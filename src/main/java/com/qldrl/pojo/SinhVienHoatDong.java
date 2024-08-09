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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "sinh_vien_hoat_dong")
@NamedQueries({
    @NamedQuery(name = "SinhVienHoatDong.findAll", query = "SELECT s FROM SinhVienHoatDong s"),
    @NamedQuery(name = "SinhVienHoatDong.findById", query = "SELECT s FROM SinhVienHoatDong s WHERE s.id = :id"),
    @NamedQuery(name = "SinhVienHoatDong.findByTrangThai", query = "SELECT s FROM SinhVienHoatDong s WHERE s.trangThai = :trangThai")})
public class SinhVienHoatDong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "trang_thai")
    private Boolean trangThai;
    @JoinColumn(name = "hoat_dong_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HoatDong hoatDongId;
    @JoinColumn(name = "sinh_vien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SinhVien sinhVienId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sinhVienHoatDongId")
    private Set<BaoThieu> baoThieuSet;

    public SinhVienHoatDong() {
    }

    public SinhVienHoatDong(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public HoatDong getHoatDongId() {
        return hoatDongId;
    }

    public void setHoatDongId(HoatDong hoatDongId) {
        this.hoatDongId = hoatDongId;
    }

    public SinhVien getSinhVienId() {
        return sinhVienId;
    }

    public void setSinhVienId(SinhVien sinhVienId) {
        this.sinhVienId = sinhVienId;
    }

    public Set<BaoThieu> getBaoThieuSet() {
        return baoThieuSet;
    }

    public void setBaoThieuSet(Set<BaoThieu> baoThieuSet) {
        this.baoThieuSet = baoThieuSet;
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
        if (!(object instanceof SinhVienHoatDong)) {
            return false;
        }
        SinhVienHoatDong other = (SinhVienHoatDong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldrl.pojo.SinhVienHoatDong[ id=" + id + " ]";
    }
    
}
