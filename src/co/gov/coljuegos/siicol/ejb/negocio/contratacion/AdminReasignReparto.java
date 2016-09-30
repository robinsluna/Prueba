package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;
import co.gov.coljuegos.siicol.ejb.vo.IncumplimientoContrVO;
import co.gov.coljuegos.siicol.ejb.vo.RepartoFiscalizadorVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminReasignReparto {
    
    public List<IncumplimientoContrVO> buscarTodoIncumplimientos() throws ExcepcionDAO;
    public RepartoFiscalizadorVO actualizarReparto(RepartoFiscalizadorVO repartoFiscalizadorVO, UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    public RepartoFiscalizadorVO insertarReprato(RepartoFiscalizadorVO reparto) throws ExcepcionDAO;
    public FiscalizadorSustancVO reasignarSustanciador(Long fsuCodigo, Long tacCodigo   ) throws ExcepcionDAO;
    public IncumplimientoContrVO actualizarIncumplimiento(IncumplimientoContrVO incumplimientoContrVO) throws ExcepcionDAO;
    public RepartoFiscalizadorVO buscarRepartoPorIncCodigoYActivo(Long icnCodigo) throws ExcepcionDAO;
    public List<RepartoFiscalizadorVO> buscarRepartoFiscalizActivos() throws ExcepcionDAO;
   // public RepartoFiscalizadorVO cambiarEstadoReparto(RepartoFiscalizadorVO reparto) throws ExcepcionDAO;
   public void reasignarReparto(RepartoFiscalizadorVO repartoOriginalVo, RepartoFiscalizadorVO nuevoRepartoVo) throws ExcepcionDAO;

}
