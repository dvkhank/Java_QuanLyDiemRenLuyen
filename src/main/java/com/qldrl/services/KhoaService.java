/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qldrl.services;

import com.qldrl.pojo.Khoa;
import java.util.List;

/**
 *
 * @author khanh
 */
public interface KhoaService {
    public List<Khoa> getAll();
    public Khoa getById(int id);
    
}
