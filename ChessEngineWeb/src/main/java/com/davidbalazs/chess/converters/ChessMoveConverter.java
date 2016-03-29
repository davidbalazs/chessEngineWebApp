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
    private static final char[] fieldLocationLetter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public ChessMoveData convert(int move) {
        PiecePositionData initialPositionData = getPiecePositionData(moveService.getInitialPosition(move));
        PiecePositionData finalPositionData = getPiecePositionData(moveService.getFinalPosition(move));

        return new ChessMoveData(initialPositionData, finalPositionData);
    }

    private PiecePositionData getPiecePositionData(PiecePosition piecePositionModel) {
        return new PiecePositionData(fieldLocationLetter[piecePositionModel.getX()], piecePositionModel.getY()+1);
    }
    @Required
    public void setMoveService(MoveService moveService) {
        this.moveService = moveService;
    }
}
