package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los tipos de Archivo para descarga.
 * @author Christian Acosta
 */

public enum EnumTipoArchivo {
    PDF(1),
    EXCEL(2),
    WORD(3),
    XML(4),
    OTRO(5);
    
    
    /** ID del Estado de la Evaluaci&iacute;n. */
    private int id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoArchivo (int id) {
        this.id = id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
