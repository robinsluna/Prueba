package co.gov.coljuegos.siicol.ejb.enumeration;

/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC y TESORERIA
 * AUTOR	: Christian Acosta
 * FECHA	: 20-12-2013
 */

/**
 * Enumerado asociado a los tipos de Estado de Solicitudes de Pago.
 * Obtenidos de la tabla SII_ESTADO_SOLIC_PAGO.
 * @author Christian Acosta
 */
public enum EnumEstadoSolicPago 
{
    REVISADO_TESORERIA(1L),
    DEVUELTO_AL_SUPERVISOR(2L),
    DEVUELTO_AL_PROVEEDOR(3L),
    OBLIGACION(4L),
    ORDEN_PAGO(5L);
    
    
    /** ID del Estado de la Evaluaci&iacute;n. */
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumEstadoSolicPago (Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
}
