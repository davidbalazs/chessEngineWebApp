package com.davidbalazs.chess.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Entity
@Table(name = "SAVED_MATCH")
public class SavedMatchModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PLAYER_COLOR")
    @Enumerated(EnumType.STRING)
    private PlayerColor playerColor;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column(name = "VIRTUAL_PLAYER_LEVEL")
    @Enumerated(EnumType.STRING)
    private VirtualPlayerLevel virtualPlayerLevel;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ChessMovePairModel> movePairs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public VirtualPlayerLevel getVirtualPlayerLevel() {
        return virtualPlayerLevel;
    }

    public void setVirtualPlayerLevel(VirtualPlayerLevel virtualPlayerLevel) {
        this.virtualPlayerLevel = virtualPlayerLevel;
    }

    public List<ChessMovePairModel> getMovePairs() {
        return movePairs;
    }

    public void setMovePairs(List<ChessMovePairModel> movePairs) {
        this.movePairs = movePairs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
