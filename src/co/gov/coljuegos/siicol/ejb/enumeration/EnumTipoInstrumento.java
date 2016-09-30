package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumTipoInstrumento {

    MET(1L),
    BINGO(2L),
    MESA_DE_CASINO(3L),
    OTRO(4L),
    ACDV(5L),
    MET_DJSA(6L);
    
    
    /** ID del Estado del RP. */
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoInstrumento(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
