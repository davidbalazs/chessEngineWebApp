package com.davidbalazs.chess.models;

import javax.persistence.*;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Entity
@Table(name = "CHESS_MOVE_PAIR")
public class ChessMovePairModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ChessMoveModel whiteMove;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ChessMoveModel blackMove;

    public ChessMoveModel getWhiteMove() {
        return whiteMove;
    }

    public void setWhiteMove(ChessMoveModel whiteMove) {
        this.whiteMove = whiteMove;
    }

    public ChessMoveModel getBlackMove() {
        return blackMove;
    }

    public void setBlackMove(ChessMoveModel blackMove) {
        this.blackMove = blackMove;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
