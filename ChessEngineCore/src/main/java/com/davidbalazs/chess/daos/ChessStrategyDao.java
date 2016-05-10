package com.davidbalazs.chess.daos;

import com.davidbalazs.chess.models.ChessStrategyModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessStrategyDao extends GenericDao<ChessStrategyModel> {

    long createAndGetId(ChessStrategyModel chessStrategyModel);
}
