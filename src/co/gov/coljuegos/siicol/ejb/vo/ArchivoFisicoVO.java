package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;

import java.util.Date;
import java.util.List;


public class ArchivoFisicoVO {
    private Long afiCodigo;
    private Date afiFecha;
    private String afiNombreFs;
    private String afiNombreOrignal;
    private String afiPathRelativo;
    private String afiActivo;
    
    private List<SolicitudEstMercadoVO> solicitudEstMercadoListVo;
    private List<ConsultaWebContratVO> consultaWebContratListVo;
    private List<ExpedArchFisicoVO> listaExpedArchFisicoVo;
    private List<CargaNominaVO> cargaNominaListVo;
    private List<CargaDocumentoContVO> cargaDocumentoContListVo;
    

    public ArchivoFisicoVO(){
        
    }

    public ArchivoFisicoVO(SiiArchivoFisico archivoFisico){
        if (archivoFisico!=null) {
            this.afiCodigo = archivoFisico.getAfiCodigo();
            this.afiFecha = archivoFisico.getAfiFecha();
            this.afiNombreFs = archivoFisico.getAfiNombreFs();
            this.afiNombreOrignal = archivoFisico.getAfiNombreOrignal();
            this.afiPathRelativo = archivoFisico.getAfiPathRelativo();
            this.afiActivo = archivoFisico.getAfiActivo();
        }
    }
    
    public void setListaExpedArchFisicoVo(List<ExpedArchFisicoVO> listaExpedArchFisicoVo) {
        this.listaExpedArchFisicoVo = listaExpedArchFisicoVo;
    }

    public List<ExpedArchFisicoVO> getListaExpedArchFisicoVo() {
        return listaExpedArchFisicoVo;
    }
    
    public void setAfiCodigo(Long afiCodigo) {
        this.afiCodigo = afiCodigo;
    }

    public void setAfiActivo(String afiActivo) {
        this.afiActivo = afiActivo;
    }

    public String getAfiActivo() {
        return afiActivo;
    }

    public Long getAfiCodigo() {
        return afiCodigo;
    }

    public void setAfiNombreFs(String afiNombreFs) {
        this.afiNombreFs = afiNombreFs;
    }

    public String getAfiNombreFs() {
        return afiNombreFs;
    }

    public void setAfiNombreOrignal(String afiNombreOrignal) {
        this.afiNombreOrignal = afiNombreOrignal;
    }

    public String getAfiNombreOrignal() {
        return afiNombreOrignal;
    }

    public void setAfiPathRelativo(String afiPathRelativo) {
        this.afiPathRelativo = afiPathRelativo;
    }

    public String getAfiPathRelativo() {
        return afiPathRelativo;
    }

    public void setSolicitudEstMercadoListVO(List<SolicitudEstMercadoVO> solicitudEstMercadoListVO) {
        this.solicitudEstMercadoListVo = solicitudEstMercadoListVO;
    }

    public List<SolicitudEstMercadoVO> getSolicitudEstMercadoListVO() {
        return solicitudEstMercadoListVo;
    }

    public void setConsultaWebContratListVO(List<ConsultaWebContratVO> consultaWebContratListVO) {
        this.consultaWebContratListVo = consultaWebContratListVO;
    }

    public List<ConsultaWebContratVO> getConsultaWebContratListVO() {
        return consultaWebContratListVo;
    }

    public void setCargaNominaListVo(List<CargaNominaVO> cargaNominaListVo) {
        this.cargaNominaListVo = cargaNominaListVo;
    }

    public List<CargaNominaVO> getCargaNominaListVo() {
        return cargaNominaListVo;
    }

    public void setAfiFecha(Date afiFecha) {
        this.afiFecha = afiFecha;
    }

    public Date getAfiFecha() {
        return afiFecha;
    }

    public void setCargaDocumentoContListVo(List<CargaDocumentoContVO> cargaDocumentoContListVo) {
        this.cargaDocumentoContListVo = cargaDocumentoContListVo;
    }

    public List<CargaDocumentoContVO> getCargaDocumentoContListVo() {
        return cargaDocumentoContListVo;
    }
}
