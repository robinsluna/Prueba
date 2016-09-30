package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsultaWebContrat;

import java.util.Date;
import java.util.List;

public class ConsultaWebContratVO {
    private ArchivoFisicoVO archivoFisicoVO;
    private Long cwcCodigo;
    private String cwcEntidad;
    private Date cwcFecha;
    private String cwcObjetoCont;
    private List<CotizacionEstudioVO> cotizacionEstudioList2VO;
    
    public ConsultaWebContratVO () {
        
    }

    public ConsultaWebContratVO (SiiConsultaWebContrat consultaWebContrat) {
        this.cwcCodigo = consultaWebContrat.getCwcCodigo();
        this.cwcEntidad = consultaWebContrat.getCwcEntidad();
        this.cwcFecha = consultaWebContrat.getCwcFecha();
        this.cwcObjetoCont = consultaWebContrat.getCwcObjetoCont();
        //Padres
        if (consultaWebContrat.getSiiArchivoFisico() != null ) {
            this.archivoFisicoVO = new ArchivoFisicoVO(consultaWebContrat.getSiiArchivoFisico()); 
        }
        
    }

    public void setArchivoFisicoVO(ArchivoFisicoVO archivoFisicoVO) {
        this.archivoFisicoVO = archivoFisicoVO;
    }

    public ArchivoFisicoVO getArchivoFisicoVO() {
        return archivoFisicoVO;
    }

    public void setCwcCodigo(Long cwcCodigo) {
        this.cwcCodigo = cwcCodigo;
    }

    public Long getCwcCodigo() {
        return cwcCodigo;
    }

    public void setCwcEntidad(String cwcEntidad) {
        this.cwcEntidad = cwcEntidad;
    }

    public String getCwcEntidad() {
        return cwcEntidad;
    }

    public void setCwcFecha(Date cwcFecha) {
        this.cwcFecha = cwcFecha;
    }

    public Date getCwcFecha() {
        return cwcFecha;
    }

    public void setCwcObjetoCont(String cwcObjetoCont) {
        this.cwcObjetoCont = cwcObjetoCont;
    }

    public String getCwcObjetoCont() {
        return cwcObjetoCont;
    }

    public void setCotizacionEstudioList2VO(List<CotizacionEstudioVO> cotizacionEstudioList2VO) {
        this.cotizacionEstudioList2VO = cotizacionEstudioList2VO;
    }

    public List<CotizacionEstudioVO> getCotizacionEstudioList2VO() {
        return cotizacionEstudioList2VO;
    }
}
