package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantiaExigidaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaExigida;
import co.gov.coljuegos.siicol.ejb.vo.GarantiaExigidaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminGarantiaExigidaBean implements AdminGarantiaExigida{
    @EJB 
    GarantiaExigidaDAO garantiaExigidaDao;
    
    public List<GarantiaExigidaVO> buscarTodaGarantiaExigida() throws ExcepcionDAO {
        List<SiiGarantiaExigida> garantias = garantiaExigidaDao.buscarTodaGarantiaExigida();
        List<GarantiaExigidaVO> garantiasVo = new ArrayList<GarantiaExigidaVO>();
        for (SiiGarantiaExigida garantia : garantias) {
            garantiasVo.add(new GarantiaExigidaVO(garantia));
        }
        return garantiasVo;
    }
}
