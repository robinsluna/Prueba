/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 13-01-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Cuenta Contable.
 * @author Camilo Miranda
 */
public enum EnumTipoCuentaContable 
{
    ACUMULATIVA("A"),
    CUENTA_DE_MOVIMIENTO("M");
    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoCuentaContable (String id) 
    {
        this.id = id;
    }

    
    public String getId() {
        return id;
    }
}
