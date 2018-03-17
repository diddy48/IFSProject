/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\romano3927
 */
@Entity
@Table(name = "Appartenere")
public class Appartenere {
    
    class PKAppartenere{
        @ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="Matricola", nullable=false) //length = 6
        private Dipendenti membro;
        
        @ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="NumeroNC", nullable=false)//length = 5
        private NC nc;

        public Dipendenti getMembro() {
            return membro;
        }

        public void setMembro(Dipendenti membro) {
            this.membro = membro;
        }

        public NC getNc() {
            return nc;
        }

        public void setNc(NC nc) {
            this.nc = nc;
        }
        
    }
    
    @EmbeddedId
    private PKAppartenere pkAppartenere;
    
    @Column(name="Ruolo",length=50)
    private String ruolo;

    public Appartenere() {
    }
    
    public PKAppartenere getPkAppartenere() {
        return pkAppartenere;
    }

    public void setPkAppartenere(PKAppartenere pkAppartenere) {
        this.pkAppartenere = pkAppartenere;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.pkAppartenere);
        hash = 47 * hash + Objects.hashCode(this.ruolo);
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
        final Appartenere other = (Appartenere) obj;
        if (!Objects.equals(this.ruolo, other.ruolo)) {
            return false;
        }
        if (!Objects.equals(this.pkAppartenere, other.pkAppartenere)) {
            return false;
        }
        return true;
    }
    
}
