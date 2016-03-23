package com.davidbalazs.chess.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "test/")
public class FirstController {
    public static final Logger LOG = Logger.getLogger(FirstController.class);

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String initAddMarkForm(Model model) {
        LOG.debug("Hello from controller");
        model.addAttribute("name", "Cata");
        return "firstJsp";
    }
}
