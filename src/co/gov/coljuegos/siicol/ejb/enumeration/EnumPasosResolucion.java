package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumPasosResolucion {

    REVISADO(1L,"REVISADO"),
    FIRMADO(2L,"FIRMADO"),
    EN_NUMERACION(3L,"EN NUMERACION"),
    NOTIFICADO(4L,"NOTIFICADO"),
    INTERPONE_RECURSO(5L,"INTERPONE RECURSO"), 
    CONFIRMADO(6L,"CONFIRMADO"),
    REVOCADO_PARCIALMENTE(7L,"REVOCADO PARCIALMENTE"),
    REVOCADO(8L,"REVOCADO");
    
    private Long id;
    private String nombre;

    EnumPasosResolucion(Long id, String nombre) {
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
