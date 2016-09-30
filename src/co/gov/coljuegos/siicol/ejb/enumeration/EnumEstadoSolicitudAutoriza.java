package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumEstadoSolicitudAutoriza {
    REVISADO(1L),
    SOLIC_ESTADO_REVISADO(1L),
    OFICIO_LIQUIDACION(2L),
    RESOLUCION_AUTORIZACION(3L),
    CONTRATO_PERFECCIONADO(4L),
    CONTRATO_LEGALIZADO(5L),
    OTROSI_PERFECCIONADO(6L),
    OTROSI_LEGALIZADO(7L),
    APROBADO(8L),
    OFICIO_LIQUIDACION_EN_TRAMITE(9L),
    CONTRATO_EN_TRAMITE(10L),
    RESOLUCION_AUTORIZACION_EN_TRAMITE(11L),
    DESISTIDO(12L),
    REGISTRADO(13L),
    OTROSI_EN_TRAMITE(14L),
    DESISTIDO_TACITO(15L),
    DESISTIDO_EXPRESO(16L),
    PROCESO_FINALIZADO_EN_RESOLUCION(17L),
    PROCESO_FINALIZADO_EN_OTROSI(18L),
    ANULADO(19L),
    PROCESO_FINALIZADO_TRASLADO_AUTOMATICO(20L);
    

    /** ID del Estado de la sOLICITUD aUTORIZACIÓN. */
    private Long id;

    /**
     * Constructor.
     * @param id
     */
    EnumEstadoSolicitudAutoriza(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
