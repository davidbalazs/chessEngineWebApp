package com.davidbalazs.chess.models;

import java.util.Date;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class MessageModel {
    private String email;
    private String username;
    private String message;
    private Date date;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
