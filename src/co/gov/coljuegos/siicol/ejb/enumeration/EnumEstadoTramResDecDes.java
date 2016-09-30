/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 30-10-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;

/**
 * Enumeración que gestiona los estados de trámites de resoluciones de decomiso y destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public enum EnumEstadoTramResDecDes {
    
    REVISADO(1L, "REVISADO"),
    EN_FIRME(2L, "EN FIRME"),
    EN_NUMERACION(3L, "EN NUMERACIÓN"),
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
