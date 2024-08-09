/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qldrl.repository;

import java.util.List;

/**
 *
 * @author khanh
 */
public interface StatsRepository {
    public List<Object[]> statsTheoKhoa(int min, int max, int hockinamhoc);
}
