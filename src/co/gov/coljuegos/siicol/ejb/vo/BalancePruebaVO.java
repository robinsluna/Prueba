/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 26-02-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;


/**
 * Value Object para el Balance de Prueba.
 * @author Camilo Miranda
 */
public class BalancePruebaVO implements Comparable<BalancePruebaVO> {
    
    private String cuentaContable;
    private Long ccoCodigo;
    private String nombreCuentaContable;
    private Long perCodigo;
    private String tipoIdentificacion;
    private String perNumIdentificacion;
    private Integer perDigitoVerif;
    private String razonSocial;
    private Long dcoCodigo;
    private Integer dcoNumeroCompr;
    private String tdcCodigo;
    private String nombreTipoDocContable;
    private Date dcoFechaOper;
    private BigDecimal dcoValor;
    private String ffcCodigo;
    private String nombreFuenteFinContab;
    private Long idCentroCostos;
    private String nombreCentroCostos;
    private Long idEstadoDocContab;
    private String estadoDocContab;
    private String ccoNivel1;
    private String ccoNivel2;
    private String ccoNivel3;
    private String ccoNivel4;
    private String ccoNivel5;
    private String imcTipoMovim;
    private String nombreTipoMovim;
    private BigDecimal movimientoCredito;
    private BigDecimal movimientoDebito;
    private BigDecimal saldoAnterior;
    
    
    
