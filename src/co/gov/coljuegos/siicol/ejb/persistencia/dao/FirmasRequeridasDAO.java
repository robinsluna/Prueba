package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmasRequeridas;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasDocumentosVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@Local

public class FirmasRequeridasDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
       

    public FirmasRequeridasDAO() {
        recursos = new Recursos();
    }

    public SiiFirmasRequeridas buscarFirmasRequeridasPorId(Long idFirmaRequerida) throws ExcepcionDAO{
        SiiFirmasRequeridas firmasRequeridas = null;
        try{
            firmasRequeridas = (SiiFirmasRequeridas) manager.find(SiiFirmasRequeridas.class, idFirmaRequerida);
        }catch (PersistenceException pe ){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"FirmasRequeridasDAO");
        }
        return firmasRequeridas;
    }

    public SiiFirmasRequeridas insertarFirmasRequeridas(SiiFirmasRequeridas firmasRequeridas) throws ExcepcionDAO{
        try{
            manager.persist(firmasRequeridas);
            manager.flush();
            return firmasRequeridas;
            
        }catch (PersistenceException pe ){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"FirmasRequeridasDAO");
        }
    }

    public SiiFirmasRequeridas actualizarFirmasRequeridas(SiiFirmasRequeridas firmasRequeridas) throws ExcepcionDAO{
        try{
            firmasRequeridas = manager.merge(firmasRequeridas);
            manager.flush();
            return firmasRequeridas;
            
        }catch (PersistenceException pe ){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"FirmasRequeridasDAO");
        }
    }

    public void eliminarFirmasRequeridas(Long idFirmaRequerida) throws ExcepcionDAO{
        SiiFirmasRequeridas firmasRequeridas = null;
        try{
            firmasRequeridas = (SiiFirmasRequeridas) manager.find(SiiFirmasRequeridas.class, idFirmaRequerida);
            manager.remove(firmasRequeridas);
            manager.flush();
            
        }catch (PersistenceException pe ){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"FirmasRequeridasDAO");
        }
    }
    
    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridas(Long idTipoDocumento) throws ExcepcionDAO{
        List<FirmasRequeridasDocumentosVO> listaFirmasRequeridasDocumentosVo = new ArrayList<FirmasRequeridasDocumentosVO>();
        try {
        StringBuilder sql = new StringBuilder();            
        sql.append("SELECT f.fun_nombre, fr.fre_etiqueta, u.usu_nombre_usuario, \n" +
            "p.per_primer_nombre  || decode(per_segundo_nombre,null,'',' '||per_segundo_nombre)  || decode(p.per_primer_apellido,null,'',' '||per_primer_apellido)  || decode(p.per_segundo_apellido,null,'',' '||per_segundo_apellido), \n" +
            "u.usu_codigo, fr.fre_codigo, tdc.tdo_codigo \n" + 
            "FROM sii_firmas_requeridas fr \n" + 
            "INNER JOIN sii_tipo_documento_coljuegos tdc ON (fr.tdo_codigo = tdc.tdo_codigo) \n" + 
            "INNER JOIN sii_funcion f ON (fr.fun_codigo = f.fun_codigo) \n" + 
            "INNER JOIN sii_usuario u ON (f.fun_codigo = u.fun_codigo) \n" + 
            "INNER JOIN sii_persona p ON u.per_codigo = p.per_codigo\n" + 
            "WHERE tdc.tdo_codigo = #miIdTipoDocumento \n"+
            "AND fr.FRE_ACTIVO = #freActivo ");
            
            Query query = manager.createNativeQuery(sql.toString()); 
            query.setParameter("miIdTipoDocumento",idTipoDocumento);
            query.setParameter("freActivo", EnumDecision.SI.getId());
                
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                FirmasRequeridasDocumentosVO firmasRequeridasDocumentosVo = new FirmasRequeridasDocumentosVO();
                firmasRequeridasDocumentosVo.setFre_etiqueta((String) object[0]);
                firmasRequeridasDocumentosVo.setFun_nombre((String) object[1]);
                firmasRequeridasDocumentosVo.setUsu_nombre_usuario((String) object[2]);
                firmasRequeridasDocumentosVo.setPer_nombre_completo((String) object[3]);
                firmasRequeridasDocumentosVo.setUsu_codigo(((BigDecimal) object[4]).longValue());
                firmasRequeridasDocumentosVo.setFre_codigo(((BigDecimal) object[5]).longValue());
                firmasRequeridasDocumentosVo.setFdo_id_documento(((BigDecimal) object[6]).longValue());
                listaFirmasRequeridasDocumentosVo.add(firmasRequeridasDocumentosVo);
            }
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FirmasRequeridasDAO");
        }catch(Exception ex){
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"FirmasRequeridasDAO");
        }
        return listaFirmasRequeridasDocumentosVo;
        
    }
    
    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridas(Long idTipoDocumento, Long idDocumento) throws ExcepcionDAO{
        List<FirmasRequeridasDocumentosVO> listaFirmasRequeridasDocumentosVo = new ArrayList<FirmasRequeridasDocumentosVO>();
        try {
        StringBuilder sql = new StringBuilder();            
        sql.append("SELECT f.fun_nombre, fr.fre_etiqueta, u.usu_nombre_usuario, \n" +
            "p.per_primer_nombre || ' ' ||  p.per_segundo_nombre || ' ' || p.per_primer_apellido || ' ' || p.per_segundo_apellido, \n" +
            "u.usu_codigo, fr.fre_codigo, tdc.tdo_codigo \n" + 
            "FROM sii_firmas_requeridas fr \n" + 
            "INNER JOIN sii_tipo_documento_coljuegos tdc ON (fr.tdo_codigo = tdc.tdo_codigo) \n" + 
            "INNER JOIN sii_funcion f ON (fr.fun_codigo = f.fun_codigo) \n" + 
            "INNER JOIN sii_usuario u ON (f.fun_codigo = u.fun_codigo) \n" + 
            "INNER JOIN sii_persona p ON u.per_codigo = p.per_codigo\n" + 
            "WHERE tdc.tdo_codigo = #miIdTipoDocumento \n"+
            "AND fr.fre_activo = #freActivo ");
            
            Query query = manager.createNativeQuery(sql.toString()); 
            query.setParameter("miIdTipoDocumento",idTipoDocumento);
            query.setParameter("freActivo", EnumDecision.SI.getId());
                
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                FirmasRequeridasDocumentosVO firmasRequeridasDocumentosVo = new FirmasRequeridasDocumentosVO();
                firmasRequeridasDocumentosVo.setFre_etiqueta((String) object[0]);
                firmasRequeridasDocumentosVo.setFun_nombre((String) object[1]);
                firmasRequeridasDocumentosVo.setUsu_nombre_usuario((String) object[2]);
                firmasRequeridasDocumentosVo.setPer_nombre_completo((String) object[3]);
                firmasRequeridasDocumentosVo.setUsu_codigo(((BigDecimal) object[4]).longValue());
                firmasRequeridasDocumentosVo.setFre_codigo(((BigDecimal) object[5]).longValue());
                firmasRequeridasDocumentosVo.setFdo_id_documento(idDocumento);
                listaFirmasRequeridasDocumentosVo.add(firmasRequeridasDocumentosVo);
            }
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FirmasRequeridasDAO");
        }catch(Exception ex){
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"FirmasRequeridasDAO");
        }
        return listaFirmasRequeridasDocumentosVo;
        
    }

    
    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridasUsuario(Long idTipoDocumento, Long idUsuario) throws ExcepcionDAO{
        List<FirmasRequeridasDocumentosVO> listaFirmasRequeridasDocumentosVo = new ArrayList<FirmasRequeridasDocumentosVO>();
        try {
        StringBuilder sql = new StringBuilder();            
        sql.append("SELECT f.fun_nombre, fr.fre_etiqueta, u.usu_nombre_usuario, \n" +
            "p.per_primer_nombre || ' ' ||  p.per_segundo_nombre || ' ' || p.per_primer_apellido || ' ' || p.per_segundo_apellido, \n" +
            "u.usu_codigo, fr.fre_codigo, tdc.tdo_codigo \n" + 
            "FROM sii_firmas_requeridas fr \n" + 
            "INNER JOIN sii_tipo_documento_coljuegos tdc ON (fr.tdo_codigo = tdc.tdo_codigo) \n" + 
            "INNER JOIN sii_funcion f ON (fr.fun_codigo = f.fun_codigo) \n" + 
            "INNER JOIN sii_usuario u ON (f.fun_codigo = u.fun_codigo) \n" + 
            "INNER JOIN sii_persona p ON u.per_codigo = p.per_codigo\n" + 
            "WHERE tdc.tdo_codigo = #miIdTipoDocumento " +
            "AND u.usu_codigo = #miIdUsuario "+
            "AND fr.fre_activo = #freActivo ");
        Query query = manager.createNativeQuery(sql.toString()); 
        query.setParameter("miIdTipoDocumento",idTipoDocumento);
        query.setParameter("miIdUsuario",idUsuario);
        query.setParameter("freActivo", EnumDecision.SI.getId());
            
        List<Object[]> results = query.getResultList();
        for (Object[] object : results) {
            FirmasRequeridasDocumentosVO firmasRequeridasDocumentosVo = new FirmasRequeridasDocumentosVO();
            firmasRequeridasDocumentosVo.setFre_etiqueta((String) object[0]);
            firmasRequeridasDocumentosVo.setFun_nombre((String) object[1]);
            firmasRequeridasDocumentosVo.setUsu_nombre_usuario((String) object[2]);
            firmasRequeridasDocumentosVo.setPer_nombre_completo((String) object[3]);
            firmasRequeridasDocumentosVo.setUsu_codigo(((BigDecimal) object[4]).longValue());
            firmasRequeridasDocumentosVo.setFre_codigo(((BigDecimal) object[5]).longValue());
            firmasRequeridasDocumentosVo.setFdo_id_documento(((BigDecimal) object[6]).longValue());
            listaFirmasRequeridasDocumentosVo.add(firmasRequeridasDocumentosVo);
        }
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FirmasRequeridasDAO");
        }catch(Exception ex){
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"FirmasRequeridasDAO");
        }
        return listaFirmasRequeridasDocumentosVo;
        
    }
    
    /**
     * Realiza la b&uacute;squeda de las Firmas Requeridas a trav&eacute;s del ID de Tipo de Documento Coljuegos.
     * @param idTipoDocumento - C&oacute;digo del Tipo de Documento Coljuegos.
     * @return Listado de firmas requeridas.
     * @throws ExcepcionDAO
     */
    public List<SiiFirmasRequeridas> buscarFirmasRequeridasPorIdTipoDocColjuegos (Long idTipoDocumento) 
        throws ExcepcionDAO
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT fr FROM SiiFirmasRequeridas fr, ");
            sql.append("               SiiTipoDocumentoColjuegos tdc ");
            sql.append("WHERE tdc.tdoCodigo = fr.siiTipoDocumentoColjuegos1.tdoCodigo ");
            sql.append("AND tdc.tdoCodigo = :idTipoDocumento AND fr.freActivo = 'S' ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idTipoDocumento", idTipoDocumento);
            List<SiiFirmasRequeridas> listaFR = query.getResultList();
            return listaFR;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
}
