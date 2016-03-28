package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.data.ChessMoveData;
import com.davidbalazs.chess.data.PiecePositionData;
import com.davidbalazs.chess.model.PiecePosition;
import com.davidbalazs.chess.service.MoveService;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ChessMoveConverter {
    private MoveService moveService;

    public ChessMoveData convert(int move) {
        PiecePositionData initialPositionData = getPiecePositionData(moveService.getInitialPosition(move));
        PiecePositionData finalPositionData = getPiecePositionData(moveService.getFinalPosition(move));

        return new ChessMoveData(initialPositionData, finalPositionData);
    }

    private PiecePositionData getPiecePositionData(PiecePosition piecePositionModel) {
        return new PiecePositionData(piecePositionModel.getX(), piecePositionModel.getY());
    }

    @Required
    public void setMoveService(MoveService moveService) {
        this.moveService = moveService;
    }
}
