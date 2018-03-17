/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;
 
import java.util.List;
 
import com.app.model.Dipendenti;
 
public interface DipendentiService {
    Dipendenti findById(int id);
    /*void saveDipedenti(Dipendenti dip);
    void updateDipedenti(Dipendenti dip);
    void deleteDipendenti(int id);*/
    List<Dipendenti> findAll(); 
}