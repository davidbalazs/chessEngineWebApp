package com.davidbalazs.chess.models;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Entity
@Table(name = "MESSAGE")
public class MessageModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "IS_READ")
    private boolean isRead;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
