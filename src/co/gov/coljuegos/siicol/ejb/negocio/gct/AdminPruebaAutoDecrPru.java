package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.PruebaAutoDecrPruVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Pruebas del Auto que Decreta Pruebas.
 * @author Camilo Miranda
 */
@Local
public interface AdminPruebaAutoDecrPru 
{
    public PruebaAutoDecrPruVO buscarPruebaAutoDecrPruPorId (Long papCodigo) throws ExcepcionDAO;
    public PruebaAutoDecrPruVO insertarPruebaAutoDecrPru (PruebaAutoDecrPruVO pruebaAutoDecrPruVo) throws ExcepcionDAO;
    public PruebaAutoDecrPruVO actualizarPruebaAutoDecrPru (PruebaAutoDecrPruVO pruebaAutoDecrPruVo) throws ExcepcionDAO;
    public void eliminarPruebaAutoDecrPru (Long papCodigo) throws ExcepcionDAO;
    public List<PruebaAutoDecrPruVO> buscarTodaPruebaAutoDecrPru () throws ExcepcionDAO;
    public List<PruebaAutoDecrPruVO> buscarPruebaAutoDecrPruPorIdAutoDecretaPrueProIle (Long atpCodigo) throws ExcepcionDAO;
}
