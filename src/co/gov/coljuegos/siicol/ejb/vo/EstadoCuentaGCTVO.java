package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

/**
 * @author Giovanni
 */
public class EstadoCuentaGCTVO {
    
    //Contrato
    private String CON_CONTRATO;
    //numero contrato
    private BigDecimal CON_NUMERO;  
    //Concepto 
    private String CONCEPTO;
    //Cuota 
    private BigDecimal CUOTA;
    //Año   
    private BigDecimal ANO;
    //Mes   
    private BigDecimal MES;
    //Fecha Vencimiento 
    private Date FECHA_VENCIMIENTO;
    //Fecha Pago  
    private Date FECHA_PAGO;
    //Monto Obligación 
    private BigDecimal MONTO_OBLIGACION;
    //Monto Pago     
    private BigDecimal MONTO_PAGO;
    //Saldo       
    private BigDecimal SALDO;
    //Recaudo por clasificar   
    private BigDecimal RECAUDO_CLASIFICAR;
    //Total Interes   
    private BigDecimal TOTAL_INTERES;
    //Pagado Interes 
    private BigDecimal PAGO_INTERES;
    //Saldo Interes 
    private BigDecimal SALDO_INTERES;
    //Recaudo interés por clasificar  
    private BigDecimal RECAUDO_INTERES_CLASIFICAR;
    
    private List<EstadoCuentaGCTVO> estadoCuentaGCTVOs;
    
    public EstadoCuentaGCTVO() {
                                   
    }


    public BigDecimal getCON_NUMERO() {
        return CON_NUMERO;
    }

    public void setCON_NUMERO(BigDecimal CON_NUMERO) {
        this.CON_NUMERO = CON_NUMERO;
    }

    public String getCONCEPTO() {
        return CONCEPTO;
    }

    public void setCONCEPTO(String CONCEPTO) {
        this.CONCEPTO = CONCEPTO;
    }

    public BigDecimal getCUOTA() {
        return CUOTA;
    }

    public void setCUOTA(BigDecimal CUOTA) {
        this.CUOTA = CUOTA;
    }

    public BigDecimal getANO() {
        return ANO;
    }

    public void setANO(BigDecimal ANO) {
        this.ANO = ANO;
    }

    public BigDecimal getMES() {
        return MES;
    }

    public void setMES(BigDecimal MES) {
        this.MES = MES;
    }

    public Date getFECHA_VENCIMIENTO() {
        return FECHA_VENCIMIENTO;
    }

    public void setFECHA_VENCIMIENTO(Date FECHA_VENCIMIENTO) {
        this.FECHA_VENCIMIENTO = FECHA_VENCIMIENTO;
    }

    public Date getFECHA_PAGO() {
        return FECHA_PAGO;
    }

    public void setFECHA_PAGO(Date FECHA_PAGO) {
        this.FECHA_PAGO = FECHA_PAGO;
    }

    public BigDecimal getMONTO_OBLIGACION() {
        return MONTO_OBLIGACION;
    }

    public void setMONTO_OBLIGACION(BigDecimal MONTO_OBLIGACION) {
        this.MONTO_OBLIGACION = MONTO_OBLIGACION;
    }

    public BigDecimal getMONTO_PAGO() {
        return MONTO_PAGO;
    }

    public void setMONTO_PAGO(BigDecimal MONTO_PAGO) {
        this.MONTO_PAGO = MONTO_PAGO;
    }

    public BigDecimal getSALDO() {
        return SALDO;
    }

    public void setSALDO(BigDecimal SALDO) {
        this.SALDO = SALDO;
    }

    public BigDecimal getRECAUDO_CLASIFICAR() {
        return RECAUDO_CLASIFICAR;
    }

    public void setRECAUDO_CLASIFICAR(BigDecimal RECAUDO_CLASIFICAR) {
        this.RECAUDO_CLASIFICAR = RECAUDO_CLASIFICAR;
    }

    public BigDecimal getTOTAL_INTERES() {
        return TOTAL_INTERES;
    }

    public void setTOTAL_INTERES(BigDecimal TOTAL_INTERES) {
        this.TOTAL_INTERES = TOTAL_INTERES;
    }

    public BigDecimal getPAGO_INTERES() {
        return PAGO_INTERES;
    }

    public void setPAGO_INTERES(BigDecimal PAGO_INTERES) {
        this.PAGO_INTERES = PAGO_INTERES;
    }

    public BigDecimal getSALDO_INTERES() {
        return SALDO_INTERES;
    }

    public void setSALDO_INTERES(BigDecimal SALDO_INTERES) {
        this.SALDO_INTERES = SALDO_INTERES;
    }

    public BigDecimal getRECAUDO_INTERES_CLASIFICAR() {
        return RECAUDO_INTERES_CLASIFICAR;
    }

    public void setRECAUDO_INTERES_CLASIFICAR(BigDecimal RECAUDO_INTERES_CLASIFICAR) {
        this.RECAUDO_INTERES_CLASIFICAR = RECAUDO_INTERES_CLASIFICAR;
    }

    public List<EstadoCuentaGCTVO> getEstadoCuentaGCTVOs() {
        return estadoCuentaGCTVOs;
    }

    public void setEstadoCuentaGCTVOs(List<EstadoCuentaGCTVO> estadoCuentaGCTVOs) {
        this.estadoCuentaGCTVOs = estadoCuentaGCTVOs;
    }

    public String getCON_CONTRATO() {
        return CON_CONTRATO;
    }

    public void setCON_CONTRATO(String CON_CONTRATO) {
        this.CON_CONTRATO = CON_CONTRATO;
    }
}
