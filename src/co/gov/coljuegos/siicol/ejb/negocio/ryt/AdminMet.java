package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MetVO;

import javax.ejb.Local;

@Local
public interface AdminMet {
    
    public MetVO insertarMet(MetVO mesVo) throws ExcepcionDAO;
    public MetVO buscarMetPorNuc(String metVo) throws ExcepcionDAO;
    public MetVO modificarMet(MetVO metVO) throws ExcepcionDAO;
    public int buscarMetMarcadasPorContrato(String contrato, String nit) throws ExcepcionDAO;
}
