/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.controllers;

import com.qldrl.pojo.NguoiDung;
import com.qldrl.services.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author khanh
 */
@RestController
@RequestMapping("/api")
public class ApiAdminController {

    @Autowired
    private NguoiDungService nguoiDungService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/dangky")
    public ResponseEntity<String> registerUser(@RequestBody NguoiDung nguoiDung) {

        nguoiDung.setPassword(passwordEncoder.encode(nguoiDung.getPassword()));
        NguoiDung savedNguoiDung = nguoiDungService.addUser(nguoiDung);
        if (savedNguoiDung.getId() > 0) {
            return new ResponseEntity<>("Entity created successfully", HttpStatus.CREATED);

        }
            return new ResponseEntity<>("Entity created successfully", HttpStatus.BAD_GATEWAY);
    }
}
