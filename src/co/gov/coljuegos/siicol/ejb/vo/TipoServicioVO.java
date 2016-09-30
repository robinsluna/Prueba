package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoServicio;

import java.util.List;

public class TipoServicioVO {
    private String tseActivo;
    private Long tseCodigo;
    private String tseNombre;
    private List<CotizacionEstudioVO> cotizacionEstudioListVO;

    public TipoServicioVO() {
    }

    public TipoServicioVO(SiiTipoServicio tipoServicio) {
        this.tseActivo = tipoServicio.getTseActivo();
        this.tseCodigo = tipoServicio.getTseCodigo();
        this.tseNombre = tipoServicio.getTseNombre();
    }


    public void setTseActivo(String tseActivo) {
        this.tseActivo = tseActivo;
    }

    public String getTseActivo() {
        return tseActivo;
    }

    public void setTseCodigo(Long tseCodigo) {
        this.tseCodigo = tseCodigo;
    }

    public Long getTseCodigo() {
        return tseCodigo;
    }

    public void setTseNombre(String tseNombre) {
        this.tseNombre = tseNombre;
    }

    public String getTseNombre() {
        return tseNombre;
    }

    public void setCotizacionEstudioListVO(List<CotizacionEstudioVO> cotizacionEstudioListVO) {
        this.cotizacionEstudioListVO = cotizacionEstudioListVO;
    }

    public List<CotizacionEstudioVO> getCotizacionEstudioListVO() {
        return cotizacionEstudioListVO;
    }
}
