package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumEstadoOficioLiquidacion {
    BORRADOR(1L),
    VALIDADO_GNA(2L),
    VALIDADO_FINANCIERA(3L),
    LIQUIDACION_INCORRECTA(4L),
    PENDIENTE_CORRECION_SIITO(5L),
    VALIDADO_CMI(6L);
     
    private Long id;
    
    /**
     * Constructor.
     */
    EnumEstadoOficioLiquidacion(Long id) {
        this.id = id;
    }

    
    
    public Long getId() {
        return id;
    }
}