    /**
     * Constructor.
     */
    public BalancePruebaVO() { }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(T)
     */
    public int compareTo (BalancePruebaVO bpVO) {
        int resultado = -1;
        if (this.cuentaContable!=null && bpVO.getCuentaContable()!=null)
            resultado = this.cuentaContable.compareTo(bpVO.getCuentaContable());
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) 
    {
        boolean igual = false;
        if (o instanceof PersonaVO) {
            BalancePruebaVO bpVO = (BalancePruebaVO) o;
            if (bpVO!=null) {
                igual = ( (bpVO.cuentaContable!=null && bpVO.cuentaContable.equals(this.cuentaContable)) || (bpVO.cuentaContable==null && this.cuentaContable==null) ) && 
                        ( (bpVO.ccoCodigo!=null && bpVO.ccoCodigo.equals(this.ccoCodigo)) || (bpVO.ccoCodigo==null && this.ccoCodigo==null) ) &&
                        ( (bpVO.nombreCuentaContable!=null && bpVO.nombreCuentaContable.equals(this.nombreCuentaContable)) || (bpVO.nombreCuentaContable==null && this.nombreCuentaContable==null) ) && 
                        ( (bpVO.perCodigo!=null && bpVO.perCodigo.equals(this.perCodigo)) || (bpVO.perCodigo==null && this.perCodigo==null) ) && 
                        ( (bpVO.tipoIdentificacion!=null && bpVO.tipoIdentificacion.equals(this.tipoIdentificacion)) || (bpVO.tipoIdentificacion==null && this.tipoIdentificacion==null) ) && 
                        ( (bpVO.perNumIdentificacion!=null && bpVO.perNumIdentificacion.equals(this.perNumIdentificacion)) || (bpVO.perNumIdentificacion==null && this.perNumIdentificacion==null) ) && 
                        ( (bpVO.perDigitoVerif!=null && bpVO.perDigitoVerif.equals(this.perDigitoVerif)) || (bpVO.perDigitoVerif==null && this.perDigitoVerif==null) ) && 
                        ( (bpVO.razonSocial!=null && bpVO.razonSocial.equals(this.razonSocial)) || (bpVO.razonSocial==null && this.razonSocial==null) ) && 
                        ( (bpVO.perNumIdentificacion!=null && bpVO.perNumIdentificacion.equals(this.perNumIdentificacion)) || (bpVO.perNumIdentificacion==null && this.perNumIdentificacion==null) ) && 
                        ( (bpVO.dcoCodigo!=null && bpVO.dcoCodigo.equals(this.dcoCodigo)) || (bpVO.dcoCodigo==null && this.dcoCodigo==null) ) && 
                        ( (bpVO.dcoNumeroCompr!=null && bpVO.dcoNumeroCompr.equals(this.dcoNumeroCompr)) || (bpVO.dcoNumeroCompr==null && this.dcoNumeroCompr==null) ) && 
                        ( (bpVO.tdcCodigo!=null && bpVO.tdcCodigo.equals(this.tdcCodigo)) || (bpVO.tdcCodigo==null && this.tdcCodigo==null) ) && 
                        ( (bpVO.nombreTipoDocContable!=null && bpVO.nombreTipoDocContable.equals(this.nombreTipoDocContable)) || (bpVO.nombreTipoDocContable==null && this.nombreTipoDocContable==null) ) && 
                        ( (bpVO.dcoFechaOper!=null && bpVO.dcoFechaOper.equals(this.dcoFechaOper)) || (bpVO.dcoFechaOper==null && this.dcoFechaOper==null) ) && 
                        ( (bpVO.dcoValor!=null && bpVO.dcoValor.equals(this.dcoValor)) || (bpVO.dcoValor==null && this.dcoValor==null) ) && 
                        ( (bpVO.ffcCodigo!=null && bpVO.ffcCodigo.equals(this.ffcCodigo)) || (bpVO.ffcCodigo==null && this.ffcCodigo==null) ) && 
                        ( (bpVO.nombreFuenteFinContab!=null && bpVO.nombreFuenteFinContab.equals(this.nombreFuenteFinContab)) || (bpVO.nombreFuenteFinContab==null && this.nombreFuenteFinContab==null) ) && 
                        ( (bpVO.idCentroCostos!=null && bpVO.idCentroCostos.equals(this.idCentroCostos)) || (bpVO.idCentroCostos==null && this.idCentroCostos==null) ) && 
                        ( (bpVO.idEstadoDocContab!=null && bpVO.idEstadoDocContab.equals(this.idEstadoDocContab)) || (bpVO.idEstadoDocContab==null && this.idEstadoDocContab==null) ) && 
                        ( (bpVO.estadoDocContab!=null && bpVO.estadoDocContab.equals(this.estadoDocContab)) || (bpVO.estadoDocContab==null && this.estadoDocContab==null) ) && 
                        ( (bpVO.ccoNivel1!=null && bpVO.ccoNivel1.equals(this.ccoNivel1)) || (bpVO.ccoNivel1==null && this.ccoNivel1==null) ) && 
                        ( (bpVO.ccoNivel2!=null && bpVO.ccoNivel2.equals(this.ccoNivel2)) || (bpVO.ccoNivel2==null && this.ccoNivel2==null) ) && 
                        ( (bpVO.ccoNivel3!=null && bpVO.ccoNivel3.equals(this.ccoNivel3)) || (bpVO.ccoNivel3==null && this.ccoNivel3==null) ) && 
                        ( (bpVO.ccoNivel4!=null && bpVO.ccoNivel4.equals(this.ccoNivel4)) || (bpVO.ccoNivel4==null && this.ccoNivel4==null) ) && 
                        ( (bpVO.ccoNivel5!=null && bpVO.ccoNivel5.equals(this.ccoNivel5)) || (bpVO.ccoNivel5==null && this.ccoNivel5==null) ) && 
                        ( (bpVO.imcTipoMovim!=null && bpVO.imcTipoMovim.equals(this.imcTipoMovim)) || (bpVO.imcTipoMovim==null && this.imcTipoMovim==null) ) && 
                        ( (bpVO.nombreTipoMovim!=null && bpVO.nombreTipoMovim.equals(this.nombreTipoMovim)) || (bpVO.nombreTipoMovim==null && this.nombreTipoMovim==null) ) && 
                        ( (bpVO.movimientoCredito!=null && bpVO.movimientoCredito.equals(this.movimientoCredito)) || (bpVO.movimientoCredito==null && this.movimientoCredito==null) ) && 
                        ( (bpVO.movimientoDebito!=null && bpVO.movimientoDebito.equals(this.movimientoDebito)) || (bpVO.movimientoDebito==null && this.movimientoDebito==null) ) && 
                        ( (bpVO.saldoAnterior!=null && bpVO.saldoAnterior.equals(this.saldoAnterior)) || (bpVO.saldoAnterior==null && this.saldoAnterior==null) ) && 
                        ( (bpVO.nombreCentroCostos!=null && bpVO.nombreCentroCostos.equals(this.nombreCentroCostos)) || (bpVO.nombreCentroCostos==null && this.nombreCentroCostos==null) );
            }
        }
        return (igual);
    }
    
    

    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public String getCuentaContable() {
        return cuentaContable;
    }

    public void setCcoCodigo(Long ccoCodigo) {
        this.ccoCodigo = ccoCodigo;
    }

    public Long getCcoCodigo() {
        return ccoCodigo;
    }

    public void setNombreCuentaContable(String nombreCuentaContable) {
        this.nombreCuentaContable = nombreCuentaContable;
    }

