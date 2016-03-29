package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.model.PiecePosition;
import com.davidbalazs.chess.service.MoveService;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ChessMoveConverter {
    private MoveService moveService;
    private static final char[] fieldLocationLetter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public String convert(int move) {
        PiecePosition initialPosition = moveService.getInitialPosition(move);
        PiecePosition finalPosition = moveService.getFinalPosition(move);
        System.out.println("initial position: " + initialPosition + " final position: " + finalPosition);
        return "" + fieldLocationLetter[initialPosition.getX()] + (initialPosition.getY() + 1) + "-" + fieldLocationLetter[finalPosition.getX()] + (finalPosition.getY()+1);
    }

    @Required
    public void setMoveService(MoveService moveService) {
        this.moveService = moveService;
    }
}
