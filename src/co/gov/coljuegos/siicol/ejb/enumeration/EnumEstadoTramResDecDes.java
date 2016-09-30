/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 30-10-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;

/**
 * Enumeraci�n que gestiona los estados de tr�mites de resoluciones de decomiso y destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
 */

public enum EnumEstadoTramResDecDes {
    
    REVISADO(1L, "REVISADO"),
    EN_FIRME(2L, "EN FIRME"),
    EN_NUMERACION(3L, "EN NUMERACI�N"),
    CONFIRMADO(4L, "CONFIRMADO"),
    REVOCADO_PARCIALMENTE(5L, "REVOCADO PARCIALMENTE"),
    REVOCADO(6L, "REVOCADO"),
    FIRMADO(7L, "FIRMADO"),
    NOTIFICADO(8L, "NOTIFICADO"),
    NUMERADO(9L, "NUMERADO");
    
    private Long id;
    private String nombre;
    
    /**
     * Constructor
     * @param id
     * @param nombre
     */
    
    EnumEstadoTramResDecDes(Long id, String nombre) {
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
        
        EnumEstadoTramResDecDes[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
