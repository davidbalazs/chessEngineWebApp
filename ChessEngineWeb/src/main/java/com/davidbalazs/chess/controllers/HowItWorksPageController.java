package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.controllers.enhancers.MainPageEnhancer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "how-it-works/")
public class HowItWorksPageController {

    @Resource(name = "mainPageEnhancer")
    private MainPageEnhancer mainPageEnhancer;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadPage(Model model) {
        mainPageEnhancer.enhanceModelWithSideBar(model);

        return "pages/howItWorks";
    }
}
