/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TAMU
 */
@Entity
@Table(name = "BRG_GADAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrgGadai.findAll", query = "SELECT b FROM BrgGadai b")
    , @NamedQuery(name = "BrgGadai.findByIdBarang", query = "SELECT b FROM BrgGadai b WHERE b.idBarang = :idBarang")
    , @NamedQuery(name = "BrgGadai.findByNmBarang", query = "SELECT b FROM BrgGadai b WHERE b.nmBarang = :nmBarang")
    , @NamedQuery(name = "BrgGadai.findByBerat", query = "SELECT b FROM BrgGadai b WHERE b.berat = :berat")
    , @NamedQuery(name = "BrgGadai.findByKualitas", query = "SELECT b FROM BrgGadai b WHERE b.kualitas = :kualitas")})
public class BrgGadai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BARANG")
    private String idBarang;
    @Column(name = "NM_BARANG")
    private String nmBarang;
    @Column(name = "BERAT")
    private String berat;
    @Column(name = "KUALITAS")
    private String kualitas;
    @OneToMany(mappedBy = "idBarang", fetch = FetchType.LAZY)
    private List<Gadai> gadaiList;
    @JoinColumn(name = "ID_JNS", referencedColumnName = "ID_JNS")
    @ManyToOne(fetch = FetchType.LAZY)
    private JenisBrg idJns;

    public BrgGadai() {
    }

    public BrgGadai(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNmBarang() {
        return nmBarang;
    }

    public void setNmBarang(String nmBarang) {
        this.nmBarang = nmBarang;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getKualitas() {
        return kualitas;
    }

    public void setKualitas(String kualitas) {
        this.kualitas = kualitas;
    }

    @XmlTransient
    public List<Gadai> getGadaiList() {
        return gadaiList;
    }

    public void setGadaiList(List<Gadai> gadaiList) {
        this.gadaiList = gadaiList;
    }

    public JenisBrg getIdJns() {
        return idJns;
    }

    public void setIdJns(JenisBrg idJns) {
        this.idJns = idJns;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarang != null ? idBarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrgGadai)) {
            return false;
        }
        BrgGadai other = (BrgGadai) object;
        if ((this.idBarang == null && other.idBarang != null) || (this.idBarang != null && !this.idBarang.equals(other.idBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idBarang + "";
    }
    
}
