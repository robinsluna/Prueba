package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AlcanceInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;


public interface AdminAlcanceInvitacion {
    public AlcanceInvitacionVO buscarUltimoAlcanceInvitacionPorProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO;

    public AlcanceInvitacionVO insertarAlcanceInvitacion(AlcanceInvitacionVO alcanceInvitacionVo) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param alcanceInvitacionVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public AlcanceInvitacionVO actualizarAlcanceInvitacion(AlcanceInvitacionVO alcanceInvitacionVo,
                                                           UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                             ExcepcionAplicacion;

    public void eliminarAlcanceInvitacion(Long idAlcanceInvitacion) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param alcanceInvitacionVo
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public void guardarAlcanceInvitacion(AlcanceInvitacionVO alcanceInvitacionVo,
                                         UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion;
}
