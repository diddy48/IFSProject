/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author FSEVERI\romano3927
 */
@Entity
@Table(name = "Responsabilita")
public class Responsabilita {
    
    @Id @GeneratedValue
    private int id;
}
