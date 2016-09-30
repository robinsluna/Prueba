package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumEstadoCdp {
    
    BORRADOR(1L),
    CERRADO(2L),
    REVISADO(3L),
    IMPRESO(4L),
    APROBADO(5L),
    CDP_REGISTRADO(6L),
    CDP_IMPRESO(7L),
    CDP_APROBADO(8L),
    DESISTIDO(9L),    
    RECHAZADO(10L),
    CDP_ANULADO(11L);
    
    /** ID del Estado del RP. */
    private Long id;    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoCdp(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
