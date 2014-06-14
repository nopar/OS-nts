/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sprhib.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nox
 */
@Entity
@Table(name = "POUZIVATELIA", catalog = "nts_bakalarka", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pouzivatelia.findAll", query = "SELECT p FROM Pouzivatelia p"),
    @NamedQuery(name = "Pouzivatelia.findByIdUser", query = "SELECT p FROM Pouzivatelia p WHERE p.idUser = :idUser"),
    @NamedQuery(name = "Pouzivatelia.findByEmail", query = "SELECT p FROM Pouzivatelia p WHERE p.email = :email"),
    @NamedQuery(name = "Pouzivatelia.findByNick", query = "SELECT p FROM Pouzivatelia p WHERE p.nick = :nick"),
    @NamedQuery(name = "Pouzivatelia.findByPassword", query = "SELECT p FROM Pouzivatelia p WHERE p.password = :password"),
    @NamedQuery(name = "Pouzivatelia.findByMeno", query = "SELECT p FROM Pouzivatelia p WHERE p.meno = :meno"),
    @NamedQuery(name = "Pouzivatelia.findByPriezvisko", query = "SELECT p FROM Pouzivatelia p WHERE p.priezvisko = :priezvisko"),
    @NamedQuery(name = "Pouzivatelia.findByDatumNarodenia", query = "SELECT p FROM Pouzivatelia p WHERE p.datumNarodenia = :datumNarodenia"),
    @NamedQuery(name = "Pouzivatelia.findByTelKontakt", query = "SELECT p FROM Pouzivatelia p WHERE p.telKontakt = :telKontakt"),
    @NamedQuery(name = "Pouzivatelia.findByPohlavie", query = "SELECT p FROM Pouzivatelia p WHERE p.pohlavie = :pohlavie"),
    @NamedQuery(name = "Pouzivatelia.findByResetPasswd", query = "SELECT p FROM Pouzivatelia p WHERE p.resetPasswd = :resetPasswd")})
public class Pouzivatelia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    
    @Column(length = 45)
    private String email;
    
    @Column(length = 45)
    private String nick;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String password;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String meno;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String priezvisko;
    
    @Basic(optional = false)
    @Column(name = "datum_narodenia", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datumNarodenia;
    
    @Column(name = "tel_kontakt", length = 30)
    private String telKontakt;
    
    @Basic(optional = false)
    @Column(nullable = false)
    private Character pohlavie;
    
    @Column(name = "reset_passwd", length = 50)
    private String resetPasswd;
    
    @Basic(optional = true)
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    
    
    
    
    
    @ManyToMany(mappedBy = "pouzivateliaList")
    private List<Skupiny> skupinyList;
    @JoinTable(name = "ZOZNAM_NTS", joinColumns = {
        @JoinColumn(name = "id_lekar", referencedColumnName = "id_user", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_nts", referencedColumnName = "id_nts", nullable = false)})
    
    @ManyToMany
    private List<Nts> ntsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLekar")
    private List<VyjazdovyOdber> vyjazdovyOdberList;
   
    @JoinColumn(name = "id_adresa", referencedColumnName = "id_adresa", nullable = false)
    @ManyToOne(optional = false)
    private Adresa idAdresa;
    
    @JoinColumn(name = "id_krvna_skupina", referencedColumnName = "id_krvna_skupina", nullable = false)
    @ManyToOne(optional = false)
    private KrvnaSkupina idKrvnaSkupina;
   
    @JoinColumn(name = "id_nastavenie", referencedColumnName = "id_nastavenie", nullable = false)
    @ManyToOne(optional = false)
    private Nastavenie idNastavenie;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDarca")
    private List<Odber> odberList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLekar")
    private List<Odber> odberList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDarca")
    private List<ZaznamDarcu> zaznamDarcuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLekar")
    private List<ZaznamDarcu> zaznamDarcuList1;

    public Pouzivatelia() {
    }

    public Pouzivatelia(Integer idUser) {
        this.idUser = idUser;
    }

    public Pouzivatelia(Integer idUser, String password, String meno, String priezvisko, Date datumNarodenia, Character pohlavie, boolean enabled) {
        this.idUser = idUser;
        this.password = password;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.datumNarodenia = datumNarodenia;
        this.pohlavie = pohlavie;
        this.enabled = enabled;
    }

     public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public Date getDatumNarodenia() {
        return datumNarodenia;
    }

    public void setDatumNarodenia(Date datumNarodenia) {
        this.datumNarodenia = datumNarodenia;
    }

    public String getTelKontakt() {
        return telKontakt;
    }

    public void setTelKontakt(String telKontakt) {
        this.telKontakt = telKontakt;
    }

    public Character getPohlavie() {
        return pohlavie;
    }

    public void setPohlavie(Character pohlavie) {
        this.pohlavie = pohlavie;
    }

    public String getResetPasswd() {
        return resetPasswd;
    }

    public void setResetPasswd(String resetPasswd) {
        this.resetPasswd = resetPasswd;
    }

    @XmlTransient
    public List<Skupiny> getSkupinyList() {
        return skupinyList;
    }

    public void setSkupinyList(List<Skupiny> skupinyList) {
        this.skupinyList = skupinyList;
    }

    @XmlTransient
    public List<Nts> getNtsList() {
        return ntsList;
    }

    public void setNtsList(List<Nts> ntsList) {
        this.ntsList = ntsList;
    }

    @XmlTransient
    public List<VyjazdovyOdber> getVyjazdovyOdberList() {
        return vyjazdovyOdberList;
    }

    public void setVyjazdovyOdberList(List<VyjazdovyOdber> vyjazdovyOdberList) {
        this.vyjazdovyOdberList = vyjazdovyOdberList;
    }

    public Adresa getIdAdresa() {
        return idAdresa;
    }

    public void setIdAdresa(Adresa idAdresa) {
        this.idAdresa = idAdresa;
    }

    public KrvnaSkupina getIdKrvnaSkupina() {
        return idKrvnaSkupina;
    }

    public void setIdKrvnaSkupina(KrvnaSkupina idKrvnaSkupina) {
        this.idKrvnaSkupina = idKrvnaSkupina;
    }

    public Nastavenie getIdNastavenie() {
        return idNastavenie;
    }

    public void setIdNastavenie(Nastavenie idNastavenie) {
        this.idNastavenie = idNastavenie;
    }

    @XmlTransient
    public List<Odber> getOdberList() {
        return odberList;
    }

    public void setOdberList(List<Odber> odberList) {
        this.odberList = odberList;
    }

    @XmlTransient
    public List<Odber> getOdberList1() {
        return odberList1;
    }

    public void setOdberList1(List<Odber> odberList1) {
        this.odberList1 = odberList1;
    }

    @XmlTransient
    public List<ZaznamDarcu> getZaznamDarcuList() {
        return zaznamDarcuList;
    }

    public void setZaznamDarcuList(List<ZaznamDarcu> zaznamDarcuList) {
        this.zaznamDarcuList = zaznamDarcuList;
    }

    @XmlTransient
    public List<ZaznamDarcu> getZaznamDarcuList1() {
        return zaznamDarcuList1;
    }

    public void setZaznamDarcuList1(List<ZaznamDarcu> zaznamDarcuList1) {
        this.zaznamDarcuList1 = zaznamDarcuList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pouzivatelia)) {
            return false;
        }
        Pouzivatelia other = (Pouzivatelia) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sprhib.model.Pouzivatelia[ idUser=" + idUser + " ]";
    }
    
}
