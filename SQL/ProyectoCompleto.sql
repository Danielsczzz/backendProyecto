-- Definicion de tablas ---------------------------------------------------------------------------
create table usuario(
	idUsuario int primary key auto_increment,
    nombre varchar(50) not null,
    correo varchar(50) not null unique,
    profesion enum("estudiante", "admin", "docente", "servicios") not null
);

create table telefono_usuario(
	telefono varchar(12) primary key,
    idUsuario int not null,
    foreign key (idUsuario) references usuario(idUsuario)
);

create table tipo_tramite(
	idTipo int primary key auto_increment,
    tipo varchar(50) not null unique
);

create table unidad(
	idUnidad int primary key auto_increment,
    nombre varchar(50) not null unique
);

create table telefono_unidad(
	telefono varchar(12) primary key,
    idUnidad int not null,
    foreign key (idUnidad) references unidad(idUnidad)
);

create table tramite(
	idTramite int primary key auto_increment,
    descripcion varchar(50) not null,
    normativa varchar(50) not null,
    costo decimal(10, 2),
    esPago bool not null,
    idTipo int not null,
    idUnidad int not null,
    idUsuario int not null,
    foreign key (idTipo) references tipo_tramite(idTipo),
    foreign key (idUnidad) references unidad(idUnidad),
    foreign key (idUsuario) references usuario(idUsuario)
);

create table documento(
	idDocumento int primary key auto_increment,
    archivoURL varchar(50) not null,
    estado enum("activo", "inactivo") not null default "activo",
    idTramite int not null,
    foreign key (idTramite) references tramite(idTramite)
);

create table solicitud(
	idSolicitud int primary key auto_increment,
    estado enum("pendiente", "en proceso", "completado", "cancelado") not null,
    fechaGeneracion datetime not null default now(),
    idUsuario int not null,
    idTramite int not null,
    foreign key (idUsuario) references usuario(idUsuario),
    foreign key (idTramite) references tramite(idTramite)
);

create table recibo (
	idRecibo int primary key auto_increment,
    documentoURL varchar(50) not null,
    fechaGeneracion date not null default (CURRENT_DATE + INTERVAL 1 YEAR),
    monto decimal(10, 2) not null,
    idSolicitud int not null,
    foreign key (idSolicitud) references solicitud(idSolicitud)
);

create table adjunto(
	idAdjunto int primary key auto_increment,
    documentoURL varchar(100) not null,
    idSolicitud  int not null,
    tipo enum('documento personal', 'recibo de pago', 'documento universidad'),
    foreign key (idSolicitud) references solicitud(idSolicitud)
);

create table comentario(
	idComentario int primary key auto_increment,
    texto varchar(100) not null,
    mediaURL varchar(100),
    idSolicitud int not null,
    idUsuario int not null,
    idRespuesta int null,
    foreign key (idSolicitud) references solicitud(idSolicitud),
    foreign key (idUsuario) references usuario(idUsuario),
    foreign key (idRespuesta) references comentario(idComentario)
);

-- Creacion de la tabla para guardar los logs de los usuarios
create table log_usuario (
 idLogUsuario int primary key, 
 accion varchar(20) not null,
 horaAccion datetime default now() not null,
 nombre varchar(50) not null,
 correo varchar(50) not null,
 profesion enum('estudiante', 'docente', 'admin', 'servicios') not null
);
-- ---------------------------------------------------------------------------------------------
-- Insercion de datos --------------------------------------------------------------------------
insert into usuario (idUsuario, nombre, correo, profesion)
values 
(1, "Ana", "ana@email.com", "Estudiante"),
(2, "Carlos", "carlos@email.com", "Admin"),
(3, "Elena", "elena@email.com", "Docente"),
(4, "David", "david@email.com", "Servicios"),
(5, "Fernando", "fernando@email.com", "Estudiante"),
(6, "Gloria", "gloria@email.com", "Admin"),
(7, "Hugo", "hugo@email.com", "Docente"),
(8, "Inés", "ines@email.com", "Servicios"),
(9, "Daniel", "daniel@mail.com", "admin");

insert into telefono_usuario (telefono, idUsuario)
values
("1234567890", 1),
("9876543210", 2),
("5551234567", 3),
("1112223333", 4),
("5557778888", 5),
("3555555555", 5),
("1239876543", 6),
("3334445555", 7),
("7771112222", 8);

insert into unidad (idUnidad, nombre)
values
(101, "Registro Académico"),
(102, "Recursos Humanos"),
(103, "Biblioteca"),
(104, "Tesoreria"),
(105, "Gestion TI"),
(106, "Departamento caja");

insert into telefono_unidad (telefono, idUnidad)
values
("5559998888", 101),
("7774443333", 102),
("1234567890", 103),
("3003333333", 103),
("8889990000", 104),
("4445556666", 105),
("2223334444", 106);

