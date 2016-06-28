<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/pageTemplates" %>
<template:chessProblemPageTemplate pageTitle="Chess problem">
    <c:choose>
        <c:when test="${empty chessProblem}">
            <p>The chess problem you have requested is unavailable.</p>
        </c:when>
        <c:otherwise>
            <p id="chess-problem-message">${chessProblem.description}<br/><br/></p>
            <script src="<c:url value="/resources/js/chess.js"/>"></script>
            <div id="board" style="width:650px;" class="play-chess-table"></div>
            <script>
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
                    if (source === '${chessProblem.solutionMoveFrom}' && target === '${chessProblem.solutionMoveTo}') {
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
                    position: '${chessProblem.initialPositionFen}',
                    onDragStart: onDragStart,
                    onDrop: onDrop
                };
                board = ChessBoard('board', cfg);

            </script>

        </c:otherwise>
    </c:choose>
</template:chessProblemPageTemplate>


<div id="board" style="width:650px;"></div>

