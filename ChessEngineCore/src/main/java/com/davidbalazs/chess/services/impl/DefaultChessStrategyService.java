package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.ChessStrategyDao;
import com.davidbalazs.chess.models.*;
import com.davidbalazs.chess.services.ChessStrategyService;
import org.springframework.beans.factory.annotation.Required;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultChessStrategyService implements ChessStrategyService {
    private ChessStrategyDao chessStrategyDao;

    @Override
    @Transactional
    public List<ChessStrategyModel> getChessStrategies() {
        return chessStrategyDao.getAll();
    }

    @Override
    public ChessStrategyModel getById(long id) {
        return chessStrategyDao.getById(id);
    }

    @Required
    public void setChessStrategyDao(ChessStrategyDao chessStrategyDao) {
        this.chessStrategyDao = chessStrategyDao;
    }
}
