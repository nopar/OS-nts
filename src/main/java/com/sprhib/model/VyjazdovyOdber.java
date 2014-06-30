/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sprhib.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author nox
 */
@Entity
@Table(name = "VYJAZDOVY_ODBER", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VyjazdovyOdber.findAll", query = "SELECT v FROM VyjazdovyOdber v"),
    @NamedQuery(name = "VyjazdovyOdber.findByIdVyjazdovyOdber", query = "SELECT v FROM VyjazdovyOdber v WHERE v.idVyjazdovyOdber = :idVyjazdovyOdber"),
    @NamedQuery(name = "VyjazdovyOdber.findByNazov", query = "SELECT v FROM VyjazdovyOdber v WHERE v.nazov = :nazov"),
    @NamedQuery(name = "VyjazdovyOdber.findByDatum", query = "SELECT v FROM VyjazdovyOdber v WHERE v.datum = :datum"),
    @NamedQuery(name = "VyjazdovyOdber.findByAdresa", query = "SELECT v FROM VyjazdovyOdber v WHERE v.adresa = :adresa"),
    @NamedQuery(name = "VyjazdovyOdber.findByCasZaciatku", query = "SELECT v FROM VyjazdovyOdber v WHERE v.casZaciatku = :casZaciatku"),
    @NamedQuery(name = "VyjazdovyOdber.findByCasKonca", query = "SELECT v FROM VyjazdovyOdber v WHERE v.casKonca = :casKonca"),
    @NamedQuery(name = "VyjazdovyOdber.findByBlizsiPopis", query = "SELECT v FROM VyjazdovyOdber v WHERE v.blizsiPopis = :blizsiPopis")})
public class VyjazdovyOdber implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vyjazdovy_odber", nullable = false)
    private Integer idVyjazdovyOdber;
    @Basic(optional = false)
    @Column(nullable = false, length = 25)
    private String nazov;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @Column(nullable = false, length = 35)
    private String adresa;
    
    @Basic(optional = false)
    @Column(name = "cas_zaciatku", nullable = false)
    private String casZaciatku;
    
    @Basic(optional = false)
    @Column(name = "cas_konca", nullable = false)
    private String casKonca;
    
    @Column(name = "blizsi_popis", length = 255)
    private String blizsiPopis;
    
    @JoinColumn(name = "id_kraj", referencedColumnName = "id_kraj", nullable = false)
    @ManyToOne(optional = false)
    private Kraj idKraj;
    
    @JoinColumn(name = "id_lekar", referencedColumnName = "id_user", nullable = false)
    @ManyToOne(optional = false)
    private Pouzivatelia idLekar;

    public VyjazdovyOdber() {
    }

    public VyjazdovyOdber(Integer idVyjazdovyOdber) {
        this.idVyjazdovyOdber = idVyjazdovyOdber;
    }

    public VyjazdovyOdber(Integer idVyjazdovyOdber, String nazov, Date datum, String adresa, String casZaciatku, String casKonca) {
        this.idVyjazdovyOdber = idVyjazdovyOdber;
        this.nazov = nazov;
        this.datum = datum;
        this.adresa = adresa;
        this.casZaciatku = casZaciatku;
        this.casKonca = casKonca;
    }

    public Integer getIdVyjazdovyOdber() {
        return idVyjazdovyOdber;
    }

    public void setIdVyjazdovyOdber(Integer idVyjazdovyOdber) {
        this.idVyjazdovyOdber = idVyjazdovyOdber;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getCasZaciatku() {
        return casZaciatku;
    }

    public void setCasZaciatku(String casZaciatku) {
        this.casZaciatku = casZaciatku;
    }

    public String getCasKonca() {
        return casKonca;
    }

    public void setCasKonca(String casKonca) {
        this.casKonca = casKonca;
    }

    public String getBlizsiPopis() {
        return blizsiPopis;
    }

    public void setBlizsiPopis(String blizsiPopis) {
        this.blizsiPopis = blizsiPopis;
    }

    public Kraj getIdKraj() {
        return idKraj;
    }

    public void setIdKraj(Kraj idKraj) {
        this.idKraj = idKraj;
    }

    public Pouzivatelia getIdLekar() {
        return idLekar;
    }

    public void setIdLekar(Pouzivatelia idLekar) {
        this.idLekar = idLekar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVyjazdovyOdber != null ? idVyjazdovyOdber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VyjazdovyOdber)) {
            return false;
        }
        VyjazdovyOdber other = (VyjazdovyOdber) object;
        if ((this.idVyjazdovyOdber == null && other.idVyjazdovyOdber != null) || (this.idVyjazdovyOdber != null && !this.idVyjazdovyOdber.equals(other.idVyjazdovyOdber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.VyjazdovyOdber[ idVyjazdovyOdber=" + idVyjazdovyOdber + " ]";
    }
    
}
