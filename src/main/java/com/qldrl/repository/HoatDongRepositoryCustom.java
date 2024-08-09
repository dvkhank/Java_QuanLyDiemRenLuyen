/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qldrl.repository;

import com.qldrl.pojo.HoatDong;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khanh
 */
public interface HoatDongRepositoryCustom {
    public List<HoatDong> searchHoatDongs(Map<String, String> searchParams);
}
