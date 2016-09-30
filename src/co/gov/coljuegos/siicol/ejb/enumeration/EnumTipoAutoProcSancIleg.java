package co.gov.coljuegos.siicol.ejb.enumeration;

/**
 * Enumerado para el Tipo de Auto para los Procesos Sancionatorios de Ilegalidad.
 * - Obtenido de la columna <i>SII_AUTO_DECRETA_PRUE_PRO_ILE</i>.<i>ATP_TIPO_AUTO</i>.
 * @author Camilo Miranda
 */
public enum EnumTipoAutoProcSancIleg 
{
    DECRETA_PRUEBAS("D"),
    NIEGA_PRUEBAS("N"),
    TRASLADO_ALEGATOS("T");
    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoAutoProcSancIleg(String id) {
        this.id = id;
    }

    
    
    public String getId() {
        return id;
    }
}
