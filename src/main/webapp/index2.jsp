<%-- 
    Document   : jugador
    Created on : 10/08/2014, 01:21:32 PM
    Author     : socom_000
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <title>Jugador</title>
    </head>
    <body>
        <center>
        <h1>Bienvenidos weyes!!!!!!</h1>
        
        <p>
            <b>
                Inserta los datos del jugador
            </b>
            <p>
                <b>
                    Nombre:
        <input type="text" id="nombre" />
                </b>
        <p>
            <b>
                Numero:
        <input type="text" id="numero" />
            </b>
        <p>
            <b>
                Nacionalidad:
                <input type="text" id="nacionalidad" />
            </b>
            <p>
            <b>
                Id Equipo:
                <input type="text" id="id" />
            </b>
        <p>
        <input type="button" value="Guardar jugador" id="boton-guardar">
        <input type="button" value="Mostrar jugador" id="boton-mostrar" >
       <input type="button" value="Sueldo" onClick="location.href = 'index3.jsp' ">
        </center>
        <select name="nombres" id="todos" hidden>
             
            </select>
       
        <script>
        
       $("#boton-mostrar").click(function(){ 
        $("#todos").show();/* Este hace que se vea la chingadera de menu */   
        $("#todos").empty(); /* con esta funcion empty vaciamos todo, si  no se te juntaran un chingo de registros en el select de html */   
  $.getJSON("http://localhost:8091/MavenProyecto/servicios/jugador",function(result){
    $.each(result, function(i, campo){
      $("#todos").append("<option>"+campo.nombre + "</option> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var nombre=$("#nombre").val();
    var numero=$("#numero").val();
    var nacionalidad=$("#nacionalidad").val();
    var id=$("#id").val();
                $.ajax({
        method:'POST',
        url:"http://localhost:8091/MavenProyecto/servicios/jugador/"+nombre+"/"+numero+"/"+nacionalidad+"/"+id,
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
