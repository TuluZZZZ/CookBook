package com.cook.book.cook.controllers;

import com.cook.book.cook.dtos.UserDto;
import com.cook.book.cook.services.impl.UserServiceImpl;
import com.cook.book.cook.validation.UserValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserServiceImpl userService;
    private final UserValidation userValidation;
    @GetMapping()
    public String formRegistration(Model model) {
        model.addAttribute("userDTO", new UserDto());
        return "registration";
    }
    @PostMapping()
    public String saveUser(@Valid UserDto userDTO, BindingResult bindingResult, Model model) {
        userValidation.validate(userDTO, bindingResult);
        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
            UserDto registration = userService.create(userDTO);
            log.info("Registered user with login: " + registration.getLogin());
            return "login";
        }
        model.addAttribute("userDTO", userDTO);
        return "registration";
    }

}
