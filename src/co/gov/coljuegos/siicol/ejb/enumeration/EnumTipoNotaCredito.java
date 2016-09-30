package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Nota Cr&eacute;dito.
 * @author Camilo Miranda
 */
public enum EnumTipoNotaCredito 
{
    PROVEEDOR("CPR"), 
    FUNCIONARIOS_PLANTA("CFP");
    
    
    private String id;
    
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoNotaCredito(String id) 
    {
        this.id = id;
    }

    
    
    public String getId() {
        return id;
    }
}
