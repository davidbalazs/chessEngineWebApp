package com.davidbalazs.chess.converters;

import com.davidbalazs.chess.data.QuoteData;
import com.davidbalazs.chess.models.QuoteModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class QuoteConverter {
    public QuoteData convert(QuoteModel quoteModel) {
        QuoteData quoteData = new QuoteData();
        quoteData.setId(quoteModel.getId());
        quoteData.setQuote(quoteModel.getQuote());
        quoteData.setAuthor(quoteModel.getAuthor());
        quoteData.setIsQuoteOfTheDay(quoteModel.isQuoteOfTheDay());

        return quoteData;
    }

    public List<QuoteData> convertAll(List<QuoteModel> quoteModelList) {
        List<QuoteData> quoteDataList = new ArrayList<>();

        for (QuoteModel quoteModel : quoteModelList) {
            QuoteData quoteData = convert(quoteModel);
            quoteDataList.add(quoteData);
        }

        return quoteDataList;
    }

    public QuoteModel convertReverse(QuoteData quoteData) {
        QuoteModel quoteModel = new QuoteModel();
        quoteModel.setId(quoteData.getId());
        quoteModel.setQuote(quoteData.getQuote());
        quoteModel.setAuthor(quoteData.getAuthor());
        quoteModel.setQuoteOfTheDay(quoteData.isQuoteOfTheDay());

        return quoteModel;
    }
}
