package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.controllers.enhancers.MainPageEnhancer;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
public class MainPageController {
    public static final Logger LOGGER = Logger.getLogger(MainPageController.class);

    @Resource(name = "mainPageEnhancer")
    private MainPageEnhancer mainPageEnhancer;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loadHomePage(Model model) {
        mainPageEnhancer.enhanceModelWithSideBar(model);
        return "pages/homePage";
    }
}
