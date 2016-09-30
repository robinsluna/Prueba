package co.gov.coljuegos.siicol.ejb.enumeration;



/**
 * Enumerado asociado a los Tipos de Cuenta Bancaria.
 * @author Camilo Miranda
 */
public enum EnumTipoCuentaBancaria {
    
    AHORROS("A", "AHORROS"),
    CORRIENTE("C", "CORRIENTE");
    
    
    private String id;
    private String nombre;
    
    
    
    /**
     * Constructor.
     */
    EnumTipoCuentaBancaria(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    /**
     *Obtiene el Identificador del Tipo de Cuenta Bancaria.
     * @return id
     */
    public String getId() {
        return id;
    }
    
    
    /**
     * Obtiene el Nombre del Tipo de Cuenta Bancaria.
     * @return nombre
     */
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
        
        EnumTipoCuentaBancaria[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
