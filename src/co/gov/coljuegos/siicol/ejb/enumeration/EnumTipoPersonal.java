package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumTipoPersonal {

    REVISOR_FISCAL(1L),
    CONTACTO_EMPRESA(2L),
    APODERADO(3L),
    SOCIO_MAYORITARIO(4L),
    CONTADOR(5L),
    REPRESENTANTE_LEGAL_SUPLENTE(11L),
    REVISOR_FISCAL_SUPLENTE(12L),
    REPRESENTANTE_LEGAL(13L),
    SOCIO_MAYORITARIO_1(6L),
    SOCIO_MAYORITARIO_2(7L),
    SOCIO_MAYORITARIO_3(8L),
    SOCIO_MAYORITARIO_4(9L),
    SOCIO_MAYORITARIO_5(10L);


    /** ID del Estado de la Novedad. */
    private Long id;

    /**
     * Constructor.
     * @param id
     */
    EnumTipoPersonal(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
