package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumEstadoResolucAut {
    PROYECTADO(1L),
    REVISION_ABOGADO(2L),
    NOTIFICADO_Y_EN_TERMINOS(3L),
    EN_FIRMA(4L),
    FIRMADO(5L),
    EN_FIRME(6L),
    OPERADOR_EN_MORA(7L),
    VALIDADO_FINANCIERA(8L),
    VALIDADO_GCT(9L),
    NO_VALIDADO_FINANCIERA(10L),
    NO_VALIDADO_GCT(11L),
    NUMERADO(12L);
    
    private Long id;
    
    EnumEstadoResolucAut(Long id) {
        this.id = id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
}
