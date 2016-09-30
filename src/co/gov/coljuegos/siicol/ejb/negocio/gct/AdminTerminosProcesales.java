package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TerminosProcesalesVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de T&eacute;rminos Procesales.
 * @author Camilo Miranda
 */
@Local
public interface AdminTerminosProcesales 
{
    public TerminosProcesalesVO buscarTerminoProcesalPorId (Long tprCodigo) throws ExcepcionDAO;
    public TerminosProcesalesVO buscarTerminoProcesalFiscalizacionPorEstadoProceso (Long epsCodigo) throws ExcepcionDAO;
    public TerminosProcesalesVO buscarTerminoProcesalIlegalidadPorEstadoProceso (Long epiCodigo) throws ExcepcionDAO;
    public List<TerminosProcesalesVO> buscarTodoTerminosProcesales () throws ExcepcionDAO;
}
