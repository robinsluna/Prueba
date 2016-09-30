package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumEstadoTramResProcIleg {
    BORRADOR(1L),
    REVISADO_PROFESIONAL_GPCOI(2L),
    FIRMADO(3L),
    COMUNICADO(4L),
    EN_NUMERACION(5L),
    CONFIRMADO_EN_RECURSO_REPOSICION(6L),
    REVOCADO_PARCIALMENTE_EN_RECURSO_REPOSICION(7L),
    REVOCADO_EN_RECURSO_REPOSICION(8L),
    EN_FIRME(9L),
    NOTIFICADO(10L),
    REVISADO_COORDINADOR(11L),
    CONFIRMADO_EN_RECURSO_APELACION(12L),
    REVOCADO_PARCIALMENTE_EN_RECURSO_APELACION(13L),
    REVOCADO_EN_RECURSO_APELACION(14L),
    NUMERADO(15L); 
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoTramResProcIleg(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
    
}
