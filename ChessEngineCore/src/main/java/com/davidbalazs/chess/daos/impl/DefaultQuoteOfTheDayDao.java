package com.davidbalazs.chess.daos.impl;

import com.davidbalazs.chess.daos.QuoteOfTheDayDao;
import com.davidbalazs.chess.models.QuoteOfTheDayModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultQuoteOfTheDayDao extends DefaultGenericDao<QuoteOfTheDayModel> implements QuoteOfTheDayDao {
    @Override
    public QuoteOfTheDayModel getQuoteOfTheDay() {
        return null;
    }
}
