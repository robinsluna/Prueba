package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminHistorialRol;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioRolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuarioRol;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioRolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminUsuarioRolBean implements AdminUsuarioRol {
    
    @EJB
    UsuarioRolDAO usuarioRolDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    UsuarioDAO usuarioDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    AdminLogGeneral adminLogGeneral;
    @EJB
    RolDAO rolDao;
    @EJB
    AdminHistorialRol adminHistorialRol;
    
    public AdminUsuarioRolBean() {
    }

    public List<UsuarioRolVO> buscarUsuarioRolPorUsuario(Long idUsuario) throws ExcepcionDAO {
        List<UsuarioRolVO> listaUsuarioRolVo = null;
        List<SiiUsuarioRol> listaUsuarioRol = usuarioRolDao.buscarUsuarioRolPorUsuario(idUsuario);
        if(listaUsuarioRol != null && listaUsuarioRol.size() > 0){
            listaUsuarioRolVo = new ArrayList<UsuarioRolVO>();
            for(SiiUsuarioRol unUsuarioRol : listaUsuarioRol){
                listaUsuarioRolVo.add(new UsuarioRolVO(unUsuarioRol));
            }
        }
        return listaUsuarioRolVo;
    }
    
    public void actualizarUsuarioRolTodosUsuarioRol(List<RolVO> listaRolVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO{
        UsuarioVO usuarioActualizarVo = listaRolVo.get(0).getUsuarioRolVoList().get(0).getUsuarioVo();
        //Consultamos el registro actual
        SiiUsuario siiUsuarioActual = usuarioDao.buscarUsuarioPorId(usuarioActualizarVo.getUsuCodigo());
        if(siiUsuarioActual.getSiiEstadoUsuario().getEusCodigo() != usuarioActualizarVo.getEstadoUsuarioVo().getEusCodigo()){
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.USUARIO.getId(), usuarioActualizarVo.getEstadoUsuarioVo().getEusCodigo(), usuarioLogueado, usuarioActualizarVo.getUsuCodigo());
        }
        SiiUsuario siiUsuario = conversionVoEntidad.convertir(usuarioActualizarVo);
        usuarioDao.actualizarUsuario(siiUsuario);
        SiiUsuario siiUsuarioConec = conversionVoEntidad.convertir(usuarioLogueado);
        
        String rolesAgregados = "";
        String rolesBorrados = "";
        String separadorA = "";
        String separadorB = "";
        for(RolVO unRolVo : listaRolVo){
            SiiUsuarioRol siiUsuarioRol = new SiiUsuarioRol();
            siiUsuarioRol.setSiiUsuario(siiUsuario);
            SiiRol siiRol = rolDao.buscarRolPorId(unRolVo.getRolCodigo());
            siiUsuarioRol.setSiiRol1(siiRol);
            //verificar si el registro existe
            
            SiiUsuarioRol siiUsuarioRolBusqueda = usuarioRolDao.buscarUsuarioRolPorPadres(siiUsuarioRol);
            if(siiUsuarioRolBusqueda != null){
                if(!unRolVo.isSeleccionado()){
                    //Borramos el registro si existe y no está seleccionado
                    usuarioRolDao.borrarUsuarioRol(siiUsuarioRolBusqueda);
                    rolesBorrados += separadorB + unRolVo.getRolCodigo();
                    separadorB = ",";
                    //Almacenamos el historial de desasignación
                    adminHistorialRol.registrarDesasignacionRol(siiRol, siiUsuario, siiUsuarioConec);
                }
            }
            else{
                if(unRolVo.isSeleccionado()){
                    //Adicionamos el registro
                    usuarioRolDao.insertarUsuarioRol(siiUsuarioRol);
                    rolesAgregados += separadorA + unRolVo.getRolCodigo();
                    separadorA = ",";
                    //Almacenamos el historial de asignación
                    adminHistorialRol.registrarAsignacionRol(siiRol, siiUsuario, siiUsuarioConec);
                }
            }
        }
        //Agregamos log general
        String mensaje = "Usuario Modificado : " + usuarioActualizarVo.toString() + ". Roles Agregados : " + rolesAgregados + ". Roles eliminados : " + rolesBorrados;
        adminLogGeneral.log("UsuarioRol - Actualizar", mensaje, usuarioLogueado);
        
    }
    
    public UsuarioVO insertarUsuarioRolTodosUsuarioRol(List<RolVO> listaRolVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO{
        UsuarioVO usuarioInsertarVo = listaRolVo.get(0).getUsuarioRolVoList().get(0).getUsuarioVo();
        SiiUsuario siiUsuario = conversionVoEntidad.convertir(usuarioInsertarVo);
        siiUsuario.setUsuNombreUsuario(siiUsuario.getUsuNombreUsuario().toUpperCase());
        siiUsuario = usuarioDao.insertarUsuario(siiUsuario);
        SiiUsuario siiUsuarioConec = conversionVoEntidad.convertir(usuarioLogueado);
        //Se registra el log de cambio de estado:
        adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.USUARIO.getId(), siiUsuario.getSiiEstadoUsuario().getEusCodigo(), usuarioLogueado, siiUsuario.getUsuCodigo());
        String rolesAgregados = "";
        String separadorA = "";
        for(RolVO unRolVo : listaRolVo){ //Solo recibe elementos seleccionados
            SiiUsuarioRol siiUsuarioRol = new SiiUsuarioRol();
            siiUsuarioRol.setSiiUsuario(siiUsuario);
            SiiRol siiRol = rolDao.buscarRolPorId(unRolVo.getRolCodigo());
            siiUsuarioRol.setSiiRol1(siiRol);
            usuarioRolDao.insertarUsuarioRol(siiUsuarioRol);
            rolesAgregados += separadorA + unRolVo.getRolCodigo();
            separadorA = ",";
            //Guardamos el historial de asignación
            adminHistorialRol.registrarAsignacionRol(siiRol, siiUsuario, siiUsuarioConec);
        }
        //Agregamos log general
        String mensaje = "Usuario Agregado : " + usuarioInsertarVo.toString() + ". Roles Agregados : " + rolesAgregados;
        adminLogGeneral.log("UsuarioRol - Agregar", mensaje, usuarioLogueado);
        return new UsuarioVO(siiUsuario);
    }
}
