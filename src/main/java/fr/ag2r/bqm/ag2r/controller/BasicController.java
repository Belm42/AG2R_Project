package fr.ag2r.bqm.ag2r.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @GetMapping("/")
    public String def() {

        return "redirect:/user/event/index";
    }

    @GetMapping("/403")
    public String notAutorized() {

        return "403";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }
}
