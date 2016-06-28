package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.enhancers.SideBarEnhancer;
import com.davidbalazs.chess.enhancers.UserEnhancer;
import com.davidbalazs.chess.models.ChessProblemModel;
import com.davidbalazs.chess.services.ChessProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;
import java.util.Random;

/**
 * Created by David B on 4/26/2016.
 */
@Controller
@RequestMapping(value = "chess-problem/")
public class ChessProblemPageController {
    @Resource(name = "userEnhancer")
    private UserEnhancer userEnhancer;

    @Resource(name = "sideBarEnhancer")
    private SideBarEnhancer sideBarEnhancer;

    @Resource(name = "chessProblemService")
    private ChessProblemService chessProblemService;


    @RequestMapping(value = "display-all", method = RequestMethod.GET)
    public String getStrategiesPage(Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        sideBarEnhancer.enhanceModelWithSideBar(model);

        model.addAttribute("chessProblems", chessProblemService.getAll());
        return "pages/problemsPage";
    }

    @RequestMapping(value = "problem", method = RequestMethod.GET)
    public String getProblemById(@RequestParam("problem-id") long problemId, Model model, Principal principal) {
        userEnhancer.enhanceModelWithLoggedInUser(model, principal);
        model.addAttribute("chessProblem", chessProblemService.getById(problemId));

        return "pages/problemPage";
    }

    @RequestMapping(value = "another-problem", method = RequestMethod.GET)
    public String getAnotherProblem(@RequestParam("problem-id") long problemId, Model model, Principal principal) {
        List<ChessProblemModel> problemsList = chessProblemService.getAll();
        Random rand = new Random();
        int generatedRandomNumber = rand.nextInt(problemsList.size());
        long newProblemId = problemsList.get(generatedRandomNumber).getId();

        if (newProblemId == problemId) {
            generatedRandomNumber = rand.nextInt(problemsList.size());
            newProblemId = problemsList.get(generatedRandomNumber).getId();
        }
        return "redirect:problem?problem-id=" + newProblemId;
    }
}
