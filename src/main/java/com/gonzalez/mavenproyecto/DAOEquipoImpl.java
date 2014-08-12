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
public class DAOEquipoImpl extends DAO{
    
    public void agregarEquipo(Equipo equipo) {
    begin();
    getSession().save(equipo);
    commit();
    close();
    
    }
 
    public ArrayList<Equipo> buscarTodosEquipo() {
        begin();
        Query q = getSession().createQuery("from Equipo");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Equipo> equipos = (ArrayList<Equipo>)q.list();
        commit();
        close();
         
return equipos; 
        
      
    }
 
 public void borrarEquipo(Equipo equipo){
            begin();
             getSession().delete(equipo);
            commit();
            close();
 }   
        
  public Equipo buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Equipo where id = :id");
        q.setInteger("id",id);
        Equipo p = (Equipo)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
    
    
}
