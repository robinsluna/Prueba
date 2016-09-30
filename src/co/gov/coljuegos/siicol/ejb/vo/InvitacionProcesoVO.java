package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;

import java.util.Date;
import java.util.List;

public class InvitacionProcesoVO {
    private Long iprCodigo;
    private Date iprFecha;
    private Date iprFechaVenc;
    private ProcesoContratacionVO procesoContratacionVO;
    private UsuarioVO usuarioVO;
    private List<ProveedorInvitacionVO> proveedorInvitacionListVO;
    private EstadoInvitacionVO estadoInvitacionVO;
    private Long idEstadoAnterior;

    public InvitacionProcesoVO() {
    }


    /**
     * @author Modifica Giovanni
     * @param invitacionProceso
     */
    public InvitacionProcesoVO(SiiInvitacionProceso invitacionProceso) {
        this.iprCodigo = invitacionProceso.getIprCodigo();
        
        if (invitacionProceso.getIprFecha() != null) {
            this.iprFecha = invitacionProceso.getIprFecha();
        }
        if (invitacionProceso.getIprFechaVenc() != null) {
            this.iprFechaVenc = invitacionProceso.getIprFechaVenc();
        }
        
        //Padres:
        //Proceso Contratacion 
        if (invitacionProceso.getSiiProcesoContratacion() != null) {
            this.procesoContratacionVO = new ProcesoContratacionVO(invitacionProceso.getSiiProcesoContratacion());
        }
        //Usuario
        if (invitacionProceso.getSiiUsuario() != null) {
            this.usuarioVO = new UsuarioVO(invitacionProceso.getSiiUsuario());
        }
        //Estado Invitacion
        if (invitacionProceso.getSiiEstadoInvitacion() != null) {
            this.estadoInvitacionVO = new EstadoInvitacionVO(invitacionProceso.getSiiEstadoInvitacion());
            this.idEstadoAnterior = invitacionProceso.getSiiEstadoInvitacion().getEinCodigo();
        }
    }


    public void setIprCodigo(Long iprCodigo) {
        this.iprCodigo = iprCodigo;
    }

    public Long getIprCodigo() {
        return iprCodigo;
    }

    public void setIprFecha(Date iprFecha) {
        this.iprFecha = iprFecha;
    }

    public Date getIprFecha() {
        return iprFecha;
    }

    public void setProcesoContratacionVO(ProcesoContratacionVO procesoContratacionVO) {
        this.procesoContratacionVO = procesoContratacionVO;
    }

    public ProcesoContratacionVO getProcesoContratacionVO() {
        return procesoContratacionVO;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public void setProveedorInvitacionListVO(List<ProveedorInvitacionVO> proveedorInvitacionListVO) {
        this.proveedorInvitacionListVO = proveedorInvitacionListVO;
    }

    public List<ProveedorInvitacionVO> getProveedorInvitacionListVO() {
        return proveedorInvitacionListVO;
    }

    public void setEstadoInvitacionVO(EstadoInvitacionVO estadoInvitacionVO) {
        this.estadoInvitacionVO = estadoInvitacionVO;
    }

    public EstadoInvitacionVO getEstadoInvitacionVO() {
        return estadoInvitacionVO;
    }

    public void setIprFechaVenc(Date iprFechaVenc) {
        this.iprFechaVenc = iprFechaVenc;
    }

    public Date getIprFechaVenc() {
        return iprFechaVenc;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
