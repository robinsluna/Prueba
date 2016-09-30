package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemSolicitudDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemSolicitud;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ItemSolicitudVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;


import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminItemSolicitudBean implements AdminItemSolicitud{
    @Resource
    SessionContext sessionContext;
    @EJB
    ItemSolicitudDAO itemSolicitudDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminItemSolicitudBean() {
    }
    public ItemSolicitudVO insertarItemSolicitud(ItemSolicitudVO itemSolicitudVo) throws ExcepcionDAO{
            SiiItemSolicitud itemSolicitud= conversionVoEntidad.convertir(itemSolicitudVo);
            SiiItemSolicitud unItemSolicitud = itemSolicitudDao.insertarItemSolicitud(itemSolicitud);
            return new ItemSolicitudVO(unItemSolicitud);
        }
    
    public ItemSolicitudVO actualizarItemSolicitud(ItemSolicitudVO itemSolicitudVo) throws ExcepcionDAO{
        SiiItemSolicitud itemSolicitud = conversionVoEntidad.convertir(itemSolicitudVo);
        SiiItemSolicitud unItemSolicitud = itemSolicitudDao.actualizarItemSolicitud(itemSolicitud);
        return new ItemSolicitudVO(unItemSolicitud);
    }
    
    public ItemSolicitudVO buscarItemSolicitudPorId(ItemSolicitudVO itemSolicitudVo) throws ExcepcionDAO{
        SiiItemSolicitud itemSolicitud = conversionVoEntidad.convertir(itemSolicitudVo);
        SiiItemSolicitud unItemSolicitud = itemSolicitudDao.buscarItemSolicitudPorId(itemSolicitud.getIsoCodigo());
        return new ItemSolicitudVO(unItemSolicitud);
    }
    
    public void eliminarItemSolicitud(ItemSolicitudVO itemSolicitudVo) throws ExcepcionDAO{
        SiiItemSolicitud itemSolicitud = conversionVoEntidad.convertir(itemSolicitudVo);
        SiiItemSolicitud unItemSolicitud = itemSolicitudDao.buscarItemSolicitudPorId(itemSolicitud.getIsoCodigo());
        itemSolicitudDao.eliminarItemSolicitud(unItemSolicitud.getIsoCodigo());   
    }
    
    public List<ItemSolicitudVO> buscarTodosItemSolicitud() throws ExcepcionDAO{
        List<SiiItemSolicitud> listaSiiItemSolicitud = itemSolicitudDao.buscarTodosItemSolicitud();
        List<ItemSolicitudVO> listaItemSolicitudVo = new ArrayList();
        for(SiiItemSolicitud unItemSolicitud : listaSiiItemSolicitud){
            ItemSolicitudVO nuevoItemSolicitudVo = new ItemSolicitudVO(unItemSolicitud);
            listaItemSolicitudVo.add(nuevoItemSolicitudVo);
        }
        return listaItemSolicitudVo;
    }

    
    public List<ItemSolicitudVO> buscarItemsSolicitudPorIdSEM(SolicitudEstMercadoVO solicitudEstMercadoVo) throws ExcepcionDAO{        
            
            List<SiiItemSolicitud> listaSiiItemSolicitud;
            listaSiiItemSolicitud = itemSolicitudDao.buscarItemsSolicitudPorIdSEM(solicitudEstMercadoVo.getSemCodigo());
            List<ItemSolicitudVO> listaItemSolicitudVo = new ArrayList();
            for(SiiItemSolicitud unItemSolicitud : listaSiiItemSolicitud){
                listaItemSolicitudVo.add(new ItemSolicitudVO(unItemSolicitud));
            }
            return listaItemSolicitudVo;
        }
    

    
    public List<ItemSolicitudVO> buscarItemSolicitudPorSolicitud(Long idSolicitudEstudioMercado) throws ExcepcionDAO{
        List<SiiItemSolicitud> listaSiiItemSolicitud = itemSolicitudDao.buscarItemSolicitudPorSolicitud(idSolicitudEstudioMercado);
        List<ItemSolicitudVO> listaItemSolicitudVo = new ArrayList();
        for(SiiItemSolicitud unItemSolicitud : listaSiiItemSolicitud){
            ItemSolicitudVO nuevoItemSolicitudVo = new ItemSolicitudVO(unItemSolicitud);
            listaItemSolicitudVo.add(nuevoItemSolicitudVo);
        }
        return listaItemSolicitudVo;
    }
    

}

