package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPago;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.ArrayList;
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
public class SolicitudPagoDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public SolicitudPagoDAO() {
        recursos = new Recursos();
    }

    /**
     * @author Giovanni
     * @param idSolicitudPago
     * @return 
     * @throws ExcepcionDAO
     */
    public SiiSolicitudPago buscarSolicitudPagoPorId(Long idSolicitudPago) throws ExcepcionDAO {
        SiiSolicitudPago siiSolicitudPago = null;
        try {
            siiSolicitudPago = manager.find(SiiSolicitudPago.class, idSolicitudPago);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPagoDAO");
        }
        return siiSolicitudPago;
    }

    public List<SiiSolicitudPago> buscarTodoSolicitudPago() throws ExcepcionDAO {
        try {

            List<SiiSolicitudPago> listaSolicitudPago = new ArrayList();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT solP FROM SiiSolicitudPago solP order by solP.spaConsecutivo desc");

            Query query = manager.createQuery(sql.toString());
            listaSolicitudPago = query.getResultList();
            return listaSolicitudPago;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "SolicitudPagoDAO");
        }
    }


    public List<BigDecimal> programaciónDelPFCMensual(Integer vigencia, Integer seleccionMesPago) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            //Validación del PFC
            sql.append("SELECT distinct(rp.rp_codigo) ");
            sql.append("FROM  ");
            sql.append("  SII_OBLIG_DET_RUBRO_CDP odet, ");
            sql.append("  SII_OBLIGACION_PAGO obli, ");
            sql.append("  SII_RP_DET_RUBRO_CDP rpdet, ");
            sql.append("  SII_RP rp ");
            sql.append("WHERE  ");
            sql.append("obli.opa_vigencia = #vigencia ");
            sql.append("AND obli.mes_codigo = #seleccionMesPago ");
            sql.append("AND obli.opa_codigo = odet.opa_codigo ");
            sql.append("AND odet.drc_codigo = rpdet.drc_codigo ");
            sql.append("AND rpdet.rp_codigo = rp.rp_codigo ");
            sql.append("AND RP.RP_CODIGO NOT IN (SELECT SOL.RP_CODIGO FROM SII_SOLICITUD_PAGO SOL)");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("seleccionMesPago", seleccionMesPago);
            query.setParameter("vigencia", vigencia);
            List<BigDecimal> listaRP = query.getResultList();


            return listaRP;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPagoDAO");
        }

    }

    /**
     * Se retorna todas las RP sin restricciones para crear solicitudes
     * @return
     * @throws ExcepcionDAO
     */
    public List<Long> sinProgramaciónDelPFCMensual() throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            //Sin Validación del PFC
            sql.append("SELECT distinct(rp.rpCodigo) ");
            //sql.append("FROM  SiiRp rp WHERE rp.rpCodigo NOT IN (SELECT SOL.siiRp.rpCodigo FROM SiiSolicitudPago SOL) ");
            //sql.append("AND rp.rpConsecutivo is not null ");
            sql.append("FROM  SiiRp rp WHERE rp.rpConsecutivo is not null AND rp.siiEstadoRp.erpCodigo = 8 order by rp.rpConsecutivo desc");

            Query query = manager.createQuery(sql.toString());
            List<Long> listaRP = query.getResultList();

            return listaRP;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPagoDAO");
        }

    }
    

    public SiiSolicitudPago actualizarEstadoSolicitud(SiiSolicitudPago solicitudPago) throws ExcepcionDAO {
        try {
            manager.merge(solicitudPago);
            manager.flush();
            return solicitudPago;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPagoDAO");
        }
    }

    public void insertarSolicitudPago(SiiSolicitudPago solicitudPago) throws ExcepcionDAO {

        try {
            manager.persist(solicitudPago);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "SolicitudPagoDAO");
        }
    }

    public List<SiiSolicitudPago> buscarSiiSolitudPagoXEstado(long estado) throws ExcepcionDAO {

        try {
            List<SiiSolicitudPago> listaSolicitudPago = new ArrayList();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT solP FROM SiiSolicitudPago solP WHERE solP.siiEstadoSolicPago.esoCodigo = :estado");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            listaSolicitudPago = query.getResultList();
            return listaSolicitudPago;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPagoDAO");
        }
    }

    public SiiSolicitudPago buscarSiiSolitudPagoXRp(Long idRp) throws ExcepcionDAO {
        SiiSolicitudPago solicitudPago = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT solP FROM SiiSolicitudPago solP WHERE solP.siiRp.rpCodigo = :idRp");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idRp", idRp);
            solicitudPago = (SiiSolicitudPago) query.getSingleResult();


        } catch (javax.persistence.NoResultException ne) {
            solicitudPago = null;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPagoDAO");
        }
        return solicitudPago;
    }

    public Long buscarConsecutivoSolicitudPago() throws ExcepcionDAO {
        Long consecutivo = null;
        try {
            StringBuilder sql = new StringBuilder();


            sql.append("SELECT NVL(MAX(SPA_CONSECUTIVO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM SII_SOLICITUD_PAGO o ");
            sql.append("WHERE SPA_CONSECUTIVO LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%'");
            Query query = manager.createNativeQuery(sql.toString());

            if (query.getSingleResult() != null) {
                consecutivo = new Long(((BigDecimal) query.getSingleResult()).longValueExact());
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    
    /**
     * Obtiene el Consecutivo de la Solicitud de Pago, asociada a la vigencia.
     * @param vigencia - A&ntilde;o al que se le generar&aacute; el Consecutivo.
     * @return Consecutivo asociado a la vigencia.
     * @throws ExcepcionDAO
     */
    public Long buscarConsecutivoSolicitudPago (Integer vigencia) throws ExcepcionDAO 
    {
        Long consecutivo = null;
        
        if (vigencia!=null) {
            
            Integer prefix = vigencia;
            
            if (vigencia>=100) {
                // establecer como prefijo los ultimos dos digitos de la vigencia
                String vig = vigencia.toString();
                String vigPref = vig.substring(vig.length()-2);
                prefix = Integer.parseInt(vigPref);
            }
                
            
            try {
                StringBuilder sql = new StringBuilder();
    
    
                sql.append("SELECT NVL(MAX(SPA_CONSECUTIVO)+1, "+prefix+"000001) ");
                sql.append("FROM SII_SOLICITUD_PAGO o ");
                sql.append("WHERE SPA_CONSECUTIVO LIKE '"+prefix+"%' ");
                Query query = manager.createNativeQuery(sql.toString());
    
                if (query.getSingleResult() != null) {
                    consecutivo = new Long(((BigDecimal) query.getSingleResult()).longValueExact());
                }
    
            }
            catch (NoResultException ne) {
                consecutivo = null;
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return consecutivo;
    }


    /**
     * Realiza la b&uacute;squeda de las Solicitudes de Pago que No se encuentran asociadas a Obligaciones sin anular, cuyo estado corresponda al estado de solicitud especificado.
     * @param esoCodigo - Estado de la Solicitud de Pago.
     * @return List of SiiSolicitudPago
     * @throws ExcepcionDAO
     */
    public List<SiiSolicitudPago> buscarSiiSolitudPagoSinObligacionXEstado(Long esoCodigo) throws ExcepcionDAO {

        try {
            List<SiiSolicitudPago> listaSolicitudPago = new ArrayList();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT spa FROM SiiSolicitudPago spa ");
            sql.append("WHERE spa.siiEstadoSolicPago.esoCodigo = :esoCodigo ");
            sql.append("AND spa.spaCodigo NOT IN (SELECT obl.siiSolicitudPago.spaCodigo FROM SiiObligacion obl WHERE obl.siiEstadoObligacion.eobCodigo <> :estadoObligacion) ");
            sql.append("ORDER BY spa.spaConsecutivo DESC ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("esoCodigo", esoCodigo);
            query.setParameter("estadoObligacion", EnumEstadoObligacion.ANULADO.getId());

            listaSolicitudPago = query.getResultList();
            return listaSolicitudPago;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPagoDAO");
        }
    }
}
