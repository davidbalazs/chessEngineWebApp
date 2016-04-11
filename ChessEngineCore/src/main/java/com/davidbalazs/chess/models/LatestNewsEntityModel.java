package com.davidbalazs.chess.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by David on 4/5/2016.
 */
@Entity
@Table(name = "LATEST_NEWS")
public class LatestNewsEntityModel {
    @Id
    @Column(name="ID")
    @GeneratedValue
    private long id;

    @Column(name="TITLE")
    private String title;

    @Column(name="TEXT")
    private String text;

    @Column(name="DATE")
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
