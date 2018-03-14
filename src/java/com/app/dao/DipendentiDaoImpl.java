/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.dao;
 
//import biblio.model.Utenti;
import com.app.model.Dipendenti;
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
 
@Transactional
@Repository("dipendentiDao")
public class DipendentiDaoImpl implements DipendentiDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public Dipendenti findById(int id) {
        return (Dipendenti) getSession().get(Dipendenti.class, id);
    }

    @Override
    public List<Dipendenti> findAll() {
        List<Dipendenti> l;
        Query q=getSession().createQuery("from Dipendenti");
        l=q.list(); 
      
        return l;
    }

 
}