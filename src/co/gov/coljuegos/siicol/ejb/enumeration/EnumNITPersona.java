package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para el manejo de NITs de Personas Jur&iacute;dicas a trav&eacute;s del nombre de la Raz&oacute;n Social.
 * @author Camilo Miranda
 */
public enum EnumNITPersona {
    
    FOSYGA("900462447"),
    COLCIENCIAS("899999296");
    
    
    private String perNumIdentificacion;
    
    
    
    /**
     * Constructor.
     */
    EnumNITPersona(String perNumIdentificacion) 
    {
        this.perNumIdentificacion = perNumIdentificacion;
    }

    
    
    public String getPerNumIdentificacion() {
        return perNumIdentificacion;
    }
}
