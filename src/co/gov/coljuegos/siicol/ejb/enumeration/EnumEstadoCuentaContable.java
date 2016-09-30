package co.gov.coljuegos.siicol.ejb.enumeration;

/**
 * Enumerado para el Estado de la Cuenta Contable.
 * - Obtenido de la tabla <i>SII_ESTADO_CUENTA_CONTABLE</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoCuentaContable 
{
    ACTIVO(1L, "ACTIVO"),
    BLOQUEADO(2L, "BLOQUEADO"),
    RETIRADO(3L, "RETIRADO");
    

    private Long id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumEstadoCuentaContable(Long id, String nombre) 
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
        
        EnumEstadoCuentaContable[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
