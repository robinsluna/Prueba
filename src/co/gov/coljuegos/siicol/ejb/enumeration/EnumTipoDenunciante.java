package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumTipoDenunciante {
    ANONIMO("A"),
    PERSONA_NATURAL("N"),
    PERSONA_JURIDICA("J"),
    ENTIDAD_DEL_ESTADO("E"),
    COLJUEGOS("C");
    
    
    private String id;
    
    
    EnumTipoDenunciante(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
