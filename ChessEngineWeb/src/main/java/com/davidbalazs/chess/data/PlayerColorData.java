package com.davidbalazs.chess.data;

/**
 * @author: david.balazs@iquestgroup.com
 */
public enum PlayerColorData {
    WHITE("White"),
    BLACK("Black");

    private String name;

    PlayerColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
