package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "register-form", method = RequestMethod.GET)
    public String loadPage(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "pages/registerUserPage";
    }
}
