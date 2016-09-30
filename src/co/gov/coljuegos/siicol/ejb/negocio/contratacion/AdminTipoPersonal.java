package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoPersonalVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoPersonal {
    
    /**
     *metodo para consultar todos los tipos de personal
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<TipoPersonalVO> buscarTipoPersonal() throws ExcepcionDAO;    
}
