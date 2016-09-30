package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para las Clases de Juego.
 * @author Camilo Miranda
 */
public enum EnumClaseJuego 
{
    LOCALIZADOS(1L),
    NOVEDOSOS(2L),
    PROMOCIONALES(3L),
    RIFAS(4L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumClaseJuego (Long id) 
    {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
