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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\romano3927
 */
@Entity
@Table(name = "Responsabilita")
public class Responsabilita {

    class PKResponsabilita {

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "Matricola", nullable = false) //length=5
        private Dipendenti resonsabile;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "NumeroNC", nullable = false) //length=6
        private NC nc;

        public Dipendenti getResonsabile() {
            return resonsabile;
        }

        public void setResonsabile(Dipendenti resonsabile) {
            this.resonsabile = resonsabile;
        }

        public NC getNc() {
            return nc;
        }

        public void setNc(NC nc) {
            this.nc = nc;
        }

    }

    @EmbeddedId
    private PKResponsabilita pkResponsabilita;

    @Column(name = "RepartoLavorativo", length = 40)
    private String repartoLavorativo;

    public Responsabilita() {
    }

    public PKResponsabilita getPkResponsabilita() {
        return pkResponsabilita;
    }

    public void setPkResponsabilita(PKResponsabilita pkResponsabilita) {
        this.pkResponsabilita = pkResponsabilita;
    }

    public String getRepartoLavorativo() {
        return repartoLavorativo;
    }

    public void setRepartoLavorativo(String repartoLavorativo) {
        this.repartoLavorativo = repartoLavorativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.pkResponsabilita);
        hash = 47 * hash + Objects.hashCode(this.repartoLavorativo);
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
        final Responsabilita other = (Responsabilita) obj;
        if (!Objects.equals(this.repartoLavorativo, other.repartoLavorativo)) {
            return false;
        }
        if (!Objects.equals(this.pkResponsabilita, other.pkResponsabilita)) {
            return false;
        }
        return true;
    }

}
