package com.davidbalazs.chess.controllers.administration;

import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.services.LatestNewsService;
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
@RequestMapping(value = "administration/news/")
public class AdministrationNewsPageController {
    public static final Logger LOGGER = Logger.getLogger(AdministrationNewsPageController.class);
    private static final String DELETE_NEWS_ITEM_LOG_MESSAGE = "Received request to delete news item with id {0}";

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "latestNewsService")
    private LatestNewsService latestNewsService;

    @RequestMapping(value = "show-all", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        LOGGER.info("Displaying all news");
        model.addAttribute("news", latestNewsService.getLatestNews());
        return "pages/administration/administrationNewsPage";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteNews(@RequestParam("news-id") long newsId) {
        LOGGER.info(MessageFormat.format(DELETE_NEWS_ITEM_LOG_MESSAGE, newsId));
        latestNewsService.delete(newsId);
        return "redirect:show-all";
    }
}
