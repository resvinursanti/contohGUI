/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TAMU
 */
@Entity
@Table(name = "GADAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gadai.findAll", query = "SELECT g FROM Gadai g")
    , @NamedQuery(name = "Gadai.findByIdGadai", query = "SELECT g FROM Gadai g WHERE g.idGadai = :idGadai")
    , @NamedQuery(name = "Gadai.findByJmlPinjaman", query = "SELECT g FROM Gadai g WHERE g.jmlPinjaman = :jmlPinjaman")
    , @NamedQuery(name = "Gadai.findByTglPengajuan", query = "SELECT g FROM Gadai g WHERE g.tglPengajuan = :tglPengajuan")
    , @NamedQuery(name = "Gadai.findByStatus", query = "SELECT g FROM Gadai g WHERE g.status = :status")
    , @NamedQuery(name = "Gadai.findBySisa", query = "SELECT g FROM Gadai g WHERE g.sisa = :sisa")})
public class Gadai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GADAI")
    private String idGadai;
    @Column(name = "JML_PINJAMAN")
    private Long jmlPinjaman;
    @Column(name = "TGL_PENGAJUAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglPengajuan;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "SISA")
    private Long sisa;
    @JoinColumn(name = "ID_BARANG", referencedColumnName = "ID_BARANG")
    @ManyToOne(fetch = FetchType.LAZY)
    private BrgGadai idBarang;
    @JoinColumn(name = "ID_CUST", referencedColumnName = "ID_CUST")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer idCust;
    @OneToMany(mappedBy = "idGadai", fetch = FetchType.LAZY)
    private List<Angsurangadai> angsurangadaiList;

    public Gadai() {
    }

    public Gadai(String idGadai) {
        this.idGadai = idGadai;
    }

    public String getIdGadai() {
        return idGadai;
    }

    public void setIdGadai(String idGadai) {
        this.idGadai = idGadai;
    }

    public Long getJmlPinjaman() {
        return jmlPinjaman;
    }

    public void setJmlPinjaman(Long jmlPinjaman) {
        this.jmlPinjaman = jmlPinjaman;
    }

    public Date getTglPengajuan() {
        return tglPengajuan;
    }

    public void setTglPengajuan(Date tglPengajuan) {
        this.tglPengajuan = tglPengajuan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSisa() {
        return sisa;
    }

    public void setSisa(Long sisa) {
        this.sisa = sisa;
    }

    public BrgGadai getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(BrgGadai idBarang) {
        this.idBarang = idBarang;
    }

    public Customer getIdCust() {
        return idCust;
    }

    public void setIdCust(Customer idCust) {
        this.idCust = idCust;
    }

    @XmlTransient
    public List<Angsurangadai> getAngsurangadaiList() {
        return angsurangadaiList;
    }

    public void setAngsurangadaiList(List<Angsurangadai> angsurangadaiList) {
        this.angsurangadaiList = angsurangadaiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGadai != null ? idGadai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gadai)) {
            return false;
        }
        Gadai other = (Gadai) object;
        if ((this.idGadai == null && other.idGadai != null) || (this.idGadai != null && !this.idGadai.equals(other.idGadai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idGadai + "";
    }
    
}
