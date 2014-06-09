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
@Table(name = "ZAZNAM_DARCU", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZaznamDarcu.findAll", query = "SELECT z FROM ZaznamDarcu z"),
    @NamedQuery(name = "ZaznamDarcu.findByIdZaznamDarcu", query = "SELECT z FROM ZaznamDarcu z WHERE z.idZaznamDarcu = :idZaznamDarcu"),
    @NamedQuery(name = "ZaznamDarcu.findByDatum", query = "SELECT z FROM ZaznamDarcu z WHERE z.datum = :datum"),
    @NamedQuery(name = "ZaznamDarcu.findByPoznamka", query = "SELECT z FROM ZaznamDarcu z WHERE z.poznamka = :poznamka")})
public class ZaznamDarcu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zaznam_darcu", nullable = false)
    private Integer idZaznamDarcu;
    
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    
    @Column(length = 100)
    private String poznamka;
    
    @JoinColumn(name = "id_darca", referencedColumnName = "id_user", nullable = false)
    @ManyToOne(optional = false)
    private Pouzivatelia idDarca;
    
    @JoinColumn(name = "id_lekar", referencedColumnName = "id_user", nullable = false)
    @ManyToOne(optional = false)
    private Pouzivatelia idLekar;

    public ZaznamDarcu() {
    }

    public ZaznamDarcu(Integer idZaznamDarcu) {
        this.idZaznamDarcu = idZaznamDarcu;
    }

    public ZaznamDarcu(Integer idZaznamDarcu, Date datum) {
        this.idZaznamDarcu = idZaznamDarcu;
        this.datum = datum;
    }

    public Integer getIdZaznamDarcu() {
        return idZaznamDarcu;
    }

    public void setIdZaznamDarcu(Integer idZaznamDarcu) {
        this.idZaznamDarcu = idZaznamDarcu;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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
        hash += (idZaznamDarcu != null ? idZaznamDarcu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZaznamDarcu)) {
            return false;
        }
        ZaznamDarcu other = (ZaznamDarcu) object;
        if ((this.idZaznamDarcu == null && other.idZaznamDarcu != null) || (this.idZaznamDarcu != null && !this.idZaznamDarcu.equals(other.idZaznamDarcu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.ZaznamDarcu[ idZaznamDarcu=" + idZaznamDarcu + " ]";
    }
    
}
