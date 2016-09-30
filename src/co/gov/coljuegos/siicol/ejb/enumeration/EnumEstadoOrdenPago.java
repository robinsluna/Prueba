package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumEstadoOrdenPago {

    BORRADOR(1L, "BORRADOR"),
    APROBADO(2L, "APROBADO"),
    ANULADO(3L, "ANULADO"),
    PAGADO(4L, "PAGADO");

    private Long id;
    private String nombre;

    EnumEstadoOrdenPago(Long id, String nombre) {
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
        
        EnumEstadoOrdenPago[] enums = values();
        
        int i=0;
        while (i<enums.length && nombre==null) {
            if (enums[i].getId().equals(id))
                nombre = enums[i].getNombre();
            i++;
        }
        
        return (nombre);
    }
}
