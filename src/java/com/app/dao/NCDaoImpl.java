/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.model.Dipendenti;
import com.app.model.NC;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roman
 */
@Transactional
@Repository("NCDao")
public class NCDaoImpl implements NCDao{
    @Autowired
    private SessionFactory sessionFactory;
 
    
    protected Session getSession(){
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

 
}
