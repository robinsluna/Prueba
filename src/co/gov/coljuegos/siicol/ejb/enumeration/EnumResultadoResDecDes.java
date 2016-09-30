package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumResultadoResDecDes {
    
    
    DEVOLUCION(1L,"DEVOLUCION"),
    DECOMISO_Y_DESTRUCCION(2L,"DECOMISO Y DESTRUCCION"),
    DEVOLUCION_DECOMISO_Y_DESTRUCCION(3L,"DEVOLUCION DECOMISO Y DESTRUCCION"),
    CONFIRMA(4L,"CONFIRMA"),
    REVOCA(5L,"REVOCA"),
    REVOCA_PARCIALMENTE(6L,"REVOCA PARCIALMENTE");
               
               
    private Long id;
    private String nombre;

    
    
    EnumResultadoResDecDes(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


}
