package com.davidbalazs.chess.controllers.administration;

import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.services.MessageService;
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
@RequestMapping(value = "administration/messages/")
public class AdministrationMessagesController {
    public static final Logger LOGGER = Logger.getLogger(AdministrationMessagesController.class);
    private static final String MARK_MESSAGE_AS_READ_LOG_MESSAGE = "Received request to mark message with id {0} as read.";
    private static final String MARK_MESSAGE_AS_UNREAD_LOG_MESSAGE = "Received request to mark message with id {0} as unread.";
    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "messageService")
    private MessageService messageService;

    @RequestMapping(value = "show-all", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        LOGGER.info("Displaying all messages");
        model.addAttribute("messages", messageService.getAll());
        return "pages/administration/administrationMessagesPage";
    }

    @RequestMapping(value = "mark-as-read", method = RequestMethod.GET)
    public String markAsRead(@RequestParam("message-id") long messageId) {
        LOGGER.info(MessageFormat.format(MARK_MESSAGE_AS_READ_LOG_MESSAGE, messageId));
        messageService.markAsRead(messageId);
        return "redirect:show-all";
    }

    @RequestMapping(value = "mark-as-unread", method = RequestMethod.GET)
    public String markAsUnread(@RequestParam("message-id") long messageId) {
        LOGGER.info(MessageFormat.format(MARK_MESSAGE_AS_UNREAD_LOG_MESSAGE, messageId));
        messageService.markAsUnread(messageId);
        return "redirect:show-all";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteMessage(@RequestParam("message-id") long messageId) {
        LOGGER.info(MessageFormat.format(MARK_MESSAGE_AS_UNREAD_LOG_MESSAGE, messageId));
        messageService.delete(messageId);
        return "redirect:show-all";
    }
}
