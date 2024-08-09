/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.services.impl;

import com.qldrl.pojo.HoatDong;
import com.qldrl.repository.HoatDongRepository;
import com.qldrl.services.HoatDongService;
import jakarta.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author khanh
 */
@Service
public class HoatDongServiceImpl implements HoatDongService {

    @Autowired
    private HoatDongRepository hoatDongRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<HoatDong> getAll() {
        return hoatDongRepository.findAll();
    }

    @Override
    public void saveOrUpdate(HoatDong hd) {
        hoatDongRepository.save(hd);
    }

    @Override
    public HoatDong findById(int id) {
        return hoatDongRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        hoatDongRepository.deleteById(id);
    }

    @Override
    public List<HoatDong> getByKeyword(String keyword) {

        return hoatDongRepository.findByKeyword(keyword);
    }

    @Override
    public List<HoatDong> getByDieu(int dieuId) {
        return hoatDongRepository.findByDieu(dieuId);
    }

    @Override
    public List<HoatDong> getByKhoa(int khoaId) {
        return hoatDongRepository.findByKhoa(khoaId);
    }

    @Override
    public List<HoatDong> getByHetHan() {
        return hoatDongRepository.findByNgayBefore(new Date());
    }

    @Override
    public List<HoatDong> getByDienRa() {
        return hoatDongRepository.findByNgayAfter(new Date());
    }

    @Override
    public List<HoatDong> searchHoatDongs(Map<String, String> searchParams) {
        return hoatDongRepository.searchHoatDongs(searchParams);
    }
    
 
}
