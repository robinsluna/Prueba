package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CotizacionEstudioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminCotizacionEstudio {
    public CotizacionEstudioVO insertarCotizacionEstudio(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO;

    public CotizacionEstudioVO buscarCotizacionEstudioPorId(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO;

    public CotizacionEstudioVO actualizarCotizacionEstudio(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO;
    
    public List<CotizacionEstudioVO> buscarCotizacionEstudioPorEM(Long idEstudioMercado) throws ExcepcionDAO;

    public void eliminarCotizacionEstudio(CotizacionEstudioVO cotizacionEstudioVO) throws ExcepcionDAO;

    public List<CotizacionEstudioVO> buscarTodoCotizacionEstudio() throws ExcepcionDAO;
}
