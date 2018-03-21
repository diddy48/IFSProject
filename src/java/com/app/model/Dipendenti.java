/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author romano3927
 */
@Entity
@Table(name="Dipendenti")
public class Dipendenti implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Matricola")
    private int matricola;
    
    @Column(name = "CF", nullable = false, length = 16)
    private String cf;
    
    @Column(name = "Nome", nullable = false, length = 30)
    private String nome;
    
    @Column(name = "Cognome", nullable = false, length = 30)
    private String cognome;
    
    @Column(name = "DataNascita", nullable = false)
    private Date dataNascita;
    
    @Column(name = "Ruolo", nullable = false, length = 20)
    private String ruolo;
    
    @Column(name = "Mail", nullable = false, length = 35)
    private String mail;
    
    @Column(name = "Password", nullable = false, length = 30)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="teamLeader")
    private Set<NC> ncLeader = new HashSet();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="richiedente")
    private Set<NC> ncRichiede = new HashSet();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="pkAppartenere.membro", cascade = CascadeType.ALL)
    private Set<NC> ncAppartiene = new HashSet();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="pkResponsabilita.responsabile", cascade = CascadeType.ALL)
    private Set<NC> ncResponsabile = new HashSet();
    
    public Dipendenti() {
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<NC> getNcLeader() {
        return ncLeader;
    }

    public void setNcLeader(Set<NC> ncLeader) {
        this.ncLeader = ncLeader;
    }

    public Set<NC> getNcRichiede() {
        return ncRichiede;
    }

    public void setNcRichiede(Set<NC> ncRichiede) {
        this.ncRichiede = ncRichiede;
    }

    public Set<NC> getNcAppartiene() {
        return ncAppartiene;
    }

    public void setNcAppartiene(Set<NC> ncAppartiene) {
        this.ncAppartiene = ncAppartiene;
    }

    public Set<NC> getNcResponsabile() {
        return ncResponsabile;
    }

    public void setNcResponsabile(Set<NC> ncResponsabile) {
        this.ncResponsabile = ncResponsabile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.matricola;
        hash = 97 * hash + Objects.hashCode(this.cf);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cognome);
        hash = 97 * hash + Objects.hashCode(this.dataNascita);
        hash = 97 * hash + Objects.hashCode(this.ruolo);
        hash = 97 * hash + Objects.hashCode(this.mail);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.ncLeader);
        hash = 97 * hash + Objects.hashCode(this.ncRichiede);
        hash = 97 * hash + Objects.hashCode(this.ncAppartiene);
        hash = 97 * hash + Objects.hashCode(this.ncResponsabile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dipendenti other = (Dipendenti) obj;
        if (this.matricola != other.matricola) {
            return false;
        }
        if (!Objects.equals(this.cf, other.cf)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.ruolo, other.ruolo)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.dataNascita, other.dataNascita)) {
            return false;
        }
        if (!Objects.equals(this.ncLeader, other.ncLeader)) {
            return false;
        }
        if (!Objects.equals(this.ncRichiede, other.ncRichiede)) {
            return false;
        }
        if (!Objects.equals(this.ncAppartiene, other.ncAppartiene)) {
            return false;
        }
        if (!Objects.equals(this.ncResponsabile, other.ncResponsabile)) {
            return false;
        }
        return true;
    }
    
    
}
