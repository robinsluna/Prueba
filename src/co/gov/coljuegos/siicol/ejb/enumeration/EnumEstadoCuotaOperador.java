package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los estados de Cuota Operador.
 * - Obtenido de la columna <i>SII_CUOTA_OPERADOR</i>.<i><b>COP_CANCELADA</b></i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoCuotaOperador 
{
    //SI("S", "CANCELADA"),
    NO_CANCELADA("N", "NO CANCELADA"),
    CANCELADA("C", "CANCELADA"),
    INACTIVA("I", "INACTIVA"),
    TEMPORAL("T", "TEMPORAL"),
    ACTIVA("A", "ACTIVA");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumEstadoCuotaOperador(String id, String nombre) 
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
        
        EnumEstadoCuotaOperador[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
