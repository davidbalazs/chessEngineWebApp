package com.davidbalazs.chess.controllers.enhancers;

import com.davidbalazs.chess.services.LatestNewsSideBarService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.ui.Model;

/**
 * Created by David on 4/4/2016.
 */
public class MainPageEnhancer {
    private LatestNewsSideBarService latestNewsSideBarService;

    public void enhanceModelWithSideBar(Model model) {
        enhanceModelWithLatestNewsSideBar(model);
        enhanceModelWithQuoteOfTheDaySideBar(model);
        enhanceModelWithProblemOfTheDaySideBar(model);
    }

    private void enhanceModelWithProblemOfTheDaySideBar(Model model) {
    }

    private void enhanceModelWithQuoteOfTheDaySideBar(Model model) {

    }

    private void enhanceModelWithLatestNewsSideBar(Model model) {
        model.addAttribute("latestNews", latestNewsSideBarService.getLatestNews());
    }

    @Required
    public void setLatestNewsSideBarService(LatestNewsSideBarService latestNewsSideBarService) {
        this.latestNewsSideBarService = latestNewsSideBarService;
    }
}
