package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcSanc;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


/**
 * Value Object para la Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
public class ResolucionProcSancVO 
{
    private Date remFecha;
    private String remNumero;
    private Date remSnumFechaRad;
    private String remSnumRadicado;
    private String remTipo;
    private BigDecimal remValorSancion;
    private Long repCodigo;
    private String repConceptoSancion;
    private Date repFecha;
    private BigDecimal remValClausulaPen;
    
    private ArchivoFisicoVO archivoFisicoVo;
    
    private List<ProcesoSancionatorioVO> procesoSancionatorioSancList;
    private List<ProcesoSancionatorioVO> procesoSancionatorioSinList;
    private List<ProcesoSancionatorioVO> procesoSancionatorioReposList;
    private List<ProcesoSancionatorioVO> procesoSancionatorioApelaList;
    private List<TramiteResolProcSanVO> tramiteResolProcSanList;
    
    
    /**
     * Constructor.
     */
    public ResolucionProcSancVO() { }
    
    
    /**
     * Constructor.
     * @param siiResolucionProcSanc - Entity.
     */
    public ResolucionProcSancVO (SiiResolucionProcSanc siiResolucionProcSanc) 
    {
        if (siiResolucionProcSanc!=null) {
            this.remFecha = siiResolucionProcSanc.getRemFecha();
            this.remNumero = siiResolucionProcSanc.getRemNumero();
            this.remSnumFechaRad = siiResolucionProcSanc.getRemSnumFechaRad();
            this.remSnumRadicado = siiResolucionProcSanc.getRemSnumRadicado();
            this.remTipo = siiResolucionProcSanc.getRemTipo();
            this.remValorSancion = siiResolucionProcSanc.getRemValorSancion();
            this.repCodigo = siiResolucionProcSanc.getRepCodigo();
            this.repConceptoSancion = siiResolucionProcSanc.getRepConceptoSancion();
            this.repFecha = siiResolucionProcSanc.getRepFecha();
            this.remValClausulaPen = siiResolucionProcSanc.getRemValClausulaPen();
            
            if (siiResolucionProcSanc.getSiiArchivoFisico()!=null)
                this.archivoFisicoVo = new ArchivoFisicoVO(siiResolucionProcSanc.getSiiArchivoFisico());
        }
    }

    
    
    public void setRemFecha(Date remFecha) {
        this.remFecha = remFecha;
    }

    public Date getRemFecha() {
        return remFecha;
    }

    public void setRemNumero(String remNumero) {
        this.remNumero = remNumero;
    }

    public String getRemNumero() {
        return remNumero;
    }

    public void setRemSnumFechaRad(Date remSnumFechaRad) {
        this.remSnumFechaRad = remSnumFechaRad;
    }

    public Date getRemSnumFechaRad() {
        return remSnumFechaRad;
    }

    public void setRemSnumRadicado(String remSnumRadicado) {
        this.remSnumRadicado = remSnumRadicado;
    }

    public String getRemSnumRadicado() {
        return remSnumRadicado;
    }

    public void setRemTipo(String remTipo) {
        this.remTipo = remTipo;
    }

    public String getRemTipo() {
        return remTipo;
    }

    public void setRemValorSancion(BigDecimal remValorSancion) {
        this.remValorSancion = remValorSancion;
    }

    public BigDecimal getRemValorSancion() {
        return remValorSancion;
    }

    public void setRepCodigo(Long repCodigo) {
        this.repCodigo = repCodigo;
    }

    public Long getRepCodigo() {
        return repCodigo;
    }

    public void setRepConceptoSancion(String repConceptoSancion) {
        this.repConceptoSancion = repConceptoSancion;
    }

    public String getRepConceptoSancion() {
        return repConceptoSancion;
    }

    public void setRepFecha(Date repFecha) {
        this.repFecha = repFecha;
    }

    public Date getRepFecha() {
        return repFecha;
    }

    public void setRemValClausulaPen(BigDecimal remValClausulaPen) {
        this.remValClausulaPen = remValClausulaPen;
    }

    public BigDecimal getRemValClausulaPen() {
        return remValClausulaPen;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setProcesoSancionatorioSancList(List<ProcesoSancionatorioVO> procesoSancionatorioSancList) {
        this.procesoSancionatorioSancList = procesoSancionatorioSancList;
    }

    public List<ProcesoSancionatorioVO> getProcesoSancionatorioSancList() {
        return procesoSancionatorioSancList;
    }

    public void setProcesoSancionatorioSinList(List<ProcesoSancionatorioVO> procesoSancionatorioSinList) {
        this.procesoSancionatorioSinList = procesoSancionatorioSinList;
    }

    public List<ProcesoSancionatorioVO> getProcesoSancionatorioSinList() {
        return procesoSancionatorioSinList;
    }

    public void setProcesoSancionatorioReposList(List<ProcesoSancionatorioVO> procesoSancionatorioReposList) {
        this.procesoSancionatorioReposList = procesoSancionatorioReposList;
    }

    public List<ProcesoSancionatorioVO> getProcesoSancionatorioReposList() {
        return procesoSancionatorioReposList;
    }

    public void setProcesoSancionatorioApelaList(List<ProcesoSancionatorioVO> procesoSancionatorioApelaList) {
        this.procesoSancionatorioApelaList = procesoSancionatorioApelaList;
    }

    public List<ProcesoSancionatorioVO> getProcesoSancionatorioApelaList() {
        return procesoSancionatorioApelaList;
    }

    public void setTramiteResolProcSanList(List<TramiteResolProcSanVO> tramiteResolProcSanList) {
        this.tramiteResolProcSanList = tramiteResolProcSanList;
    }

    public List<TramiteResolProcSanVO> getTramiteResolProcSanList() {
        return tramiteResolProcSanList;
    }
}
