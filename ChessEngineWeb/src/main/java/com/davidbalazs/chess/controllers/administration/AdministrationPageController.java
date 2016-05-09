package com.davidbalazs.chess.controllers.administration;

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
public class AdministrationPageController {
    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @RequestMapping(value = "/administration/", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        return "pages/administration/mainAdministrationPage";
    }
}
