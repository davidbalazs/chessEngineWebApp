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

    @Override
    public void markAsProblemOfTheDay(long id) {
        unmarkCurrentProblemOfTheDay();
        ChessProblemModel newProblemOfTheDay = chessProblemDao.getById(id);
        newProblemOfTheDay.setIsProblemOfTheDay(true);
        chessProblemDao.update(newProblemOfTheDay);
    }

    @Override
    public void unmarkAsProblemOfTheDay(long id) {
        ChessProblemModel newProblemOfTheDay = chessProblemDao.getById(id);
        newProblemOfTheDay.setIsProblemOfTheDay(false);
        chessProblemDao.update(newProblemOfTheDay);
    }

    @Override
    public ChessProblemModel getById(long id) {
        return chessProblemDao.getById(id);
    }

    @Override
    public void delete(long id) {
        chessProblemDao.delete(id);
    }

    private void unmarkCurrentProblemOfTheDay() {
        ChessProblemModel currentProblemOfTheDay = chessProblemDao.getProblemOfTheDay();
        currentProblemOfTheDay.setIsProblemOfTheDay(false);
        chessProblemDao.update(currentProblemOfTheDay);
    }

    @Required
    public void setChessProblemDao(ChessProblemDao chessProblemDao) {
        this.chessProblemDao = chessProblemDao;
    }
}
