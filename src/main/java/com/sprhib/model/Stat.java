/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sprhib.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nox
 */
@Entity
@Table(name = "STAT", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
public class Stat implements Serializable {
   // private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stat", nullable = false)
    private Integer idStat;
    
    @Basic(optional = false)
    @Column(name = "stat", nullable = false, length = 30)
    private String stat;
    
    @Basic(optional = false)
    @Column(name = "skratka", nullable = false, length = 4)
    private String skratka;

    public Stat() {
    }

    public Stat(Integer idStat) {
        this.idStat = idStat;
    }

    public Stat(Integer idStat, String stat, String skratka) {
        this.idStat = idStat;
        this.stat = stat;
        this.skratka = skratka;
    }

    public Integer getIdStat() {
        return idStat;
    }

    public void setIdStat(Integer idStat) {
        this.idStat = idStat;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getSkratka() {
        return skratka;
    }

    public void setSkratka(String skratka) {
        this.skratka = skratka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStat != null ? idStat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stat)) {
            return false;
        }
        Stat other = (Stat) object;
        if ((this.idStat == null && other.idStat != null) || (this.idStat != null && !this.idStat.equals(other.idStat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Stat[ idStat=" + idStat + " ]";
    }
    
}
