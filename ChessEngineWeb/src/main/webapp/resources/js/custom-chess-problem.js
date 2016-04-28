var board,
    game = new Chess(),
    chessProblemMessage = $('#chess-problem-message');

// do not pick up pieces if the game is over
// only pick up pieces for the side to move
var onDragStart = function (source, piece, position, orientation) {
    if (game.game_over() === true ||
        (game.turn() === 'w' && piece.search(/^b/) !== -1) ||
        (game.turn() === 'b' && piece.search(/^w/) !== -1)) {
        return false;
    }
};

var onDrop = function (source, target) {
    if (source === 'c8' && target === 'a8') {
        chessProblemMessage.html('Check mate. Well done! <br/> <a href="chess-problem-item.html">Try another problem</a>');
        chessProblemMessage.css({'color': '#00ff1e'});
    }
    else {
        chessProblemMessage.html('Wrong move. Try again! <br/> <a href="chess-problem-item.html">Try another problem</a>');
        chessProblemMessage.css({'color': '#ff0000'});
        return 'snapback';
    }
};

// update the board position after the piece snap
// for castling, en passant, pawn promotion
var onSnapEnd = function () {
    board.position(game.fen());
};

var cfg = {
    draggable: true,
    position: '2R5/8/8/k1K5/8/8/8/8',
    onDragStart: onDragStart,
    onDrop: onDrop
};
board = ChessBoard('board', cfg);
