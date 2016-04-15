package com.davidbalazs.chess.models;

import javax.persistence.*;

@Entity
@Table(name = "CHESS_STRATEGY_MOVE_PAIR")
public class ChessStrategyMovePairModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ChessStrategyMoveModel whiteMove;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ChessStrategyMoveModel blackMove;

    public ChessStrategyMoveModel getWhiteMove() {
        return whiteMove;
    }

    public void setWhiteMove(ChessStrategyMoveModel whiteMove) {
        this.whiteMove = whiteMove;
    }

    public ChessStrategyMoveModel getBlackMove() {
        return blackMove;
    }

    public void setBlackMove(ChessStrategyMoveModel blackMove) {
        this.blackMove = blackMove;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
