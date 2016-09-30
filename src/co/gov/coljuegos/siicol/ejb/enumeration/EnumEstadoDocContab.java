/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-02-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los Estados de Documentos Contables.
 * @author Camilo Miranda
 */
public enum EnumEstadoDocContab 
{
    BORRADOR(1L, "BORRADOR"),
    APROBADO(2L, "APROBADO"),
    ANULADO(3L, "ANULADO");
    
    
    
    /** ID del Estado */
    private Long id;
    /** Nombre del Estado */
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id - ID del Estado.
     * @param nombre - Nombre del Estado.
     */
    EnumEstadoDocContab (Long id, String nombre) 
    {
        this.id = id;
        this.nombre =nombre;
    }

    
    /**
     * Obtiene el ID del Estado.
     * @return id
     */
    public Long getId() {
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
    public static String getNombreById (Long id) 
    {
        String nombre = null;
        
        EnumEstadoDocContab[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
    
}
