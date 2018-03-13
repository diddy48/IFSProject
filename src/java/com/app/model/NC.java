/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
 * @author roman
 */
@Entity
@Table(name = "NC")
public class NC implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NumeroNC")
    private int numeroNC;

    @Column(name = "Titolo", nullable = false, length = 30)
    private String titolo;

    @Column(name = "Descrizione", nullable = false, length = 300)
    private String descrizione;

    @Column(name = "DataApertura", nullable = false)
    private Date dataA;

    @Column(name = "DataChiusura")
    private Date DataC;

    @Column(name = "Fase", nullable = false)
    private Enum fase;
    
    @Column(name = "Priorita", nullable = false)
    private Enum priorita;
    
    @Column(name = "CodiceProdotto", nullable = false, length=6)
    private int codiceProdotto;
    
    @Column(name = "CostoNC")
    private float costoNC;
    
    @Column(name = "RepartoProdotto", nullable = false)
    private Enum repartoP;
    
    @Column(name = "AContenimento", length = 300)
    private String aContenimento;

    @Column(name = "Cause", length = 300)
    private String cause;

    @Column(name = "ACorrettiva",  length = 300)
    private String aCorrettiva;

    @Column(name = "APreventiva", length = 300)
    private String aPreventiva;

    @Column(name = "IntesaComprensione",  length = 300)
    private String intesaComp;

     @Column(name = "Tipo", nullable = false)
    private Enum tipo;
     
      @Column(name = "Cliente", length=40)
    private String cliente;
      
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="matricola")
    private Dipendenti richiedente;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="matricola", nullable=false)
    private Dipendenti teamLeader;
}
