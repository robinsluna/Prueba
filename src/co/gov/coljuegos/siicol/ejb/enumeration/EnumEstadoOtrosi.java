package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumEstadoOtrosi {
    
    PROYECTADO(1L),
    REVISADO_ABOGADO(2L),
    VALIDADO_FINANCIERA(3L),
    VALIDADO_GCT(4L),
    FIRMADO_COLJUEGOS(5L),
    CITADO_FIRMA_OPERADOR(6L),
    PERFECCIONADO(7L),
    NO_VALIDADO_CCA(8L),
    VALIDADO_CCA(9L),
    NO_VALIDADO_FINANCIERA(10L),
    NO_VALIDADO_GCT(11L),
    LEGALIZADO(12L);
    

    /** ID del Estado */
    private Long id;


    /**
     * Constructor.
     * @param id - ID del Estado.
     * @param nombre - Nombre del Estado.
     */
    EnumEstadoOtrosi(Long id) {
        this.id = id;
    }


    /**
     * Obtiene el ID del Estado.
     * @return id
     */
    public Long getId() {
        return id;
    }
}
