/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.controllers;

import com.qldrl.pojo.Dieu;
import com.qldrl.pojo.HoatDong;
import com.qldrl.pojo.Khoa;
import com.qldrl.services.DieuService;
import com.qldrl.services.HoatDongService;
import com.qldrl.services.HocKiNamHocService;
import com.qldrl.services.KhoaService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author khanh
 */
@Controller
@RequestMapping("/admin")
public class HoatDongController {

    @Autowired
    private DieuService dieuService;
    @Autowired
    private HoatDongService hoatDongService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private HocKiNamHocService hknhService;

    private void addCommonAttributes(ModelMap model) {
        model.addAttribute("dieus", dieuService.getAll());
        model.addAttribute("khoas", khoaService.getAll());
        model.addAttribute("hockinamhocs", hknhService.getAll());
    }

    @GetMapping("/hoatdong")
    public String index(ModelMap model, @RequestParam Map<String, String> params) {
        if (!params.containsKey("page")) {
            params.put("page", "1");
        }
        List<HoatDong> hoatdongs = hoatDongService.searchHoatDongs(params);
        addCommonAttributes(model);
        model.addAttribute("hoatdongs", hoatdongs);
        params.forEach((key, value) -> {
            if ("keyword".equals(key) && value != null && !value.isEmpty()) {
                model.addAttribute(key, value);
            }
        });
        return "admin/hoatdong/index";
    }

    @GetMapping("/tao-hoatdong")
    public String add(ModelMap model) {
        HoatDong hd = new HoatDong();
        model.addAttribute("hoatdong", hd);
        addCommonAttributes(model);

        return "admin/hoatdong/add";
    }

    @PostMapping("/tao-hoatdong")
    public String addHoatDong(@Valid @ModelAttribute("hoatdong") HoatDong hd, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            addCommonAttributes(model);
            return "admin/hoatdong/add";
        }
        hoatDongService.saveOrUpdate(hd);
        return "redirect:/admin/hoatdong";

    }

    @GetMapping("/sua-hoatdong/{id}")
    public String editHoatDong(ModelMap model, @PathVariable("id") Integer id) {
        model.addAttribute("hoatdong", this.hoatDongService.findById(id));
        addCommonAttributes(model);
        return "admin/hoatdong/edit";
    }

    @PostMapping("/sua-hoatdong")
    public String suaHoatDong(@Valid @ModelAttribute("hoatdong") HoatDong hd, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            addCommonAttributes(model);
            return "admin/hoatdong/edit";
        }
        hoatDongService.saveOrUpdate(hd);
        return "redirect:/admin/hoatdong";
    }

    @GetMapping("/xoa-hoatdong/{id}")
    public String xoaHoatDong(@PathVariable("id") Integer id) {
        hoatDongService.delete(id);
        return "redirect:/admin/hoatdong";
    }

}
