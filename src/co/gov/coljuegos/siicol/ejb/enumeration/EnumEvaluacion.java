/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 17-12-2013
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Evaluaci&oacute;n.
 * @author Camilo Miranda
 */
public enum EnumEvaluacion 
{
    CUMPLE("S", "CUMPLE"),
    NO_CUMPLE("N", "NO CUMPLE");
    
    
    /** ID del resultado de Evaluaci&oacute;n. */
    private String id;
    /** Nombre del resultado de la Evaluaci&iacute;n. */
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id - ID del resultado de Evaluaci&oacute;n.
     * @param nombre - Nombre del resultado de la Evaluaci&iacute;n.
     */
    EnumEvaluacion(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    /**
     * Obtiene el nombre del Enumerado a partir del ID.
     * @param id
     * @return enum.id
     */
    public static String getNombreById (Long id) 
    {
        String nombre = null;
        
        EnumEvaluacion[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
    
}
