package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumEstadoObligacion {
   BORRADOR(1L),
   APROBADO(2L),
   DEVUELTO_A_TESORERIA(3L),
    ANULADO(4L);
    
    
    private Long id;
    
    
    
    /**
     * Constructor.
     */
    EnumEstadoObligacion(Long id) {
        this.id = id;
    }

    
    
    public Long getId() {
        return id;
    }
}


