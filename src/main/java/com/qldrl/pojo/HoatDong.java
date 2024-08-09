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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;
/**
 *
 * @author khanh
 */
@Entity
@Table(name = "hoat_dong")
@NamedQueries({
    @NamedQuery(name = "HoatDong.findAll", query = "SELECT h FROM HoatDong h"),
    @NamedQuery(name = "HoatDong.findById", query = "SELECT h FROM HoatDong h WHERE h.id = :id"),
    @NamedQuery(name = "HoatDong.findByTen", query = "SELECT h FROM HoatDong h WHERE h.ten = :ten"),
    @NamedQuery(name = "HoatDong.findByMoTa", query = "SELECT h FROM HoatDong h WHERE h.moTa = :moTa"),
    @NamedQuery(name = "HoatDong.findByDiem", query = "SELECT h FROM HoatDong h WHERE h.diem = :diem"),
    @NamedQuery(name = "HoatDong.findByPhi", query = "SELECT h FROM HoatDong h WHERE h.phi = :phi"),
    @NamedQuery(name = "HoatDong.findByNgay", query = "SELECT h FROM HoatDong h WHERE h.ngay = :ngay")})
public class HoatDong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @NotBlank(message = "Tên không được trống")
    @Column(name = "ten")
    private String ten;
    @Column(name = "mo_ta")
    private String moTa;
    @Basic(optional = false)
    @Positive(message = "Số phải lớn hơn 0")
    @Column(name = "diem")
    private int diem;
    @Column(name = "phi")
    private Long phi;
    @NotNull(message = "Ngày không được để trống")
    @Column(name = "ngay")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngay;
    @JoinColumn(name = "dieu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dieu dieuId;
    @JoinColumn(name = "hoc_ki_nam_hoc_id", referencedColumnName = "id")
    @ManyToOne
    private HocKiNamHoc hocKiNamHocId;
    @JoinColumn(name = "khoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Khoa khoaId;
    @OneToMany(mappedBy = "hoatDongId")
    private Set<BaiViet> baiVietSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoatDongId")
    private Set<SinhVienHoatDong> sinhVienHoatDongSet;

    public HoatDong() {
    }

    public HoatDong(Integer id) {
        this.id = id;
    }

    public HoatDong(Integer id, int diem) {
        this.id = id;
        this.diem = diem;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Long getPhi() {
        return phi;
    }

    public void setPhi(Long phi) {
        this.phi = phi;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Dieu getDieuId() {
        return dieuId;
    }

    public void setDieuId(Dieu dieuId) {
        this.dieuId = dieuId;
    }

    public HocKiNamHoc getHocKiNamHocId() {
        return hocKiNamHocId;
    }

    public void setHocKiNamHocId(HocKiNamHoc hocKiNamHocId) {
        this.hocKiNamHocId = hocKiNamHocId;
    }

    public Khoa getKhoaId() {
        return khoaId;
    }

    public void setKhoaId(Khoa khoaId) {
        this.khoaId = khoaId;
    }

    public Set<BaiViet> getBaiVietSet() {
        return baiVietSet;
    }

    public void setBaiVietSet(Set<BaiViet> baiVietSet) {
        this.baiVietSet = baiVietSet;
    }

    public Set<SinhVienHoatDong> getSinhVienHoatDongSet() {
        return sinhVienHoatDongSet;
    }

    public void setSinhVienHoatDongSet(Set<SinhVienHoatDong> sinhVienHoatDongSet) {
        this.sinhVienHoatDongSet = sinhVienHoatDongSet;
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
        if (!(object instanceof HoatDong)) {
            return false;
        }
        HoatDong other = (HoatDong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldrl.pojo.HoatDong[ id=" + id + " ]";
    }
    
}
