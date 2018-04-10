/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.model.Appartenere;
import com.app.model.Dipendenti;
import com.app.model.NC;
import com.app.model.Responsabilita;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roman
 */
@Transactional
@Repository("NCDao")
public class NCDaoImpl implements NCDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public NC findById(int id) {
        return (NC) getSession().get(NC.class, id);
    }

    /*
    public void saveEmployee(Employee employee) {
        getSession().persist(employee);
    }
 
    public void deleteEmployee(int id) {
        Employee e = (Employee) getSession().load(Employee.class, id);
	if(e!=null) getSession().delete(e);
    }
     */
    @Override
    public List<NC> findAll() {
        Criteria criteria = getSession().createCriteria(NC.class);
        return (List<NC>) criteria.list();
    }

    @Override
    public List<NC> findNCResponsabileById(int id) {
        List<NC> nc = new ArrayList<NC>();
        Criteria criteria1 = getSession().createCriteria(Dipendenti.class).add(Restrictions.eq("matricola", id));
        if(criteria1.list().isEmpty()) return nc;
        Dipendenti dipNC = (Dipendenti) criteria1.list().get(0);
        Criteria criteria2 = getSession().createCriteria(Responsabilita.class).add(Restrictions.eq("pkResponsabilita.responsabile", dipNC));
        List<Responsabilita> resp = criteria2.list();
        if(resp.isEmpty()) return nc;
        Criteria criteria3;
        for(Responsabilita r: resp){
            List<NC> lista =getSession().createCriteria(NC.class).add(Restrictions.eq("numeroNC", r.getNc().getNumeroNC())).list();
            if(!lista.isEmpty()){
                nc.add(lista.get(0));
            }
        }
        return nc;
    }

    @Override
    public List<NC> findNCAppartenereById(int id) {
        List<NC> nc = new ArrayList<NC>();
        Criteria criteria1 = getSession().createCriteria(Dipendenti.class).add(Restrictions.eq("matricola", id));
        if(criteria1.list().isEmpty()) return nc;
        Dipendenti dipNC = (Dipendenti) criteria1.list().get(0);
        Criteria criteria2 = getSession().createCriteria(Appartenere.class).add(Restrictions.eq("pkAppartenere.membro", dipNC));
        List<Appartenere> resp = criteria2.list();
        if(resp.isEmpty()) return nc;
        Criteria criteria3;
        for(Appartenere r: resp){
            List<NC> lista =getSession().createCriteria(NC.class).add(Restrictions.eq("numeroNC", r.getNc().getNumeroNC())).list();
            if(!lista.isEmpty()){
                nc.add(lista.get(0));
            }
        }
        return nc;
    }
}
