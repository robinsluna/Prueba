package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoAnulaAccConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulaAccCont;
import co.gov.coljuegos.siicol.ejb.vo.MotivoAnulaAccContVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminMotivoAnulaAccContBean implements AdminMotivoAnulaAccCont {
    @EJB 
    private MotivoAnulaAccConDAO motivoAnulaAccConDao;
    
    public AdminMotivoAnulaAccContBean() {
    }

    public List<MotivoAnulaAccContVO> buscarTodosMotivos() throws ExcepcionDAO {
        List<MotivoAnulaAccContVO> motivosVo = new ArrayList<MotivoAnulaAccContVO>();
        for (SiiMotivoAnulaAccCont motivo :motivoAnulaAccConDao.buscarTodo()) {
            motivosVo.add(new MotivoAnulaAccContVO(motivo));
        }
        return motivosVo;
    }
}
