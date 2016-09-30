package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConsultaWebContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CotizacionEstudioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemCotizacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemCotizacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CotizacionEstudioVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemCotizacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminCotizacionEstudioBean implements AdminCotizacionEstudio {
    @EJB
    CotizacionEstudioDAO cotizacionEstudioDao;
    @EJB
    ConsultaWebContratDAO consultaWebContratDao;
    @EJB
    ItemCotizacionDAO itemCotizacionDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminCotizacionEstudioBean() {
    }

    public CotizacionEstudioVO insertarCotizacionEstudio(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO {
        CotizacionEstudioVO miCotizacionEstudioVO = cotizacionEstudioVO;
        SiiCotizacionEstudio localCotizacionEstudio = cotizacionEstudioDao.insertarCotizacionEstudio(conversionVoEntidad.convertir(cotizacionEstudioVO));
        miCotizacionEstudioVO = new CotizacionEstudioVO(localCotizacionEstudio);
        miCotizacionEstudioVO.setEstudioMercadoVO(cotizacionEstudioVO.getEstudioMercadoVO());
        return miCotizacionEstudioVO;
    }

    public CotizacionEstudioVO buscarCotizacionEstudioPorId(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO {
        SiiCotizacionEstudio localCotizacionEstudio =
            cotizacionEstudioDao.buscarCotizacionEstudioPorId(cotizacionEstudioVO.getCesCodigo());
        return new CotizacionEstudioVO(localCotizacionEstudio);
    }

    public CotizacionEstudioVO actualizarCotizacionEstudio(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO {
        CotizacionEstudioVO miCotizacionEstudioVO = cotizacionEstudioVO;
        SiiCotizacionEstudio cotizacionEstudio = cotizacionEstudioDao.actualizarCotizacionEstudio(conversionVoEntidad.convertir(cotizacionEstudioVO));
        miCotizacionEstudioVO = new CotizacionEstudioVO(cotizacionEstudio);
        miCotizacionEstudioVO.setEstudioMercadoVO(cotizacionEstudioVO.getEstudioMercadoVO());
        
        return new CotizacionEstudioVO(cotizacionEstudio);
    }

    public List<CotizacionEstudioVO> buscarCotizacionEstudioPorEM(Long idEstudioMercado) throws ExcepcionDAO {
        List<SiiCotizacionEstudio> listaCotizacionEstudio =
            cotizacionEstudioDao.buscarCotizacionEstudioPorEM(idEstudioMercado);
        List<CotizacionEstudioVO> listaCotizacionEstudioVO = new ArrayList();
        for (SiiCotizacionEstudio unaCotizacionEstudio : listaCotizacionEstudio) {
            listaCotizacionEstudioVO.add(new CotizacionEstudioVO(unaCotizacionEstudio));
        }
        return listaCotizacionEstudioVO;

    }

    public void eliminarCotizacionEstudio(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO {
        cotizacionEstudioDao.eliminarCotizacionEstudio(cotizacionEstudioVO.getCesCodigo());
    }

    public List<CotizacionEstudioVO> buscarTodoCotizacionEstudio() throws ExcepcionDAO {
        List<SiiCotizacionEstudio> listaCotizacionEstudio = cotizacionEstudioDao.buscarTodoCotizacionEstudio();
        List<CotizacionEstudioVO> listaCotizacionEstudioVO = new ArrayList();
        for (SiiCotizacionEstudio unaCotizacionEstudio : listaCotizacionEstudio) {
            listaCotizacionEstudioVO.add(new CotizacionEstudioVO(unaCotizacionEstudio));
        }
        return listaCotizacionEstudioVO;
    }

}
