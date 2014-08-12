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
public class DAOJugadorImpl extends DAO1{
    
    public void agregarJugador(Jugador c) {
    begin();
 
    
    getSession().save(c);
    commit();
    close();
    
    }
 
       
    public ArrayList<Jugador> buscarTodosJugador() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Jugador.class);
        ArrayList<Jugador> jugadores = (ArrayList<Jugador>)c.list();
        commit();
        close();
         
return jugadores; 
        
      
    }
    
 public static void borrarJugador(Jugador jugador){
            begin();
             getSession().delete(jugador);
            commit();
            close();
 }   
        
  public Jugador buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Jugador where id = :id");
        q.setInteger("id",id);
        Jugador p = (Jugador)q.uniqueResult();
        commit();
        close();
return p;  
   
  } 
    
}
