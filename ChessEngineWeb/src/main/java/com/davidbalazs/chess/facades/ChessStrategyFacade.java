package com.davidbalazs.chess.facades;

import com.davidbalazs.chess.data.ChessStrategyDetailsData;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessStrategyFacade {
    long createUsingStrategyDetails(ChessStrategyDetailsData chessStrategyDetailsData);
}
