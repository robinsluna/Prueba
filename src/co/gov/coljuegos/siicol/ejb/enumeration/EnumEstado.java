/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 06-12-2013
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado globales.
 * @author Camilo Miranda
 */
public enum EnumEstado 
{
    BORRADOR("B", "BORRADOR"),
    APROBADO("A", "APROBADO"),
    ACTIVO("S", "ACTIVO"),
    INACTIVO("N", "INACTIVO");
    
    
    /** ID del Estado */
    private String id;
    /** Nombre del Estado */
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id - ID del Estado.
     * @param nombre - Nombre del Estado.
     */
    EnumEstado (String id, String nombre) 
    {
        this.id = id;
        this.nombre =nombre;
    }

    
    /**
     * Obtiene el ID del Estado.
     * @return id
     */
    public String getId() {
        return id;
    }
    
    /**
     * Obtiene el Nombre del Estado.
     * @return nombre
     */
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
        
        EnumEstado[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
    
}
