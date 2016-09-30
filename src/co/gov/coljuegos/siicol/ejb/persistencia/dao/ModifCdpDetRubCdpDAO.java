package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifCdpDetRubCdp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudIncrementoCdpVO;

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
public class ModifCdpDetRubCdpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ModifCdpDetRubCdpDAO() {
        recursos = new Recursos();
    }

    public List<SiiModifCdpDetRubCdp> listaModifCdpDetRubCdpPorModificacion(Long id) throws ExcepcionDAO {
        List<SiiModifCdpDetRubCdp> listaSiiModifCdpDetRubCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModifCdpDetRubCdp o WHERE o.siiModificacionCdp.mcdCodigo = :id");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("id", id);
            listaSiiModifCdpDetRubCdp = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
        return listaSiiModifCdpDetRubCdp;
    }

    public BigDecimal valorIncCdpRubPorDetRubCdpAprobados(Long id) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.mcrValor) FROM SiiModifCdpDetRubCdp o " +
                       "WHERE o.siiDetalleRubroCdp.drcCodigo = :id " +
                       "AND o.siiModificacionCdp.siiEstadoModifCdp.emcNombre = 'APROBADO' " +
                       "AND o.siiModificacionCdp.mcdTipoMod='I'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("id", id);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
    }

    public BigDecimal valorDecCdpRubPorDetRubCdpAprobados(Long id) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.mcrValor) FROM SiiModifCdpDetRubCdp o " +
                       "WHERE o.siiDetalleRubroCdp.drcCodigo = :id " +
                       "AND o.siiModificacionCdp.siiEstadoModifCdp.emcNombre = 'APROBADO' " +
                       "AND o.siiModificacionCdp.mcdTipoMod='D'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("id", id);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
    }

    public List<SiiModifCdpDetRubCdp> listaModifCdpRubPorDetRubCdp(Long id) throws ExcepcionDAO {
        List<SiiModifCdpDetRubCdp> listaSiiModifCdpDetRubCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModifCdpDetRubCdp o WHERE o.siiDetalleRubroCdp.drcCodigo = :id");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("id", id);
            listaSiiModifCdpDetRubCdp = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
        return listaSiiModifCdpDetRubCdp;
    }

    public SiiModifCdpDetRubCdp insertarModifCdpDetRubCdp(SiiModifCdpDetRubCdp modif) throws ExcepcionDAO {
        try {
            manager.persist(modif);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
        return modif;
    }

    public SiiModifCdpDetRubCdp actualizarModifCdpDetRubCdp(SiiModifCdpDetRubCdp modif) throws ExcepcionDAO {
        try {
            modif = manager.merge(modif);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
        return modif;
    }

    public SiiModifCdpDetRubCdp buscarModifCdpDetRubCdpPorId(Long id) throws ExcepcionDAO {
        SiiModifCdpDetRubCdp modif = null;
        try {
            modif = manager.find(SiiModifCdpDetRubCdp.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
        return modif;
    }

    //INCREMENTO


    public List<SolicitudIncrementoCdpVO> buscarValorIncRubroCdpPorItemPlanContratIdCdp(Long idIpc,
                                                                                        Long idCdp) throws ExcepcionDAO {
        List<SolicitudIncrementoCdpVO> listaIncrementoCdp = new ArrayList<SolicitudIncrementoCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("  SELECT uno.codigo, sum(uno.valor) FROM ( ");
            sql.append("  SELECT dr.dru_codigo codigo, sum(dr.dru_valor) valor ");
            sql.append("  FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("  INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo = ipcdr.dru_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("  INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("  INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("  INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("  WHERE ipcdr.ipc_codigo = #miIdIpc "); // se buscan por item del plan de contratacion los detalles de rubro del item.
            sql.append("  GROUP BY dr.dru_codigo ");
            sql.append("  UNION ALL ");
            sql.append("  SELECT mpdr.dru_codigo_destino, sum(mpdr.mpd_valor) ");
            sql.append("  FROM sii_modific_presup mp ");
            sql.append("  INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo) ");
            sql.append("  INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo) ");
            sql.append("  WHERE mpdr.dru_codigo_destino IN ");
            sql.append("  (SELECT dr.dru_codigo ");
            sql.append("  FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("  INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("  INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("  INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("  INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("  WHERE ipcdr.ipc_codigo = #miIdIpc ");
            sql.append("  AND mp.mpr_tipo in ('A') ");
            sql.append("  AND mpdr.dru_codigo_origen IS NOT NULL ");
            sql.append("  AND emp.emp_nombre = 'AUTORIZADO' )");
            sql.append("  GROUP BY mpdr.dru_codigo_destino ");
            sql.append("  UNION ALL ");
            sql.append("  SELECT mpdr.dru_codigo_destino, -sum(mpdr.mpd_valor) ");
            sql.append("  FROM sii_modific_presup mp ");
            sql.append("  INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo) ");
            sql.append("  INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo) ");
            sql.append("  WHERE mpdr.dru_codigo_destino IN ");
            sql.append("  (SELECT dr.dru_codigo ");
            sql.append("  FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("  INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("  INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("  INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("  INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("  WHERE ipcdr.ipc_codigo  = #miIdIpc  ");
            sql.append("  AND mp.mpr_tipo in ('R') ");
            sql.append("  AND mpdr.dru_codigo_origen IS NOT NULL ");
            sql.append("  AND emp.emp_nombre = 'AUTORIZADO' )");
            sql.append("  GROUP BY mpdr.dru_codigo_destino ");
            sql.append("  UNION ALL ");
            sql.append("  SELECT mpdr.dru_codigo_destino, sum(mpdr.mpd_valor) ");
            sql.append("  FROM sii_modific_presup mp ");
            sql.append("  INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo) ");
            sql.append("  INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo) ");
            sql.append("  WHERE mpdr.dru_codigo_destino IN ");
            sql.append("  (SELECT dr.dru_codigo ");
            sql.append("  FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("  INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("  INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("  INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("  INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("  WHERE ipcdr.ipc_codigo = #miIdIpc  ");
            sql.append("  AND mp.mpr_tipo in ('T') ");
            sql.append("  AND mpdr.dru_codigo_origen IS NOT NULL ");
            sql.append("  AND emp.emp_nombre = 'AUTORIZADO' )");
            sql.append("  GROUP BY mpdr.dru_codigo_destino ");
            sql.append("  UNION ALL ");
            sql.append("  SELECT mpdr.dru_codigo_origen, -sum(mpdr.mpd_valor) ");
            sql.append("  FROM sii_modific_presup mp ");
            sql.append("  INNER JOIN sii_mod_pres_det_rubro mpdr ON (mp.mpr_codigo = mpdr.mpr_codigo) ");
            sql.append("  INNER JOIN sii_estado_modif_presup emp ON (mp.emp_codigo = emp.emp_codigo) ");
            sql.append("  WHERE mpdr.dru_codigo_origen IN ");
            sql.append("  (SELECT dr.dru_codigo ");
            sql.append("  FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("  INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("  INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("  INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("  INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("  WHERE ipcdr.ipc_codigo = #miIdIpc  ");
            sql.append("  AND mp.mpr_tipo in ('T') ");
            sql.append("  AND mpdr.dru_codigo_origen IS NOT NULL ");
            sql.append("  AND emp.emp_nombre = 'AUTORIZADO') ");
            sql.append("  GROUP BY mpdr.dru_codigo_origen ");
            sql.append("  UNION ALL   ");
            sql.append("  SELECT drc.dru_codigo, -sum(drc.dru_valor) ");
            sql.append("  FROM sii_cdp cdp        ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (cdp.cdp_codigo = drc.cdp_codigo) ");
            sql.append("  INNER JOIN sii_estado_cdp ecdp  ON (cdp.ecd_codigo = ecdp.ecd_codigo) ");
            sql.append("  WHERE  cdp.cdp_codigo = #miIdCdp  and dru_codigo   IN ");
            sql.append("  (SELECT dr.dru_codigo ");
            sql.append("  FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("  INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("  INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("  INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("  INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("  WHERE ipcdr.ipc_codigo = #miIdIpc ");
            sql.append("  AND ecdp.ecd_nombre = 'CDP APROBADO') ");
            sql.append("  GROUP BY drc.dru_codigo");
            sql.append("  UNION ALL ");
            sql.append("  SELECT drc.dru_codigo, -sum(mcdrc.mcr_VALOR) ");
            sql.append("  FROM sii_modificacion_cdp mc ");
            sql.append("  INNER JOIN sii_modif_cdp_det_rub_cdp mcdrc ON (mc.mcd_codigo = mcdrc.mcd_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc on (drc.drc_codigo = mcdrc.drc_codigo) ");
            sql.append("  INNER JOIN sii_estado_modif_cdp emc on (mc.emc_codigo = emc.emc_codigo) ");
            sql.append("  WHERE MC.mcd_tipo_mod = 'D' AND mcdrc.drc_codigo IN ");
            sql.append("  (SELECT drc.drc_codigo ");
            sql.append("  FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("  INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("  INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("  INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("  INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("  WHERE ipcdr.ipc_codigo = #miIdIpc  )");
            sql.append("  AND emc.emc_nombre ='APROBADO'");
            sql.append("  GROUP BY drc.dru_codigo ");
            sql.append("  UNION ALL");
            sql.append("  SELECT drc.dru_codigo, sum(mcdrc.mcr_VALOR) ");
            sql.append("  FROM sii_modificacion_cdp mc ");
            sql.append("  INNER JOIN sii_modif_cdp_det_rub_cdp mcdrc ON (mc.mcd_codigo = mcdrc.mcd_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.drc_codigo = mcdrc.drc_codigo) ");
            sql.append("  INNER JOIN sii_estado_modif_cdp emc ON (mc.emc_codigo = emc.emc_codigo) ");
            sql.append("  WHERE MC.mcd_tipo_mod = 'I' AND mcdrc.drc_codigo IN ");
            sql.append("  (SELECT drc.drc_codigo ");
            sql.append("  FROM sii_item_plan_cont_det_rub ipcdr ");
            sql.append("  INNER JOIN sii_detalle_rubro dr ON (dr.dru_codigo =ipcdr.dru_codigo) ");
            sql.append("  INNER JOIN sii_detalle_rubro_cdp drc ON (drc.dru_codigo = dr.dru_codigo) ");
            sql.append("  INNER JOIN sii_dtlle_fuente_financiacion dff ON (dr.dff_codigo = dff.dff_codigo) ");
            sql.append("  INNER JOIN sii_fuente_financiacion ff ON (dff.ffi_codigo = ff.ffi_codigo) ");
            sql.append("  INNER JOIN pr_rubro r ON (dr.interno = r.interno) AND (dr.vigencia = r.vigencia) ");
            sql.append("  WHERE ipcdr.ipc_codigo = #miIdIpc  )");
            sql.append("  AND emc.emc_nombre ='APROBADO' ");
            sql.append("  GROUP BY drc.dru_codigo ");
            sql.append("  )uno GROUP BY uno.codigo ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("miIdIpc", idIpc);
            query.setParameter("miIdCdp", idCdp);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                SolicitudIncrementoCdpVO solicitudIncrementoCdpVO = new SolicitudIncrementoCdpVO();
                solicitudIncrementoCdpVO.setRp_codigo(((BigDecimal) object[0]).longValue());
                solicitudIncrementoCdpVO.setCdpInc_valor(((BigDecimal) object[1]));
                listaIncrementoCdp.add(solicitudIncrementoCdpVO);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CdpDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "CdpDAO");
        }
        return listaIncrementoCdp;
    }


    public SiiModifCdpDetRubCdp buscarModifCdpDetRubCdpBaseGMF(Long druCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dm2.MCR_CODIGO \n" + 
            "FROM sii_modif_cdp_det_rub_cdp dm1\n" + 
            "INNER JOIN sii_detalle_rubro_cdp drc1\n" + 
            "ON dm1.DRC_CODIGO = drc1.DRC_CODIGO\n" + 
            "INNER JOIN sii_detalle_rubro dr\n" + 
            "ON drc1.DRU_CODIGO = dr.DRU_CODIGO\n" + 
            "INNER JOIN PR.SII_DETALLE_RUBRO_CDP drc2\n" + 
            "ON dr.DRU_CODIGO    = drc2.DRU_CODIGO\n" + 
            "AND drc1.CDP_CODIGO = drc2.CDP_CODIGO\n" + 
            "INNER JOIN PR.SII_MODIF_CDP_DET_RUB_CDP dm2\n" + 
            "ON drc2.DRC_CODIGO   = dm2.DRC_CODIGO\n" + 
            "AND dm1.MCD_CODIGO   = dm2.MCD_CODIGO\n" + 
            "WHERE dm1.MCR_CODIGO = ?1\n" + 
            "AND dm2.MCR_CODIGO  <> ?1");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            return  buscarModifCdpDetRubCdpPorId((Long) query.getSingleResult());

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
    }

    public List<SiiModifCdpDetRubCdp> rubrosFinanciadosConRecursosPropios(Long mcdCodigo) throws ExcepcionDAO {
        List<SiiModifCdpDetRubCdp> listaSiiModifCdpDetRubCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT mcr\n" + 
            "FROM SiiModifCdpDetRubCdp mcr\n" + 
            "INNER JOIN mcr.siiModificacionCdp mcd\n" + 
            "INNER JOIN mcr.siiDetalleRubroCdp dcr\n" + 
            "INNER JOIN dcr.siiDetalleRubro dru\n" + 
            "INNER JOIN dru.siiDtlleFuenteFinanciacion dff\n" + 
            "INNER JOIN dff.siiFuenteFinanciacion ffi\n" + 
            "WHERE mcd.mcdCodigo = :mcdCodigo and\n" + 
            "  ffi.ffiDescripcion = 'RECURSOS PROPIOS'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mcdCodigo", mcdCodigo);
            listaSiiModifCdpDetRubCdp = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifCdpDetRubCdpDAO");
        }
        return listaSiiModifCdpDetRubCdp;
    }
}
