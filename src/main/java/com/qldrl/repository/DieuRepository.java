/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qldrl.repository;

import com.qldrl.pojo.Dieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khanh
 */
@Repository
public interface DieuRepository extends JpaRepository<Dieu, Integer>{
    
}
