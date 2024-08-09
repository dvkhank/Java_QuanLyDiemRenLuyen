/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.controllers;

import java.time.LocalDate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author khanh
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void commonAttributes(ModelMap model) {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    
    if (principal instanceof UserDetails) {
        UserDetails userDetails = (UserDetails) principal;
        model.addAttribute("user", userDetails);
    } else {
        model.addAttribute("user", null);
    }
    
    LocalDate today = LocalDate.now();
    model.addAttribute("today", today);

    }
}
