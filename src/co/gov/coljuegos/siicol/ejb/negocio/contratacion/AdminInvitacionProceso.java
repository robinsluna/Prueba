package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ImprimirInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.InvitacionProcesoVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminInvitacionProceso {
    public InvitacionProcesoVO buscarInvitacionProcesoPorId(Long iprCodigo) throws ExcepcionDAO;
    public InvitacionProcesoVO insertarInvitacionProceso(InvitacionProcesoVO invitacionProcesoVO) throws ExcepcionDAO;
    
    /**
     * @author Modifica Giovanni
     * @param invitacionProcesoVO
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public void actualizarInvitacionProceso(InvitacionProcesoVO invitacionProcesoVO ,
                                            UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion;
    
    public List<InvitacionProcesoVO> buscarInvitacionProcesoPorProceso(InvitacionProcesoVO invitacionProcesoVO) throws ExcepcionDAO;
    public List<InvitacionProcesoVO> buscarTodaInvitacionProceso(InvitacionProcesoVO invitacionProcesoVO) throws ExcepcionDAO;
    public ImprimirInvitacionVO buscarDatosImpresionInvitacion (Integer idInvitacion) throws ExcepcionDAO;
    public PersonaVO buscarDatosFuncionarioImpresion (Long codigoFuncionario) throws ExcepcionDAO;
    public List<InvitacionProcesoVO> buscarProcesoContratacionInvitacion () throws ExcepcionDAO;
    public List<InvitacionProcesoVO> buscarInvitacionProcesoPorProceso(Long prcCodigo) throws ExcepcionDAO;
}
