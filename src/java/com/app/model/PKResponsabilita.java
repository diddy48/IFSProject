/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author roman
 */
@Embeddable
public class PKResponsabilita implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "Matricola", nullable = false) //length=5
    private Dipendenti responsabile;

    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "NumeroNC", nullable = false) //length=6
    private NC nc;

    public PKResponsabilita() {
    }

    public Dipendenti getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(Dipendenti responsabile) {
        this.responsabile = responsabile;
    }

    public NC getNc() {
        return nc;
    }

    public void setNc(NC nc) {
        this.nc = nc;
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
        final PKResponsabilita other = (PKResponsabilita) obj;
        if (!Objects.equals(this.responsabile, other.responsabile)) {
            return false;
        }
        if (!Objects.equals(this.nc, other.nc)) {
            return false;
        }
        return true;
    }


    
}
