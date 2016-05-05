package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.enhancers.SideBarEnhancer;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
@RequestMapping(value = "error/")
public class ErrorController {

    @Resource(name = "sideBarEnhancer")
    private SideBarEnhancer sideBarEnhancer;

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @RequestMapping(value = "notFound", method = RequestMethod.GET)
    public String notFound(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);

        return "pages/notFoundPage";
    }

    @RequestMapping(value = "internalError", method = RequestMethod.GET)
    public String internalError(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);

        return "pages/internalErrorPage";
    }

    @RequestMapping(value = "access-denied", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);

        return "pages/security/accessDeniedPage";
    }
}
