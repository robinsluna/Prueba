package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CargaActuacionesAdmVO;

import co.gov.coljuegos.siicol.ejb.vo.ProcesoOriCargaVO;

import co.gov.coljuegos.siicol.ejb.vo.ProyeccionCargaActVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;



@Local
public interface AdminCargueLiquidacionActAdmin{
    
    public List<CargaActuacionesAdmVO> buscarTodasCargaActuacionesAdm() throws ExcepcionDAO;
    public CargaActuacionesAdmVO insertarCargaActuacionesAdm(CargaActuacionesAdmVO cargaActuacionesAdmVo,UsuarioVO usuarioLogueado  ) throws ExcepcionDAO,ExcepcionAplicacion ;
    public List<CargaActuacionesAdmVO> buscarNumReSolucionFechaActAdm (Long numResolucion ,Date fechaActAdm) throws ExcepcionDAO ;
    public List<ProcesoOriCargaVO> buscarTodoProcesoOriCarga() throws ExcepcionDAO ;
    public CargaActuacionesAdmVO buscarCargaActuacionesAdmXId(Long caaCodigo) throws ExcepcionDAO ;
    public List<ProcesoOriCargaVO> buscarTodosProcesoOriCarga ()throws ExcepcionDAO ;
    public CargaActuacionesAdmVO actualizarActuacionAdm (CargaActuacionesAdmVO cargaActuacionesAdmVo,Boolean migrar,UsuarioVO usuarioLogueado ) throws ExcepcionDAO,Throwable ;
    public List<ProyeccionCargaActVO> buscarProyeccionCargaActXConceptoCuotaActAdmin(Long  caaCodigo) throws ExcepcionDAO ;
    public Date  obtenerDiasHabiles(Calendar fechaInicial, Calendar fechaFinal) ;
    public List<CargaActuacionesAdmVO> buscarPersonasCargaActAdminPorNumeroId(String identificacion) throws ExcepcionDAO;
    
}
