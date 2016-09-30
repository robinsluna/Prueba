package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ItemCotizacionVO;

import java.util.List;

import javax.ejb.Local;
@Local
public interface AdminItemCotizacion {
    public ItemCotizacionVO insertarItemCotizacion(ItemCotizacionVO itemCotizacionVO) throws ExcepcionDAO;

    public ItemCotizacionVO buscarItemCotizacionPorId(ItemCotizacionVO itemCotizacionVO) throws ExcepcionDAO;

    public ItemCotizacionVO actualizarItemCotizacion(ItemCotizacionVO itemCotizacionVO) throws ExcepcionDAO;

    public void eliminarItemCotizacion(ItemCotizacionVO itemCotizacionVO) throws ExcepcionDAO;

    public List<ItemCotizacionVO> buscarTodoItemCotizacion() throws ExcepcionDAO;
    
    public List<ItemCotizacionVO> buscarItemCotizacionPorCotizacion(Long IdCotizacionEstudio) throws ExcepcionDAO;
}
