/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.model.NC;
import com.app.model.Responsabilita;
import java.util.List;
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
        /*List<Dipendenti> l;
        Query q=getSession().createQuery("from Dipendenti");
        l=q.list(); 
      
        return l;*/
        Criteria criteria = getSession().createCriteria(NC.class);
        return (List<NC>) criteria.list();
    }

    @Override
    public List<NC> findNCResponsabileById(int id) {
        /*List<NC> l;
        Query q=getSession().createQuery("from Responsabilita r,NC nc"
                + "where r.NumeroNC=nc.NumeroNC AND "
                + "r.Matricola="+id);
        l=q.list(); 
        return l;*/
        SQLQuery query = getSession().createSQLQuery("select"
                + " nc.`NumeroNC`, `Titolo`, `Descrizione`, `DataApertura`, `DataChiusura`, `Priorita`, `CodiceProdotto`, `CostoNC`, `RepartoProdotto`, `AContenimento`, `Cause`, `ACorrettiva`, `APreventiva`, `IntesaComprensione`, `Tipo`, `Cliente`, `Richiedente`, `TeamLeader`"
                + " from Responsabilita r,NC nc "
                + "where r.NumeroNC=nc.NumeroNC AND "
                + "r.Matricola= :matricola ");
        query.addEntity(NC.class).addEntity(Responsabilita.class);
        query.setParameter("matricola", id);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        return query.list();
        //return null;
        /*Criteria criteria = getSession().createCriteria(NC.class,"nc").createAlias("nc.responsabili", "responsabili").add(Restrictions.eq("responsabili.pkResponsabilita.responsabile", id));
        return criteria.list();*/
    }

}
