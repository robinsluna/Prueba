package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionProcesalIncVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz Local para el manejo de Direcciones Procesales en procesos de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Local
public interface AdminDireccionProcesalInc 
{
    public DireccionProcesalIncVO buscarDireccionProcesalIncPorCodigo (Long dpiCodigo) throws ExcepcionDAO;
    public DireccionProcesalIncVO insertarDireccionProcesalInc (DireccionProcesalIncVO direccionProcesalIncVo) throws ExcepcionDAO;
    public DireccionProcesalIncVO actualizarDireccionProcesalInc (DireccionProcesalIncVO direccionProcesalIncVo) throws ExcepcionDAO;
    public void eliminarDireccionProcesalInc (Long dpiCodigo) throws ExcepcionDAO;
    public List<DireccionProcesalIncVO> buscarTodaDireccionProcesalInc () throws ExcepcionDAO;
    public List<DireccionProcesalIncVO> buscarDireccionProcesalIncPorIdIncumplimiento (Long icnCodigo) throws ExcepcionDAO;
}
