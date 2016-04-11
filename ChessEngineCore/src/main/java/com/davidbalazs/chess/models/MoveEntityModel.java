package com.davidbalazs.chess.models;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class MoveEntityModel {
    private String fenPosition;
    private String moveThatWasMade;

    public String getFenPosition() {
        return fenPosition;
    }

    public void setFenPosition(String fenPosition) {
        this.fenPosition = fenPosition;
    }

    public String getMoveThatWasMade() {
        return moveThatWasMade;
    }

    public void setMoveThatWasMade(String moveThatWasMade) {
        this.moveThatWasMade = moveThatWasMade;
    }
}
