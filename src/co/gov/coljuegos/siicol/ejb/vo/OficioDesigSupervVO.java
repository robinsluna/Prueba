package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioDesigSuperv;


import java.util.Date;

public class OficioDesigSupervVO {
    private Long odsCodgo;
    private String odsEstado;
    private Date odsFechaDesig;
    private String odsNombreExterno;
    private String odsNumIdentExt;
    private UsuarioVO usuarioVo;
    private ProcesoContratacionVO procesoContratacionVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private TipoIdentificacionVO tipoIdentificacionVo;

    public OficioDesigSupervVO() {        
    }
    
    public OficioDesigSupervVO(SiiOficioDesigSuperv siiOficioDesigSuperv) {        
        this.odsCodgo = siiOficioDesigSuperv.getOdsCodgo();
        this.odsEstado = siiOficioDesigSuperv.getOdsEstado();
        this.odsFechaDesig = siiOficioDesigSuperv.getOdsFechaDesig();
        this.odsNumIdentExt = siiOficioDesigSuperv.getOdsNumIdentExt();
        //Padres
        if (siiOficioDesigSuperv.getSiiProcesoContratacion() != null){
            this.procesoContratacionVo = new ProcesoContratacionVO(siiOficioDesigSuperv.getSiiProcesoContratacion());
        }
        if (siiOficioDesigSuperv.getSiiTipoIdentificacion() != null){
            this.tipoIdentificacionVo = new TipoIdentificacionVO(siiOficioDesigSuperv.getSiiTipoIdentificacion());
        }
        if (siiOficioDesigSuperv.getSiiUsuario() != null){
            this.usuarioVo = new UsuarioVO(siiOficioDesigSuperv.getSiiUsuario());
        }
        if (siiOficioDesigSuperv.getSiiArchivoFisico() != null){
            this.archivoFisicoVo = new ArchivoFisicoVO(siiOficioDesigSuperv.getSiiArchivoFisico());
        }                                    
    }


    public void setOdsCodgo(Long odsCodgo) {
        this.odsCodgo = odsCodgo;
    }

    public Long getOdsCodgo() {
        return odsCodgo;
    }

    public void setOdsEstado(String odsEstado) {
        this.odsEstado = odsEstado;
    }

    public String getOdsEstado() {
        return odsEstado;
    }

    public void setOdsFechaDesig(Date odsFechaDesig) {
        this.odsFechaDesig = odsFechaDesig;
    }

    public Date getOdsFechaDesig() {
        return odsFechaDesig;
    }

    public void setOdsNumIdentExt(String odsNumIdentExt) {
        this.odsNumIdentExt = odsNumIdentExt;
    }

    public String getOdsNumIdentExt() {
        return odsNumIdentExt;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }

    public void setProcesoContratacionVo(ProcesoContratacionVO procesoContratacionVo) {
        this.procesoContratacionVo = procesoContratacionVo;
    }

    public ProcesoContratacionVO getProcesoContratacionVo() {
        return procesoContratacionVo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setTipoIdentificacionVo(TipoIdentificacionVO tipoIdentificacionVo) {
        this.tipoIdentificacionVo = tipoIdentificacionVo;
    }

    public TipoIdentificacionVO getTipoIdentificacionVo() {
        return tipoIdentificacionVo;
    }

    public void setOdsNombreExterno(String odsNombreExterno) {
        this.odsNombreExterno = odsNombreExterno;
    }

    public String getOdsNombreExterno() {
        return odsNombreExterno;
    }
}
