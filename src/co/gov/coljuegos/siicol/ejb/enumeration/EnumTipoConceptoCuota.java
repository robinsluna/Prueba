package co.gov.coljuegos.siicol.ejb.enumeration;


public enum EnumTipoConceptoCuota {   
    
    CUOTA("CU"),
    INTERESMORA("IM"),
    INTERESFINANCIACION("IF");
    
    
    
    /** tipo concepto cuota*/
    private String tipoConceptoCuota;
    
    
    /**
     * Constructor.
     * @param tipoConceptoCuota
     */
    EnumTipoConceptoCuota(String tipoConceptoCuota) {
        this.tipoConceptoCuota = tipoConceptoCuota;
    }


    /**
     * Obtiene el Path Relativo.
     * @return relativePath
     */
    
    public String getTipoConceptoCuota() {
        return tipoConceptoCuota;
    }
}
