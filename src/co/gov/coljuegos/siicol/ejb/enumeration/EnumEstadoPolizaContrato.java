package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumEstadoPolizaContrato {

    BORRADOR_OFICIO_APROBACION(1L),
    APROBADO(2L),
    BORRADOR_REQUERIMIENTO_OPERADOR(3L),
    BORRADOR_INFORME_FALTA_POLIZA(4L),
    REQUERIMIENTO_OPERADOR(5L),
    INACTIVO(6L);

    /** ID del Estado de la Novedad. */
    private Long id;

    /**
     * Constructor.
     * @param id
     */
    EnumEstadoPolizaContrato(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
