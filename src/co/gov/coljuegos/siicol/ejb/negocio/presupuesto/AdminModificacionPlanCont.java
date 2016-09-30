package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionPlanContVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminModificacionPlanCont {
    public List<ModificacionPlanContVO> buscarTrasladosPlanContEnTramite() throws ExcepcionDAO;
    public ModificacionPlanContVO crearTraslado(ModificacionPlanContVO modificacionPlanContVo,UsuarioVO usuarioVO) throws ExcepcionDAO;
    public ModificacionPlanContVO actualizarTraslado(ModificacionPlanContVO modificacionPlanContVo, UsuarioVO usuarioVO,
                                                     boolean cambioEstado) throws ExcepcionDAO;
}
