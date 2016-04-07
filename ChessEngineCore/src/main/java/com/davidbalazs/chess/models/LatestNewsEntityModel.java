package com.davidbalazs.chess.models;

import java.util.Date;

/**
 * Created by David on 4/5/2016.
 */
public class LatestNewsEntityModel {
    private long id;
    private String title;
    private String text;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
