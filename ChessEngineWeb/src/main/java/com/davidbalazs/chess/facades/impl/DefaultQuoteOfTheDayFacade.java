package com.davidbalazs.chess.facades.impl;

import com.davidbalazs.chess.converters.QuoteConverter;
import com.davidbalazs.chess.data.QuoteData;
import com.davidbalazs.chess.facades.QuoteOfTheDayFacade;
import com.davidbalazs.chess.models.QuoteModel;
import com.davidbalazs.chess.services.QuoteOfTheDayService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class DefaultQuoteOfTheDayFacade implements QuoteOfTheDayFacade {
    private QuoteOfTheDayService quoteOfTheDayService;
    private QuoteConverter quoteConverter;

    @Override
    public List<QuoteData> getAll() {
        List<QuoteModel> quoteModelList = quoteOfTheDayService.getAll();

        return quoteConverter.convertAll(quoteModelList);
    }

    @Override
    public void add(QuoteData quoteData) {
        QuoteModel quoteModel = quoteConverter.convertReverse(quoteData);
        quoteOfTheDayService.add(quoteModel);
    }

    @Override
    public void delete(long id) {
        quoteOfTheDayService.delete(id);
    }

    @Override
    public void markAsQuoteOfTheDay(long id) {
        quoteOfTheDayService.markAsQuoteOfTheDay(id);
    }

    @Override
    public void unmarkAsQuoteOfTheDay(long id) {
        quoteOfTheDayService.unmarkAsQuoteOfTheDay(id);
    }

    @Required
    public void setQuoteOfTheDayService(QuoteOfTheDayService quoteOfTheDayService) {
        this.quoteOfTheDayService = quoteOfTheDayService;
    }

    @Required
    public void setQuoteConverter(QuoteConverter quoteConverter) {
        this.quoteConverter = quoteConverter;
    }
}
