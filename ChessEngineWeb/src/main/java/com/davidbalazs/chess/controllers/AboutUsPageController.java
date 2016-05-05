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
@RequestMapping(value = "about-us/")
public class AboutUsPageController {
    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "sideBarEnhancer")
    private SideBarEnhancer sideBarEnhancer;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);

        return "pages/aboutUsPage";
    }
}
