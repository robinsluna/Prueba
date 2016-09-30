package co.gov.coljuegos.siicol.ejb.enumeration;

/**
 * Enumerado asociado a los tipos de Estado de Cierre-Recaudo.
 * Obtenidos de la tabla SII_ESTADO_OBLIG_NO_PRES.
 * @author Mónica Pabón
 */
public enum EnumEstadoObligacionNoPresupuestal {
    BORRADOR(1L),
    APROBADO(2L),
    PAGADO(3L),
    ANULADO(4L);

    /** ID del Estado del cierre. */
        private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoObligacionNoPresupuestal(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    
}
