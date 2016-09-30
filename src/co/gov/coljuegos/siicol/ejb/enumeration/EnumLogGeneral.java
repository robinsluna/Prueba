package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumLogGeneral {
    
    TIPO_INFO(1),
    TIPO_DEBUG(2),
    TIPO_ERROR(3);
    
    private Integer id;
    
    private EnumLogGeneral(Integer id) {
        this.id = id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
