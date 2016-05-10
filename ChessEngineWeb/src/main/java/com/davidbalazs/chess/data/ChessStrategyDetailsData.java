package com.davidbalazs.chess.data;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ChessStrategyDetailsData {
    private String name;
    private ChessStrategyCategoryData category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChessStrategyCategoryData getCategory() {
        return category;
    }

    public void setCategory(ChessStrategyCategoryData category) {
        this.category = category;
    }
}
