/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.util.Objects;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@AssociationOverrides({
    @AssociationOverride(name = "pkAppartenere.membro",
        joinColumns =@JoinColumn(name = "Matricola")),
    @AssociationOverride(name = "pkAppartenere.nc",
        joinColumns =@JoinColumn(name = "NumeroNC")) })
public class Appartenere {
    
    @EmbeddedId
    private PKAppartenere pkAppartenere = new PKAppartenere();
    
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
