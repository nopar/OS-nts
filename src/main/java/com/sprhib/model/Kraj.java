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
@Table(name = "KRAJ", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kraj.findAll", query = "SELECT k FROM Kraj k"),
    @NamedQuery(name = "Kraj.findByIdKraj", query = "SELECT k FROM Kraj k WHERE k.idKraj = :idKraj"),
    @NamedQuery(name = "Kraj.findByKraj", query = "SELECT k FROM Kraj k WHERE k.kraj = :kraj")})
public class Kraj implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_kraj", nullable = false)
    private Integer idKraj;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String kraj;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKraj")
    private List<VyjazdovyOdber> vyjazdovyOdberList;
    
    @JoinColumn(name = "id_stat", referencedColumnName = "id_stat", nullable = false)
    @ManyToOne(optional = false)
    private Stat idStat;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKraj")
    private List<Mesto> mestoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKraj")
    private List<Nts> ntsList;

    public Kraj() {
    }

    public Kraj(Integer idKraj) {
        this.idKraj = idKraj;
    }

    public Kraj(Integer idKraj, String kraj) {
        this.idKraj = idKraj;
        this.kraj = kraj;
    }

    public Integer getIdKraj() {
        return idKraj;
    }

    public void setIdKraj(Integer idKraj) {
        this.idKraj = idKraj;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    @XmlTransient
    public List<VyjazdovyOdber> getVyjazdovyOdberList() {
        return vyjazdovyOdberList;
    }

    public void setVyjazdovyOdberList(List<VyjazdovyOdber> vyjazdovyOdberList) {
        this.vyjazdovyOdberList = vyjazdovyOdberList;
    }

    public Stat getIdStat() {
        return idStat;
    }

    public void setIdStat(Stat idStat) {
        this.idStat = idStat;
    }

    @XmlTransient
    public List<Mesto> getMestoList() {
        return mestoList;
    }

    public void setMestoList(List<Mesto> mestoList) {
        this.mestoList = mestoList;
    }

    @XmlTransient
    public List<Nts> getNtsList() {
        return ntsList;
    }

    public void setNtsList(List<Nts> ntsList) {
        this.ntsList = ntsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKraj != null ? idKraj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kraj)) {
            return false;
        }
        Kraj other = (Kraj) object;
        if ((this.idKraj == null && other.idKraj != null) || (this.idKraj != null && !this.idKraj.equals(other.idKraj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Kraj[ idKraj=" + idKraj + " ]";
    }
    
}
