package com.davidbalazs.chess.services.impl;

import com.davidbalazs.chess.daos.QuoteOfTheDayDao;
import com.davidbalazs.chess.models.QuoteModel;
import com.davidbalazs.chess.services.QuoteOfTheDayService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultQuoteOfTheDayService implements QuoteOfTheDayService {
    private QuoteOfTheDayDao quoteOfTheDayDao;

    @Override
    public List<QuoteModel> getAll() {
        return quoteOfTheDayDao.getAll();
    }

    @Override
    public QuoteModel getQuoteOfTheDay() {
        return quoteOfTheDayDao.getQuoteOfTheDay();
    }

    @Override
    public void markAsQuoteOfTheDay(long id) {
        unmarkCurrentQuoteOfTheDay();
        QuoteModel newQuoteOfTheDay = quoteOfTheDayDao.getById(id);
        newQuoteOfTheDay.setQuoteOfTheDay(true);
        quoteOfTheDayDao.update(newQuoteOfTheDay);
    }

    @Override
    public void unmarkAsQuoteOfTheDay(long id) {
        unmarkCurrentQuoteOfTheDay();
    }

    @Override
    public void add(QuoteModel quoteModel) {
        quoteOfTheDayDao.create(quoteModel);
    }

    @Override
    public void delete(long id) {
        quoteOfTheDayDao.delete(id);
    }

    private void unmarkCurrentQuoteOfTheDay() {
        QuoteModel currentQuoteOfTheDay = quoteOfTheDayDao.getQuoteOfTheDay();
        if (currentQuoteOfTheDay != null) {
            currentQuoteOfTheDay.setQuoteOfTheDay(false);
            quoteOfTheDayDao.update(currentQuoteOfTheDay);
        }
    }

    @Required
    public void setQuoteOfTheDayDao(QuoteOfTheDayDao quoteOfTheDayDao) {
        this.quoteOfTheDayDao = quoteOfTheDayDao;
    }
}
