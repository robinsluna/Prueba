package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los M&oacute;dulos del Proceso Sancionatorio de Ilegalidad.
 * - Obtenido de la tabla <i>SII_MODULO</i>.
 * @author Camilo Miranda
 */
public enum EnumModuloProcesoSancIleg 
{
    ILEGALIDAD_INICIO_PROCESO_SANCIONATORIO_ILEGALIDAD("Ilegalidad - Inicio Proceso Sancionatorio Ilegalidad"),
    //ILEGALIDAD_PROYECTO_COMUNICACION_INICIO_ACTUACION_ADMINISTRATIVA("Ilegalidad - Proyecto comunicación inicio actuación administrativa"),
    ILEGALIDAD_COMUNICACION_INICIO_ACTUACION_ADMINISTRATIVA_FIRMADA("Ilegalidad - Comunicación inicio actuación administrativa firmada"),
    ILEGALIDAD_RESULTADO_DEL_ENVIO_DE_LA_COMUNICACION("Ilegalidad - Resultado del envío de la comunicación"),
    ILEGALIDAD_PROYECTO_AUTO_DE_FORMULACION_DE_CARGOS("Ilegalidad - Proyecto auto de formulación de cargos"),
    //ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_DE_FORMULACION_DE_CARGOS("Ilegalidad - Solicitud numeración auto de formulación de cargos"),
    ILEGALIDAD_RECEPCION_DE_DESCARGOS("Ilegalidad - Recepción de descargos"),
    ILEGALIDAD_PROYECTO_AUTO_QUE_DECRETA_PRUEBAS("Ilegalidad - Proyecto auto que decreta pruebas"),
    //ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_QUE_DECRETA_PRUEBAS("Ilegalidad - Solicitud numeración auto que decreta pruebas"),
    ILEGALIDAD_PROYECTO_AUTO_QUE_NIEGA_PRUEBAS_Y_CORRE_TRASLADO_ALEGATOS("Ilegalidad - Proyecto auto que niega pruebas y corre traslado alegatos"),
    //ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_QUE_NIEGA_PRUEBAS_Y_CORRE_TRASLADO_ALEGATOS("Ilegalidad - Solicitud numeración auto que niega pruebas y corre traslado alegatos"),
    ILEGALIDAD_PROYECTO_AUTO_DE_TRASLADO_PARA_ALEGATOS("Ilegalidad - Proyecto auto de traslado para alegatos"),
    //ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_TRASLADO_PARA_ALEGATOS("Ilegalidad - Solicitud numeración auto traslado para alegatos"),
    ILEGALIDAD_TRAMITE_RESOLUCION_SIN_SANCION("Ilegalidad - Trámite Resolución Sin Sanción"),
    ILEGALIDAD_TRAMITE_RESOLUCION_SANCIONATORIA("Ilegalidad - Trámite Resolución Sancionatoria"),
    ILEGALIDAD_TRAMITE_RECURSO_DE_REPOSICION_A_LA_RESOLUCION("Ilegalidad - Trámite Recurso de reposición a la Resolución"),
    ILEGALIDAD_TRAMITE_RECURSO_DE_APELACION_A_LA_RESOLUCION("Ilegalidad - Trámite Recurso de apelación a la Resolución"),
    ILEGALIDAD_PROYECTO_AUTO_DE_ARCHIVO("Ilegalidad - Proyecto auto de archivo"),
    ILEGALIDAD_SOLICITUD_NUMERACION_AUTO_DE_ARCHIVO("Ilegalidad - Solicitud numeración auto de archivo"),
    ILEGALIDAD_AUTORIZACION_DE_LA_NOTIFICACION_AL_CORREO_ELECTRONICO("Ilegalidad - Autorización de la notificación al correo electrónico");
    
    
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
