CREATE DATABASE siajardin;

CREATE TABLE IF NOT EXISTS  rol  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(150) NOT NULL UNIQUE,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  tipo_documento  (
	 id  VARCHAR(5) NOT NULL UNIQUE,
	 descripcion  VARCHAR(100) NOT NULL,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  genero  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(100) NOT NULL,
	 activo  INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  grado_academico  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(150) NOT NULL,
	 activo  INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  estado  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(150) NOT NULL,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  jornada  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(100) NOT NULL,
	 activo  INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY( id )
);


CREATE TABLE IF NOT EXISTS  usuario  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 correo  VARCHAR(150) NOT NULL UNIQUE,
	 clave  VARCHAR(255) NOT NULL,
	 id_tipo_documento  VARCHAR(5) NOT NULL REFERENCES tipo_documento ( id ),
	 identificacion  VARCHAR(25) NOT NULL,
	 nombre  VARCHAR(150) NOT NULL,
	 apellido  VARCHAR(150) NOT NULL,
	 telefono  VARCHAR(30) NOT NULL,
	 direccion  VARCHAR(255) NOT NULL,
	 id_rol  BIGINT NOT NULL REFERENCES rol ( id ),
	 id_estado  BIGINT NOT NULL REFERENCES estado ( id ),
	 id_genero  BIGINT NOT NULL REFERENCES genero ( id ),
	 reset  INTEGER NOT NULL,
	 hash_reset  VARCHAR(255),
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);


CREATE TABLE IF NOT EXISTS  bitacora  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 fecha  DATE NOT NULL,
	 hora  VARCHAR(10) NOT NULL,
	 evento  VARCHAR(100) NOT NULL,
	 detalle  TEXT,
	 id_usuario  BIGINT NOT NULL REFERENCES usuario ( id ),
	PRIMARY KEY( id )
);


CREATE TABLE IF NOT EXISTS  proceso  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 codigo  VARCHAR(25) NOT NULL UNIQUE,
	 descripcion  VARCHAR(150) NOT NULL,
	 activo  INTEGER NOT NULL DEFAULT 1,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  calendario  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(150) NOT NULL,
	 fecha_inicial  DATE NOT NULL,
	 fecha_final  DATE NOT NULL,
	 activo  INTEGER NOT NULL DEFAULT 1,
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  procesos_x_calendario  (
	 id_calendario  BIGINT NOT NULL REFERENCES calendario ( id ),
	 id_proceso  BIGINT NOT NULL REFERENCES proceso ( id ),
	PRIMARY KEY( id_calendario ,  id_proceso )
);

CREATE TABLE IF NOT EXISTS  estudiante  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_tipo_documento  VARCHAR(5) NOT NULL REFERENCES tipo_documento ( id ),
	 identificacion  VARCHAR(25) NOT NULL,
	 nombres  VARCHAR(150) NOT NULL,
	 apellidos  VARCHAR(150) NOT NULL,
	 id_genero  BIGINT NOT NULL REFERENCES genero ( id ),
	 fecha_nacimiento  DATE NOT NULL,
	 lugar_nacimiento  VARCHAR(150) NOT NULL,
	 tipo_entidad_salud  VARCHAR(100) NOT NULL,
	 nombre_entidad_salud  VARCHAR(150) NOT NULL,
	 grupo_sanguineo  VARCHAR(20) NOT NULL,
	 foto  TEXT,
	 matriculado  INTEGER NOT NULL,
	 carnet_vacuna_completo  VARCHAR(10),
	 conducta_a_seguir  TEXT,
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  cohorte  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(150) NOT NULL,
	 id_calendario  BIGINT NOT NULL REFERENCES calendario ( id ),
	 n_periodo  INTEGER NOT NULL,
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  curso  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(150) NOT NULL UNIQUE,
	 capacidad  INTEGER NOT NULL,
	 inscritos  INTEGER NOT NULL,
	 matriculados  INTEGER NOT NULL,
	 id_grado_academico  BIGINT NOT NULL REFERENCES grado_academico ( id ),
	 id_cohorte  BIGINT NOT NULL REFERENCES cohorte ( id ),
	 id_usuario  BIGINT NOT NULL REFERENCES usuario ( id ),
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);



