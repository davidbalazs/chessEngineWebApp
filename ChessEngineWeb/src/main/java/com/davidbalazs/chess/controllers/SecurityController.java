package com.davidbalazs.chess.controllers;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.MessageFormat;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
public class SecurityController {
    public static final Logger LOGGER = Logger.getLogger(ContactUsPageController.class);
    private static final String LOGOUT_LOG_MESSAGE = "Received request to logout user with name : {0}";

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String accessDeniedPage(Model model) {
        return "pages/security/accessDeniedPage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Principal principal) {
        LOGGER.info(MessageFormat.format(LOGOUT_LOG_MESSAGE, principal.getName()));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "pages/homePage";
    }
}
