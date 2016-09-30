package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumTipoLogAuditoria {
    GENERAL("G"),
    ESTADOS("E"),
    ACTIVIDADES("A"),
    MODIFICACIONES("M");
    
    
    private String id;
    
    EnumTipoLogAuditoria(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
