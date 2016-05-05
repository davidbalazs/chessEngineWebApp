package com.davidbalazs.chess.facades.impl;

import com.davidbalazs.chess.algorithms.MoveAlgorithm;
import com.davidbalazs.chess.converters.ChessMoveConverter;
import com.davidbalazs.chess.converters.ChessPositionConverter;
import com.davidbalazs.chess.data.ChessMoveData;
import com.davidbalazs.chess.data.PlayerColorData;
import com.davidbalazs.chess.data.VirtualPlayerLevelData;
import com.davidbalazs.chess.facades.ChessMoveFacade;
import com.davidbalazs.chess.model.ChessPosition;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultChessMoveFacade implements ChessMoveFacade {
    private ChessPositionConverter chessPositionConverter;
    private MoveAlgorithm moveAlgorithm;
    private ChessMoveConverter chessMoveConverter;

    public ChessMoveData getNextMove(String chessPositionFen, PlayerColorData sideToMove, VirtualPlayerLevelData virtualPlayerLevel) {
        ChessPosition chessPosition = chessPositionConverter.convert(chessPositionFen);

        int move;

        if (PlayerColorData.WHITE.equals(sideToMove)) {
            move = moveAlgorithm.getNextWhiteMove(chessPosition, virtualPlayerLevel.getValue());
        } else {
            move = moveAlgorithm.getNextBlackMove(chessPosition, virtualPlayerLevel.getValue());
        }

        return chessMoveConverter.convert(move);
    }

    @Required
    public void setChessPositionConverter(ChessPositionConverter chessPositionConverter) {
        this.chessPositionConverter = chessPositionConverter;
    }

    @Required
    public void setChessMoveConverter(ChessMoveConverter chessMoveConverter) {
        this.chessMoveConverter = chessMoveConverter;
    }

    @Required
    public void setMoveAlgorithm(MoveAlgorithm moveAlgorithm) {
        this.moveAlgorithm = moveAlgorithm;
    }
}
