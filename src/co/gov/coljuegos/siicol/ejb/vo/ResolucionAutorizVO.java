package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;

import java.util.Date;
import java.util.List;

public class ResolucionAutorizVO implements Comparable<ResolucionAutorizVO> {
    private Long rauCodigo;
    private Long rauNumeroRes;
    private Date rauFechaNotif;
    private String rauMedioNotif;
    private String rauObservaciones;
    private Date rauFechaResol;
    private Date rauFechaPasFirma;
    private Date rauFechaPasRev;
    private Date rauFechaResFirme;
    private EstadoResolucAutVO estadoResolucAutVO;
    private SolicitudAutorizaVO solicitudAutorizaVO;
    private List<ComunicacSiitoVO> comunicacSiitoListVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private List<RevisionFinancResolAutorizVO> revisionFinancResolAutorizListVo;
    private List<RevisionGctResolucAutorizaVO> revisionGctResolucAutorizaListVo;
    private String rauValidacFinanc;
    private String rauValidacGct;
    private Long idEstadoAnterior;
    
    

    public ResolucionAutorizVO() {

    }

    /**
     * @author Modifica Giovanni
     * @param siiResolucionAutoriz
     */
    public ResolucionAutorizVO(SiiResolucionAutoriz siiResolucionAutoriz) {

        this.rauCodigo = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauCodigo();
        this.rauNumeroRes = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauNumeroRes();
        this.rauFechaNotif = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauFechaNotif();
        this.rauMedioNotif = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauMedioNotif();
        this.rauObservaciones = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauObservaciones();
        this.rauFechaResol = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauFechaResol();
        this.rauFechaPasFirma = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauFechaPasFirma();
        this.rauFechaPasRev = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauFechaPasRev();
        this.rauFechaResFirme = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauFechaResFirme();
        this.rauValidacFinanc = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauValidacFinanc();
        this.rauValidacGct = siiResolucionAutoriz == null ? null : siiResolucionAutoriz.getRauValidacGct();
        //Padres:
        if (siiResolucionAutoriz != null) {
            //Estado
            if (siiResolucionAutoriz.getSiiEstadoResolucAut() != null) {
                this.estadoResolucAutVO = new EstadoResolucAutVO(siiResolucionAutoriz.getSiiEstadoResolucAut());
                this.idEstadoAnterior = siiResolucionAutoriz.getSiiEstadoResolucAut().getEraCodigo();
            }
            //Solicituf Autorizacion
            if (siiResolucionAutoriz.getSiiSolicitudAutoriza() != null) {
                this.solicitudAutorizaVO = new SolicitudAutorizaVO(siiResolucionAutoriz.getSiiSolicitudAutoriza());
            }
            //Archivo fisico
            if (siiResolucionAutoriz.getSiiArchivoFisico() != null) {
                this.archivoFisicoVo = new ArchivoFisicoVO(siiResolucionAutoriz.getSiiArchivoFisico());
            }
        }
    }

    public void setRauCodigo(Long rauCodigo) {
        this.rauCodigo = rauCodigo;
    }

    public Long getRauCodigo() {
        return rauCodigo;
    }

    public void setRauNumeroRes(Long rauNumeroRes) {
        this.rauNumeroRes = rauNumeroRes;
    }

    public Long getRauNumeroRes() {
        return rauNumeroRes;
    }

    public void setEstadoResolucAutVO(EstadoResolucAutVO estadoResolucAutVO) {
        this.estadoResolucAutVO = estadoResolucAutVO;
    }

    public EstadoResolucAutVO getEstadoResolucAutVO() {
        return estadoResolucAutVO;
    }

    public void setSolicitudAutorizaVO(SolicitudAutorizaVO solicitudAutorizaVO) {
        this.solicitudAutorizaVO = solicitudAutorizaVO;
    }

    public SolicitudAutorizaVO getSolicitudAutorizaVO() {
        return solicitudAutorizaVO;
    }

    public void setRauFechaNotif(Date rauFechaNotif) {
        this.rauFechaNotif = rauFechaNotif;
    }

    public Date getRauFechaNotif() {
        return rauFechaNotif;
    }

