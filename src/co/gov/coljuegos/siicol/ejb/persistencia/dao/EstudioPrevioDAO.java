package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioPrevio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.RubroEstudioPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleIPCVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudDetalleRubroCdpVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstudioPrevioDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstudioPrevioDAO() {
        recursos = new Recursos();
    }

    public SiiEstudioPrevio insertarEstudioPrevio(SiiEstudioPrevio estudioPrevio) throws ExcepcionDAO {
        try {
            manager.persist(estudioPrevio);
            manager.flush();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return estudioPrevio;
    }

    public SiiEstudioPrevio buscarEstudioPrevioPorId(Long idEstudioPrevio) throws ExcepcionDAO {
        SiiEstudioPrevio estudioPrevio = null;
        try {
            estudioPrevio = manager.find(SiiEstudioPrevio.class, idEstudioPrevio);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return estudioPrevio;
    }

    public SiiEstudioPrevio actualizarEstudioPrevio(SiiEstudioPrevio estudioPrevio) throws ExcepcionDAO {
        try {
            manager.merge(estudioPrevio);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return estudioPrevio;
    }


    public List<SiiEstudioPrevio> buscarTodosEstudioPrevio() throws ExcepcionDAO {
        List<SiiEstudioPrevio> listaEstudioPrevio = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT estPrev FROM SiiEstudioPrevio estPrev order by estPrev.siiProcesoContratacion.prcCodigo desc");
            Query query = manager.createQuery(sql.toString());
            listaEstudioPrevio = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaEstudioPrevio;
    }

    public List<RubroFuenteDetalleIPCVO> buscarRubroFuenteDetallePorItemPlanContratac(Long idItemPlanContratac) throws ExcepcionDAO {
        List<RubroFuenteDetalleIPCVO> listaRubroFuenteDetalleIPCVo = new ArrayList<RubroFuenteDetalleIPCVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ff.ffi_codigo, ff.ffi_codigo_fuente, ff.ffi_nombre, ff.ffi_Descripcion, dff.dff_codigo, dff.ffi_codigo, dff.dff_descripcion, dr.dru_codigo,");
            sql.append(" (TO_CHAR(r.interno_nivel1) || (case when r.interno_nivel2 is null then '' else '.' || TO_CHAR(r.interno_nivel2) end) || (case when r.interno_nivel3 is null then '' else '.' || TO_CHAR(r.interno_nivel3) end) || (case when r.interno_nivel4 is null then '' else '.' || TO_CHAR(r.interno_nivel4) end) || (case when r.interno_nivel5 is null then '' else '.' || TO_CHAR(r.interno_nivel5) end) || (case when r.interno_nivel6 is null then '' else '.' || TO_CHAR(r.interno_nivel6) end) || (case when r.interno_nivel7 is null then '' else '.' || TO_CHAR(r.interno_nivel7) end) || (case when r.interno_nivel8 is null then '' else '.' || TO_CHAR(r.interno_nivel8) end)) as codigoRubro, ");
            sql.append(" r.descripcion, dr.dru_valor, dr.vigencia, r.interno");
            sql.append(" FROM sii_item_plan_cont_det_rub ipcdr");
            sql.append(" INNER JOIN sii_detalle_rubro dr ON (ipcdr.dru_codigo = dr.dru_codigo)");
            sql.append(" INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo)");
            sql.append(" INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo)");
            sql.append(" INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia)");
            sql.append(" WHERE ipcdr.ipc_codigo = #idIPC");
            sql.append(" ORDER BY codigoRubro");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idIPC", idItemPlanContratac);

            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                RubroFuenteDetalleIPCVO rfdIPCVo = new RubroFuenteDetalleIPCVO();
                rfdIPCVo.setFfiCodigo(((BigDecimal) object[0]).longValue());
                rfdIPCVo.setFfi_codigo_fuente(((BigDecimal) object[1]).longValue());
                rfdIPCVo.setFfiNombre((String) object[2]);
                rfdIPCVo.setFfiDescripcion((String) object[3]);
                rfdIPCVo.setDffCodigo(((BigDecimal) object[4]).longValue());
                rfdIPCVo.setDff_ffi_codigo(((BigDecimal) object[5]).longValue());
                rfdIPCVo.setDffDescripcion((String) object[6]);
                rfdIPCVo.setDrCodigo(((BigDecimal) object[7]).longValue());
                rfdIPCVo.setCodigo_rubro((String) object[8]);
                rfdIPCVo.setRubDescripcion((String) object[9]);
                rfdIPCVo.setDrValor(((BigDecimal) object[10]));
                rfdIPCVo.setDrVigencia(((BigDecimal) object[11]).longValue());
                rfdIPCVo.setInterno(((BigDecimal) object[12]).longValue());
                listaRubroFuenteDetalleIPCVo.add(rfdIPCVo);
            }

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRubroFuenteDetalleIPCVo;
    }

    public List<SiiEstudioPrevio> buscarEstudioPrevioPorCodigoPContratacion(Long idPc) throws ExcepcionDAO {
        List<SiiEstudioPrevio> listaEstudioPrevio = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT estPrev FROM SiiEstudioPrevio estPrev INNER JOIN estPrev.siiItemPlanContratac ipc " + "WHERE estPrev.siiProcesoContratacion.prcCodigo = :idPc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPc", idPc);
            listaEstudioPrevio = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaEstudioPrevio;
    }

    public SiiEstudioPrevio buscarEstudioPrevioPorCodigoProcesoContratacion(Integer idProcesoContratacion) throws ExcepcionDAO {

        List<SiiSolicitudEstMercado> miListaSolEstMer = new ArrayList<SiiSolicitudEstMercado>();
        SiiEstudioPrevio SiiEstPrev = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select area.aco_nombre,sol.sem_objeto_contra_c,ep.epe_valor_contrat,ep.epe_forma_pag_c, ");
            sql.append(" ep.epe_tiempo_durac, DECODE(ep.epe_unidad_durac,1,'DIAS HABILES',2,'DIAS CALENDARIO',3,'MESES',4,'AÑOS',5,'SEMANAS'),ep.epe_obligac_contra_c, ep.epe_codigo, ep.epe_descr_justif,");
            sql.append(" ep.ipc_codigo ");
            sql.append(" from sii_estudio_previo ep inner join sii_solicitud_est_mercado sol on (ep.prc_codigo = sol.prc_codigo)");
            sql.append(" inner join sii_area_coljuegos area on (sol.aco_codigo_responsable = area.aco_codigo) ");
            sql.append(" where ep.prc_codigo=#idProcesoContratacion");


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idProcesoContratacion", idProcesoContratacion);

            List<Object[]> results = query.getResultList();

            if(results != null && !results.isEmpty()) {
                SiiEstPrev = new SiiEstudioPrevio();
                for(Object[] object : results) {

                    SiiProcesoContratacion miSiiProcContra = new SiiProcesoContratacion();
                    SiiSolicitudEstMercado siiSolEstMer = new SiiSolicitudEstMercado();
                    SiiAreaColjuegos siiAreaCol = new SiiAreaColjuegos();

                    siiAreaCol.setAcoNombre((String) object[0]);
                    siiSolEstMer.setSiiAreaColjuegos(siiAreaCol);
                    miListaSolEstMer.add(siiSolEstMer);

                    miSiiProcContra.setPrcCodigo((long) idProcesoContratacion);
                    miSiiProcContra.setPrcObjeto((String) object[1]);
                    miSiiProcContra.setSiiSolicitudEstMercadoList((List) miListaSolEstMer);
                    SiiEstPrev.setSiiProcesoContratacion(miSiiProcContra);

                    SiiEstPrev.setEpeValorContrat(((BigDecimal) object[2]).longValue());
                    SiiEstPrev.setEpeFormaPago((String) object[3]);
                    SiiEstPrev.setEpeTiempoDurac(Integer.valueOf(((BigDecimal) object[4]).intValue()));
                    SiiEstPrev.setEpeUnidadDurac((String) object[5]);
                    SiiEstPrev.setEpeObligacContrat((String) object[6]);
                    SiiEstPrev.setEpeCodigo(((BigDecimal) object[7]).longValue());
                    SiiEstPrev.setEpeDescrJustif((String) object[8]);
                }
            }


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return SiiEstPrev;
    }

    public List<RubroEstudioPrevioVO> buscarRubroPorInterno(Long idInterno) throws ExcepcionDAO {
        List<RubroEstudioPrevioVO> listaRubroEstudioPrevio = new ArrayList<RubroEstudioPrevioVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select interno, descripcion from pr_rubro where interno =#idInterno");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idInterno", idInterno);
            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                RubroEstudioPrevioVO rubroEstudioPrevioVo = new RubroEstudioPrevioVO();
                rubroEstudioPrevioVo.setInterno(((BigDecimal) object[0]).longValue());
                rubroEstudioPrevioVo.setDescripcion((String) object[1]);
                listaRubroEstudioPrevio.add(rubroEstudioPrevioVo);
            }

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRubroEstudioPrevio;
    }

    public List<RubroFuenteDetalleIPCVO> consultarRubroFuenteDetallePorIpcIDEstudioPrevio(Long idIpc, Long IdEstudioPrevio) throws ExcepcionDAO {
        List<RubroFuenteDetalleIPCVO> listaRubroFuenteDetalleIPCVo = new ArrayList<RubroFuenteDetalleIPCVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select ff.ffi_codigo, ff.ffi_nombre, ff.ffi_Descripcion, dff.dff_codigo, dff.dff_descripcion, dr.dru_codigo, ");
            sql.append("r.descripcion, dr.dru_valor, dr.vigencia, epdr.epd_valor, epdr.epd_codigo, epdr.epe_codigo ");
            sql.append("from sii_estudio_previo ep ");
            sql.append("INNER JOIN sii_est_prev_det_rubro epdr ON (ep.epe_codigo = epdr.epe_codigo) ");
            sql.append("INNER JOIN sii_detalle_rubro dr ON (epdr.dru_codigo = dr.dru_codigo) ");
            sql.append("INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("WHERE ep.ipc_codigo = #idIPC ");
            sql.append("AND ep.epe_codigo = #codigoEstudioPrevio ");
            sql.append("ORDER BY ff.ffi_nombre, r.descripcion ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idIPC", idIpc);
            query.setParameter("codigoEstudioPrevio", IdEstudioPrevio);
            List<Object[]> results = query.getResultList();
            for(Object[] object : results) {
                RubroFuenteDetalleIPCVO rfdIPCVo = new RubroFuenteDetalleIPCVO();
                rfdIPCVo.setFfiCodigo(((BigDecimal) object[0]).longValue());
                rfdIPCVo.setFfiNombre((String) object[1]);
                rfdIPCVo.setFfiDescripcion((String) object[2]);
                rfdIPCVo.setDffCodigo(((BigDecimal) object[3]).longValue());
                rfdIPCVo.setDffDescripcion((String) object[4]);
                rfdIPCVo.setDrCodigo(((BigDecimal) object[5]).longValue());
                rfdIPCVo.setRubDescripcion((String) object[6]);
                rfdIPCVo.setDrValor(((BigDecimal) object[7]));
                rfdIPCVo.setDrVigencia(((BigDecimal) object[8]).longValue());
                rfdIPCVo.setValorSolEstMercado(((BigDecimal) object[9]));
                rfdIPCVo.setEpdcodigo(((BigDecimal) object[10]).longValue());
                rfdIPCVo.setEpeCodigo(((BigDecimal) object[11]).longValue());

                listaRubroFuenteDetalleIPCVo.add(rfdIPCVo);
            }
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRubroFuenteDetalleIPCVo;
    }

    public List<SolicitudDetalleRubroCdpVO> calcularSaldoModificacionPresupuesto(Long idItemPlanContratacion, Long idVigencia) throws ExcepcionDAO {
        List<SolicitudDetalleRubroCdpVO> listaSolicitudDetalleRubroCdpVO = new ArrayList<SolicitudDetalleRubroCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT uno.dru_codigo, sum(uno.dru_valor) FROM ( " + "SELECT ipcdr.dru_codigo, dr.dru_valor FROM sii_item_plan_cont_det_rub ipcdr \n" +
                       "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo = ipcdr.dru_codigo)  \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat  AND dr.vigencia = #miVigencia \n" +
                       "UNION ALL  SELECT mpdr.dru_codigo_destino, sum(mpdr.mpd_valor)  \n" + "FROM sii_modific_presup mp  \n" +
                       "INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo)  \n" + "INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo) \n" +
                       "WHERE mpdr.dru_codigo_destino IN  (SELECT ipcdr.dru_codigo \n" + "FROM sii_item_plan_cont_det_rub ipcdr \n" +
                       "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat  AND dr.vigencia = #miVigencia) \n" +
                       "AND mp.mpr_tipo IN ('A') AND mpdr.dru_codigo_destino IS NOT NULL \n" + "AND mp.emp_codigo = 3 GROUP BY mpdr.dru_codigo_destino UNION ALL \n" +
                       "SELECT mpdr.dru_codigo_destino, -sum(mpdr.mpd_valor) FROM sii_modific_presup mp  \n" + "INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo) \n" +
                       "INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo) \n" + "WHERE mpdr.dru_codigo_destino IN (SELECT ipcdr.dru_codigo \n" +
                       "FROM sii_item_plan_cont_det_rub ipcdr \n" + "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) \n" +
                       "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat  AND dr.vigencia = #miVigencia) \n" + "AND mp.mpr_tipo IN ('R') AND mpdr.dru_codigo_destino IS NOT NULL \n" +
                       "AND mp.emp_codigo = 3 GROUP BY mpdr.dru_codigo_destino UNION ALL  \n" + "SELECT mpdr.dru_codigo_destino, sum(mpdr.mpd_valor)  FROM sii_modific_presup mp  \n" +
                       "INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo) \n" + "INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo)  \n" +
                       "WHERE mpdr.dru_codigo_destino IN  (SELECT ipcdr.dru_codigo \n" + "FROM sii_item_plan_cont_det_rub ipcdr \n" +
                       "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo)  \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat  \n" +
                       "AND dr.vigencia = #miVigencia) AND mp.mpr_tipo IN ('T')  \n" + "AND mpdr.dru_codigo_destino IS NOT NULL  AND mp.emp_codigo = 3 \n" +
                       "GROUP BY mpdr.dru_codigo_destino  UNION ALL  \n" + "SELECT mpdr.dru_codigo_origen, -sum(mpdr.mpd_valor)  FROM sii_modific_presup mp  \n" +
                       "INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo)  \n" + "INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo)  \n" +
                       "WHERE mpdr.dru_codigo_origen IN  (SELECT ipcdr.dru_codigo \n" + "FROM sii_item_plan_cont_det_rub ipcdr \n" +
                       "INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo)  \n" + "WHERE ipcdr.ipc_codigo IN #miIdItemPlanContrat  AND dr.vigencia = #miVigencia)  \n" +
                       "AND mp.mpr_tipo IN ('T')  AND mpdr.dru_codigo_origen IS NOT NULL  \n" + "AND mp.emp_codigo = 3  GROUP BY mpdr.dru_codigo_origen  \n" + ")uno GROUP BY uno.dru_codigo ");

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

}

