/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gonzalez.mavenproyecto;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author socom_000
 */
@Controller
@RequestMapping("/")
public class ControladorJugador {
    
    @RequestMapping(value="/jugador/{nombre}/{numero}/{nacionalidad}/{id}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public @ResponseBody String mensaje(@PathVariable String nombre, @PathVariable int 
            numero,@PathVariable String nacionalidad, @PathVariable int id ){
        String mensaje="nada";
        try{
           DAOJugadorImpl d= new DAOJugadorImpl();
            d.agregarJugador(new Jugador(nombre, numero, nacionalidad,new Equipo(id) ));
           mensaje= "Jugador guardado con exito";
        }catch(Exception e){
            mensaje="Lo siento pero no existe ese id de equipo";
        }
        return mensaje;
    }
    
    @RequestMapping(value="/jugador", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOJugadorImpl d=new DAOJugadorImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosJugador());
    }
}

