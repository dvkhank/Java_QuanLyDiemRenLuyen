/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.services;

import com.qldrl.pojo.NguoiDung;


/**
 *
 * @author khanh
 */
public interface NguoiDungService {

    public NguoiDung addUser(NguoiDung nguoiDung);
    public NguoiDung findByUsername(String username);

}
