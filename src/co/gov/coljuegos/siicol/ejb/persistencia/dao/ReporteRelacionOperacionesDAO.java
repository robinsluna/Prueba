package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.FiltrosLibroAuxiliarVO;
import co.gov.coljuegos.siicol.ejb.vo.LibroAuxiliarVO;

import co.gov.coljuegos.siicol.ejb.vo.ReporteRelacionOperacionesVO;

import com.sun.org.apache.bcel.internal.generic.Select;

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

public class ReporteRelacionOperacionesDAO {
    private static boolean ocultarCampos;
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    /**
     * Constructor.
     */
    public ReporteRelacionOperacionesDAO() {
        this.recursos = new Recursos();
    }

    /**
     * Genera el listado de Value Objects que conformar el <b>ReporteRelacionOperaciones</b>.
     * @return List of ReporteRelacionOperacionesVO.
     */
    public List<ReporteRelacionOperacionesVO> generarReporteRelacionOperaciones() throws ExcepcionDAO {
        ReporteRelacionOperacionesVO filtros = new ReporteRelacionOperacionesVO();
        // filtros.setRubro(DetalleRubroDAO);
        return (this.generarReporteRelacionOperacionesPorFiltros(filtros, false));
    }


    /**
     * Genera el listado de Value Objects que conformar el <b>Reporte Relacion Operaciones</b>.
     * @param filtros - Filtros que ser&aacute;n aplicados para generar el Reporte Relacion Operaciones.
     * @return List of Reporte Relacion OperacionesVO.
     */
    public List<ReporteRelacionOperacionesVO> generarReporteRelacionOperacionesPorFiltros( /*Filtros*/ReporteRelacionOperacionesVO filtros,
                                                                                           boolean ocultarCampos) throws ExcepcionDAO {
        List<ReporteRelacionOperacionesVO> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();
            /**Consulta**/

            sql.append("       WITH rubro AS   ");
            sql.append("        (SELECT n1.CODIGO UNI,   ");
            sql.append("          n2.CODIGO TIP,   ");
            sql.append("          n3.CODIGO CTA,   ");
            sql.append("          n4.CODIGO SCTA,   ");
            sql.append("          n5.CODIGO OBJ,   ");
            sql.append("          n6.CODIGO ORD,   ");
            sql.append("          n7.CODIGO SORD,   ");
            sql.append("          n8.CODIGO FUENTE,   ");
            sql.append("          r.DESCRIPCION,   ");
            sql.append("          r.INTERNO,   ");
            sql.append("          r.VIGENCIA   ");
            sql.append("        FROM pr_rubro r   ");
            sql.append("        LEFT JOIN pr_nivel1 n1   ");
            sql.append("        ON r.INTERNO_NIVEL1 = n1.INTERNO   ");
            sql.append("        LEFT JOIN pr_nivel2 n2   ");
            sql.append("        ON r.INTERNO_NIVEL2 = n2.INTERNO   ");
            sql.append("        LEFT JOIN pr_nivel3 n3   ");
            sql.append("        ON r.INTERNO_NIVEL3 = n3.INTERNO   ");
            sql.append("        LEFT JOIN pr_nivel4 n4   ");
            sql.append("        ON r.INTERNO_NIVEL4 = n4.INTERNO   ");
            sql.append("        LEFT JOIN pr_nivel5 n5   ");
            sql.append("        ON r.INTERNO_NIVEL5 = n5.INTERNO   ");
            sql.append("        LEFT JOIN pr_nivel6 n6   ");
            sql.append("        ON r.INTERNO_NIVEL6 = n6.INTERNO   ");
            sql.append("        LEFT JOIN pr_nivel7 n7   ");
            sql.append("        ON r.INTERNO_NIVEL7 = n7.INTERNO   ");
            sql.append("        LEFT JOIN pr_nivel8 n8   ");
            sql.append("        ON r.INTERNO_NIVEL8 = n8.INTERNO   ");
            sql.append("        ),   ");
            sql.append("        modificacion_cdp AS   ");
            sql.append("        (SELECT mcr.DRC_CODIGO,   ");
            sql.append("          SUM(mcr.MCR_VALOR * DECODE(mcd.MCD_TIPO_MOD, 'D', -1, 'I', 1, 1)) valor   ");
            sql.append("        FROM sii_modif_cdp_det_rub_cdp mcr   ");
            sql.append("        INNER JOIN sii_modificacion_cdp mcd   ");
            sql.append("        ON mcd.MCD_CODIGO = mcr.MCD_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modif_cdp emc   ");
            sql.append("        ON mcd.EMC_CODIGO    = emc.EMC_CODIGO   ");
            sql.append("        WHERE emc.EMC_NOMBRE = 'APROBADO'   ");
            sql.append("        AND mcr.MCR_VALOR   <> 0   ");
            sql.append("        GROUP BY mcr.DRC_CODIGO   ");
            sql.append("        ),   ");
            sql.append("        modificacion_rp AS   ");
            sql.append("        (SELECT rdr.RDR_CODIGO,   ");
            sql.append("          SUM(mrd.MRD_VALOR * DECODE(mrp.MRP_TIPO_MODIF, 'D', -1, 'I', 1, 1)) valor   ");
            sql.append("        FROM sii_modificacion_rp mrp   ");
            sql.append("        INNER JOIN sii_estado_modific_rp emr   ");
            sql.append("        ON mrp.EMR_CODIGO = emr.EMR_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_rp_det_rub_cdp mrd   ");
            sql.append("        ON mrp.MRP_CODIGO = mrd.MRP_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON mrd.RDR_CODIGO    = rdr.RDR_CODIGO   ");
            sql.append("        WHERE emr.EMR_NOMBRE = 'APROBADO'   ");
            sql.append("        AND mrd.MRD_VALOR   <> 0   ");
            sql.append("        GROUP BY rdr.RDR_CODIGO   ");
            sql.append("        ),   ");
            sql.append("        expedicion_rp AS   ");
            sql.append("        (SELECT 'EXPEDICION RP' tipo_operacion,   ");
            sql.append("          RP.RP_CONSECUTIVO numero_operacion,   ");
            sql.append("          RP.RP_FECHA_RP fecha_operacion,   ");
            sql.append("          'EXPEDICION CDP' operacion_referencia,   ");
            sql.append("          cdp.CDP_CONSECUTIVO numero_referencia,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(rdr.RDR_VALOR) + SUM(NVL(mod.valor, 0)) valor_expedido,   ");
            sql.append("       0   ");
            sql.append("        FROM modificacion_rp mod   ");
            sql.append("        RIGHT JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON rdr.RDR_CODIGO = mod.RDR_CODIGO   ");
            sql.append("        INNER JOIN sii_RP RP   ");
            sql.append("        ON RP.RP_CODIGO = rdr.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp_rp CRP   ");
            sql.append("        ON CRP.RP_CODIGO = RP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = CRP.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO  = drc.CDP_CODIGO   ");
            sql.append("        AND rdr.DRC_CODIGO = drc.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_rp erp   ");
            sql.append("        ON RP.ERP_CODIGO         = erp.ERP_CODIGO   ");
            sql.append("        WHERE drc.DRC_APLICA_GMF = 'N'   ");
            sql.append("        AND erp.ERP_NOMBRE       = 'RP APROBADO'   ");
            sql.append("        GROUP BY 'EXPEDICION RP',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          RP.RP_FECHA_RP,   ");
            sql.append("          'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        ),   ");
            sql.append("        obligacion AS   ");
            sql.append("        (SELECT 'OBLIGACIONES' tipo_operacion,   ");
            sql.append("          obl.OBL_NUMERO numero_operacion,   ");
            sql.append("          obl.OBL_FECHA fecha_operacion,   ");
            sql.append("          'EXPEDICION RP' operacion_referencia,   ");
            sql.append("          RP.RP_CONSECUTIVO numero_referencia,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(ocr.OCR_VALOR) valor_obligacion,   ");
            sql.append("          0 saldo   ");
            sql.append("        FROM sii_obligacion obl   ");
            sql.append("        INNER JOIN sii_obl_conc_rp_det_rub_cdp ocr   ");
            sql.append("        ON obl.OBL_CODIGO = ocr.OBL_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON ocr.RDR_CODIGO = rdr.RDR_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN SII_CDP CDP   ");
            sql.append("        ON CDP.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN SII_ESTADO_OBLIGACION EOB   ");
            sql.append("        ON obl.EOB_CODIGO = EOB.EOB_CODIGO   ");
            sql.append("        INNER JOIN SII_RP RP   ");
            sql.append("        ON RP.RP_CODIGO          = rdr.RP_CODIGO   ");
            sql.append("        WHERE drc.DRC_APLICA_GMF = 'N'   ");
            sql.append("        AND EOB.EOB_NOMBRE       = 'APROBADO'   ");
            sql.append("        GROUP BY obl.OBL_NUMERO,   ");
            sql.append("          obl.OBL_FECHA,   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        ),   ");
            sql.append("        obligacion_gmf AS   ");
            sql.append("        (SELECT 'OBLIGACIONES (4*1000)' tipo_operacion,   ");
            sql.append("          obl.OBL_NUMERO numero_operacion,   ");
            sql.append("          obl.OBL_FECHA fecha_operacion,   ");
            sql.append("          'EXPEDICION RP (4*1000)' operacion_referencia,   ");
            sql.append("          RP.RP_CONSECUTIVO numero_referencia,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(ocr.OCR_VALOR) * 4 / 1000 valor_obligacion,   ");
            sql.append("          0 saldo   ");
            sql.append("        FROM sii_obligacion obl   ");
            sql.append("        INNER JOIN sii_obl_conc_rp_det_rub_cdp ocr   ");
            sql.append("        ON obl.OBL_CODIGO = ocr.OBL_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON ocr.RDR_CODIGO = rdr.RDR_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN SII_CDP CDP   ");
            sql.append("        ON CDP.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN SII_ESTADO_OBLIGACION EOB   ");
            sql.append("        ON obl.EOB_CODIGO = EOB.EOB_CODIGO   ");
            sql.append("        INNER JOIN SII_RP RP   ");
            sql.append("        ON RP.RP_CODIGO = rdr.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drcGmf   ");
            sql.append("        ON drcGmf.CDP_CODIGO      = drc.CDP_CODIGO   ");
            sql.append("        AND drcGmf.DRU_CODIGO     = drc.DRU_CODIGO   ");
            sql.append("        WHERE drc.DRC_APLICA_GMF  = 'N'   ");
            sql.append("        AND EOB.EOB_NOMBRE        = 'APROBADO'   ");
            sql.append("        AND drcGmf.DRC_APLICA_GMF = 'S'   ");
            sql.append("        GROUP BY obl.OBL_NUMERO,   ");
            sql.append("          obl.OBL_FECHA,   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        ),   ");
            sql.append("        pagos AS   ");
            sql.append("        (SELECT 'PAGOS' tipo_operacion,   ");
            sql.append("          orp.ORP_CONSECUTIVO numero_operacion,   ");
            sql.append("          orp.ORP_FECHA fecha_operacion,   ");
            sql.append("          'OBLIGACIONES' operacion_referencia,   ");
            sql.append("          obl.OBL_NUMERO numero_referencia,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(ocr.OCR_VALOR) valor_pagado,   ");
            sql.append("          0 saldo   ");
            sql.append("        FROM sii_orden_pago orp   ");
            sql.append("        INNER JOIN sii_estado_orden_pago eop   ");
            sql.append("        ON orp.EOP_CODIGO = eop.EOP_CODIGO   ");
            sql.append("        INNER JOIN sii_obligacion obl   ");
            sql.append("        ON orp.OBL_CODIGO = obl.OBL_CODIGO   ");
            sql.append("        INNER JOIN sii_obl_conc_rp_det_rub_cdp ocr   ");
            sql.append("        ON obl.OBL_CODIGO = ocr.OBL_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON ocr.RDR_CODIGO = rdr.RDR_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN SII_CDP CDP   ");
            sql.append("        ON drc.CDP_CODIGO      = CDP.CDP_CODIGO   ");
            sql.append("        WHERE eop.EOP_NOMBRE   = 'PAGADA'   ");
            sql.append("        AND drc.DRC_APLICA_GMF = 'N'   ");
            sql.append("        GROUP BY orp.ORP_CONSECUTIVO,   ");
            sql.append("          orp.ORP_FECHA,   ");
            sql.append("          obl.OBL_NUMERO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        ),   ");
            sql.append("        pagos_gmf AS   ");
            sql.append("        (SELECT 'PAGOS (4*1000)' tipo_operacion,   ");
            sql.append("          orp.ORP_CONSECUTIVO numero_operacion,   ");
            sql.append("          orp.ORP_FECHA fecha_operacion,   ");
            sql.append("          'OBLIGACIONES (4*1000)' operacion_referencia,   ");
            sql.append("          obl.OBL_NUMERO numero_referencia,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(ocr.OCR_VALOR) * 4 / 1000 valor_pagado,   ");
            sql.append("          0 saldo   ");
            sql.append("        FROM sii_orden_pago orp   ");
            sql.append("        INNER JOIN sii_estado_orden_pago eop   ");
            sql.append("        ON orp.EOP_CODIGO = eop.EOP_CODIGO   ");
            sql.append("        INNER JOIN sii_obligacion obl   ");
            sql.append("        ON orp.OBL_CODIGO = obl.OBL_CODIGO   ");
            sql.append("        INNER JOIN sii_obl_conc_rp_det_rub_cdp ocr   ");
            sql.append("        ON obl.OBL_CODIGO = ocr.OBL_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON ocr.RDR_CODIGO = rdr.RDR_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drcGmf   ");
            sql.append("        ON drcGmf.CDP_CODIGO  = drc.CDP_CODIGO   ");
            sql.append("        AND drcGmf.DRU_CODIGO = drc.DRU_CODIGO   ");
            sql.append("        INNER JOIN SII_CDP CDP   ");
            sql.append("        ON drcGmf.CDP_CODIGO      = CDP.CDP_CODIGO   ");
            sql.append("        WHERE eop.EOP_NOMBRE      = 'PAGADA'   ");
            sql.append("        AND drcGmf.DRC_APLICA_GMF = 'S'   ");
            sql.append("        AND drc.DRC_APLICA_GMF    = 'N'   ");
            sql.append("        GROUP BY orp.ORP_CONSECUTIVO,   ");
            sql.append("          orp.ORP_FECHA,   ");
            sql.append("          obl.OBL_NUMERO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        ),   ");
            sql.append("        operaciones AS   ");
            sql.append("        (SELECT 'SOLICITUD CDP' tipo_operacion,   ");
            sql.append("          cdp.CDP_CODIGO numero_operacion,   ");
            sql.append("          cdp.CDP_FECHA_SOLIC fecha_operacion,   ");
            sql.append("          '' operacion_referencia,   ");
            sql.append("          0 numero_referencia,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(drc.DRU_VALOR) AS valor_total,   ");
            sql.append("          0                  AS saldo_por_ejecutar   ");
            sql.append("        FROM sii_detalle_rubro_cdp drc   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN SII_ESTADO_CDP ecd   ");
            sql.append("        ON cdp.ECD_CODIGO         = ecd.ECD_CODIGO   ");
            sql.append("        WHERE ecd.ECD_NOMBRE NOT IN ('DESISTIDO', 'RECHAZADO')   ");
            sql.append("        GROUP BY 'SOLICITUD CDP',   ");
            sql.append("          cdp.CDP_CODIGO,   ");
            sql.append("          cdp.CDP_FECHA_SOLIC,   ");
            sql.append("          '',   ");
            sql.append("          0,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          cdp.CDP_FECHA_EXPEDICION,   ");
            sql.append("          'SOLICITUD CDP',   ");
            sql.append("          cdp.CDP_CODIGO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(drc.DRU_VALOR) + SUM(NVL(mod.valor, 0)),   ");
            sql.append("          SUM(drc.DRU_VALOR) + SUM(NVL(mod.valor, 0)) - SUM(exp.valor_expedido)   ");
            sql.append("        FROM expedicion_rp exp   ");
            sql.append("        RIGHT JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON drc.DRU_CODIGO = exp.DRU_CODIGO   ");
            sql.append("        LEFT JOIN modificacion_cdp mod   ");
            sql.append("        ON drc.DRC_CODIGO = mod.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_cdp ecd   ");
            sql.append("        ON cdp.ECD_CODIGO      = ecd.ECD_CODIGO   ");
            sql.append("        WHERE ecd.ECD_NOMBRE   = 'CDP APROBADO'   ");
            sql.append("        AND drc.DRC_APLICA_GMF = 'N'   ");
            sql.append("        GROUP BY 'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          cdp.CDP_FECHA_EXPEDICION,   ");
            sql.append("          'SOLICITUD CDP',   ");
            sql.append("          cdp.CDP_CODIGO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'EXPEDICION CDP (4*1000)',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          cdp.CDP_FECHA_EXPEDICION,   ");
            sql.append("          'SOLICITUD CDP',   ");
            sql.append("          cdp.CDP_CODIGO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(drc.DRU_VALOR) + SUM(NVL(mod.valor, 0)),   ");
            sql.append("          SUM(drc.DRU_VALOR) + SUM(NVL(mod.valor, 0)) - SUM(exp.valor_expedido)   ");
            sql.append("        FROM expedicion_rp exp   ");
            sql.append("        RIGHT JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON drc.DRU_CODIGO = exp.DRU_CODIGO   ");
            sql.append("        LEFT JOIN modificacion_cdp mod   ");
            sql.append("        ON drc.DRC_CODIGO = mod.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_cdp ecd   ");
            sql.append("        ON cdp.ECD_CODIGO      = ecd.ECD_CODIGO   ");
            sql.append("        WHERE ecd.ECD_NOMBRE   = 'CDP APROBADO'   ");
            sql.append("        AND drc.DRC_APLICA_GMF = 'S'   ");
            sql.append("        GROUP BY 'EXPEDICION CDP (4*1000)',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          cdp.CDP_FECHA_EXPEDICION,   ");
            sql.append("          'SOLICITUD CDP',   ");
            sql.append("          cdp.CDP_CODIGO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'INCREMENTO CDP',   ");
            sql.append("          mcd.MCD_NUMERO,   ");
            sql.append("          mcd.MCD_FECHA_APROB_RECHAZO,   ");
            sql.append("          'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(mcr.MCR_VALOR),   ");
            sql.append("       0   ");
            sql.append("        FROM sii_modificacion_cdp mcd   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON mcd.CDP_CODIGO = cdp.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_cdp_det_rub_cdp mcr   ");
            sql.append("        ON mcd.MCD_CODIGO  = mcr.MCD_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = mcr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modif_cdp emc   ");
            sql.append("        ON mcd.EMC_CODIGO      = emc.EMC_CODIGO   ");
            sql.append("        WHERE mcd.MCD_TIPO_MOD = 'I'   ");
            sql.append("        AND drc.DRC_APLICA_GMF = 'N'   ");
            sql.append("        AND emc.EMC_NOMBRE     = 'APROBADO'   ");
            sql.append("        GROUP BY 'INCREMENTO CDP',   ");
            sql.append("          mcd.MCD_NUMERO,   ");
            sql.append("          mcd.MCD_FECHA_APROB_RECHAZO,   ");
            sql.append("          'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'INCREMENTO CDP (4*1000)',   ");
            sql.append("          mcd.MCD_NUMERO,   ");
            sql.append("          mcd.MCD_FECHA_APROB_RECHAZO,   ");
            sql.append("          'EXPEDICION CDP (4*1000)',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(mcr.MCR_VALOR),   ");
            sql.append("       0   ");
            sql.append("        FROM sii_modificacion_cdp mcd   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON mcd.CDP_CODIGO = cdp.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_cdp_det_rub_cdp mcr   ");
            sql.append("        ON mcd.MCD_CODIGO  = mcr.MCD_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = mcr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modif_cdp emc   ");
            sql.append("        ON mcd.EMC_CODIGO      = emc.EMC_CODIGO   ");
            sql.append("        WHERE mcd.MCD_TIPO_MOD = 'I'   ");
            sql.append("        AND drc.DRC_APLICA_GMF = 'S'   ");
            sql.append("        AND emc.EMC_NOMBRE     = 'APROBADO'   ");
            sql.append("        GROUP BY 'INCREMENTO CDP (4*1000)',   ");
            sql.append("          mcd.MCD_NUMERO,   ");
            sql.append("          mcd.MCD_FECHA_APROB_RECHAZO,   ");
            sql.append("          'EXPEDICION CDP (4*1000)',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'DECREMENTO CDP',   ");
            sql.append("          mcd.MCD_NUMERO,   ");
            sql.append("          mcd.MCD_FECHA_APROB_RECHAZO,   ");
            sql.append("          'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(mcr.MCR_VALOR),   ");
            sql.append("       0   ");
            sql.append("        FROM sii_modificacion_cdp mcd   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON mcd.CDP_CODIGO = cdp.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_cdp_det_rub_cdp mcr   ");
            sql.append("        ON mcd.MCD_CODIGO  = mcr.MCD_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = mcr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modif_cdp emc   ");
            sql.append("        ON mcd.EMC_CODIGO      = emc.EMC_CODIGO   ");
            sql.append("        WHERE mcd.MCD_TIPO_MOD = 'D'   ");
            sql.append("        AND drc.DRC_APLICA_GMF = 'N'   ");
            sql.append("        AND emc.EMC_NOMBRE     = 'APROBADO'   ");
            sql.append("        GROUP BY 'DECREMENTO CDP',   ");
            sql.append("          mcd.MCD_NUMERO,   ");
            sql.append("          mcd.MCD_FECHA_APROB_RECHAZO,   ");
            sql.append("          'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'DECREMENTO CDP (4*1000)',   ");
            sql.append("          mcd.MCD_NUMERO,   ");
            sql.append("          mcd.MCD_FECHA_APROB_RECHAZO,   ");
            sql.append("          'EXPEDICION CDP (4*1000)',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(mcr.MCR_VALOR),   ");
            sql.append("       0   ");
            sql.append("        FROM sii_modificacion_cdp mcd   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON mcd.CDP_CODIGO = cdp.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_cdp_det_rub_cdp mcr   ");
            sql.append("        ON mcd.MCD_CODIGO  = mcr.MCD_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = mcr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modif_cdp emc   ");
            sql.append("        ON mcd.EMC_CODIGO      = emc.EMC_CODIGO   ");
            sql.append("        WHERE mcd.MCD_TIPO_MOD = 'D'   ");
            sql.append("        AND drc.DRC_APLICA_GMF = 'S'   ");
            sql.append("        AND emc.EMC_NOMBRE     = 'APROBADO'   ");
            sql.append("        GROUP BY 'DECREMENTO CDP (4*1000)',   ");
            sql.append("          mcd.MCD_NUMERO,   ");
            sql.append("          mcd.MCD_FECHA_APROB_RECHAZO,   ");
            sql.append("          'EXPEDICION CDP (4*1000)',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'SOLICITUD RP',   ");
            sql.append("          RP.RP_CODIGO,   ");
            sql.append("          RP.RP_FECHA_SOLIC,   ");
            sql.append("          'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(rdr.RDR_VALOR),   ");
            sql.append("          SUM(rdr.RDR_VALOR) - SUM(obl.valor_obligacion)   ");
            sql.append("        FROM sii_RP RP   ");
            sql.append("        INNER JOIN sii_cdp_rp CRP   ");
            sql.append("        ON CRP.RP_CODIGO = RP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = CRP.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN SII_ESTADO_RP ERP   ");
            sql.append("        ON RP.ERP_CODIGO = ERP.ERP_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON RP.RP_CODIGO = rdr.RP_CODIGO   ");
            sql.append("        right JOIN obligacion obl   ");
            sql.append("        ON drc.DRU_CODIGO         = obl.DRU_CODIGO   ");
            sql.append("        WHERE ERP.ERP_NOMBRE NOT IN ('DESISTIDO', 'RECHAZADO')   ");
            sql.append("        GROUP BY 'SOLICITUD RP',   ");
            sql.append("          RP.RP_CODIGO,   ");
            sql.append("          RP.RP_FECHA_SOLIC,   ");
            sql.append("          'EXPEDICION CDP',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT exp.tipo_operacion,   ");
            sql.append("          exp.numero_operacion,   ");
            sql.append("          exp.fecha_operacion,   ");
            sql.append("          exp.operacion_referencia,   ");
            sql.append("          exp.numero_referencia,   ");
            sql.append("          exp.DRU_CODIGO,   ");
            sql.append("          exp.valor_expedido,   ");
            sql.append("          exp.valor_expedido - obl.valor_obligacion   ");
            sql.append("        FROM expedicion_rp exp   ");
            sql.append("        LEFT JOIN obligacion obl   ");
            sql.append("        ON exp.DRU_CODIGO = obl.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'EXPEDICION RP (4*1000)',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          RP.RP_FECHA_RP,   ");
            sql.append("          'EXPEDICION CDP (4*1000)',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(rdr.RDR_VALOR) + SUM(NVL(mod.valor, 0)),   ");
            sql.append("       0   ");
            sql.append("        FROM modificacion_rp mod   ");
            sql.append("        RIGHT JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON rdr.RDR_CODIGO = mod.RDR_CODIGO   ");
            sql.append("        INNER JOIN sii_RP RP   ");
            sql.append("        ON RP.RP_CODIGO = rdr.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp_rp CRP   ");
            sql.append("        ON CRP.RP_CODIGO = RP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = CRP.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO  = drc.CDP_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_rp erp   ");
            sql.append("        ON RP.ERP_CODIGO         = erp.ERP_CODIGO   ");
            sql.append("        WHERE drc.DRC_APLICA_GMF = 'S'   ");
            sql.append("        AND erp.ERP_NOMBRE       = 'RP APROBADO'   ");
            sql.append("        GROUP BY 'EXPEDICION RP (4*1000)',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          RP.RP_FECHA_RP,   ");
            sql.append("          'EXPEDICION CDP (4*1000)',   ");
            sql.append("          cdp.CDP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'INCREMENTO RP',   ");
            sql.append("          MRP.MRP_CONSECUTIVO,   ");
            sql.append("          MRP.MRP_FECHA,   ");
            sql.append("          'EXPEDICION RP',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(mrd.MRD_VALOR),   ");
            sql.append("       0   ");
            sql.append("        FROM sii_RP RP   ");
            sql.append("        INNER JOIN sii_cdp_rp CRP   ");
            sql.append("        ON CRP.RP_CODIGO = RP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = CRP.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_modificacion_rp MRP   ");
            sql.append("        ON RP.RP_CODIGO = MRP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_rp_det_rub_cdp mrd   ");
            sql.append("        ON MRP.MRP_CODIGO = mrd.MRP_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON rdr.RDR_CODIGO  = mrd.RDR_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modific_rp emr   ");
            sql.append("        ON MRP.EMR_CODIGO        = emr.EMR_CODIGO   ");
            sql.append("        WHERE drc.DRC_APLICA_GMF = 'N'   ");
            sql.append("        AND MRP.MRP_TIPO_MODIF   = 'I'   ");
            sql.append("        AND emr.EMR_NOMBRE       = 'APROBADO'   ");
            sql.append("        GROUP BY 'INCREMENTO RP',   ");
            sql.append("          MRP.MRP_CONSECUTIVO,   ");
            sql.append("          MRP.MRP_FECHA,   ");
            sql.append("          'EXPEDICION RP',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'INCREMENTO RP (4*1000)',   ");
            sql.append("          MRP.MRP_CONSECUTIVO,   ");
            sql.append("          MRP.MRP_FECHA,   ");
            sql.append("          'EXPEDICION RP (4*1000)',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(mrd.MRD_VALOR),   ");
            sql.append("       0   ");
            sql.append("        FROM sii_RP RP   ");
            sql.append("        INNER JOIN sii_cdp_rp CRP   ");
            sql.append("        ON CRP.RP_CODIGO = RP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = CRP.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_modificacion_rp MRP   ");
            sql.append("        ON RP.RP_CODIGO = MRP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_rp_det_rub_cdp mrd   ");
            sql.append("        ON MRP.MRP_CODIGO = mrd.MRP_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON rdr.RDR_CODIGO  = mrd.RDR_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modific_rp emr   ");
            sql.append("        ON MRP.EMR_CODIGO        = emr.EMR_CODIGO   ");
            sql.append("        WHERE drc.DRC_APLICA_GMF = 'S'   ");
            sql.append("        AND MRP.MRP_TIPO_MODIF   = 'I'   ");
            sql.append("        AND emr.EMR_NOMBRE       = 'APROBADO'   ");
            sql.append("        GROUP BY MRP.MRP_CONSECUTIVO,   ");
            sql.append("          MRP.MRP_FECHA,   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'DECREMENTO RP',   ");
            sql.append("          MRP.MRP_CONSECUTIVO,   ");
            sql.append("          MRP.MRP_FECHA,   ");
            sql.append("          'EXPEDICION RP',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(mrd.MRD_VALOR),   ");
            sql.append("       0   ");
            sql.append("        FROM sii_RP RP   ");
            sql.append("        INNER JOIN sii_cdp_rp CRP   ");
            sql.append("        ON CRP.RP_CODIGO = RP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = CRP.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_modificacion_rp MRP   ");
            sql.append("        ON RP.RP_CODIGO = MRP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_rp_det_rub_cdp mrd   ");
            sql.append("        ON MRP.MRP_CODIGO = mrd.MRP_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON rdr.RDR_CODIGO  = mrd.RDR_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modific_rp emr   ");
            sql.append("        ON MRP.EMR_CODIGO        = emr.EMR_CODIGO   ");
            sql.append("        WHERE drc.DRC_APLICA_GMF = 'N'   ");
            sql.append("        AND MRP.MRP_TIPO_MODIF   = 'D'   ");
            sql.append("        AND emr.EMR_NOMBRE       = 'APROBADO'   ");
            sql.append("        GROUP BY MRP.MRP_CONSECUTIVO,   ");
            sql.append("          MRP.MRP_FECHA,   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT 'DECREMENTO RP (4*1000)',   ");
            sql.append("          MRP.MRP_CONSECUTIVO,   ");
            sql.append("          MRP.MRP_FECHA,   ");
            sql.append("          'EXPEDICION RP (4*1000)',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO,   ");
            sql.append("          SUM(mrd.MRD_VALOR),   ");
            sql.append("       0   ");
            sql.append("        FROM sii_RP RP   ");
            sql.append("        INNER JOIN sii_cdp_rp CRP   ");
            sql.append("        ON CRP.RP_CODIGO = RP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_cdp cdp   ");
            sql.append("        ON cdp.CDP_CODIGO = CRP.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_detalle_rubro_cdp drc   ");
            sql.append("        ON cdp.CDP_CODIGO = drc.CDP_CODIGO   ");
            sql.append("        INNER JOIN sii_modificacion_rp MRP   ");
            sql.append("        ON RP.RP_CODIGO = MRP.RP_CODIGO   ");
            sql.append("        INNER JOIN sii_modif_rp_det_rub_cdp mrd   ");
            sql.append("        ON MRP.MRP_CODIGO = mrd.MRP_CODIGO   ");
            sql.append("        INNER JOIN sii_rp_det_rubro_cdp rdr   ");
            sql.append("        ON rdr.RDR_CODIGO  = mrd.RDR_CODIGO   ");
            sql.append("        AND drc.DRC_CODIGO = rdr.DRC_CODIGO   ");
            sql.append("        INNER JOIN sii_estado_modific_rp emr   ");
            sql.append("        ON MRP.EMR_CODIGO        = emr.EMR_CODIGO   ");
            sql.append("        WHERE drc.DRC_APLICA_GMF = 'S'   ");
            sql.append("        AND MRP.MRP_TIPO_MODIF   = 'D'   ");
            sql.append("        AND emr.EMR_NOMBRE       = 'APROBADO'   ");
            sql.append("        GROUP BY 'DECREMENTO RP (4*1000)',   ");
            sql.append("          MRP.MRP_CONSECUTIVO,   ");
            sql.append("          MRP.MRP_FECHA,   ");
            sql.append("          'EXPEDICION RP (4*1000)',   ");
            sql.append("          RP.RP_CONSECUTIVO,   ");
            sql.append("          drc.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT obl.tipo_operacion,   ");
            sql.append("          obl.numero_operacion,   ");
            sql.append("          obl.fecha_operacion,   ");
            sql.append("          obl.operacion_referencia,   ");
            sql.append("          obl.numero_referencia,   ");
            sql.append("          obl.DRU_CODIGO,   ");
            sql.append("          obl.valor_obligacion,   ");
            sql.append("          obl.valor_obligacion - NVL(pagos.valor_pagado, 0)   ");
            sql.append("        FROM obligacion obl   ");
            sql.append("        LEFT JOIN pagos   ");
            sql.append("        ON obl.DRU_CODIGO = pagos.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT obl.tipo_operacion,   ");
            sql.append("          obl.numero_operacion,   ");
            sql.append("          obl.fecha_operacion,   ");
            sql.append("          obl.operacion_referencia,   ");
            sql.append("          obl.numero_referencia,   ");
            sql.append("          obl.DRU_CODIGO,   ");
            sql.append("          obl.valor_obligacion,   ");
            sql.append("          obl.valor_obligacion - NVL(pagos.valor_pagado, 0)   ");
            sql.append("        FROM obligacion_gmf obl   ");
            sql.append("        LEFT JOIN pagos_gmf pagos   ");
            sql.append("        ON obl.DRU_CODIGO = pagos.DRU_CODIGO   ");
            sql.append("        UNION   ");
            sql.append("        SELECT pagos.tipo_operacion,   ");
            sql.append("          pagos.numero_operacion,   ");
            sql.append("          pagos.fecha_operacion,   ");
            sql.append("          pagos.operacion_referencia,   ");
            sql.append("          pagos.numero_referencia,   ");
            sql.append("          pagos.DRU_CODIGO,   ");
            sql.append("          pagos.valor_pagado,   ");
            sql.append("          pagos.saldo   ");
            sql.append("        FROM pagos   ");
            sql.append("        UNION   ");
            sql.append("        SELECT pagos_gmf.tipo_operacion,   ");
            sql.append("          pagos_gmf.numero_operacion,   ");
            sql.append("          pagos_gmf.fecha_operacion,   ");
            sql.append("          pagos_gmf.operacion_referencia,   ");
            sql.append("          pagos_gmf.numero_referencia,   ");
            sql.append("          pagos_gmf.DRU_CODIGO,   ");
            sql.append("          pagos_gmf.valor_pagado,   ");
            sql.append("          pagos_gmf.saldo   ");
            sql.append("        FROM pagos_gmf   ");
            sql.append("        )   ");
            sql.append("       SELECT Level,   ");
            sql.append("        operaciones.tipo_operacion,   ");
            sql.append("        operaciones.numero_operacion,   ");
            sql.append("        operaciones.fecha_operacion,   ");
            sql.append("        operaciones.operacion_referencia,   ");
            sql.append("        operaciones.numero_referencia,   ");
            sql.append("        dru.DRU_CODIGO,   ");
            sql.append("        operaciones.valor_total,   ");
            sql.append("        operaciones.saldo_por_ejecutar,   ");
            sql.append("        rubro.UNI,   ");
            sql.append("        rubro.TIP,   ");
            sql.append("        rubro.CTA,   ");
            sql.append("        rubro.SCTA,   ");
            sql.append("        rubro.OBJ,   ");
            sql.append("        rubro.ORD,   ");
            sql.append("        rubro.SORD,   ");
            sql.append("        rubro.FUENTE,   ");
            sql.append("        rubro.DESCRIPCION,   ");
            sql.append("        ffi.FFI_CODIGO_FUENTE,   ");
            sql.append("        dff.DFF_CODIGO_RECURSO   ");
            sql.append("       FROM operaciones   ");
            sql.append("       INNER JOIN sii_detalle_rubro dru   ");
            sql.append("       ON operaciones.DRU_CODIGO = dru.DRU_CODIGO   ");
            sql.append("       INNER JOIN rubro   ");
            sql.append("       ON dru.INTERNO   = rubro.INTERNO   ");
            sql.append("       AND dru.VIGENCIA = rubro.VIGENCIA   ");
            sql.append("       INNER JOIN sii_dtlle_fuente_financiacion dff   ");
            sql.append("       ON dru.DFF_CODIGO = dff.DFF_CODIGO   ");
            sql.append("       INNER JOIN sii_fuente_financiacion ffi   ");
            sql.append("       ON dff.FFI_CODIGO                      = ffi.FFI_CODIGO   ");
            sql.append("       WHERE NVL(operaciones.valor_total, 0) <> 0   ");
            sql.append("        START WITH REPLACE(operaciones.tipo_operacion, ' (4*1000)', '') LIKE :tipoOperacion   ");
            sql.append("       AND operaciones.numero_operacion                = #numeroOperacion   ");
            sql.append("        CONNECT BY Prior operaciones.numero_operacion = operaciones.numero_referencia   ");
            sql.append("       AND Prior operaciones.tipo_operacion LIKE operaciones.operacion_referencia   ");
            sql.append("       UNION   ");
            sql.append("       SELECT Level,   ");
            sql.append("        operaciones.tipo_operacion,   ");
            sql.append("        operaciones.numero_operacion,   ");
            sql.append("        operaciones.fecha_operacion,   ");
            sql.append("        operaciones.operacion_referencia,   ");
            sql.append("        operaciones.numero_referencia,   ");
            sql.append("        dru.DRU_CODIGO,   ");
            sql.append("        operaciones.valor_total,   ");
            sql.append("        operaciones.saldo_por_ejecutar,   ");
            sql.append("        rubro.UNI,   ");
            sql.append("        rubro.TIP,   ");
            sql.append("        rubro.CTA,   ");
            sql.append("        rubro.SCTA,   ");
            sql.append("        rubro.OBJ,   ");
            sql.append("        rubro.ORD,   ");
            sql.append("        rubro.SORD,   ");
            sql.append("        rubro.FUENTE,   ");
            sql.append("        rubro.DESCRIPCION,   ");
            sql.append("        ffi.FFI_CODIGO_FUENTE,   ");
            sql.append("        dff.DFF_CODIGO_RECURSO   ");
            sql.append("       FROM operaciones   ");
            sql.append("       INNER JOIN sii_detalle_rubro dru   ");
            sql.append("       ON operaciones.DRU_CODIGO = dru.DRU_CODIGO   ");
            sql.append("       INNER JOIN rubro   ");
            sql.append("       ON dru.INTERNO   = rubro.INTERNO   ");
            sql.append("       AND dru.VIGENCIA = rubro.VIGENCIA   ");
            sql.append("       INNER JOIN sii_dtlle_fuente_financiacion dff   ");
            sql.append("       ON dru.DFF_CODIGO = dff.DFF_CODIGO   ");
            sql.append("       INNER JOIN sii_fuente_financiacion ffi   ");
            sql.append("       ON dff.FFI_CODIGO                      = ffi.FFI_CODIGO   ");
            sql.append("       WHERE NVL(operaciones.valor_total, 0) <> 0   ");
            sql.append("        START WITH REPLACE(operaciones.tipo_operacion, ' (4*1000)', '') LIKE :tipoOperacion   ");
            sql.append("       AND operaciones.numero_operacion                 = #numeroOperacion   ");
            sql.append("        CONNECT BY Prior operaciones.numero_referencia = operaciones.numero_operacion   ");
            sql.append("       AND Prior operaciones.operacion_referencia       = operaciones.tipo_operacion   ");
            
//Filtros//
            if (filtros != null) {
                // FILTRAR POR FECHA
                if (filtros.getFechaIniSeleccionada() != null && filtros.getFechaFinSeleccionada() != null) {
                    sql.append(" AND TRUNC(dc.DCO_FECHA_OPER) BETWEEN #fechaIni  AND #fechaFin ");
                }
                // FILTRAR POR RUBRO
                if(filtros.getRubroInicial() !=null && filtros.getRubroFinal() !=null){
                    sql.append(" AND TRUNC(dc.RUBRO)BETWEEN #rubroInicial AND # rubroFinal ");
                }
                
                // FILTRAR POR FUENTE DE FINANCIACION
                if (filtros.getFfCodigoSeleccionado() != null) {
                    sql.append(" AND ic.FFC_CODIGO = #ffCodigo ");
                }

            }

            Query query = manager.createQuery(sql.toString());
            query.setParameter("fechaIni", filtros.getFechaIniSeleccionada());
            query.setParameter("fechaFin", filtros.getFechaFinSeleccionada());
            query.setParameter("ffcCodigo", filtros.getFfCodigoSeleccionado());
            query.setParameter("rubroInicial", filtros.getRubroInicial());
            query.setParameter("rubroFinal", filtros.getRubroFinal());
            query.setParameter("numeroOperacion", filtros.getNuOperacion());
            query.setParameter("tipoOperacion", filtros.getTipoOperacion());
            
            List<Object[]> rows = query.getResultList();


            if (rows != null) {

                resultado = new ArrayList<ReporteRelacionOperacionesVO>();

                for (Object[] row : rows) {
                    ReporteRelacionOperacionesVO reporteRelacionOperacionesVO = new ReporteRelacionOperacionesVO();

                    if (row[0] != null)
                        reporteRelacionOperacionesVO.setRubro((String) row[0]);

                    if (row[1] != null)
                        reporteRelacionOperacionesVO.setNumeroRubro(((BigDecimal) row[1]).longValue());

                    if (row[2] != null)
                        reporteRelacionOperacionesVO.setNombreRubro((String) row[2]);

                    // Solamente se visualizaran al momento de Filtrar por Fuente de financiacion.
                    if (!ocultarCampos || filtros.isFiltrarPorFuenteFinanciacion()) {
                        if (row[3] != null)
                            reporteRelacionOperacionesVO.setFfCodigoSeleccionado(((BigDecimal) row[3]).longValue());

                        if (row[4] != null)
                            reporteRelacionOperacionesVO.setDetalleFuenteFinanciacion((String) row[7]);
                    }
                    resultado.add(reporteRelacionOperacionesVO);

                }
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return (resultado);
    }

    public long consultarTipoOperacion(long concepto, String tipoOperacion) {
        return 0L;
    }
}
