package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para las categor&iacute;as de la Resoluci&oacute;n de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
public enum EnumCategoriaResolucionIncumContr 
{
    ORIGINA_RECURSO(1L),
    RESUELVE_RECURSO(2L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     */
    EnumCategoriaResolucionIncumContr(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
