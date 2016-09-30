package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ExpedienteDocumDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ExpedienteDocumDAO() {
        recursos = new Recursos();
    }

    /**
     *
     * @param siiExpedienteDocum
     * @return
     * @throws ExcepcionDAO
     */
    public SiiExpedienteDocum insertarExpedienteDocum(SiiExpedienteDocum siiExpedienteDocum) throws ExcepcionDAO {
        try {
            manager.persist(siiExpedienteDocum);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiExpedienteDocum;
    }

    /**
     *
     * @param idExpedienteDocum
     * @return
     * @throws ExcepcionDAO
     */
    public SiiExpedienteDocum buscarExpedienteDocumPorId(String idExpedienteDocum) throws ExcepcionDAO {
        SiiExpedienteDocum siiExpedienteDocum = null;
        try {
            siiExpedienteDocum = (SiiExpedienteDocum) manager.find(SiiExpedienteDocum.class, idExpedienteDocum);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiExpedienteDocum;
    }

    /**
     *
     * @param siiExpedienteDocum
     * @return
     * @throws ExcepcionDAO
     */
    public SiiExpedienteDocum actualizarExpedienteDocum(SiiExpedienteDocum siiExpedienteDocum) throws ExcepcionDAO {
        try {
            manager.merge(siiExpedienteDocum);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiExpedienteDocum;
    }

    public String listaRadicadosDelExpediente(String edoCodigo) throws ExcepcionDAO {
        String retorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ListAgg(dra.DRA_CODIGO\n" + "  || ' del '\n" + "  || dra.DRA_FECHA\n" +
                       "  || ', ') Within GROUP (\n" + "ORDER BY edo.EDO_CODIGO)\n" +
                       "FROM sii_expediente_docum edo\n" + "INNER JOIN sii_expediente_radicado exr\n" +
                       "ON edo.EDO_CODIGO = exr.EDO_CODIGO\n" + "INNER JOIN PR.SII_DOCUMENTO_RADICADO dra\n" +
                       "ON exr.EXR_CODIGO = dra.EXR_CODIGO\n" + "where edo.EDO_CODIGO = #edoCodigo\n" +
                       "GROUP BY edo.EDO_CODIGO");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("edoCodigo", edoCodigo);
            retorno = (String) query.getSingleResult();
            
        } catch (NoResultException pe) {
            retorno = "_____";
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retorno;
    }

    //Por Gatopardo
    //Buscar expediente principal por contrato y nit
    public SiiExpedienteDocum buscarExpedientePrincipalPorContratoPorNit(String numeroContrato,
                                                                         String nit) throws ExcepcionDAO {
        SiiExpedienteDocum siiExpedienteDocum = null;
        try {
            /*
            Select *
            from SII_EXPEDIENTE_DOCUM expd
            inner join SII_SOLICITUD_AUTORIZA sau on sau.EDO_CODIGO = expd.EDO_CODIGO
            inner join sii_novedad nov on sau.SAU_CODIGO = nov.SAU_CODIGO
            inner join SII_CONTRATO con on nov.CON_CODIGO = con.CON_CODIGO
            inner join SII_OPERADOR ope on ope.OPE_CODIGO = con.OPE_CODIGO
            inner join sii_persona per on per.PER_CODIGO = ope.PER_CODIGO
            where per.PER_NUM_IDENTIFICACION = '800256745'
            and expd.EDO_CODIGO_PADRE is null
             */
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT expDoc FROM SiiExpedienteDocum expDoc ");
            sql.append("INNER JOIN expDoc.siiSolicitudAutorizaList sau ");
            sql.append("INNER JOIN sau.siiNovedadList nov ");
            sql.append("INNER JOIN nov.siiContrato con ");
            sql.append("INNER JOIN con.siiOperador ope ");
            sql.append("INNER JOIN ope.siiPersona per ");
            sql.append("WHERE per.perNumIdentificacion = :nit ");
            sql.append("AND con.conNumero = :numeroContrato ");
            sql.append("AND expDoc.siiExpedienteDocumPadre IS NULL ");
            //sql.append("order by expDoc.edoFecha desc");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("numeroContrato", numeroContrato);
            query.setParameter("nit", nit);

            List<SiiExpedienteDocum> listaExpedienteDocum = query.getResultList();
            if (listaExpedienteDocum != null && listaExpedienteDocum.size() > 0) {
                siiExpedienteDocum = listaExpedienteDocum.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiExpedienteDocum;
    }

}
