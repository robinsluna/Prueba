package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvestProIle;
import co.gov.coljuegos.siicol.ejb.vo.ElementoProcesoIleVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaInvestProIleVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoSancIlegalidadVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionProcIlegVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminProcesoSancIlegalidad {
    public ProcesoSancIlegalidadVO buscarProcSancIlegalidadPorCodigo(Long prsCodigo) throws ExcepcionDAO;
    public List<ProcesoSancIlegalidadVO> buscarTodoProcesoSancIlegalidad() throws ExcepcionDAO;
    
    /**
     * Buscar todos los procesos sancionatorios de ilegalidad con datos de acción control y denuncia
     * @return Lista de SiiProcesoSancIlegalidad.
     * @throws ExcepcionDAO
     */
    
    public List<ProcesoSancIlegalidadVO> buscarTodoProcesoSancIlegalidadConDenuncia() throws ExcepcionDAO;
    public Integer obtenerConsecutivoProcesoSancIlegalidad () throws ExcepcionDAO;
    public ProcesoSancIlegalidadVO insertarProcesoSancIlegalidad(ProcesoSancIlegalidadVO proceso) throws ExcepcionDAO;
    public ProcesoSancIlegalidadVO insertarProcesoSancIlegalidad(ProcesoSancIlegalidadVO procesoSancIlegalidadVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion ;
    public ProcesoSancIlegalidadVO actualizarProcesoSancIlegalidad(ProcesoSancIlegalidadVO proceso, boolean cascadeUpdate, boolean doComunicacionesResol) throws ExcepcionDAO, ExcepcionAplicacion;
    
    public boolean actualizarResolucionSoportaRecurso(ProcesoSancIlegalidadVO procesoSancionatorio, ResolucionProcIlegVO resolucionOriginaRecurso,
                                                       List<PersonaInvestProIleVO> listaPersonaInvestProIle) throws ExcepcionDAO, ExcepcionAplicacion; 
    
    public void establecerResolucionesProcSancIleEnFirme() throws Exception;
    public BigDecimal obtenerValorTotalSancionElementosProceso (Long prsCodigo) throws ExcepcionDAO;
    
    
    
    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    public void setListaElementoProcesoIleEliminar (List<ElementoProcesoIleVO> listaElementoProcesoIleEliminar);
    
    public List<PersonaInvestProIleVO> buscarPersonasInvestPorNumeroId(String identificacion) throws ExcepcionDAO;
}
