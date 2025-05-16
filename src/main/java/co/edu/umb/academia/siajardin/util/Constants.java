package co.edu.umb.academia.siajardin.util;

public interface Constants {

    //constantes string
    public static final String S_UNABLE_TO_PROCESS_INPUT = "Imposible procesar solicitud";
    public static final String S_RELOJ_NOT_FOUND = "El numero de serie del reloj no esta registrado";
    public static final String S_MARCA_PERIODO_CLOSE = "Marcacion procesada en tabla temporal por periodo cerrado";
    public static final String S_MARCA_PROCESADA = "Marcacion procesada correctamente";
    public static final String S_MARCA_NO_PROCESADA_DUPLICADA = "Marcacion duplicada, no se pudo procesar";
    public static final String S_DATE_AND_TIME_INVALID = "Fecha y/o Hora invalidos";
    public static final String S_DATE_INVALID = "Fecha invalida";
    public static final String S_IDENTIFICACION_NO_PRESENT = "Identificacion no presente en solicitud";
    public static final String S_SERIALNUMBER_NO_PRESENT = "serialnumber no presente en solicitud";
    public static final String S_COLABORADOR_INDETERMINADO = "No se pudo encontrar el colaborador por el numero de identificacion";
    public static final String S_LONG_ID = "Longitud_IdMarcacion";
    public static final String S_CODIGO_TURNO1_INVALIDO = "Codigo de turno 1 invalido";
    public static final String S_CODIGO_TURNO2_INVALIDO = "Codigo de turno 2 invalido";
    public static final String S_TURNO_PROCESADO = "Turno procesado correctamente";
    public static final String S_TURNO_NO_RECIBIDOS = "No se recibieron turnos para procesar";
    public static final String S_TURNO_PERIODO_CERRADO = "No se puede procesar la solicitud por periodo cerrado";
    public static final String S_VALUE_Y = "Y";
    public static final String S_VALUE_N = "N";
    public static final String S_VALUE_EMPTY = "";
    public static final String S_VALUE_ACTIVO_TRUE = "true";
    public static final String S_SOLICITUD_CORRECTA = "Solicitud correctamente procesada";
    public static final String S_REGISTRO_DUPLICADO = "Registro duplicado";
    public static final String S_PATTERN_DATE = "yyyy-MM-dd";
    public static final String S_NOVEDAD_DUPLICADA = "Ya existe una novedad creada con los mismos datos";
    //mensajes de colaboradores
    public static final String S_COLABORADOR_TIPO_DOC_INVALIDO = "Tipo de documento no determinado";
    public static final String S_COLABORADOR_EMPRESA_INVALIDO = "Empresa no determinada";
    public static final String S_COLABORADOR_CARGO_INVALIDO = "Cargo no determinado";
    public static final String S_COLABORADOR_ORGANIGRAMA_INVALIDO = "Organigrama no determinado";
    public static final String S_COLABORADOR_GRUPO_HORARIO_INVALIDO = "Grupo de Horario no determinado";
    public static final String S_COLABORADOR_CENTRO_COSTO_INVALIDO = "Centro de costo no determinado";
    public static final String S_COLABORADOR_POLITICA_PAGO_INVALIDO = "Politica de pago no determinada";
    public static final String S_COLABORADOR_FECHA_INGRESO_INVALIDO = "Fecha ingreso invalida";
    public static final String S_COLABORADOR_FECHA_RETIRO_INVALIDO = "Fecha retiro invalida";
    public static final String S_COLABORADOR_VALOR_ACTIVO_INVALIDO = "Valor del campo activo no valido, se espera valores true/false";
    public static final String S_COLABORADOR_NOMBRES_INVALIDO = "campo nombres no presente o vacio";
    public static final String S_COLABORADOR_APELLIDOS_INVALIDO = "campo apellidos no presente o vacio";
    public static final String S_COLABORADOR_IDENTIFICACION_INVALIDO = "campo doc_identificacion no presente o vacio";
    public static final String S_COLABORADOR_CREADO = "Colaborador correctamente creado";
    public static final String S_COLABORADOR_ACTUALIZADO = "Colaborador correctamente actualizado";
    public static final String S_LICENCIA_EXCEDE_EMPLEADOS = "Su licencia a llegado al limite de colaboradores permitidos";
    //cierre periodo
    public static final String S_CIERRE_PERIODO_NO_DEFINIDO = "Periodo de cierre no definido en el sistema";
    public static final String S_CIERRE_PERIODO_RECUPERADO = "Periodo de cierre recuperado";
    public static final String S_CIERRE_HABILITADO = "Habilitado";
    public static final String S_CIERRE_DESHABILITADO = "Deshabilitado";
    //constantes int
    public static final int N_ID_DEFAULT_FUNCION_MARCACION = 255;
    public static final int N_ID_FUNCION_ENTRADA_MARCACION = 100;
    public static final int N_ID_FUNCION_SALIDA_MARCACION = 120;
    public static final int N_ZERO = 0;
    public static final int N_ONE = 1;
    public static final int N_STATUS_ACTIVO = 1;
    public static final int ID_INTERFACE_ZK = 5;

