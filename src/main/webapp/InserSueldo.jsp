<%-- 
    Document   : sueldo
    Created on : 10/08/2014, 01:47:28 PM
    Author     : socom_000
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <title>Sueldo jugador</title>
    </head>
    <body>
        <center>
        <h1>Bienvenidos weyes!!!!!!</h1>
        
        <p>
            <b>
                Inserta el sueldo del jugador
            </b>
            <p>
                <b>
                    Sueldo:
        <input type="text" id="sueldo" />
                </b>
        <p>
           <b>
                    Id Jugador:
        <input type="text" id="id" />
                </b>
        <p>
        <input type="button" value="Guardar sueldo" id="boton-guardar">
        <input type="button" value="Mostrar sueldo" id="boton-mostrar" >
        <input type="button" value="Borrar sueldo" onClick="location.href = 'borrar.jsp' ">
       <input type="button" value="Inicio" onClick="location.href = 'index.jsp' ">
        </center>
        <select name="nombres" id="todos" hidden>
             
            </select>
       
        <script>
        
       $("#boton-mostrar").click(function(){ 
        $("#todos").show();/* Este hace que se vea la chingadera de menu */   
        $("#todos").empty(); /* con esta funcion empty vaciamos todo, si  no se te juntaran un chingo de registros en el select de html */   
  $.getJSON("http://localhost:8091/MavenProyecto/servicios/sueldo",function(result){
    $.each(result, function(i, campo){
      $("#todos").append("<option>"+campo.sueldo + "</option> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var sueldo=$("#sueldo").val();
    var id=$("#id").val();
                $.ajax({
        method:'GET',
        url:"http://localhost:8091/MavenProyecto/servicios/sueldo/"+sueldo+"/"+id,
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

