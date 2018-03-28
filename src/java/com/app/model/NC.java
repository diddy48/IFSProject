/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.objects.Priorita;
import com.app.objects.RepartoProdotto;
import com.app.objects.Tipo;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Priorita", nullable = false)
    private Priorita priorita;
    
    @Column(name = "CodiceProdotto", nullable = false, length=6)
    private Integer codiceProdotto;
    
    @Column(name = "CostoNC")
    private Float costoNC;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "RepartoProdotto", nullable = false)
    private RepartoProdotto repartoP;
    
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

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo", nullable = false)
    private Tipo tipo;
     
    @Column(name = "Cliente", length=40)
    private String cliente;
      
    @ManyToOne(fetch= LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="Richiedente")
    private Dipendenti richiedente;
    
    @ManyToOne(fetch= LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="TeamLeader", nullable=false)
    private Dipendenti teamLeader;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="pkAppartenere.nc",cascade = CascadeType.ALL)
    private Set<Appartenere> membri = new HashSet();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="pkResponsabilita.nc", cascade = CascadeType.ALL)
    private Set<Responsabilita> responsabili  = new HashSet();

    public NC() {
    }
    
    public int getNumeroNC() {
        return numeroNC;
    }

    public void setNumeroNC(int numeroNC) {
        this.numeroNC = numeroNC;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataA() {
        return dataA;
    }

    public void setDataA(Date dataA) {
        this.dataA = dataA;
    }

    public Date getDataC() {
        return DataC;
    }

    public void setDataC(Date DataC) {
        this.DataC = DataC;
    }

    public Priorita getPriorita() {
        return priorita;
    }

    public void setPriorita(Priorita priorita) {
        this.priorita = priorita;
    }

    public Integer getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(Integer codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    public Float getCostoNC() {
        return costoNC;
    }

    public void setCostoNC(Float costoNC) {
        this.costoNC = costoNC;
    }

    public RepartoProdotto getRepartoP() {
        return repartoP;
    }

    public void setRepartoP(RepartoProdotto repartoP) {
        this.repartoP = repartoP;
    }

    public String getaContenimento() {
        return aContenimento;
    }

    public void setaContenimento(String aContenimento) {
        this.aContenimento = aContenimento;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getaCorrettiva() {
        return aCorrettiva;
    }

    public void setaCorrettiva(String aCorrettiva) {
        this.aCorrettiva = aCorrettiva;
    }

    public String getaPreventiva() {
        return aPreventiva;
    }

    public void setaPreventiva(String aPreventiva) {
        this.aPreventiva = aPreventiva;
    }

    public String getIntesaComp() {
        return intesaComp;
    }

    public void setIntesaComp(String intesaComp) {
        this.intesaComp = intesaComp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Dipendenti getRichiedente() {
        return richiedente;
    }

    public void setRichiedente(Dipendenti richiedente) {
        this.richiedente = richiedente;
    }

    public Dipendenti getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Dipendenti teamLeader) {
        this.teamLeader = teamLeader;
    }

    public Set<Appartenere> getMembri() {
        return membri;
    }

    public void setMembri(Set<Appartenere> membri) {
        this.membri = membri;
    }

    public Set<Responsabilita> getResponsabili() {
        return responsabili;
    }

    public void setResponsabili(Set<Responsabilita> responsabili) {
        this.responsabili = responsabili;
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
        final NC other = (NC) obj;
        if (this.numeroNC != other.numeroNC) {
            return false;
        }
        if (this.codiceProdotto != other.codiceProdotto) {
            return false;
        }
        if (Float.floatToIntBits(this.costoNC) != Float.floatToIntBits(other.costoNC)) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.aContenimento, other.aContenimento)) {
            return false;
        }
        if (!Objects.equals(this.cause, other.cause)) {
            return false;
        }
        if (!Objects.equals(this.aCorrettiva, other.aCorrettiva)) {
            return false;
        }
        if (!Objects.equals(this.aPreventiva, other.aPreventiva)) {
            return false;
        }
        if (!Objects.equals(this.intesaComp, other.intesaComp)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.dataA, other.dataA)) {
            return false;
        }
        if (!Objects.equals(this.DataC, other.DataC)) {
            return false;
        }
        if (this.priorita != other.priorita) {
            return false;
        }
        if (this.repartoP != other.repartoP) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.richiedente, other.richiedente)) {
            return false;
        }
        if (!Objects.equals(this.teamLeader, other.teamLeader)) {
            return false;
        }
        if (!Objects.equals(this.membri, other.membri)) {
            return false;
        }
        if (!Objects.equals(this.responsabili, other.responsabili)) {
            return false;
        }
        return true;
    }
    
}
