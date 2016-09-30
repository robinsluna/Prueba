package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Solicitud.
 * @author Camilo Miranda
 */
public enum EnumTipoSolicitud {
    
    CONTRATO_NUEVO(10L),
    PRORROGA_CONTRATO(30L),
    ACTUALIZACION_OPERADOR(50L),
    DESISTIR_SOLICITUD(70L),
    TRASLADO_AUTOMATICO(80L),
    OTRAS_NOVEDADES(90L);
    
    /** ID del Estado del Solicitud. */
    private Long id;
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoSolicitud(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
