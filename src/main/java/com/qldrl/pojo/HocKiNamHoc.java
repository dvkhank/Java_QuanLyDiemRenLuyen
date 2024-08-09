/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qldrl.pojo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "hoc_ki_nam_hoc")
@NamedQueries({
    @NamedQuery(name = "HocKiNamHoc.findAll", query = "SELECT h FROM HocKiNamHoc h"),
    @NamedQuery(name = "HocKiNamHoc.findById", query = "SELECT h FROM HocKiNamHoc h WHERE h.id = :id")})
public class HocKiNamHoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "hocKiNamHocId")
    private Set<HoatDong> hoatDongSet;
    @JoinColumn(name = "hoc_ki_id", referencedColumnName = "id")
    @ManyToOne
    private HocKi hocKiId;
    @JoinColumn(name = "nam_hoc_id", referencedColumnName = "id")
    @ManyToOne
    private NamHoc namHocId;

    public HocKiNamHoc() {
    }

    public HocKiNamHoc(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<HoatDong> getHoatDongSet() {
        return hoatDongSet;
    }

    public void setHoatDongSet(Set<HoatDong> hoatDongSet) {
        this.hoatDongSet = hoatDongSet;
    }

    public HocKi getHocKiId() {
        return hocKiId;
    }

    public void setHocKiId(HocKi hocKiId) {
        this.hocKiId = hocKiId;
    }

    public NamHoc getNamHocId() {
        return namHocId;
    }

    public void setNamHocId(NamHoc namHocId) {
        this.namHocId = namHocId;
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
        if (!(object instanceof HocKiNamHoc)) {
            return false;
        }
        HocKiNamHoc other = (HocKiNamHoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldrl.pojo.HocKiNamHoc[ id=" + id + " ]";
    }
    
}
