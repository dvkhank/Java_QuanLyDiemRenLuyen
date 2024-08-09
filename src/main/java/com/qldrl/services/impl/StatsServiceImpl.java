/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.services.impl;

import com.qldrl.repository.StatsRepository;
import com.qldrl.services.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khanh
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepo;
    
    @Override
    public List<Object[]> statsTheoKhoa(int min, int max, int hockinamhoc) {
        return statsRepo.statsTheoKhoa(min, max, hockinamhoc);
    }
}
