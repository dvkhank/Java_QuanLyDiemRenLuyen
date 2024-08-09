/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.repository.impl;

import com.qldrl.repository.StatsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author khanh
 */
@Repository
public class StatsRepositoryImpl implements StatsRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> statsTheoKhoa(int min, int max, int hockinamhoc) {

        String subqueryHQL = "SELECT nd.id, d.dieu, k.ten, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN sv.nguoiDung nd "
                + "JOIN sv.lopId l "
                + "JOIN l.khoaId k "
                + "WHERE hn.id = :hockinamhoc AND svhd.trangThai = true "
                + "GROUP BY nd.id, d.dieu, k.ten, d.diemToiDa";

        Map<Integer, Integer> resultMap = new HashMap<>();
        //Query tính điểm group by theo điều
        TypedQuery<Object[]> query = entityManager.createQuery(subqueryHQL, Object[].class);
        query.setParameter("hockinamhoc", hockinamhoc);
        List<Object[]> queryResult = query.getResultList();//Câu query có 4 cột : id , dieu, khoa, tongdiem
        //Tính điểm dựa trên id
        // 1 Object[] =  id , dieu, khoa, tongdiem
        for (Object[] row : queryResult) {
            int id = (int) (row[0]);
            int diemTong = (int) row[3];
            if (resultMap.containsKey(id)) {
                resultMap.put(id, resultMap.get(id) + diemTong);
            } else {
                resultMap.put(id, diemTong);
            }
        }
        //=> Đã tính xong điểm sinh viên 
        //=> resultMap ("123",90)

        List<Object[]> temptResult = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            int id = entry.getKey();
            int sumDiemTong = entry.getValue();//Duyệt từng map trong resultMap để so sánh id để lấy 
            //Nhóm các trường theo id, minh họa subquery
            for (Object[] row : queryResult) {
                int currentId = (int) row[0];
                if (currentId == id) {
                    int dieu = (int) row[1];
                    String khoa = (String) row[2];
                    temptResult.add(new Object[]{id, dieu, khoa, sumDiemTong});
                    break; // Dừng vòng lặp khi tìm thấy id tương ứng
                }
            }
        }

        //Đếm số lượng thành tích theo khoa từ map temptResult, map này đã đầy đủ 4 trường
        Map<String, Integer> countByKhoa = new HashMap<>();
        List<Object[]> finalResult = new ArrayList<>();

        for (Object[] row : temptResult) {
            String khoa = (String) row[2]; // Lấy giá trị của trường khoa từ temptResult
            int sumDiemTong = (int) row[3]; // Lấy giá trị sumDiemTong từ temptResult

            // Kiểm tra nếu sumDiemTong lớn hơn hoặc bằng giá trị thành tích
            if (sumDiemTong >= min && sumDiemTong <= max) {
                // Kiểm tra nếu khoa đã tồn tại trong Map
                if (countByKhoa.containsKey(khoa)) {
                    // Nếu đã tồn tại, tăng giá trị đếm lên 1
                    countByKhoa.put(khoa, countByKhoa.get(khoa) + 1);
                } else {
                    // Nếu chưa tồn tại, thêm khoa vào Map với giá trị 1
                    countByKhoa.put(khoa, 1);
                }
            }
        }

//         Tạo các đối tượng kết quả và thêm vào danh sách finalResult
        for (Map.Entry<String, Integer> entry : countByKhoa.entrySet()) {
            String khoa = entry.getKey();
            int count = entry.getValue();
            finalResult.add(new Object[]{khoa, count});
        }
        return finalResult;

    }
}
