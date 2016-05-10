package com.davidbalazs.chess.data;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class QuoteData {
    private long id;
    private String quote;
    private String author;
    private boolean isQuoteOfTheDay;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isQuoteOfTheDay() {
        return isQuoteOfTheDay;
    }

    public void setIsQuoteOfTheDay(boolean isQuoteOfTheDay) {
        this.isQuoteOfTheDay = isQuoteOfTheDay;
    }
}
