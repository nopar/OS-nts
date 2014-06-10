/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sprhib.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ODBER", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odber.findAll", query = "SELECT o FROM Odber o"),
    @NamedQuery(name = "Odber.findByIdOdber", query = "SELECT o FROM Odber o WHERE o.idOdber = :idOdber"),
    @NamedQuery(name = "Odber.findByDatum", query = "SELECT o FROM Odber o WHERE o.datum = :datum"),
    @NamedQuery(name = "Odber.findByObjem", query = "SELECT o FROM Odber o WHERE o.objem = :objem"),
    @NamedQuery(name = "Odber.findByPoznamka", query = "SELECT o FROM Odber o WHERE o.poznamka = :poznamka")})
public class Odber implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_odber", nullable = false)
    private Integer idOdber;
    
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Basic(optional = false)
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal objem;
    
    @Column(length = 100)
    private String poznamka;
    
    @JoinColumn(name = "id_darca", referencedColumnName = "id_user", nullable = false)
    @ManyToOne(optional = false)
    private Pouzivatelia idDarca;
    
    @JoinColumn(name = "id_lekar", referencedColumnName = "id_user", nullable = false)
    @ManyToOne(optional = false)
    private Pouzivatelia idLekar;

    public Odber() {
    }

    public Odber(Integer idOdber) {
        this.idOdber = idOdber;
    }

    public Odber(Integer idOdber, Date datum, BigDecimal objem) {
        this.idOdber = idOdber;
        this.datum = datum;
        this.objem = objem;
    }

    public Integer getIdOdber() {
        return idOdber;
    }

    public void setIdOdber(Integer idOdber) {
        this.idOdber = idOdber;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigDecimal getObjem() {
        return objem;
    }

    public void setObjem(BigDecimal objem) {
        this.objem = objem;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }

    public Pouzivatelia getIdDarca() {
        return idDarca;
    }

    public void setIdDarca(Pouzivatelia idDarca) {
        this.idDarca = idDarca;
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
        hash += (idOdber != null ? idOdber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odber)) {
            return false;
        }
        Odber other = (Odber) object;
        if ((this.idOdber == null && other.idOdber != null) || (this.idOdber != null && !this.idOdber.equals(other.idOdber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Odber[ idOdber=" + idOdber + " ]";
    }

    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
