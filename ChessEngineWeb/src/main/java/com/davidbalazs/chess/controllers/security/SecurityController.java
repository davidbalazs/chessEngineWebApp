package com.davidbalazs.chess.controllers.security;

import com.davidbalazs.chess.enhancers.UserEnhancer;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.MessageFormat;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
public class SecurityController {
    public static final Logger LOGGER = Logger.getLogger(SecurityController.class);
    private static final String LOGOUT_LOG_MESSAGE = "Received request to logout user with name : {0}";
    private static final String LOGOUT_FAILURE_LOG_MESSAGE = "Trying to logout but there is no authenticated user. [Principal is null]";

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public String accessDeniedPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        return "pages/security/accessDeniedPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        LOGGER.info("Retrieving login form");
        return "pages/security/loginPage";
    }

    @RequestMapping(value = "/login-failure", method = RequestMethod.GET)
    public String loginFail(RedirectAttributes redirectAttrs) {
        LOGGER.warn("Login failure occured");
        redirectAttrs.addFlashAttribute("message", "Login failed. Provide correct credentials.");
        return "redirect:login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Principal principal, RedirectAttributes redirectAttrs) {
        if (principal != null) {
            LOGGER.info(MessageFormat.format(LOGOUT_LOG_MESSAGE, principal.getName()));
        } else {
            LOGGER.info(LOGOUT_FAILURE_LOG_MESSAGE);
            //TODO: return an error page.
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        redirectAttrs.addFlashAttribute("message", "Logout success!");
        return "redirect:login";
    }
}
