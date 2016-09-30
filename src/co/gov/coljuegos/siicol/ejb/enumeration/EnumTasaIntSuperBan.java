package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumTasaIntSuperBan {
    
    SIMPLE("S"),
    COMPUESTO("C");
    
    private String id;
    
    EnumTasaIntSuperBan(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
