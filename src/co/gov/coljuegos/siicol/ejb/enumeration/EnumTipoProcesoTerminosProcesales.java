package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Proceso de T&eacute;rminos Procesales.
 * @author Camilo Miranda
 */
public enum EnumTipoProcesoTerminosProcesales 
{
    FISCALIZACION("F"),
    ILEGALIDAD("I");
    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoProcesoTerminosProcesales (String id) 
    {
        this.id = id;
    }

    
    
    public String getId() {
        return id;
    }
}
