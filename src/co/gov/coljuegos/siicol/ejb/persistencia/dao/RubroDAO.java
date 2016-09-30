/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrRubroPK;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteEjecucionPreGastosVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroDetalleFuenteVO;

import java.math.BigDecimal;

import java.util.ArrayList;
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
public class RubroDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public RubroDAO() {
        recursos = new Recursos();
    }

    public PrRubro insertarPrRubro(PrRubro prRubro) throws ExcepcionDAO {
        try {
            manager.persist(prRubro);
            manager.flush();
            return prRubro;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        }
    }

    public PrRubro buscarPorInternoRubroVig(PrRubroPK unRubroPk) throws ExcepcionDAO {
        PrRubro prRubroRetorno = null;
        try {
            //prRubroRetorno = manager.find(PrRubro.class, new PrRubroPK(prRubro.getInterno(), prRubro.getVigencia()));
            prRubroRetorno = manager.find(PrRubro.class, unRubroPk);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        }
        return prRubroRetorno;
    }

    public PrRubro actualizarPrRubro(PrRubro prRubro) throws ExcepcionDAO {
        try {
            manager.merge(prRubro); //La guarda en el almacen
            manager.flush(); //Pasa a la Bd
            return prRubro;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        }
    }

    public List<PrRubro> buscarTodoPrRubro() throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rubro FROM PrRubro rubro");
            Query query = manager.createQuery(sql.toString());
            List<PrRubro> listaEntidadesRubro = query.getResultList();

            return listaEntidadesRubro;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        }
    }

    public List<PrRubro> buscarTodoPrRubroVigencia(PrRubro prRubro) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rubro FROM PrRubro rubro");
            sql.append(" WHERE rubro.vigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", prRubro.getVigencia());
            List<PrRubro> listaEntidadRubro = query.getResultList();

            return listaEntidadRubro;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        }
    }

    public List<RubroDetalleFuenteVO> buscarTodoRubroFuenteDetalle(Integer vigencia) throws ExcepcionDAO {
        List<RubroDetalleFuenteVO> listaRubroFuenteDetalleVo = new ArrayList<RubroDetalleFuenteVO>();
        try {
            StringBuilder sql = new StringBuilder();
            /* sql.append("SELECT a.descripcion,a.interno,d.dff_descripcion, d.dff_codigo,b.dru_valor,b.dru_codigo,c.ffi_descripcion ");
            sql.append(" FROM pr_rubro a,sii_detalle_rubro b, sii_fuente_financiacion c,sii_dtlle_fuente_financiacion d");
            sql.append(" WHERE a.interno = b.interno ");
            sql.append(" AND b.dff_codigo= d.dff_codigo");
            sql.append(" AND c.ffi_codigo=d.ffi_codigo");
            sql.append(" AND a.vigencia =b.vigencia"); */

            //Por Diego Alvarado: Cambiada la consulta a inner join
            sql.append("SELECT rub.descripcion,rub.interno,dtlleFte.dff_descripcion, dtlleFte.dff_codigo,");
            sql.append(" detRub.dru_valor,detRub.dru_codigo,fte.ffi_descripcion");
            sql.append(" FROM pr_rubro rub");
            sql.append(" INNER JOIN sii_detalle_rubro detRub ON rub.interno = detRub.interno AND rub.vigencia = detRub.vigencia");
            sql.append(" INNER JOIN sii_dtlle_fuente_financiacion dtlleFte ON detRub.dff_codigo = dtlleFte.dff_codigo");
            sql.append(" INNER JOIN sii_fuente_financiacion fte ON fte.ffi_codigo = dtlleFte.ffi_codigo");
            sql.append(" INNER JOIN PR_NIVEL1 N1 ON N1.INTERNO = RUB.INTERNO_NIVEL1");
            sql.append(" WHERE detRub.dru_valor <>0 AND N1.CODIGO=2");
            sql.append(" AND rub.vigencia = #vigencia");
            sql.append(" ORDER BY rub.descripcion DESC");

            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("vigencia", vigencia);

            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                RubroDetalleFuenteVO rfdVo = new RubroDetalleFuenteVO();
                rfdVo.setDetRubro((String) object[0]); // Detalle Rubro
                rfdVo.setIdRubro(((BigDecimal) object[1]).longValue()); //Id Rubro
                rfdVo.setDtlleFuente((String) object[2]); // Descripcion Detalle fuente
                rfdVo.setIdDetalleFuente(((BigDecimal) object[3]).longValue()); //Id detalle fuente
                rfdVo.setValor((BigDecimal) object[4]); // Valor
                rfdVo.setIdDetalleRubro(((BigDecimal) object[5]).longValue()); //Id detalle Rubro
                rfdVo.setDesFuente((String) object[6]); // Descripcion fuente

                listaRubroFuenteDetalleVo.add(rfdVo);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
        return listaRubroFuenteDetalleVo;
    }

    public List<RubroDetalleFuenteVO> buscarTodoRubroDetallePorFteNacion(Integer vigencia) throws ExcepcionDAO {
        List<RubroDetalleFuenteVO> listaRubroFuenteDetalleNacionVo = new ArrayList<RubroDetalleFuenteVO>();
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT rub.descripcion,rub.interno,dtlleFte.dff_descripcion, dtlleFte.dff_codigo,");
            sql.append(" detRub.dru_valor,detRub.dru_codigo,fte.ffi_descripcion");
            sql.append(" FROM pr_rubro rub");
            sql.append(" INNER JOIN sii_detalle_rubro detRub ON rub.interno = detRub.interno AND rub.vigencia = detRub.vigencia");
            sql.append(" INNER JOIN sii_dtlle_fuente_financiacion dtlleFte ON detRub.dff_codigo = dtlleFte.dff_codigo");
            sql.append(" INNER JOIN sii_fuente_financiacion fte ON fte.ffi_codigo = dtlleFte.ffi_codigo");
            sql.append(" INNER JOIN PR_NIVEL1 N1 ON N1.INTERNO = RUB.INTERNO_NIVEL1");
            sql.append(" WHERE detRub.dru_valor <>0 AND N1.CODIGO=2");
            sql.append(" AND rub.vigencia = #vigencia");
            sql.append(" AND fte.Ffi_descripcion = 'RECURSOS NACIÓN'");
            sql.append(" ORDER BY rub.descripcion DESC");

            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("vigencia", vigencia);

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                RubroDetalleFuenteVO rfdnVo = new RubroDetalleFuenteVO();
                rfdnVo.setDetRubro((String) object[0]); // Detalle Rubro
                rfdnVo.setIdRubro(((BigDecimal) object[1]).longValue()); //Id Rubro
                rfdnVo.setDtlleFuente((String) object[2]); // Descripcion Detalle fuente
                rfdnVo.setIdDetalleFuente(((BigDecimal) object[3]).longValue()); //Id detalle fuente
                rfdnVo.setValor((BigDecimal) object[4]); // Valor
                rfdnVo.setIdDetalleRubro(((BigDecimal) object[5]).longValue()); //Id detalle Rubro
                rfdnVo.setDesFuente((String) object[6]); // Descripcion fuente

                listaRubroFuenteDetalleNacionVo.add(rfdnVo);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
        return listaRubroFuenteDetalleNacionVo;
    }

    public PrRubroVO buscarRubroPorNiveles(Integer vigencia, String cadena) throws ExcepcionDAO {
        PrRubroVO rubroVo = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT INTERNO FROM(");
            sql.append("SELECT TO_CHAR(N1.CODIGO) || '.' || TO_CHAR(N2.CODIGO) || '.' || TO_CHAR(N3.CODIGO)");
            sql.append("|| '.' || TO_CHAR(N4.CODIGO) || '.' || TO_CHAR(N5.CODIGO) || '.' || TO_CHAR(N6.CODIGO) ");
            sql.append("|| '.' || TO_CHAR(N7.CODIGO) || '.' || TO_CHAR(N8.CODIGO) || '.' AS CADENA, RUB.INTERNO AS INTERNO");
            sql.append(" FROM PR_RUBRO RUB");
            sql.append(" LEFT JOIN PR_NIVEL1 N1 ON N1.INTERNO = RUB.INTERNO_NIVEL1");
            sql.append(" LEFT JOIN PR_NIVEL2 N2 ON N2.INTERNO = RUB.INTERNO_NIVEL2");
            sql.append(" LEFT JOIN PR_NIVEL3 N3 ON N3.INTERNO = RUB.INTERNO_NIVEL3");
            sql.append(" LEFT JOIN PR_NIVEL4 N4 ON N4.INTERNO = RUB.INTERNO_NIVEL4");
            sql.append(" LEFT JOIN PR_NIVEL5 N5 ON N5.INTERNO = RUB.INTERNO_NIVEL5");
            sql.append(" LEFT JOIN PR_NIVEL6 N6 ON N6.INTERNO = RUB.INTERNO_NIVEL6");
            sql.append(" LEFT JOIN PR_NIVEL7 N7 ON N7.INTERNO = RUB.INTERNO_NIVEL7");
            sql.append(" LEFT JOIN PR_NIVEL8 N8 ON N8.INTERNO = RUB.INTERNO_NIVEL8");
            sql.append(" WHERE RUB.VIGENCIA = #vigencia)");
            sql.append(" WHERE CADENA = #cadena");

            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("vigencia", vigencia);
            query.setParameter("cadena", cadena);

            List<Object> results = query.getResultList();
            for (Object object : results) {
                rubroVo = new PrRubroVO();
                rubroVo.setInterno(((BigDecimal) object).longValue());
                break;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
        return rubroVo;
    }

    public ReporteEjecucionPreGastosVO buscarPresupuestoAprobadoXidRubro(String idRubro) throws ExcepcionDAO {
        ReporteEjecucionPreGastosVO reporteEjecucionPreGastosVo = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select  sum( (sum(dru_valor+ADICIONES)-sum(REDUCCIONES))- (sum(CREDITOS+CONTRACREDITOS))) as APROBADO from(");
            sql.append(" SELECT  dru.dru_codigo ,dru.dru_valor,");
            sql.append(" (SELECT NVL(SUM(mpdr_destino.mpd_valor), 0) FROM SII_MOD_PRES_DET_RUBRO mpdr_destino, SII_MODIFIC_PRESUP mp WHERE mp.mpr_codigo=mpdr_destino.mpr_codigo AND mp.emp_codigo=3 AND mp.mpr_tipo='T' AND mpdr_destino.dru_codigo_destino=dru.dru_codigo) AS CREDITOS, ");
            sql.append(" (SELECT NVL(SUM(mpdr_origen.mpd_valor), 0) FROM SII_MOD_PRES_DET_RUBRO mpdr_origen, SII_MODIFIC_PRESUP mp WHERE mp.mpr_codigo=mpdr_origen.mpr_codigo AND mp.emp_codigo=3 AND mp.mpr_tipo='T' AND mpdr_origen.dru_codigo_origen=dru.dru_codigo) AS CONTRACREDITOS,");
            sql.append(" (SELECT NVL(SUM(mpdr.mpd_valor), 0) FROM SII_MOD_PRES_DET_RUBRO mpdr, SII_MODIFIC_PRESUP mp WHERE mp.mpr_codigo=mpdr.mpr_codigo AND mp.emp_codigo=3 AND mp.mpr_tipo='A' AND mpdr.dru_codigo_destino=dru.dru_codigo) AS ADICIONES,");
            sql.append(" (SELECT NVL(SUM(mpdr.mpd_valor), 0) FROM SII_MOD_PRES_DET_RUBRO mpdr, SII_MODIFIC_PRESUP mp WHERE mp.mpr_codigo=mpdr.mpr_codigo AND mp.emp_codigo=3 AND mp.mpr_tipo='R' AND mpdr.dru_codigo_destino=dru.dru_codigo) AS REDUCCIONES");
            sql.append(" FROM SII_DETALLE_RUBRO dru");
            sql.append(" WHERE dru.dru_codigo= #idRubro)");
            sql.append(" group by 1");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRubro", idRubro);

            Object results = query.getSingleResult();

            reporteEjecucionPreGastosVo = new ReporteEjecucionPreGastosVO();
            reporteEjecucionPreGastosVo.setPreAprobado(((BigDecimal) results));


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
        return reporteEjecucionPreGastosVo;
    }

    public ReporteEjecucionPreGastosVO buscarCDPAprobadoXidRubro(long idRubro, String fechaIni,
                                                                 String fechaFin) throws ExcepcionDAO {
        ReporteEjecucionPreGastosVO reporteEjecucionPreGastosVo = null;
        BigDecimal temp = new BigDecimal(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT SUM(det.dru_valor)as CDPEXPEDIDOS FROM sii_cdp cdp");
            sql.append(" INNER JOIN sii_estado_cdp est on cdp.ecd_codigo=est.ecd_codigo");
            sql.append(" inner join sii_detalle_rubro_cdp det on cdp.cdp_codigo=det.cdp_codigo");
            sql.append(" inner join sii_rp_det_rubro_cdp rdr  on rdr.drc_codigo = det.drc_codigo ");
            sql.append(" inner join sii_rp rp on rp.rp_codigo = rdr.rp_codigo");
            sql.append(" WHERE rp.rp_fecha_solic between  to_date(#fechaIni) and to_date(#fechaFin)  and  det.dru_codigo= #idRubro and est.ecd_nombre='CDP APROBADO'");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRubro", idRubro);
            query.setParameter("fechaIni", fechaIni);
            query.setParameter("fechaFin", fechaFin);

            List<Object> results = query.getResultList();
            for (Object object : results) {
                reporteEjecucionPreGastosVo = new ReporteEjecucionPreGastosVO();
                if (object != null)
                    reporteEjecucionPreGastosVo.setCerExpedidos(((BigDecimal) object));
                else
                    reporteEjecucionPreGastosVo.setCerExpedidos(temp);
                break;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
        return reporteEjecucionPreGastosVo;
    }

    public ReporteEjecucionPreGastosVO buscarRPAprobadoXidRubro(String idRubro, String fechaIni,
                                                                String fechafin) throws ExcepcionDAO {

        ReporteEjecucionPreGastosVO reporteEjecucionPreGastosVo = null;
        BigDecimal temp = new BigDecimal(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select sum (rdr.rdr_valor) AS RPEXPEDIDOS from sii_rp rp");
            sql.append(" inner join sii_estado_rp est on rp.erp_codigo=est.erp_codigo");
            sql.append(" inner join sii_rp_det_rubro_cdp rdr  on rp.rp_codigo=rdr.rp_codigo");
            sql.append(" inner join sii_detalle_rubro_cdp drc on rdr.drc_codigo=drc.drc_codigo");
            sql.append(" where est.erp_nombre='RP APROBADO' and drc.dru_codigo= #idRubro and  rp.rp_fecha_solic between  to_date(#fechaIni) and to_date(#fechafin)");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRubro", idRubro);
            query.setParameter("fechaIni", fechaIni);
            query.setParameter("fechafin", fechafin);

            List<Object> results = query.getResultList();
            for (Object object : results) {
                reporteEjecucionPreGastosVo = new ReporteEjecucionPreGastosVO();
                if (object != null)
                    reporteEjecucionPreGastosVo.setRegExpedidos(((BigDecimal) object));
                else
                    reporteEjecucionPreGastosVo.setRegExpedidos(temp);
                break;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
        return reporteEjecucionPreGastosVo;
    }

    public ReporteEjecucionPreGastosVO buscarObligacionesAprobadoXidRubro(String idRubro, String fechaIni,
                                                                          String fechafin) throws ExcepcionDAO {
        ReporteEjecucionPreGastosVO reporteEjecucionPreGastosVo = null;
        BigDecimal temp = new BigDecimal(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select sum(spa.spa_valor_cuenta) AS OBLEXPEDIDAS from sii_obligacion obl");
            sql.append(" inner join sii_estado_obligacion eob on obl.eob_codigo=eob.eob_codigo");
            sql.append(" inner join  sii_solicitud_pago spa on obl.spa_codigo=spa.spa_codigo");
            sql.append(" inner join sii_rp rp on spa.rp_codigo=rp.rp_codigo");
            sql.append(" inner join sii_rp_det_rubro_cdp rdr  on rp.rp_codigo=rdr.rp_codigo");
            sql.append(" inner join sii_detalle_rubro_cdp drc on rdr.drc_codigo=drc.drc_codigo");
            sql.append(" where eob.eob_nombre='APROBADO' and  rp.rp_fecha_solic between  to_date(#fechaIni) and to_date(#fechafin) and drc.dru_codigo= #idRubro");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRubro", idRubro);
            query.setParameter("fechaIni", fechaIni);
            query.setParameter("fechafin", fechafin);

            List<Object> results = query.getResultList();
            for (Object object : results) {
                reporteEjecucionPreGastosVo = new ReporteEjecucionPreGastosVO();
                if (object != null)
                    reporteEjecucionPreGastosVo.setObliExpedidos(((BigDecimal) object));
                else
                    reporteEjecucionPreGastosVo.setObliExpedidos(temp);
                break;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
        return reporteEjecucionPreGastosVo;
    }

    public ReporteEjecucionPreGastosVO buscarPagosAprobadasXidRubro(String idRubro, String fechaIni,
                                                                    String fechafin) throws ExcepcionDAO {
        ReporteEjecucionPreGastosVO reporteEjecucionPreGastosVo = null;
        BigDecimal temp = new BigDecimal(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select sum(spa.spa_valor_cuenta) AS PAGOS from sii_orden_pago orp");
            sql.append(" inner join sii_estado_orden_pago est on orp.eop_codigo=est.eop_codigo ");
            sql.append(" inner join sii_obligacion obl on orp.obl_codigo=obl.obl_codigo");
            sql.append(" inner join  sii_solicitud_pago spa on obl.spa_codigo=spa.spa_codigo");
            sql.append(" inner join sii_rp rp on spa.rp_codigo=rp.rp_codigo");
            sql.append(" inner join sii_rp_det_rubro_cdp rdr  on rp.rp_codigo=rdr.rp_codigo");
            sql.append(" inner join sii_detalle_rubro_cdp drc on rdr.drc_codigo=drc.drc_codigo");
            sql.append(" where est.eop_nombre='PAGADA' and rp.rp_fecha_solic between  to_date(#fechaIni) and to_date(#fechaFin)  and drc.dru_codigo= #idRubro");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRubro", idRubro);

            List<Object> results = query.getResultList();
            for (Object object : results) {
                reporteEjecucionPreGastosVo = new ReporteEjecucionPreGastosVO();
                if (object != null)
                    reporteEjecucionPreGastosVo.setTotalPago(((BigDecimal) object));
                else
                    reporteEjecucionPreGastosVo.setTotalPago(temp);
                break;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
        return reporteEjecucionPreGastosVo;
    }

    public PrRubro buscarRubroPorVigenciaCodigo(Integer vigencia, String unidad, String tipo, String cuenta,
                                                String subcuenta, String objeto, String ordinal,
                                                String subordinal) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM PrRubro o ");
            sql.append(" WHERE o.vigencia = :vigencia ");
            sql.append(" AND o.internoNivel1 = :internoNivel1 ");
            sql.append(" AND o.internoNivel2 = :internoNivel2 ");
            sql.append(" AND o.internoNivel3 = :internoNivel3 ");
            sql.append(" AND o.internoNivel4 = :internoNivel4 ");
            sql.append(" AND o.internoNivel5 = :internoNivel5 ");
            sql.append(" AND o.internoNivel6 = :internoNivel6 ");
            sql.append(" AND o.internoNivel7 = :internoNivel7 ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            query.setParameter("internoNivel1", buscarInternoNivel(vigencia, unidad, 1));
            query.setParameter("internoNivel2", buscarInternoNivel(vigencia, tipo, 2));
            query.setParameter("internoNivel3", buscarInternoNivel(vigencia, cuenta, 3));
            query.setParameter("internoNivel4", buscarInternoNivel(vigencia, subcuenta, 4));
            query.setParameter("internoNivel5", buscarInternoNivel(vigencia, objeto, 5));
            query.setParameter("internoNivel6", buscarInternoNivel(vigencia, ordinal, 6));
            query.setParameter("internoNivel7", buscarInternoNivel(vigencia, subordinal, 7));
            //query.setParameter("internoNivel8", buscarInternoNivel(vigencia,unidad,8));
            return (PrRubro) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        }


    }

    private Long buscarInternoNivel(Integer vigencia, String codigo, Integer nivel) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o.interno FROM PrNivel" + nivel + " o ");
            sql.append(" WHERE o.vigencia = :vigencia AND o.codigo = :codigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            query.setParameter("codigo", codigo);
            return (Long) query.getSingleResult();
        } catch (PersistenceException pe) {
            return null;
        }
    }

    public Long buscarRubroPorVigenciaCodigoNiveles(Integer vigencia, String unidad, String tipo, String cuenta,
                                                    String subcuenta, String objeto, String ordinal,
                                                    String subordinal) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT RUB.INTERNO\n" + "FROM PR_RUBRO RUB\n" + "LEFT JOIN PR_NIVEL1 N1\n" +
                       "ON RUB.INTERNO_NIVEL1 = N1.INTERNO\n" + "LEFT JOIN PR_NIVEL2 N2\n" +
                       "ON RUB.INTERNO_NIVEL2 = N2.INTERNO\n" + "LEFT JOIN PR_NIVEL3 N3\n" +
                       "ON RUB.INTERNO_NIVEL3 = N3.INTERNO\n" + "LEFT JOIN PR_NIVEL4 N4\n" +
                       "ON RUB.INTERNO_NIVEL4 = N4.INTERNO\n" + "LEFT JOIN PR_NIVEL5 N5\n" +
                       "ON RUB.INTERNO_NIVEL5 = N5.INTERNO\n" + "LEFT JOIN PR_NIVEL6 N6\n" +
                       "ON RUB.INTERNO_NIVEL6 = N6.INTERNO\n" + "LEFT JOIN PR_NIVEL7 N7\n" +
                       "ON RUB.INTERNO_NIVEL7     = N7.INTERNO\n" + "WHERE RUB.VIGENCIA        = #vigencia\n" +
                       "AND N1.CODIGO             = #unidad\n" + "AND NVL(#tipo, 'x')       = NVL(N2.CODIGO, 'x')\n" +
                       "AND NVL(#cuenta, 'x')     = NVL(N3.CODIGO, 'x')\n" +
                       "AND NVL(#subcuenta, 'x')  = NVL(N4.CODIGO, 'x')\n" +
                       "AND NVL(#objeto, 'x')     = NVL(N5.CODIGO, 'x')\n" +
                       "AND NVL(#ordinal, 'x')    = NVL(N6.CODIGO, 'x')\n" +
                       "AND NVL(#subordinal, 'x') = NVL(N7.CODIGO, 'x')");

            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("vigencia", vigencia);
            query.setParameter("unidad", unidad);
            query.setParameter("tipo", tipo);
            query.setParameter("cuenta", cuenta);
            query.setParameter("subcuenta", subcuenta);
            query.setParameter("objeto", objeto);
            query.setParameter("ordinal", ordinal);
            query.setParameter("subordinal", subordinal);
            BigDecimal codigo = (BigDecimal) query.getSingleResult();
            return  codigo.longValue();

        } catch (EntityNotFoundException eNf) {
            return null;
        } catch (NoResultException nRe) {
            return null;
        } catch (PersistenceException pe) { //EntityExistsException, EntityNotFoundException, NonUniqueResultException, NoResultException
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RubroDAO");
        }
    }

    /**
     * @author Giovanni
     * @param prRubroPK
     * @return
     * @throws ExcepcionDAO
     */
    public Object[] buscarCodigoRubroXVigenciaXInterno(PrRubroPK prRubroPK) throws ExcepcionDAO {
       Object[] infoRubro = null;

        try {

            StringBuilder sql = new StringBuilder();

            sql.append("SELECT uni.codigo AS uni, tip.codigo AS tip, cta.codigo AS cta, scta.codigo AS scta, obj.codigo AS obj, ord.codigo AS ord, sord.codigo AS sord, prr.descripcion");
            sql.append(" FROM pr_rubro prr");
            sql.append(" LEFT JOIN pr_nivel1 uni ON prr.interno_nivel1 = uni.interno AND prr.vigencia = uni.vigencia");
            sql.append(" LEFT JOIN pr_nivel2 tip ON prr.interno_nivel2 = tip.interno AND prr.vigencia = tip.vigencia");
            sql.append(" LEFT JOIN pr_nivel3 cta ON prr.interno_nivel3 = cta.interno AND prr.vigencia = cta.vigencia");
            sql.append(" LEFT JOIN pr_nivel4 scta ON prr.interno_nivel4 = scta.interno AND prr.vigencia = scta.vigencia");
            sql.append(" LEFT JOIN pr_nivel5 obj ON prr.interno_nivel5 = obj.interno AND prr.vigencia = obj.vigencia");
            sql.append(" LEFT JOIN pr_nivel6 ord ON prr.interno_nivel6 = ord.interno AND prr.vigencia = ord.vigencia");
            sql.append(" LEFT JOIN pr_nivel7 sord ON prr.interno_nivel7 = sord.interno AND prr.vigencia = sord.vigencia");
            sql.append(" WHERE prr.interno = #interno");
            sql.append(" AND prr.vigencia = #vigencia");
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("interno", prRubroPK.getInterno());
            query.setParameter("vigencia", prRubroPK.getVigencia());
            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                infoRubro = results.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RubroDAO");
        }

        return infoRubro;
    }

}
