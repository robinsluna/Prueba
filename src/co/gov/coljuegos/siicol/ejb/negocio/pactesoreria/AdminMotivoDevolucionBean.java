package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoDevolucionSEMDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;
import co.gov.coljuegos.siicol.ejb.vo.MotivoDevolucionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminMotivoDevolucionBean implements AdminMotivoDevolucion{
    
    @EJB
    MotivoDevolucionSEMDAO motivoDevolucionDao;
    
    public AdminMotivoDevolucionBean() {
        
    }

    public List<MotivoDevolucionVO> buscarTodoMotivoDevolucion() throws ExcepcionDAO {
        
        List<SiiMotivoDevolucion> siiMotivos = motivoDevolucionDao.buscarTodoMotivoDevolucionSEM();
        List<MotivoDevolucionVO> motivosV0 = new ArrayList();
        for (SiiMotivoDevolucion motivo : siiMotivos){
            motivosV0.add(new MotivoDevolucionVO(motivo));
        }
        return  motivosV0; 
    }
}
