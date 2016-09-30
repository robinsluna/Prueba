/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 30-12-2014
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el manejo de Estados de Detalle Rubro Vigencia Futura.
 * @author Camilo Miranda.
 */
public enum EnumEstadoDetRubroVigenFutura 
{
    ACTIVO("A", "ACTIVO"),
    INACTIVO("I", "INACTIVO");
    
    
    private String id;
    private String nombre;

    
    /**
     * Constructor.
     * @param id - ID del Estado.
     * @param nombre - Nombre del Estado.
     */
    EnumEstadoDetRubroVigenFutura(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
        
        EnumEstadoDetRubroVigenFutura[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
