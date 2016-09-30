/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Mónica Pabón
 * FECHA	: 20-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoPolizaContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ContratoVO implements Comparable<ContratoVO> {

    private Long conCodigo;
    private String conDescripcion;
    private Date conFechaFin;
    private Date conFechaIni;
    private String conNumero;
    private Date conFecha;
    private String conVigente;
    private Integer conConsecutivo;
    private String conExpedienteUrl;
    private Date conFechaCitFirOpe;
    private Date conFechaFirColj;
    private Date conFechaFirOpe;
    private Date conFechaPrgFirOpe;
    private Date conFechaRegistro;
    private Date conFechaRevAbog;
    private Date fechaUltimaLiquidacion;
    private String conTextoValFinan;
    private String conTextoValGct;
    private String conPermiso;
    private String conEsRenovacion;
    private Date conFechaFinDefin;
    private Date conFechaCesion;
    private BigDecimal conValorEstimado;
    private String conTextoValCca;
    private EstadoContratoVO estadoContratoVo;
    private OperadorVO operadorVo;
    private ContratoVO contratoCedenteVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private List<NovedadVO> novedadVoList;
    private List<PolizaContratVO> polizaContratLisVo;
    private List<RevisionFinanVO> revisionFinanListVo;
    private List<RevisionGctVO> revisionGctListVo;
    private List<ContratoVO> contratosCedidosListVo;
    private List<LiquidacionContratoVO> liquidacionContratoListVo;
    private List<LiquidacionMesVO> liquidacionMesListVo;
    private List<InformeSupervisionVO> informeSupervisionListVo;
    private List<ElementoAsociadoVO> listaElementoAsociadoVo;

    //campos adicionados en el VO que no vienen de la entidad
    private Long idEstadoAnterior;
    private SolicitudAutorizaVO solicitudAutorizaVo;
    private Long valorCOntrato;
    private boolean isSeleccionado;


    public ContratoVO(SiiContrato siiContrato) {
        this.conCodigo = siiContrato.getConCodigo();
        this.conDescripcion = siiContrato.getConDescripcion();
        this.conFechaFin = siiContrato.getConFechaFin();
        this.conFechaIni = siiContrato.getConFechaIni();
        this.conNumero = siiContrato.getConNumero();
        this.conFecha = siiContrato.getConFecha();
        this.conVigente = siiContrato.getConVigente();
        this.conConsecutivo = siiContrato.getConConsecutivo();
        this.conExpedienteUrl = siiContrato.getConExpedienteUrl();
        this.conFechaCitFirOpe = siiContrato.getConFechaCitFirOpe();
        this.conFechaFirColj = siiContrato.getConFechaFirColj();
        this.conFechaFirOpe = siiContrato.getConFechaFirOpe();
        this.conFechaPrgFirOpe = siiContrato.getConFechaPrgFirOpe();
        this.conFechaRegistro = siiContrato.getConFechaRegistro();
        this.conFechaRevAbog = siiContrato.getConFechaRevAbog();
        this.conTextoValFinan = siiContrato.getConTextoValFinan();
        this.conTextoValGct = siiContrato.getConTextoValGct();
        this.conPermiso = siiContrato.getConPermiso();
        this.conFechaCesion = siiContrato.getConFechaCesion();
        this.conValorEstimado = siiContrato.getConValorEstimado();
        this.conTextoValCca = siiContrato.getConTextoValCca();
        this.conEsRenovacion = siiContrato.getConEsRenovacion();
        this.conFechaFinDefin = siiContrato.getConFechaFinDefin();

        if(siiContrato.getSiiOperador() != null) {
            this.operadorVo = new OperadorVO(siiContrato.getSiiOperador());
        }
        if(siiContrato.getSiiEstadoContrato() != null) {
            this.estadoContratoVo = new EstadoContratoVO(siiContrato.getSiiEstadoContrato());
            this.idEstadoAnterior = siiContrato.getSiiEstadoContrato().getEcoCodigo();
        }
        if(siiContrato.getSiiArchivoFisico() != null) {
            this.archivoFisicoVo = new ArchivoFisicoVO(siiContrato.getSiiArchivoFisico());
        }
        if(siiContrato.getSiiContratoCedente()!= null ){
            this.contratoCedenteVo = new ContratoVO (siiContrato.getSiiContratoCedente() );
        }
    }

    public ContratoVO() {
    }


    public void setConCodigo(Long conCodigo) {
        this.conCodigo = conCodigo;
    }

    public Long getConCodigo() {
        return conCodigo;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
    }

    public String getConDescripcion() {
        return conDescripcion;
    }

    public void setConFechaFin(Date conFechaFin) {
        this.conFechaFin = conFechaFin;
    }

    public Date getConFechaFin() {
        return conFechaFin;
    }

    public void setConFechaIni(Date conFechaIni) {
        this.conFechaIni = conFechaIni;
    }

    public Date getConFechaIni() {
        return conFechaIni;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConNumero() {
        return conNumero;
    }


    public void setOperadorVo(OperadorVO operadorVo) {
        this.operadorVo = operadorVo;
    }

    public OperadorVO getOperadorVo() {
        return operadorVo;
    }

    public void setNovedadVoList(List<NovedadVO> novedadVoList) {
        this.novedadVoList = novedadVoList;
    }

    public List<NovedadVO> getNovedadVoList() {
        return novedadVoList;
    }

    public void setEstadoContratoVo(EstadoContratoVO estadoContratoVo) {
        this.estadoContratoVo = estadoContratoVo;
    }

    public EstadoContratoVO getEstadoContratoVo() {
        return estadoContratoVo;
    }


    public void setPolizaContratLisVo(List<PolizaContratVO> polizaContratLisVo) {
        this.polizaContratLisVo = polizaContratLisVo;
    }

    public List<PolizaContratVO> getPolizaContratLisVo() {
        return polizaContratLisVo;
    }

    public void setConFecha(Date conFecha) {
        this.conFecha = conFecha;
    }

    public Date getConFecha() {
        return conFecha;
    }

    public void setConVigente(String conVigente) {
        this.conVigente = conVigente;
    }

    public String getConVigente() {
        return conVigente;
    }

    public void setConConsecutivo(Integer conConsecutivo) {
        this.conConsecutivo = conConsecutivo;
    }

    public Integer getConConsecutivo() {
        return conConsecutivo;
    }

    public void setValorCOntrato(Long valorCOntrato) {
        this.valorCOntrato = valorCOntrato;
    }

    public Long getValorCOntrato() {
        return valorCOntrato;
    }

    public void setSolicitudAutorizaVo(SolicitudAutorizaVO solicitudAutorizaVo) {
        this.solicitudAutorizaVo = solicitudAutorizaVo;
    }

    public SolicitudAutorizaVO getSolicitudAutorizaVo() {
        return solicitudAutorizaVo;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setConExpedienteUrl(String conExpedienteUrl) {
        this.conExpedienteUrl = conExpedienteUrl;
    }

    public String getConExpedienteUrl() {
        return conExpedienteUrl;
    }

    public void setConFechaCitFirOpe(Date conFechaCitFirOpe) {
        this.conFechaCitFirOpe = conFechaCitFirOpe;
    }

    public Date getConFechaCitFirOpe() {
        return conFechaCitFirOpe;
    }

    public void setConFechaFirColj(Date conFechaFirColj) {
        this.conFechaFirColj = conFechaFirColj;
    }

    public Date getConFechaFirColj() {
        return conFechaFirColj;
    }

    public void setConFechaFirOpe(Date conFechaFirOpe) {
        this.conFechaFirOpe = conFechaFirOpe;
    }

    public Date getConFechaFirOpe() {
        return conFechaFirOpe;
    }

    public void setConFechaPrgFirOpe(Date conFechaPrgFirOpe) {
        this.conFechaPrgFirOpe = conFechaPrgFirOpe;
    }

    public Date getConFechaPrgFirOpe() {
        return conFechaPrgFirOpe;
    }

    public void setConFechaRegistro(Date conFechaRegistro) {
        this.conFechaRegistro = conFechaRegistro;
    }

    public Date getConFechaRegistro() {
        return conFechaRegistro;
    }

    public void setConFechaRevAbog(Date conFechaRevAbog) {
        this.conFechaRevAbog = conFechaRevAbog;
    }

    public Date getConFechaRevAbog() {
        return conFechaRevAbog;
    }

    public void setConTextoValFinan(String conTextoValFinan) {
        this.conTextoValFinan = conTextoValFinan;
    }

    public String getConTextoValFinan() {
        return conTextoValFinan;
    }

    public void setConTextoValGct(String conTextoValGct) {
        this.conTextoValGct = conTextoValGct;
    }

    public String getConTextoValGct() {
        return conTextoValGct;
    }

    public void setConPermiso(String conPermiso) {
        this.conPermiso = conPermiso;
    }

    public String getConPermiso() {
        return conPermiso;
    }

    public void setRevisionFinanListVo(List<RevisionFinanVO> revisionFinanListVo) {
        this.revisionFinanListVo = revisionFinanListVo;
    }

    public List<RevisionFinanVO> getRevisionFinanListVo() {
        return revisionFinanListVo;
    }

    public void setRevisionGctListVo(List<RevisionGctVO> revisionGctListVo) {
        this.revisionGctListVo = revisionGctListVo;
    }

    public List<RevisionGctVO> getRevisionGctListVo() {
        return revisionGctListVo;
    }

    public void setContratoCedenteVo(ContratoVO contratoCedenteVo) {
        this.contratoCedenteVo = contratoCedenteVo;
    }

    public ContratoVO getContratoCedenteVo() {
        return contratoCedenteVo;
    }

    public void setContratosCedidosListVo(List<ContratoVO> contratosCedidosListVo) {
        this.contratosCedidosListVo = contratosCedidosListVo;
    }

    public List<ContratoVO> getContratosCedidosListVo() {
        return contratosCedidosListVo;
    }

    public void setConFechaCesion(Date conFechaCesion) {
        this.conFechaCesion = conFechaCesion;
    }

    public Date getConFechaCesion() {
        return conFechaCesion;
    }

    public void setConValorEstimado(BigDecimal conValorEstimado) {
        this.conValorEstimado = conValorEstimado;
    }

    public BigDecimal getConValorEstimado() {
        return conValorEstimado;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setConTextoValCca(String conTextoValCca) {
        this.conTextoValCca = conTextoValCca;
    }

    public String getConTextoValCca() {
        return conTextoValCca;
    }

    public int compareTo(ContratoVO compareContratoVO) {

        //descending order ContratoVO.expedienteDocum.getConNumero
        if(compareContratoVO.getConNumero() != null)
            return compareContratoVO.getConNumero().compareTo(this.getConNumero());
        else if(this.getConNumero() != null)
            return -1;
        else
            return 0;

    }

    public void setConEsRenovacion(String conEsRenovacion) {
        this.conEsRenovacion = conEsRenovacion;
    }

    public String getConEsRenovacion() {
        return conEsRenovacion;
    }

    public void setConFechaFinDefin(Date conFechaFinDefin) {
        this.conFechaFinDefin = conFechaFinDefin;
    }

    public Date getConFechaFinDefin() {
        return conFechaFinDefin;
    }

    public void setLiquidacionContratoListVo(List<LiquidacionContratoVO> liquidacionContratoListVo) {
        this.liquidacionContratoListVo = liquidacionContratoListVo;
    }

    public List<LiquidacionContratoVO> getLiquidacionContratoListVo() {
        return liquidacionContratoListVo;
    }

    public void setLiquidacionMesListVo(List<LiquidacionMesVO> liquidacionMesListVo) {
        this.liquidacionMesListVo = liquidacionMesListVo;
    }

    public List<LiquidacionMesVO> getLiquidacionMesListVo() {
        return liquidacionMesListVo;
    }

    public void setInformeSupervisionListVo(List<InformeSupervisionVO> informeSupervisionListVo) {
        this.informeSupervisionListVo = informeSupervisionListVo;
    }

    public List<InformeSupervisionVO> getInformeSupervisionListVo() {
        return informeSupervisionListVo;
    }


    public void setIsSeleccionado(boolean isSeleccionado) {
        this.isSeleccionado = isSeleccionado;
    }

    public boolean isIsSeleccionado() {
        return isSeleccionado;
    }

    public void setFechaUltimaLiquidacion(Date fechaUltimaLiquidacion) {
        this.fechaUltimaLiquidacion = fechaUltimaLiquidacion;
    }

    public Date getFechaUltimaLiquidacion() {
        return fechaUltimaLiquidacion;
    }

    /**
     *  fechaIni
     *  fechaFin
     *  TODO Hay que tomar en cuenta los periodos de suspension?.
     * @return la diferencia en meses entre la fecha inicial del contrato y la fecha final Definitiva.
     */
    public int getDuracionEnMeses() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(conFechaIni);
        Calendar endCalendar = Calendar.getInstance();
        if(conFechaFinDefin != null) {
            endCalendar.setTime(this.conFechaFinDefin);
        }
        else {
            endCalendar.setTime(this.conFechaFin);
        }

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        return diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
    }

    public int getDuracionInicialEnMeses() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(conFechaIni);
        Calendar endCalendar = Calendar.getInstance();

        endCalendar.setTime(this.conFechaFin);

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        return diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
    }


    /**
     * Obtiene la &uacute;ltima P&oacute;liza Aprobada.
     * @return
     */
    public PolizaContratVO getUltimaPolizaContrat() {
        PolizaContratVO ultima = null;
        if(this.polizaContratLisVo != null && !this.polizaContratLisVo.isEmpty()) {
            // ordenar la lista por codigo en orden descendente
            Collections.sort(this.polizaContratLisVo);
            Collections.reverse(this.polizaContratLisVo);

            Iterator<PolizaContratVO> it = this.polizaContratLisVo.iterator();
            while(it.hasNext() && ultima == null) {
                PolizaContratVO polizaContratVo = it.next();
                if(polizaContratVo != null && polizaContratVo.getEstadoPolizaContVO() != null && polizaContratVo.getEstadoPolizaContVO().getEpoCodigo()!=null && 
                   EnumEstadoPolizaContrato.APROBADO.getId().equals(polizaContratVo.getEstadoPolizaContVO().getEpoCodigo())) 
                {
                    ultima = polizaContratVo;
                }
            }
        }
        return (ultima);
    }

    public void setListaElementoAsociadoVo(List<ElementoAsociadoVO> listaElementoAsociadoVo) {
        this.listaElementoAsociadoVo = listaElementoAsociadoVo;
    }

    public List<ElementoAsociadoVO> getListaElementoAsociadoVo() {
        return listaElementoAsociadoVo;
    }
}
