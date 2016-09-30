package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumTipoNovedad {

    ADICION_ELEMENTOS(10L),
    CADUCIDAD(80L),
    CAMBIO_APUESTA(60L),
    CREACION_LOCAL(50L),
    CREACION_LICENCIA_ACDV(90L),
    ELEMENTOS_BODEGA(70L),
    CAMBIO_ESTADO_METL(11L),
    PRORROGA_CONTRATO(200L),
    REEMPLAZO_ELEMENTOS(40L),
    REINICIO(85L),
    RETIRO_ELEMENTOS(20L),
    SUSPENSIÓN_CONTRATO(210L),
    TERMINACION_ANTICIPADA_CONTRATO(230L),
    TERMINACION_SUSPENSION_CONTRATO(220L),
    TRASLADO_ELEMENTOS(30L);
    
    /** ID del Estado de la Novedad. */
    private Long id;

    /**
     * Constructor.
     * @param id
     */
    EnumTipoNovedad(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
