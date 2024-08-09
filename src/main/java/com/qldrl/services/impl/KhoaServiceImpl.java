/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.services.impl;

import com.qldrl.pojo.Khoa;
import com.qldrl.repository.KhoaRepository;
import com.qldrl.services.KhoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khanh
 */
@Service
public class KhoaServiceImpl implements KhoaService{
    @Autowired
    private KhoaRepository khoaRepo;
    
    public List<Khoa> getAll() {
        return khoaRepo.findAll();
    }
    public Khoa getById(int id) {
        return khoaRepo.findById(id).orElse(null);
    }

}
