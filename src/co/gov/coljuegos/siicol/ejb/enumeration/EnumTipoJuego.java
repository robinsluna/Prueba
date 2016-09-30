package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumTipoJuego {

    MAQUINAS_TRAGAMONEDAS(1L),
    JUEGOS_DE_CASINO(2L),
    OTROS(3L),
    SALONES_DE_BINGO_SILLAS(4L),
    DEMAS_JUEGOS(5L),
    RIFAS(6L),
    PROMOCIONALES(7L),
    NOVEDOSOS(8L),
    OTRAS_APUESTAS(9L),
    DECLARACION_DE_PREMIOS(10L);    
    
    /** ID. */
    private Long id;    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoJuego(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }   

}
