package com.davidbalazs.chess.daos.impl;

import com.davidbalazs.chess.daos.QuoteOfTheDayDao;
import com.davidbalazs.chess.models.QuoteModel;

import javax.persistence.Query;
import java.text.MessageFormat;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultQuoteOfTheDayDao extends DefaultGenericDao<QuoteModel> implements QuoteOfTheDayDao {

    private static final String SELECT_QUOTE_OF_THE_DAY_QUERY = "SELECT q FROM {0} q WHERE q.isQuoteOfTheDay = true";

    @Override
    public QuoteModel getQuoteOfTheDay() {
        Class<QuoteModel> type = QuoteModel.class;
        Query query = entityManager.createQuery(MessageFormat.format(SELECT_QUOTE_OF_THE_DAY_QUERY, type.getSimpleName()));
        List<QuoteModel> resultList = query.getResultList();
        if (resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
