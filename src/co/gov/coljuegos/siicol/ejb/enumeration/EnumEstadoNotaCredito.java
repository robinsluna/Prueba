/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-06-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Estados de las Notas de Cr&eacute;dito.
 * @author Camilo Miranda
 */
public enum EnumEstadoNotaCredito 
{
    BORRADOR("B", "BORRADOR"),
    APROBADO("A", "APROBADO"),
    ANULADO("N", "ANULADO"),
    REINTEGRADO("R", "REINTEGRADO");
    
    
    private String id;
    private String nombre;
    
    
    
    /**
     * Constructor.
     */
    EnumEstadoNotaCredito(String id, String nombre) {
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
        
        EnumEstadoNotaCredito[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
