package com.davidbalazs.chess.daos.impl;

import com.davidbalazs.chess.daos.QuoteOfTheDayDao;
import com.davidbalazs.chess.models.QuoteOfTheDayModel;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultQuoteOfTheDayDao extends DefaultGenericDao<QuoteOfTheDayModel> implements QuoteOfTheDayDao {
    @Override
    public QuoteOfTheDayModel getQuoteOfTheDay() {
        Class<QuoteOfTheDayModel> type = QuoteOfTheDayModel.class;
        Query query = entityManager.createQuery("SELECT e FROM " + type.getSimpleName() + " e");
        List<QuoteOfTheDayModel> objects = new ArrayList<>();
        objects.addAll(query.getResultList());
        return objects.get(0);
    }
}
