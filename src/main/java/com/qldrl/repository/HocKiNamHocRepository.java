/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qldrl.repository;

import com.qldrl.pojo.HocKiNamHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khanh
 */
@Repository
public interface HocKiNamHocRepository extends JpaRepository<HocKiNamHoc, Integer>{
    
}
