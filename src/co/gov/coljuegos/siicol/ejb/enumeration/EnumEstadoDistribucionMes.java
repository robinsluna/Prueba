package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado de Distribucion - Mes.
 * Obtenidos de la tabla SII_ESTADO_DISTRIB_ENTE.
 * @author Mónica Pabón
 */

public enum EnumEstadoDistribucionMes {
    BORRADOR(1L),
    APROBADO(2L),
    ANULADO(3L),
    CERRADO(4L);
    
    
    
    
    /** ID del Estado de la distribucion. */
        private Long id;
   
       /**
     * Constructor.
     * @param id
     */
     EnumEstadoDistribucionMes(Long id) {
       this.id = id;
    }
   
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
