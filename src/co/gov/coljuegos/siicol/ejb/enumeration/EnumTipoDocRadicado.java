/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: Contratación
 * AUTOR	: Diego Alvarado
 * FECHA	: 13-01-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Documento Radicado.
 * @author Diego Alvarado
 */
public enum EnumTipoDocRadicado 
{
    TARJETA_PROFESIONAL(3L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoDocRadicado (Long id) 
    {
        this.id = id;
    }

    
    public Long getId() {
        return id;
    }
}
