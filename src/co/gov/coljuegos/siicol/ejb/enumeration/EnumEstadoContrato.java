/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Christian Acosta
 * FECHA	: 12-02-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los Estados del contrato.
 * @author Christian Acosta
 */
public enum EnumEstadoContrato 
{
    ELABORADO(1L),
    PERFECCIONADO(2L),
    LEGALIZADO(3L),
    LIQUIDADO(4L),
    SUSPENDIDO(5L),
    CEDIDO(6L),
        VIGENTE(6L),
    INACTIVO(7L),
    PROYECTADO(8L),
    REVISADO_ABOGADO(9L),
    VALIDADO_FINANCIERA(10L),
    VALIDADO_GCT(11L),
    FIRMADO_COLJUEGOS(12L),
    CITADO_FIRMA_OPERADOR(13L),
    CADUCIDAD(14L),
    PRORROGA(15L),
    NO_VALIDADO_FINANCIERA(16L),
    NO_VALIDADO_GCT(17L),
    NO_VALIDADO_CCA(18L),
    VALIDADO_CCA(19L),
    TERMINACION_ANTICIPADA(20L),
    REANUDADO(21L);
    
    
    /** ID del Estado */
    private Long id;
    
    
    /**
     * Constructor.
     * @param id - ID del Estado.
     * @param nombre - Nombre del Estado.
     */
    EnumEstadoContrato (Long id) 
    {
        this.id = id;
    }

    
    /**
     * Obtiene el ID del Estado.
     * @return id
     */
    public Long getId() {
        return id;
    }
        
}
