package com.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
public class MainController {
    private final List<String> messages = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/projects")
    public String projects() {
        return "projects";
    }

    @GetMapping("/connect")
    public String connect() {
        return "connect";
    }

    @GetMapping("/messages")
    public String messagesPage(Model model) {
        model.addAttribute("messages", messages);
        return "messages";
    }

    @PostMapping("/connect")
    public String submitconnect(@RequestParam String name, @RequestParam String email, @RequestParam String message, Model model) {
        messages.add(name + " (" + email + "): " + message);
        model.addAttribute("success", true);
        return "connect";
    }
}
