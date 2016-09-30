package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaRp;

import java.util.List;

public class CargaRpVO {
    private Long crpCodigo;
    private String crpNombreArch;
    private ArchivoFisicoVO archivoFisicoVo;
    private List<RpVO> RpListVo;
    private String crpDescripcion;

    public CargaRpVO() {

    }

    public CargaRpVO(SiiCargaRp cargaRp) {
        if (cargaRp != null) {
            this.crpCodigo = cargaRp.getCrpCodigo();
            this.crpNombreArch = cargaRp.getCrpNombreArch();
            this.crpDescripcion = cargaRp.getCrpDescripcion();
            //Padres:
            if (cargaRp.getSiiArchivoFisico() != null) {
                this.archivoFisicoVo = new ArchivoFisicoVO(cargaRp.getSiiArchivoFisico());
            }
        }
    }

    public void setCrpCodigo(Long crpCodigo) {
        this.crpCodigo = crpCodigo;
    }

    public Long getCrpCodigo() {
        return crpCodigo;
    }

    public void setCrpNombreArch(String crpNombreArch) {
        this.crpNombreArch = crpNombreArch;
    }

    public String getCrpNombreArch() {
        return crpNombreArch;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setRpListVo(List<RpVO> RpListVo) {
        this.RpListVo = RpListVo;
    }

    public void setCrpDescripcion(String crpDescripcion) {
        this.crpDescripcion = crpDescripcion;
    }

    public String getCrpDescripcion() {
        return crpDescripcion;
    }

    public List<RpVO> getRpListVo() {
        return RpListVo;
    }

}
