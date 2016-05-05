var counter = 0;
var board,
    game = new Chess();

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
    // see if the move is legal
    var move = game.move({
        from: source,
        to: target,
        promotion: 'q' // NOTE: always promote to a queen for example simplicity
    });

    // illegal move
    if (move === null) return 'snapback';

    updateStatus();
};


// update the board position after the piece snap
// for castling, en passant, pawn promotion
var onSnapEnd = function () {
    board.position(game.fen());
    makeAjaxCallForNextMove();
};

function makeAjaxCallForNextMove() {
    $.ajax({
        url: "/playgame/next-move?chessPositionFen=" + board.fen() + "&sideToMove=" + virtualPlayerColor + "&virtualPlayerLevel=" + virtualPlayerLevel,
        type: "GET",
        success: function (move) {
            var moveStatusObject = game.move({
                from: move.initialPosition.x + move.initialPosition.y,
                to: move.finalPosition.x + move.finalPosition.y,
                promotion: 'q' // NOTE: always promote to a queen for example simplicity
            });

            if (moveStatusObject === null) {
                $("#status").html("virtual player made a wrong move: from " + move.initialPosition.x + move.initialPosition.y + "to " + move.finalPosition.x + move.finalPosition.y);
            } else {
                board.position(game.fen());
                counter++;
                $("#message").html(counter);
                updateStatus();
            }
        }
    });
};

var updateStatus = function () {
    var status = '';

    var moveColor = 'White';
    if (game.turn() === 'b') {
        moveColor = 'Black';
    }

    // checkmate?
    if (game.in_checkmate() === true) {
        status = 'Game over, ' + moveColor + ' is in checkmate.';
    }

    // draw?
    else if (game.in_draw() === true) {
        status = 'Game over, drawn position';
    }

    // game still on
    else {
        status = moveColor + ' to move';

        // check?
        if (game.in_check() === true) {
            status += ', ' + moveColor + ' is in check';
        }
    }

    $("#status").html(status);
};

var cfg = {
    orientation: tableOrientation,
    draggable: true,
    position: 'start',
    onDragStart: onDragStart,
    onDrop: onDrop,
    onSnapEnd: onSnapEnd
};
board = ChessBoard('board', cfg);

if (virtualPlayerColor === "WHITE") {
    makeAjaxCallForNextMove();
}

updateStatus();
