/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\romano3927
 */
@Entity
@Table(name = "Responsabilita")
public class Responsabilita {
    
    class PKResponsabilita{
        @Column(name="Matricola", length=6)
        private int matricola;
        
        @Column(name="NumeroNC", length=5)
        private int numeroNC;
    }
    
    @EmbeddedId
    private PKResponsabilita pkResponsabilita;
    
    @Column(name="RuoloLavorita",length=40)
    private String ruoloLavorativo;
}
