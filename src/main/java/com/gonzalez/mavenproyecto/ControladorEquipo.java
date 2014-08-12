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
public class ControladorEquipo {
    
    @RequestMapping(value="/equipo/{nombre}/{pais}", method=RequestMethod.POST, headers={"Accept=text/html"})
    public @ResponseBody String mensaje(@PathVariable String nombre, @PathVariable String pais){
           DAOEquipoImpl d= new DAOEquipoImpl();
           d.agregarEquipo(new Equipo(nombre, pais));
           return "Equipo guardado con exito";
    }
    
    @RequestMapping(value="/equipo", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOEquipoImpl d=new DAOEquipoImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosEquipo());
    }
     @RequestMapping(value = "/equipo/{id}/{equipo}", method = RequestMethod.DELETE, headers = {"Accept=text/html"})
    public @ResponseBody String eliminar(@PathVariable int id,@PathVariable String equipo){
        DAOEquipoImpl d= new DAOEquipoImpl();
           d.borrarEquipo(new Equipo(id));
           return "Equipo borrado con exito";
        }
}
