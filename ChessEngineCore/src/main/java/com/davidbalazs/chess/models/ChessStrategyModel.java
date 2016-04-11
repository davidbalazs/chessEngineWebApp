package com.davidbalazs.chess.models;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ChessStrategyModel {
    private String name;
    private ChessStrategyCategory category;
    private List<ChessStrategyEntityModel> moves;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChessStrategyCategory getCategory() {
        return category;
    }

    public void setCategory(ChessStrategyCategory category) {
        this.category = category;
    }

    public List<ChessStrategyEntityModel> getMoves() {
        return moves;
    }

    public void setMoves(List<ChessStrategyEntityModel> moves) {
        this.moves = moves;
    }
}
