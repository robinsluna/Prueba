/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 15-01-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado de RP.
 * Obtenidos de la tabla SII_ESTADO_RP.
 * @author Camilo Miranda
 */
public enum EnumEstadoRp {
    
    BORRADOR(1L),
    CERRADO(2L),
    REVISADO(3L),
    IMPRESO(4L),
    APROBADO(5L),
    RP_GENERADO(6L),
    RP_IMPRESO(7L),
    RP_APROBADO(8L),
    RP_ANULADO(21L),
    RECHAZADO(22L),
    DESISTIDO(9L);
    
    
    /** ID del Estado del RP. */
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoRp(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
