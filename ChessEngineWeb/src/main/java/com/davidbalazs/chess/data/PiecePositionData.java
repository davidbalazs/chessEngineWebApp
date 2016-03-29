package com.davidbalazs.chess.data;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class PiecePositionData {
    private char x;
    private int y;

    public PiecePositionData(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public char getX() {
        return x;
    }

    public void setX(char x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
