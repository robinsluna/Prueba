package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado para los Estados de Proceso Sancionatorio.
 * - Obtenidos de la tabla <i>SII_ESTADO_PROCESO_SANC</i>.
 * @author Camilo Miranda
 */
public enum EnumEstadoProcesoSanc 
{
    BORRADOR_COMUNICACION_INICIO(1L),
    COMUNICACION_INICIO_FIRMADA(2L),
    RESULTADO_ENVIO_COMUNICACION_INICIO(3L),
    BORRADOR_AUTO_FORMULACION_CARGOS(4L),
    AUTO_FORMULACION_CARGOS_EN_NUMERACION(5L),
    BORRADOR_AUTO_DECRETA_PRUEBAS(6L),
    AUTO_DECRETA_PRUEBAS_EN_NUMERACION(7L),
    BORRADOR_AUTO_TRASLADO_ALEGATOS(8L),
    AUTO_TRASLADO_ALEGATOS_EN_NUMERACION(9L),
    TRAMITE_RESOLUCION_SIN_SANCION(10L),
    TRAMITE_RECURSO_REPOSICION(11L),
    TRAMITE_RECURSO_APELACION(12L),
    TERMINADO_SIN_SANCION(13L),
    TERMINADO_CON_SANCION(14L),
    BORRADOR_AUTO_ARCHIVO(15L),
    AUTO_ARCHIVO_EN_NUMERACION(16L),
    REPARTIDO(17L),
    AUTO_FORMULACION_CARGOS_NOTIFICADO(18L),
    AUTO_TRASLADO_ALEGATOS_COMUNICADO(19L),
    AUTO_DECRETA_PRUEBAS_COMUNICADO(20L),
    INFORME_SUPERVISION(21L),
    TRAMITE_RESOLUCION_CON_SANCION(22L),
    ARCHIVADO(23L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoProcesoSanc(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
