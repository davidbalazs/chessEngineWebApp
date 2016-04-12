package com.davidbalazs.chess.daos.impl;

import com.davidbalazs.chess.daos.ChessProblemDao;
import com.davidbalazs.chess.models.ChessProblemModel;

import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultChessProblemDao extends DefaultGenericDao<ChessProblemModel> implements ChessProblemDao {

    private static final String SELECT_PROBLEM_OF_THE_DAY_QUERY = "SELECT P FROM {0} P WHERE P.isProblemOfTheDay = true";

    @Override
    public ChessProblemModel getProblemOfTheDay() {
        Class<ChessProblemModel> type = ChessProblemModel.class;
        Query query = entityManager.createQuery(MessageFormat.format(SELECT_PROBLEM_OF_THE_DAY_QUERY, type.getSimpleName()));
        List<ChessProblemModel> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
