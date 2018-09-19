/*
 * Copyright (C) 2018 Worldline ODC.
 */
package net.atos.wl.odc.techhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring REST Controller for Home.
 * 
 * @author a120065
 */
@Controller
public class HomeController {

    /**
     * Method to redirect to swagger UI at root.
     * 
     * @return redirection.
     */
    @RequestMapping("/")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
