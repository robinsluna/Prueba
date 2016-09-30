/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 21-11-2014
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class SolicitudPromocionalesVO {

    private Long idSolicitud;
    private String nombreJuego;
    private Date fechaInicio;
    private Date fechaCierre;
    private BigDecimal valorTotalPremios;
    private BigDecimal valorDE;
    private BigDecimal valorGA;
    private TipoApuestaVO tipoApuestaVo;
    private SolicitudAutorizaVO solicitudAutorizaVo;
    private List<CuotaOperadorVO>  listaCuotaOperadorVo;
    private PersonaVO personaVo;
    private PersonaVO personaRepVo;
    private String numeroRadicación;
    private Date fechaRadicación;
    private Date fechaResolucion;
    private String  numeroResolucion;
    private Date fechaResTacito;
    private String numeroResTacito;
    private String numeroRadicaciónExp;
    private Date fechaRadicaciónExp;
    private Long refPagoDE;
    private Long refPagoGA;
    private String estado;
    private Integer consecutivo;
    // se usan en translado bancario
    private String  concepto;
    private BigDecimal valorConcepto;
    private Long idDeclaracion;
    

    public  SolicitudPromocionalesVO(SiiRifaPromocional siiRifaPromocional ) {
        this.idSolicitud= siiRifaPromocional.getRfpCodigo();
        this.nombreJuego=siiRifaPromocional.getRfpNombre();
        this.fechaInicio=siiRifaPromocional.getRfpFechaInicio();
        this.fechaCierre=siiRifaPromocional.getRfpFechaFin();
        this.valorTotalPremios=siiRifaPromocional.getRfpValorTotal();
        this.valorDE=siiRifaPromocional.getRfpValorDe();
        this.valorGA=siiRifaPromocional.getRfpValorGa();
        this.consecutivo=siiRifaPromocional.getRfpConsecutivo();
        this.numeroResolucion=siiRifaPromocional.getRfpResolucion();
        this.fechaResolucion=siiRifaPromocional.getRfpFechaResol();
        this.numeroRadicaciónExp=siiRifaPromocional.getRfpResolDesistExpr();
        this.fechaRadicaciónExp=siiRifaPromocional.getRfpFechaResDesExp();
        this.numeroResTacito=siiRifaPromocional.getRfpResolDesistTaci();
        this.fechaResTacito=siiRifaPromocional.getRfpFechaResDesTaci();
        
        if(siiRifaPromocional.getSiiSolicitudAutoriza()!= null )
                this.solicitudAutorizaVo=new SolicitudAutorizaVO(siiRifaPromocional.getSiiSolicitudAutoriza());
        if (siiRifaPromocional.getSiiTipoApuesta() != null )
                this.tipoApuestaVo=new TipoApuestaVO(siiRifaPromocional.getSiiTipoApuesta());
             
    }
    
    public  SolicitudPromocionalesVO() {
        
    }


    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setValorTotalPremios(BigDecimal valorTotalPremios) {
        this.valorTotalPremios = valorTotalPremios;
    }

    public BigDecimal getValorTotalPremios() {
        return valorTotalPremios;
    }

    public void setValorDE(BigDecimal valorDE) {
        this.valorDE = valorDE;
    }

    public BigDecimal getValorDE() {
        return valorDE;
    }

    public void setValorGA(BigDecimal valorGA) {
        this.valorGA = valorGA;
    }

    public BigDecimal getValorGA() {
        return valorGA;
    }

    public void setTipoApuestaVo(TipoApuestaVO tipoApuestaVo) {
        this.tipoApuestaVo = tipoApuestaVo;
    }

    public TipoApuestaVO getTipoApuestaVo() {
        return tipoApuestaVo;
    }

    public void setSolicitudAutorizaVo(SolicitudAutorizaVO solicitudAutorizaVo) {
        this.solicitudAutorizaVo = solicitudAutorizaVo;
    }

    public SolicitudAutorizaVO getSolicitudAutorizaVo() {
        return solicitudAutorizaVo;
    }


    public void setNumeroResolucion(String numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    public String getNumeroResolucion() {
        return numeroResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }


    public void setListaCuotaOperadorVo(List<CuotaOperadorVO> listaCuotaOperadorVo) {
        this.listaCuotaOperadorVo = listaCuotaOperadorVo;
    }

    public List<CuotaOperadorVO> getListaCuotaOperadorVo() {
        return listaCuotaOperadorVo;
    }


    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }


    public void setNumeroRadicaciónExp(String numeroRadicaciónExp) {
        this.numeroRadicaciónExp = numeroRadicaciónExp;
    }

    public String getNumeroRadicaciónExp() {
        return numeroRadicaciónExp;
    }

    public void setFechaRadicaciónExp(Date fechaRadicaciónExp) {
        this.fechaRadicaciónExp = fechaRadicaciónExp;
    }

    public Date getFechaRadicaciónExp() {
        return fechaRadicaciónExp;
    }

    public void setRefPagoDE(Long refPagoDE) {
        this.refPagoDE = refPagoDE;
    }

    public Long getRefPagoDE() {
        return refPagoDE;
    }

    public void setRefPagoGA(Long refPagoGA) {
        this.refPagoGA = refPagoGA;
    }

    public Long getRefPagoGA() {
        return refPagoGA;
    }

    public void setPersonaRepVo(PersonaVO personaRepVo) {
        this.personaRepVo = personaRepVo;
    }

    public PersonaVO getPersonaRepVo() {
        return personaRepVo;
    }

    public void setNumeroResTacito(String numeroResTacito) {
        this.numeroResTacito = numeroResTacito;
    }

    public String getNumeroResTacito() {
        return numeroResTacito;
    }

    public void setFechaResTacito(Date fechaResTacito) {
        this.fechaResTacito = fechaResTacito;
    }

    public Date getFechaResTacito() {
        return fechaResTacito;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setNumeroRadicación(String numeroRadicación) {
        this.numeroRadicación = numeroRadicación;
    }

    public String getNumeroRadicación() {
        return numeroRadicación;
    }

    public void setFechaRadicación(Date fechaRadicación) {
        this.fechaRadicación = fechaRadicación;
    }

    public Date getFechaRadicación() {
        return fechaRadicación;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setValorConcepto(BigDecimal valorConcepto) {
        this.valorConcepto = valorConcepto;
    }

    public BigDecimal getValorConcepto() {
        return valorConcepto;
    }

    public void setIdDeclaracion(Long idDeclaracion) {
        this.idDeclaracion = idDeclaracion;
    }

    public Long getIdDeclaracion() {
        return idDeclaracion;
    }
}
