/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.repository.impl;

import com.qldrl.pojo.Dieu;
import com.qldrl.pojo.HoatDong;
import com.qldrl.pojo.HocKiNamHoc;
import com.qldrl.pojo.Khoa;
import com.qldrl.repository.HoatDongRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khanh
 */
@Repository
public class HoatDongRepositoryCustomImpl implements HoatDongRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public List<HoatDong> searchHoatDongs(Map<String, String> searchParams) {
        List<HoatDong> hoatdongs;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HoatDong> cq = cb.createQuery(HoatDong.class);
        Root<HoatDong> hoatDong = cq.from(HoatDong.class);

        List<Predicate> predicates = new ArrayList<>();

        String keyword = searchParams.get("keyword");
        if (keyword
                != null && !keyword.isEmpty()) {
            predicates.add(cb.like(hoatDong.get("ten"), "%" + keyword + "%"));
        }

        String strDieuId = searchParams.get("dieuId");
        if (strDieuId
                != null && !strDieuId.isEmpty()) {
            int dieuId = Integer.parseInt(strDieuId);
            Dieu dieu = entityManager.find(Dieu.class, dieuId);
            if (dieu != null) {
                predicates.add(cb.equal(hoatDong.get("dieuId"), dieu));
            }
        }

        String strKhoaId = searchParams.get("khoaId");
        if (strKhoaId
                != null && !strKhoaId.isEmpty()) {
            int khoaId = Integer.parseInt(strKhoaId);
            Khoa khoa = entityManager.find(Khoa.class, khoaId);
            if (khoa != null) {
                predicates.add(cb.equal(hoatDong.get("khoaId"), khoa));
            }
        }
        String strStatus = searchParams.get("status");
        if (strStatus != null && !strStatus.isEmpty()) {
            if (strStatus.equals("dienra")) {
                predicates.add(cb.greaterThan(hoatDong.get("ngay"), new Date()));
            } else {
                predicates.add(cb.lessThan(hoatDong.get("ngay"), new Date()));
            }

        }
        String strhknhId = searchParams.get("hockinamhocId");
        if (strhknhId != null && !strhknhId.isEmpty()) {
            int hknhId = Integer.parseInt(strhknhId);
            HocKiNamHoc hknh = entityManager.find(HocKiNamHoc.class, hknhId);
            if (hknh != null) {
                predicates.add(cb.equal(hoatDong.get("hocKiNamHocId"), hknh));
            }
        }

        cq.where(predicates.toArray(new Predicate[0]));
        cq.orderBy(cb.desc(hoatDong.get("id")));

        TypedQuery<HoatDong> query = entityManager.createQuery(cq);
        String p = searchParams.get("page");
        if (p != null && !p.isEmpty()) {
            int page = Integer.parseInt(p);
            if (page > 0) {
                int pageSize = 6;
                int start = (page - 1) * pageSize;
                query.setFirstResult(start);
                query.setMaxResults(pageSize);
            } else {
                // Nếu trang không hợp lệ, có thể đặt start và pageSize mặc định
                query.setFirstResult(0);
                query.setMaxResults(6);
            }
        }

        List<HoatDong> hoatDongs = query.getResultList();
        return hoatDongs;

    }
}
