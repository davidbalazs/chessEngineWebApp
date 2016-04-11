package com.davidbalazs.chess.daos;

import com.davidbalazs.chess.models.QuoteOfTheDayModel;

/**
 * @author: david.balazs@iquestgroup.com
 */
public interface QuoteOfTheDayDao  extends GenericDao<QuoteOfTheDayModel> {
    QuoteOfTheDayModel getQuoteOfTheDay();
}
