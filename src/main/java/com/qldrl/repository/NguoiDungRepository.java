/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.repository;

import com.qldrl.pojo.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khanh
 */
@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer>{
    NguoiDung findByEmail(String email);
    NguoiDung findByUsername(String username);
    

}
