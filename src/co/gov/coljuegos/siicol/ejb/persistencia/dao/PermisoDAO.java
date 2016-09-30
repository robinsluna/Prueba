package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermiso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.ModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PermisoDAO {
    
    @EJB
    ModuloDAO moduloDao;
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public PermisoDAO() {
        recursos = new Recursos();
    }
    
    public SiiPermiso insertarPermiso(SiiPermiso siiPermiso) throws ExcepcionDAO{
        try{
            manager.persist(siiPermiso);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                              //Retorna el VO
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"PermisoDAO");
        }
        return siiPermiso;
    }
    
    public SiiPermiso buscarPermisoPorId(Long idPermiso) throws ExcepcionDAO{
        SiiPermiso siiPermiso = null;
        try{
            siiPermiso = (SiiPermiso) manager.find(SiiPermiso.class, idPermiso);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"PermisoDAO");
        }
        return siiPermiso;
    }
    
    public void insertarListaPermisos(List<SiiPermiso> listaPermisos) throws ExcepcionDAO{
        try{
            if(listaPermisos != null && listaPermisos.size()>0){
                for(SiiPermiso unPermiso : listaPermisos){
                    unPermiso = insertarPermiso(unPermiso);
                }
            }
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"PermisoDAO");
        }
    }
    /*
    public List<ModuloVO> buscarPermisoPorIdUsuarioPorIdModuloPadre(UsuarioVO usuarioVo, ModuloVO moduloVo) throws ExcepcionDAO{
        List<SiiModulo> listaSiiModulos = moduloDao.buscarModulosPorIdUsuarioPorIdModuloPadre(usuarioVo,
                                                    moduloVo==null?null:moduloVo.getModCodigo());
        List<ModuloVO> listaModulosVo = null;
        if(listaSiiModulos != null && listaSiiModulos.size()>0){
            listaModulosVo = new ArrayList<ModuloVO>();
            for(SiiModulo unSiiModulo : listaSiiModulos){
                ModuloVO unModuloVo = new ModuloVO(unSiiModulo);
                List<ModuloVO> listaHijosVo = buscarPermisoPorIdUsuarioPorIdModuloPadre(usuarioVo,unModuloVo);
                unModuloVo.setModuloHijosVoList(listaHijosVo);
                listaModulosVo.add(unModuloVo);
            }
        }
        return listaModulosVo;
    }
    */
    public SiiPermiso buscarPermisoPorNombre(String nombrePermiso) throws ExcepcionDAO{
        SiiPermiso permisoRetorno = null;
        try{
            List<SiiPermiso> listaPermisos = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT per FROM SiiPermiso per");
            sql.append(" WHERE per.pmsNombre = :nombrePermiso");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombrePermiso", nombrePermiso);
            listaPermisos = query.getResultList();
            if(listaPermisos != null && listaPermisos.size()>0){
                permisoRetorno = listaPermisos.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return permisoRetorno;
    }
}
