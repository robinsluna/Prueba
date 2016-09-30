package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.ReporteRelacionOperacionesVO;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ReporteRelacionOperacionesVO implements Comparable<ReporteRelacionOperacionesVO> {

    private String rubro;
    private String concepto;
    private String tipoOperacion;
    private String nuOperacion;
    private Date fecOperacion;
    private String opeReferencia;
    private String nuOperacionReferencia;
    private String fuenteFinanciacion;
    private String valTotal;
    private String saldoEjecutar;
    private String identiTercero;
    private String nomTercero;
    private String objeto;
    private Date fechaIniSeleccionada;
    private Date fechaFinSeleccionada;
    private String consultarTipoOperacion;
    
    private String grillaInicial;
    private String panelInicial;
    private String ffCodigoSeleccionado;
    private boolean filtrarPorFechas;
    private boolean filtrarPorFuenteFinanciacion;
    private String filtrarPorRubros;
    private String rubroInicial;
    private String rubroFinal;
    private String numeroRubro;
    private String nombreRubro;
    private String tipoFormato;
    private String detalleFuenteFinanciacion;
    private String seleccionDetalleFuenteFinanciacion;
    private String listaItemsFuenteFinanc;
    private String saldo;
    
    
    private Integer reportOutputFormat;
 
       /**
     * Constructor.
     */
    
       
    public ReporteRelacionOperacionesVO() {
    }
       

    @Override
    public int compareTo(ReporteRelacionOperacionesVO reporteRelacionOperacionesVO) {
        // TODO Implement this method
        return 0;
    }


    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setNuOperacion(String nuOperacion) {
        this.nuOperacion = nuOperacion;
    }

    public String getNuOperacion() {
        return nuOperacion;
    }

    public void setFecOperacion(Date fecOperacion) {
        this.fecOperacion = fecOperacion;
    }

    public Date getFecOperacion() {
        return fecOperacion;
    }

    public void setOpeReferencia(String opeReferencia) {
        this.opeReferencia = opeReferencia;
    }

    public String getOpeReferencia() {
        return opeReferencia;
    }

    public void setNuOperacionReferencia(String nuOperacionReferencia) {
        this.nuOperacionReferencia = nuOperacionReferencia;
    }

    public String getNuOperacionReferencia() {
        return nuOperacionReferencia;
    }

    public void setFuenteFinanciacion(String fuenteFinanciacion) {
        this.fuenteFinanciacion = fuenteFinanciacion;
    }

    public String getFuenteFinanciacion() {
        return fuenteFinanciacion;
    }

    public void setValTotal(String valTotal) {
        this.valTotal = valTotal;
    }

    public String getValTotal() {
        return valTotal;
    }

    public void setSaldoEjecutar(String saldoEjecutar) {
        this.saldoEjecutar = saldoEjecutar;
    }

    public String getSaldoEjecutar() {
        return saldoEjecutar;
    }

    public void setIdentiTercero(String identiTercero) {
        this.identiTercero = identiTercero;
    }

    public String getIdentiTercero() {
        return identiTercero;
    }

    public void setNomTercero(String nomTercero) {
        this.nomTercero = nomTercero;
    }

    public String getNomTercero() {
        return nomTercero;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setFechaIniSeleccionada(Date fechaIniSeleccionada) {
        this.fechaIniSeleccionada = fechaIniSeleccionada;
    }

    public Date getFechaIniSeleccionada() {
        return fechaIniSeleccionada;
    }

    public void setFechaFinSeleccionada(Date fechaFinSeleccionada) {
        this.fechaFinSeleccionada = fechaFinSeleccionada;
    }

    public Date getFechaFinSeleccionada() {
        return fechaFinSeleccionada;
    }

    public void setConsultarTipoOperacion(String consultarTipoOperacion) {
        this.consultarTipoOperacion = consultarTipoOperacion;
    }

    public String getConsultarTipoOperacion() {
        return consultarTipoOperacion;
    }

    public void setGrillaInicial(String grillaInicial) {
        this.grillaInicial = grillaInicial;
    }

    public String getGrillaInicial() {
        return grillaInicial;
    }

    public void setPanelInicial(String panelInicial) {
        this.panelInicial = panelInicial;
    }

    public String getPanelInicial() {
        return panelInicial;
    }

    public void setFfCodigoSeleccionado(String ffCodigoSeleccionado) {
        this.ffCodigoSeleccionado = ffCodigoSeleccionado;
    }

    public String getFfCodigoSeleccionado() {
        return ffCodigoSeleccionado;
    }

    public void setFiltrarPorFechas(boolean filtrarPorFechas) {
        this.filtrarPorFechas = filtrarPorFechas;
    }

    public boolean isFiltrarPorFechas() {
        return filtrarPorFechas;
    }

    public void setFiltrarPorFuenteFinanciacion(boolean filtrarPorFuenteFinanciacion) {
        this.filtrarPorFuenteFinanciacion = filtrarPorFuenteFinanciacion;
    }

    public boolean isFiltrarPorFuenteFinanciacion() {
        return filtrarPorFuenteFinanciacion;
    }

    public void setFiltrarPorRubros(String filtrarPorRubros) {
        this.filtrarPorRubros = filtrarPorRubros;
    }

    public String getFiltrarPorRubros() {
        return filtrarPorRubros;
    }

    public void setRubroInicial(String rubroInicial) {
        this.rubroInicial = rubroInicial;
    }

    public String getRubroInicial() {
        return rubroInicial;
    }

    public void setRubroFinal(String rubroFinal) {
        this.rubroFinal = rubroFinal;
    }

    public String getRubroFinal() {
        return rubroFinal;
    }

    public void setNumeroRubro(String numeroRubro) {
        this.numeroRubro = numeroRubro;
    }

    public String getNumeroRubro() {
        return numeroRubro;
    }

    public void setTipoFormato(String tipoFormato) {
        this.tipoFormato = tipoFormato;
    }

    public String getTipoFormato() {
        return tipoFormato;
    }

    public void setDetalleFuenteFinanciacion(String detalleFuenteFinanciacion) {
        this.detalleFuenteFinanciacion = detalleFuenteFinanciacion;
    }

    public String getDetalleFuenteFinanciacion() {
        return detalleFuenteFinanciacion;
    }

    public void setSeleccionDetalleFuenteFinanciacion(String seleccionDetalleFuenteFinanciacion) {
        this.seleccionDetalleFuenteFinanciacion = seleccionDetalleFuenteFinanciacion;
    }

    public String getSeleccionDetalleFuenteFinanciacion() {
        return seleccionDetalleFuenteFinanciacion;
    }

    public void setListaItemsFuenteFinanc(String listaItemsFuenteFinanc) {
        this.listaItemsFuenteFinanc = listaItemsFuenteFinanc;
    }

    public String getListaItemsFuenteFinanc() {
        return listaItemsFuenteFinanc;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setReportOutputFormat(Integer reportOutputFormat) {
        this.reportOutputFormat = reportOutputFormat;
    }

    public Integer getReportOutputFormat() {
        return reportOutputFormat;
    }

    public void setNumeroRubro(long l) {
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setFfCodigoSeleccionado(long l) {
    }
}


