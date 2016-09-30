package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CotizacionEstudioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemCotizacionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemSolicitudDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemCotizacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ItemCotizacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminItemCotizacionBean implements AdminItemCotizacion{
    @Resource
    SessionContext sessionContext;

    @EJB
    ItemCotizacionDAO itemCotizacionDao;
    @EJB
    ItemSolicitudDAO itemSolicitudDao;
    @EJB
    CotizacionEstudioDAO cotizacionEstudioDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminItemCotizacionBean() {
    }

    public ItemCotizacionVO insertarItemCotizacion(ItemCotizacionVO itemCotizacionVO) throws ExcepcionDAO {
        SiiItemCotizacion itemCotizacion = conversionVoEntidad.convertir(itemCotizacionVO);
        itemCotizacion = itemCotizacionDao.insertarItemCotizacion(itemCotizacion);
        return new ItemCotizacionVO(itemCotizacion);
    }

    public ItemCotizacionVO buscarItemCotizacionPorId(ItemCotizacionVO itemCotizacionVO) throws ExcepcionDAO {
        SiiItemCotizacion localItemCotizacion = itemCotizacionDao.buscarItemCotizacionPorId(itemCotizacionVO.getIcoCodigo());
        return new ItemCotizacionVO(localItemCotizacion);
    }

    public ItemCotizacionVO actualizarItemCotizacion(ItemCotizacionVO itemCotizacionVO) throws ExcepcionDAO {
        SiiItemCotizacion itemCotizacion = conversionVoEntidad.convertir(itemCotizacionVO);
        itemCotizacion = itemCotizacionDao.actualizarItemCotizacion(itemCotizacion);
        return new ItemCotizacionVO(itemCotizacion);
    }

    public void eliminarItemCotizacion(ItemCotizacionVO itemCotizacionVO) throws ExcepcionDAO {
        itemCotizacionDao.eliminarItemCotizacion(itemCotizacionVO.getIcoCodigo());
    }

    public List<ItemCotizacionVO> buscarTodoItemCotizacion() throws ExcepcionDAO {
        List<SiiItemCotizacion> listaItemCotizacion =
            itemCotizacionDao.buscarTodoItemCotizacion();
        List<ItemCotizacionVO> listaItemCotizacionVO = new ArrayList();
        for (SiiItemCotizacion unItemCotizacion : listaItemCotizacion) {
            listaItemCotizacionVO.add(new ItemCotizacionVO(unItemCotizacion));
        }
        return listaItemCotizacionVO;
    }

    public List<ItemCotizacionVO> buscarItemCotizacionPorCotizacion(Long idCotizacionEstudio) throws ExcepcionDAO {
        List<SiiItemCotizacion> listaItemCotizacion =
            itemCotizacionDao.buscarItemCotizacionPorCotizacion(idCotizacionEstudio);
        List<ItemCotizacionVO> listaItemCotizacionVO = new ArrayList();
        for (SiiItemCotizacion unItemCotizacion : listaItemCotizacion) {
            listaItemCotizacionVO.add(new ItemCotizacionVO(unItemCotizacion));
        }
        return listaItemCotizacionVO;
    }

}


