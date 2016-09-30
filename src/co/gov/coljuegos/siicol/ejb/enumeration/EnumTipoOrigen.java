package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumTipoOrigen {
    CONTRATO(1L),
    RESOLUCION(2L);
    
    /** ID del Estado del cierre. */
        private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoOrigen(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    
    
}