insert into tipo_tramite (idTipo, tipo)
values
(1, "Matrícula"),
(2, "Permiso"),
(3, "Certificación"),
(4, "Reclamación"),
(5, "Solicitud"),
(6, "Consulta");

insert into tramite (idTramite, descripcion, normativa, idTipo, idUnidad, idUsuario, esPago, monto)
values
(201, "Inscripción", "Reglamento X", 1, 101, 6, true, 4000000),
(204, "Reembolso", "Política A", 4, 104, 9, true, 100000),
(208, "Solicitud de beca parqueaderos uao", "Normativa 420", 5, 104, 9, true, 2500000);

insert into tramite (idTramite, descripcion, normativa, idTipo, idUnidad, idUsuario, esPago)
values
(202, "Permiso de ausencia", "Norma Y", 2, 102, 2, false),
(203, "Certificado de notas", "Procedimiento Z", 3, 103, 6, false),
(205, "Permiso de vacaciones", "Reglamento B", 5, 105, 6, false),
(206, "Consulta de horarios", "Procedimiento C", 6, 106, 6, false),
(207, "Resevar salon 2001", "Norma z", 2, 102, 9, false);

insert into documento (idDocumento, archivoURL, estado, idTramite)
values
(301, "https://uao.documentos.com/inscripcion.pdf", "activo", 201),
(302, "https://uao.documentos.com/licencia_ausencia.pdf", "inactivo", 202),
(303, "https://uao.documentos.com/notasPlantilla.pdf", "activo", 203),
(304, "https://uao.pagos.com/politicaReembolso.pdf", "inactivo", 204),
(305, "https://uao.portal.com/permisoVacaciones.pdf", "inactivo", 205),
(306, "https://uao.lineaRoja.com/horario.pdf", "activo", 206),
(308, "https://uao.portal.com/becaValidacion.pdf", "activo", 206);

insert into solicitud (idSolicitud, estado, fechaGeneracion, idUsuario, idTramite)
values
(401, "pendiente", "2020-03-15 6:00:00", 1, 201),
(402, "en proceso", "2020-04-21 15:30:00", 2, 202),
(403, "completado", "2022-07-02 9:15:00",3, 203),
(404, "pendiente", "2022-08-15 7:00:00",5, 204),
(405, "en proceso", "2022-08-21 9:00:00", 6, 205),
(406, "en proceso", "2024-01-21 7:00:00",1, 208),
(407, "pendiente", "2024-01-29 7:15:00",5, 208),
(408, "pendiente", "2024-01-29 7:45:00",5, 208),
(409, "en proceso", "2024-01-29 8:00:00",1, 208),
(410, "en proceso", "2024-01-29 8:15:00",5, 208),
(411, "cancelado", "2024-01-29 8:45:00",5, 208),
(412, "en proceso", "2024-02-22 8:20:00",7, 205),
(413, "completado", "2023-01-15 7:00:00",1, 201),
(414, "completado", "2024-03-15 8:00:00",1, 206);

insert into adjunto (idAdjunto, documentoURL, idSolicitud, tipo)
values
(501, "https://recursos.estudiante.com/certificadoNotas.pdf", 401, 'recibo de pago'),
(502, "https://recursos.admin.com/cedulaColaborador.pdf", 402, 'documento personal'),
(503, "https://recursos.estudiante.com/recibos/parqBeca.pdf", 403, 'recibo de pago'),
(504, "https://uaoPortal.com/estudianteRecurso.pdf", 410, 'documento personal'),
(505, "https://recursos.estudiante.com/recibos/parqBeca.pdf", 405, 'recibo de pago'),
(506, "https://recursos.estudiante.com/recibos/parqBeca.pdf", 406, 'recibo de pago'),
(507, "https://uaoPortal.com/politicaReembolso.pdf", 404, 'documento universidad'),
(508, "uao.docente/cedulaCiudadania.jpg", 412, 'documento personal'),
(509, "uao.estudiante/certificadoBachillerato.png", 413, 'documento personal');

insert into recibo (documentoURL, fechaGeneracion, monto, idSolicitud) 
values
("uao.com/notasRecibo.pdf", "2024-01-30", 40000, 403),
("uao.becas.com/ReembolsoMonto.pdf", "2024-01-30", 2500000, 404),
("uao.becas.com/reciboBeca.pdf", "2024-01-30", 3000000,406 ),
("uao.becas.com/becaValor.pdf", "2024-01-30", 3000000,407),
("uao.becas.com/valorBeca.pdf", "2024-01-30", 3000000, 408),
("uao.becas.com/becaPago.pdf", "2024-01-30", 3000000, 409),
("uao.becas.com/pagoBeca.pdf", "2024-01-30", 3000000, 410);


