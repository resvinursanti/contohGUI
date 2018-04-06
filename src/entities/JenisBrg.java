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
@Table(name = "JENIS_BRG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JenisBrg.findAll", query = "SELECT j FROM JenisBrg j")
    , @NamedQuery(name = "JenisBrg.findByIdJns", query = "SELECT j FROM JenisBrg j WHERE j.idJns = :idJns")
    , @NamedQuery(name = "JenisBrg.findByNmJns", query = "SELECT j FROM JenisBrg j WHERE j.nmJns = :nmJns")})
public class JenisBrg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_JNS")
    private String idJns;
    @Column(name = "NM_JNS")
    private String nmJns;
    @OneToMany(mappedBy = "idJns", fetch = FetchType.LAZY)
    private List<BrgGadai> brgGadaiList;

    public JenisBrg() {
    }

    public JenisBrg(String idJns) {
        this.idJns = idJns;
    }

    public String getIdJns() {
        return idJns;
    }

    public void setIdJns(String idJns) {
        this.idJns = idJns;
    }

    public String getNmJns() {
        return nmJns;
    }

    public void setNmJns(String nmJns) {
        this.nmJns = nmJns;
    }

    @XmlTransient
    public List<BrgGadai> getBrgGadaiList() {
        return brgGadaiList;
    }

    public void setBrgGadaiList(List<BrgGadai> brgGadaiList) {
        this.brgGadaiList = brgGadaiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJns != null ? idJns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JenisBrg)) {
            return false;
        }
        JenisBrg other = (JenisBrg) object;
        if ((this.idJns == null && other.idJns != null) || (this.idJns != null && !this.idJns.equals(other.idJns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + idJns + "";
    }
    
}
