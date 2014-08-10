<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
                Inserta los valores
            </b>
            <p>
                <b>
                    Equipo:
        <input type="text" id="nombre" />
                </b>
        <p>
            <b>
                Pais:
        <input type="text" id="pais" />
            </b>
        <p>
        <input type="button" value="Guardar equipo" id="boton-guardar">
        <input type="button" value="Mostrar equipos" id="boton-mostrar" >
        <input type="button" value="Borrar equipo" onClick="location.href = 'borrar.jsp' ">
       <input type="button" value="Inicio" onClick="location.href = 'index.jsp' ">

       
        </center>
        <select name="nombres" id="todos" hidden>
             
            </select>
       
        <script>
        
       $("#boton-mostrar").click(function(){ 
        $("#todos").show();/* Este hace que se vea la chingadera de menu */   
        $("#todos").empty(); /* con esta funcion empty vaciamos todo, si  no se te juntaran un chingo de registros en el select de html */   
  $.getJSON("http://localhost:8091/MavenProyecto/servicios/equipo",function(result){
    $.each(result, function(i, campo){
      $("#todos").append("<option>"+campo.nombre + "</option> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var nombre=$("#nombre").val();
    var pais=$("#pais").val();
                $.ajax({
        method:'GET',
        url:"http://localhost:8091/MavenProyecto/servicios/equipo/"+nombre+"/"+pais,
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
