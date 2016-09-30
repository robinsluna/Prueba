/* 
 * SISTEMA	: SIICOL
 * MODULO	: GESTION CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 11-08-2015
 */
package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los estados del Proceso de Incumplimiento Contractual.
 * Obtenidos de la tabla <i>SII_ESTADO_INCUMPL_CONTRACT</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoIncumplContract 
{
    INFORME_SUPERVISION(1L),
    BORRADOR_CITACION_AUDIENCIA(2L),
    CITACION_AUDIENCIA_FIRMADA(3L),
    CITACION_AUDIENCIA_NOTIFICADA(4L),
    AUDIENCIA_SUSPENDIDA(5L),
    AUDIENCIA_REANUDADA(6L),
    TRAMITE_RESOLUCION_SIN_SANCION(7L),
    TERMINADO_SIN_SANCION(8L),
    TRAMITE_RESOLUCION_INCUMPLIMIENTO(9L),
    TERMINADO_CON_SANCION(10L),
    BORRADOR_AUTO_ARCHIVO(11L),
    ARCHIVADO(12L),
    REPARTIDO(13L),
    AUDIENCIA_CANCELADA(14L),
    TRAMITE_RESOLUCION_RESUELVE_RECURSO_SIN_SANCION(15L),
    TRAMITE_RESOLUCION_RESUELVE_RECURSO_INCUMPLIMIENTO(16L),
    INCUMPLIMIENTO_SUPERADO(17L),
    INCUMPLIMIENTO_NO_SUPERADO(18L);
    

    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoIncumplContract(Long id) {
        this.id = id;
    }

    
    
    public Long getId() {
        return id;
    }
}
