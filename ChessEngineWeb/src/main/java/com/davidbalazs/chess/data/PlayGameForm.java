package com.davidbalazs.chess.data;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class PlayGameForm {
    @NotEmpty(message = "Please select a virtual player level.")
    private VirtualPlayerLevelData virtualPlayerLevel;

    @NotEmpty(message = "Please select a player color.")
    private PlayerColorData playerColor;

    /**
     * Using constructor to set default values for fields.
     */
    public PlayGameForm() {
        virtualPlayerLevel = VirtualPlayerLevelData.LEVEL_1;
        playerColor = PlayerColorData.WHITE;
    }

    public VirtualPlayerLevelData getVirtualPlayerLevel() {
        return virtualPlayerLevel;
    }

    public void setVirtualPlayerLevel(VirtualPlayerLevelData virtualPlayerLevel) {
        this.virtualPlayerLevel = virtualPlayerLevel;
    }

    public PlayerColorData getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(PlayerColorData playerColor) {
        this.playerColor = playerColor;
    }
}
