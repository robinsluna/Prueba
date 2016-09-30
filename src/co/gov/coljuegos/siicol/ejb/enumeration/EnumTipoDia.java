package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de D&iacute;as.
 * - Obtenido de la columna <i>SII_TERMINOS_PROCESALES</i>.<i>TPR_TIPO_DIA</i>.
 * @author Camilo Miranda
 */
public enum EnumTipoDia 
{
    HABIL("H", "HÁBIL(ES)"),
    CALENDARIO("C", "DIARIO(S)");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoDia (String id, String nombre) {
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
        
        EnumTipoDia[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
