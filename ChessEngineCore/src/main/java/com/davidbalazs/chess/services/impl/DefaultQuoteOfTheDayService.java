package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.QuoteOfTheDayDao;
import com.davidbalazs.chess.models.QuoteOfTheDayModel;
import com.davidbalazs.chess.services.QuoteOfTheDayService;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultQuoteOfTheDayService implements QuoteOfTheDayService {
    private QuoteOfTheDayDao quoteOfTheDayDao;
    @Override
    public QuoteOfTheDayModel getQuoteOfTheDay() {
        return quoteOfTheDayDao.getQuoteOfTheDay();
    }

    @Required
    public void setQuoteOfTheDayDao(QuoteOfTheDayDao quoteOfTheDayDao) {
        this.quoteOfTheDayDao = quoteOfTheDayDao;
    }
}
