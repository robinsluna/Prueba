/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 09-12-2013
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Ubicaci&oacute;n.
 * @author Camilo Miranda
 */
public enum EnumTipoUbicacion 
{
    PAIS(1L),
    DEPARTAMENTO(2L),
    CIUDAD(3L),
    BARRIO(4L);
    
    
    /** C&oacute;digo de la Ubicaci&oacute;n. */
    private Long tiuCodigo;
    
    
    /**
     * Constructor.
     * @param tiuCodigo
     */
    EnumTipoUbicacion(Long tiuCodigo) 
    {
        this.tiuCodigo = tiuCodigo;
    }
    
    
    /**
     * Obtiene el c&oacute;digo de la Ubicaci&oacute;n.
     * @return tiuCodigo
     */
    public Long getTiuCodigo() {
        return tiuCodigo;
    }
    
}
