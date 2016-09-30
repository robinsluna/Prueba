package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoEstudioMercDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstudioMercadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstudioMerc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioMercado;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEstudioMercVO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;

import co.gov.coljuegos.siicol.ejb.vo.EstudioMercadoVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminEstadoEstudioMercBean implements AdminEstadoEstudioMerc{
    @Resource
    SessionContext sessionContext;

    @EJB
    EstadoEstudioMercDAO estadoEstudioMercDao;
    @EJB
    EstudioMercadoDAO estudioMercadoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;


    public AdminEstadoEstudioMercBean() {
    }

    public EstadoEstudioMercVO insertarEstadoEstudioMerc(EstadoEstudioMercVO estadoEstudioMercVO) throws ExcepcionDAO {
        SiiEstadoEstudioMerc estadoEstudioMerc = conversionVoEntidad.convertir(estadoEstudioMercVO);
        estadoEstudioMerc = estadoEstudioMercDao.insertarEstadoEstudioMerc(estadoEstudioMerc);

        return new EstadoEstudioMercVO(estadoEstudioMerc);
    }

    public EstadoEstudioMercVO buscarEstadoEstudioMercPorId(Long idEstadoEstudioMercado) throws ExcepcionDAO {
        SiiEstadoEstudioMerc estadoEstudioMerc =
            estadoEstudioMercDao.buscarEstadoEstudioMercPorId(idEstadoEstudioMercado);
        return new EstadoEstudioMercVO(estadoEstudioMerc);
    }

    public EstadoEstudioMercVO actualizarEstadoEstudioMerc(EstadoEstudioMercVO estadoEstudioMercVO) throws ExcepcionDAO {
        SiiEstadoEstudioMerc estadoEstudioMerc = conversionVoEntidad.convertir(estadoEstudioMercVO);
        return new EstadoEstudioMercVO(estadoEstudioMercDao.actualizarEstadoEstudioMerc(estadoEstudioMerc));
    }

    public void eliminarEstadoEstudioMerc(EstadoEstudioMercVO estadoEstudioMercVO) throws ExcepcionDAO {
        estadoEstudioMercDao.eliminarEstadoEstudioMerc(estadoEstudioMercVO.getEemCodigo());
    }

    public List<EstadoEstudioMercVO> buscarTodoEstadoEstudioMerc() throws ExcepcionDAO {
        List<SiiEstadoEstudioMerc> listaEstadoEstudioMerc =
            estadoEstudioMercDao.buscarTodoEstadoEstudioMerc();
        List<EstadoEstudioMercVO> listaEstadoEstudioMercVO = new ArrayList();
        for (SiiEstadoEstudioMerc unEstadoEstudioMerc : listaEstadoEstudioMerc) {
            listaEstadoEstudioMercVO.add(new EstadoEstudioMercVO(unEstadoEstudioMerc));
        }
        return listaEstadoEstudioMercVO;
    }
    
}


