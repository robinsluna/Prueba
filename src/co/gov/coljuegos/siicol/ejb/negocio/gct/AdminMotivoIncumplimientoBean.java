package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoIncumplimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoIncumplimiento;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncumplimientoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminMotivoIncumplimientoBean implements AdminMotivoIncumplimiento{
    @EJB
    private MotivoIncumplimientoDAO motivoIncumplimientoDao;

    public AdminMotivoIncumplimientoBean() {

    }

    public List<MotivoIncumplimientoVO> motivosTipo(String tipo) throws ExcepcionDAO {
        List<MotivoIncumplimientoVO> motivosVo = new ArrayList<MotivoIncumplimientoVO>();
        for(SiiMotivoIncumplimiento motivo : motivoIncumplimientoDao.buscarTodo()) {
            if(tipo.equals(motivo.getMinTipo())) {
                motivosVo.add(new MotivoIncumplimientoVO(motivo));
            }
            
        }
        return motivosVo;
    }
    
    public List<MotivoIncumplimientoVO>  listaMotivos()  throws ExcepcionDAO {
        List<MotivoIncumplimientoVO> motivosVo = new ArrayList<MotivoIncumplimientoVO>();
        for(SiiMotivoIncumplimiento motivo : motivoIncumplimientoDao.buscarTodo()) {
                motivosVo.add(new MotivoIncumplimientoVO(motivo));
        }
        return motivosVo;
    }
    
    
}
