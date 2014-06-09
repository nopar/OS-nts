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
@Table(name = "NASTAVENIE", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nastavenie.findAll", query = "SELECT n FROM Nastavenie n"),
    @NamedQuery(name = "Nastavenie.findByIdNastavenie", query = "SELECT n FROM Nastavenie n WHERE n.idNastavenie = :idNastavenie"),
    @NamedQuery(name = "Nastavenie.findByMojeOdbery", query = "SELECT n FROM Nastavenie n WHERE n.mojeOdbery = :mojeOdbery"),
    @NamedQuery(name = "Nastavenie.findByVyjazdoveOdbery", query = "SELECT n FROM Nastavenie n WHERE n.vyjazdoveOdbery = :vyjazdoveOdbery"),
    @NamedQuery(name = "Nastavenie.findByUrgentnePripady", query = "SELECT n FROM Nastavenie n WHERE n.urgentnePripady = :urgentnePripady"),
    @NamedQuery(name = "Nastavenie.findByKraj", query = "SELECT n FROM Nastavenie n WHERE n.kraj = :kraj")})
public class Nastavenie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nastavenie", nullable = false)
    private Integer idNastavenie;
    
    @Basic(optional = false)
    @Column(name = "moje_odbery", nullable = false)
    private boolean mojeOdbery;
    
    @Basic(optional = false)
    @Column(name = "vyjazdove_odbery", nullable = false)
    private boolean vyjazdoveOdbery;
    
    @Basic(optional = false)
    @Column(name = "urgentne_pripady", nullable = false)
    private boolean urgentnePripady;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean kraj;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNastavenie")
    private List<Pouzivatelia> pouzivateliaList;

    public Nastavenie() {
    }

    public Nastavenie(Integer idNastavenie) {
        this.idNastavenie = idNastavenie;
    }

    public Nastavenie(Integer idNastavenie, boolean mojeOdbery, boolean vyjazdoveOdbery, boolean urgentnePripady, boolean kraj) {
        this.idNastavenie = idNastavenie;
        this.mojeOdbery = mojeOdbery;
        this.vyjazdoveOdbery = vyjazdoveOdbery;
        this.urgentnePripady = urgentnePripady;
        this.kraj = kraj;
    }

    public Integer getIdNastavenie() {
        return idNastavenie;
    }

    public void setIdNastavenie(Integer idNastavenie) {
        this.idNastavenie = idNastavenie;
    }

    public boolean getMojeOdbery() {
        return mojeOdbery;
    }

    public void setMojeOdbery(boolean mojeOdbery) {
        this.mojeOdbery = mojeOdbery;
    }

    public boolean getVyjazdoveOdbery() {
        return vyjazdoveOdbery;
    }

    public void setVyjazdoveOdbery(boolean vyjazdoveOdbery) {
        this.vyjazdoveOdbery = vyjazdoveOdbery;
    }

    public boolean getUrgentnePripady() {
        return urgentnePripady;
    }

    public void setUrgentnePripady(boolean urgentnePripady) {
        this.urgentnePripady = urgentnePripady;
    }

    public boolean getKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
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
        hash += (idNastavenie != null ? idNastavenie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nastavenie)) {
            return false;
        }
        Nastavenie other = (Nastavenie) object;
        if ((this.idNastavenie == null && other.idNastavenie != null) || (this.idNastavenie != null && !this.idNastavenie.equals(other.idNastavenie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Nastavenie[ idNastavenie=" + idNastavenie + " ]";
    }
    
}
