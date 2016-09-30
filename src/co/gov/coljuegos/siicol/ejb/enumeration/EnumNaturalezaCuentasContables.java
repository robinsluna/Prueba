/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 23-01-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a la Naturaleza de la Cuenta Contable.
 * @author Camilo Miranda
 */
public enum EnumNaturalezaCuentasContables 
{
    DEBITO("D", "DÉBITO"),
    CREDITO("C", "CRÉDITO");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumNaturalezaCuentasContables (String id, String nombre) {
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
        
        EnumNaturalezaCuentasContables[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
