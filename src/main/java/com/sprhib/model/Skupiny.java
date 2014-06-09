/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sprhib.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nox
 */
@Entity
@Table(name = "SKUPINY", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skupiny.findAll", query = "SELECT s FROM Skupiny s"),
    @NamedQuery(name = "Skupiny.findByIdGroup", query = "SELECT s FROM Skupiny s WHERE s.idGroup = :idGroup"),
    @NamedQuery(name = "Skupiny.findByAutorita", query = "SELECT s FROM Skupiny s WHERE s.autorita = :autorita"),
    @NamedQuery(name = "Skupiny.findBySpecialne", query = "SELECT s FROM Skupiny s WHERE s.specialne = :specialne")})
public class Skupiny implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_group", nullable = false)
    private Integer idGroup;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String autorita;
    private Integer specialne;
    
    @JoinTable(name = "ZOZNAM_POUZIVATEL_SKUPINA", joinColumns = {
        @JoinColumn(name = "id_group", referencedColumnName = "id_group", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)})
    
    @ManyToMany
    private List<Pouzivatelia> pouzivateliaList;

    public Skupiny() {
    }

    public Skupiny(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public Skupiny(Integer idGroup, String autorita) {
        this.idGroup = idGroup;
        this.autorita = autorita;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getAutorita() {
        return autorita;
    }

    public void setAutorita(String autorita) {
        this.autorita = autorita;
    }

    public Integer getSpecialne() {
        return specialne;
    }

    public void setSpecialne(Integer specialne) {
        this.specialne = specialne;
    }

    @XmlTransient
    public List<Pouzivatelia> getPouzivateliaList() {
        return pouzivateliaList;
    }

    public void setPouzivateliaList(List<Pouzivatelia> pouzivateliaList) {
        this.pouzivateliaList = pouzivateliaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroup != null ? idGroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skupiny)) {
            return false;
        }
        Skupiny other = (Skupiny) object;
        if ((this.idGroup == null && other.idGroup != null) || (this.idGroup != null && !this.idGroup.equals(other.idGroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Skupiny[ idGroup=" + idGroup + " ]";
    }
    
}
