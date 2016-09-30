/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para la Modalidad de Conceptos Cuota.
 * @author Camilo Miranda
 */
public enum EnumModalidadConceptoCuota 
{
    LOCALIZADOS("L");
    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumModalidadConceptoCuota (String id) 
    {
        this.id = id;
    }

    
    
    public String getId() {
        return id;
    }
}
