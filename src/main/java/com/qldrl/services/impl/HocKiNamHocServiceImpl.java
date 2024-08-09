/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.services.impl;

import com.qldrl.pojo.HocKiNamHoc;
import com.qldrl.repository.HocKiNamHocRepository;
import com.qldrl.services.HocKiNamHocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khanh
 */
@Service
public class HocKiNamHocServiceImpl implements HocKiNamHocService{
    
    @Autowired
    private HocKiNamHocRepository hknhr;
    
    public List<HocKiNamHoc> getAll() {
        return hknhr.findAll();
    }
}
