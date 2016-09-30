package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminHistorialPermiso;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistorialPermisoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistorialRolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModuloDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PermisoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PermisoRolModuloDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistorialRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermiso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.PermisoRolModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminModuloBean implements AdminModulo {

    @EJB
    ModuloDAO moduloDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    PermisoRolModuloDAO permisoRolModuloDao;
    @EJB
    RolDAO rolDao;
    @EJB
    PermisoDAO permisoDao;
    @EJB
    HistorialRolDAO historialRolDao;
    @EJB
    HistorialPermisoDAO historialPermisoDao;
    @EJB
    AdminHistorialPermiso adminHistorialPermiso;
    
    public AdminModuloBean() {
    }
    
    public List<ModuloVO> buscarModulosPorIdUsuario(UsuarioVO usuarioVo) throws ExcepcionDAO{
        List<ModuloVO> listaModulos = moduloDao.buscarModulosPorIdUsuario(usuarioVo);
        List<ModuloVO> listaRetorno = new ArrayList<ModuloVO>();
        ModuloVO moduloVoAnterior = null;
        for (ModuloVO unModuloVo : listaModulos) {
            //ModuloVO moduloVo = null;
            if(moduloVoAnterior != null && moduloVoAnterior.getModNombre().equals(unModuloVo.getModNombre())){
                //moduloVo = moduloVoAnterior;
                PermisoRolModuloVO permisoRolModuloVo = new PermisoRolModuloVO();
                permisoRolModuloVo.setPermisoVo(unModuloVo.getPermisoRolModuloVoList().get(0).getPermisoVo());
                moduloVoAnterior.getPermisoRolModuloVoList().add(permisoRolModuloVo);
            }
            else{
                //moduloVo = unModuloVo;
                listaRetorno.add(unModuloVo);
                moduloVoAnterior = unModuloVo;
            }
            //moduloVoAnterior = moduloVo;
        }
        return listaRetorno;
    }
    
    
    /*
     * Por Diego Alvarado
     * Devuelve una lista de módulos sin repetir para generar el menú
     */
    public List<ModuloVO> buscarSoloModulosPorIdUsuarioConOrden(UsuarioVO usuarioVo) throws ExcepcionDAO{
        List<ModuloVO> listaModulos = moduloDao.buscarSoloModulosPorIdUsuarioConOrden(usuarioVo);
        List<ModuloVO> listaRetorno = new ArrayList<ModuloVO>();
        ModuloVO moduloVoAnterior = null;
        for (ModuloVO unModuloVo : listaModulos) {
            if(moduloVoAnterior != null && moduloVoAnterior.getModNombre().equals(unModuloVo.getModNombre())){
                PermisoRolModuloVO permisoRolModuloVo = new PermisoRolModuloVO();
                permisoRolModuloVo.setPermisoVo(unModuloVo.getPermisoRolModuloVoList().get(0).getPermisoVo());
                moduloVoAnterior.getPermisoRolModuloVoList().add(permisoRolModuloVo);
            }
            else{
                listaRetorno.add(unModuloVo);
                moduloVoAnterior = unModuloVo;
            }
        }
        return listaRetorno;
    }
    
    
    public ModuloVO buscarModuloPorNombre(ModuloVO moduloVo) throws ExcepcionDAO{
        return new ModuloVO(moduloDao.buscarModuloPorNombre(moduloVo.getModNombre()));
    }
    
    public List<ModuloVO> buscarTodosModulosConSinPermisoPorRol(Long idRol) throws ExcepcionDAO{
        return moduloDao.buscarTodosModulosConSinPermisoPorRol(idRol);
    }
    
    public void actualizarModulosPermisoTodos(List<ModuloVO> listaModulosVo) throws ExcepcionDAO{
        SiiHistorialRol siiHistorialRol = null;
        RolVO rolVo = ((listaModulosVo.get(0)).getPermisoRolModuloVoList().get(0)).getRolVo();
        SiiUsuario siiUsuarioConec = conversionVoEntidad.convertir(rolVo.getUsuarioConectadoVo());
        SiiRol siiRolActual = rolDao.buscarRolPorId(rolVo.getRolCodigo());
        String rolActualActivo = siiRolActual.getRolActivo();
        boolean rolEstadoDiferente = !rolActualActivo.equals(rolVo.getRolActivo());
        boolean rolCambioAActivado = rolEstadoDiferente && "S".equals(rolVo.getRolActivo());
        boolean rolCambioAInactivado = (rolEstadoDiferente) && (!rolCambioAActivado);
        SiiRol siiRol = conversionVoEntidad.convertir(rolVo);
        rolDao.actualizarRol(siiRol);
        
        /*
         * Chequeamos si se activó el rol
         * Cuando el rol se activa el historial de activación del rol se registra antes que el historial de asignación de permisos
         * 
        */
        if(rolCambioAActivado){
            registrarHistorialCambioEstadoRol(rolVo, siiUsuarioConec);
        }
        
        for(ModuloVO moduloVo : listaModulosVo){
            boolean existePermiso = false;
            for (PermisoRolModuloVO permisoRolModuloVo : moduloVo.getPermisoRolModuloVoList()){
                SiiPermisoRolModulo siiPermisoRolModulo = conversionVoEntidad.convertir(permisoRolModuloVo);
                SiiPermisoRolModulo siiPermisoRolModuloBuscar = permisoRolModuloDao.buscarPermisoRolModuloPorPadres(siiPermisoRolModulo);
                
                if(siiPermisoRolModuloBuscar != null){
                    if(!permisoRolModuloVo.getPermisoVo().isSeleccionado()){
                        //Si no está seleccionado se borra:
                        permisoRolModuloDao.borrarPermisoRolModulo(siiPermisoRolModuloBuscar.getPrmCodigo());
                        //Registramos el historial de roles y permisos
                        if(siiHistorialRol == null){
                            siiHistorialRol = new SiiHistorialRol();
                            siiHistorialRol.setHroFechaDesasigna(new Date());
                            siiHistorialRol.setSiiRol(siiRol);
                            siiHistorialRol.setSiiUsuarioConec(siiUsuarioConec);
                            siiHistorialRol.setHroFechaActInacPer(siiHistorialRol.getHroFechaDesasigna());
                            historialRolDao.insertar(siiHistorialRol);
                        }
                        adminHistorialPermiso.registarDesasignacionPermiso(siiHistorialRol, siiPermisoRolModulo, siiUsuarioConec);
                    }
                    else{
                        //Existe al menos un permiso
                        existePermiso = true;
                    }
                }
                else{
                    if(permisoRolModuloVo.getPermisoVo().isSeleccionado()){
                        //Si está seleccionado se inserta:
                        siiPermisoRolModulo = permisoRolModuloDao.insertarPermisoRolModulo(siiPermisoRolModulo);
                        existePermiso = true;
                        //Registramos el historial de roles y permisos
                        if(siiHistorialRol == null){
                            siiHistorialRol = new SiiHistorialRol();
                            siiHistorialRol.setHroFechaAsigna(new Date());
                            siiHistorialRol.setSiiRol(siiRol);
                            siiHistorialRol.setSiiUsuarioConec(siiUsuarioConec);
                            siiHistorialRol.setHroFechaActInacPer(siiHistorialRol.getHroFechaAsigna());
                            historialRolDao.insertar(siiHistorialRol);
                        }
                        adminHistorialPermiso.registarAsignacionPermiso(siiHistorialRol, siiPermisoRolModulo, siiUsuarioConec);
                    }
                }
            }
            if(existePermiso){
                SiiModulo siiModulo = moduloDao.buscarModuloPorId(moduloVo.getModCodigo());
                //Buscamos e insertamos los módulos padre
                insertarModuloPadre(siiModulo, siiRol);
            }
        }
        
        /*
         *Chequeamos si se inactivó el rol
         * Cuando el rol se inactiva el historial de activación del rol se registra después que el historial de asignación de permisos
         * para evitar inconsistencias al inactivar un rol y al mismo tiempo activar un permiso
         */
        if(rolCambioAInactivado){
            registrarHistorialCambioEstadoRol(rolVo, siiUsuarioConec);
        }
    }
    
    private void registrarHistorialCambioEstadoRol(RolVO rolVo, SiiUsuario siiUsuarioConec) throws ExcepcionDAO{
        //Buscamos los permisos del rol
        List<SiiPermisoRolModulo> listaSiiPermisoRol = permisoRolModuloDao.buscarPermisoRolModuloPorRol(rolVo.getRolCodigo());
        SiiRol siiRol = conversionVoEntidad.convertir(rolVo);
        if(listaSiiPermisoRol != null && listaSiiPermisoRol.size() > 0){
            SiiHistorialRol siiHistorialRol = new SiiHistorialRol();
            if("N".equals(rolVo.getRolActivo())){
                siiHistorialRol.setHroFechaInactivRol(new Date());
            }
            else{
                siiHistorialRol.setHroFechaActivRol(new Date());
            }
            siiHistorialRol.setSiiRol(siiRol);
            siiHistorialRol.setSiiUsuarioConec(siiUsuarioConec);
            siiHistorialRol.setHroFechaActInacPer(new Date());
            historialRolDao.insertar(siiHistorialRol);
            
            if("N".equals(rolVo.getRolActivo())){
                //Hay inactivación de rol
                for(SiiPermisoRolModulo unSiiPermisoRolModulo : listaSiiPermisoRol){
                    adminHistorialPermiso.registarDesasignacionPermiso(siiHistorialRol, unSiiPermisoRolModulo, siiUsuarioConec);
                }
            }
            else{
                //Hay activación de rol
                for(SiiPermisoRolModulo unSiiPermisoRolModulo : listaSiiPermisoRol){
                    adminHistorialPermiso.registarAsignacionPermiso(siiHistorialRol, unSiiPermisoRolModulo, siiUsuarioConec);
                }
            }
        }
    }
    
    
    public void insertarModulosPermisoTodos(List<ModuloVO> listaModulosVo) throws ExcepcionDAO{
        RolVO rolVo = (listaModulosVo.get(0).getPermisoRolModuloVoList().get(0)).getRolVo();
        SiiRol siiRol = conversionVoEntidad.convertir(rolVo);
        siiRol = rolDao.insertarRol(siiRol);
        rolVo.setRolCodigo(siiRol.getRolCodigo());
        for(ModuloVO moduloVo : listaModulosVo){
            boolean existePermiso = false;
            for (PermisoRolModuloVO permisoRolModuloVo : moduloVo.getPermisoRolModuloVoList()){
                permisoRolModuloVo.setRolVo(rolVo);
                SiiPermisoRolModulo siiPermisoRolModulo = conversionVoEntidad.convertir(permisoRolModuloVo);
                if(permisoRolModuloVo.getPermisoVo().isSeleccionado()){
                    siiPermisoRolModulo = permisoRolModuloDao.insertarPermisoRolModulo(siiPermisoRolModulo);
                    existePermiso = true;
                }
            }
            if(existePermiso){
                SiiModulo siiModulo = moduloDao.buscarModuloPorId(moduloVo.getModCodigo());
                //Buscamos e insertamos los módulos padre
                insertarModuloPadre(siiModulo, siiRol);
            }
        }
    }
    
    private void insertarModuloPadre(SiiModulo siiModulo, SiiRol siiRol) throws ExcepcionDAO{
        if(siiModulo.getModCodigoPadre() == null){
            return;
        }
        SiiModulo siiModuloPadre = moduloDao.buscarModuloPorId(siiModulo.getModCodigoPadre());
        SiiPermisoRolModulo siiPermisoRolModulo = new SiiPermisoRolModulo();
        siiPermisoRolModulo.setSiiModulo1(siiModuloPadre);
        siiPermisoRolModulo.setSiiRol(siiRol);
        SiiPermiso siiPermiso = permisoDao.buscarPermisoPorNombre("CONSULTAR");
        siiPermisoRolModulo.setSiiPermiso(siiPermiso);
        SiiPermisoRolModulo siiPermisoRolModuloBuscar = permisoRolModuloDao.buscarPermisoRolModuloPorPadres(siiPermisoRolModulo);
        if(siiPermisoRolModuloBuscar == null){
            siiPermisoRolModulo = permisoRolModuloDao.insertarPermisoRolModulo(siiPermisoRolModulo);
        }
        insertarModuloPadre(siiModuloPadre, siiRol);
    }
    
    
    /*
    public ModuloVO buscarModuloPorPath (String modPath) throws ExcepcionDAO {
        ModuloVO moduloVo = null;
        SiiModulo siiModulo = moduloDao.buscarModuloPorPath(modPath);
        if (siiModulo!=null)
            moduloVo = new ModuloVO(siiModulo);
        
        return ( moduloVo );
    }
    */
    
    
    public List<ModuloVO> buscarTodosModulos() throws ExcepcionDAO {
        List<SiiModulo> listaModulos = moduloDao.buscarTodosModulos();
        List<ModuloVO> resultado = null;
        if (listaModulos!=null && !listaModulos.isEmpty()) {
            resultado = new ArrayList<ModuloVO>();
            for (SiiModulo siiModulo: listaModulos) {
                if (siiModulo!=null)
                    resultado.add(new ModuloVO(siiModulo));
            }
        }
        return resultado;
    }
}
