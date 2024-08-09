/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.services;

import com.qldrl.pojo.NguoiDung;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author khanh
 */
@Service
public class CustomUserDetailService implements UserDetailsService{
    @Autowired
    private NguoiDungService nguoiDungService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NguoiDung nd = nguoiDungService.findByUsername(username);
        if (nd == null) {
            throw new UsernameNotFoundException("Khong tim thay nguoi dung");
        }
        Set<GrantedAuthority> a = new HashSet<>();
        a.add(new SimpleGrantedAuthority(nd.getUserRole()));
        return new User(nd.getUsername(), nd.getPassword(), a);
    }
}
