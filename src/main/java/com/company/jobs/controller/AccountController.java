package com.company.jobs.controller;

import com.company.jobs.dto.UserDTO;
import com.company.jobs.exception.UserAlreadyExistsException;
import com.company.jobs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());

        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", userDTO);
            return "register";
        }
        try {
            accountService.save(userDTO);
        } catch (UserAlreadyExistsException e) {
            result.rejectValue("email", "error.user", "An account already exists for this email.");
            return "register";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }
}
