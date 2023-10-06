package com.cook.book.cook.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ClientsController {
    @GetMapping("/api/v1/clients")
    public String login() {
        return "clients";
    }
}

