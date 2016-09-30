package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaInexacProcSancVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioProcSanVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoSancionatorioVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el maejo de Procesos Sancionatorios.
 * @author Camilo Miranda
 */
@Local
public interface AdminProcesoSancionatorio 
{
    public ProcesoSancionatorioVO buscarProcesoSancionatorioPorCodigo (Long psaCodigo) throws ExcepcionDAO;
    public List<ProcesoSancionatorioVO> buscarTodoProcesoSancionatorio () throws ExcepcionDAO;
    public ProcesoSancionatorioVO insertarProcesoSancionatorio (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public ProcesoSancionatorioVO insertarProcesoSancionatorio(ProcesoSancionatorioVO procesoSancionatorioVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    public ProcesoSancionatorioVO actualizarProcesoSancionatorio (ProcesoSancionatorioVO procesoSancionatorioVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public ProcesoSancionatorioVO actualizarProcesoSancionatorio (ProcesoSancionatorioVO procesoSancionatorioVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    public void eliminarProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO;
    public List<ProcesoSancionatorioVO> buscarProcesoSancionatorioPorPerCodigoSustanciador (Long perCodigo) throws ExcepcionDAO;
    public List<ProcesoSancionatorioVO> buscarProcesosInforme(Long psaCodigo) throws ExcepcionDAO;
    public boolean sustanciadorConProcesosVigentes(Long fsuCodigo) throws ExcepcionDAO;
    public List<ProcesoSancionatorioVO> buscarProcesoSancionatorioConTramiteResolucionNotificado () throws ExcepcionDAO;
    public void establecerResolucionesProcSancEnFirme();
    
    
    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    public void setListaInventarioProcSanEliminar (List<InventarioProcSanVO> listaInventarioProcSanEliminar);
    public void setListaCuotaInexacProcSancEliminar (List<CuotaInexacProcSancVO> listaCuotaInexacProcSancEliminar);
}
