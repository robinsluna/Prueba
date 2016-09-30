/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 29-10-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Cartera.
 * @author Camilo Miranda
 */
public enum EnumTipoCartera 
{
    CORRIENTE("C", "CORRIENTE"),
    DIFICIL_COBRO("D", "DIFÍCIL RECAUDO");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     */
    EnumTipoCartera(String id, String nombre) {
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
        
        EnumTipoCartera[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
