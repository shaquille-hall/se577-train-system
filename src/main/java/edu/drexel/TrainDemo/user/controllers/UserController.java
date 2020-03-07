package edu.drexel.TrainDemo.user.controllers;

import edu.drexel.TrainDemo.user.models.User;
import edu.drexel.TrainDemo.user.repositories.UserRepository;
import edu.drexel.TrainDemo.user.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private UserService service;

    public UserController(UserRepository repo) {
        this.service = new UserService(repo);
    }

    @GetMapping("/user")
    @ResponseBody
    public User getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        Integer id = principal.getAttribute("id");
        String defaultName = principal.getAttribute("name");
        return service.getOrCreateUser(id, defaultName);
    }

    @PostMapping("/user/manage/submit")
    @ResponseBody
    public Object submitUserInfo(@AuthenticationPrincipal OAuth2User principal, @ModelAttribute User newUserData) {
        User originalUserData = getUserInfo(principal);
        service.saveUser(originalUserData, newUserData);
        return "<script>window.location.href = '/';</script>";
    }

    @GetMapping("/user/manage")
    public String manageUser(@AuthenticationPrincipal OAuth2User principal, Model model) {
        User current = getUserInfo(principal);
        model.addAttribute("User", current);
        return "user/manage_user";
    }
}