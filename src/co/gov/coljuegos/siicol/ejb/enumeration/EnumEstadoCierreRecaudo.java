package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado de Cierre-Recaudo.
 * Obtenidos de la tabla SII_ESTADO_CIERRE_REC.
 * @author Mónica Pabón
 */
public enum EnumEstadoCierreRecaudo {
    BORRADOR(1L),
    CERRADO_CONTABILIDAD(2L),
    CERRADO_TESORERIA(3L),
    CERRADO_CARTERA(4L);
        
    
    
    /** ID del Estado del cierre. */
        private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoCierreRecaudo(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
}
