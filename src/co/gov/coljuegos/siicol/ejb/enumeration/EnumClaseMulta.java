package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para la Clase de Multa de un Tipo de Multa.
 * @author Camilo Miranda
 */
public enum EnumClaseMulta 
{
    DIARIA("D", "DIARIA"),
    TOTAL("T", "TOTAL");

    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumClaseMulta(String id, String nombre) 
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
        
        EnumClaseMulta[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
