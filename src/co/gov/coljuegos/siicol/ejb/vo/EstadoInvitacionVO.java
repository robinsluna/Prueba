package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoInvitacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;

import java.util.List;

public class EstadoInvitacionVO {
    private Long einCodigo;
    private String einDescripcion;
    private String einNombre;
    private List<InvitacionProcesoVO> invitacionProcesoListVO;

    public EstadoInvitacionVO(SiiEstadoInvitacion estadoInvitacion) {
        this.einCodigo = estadoInvitacion.getEinCodigo();
        this.einDescripcion = estadoInvitacion.getEinDescripcion();
        this.einNombre = estadoInvitacion.getEinNombre();
    }

    public EstadoInvitacionVO() {
        
    }
    public void setEinCodigo(Long einCodigo) {
        this.einCodigo = einCodigo;
    }

    public Long getEinCodigo() {
        return einCodigo;
    }

    public void setEinDescripcion(String einDescripcion) {
        this.einDescripcion = einDescripcion;
    }

    public String getEinDescripcion() {
        return einDescripcion;
    }

    public void setEinNombre(String einNombre) {
        this.einNombre = einNombre;
    }

    public String getEinNombre() {
        return einNombre;
    }

    public void setInvitacionProcesoListVO(List<InvitacionProcesoVO> invitacionProcesoListVO) {
        this.invitacionProcesoListVO = invitacionProcesoListVO;
    }

    public List<InvitacionProcesoVO> getInvitacionProcesoListVO() {
        return invitacionProcesoListVO;
    }
}
