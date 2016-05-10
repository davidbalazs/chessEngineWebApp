package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.ChessStrategyModel;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface ChessStrategyService {
    @Transactional
    long create(ChessStrategyModel chessStrategyModel);

    @Transactional
    List<ChessStrategyModel> getChessStrategies();

    ChessStrategyModel getById(long id);
}
