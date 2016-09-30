package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ItemSolicitudVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminItemSolicitud {
    public ItemSolicitudVO insertarItemSolicitud(ItemSolicitudVO itemSolicitudVo) throws ExcepcionDAO;
    public ItemSolicitudVO actualizarItemSolicitud(ItemSolicitudVO itemSolicitudVo) throws ExcepcionDAO;
    public ItemSolicitudVO buscarItemSolicitudPorId(ItemSolicitudVO itemSolicitudVo) throws ExcepcionDAO;
    public void eliminarItemSolicitud(ItemSolicitudVO itemSolicitudVo) throws ExcepcionDAO;
    public List<ItemSolicitudVO> buscarTodosItemSolicitud() throws ExcepcionDAO;
    public List<ItemSolicitudVO> buscarItemsSolicitudPorIdSEM(SolicitudEstMercadoVO solicitudEstMercadoVo) throws ExcepcionDAO;
    public List<ItemSolicitudVO> buscarItemSolicitudPorSolicitud(Long idSolicitudEstudioMercado) throws ExcepcionDAO;

}
