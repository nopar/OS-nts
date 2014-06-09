/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sprhib.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nox
 */
@Entity
@Table(name = "KRVNA_SKUPINA", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KrvnaSkupina.findAll", query = "SELECT k FROM KrvnaSkupina k"),
    @NamedQuery(name = "KrvnaSkupina.findByIdKrvnaSkupina", query = "SELECT k FROM KrvnaSkupina k WHERE k.idKrvnaSkupina = :idKrvnaSkupina"),
    @NamedQuery(name = "KrvnaSkupina.findByTypKrvi", query = "SELECT k FROM KrvnaSkupina k WHERE k.typKrvi = :typKrvi")})
public class KrvnaSkupina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_krvna_skupina", nullable = false)
    private Integer idKrvnaSkupina;
    
    @Basic(optional = false)
    @Column(name = "typ_krvi", nullable = false, length = 3)
    private String typKrvi;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKrvnaSkupina")
    private List<Pouzivatelia> pouzivateliaList;

    public KrvnaSkupina() {
    }

    public KrvnaSkupina(Integer idKrvnaSkupina) {
        this.idKrvnaSkupina = idKrvnaSkupina;
    }

    public KrvnaSkupina(Integer idKrvnaSkupina, String typKrvi) {
        this.idKrvnaSkupina = idKrvnaSkupina;
        this.typKrvi = typKrvi;
    }

    public Integer getIdKrvnaSkupina() {
        return idKrvnaSkupina;
    }

    public void setIdKrvnaSkupina(Integer idKrvnaSkupina) {
        this.idKrvnaSkupina = idKrvnaSkupina;
    }

    public String getTypKrvi() {
        return typKrvi;
    }

    public void setTypKrvi(String typKrvi) {
        this.typKrvi = typKrvi;
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
        hash += (idKrvnaSkupina != null ? idKrvnaSkupina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KrvnaSkupina)) {
            return false;
        }
        KrvnaSkupina other = (KrvnaSkupina) object;
        if ((this.idKrvnaSkupina == null && other.idKrvnaSkupina != null) || (this.idKrvnaSkupina != null && !this.idKrvnaSkupina.equals(other.idKrvnaSkupina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.KrvnaSkupina[ idKrvnaSkupina=" + idKrvnaSkupina + " ]";
    }
    
}
