package com.davidbalazs.chess.models;

import org.hibernate.annotations.IndexColumn;

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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "join_table_chess_game_white_move")
    @IndexColumn(base = 1, name = "dnr")
    private ChessMoveModel whiteMove;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "join_table_chess_game_black_move")
    @IndexColumn(base = 1, name = "pmnr")
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
