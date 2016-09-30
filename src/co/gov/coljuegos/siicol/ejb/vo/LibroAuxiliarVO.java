/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 17-03-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;


/**
 * Value Object utilizaddo para la generacion del Libro Auxiliar.
 * @author Camilo Miranda
 */
public class LibroAuxiliarVO implements Comparable<LibroAuxiliarVO> 
{
    private String cuentaContable;
    private String nombreCuentaContable;
    private String tdcCodigo;
    private String nombreTipoDocContable;
    private Integer dcoNumeroCompr;
    private Long perCodigo;
    private String tipoIdentificacion;
    private String perNumIdentificacion;
    private Integer perDigitoVerif;
    private String razonSocial;
    private String conceptoInfoExogena;
    private String ffcCodigo;
    private String nombreFuenteFinContab;
    private Long idCentroCostos;
    private String nombreCentroCostos;
    private String referencia1;
    private String referencia2;
    private String descrOperacion;
    private Date dcoFechaOper;
    private BigDecimal movimientoCredito;
    private BigDecimal movimientoDebito;
    
    private Long dcoCodigo;
    private Long ccoCodigo;
    
    private String ccoNivel1;
    private String ccoNivel2;
    private String ccoNivel3;
    private String ccoNivel4;
    private String ccoNivel5;
    
    private String imcTipoMovim;
    private String nombreTipoMovim;
    private Long idEstadoDocContab;
    private String estadoDocContab;

    
    
    
    /**
     * Constructor.
     */
    public LibroAuxiliarVO() { }

    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(T)
     */
    public int compareTo (LibroAuxiliarVO libroAuxiliarVo) {
        return (this.cuentaContable.compareTo(libroAuxiliarVo.getCuentaContable()));
    }
    
    
    
    
    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public String getCuentaContable() {
        return cuentaContable;
    }

    public void setNombreCuentaContable(String nombreCuentaContable) {
        this.nombreCuentaContable = nombreCuentaContable;
    }

    public String getNombreCuentaContable() {
        return nombreCuentaContable;
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

    public void setDcoNumeroCompr(Integer dcoNumeroCompr) {
        this.dcoNumeroCompr = dcoNumeroCompr;
    }

    public Integer getDcoNumeroCompr() {
        return dcoNumeroCompr;
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

    public void setConceptoInfoExogena(String conceptoInfoExogena) {
        this.conceptoInfoExogena = conceptoInfoExogena;
    }

    public String getConceptoInfoExogena() {
        return conceptoInfoExogena;
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

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setDescrOperacion(String descrOperacion) {
        this.descrOperacion = descrOperacion;
    }

    public String getDescrOperacion() {
        return descrOperacion;
    }

    public void setDcoFechaOper(Date dcoFechaOper) {
        this.dcoFechaOper = dcoFechaOper;
    }

    public Date getDcoFechaOper() {
        return dcoFechaOper;
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

    public void setDcoCodigo(Long dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    public Long getDcoCodigo() {
        return dcoCodigo;
    }

    public void setCcoCodigo(Long ccoCodigo) {
        this.ccoCodigo = ccoCodigo;
    }

    public Long getCcoCodigo() {
        return ccoCodigo;
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
}
