package com.davidbalazs.chess.controllers.administration;

import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.models.UserState;
import com.davidbalazs.chess.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.security.Principal;
import java.text.MessageFormat;

/**
 * @author: david.balazs@iquestgroup.com
 */
@Controller
@RequestMapping(value = "administration/users/")
public class AdministrationUsersController {
    public static final Logger LOGGER = Logger.getLogger(AdministrationUsersController.class);
    private static final String DELETE_USER_LOG_MESSAGE = "Received requiest to delete user with username {0}.";

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "show-all", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        LOGGER.info("Displaying all users");
        model.addAttribute("users", userService.getAll());
        return "pages/administration/administrationUsersPage";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("username") String username) {
        LOGGER.info(MessageFormat.format(DELETE_USER_LOG_MESSAGE, username));
        userService.delete(username);
        return "redirect:show-all";
    }

    @RequestMapping(value = "block", method = RequestMethod.GET)
    public String blockUser(@RequestParam("username") String username) {
        LOGGER.info(MessageFormat.format(DELETE_USER_LOG_MESSAGE, username));
        userService.changeUserState(username, UserState.BLOCKED);
        return "redirect:show-all";
    }

    @RequestMapping(value = "unblock", method = RequestMethod.GET)
    public String unblockUser(@RequestParam("username") String username) {
        LOGGER.info(MessageFormat.format(DELETE_USER_LOG_MESSAGE, username));
        userService.changeUserState(username, UserState.ACTIVE);
        return "redirect:show-all";
    }
}
