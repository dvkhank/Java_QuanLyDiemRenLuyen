/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.pojo;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "nam_hoc")
@NamedQueries({
    @NamedQuery(name = "NamHoc.findAll", query = "SELECT n FROM NamHoc n"),
    @NamedQuery(name = "NamHoc.findById", query = "SELECT n FROM NamHoc n WHERE n.id = :id"),
    @NamedQuery(name = "NamHoc.findByNamHoc", query = "SELECT n FROM NamHoc n WHERE n.namHoc = :namHoc")})
public class NamHoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nam_hoc")
    private int namHoc;
    @OneToMany(mappedBy = "namHocId")
    private Set<HocKiNamHoc> hocKiNamHocSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "namHocId")
    private Set<SinhVien> sinhVienSet;

    public NamHoc() {
    }

    public NamHoc(Integer id) {
        this.id = id;
    }

    public NamHoc(Integer id, int namHoc) {
        this.id = id;
        this.namHoc = namHoc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public Set<HocKiNamHoc> getHocKiNamHocSet() {
        return hocKiNamHocSet;
    }

    public void setHocKiNamHocSet(Set<HocKiNamHoc> hocKiNamHocSet) {
        this.hocKiNamHocSet = hocKiNamHocSet;
    }

    public Set<SinhVien> getSinhVienSet() {
        return sinhVienSet;
    }

    public void setSinhVienSet(Set<SinhVien> sinhVienSet) {
        this.sinhVienSet = sinhVienSet;
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
        if (!(object instanceof NamHoc)) {
            return false;
        }
        NamHoc other = (NamHoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldrl.pojo.NamHoc[ id=" + id + " ]";
    }
    
}
