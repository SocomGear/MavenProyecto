<%-- 
    Document   : borrar
    Created on : 10/08/2014, 03:07:13 PM
    Author     : socom_000
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <title>Mi pagina web</title>
    </head>
    <body>
        <center>
        <h1>Bienvenidos weyes!!!!!!</h1>
        
        <p>
            <b>
                Que equipo deseas borrar?
            </b>
            <p>
                <b>
                    Id Equipo:
        <input type="text" id="id" />
                </b>
        <p>
          <b>
                    Nombre:
        <input type="text" id="nombre" />
                </b>
        <p> 
        <input type="button" value="Borrar equipo" id="boton-borrar">
        
       <input type="button" value="Inicio" onClick="location.href = 'index.jsp' ">

       
        </center>
        <script>
        
       
$("#boton-borrar").click(function(){
    var id=$("#id").val();
    var nombre=$("#nombre").val();
                $.ajax({
        method:'DELETE',
        url:"http://localhost:8091/MavenProyecto/servicios/equipo/"+id+"/"+nombre,
        success:function(valor){
            alert(valor);
        },
        failure:function(e){
            alert(e);
        }
    });
});

   


        </script>
        
        <div></div>
    </body>
</html>