package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.vo.MesVO;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface AdminMes {
    
    public MesVO buscarMesPorId(MesVO mesVo) throws ExcepcionDAO;
    public List<MesVO> buscarTodosMes() throws ExcepcionDAO;
}
