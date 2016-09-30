package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumResolucionDesisSolAut {
    PROYECTADO("P", "PROYECTADO"),
    EN_FIRME("F", "EN FIRME");
    
    private String id;
    private String nombre;
    
    
    EnumResolucionDesisSolAut(String id, String nombre) {
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
        
        EnumResolucionDesisSolAut[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
