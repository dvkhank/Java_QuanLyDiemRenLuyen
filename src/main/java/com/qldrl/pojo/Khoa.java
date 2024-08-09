/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.pojo;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author khanh
 */
@Entity
@Table(name = "khoa")
@NamedQueries({
    @NamedQuery(name = "Khoa.findAll", query = "SELECT k FROM Khoa k"),
    @NamedQuery(name = "Khoa.findById", query = "SELECT k FROM Khoa k WHERE k.id = :id"),
    @NamedQuery(name = "Khoa.findByTen", query = "SELECT k FROM Khoa k WHERE k.ten = :ten")})
public class Khoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ten")
    private String ten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaId")
    private Set<HoatDong> hoatDongSet;
    @OneToMany(mappedBy = "khoaId")
    private Set<Lop> lopSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khoaId")
    private Set<TroLySinhVien> troLySinhVienSet;

    public Khoa() {
    }

    public Khoa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<HoatDong> getHoatDongSet() {
        return hoatDongSet;
    }

    public void setHoatDongSet(Set<HoatDong> hoatDongSet) {
        this.hoatDongSet = hoatDongSet;
    }

    public Set<Lop> getLopSet() {
        return lopSet;
    }

    public void setLopSet(Set<Lop> lopSet) {
        this.lopSet = lopSet;
    }

    public Set<TroLySinhVien> getTroLySinhVienSet() {
        return troLySinhVienSet;
    }

    public void setTroLySinhVienSet(Set<TroLySinhVien> troLySinhVienSet) {
        this.troLySinhVienSet = troLySinhVienSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Khoa)) {
            return false;
        }
        Khoa other = (Khoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldrl.pojo.Khoa[ id=" + id + " ]";
    }
    
}
