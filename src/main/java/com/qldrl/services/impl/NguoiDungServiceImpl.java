/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.services.impl;

import com.qldrl.pojo.NguoiDung;
import com.qldrl.repository.NguoiDungRepository;
import com.qldrl.services.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khanh
 */
@Service
public class NguoiDungServiceImpl implements NguoiDungService{

    @Autowired
    private NguoiDungRepository nguoiDungRepo;

    public NguoiDung addUser(NguoiDung nguoiDung) {
        return nguoiDungRepo.save(nguoiDung);

    }

    @Override
    public NguoiDung findByUsername(String username) {
        return nguoiDungRepo.findByUsername(username);
    }
}
