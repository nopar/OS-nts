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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "NTS", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nts.findAll", query = "SELECT n FROM Nts n"),
    @NamedQuery(name = "Nts.findByIdNts", query = "SELECT n FROM Nts n WHERE n.idNts = :idNts"),
    @NamedQuery(name = "Nts.findByMesto", query = "SELECT n FROM Nts n WHERE n.mesto = :mesto"),
    @NamedQuery(name = "Nts.findByAdresa", query = "SELECT n FROM Nts n WHERE n.adresa = :adresa"),
    @NamedQuery(name = "Nts.findByEmail", query = "SELECT n FROM Nts n WHERE n.email = :email"),
    @NamedQuery(name = "Nts.findByTelKontakt", query = "SELECT n FROM Nts n WHERE n.telKontakt = :telKontakt"),
    @NamedQuery(name = "Nts.findByAktivna", query = "SELECT n FROM Nts n WHERE n.aktivna = :aktivna")})
public class Nts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nts", nullable = false)
    private Integer idNts;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String mesto;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 35)
    private String adresa;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 25)
    private String email;
    
    @Basic(optional = false)
    @Column(name = "tel_kontakt", nullable = false, length = 30)
    private String telKontakt;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean aktivna;
    
    @ManyToMany(mappedBy = "ntsList")
    private List<Pouzivatelia> pouzivateliaList;
    
    @JoinColumn(name = "id_kraj", referencedColumnName = "id_kraj", nullable = false)
    @ManyToOne(optional = false)
    private Kraj idKraj;

    public Nts() {
    }

    public Nts(Integer idNts) {
        this.idNts = idNts;
    }

    public Nts(Integer idNts, String mesto, String adresa, String email, String telKontakt, boolean aktivna) {
        this.idNts = idNts;
        this.mesto = mesto;
        this.adresa = adresa;
        this.email = email;
        this.telKontakt = telKontakt;
        this.aktivna = aktivna;
    }

    public Integer getIdNts() {
        return idNts;
    }

    public void setIdNts(Integer idNts) {
        this.idNts = idNts;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelKontakt() {
        return telKontakt;
    }

    public void setTelKontakt(String telKontakt) {
        this.telKontakt = telKontakt;
    }

    public boolean getAktivna() {
        return aktivna;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    @XmlTransient
    public List<Pouzivatelia> getPouzivateliaList() {
        return pouzivateliaList;
    }

    public void setPouzivateliaList(List<Pouzivatelia> pouzivateliaList) {
        this.pouzivateliaList = pouzivateliaList;
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
        hash += (idNts != null ? idNts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nts)) {
            return false;
        }
        Nts other = (Nts) object;
        if ((this.idNts == null && other.idNts != null) || (this.idNts != null && !this.idNts.equals(other.idNts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Nts[ idNts=" + idNts + " ]";
    }
    
}
