package com.davidbalazs.chess.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "administration")
public class AdministrationPageController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getPage(Model model) {
        return "pages/administration/mainAdministrationPage";
    }
}
