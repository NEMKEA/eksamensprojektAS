package com.example.projektkalkuleringsprojekt2semexam.controller;

import com.example.projektkalkuleringsprojekt2semexam.model.User;
import com.example.projektkalkuleringsprojekt2semexam.service.projectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {

    private projectService projectService;

    private boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    public AccountController(projectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/createuser")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "createUser";
    }

    @PostMapping("/createuser")
    public String createdUser(@ModelAttribute("user") User user) {
        projectService.createUser(user);
        return "createUserSuccess";
    }

    @GetMapping("/youraccount")
    public String yourAccount(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user = projectService.getUserById(user.getUserID());
        model.addAttribute("user", user);
        return isLoggedIn(session) ? "accountinfo" : "index";
    }

    @PostMapping("/youraccount/delete")
    public String deleteAccount(HttpSession session, @RequestParam("id") int id) {
        projectService.deleteAccount(id);
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("youraccount/edit/{id}")
    public String editedAccount(HttpSession session, User editedUser) {
        User user = (User) session.getAttribute("user");
        projectService.editAccount(user.getUserID(), editedUser);
        return "redirect:/youraccount";
    }

}
