package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el manejo de Estados de los Tr&aacute;mites de Resoluci&oacute;n Sin Sanci&oacute;n.
 * Obtenidos de la tabla <i>SII_ESTADO_RESOLUC_SAN_CON</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoResolucSanCon 
{
    REVISADO_PROFESIONAL_GCT(1L, "REVISION PROFESIONAL DE GCT"),
    REVISADO_COORDINADOR(2L, "REVISION COORDINADOR"),
    FIRMADO(3L, "FIRMA"),
    NOTIFICADO(4L, "NOTIFICACION"),
    CONFIRMADO(5L, "CONFIRMADO"),
    REVOCADO_PARCIALMENTE(6L, "REVOCADO PARCIALMENTE"),
    REVOCADO(7L, "REVOCADO"),
    EN_FIRME(8L, "EN FIRME"),
    EN_NUMERACION(9L, "EN NUMERACIÓN");
    
    
    private Long id;
    private String nombre;
    
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoResolucSanCon(Long id, String nombre) 
    {
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
        
        EnumEstadoResolucSanCon[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
