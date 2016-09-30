package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.InhabilidadPersonaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Inhabilidades Persona.
 * @author Camilo Miranda
 */
@Local
public interface AdminInhabilidadPersona 
{
    public InhabilidadPersonaVO buscarInhabilidadPersonaPorId (Long ipeCodigo) throws ExcepcionDAO;
    public InhabilidadPersonaVO buscarInhabilidadPersonaPorIdPersonaYTipoProceso (Long perCodigo, Long idProceso, Long tipoProceso) throws ExcepcionDAO;
    public InhabilidadPersonaVO buscarInhabilidadPersonaPorIdPersonaYTipoProceso (Long perCodigo, Long idProceso, Long tipoProceso, boolean soloActivos) throws ExcepcionDAO;
    public InhabilidadPersonaVO insertarInhabilidadPersona (InhabilidadPersonaVO inhabilidadPersonaVo) throws ExcepcionDAO;
    public InhabilidadPersonaVO actualizarInhabilidadPersona (InhabilidadPersonaVO inhabilidadPersonaVo) throws ExcepcionDAO;
    public void eliminarInhabilidadPersona (Long ipeCodigo) throws ExcepcionDAO;
    public List<InhabilidadPersonaVO> buscarInhabilidadPersonaPorIdPersona (Long perCodigo) throws ExcepcionDAO;
    public List<InhabilidadPersonaVO> buscarTodaInhabilidadPersona () throws ExcepcionDAO;
    public List<InhabilidadPersonaVO> buscarInhabilidadPersonaPorIdIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO;
    public List<InhabilidadPersonaVO> buscarInhabilidadPersonaPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO;
    public List<InhabilidadPersonaVO> buscarInhabilidadPersonaPorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO;
}
