package com.davidbalazs.chess.helpers;

import com.davidbalazs.chess.models.UserModel;
import com.davidbalazs.chess.services.UserService;
import org.springframework.beans.factory.annotation.Required;

import java.security.Principal;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class UserHelper {
    private UserService userService;

    public UserModel getLoggedInUser(Principal principal) {
        if (principal != null) {
            String loggedInUsername = principal.getName();
            return userService.getByUsername(loggedInUsername);
        }

        return null;
    }

    @Required
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
