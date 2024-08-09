/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.services.impl;

import com.qldrl.pojo.Dieu;
import com.qldrl.repository.DieuRepository;
import com.qldrl.services.DieuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khanh
 */
@Service
public class DieuServiceImpl implements DieuService{
    @Autowired
    private DieuRepository dieuRepo;
    @Override
    public List<Dieu> getAll() {
        return dieuRepo.findAll();
    }
    
}
