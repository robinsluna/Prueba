/* 
 * SISTEMA	: SIICOL
 * AUTOR	: M�nica Pab�n
 * FECHA	: 11-08-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los indicadores de la liquidaci�n del oficio
 * @author M�nica Pab�n
 */
public enum EnumIndicadorLiquidacion 
{
    LIQUIDACION_ACTUAL("A"),
    LIQUIDACION_MODIFICACION("M"),
    LIQUIDACION_NUEVA("N");
    
    
    private String id;
    
    
    /**
     * Constructor.
     */
    EnumIndicadorLiquidacion(String id) 
    {
        this.id = id;
    }

    
    
    public String getId() {
        return id;
    }
}