insert into comentario (texto, mediaURL, idSolicitud, idUsuario) values ("Todo en orden", "https://example.com/comment1.jpg", 401, 1);
insert into comentario (texto, mediaURL, idSolicitud, idUsuario) values ("Revisar detalles", "https://example.com/comment2.jpg", 402, 2);
insert into comentario (texto, mediaURL, idSolicitud, idUsuario) values ("Todo correcto", "https://example.com/comment3.jpg", 404, 5);
insert into comentario (texto, idSolicitud, idUsuario, idRespuesta) 
values
("Archivo invalido por favor reenviar", 404, 2, 3),
("Todos los archivos estan corregidos", 402, 6, 2),
("Revisa tu correo para confirmar", 404, 2, 3);
-- ---------------------------------------------------------------------------------------------

-- Creacion de vistas---------------------------------------------------------------------------

-- Obtiene toda la informacion de las solicitudes
create view info_solicitud as
	select u.idUsuario, s.idSolicitud, u.nombre as usuario, s.estado, s.fechaGeneracion, tp.tipo, t.descripcion, t.normativa 
	from usuario as u join solicitud as s using (idUsuario) 
	join tramite as t using(idTramite) 
	join tipo_tramite as tp using(idTipo);

-- Obtiene las solicitudes con mas tiempo en proceso o pendiente
create view tipo_tramite_mas_recurrente as
    select tp.tipo from tramite
    join tipo_tramite as tp using(idTipo)
    group by idTipo
    having count(idTipo)=(
        select max(numRegistros)
        from (select t.idTipo, count(t.idTipo) as numRegistros
              from tramite as t group by t.idTipo) as subQuery);

-- -----------------------------------------------------------------------------------------------

-- Funciones ------------------------------------------------------------------------------------------------------

-- Funcion para calcular el iva
DELIMITER //
create function calcularIva(monto decimal(10, 2)) returns decimal(10, 2)
reads sql data
begin
 declare montoConIva decimal(10, 2);
 set montoConIva = monto + (monto * (19 /100));
 return montoConIva;
end //
DELIMITER ;

-- Procedures -----------------------------------------------------------------------------------------------------

-- Consultar Trámites Activos de Usuario
DELIMITER //
create procedure ConsultarTramitesActivosDeUsuario(in idUsuario int)
begin
    select
        t.idTramite as ID_tramite,
        tt.tipo as TipoTramite,
        t.descripcion as Descripcion,
        u.nombre as UnidadResponsable,
        s.estado as Estado
    from tramite as t join tipo_tramite as tt using(idTipo)
    join unidad u using(idUnidad)
    join solicitud s using(idTramite)
    where s.idUsuario = idUsuario
        and s.estado in ('pendiente', 'en proceso');
end //
DELIMITER ;

-- ----------------------------------------------------------------------------------------------------------------

-- Triggers -------------------------------------------------------------------------------------------------------

-- Trigger para mandar un comentario de que se acaba de agregar un recibo a la solicitud
DELIMITER //
create trigger informarRecibo after insert on recibo
for each row
begin
  declare idFuncionario int;
  select t.idUsuario into idFuncionario from recibo 
	join solicitud using (idSolicitud)
    join tramite as t using(idTramite) limit 1;
  insert into comentario (texto, mediaURL, idSolicitud, idUsuario) values ("Acabamos de agregar un recibo a tu solicitud, por favor revisa tu portal uao!", new.documentoURL, new.idSolicitud, idFuncionario);
end; //
DELIMITER ;

-- Trigger para modificar la solicitud dependiendo del adjunto que se agregue
DELIMITER //
create trigger modificarSolicitud after insert on adjunto
for each row
begin
  if new.tipo = 'documento personal' then
	update solicitud set estado = 'en proceso' where idSolicitud = new.idSolicitud;
  elseif new.tipo = 'recibo de pago' then 
	update solicitud set estado = 'pendiente' where idSolicitud = new.idSolicitud;
  else
    update solicitud set estado = 'completado' where idSolicitud = new.idSolicitud;
  end if;
end //
DELIMITER ;

-- Trigger para actualizar la solicitud a cancelado cuando el documento del tramite se inactive
DELIMITER //
create trigger actualizarSolicitudPorDocumento after update on documento
for each row
begin
	declare solicitudId int;
	select idSolicitud into solicitudId from solicitud 
    join tramite using (idTramite)
    join documento using (idTramite) 
    where idDocumento = new.idDocumento;
	if new.estado = 'inactivo' then
		update solicitud set estado = 'cancelado' where idSolicitud = solicitudId;
	end if;
end //
DELIMITER ;

