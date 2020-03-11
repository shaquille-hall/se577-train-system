package edu.drexel.TrainDemo.admin.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AdminController {

    @GetMapping("/admin")
    public String getAdminPage(@AuthenticationPrincipal OAuth2User principal, Model model) {
        return "admin/admin_portal";
    }
}


