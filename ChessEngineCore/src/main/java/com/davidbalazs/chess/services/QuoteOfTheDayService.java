package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.QuoteModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface QuoteOfTheDayService {
    QuoteModel getQuoteOfTheDay();
}
