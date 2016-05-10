package com.davidbalazs.chess.controllers.administration;

import com.davidbalazs.chess.data.LatestNewsItemData;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.facades.LatestNewsFacade;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
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
    private static final String ERROR_SUBMITTING_THE_ADD_NEWS_FORM_LOG_MESSAGE = "Error submitting the add news form.";
    private static final String ADD_NEWS_LOG_MESSAGE = "Received request to add latest news with title: {0}.";

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "latestNewsFacade")
    private LatestNewsFacade latestNewsFacade;

    @RequestMapping(value = "show-all", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        LOGGER.info("Displaying all news");
        model.addAttribute("newsList", latestNewsFacade.getAll());
        model.addAttribute("newsData", new LatestNewsItemData());
        return "pages/administration/administrationNewsPage";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteNews(@RequestParam("news-id") long newsId) {
        LOGGER.info(MessageFormat.format(DELETE_NEWS_ITEM_LOG_MESSAGE, newsId));
        latestNewsFacade.delete(newsId);
        return "redirect:show-all";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addNews(RedirectAttributes redirectAttrs, @Valid @ModelAttribute("newsData") LatestNewsItemData latestNewsItemData, BindingResult result) {
        if (result.hasErrors()) {
            LOGGER.error(ERROR_SUBMITTING_THE_ADD_NEWS_FORM_LOG_MESSAGE);
            redirectAttrs.addFlashAttribute("message", "Error submitting form. Please try again with valid data.");
            return "redirect:show-all";
        }

        LOGGER.info(MessageFormat.format(ADD_NEWS_LOG_MESSAGE, latestNewsItemData.getTitle()));
        redirectAttrs.addFlashAttribute("message", "news have been successfully added.");
        latestNewsFacade.add(latestNewsItemData);
        return "redirect:show-all";
    }
}
