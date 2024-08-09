/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;

/**
 *
 * @author khanh
 */
@Controller
public class LocaleController {

    @Autowired
    private LocaleResolver localeResolver;

    @PostMapping("/changeLanguage")
    public String changeLanguage(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("lang") String lang) {
        Locale locale = new Locale(lang);
        localeResolver.setLocale(request, response, locale);
        // Return the current page or view
        return "redirect:" + request.getHeader("Referer");
    }
}
