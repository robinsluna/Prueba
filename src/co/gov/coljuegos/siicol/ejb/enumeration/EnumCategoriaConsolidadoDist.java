/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-05-2014
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para las Categor&iacute;asa asociadas a los Consolidados de Distribuci&oacute;n y al Concepto en Cuentas Contables por Tipo Documento Contable.
 * @author Camilo Miranda
 */
public enum EnumCategoriaConsolidadoDist 
{
    CUOTAS_DERECHOS_EXPLOTACION("CU"),
    INTERESES_MORA("IM"),
    INTERESES_FINANCIACION("IF"),
    RENDIMIENTOS_FINANCIEROS("RF"),
    ACTUACIONES_ADMINISTRATIVAS("AA");
    
    
    private String id;
    
    
    /**
     * Constructor.
     */
    EnumCategoriaConsolidadoDist(String id) 
    {
        this.id = id;
    }

    
    
    public String getId() {
        return id;
    }
}
