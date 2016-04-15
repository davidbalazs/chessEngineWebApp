package com.davidbalazs.chess.models;

import javax.persistence.*;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Entity
@Table(name = "CHESS_STRATEGY_MOVE")
public class ChessStrategyMoveModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ChessMoveModel move;

    @Column(name = "DESCRIPTION")
    private String description;

    public ChessMoveModel getMove() {
        return move;
    }

    public void setMove(ChessMoveModel move) {
        this.move = move;
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