    public void setRauMedioNotif(String rauMedioNotif) {
        this.rauMedioNotif = rauMedioNotif;
    }

    public String getRauMedioNotif() {
        return rauMedioNotif;
    }

    public void setRauObservaciones(String rauObservaciones) {
        this.rauObservaciones = rauObservaciones;
    }

    public String getRauObservaciones() {
        return rauObservaciones;
    }

    public void setRauFechaResol(Date rauFechaResol) {
        this.rauFechaResol = rauFechaResol;
    }

    public Date getRauFechaResol() {
        return rauFechaResol;
    }

    public void setRauFechaPasFirma(Date rauFechaPasFirma) {
        this.rauFechaPasFirma = rauFechaPasFirma;
    }

    public Date getRauFechaPasFirma() {
        return rauFechaPasFirma;
    }

    public void setRauFechaPasRev(Date rauFechaPasRev) {
        this.rauFechaPasRev = rauFechaPasRev;
    }

    public Date getRauFechaPasRev() {
        return rauFechaPasRev;
    }

    public void setRauFechaResFirme(Date rauFechaResFirme) {
        this.rauFechaResFirme = rauFechaResFirme;
    }

    public Date getRauFechaResFirme() {
        return rauFechaResFirme;
    }

    public void setComunicacSiitoListVo(List<ComunicacSiitoVO> comunicacSiitoListVo) {
        this.comunicacSiitoListVo = comunicacSiitoListVo;
    }

    public List<ComunicacSiitoVO> getComunicacSiitoListVo() {
        return comunicacSiitoListVo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public int compareTo(ResolucionAutorizVO compareResolucionAutorizVO) {


        //descending order solicitudAutorizaVO.expedienteDocum.edoCodigo
        if (compareResolucionAutorizVO.getSolicitudAutorizaVO() != null &&
            compareResolucionAutorizVO.getSolicitudAutorizaVO().getExpedienteDocum() != null &&
            compareResolucionAutorizVO.getSolicitudAutorizaVO().getExpedienteDocum().getEdoCodigo() != null &&
            this.getSolicitudAutorizaVO().getExpedienteDocum() != null &&
            this.getSolicitudAutorizaVO().getExpedienteDocum().getEdoCodigo() != null)
            return compareResolucionAutorizVO.getSolicitudAutorizaVO().getExpedienteDocum().getEdoCodigo().compareTo(this.getSolicitudAutorizaVO().getExpedienteDocum().getEdoCodigo());
        else if (compareResolucionAutorizVO.getSolicitudAutorizaVO() != null ||
                 compareResolucionAutorizVO.getSolicitudAutorizaVO().getExpedienteDocum() != null ||
                 compareResolucionAutorizVO.getSolicitudAutorizaVO().getExpedienteDocum().getEdoCodigo() != null)
            return 1;
        else if (this.getSolicitudAutorizaVO().getExpedienteDocum().getEdoCodigo() != null)
            return -1;
        else
            return 0;

    }

    public void setRevisionFinancResolAutorizListVo(List<RevisionFinancResolAutorizVO> revisionFinancResolAutorizListVo) {
        this.revisionFinancResolAutorizListVo = revisionFinancResolAutorizListVo;
    }

    public List<RevisionFinancResolAutorizVO> getRevisionFinancResolAutorizListVo() {
        return revisionFinancResolAutorizListVo;
    }

    public void setRevisionGctResolucAutorizaListVo(List<RevisionGctResolucAutorizaVO> revisionGctResolucAutorizaListVo) {
        this.revisionGctResolucAutorizaListVo = revisionGctResolucAutorizaListVo;
    }

    public List<RevisionGctResolucAutorizaVO> getRevisionGctResolucAutorizaListVo() {
        return revisionGctResolucAutorizaListVo;
    }

    public void setRauValidacFinanc(String rauValidacFinanc) {
        this.rauValidacFinanc = rauValidacFinanc;
    }

    public String getRauValidacFinanc() {
        return rauValidacFinanc;
    }

    public void setRauValidacGct(String rauValidacGct) {
        this.rauValidacGct = rauValidacGct;
    }

    public String getRauValidacGct() {
        return rauValidacGct;
    }
}
