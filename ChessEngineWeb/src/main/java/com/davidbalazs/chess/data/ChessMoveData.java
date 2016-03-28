package com.davidbalazs.chess.data;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ChessMoveData {
    private PiecePositionData initialPosition;
    private PiecePositionData finalPosition;

    public ChessMoveData(PiecePositionData initialPosition, PiecePositionData finalPosition) {
        this.initialPosition = initialPosition;
        this.finalPosition = finalPosition;
    }

    public PiecePositionData getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(PiecePositionData initialPosition) {
        this.initialPosition = initialPosition;
    }

    public PiecePositionData getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(PiecePositionData finalPosition) {
        this.finalPosition = finalPosition;
    }
}
