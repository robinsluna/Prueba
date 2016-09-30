package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ImpContabOblNoPresVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionNoPresupVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

public interface AdminObligacionNoPresup {
    public ObligacionNoPresupVO insertarSiiObligacionNoPresup(ObligacionNoPresupVO obligacionNoPresupVO) throws ExcepcionDAO;

    public List<ObligacionNoPresupVO> buscarTodoSiiObligacionNoPresup() throws ExcepcionDAO;

    public ObligacionNoPresupVO buscarPorCodigoObligacionNoPres(Long idCodigoObligNoPres) throws ExcepcionDAO;

    public Long buscarConsecutivoObligaNoPres() throws ExcepcionDAO;

    /**
     * @author Modifica Giovannni
     * @param obligacionNoPresupVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ObligacionNoPresupVO actualizarSiiObligacionNoPresup(ObligacionNoPresupVO obligacionNoPresupVo,
                                                                UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                  ExcepcionAplicacion;

    public List<ObligacionNoPresupVO> buscarObligacionesNoPresSinOrdenPago() throws ExcepcionDAO;
    
}
