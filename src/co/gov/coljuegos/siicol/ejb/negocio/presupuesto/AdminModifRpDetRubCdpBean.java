package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifRpDetRubCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifRpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.vo.ModifRpDetRubCdpVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminModifRpDetRubCdpBean implements AdminModifRpDetRubCdp {
    @EJB
    ModifRpDetRubCdpDAO modifRpDetRubCdpDao;

    public AdminModifRpDetRubCdpBean() {
    }

    public List<ModifRpDetRubCdpVO> listaModifRpDetRubCdp(Long mrpCodigo) throws ExcepcionDAO {
        List<ModifRpDetRubCdpVO> listaModifRpDetRubCdpVo = new ArrayList<ModifRpDetRubCdpVO>();
        List<SiiModifRpDetRubCdp> listaModifRpDetRubCdp = new ArrayList<SiiModifRpDetRubCdp>();

        listaModifRpDetRubCdp = modifRpDetRubCdpDao.listaModifRpDetRubCdp(mrpCodigo);

        for (SiiModifRpDetRubCdp unDetModifRp : listaModifRpDetRubCdp) {
            listaModifRpDetRubCdpVo.add(new ModifRpDetRubCdpVO(unDetModifRp));
        }

        return listaModifRpDetRubCdpVo;
    }

    public List<ModifRpDetRubCdpVO> listaModifRpDetRubCdpPorRpDetRubroCdp(Long rdrCodigo) throws ExcepcionDAO {
        List<ModifRpDetRubCdpVO> listaModifRpDetRubCdpVo = new ArrayList<ModifRpDetRubCdpVO>();
        List<SiiModifRpDetRubCdp> listaModifRpDetRubCdp = new ArrayList<SiiModifRpDetRubCdp>();

        listaModifRpDetRubCdp = modifRpDetRubCdpDao.listaModifRpDetRubCdpPorRpDetRubroCdp(rdrCodigo);

        for (SiiModifRpDetRubCdp unDetModifRp : listaModifRpDetRubCdp) {
            listaModifRpDetRubCdpVo.add(new ModifRpDetRubCdpVO(unDetModifRp));
        }

        return listaModifRpDetRubCdpVo;

    }

    public BigDecimal valorDecRpDetRubCdpAprobado(Long dcrCodigo, Long rpCodigo) throws ExcepcionDAO {
        return modifRpDetRubCdpDao.valorDecRpDetRubCdpAprobado(dcrCodigo, rpCodigo);
    }
    
    public BigDecimal valorIncRpDetRubCdpAprobado(Long dcrCodigo, Long rpCodigo) throws ExcepcionDAO {
        return modifRpDetRubCdpDao.valorIncRpDetRubCdpAprobado(dcrCodigo, rpCodigo);
    }

    public BigDecimal valorDecRpPorDetRubRpAprobados(Long rdrCodigo)  throws ExcepcionDAO {
        return modifRpDetRubCdpDao.valorDecRpPorDetRubRpAprobados(rdrCodigo);
    }

    public BigDecimal valorIncRpPorDetRubRpAprobados(Long rdrCodigo)  throws ExcepcionDAO {
        return modifRpDetRubCdpDao.valorIncRpPorDetRubRpAprobados(rdrCodigo);
    }

    /*     public BigDecimal valorNotasCreditoSinReconocimiento(Long dcrCodigo) throws ExcepcionDAO {
        return modifRpDetRubCdpDao.valorNotasCreditoSinReconocimiento(dcrCodigo);
    }

    public BigDecimal valorReintegrosNotasCreditoConReconocimiento(Long dcrCodigo) throws ExcepcionDAO {
        return modifRpDetRubCdpDao.valorReintegrosNotasCreditoConReconocimiento(dcrCodigo);
    } */
}
