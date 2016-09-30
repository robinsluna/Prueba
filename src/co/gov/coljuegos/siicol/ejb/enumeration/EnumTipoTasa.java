package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumTipoTasa {
    SUPER_BANCARIA("SB"),
    INTERES_LEGAL_CIVIL("ILC");
    
         private String id;
    
    
    /**
     * Constructor.
     */
    EnumTipoTasa(String id) 
    {
        this.id = id;
    }

    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
