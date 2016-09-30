package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumEstadoAcuerdoPago {
    BORRADOR(1L),
    APROBADO_COMITE(2L),
    NEGADO_COMITE(3L),
    COMITE_MODIFICATORIO(4L),
    RESOLUCION(5L),
    RESOLUCION_MODIFICATORIA(6L),
    FIRMADO(7L),
    INCUMPLIDO(8L),
    RETIRADO(9L),    
    TERMINADO(10L);
   
    
    /** ID del Estado del RP. */
    private Long id;    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoAcuerdoPago(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
