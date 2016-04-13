package com.davidbalazs.chess.data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by David on 4/13/2016.
 */
public class ContactUsForm {
    @NotEmpty(message = "Please enter your email.")
    @Email(message = "Please enter a valid email.")
    private String email;

    @NotEmpty(message = "Please enter your name.")
    @Size(min = 2, max = 30, message = "Name length must be between 2 and 30 characters.")
    private String username;

    @NotEmpty(message = "Please enter your message.")
    @Size(min = 2, max = 800, message = "Message length must be between 2 and 800 characters.")
    private String message;

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
}
