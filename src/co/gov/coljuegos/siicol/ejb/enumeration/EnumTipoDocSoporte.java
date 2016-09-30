package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumTipoDocSoporte {
    
    NOMINA(1L),
    SERVICIOS_PUBLICOS(2L),
    CONTRATACION(3L),
    VIATICOS(4L),
    IMPUESTOS(5L),
    TRANSFERENCIAS(6L),
    CAPACITACION(7L),
    ADICION_VIGENCIA_FUTURA(8L),
    CAJA_MENOR(9L),
    HONORARIOS_JUNTA_DIRECTIVA(10L),
    OTROS_CONCEPTOS(11L),
    CONTRATO_NUEVO_VIGENCIA_FUTURA(12L),
    SUSTITUCION_DE_LA_APROPIACION_VIGENCIA_FUTURA(13L);
    private Long id;    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoDocSoporte(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
