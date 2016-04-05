package com.davidbalazs.chess.controllers.enhancers;

import org.springframework.ui.Model;

/**
 * Created by David on 4/4/2016.
 */
public class MainPageEnhancer {
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
    }
}
