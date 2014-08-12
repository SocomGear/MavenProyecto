/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gonzalez.mavenproyecto;

import static com.gonzalez.mavenproyecto.DAO.close;
import static com.gonzalez.mavenproyecto.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;

/**
 *
 * @author socom_000
 */
public class DAOSueldoImpl extends DAO1{
    
    public void agregarSueldo(Sueldo c) {
    begin();
 
    
    getSession().save(c);
    commit();
    close();
    
    }
 
       
    public ArrayList<Sueldo> buscarTodosSueldo() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Sueldo.class);
        ArrayList<Sueldo> sueldos = (ArrayList<Sueldo>)c.list();
        commit();
        close();
         
return sueldos; 
        
      
    }
    
 public static void borrarSueldo(Sueldo sueldo){
            begin();
             getSession().delete(sueldo);
            commit();
            close();
 }   
       
  public Sueldo buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Sueldo where id = :id");
        q.setInteger("id",id);
        Sueldo p = (Sueldo)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
    
}
