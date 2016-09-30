package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AmparoEstPrevVO;

import java.util.List;
import javax.ejb.Local;

@Local
public interface AdminAmparoEstPrev {
    public AmparoEstPrevVO buscarAmparoEstPrevPorId(AmparoEstPrevVO amparoEstPrevVo) throws ExcepcionDAO;            
    public AmparoEstPrevVO  insertarAmparoEstPrev (AmparoEstPrevVO  amparoEstPrevVo) throws ExcepcionDAO;        
    public AmparoEstPrevVO actualizarAmparoEstPrev(AmparoEstPrevVO amparoEstPrevVo) throws ExcepcionDAO;        
    public List<AmparoEstPrevVO> buscarTodosAmparoEstPrev() throws ExcepcionDAO;
    public List<AmparoEstPrevVO> buscarAmparoEstPrevPorIdEstPrevio (Long idEstPrevio) throws ExcepcionDAO;
    public void eliminarAmparoEstPrev (AmparoEstPrevVO amparoEstPrevVo) throws ExcepcionDAO;
}

