package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.ChessProblemDao;
import com.davidbalazs.chess.models.ChessProblemModel;
import com.davidbalazs.chess.services.ChessProblemService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultChessProblemService implements ChessProblemService {
    private ChessProblemDao chessProblemDao;

    @Override
    public List<ChessProblemModel> getAll() {
        return chessProblemDao.getAll();
    }

    @Override
    public ChessProblemModel getProblemOfTheDay() {
        return chessProblemDao.getProblemOfTheDay();
    }

    @Required
    public void setChessProblemDao(ChessProblemDao chessProblemDao) {
        this.chessProblemDao = chessProblemDao;
    }
}
