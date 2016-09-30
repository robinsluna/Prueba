package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.ModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.PermisoRolModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.PermisoVO;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ModuloDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    
    private Recursos recursos;
    
    public ModuloDAO() {
        recursos = new Recursos();
    }
    
    public List<ModuloVO> buscarModulosPorIdUsuario(UsuarioVO usuarioVo) throws ExcepcionDAO{
        List<ModuloVO> moduloVoList = new ArrayList<ModuloVO>();
        Query query = null;
        try {
            StringBuilder sql = new StringBuilder();
            if(usuarioVo.getUsuNombreUsuario().toUpperCase().equals("ROOT_SIICOL")){
                sql.append("SELECT DISTINCT MODU.MOD_CODIGO,MODU.MOD_NOMBRE,MODU.MOD_TITULO,MODU.MOD_PATH,MODU.MOD_ORDEN,");
                sql.append(" MODU.MOD_ACTIVO,MODU.MOD_CODIGO_PADRE,PMS.PMS_CODIGO,PMS.PMS_NOMBRE");
                sql.append(" FROM SII_MODULO MODU,SII_PERMISO PMS,SII_ROL ROL");
                //sql.append(" WHERE MODU.MOD_ACTIVO = 'S'");
                sql.append(" ORDER BY MODU.MOD_NOMBRE");

                query = manager.createNativeQuery(sql.toString());
            }
            else{
                sql.append("SELECT DISTINCT MODU.MOD_CODIGO,MODU.MOD_NOMBRE,MODU.MOD_TITULO,MODU.MOD_PATH,MODU.MOD_ORDEN,");
                sql.append(" MODU.MOD_ACTIVO,MODU.MOD_CODIGO_PADRE,PMS.PMS_CODIGO,PMS.PMS_NOMBRE");
                sql.append(" FROM SII_MODULO MODU");
                sql.append(" INNER JOIN SII_PERMISO_ROL_MODULO PMR ON PMR.MOD_CODIGO = MODU.MOD_CODIGO");
                sql.append(" INNER JOIN SII_PERMISO PMS ON PMS.PMS_CODIGO = PMR.PMS_CODIGO");
                sql.append(" INNER JOIN SII_ROL ROL ON ROL.ROL_CODIGO = PMR.ROL_CODIGO");
                sql.append(" INNER JOIN SII_USUARIO_ROL UROL ON UROL.ROL_CODIGO = ROL.ROL_CODIGO");
                sql.append(" INNER JOIN SII_USUARIO USU ON USU.USU_CODIGO = UROL.USU_CODIGO");
                sql.append(" WHERE MODU.MOD_ACTIVO = 'S'");
                sql.append(" AND ROL.ROL_ACTIVO = 'S'");
                sql.append(" AND USU.USU_CODIGO = #idUsuario");
                sql.append(" ORDER BY MODU.MOD_NOMBRE");
    
                query = manager.createNativeQuery(sql.toString());
                query.setParameter("idUsuario",usuarioVo.getUsuCodigo());
            }
            
            List<Object[]> results = query.getResultList();
            
            for (Object[] object : results) {
                ModuloVO moduloVo = new ModuloVO();
                moduloVoList.add(moduloVo);
                moduloVo.setPermisoRolModuloVoList(new ArrayList<PermisoRolModuloVO>());
                moduloVo.setModCodigo(((BigDecimal) object[0]).longValue());
                moduloVo.setModNombre((String) object[1]);
                moduloVo.setModTitulo((String) object[2]);
                moduloVo.setModPath((String) object[3]);
                moduloVo.setModOrden(new Integer(((BigDecimal) object[4]).intValue()));
                moduloVo.setModActivo((String) object[5]);
                if(object[6] != null){
                    moduloVo.setModCodigoPadre(((BigDecimal) object[6]).longValue());
                }
                
                PermisoRolModuloVO permisoRolModuloVo = new PermisoRolModuloVO();
                PermisoVO permisoVo = new PermisoVO();
                
                permisoVo.setPmsCodigo(((BigDecimal) object[7]).longValue());
                permisoVo.setPmsNombre((String) object[8]);
                permisoRolModuloVo.setPermisoVo(permisoVo);
                moduloVo.getPermisoRolModuloVoList().add(permisoRolModuloVo);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RubroDAO");
        } catch(Exception ex){
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"ModuloDAO");
        }
        return moduloVoList;
    }
    
    /*
    public List<ModuloVO> buscarModulosPorIdUsuarioConOrden(UsuarioVO usuarioVo) throws ExcepcionDAO{
        List<ModuloVO> moduloVoList = new ArrayList<ModuloVO>();
        Query query = null;
        try {
            StringBuilder sql = new StringBuilder();
            if(usuarioVo.getUsuNombreUsuario().toUpperCase().equals("ROOT_SIICOL")){
                sql.append("SELECT DISTINCT MODU.MOD_CODIGO,MODU.MOD_NOMBRE,MODU.MOD_TITULO,MODU.MOD_PATH,MODU.MOD_ORDEN,");
                sql.append(" MODU.MOD_ACTIVO,MODU.MOD_CODIGO_PADRE,PMS.PMS_CODIGO,PMS.PMS_NOMBRE");
                sql.append(" FROM SII_MODULO MODU,SII_PERMISO PMS,SII_ROL ROL");
                //sql.append(" WHERE MODU.MOD_ACTIVO = 'S'");
                sql.append(" ORDER BY MODU.MOD_ORDEN");

                query = manager.createNativeQuery(sql.toString());
            }
            else{
                sql.append("SELECT DISTINCT MODU.MOD_CODIGO,MODU.MOD_NOMBRE,MODU.MOD_TITULO,MODU.MOD_PATH,MODU.MOD_ORDEN,");
                sql.append(" MODU.MOD_ACTIVO,MODU.MOD_CODIGO_PADRE,PMS.PMS_CODIGO,PMS.PMS_NOMBRE");
                sql.append(" FROM SII_MODULO MODU");
                sql.append(" INNER JOIN SII_PERMISO_ROL_MODULO PMR ON PMR.MOD_CODIGO = MODU.MOD_CODIGO");
                sql.append(" INNER JOIN SII_PERMISO PMS ON PMS.PMS_CODIGO = PMR.PMS_CODIGO");
                sql.append(" INNER JOIN SII_ROL ROL ON ROL.ROL_CODIGO = PMR.ROL_CODIGO");
                sql.append(" INNER JOIN SII_USUARIO_ROL UROL ON UROL.ROL_CODIGO = ROL.ROL_CODIGO");
                sql.append(" INNER JOIN SII_USUARIO USU ON USU.USU_CODIGO = UROL.USU_CODIGO");
                sql.append(" WHERE MODU.MOD_ACTIVO = 'S'");
                sql.append(" AND USU.USU_CODIGO = #idUsuario");
                sql.append(" ORDER BY MODU.MOD_ORDEN");
    
                query = manager.createNativeQuery(sql.toString());
                query.setParameter("idUsuario",usuarioVo.getUsuCodigo());
            }
            
            List<Object[]> results = query.getResultList();
            
            for (Object[] object : results) {
                ModuloVO moduloVo = new ModuloVO();
                moduloVoList.add(moduloVo);
                moduloVo.setPermisoRolModuloVoList(new ArrayList<PermisoRolModuloVO>());
                moduloVo.setModCodigo(((BigDecimal) object[0]).longValue());
                moduloVo.setModNombre((String) object[1]);
                moduloVo.setModTitulo((String) object[2]);
                moduloVo.setModPath((String) object[3]);
                moduloVo.setModOrden(new Integer(((BigDecimal) object[4]).intValue()));
                moduloVo.setModActivo((String) object[5]);
                if(object[6] != null){
                    moduloVo.setModCodigoPadre(((BigDecimal) object[6]).longValue());
                }
                
                PermisoRolModuloVO permisoRolModuloVo = new PermisoRolModuloVO();
                PermisoVO permisoVo = new PermisoVO();
                
                permisoVo.setPmsCodigo(((BigDecimal) object[7]).longValue());
                permisoVo.setPmsNombre((String) object[8]);
                permisoRolModuloVo.setPermisoVo(permisoVo);
                moduloVo.getPermisoRolModuloVoList().add(permisoRolModuloVo);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RubroDAO");
        } catch(Exception ex){
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"ModuloDAO");
        }
        return moduloVoList;
    }
    */
    public SiiModulo buscarModuloPorId(Long idModulo) throws ExcepcionDAO{
        SiiModulo siiModulo = null;
        try {
            siiModulo = (SiiModulo) manager.find(SiiModulo.class, idModulo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModuloDAO");
        }
        return siiModulo;
    }
    
    public List<ModuloVO> buscarSoloModulosPorIdUsuarioConOrden(UsuarioVO usuarioVo) throws ExcepcionDAO{
        List<ModuloVO> moduloVoList = new ArrayList<ModuloVO>();
        Query query = null;
        try {
            StringBuilder sql = new StringBuilder();
            if(usuarioVo.getUsuNombreUsuario().toUpperCase().equals("ROOT_SIICOL")){
                sql.append("SELECT DISTINCT MODU.MOD_CODIGO, MODU.MOD_NOMBRE, MODU.MOD_TITULO, MODU.MOD_PATH,");
                sql.append(" MODU.MOD_ORDEN, MODU.MOD_ACTIVO, MODU.MOD_CODIGO_PADRE, MOD_MB_CLASS, MOD_PARAMETROS");
                sql.append(" FROM SII_MODULO MODU,SII_PERMISO PMS,SII_ROL ROL");
                //sql.append(" WHERE MODU.MOD_ACTIVO = 'S'");
                sql.append(" ORDER BY MODU.MOD_ORDEN");

                query = manager.createNativeQuery(sql.toString());
            }
            else{
                sql.append("SELECT DISTINCT MODU.MOD_CODIGO,MODU.MOD_NOMBRE,MODU.MOD_TITULO,MODU.MOD_PATH,MODU.MOD_ORDEN,");
                sql.append(" MODU.MOD_ACTIVO,MODU.MOD_CODIGO_PADRE, MOD_MB_CLASS, MOD_PARAMETROS");
                sql.append(" FROM SII_MODULO MODU");
                sql.append(" INNER JOIN SII_PERMISO_ROL_MODULO PMR ON PMR.MOD_CODIGO = MODU.MOD_CODIGO");
                sql.append(" INNER JOIN SII_PERMISO PMS ON PMS.PMS_CODIGO = PMR.PMS_CODIGO");
                sql.append(" INNER JOIN SII_ROL ROL ON ROL.ROL_CODIGO = PMR.ROL_CODIGO");
                sql.append(" INNER JOIN SII_USUARIO_ROL UROL ON UROL.ROL_CODIGO = ROL.ROL_CODIGO");
                sql.append(" INNER JOIN SII_USUARIO USU ON USU.USU_CODIGO = UROL.USU_CODIGO");
                sql.append(" WHERE MODU.MOD_ACTIVO = 'S'");
                sql.append(" AND ROL.ROL_ACTIVO = 'S'");
                sql.append(" AND USU.USU_CODIGO = #idUsuario");
                sql.append(" ORDER BY MODU.MOD_ORDEN");
    
                query = manager.createNativeQuery(sql.toString());
                query.setParameter("idUsuario",usuarioVo.getUsuCodigo());
            }
            
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                ModuloVO moduloVo = new ModuloVO();
                moduloVoList.add(moduloVo);
                moduloVo.setModCodigo(((BigDecimal) object[0]).longValue());
                moduloVo.setModNombre((String) object[1]);
                moduloVo.setModTitulo((String) object[2]);
                moduloVo.setModPath((String) object[3]);
                moduloVo.setModOrden(new Integer(((BigDecimal) object[4]).intValue()));
                moduloVo.setModActivo((String) object[5]);
                if(object[6] != null){
                    moduloVo.setModCodigoPadre(((BigDecimal) object[6]).longValue());
                }
                if(object[7] != null){
                    moduloVo.setModMbClass((String) object[7]);
                }
                if(object[8] != null){
                    moduloVo.setModParametros((String) object[8]);
                }
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RubroDAO");
        } catch(Exception ex){
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"ModuloDAO");
        }
        return moduloVoList;
    }
    
    /*
    public List<SiiModulo> buscarModulosPorIdUsuarioPorIdModuloPadre(UsuarioVO usuarioVo, Long idModuloPadre) throws ExcepcionDAO{
        List<SiiModulo> siiModuloList = new ArrayList<SiiModulo>();
        try {
            StringBuilder sql = new StringBuilder();
            Query query = null;
            if(usuarioVo.getUsuNombreUsuario().toUpperCase().equals("ROOT_SIICOL")){
                //Para root_siicol trae todos los módulos
                sql.append("SELECT DISTINCT MODU.MOD_CODIGO, MODU.MOD_NOMBRE, MODU.MOD_TITULO, MODU.MOD_PATH,");
                sql.append(" MODU.MOD_ORDEN, MODU.MOD_ACTIVO, MODU.MOD_CODIGO_PADRE, MOD_MB_CLASS");
                sql.append(" FROM SII_MODULO MODU, SII_PERMISO_ROL_MODULO PMR, SII_PERMISO PMS, SII_ROL");
                sql.append(" WHERE MODU.MOD_ACTIVO = 'S'");
                if(idModuloPadre == null){
                    sql.append(" AND MODU.MOD_CODIGO_PADRE IS NULL");
                    sql.append(" ORDER BY MODU.MOD_ORDEN");
                    query = manager.createNativeQuery(sql.toString());
                }
                else{
                    sql.append(" AND MODU.MOD_CODIGO_PADRE = #idCodigoPadre");
                    sql.append(" ORDER BY MODU.MOD_ORDEN");
                    query = manager.createNativeQuery(sql.toString());
                    query.setParameter("idCodigoPadre",idModuloPadre);
                }
            }
            else{
                sql.append("SELECT DISTINCT MODU.MOD_CODIGO,MODU.MOD_NOMBRE,MODU.MOD_TITULO,MODU.MOD_PATH,MODU.MOD_ORDEN,");
                sql.append(" MODU.MOD_ACTIVO,MODU.MOD_CODIGO_PADRE, MOD_MB_CLASS");
                sql.append(" FROM SII_MODULO MODU");
                sql.append(" INNER JOIN SII_PERMISO_ROL_MODULO PMR ON PMR.MOD_CODIGO = MODU.MOD_CODIGO");
                sql.append(" INNER JOIN SII_PERMISO PMS ON PMS.PMS_CODIGO = PMR.PMS_CODIGO");
                sql.append(" INNER JOIN SII_ROL ROL ON ROL.ROL_CODIGO = PMR.ROL_CODIGO");
                sql.append(" INNER JOIN SII_USUARIO_ROL UROL ON UROL.ROL_CODIGO = ROL.ROL_CODIGO");
                sql.append(" INNER JOIN SII_USUARIO USU ON USU.USU_CODIGO = UROL.USU_CODIGO");
                sql.append(" WHERE MODU.MOD_ACTIVO = 'S'");
                sql.append(" AND USU.USU_CODIGO = #idUsuario");
                
                if(idModuloPadre == null){
                    sql.append(" AND MODU.MOD_CODIGO_PADRE IS NULL");
                    sql.append(" ORDER BY MODU.MOD_ORDEN");
                    query = manager.createNativeQuery(sql.toString());
                }
                else{
                    sql.append(" AND MODU.MOD_CODIGO_PADRE = #idCodigoPadre");
                    sql.append(" ORDER BY MODU.MOD_ORDEN");
                    query = manager.createNativeQuery(sql.toString());
                    query.setParameter("idCodigoPadre",idModuloPadre);
                }
                query.setParameter("idUsuario",usuarioVo.getUsuCodigo());
            }
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                SiiModulo siiModulo = new SiiModulo();
                siiModuloList.add(siiModulo);
                siiModulo.setModCodigo(((BigDecimal) object[0]).longValue());
                siiModulo.setModNombre((String) object[1]);
                siiModulo.setModTitulo((String) object[2]);
                siiModulo.setModPath((String) object[3]);
                siiModulo.setModOrden(new Integer(((BigDecimal) object[4]).intValue()));
                siiModulo.setModActivo((String) object[5]);
                if(object[6] != null){
                    siiModulo.setModCodigoPadre(((BigDecimal) object[6]).longValue());
                }
                if(object[7] != null){
                    siiModulo.setModMbClass((String) object[7]);
                }
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModuloDAO");
        }
        return siiModuloList;
    }
    */
    
    public SiiModulo buscarModuloPorNombre(String nombreModulo) throws ExcepcionDAO{
        SiiModulo moduloRetorno = null;
        try{
            List<SiiModulo> listaModulos = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT modu FROM SiiModulo modu");
            sql.append(" WHERE modu.modNombre = :nombreModulo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreModulo", nombreModulo);
            listaModulos = query.getResultList();
            if(listaModulos != null && listaModulos.size()>0){
                moduloRetorno = listaModulos.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return moduloRetorno;
    }
    
    public SiiModulo insertarModulo(SiiModulo siiModulo) throws ExcepcionDAO{
        try{
            manager.persist(siiModulo);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                              //Retorna el VO
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ModuloDAO");
        }
        return siiModulo;
    }
    /*
    public SiiModulo buscarModulosPermisosTodosPorRol(Long idRol) throws ExcepcionDAO{
        List<SiiModulo> listaModulos = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT modu FROM SiiModulo modu");
            sql.append("INNER JOIN modu.");
            sql.append(" WHERE modu.modNombre = :nombreModulo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreModulo", nombreModulo);
            listaModulos = query.getResultList();
            if(listaModulos != null && listaModulos.size()>0){
                moduloRetorno = listaModulos.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return moduloRetorno;
    }*/
    
    public List<SiiModulo> buscarTodosModulos() throws ExcepcionDAO{
        List<SiiModulo> listaModulos = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT modu FROM SiiModulo modu");
            Query query = manager.createQuery(sql.toString());
            listaModulos = query.getResultList();
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ModuloDAO");
        }
        return listaModulos;
    }
    
    public List<ModuloVO> buscarTodosModulosConSinPermisoPorRol(Long idRol) throws ExcepcionDAO{
        List<ModuloVO> listaModulo = null;
        RolVO rolVo = new RolVO();
        rolVo.setRolCodigo(idRol);
        try{            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUB0.MOD_CODIGO, SUB0.MOD_NOMBRE,");
            sql.append(" SUB0.PMS_CODIGO, SUB0.PMS_NOMBRE,PRM.PMS_CODIGO");
            sql.append(" FROM");
            sql.append(" (SELECT ROL.ROL_CODIGO, PMS.PMS_CODIGO, PMS.PMS_NOMBRE, MODU.MOD_CODIGO, MODU.MOD_NOMBRE");
            sql.append(" FROM  SII_PERMISO PMS,SII_ROL ROL, SII_MODULO MODU");
            sql.append(" WHERE MODU.MOD_PATH IS NOT NULL AND MODU.MOD_ACTIVO = 'S' ) SUB0");
            sql.append(" LEFT JOIN SII_PERMISO_ROL_MODULO PRM ON SUB0.ROL_CODIGO = PRM.ROL_CODIGO");
            sql.append(" AND SUB0.PMS_CODIGO = PRM.PMS_CODIGO AND SUB0.MOD_CODIGO = PRM.MOD_CODIGO");
            sql.append(" WHERE SUB0.ROL_CODIGO = #idRol");
            sql.append(" ORDER BY SUB0.MOD_NOMBRE");
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("idRol",idRol);
            
            List<Object[]> results = query.getResultList();
            if(results != null && results.size() > 0){
                listaModulo = new ArrayList<ModuloVO>();
                ModuloVO moduloVo = null;
                String nombreModuloAnterior = "";
                for (Object[] object : results) {
                    if(!((String) object[1]).equals(nombreModuloAnterior)){
                        moduloVo = new ModuloVO();
                        moduloVo.setModCodigo(((BigDecimal) object[0]).longValue());
                        moduloVo.setModNombre((String) object[1]);
                        moduloVo.setPermisoRolModuloVoList(new ArrayList<PermisoRolModuloVO>());
                        listaModulo.add(moduloVo);
                        nombreModuloAnterior = moduloVo.getModNombre();
                    }
                    PermisoVO permisoVo = new PermisoVO();
                    permisoVo.setPmsCodigo(((BigDecimal) object[2]).longValue());
                    permisoVo.setPmsNombre((String) object[3]);
                    if(object[4] != null){
                        permisoVo.setSeleccionado(true);
                    }
                    PermisoRolModuloVO permisoRolModuloVo = new PermisoRolModuloVO();
                    permisoRolModuloVo.setRolVo(rolVo);
                    permisoRolModuloVo.setPermisoVo(permisoVo);
                    permisoRolModuloVo.setModuloVo(moduloVo);
                    moduloVo.getPermisoRolModuloVoList().add(permisoRolModuloVo);
                }     
            }
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"PermisoRolModuloDAO");            
        }
        return listaModulo;
    }
    
    
    
    /*
     * Realiza la consulta de un m&oacute;dulo por medio de su Path.
     * @param modPath - Servlet Path asociado al M&oacute;dulo.
     * @return M&oacute;dulo.
     * @throws ExcepcionDAO
     *//*
    public SiiModulo buscarModuloPorPath (String modPath) throws ExcepcionDAO
    {
        SiiModulo moduloRetorno = null;
        
        try{
            List<SiiModulo> listaModulos = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT m FROM SiiModulo m ");
            sql.append("WHERE m.modPath = :modPath ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("modPath", modPath);
            
            listaModulos = query.getResultList();
            if(listaModulos != null && listaModulos.size()>0){
                moduloRetorno = listaModulos.get(0);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        return moduloRetorno;
    }*/
}
