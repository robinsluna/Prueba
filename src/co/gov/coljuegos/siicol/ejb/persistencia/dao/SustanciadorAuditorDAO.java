package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSustanciadorAuditor;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.SustanciadorAuditorVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object para la gestión de los sustanciadores/auditores
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class SustanciadorAuditorDAO extends AbstractDAO<Long, SiiSustanciadorAuditor> {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
 

    /**
     * Constructor
     */
    public SustanciadorAuditorDAO() {
        super(SiiSustanciadorAuditor.class);
        recursos = new Recursos();
    }

    /**
     * Busca todos los sustanciadores/auditores que estén en estado activo según tipo de actuación
     * @param tipoActuacion - número del tipo de actuación
     * @return listaSiiSustanciadorAuditor - lista de sustanciadores/auditores
     * @throws ExcepcionDAO
     */

    public List<SustanciadorAuditorVO> buscarTodosSustanciadoresAuditoresActivosXTipoActuacion(Long tipoActuacion) throws ExcepcionDAO {
        List<SustanciadorAuditorVO> listaSustanciadorAuditorVO = new ArrayList<SustanciadorAuditorVO>();
        try {

            Date fechaActual = new Date();

            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT DISTINCT s.sua_codigo codigo,");
            sql.append(" s.sua_rol rol,");
            sql.append(" s.per_codigo codPersona,");
            sql.append(" p.per_primer_apellido primerapellido,");
            sql.append(" p.per_segundo_apellido segundoapellido,");
            sql.append(" p.per_primer_nombre primernombre,");
            sql.append(" p.per_segundo_nombre segundonombre");
            sql.append(" FROM sii_sustanciador_auditor s");
            sql.append(" INNER JOIN sii_persona p");
            sql.append(" ON p.per_codigo= s.per_codigo");
            sql.append(" INNER JOIN sii_hist_estado_sustan hes");
            sql.append(" ON hes.sua_codigo = s.sua_codigo");
            sql.append(" WHERE hes.hes_estado='A'");
            sql.append(" AND trunc(sysdate)");
            sql.append(" BETWEEN hes.hes_fecha_act AND hes.hes_fecha_inact");
            sql.append(" AND s.tac_codigo = ");
            sql.append(tipoActuacion);
            sql.append(" ORDER BY primerapellido,");
            sql.append(" segundoapellido,");
            sql.append(" primernombre,");
            sql.append(" segundonombre");

            Query query = em.createNativeQuery(sql.toString());
            List<Object[]> results = query.getResultList();


            for(Object[] object : results) {
                SustanciadorAuditorVO sustanciadorAuditorVO = new SustanciadorAuditorVO();
                sustanciadorAuditorVO.setSuaCodigo(((BigDecimal) object[0]).longValue());
                sustanciadorAuditorVO.setSuaRol((String) object[1]);

                PersonaVO personaVO = new PersonaVO();
                personaVO.setPerCodigo(((BigDecimal) object[2]).longValue());
                personaVO.setPerPrimerApellido((String) object[3]);
                personaVO.setPerSegundoApellido((String) object[4]);
                personaVO.setPerPrimerNombre((String) object[5]);
                personaVO.setPerSegundoNombre((String) object[6]);
                sustanciadorAuditorVO.setPersonaVo(personaVO);

                listaSustanciadorAuditorVO.add(sustanciadorAuditorVO);
            }

            return listaSustanciadorAuditorVO;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SustanciadorAuditorDAO");
        }

    }

    /**
     * Busca todos los sustanciadores/auditores que estén en estado activo en orden alfabético
     * @return listaSiiSustanciadorAuditor - lista de sustanciadores/auditores
     * @throws ExcepcionDAO
     */
    /*   public List<SustanciadorAuditorVO> buscarSustanciadoresAuditoresActivosOrdAlfa(Integer numFun, Long tipoActuacion) throws ExcepcionDAO {
        List<SustanciadorAuditorVO> listaSustanciadorAuditorVO = new ArrayList<SustanciadorAuditorVO>();
        try {

            Date fechaActual = new Date();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT *");
            sql.append("FROM");
            sql.append("(SELECT i.codigo cod,");
            sql.append("i.rol,");
            sql.append("i.codPersona,");
            sql.append("i.primerapellido,");
            sql.append("i.segundoapellido,");
            sql.append("i.primernombre,");
            sql.append("i. segundonombre");
            sql.append("FROM");
            sql.append("( SELECT DISTINCT s.sua_codigo codigo,");
            sql.append("s.sua_rol rol,");
            sql.append("s.per_codigo codPersona,");
            sql.append("p.per_primer_apellido primerapellido,");
            sql.append("p.per_segundo_apellido segundoapellido,");
            sql.append("p.per_primer_nombre primernombre,");
            sql.append("p.per_segundo_nombre segundonombre");

            sql.append("FROM sii_sustanciador_auditor s");
            sql.append("INNER JOIN sii_persona p");
            sql.append("ON p.per_codigo= s.per_codigo");
            sql.append("INNER JOIN sii_hist_estado_sustan hes");
            sql.append("ON hes.sua_codigo = s.sua_codigo");
            sql.append("WHERE ROWNUM     <= ");
            sql.append(numFun);
            sql.append(" AND hes.hes_estado='A'");
            sql.append("AND ");
            sql.append(fechaActual);
            sql.append(" BETWEEN hes.hes_fecha_act AND hes.hes_fecha_inact");
            sql.append("AND s.tac_codigo = ");
            sql.append(tipoActuacion);
            sql.append("   )i");
            sql.append(")j");
            sql.append("LEFT JOIN");
            sql.append("(SELECT DISTINCT aot.sua_codigo");
            sql.append("FROM sii_auditor_orden_trab aot");
            sql.append("WHERE aot.aot_activo='N'");
            sql.append(") auditorot");
            sql.append("ON auditorot.sua_codigo     =j.cod");

            sql.append("ORDER BY j.primerapellido,");
            sql.append("j.segundoapellido,");
            sql.append("j.primernombre,");
            sql.append("j.segundonombre");
            Query query = em.createNativeQuery(sql.toString());
            List<Object[]> results = query.getResultList();


            for(Object[] object : results) {
                SustanciadorAuditorVO sustanciadorAuditorVO = new SustanciadorAuditorVO();
                sustanciadorAuditorVO.setSuaCodigo(((BigDecimal) object[0]).longValue());
                sustanciadorAuditorVO.setSuaRol((String) object[1]);

                PersonaVO personaVO = new PersonaVO();
                personaVO.setPerCodigo(((BigDecimal) object[2]).longValue());
                personaVO.setPerPrimerApellido((String) object[3]);
                personaVO.setPerSegundoApellido((String) object[4]);
                personaVO.setPerPrimerNombre((String) object[5]);
                personaVO.setPerSegundoNombre((String) object[6]);
                sustanciadorAuditorVO.setPersonaVo(personaVO);

                listaSustanciadorAuditorVO.add(sustanciadorAuditorVO);
            }

            return listaSustanciadorAuditorVO;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SustanciadorAuditorDAO");
        }

    } */

    public List<SiiSustanciadorAuditor> buscarTodoSustanciadorAudPrincipal() throws ExcepcionDAO {
        List<SiiSustanciadorAuditor> listSiiSustanciadorAuditor = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT f FROM SiiSustanciadorAuditor f WHERE f.suaEstado = 'A' and f.suaRol='A' AND f.suaGrupoAsigVis = 'P' order by f.siiPersona.perPrimerApellido asc ");
            Query query = em.createQuery(sql.toString());
            listSiiSustanciadorAuditor = query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "SustanciadorAuditorDAO");
        }
        return listSiiSustanciadorAuditor;
    }

    public List<SiiSustanciadorAuditor> buscarTodoSustanciadorAudAcompañante() throws ExcepcionDAO {
        List<SiiSustanciadorAuditor> listSiiSustanciadorAuditor = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT f FROM SiiSustanciadorAuditor f WHERE  f.suaRol='A'  order by f.siiPersona.perPrimerApellido asc ");
            Query query = em.createQuery(sql.toString());
            listSiiSustanciadorAuditor = query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "SustanciadorAuditorDAO");
        }
        return listSiiSustanciadorAuditor;
    }

    public boolean existeSustanciadorAuditorPorPersonaRolTipoActuacion(Long perCodigo, String suaRol, Long tacCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiSustanciadorAuditor o WHERE o.siiPersona.perCodigo = :perCodigo AND o.suaRol = :suaRol AND o.siiTipoActuacion.tacCodigo=:tacCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            query.setParameter("suaRol", suaRol);
            query.setParameter("tacCodigo", tacCodigo);
            List lista = query.getResultList();
            if(lista.size() > 0) {
                return true;
            }
            else {
                return false;
            }

        } catch(PersistenceException pe) {
            return false;
        }
    }

    public SiiSustanciadorAuditor buscarSustanciadorAuditorPorId(Long suaCodigo) throws ExcepcionDAO {
        SiiSustanciadorAuditor sustanciador = null;
        try {
            sustanciador = (SiiSustanciadorAuditor) manager.find(SiiSustanciadorAuditor.class, suaCodigo);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return sustanciador;

    }

    public List<SiiSustanciadorAuditor> buscarTodoOrdenadoPorPrimerNombre() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiSustanciadorAuditor o ORDER BY o.siiPersona.perPrimerNombre,o.siiPersona.perSegundoNombre,o.siiPersona.perPrimerApellido,o.siiPersona.perSegundoApellido");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "SustanciadorAuditorDAO");
        }
    }

    public List<SiiSustanciadorAuditor> buscarTodoOrdenadoPorId() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiSustanciadorAuditor o ORDER BY o.suaCodigo DESC");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "SustanciadorAuditorDAO");
        }
    }

}
