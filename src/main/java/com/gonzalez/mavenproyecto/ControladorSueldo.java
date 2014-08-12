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
public class ControladorSueldo {
    
    @RequestMapping(value="/sueldo/{sueldo}/{id}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public @ResponseBody String mensaje(@PathVariable float sueldo, @PathVariable int id ){
        String mensaje="nada";
        try{
           DAOSueldoImpl d= new DAOSueldoImpl();
            d.agregarSueldo(new Sueldo(sueldo,new Jugador(id) ));
           mensaje= "Sueldo guardado con exito";
        }catch(Exception e){
            mensaje="Lo siento pero no existe ese id de jugador";
        }
        return mensaje;
    }
    
    @RequestMapping(value="/sueldo", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOSueldoImpl d=new DAOSueldoImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosSueldo());
    }
    @RequestMapping(value = "/sueldo/{id}/{sueldo}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id, @PathVariable String sueldo){
        
        try {
            DAOSueldoImpl.borrarSueldo(new Sueldo(id));
            return "Sueldo eliminado con exito";
        } catch (Exception e) {
            return "No seas wey no coinciden los datos";
        }
        
    }
}
