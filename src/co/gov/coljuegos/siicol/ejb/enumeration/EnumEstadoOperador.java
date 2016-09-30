package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Estados del Operador.
 * - Obtenido de la columna <i>SII_OPERADOR</i>.<i>OPE_ESTADO</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoOperador 
{
    HABILITADO("H", "HABILITADO"),
    INHABILITADO("I", "INHABILITADO");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumEstadoOperador(String id, String nombre) 
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
        
        EnumEstadoOperador[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
