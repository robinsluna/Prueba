package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CorteCarteraVO;

import javax.ejb.Local;

@Local
public interface AdminCorteCartera {
    
    public CorteCarteraVO buscarCorteCarteraPorVigenciaPorMes(int vigencia, int mes) throws ExcepcionDAO;
    
    public CorteCarteraVO insertarCorteCartera(CorteCarteraVO corteCarteraVo) throws ExcepcionDAO;
    
    public CorteCarteraVO actualizarCorteCartera(CorteCarteraVO corteCarteraVo) throws ExcepcionDAO;
    
    public CorteCarteraVO buscarCorteCarteraPorId(Long idCorteCartera) throws ExcepcionDAO;
    
    public void realizarCorteCartera(CorteCarteraVO corteCarteraVo) throws ExcepcionDAO;
}
