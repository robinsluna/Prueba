package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioResolDesis;


public class InventarioResolDesisVO {
    
    private String irdActivo;
    private Integer irdCantidadElem;
    private Long irdCodigo;
    private TipoApuestaVO tipoApuestaVo;
    private UsuarioVO usuarioConectVo;
    private ResolucionDesisSolAutVO resolucionDesisSolAutVo;
    private TipoNovedadVO tipoNovedadVo;
    
    
    /*
     *
    private SiiTipoApuesta siiTipoApuesta;
    private SiiUsuario siiUsuarioConect;
    private SiiResolucionDesisSolAut siiResolucionDesisSolAut;
    */
    
    public InventarioResolDesisVO() {
     
    }

    public InventarioResolDesisVO(SiiInventarioResolDesis siiInventarioResolDesis) {
        
        if (siiInventarioResolDesis!=null) {
            this.irdActivo = siiInventarioResolDesis.getIrdActivo();
            this.irdCantidadElem = siiInventarioResolDesis.getIrdCantidadElem();
            this.irdCodigo = siiInventarioResolDesis.getIrdCodigo();
            
            if (siiInventarioResolDesis.getSiiUsuarioConect()!=null)
                this.usuarioConectVo = new UsuarioVO(siiInventarioResolDesis.getSiiUsuarioConect());
            
            if (siiInventarioResolDesis.getSiiTipoApuesta()!=null)
                this.tipoApuestaVo = new TipoApuestaVO(siiInventarioResolDesis.getSiiTipoApuesta());
            
            if (siiInventarioResolDesis.getSiiTipoNovedad()!=null)
                this.tipoNovedadVo = new TipoNovedadVO(siiInventarioResolDesis.getSiiTipoNovedad());
        }
    }


    public void setTipoNovedadVo(TipoNovedadVO tipoNovedadVo) {
        this.tipoNovedadVo = tipoNovedadVo;
    }

    public TipoNovedadVO getTipoNovedadVo() {
        return tipoNovedadVo;
    }
    
    public void setIrdActivo(String irdActivo) {
        this.irdActivo = irdActivo;
    }

    public String getIrdActivo() {
        return irdActivo;
    }

    public void setIrdCantidadElem(Integer irdCantidadElem) {
        this.irdCantidadElem = irdCantidadElem;
    }

    public Integer getIrdCantidadElem() {
        return irdCantidadElem;
    }

    public void setIrdCodigo(Long irdCodigo) {
        this.irdCodigo = irdCodigo;
    }

    public Long getIrdCodigo() {
        return irdCodigo;
    }

    public void setTipoApuestaVo(TipoApuestaVO tipoApuestaVo) {
        this.tipoApuestaVo = tipoApuestaVo;
    }

    public TipoApuestaVO getTipoApuestaVo() {
        return tipoApuestaVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setResolucionDesisSolAutVo(ResolucionDesisSolAutVO resolucionDesisSolAutVo) {
        this.resolucionDesisSolAutVo = resolucionDesisSolAutVo;
    }

    public ResolucionDesisSolAutVO getResolucionDesisSolAutVo() {
        return resolucionDesisSolAutVo;
    }
}
