function move(fenPosition) {
	board.position(fenPosition);
}

var board = ChessBoard('board');



var board,
  game = new Chess();

var cfg = {
  draggable: false,
  position: 'start'
};
board = ChessBoard('board', cfg);

updateStatus();