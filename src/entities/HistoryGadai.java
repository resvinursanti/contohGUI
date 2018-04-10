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
 * @author Evi
 */
@Entity
@Table(name = "HISTORY_GADAI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryGadai.findAll", query = "SELECT h FROM HistoryGadai h")
    , @NamedQuery(name = "HistoryGadai.findByIdHistorygadai", query = "SELECT h FROM HistoryGadai h WHERE h.idHistorygadai = :idHistorygadai")
    , @NamedQuery(name = "HistoryGadai.findByStatus", query = "SELECT h FROM HistoryGadai h WHERE h.status = :status")})
public class HistoryGadai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_HISTORYGADAI")
    private String idHistorygadai;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(mappedBy = "idHistorygadai", fetch = FetchType.LAZY)
    private List<Gadai> gadaiList;

    public HistoryGadai() {
    }

    public HistoryGadai(String idHistorygadai) {
        this.idHistorygadai = idHistorygadai;
    }

    public String getIdHistorygadai() {
        return idHistorygadai;
    }

    public void setIdHistorygadai(String idHistorygadai) {
        this.idHistorygadai = idHistorygadai;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Gadai> getGadaiList() {
        return gadaiList;
    }

    public void setGadaiList(List<Gadai> gadaiList) {
        this.gadaiList = gadaiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorygadai != null ? idHistorygadai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryGadai)) {
            return false;
        }
        HistoryGadai other = (HistoryGadai) object;
        if ((this.idHistorygadai == null && other.idHistorygadai != null) || (this.idHistorygadai != null && !this.idHistorygadai.equals(other.idHistorygadai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HistoryGadai[ idHistorygadai=" + idHistorygadai + " ]";
    }
    
}
