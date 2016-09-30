package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CdpVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCdpVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminEstadoCdpBean implements AdminEstadoCdp {
    @EJB 
    EstadoCdpDAO estadoCdpDao;
    @EJB 
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    CdpDAO cdpDao;

    public AdminEstadoCdpBean() {
    }

    public EstadoCdpVO buscarEstadoCdpPorId(long idEstadoCdp) throws ExcepcionDAO {
        SiiEstadoCdp estadoCdp = estadoCdpDao.buscarEstadoCdpPorId(idEstadoCdp);
        return new EstadoCdpVO(estadoCdp);
    }

    public EstadoCdpVO insertarEstadoCdp(EstadoCdpVO estadoCdpVO) throws ExcepcionDAO {
        SiiEstadoCdp estadoCdp = estadoCdpDao.insertarEstadoCdp(conversionVoEntidad.convertir(estadoCdpVO));
        List<CdpVO> listaCdpVO = estadoCdpVO.getCdpListVO();
        for (CdpVO unCdpVO : listaCdpVO) {
            SiiCdp nuevoCdp = conversionVoEntidad.convertir(unCdpVO);
            cdpDao.insertarCdp(nuevoCdp);
        }
        return new EstadoCdpVO(estadoCdp);
    }

    public void eliminarEstadoCdp(long idEstadoCdp) throws ExcepcionDAO {
        estadoCdpDao.eliminarEstadoCdp(idEstadoCdp);
    }

    public List<EstadoCdpVO> buscarTodoCdp() throws ExcepcionDAO {
        List<SiiEstadoCdp> listaEstadoCdp = estadoCdpDao.buscarTodoCdp();
        List<EstadoCdpVO> listaEstadoCdpVO = new ArrayList();
        for (SiiEstadoCdp unEstadoCdp : listaEstadoCdp) {
            listaEstadoCdpVO.add(new EstadoCdpVO(unEstadoCdp));
        }
        return listaEstadoCdpVO;
    }
}
