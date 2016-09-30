/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 11-02-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Estado de Modificaci&oacute;n Presupuestal.
 * Obtenidos de la tabla SII_ESTADO_MODIF_PRESUP.
 * @author Camilo Miranda
 */
public enum EnumEstadoModifPresup {
    
    BORRADOR(1L, "BORRADOR"),
    ANULADO(2L, "ANULADO"),
    AUTORIZADO(3L, "AUTORIZADO"),
    CERRADO(4L, "CERRADO");
    
    
    private Long id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumEstadoModifPresup (Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public Long getId() {
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
    public static String getNombreById (Long id) 
    {
        String nombre = null;
        
        EnumEstadoModifPresup[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
    
}
