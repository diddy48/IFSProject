/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.controller;

import com.app.dao.DipendentiDao;
import com.app.model.Dipendenti;
import com.app.service.DipendentiService;
//import com.app.service.NCService;
import java.util.List;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
 
@Controller
@RequestMapping("/")
@ComponentScan("com.app.service")
public class DipendentiController {
 
    @Autowired
    DipendentiService serviceDip;
    
    /*D@Autowired
    NCService  serviceNc;
    /*
     * This method will list all existing users.
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String listDipendenti(ModelMap model) {
        List<Dipendenti> dipendenti=serviceDip.findAll();
        model.addAttribute("dipendenti", dipendenti);
        return "dipendenti";
    }
    
    @RequestMapping(value="/showNC/{matricola}", method=RequestMethod.GET)
    public String listNC(@PathVariable("matricola") int matricola, ModelMap model){
        Dipendenti dipendente=serviceDip.findById(matricola);
        model.addAttribute("dipendente",dipendente);
        //model.addAttribute("ncResponsabile",serviceNc.findNCResponsabileById(matricola));
        model.addAttribute("ncReponsabile",dipendente.getNcResponsabile());
        model.addAttribute("ncLeader",dipendente.getNcLeader());
        model.addAttribute("ncMembro",dipendente.getNcAppartiene());
        model.addAttribute("ncRichiede",dipendente.getNcRichiede());
        return "nc";
    }
 
}
