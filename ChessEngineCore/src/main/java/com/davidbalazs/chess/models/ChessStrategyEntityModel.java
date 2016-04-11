package com.davidbalazs.chess.models;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class ChessStrategyEntityModel {
    private MoveEntityModel moveEntity;
    private String description;

    public MoveEntityModel getMoveEntity() {
        return moveEntity;
    }

    public void setMoveEntity(MoveEntityModel moveEntity) {
        this.moveEntity = moveEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
