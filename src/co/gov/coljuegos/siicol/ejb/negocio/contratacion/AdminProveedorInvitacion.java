package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ProveedorInvitacionVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminProveedorInvitacion {
    public ProveedorInvitacionVO buscarProveedorInvitacionPorId(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO;

    public ProveedorInvitacionVO insertarProveedorInvitacion(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO;

    public ProveedorInvitacionVO actualizarProveedorInvitacion(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO;

    public void eliminarProveedorInvitacion(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO;

    public List<ProveedorInvitacionVO> buscarTodoProveedorInvitacionPorInvitacion(Integer invitacion) throws ExcepcionDAO;
    
    public List<ProveedorInvitacionVO> buscarProveedorInvitacionPorCodProveedoreInvitacion(long idProveedor,long idInvitacionProceso) throws ExcepcionDAO;
    
    public List<ProveedorInvitacionVO> buscarProveedorInvitacionPorProcesoContratacion (Long prcCodigo) throws ExcepcionDAO;
}
