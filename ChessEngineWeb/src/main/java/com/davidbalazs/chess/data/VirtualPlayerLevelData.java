package com.davidbalazs.chess.data;

/**
 * @author: david.balazs@iquestgroup.com
 */
public enum VirtualPlayerLevelData {
    LEVEL_1("Level 1", 1),
    LEVEL_2("Level 2", 2),
    LEVEL_3("Level 3", 3),
    LEVEL_4("Level 4", 4);

    String name;
    int value;

    VirtualPlayerLevelData(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
