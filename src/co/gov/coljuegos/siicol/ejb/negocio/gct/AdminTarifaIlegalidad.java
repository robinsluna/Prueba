package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.TarifaIlegalidadVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Tarifas de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminTarifaIlegalidad 
{
    public TarifaIlegalidadVO buscarTarifaIlegalidadPorId (Long tleCodigo) throws ExcepcionDAO;
    public TarifaIlegalidadVO insertarTarifaIlegalidad (TarifaIlegalidadVO tarifaIlegalidadVo) throws ExcepcionDAO;
    public TarifaIlegalidadVO actualizarTarifaIlegalidad (TarifaIlegalidadVO tarifaIlegalidadVo) throws ExcepcionDAO;
    public void eliminarTarifaIlegalidad (Long tleCodigo) throws ExcepcionDAO;
    public List<TarifaIlegalidadVO> buscarTarifaIlegalidadPorClaseJuegoTipoInstrumento (Long cjuCodigo, Long tinCodigo) throws ExcepcionDAO;
    public List<TarifaIlegalidadVO> buscarTodaTarifaIlegalidad () throws ExcepcionDAO;
}
