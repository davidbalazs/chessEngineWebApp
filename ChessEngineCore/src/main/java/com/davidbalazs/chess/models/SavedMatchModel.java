package com.davidbalazs.chess.models;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class SavedMatchModel {
    private String name;
    private PlayerColor playerColor;
    private Date date;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;
    private VirtualPlayerLevel virtualPlayerLevel;
    private List<MoveEntityModel> moves;

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

    public List<MoveEntityModel> getMoves() {
        return moves;
    }

    public void setMoves(List<MoveEntityModel> moves) {
        this.moves = moves;
    }
}
