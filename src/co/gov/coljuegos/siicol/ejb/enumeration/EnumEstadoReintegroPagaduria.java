package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Estados de Reintegros de Pagadur&iacute;a.
 * - Obtenidos de la columna <i>SII_REINTEGRO_INGRESO_PAG</i>.<i>RIP_ESTADO</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoReintegroPagaduria 
{
    BORRADOR("B", "BORRADOR"),
    APROBADO("A", "APROBADO"),
    ANULADO("N", "ANULADO");
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumEstadoReintegroPagaduria(String id, String nombre) 
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
        
        EnumEstadoReintegroPagaduria[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
