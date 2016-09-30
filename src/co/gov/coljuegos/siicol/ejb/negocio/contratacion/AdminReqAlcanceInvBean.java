package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReqAlcanceInvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqAlcanceInv;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ReqAlcanceInvVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminReqAlcanceInvBean implements AdminReqAlcanceInv {
    @Resource
    SessionContext sessionContext;
    
    @EJB 
    ReqAlcanceInvDAO reqAlcanceInvDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminReqAlcanceInvBean() {
    }
    
    public ReqAlcanceInvVO buscarReqAlcanceInvPorId(Long id) throws ExcepcionDAO {
        return new ReqAlcanceInvVO(reqAlcanceInvDao.buscarReqAlcanceInvPorId(id));
    }
    
    public List<ReqAlcanceInvVO> buscarReqAlcanceInvPorAlcanceInv(Long id) throws ExcepcionDAO {
        List<SiiReqAlcanceInv> listaReqAlcanceInv = reqAlcanceInvDao.buscarReqAlcanceInvPorAlcanceInv(id);
        List<ReqAlcanceInvVO> listaReqAlcanceInvVo = new ArrayList();
        for (SiiReqAlcanceInv unReqAlcanceInv : listaReqAlcanceInv) {
            listaReqAlcanceInvVo.add(new ReqAlcanceInvVO(unReqAlcanceInv));
        }
        return listaReqAlcanceInvVo;
        
    }
    
    public void eliminarReqAlcanceInv(ReqAlcanceInvVO reqAlcanceInvVo) throws ExcepcionDAO {
        reqAlcanceInvDao.eliminarReqAlcanceInv(conversionVoEntidad.convertir(reqAlcanceInvVo));
    }
    
    
}
