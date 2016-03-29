package com.davidbalazs.chess.facades;

import com.davidbalazs.chess.data.ChessMoveData;
import com.davidbalazs.chess.data.PlayerColorData;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessMoveFacade {
    String getNextMove(String chessPositionFen, PlayerColorData sideToMove, int virtualPlayerLevel);
}
