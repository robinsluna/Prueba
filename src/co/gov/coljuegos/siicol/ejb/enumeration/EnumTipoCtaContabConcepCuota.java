/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 29-10-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Value Object para las Cuentas Contables asociadas a cada Concepto de Cuota.
 * Columna: <i>SII_CTA_CONTAB_CONCEP_CUOTA.CCC_TIPO</i>.
 * @author Camilo Miranda
 */
public enum EnumTipoCtaContabConcepCuota 
{
    NORMAL("N"),
    DIFICIL_COBRO("D");
    
    
    private String id;
    
    
    
    /**
     * Constructor.
     */
    EnumTipoCtaContabConcepCuota(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
