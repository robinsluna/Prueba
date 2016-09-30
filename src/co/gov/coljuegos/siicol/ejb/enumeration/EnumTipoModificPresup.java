/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-02-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Modificaci&oacute;n Presupuestal.
 * @author Camilo Miranda
 */
public enum EnumTipoModificPresup {
    
    ADICION("A", "ADICIÓN"),
    REDUCCION("R", "REDUCCIÓN"),
    TRASLADO("T", "TRASLADO");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumTipoModificPresup(String id, String nombre) {
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
        
        EnumTipoModificPresup[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
