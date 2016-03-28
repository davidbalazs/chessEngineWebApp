package com.davidbalazs.chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "error/")
public class ErrorController {

    @RequestMapping(value = "notFound", method = RequestMethod.GET)
    public String notFound() {
        return "pages/notFoundPage";
    }

    @RequestMapping(value = "internalError", method = RequestMethod.GET)
    public String internalError() {
        return "pages/internalErrorPage";
    }
}