    //estado usuarios
    public static final int N_INACTIVO_2 = 2;
    public static final int N_ACTIVO_1 = 1;
    public static final int N_BLOQUEADO_3 = 3;

    //mensajes estados
    public static final String S_USUARIO_INACTIVO = "Usuario Inactivo";
    public static final String S_USUARIO_BLOQUEADO = "Usuario Bloqueado";
    public static final String S_USUARIO_NO_AUTORIZADO = "Usuario No Autorizado";
    public static final String S_USUARIO_CLAVE_INVALIDA = "Clave Invalida";

    //mensaje de clave
    public static final String S_CLAVE_ACTUAL_NO_COINCIDE = "La clave actual ingresada no coincide";
    public static final String S_CLAVE_NUEVA_Y_CONFIRMACION_INVALIDA = "La clave nueva y la confirmación no coinciden";
    public static final String S_CLAVE_CORRENCTAMENTE_CAMBIADA = "La clave ha sido correctamente cambiada";

    interface EnumDays {

        public static int DOMINGO = 0;
        public static int LUNES = 1;
        public static int MARTES = 2;
        public static int MIERCOLES = 3;
        public static int JUEVES = 4;
        public static int VIERNES = 5;
        public static int SABADO = 6;
    }

    //eventos bitacora
    public static final String S_EVENTO_INICIO_SESION = "Inicio de sesión";
    public static final String S_EVENTO_CIERRE_SESION = "Cierre de sesión";
    public static final String S_BUSQUEDA_INFORMACION = "Busqueda";
    public static final String S_ACTUALIZACION_INFORMACION = "Actualización";
    public static final String S_CREACION_INFORMACION = "Creación";
    public static final String S_ELIMINAR_INFORMACION = "Eliminación";
    public static final String S_INTEGRACION_TURNO = "Integración turno";
    public static final String S_INTEGRACION_COLABORADOR = "Integración Colaborador";
    public static final String S_GENERACION_REPORTE = "Generación Reporte";
    public static final String S_INTEGRACION_MARCACION = "Integración marcación";

    //iniciar servicios de workers
    public static int N_START_SERVICE = 1;

    ///tipos de dia
    public static final int N_ORDINARIO_0 = 0;
    public static final int N_DOMINICAL_1 = 1;
    public static final int N_FESTIVO_2 = 2;
    public static final String S_DOMINGO = "Domingo";

    //estados novedades_ds_fc
    public static int N_ESTADO_DSFC_PROCESADO = 1;
    public static int N_ESTADO_DSFC_NO_PROCESADO = 2;

    //formato PDF
    public static final String PDF_FORMAT = ".pdf";
    
    //value para turnos vacios
    public static final String S_EMPTY = "EMPTY";
}
