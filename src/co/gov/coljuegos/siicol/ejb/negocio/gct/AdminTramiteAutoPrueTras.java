package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.TramiteAutoPrueTrasVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Tr&aacute;mites del Auto que Decreta Pruebas.
 * @author Camilo Miranda
 */
@Local
public interface AdminTramiteAutoPrueTras 
{
    public TramiteAutoPrueTrasVO buscarTramiteAutoPrueTrasPorId (Long traCodigo) throws ExcepcionDAO;
    public TramiteAutoPrueTrasVO insertarTramiteAutoPrueTras (TramiteAutoPrueTrasVO tramiteAutoPrueTrasVo) throws ExcepcionDAO;
    public TramiteAutoPrueTrasVO actualizarTramiteAutoPrueTras (TramiteAutoPrueTrasVO tramiteAutoPrueTrasVo) throws ExcepcionDAO;
    public void eliminarTramiteAutoPrueTras (Long traCodigo) throws ExcepcionDAO;
    public List<TramiteAutoPrueTrasVO> buscarTodoDetalleAutoPruPerInv () throws ExcepcionDAO;
    public List<TramiteAutoPrueTrasVO> buscarDetalleAutoPruPerInvPorIdAutoDecretaPrueProIle (Long atpCodigo) throws ExcepcionDAO;
}
