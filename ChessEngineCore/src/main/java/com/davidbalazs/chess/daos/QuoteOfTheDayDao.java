package com.davidbalazs.chess.daos;

import com.davidbalazs.chess.models.QuoteModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface QuoteOfTheDayDao  extends GenericDao<QuoteModel> {
    QuoteModel getQuoteOfTheDay();
}
