package co.gov.coljuegos.siicol.ejb.enumeration;

public enum EnumCategoriaDistrib {
    
    LOCALIZADOS(1L),
    PROMOCIONALES(2L),
    RIFAS(3L),
    HIPICOS_GALLISTICOS(4L),
    ACTUACIONES_ADMINISTRATIVAS(5L),
    INTERESES_DE_MORA(6L),
    INTERESES_DE_FINANCIACION(7L),
    LEGALIZACION_DE_ANTICIPOS(8L);
    
    /** ID de la Categoria */
    private Long id;

    /**
     * Constructor.
     * @param id
     */
    EnumCategoriaDistrib(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
