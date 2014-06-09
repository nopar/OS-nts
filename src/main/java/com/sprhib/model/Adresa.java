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
@Table(name = "ADRESA", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a"),
    @NamedQuery(name = "Adresa.findByIdAdresa", query = "SELECT a FROM Adresa a WHERE a.idAdresa = :idAdresa"),
    @NamedQuery(name = "Adresa.findByUlica", query = "SELECT a FROM Adresa a WHERE a.ulica = :ulica"),
    @NamedQuery(name = "Adresa.findByCisloDomu", query = "SELECT a FROM Adresa a WHERE a.cisloDomu = :cisloDomu")})
public class Adresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adresa", nullable = false)
    private Integer idAdresa;
    @Column(length = 20)
    private String ulica;
    @Basic(optional = false)
    @Column(name = "cislo_domu", nullable = false, length = 5)
    private String cisloDomu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdresa")
    private List<Pouzivatelia> pouzivateliaList;
    @JoinColumn(name = "id_mesto", referencedColumnName = "id_mesto", nullable = false)
    @ManyToOne(optional = false)
    private Mesto idMesto;

    public Adresa() {
    }

    public Adresa(Integer idAdresa) {
        this.idAdresa = idAdresa;
    }

    public Adresa(Integer idAdresa, String cisloDomu) {
        this.idAdresa = idAdresa;
        this.cisloDomu = cisloDomu;
    }

    public Integer getIdAdresa() {
        return idAdresa;
    }

    public void setIdAdresa(Integer idAdresa) {
        this.idAdresa = idAdresa;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getCisloDomu() {
        return cisloDomu;
    }

    public void setCisloDomu(String cisloDomu) {
        this.cisloDomu = cisloDomu;
    }

    @XmlTransient
    public List<Pouzivatelia> getPouzivateliaList() {
        return pouzivateliaList;
    }

    public void setPouzivateliaList(List<Pouzivatelia> pouzivateliaList) {
        this.pouzivateliaList = pouzivateliaList;
    }

    public Mesto getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(Mesto idMesto) {
        this.idMesto = idMesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdresa != null ? idAdresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.idAdresa == null && other.idAdresa != null) || (this.idAdresa != null && !this.idAdresa.equals(other.idAdresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Adresa[ idAdresa=" + idAdresa + " ]";
    }
    
}
