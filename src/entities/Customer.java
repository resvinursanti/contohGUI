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
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByIdCust", query = "SELECT c FROM Customer c WHERE c.idCust = :idCust")
    , @NamedQuery(name = "Customer.findByNoKtp", query = "SELECT c FROM Customer c WHERE c.noKtp = :noKtp")
    , @NamedQuery(name = "Customer.findByNmCust", query = "SELECT c FROM Customer c WHERE c.nmCust = :nmCust")
    , @NamedQuery(name = "Customer.findByNoTelp", query = "SELECT c FROM Customer c WHERE c.noTelp = :noTelp")
    , @NamedQuery(name = "Customer.findByPekerjaan", query = "SELECT c FROM Customer c WHERE c.pekerjaan = :pekerjaan")
    , @NamedQuery(name = "Customer.findByAlamat", query = "SELECT c FROM Customer c WHERE c.alamat = :alamat")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CUST")
    private String idCust;
    @Column(name = "NO_KTP")
    private Integer noKtp;
    @Column(name = "NM_CUST")
    private String nmCust;
    @Column(name = "NO_TELP")
    private Integer noTelp;
    @Column(name = "PEKERJAAN")
    private String pekerjaan;
    @Column(name = "ALAMAT")
    private String alamat;
    @OneToMany(mappedBy = "idCust", fetch = FetchType.LAZY)
    private List<Gadai> gadaiList;
    @OneToMany(mappedBy = "idCust", fetch = FetchType.LAZY)
    private List<Angsurangadai> angsurangadaiList;

    public Customer() {
    }

    public Customer(String idCust) {
        this.idCust = idCust;
    }

    public String getIdCust() {
        return idCust;
    }

    public void setIdCust(String idCust) {
        this.idCust = idCust;
    }

    public Integer getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(Integer noKtp) {
        this.noKtp = noKtp;
    }

    public String getNmCust() {
        return nmCust;
    }

    public void setNmCust(String nmCust) {
        this.nmCust = nmCust;
    }

    public Integer getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(Integer noTelp) {
        this.noTelp = noTelp;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @XmlTransient
    public List<Gadai> getGadaiList() {
        return gadaiList;
    }

    public void setGadaiList(List<Gadai> gadaiList) {
        this.gadaiList = gadaiList;
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
        hash += (idCust != null ? idCust.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.idCust == null && other.idCust != null) || (this.idCust != null && !this.idCust.equals(other.idCust))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idCust + "";
    }
    
}
