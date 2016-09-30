/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-01-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado de Modificaci&oacute;n del RP.
 * Obtenidos de la tabla SII_ESTADO_MODIFIC_RP.
 * @author Camilo Miranda
 */
public enum EnumEstadoModificRP {
    BORRADOR(1L),
    REVISADO(2L),
    APROBADO(3L),
    RECHAZADO(4L);
    
    
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoModificRP (Long id) {
        this.id = id;
    }
    
    
    
    public Long getId() {
        return id;
    }
}
