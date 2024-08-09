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
@Table(name = "dieu")
@NamedQueries({
    @NamedQuery(name = "Dieu.findAll", query = "SELECT d FROM Dieu d"),
    @NamedQuery(name = "Dieu.findById", query = "SELECT d FROM Dieu d WHERE d.id = :id"),
    @NamedQuery(name = "Dieu.findByDieu", query = "SELECT d FROM Dieu d WHERE d.dieu = :dieu"),
    @NamedQuery(name = "Dieu.findByDiemToiDa", query = "SELECT d FROM Dieu d WHERE d.diemToiDa = :diemToiDa")})
public class Dieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dieu")
    private int dieu;
    @Basic(optional = false)
    @Column(name = "diem_toi_da")
    private int diemToiDa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dieuId")
    private Set<HoatDong> hoatDongSet;

    public Dieu() {
    }

    public Dieu(Integer id) {
        this.id = id;
    }

    public Dieu(Integer id, int dieu, int diemToiDa) {
        this.id = id;
        this.dieu = dieu;
        this.diemToiDa = diemToiDa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDieu() {
        return dieu;
    }

    public void setDieu(int dieu) {
        this.dieu = dieu;
    }

    public int getDiemToiDa() {
        return diemToiDa;
    }

    public void setDiemToiDa(int diemToiDa) {
        this.diemToiDa = diemToiDa;
    }

    public Set<HoatDong> getHoatDongSet() {
        return hoatDongSet;
    }

    public void setHoatDongSet(Set<HoatDong> hoatDongSet) {
        this.hoatDongSet = hoatDongSet;
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
        if (!(object instanceof Dieu)) {
            return false;
        }
        Dieu other = (Dieu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qldrl.pojo.Dieu[ id=" + id + " ]";
    }
    
}
