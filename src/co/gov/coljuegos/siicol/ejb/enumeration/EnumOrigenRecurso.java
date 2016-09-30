package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Or&iacute;genes del Recurso.
 * @author Camilo Miranda
 */
public enum EnumOrigenRecurso 
{
    OPERADOR("O", "OPERADOR"),
    ASEGURADORA("A", "ASEGURADORA"),
    AMBOS("M", "OPERADOR Y ASEGURADORA");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumOrigenRecurso(String id, String nombre) {
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
        
        EnumOrigenRecurso[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
