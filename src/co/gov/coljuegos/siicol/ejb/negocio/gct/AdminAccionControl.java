package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminAccionControl {
    public List<AccionControlVO> accionesDeControl() throws ExcepcionDAO;
    
    /**
     * Buscar las acciones de control que tengan acta de hechos
     * @return accionesVo - Lista de AccionControlVO
     * @throws ExcepcionDAO
     */
    
    public List<AccionControlVO> buscarAccionControlConActaHechosDesc() throws ExcepcionDAO;
    
    /**
     * Buscar acciones de control sin proceso sancionatorio de ilegalidad
     * @return accionesVo - Lista de acciones de control
     * @throws ExcepcionDAO
     */

    public List<AccionControlVO> buscarAccionesControlAprobadas() throws ExcepcionDAO;
    
    public List<AccionControlVO> buscarAccionControlSinProcesoSancIleg() throws ExcepcionDAO;
        
    public AccionControlVO insertarAccionControl(AccionControlVO accionControlVo) throws ExcepcionDAO;
    
    /**
     * Buscar un acción control según Id de Auto comisorio.
     * @param acaCodigo
     * @return resultado - AccionControlVO
     * @throws ExcepcionDAO
     */

    public AccionControlVO buscarAccionControlXIdAutoComisorio(Long acaCodigo) throws ExcepcionDAO;
    
    public AccionControlVO actualizarAccionControl(AccionControlVO accionControlVo, UsuarioVO usuarioVo) throws ExcepcionDAO;
    /**
     * Buscar Accion Control según Id de resolución de decomiso y destrucción
     * @param rddCodigo
     * @return  resultado - lista de acciones de control
     * @throws ExcepcionDAO
     */
    
    public List<AccionControlVO> buscarAccionControlXIdResolucionDecomDest(Long rddCodigo) throws ExcepcionDAO;
    public AccionControlVO buscarAccionControlXId(Long codigo) throws ExcepcionDAO;
}
