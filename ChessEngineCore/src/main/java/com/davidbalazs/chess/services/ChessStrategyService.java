package com.davidbalazs.chess.services;

import com.davidbalazs.chess.daos.ChessStrategyDao;
import com.davidbalazs.chess.models.ChessStrategyModel;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessStrategyService {
    List<ChessStrategyModel> getChessStrategies();

    ChessStrategyModel getById(long id);
}
