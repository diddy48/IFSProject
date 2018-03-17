/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\romano3927
 */
@Entity
@Table(name = "Appartenere")
public class Appartenere {
    
    class PKAppartenere{
        @Column(name="Matricola", length=5)
        private int matricola;
        
        @Column(name="NumeroNC", length=6)
        private int numeroNC;
    }
    
    @EmbeddedId
    private PKAppartenere pkAppartenere;
    
    @Column(name="Ruolo",length=50)
    private String ruolo;
}
