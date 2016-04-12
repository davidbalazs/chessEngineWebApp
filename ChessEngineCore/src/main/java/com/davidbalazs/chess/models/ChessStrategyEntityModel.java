package com.davidbalazs.chess.models;

import javax.persistence.*;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Entity
@Table(name = "CHESS_STRATEGY_ENTITY")
public class ChessStrategyEntityModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private MoveEntityModel moveEntity;

    @Column(name = "DESCRIPTION")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
