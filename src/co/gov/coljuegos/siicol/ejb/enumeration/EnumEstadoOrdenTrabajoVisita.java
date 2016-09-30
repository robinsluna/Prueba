/* 
 * SISTEMA	: SIICOL
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 22-09-2015
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los Estados del contrato.
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public enum EnumEstadoOrdenTrabajoVisita
{
    BORRADOR("B"),
    APROBADO("A"),
    ANULADO("N");

    
    /** ID del Estado */
    private String id;
    
    /**
     * Constructor
     * @param id 
     */
    EnumEstadoOrdenTrabajoVisita (String id) 
    {
        this.id = id;
    }

    
    /**
     * Obtiene el ID del Estado.
     * @return id
     */
    public String getId() {
        return id;
    }
        
}
