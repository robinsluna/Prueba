package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstPrevDetRubroVO;


import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstPrevDetRubro {
    public EstPrevDetRubroVO buscarEstPrevDetRubroPorId(EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO;
    public EstPrevDetRubroVO insertarEstPrevDetRubro(EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO;
    public EstPrevDetRubroVO actualizarEstPrevDetRubro(EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO;       
    public List<EstPrevDetRubroVO> buscarTodosEstPrevDetRubro() throws ExcepcionDAO;
    public List<EstPrevDetRubroVO> buscarEstPrevDetRubroPorIdEstPrevio (Long idEstPrevio) throws ExcepcionDAO;
    public void eliminarEstPrevDetRubro (EstPrevDetRubroVO estPrevDetRubroVo) throws ExcepcionDAO;
}

