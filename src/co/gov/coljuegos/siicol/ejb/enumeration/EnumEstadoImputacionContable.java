/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 28-01-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado de Imputaci&oacute;n Contable.
 * @author Camilo Miranda
 */
public enum EnumEstadoImputacionContable {
    BORRADOR("B", "BORRADOR"),
    ACTIVO("A", "ACTIVO"),
    INCONSISTENTE("I", "INCONSISTENTE");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoImputacionContable(String id, String nombre) {
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
        
        EnumEstadoImputacionContable[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
