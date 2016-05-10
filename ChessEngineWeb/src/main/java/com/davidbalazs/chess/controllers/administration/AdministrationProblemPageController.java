package com.davidbalazs.chess.controllers.administration;

import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.services.ChessProblemService;
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
@RequestMapping(value = "administration/problem/")
public class AdministrationProblemPageController {
    public static final Logger LOGGER = Logger.getLogger(AdministrationProblemPageController.class);
    private static final String DELETE_PROBLEM_LOG_MESSAGE = "Received request to delete problem with id {0}.";
    private static final String MARK_AS_PROBLEM_OF_THE_DAY_LOG_MESSAGE = "Received request to mark problem with id {0} as problem of the day.";
    private static final String UNMARK_AS_PROBLEM_OF_THE_DAY_LOG_MESSAGE = "Received request to mark problem with id {0} as problem of the day.";

    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "chessProblemService")
    private ChessProblemService chessProblemService;

    @RequestMapping(value = "show-all", method = RequestMethod.GET)
    public String getPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        LOGGER.info("Displaying all problems");
        model.addAttribute("chessProblems", chessProblemService.getAll());
        return "pages/administration/administrationProblemOfTheDayPage";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteProblem(@RequestParam("problem-id") long problemId) {
        LOGGER.info(MessageFormat.format(DELETE_PROBLEM_LOG_MESSAGE, problemId));
        chessProblemService.delete(problemId);
        return "redirect:show-all";
    }

    @RequestMapping(value = "mark-as-problem-of-the-day", method = RequestMethod.GET)
    public String markAsProblemOfTheDay(@RequestParam("problem-id") long problemId) {
        LOGGER.info(MessageFormat.format(MARK_AS_PROBLEM_OF_THE_DAY_LOG_MESSAGE, problemId));
        chessProblemService.markAsProblemOfTheDay(problemId);
        return "redirect:show-all";
    }

    @RequestMapping(value = "UNmark-as-problem-of-the-day", method = RequestMethod.GET)
    public String UNmarkAsProblemOfTheDay(@RequestParam("problem-id") long problemId) {
        LOGGER.info(MessageFormat.format(UNMARK_AS_PROBLEM_OF_THE_DAY_LOG_MESSAGE, problemId));
        chessProblemService.unmarkAsProblemOfTheDay(problemId);
        return "redirect:show-all";
    }
}
