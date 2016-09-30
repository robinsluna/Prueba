package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el Indicador de la parametrizaci&oacute;n de Cuentas Contables por Tipo Documento Contable.
 * - Obtenido de la columna <i>SII_CUENTA_CONT_TIPO_DOC_CONT</i>.<i>CCT_INDICADOR1</i>.
 * @author Camilo Miranda
 */
public enum EnumIndicadorCuentaContTipoDocCont 
{
    CUOTA("CUOTA"),
    TOTAL("TOTAL");
    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumIndicadorCuentaContTipoDocCont (String id) 
    {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
