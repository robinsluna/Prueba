package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TasaInteresVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTasaInteres {
    public TasaInteresVO buscarTasaInteresPorId (Long id) throws ExcepcionDAO;
    
    public TasaInteresVO insertarTasaInteres (TasaInteresVO tasaInteresVo) throws ExcepcionDAO;
    
    public List<TasaInteresVO> buscarTodoTasaInteres () throws ExcepcionDAO;
    
    public TasaInteresVO actualizarTasaInteres (TasaInteresVO tasaInteresVo) throws ExcepcionDAO;
}
