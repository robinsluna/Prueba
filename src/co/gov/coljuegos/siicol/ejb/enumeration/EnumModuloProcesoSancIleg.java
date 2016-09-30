package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los M&oacute;dulos del Proceso Sancionatorio de Ilegalidad.
 * - Obtenido de la tabla <i>SII_MODULO</i>.
 * @author Camilo Miranda
 */
public enum EnumModuloProcesoSancIleg 
{
    ILEGALIDAD_INICIO_PROCESO_SANCIONATORIO_ILEGALIDAD("Ilegalidad - Inicio Proceso Sancionatorio Ilegalidad"),
    //ILEGALIDAD_PROYECTO_COMUNICACION_INICIO_ACTUACION_ADMINISTRATIVA("Ilegalidad - Proyecto comunicaci�n inicio actuaci�n administrativa"),
    ILEGALIDAD_COMUNICACION_INICIO_ACTUACION_ADMINISTRATIVA_FIRMADA("Ilegalidad - Comunicaci�n inicio actuaci�n administrativa firmada"),
    ILEGALIDAD_RESULTADO_DEL_ENVIO_DE_LA_COMUNICACION("Ilegalidad - Resultado del env�o de la comunicaci�n"),
    ILEGALIDAD_PROYECTO_AUTO_DE_FORMULACION_DE_CARGOS("Ilegalidad - Proyecto auto de formulaci�n de cargos"),
    //ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_DE_FORMULACION_DE_CARGOS("Ilegalidad - Solicitud numeraci�n auto de formulaci�n de cargos"),
    ILEGALIDAD_RECEPCION_DE_DESCARGOS("Ilegalidad - Recepci�n de descargos"),
    ILEGALIDAD_PROYECTO_AUTO_QUE_DECRETA_PRUEBAS("Ilegalidad - Proyecto auto que decreta pruebas"),
    //ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_QUE_DECRETA_PRUEBAS("Ilegalidad - Solicitud numeraci�n auto que decreta pruebas"),
    ILEGALIDAD_PROYECTO_AUTO_QUE_NIEGA_PRUEBAS_Y_CORRE_TRASLADO_ALEGATOS("Ilegalidad - Proyecto auto que niega pruebas y corre traslado alegatos"),
    //ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_QUE_NIEGA_PRUEBAS_Y_CORRE_TRASLADO_ALEGATOS("Ilegalidad - Solicitud numeraci�n auto que niega pruebas y corre traslado alegatos"),
    ILEGALIDAD_PROYECTO_AUTO_DE_TRASLADO_PARA_ALEGATOS("Ilegalidad - Proyecto auto de traslado para alegatos"),
    //ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_TRASLADO_PARA_ALEGATOS("Ilegalidad - Solicitud numeraci�n auto traslado para alegatos"),
    ILEGALIDAD_TRAMITE_RESOLUCION_SIN_SANCION("Ilegalidad - Tr�mite Resoluci�n Sin Sanci�n"),
    ILEGALIDAD_TRAMITE_RESOLUCION_SANCIONATORIA("Ilegalidad - Tr�mite Resoluci�n Sancionatoria"),
    ILEGALIDAD_TRAMITE_RECURSO_DE_REPOSICION_A_LA_RESOLUCION("Ilegalidad - Tr�mite Recurso de reposici�n a la Resoluci�n"),
    ILEGALIDAD_TRAMITE_RECURSO_DE_APELACION_A_LA_RESOLUCION("Ilegalidad - Tr�mite Recurso de apelaci�n a la Resoluci�n"),
    ILEGALIDAD_PROYECTO_AUTO_DE_ARCHIVO("Ilegalidad - Proyecto auto de archivo"),
    ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_DE_ARCHIVO("Ilegalidad - Solicitud numeraci�n auto de archivo"),
    ILEGALIDAD_AUTORIZACION_DE_LA_NOTIFICACION_AL_CORREO_ELECTRONICO("Ilegalidad - Autorizaci�n de la notificaci�n al correo electr�nico");
    
    
    private String nombre;
    
    
    /**
     * Constructor.
     * @param nombre
     */
    EnumModuloProcesoSancIleg (String nombre) 
    {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }
}
