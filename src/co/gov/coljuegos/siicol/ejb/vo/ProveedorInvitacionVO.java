package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedorInvitacion;

public class ProveedorInvitacionVO {
    private Long pinCodigo;
    private ProveedorVO proveedorVO;
    private InvitacionProcesoVO invitacionProcesoVO;

    public ProveedorInvitacionVO(SiiProveedorInvitacion proveedorInvitacion){
        this.pinCodigo = proveedorInvitacion.getPinCodigo();
        //Padres:
        this.proveedorVO = new ProveedorVO(proveedorInvitacion.getSiiProveedor());
        this.invitacionProcesoVO = new InvitacionProcesoVO(proveedorInvitacion.getSiiInvitacionProceso());
    }
    public ProveedorInvitacionVO(){
        
    }
    
    public void setPinCodigo(Long pinCodigo) {
        this.pinCodigo = pinCodigo;
    }

    public Long getPinCodigo() {
        return pinCodigo;
    }

    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

    public ProveedorVO getProveedorVO() {
        return proveedorVO;
    }

    public void setInvitacionProcesoVO(InvitacionProcesoVO invitacionProcesoVO) {
        this.invitacionProcesoVO = invitacionProcesoVO;
    }

    public InvitacionProcesoVO getInvitacionProcesoVO() {
        return invitacionProcesoVO;
    } 
}
