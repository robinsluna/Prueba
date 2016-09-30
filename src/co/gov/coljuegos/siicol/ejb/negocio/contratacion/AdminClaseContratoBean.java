package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ClaseContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiClaseContrato;
import co.gov.coljuegos.siicol.ejb.vo.ClaseContratoVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminClaseContratoBean implements AdminClaseContrato{
    @Resource
    SessionContext sessionContext;
    @EJB
    ClaseContratoDAO claseContratoDao;
    
    public AdminClaseContratoBean() {
        
    }
    
    public List<ClaseContratoVO> listaClaseContrato() throws ExcepcionDAO {
        List<ClaseContratoVO> listaClaseContratoVo = new ArrayList<ClaseContratoVO>();
        for (SiiClaseContrato claseContrato : claseContratoDao.listaClaseContrato()) {
            listaClaseContratoVo.add(new ClaseContratoVO(claseContrato));
        }
        return listaClaseContratoVo;
    }
    
    public ClaseContratoVO buscarClaseContratoPorNombre(String clcNombre) throws ExcepcionDAO {
        return new ClaseContratoVO(claseContratoDao.buscarClaseContratoPorNombre(clcNombre));
    }

    public ClaseContratoVO buscarClaseContratoPorId(Long clcCodigo) throws ExcepcionDAO {
        return new ClaseContratoVO(claseContratoDao.buscarClaseContratoPorId(clcCodigo));
    }

}
