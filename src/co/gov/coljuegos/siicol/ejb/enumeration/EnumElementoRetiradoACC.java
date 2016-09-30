package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumElementoRetiradoACC {
    DEVOLUCION("D"),
    DECOMISO_Y_DESTRUCCION("DD"),
    DEVOLUCION_DECOMISO_Y_DESTRUCCION("DDD");
    
    private String id;
    
    EnumElementoRetiradoACC(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
