package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFiscalizadorSustanc;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class FiscalizadorSustancDAO extends AbstractDAO<Long, SiiFiscalizadorSustanc> {
    private static final long PROCESO_FISCALIZACION = 4L;
    private static final long PROCESO_SANCIONATORIO = 3L;
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    @EJB
    private TipoActuacionDAO tipoActuacionDao;


    public FiscalizadorSustancDAO() {
        super(SiiFiscalizadorSustanc.class);
        recursos = new Recursos();
    }

    public SiiFiscalizadorSustanc buscarPorCodigoSiiFiscalizadorSustanc(Long fsuCodigo) throws ExcepcionDAO {
        SiiFiscalizadorSustanc siiFiscalizadorSustanc = null;
        try {
            siiFiscalizadorSustanc = (SiiFiscalizadorSustanc) em.find(SiiFiscalizadorSustanc.class, fsuCodigo);

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificPfcAnualDAO");
        }
        return siiFiscalizadorSustanc;
    }


    public boolean existeFiscalizadorSustancPorPersonaRol(Long perCodigo, String fsuRol) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiFiscalizadorSustanc o WHERE o.siiPersona.perCodigo = :perCodigo AND o.fsuRol = :fsuRol");
            Query query = em.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            query.setParameter("fsuRol", fsuRol);
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

    public boolean existeFiscalizadorSustancPorPersonaRolTipoActuacion(Long perCodigo, String fsuRol, Long tacCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiFiscalizadorSustanc o WHERE o.siiPersona.perCodigo = :perCodigo AND o.fsuRol = :fsuRol AND o.siiTipoActuacion.tacCodigo=:tacCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            query.setParameter("fsuRol", fsuRol);
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

    public Long sustanciadorParaAsignarProceso(Long tacCodigo) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            if(tacCodigo ==
               PROCESO_SANCIONATORIO) {
                //Proceso incumplimiento
                sql.append("SELECT CANTIDAD_PROCESOS,\n" + "  PER_PRIMER_APELLIDO,\n" + "  PER_SEGUNDO_APELLIDO,\n" + "  PER_PRIMER_NOMBRE,\n" + "  PER_SEGUNDO_NOMBRE,\n" + "  FSU_CODIGO,\n" +
                           "  RowNum\n" + "FROM\n" + "  (SELECT SUM(\n" + "    CASE\n" + "      WHEN NVL(rfs.RFS_ACTIVO, 'S') = 'S'\n" + "      THEN 1\n" +
                           "      WHEN NVL(rfs.RFS_ACTIVO, 'S') = 'N'\n" + "      THEN 0\n" + "    END) CANTIDAD_PROCESOS,\n" + "    per.PER_PRIMER_APELLIDO,\n" + "    per.PER_SEGUNDO_APELLIDO,\n" +
                           "    per.PER_PRIMER_NOMBRE,\n" + "    per.PER_SEGUNDO_NOMBRE,\n" + "    fsu.FSU_CODIGO,\n" + "    tac.TAC_NOMBRE\n" + "  FROM SII_FISCALIZADOR_SUSTANC fsu\n" +
                           "  INNER JOIN sii_tipo_actuacion tac\n" + "  ON fsu.TAC_CODIGO = tac.TAC_CODIGO\n" + "  INNER JOIN sii_persona per\n" + "  ON fsu.PER_CODIGO = per.PER_CODIGO\n" +
                           "  LEFT JOIN SII_REPARTO_FISCALIZADOR rfs\n" + "  ON fsu.FSU_CODIGO = rfs.FSU_CODIGO\n" + "  LEFT JOIN SII_INCUMPLIMIENTO_CONTR icn\n" +
                           "  ON rfs.ICN_CODIGO = icn.ICN_CODIGO\n" + "  LEFT JOIN sii_estado_incumpl_contract eic\n" + "  ON icn.EIC_CODIGO = eic.EIC_CODIGO\n" +
                           "  INNER JOIN sii_hist_estado_fiscaliz hef\n" + "  ON fsu.FSU_CODIGO                   = hef.FSU_CODIGO\n" +
                           "  WHERE  NVL(eic.EIC_NOMBRE, 'XXX') NOT IN ('TERMINADO SIN SANCIÓN', 'TERMINADO CON SANCIÓN', 'ARCHIVADO')\n" + "  AND fsu.FSU_ROL                    IN ('S', 'A')\n" +
                           "  AND tac.TAC_CODIGO                  = #tacCodigo\n" + "  AND hef.hef_estado                  = 'A'\n" +
                           "  AND TRUNC(sysdate) BETWEEN TRUNC(hef.hef_fecha_act) AND TRUNC(hef.hef_fecha_inact)\n" + "  GROUP BY per.PER_PRIMER_APELLIDO,\n" + "    per.PER_SEGUNDO_APELLIDO,\n" +
                           "    per.PER_PRIMER_NOMBRE,\n" + "    per.PER_SEGUNDO_NOMBRE,\n" + "    fsu.FSU_CODIGO,\n" + "    tac.TAC_NOMBRE\n" + "  ORDER BY 1,\n" + "    2,\n" + "    3,\n" +
                           "    4,\n" + "    5\n" + "  )\n" + "WHERE rownum = 1");

            }
            else if(tacCodigo == PROCESO_FISCALIZACION) {
                sql.append("SELECT CANTIDAD_PROCESOS,\n" + "  PER_PRIMER_APELLIDO,\n" + "  PER_SEGUNDO_APELLIDO,\n" + "  PER_PRIMER_NOMBRE,\n" + "  PER_SEGUNDO_NOMBRE,\n" + "  FSU_CODIGO,\n" +
                           "  RowNum\n" + "FROM\n" + "  (SELECT SUM(\n" + "    CASE\n" + "      WHEN NVL(rfs.RFS_ACTIVO, 'S') = 'S'\n" + "      THEN 1\n" +
                           "      WHEN NVL(rfs.RFS_ACTIVO, 'S') = 'N'\n" + "      THEN 0\n" + "    END) CANTIDAD_PROCESOS,\n" + "    per.PER_PRIMER_APELLIDO,\n" + "    per.PER_SEGUNDO_APELLIDO,\n" +
                           "    per.PER_PRIMER_NOMBRE,\n" + "    per.PER_SEGUNDO_NOMBRE,\n" + "    fsu.FSU_CODIGO,\n" + "    tac.TAC_NOMBRE\n" + "  FROM SII_FISCALIZADOR_SUSTANC fsu\n" +
                           "  INNER JOIN sii_tipo_actuacion tac\n" + "  ON fsu.TAC_CODIGO = tac.TAC_CODIGO\n" + "  INNER JOIN sii_persona per\n" + "  ON fsu.PER_CODIGO = per.PER_CODIGO\n" +
                           "  LEFT JOIN SII_REPARTO_FISCALIZADOR rfs\n" + "  ON fsu.FSU_CODIGO = rfs.FSU_CODIGO\n" + "  LEFT JOIN SII_INCUMPLIMIENTO_CONTR icn\n" +
                           "  ON rfs.ICN_CODIGO = icn.ICN_CODIGO\n" + "  LEFT JOIN sii_estado_incumpl_contract eic\n" + "  ON icn.EIC_CODIGO = eic.EIC_CODIGO\n" +
                           "  INNER JOIN sii_hist_estado_fiscaliz hef\n" + "  ON fsu.FSU_CODIGO                   = hef.FSU_CODIGO\n" +
                           "  WHERE  NVL(eic.EIC_NOMBRE, 'XXX') NOT IN ('TERMINADO SIN SANCIÓN', 'TERMINADO CON SANCIÓN', 'ARCHIVADO')\n" + "  AND fsu.FSU_ROL                    IN ('S', 'A')\n" +
                           "  AND tac.TAC_CODIGO                  = #tacCodigo\n" + "  AND hef.hef_estado                  = 'A'\n" +
                           "  AND TRUNC(sysdate) BETWEEN TRUNC(hef.hef_fecha_act) AND TRUNC(hef.hef_fecha_inact)\n" + "  GROUP BY per.PER_PRIMER_APELLIDO,\n" + "    per.PER_SEGUNDO_APELLIDO,\n" +
                           "    per.PER_PRIMER_NOMBRE,\n" + "    per.PER_SEGUNDO_NOMBRE,\n" + "    fsu.FSU_CODIGO,\n" + "    tac.TAC_NOMBRE\n" + "  ORDER BY 1,\n" + "    2,\n" + "    3,\n" +
                           "    4,\n" + "    5\n" + "  )\n" + "WHERE rownum = 1");

            }


            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("tacCodigo", tacCodigo);
            Object[] fila = (Object[]) query.getSingleResult();
            BigDecimal fsuCodigoRetorno = (BigDecimal) fila[5];
            return fsuCodigoRetorno.longValue();

        } catch(NoResultException nre) {
            String mensajeError = "No existen sustanciadores / fiscalizadores con el tipo de actuación requerido. ";
            throw new ExcepcionDAO(mensajeError);
        } catch(PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FiscalizadorSustancDAO");
        }
    }


    public List<SiiFiscalizadorSustanc> buscarTodoFiscalizadorPrincipal() throws ExcepcionDAO {
        List<SiiFiscalizadorSustanc> listSiiFiscalizadorSustanc = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT f FROM SiiFiscalizadorSustanc f WHERE f.siiTipoActuacion.tacNombre='Visita' and f.fsuRol='F' ");
            sql.append(" order by f.siiPersona.perPrimerApellido asc ");
            Query query = em.createQuery(sql.toString());
            listSiiFiscalizadorSustanc = query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FiscalizadorSustancDAO");
        }
        return listSiiFiscalizadorSustanc;
    }

    public List<SiiFiscalizadorSustanc> buscarTodoFiscalizadorAcompañante() throws ExcepcionDAO {
        List<SiiFiscalizadorSustanc> listSiiFiscalizadorSustanc = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT f FROM SiiFiscalizadorSustanc f WHERE f.siiTipoActuacion.tacNombre='Visita' and f.fsuRol='F' ");
            sql.append("  order by f.siiPersona.perPrimerApellido asc ");
            Query query = em.createQuery(sql.toString());
            listSiiFiscalizadorSustanc = query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FiscalizadorSustancDAO");
        }
        return listSiiFiscalizadorSustanc;
    }


    public Long reasignarSustanciador(Long fsuCodigo, Long tacCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            if(tacCodigo ==
               PROCESO_SANCIONATORIO) {
                //Proceso incumplimiento
                sql.append("SELECT CANTIDAD_PROCESOS,\n" + "  PER_PRIMER_APELLIDO,\n" + "  PER_SEGUNDO_APELLIDO,\n" + "  PER_PRIMER_NOMBRE,\n" + "  PER_SEGUNDO_NOMBRE,\n" + "  FSU_CODIGO,\n" +
                           "  RowNum\n" + "FROM\n" + "  (SELECT  SUM(\n" + "    CASE\n" + "      WHEN nvl(rfs.RFS_ACTIVO,'S') = 'S'\n" + "      THEN 1\n" +
                           "      WHEN nvl(rfs.RFS_ACTIVO,'S') = 'N'\n" + "      THEN 0\n" + "    END) CANTIDAD_PROCESOS,\n" + "    per.PER_PRIMER_APELLIDO,\n" + "    per.PER_SEGUNDO_APELLIDO,\n" +
                           "    per.PER_PRIMER_NOMBRE,\n" + "    per.PER_SEGUNDO_NOMBRE,\n" + "    fsu.FSU_CODIGO,\n" + "    tac.TAC_NOMBRE\n" + "  FROM SII_FISCALIZADOR_SUSTANC fsu\n" +
                           "  INNER JOIN sii_tipo_actuacion tac\n" + "  ON fsu.TAC_CODIGO = tac.TAC_CODIGO\n" + "  INNER JOIN sii_persona per\n" + "  ON fsu.PER_CODIGO = per.PER_CODIGO\n" +
                           "  LEFT JOIN SII_REPARTO_FISCALIZADOR rfs\n" + "  ON fsu.FSU_CODIGO = rfs.FSU_CODIGO\n" + "  LEFT JOIN SII_INCUMPLIMIENTO_CONTR icn\n" +
                           "  ON rfs.ICN_CODIGO = icn.ICN_CODIGO\n" + "  LEFT JOIN sii_estado_incumpl_contract eic\n" + "  ON icn.EIC_CODIGO = eic.EIC_CODIGO\n" +
                           "  INNER JOIN sii_hist_estado_fiscaliz hef\n" + "  ON fsu.FSU_CODIGO                   = hef.FSU_CODIGO\n" +
                           "  WHERE NVL(eic.EIC_NOMBRE, 'XXX') NOT IN ('TERMINADO SIN SANCIÓN', 'TERMINADO CON SANCIÓN', 'ARCHIVADO')\n" + "  AND fsu.FSU_ROL                    IN ('S', 'A')\n" +
                           "  AND tac.TAC_CODIGO                  = #tacCodigo\n" + "  AND hef.hef_estado                  = 'A'\n" + "  AND fsu.fsu_codigo                 <> #fsuCodigo\n" +
                           "  AND TRUNC(sysdate) BETWEEN TRUNC(hef.hef_fecha_act) AND TRUNC(hef.hef_fecha_inact)\n" + "  GROUP BY per.PER_PRIMER_APELLIDO,\n" + "    per.PER_SEGUNDO_APELLIDO,\n" +
                           "    per.PER_PRIMER_NOMBRE,\n" + "    per.PER_SEGUNDO_NOMBRE,\n" + "    fsu.FSU_CODIGO,\n" + "    tac.TAC_NOMBRE\n" + "  ORDER BY 1,\n" + "    2,\n" + "    3,\n" +
                           "    4,\n" + "    5\n" + "  )\n" + "WHERE rownum = 1");

            }
            else if(tacCodigo == PROCESO_FISCALIZACION) {
                sql.append("SELECT CANTIDAD_PROCESOS,\n" + "  PER_PRIMER_APELLIDO,\n" + "  PER_SEGUNDO_APELLIDO,\n" + "  PER_PRIMER_NOMBRE,\n" + "  PER_SEGUNDO_NOMBRE,\n" + "  FSU_CODIGO,\n" +
                           "  RowNum\n" + "FROM\n" + "  (SELECT SUM(\n" + "    CASE\n" + "      WHEN NVL(rfs.RFS_ACTIVO, 'S') = 'S'\n" + "      THEN 1\n" +
                           "      WHEN NVL(rfs.RFS_ACTIVO, 'S') = 'N'\n" + "      THEN 0\n" + "    END) CANTIDAD_PROCESOS,\n" + "    per.PER_PRIMER_APELLIDO,\n" + "    per.PER_SEGUNDO_APELLIDO,\n" +
                           "    per.PER_PRIMER_NOMBRE,\n" + "    per.PER_SEGUNDO_NOMBRE,\n" + "    fsu.FSU_CODIGO,\n" + "    tac.TAC_NOMBRE\n" + "  FROM SII_FISCALIZADOR_SUSTANC fsu\n" +
                           "  INNER JOIN sii_tipo_actuacion tac\n" + "  ON fsu.TAC_CODIGO = tac.TAC_CODIGO\n" + "  INNER JOIN sii_persona per\n" + "  ON fsu.PER_CODIGO = per.PER_CODIGO\n" +
                           "  LEFT JOIN SII_REPARTO_FISCALIZADOR rfs\n" + "  ON fsu.FSU_CODIGO = rfs.FSU_CODIGO\n" + "   LEFT JOIN sii_proceso_sancionatorio psa\n" +
                           "  ON rfs.psa_CODIGO = psa.psa_CODIGO\n" + "  LEFT JOIN sii_estado_proceso_sanc eps\n" + "  ON psa.psa_CODIGO = eps.eps_CODIGO\n" +
                           "  INNER JOIN sii_hist_estado_fiscaliz hef\n" + "  ON fsu.FSU_CODIGO                     = hef.FSU_CODIGO\n" +
                           "  WHERE NVL(eps.EPS_NOMBRE, 'XXX') NOT IN ('TERMINADO SIN SANCIÓN', 'TERMINADO CON SANCIÓN', 'ARCHIVADO')\n" + "  AND fsu.FSU_ROL                      IN ('S', 'A')\n" +
                           "  AND tac.TAC_CODIGO                    = #tacCodigo\n" + "  AND hef.hef_estado                    = 'A'\n" + "  AND fsu.fsu_codigo                 <> #fsuCodigo\n" +
                           "  AND TRUNC(sysdate) BETWEEN TRUNC(hef.hef_fecha_act) AND TRUNC(hef.hef_fecha_inact)\n" + "  GROUP BY per.PER_PRIMER_APELLIDO,\n" + "    per.PER_SEGUNDO_APELLIDO,\n" +
                           "    per.PER_PRIMER_NOMBRE,\n" + "    per.PER_SEGUNDO_NOMBRE,\n" + "    fsu.FSU_CODIGO,\n" + "    tac.TAC_NOMBRE\n" + "  ORDER BY 1,\n" + "    2,\n" + "    3,\n" +
                           "    4,\n" + "    5\n" + "  )\n" + "WHERE rownum = 1");
            }
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("tacCodigo", tacCodigo);
            query.setParameter("fsuCodigo", fsuCodigo);
            Object[] fila = (Object[]) query.getSingleResult();
            BigDecimal fsuCodigoRetorno = (BigDecimal) fila[5];
            return fsuCodigoRetorno.longValue();

        } catch(NoResultException nre) {
            String mensajeError = "No existen sustanciadores / fiscalizadores activos con el tipo de actuación " + tipoActuacionDao.buscarPorCodigo(tacCodigo).getTacNombre();
            throw new ExcepcionDAO(mensajeError);
        } catch(PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FiscalizadorSustancDAO");
        }
    }

    public SiiFiscalizadorSustanc buscarFiscalizadorSustancPorId(Long fsuCodigo) throws ExcepcionDAO {
        SiiFiscalizadorSustanc fiscalizador = null;
        try {
            fiscalizador = (SiiFiscalizadorSustanc) manager.find(SiiFiscalizadorSustanc.class, fsuCodigo);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return fiscalizador;

    }

    public List<SiiFiscalizadorSustanc> buscarTodoOrdenadoPorPrimerNombre() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiFiscalizadorSustanc o ORDER BY o.siiPersona.perPrimerNombre,o.siiPersona.perSegundoNombre,o.siiPersona.perPrimerApellido,o.siiPersona.perSegundoApellido");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FiscalizadorSustancDAO");
        }
    }

    public List<SiiFiscalizadorSustanc> buscarTodoOrdenadoPorId() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiFiscalizadorSustanc o ORDER BY o.fsuCodigo DESC");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FiscalizadorSustancDAO");
        }
    }

}

