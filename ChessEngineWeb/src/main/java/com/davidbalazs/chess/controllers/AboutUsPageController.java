package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.controllers.enhancers.MainPageEnhancer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "about-us/")
public class AboutUsPageController {
    @Resource(name = "mainPageEnhancer")
    private MainPageEnhancer mainPageEnhancer;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getPage(Model model) {
        mainPageEnhancer.enhanceModelWithSideBar(model);

        return "pages/aboutUsPage";
    }
}
