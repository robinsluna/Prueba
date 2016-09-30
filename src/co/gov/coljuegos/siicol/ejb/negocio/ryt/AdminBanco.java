package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.BancoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminBanco {
    
    /**
     * @author
     * @return
     * @throws ExcepcionDAO
     */
    public List<BancoVO> consultarBancos() throws ExcepcionDAO;
    public BancoVO buscarBancoPorCodigo(String idBanco) throws ExcepcionDAO;
 
}
