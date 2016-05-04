package com.davidbalazs.chess.validators;

import com.davidbalazs.chess.data.UserData;
import com.davidbalazs.chess.services.UserService;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class AdditionalUserValidator {
    private UserService userService;

    public List<String> validate(UserData userData) {
        List<String> errorMessages = new ArrayList<String>();

        if (!userData.getPassword().equals(userData.getReTypedPassword())) {
            errorMessages.add("Password doesn't match with the retyped one.");
        }

        if (userService.getByUsername(userData.getUsername()) != null) {
            errorMessages.add("There is already a registered user with this username!");
        }

        return errorMessages;
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
