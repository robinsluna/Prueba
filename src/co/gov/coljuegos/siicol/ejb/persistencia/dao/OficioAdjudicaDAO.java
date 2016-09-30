/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-12-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioAdjudica;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class OficioAdjudicaDAO extends GenericDAO<SiiOficioAdjudica> {


    /**
     * Constructor.
     */
    public OficioAdjudicaDAO() {
        super(SiiOficioAdjudica.class);
    }


    /**
     * @author Giovanni
     * Realiza la consulta de los Oficios de Adjudicaci&oacute;n asociados a un Proceso de Contrataci&oacute;n.
     * @param prcCodigo - C&oacute;digo del Proceso de Contrataci&oacute;n.
     * @return listado de SiiOficioAdjudica.
     * @throws ExcepcionDAO
     */
    public SiiOficioAdjudica buscarOficioAdjudicaXCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        SiiOficioAdjudica siiOficioAdjudica = new SiiOficioAdjudica();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT oa FROM SiiOficioAdjudica oa,SiiProcesoContratacion pc");
            sql.append(" WHERE pc.prcCodigo = oa.siiProcesoContratacion.prcCodigo");
            sql.append(" AND pc.prcCodigo = :prcCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            List<SiiOficioAdjudica> siiOficioAdjudicas = query.getResultList();

            if (siiOficioAdjudicas != null && !siiOficioAdjudicas.isEmpty()) {
                siiOficioAdjudica = siiOficioAdjudicas.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return siiOficioAdjudica;
    }

    /**
     * Realiza la consulta de los Oficios de Adjudicaci&oacute;n asociados a un Proceso de Contrataci&oacute;n.
     * @param prcCodigo - C&oacute;digo del Proceso de Contrataci&oacute;n.
     * @return listado de SiiOficioAdjudica.
     * @throws ExcepcionDAO
     */
    public List<SiiOficioAdjudica> buscarPorCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT oa FROM SiiOficioAdjudica oa, ");
            sql.append("               SiiProcesoContratacion pc ");
            sql.append("WHERE pc.prcCodigo = oa.siiProcesoContratacion.prcCodigo ");
            sql.append("AND pc.prcCodigo = :prcCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            List<SiiOficioAdjudica> lista = query.getResultList();
            return (lista);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }

    public Long consultarConsecutivoMinuta() throws ExcepcionDAO {
        Long idConsecutivoMinuta;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select max(oad_consec_contr) from sii_oficio_adjudica  ");
            Query query = em.createNativeQuery(sql.toString());
            if (query.getSingleResult() == null) {
                idConsecutivoMinuta = 0L;
            } else {
                idConsecutivoMinuta = ((BigDecimal) query.getSingleResult()).longValue();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficioAdjudicaDAO");
        }
        return idConsecutivoMinuta;
    }

    /**
     * @author Giovanni
     * @param oadConsecContr
     * @return
     * @throws ExcepcionDAO
     */
    public boolean consultarConsecContr(Integer oadConsecContr, Integer oadVigencia) throws ExcepcionDAO {
        boolean estaConsecContr = false;

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT oa FROM SiiOficioAdjudica oa");
            sql.append(" WHERE oa.oadConsecContr = :oadConsecContr");
            sql.append(" AND oa.oadVigenciaContr != :oadVigencia");

            Query query = em.createQuery(sql.toString());
            query.setParameter("oadConsecContr", oadConsecContr);
            query.setParameter("oadVigencia", oadVigencia);
            
            List<SiiOficioAdjudica> siiOficioAdjudicas = query.getResultList();
            if (siiOficioAdjudicas != null && !siiOficioAdjudicas.isEmpty()) {
                estaConsecContr = true;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return estaConsecContr;
    }
}

