package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminFiscalizadorSustanc {
    public List<FiscalizadorSustancVO> buscarTodoFiscalizadorSustanc() throws ExcepcionDAO;
    public FiscalizadorSustancVO buscarFiscalizadorSustancPorCodigo(Long fsuCodigo) throws ExcepcionDAO;
    public FiscalizadorSustancVO insertarFiscalizadorSustanc(FiscalizadorSustancVO fiscalizadorSustancVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public FiscalizadorSustancVO actualizarFiscalizadorSustanc(FiscalizadorSustancVO fiscalizadorSustancVo) throws ExcepcionDAO;
    public FiscalizadorSustancVO sustanciadorParaAsignarProceso(Long tacCodigo) throws ExcepcionDAO, ExcepcionAplicacion;
}
