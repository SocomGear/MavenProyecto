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
public class DAOJugadorImpl extends DAO{
    
    public void agregarJugador(Jugador c) {
    begin();
 
    
    getSession().save(c);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Jugador> buscarTodosJugador() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Jugador.class);
        ArrayList<Jugador> jugadores = (ArrayList<Jugador>)c.list();
        commit();
        close();
         
return jugadores; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarJugador(Jugador p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
        /**
         * Este metodo busca un cliente por medio de su Id
         * @param id Este parametro es el Id del cliente que se quiere buscar
         * @return El tipo de retorno es el cliente buscado
         */
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
