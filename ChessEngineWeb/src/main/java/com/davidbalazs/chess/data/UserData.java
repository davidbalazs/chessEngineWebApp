package com.davidbalazs.chess.data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class UserData {

    @NotEmpty(message = "Please enter a username.")
    @Size(min = 2, max = 30, message = "Username length must be between 2 and 30 characters.")
    private String username;

    @NotEmpty(message = "Please enter a password.")
    private String password;

    @NotEmpty(message = "Please re-enter the password.")
    private String reTypedPassword;

    @Size(max = 30, message = "First name length must be no longer than 30 characters.")
    private String firstName;

    @Size(max = 30, message = "Last name length must be no longer than 30 characters.")
    private String lastName;

    @NotEmpty(message = "Please enter your email.")
    @Email(message = "Please enter a valid email.")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReTypedPassword() {
        return reTypedPassword;
    }

    public void setReTypedPassword(String reTypedPassword) {
        this.reTypedPassword = reTypedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
