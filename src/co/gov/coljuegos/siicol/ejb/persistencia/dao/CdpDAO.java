/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 16-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoCdp;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudDetalleRubroCdpVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class CdpDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public CdpDAO() {
        recursos = new Recursos();
    }

    public SiiCdp buscarCdpPorId(Long idCodigoCdp) throws ExcepcionDAO {
        SiiCdp resultadoCdp = null;
        try {
            resultadoCdp = manager.find(SiiCdp.class, idCodigoCdp);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return resultadoCdp;
    }

    public SiiCdp insertarCdp(SiiCdp siiCdp) throws ExcepcionDAO {
        try {
            manager.persist(siiCdp);
            manager.flush();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCdp;
    }

    public SiiCdp actualizarCdp(SiiCdp siiCdp) throws ExcepcionDAO {
        try {
            manager.merge(siiCdp);
            manager.flush();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCdp;
    }


    public List<SiiCdp> buscarTodoCdp() throws ExcepcionDAO {
        List<SiiCdp> listaCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT solCdp FROM SiiCdp solCdp");
            Query query = manager.createQuery(sql.toString());
            listaCdp = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCdp;
    }

    public List<SiiCdp> buscarCdpPorEstado(String estado) throws ExcepcionDAO {
        List<SiiCdp> listaCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cdp FROM SiiCdp cdp INNER JOIN cdp.siiEstadoCdp estado WHERE estado.ecdNombre = :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            listaCdp = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCdp;
    }

    public List<SiiCdp> buscarCdpsAprobadosSinIncrementosEnTramite() throws ExcepcionDAO {
        List<SiiCdp> listaCdp =  cdpsAprobadosSinMovimientosEnTramite("I");
        return listaCdp;
    }

    public List<SiiCdp> buscarCdpsAprobadosSinDecrementosEnTramite() throws ExcepcionDAO {
        List<SiiCdp> listaCdp = cdpsAprobadosSinMovimientosEnTramite("D");
        return listaCdp;
    }

    private List<SiiCdp> cdpsAprobadosSinMovimientosEnTramite(String mcdTipoMod) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cdp FROM SiiCdp cdp " + 
                       "INNER JOIN cdp.siiEstadoCdp estado " + 
                       "WHERE estado.ecdNombre = 'CDP APROBADO'" + 
                       "AND NOT EXISTS " +
                       " (SELECT mcd FROM SiiModificacionCdp mcd " + 
                       "  WHERE mcd.siiEstadoModifCdp.emcNombre NOT IN ('APROBADO','RECHAZADO','ANULADO') " + 
                       "  AND mcd.mcdTipoMod = :mcdTipoMod " +
                       "  AND mcd.siiCdp.cdpCodigo = cdp.cdpCodigo)" + 
                       " ORDER BY cdp.cdpConsecutivo DESC");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mcdTipoMod", mcdTipoMod);
            return query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }


    public SiiCdp buscarCdpPorConsecutivo(Long cdpConsecutivo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiCdp o WHERE o.cdpConsecutivo = :cdpConsecutivo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cdpConsecutivo", cdpConsecutivo);
            return (SiiCdp) query.getSingleResult();
        } catch(EntityNotFoundException eNF) {
            return new SiiCdp();
        } catch(NoResultException nRe) {
            return new SiiCdp();
        } catch(PersistenceException pe) { // EntityNotFoundException, NonUniqueResultException
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CdpDAO");
        }
    }

    public List<SiiCdp> buscarCdpExpedidos() throws ExcepcionDAO {
        List<SiiCdp> listaCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cdp FROM SiiCdp cdp INNER JOIN cdp.siiEstadoCdp estado WHERE estado.ecdNombre " + "IN ('APROBADO', 'CDP ANULADO','CDP IMPRESO','CDP REGISTRADO', 'CDP APROBADO') " +
                       "ORDER BY cdp.cdpConsecutivo DESC");
            Query query = manager.createQuery(sql.toString());
            listaCdp = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCdp;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiCdp> buscarCdpsCadenaPresupuestal(Date fechaInicial, Date fechaFinal) throws ExcepcionDAO {
        List<SiiCdp> siiCdps = new ArrayList<SiiCdp>();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cdp FROM SiiCdp cdp");
            sql.append(" WHERE cdp.siiEstadoCdp.ecdCodigo = :codigoEstado");
            sql.append(" AND cdp.cdpFechaExpedicion BETWEEN :fechaInicial AND :fechaFinal");
            sql.append(" ORDER BY cdp.cdpConsecutivo ASC");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoEstado", EnumEstadoCdp.CDP_APROBADO.getId());
            query.setParameter("fechaInicial", fechaInicial);
            query.setParameter("fechaFinal", fechaFinal);

            siiCdps = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCdps;
    }

    public List<SiiCdp> buscarCdpSolicitados() throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cdp FROM SiiCdp cdp INNER JOIN cdp.siiEstadoCdp estado WHERE estado.ecdNombre " +
                       "IN ('BORRADOR', 'CERRADO', 'REVISADO', 'IMPRESO', 'APROBADO', 'DESISTIDO', 'RECHAZADO') " + "ORDER BY cdp.cdpCodigo DESC");
            Query query = manager.createQuery(sql.toString());
            List<SiiCdp> listaCdpSolicitados = query.getResultList();
            return listaCdpSolicitados;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }


    public List<SolicitudDetalleRubroCdpVO> buscarDetalleRubroCdpPorItemPlanContratIdCdp(Long idIpc, Long idCdp) throws ExcepcionDAO {
        List<SolicitudDetalleRubroCdpVO> ListaDetalleRubroCdp = new ArrayList<SolicitudDetalleRubroCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ff.ffi_codigo,\n" + "  ff.ffi_descripcion,\n" + "  dff.dff_codigo,\n" + "  dff.dff_descripcion,\n" + "  dr.dru_codigo,\n" + "  r.descripcion,\n" + "  dr.dru_valor,\n" +
                       "  dr.vigencia,\n" + "  drc.drc_codigo,\n" + "  drc.cdp_codigo,\n" + "  drc.dru_valor,\n" + "  drc.drc_codigo,\n" + "  drc.drc_saldo_anterior,\n" + "  drc.drc_aplica_gmf,\n" +
                       "  drc.gmf_codigo,\n" + "  ff.ffi_codigo_fuente,\n" + "  dff.ffi_codigo,\n" +
                       "  /*\"TO_CHAR(r.interno_nivel1) || (case when r.interno_nivel2 is null then '' else '.' || TO_CHAR(r.interno_nivel2) end) || (case when r.interno_nivel3 is null then '' else '.' || TO_CHAR(r.interno_nivel3) end) || (case when r.interno_nivel4 is null then '' else '.' || TO_CHAR(r.interno_nivel4) end) || (case when r.interno_nivel5 is null then '' else '.' || TO_CHAR(r.interno_nivel5) end) || (case when r.interno_nivel6 is null then '' else '.' || TO_CHAR(r.interno_nivel6) end) || (case when r.interno_nivel7 is null then '' else '.' || TO_CHAR(r.interno_nivel7) end) || (case when r.interno_nivel8 is null then '' else '.' || TO_CHAR(r.interno_nivel8) end)  */\n" +
                       "  (\n" + "  SELECT\n" + "    (SELECT codigo FROM pr_nivel1 n1 WHERE n1.interno = r.interno_nivel1\n" + "    )\n" + "    ||\n" + "    (SELECT DECODE(codigo,NULL,NULL,'.'\n" +
                       "      ||codigo)\n" + "    FROM pr_nivel2 n1\n" + "    WHERE n1.interno = r.interno_nivel2\n" + "    )\n" + "    ||\n" + "    (SELECT DECODE(codigo,NULL,NULL,'.'\n" +
                       "      ||codigo)\n" + "    FROM pr_nivel3 n1\n" + "    WHERE n1.interno = r.interno_nivel3\n" + "    )\n" + "    ||\n" + "    (SELECT DECODE(codigo,NULL,NULL,'.'\n" +
                       "      ||codigo)\n" + "    FROM pr_nivel4 n1\n" + "    WHERE n1.interno = r.interno_nivel4\n" + "    )\n" + "    ||\n" + "    (SELECT DECODE(codigo,NULL,NULL,'.'\n" +
                       "      ||codigo)\n" + "    FROM pr_nivel5 n1\n" + "    WHERE n1.interno = r.interno_nivel5\n" + "    )\n" + "    ||\n" + "    (SELECT DECODE(codigo,NULL,NULL,'.'\n" +
                       "      ||codigo)\n" + "    FROM pr_nivel6 n1\n" + "    WHERE n1.interno = r.interno_nivel6\n" + "    )\n" + "    ||\n" + "    (SELECT DECODE(codigo,NULL,NULL,'.'\n" +
                       "      ||codigo)\n" + "    FROM pr_nivel7 n1\n" + "    WHERE n1.interno = r.interno_nivel7\n" + "    )\n" + "    ||\n" + "    (SELECT DECODE(codigo,NULL,NULL,'.'\n" +
                       "      ||codigo)\n" + "    FROM pr_nivel8 n1\n" + "    WHERE n1.interno = r.interno_nivel8\n" + "    )\n" + "  FROM pr_rubro pr\n" + "  WHERE pr.interno = r.interno\n" +
                       "  AND pr.vigencia  = r.vigencia\n" + "  ),\n" + "  dff.DFF_CODIGO_RECURSO\n" + "FROM sii_item_plan_cont_det_rub ipcdr\n" + "INNER JOIN sii_detalle_rubro dr\n" +
                       "ON (dr.dru_codigo =ipcdr.dru_codigo)\n" + "INNER JOIN sii_detalle_rubro_cdp drc\n" + "ON (drc.dru_codigo = dr.dru_codigo)\n" +
                       "INNER JOIN sii_dtlle_fuente_financiacion dff\n" + "ON (dr.dff_codigo = dff.dff_codigo)\n" + "INNER JOIN sii_fuente_financiacion ff\n" +
                       "ON (dff.ffi_codigo = ff.ffi_codigo)\n" + "INNER JOIN pr_rubro r\n" + "ON (dr.interno         = r.interno)\n" + "AND (dr.vigencia       = r.vigencia)\n" +
                       "WHERE ipcdr.ipc_codigo = #miIdIpc\n" + "AND drc.cdp_codigo     = #miIdCdp\n" + "ORDER BY ff.ffi_descripcion,\n" + "  r.descripcion");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("miIdIpc", idIpc);
            query.setParameter("miIdCdp", idCdp);
            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                SolicitudDetalleRubroCdpVO solicitudDetalleRubroCdpVo = new SolicitudDetalleRubroCdpVO();
                solicitudDetalleRubroCdpVo.setFfi_codigo(((BigDecimal) object[0]).longValue());
                solicitudDetalleRubroCdpVo.setFfi_descripcion((String) object[1]);
                //solicitudDetalleRubroCdpVo.setFfi_nombre((String) object[1]);
                solicitudDetalleRubroCdpVo.setDff_codigo(((BigDecimal) object[2]).longValue());
                solicitudDetalleRubroCdpVo.setDff_descripcion((String) object[3]);
                solicitudDetalleRubroCdpVo.setDru_codigo(((BigDecimal) object[4]).longValue());
                solicitudDetalleRubroCdpVo.setDescripcion((String) object[5]);
                solicitudDetalleRubroCdpVo.setDru_valor(((BigDecimal) object[6]));
                solicitudDetalleRubroCdpVo.setVigencia(((BigDecimal) object[7]).longValue());
                solicitudDetalleRubroCdpVo.setDrc_codigo(((BigDecimal) object[8]).longValue());
                solicitudDetalleRubroCdpVo.setCdp_codigo(((BigDecimal) object[9]).longValue());
                solicitudDetalleRubroCdpVo.setCdp_valor(((BigDecimal) object[10]));
                solicitudDetalleRubroCdpVo.setDrc_codigo(((BigDecimal) object[11]).longValue());
                solicitudDetalleRubroCdpVo.setSaldo_anterior(((BigDecimal) object[12]));
                solicitudDetalleRubroCdpVo.setAplica_gf((String) object[13]);
                if(object[14] != null) {
                    solicitudDetalleRubroCdpVo.setCdp_codigo(((BigDecimal) object[14]).longValue());
                }
                solicitudDetalleRubroCdpVo.setDff_ffi_codigo(((BigDecimal) object[16]).longValue());
                solicitudDetalleRubroCdpVo.setFfi_codigo_fuente(((BigDecimal) object[15]).longValue());
                solicitudDetalleRubroCdpVo.setCodigo_rubro((String) object[17]);
                solicitudDetalleRubroCdpVo.setDff_codigo_recurso(((BigDecimal) object[18]).longValue());
                ListaDetalleRubroCdp.add(solicitudDetalleRubroCdpVo);
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return ListaDetalleRubroCdp;
    }

    public List<SolicitudDetalleRubroCdpVO> buscarDetalleRubroCdpPorItemPlanContratIdCdpParaRecursosPropios(Long idIpc, Long idCdp) throws ExcepcionDAO {
        List<SolicitudDetalleRubroCdpVO> ListaDetalleRubroCdp = new ArrayList<SolicitudDetalleRubroCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ff.ffi_codigo, ff.ffi_descripcion, dff.dff_codigo, dff.dff_descripcion, dr.dru_codigo, ");
            sql.append("r.descripcion, dr.dru_valor, dr.vigencia, drc.drc_codigo, drc.cdp_codigo, drc.dru_valor, drc.drc_codigo ");
            sql.append("FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) ");
            sql.append("INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("WHERE ipcdr.ipc_codigo = #miIdIpc ");
            sql.append("AND drc.cdp_codigo = #miIdCdp ");
            sql.append("AND ff.ffi_descripcion = 'RECURSOS PROPIOS' ");
            sql.append("ORDER BY ff.ffi_descripcion, r.descripcion ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("miIdIpc", idIpc);
            query.setParameter("miIdCdp", idCdp);
            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                SolicitudDetalleRubroCdpVO solicitudDetalleRubroCdpVo = new SolicitudDetalleRubroCdpVO();
                solicitudDetalleRubroCdpVo.setFfi_codigo(((BigDecimal) object[0]).longValue());
                solicitudDetalleRubroCdpVo.setFfi_descripcion((String) object[1]);
                //solicitudDetalleRubroCdpVo.setFfi_nombre((String) object[1]);
                solicitudDetalleRubroCdpVo.setDff_codigo(((BigDecimal) object[2]).longValue());
                solicitudDetalleRubroCdpVo.setDff_descripcion((String) object[3]);
                solicitudDetalleRubroCdpVo.setDru_codigo(((BigDecimal) object[4]).longValue());
                solicitudDetalleRubroCdpVo.setDescripcion((String) object[5]);
                solicitudDetalleRubroCdpVo.setDru_valor(((BigDecimal) object[6]));
                solicitudDetalleRubroCdpVo.setVigencia(((BigDecimal) object[7]).longValue());
                solicitudDetalleRubroCdpVo.setDrc_codigo(((BigDecimal) object[8]).longValue());
                solicitudDetalleRubroCdpVo.setCdp_codigo(((BigDecimal) object[9]).longValue());
                solicitudDetalleRubroCdpVo.setCdp_valor(((BigDecimal) object[10]));
                solicitudDetalleRubroCdpVo.setDrc_codigo(((BigDecimal) object[11]).longValue());
                ListaDetalleRubroCdp.add(solicitudDetalleRubroCdpVo);
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return ListaDetalleRubroCdp;

    }

    public Long consultarConsecutivoCdp() throws ExcepcionDAO {
        Long consecutivo = null;
        try {
            StringBuilder sql = new StringBuilder();


            sql.append("SELECT NVL(MAX(cdp_consecutivo)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yyyy')||'000001')) ");
            sql.append("FROM sii_cdp cdp ");
            sql.append("WHERE cdp_consecutivo LIKE ''||TO_CHAR(CURRENT_DATE,'yyyy')||'%'");
            Query query = manager.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                consecutivo = new Long(((BigDecimal) query.getSingleResult()).longValue());
            }

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }


    public List<SolicitudDetalleRubroCdpVO> calcularSaldoApropiacion(Long idItemPlanContratacion, Long idVigencia) throws ExcepcionDAO {
        List<SolicitudDetalleRubroCdpVO> listaSolicitudDetalleRubroCdpVO = new ArrayList<SolicitudDetalleRubroCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT uno.dru_codigo, sum(uno.dru_valor) FROM ( \n" + "SELECT ipcdr.dru_codigo, dr.dru_valor \n" + "FROM sii_item_plan_cont_det_rub ipcdr \n" +
                       "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo = ipcdr.dru_codigo)  \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat \n" + "AND dr.vigencia = #miVigencia\n" +
                       "UNION ALL  \n" + "SELECT mpdr.dru_codigo_destino, sum(mpdr.mpd_valor)  \n" + "FROM sii_modific_presup mp  \n" +
                       "INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo)  \n" + "INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo) \n" +
                       "WHERE mpdr.dru_codigo_destino IN  \n" + "(SELECT ipcdr.dru_codigo \n" + "FROM sii_item_plan_cont_det_rub ipcdr \n" +
                       "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat \n" + "AND dr.vigencia = #miVigencia) \n" +
                       "AND mp.mpr_tipo IN ('A') \n" + "AND mpdr.dru_codigo_destino IS NOT NULL \n" + "AND mp.emp_codigo = 3 \n" + "GROUP BY mpdr.dru_codigo_destino \n" + "UNION ALL \n" +
                       "SELECT mpdr.dru_codigo_destino, -sum(mpdr.mpd_valor) \n" + "FROM sii_modific_presup mp  \n" + "INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo) \n" +
                       "INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo) \n" + "WHERE mpdr.dru_codigo_destino IN \n" + "(SELECT ipcdr.dru_codigo \n" +
                       "FROM sii_item_plan_cont_det_rub ipcdr \n" + "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat \n" +
                       "AND dr.vigencia = #miVigencia) \n" + "AND mp.mpr_tipo IN ('R') \n" + "AND mpdr.dru_codigo_destino IS NOT NULL \n" + "AND mp.emp_codigo = 3 \n" +
                       "GROUP BY mpdr.dru_codigo_destino \n" + "UNION ALL  \n" + "SELECT mpdr.dru_codigo_destino, sum(mpdr.mpd_valor)  \n" + "FROM sii_modific_presup mp  \n" +
                       "INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo) \n" + "INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo)  \n" +
                       "WHERE mpdr.dru_codigo_destino IN  \n" + "(SELECT ipcdr.dru_codigo \n" + "FROM sii_item_plan_cont_det_rub ipcdr \n" +
                       "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo)  \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat \n" +
                       "AND dr.vigencia = #miVigencia) AND mp.mpr_tipo IN ('T')  \n" + "AND mpdr.dru_codigo_destino IS NOT NULL  \n" + "AND mp.emp_codigo = 3  \n" +
                       "GROUP BY mpdr.dru_codigo_destino  \n" + "UNION ALL  \n" + "SELECT mpdr.dru_codigo_origen, -sum(mpdr.mpd_valor)  \n" + "FROM sii_modific_presup mp  \n" +
                       "INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo)  \n" + "INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo)  \n" +
                       "WHERE mpdr.dru_codigo_origen IN  \n" + "(SELECT ipcdr.dru_codigo \n" + "FROM sii_item_plan_cont_det_rub ipcdr \n" +
                       "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo)  \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat \n" + "AND dr.vigencia = #miVigencia)  \n" +
                       "AND mp.mpr_tipo IN ('T')  \n" + "AND mpdr.dru_codigo_origen IS NOT NULL  \n" + "AND mp.emp_codigo = 3  \n" + "GROUP BY mpdr.dru_codigo_origen  \n" + "UNION ALL  \n" +
                       "SELECT drc.dru_codigo, -sum(drc.dru_valor)  \n" + "FROM sii_cdp cdp  \n" + "INNER JOIN sii_detalle_rubro_cdp drc ON (cdp.cdp_codigo = drc.cdp_codigo)  \n" +
                       "INNER JOIN sii_estado_cdp ecdp  ON (cdp.ecd_codigo = ecdp.ecd_codigo)  \n" + "WHERE dru_codigo IN  \n" + "(SELECT ipcdr.dru_codigo \n" +
                       "FROM sii_item_plan_cont_det_rub ipcdr \n" + "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo)  \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat \n" +
                       "AND dr.vigencia = #miVigencia)  \n" + "AND ecdp.ecd_nombre = 'CDP APROBADO'  \n" + "GROUP BY drc.dru_codigo  \n" + "UNION ALL  \n" +
                       "SELECT drc.dru_codigo, sum(mcdrc.mcr_valor)  \n" + "FROM sii_modificacion_cdp mc  \n" + "INNER JOIN sii_modif_cdp_det_rub_cdp mcdrc ON (mc.mcd_codigo = mcdrc.mcd_codigo)  \n" +
                       "INNER JOIN sii_detalle_rubro_cdp drc ON (drc.drc_codigo = mcdrc.drc_codigo)  \n" + "WHERE mcdrc.drc_codigo IN  \n" + "(SELECT drc.drc_codigo \n" +
                       "FROM sii_item_plan_cont_det_rub ipcdr \n" + "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo)  \n" +
                       "INNER JOIN sii_detalle_rubro_cdp drc ON (dr.dru_codigo = drc.dru_codigo) \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat \n" + "AND dr.vigencia = #miVigencia)  \n" +
                       "AND mc.emc_codigo=5 \n" + "AND mc.mcd_tipo_mod='D' \n" + "GROUP BY drc.dru_codigo  \n" + "UNION ALL  \n" + "SELECT drc.dru_codigo, -sum(mcdrc.mcr_valor)  \n" +
                       "FROM sii_modificacion_cdp mc  \n" + "INNER JOIN sii_modif_cdp_det_rub_cdp mcdrc ON (mc.mcd_codigo = mcdrc.mcd_codigo)  \n" +
                       "INNER JOIN sii_detalle_rubro_cdp drc ON (drc.drc_codigo = mcdrc.drc_codigo)  \n" + "WHERE mcdrc.drc_codigo IN  \n" + "(SELECT drc.drc_codigo \n" +
                       "FROM sii_item_plan_cont_det_rub ipcdr \n" + "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo)  \n" +
                       "INNER JOIN sii_detalle_rubro_cdp drc ON (dr.dru_codigo = drc.dru_codigo) \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat \n" + "AND dr.vigencia = #miVigencia)  \n" +
                       "AND mc.emc_codigo=5 \n" + "AND mc.mcd_tipo_mod='I' \n" + "GROUP BY drc.dru_codigo \n" + ")uno GROUP BY uno.dru_codigo \n ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("miIdItemPlanContrat", idItemPlanContratacion);
            query.setParameter("miVigencia", idVigencia);
            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                SolicitudDetalleRubroCdpVO solicitudDetalleRubroCdpVo = new SolicitudDetalleRubroCdpVO();
                solicitudDetalleRubroCdpVo.setDru_codigo(((BigDecimal) object[0]).longValue());
                solicitudDetalleRubroCdpVo.setSaldo_apropiacion(((BigDecimal) object[1]));
                listaSolicitudDetalleRubroCdpVO.add(solicitudDetalleRubroCdpVo);
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolicitudDetalleRubroCdpVO;
    }


    public List<PrRubroVO> buscarDescricionRubroN2N3XCdp(Long idCdp) throws ExcepcionDAO {
        List<PrRubroVO> ListaPrRubroVo = new ArrayList<PrRubroVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select  desHijo as des from (");
            sql.append("  select distinct rubro.descripcion as desHijo from sii_cdp cdp");
            sql.append("  inner join sii_detalle_rubro_cdp drc on drc.cdp_codigo=cdp.cdp_codigo");
            sql.append(" inner join sii_detalle_rubro dru on drc.dru_codigo=dru.dru_codigo");
            sql.append(" inner join pr_rubro rubro on dru.vigencia=rubro.vigencia and dru.interno=rubro.interno");
            sql.append(" where cdp.cdp_codigo = #idCdp  and drc.dru_Valor > 0)");
            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("idCdp", idCdp);
            List<String> results = query.getResultList();
            for(String object : results) {
                PrRubroVO prRubroVo = new PrRubroVO();
                prRubroVo.setDescripcion(((String) object));
                ListaPrRubroVo.add(prRubroVo);
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return ListaPrRubroVo;
    }

    public BigDecimal valorActualApropiadoPorRubrosCdp(Long cdpCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("WITH r AS\n" + "  (SELECT DISTINCT drc.DRU_CODIGO\n" + "  FROM sii_detalle_rubro_cdp drc\n" + "  WHERE drc.CDP_CODIGO = #cdpCodigo  )\n" + "SELECT NVL(SUM(valor),0)\n" +
                       "FROM\n" + "  (SELECT mpd.MPD_VALOR valor\n" + "  FROM sii_mod_pres_det_rubro mpd,\n" + "    sii_modific_presup mpr,\n" + "    sii_estado_modif_presup emp,\n" + "    r\n" +
                       "  WHERE mpd.MPR_CODIGO       = mpr.MPR_CODIGO\n" + "  AND mpr.EMP_CODIGO         = emp.EMP_CODIGO\n" + "  AND (mpd.DRU_CODIGO_ORIGEN = r.DRU_CODIGO\n" +
                       "  AND mpr.MPR_TIPO           = 'A'\n" + "  AND emp.EMP_NOMBRE         = 'AUTORIZADO')\n" + "  UNION\n" + "  SELECT -mpd.MPD_VALOR valor\n" +
                       "  FROM sii_mod_pres_det_rubro mpd,\n" + "    sii_modific_presup mpr,\n" + "    sii_estado_modif_presup emp,\n" + "    r\n" + "  WHERE mpd.MPR_CODIGO       = mpr.MPR_CODIGO\n" +
                       "  AND mpr.EMP_CODIGO         = emp.EMP_CODIGO\n" + "  AND (mpd.DRU_CODIGO_ORIGEN = r.DRU_CODIGO\n" + "  AND mpr.MPR_TIPO           = 'R'\n" +
                       "  AND emp.EMP_NOMBRE         = 'AUTORIZADO')\n" + "  UNION\n" + "  SELECT -mpd.MPD_VALOR valor\n" + "  FROM sii_mod_pres_det_rubro mpd,\n" + "    sii_modific_presup mpr,\n" +
                       "    sii_estado_modif_presup emp,\n" + "    r\n" + "  WHERE mpd.MPR_CODIGO       = mpr.MPR_CODIGO\n" + "  AND mpr.EMP_CODIGO         = emp.EMP_CODIGO\n" +
                       "  AND (mpd.DRU_CODIGO_ORIGEN = r.DRU_CODIGO\n" + "  AND mpr.MPR_TIPO           = 'T'\n" + "  AND emp.EMP_NOMBRE         = 'AUTORIZADO')\n" + "  UNION\n" +
                       "  SELECT mpd.MPD_VALOR valor\n" + "  FROM sii_mod_pres_det_rubro mpd,\n" + "    sii_modific_presup mpr,\n" + "    sii_estado_modif_presup emp,\n" + "    r\n" +
                       "  WHERE mpd.MPR_CODIGO        = mpr.MPR_CODIGO\n" + "  AND mpr.EMP_CODIGO          = emp.EMP_CODIGO\n" + "  AND (mpd.DRU_CODIGO_DESTINO = r.DRU_CODIGO\n" +
                       "  AND mpr.MPR_TIPO            = 'T'\n" + "  AND emp.EMP_NOMBRE          = 'AUTORIZADO')\n" + "  )");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("cdpCodigo", cdpCodigo);
            return (BigDecimal) query.getSingleResult();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public BigDecimal valorActualComprometidoPorRubrosCdp(Long cdpCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("WITH r AS\n" + "  (SELECT DISTINCT drc.DRU_CODIGO\n" + "  FROM sii_detalle_rubro_cdp drc\n" + "  WHERE drc.CDP_CODIGO = #cdpCodigo)\n" + "SELECT sum(valor)\n" + "FROM\n" +
                       "  (SELECT drc.DRU_VALOR valor\n" + "  FROM sii_detalle_rubro_cdp drc\n" + "  INNER JOIN r\n" + "  ON r.DRU_CODIGO = drc.DRU_CODIGO\n" + "  INNER JOIN sii_cdp cdp\n" +
                       "  ON drc.CDP_CODIGO = cdp.CDP_CODIGO\n" + "  INNER JOIN sii_estado_cdp ecd\n" + "  ON cdp.ECD_CODIGO    = ecd.ECD_CODIGO\n" + "  WHERE ecd.ECD_NOMBRE = 'CDP APROBADO'\n" +
                       "  UNION ALL\n" + "  SELECT mcr.MCR_VALOR\n" + "  FROM sii_modif_cdp_det_rub_cdp mcr\n" + "  INNER JOIN sii_detalle_rubro_cdp dcr\n" + "  ON mcr.DRC_CODIGO = dcr.DRC_CODIGO\n" +
                       "  INNER JOIN r\n" + "  ON r.DRU_CODIGO = dcr.DRU_CODIGO\n" + "  INNER JOIN sii_modificacion_cdp mcd\n" + "  ON mcd.MCD_codigo = mcr.MCD_CODIGO\n" +
                       "  INNER JOIN sii_estado_modif_cdp emc\n" + "  ON mcd.EMC_CODIGO      = emc.EMC_CODIGO\n" + "  WHERE mcd.MCD_TIPO_MOD = 'I'\n" + "  AND emc.EMC_NOMBRE     = 'APROBADO'\n" +
                       "  UNION ALL\n" + "  SELECT -mcr.MCR_VALOR\n" + "  FROM sii_modif_cdp_det_rub_cdp mcr\n" + "  INNER JOIN sii_detalle_rubro_cdp dcr\n" +
                       "  ON mcr.DRC_CODIGO = dcr.DRC_CODIGO\n" + "  INNER JOIN sii_modificacion_cdp mcd\n" + "  ON mcr.MCD_CODIGO = mcd.MCD_CODIGO\n" + "  INNER JOIN sii_estado_modif_cdp emc\n" +
                       "  ON mcd.EMC_CODIGO = emc.EMC_CODIGO\n" + "  INNER JOIN r\n" + "  ON dcr.DRU_CODIGO      = r.DRU_CODIGO\n" + "  WHERE mcd.MCD_TIPO_MOD = 'D'\n" +
                       "  AND emc.EMC_NOMBRE     = 'APROBADO'\n" + "  )");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("cdpCodigo", cdpCodigo);
            return (BigDecimal) query.getSingleResult();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }


    public List<SiiDetalleRubroCdp> buscarDetalleRubroCdpPorCdpCodigo(Long cdpCodigo) throws ExcepcionDAO {
        List<SiiDetalleRubroCdp> listaSiiDetalleRubroCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDetalleRubroCdp o WHERE o.siiCdp.cdpCodigo = :cdpCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cdpCodigo", cdpCodigo);
            listaSiiDetalleRubroCdp = query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleRubroCdp;
    }

    public BigDecimal valorEjecutadoCdp(Long cdpConsecutivo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(rdr.rdrValor) FROM SiiCdp o\n" + "INNER JOIN o.siiDetalleRubroCdpList drc\n" + "INNER JOIN drc.siiRpDetRubroCdpList rdr\n" + "INNER JOIN rdr.siiRp rp\n" +
                       "INNER JOIN rp.siiEstadoRp erp\n" + "WHERE o.cdpConsecutivo = :cdpConsecutivo\n" + "AND erp.erpNombre = 'RP APROBADO'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cdpConsecutivo", cdpConsecutivo);
            BigDecimal valorRpDetRubroCdp = (BigDecimal) query.getSingleResult();
            valorRpDetRubroCdp = valorRpDetRubroCdp == null ? BigDecimal.ZERO : valorRpDetRubroCdp;

            sql = new StringBuilder();
            sql.append("SELECT SUM(mrd.mrdValor) FROM SiiCdp o\n" + "INNER JOIN o.siiDetalleRubroCdpList drc\n" + "INNER JOIN drc.siiRpDetRubroCdpList rdr\n" +
                       "INNER JOIN rdr.siiModifRpDetRubCdpList1 mrd\n" + "INNER JOIN mrd.siiModificacionRp mrp\n" + "INNER JOIN mrp.siiEstadoModificRp emr\n" +
                       "WHERE o.cdpConsecutivo = :cdpConsecutivo\n" + "AND emr.emrNombre = 'APROBADO'\n" + "AND mrp.mrpTipoModif = 'I'");
            query = manager.createQuery(sql.toString());
            query.setParameter("cdpConsecutivo", cdpConsecutivo);
            BigDecimal valorIncRpDetRubCdp = (BigDecimal) query.getSingleResult();
            valorIncRpDetRubCdp = valorIncRpDetRubCdp == null ? BigDecimal.ZERO : valorIncRpDetRubCdp;

            sql = new StringBuilder();
            sql.append("SELECT SUM(mrd.mrdValor) FROM SiiCdp o\n" + "INNER JOIN o.siiDetalleRubroCdpList drc\n" + "INNER JOIN drc.siiRpDetRubroCdpList rdr\n" +
                       "INNER JOIN rdr.siiModifRpDetRubCdpList1 mrd\n" + "INNER JOIN mrd.siiModificacionRp mrp\n" + "INNER JOIN mrp.siiEstadoModificRp emr\n" +
                       "WHERE o.cdpConsecutivo = :cdpConsecutivo\n" + "AND emr.emrNombre = 'APROBADO'\n" + "AND mrp.mrpTipoModif = 'D'");
            query = manager.createQuery(sql.toString());
            query.setParameter("cdpConsecutivo", cdpConsecutivo);
            BigDecimal valorDecRpDetRubCdp = (BigDecimal) query.getSingleResult();
            valorDecRpDetRubCdp = valorDecRpDetRubCdp == null ? BigDecimal.ZERO : valorDecRpDetRubCdp;

            return valorRpDetRubroCdp.add(valorIncRpDetRubCdp).subtract(valorDecRpDetRubCdp);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CdpDAO");
        }
    }

    public List<SiiCdp> buscarCdpsPorItemPlanCont(Long ipcCodigo) throws ExcepcionDAO {
        List<SiiCdp> listaCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cdp FROM SiiCdp cdp WHERE cdp.siiItemPlanContratac.ipcCodigo = :ipcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("ipcCodigo", ipcCodigo);
            listaCdp = query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCdp;
    }
}
