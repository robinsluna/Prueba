package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Estados de Tr&aacute;mite de Resoluci&oacute;n de Procesos Sancionatorios.
 * @author Camilo Miranda
 */
public enum EnumEstadoTramResPrSan 
{
    BORRADOR(1L, "BORRADOR"),
    REVISADO_PROFESIONAL_GCT(2L, "REVISADO PROFESIONAL GCT"),
    REVISADO_COORDINADOR(3L, "REVISADO COORDINADOR"),
    FIRMADO(4L, "FIRMADO"),
    EN_NUMERACION(5L, "EN NUMERACI�N"),
    NOTIFICADO(6L, "NOTIFICADO"),
    CONFIRMADO_EN_RECURSO_REPOSICION(7L, "CONFIRMADO EN RECURSO REPOSICI�N"),
    REVOCADO_PARCIALMENTE_EN_RECURSO_REPOSICION(8L, "REVOCADO PARCIALMENTE EN RECURSO REPOSICI�N"),
    REVOCADO_EN_RECURSO_REPOSICION(9L, "REVOCADO EN RECURSO REPOSICI�N"),
    CONFIRMADO_EN_RECURSO_APELACION(10L, "CONFIRMADO EN RECURSO APELACI�N"),
    REVOCADO_PARCIALMENTE_EN_RECURSO_APELACION(11L, "REVOCADO PARCIALMENTE EN RECURSO APELACI�N"),
    REVOCADO_EN_RECURSO_APELACION(12L, "REVOCADO EN RECURSO APELACI�N"),
    EN_FIRME(13L, "EN FIRME");
    
    
    private Long id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumEstadoTramResPrSan(Long id, String nombre) {
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
        
        EnumEstadoTramResPrSan[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
