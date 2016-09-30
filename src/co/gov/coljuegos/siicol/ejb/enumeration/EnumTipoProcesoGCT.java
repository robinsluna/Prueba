package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Tipos de Proceso de Gesti&oacute;n Contractual.
 * @author Camilo Miranda
 */
public enum EnumTipoProcesoGCT 
{
    INCUMPLIMIENTO_CONTRACTUAL(1L),
    SANCIONATORIO_FISCALIZACION(2L),
    SANCIONATORIO_ILEGALIDAD(3L);
    
    
    private Long id;
    
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoProcesoGCT(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
