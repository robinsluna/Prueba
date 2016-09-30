/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-07-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los Tipos de Documento de Soporte.
 * Obtenidos de la tabla <i>SII_TIPO_DOC_SOP_SOLIC_PAGO</i>.
 * @author Camilo Miranda
 */
public enum EnumTipoDocSopSolicPago {
    
    FACTURA(1L),
    CUENTA_COBRO(2L),
    RESOLUCION(3L),
    ACTA(4L),
    COMPROBANTE_CONTABLE(5L),
    CONTRATO(6L),
    DECLARACIONES_TRIBUTARIAS(7L),
    DECRETO(8L),
    POLIZA(9L),
    NOMINA(10L),
    PUBLICACION(11L),
    NOTA_CREDITO(12L),
    NOTA_DEBITO(13L),
    SOLICITUD(14L),
    OFICIO(15L),
    RECIBO_OFICIAL_DE_PAGO(16L),
    DISTRIBUCION(17L);
    
    
    private Long id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoDocSopSolicPago(Long id) {
        this.id = id;
    }

    
    
    public Long getId() {
        return id;
    }
}
