package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Multa.
 * @author Camilo Miranda
 */
public enum EnumTipoMulta 
{
    POLIZA(1L, "PÓLIZA"),
    GENERAL(2L, "GENERAL"),
    TRASLADO(3L, "TRASLADO"),
    CLAUSULA_PENAL(4L, "CLÁUSULA PENAL");
    
    
    private Long id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     * @param nombre
     */
    EnumTipoMulta (Long id, String nombre) 
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
    public static String getNombreById (String id) 
    {
        String nombre = null;
        
        EnumTipoMulta[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
