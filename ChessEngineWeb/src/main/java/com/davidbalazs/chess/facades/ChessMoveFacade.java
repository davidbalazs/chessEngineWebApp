package com.davidbalazs.chess.facades;

import com.davidbalazs.chess.data.ChessMoveData;
import com.davidbalazs.chess.data.PlayerColorData;
import com.davidbalazs.chess.data.VirtualPlayerLevelData;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessMoveFacade {
    ChessMoveData getNextMove(String chessPositionFen, PlayerColorData sideToMove, VirtualPlayerLevelData virtualPlayerLevel);
}
