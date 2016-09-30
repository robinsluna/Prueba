package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.PerInvesProIleAutoPruVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interfaz local para el manejo de Personas Investigadas del Auto que Decreta Pruebas.
 * @author Camilo Miranda
 */
@Local
public interface AdminPerInvesProIleAutoPru 
{
    public PerInvesProIleAutoPruVO buscarPerInvesProIleAutoPruPorId (Long pauCodigo) throws ExcepcionDAO;
    public PerInvesProIleAutoPruVO insertarPerInvesProIleAutoPru (PerInvesProIleAutoPruVO perInvesProIleAutoPruVo) throws ExcepcionDAO;
    public PerInvesProIleAutoPruVO actualizarPerInvesProIleAutoPru (PerInvesProIleAutoPruVO perInvesProIleAutoPruVo) throws ExcepcionDAO;
    public void eliminarPerInvesProIleAutoPru (Long pauCodigo) throws ExcepcionDAO;
    public List<PerInvesProIleAutoPruVO> buscarTodaPerInvesProIleAutoPru () throws ExcepcionDAO;
    public List<PerInvesProIleAutoPruVO> buscarPerInvesProIleAutoPruPorIdAutoDecretaPrueProIle (Long atpCodigo) throws ExcepcionDAO;
}
