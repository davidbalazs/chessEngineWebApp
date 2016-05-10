package com.davidbalazs.chess.facades;

import com.davidbalazs.chess.data.QuoteData;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface QuoteOfTheDayFacade {
    List<QuoteData> getAll();

    void add(QuoteData quote);

    void delete(long id);

    void markAsQuoteOfTheDay(long id);

    void unmarkAsQuoteOfTheDay(long id);
}
