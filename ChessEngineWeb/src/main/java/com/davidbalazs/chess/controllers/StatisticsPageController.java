package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.enhancers.SideBarEnhancer;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "/statistics")
public class StatisticsPageController {

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "sideBarEnhancer")
    private SideBarEnhancer sideBarEnhancer;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);

        return "pages/statisticsPage";
    }
}
