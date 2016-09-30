package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RecepcionAlegatoProSanVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Recepci&oacute;n de Alegatos del Proceso Sancionatorio de Fiscalizaci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminRecepcionAlegatoProSan 
{
    public RecepcionAlegatoProSanVO buscarRecepcionAlegatoProSanPorId (Long ralCodigo) throws ExcepcionDAO;
    public RecepcionAlegatoProSanVO insertarRecepcionAlegatoProSan (RecepcionAlegatoProSanVO recepcionAlegatoProSanVo) throws ExcepcionDAO;
    public RecepcionAlegatoProSanVO actualizarRecepcionAlegatoProSan (RecepcionAlegatoProSanVO recepcionAlegatoProSanVo) throws ExcepcionDAO;
    public void eliminarRecepcionAlegatoProSan (Long ralCodigo) throws ExcepcionDAO;
    public List<RecepcionAlegatoProSanVO> buscarRecepcionAlegatoProSanPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO;
    public List<RecepcionAlegatoProSanVO> buscarTodaRecepcionAlegatoProSan () throws ExcepcionDAO;
}
