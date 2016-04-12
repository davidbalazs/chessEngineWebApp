package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.controllers.enhancers.MainPageEnhancer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "error/")
public class ErrorController {

    @Resource(name = "mainPageEnhancer")
    private MainPageEnhancer mainPageEnhancer;

    @RequestMapping(value = "notFound", method = RequestMethod.GET)
    public String notFound(Model model) {
        mainPageEnhancer.enhanceModelWithSideBar(model);

        return "pages/notFoundPage";
    }

    @RequestMapping(value = "internalError", method = RequestMethod.GET)
    public String internalError(Model model) {
        mainPageEnhancer.enhanceModelWithSideBar(model);

        return "pages/internalErrorPage";
    }
}
