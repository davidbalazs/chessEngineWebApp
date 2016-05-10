package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.QuoteModel;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface QuoteOfTheDayService {
    List<QuoteModel> getAll();

    QuoteModel getQuoteOfTheDay();

    @Transactional
    void markAsQuoteOfTheDay(long id);

    @Transactional
    void unmarkAsQuoteOfTheDay(long id);

    @Transactional
    void add(QuoteModel quoteModel);

    @Transactional
    void delete(long id);
}
