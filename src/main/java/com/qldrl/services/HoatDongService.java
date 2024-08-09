/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qldrl.services;

import com.qldrl.pojo.HoatDong;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khanh
 */
public interface HoatDongService {

    public List<HoatDong> getAll();

    public void saveOrUpdate(HoatDong hd);

    public HoatDong findById(int id);

    public void delete(int id);

    public List<HoatDong> getByKeyword(String keyword);

    public List<HoatDong> getByDieu(int dieuId);

    public List<HoatDong> getByKhoa(int khoaId);

    public List<HoatDong> getByHetHan();

    public List<HoatDong> getByDienRa();

    public List<HoatDong> searchHoatDongs(Map<String, String> searchParams);
}
