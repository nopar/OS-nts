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
 * @author nox
 */
@Entity
@Table(name = "MESTO", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesto.findAll", query = "SELECT m FROM Mesto m"),
    @NamedQuery(name = "Mesto.findByIdMesto", query = "SELECT m FROM Mesto m WHERE m.idMesto = :idMesto"),
    @NamedQuery(name = "Mesto.findByMesto", query = "SELECT m FROM Mesto m WHERE m.mesto = :mesto"),
    @NamedQuery(name = "Mesto.findByPsc", query = "SELECT m FROM Mesto m WHERE m.psc = :psc")})
public class Mesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mesto", nullable = false)
    private Integer idMesto;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 35)
    private String mesto;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 5)
    private String psc;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMesto")
    private List<Adresa> adresaList;
    
    @JoinColumn(name = "id_kraj", referencedColumnName = "id_kraj", nullable = false)
    @ManyToOne(optional = false)
    private Kraj idKraj;

    public Mesto() {
    }

    public Mesto(Integer idMesto) {
        this.idMesto = idMesto;
    }

    public Mesto(Integer idMesto, String mesto, String psc) {
        this.idMesto = idMesto;
        this.mesto = mesto;
        this.psc = psc;
    }

    public Integer getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(Integer idMesto) {
        this.idMesto = idMesto;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    @XmlTransient
    public List<Adresa> getAdresaList() {
        return adresaList;
    }

    public void setAdresaList(List<Adresa> adresaList) {
        this.adresaList = adresaList;
    }

    public Kraj getIdKraj() {
        return idKraj;
    }

    public void setIdKraj(Kraj idKraj) {
        this.idKraj = idKraj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesto != null ? idMesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesto)) {
            return false;
        }
        Mesto other = (Mesto) object;
        if ((this.idMesto == null && other.idMesto != null) || (this.idMesto != null && !this.idMesto.equals(other.idMesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Mesto[ idMesto=" + idMesto + " ]";
    }
    
}
