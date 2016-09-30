/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-03-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los Destinos para Recaudo Sin Clasificar.
 * @author Camilo Miranda
 */
public enum EnumDestinoRecaudoSinClasificar 
{
    COLJUEGOS("CJ", "COLJUEGOS"),
    ENTES_TERRITORIALES("ET", "ENTES TERRITORIALES");
    
    
    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumDestinoRecaudoSinClasificar(String id, String nombre) 
    {
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
        
        EnumDestinoRecaudoSinClasificar[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
