package com.davidbalazs.chess.enhancers;

import com.davidbalazs.chess.helpers.UserHelper;
import com.davidbalazs.chess.models.UserModel;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

import java.security.Principal;

/**
 * @author: david.balazs@iquestgroup.com
 */
public class UserEnhancer {
    private UserHelper userHelper;

    public void enhanceModelWithLoggedInUser(Model model, Principal principal) {
        UserModel loggedInUser = userHelper.getLoggedInUser(principal);

        if (loggedInUser != null) {
            model.addAttribute("loggedInUser", loggedInUser);
            model.addAttribute("isUserLoggedIn", true);
            model.addAttribute("loggedInUserRole", loggedInUser.getRole());
        }
    }

    @Required
    public void setUserHelper(UserHelper userHelper) {
        this.userHelper = userHelper;
    }
}
