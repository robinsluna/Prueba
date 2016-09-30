package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para las categor&iacute;as de Resoluci&oacute;n de un Proceso Sancionatorio.
 * @author Camilo Miranda
 */
public enum EnumCategoriaResolucionProcSanc 
{
    RESOLUCION_CON_SANCION(1L),
    RESOLUCION_SIN_SANCION(2L),
    RESOLUCION_RECURSO_REPOSICION(3L),
    RESOLUCION_RECURSO_APELACION(4L);

    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumCategoriaResolucionProcSanc(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
