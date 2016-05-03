package com.davidbalazs.chess.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
public class SecurityController {

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String accessDeniedPage(Model model) {
        return "pages/security/accessDeniedPage";
    }
}
