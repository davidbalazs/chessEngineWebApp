package com.davidbalazs.chess.data;

/**
 * @author: david.balazs@iquestgroup.com
 */
public enum VirtualPlayerLevelData {
    LEVEL_1("Level 1"),
    LEVEL_2("Level 2"),
    LEVEL_3("Level 3"),
    LEVEL_4("Level 4");

    String name;

    VirtualPlayerLevelData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