CREATE TABLE IF NOT EXISTS  objetivo  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  TEXT NOT NULL,
	 periodo  INTEGER NOT NULL,
	 id_cohorte  BIGINT NOT NULL REFERENCES cohorte ( id ),
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);



CREATE TABLE IF NOT EXISTS  padres_estudiante  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 nombres_papa  VARCHAR(150),
	 apellidos_papa  VARCHAR(150),
	 id_tipo_documento_papa  VARCHAR(5),
	 identificacion_papa  VARCHAR(25),
	 lugar_expedicion_papa  VARCHAR(100),
	 profesion_papa  VARCHAR(100),
	 empresa_papa  VARCHAR(150),
	 telefono_papa  VARCHAR(25),
	 movil_papa  VARCHAR(25),
	 correo_papa  VARCHAR(150),
	 nombres_mama  VARCHAR(150),
	 apellidos_mama  VARCHAR(150),
	 id_tipo_documento_mama  VARCHAR(5),
	 identificacion_mama  VARCHAR(25),
	 lugar_expedicion_mama  VARCHAR(100),
	 profesion_mama  VARCHAR(100),
	 empresa_mam  VARCHAR(150),
	 telefono_mama  VARCHAR(25),
	 movil_mama  VARCHAR(25),
	 correo_mama  VARCHAR(150),
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  contacto_emergencia_estudiante  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 nombres_1  VARCHAR(200),
	 parentesco_1  VARCHAR(100),
	 direccion_1  VARCHAR(200),
	 telefono_1  VARCHAR(25),
	 movil_1  VARCHAR(25),
	 correo_1  VARCHAR(150),
	 nombres_2  VARCHAR(200),
	 parentesco_2  VARCHAR(100),
	 direccion_2  VARCHAR(200),
	 telefono_2  VARCHAR(25),
	 movil_2  VARCHAR(25),
	 correo_2  VARCHAR(150),
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  antecedentes_embarazo_estudiante  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 tipo_parto  VARCHAR(25),
	 pretermino  INTEGER DEFAULT 0,
	 postermino  INTEGER DEFAULT 0,
	 talla  VARCHAR(25),
	 peso  VARCHAR(25),
	 lactancia_materna  VARCHAR(10),
	 utimo_mes_lactancia  VARCHAR(100),
	 utiliza_tetero  VARCHAR(10),
	 edad_utilizacion  VARCHAR(100),
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  hospitalario_estudiante  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 hospitalizado  VARCHAR(10),
	 causa  TEXT,
	 fecha  DATE,
	 centro_medico  VARCHAR(150),
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  medicamentos_estudiante  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 medicamento  VARCHAR(100),
	 enfermedad_tratada  VARCHAR(150),
	 alergia_medicamento  VARCHAR(150),
	 alimentos_no_consumidos  TEXT,
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  odontologia_estudiante  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 edad_inicio_lavado_dientes  VARCHAR(25),
	 frecuencia  INTEGER,
	 le_gusta  INTEGER,
	 tiene_caries  VARCHAR(10),
	 control_odontologico  VARCHAR(10),
	 fecha_ultimo_control  DATE,
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  control_crecimiento_estudiante  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 fecha  DATE,
	 peso  VARCHAR(25),
	 talla  VARCHAR(25),
	 fecha_creacion  TIMESTAMP,
	 fecha_actualizacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  inscrito  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 id_curso  BIGINT NOT NULL REFERENCES curso ( id ),
	 id_jornada  BIGINT NOT NULL REFERENCES jornada ( id ),
	 fecha_creacion  TIMESTAMP,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  matriculado  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_estudiante  BIGINT NOT NULL REFERENCES estudiante ( id ),
	 id_curso  BIGINT NOT NULL REFERENCES curso ( id ),
	 id_jornada  BIGINT NOT NULL REFERENCES jornada ( id ),
	 fecha_creacion  TIMESTAMP NOT NULL,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  documeto  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 descripcion  VARCHAR(150) NOT NULL,
	 obligatorio  INTEGER NOT NULL DEFAULT 0,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  documento_x_curso  (
	 id_curso  BIGINT NOT NULL REFERENCES curso ( id ),
	 id_documento  BIGINT NOT NULL REFERENCES documeto ( id ),
	PRIMARY KEY( id_curso ,  id_documento )
);

