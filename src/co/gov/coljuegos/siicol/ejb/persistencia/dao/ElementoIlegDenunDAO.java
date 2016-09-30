/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-09-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegDenun;
import co.gov.coljuegos.siicol.ejb.vo.ElementoIlegDenunVO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access  Object para gestionar los elementos ilegales de las denuncias
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
    public class ElementoIlegDenunDAO extends AbstractDAO<Long, SiiElementoIlegDenun> {
    
    /**
     * Constructor
     */
    public ElementoIlegDenunDAO() {
        super(SiiElementoIlegDenun.class);
    }
    
    /**
     * Buscar los elementos ilegales activos (eid.eidActivo = 'S') según el código de la denuncia 
     * @param denCodigo - Código de la denuncia
     * @return resultado - lista de elementos ilegales de la denuncia
     * @throws ExcepcionDAO
     */
    public List<SiiElementoIlegDenun> buscarElementoIlegDenunXCodDenuncia(Long denCodigo) throws ExcepcionDAO 
    {
        List<SiiElementoIlegDenun> resultado = null;
        
        if (denCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT eid FROM SiiElementoIlegDenun eid ");
                sql.append("WHERE eid.siiDenuncia.denCodigo = :denCodigo AND eid.eidActivo = 'S' ORDER BY eid.eidCodigo");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("denCodigo", denCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }

    public List<SiiElementoIlegDenun> buscarTodoElementoIlegDenunXCodDenuncia(Long denCodigo) throws ExcepcionDAO 
    {
        List<SiiElementoIlegDenun> resultado = null;
        
        if (denCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT eid FROM SiiElementoIlegDenun eid ");
                sql.append("WHERE eid.siiDenuncia.denCodigo = :denCodigo ORDER BY eid.eidCodigo");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("denCodigo", denCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }

    public SiiElementoIlegDenun buscarElementoInactivo(ElementoIlegDenunVO elementoIlegDenunVo) throws ExcepcionDAO {
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT eid FROM SiiElementoIlegDenun eid ");
            sql.append("WHERE eid.siiDenuncia.denCodigo = :denCodigo AND eid.eidActivo='N' AND eid.eidNumero = :eidNumero AND eid.siiTipoElemenIlegalidad.teiCodigo = :teiCodigo");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("denCodigo", elementoIlegDenunVo.getDenunciaVo().getDenCodigo());
            query.setParameter("eidNumero",elementoIlegDenunVo.getEidNumero());
            query.setParameter("teiCodigo",elementoIlegDenunVo.getTipoElemenIlegalidadVo().getTeiCodigo());
            
            return (SiiElementoIlegDenun) query.getSingleResult();
            
        }
        catch (NoResultException e) {
            return new SiiElementoIlegDenun();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }
    }
}
