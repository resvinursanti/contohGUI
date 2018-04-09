/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TAMU
 */
@Entity
@Table(name = "ANGSURANGADAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Angsurangadai.findAll", query = "SELECT a FROM Angsurangadai a")
    , @NamedQuery(name = "Angsurangadai.findByIdAngsuran", query = "SELECT a FROM Angsurangadai a WHERE a.idAngsuran = :idAngsuran")
    , @NamedQuery(name = "Angsurangadai.findByTglAngsur", query = "SELECT a FROM Angsurangadai a WHERE a.tglAngsur = :tglAngsur")
    , @NamedQuery(name = "Angsurangadai.findByJmlAngsur", query = "SELECT a FROM Angsurangadai a WHERE a.jmlAngsur = :jmlAngsur")
    , @NamedQuery(name = "Angsurangadai.findByDenda", query = "SELECT a FROM Angsurangadai a WHERE a.denda = :denda")})
public class Angsurangadai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ANGSURAN")
    private String idAngsuran;
    @Column(name = "TGL_ANGSUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglAngsur;
    @Column(name = "JML_ANGSUR")
    private Integer jmlAngsur;
    @Column(name = "DENDA")
    private Integer denda;
    @JoinColumn(name = "ID_CUST", referencedColumnName = "ID_CUST")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer idCust;
    @JoinColumn(name = "ID_GADAI", referencedColumnName = "ID_GADAI")
    @ManyToOne(fetch = FetchType.LAZY)
    private Gadai idGadai;

    public Angsurangadai() {
    }

    public Angsurangadai(String idAngsuran, Date tglAngsur, Integer jmlAngsur, Integer denda) {
        this.idAngsuran = idAngsuran;
        this.tglAngsur = tglAngsur;
        this.jmlAngsur = jmlAngsur;
        this.denda = denda;
    }

    
    public Angsurangadai(String idAngsuran) {
        this.idAngsuran = idAngsuran;
    }

    public String getIdAngsuran() {
        return idAngsuran;
    }

    public void setIdAngsuran(String idAngsuran) {
        this.idAngsuran = idAngsuran;
    }

    public Date getTglAngsur() {
        return tglAngsur;
    }

    public void setTglAngsur(Date tglAngsur) {
        this.tglAngsur = tglAngsur;
    }

    public Integer getJmlAngsur() {
        return jmlAngsur;
    }

    public void setJmlAngsur(Integer jmlAngsur) {
        this.jmlAngsur = jmlAngsur;
    }

    public Integer getDenda() {
        return denda;
    }

    public void setDenda(Integer denda) {
        this.denda = denda;
    }

    public Customer getIdCust() {
        return idCust;
    }

    public void setIdCust(Customer idCust) {
        this.idCust = idCust;
    }

    public Gadai getIdGadai() {
        return idGadai;
    }

    public void setIdGadai(Gadai idGadai) {
        this.idGadai = idGadai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAngsuran != null ? idAngsuran.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Angsurangadai)) {
            return false;
        }
        Angsurangadai other = (Angsurangadai) object;
        if ((this.idAngsuran == null && other.idAngsuran != null) || (this.idAngsuran != null && !this.idAngsuran.equals(other.idAngsuran))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idAngsuran + "";
    }
    
}
