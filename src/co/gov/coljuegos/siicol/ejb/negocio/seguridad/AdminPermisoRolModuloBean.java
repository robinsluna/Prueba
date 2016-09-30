package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModuloDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PermisoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PermisoRolModuloDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.RolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioRolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermiso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuarioRol;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.ModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.PermisoRolModuloVO;

import co.gov.coljuegos.siicol.ejb.vo.PermisoVO;

import co.gov.coljuegos.siicol.ejb.vo.RolVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioRolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
public class AdminPermisoRolModuloBean implements AdminPermisoRolModulo {
    
    @EJB
    PermisoRolModuloDAO permisoRolModuloDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ModuloDAO moduloDao;
    @EJB
    PermisoDAO permisoDao;
    @EJB
    RolDAO rolDao;
    @EJB
    UsuarioRolDAO usuarioRolDao;
    @EJB
    UsuarioDAO usuarioDao;
    
    private Recursos recursos;
    
    public AdminPermisoRolModuloBean() {
        recursos = new Recursos();
    }
    
    public PermisoRolModuloVO insertarPermisoRolModulo(PermisoRolModuloVO permisoRolModuloVo) throws ExcepcionDAO{
        //Buscar para ver si ya existe:
        SiiPermisoRolModulo permisoRolModulo = conversionVoEntidad.convertir(permisoRolModuloVo);
        permisoRolModulo = permisoRolModuloDao.buscarPermisoRolModuloPorPadres(permisoRolModulo);
        if(permisoRolModulo != null){
            String mensajeError = recursos.obtenerRecurso("ERROR_REGISTRO_EXISTE", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AdminPermisoRolModuloBean");
        }
        permisoRolModulo = permisoRolModuloDao.insertarPermisoRolModulo(conversionVoEntidad.convertir(permisoRolModuloVo));
        return new PermisoRolModuloVO(permisoRolModulo);
    }
    
    public PermisoRolModuloVO buscarPermisoRolModuloPorPadres(PermisoRolModuloVO permisoRolModuloVo) throws ExcepcionDAO{
        PermisoRolModuloVO unPRMVoRetorno = null;
        SiiPermisoRolModulo siiPermisoRolModulo = conversionVoEntidad.convertir(permisoRolModuloVo);
        siiPermisoRolModulo = permisoRolModuloDao.buscarPermisoRolModuloPorPadres(siiPermisoRolModulo);
        if(siiPermisoRolModulo != null){
            unPRMVoRetorno = new PermisoRolModuloVO(siiPermisoRolModulo);
        }
        return unPRMVoRetorno;
    }
    
    public void borrarPermisoRolModulo(PermisoRolModuloVO permisoRolModuloVo) throws ExcepcionDAO{
        permisoRolModuloDao.borrarPermisoRolModulo(permisoRolModuloVo.getPrmCodigo());
    }
    
    public List<PermisoRolModuloVO> insertarListasPermisosRolesModulos(List<ModuloVO> listaModulosVo,List<PermisoVO> listaPermisosVo,
                                                                 List<RolVO> listaRoles, UsuarioVO usuarioVo) throws ExcepcionDAO{
        List<PermisoRolModuloVO> listaPRMVo = new ArrayList<PermisoRolModuloVO>();
        insertarListaModulosConHijos(listaModulosVo,null);
        
        for(PermisoVO unPermisoVo : listaPermisosVo){
            SiiPermiso unSiiPermiso = permisoDao.buscarPermisoPorNombre(unPermisoVo.getPmsNombre());
            if(unSiiPermiso == null){
            unSiiPermiso = permisoDao.insertarPermiso(conversionVoEntidad.convertir(unPermisoVo));
            System.out.println("Insertado Permiso " + unPermisoVo.getPmsNombre());
            }
            unPermisoVo.setPmsCodigo(unSiiPermiso.getPmsCodigo());
        }
        
        for(RolVO unRolVo : listaRoles){
            SiiRol unSiiRol = rolDao.buscarRolPorNombre(unRolVo.getRolNombre());
            if(unSiiRol == null){
                unSiiRol = rolDao.insertarRol(conversionVoEntidad.convertir(unRolVo));
                System.out.println("Insertado Rol " + unRolVo.getRolNombre());
            }
            unRolVo.setRolCodigo(unSiiRol.getRolCodigo());
            
            //Asignamos el rol al usuario
            SiiUsuario siiUsuarioBuscar = null;
            if(usuarioVo != null){
                siiUsuarioBuscar = usuarioDao.buscarUsuarioPorLogin(usuarioVo.getUsuNombreUsuario());
            }
            if(siiUsuarioBuscar != null){
                SiiUsuarioRol siiUsuarioRolBuscar = new SiiUsuarioRol();
                siiUsuarioRolBuscar.setSiiUsuario(siiUsuarioBuscar);
                siiUsuarioRolBuscar.setSiiRol1(unSiiRol);
                siiUsuarioRolBuscar = usuarioRolDao.buscarUsuarioRolPorPadres(siiUsuarioRolBuscar);
                if(siiUsuarioRolBuscar == null){
                    siiUsuarioRolBuscar = new SiiUsuarioRol();
                    siiUsuarioRolBuscar.setSiiUsuario(siiUsuarioBuscar);
                    siiUsuarioRolBuscar.setSiiRol1(unSiiRol);
                    usuarioRolDao.insertarUsuarioRol(siiUsuarioRolBuscar);
                    System.out.println("Agregado el usuario " + siiUsuarioBuscar.getUsuNombreUsuario() +
                                       " al Rol " + unSiiRol.getRolNombre());
                }
            }
        }
        
        List<ModuloVO> listaLinealModuloVo = alinearRamasArbol(listaModulosVo);
        //Insertamos todas las combinaciones si no existe
        for(ModuloVO unModuloVo : listaLinealModuloVo){
            for(PermisoVO unPermisoVo : listaPermisosVo){
                for(RolVO unRolVo : listaRoles){
                    PermisoRolModuloVO unPRMVo = new PermisoRolModuloVO();
                    unPRMVo.setRolVo(unRolVo);
                    unPRMVo.setPermisoVo(unPermisoVo);
                    unPRMVo.setModuloVo(unModuloVo);
                    PermisoRolModuloVO buscaPRMVo = buscarPermisoRolModuloPorPadres(unPRMVo);
                    if(buscaPRMVo == null){
                        SiiPermisoRolModulo unPRMInsertar = conversionVoEntidad.convertir(unPRMVo);
                        unPRMInsertar = permisoRolModuloDao.insertarPermisoRolModulo(unPRMInsertar);
                        buscaPRMVo = new PermisoRolModuloVO(unPRMInsertar);
                    }
                    unPRMVo.setPrmCodigo(buscaPRMVo.getPrmCodigo());
                    listaPRMVo.add(unPRMVo);
                }
            }
        }
        
        
        return listaPRMVo;
    }
    
    private void insertarListaModulosConHijos(List<ModuloVO> listaModulosVo, ModuloVO moduloPadre) throws ExcepcionDAO{
        //List<ModuloVO> listaRetorno = new ArrayList<ModuloVO>();
        
        for(ModuloVO moduloVo : listaModulosVo){
            System.out.println("Revisando Modulo " + moduloVo.getModNombre());
            SiiModulo moduloInsertar = conversionVoEntidad.convertir(moduloVo);
            if(moduloPadre != null){
                moduloInsertar.setModCodigoPadre(moduloPadre.getModCodigo());
            }
            SiiModulo siiModuloIns = moduloDao.buscarModuloPorNombre(moduloInsertar.getModNombre());
            if(siiModuloIns == null){
                siiModuloIns = moduloDao.insertarModulo(moduloInsertar);
                String detalle =  moduloPadre == null?"":moduloPadre.getModNombre() + ":" + moduloInsertar.getModNombre();
                System.out.println("Insertado Modulo " + detalle);
            }
            moduloVo.setModCodigo(siiModuloIns.getModCodigo());
            if(moduloVo.getModuloHijosVoList() != null && moduloVo.getModuloHijosVoList().size()>0){
                insertarListaModulosConHijos(moduloVo.getModuloHijosVoList(),moduloVo);
            }
        }
    }
    
    private List<ModuloVO> alinearRamasArbol(List<ModuloVO> listaModulosArbol){
        List<ModuloVO> listaLineal = new ArrayList<ModuloVO>();
        for(ModuloVO unModuloVo : listaModulosArbol){
            listaLineal.add(unModuloVo);
            if(unModuloVo.getModuloHijosVoList() != null && unModuloVo.getModuloHijosVoList().size()>0){
                List<ModuloVO> listaHijos = alinearRamasArbol(unModuloVo.getModuloHijosVoList());
                listaLineal.addAll(listaHijos);
            }
        }
        return listaLineal;
    }
    
    public List<PermisoRolModuloVO> buscarPermisoRolModuloPorRol(Long idRol) throws ExcepcionDAO{
        List<PermisoRolModuloVO> listaPmsVo = null;
        List<SiiPermisoRolModulo> listaPms = permisoRolModuloDao.buscarPermisoRolModuloPorRol(idRol);
        if(listaPms != null && listaPms.size() > 0){
            listaPmsVo = new ArrayList<PermisoRolModuloVO>();
            for (SiiPermisoRolModulo unPermisoRolModulo : listaPms){
                listaPmsVo.add(new PermisoRolModuloVO(unPermisoRolModulo));
            }
        }
        return listaPmsVo;
    }
    
}
