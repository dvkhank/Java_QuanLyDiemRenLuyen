/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.controllers;

import com.qldrl.services.DieuService;
import com.qldrl.services.HoatDongService;
import com.qldrl.services.HocKiNamHocService;
import com.qldrl.services.KhoaService;
import com.qldrl.services.StatsService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author khanh
 */
@Controller
@RequestMapping("/admin")
public class StatsController {

    @Autowired
    private DieuService dieuService;
    @Autowired
    private HoatDongService hoatDongService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private HocKiNamHocService hknhService;
    @Autowired
    private StatsService statsService;

    private void addCommonAttributes(ModelMap model) {
        model.addAttribute("dieus", dieuService.getAll());
        model.addAttribute("khoas", khoaService.getAll());
        model.addAttribute("hockinamhocs", hknhService.getAll());
    }

    @GetMapping("/thongketoantruong")
    public String index(ModelMap model, @RequestParam Map<String, String> params) {
        addCommonAttributes(model);
        int min = 0, max = 0;
        int hknhId = 0;
        String label = "";
        String thanhtich = params.get("thanhtich");
        String strhknhId = params.get("hockinamhocId");
        if (strhknhId != null && !strhknhId.isEmpty()) {
            hknhId = Integer.parseInt(strhknhId);
        }

        if(thanhtich != null && !thanhtich.isEmpty()) {
            System.err.println("HELLO");
            switch (thanhtich) {
                case "xuatsac" -> {
                    min = 90;
                    max = 100;
                    label = "Xuất sắc";
                }
                case "gioi" -> {
                    min = 80;
                    max = 89;
                    label = "Giỏi";
                }
                case "kha" -> {
                    min = 65;
                    max = 79;
                    label = "Khá";
                }
                case "trungbinh" -> {
                    min = 50;
                    max = 64;
                    label = "Trung bình";
                }
                case "yeu" -> {
                    min = 35;
                    max = 49;
                    label = "Yếu";
                }
                default -> {
                    min = 0;
                    max = 34;
                }
            }
        } 
        
        List<Object[]> statsKhoa = statsService.statsTheoKhoa(min, max, hknhId);
        System.out.println(statsKhoa);
        model.addAttribute("statsKhoa", statsKhoa);
        model.addAttribute("label", label);
        return "admin/stats/statsall";
    }
}
