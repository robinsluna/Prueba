/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 24-01-2014
 */

package co.gov.coljuegos.siicol.ejb.enumeration;


/**
 * Enumerado asociado a los Tipos de Documento Contable.
 * Obtenidos de la tabla <b>SII_TIPO_DOC_CONTABLE</b>.
 * @author Camilo Miranda
 */
public enum EnumTipoDocContable 
{
    OBLIGACION_PROVEEDOR("OPR"),
    PAGO_PROVEEDOR("PPR"),
    INTERES_CUOTA("INM"), //interes diario
    RECIBO_PAGO_BANCOS("RPB"),
    SALDOS_FINALES_VIGENCIA_FISCAL("SFI"),
    INTERES_DE_MORA("INM"),
    AMORTIZACION_CONTRATOS_CONCESION("ACC"),
    TRASLADO_RECURSOS_INSTITUCIONES_FINANCIERAS("TRF"),
    
    PAGO_NO_PRESUPUESTAL("PNP"),
    AMORTIZACION_CONTRATOS_DE_CONCESION("ACC"),
    TRASLADO_A_PAGADURIA("TPE"),
    DEPRECIACION_DE_PROPIEDAD_PLANTA_Y_EQUIPO("MDP"),
    AMORTIZACION_DE_ACTIVOS("MAM"),
    JUEGO_NOVEDOSO_BALOTO("MJB"),
    JUEGO_NOVEDOSO_SUPERASTRO("MJS"),
    NOMINA("MNM"),
    AMPLIACION_CONTRATOS_DE_CONCESION("MAC"),
    JUEGO_PROMOCIONAL("MJP"),
    RECIBO_DE_PAGO_CAPTURA_MANUAL("RPM"),
    OBLIGACION_FUNCIONARIOS_DE_PLANTA("OFP"),
    PAGO_FUNCIONARIOS_PLANTA("PFP"),
    OBLIGACION_ENTES_TERRITORIALES("OET"),
    PAGO_ENTES_TERRITORIALES("PET"),
    PAGO_CUENTAS_POR_PAGAR("PCP"),
    CIERRE_DE_VIGENCIA_FISCAL("CVF"), 
    CIERRE_DE_CUENTAS_DE_IMPUESTOS("CCI"), 
    CIERRE_DE_CUENTAS_BANCARIAS("CCB"),
    NOTA_CREDITO_PROVEEDORES("CPR"),
    NOTA_CREDITO_FUNCIONARIOS_PLANTA("CFP"),
    CADUCIDAD("CCD"),
    CLAUSULA_PENAL("CLP"),
    INCUMPLIMIENTO_CONTRACTUAL("ICC"),
    SANCION_POR_FISCALIZACION("SPF");


    
    
    private String id;
    
    
    /**
     * Constructor.
     * @param id
     */
    EnumTipoDocContable(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }
}
