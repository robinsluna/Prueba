package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifCdpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifCdpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.vo.ModifCdpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudIncrementoCdpVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminModifCdpDetRubCdpBean implements AdminModifCdpDetRubCdp {
    
    @EJB
    ModifCdpDetRubCdpDAO modifCdpDetRubDao;

    public AdminModifCdpDetRubCdpBean() {
    }

    public List<ModifCdpDetRubCdpVO> listaModifCdpDetRubCdpPorModificacion(Long id) throws ExcepcionDAO {
        List<ModifCdpDetRubCdpVO> listaModifCdpDetRubCdpVo = new ArrayList();
        List<SiiModifCdpDetRubCdp> listaSiiModifCdpDetRubCdp = modifCdpDetRubDao.listaModifCdpDetRubCdpPorModificacion(id);
        for (SiiModifCdpDetRubCdp unModifCdpDetRubCdp : listaSiiModifCdpDetRubCdp) {
            listaModifCdpDetRubCdpVo.add(new ModifCdpDetRubCdpVO(unModifCdpDetRubCdp));
        }
        return listaModifCdpDetRubCdpVo;
    }
    
    public List<ModifCdpDetRubCdpVO> listaModifCdpRubPorDetRubCdp(Long id) throws ExcepcionDAO {
        List<ModifCdpDetRubCdpVO> listaModifCdpDetRubCdpVo = new ArrayList();
        List<SiiModifCdpDetRubCdp> listaSiiModifCdpDetRubCdp = modifCdpDetRubDao.listaModifCdpRubPorDetRubCdp(id);
        for (SiiModifCdpDetRubCdp unModifCdpDetRubCdp : listaSiiModifCdpDetRubCdp) {
            listaModifCdpDetRubCdpVo.add(new ModifCdpDetRubCdpVO(unModifCdpDetRubCdp));
        }
        return listaModifCdpDetRubCdpVo;
        
    }
    
    public BigDecimal valorDecCdpRubPorDetRubCdpAprobados(Long id) throws ExcepcionDAO {
        return modifCdpDetRubDao.valorDecCdpRubPorDetRubCdpAprobados(id);
    }
        
    public BigDecimal valorIncCdpRubPorDetRubCdpAprobados(Long id) throws ExcepcionDAO {
        return modifCdpDetRubDao.valorIncCdpRubPorDetRubCdpAprobados(id);
    }

    public List<SolicitudIncrementoCdpVO> buscarValorIncRubroCdpPorItemPlanContratIdCdp (Long idIpc, Long idCdp) throws ExcepcionDAO {
    List<SolicitudIncrementoCdpVO> listaIncrementoCdp = modifCdpDetRubDao.buscarValorIncRubroCdpPorItemPlanContratIdCdp(idIpc, idCdp);
     return  listaIncrementoCdp;
    }
    
    public ModifCdpDetRubCdpVO buscarModifCdpDetRubCdpBaseGMF(Long druCodigo) throws ExcepcionDAO {
        return new ModifCdpDetRubCdpVO(modifCdpDetRubDao.buscarModifCdpDetRubCdpBaseGMF(druCodigo));
    }
    
    public List<ModifCdpDetRubCdpVO> rubrosFinanciadosConRecursosPropios(Long mcdCodigo) throws ExcepcionDAO {
        List<ModifCdpDetRubCdpVO> listaModifCdpDetRubCdpVo = new ArrayList();
        List<SiiModifCdpDetRubCdp> listaSiiModifCdpDetRubCdp = modifCdpDetRubDao.rubrosFinanciadosConRecursosPropios(mcdCodigo);
        for (SiiModifCdpDetRubCdp unModifCdpDetRubCdp : listaSiiModifCdpDetRubCdp) {
            listaModifCdpDetRubCdpVo.add(new ModifCdpDetRubCdpVO(unModifCdpDetRubCdp));
        }
        return listaModifCdpDetRubCdpVo;
    }
}
