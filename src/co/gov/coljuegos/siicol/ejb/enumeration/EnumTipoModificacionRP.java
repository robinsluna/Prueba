/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-12-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Modificaci&oacute;n RP.
 * @author Camilo Miranda
 */
public enum EnumTipoModificacionRP {
    
    DECREMENTO("D", "DECREMENTO"),
    INCREMENTO("I", "INCREMENTO");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumTipoModificacionRP(String id, String nombre) {
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
        
        EnumTipoModificacionRP[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
