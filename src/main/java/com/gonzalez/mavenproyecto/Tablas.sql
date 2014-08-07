
create table equipo (id_equipo  integer primary key auto_increment,
                     nombre varchar(80),
                     pais varchar(80) );

create table jugador (id_jugador integer primary key auto_increment, id_equipo integer, nombre varchar(80),
                           numero integer, nacionalidad varchar(80),
                           foreign key (id_equipo) references  
                            equipo (id_equipo));


create table sueldo (id_jugador integer , id_sueldo integer auto_increment primary key, sueldo float,
                     constraint foreign key(id_jugador) references jugador(id_jugador));

select * from jugador;