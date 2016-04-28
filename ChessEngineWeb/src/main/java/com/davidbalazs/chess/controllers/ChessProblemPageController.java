package com.davidbalazs.chess.controllers;

import com.davidbalazs.chess.controllers.enhancers.MainPageEnhancer;
import com.davidbalazs.chess.services.ChessProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by David B on 4/26/2016.
 */
@Controller
@RequestMapping(value = "chess-problem/")
public class ChessProblemPageController {

    @Resource(name = "mainPageEnhancer")
    private MainPageEnhancer mainPageEnhancer;

    @Resource(name = "chessProblemService")
    private ChessProblemService chessProblemService;


    @RequestMapping(value = "display-all", method = RequestMethod.GET)
    public String getStrategiesPage(Model model) {
        mainPageEnhancer.enhanceModelWithSideBar(model);

        model.addAttribute("chessProblems", chessProblemService.getAll());
        return "pages/problemsPage";
    }

    @RequestMapping(value = "problem", method = RequestMethod.GET)
    public String getProblemById(@RequestParam("problem-id") long problemId, Model model) {
        model.addAttribute("chessProblem", chessProblemService.getById(problemId));

        return "pages/problemPage";
    }
}
