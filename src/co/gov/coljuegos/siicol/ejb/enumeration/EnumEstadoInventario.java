package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumEstadoInventario {

    //A para activo, PR para pendiente de Retiro, PA para pendiente de activación y R para retirado
    PENDIENTE_ACTIVACION("PA", "PENDIENTE_ACTIVACIÓN"),
    PENDIENTE_RETIRO("PR", "PENDIENTE RETIRO"),
    RETIRADO("R", "RETIRADO"),
    ACTIVO("A", "ACTIVO"),
    INACTIVO("I", "INACTIVO"),
    ELEMENTO_EN_BODEGA("B", "ELEMENTO EN BODEGA");

    private String id;
    private String nombre;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoInventario(String id, String nombre) {
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
        
        EnumEstadoInventario[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