    public String getNombreCuentaContable() {
        return nombreCuentaContable;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setPerNumIdentificacion(String perNumIdentificacion) {
        this.perNumIdentificacion = perNumIdentificacion;
    }

    public String getPerNumIdentificacion() {
        return perNumIdentificacion;
    }

    public void setPerDigitoVerif(Integer perDigitoVerif) {
        this.perDigitoVerif = perDigitoVerif;
    }

    public Integer getPerDigitoVerif() {
        return perDigitoVerif;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setDcoCodigo(Long dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    public Long getDcoCodigo() {
        return dcoCodigo;
    }

    public void setDcoNumeroCompr(Integer dcoNumeroCompr) {
        this.dcoNumeroCompr = dcoNumeroCompr;
    }

    public Integer getDcoNumeroCompr() {
        return dcoNumeroCompr;
    }

    public void setTdcCodigo(String tdcCodigo) {
        this.tdcCodigo = tdcCodigo;
    }

    public String getTdcCodigo() {
        return tdcCodigo;
    }

    public void setNombreTipoDocContable(String nombreTipoDocContable) {
        this.nombreTipoDocContable = nombreTipoDocContable;
    }

    public String getNombreTipoDocContable() {
        return nombreTipoDocContable;
    }

    public void setDcoFechaOper(Date dcoFechaOper) {
        this.dcoFechaOper = dcoFechaOper;
    }

    public Date getDcoFechaOper() {
        return dcoFechaOper;
    }

    public void setDcoValor(BigDecimal dcoValor) {
        this.dcoValor = dcoValor;
    }

    public BigDecimal getDcoValor() {
        return dcoValor;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setNombreFuenteFinContab(String nombreFuenteFinContab) {
        this.nombreFuenteFinContab = nombreFuenteFinContab;
    }

    public String getNombreFuenteFinContab() {
        return nombreFuenteFinContab;
    }

    public void setIdCentroCostos(Long idCentroCostos) {
        this.idCentroCostos = idCentroCostos;
    }

    public Long getIdCentroCostos() {
        return idCentroCostos;
    }

    public void setNombreCentroCostos(String nombreCentroCostos) {
        this.nombreCentroCostos = nombreCentroCostos;
    }

    public String getNombreCentroCostos() {
        return nombreCentroCostos;
    }

    public void setIdEstadoDocContab(Long idEstadoDocContab) {
        this.idEstadoDocContab = idEstadoDocContab;
    }

    public Long getIdEstadoDocContab() {
        return idEstadoDocContab;
    }

    public void setEstadoDocContab(String estadoDocContab) {
        this.estadoDocContab = estadoDocContab;
    }

    public String getEstadoDocContab() {
        return estadoDocContab;
    }

    public void setCcoNivel1(String ccoNivel1) {
        this.ccoNivel1 = ccoNivel1;
    }

    public String getCcoNivel1() {
        return ccoNivel1;
    }

    public void setCcoNivel2(String ccoNivel2) {
        this.ccoNivel2 = ccoNivel2;
    }

    public String getCcoNivel2() {
        return ccoNivel2;
    }

    public void setCcoNivel3(String ccoNivel3) {
        this.ccoNivel3 = ccoNivel3;
    }

    public String getCcoNivel3() {
        return ccoNivel3;
    }

    public void setCcoNivel4(String ccoNivel4) {
        this.ccoNivel4 = ccoNivel4;
    }

    public String getCcoNivel4() {
        return ccoNivel4;
    }

    public void setCcoNivel5(String ccoNivel5) {
        this.ccoNivel5 = ccoNivel5;
    }

    public String getCcoNivel5() {
        return ccoNivel5;
    }

    public void setImcTipoMovim(String imcTipoMovim) {
        this.imcTipoMovim = imcTipoMovim;
    }

    public String getImcTipoMovim() {
        return imcTipoMovim;
    }

    public void setNombreTipoMovim(String nombreTipoMovim) {
        this.nombreTipoMovim = nombreTipoMovim;
    }

    public String getNombreTipoMovim() {
        return nombreTipoMovim;
    }

    public void setMovimientoCredito(BigDecimal movimientoCredito) {
        this.movimientoCredito = movimientoCredito;
    }

    public BigDecimal getMovimientoCredito() {
        return movimientoCredito;
    }

    public void setMovimientoDebito(BigDecimal movimientoDebito) {
        this.movimientoDebito = movimientoDebito;
    }

    public BigDecimal getMovimientoDebito() {
        return movimientoDebito;
    }

    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public BigDecimal getSaldoAnterior() {
        return saldoAnterior;
    }
    
    
    /**
     * Calcula el Saldo Final.
     * @return
     */
    public BigDecimal getSaldoFinal() {
        BigDecimal total = new BigDecimal(0);
        if (saldoAnterior!=null)
            total = total.add(saldoAnterior);
        if (movimientoDebito!=null)
            total = total.add(movimientoDebito);
        if (movimientoCredito!=null)
            total = total.subtract(movimientoCredito);
        
        return (total);
    }
}
