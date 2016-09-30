/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEvaluacionJurTecFin;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class EvaluacionJurTecFinDAO extends GenericDAO<SiiEvaluacionJurTecFin>
{
    /**
     * Constructor.
     */
    public EvaluacionJurTecFinDAO() 
    {
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiEvaluacionJurTecFin.class);
    }
    
    
    
    /**
     * Realiza la consulta de las Evaluaciones Jur&iacute;dica, T&eacute;cnica y Financiera asociadas a un Proceso de Contrataci&oacute;n.
     * @param prcCodigo - C&oacute;digo del Proceso de Contrataci&oacute;n.
     * @return listado de SiiEvaluacionJurTecFin.
     * @throws ExcepcionDAO
     */
    public List<SiiEvaluacionJurTecFin> buscarPorCodigoProcesoContratacion (Long prcCodigo) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ejtf FROM SiiEvaluacionJurTecFin ejtf, ");
            sql.append("              SiiProcesoContratacion pc ");
            sql.append("WHERE pc.prcCodigo = ejtf.siiProcesoContratacion.prcCodigo ");
            sql.append("AND pc.prcCodigo = :prcCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            List<SiiEvaluacionJurTecFin> listaEJTF = query.getResultList();
            return listaEJTF;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EvaluacionJurTecFinDAO");
        }
    }
}
