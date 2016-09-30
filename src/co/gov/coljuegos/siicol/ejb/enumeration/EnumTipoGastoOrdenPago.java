/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-05-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Gasto de Ordenes de Pago.
 * @author Camilo Miranda
 */
public enum EnumTipoGastoOrdenPago {
    
    GASTOS_GENERALES("GG", "GASTOS GENERALES"),
    GASTOS_PERSONAL("GP", "GASTOS PERSONAL"),
    RECURSOS_PROPIOS("RP", "RECURSOS PROPIOS");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumTipoGastoOrdenPago (String id, String nombre) {
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
        
        EnumTipoGastoOrdenPago[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
