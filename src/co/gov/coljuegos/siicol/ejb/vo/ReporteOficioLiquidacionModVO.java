package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ReporteOficioLiquidacionModVO {
    private Integer oliConsecutivo;
    private String razonSocial;
    private Date fechaExpedicionOficio;
    private String nit;
    private String numeroContrato;
    private Integer mesesLiquidados;
    private Date fechaIniContrato;
    private Date fechaFinContrato;
    private BigDecimal totalMensualDerechoExpl;
    private BigDecimal totalMensualGastosAdm;
    private BigDecimal valorTotalMensual;
    private BigDecimal totalDerExp;
    private BigDecimal totalGasAdm;
    private BigDecimal totalContrato;
    private BigDecimal vlrCumplimiento;
    private BigDecimal vlrPagoPremios;
    private BigDecimal vlrSalariosyPres;
    private BigDecimal vlrCumPrem;
    private BigDecimal totalValAse;
	private BigDecimal valAseSalarios;
    private List<OficLiqTipoApuestaVO> listaInvModifica;
    private List<OficLiqTipoApuestaVO> listaOficiosNuevoPdf;
	private List<OficioLiquidacionPrevioVO> listaOficiosPreviosAct;
	private String edoCodigo;
    
    public ReporteOficioLiquidacionModVO() {
        
    }

    public void setOliConsecutivo(Integer oliConsecutivo) {
        this.oliConsecutivo = oliConsecutivo;
    }

    public Integer getOliConsecutivo() {
        return oliConsecutivo;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setFechaExpedicionOficio(Date fechaExpedicionOficio) {
        this.fechaExpedicionOficio = fechaExpedicionOficio;
    }

    public Date getFechaExpedicionOficio() {
        return fechaExpedicionOficio;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setMesesLiquidados(Integer mesesLiquidados) {
        this.mesesLiquidados = mesesLiquidados;
    }

    public Integer getMesesLiquidados() {
        return mesesLiquidados;
    }

    public void setFechaIniContrato(Date fechaIniContrato) {
        this.fechaIniContrato = fechaIniContrato;
    }

    public Date getFechaIniContrato() {
        return fechaIniContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setTotalMensualDerechoExpl(BigDecimal totalMensualDerechoExpl) {
        this.totalMensualDerechoExpl = totalMensualDerechoExpl;
    }

    public BigDecimal getTotalMensualDerechoExpl() {
        return totalMensualDerechoExpl;
    }

    public void setTotalMensualGastosAdm(BigDecimal totalMensualGastosAdm) {
        this.totalMensualGastosAdm = totalMensualGastosAdm;
    }

    public BigDecimal getTotalMensualGastosAdm() {
        return totalMensualGastosAdm;
    }

    public void setValorTotalMensual(BigDecimal valorTotalMensual) {
        this.valorTotalMensual = valorTotalMensual;
    }

    public BigDecimal getValorTotalMensual() {
        return valorTotalMensual;
    }

    
    public void setTotalDerExp(BigDecimal totalDerExp) {
        this.totalDerExp = totalDerExp;
    }

    public BigDecimal getTotalDerExp() {
        return totalDerExp;
    }

    public void setTotalGasAdm(BigDecimal totalGasAdm) {
        this.totalGasAdm = totalGasAdm;
    }

    public BigDecimal getTotalGasAdm1() {
        return totalGasAdm;
    }

   

    public void setVlrCumplimiento(BigDecimal vlrCumplimiento) {
        this.vlrCumplimiento = vlrCumplimiento;
    }

    public BigDecimal getVlrCumplimiento() {
        return vlrCumplimiento;
    }

    public void setVlrPagoPremios(BigDecimal vlrPagoPremios) {
        this.vlrPagoPremios = vlrPagoPremios;
    }

    public BigDecimal getVlrPagoPremios() {
        return vlrPagoPremios;
    }

    public void setVlrSalariosyPres(BigDecimal vlrSalariosyPres) {
        this.vlrSalariosyPres = vlrSalariosyPres;
    }

    public BigDecimal getVlrSalariosyPres() {
        return vlrSalariosyPres;
    }

    public void setVlrCumPrem(BigDecimal vlrCumPrem) {
        this.vlrCumPrem = vlrCumPrem;
    }

    public BigDecimal getVlrCumPrem() {
        return vlrCumPrem;
    }


    public void setListaInvModifica(List<OficLiqTipoApuestaVO> listaInvModifica) {
        this.listaInvModifica = listaInvModifica;
    }

    public List<OficLiqTipoApuestaVO> getListaInvModifica() {
        return listaInvModifica;
    }


    public void setListaOficiosNuevoPdf(List<OficLiqTipoApuestaVO> listaOficiosNuevoPdf) {
        this.listaOficiosNuevoPdf = listaOficiosNuevoPdf;
    }

    public List<OficLiqTipoApuestaVO> getListaOficiosNuevoPdf() {
        return listaOficiosNuevoPdf;
    }


    public void setListaOficiosPreviosAct(List<OficioLiquidacionPrevioVO> listaOficiosPreviosAct) {
        this.listaOficiosPreviosAct = listaOficiosPreviosAct;
    }

    public List<OficioLiquidacionPrevioVO> getListaOficiosPreviosAct() {
        return listaOficiosPreviosAct;
    }
 public void setValAseSalarios(BigDecimal valAseSalarios) {
        this.valAseSalarios = valAseSalarios;
    }

    public BigDecimal getValAseSalarios() {
        return valAseSalarios;
    }


    public void setTotalContrato(BigDecimal totalContrato) {
        this.totalContrato = totalContrato;
    }

    public BigDecimal getTotalContrato() {
        return totalContrato;
    }


    public void setTotalValAse(BigDecimal totalValAse) {
        this.totalValAse = totalValAse;
    }

    public BigDecimal getTotalValAse() {
        return totalValAse;
    }
	
	public void setEdoCodigo(String edoCodigo) {
        this.edoCodigo = edoCodigo;
    }

    public String getEdoCodigo() {
        return edoCodigo;
    }
}
