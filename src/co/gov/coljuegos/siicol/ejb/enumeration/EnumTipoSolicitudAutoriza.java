package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Solicitud.
 * Correspondiente a la tabal SII_TIPO_SOLIC_AUTORIZA
 * @author Camilo Miranda
 */
public enum EnumTipoSolicitudAutoriza {
    
    NUEVO_OPERADOR(5L),
    CONTRATO_NUEVO(10L),
    RENOVACION_CONTRATO(20L),
    PRORROGA_CONTRATO(30L),
    CESION_CONTRATO(40L),
    ACTUALIZACION_OPERADOR(50L),
    RESPONDER_REQUERIMIENTO(60L),
    DESISTIR_SOLICITUD(70L),
    TRASLADO_AUTOMATICO(80L),
    OTRAS_NOVEDADES(90L),
        CAMBIO_ESTADO_METL(91L),
    SOLICITUD_CAMBIO_DE_ESTADO_MET_EN_LINEA(91L),
        REPORTE_CONTADORES_MET(92L),
    NUEVA_RIFA(110L),
    NUEVO_PROMOCIONAL(120L);
    


    
    /** ID del Estado del Solicitud. */
    private Long id;
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoSolicitudAutoriza(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
