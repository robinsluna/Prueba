package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Decisi&oacute;n de una Resoluci&oacute;n.
 * @author Camilo Miranda
 */
public enum EnumTipoDecisionResolucion 
{
    CONFIRMA("C", "CONFIRMA"),
    REVOCA("R", "REVOCA"),
    REVOCA_PARCIALMENTE("P", "REVOCA PARCIALMENTE"),
    RECHAZA("Z","RECHAZA EL RECURSO");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumTipoDecisionResolucion(String id, String nombre) 
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
        
        EnumTipoDecisionResolucion[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
