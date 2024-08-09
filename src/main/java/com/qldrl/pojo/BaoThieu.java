/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.pojo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author khanh
 */
@Entity
@Table(name = "bao_thieu")
@NamedQueries({
    @NamedQuery(name = "BaoThieu.findAll", query = "SELECT b FROM BaoThieu b"),
    @NamedQuery(name = "BaoThieu.findById", query = "SELECT b FROM BaoThieu b WHERE b.id = :id"),
    @NamedQuery(name = "BaoThieu.findByActive", query = "SELECT b FROM BaoThieu b WHERE b.active = :active"),
    @NamedQuery(name = "BaoThieu.findByMinhChung", query = "SELECT b FROM BaoThieu b WHERE b.minhChung = :minhChung"),
    @NamedQuery(name = "BaoThieu.findByNoiDung", query = "SELECT b FROM BaoThieu b WHERE b.noiDung = :noiDung")})
public class BaoThieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Short active;
    @Column(name = "minh_chung")
    private String minhChung;
    @Column(name = "noi_dung")
    private String noiDung;
    @JoinColumn(name = "sinh_vien_hoat_dong_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SinhVienHoatDong sinhVienHoatDongId;

    public BaoThieu() {
    }

    public BaoThieu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getMinhChung() {
        return minhChung;
    }

    public void setMinhChung(String minhChung) {
        this.minhChung = minhChung;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public SinhVienHoatDong getSinhVienHoatDongId() {
        return sinhVienHoatDongId;
    }

    public void setSinhVienHoatDongId(SinhVienHoatDong sinhVienHoatDongId) {
        this.sinhVienHoatDongId = sinhVienHoatDongId;
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
        if (!(object instanceof BaoThieu)) {
            return false;
        }
        BaoThieu other = (BaoThieu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldrl.pojo.BaoThieu[ id=" + id + " ]";
    }
    
}
