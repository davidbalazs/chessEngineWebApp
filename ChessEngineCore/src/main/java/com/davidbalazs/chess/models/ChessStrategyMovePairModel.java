package com.davidbalazs.chess.models;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;

@Entity
@Table(name = "CHESS_STRATEGY_MOVE_PAIR")
public class ChessStrategyMovePairModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "join_table_strategy_white_move")
    @IndexColumn(base = 1, name = "dnr")
    private ChessStrategyMoveModel whiteMove;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "join_table_strategy_black_move")
    @IndexColumn(base = 1, name = "pmnr")
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
