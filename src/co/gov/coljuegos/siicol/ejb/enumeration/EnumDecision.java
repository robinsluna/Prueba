/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 24-01-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a la toma de Decisiones.
 * @author Camilo Miranda
 */
public enum EnumDecision {
    SI("S", "SI"),
    NO("N", "NO"),
    NO_APLICA("NA", "NO APLICA");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumDecision(String id, String nombre) 
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
        
        EnumDecision[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
