/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.qldrl.repository;

import com.qldrl.pojo.HoatDong;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khanh
 */
@Repository
public interface HoatDongRepository extends JpaRepository<HoatDong, Integer>, HoatDongRepositoryCustom{

    @Query("SELECT h FROM HoatDong h WHERE h.ten LIKE %?1%")
    List<HoatDong> findByKeyword(String keyword);

    @Query("SELECT h FROM HoatDong h WHERE h.dieuId.id = :dieuId")
    List<HoatDong> findByDieu(@Param("dieuId") int dieuId);

    @Query("SELECT h FROM HoatDong h WHERE h.khoaId.id = :khoaId")
    List<HoatDong> findByKhoa(@Param("khoaId") int khoaId);

    List<HoatDong> findByNgayBefore(Date date);

    List<HoatDong> findByNgayAfter(Date date);
}