-- Trigger para generar un recibo cuando se cree una solicitud para un tramite con pago
DELIMITER //
create trigger validarTramitePago before insert on recibo
for each row 
begin
	declare esTramitePago bool;
    select t.esPago into esTramitePago from solicitud as s
    join tramite as t using (idTramite)
    where s.idSolicitud = new.idSolicitud;
    if esTramitePago = false then 
		signal
		sqlstate '45000'
        set message_text = 'No se puede agregar un recibo a esta solicitud, ya que el tramite no requiere pagos.';
	end if;
end //
DELIMITER ;

-- Trigger de Validación de Correo Electrónico
DELIMITER //
create trigger validarCorreo before insert on usuario
for each row
begin
  -- Verificar formato de correo electrónico
  if not REGEXP_LIKE(new.correo, '^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$') then
    signal sqlstate '45000' set message_text = 'Correo electrónico no válido';
  end if;
end //
DELIMITER ;

-- Trigger que valida si el usuario que intenta crear el tramite es admin
DELIMITER //
create trigger validarAdmin before insert on tramite 
for each row
begin
    declare rol varchar(10);
    select profesion into rol from usuario where idUsuario = new.idUsuario;
    if rol <> 'admin' then
		signal
		sqlstate '45000'
        set message_text = 'Este usuario no es valido para realizar esta operacion';
	end if;
end; //
DELIMITER ;

-- Trigger para que no se ingresen mas comentarios en una solicitud cancelada o completada
DELIMITER //
create trigger validarSolicitud before insert on comentario 
for each row
begin
    declare estadoSolicitud enum('pendiente', 'en proceso', 'completado', 'cancelado');
    select estado into estadoSolicitud from solicitud where idSolicitud = new.idSolicitud;
    if estadoSolicitud <> 'completado' or estadoSolicitud <> 'cancelado' then
		signal
		sqlstate '45000'
        set message_text = 'No se pueden agregar mas comentarios a esta solicitud.';
	end if;
end; //
DELIMITER ;

-- Triggers para los logs de los usuarios --------------------------------------------------------------------------

DELIMITER //
create trigger logInsert after insert on usuario
for each row
begin
  insert into log_usuario (idLogUsuario, accion, nombre, correo, profesion) values (new.idUsuario, "insert", new.nombre, new.correo, new.profesion);
end; //
DELIMITER ;

DELIMITER //
create trigger logUpdate after update on usuario
for each row
begin
  insert into log_usuario (idLogUsuario, accion, nombre, correo, profesion) values (new.idUsuario, "update", new.nombre, new.correo, new.profesion);
end; //
DELIMITER ;

DELIMITER //
create trigger logDelete before delete on usuario
for each row
begin
  insert into log_usuario (idLogUsuario, accion, nombre, correo, profesion) values (old.idUsuario, "delete", old.nombre, old.correo, old.profesion);
end; //
DELIMITER ;
-- -----------------------------------------------------------------------------------------------------------------

-- Casos de prueba -------------------------------------------------------------------------------------------------

-- Funcion para calcular el iva
-- select calcularIva(100000.00);

-- Procedure que obtiene las solicitudes pendientes de un usuario
-- call ConsultarTramitesActivosDeUsuario(1);

-- Prueba para trigger que manda un comentario al ingresar un recibo a una solicitud
-- insert into recibo values (8, "portalMatricula.uao.com/reciboMatricula.pdf", "2024-01-30", 3000000.00, 413);

-- Prueba para trigger que cambia el estado de una solicitud dependiendo del adjunte que se agregue
-- insert into adjunto values (510, "https://uaoPortal.estudiante.com/documentoConfirmacion.pdf", 401, 'documento universidad');

-- Prueba para trigger que cambia el estado de una solicitud dependiendo del estado del documento del tramite
-- update documento set estado = 'inactivo' where idDocumento = 306;

-- Prueba para verificar si el tramite si es de pago
-- insert into recibo (documentoURL, monto, idSolicitud) values ("https://archivoDePrueba", 10000, 402);

-- Prueba para trigger que valida que el correo electronico de un usuario es valido
-- insert into usuario values (15, "david barreto", "david.com", "estudiante");ç

-- Prueba para trigger que valida que el usuario que ingresa un tramite es admin
-- insert into tramite (idTramite, descripcion, normativa, idTipo, idUnidad, idUsuario) values (220, 'Tramite de prueba', 'ley 100', 7, 102, 1);

-- Prueba para trigger que valida que no se pueden agregar mas comentarios a una solicitud cancelada o completada
-- insert into comentario (texto, idSolicitud, idUsuario )values ("texto de ejemplo", 411, 9);

-- Prueba para triggers de logs de la tabla usuario
-- insert into usuario values (10, "juan jose moncayo", "jjMoncayo@mail.com", "estudiante");
-- update usuario set nombre = "daniel sanchez" where idUsuario = 9;
-- delete from usuario where idUsuario = 9;