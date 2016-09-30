/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 13-01-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;

/**
 * Enumerado para el Estado del Cierre Anual Contable.
 * Obtenidos de la tabla <i>SII_ESTADO_CIERRE_AN_CONT</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoCierreAnCont 
{
    BORRADOR(1L), 
    APROBADO(2L), 
    ANULADO(3L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoCierreAnCont (Long id) 
    {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
