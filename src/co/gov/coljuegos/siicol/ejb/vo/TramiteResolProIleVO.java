package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProIle;

import java.util.Date;

public class TramiteResolProIleVO implements Comparable {
    private Long tpiCodigo;
    private Date tpiFecha;
    private ResolucionProcIlegVO resolucionProcIlegVo;
    private UsuarioVO usuarioConecVo;
    private EstadoTramResProcIlegVO estadoTramResProcIlegVo;
    
    public TramiteResolProIleVO() {
        
    }
    public TramiteResolProIleVO(SiiTramiteResolProIle tramiteResolProIle) {
        this.tpiCodigo = tramiteResolProIle.getTpiCodigo();
        this.tpiFecha = tramiteResolProIle.getTpiFecha();
        //Padres
        if (tramiteResolProIle.getSiiEstadoTramResProcIleg()!=null) {
            this.estadoTramResProcIlegVo = new EstadoTramResProcIlegVO(tramiteResolProIle.getSiiEstadoTramResProcIleg());
        }
        if (tramiteResolProIle.getSiiResolucionProcIleg() != null) {
            this.resolucionProcIlegVo = new ResolucionProcIlegVO(tramiteResolProIle.getSiiResolucionProcIleg());
        }
        if (tramiteResolProIle.getSiiUsuarioConec() != null) {
            this.usuarioConecVo = new UsuarioVO(tramiteResolProIle.getSiiUsuarioConec());
        }
        
    }

    public void setTpiCodigo(Long tpiCodigo) {
        this.tpiCodigo = tpiCodigo;
    }

    public Long getTpiCodigo() {
        return tpiCodigo;
    }

    public void setTpiFecha(Date tpiFecha) {
        this.tpiFecha = tpiFecha;
    }

    public Date getTpiFecha() {
        return tpiFecha;
    }

    public void setResolucionProcIlegVo(ResolucionProcIlegVO resolucionProcIlegVo) {
        this.resolucionProcIlegVo = resolucionProcIlegVo;
    }

    public ResolucionProcIlegVO getResolucionProcIlegVo() {
        return resolucionProcIlegVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setEstadoTramResProcIlegVo(EstadoTramResProcIlegVO estadoTramResProcIlegVo) {
        this.estadoTramResProcIlegVo = estadoTramResProcIlegVo;
    }

    public EstadoTramResProcIlegVO getEstadoTramResProcIlegVo() {
        return estadoTramResProcIlegVo;
    }

    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof TramiteResolProIleVO) {
            TramiteResolProIleVO trpVo = (TramiteResolProIleVO) o;
            if (trpVo!=null && trpVo.getEstadoTramResProcIlegVo()!=null && this.estadoTramResProcIlegVo!=null) {
                // comparar los estados de los dos tramites de resolucion a comparar
                resultado = this.estadoTramResProcIlegVo.compareTo(trpVo.getEstadoTramResProcIlegVo());
            }
        }
        return (resultado);
    }
}
