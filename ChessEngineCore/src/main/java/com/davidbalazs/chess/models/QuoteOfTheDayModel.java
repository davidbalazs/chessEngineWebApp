package com.davidbalazs.chess.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by David on 4/5/2016.
 */
@Entity
@Table(name = "QUOTE_OF_THE_DAY")
public class QuoteOfTheDayModel {
    @Column(name = "QUOTE")
    private String quote;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "IS_ENABLED")
    private boolean isEnabled;

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
}
