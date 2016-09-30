package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Conceptos de Liquidaci&oacute;n Mes.
 * - Obtenidos de la columna <i>SII_LIQUIDACION_MES</i>.<i>LIQ_CONCEPTO</i>.
 * @author Camilo Miranda
 */
public enum EnumConceptoLiquidacion 
{
    DERECHOS_DE_EXPLOTACION("DE", "DERECHOS DE EXPLOTACIÓN"), 
    GASTOS_DE_ADMINISTRACION("GA", "GASTOS DE ADMINISTRACIÓN");
    
    
    
    private String id;
    private String nombre;
    
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumConceptoLiquidacion(String id, String nombre) 
    {
        this.id = id;
        this.nombre = nombre;
    }

    
    
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    /**
     * Obtiene el nombre del Enumerado a partir del ID.
     * @param id
     * @return enum.id
     */
    public static String getNombreById (String id) 
    {
        String nombre = null;
        
        EnumConceptoLiquidacion[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