CREATE TABLE IF NOT EXISTS  documentos_x_inscrito  (
	 id  BIGSERIAL NOT NULL,
	 id_inscrito  BIGINT NOT NULL REFERENCES inscrito ( id ),
	 id_documento  BIGINT NOT NULL REFERENCES documeto ( id ),
	 nombre_documento  VARCHAR(150) NOT NULL,
	 ruta  VARCHAR(200) NOT NULL,
	 tipo  VARCHAR(20) NOT NULL,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  documentos_x_matriculado  (
	 id  BIGSERIAL NOT NULL,
	 id_matriculado  BIGINT NOT NULL REFERENCES matriculado ( id ),
	 id_documento  BIGINT NOT NULL REFERENCES documeto ( id ),
	 nombre_documento  VARCHAR(150) NOT NULL,
	 ruta  VARCHAR(200) NOT NULL,
	 tipo  VARCHAR(20) NOT NULL,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  informe_matriculado  (
	 id  BIGSERIAL NOT NULL,
	 id_matriculado  BIGINT NOT NULL REFERENCES matriculado ( id ),
	 descripcion  TEXT NOT NULL,
	 annio  INTEGER NOT NULL,
	 periodo  INTEGER NOT NULL,
	 fecha_creacion  TIMESTAMP NOT NULL,
	 fecha_actualizacion  TIMESTAMP NOT NULL,
	PRIMARY KEY( id )
);

CREATE TABLE IF NOT EXISTS  detalle_informe  (
	 id  BIGSERIAL NOT NULL UNIQUE,
	 id_informe_matriculado  BIGINT NOT NULL REFERENCES informe_matriculado ( id ),
	 id_objetivo  BIGINT NOT NULL REFERENCES objetivo ( id ),
	 valoracion  VARCHAR(10) NOT NULL,
	 fecha_creacion  TIMESTAMP NOT NULL,
	 fecha_actualizacion  TIMESTAMP NOT NULL,
	PRIMARY KEY( id )
);

---carga de datos iniciales
create or replace function data_init_load() returns integer as
$BODY$
begin
--carga de roles
if not exists (select * from rol where descripcion = 'Administrador') then
	insert into rol (descripcion) values ('Administrador');
end if;
if not exists (select * from rol where descripcion = 'Docente') then
	insert into rol (descripcion) values ('Docente');
end if;
if not exists (select * from rol where descripcion = 'Estudiante') then
	insert into rol (descripcion) values ('Estudiante');
end if;
if not exists (select * from rol where descripcion = 'Coordinador') then
	insert into rol (descripcion) values ('Coordinador');
end if;
if not exists (select * from rol where descripcion = 'Director') then
	insert into rol (descripcion) values ('Director');
end if;

--carga de procesos
if not exists (select * from proceso where codigo = 'INS001') then
	insert into proceso (codigo, descripcion,activo) values ('INS001', 'Proceso de Inscripción', 1);
end if;

if not exists (select * from proceso where codigo = 'MTR002') then
	insert into proceso (codigo, descripcion,activo) values ('MTR002', 'Proceso de Matrícula', 1);
end if;

if not exists (select * from proceso where codigo = 'CUR003') then
	insert into proceso (codigo, descripcion,activo) values ('CUR003', 'Proceso de Gestión Académica', 1);
end if;

--carga de tipo de documento
if not exists (select * from tipo_documento where id = 'CC') then
	insert into tipo_documento (id, descripcion) values ('CC', 'Cédula de Ciudadanía');
end if;
if not exists (select * from tipo_documento where id = 'TI') then
	insert into tipo_documento (id, descripcion) values ('TI', 'Tarjeta de Identidad');
end if;
if not exists (select * from tipo_documento where id = 'RC') then
	insert into tipo_documento (id, descripcion) values ('RC', 'Registro Civil');
end if;
if not exists (select * from tipo_documento where id = 'PA') then
	insert into tipo_documento (id, descripcion) values ('PA', 'Pasaporte');
end if;
if not exists (select * from tipo_documento where id = 'CE') then
	insert into tipo_documento (id, descripcion) values ('CE', 'Cédula de Extranjería');
end if;
if not exists (select * from tipo_documento where id = 'NIT') then
	insert into tipo_documento (id, descripcion) values ('NIT', 'Número de Identificación Tributaria');
end if;
if not exists (select * from tipo_documento where id = 'NUIP') then
	insert into tipo_documento (id, descripcion) values ('NUIP', 'Número Único de Identificación Personal');
end if;

--carga de genero
if not exists (select * from genero where descripcion = 'Masculino') then
	insert into genero (descripcion,activo) values ('Masculino',1);
end if;
if not exists (select * from genero where descripcion = 'Femenino') then
	insert into genero (descripcion,activo) values ('Femenino',1);
end if;
if not exists (select * from genero where descripcion = 'Otro') then
	insert into genero (descripcion,activo) values ('Otro',1);
end if;
if not exists (select * from genero where descripcion = 'No definido') then
	insert into genero (descripcion,activo) values ('No definido',1);
end if;

--carga de grado academico
if not exists (select * from grado_academico where descripcion = 'Caminadores') then
	insert into grado_academico (descripcion,activo) values ('Caminadores',1);
end if;
if not exists (select * from grado_academico where descripcion = 'Párvulo') then
	insert into grado_academico (descripcion,activo) values ('Párvulo',1);
end if;
if not exists (select * from grado_academico where descripcion = 'Pre-Kinder') then
	insert into grado_academico (descripcion,activo) values ('Pre-Kinder',1);
end if;
if not exists (select * from grado_academico where descripcion = 'Kinder') then
	insert into grado_academico (descripcion,activo) values ('Kinder',1);
end if;
if not exists (select * from grado_academico where descripcion = 'Preparatoria') then
	insert into grado_academico (descripcion,activo) values ('Preparatoria',1);
end if;

--jornada
if not exists (select * from jornada where descripcion = 'Media Jornada') then
	insert into jornada (descripcion,activo) values ('Media Jornada',1);
end if;
if not exists (select * from jornada where descripcion = 'Jornada Extendida') then
	insert into jornada (descripcion,activo) values ('Jornada Extendida',1);
end if;
if not exists (select * from jornada where descripcion = 'Jornada Completa') then
	insert into jornada (descripcion,activo) values ('Jornada Completa',1);
end if;

--carga de estado
if not exists (select * from estado where descripcion = 'Activo') then
	insert into estado (descripcion) values ('Activo');
end if;
if not exists (select * from estado where descripcion = 'Inactivo') then
	insert into estado (descripcion) values ('Inactivo');
end if;
if not exists (select * from estado where descripcion = 'Bloqueado') then
	insert into estado (descripcion) values ('Bloqueado');
end if;


---usuario administrador
if not exists (select * from usuario where correo = 'info@aatecnologias.com') then
	insert into usuario (correo, clave, id_tipo_documento, identificacion, 
	nombre, apellido, telefono, direccion, 
	id_rol, id_estado, id_genero, reset, hash_reset, fecha_creacion,fecha_actualizacion) 
	values ('admin@academia.umb.edu.co', 
	'7970c83b5156382ecfd854c2022c6561429f79acaaad4416d0996934eb12432894551603a84b5380ed79f81c51b1da9836061d4aff17f04fd5d5fd45c93a9239',
	'CC', '123456789', 
	'Super user', 'Aplicacion', '3001234567', 'Bogota', 
	(select id from rol where descripcion = 'Administrador'), 
	(select id from estado where descripcion = 'Activo'), 
	(select id from genero where descripcion = 'Masculino'), 
	0, '', current_timestamp,current_timestamp);
end if;


return 1;
end;$BODY$
LANGUAGE plpgsql VOLATILE;
---ejecuta funcion
select data_init_load();
---elimina funcion
drop function if exists data_init_load();
