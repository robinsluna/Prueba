/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 03-12-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.InteresCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.RepLiquidacionVO;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LiquidacionMesDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public LiquidacionMesDAO() {
        recursos = new Recursos();
    }
    
    public SiiLiquidacionMes actualizarLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) throws ExcepcionDAO {
        try {
            manager.merge(siiLiquidacionMes);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLiquidacionMes;
    }

    public SiiLiquidacionMes buscarLiquidacionMesPorId(Long IdLiquidacionMes) throws ExcepcionDAO {
        SiiLiquidacionMes siiLiquidacionMesRetorno = null;
        try {
            siiLiquidacionMesRetorno = manager.find(SiiLiquidacionMes.class, IdLiquidacionMes);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLiquidacionMesRetorno;
    }

    public SiiLiquidacionMes insertarLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) throws ExcepcionDAO {
        try {
            manager.persist(siiLiquidacionMes);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLiquidacionMes;
    }

    public Long buscarConsecutivoCuotaPorCodigoContrato(Long codigoContrato) throws ExcepcionDAO {
        Long consecutivo;
        BigDecimal tmp;
        try {
            StringBuilder sql = new StringBuilder();


            sql.append("SELECT NVL(MAX(lm.LME_NUM_CUOTA),0) FROM SII_LIQUIDACION_MES lm ");
            sql.append("INNER JOIN SII_CONTRATO contrato on lm.con_codigo = contrato.con_codigo ");
            sql.append("where lm.con_codigo= #codigoContrato");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codigoContrato", codigoContrato);
            tmp = (BigDecimal) query.getSingleResult();
            if (tmp != null) {
                consecutivo = tmp.longValue();
            } else {
                consecutivo = 0L;
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    public Calendar obtenerUltimoMesLiquidado(Long idCodigoContrato) throws ExcepcionDAO {
        Calendar fecha;
        try {
            fecha = Calendar.getInstance();
            StringBuilder sql = new StringBuilder();
            sql.append(" select Co.Mes_Codigo, Lm.Lme_Vigencia");
            sql.append(" from sii_cuota_operador co ");
            sql.append(" Inner Join sii_liquidacion_mes lm on (lm.lme_codigo = co.lme_Codigo) ");  
            sql.append(" Inner Join sii_Contrato con on (lm.con_codigo = con.con_codigo) ");
            sql.append(" where con.con_codigo = #idCodigoContrato");
            sql.append(" order by Lm.Liq_Fecha desc");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoContrato", idCodigoContrato);
            List<Object[]> results = query.getResultList();
            
            if (results != null && !results.isEmpty()) {
                    fecha.set(((BigDecimal) results.get(0)[1]).intValue(), ((BigDecimal) results.get(0)[0]).intValue(), 1);
                    //fecha.add(Calendar.MONTH, 1);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return fecha;
    }

    public List<SiiLiquidacionMes> obtenerLiquidacionPorContratoYConceptos(Long idCodigoContrato, Date fechaInicio,
                                                                           Date fechaFin) throws ExcepcionDAO {

        List<SiiLiquidacionMes> miListaLiquidacion = new ArrayList<SiiLiquidacionMes>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select lm.liq_concepto,co.cop_valor, Co.Mes_Codigo, Lm.Lme_Vigencia");
            sql.append(" from sii_cuota_operador co ");
            sql.append(" Inner Join sii_liquidacion_mes lm on (lm.lme_codigo = co.lme_Codigo) ");  
            sql.append(" Inner Join sii_Contrato con on (lm.con_codigo = con.con_codigo) ");
            sql.append(" where con.con_codigo = #idCodigoContrato");
            sql.append(" and trunc(lm.liq_fecha) BETWEEN #fechaInicio and #fechaFin and Co.Cop_Cancelada <>'I' order by Lm.Liq_Fecha desc");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoContrato", idCodigoContrato);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    SiiLiquidacionMes liquidacion = new SiiLiquidacionMes();
                    liquidacion.setLiqConcepto((String) object[0]);
                    liquidacion.setLiqValor((BigDecimal) object[1]);
                    liquidacion.setLmeCodigo(((BigDecimal) object[2]).longValue());
					liquidacion.setLmeVigencia(((BigDecimal) object[3]).intValue());
                    miListaLiquidacion.add(liquidacion);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaLiquidacion;
    }
    
    public List<OficioLiquidacionPrevioVO> buscarInventarioPorContratoMES(Long idCodigoContrato) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaLiquidacion = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select ta.tap_codigo,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) DE,");
            sql.append(" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");
            //sql.append(" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo,Ins.Met_Codigo, met.met_online");
            sql.append(" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo, con.con_fecha_fin_defin");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" Inner Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
            sql.append(" Inner Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
            //sql.append(" Inner Join sii_met met on (ins.met_codigo = met.met_codigo)");
            sql.append(" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('A') ");
            sql.append(" order by Inv.Est_Codigo");

            /*sql.append (" select ta.tap_codigo,");
                    sql.append (" sum((substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1))) DE,");
                    sql.append (" sum(substr(TAP_GAST_ADM_FORMULA,1,INSTR(TAP_GAST_ADM_FORMULA,'*')-1)*(substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia  desc ) where con=1))) GA,");
                    sql.append (" sum((substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1)) +");
                    sql.append (" (substr(TAP_GAST_ADM_FORMULA,1,INSTR(TAP_GAST_ADM_FORMULA,'*')-1)*(substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1)))) VLRMENSUAL,");
                    sql.append (" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");
                    sql.append (" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo ");
                    sql.append (" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo and tap_codigo_apuesta <>'NA') ");
                    sql.append (" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
                    sql.append (" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
                    sql.append (" Inner Join Sii_Establecimiento est on (Inv.Est_Codigo = Inv.Est_Codigo)");
                    sql.append (" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('A','PR')");
                    sql.append (" group by Inv.Est_Codigo,ta.tap_codigo,Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,");
                    sql.append (" Ta.Tap_Min_Sillas, inv.inv_sillas, con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq,");
                    sql.append (" inv.inv_fecha_fin_liq,Tap_Der_Expl_Formula,TAP_GAST_ADM_FORMULA ,Tap_Der_Expl_Formula,Inv.Est_Codigo");*/


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoContrato", idCodigoContrato);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO liquidacion = new OficioLiquidacionPrevioVO();
                    liquidacion.setDerechosExplMensual((BigDecimal) object[1]);
                    //liquidacion.setGastosAdministracionMensual((BigDecimal)object[2]);
                    //liquidacion.setValorTotalMensual((BigDecimal)object[3]);
                    liquidacion.setNumeroContrato((String) object[2]);
                    liquidacion.setConCodigo(((BigDecimal) object[3]).longValue());
                    liquidacion.setCodigoApuesta((String) object[4]);
                    liquidacion.setMinimoSillas(((BigDecimal) object[5]).intValue());
                    liquidacion.setInventarioSillas(((BigDecimal) object[6]).longValue());
                    liquidacion.setFechaInicioContrato((Date) object[7]);
                    liquidacion.setFechaFinContrato((Date) object[8]);
                    liquidacion.setFechaInicioLiq((Date) object[9]);
                    liquidacion.setFechaFinLiq((Date) object[10]);
                    liquidacion.setIdEstablecimiento(((BigDecimal) object[11]).longValue());
                    liquidacion.setFechaFinDefinitiva((Date) object[12]);
                   //liquidacion.setIdMet(((BigDecimal) object[12]).longValue());
                   // liquidacion.setIndicadorOnLine((String) object[13]);

                    miListaLiquidacion.add(liquidacion);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaLiquidacion;
    }


    public List<OficioLiquidacionPrevioVO> buscarInventarioPorContrato(Long idCodigoContrato) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaLiquidacion = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select ta.tap_codigo,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula)) DE,");
            sql.append(" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");            
            sql.append(" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo, con.con_fecha_fin_defin");
            sql.append(" ,Ins.Met_Codigo, met.met_online, met.met_uid");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
            sql.append(" left outer Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" left outer Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" left outer Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
            sql.append(" left outer Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
            sql.append(" left outer Join sii_met met on (ins.met_codigo = met.met_codigo)");
            sql.append(" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('A','PR','R') ");            
            sql.append(" order by Inv.Est_Codigo");

            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoContrato", idCodigoContrato);
            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO liquidacion = new OficioLiquidacionPrevioVO();
					liquidacion.setTapCodigo(((BigDecimal) object[0]).longValue());
                    liquidacion.setDerechosExplMensual((BigDecimal) object[1]);
                    //liquidacion.setGastosAdministracionMensual((BigDecimal)object[2]);
                    //liquidacion.setValorTotalMensual((BigDecimal)object[3]);
                    liquidacion.setNumeroContrato((String) object[2]);
                    liquidacion.setConCodigo(((BigDecimal) object[3]).longValue());
                    liquidacion.setCodigoApuesta((String) object[4]);
                    liquidacion.setMinimoSillas(((BigDecimal) object[5]).intValue());
                    liquidacion.setInventarioSillas(((BigDecimal) object[6]).longValue());
                    liquidacion.setFechaInicioContrato((Date) object[7]);
                    liquidacion.setFechaFinContrato((Date) object[8]);
                    liquidacion.setFechaInicioLiq((Date) object[9]);
                    liquidacion.setFechaFinLiq((Date) object[10]);
                    liquidacion.setIdEstablecimiento(((BigDecimal) object[11]).longValue());
                    liquidacion.setFechaFinDefinitiva((Date) object[12]);
					if(object[13]!= null){
						liquidacion.setIdMet(((BigDecimal) object[13]).longValue());
						liquidacion.setIndicadorOnLine((String) object[14]);
						liquidacion.setNuc((String) object[15]);
					}

                    miListaLiquidacion.add(liquidacion);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaLiquidacion;
    }


    public List<InteresCuotaVO> EjecutarInteresMensual(Date fechaActual) throws ExcepcionDAO {
        List<InteresCuotaVO> respuesta = new ArrayList();
        int year = 365;

        try {
            StringBuilder sql = new StringBuilder();
            //GregorianCalendar calendar = new GregorianCalendar();
            Calendar calendarFechaActual = Calendar.getInstance();
            calendarFechaActual.setTime(fechaActual);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaActual);
            cal.set(Calendar.HOUR_OF_DAY, 00);
            cal.set(Calendar.MINUTE, 00);
            cal.set(Calendar.SECOND, 00);
        
            fechaActual = cal.getTime();
           
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String fechaSql  = "TO_DATE('" + formatter.format(fechaActual) + "','YYYY/MM/DD HH24:MI:SS') ";

           /* if (calendar.isLeapYear(calendarFechaActual.get(Calendar.YEAR))) {
                year = 366;
            }*/
            // walter becerra se cambio script anterior .
           sql.append(" select * from (  ");
           sql.append("  select  case when tasa>0 then (saldo*tasa/100/("+ year +")) else (case when tasa2>0 then (saldo*tasa2/100/("+ year +"))end )end as interes,saldo  as base,"); 
                        sql.append(" case when tasa>0 then tasa else(CASE WHEN  tasa2>0 THEN TASA2 END)END AS TASA,"); 
            sql.append("                 COD_CUOTA as  COP_CODIGO, DCC_TIPO,per_codigo,DCC_NUMERO_CUOTA,DCC_CONTRATO,'' as numresolucion  "); 
            sql.append("                from(  "); 
            sql.append("                   select per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA-DCC_VALOR_PAGADO as saldo ,TASA,TASA2 from ("); 
            sql.append("                     select per.per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA,sum(DCC_VALOR_PAGADO) as DCC_VALOR_PAGADO,"); 
            sql.append("                             case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE " + fechaSql + "  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  "); 
            sql.append("                                   ELSE 0  END  AS TASA ,"); 
            sql.append("                                   case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE " + fechaSql + " BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   "); 
            sql.append("                                   ELSE 0  END  AS TASA2  "); 
            sql.append("                     from ("); 
            sql.append("              SELECT distinct 2,CONTRATO as DCC_CONTRATO,NUMERO_CUOTA as DCC_NUMERO_CUOTA,VIGENCIA as DCC_VIGENCIA,MES as MES_CODIGO,FECHA_LIMITE_PAGO as DCC_FECHA_LIMITE_PAGO,FECHA_PAGO as DCC_FECHA_PAGO, "); 
            sql.append("                         VALOR_CUOTA as DCC_VALOR_CUOTA,VALOR_PAGADO AS DCC_VALOR_PAGADO,"); 
            sql.append("                        (VALOR_CUOTA-VALOR_PAGADO) AS DCC_SALDO_CUOTA,CASE WHEN(((CASE WHEN (FECHA_PAGO IS NOT NULL) THEN  "); 
            sql.append("                        ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0) ELSE 0 END) <0) OR ((CASE WHEN(FECHA_PAGO IS NOT NULL) THEN ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)  "); 
            sql.append("                        ELSE 0 END) >200000))THEN 0 ELSE ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)END AS DCC_DIAS_MORA,  "); 
            sql.append("                       TIPO AS DCC_TIPO, CCUCODIGO AS CCU_CODIGO,FECHA_INICIO_CONTRATO as DCC_FECHA_INI_CONTRATO,  "); 
            sql.append("                        FECHA_FIN_CONTRATO as DCC_FECHA_FIN_CONTRATO, COD_CUOTA,OPE_CODIGO "); 
            sql.append("                        FROM  "); 
                                  
             sql.append("                       (  "); 
             sql.append("                       SELECT CUO.COP_CODIGO AS COD_CUOTA, CON.CON_NUMERO AS CONTRATO ,CON.CON_FECHA_INI AS FECHA_INICIO_CONTRATO ,  "); 
             sql.append("                       CON.CON_FECHA_FIN    AS FECHA_FIN_CONTRATO , CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO , "); 
             sql.append("                      (select ccuo.ccu_nombre from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS TIPO ,  "); 
             sql.append("                       CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES  ,"); 
             sql.append("                       CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO , CUO.CCU_CODIGO  AS CCUCODIGO,  "); 
             sql.append("                      VDREC.DRE_CODIGO,OPE_CODIGO "); 
             sql.append("                      FROM (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG, ");   
             sql.append("                         COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU  "); 
             sql.append("                                               INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO "); 
             sql.append("                                               WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > " + fechaSql + " ),0) AS COP_VALOR,COP0.COP_CANCELADA,"); 
             sql.append("                                               COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.ATE_CODIGO,"); 
             sql.append("                         (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0 "); 
             sql.append("                           INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO "); 
             sql.append("                           INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO "); 
             sql.append("                           INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " + fechaSql + ""); 
             sql.append("                           WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES "); 
             sql.append("                         FROM SII_CUOTA_OPERADOR COP0   "); 
             sql.append("                       where COP0.cop_fecha_lim_pag < " + fechaSql + "   ");                   
             sql.append("                         ) CUO  "); 
             sql.append("                       LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAGADO  ");                    
             sql.append("                                   FROM SII_DETALLE_DECLARACION DDE0 "); 
             sql.append("                                   INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO "); 
             sql.append("                                   WHERE DOP.DOP_FECHA < " + fechaSql + ") DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO  "); 
                                       
             sql.append("                       LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO,"); 
             sql.append("                                    (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR   "); 
             sql.append("                                     INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA >" + fechaSql + ""); 
             sql.append("                                     WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC "); 
                                              
             sql.append("                                   FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " + fechaSql + ""); 
             sql.append("                       INNER JOIN SII_LIQUIDACION_MES LME ON LME.LME_CODIGO = CUO.LME_CODIGO  "); 
             sql.append("                       INNER JOIN SII_CONTRATO CON ON LME.CON_CODIGO = CON.CON_CODIGO  "); 
             sql.append("                       INNER JOIN SII_OPERADOR OPE ON OPE.OPE_CODIGO = CON.OPE_CODIGO  "); 
             sql.append("                       INNER JOIN SII_PERSONA PERSO ON PERSO.PER_CODIGO   = OPE.PER_CODIGO  "); 
             sql.append("                       WHERE to_date('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql + ""); 
             sql.append("                         and  ((CON.CON_FECHA_INI >= '30/04/2007'  AND CON.CON_FECHA_FIN     >= '30/04/2012')  or CON.con_numero IN ('C0712') )"); 
             sql.append("                          and CON.con_numero NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732','C0800') "); 
             sql.append("                                      and CUO.COP_CANCELADA != 'I' "); 
             sql.append("                       ) TODO  "); 
                                  
             sql.append("                        ORDER BY CONTRATO,VIGENCIA,  NUMERO_CUOTA , TIPO  "); 
             sql.append("                          )sub1 "); 
             sql.append("                    left join sii_concepto_cuota con on sub1.ccu_codigo=con.ccu_codigo "); 
             sql.append("                   left join sii_operador op on sub1.ope_codigo=op.ope_codigo  "); 
             sql.append("                   left join sii_persona per on per.per_codigo = op.per_codigo  "); 
             sql.append("                   where CCU_TIPO_TASA != 'N/A'  "); 
             sql.append("                   group by per.per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA,CCU_TIPO_TASA "); 
             sql.append("            )   "); 

            
            /*   //  multas y conceptos de la tabla multas
          sql.append(" union ");
          sql.append(" select * from(   ");
          sql.append(" select  per_codigo, COP_CODIGO,cop_fecha_lim_pag,connumero,cop_num_cuota ,ccu_nombre, ");
          sql.append(" case when RECAUDO is null then  valorcuota  else  saldo end as saldo,   ");
          sql.append(" case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_char('01/01/2014')  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  ");
          sql.append(" else 0  end  AS TASA ,   ");
          sql.append(" case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_char('01/01/2014')  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   ");
          sql.append(" else 0  end  AS TASA2   from(   ");
          sql.append(" select    per.per_codigo, e.cop_codigo ,e.cop_fecha_lim_pag,con.CCU_TIPO_TASA,(case when  g.con_numero is null then mul.MUL_NUM_RESOL else g.con_numero end )as connumero,e.cop_num_cuota,con.ccu_nombre,   ");
          sql.append(" e.cop_valor as valorcuota,sum( dt.dde_valor_pagado) as recaudo,(e.cop_valor-sum(dt.dde_valor_pagado)) as saldo     ");
          sql.append(" FROM SII_CUOTA_OPERADOR E     ");
          sql.append(" left join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo    ");
          sql.append(" left JOIN SII_LIQUIDACION_MES L ON L.LME_CODIGO = E.LME_CODIGO AND L.MES_CODIGO = E.MES_CODIGO     ");
          sql.append(" left JOIN SII_CONTRATO G ON g.ope_codigo=e.ope_codigo    ");
          sql.append(" inner join sii_concepto_cuota con on e.ccu_codigo=con.ccu_codigo   ");
          sql.append(" inner join sii_multa mul on e.mul_codigo=mul.mul_codigo  ");
          sql.append(" inner join sii_operador op on e.ope_codigo=op.ope_codigo  ");
          sql.append(" inner join sii_persona per on per.per_codigo = op.per_codigo  ");
          sql.append(" where  mul.mul_codigo is not null    ");
          sql.append(" group by e.cop_codigo, per.per_codigo, con.CCU_TIPO_TASA, e.cop_fecha_lim_pag, g.con_numero,mul.MUL_NUM_RESOL,e.cop_num_cuota,con.ccu_nombre, e.cop_valor    ");
          sql.append(" )) where saldo>0  ");
         */
         //interes para acuerdos de pago
          sql.append(" union     ");
          sql.append(" select * from(   ");
          sql.append(" select  per_codigo, COP_CODIGO,cop_fecha_lim_pag,connumero,cop_num_cuota ,ccu_nombre, ");
          sql.append(" case when RECAUDO is null then  valorcuota  else  saldo end as saldo,   ");
          sql.append(" case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE " + fechaSql + "  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  ");
          sql.append(" else 0  end  AS TASA ,   ");
          sql.append(" case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE " + fechaSql + "  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   ");
          sql.append(" else 0  end  AS TASA2   from(   ");
          sql.append(" select    per.per_codigo, e.cop_codigo ,e.cop_fecha_lim_pag,con.CCU_TIPO_TASA,(case when  g.con_numero is null then acu.apa_num_resol else g.con_numero end )as connumero,e.cop_num_cuota,con.ccu_nombre,    ");
          sql.append(" e.cop_valor as valorcuota,sum( dt.dde_valor_pagado) as recaudo,(e.cop_valor-sum(dt.dde_valor_pagado)) as saldo     ");
          sql.append(" FROM SII_CUOTA_OPERADOR E     ");
          sql.append(" left join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo     ");
          sql.append(" left JOIN SII_LIQUIDACION_MES L ON L.LME_CODIGO = E.LME_CODIGO AND L.MES_CODIGO = E.MES_CODIGO      ");
          sql.append(" left JOIN SII_CONTRATO G ON L.CON_CODIGO = G.CON_CODIGO     ");
          sql.append(" inner join sii_concepto_cuota con on e.ccu_codigo=con.ccu_codigo    ");
          sql.append(" inner join sii_acuerdo_pago acu on  e.apa_codigo=acu.apa_codigo    ");
          sql.append(" inner join sii_operador op on e.ope_codigo=op.ope_codigo    ");
          sql.append(" inner join sii_persona per on per.per_codigo = op.per_codigo    ");
          sql.append(" where  acu.apa_codigo is not null   and con.ccu_tipo_tasa != 'N/A' and cop_fecha_lim_pag <   " + fechaSql + "   and e.COP_CANCELADA != 'I'  ");
          sql.append(" group by e.cop_codigo, per.per_codigo, con.CCU_TIPO_TASA, e.cop_fecha_lim_pag, g.con_numero,acu.apa_num_resol,e.cop_num_cuota,con.ccu_nombre, e.cop_valor     ");
          sql.append("  ) )where saldo>0 ) ) where interes > 0.49  ");
           /*
          sql.append("  union   ");
            //interes para sanciones
          sql.append(" select * from(   ");
          sql.append(" select  per_codigo, COP_CODIGO,cop_fecha_lim_pag,connumero,cop_num_cuota ,ccu_nombre, ");
          sql.append(" case when RECAUDO is null then  valorcuota  else  saldo end as saldo,   ");
          sql.append(" case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_char('01/01/2014')  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  ");
          sql.append(" else 0  end  AS TASA ,   ");
          sql.append(" case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_char('01/01/2014')  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   ");
          sql.append(" else 0  end  AS TASA2   from(   ");
          sql.append(" select    per.per_codigo, e.cop_codigo ,e.cop_fecha_lim_pag,con.CCU_TIPO_TASA,(case when  g.con_numero is null then san.san_num_resol else g.con_numero end )as connumero,e.cop_num_cuota,con.ccu_nombre,  ");
          sql.append(" e.cop_valor as valorcuota,sum( dt.dde_valor_pagado) as recaudo,(e.cop_valor-sum(dt.dde_valor_pagado)) as saldo  ");
          sql.append(" FROM SII_CUOTA_OPERADOR E   ");
          sql.append(" left join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo  ");
          sql.append(" left JOIN SII_LIQUIDACION_MES L ON L.LME_CODIGO = E.LME_CODIGO AND L.MES_CODIGO = E.MES_CODIGO    ");
          sql.append(" left JOIN SII_CONTRATO G ON L.CON_CODIGO = G.CON_CODIGO  ");
          sql.append(" inner join sii_concepto_cuota con on e.ccu_codigo=con.ccu_codigo  ");
          sql.append(" inner join sii_sancion  san on  e.san_codigo=san.san_codigo  ");
          sql.append(" inner join sii_operador op on e.ope_codigo=op.ope_codigo  ");
          sql.append(" inner join sii_persona per on per.per_codigo = op.per_codigo  ");
          sql.append(" where  san.san_num_resol is not null  ");
          sql.append(" group by e.cop_codigo, per.per_codigo, con.CCU_TIPO_TASA, e.cop_fecha_lim_pag, g.con_numero,san.san_num_resol,e.cop_num_cuota,con.ccu_nombre, e.cop_valor   ");
          sql.append(" ))where saldo>0  ");
          sql.append("  )  ");
            */
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("fecha", fechaSql);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {

                    InteresCuotaVO interes = new InteresCuotaVO();
                    interes.setIcuValor(((BigDecimal) object[0]));
                    interes.setIcuFecha(fechaActual);
                    interes.setIcuBaseCalc(((BigDecimal) object[1]));
                    interes.setIcuTasaAplic(((BigDecimal) object[2]));
                    interes.setIcuCancelado("N");
                    CuotaOperadorVO cuota = new CuotaOperadorVO();
                    cuota.setCopCodigo(((BigDecimal) object[3]).longValue());
                    interes.setCuotaOperadorVo(cuota);
                    interes.setConcepto((String) object[4]);
                    PersonaVO personaVo = new PersonaVO();
                    personaVo.setPerCodigo(((BigDecimal) object[5]).longValue());
                    interes.setPersonaVo(personaVo);
                    interes.setNumeroCuota(((BigDecimal) object[6]).longValue());
                    interes.setNumeroContrato((String) object[7]);
                    interes.setNumeroResolucion((String) object[8]);
                    respuesta.add(interes);
                }

            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return respuesta;
    }


    /**
     *Metodo encargado de consultar la liquidacion para un operador de determinado mes, tambien incluye el
     * concepto de liquidacion el cual puede ser DE o GA
     * @author David Tafur
     * @param codigoOperador
     * @param codigoContrato
     * @param codigoMes
     * @param conceptoLiq
     * @return
     * @throws ExcepcionDAO
     */
    public SiiLiquidacionMes consultarLiquidacionMesXOperadorXContratoXMesXConcepto(long codigoOperador,
                                                                                    long codigoContrato, long codigoMes,
                                                                                    String conceptoLiq,
                                                                                    int anoVigencia) throws ExcepcionDAO {
        SiiLiquidacionMes siiLiquidacionMes = new SiiLiquidacionMes();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT liq FROM SiiLiquidacionMes liq");
            sql.append(" INNER JOIN liq.siiContrato cont");
            sql.append(" INNER JOIN liq.siiMes mes");
            sql.append(" INNER JOIN cont.siiOperador ope");
            sql.append(" WHERE ope.opeCodigo = :codigoOperador");
            sql.append(" AND cont.conCodigo = :codigoContrato");
            sql.append(" AND mes.mesCodigo = :codigoMes");
            sql.append(" AND liq.liqConcepto = :conceptoLiq");
            sql.append(" AND liq.lmeVigencia = :anoVigencia");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoOperador", codigoOperador);
            consulta.setParameter("codigoContrato", codigoContrato);
            consulta.setParameter("codigoMes", codigoMes);
            consulta.setParameter("conceptoLiq", conceptoLiq);
            consulta.setParameter("anoVigencia", anoVigencia);

            List<SiiLiquidacionMes> listaLiquidacionMes = new ArrayList<SiiLiquidacionMes>();
            listaLiquidacionMes = consulta.getResultList();

            if (listaLiquidacionMes.size() > 0) {
                siiLiquidacionMes = listaLiquidacionMes.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLiquidacionMes;
    }
    
    public List<RepLiquidacionVO> obtenerInventarioLiquidadoPorMesYVigencia(Integer vigencia, Integer mes, String contrato) throws ExcepcionDAO {

        List<RepLiquidacionVO> miListaLiquidacion = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select  Con.Con_Numero,co.cop_num_cuota,est.est_nombre,tj.tju_nombre, NVL(inv.inv_sillas,0),NVL(Ta.Tap_Min_Sillas,0),");
            sql.append(" Ta.Tap_codigo_Apuesta, ta.Tap_Der_Expl_Formula,PR.fn_calcula_de(Tap_Der_Expl_Formula) tarifames, ");
            sql.append(" (PR.fn_calcula_de(Tap_Der_Expl_Formula))/30 tarifadia, ");
            sql.append(" inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo) ");
            sql.append(" Inner Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo) ");
            sql.append(" Inner Join Sii_Tipo_Novedad tn on (Nov.Tno_Codigo = tn.Tno_Codigo)");
            sql.append(" Inner Join sii_operador op on (con.ope_codigo = op.ope_codigo)");
            sql.append(" Inner Join sii_persona per on  (op.per_codigo = per.per_codigo)");
            sql.append(" Inner Join sii_liquidacion_mes lm on (con.con_codigo = lm.con_codigo)");
            sql.append(" Inner Join Sii_Cuota_Operador co on (lm.lme_codigo = co.lme_codigo)");
            sql.append(" Inner Join Sii_Tipo_juego tj on (ta.tju_codigo= Tj.Tju_Codigo) where ");
            if(!contrato.equals("")){
                sql.append(" con.con_numero= #contrato and");
            }
            sql.append(" inv.inv_estado IN('A','R') and lm.lme_vigencia=#vigencia and lm.mes_codigo=#mes ");
            sql.append(" and lm.liq_concepto ='DE'");
            

            Query query = manager.createNativeQuery(sql.toString());
            if(!contrato.equals("")){
                query.setParameter("contrato", contrato);
            }
            query.setParameter("vigencia", vigencia);
            query.setParameter("mes", mes);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                miListaLiquidacion = new ArrayList<RepLiquidacionVO>();
                for (Object[] object : results) {
                    RepLiquidacionVO vo = new RepLiquidacionVO();
                    vo.setContrato((String) object[0]);
                    vo.setCuota(((BigDecimal) object[1]).intValue());
                    vo.setEstablecimiento((String) object[2]);
                    vo.setTipoElemento((String) object[3]);
                    vo.setNumeroSillas(((BigDecimal) object[4]).intValue());
                    vo.setMinimoSillas(((BigDecimal) object[5]).intValue());
                    vo.setTipoApuesta((String) object[6]);
                    vo.setTarifaMesFormula((String) object[7]);
                    vo.setTarifaMes((BigDecimal) object[8]);
                    vo.setTarifaDia((BigDecimal) object[9]);
                    vo.setFechaInicioLiq((Date) object[10]);
                    vo.setFechaFinLiq((Date) object[11]);                    
                    miListaLiquidacion.add(vo);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaLiquidacion;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     * @param conCodigo
     */
    public SiiLiquidacionMes ultimoMesContratoLiquidado(Long conCodigo) throws ExcepcionDAO {
        SiiLiquidacionMes siiLiquidacionMes = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT lme FROM SiiLiquidacionMes lme");
            sql.append(" WHERE lme.siiContrato.conCodigo = :conCodigo");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);

            List<SiiLiquidacionMes> siiLiquidacionMess = query.getResultList();
            if (siiLiquidacionMess != null && !siiLiquidacionMess.isEmpty()) {
                siiLiquidacionMes = siiLiquidacionMess.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLiquidacionMes;
    }
    
    public SiiLiquidacionMes buscarLiquidacionMesPorContratoPorVigenciaPorMesPorConceptoPorNit(String contrato, Integer vigencia, Integer mes, String concepto, String nit) throws ExcepcionDAO {
        SiiLiquidacionMes siiLiquidacionMes = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT lme FROM SiiLiquidacionMes lme");
            sql.append(" INNER JOIN lme.siiContrato con");
            sql.append(" INNER JOIN con.siiOperador ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" WHERE con.conNumero = :contrato");
            sql.append(" AND lme.lmeVigencia = :vigencia");
            sql.append(" AND lme.siiMes.mesCodigo = :mes");
            sql.append(" AND lme.liqConcepto = :concepto");
            sql.append(" AND per.perNumIdentificacion = :nit");
            sql.append(" AND per.siiTipoIdentificacion1.tidCodigo = " + EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId());

            Query query = manager.createQuery(sql.toString());
            query.setParameter("contrato", contrato);
            query.setParameter("vigencia", vigencia);
            query.setParameter("mes", mes);
            query.setParameter("concepto", concepto);
            query.setParameter("nit", nit);

            List<SiiLiquidacionMes> listaLiquidacionMes = query.getResultList();
            if (listaLiquidacionMes != null && !listaLiquidacionMes.isEmpty()) {
                siiLiquidacionMes = listaLiquidacionMes.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLiquidacionMes;
    }
    
    public List<InteresCuotaVO> buscarInteresDiarioXCUOTA(Date fechaActual,Integer numeroCuota,String conceptoCuota,String numContrato) throws ExcepcionDAO {
        List<InteresCuotaVO> respuesta = new ArrayList();
        int year = 365;

        try {
            StringBuilder sql = new StringBuilder();
            GregorianCalendar calendar = new GregorianCalendar();
            Calendar calendarFechaActual = Calendar.getInstance();
            calendarFechaActual.setTime(fechaActual);
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaActual);
            cal.set(Calendar.HOUR_OF_DAY, 00);
            cal.set(Calendar.MINUTE, 00);
            cal.set(Calendar.SECOND, 00);
        
            fechaActual = cal.getTime();
           
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String fechaSql  = "TO_DATE('" + formatter.format(fechaActual) + "','YYYY/MM/DD HH24:MI:SS') ";
            

            if (calendar.isLeapYear(calendarFechaActual.get(Calendar.YEAR))) {
                year = 366;
            }
        
           sql.append(" select * from (  ");
           sql.append("  select  case when tasa>0 then (saldo*tasa/100/("+ year +")) else (case when tasa2>0 then (saldo*tasa2/100/("+ year +"))end )end as interes,saldo  as base,"); 
                        sql.append(" case when tasa>0 then tasa else(CASE WHEN  tasa2>0 THEN TASA2 END)END AS TASA,"); 
            sql.append("                 COD_CUOTA as  COP_CODIGO, DCC_TIPO,per_codigo,DCC_NUMERO_CUOTA,DCC_CONTRATO,'' as numresolucion  "); 
            sql.append("                from(  "); 
            sql.append("                   select per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA-DCC_VALOR_PAGADO as saldo ,TASA,TASA2 from ("); 
            sql.append("                     select per.per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA,sum(DCC_VALOR_PAGADO) as DCC_VALOR_PAGADO,"); 
            sql.append("                             case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE (" + fechaSql + "  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA ) and TIS_ACTIVO='S' )  "); 
            sql.append("                                   ELSE 0  END  AS TASA ,"); 
            sql.append("                                   case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE " + fechaSql + " BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   "); 
            sql.append("                                   ELSE 0  END  AS TASA2  "); 
            sql.append("                     from ("); 
            sql.append("              SELECT distinct 2,CONTRATO as DCC_CONTRATO,NUMERO_CUOTA as DCC_NUMERO_CUOTA,VIGENCIA as DCC_VIGENCIA,MES as MES_CODIGO,FECHA_LIMITE_PAGO as DCC_FECHA_LIMITE_PAGO,FECHA_PAGO as DCC_FECHA_PAGO, "); 
            sql.append("                         VALOR_CUOTA as DCC_VALOR_CUOTA,VALOR_PAGADO AS DCC_VALOR_PAGADO,"); 
            sql.append("                        (VALOR_CUOTA-VALOR_PAGADO) AS DCC_SALDO_CUOTA,CASE WHEN(((CASE WHEN (FECHA_PAGO IS NOT NULL) THEN  "); 
            sql.append("                        ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0) ELSE 0 END) <0) OR ((CASE WHEN(FECHA_PAGO IS NOT NULL) THEN ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)  "); 
            sql.append("                        ELSE 0 END) >200000))THEN 0 ELSE ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)END AS DCC_DIAS_MORA,  "); 
            sql.append("                       TIPO AS DCC_TIPO, CCUCODIGO AS CCU_CODIGO,FECHA_INICIO_CONTRATO as DCC_FECHA_INI_CONTRATO,  "); 
            sql.append("                        FECHA_FIN_CONTRATO as DCC_FECHA_FIN_CONTRATO, COD_CUOTA,OPE_CODIGO "); 
            sql.append("                        FROM  "); 
                                  
             sql.append("                       (  "); 
             sql.append("                       SELECT CUO.COP_CODIGO AS COD_CUOTA, CON.CON_NUMERO AS CONTRATO ,CON.CON_FECHA_INI AS FECHA_INICIO_CONTRATO ,  "); 
             sql.append("                       CON.CON_FECHA_FIN    AS FECHA_FIN_CONTRATO , CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO , "); 
             sql.append("                      (select ccuo.ccu_nombre from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS TIPO ,  "); 
             sql.append("                       CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES  ,"); 
             sql.append("                       CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO , CUO.CCU_CODIGO  AS CCUCODIGO,  "); 
             sql.append("                      VDREC.DRE_CODIGO,OPE_CODIGO "); 
             sql.append("                      FROM (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG, ");   
             sql.append("                         COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU  "); 
             sql.append("                                               INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO "); 
             sql.append("                                               WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > " + fechaSql + " ),0) AS COP_VALOR,COP0.COP_CANCELADA,"); 
             sql.append("                                               COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.ATE_CODIGO,"); 
             sql.append("                         (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0 "); 
             sql.append("                           INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO "); 
             sql.append("                           INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO "); 
             sql.append("                           INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " + fechaSql + ""); 
             sql.append("                           WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES "); 
             sql.append("                         FROM SII_CUOTA_OPERADOR COP0   "); 
             sql.append("                       where COP0.cop_fecha_lim_pag < " + fechaSql + "   ");                   
             sql.append("                         ) CUO  "); 
             sql.append("                       LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAGADO  ");                    
             sql.append("                                   FROM SII_DETALLE_DECLARACION DDE0 "); 
             sql.append("                                   INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO "); 
             sql.append("                                   WHERE DOP.DOP_FECHA < " + fechaSql + ") DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO  "); 
                                       
             sql.append("                       LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO,"); 
             sql.append("                                   (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR   "); 
             sql.append("                                    INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA >" + fechaSql + ""); 
             sql.append("                                    WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC "); 
                                              
             sql.append("                                   FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " + fechaSql + ""); 
             sql.append("                                   INNER JOIN SII_LIQUIDACION_MES LME ON LME.LME_CODIGO = CUO.LME_CODIGO  "); 
             sql.append("                                   INNER JOIN SII_CONTRATO CON ON LME.CON_CODIGO = CON.CON_CODIGO  "); 
             sql.append("                                   INNER JOIN SII_OPERADOR OPE ON OPE.OPE_CODIGO = CON.OPE_CODIGO  "); 
             sql.append("                                   INNER JOIN SII_PERSONA PERSO ON PERSO.PER_CODIGO   = OPE.PER_CODIGO  "); 
             sql.append("                                   WHERE to_date('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql + ""); 
             sql.append("                                   and  ((CON.CON_FECHA_INI >= '30/04/2007'  AND CON.CON_FECHA_FIN     >= '30/04/2012')  or CON.con_numero IN ('C0712') )"); 
             sql.append("                                   and CON.con_numero IN ('" +numContrato + "')   "); 
                                      
             sql.append("                       ) TODO  WHERE NUMERO_CUOTA = "+ numeroCuota +" AND TIPO = '"+ conceptoCuota +"' "); 
                                  
             sql.append("                        ORDER BY CONTRATO,VIGENCIA,  NUMERO_CUOTA , TIPO  "); 
             sql.append("                          )sub1 "); 
             sql.append("                    left join sii_concepto_cuota con on sub1.ccu_codigo=con.ccu_codigo "); 
             sql.append("                   left join sii_operador op on sub1.ope_codigo=op.ope_codigo  "); 
             sql.append("                   left join sii_persona per on per.per_codigo = op.per_codigo  "); 
             sql.append("                   where CCU_TIPO_TASA != 'N/A'  "); 
             sql.append("                   group by per.per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA,CCU_TIPO_TASA "); 
             sql.append("            )   "); 

            
            /*   //  multas y conceptos de la tabla multas
          sql.append(" union ");
          sql.append(" select * from(   ");
          sql.append(" select  per_codigo, COP_CODIGO,cop_fecha_lim_pag,connumero,cop_num_cuota ,ccu_nombre, ");
          sql.append(" case when RECAUDO is null then  valorcuota  else  saldo end as saldo,   ");
          sql.append(" case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_char('01/01/2014')  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  ");
          sql.append(" else 0  end  AS TASA ,   ");
          sql.append(" case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_char('01/01/2014')  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   ");
          sql.append(" else 0  end  AS TASA2   from(   ");
          sql.append(" select    per.per_codigo, e.cop_codigo ,e.cop_fecha_lim_pag,con.CCU_TIPO_TASA,(case when  g.con_numero is null then mul.MUL_NUM_RESOL else g.con_numero end )as connumero,e.cop_num_cuota,con.ccu_nombre,   ");
          sql.append(" e.cop_valor as valorcuota,sum( dt.dde_valor_pagado) as recaudo,(e.cop_valor-sum(dt.dde_valor_pagado)) as saldo     ");
          sql.append(" FROM SII_CUOTA_OPERADOR E     ");
          sql.append(" left join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo    ");
          sql.append(" left JOIN SII_LIQUIDACION_MES L ON L.LME_CODIGO = E.LME_CODIGO AND L.MES_CODIGO = E.MES_CODIGO     ");
          sql.append(" left JOIN SII_CONTRATO G ON g.ope_codigo=e.ope_codigo    ");
          sql.append(" inner join sii_concepto_cuota con on e.ccu_codigo=con.ccu_codigo   ");
          sql.append(" inner join sii_multa mul on e.mul_codigo=mul.mul_codigo  ");
          sql.append(" inner join sii_operador op on e.ope_codigo=op.ope_codigo  ");
          sql.append(" inner join sii_persona per on per.per_codigo = op.per_codigo  ");
          sql.append(" where  mul.mul_codigo is not null    ");
          sql.append(" group by e.cop_codigo, per.per_codigo, con.CCU_TIPO_TASA, e.cop_fecha_lim_pag, g.con_numero,mul.MUL_NUM_RESOL,e.cop_num_cuota,con.ccu_nombre, e.cop_valor    ");
          sql.append(" )) where saldo>0  ");
         */
         //interes para acuerdos de pago
          sql.append(" union     ");
          sql.append(" select * from(   ");
          sql.append(" select  per_codigo, COP_CODIGO,cop_fecha_lim_pag,connumero,cop_num_cuota ,ccu_nombre, ");
          sql.append(" case when RECAUDO is null then  valorcuota  else  saldo end as saldo,   ");
          sql.append(" case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE " + fechaSql + "  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  ");
          sql.append(" else 0  end  AS TASA ,   ");
          sql.append(" case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE " + fechaSql + "  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   ");
          sql.append(" else 0  end  AS TASA2   from(   ");
          sql.append(" select    per.per_codigo, e.cop_codigo ,e.cop_fecha_lim_pag,con.CCU_TIPO_TASA,(case when  g.con_numero is null then acu.apa_num_resol else g.con_numero end )as connumero,e.cop_num_cuota,con.ccu_nombre,    ");
          sql.append(" e.cop_valor as valorcuota,sum( dt.dde_valor_pagado) as recaudo,(e.cop_valor-sum(dt.dde_valor_pagado)) as saldo     ");
          sql.append(" FROM SII_CUOTA_OPERADOR E     ");
          sql.append(" left join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo     ");
          sql.append(" left JOIN SII_LIQUIDACION_MES L ON L.LME_CODIGO = E.LME_CODIGO AND L.MES_CODIGO = E.MES_CODIGO      ");
          sql.append(" left JOIN SII_CONTRATO G ON L.CON_CODIGO = G.CON_CODIGO     ");
          sql.append(" inner join sii_concepto_cuota con on e.ccu_codigo=con.ccu_codigo    ");
          sql.append(" inner join sii_acuerdo_pago acu on  e.apa_codigo=acu.apa_codigo    ");
          sql.append(" inner join sii_operador op on e.ope_codigo=op.ope_codigo    ");
          sql.append(" inner join sii_persona per on per.per_codigo = op.per_codigo    ");
          sql.append(" where  acu.apa_codigo is not null   and con.ccu_tipo_tasa != 'N/A' and cop_fecha_lim_pag <   " + fechaSql + "   ");
          sql.append(" and g.con_numero in ('" +numContrato + "') and e.COP_NUM_CUOTA = "+ numeroCuota +"    ");
          sql.append(" group by e.cop_codigo, per.per_codigo, con.CCU_TIPO_TASA, e.cop_fecha_lim_pag, g.con_numero,acu.apa_num_resol,e.cop_num_cuota,con.ccu_nombre, e.cop_valor     ");
          sql.append("  ) )where saldo>0 ) ) where interes > 0.49  ");
           /*
          sql.append("  union   ");
            //interes para sanciones
          sql.append(" select * from(   ");
          sql.append(" select  per_codigo, COP_CODIGO,cop_fecha_lim_pag,connumero,cop_num_cuota ,ccu_nombre, ");
          sql.append(" case when RECAUDO is null then  valorcuota  else  saldo end as saldo,   ");
          sql.append(" case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_char('01/01/2014')  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  ");
          sql.append(" else 0  end  AS TASA ,   ");
          sql.append(" case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_char('01/01/2014')  BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   ");
          sql.append(" else 0  end  AS TASA2   from(   ");
          sql.append(" select    per.per_codigo, e.cop_codigo ,e.cop_fecha_lim_pag,con.CCU_TIPO_TASA,(case when  g.con_numero is null then san.san_num_resol else g.con_numero end )as connumero,e.cop_num_cuota,con.ccu_nombre,  ");
          sql.append(" e.cop_valor as valorcuota,sum( dt.dde_valor_pagado) as recaudo,(e.cop_valor-sum(dt.dde_valor_pagado)) as saldo  ");
          sql.append(" FROM SII_CUOTA_OPERADOR E   ");
          sql.append(" left join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo  ");
          sql.append(" left JOIN SII_LIQUIDACION_MES L ON L.LME_CODIGO = E.LME_CODIGO AND L.MES_CODIGO = E.MES_CODIGO    ");
          sql.append(" left JOIN SII_CONTRATO G ON L.CON_CODIGO = G.CON_CODIGO  ");
          sql.append(" inner join sii_concepto_cuota con on e.ccu_codigo=con.ccu_codigo  ");
          sql.append(" inner join sii_sancion  san on  e.san_codigo=san.san_codigo  ");
          sql.append(" inner join sii_operador op on e.ope_codigo=op.ope_codigo  ");
          sql.append(" inner join sii_persona per on per.per_codigo = op.per_codigo  ");
          sql.append(" where  san.san_num_resol is not null  ");
          sql.append(" group by e.cop_codigo, per.per_codigo, con.CCU_TIPO_TASA, e.cop_fecha_lim_pag, g.con_numero,san.san_num_resol,e.cop_num_cuota,con.ccu_nombre, e.cop_valor   ");
          sql.append(" ))where saldo>0  ");
          sql.append("  )  ");
            */
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("fecha", fechaSql);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {

                    InteresCuotaVO interes = new InteresCuotaVO();
                    interes.setIcuValor(((BigDecimal) object[0]));
                    interes.setIcuFecha(fechaActual);
                    interes.setIcuBaseCalc(((BigDecimal) object[1]));
                    interes.setIcuTasaAplic(((BigDecimal) object[2]));
                    interes.setIcuCancelado("N");
                    CuotaOperadorVO cuota = new CuotaOperadorVO();
                    cuota.setCopCodigo(((BigDecimal) object[3]).longValue());
                    interes.setCuotaOperadorVo(cuota);
                    interes.setConcepto((String) object[4]);
                    PersonaVO personaVo = new PersonaVO();
                    personaVo.setPerCodigo(((BigDecimal) object[5]).longValue());
                    interes.setPersonaVo(personaVo);
                    interes.setNumeroCuota(((BigDecimal) object[6]).longValue());
                    interes.setNumeroContrato((String) object[7]);
                    interes.setNumeroResolucion((String) object[8]);
                    respuesta.add(interes);
                }

            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return respuesta;
    }
    
    public SiiLiquidacionMes liquidaciónMesRefPago(Long numReferencia ) throws ExcepcionDAO {
        
        SiiLiquidacionMes unaSiiLiquidacionMes = new SiiLiquidacionMes();
      
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT lme FROM SiiLiquidacionMes lme");
            sql.append(" INNER JOIN lme.siiCuotaOperadorList cuo");
            sql.append(" INNER JOIN cuo.siiDetalleDeclaracionList det");
            sql.append(" WHERE det.siiReferenciaPagoDecl.rpdNumero = :numReferencia ");
    
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numReferencia", numReferencia);

              List<SiiLiquidacionMes>  listaSiiLiquidacionMes = query.getResultList();
            if (listaSiiLiquidacionMes.size() > 0) {
                unaSiiLiquidacionMes = listaSiiLiquidacionMes.get(0);
            }
            
           
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unaSiiLiquidacionMes;
    }
    
       public List<OficioLiquidacionPrevioVO> buscarInventarioPorContratoLiquidacion(Long idCodigoContrato, Date fechaInicio, Date fechaFin) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaLiquidacion = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select ta.tap_codigo,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula)/30) DE,");
            sql.append(" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");
            //sql.append(" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo,Ins.Met_Codigo, met.met_online");
            sql.append(" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" Inner Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
            sql.append(" Inner Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
            //sql.append(" Inner Join sii_met met on (ins.met_codigo = met.met_codigo)");
            sql.append(" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('A','R') ");
            sql.append(" and trunc(inv.inv_fecha_INI_liq)<=#fechaInicio and trunc(inv.inv_fecha_fin_liq)>=#fechaFin");
            sql.append(" order by Inv.Est_Codigo");

            /*sql.append (" select ta.tap_codigo,");
                    sql.append (" sum((substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1))) DE,");
                    sql.append (" sum(substr(TAP_GAST_ADM_FORMULA,1,INSTR(TAP_GAST_ADM_FORMULA,'*')-1)*(substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia  desc ) where con=1))) GA,");
                    sql.append (" sum((substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1)) +");
                    sql.append (" (substr(TAP_GAST_ADM_FORMULA,1,INSTR(TAP_GAST_ADM_FORMULA,'*')-1)*(substr(Tap_Der_Expl_Formula,1,INSTR(Tap_Der_Expl_Formula,'*')-1)*(select smm_valor from (select smm_valor,rownum con from sii_smmlv order by smm_vigencia desc  ) where con=1)))) VLRMENSUAL,");
                    sql.append (" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");
                    sql.append (" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo ");
                    sql.append (" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo and tap_codigo_apuesta <>'NA') ");
                    sql.append (" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
                    sql.append (" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
                    sql.append (" Inner Join Sii_Establecimiento est on (Inv.Est_Codigo = Inv.Est_Codigo)");
                    sql.append (" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('A','PR')");
                    sql.append (" group by Inv.Est_Codigo,ta.tap_codigo,Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,");
                    sql.append (" Ta.Tap_Min_Sillas, inv.inv_sillas, con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq,");
                    sql.append (" inv.inv_fecha_fin_liq,Tap_Der_Expl_Formula,TAP_GAST_ADM_FORMULA ,Tap_Der_Expl_Formula,Inv.Est_Codigo");*/


            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoContrato", idCodigoContrato);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO liquidacion = new OficioLiquidacionPrevioVO();
                    liquidacion.setDerechosExplMensual((BigDecimal) object[1]);
                    //liquidacion.setGastosAdministracionMensual((BigDecimal)object[2]);
                    //liquidacion.setValorTotalMensual((BigDecimal)object[3]);
                    liquidacion.setNumeroContrato((String) object[2]);
                    liquidacion.setConCodigo(((BigDecimal) object[3]).longValue());
                    liquidacion.setCodigoApuesta((String) object[4]);
                    liquidacion.setMinimoSillas(((BigDecimal) object[5]).intValue());
                    liquidacion.setInventarioSillas(((BigDecimal) object[6]).longValue());
                    liquidacion.setFechaInicioContrato((Date) object[7]);
                    liquidacion.setFechaFinContrato((Date) object[8]);
                    liquidacion.setFechaInicioLiq((Date) object[9]);
                    liquidacion.setFechaFinLiq((Date) object[10]);
                    liquidacion.setIdEstablecimiento(((BigDecimal) object[11]).longValue());
                   //liquidacion.setIdMet(((BigDecimal) object[12]).longValue());
                   // liquidacion.setIndicadorOnLine((String) object[13]);

                    miListaLiquidacion.add(liquidacion);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaLiquidacion;
    }
    public List<OficioLiquidacionPrevioVO> buscarEstablecimientoContrato(Long idCodigoContrato, Date fechaInicio, Date fechaFin) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaLiquidacion = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select distinct Inv.Est_Codigo,con.con_codigo ");           
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" Inner Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
            sql.append(" Inner Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");            
            sql.append(" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('A','R','PR') ");
            sql.append(" and trunc(inv.inv_fecha_INI_liq)<=#fechaFin and trunc(inv.inv_fecha_fin_liq)>=#fechaInicio");
            sql.append(" order by Inv.Est_Codigo");

            

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoContrato", idCodigoContrato);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO liquidacion = new OficioLiquidacionPrevioVO();                    
                    liquidacion.setIdEstablecimiento(((BigDecimal) object[0]).longValue());
                   //liquidacion.setIdMet(((BigDecimal) object[12]).longValue());
                   // liquidacion.setIndicadorOnLine((String) object[13]);

                    miListaLiquidacion.add(liquidacion);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaLiquidacion;
    }

    public List<OficioLiquidacionPrevioVO> buscarInventarioPorEstablecimiento(Long idEstablecimiento,Date fechaInicio,Date fechaFin, Long idContrato) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaLiquidacion = new ArrayList<OficioLiquidacionPrevioVO>();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select ta.tap_codigo,");
            sql.append(" fn_calcula_de(Tap_Der_Expl_Formula) DE,");
            sql.append(" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");
            sql.append(" con.con_fecha_ini, con.con_fecha_fin, con.con_fecha_fin_defin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo");
            sql.append(" ,Ins.Met_Codigo, met.met_online, met.met_uid");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
            sql.append(" left outer Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" left outer Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" left outer Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
            sql.append(" left outer Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
            sql.append(" left outer Join sii_met met on (ins.met_codigo = met.met_codigo)");
            sql.append(" where Inv.Est_Codigo =#idEstablecimiento and inv.inv_estado IN('A','PR','R') and con.con_codigo=#idContrato  ");
            sql.append (" and trunc(inv.inv_fecha_INI_liq)<=#fechaFin and trunc(inv.inv_fecha_fin_liq)>=#fechaInicio");
            sql.append(" order by Inv.Est_Codigo ");
           
            
            /*sql.append(" select ta.tap_codigo,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula)) DE,");
            sql.append(" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");            
            sql.append(" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
            sql.append(" Inner Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" Inner Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" Inner Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
            sql.append(" Inner Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
            //sql.append(" Inner Join sii_met met on (ins.met_codigo = met.met_codigo)");
            sql.append(" where Inv.Est_Codigo =#idEstablecimiento and inv.inv_estado IN('A','R') and con.con_codigo=#idContrato "); 
            sql.append(" and trunc(inv.inv_fecha_INI_liq)<=#fechaFin  and trunc(inv.inv_fecha_fin_liq)>=#fechaInicio");
            sql.append(" order by Inv.Est_Codigo");*/

           
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idEstablecimiento", idEstablecimiento);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            query.setParameter("idContrato", idContrato);
            

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO liquidacion = new OficioLiquidacionPrevioVO();
                    liquidacion.setDerechosExplMensual((BigDecimal) object[1]);
                    //liquidacion.setGastosAdministracionMensual((BigDecimal)object[2]);
                    //liquidacion.setValorTotalMensual((BigDecimal)object[3]);
                    liquidacion.setNumeroContrato((String) object[2]);
                    liquidacion.setConCodigo(((BigDecimal) object[3]).longValue());
                    liquidacion.setCodigoApuesta((String) object[4]);
                    liquidacion.setMinimoSillas(((BigDecimal) object[5]).intValue());
                    liquidacion.setInventarioSillas(((BigDecimal) object[6]).longValue());
                    liquidacion.setFechaInicioContrato((Date) object[7]);
                    liquidacion.setFechaFinContrato((Date) object[8]);
                    liquidacion.setFechaFinDefinitiva((Date) object[9]);
                    liquidacion.setFechaInicioLiq((Date) object[10]);
                    liquidacion.setFechaFinLiq((Date) object[11]);
                    liquidacion.setIdEstablecimiento(((BigDecimal) object[12]).longValue());
                    if(object[13]!= null){
                            liquidacion.setIdMet(((BigDecimal) object[13]).longValue());
                            liquidacion.setIndicadorOnLine((String) object[14]);
                            
                    }
                    

                    miListaLiquidacion.add(liquidacion);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaLiquidacion;
    }
    
    //************
    public List<SiiLiquidacionMes> buscarLiquidacionMesPorContratoPorVigenciaPorMes(Long codigoContrato, Integer vigencia, Integer mes) throws ExcepcionDAO {
        List<SiiLiquidacionMes> listaLiquidacionMes = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT lme FROM SiiLiquidacionMes lme");
            sql.append(" INNER JOIN lme.siiContrato con");           
            sql.append(" WHERE con.conCodigo = :codigoContrato");
            sql.append(" AND lme.lmeVigencia = :vigencia");
            sql.append(" AND lme.siiMes.mesCodigo = :mes");              

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoContrato", codigoContrato);
            query.setParameter("vigencia", vigencia);
            query.setParameter("mes", mes);
            
            listaLiquidacionMes = query.getResultList();
            /*if (listaLiquidacionMes != null && !listaLiquidacionMes.isEmpty()) {
                siiLiquidacionMes = listaLiquidacionMes.get(0);
            }*/

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaLiquidacionMes;
    }
    public List<OficioLiquidacionPrevioVO> buscarInventarioPorContratoYRangoOperacion(Long idCodigoContrato,String fechaInicioOper, String fechaFinOper, Long tipoNovedad, Integer vigencia) throws ExcepcionDAO {

        List<OficioLiquidacionPrevioVO> miListaLiquidacion = new ArrayList<OficioLiquidacionPrevioVO>();
 
        try {
           
            StringBuilder sql = new StringBuilder();
                       sql.append(" select s.tap_codigo,s.DE, s.con_numero,s.con_codigo,s.tipo_apuesta,s.min_sillas,s.inv_sillas,");
                       sql.append(" s.con_fecha_ini,s.con_fecha_fin,s.fecha_ini_liq,s.fecha_fin_liq,s.est_codigo,s.con_fecha_fin_defin,");
                       sql.append(" s.met_codigo,s.indicador,s.nuc,s.estado from ");
                       sql.append(" (select ta.tap_codigo tap_codigo,(fn_liquida_DE(Tap_Der_Expl_Formula,"+vigencia + ")) DE,");
                       sql.append(" Con.Con_Numero con_numero,Con.con_codigo con_codigo,Ta.Tap_codigo_Apuesta tipo_apuesta,");
                       sql.append(" NVL(Ta.Tap_Min_Sillas,0) min_sillas, NVL(inv.inv_sillas,0) inv_sillas,");
                       sql.append(" con.con_fecha_ini con_fecha_ini, con.con_fecha_fin con_fecha_fin,inv.inv_fecha_ini_liq fecha_ini_liq, ");
                       sql.append(" inv.inv_fecha_fin_liq fecha_fin_liq,Inv.Est_Codigo est_codigo, con.con_fecha_fin_defin con_fecha_fin_defin");
                       sql.append(" ,Ins.Met_Codigo met_codigo, met.met_online indicador, met.met_uid nuc,inv.inv_estado estado");
                       sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
                       sql.append(" left outer Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
                       sql.append(" left outer Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
                       sql.append(" left outer Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
                       sql.append(" left outer Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
                       sql.append(" left outer Join sii_met met on (ins.met_codigo = met.met_codigo)");
                       sql.append(" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('A') ");
                       sql.append(" and inv.inv_fecha_INI_liq <= to_Date('"+fechaFinOper +"','dd/mm/yyyy HH24:MI:SS') and inv.inv_fecha_fin_liq >= to_date('"+fechaInicioOper+"','dd/mm/yyyy HH24:MI:SS')");
                       sql.append(" UNION ALL");
                       sql.append(" select ta.tap_codigo,(fn_liquida_DE(Tap_Der_Expl_Formula,"+vigencia + ")) DE,");
                       sql.append(" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");
                       sql.append(" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo, con.con_fecha_fin_defin");
                       sql.append(" ,Ins.Met_Codigo, met.met_online, met.met_uid,inv.inv_estado");
                       sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
                       sql.append(" left outer Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
                       sql.append(" left outer Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
                       sql.append(" left outer Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
                       sql.append(" left outer Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
                       sql.append(" left outer Join sii_met met on (ins.met_codigo = met.met_codigo)");
                       sql.append(" left outer Join Sii_Tipo_Novedad tno on (nov.tno_codigo = tno.tno_codigo)");
                       sql.append(" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('R') ");
                       sql.append(" and inv.inv_fecha_INI_liq <= to_Date('"+fechaFinOper +"','dd/mm/yyyy HH24:MI:SS') and inv.inv_fecha_fin_liq >= to_date('"+fechaInicioOper+"','dd/mm/yyyy HH24:MI:SS')");
                       sql.append(" and tno.tno_codigo in (20,30,60,40))s");
                       sql.append(" order by s.est_codigo");
            
            
            /*sql.append(" select ta.tap_codigo,");
            sql.append(" (fn_calcula_de(Tap_Der_Expl_Formula)) DE,");
            sql.append(" Con.Con_Numero,Con.con_codigo,Ta.Tap_codigo_Apuesta,NVL(Ta.Tap_Min_Sillas,0), NVL(inv.inv_sillas,0),");            
            sql.append(" con.con_fecha_ini, con.con_fecha_fin,inv.inv_fecha_ini_liq, inv.inv_fecha_fin_liq,Inv.Est_Codigo, con.con_fecha_fin_defin");
            sql.append(" ,Ins.Met_Codigo, met.met_online, met.met_uid");
            sql.append(" from sii_inventario inv Inner Join sii_tipo_apuesta ta on (inv.tap_codigo = ta.tap_codigo )");
            sql.append(" left outer Join sii_novedad  nov on (inv.nov_codigo = nov.nov_codigo)");
            sql.append(" left outer Join Sii_Contrato con on (nov.con_codigo = con.con_codigo)");
            sql.append(" left outer Join Sii_Establecimiento est on (Inv.Est_Codigo = est.Est_Codigo)");
            sql.append(" left outer Join sii_instrumento ins on (inv.ins_codigo = ins.ins_codigo)");
            sql.append(" left outer Join sii_met met on (ins.met_codigo = met.met_codigo)");
            sql.append(" where con.con_codigo =#idCodigoContrato and inv.inv_estado IN('A','PR','R') ");
            sql.append("  and trunc(inv.inv_fecha_INI_liq)<to_Date('" +fechaFinOper+"','dd/mm/yyyy') and trunc(inv.inv_fecha_fin_liq)>=to_date('" +fechaInicioOper+"','dd/mm/yyyy')");
            sql.append(" order by Inv.Est_Codigo");*/

            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoContrato", idCodigoContrato);
            query.setParameter("fechaInicioOper",fechaInicioOper);
            query.setParameter("fechaFinOper",fechaFinOper);
            query.setParameter("tipoNovedad",tipoNovedad);
            

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {
                    OficioLiquidacionPrevioVO liquidacion = new OficioLiquidacionPrevioVO();
                                        liquidacion.setTapCodigo(((BigDecimal) object[0]).longValue());
                    liquidacion.setDerechosExplMensual((BigDecimal) object[1]);
                    //liquidacion.setGastosAdministracionMensual((BigDecimal)object[2]);
                    //liquidacion.setValorTotalMensual((BigDecimal)object[3]);
                    liquidacion.setNumeroContrato((String) object[2]);
                    liquidacion.setConCodigo(((BigDecimal) object[3]).longValue());
                    liquidacion.setCodigoApuesta((String) object[4]);
                    liquidacion.setMinimoSillas(((BigDecimal) object[5]).intValue());
                    liquidacion.setInventarioSillas(((BigDecimal) object[6]).longValue());
                    liquidacion.setFechaInicioContrato((Date) object[7]);
                    liquidacion.setFechaFinContrato((Date) object[8]);
                    liquidacion.setFechaInicioLiq((Date) object[9]);
                    liquidacion.setFechaFinLiq((Date) object[10]);
                    liquidacion.setIdEstablecimiento(((BigDecimal) object[11]).longValue());
                    liquidacion.setFechaFinDefinitiva((Date) object[12]);
                                        if(object[13]!= null){
                                                liquidacion.setIdMet(((BigDecimal) object[13]).longValue());
                                                liquidacion.setIndicadorOnLine((String) object[14]);
                                                liquidacion.setNuc((String) object[15]);
                                        }

                    miListaLiquidacion.add(liquidacion);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miListaLiquidacion;
    }
    
    // ************
    public List<SiiLiquidacionMes> buscarLiquidacionMesPorContratoVigenciaMesTipoReporteVetas(Long codigoContrato, Integer vigencia, Integer mes, String tipoReporteVtas) throws ExcepcionDAO {
        List<SiiLiquidacionMes> listaLiquidacionMes = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT lme FROM SiiLiquidacionMes lme");
            sql.append(" INNER JOIN lme.siiContrato con");
            sql.append(" INNER JOIN lme.siiCuotaOperadorList cop");
            sql.append(" WHERE con.conCodigo = :codigoContrato");
            sql.append(" AND lme.lmeVigencia = :vigencia");
            sql.append(" AND lme.siiMes.mesCodigo = :mes and cop.copCancelada = 'A' " +
                " and lme.liqConcepto='DE'");              

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoContrato", codigoContrato);
            query.setParameter("vigencia", vigencia);
            query.setParameter("mes", mes);
            
            
            listaLiquidacionMes = query.getResultList();
            /*if (listaLiquidacionMes != null && !listaLiquidacionMes.isEmpty()) {
                siiLiquidacionMes = listaLiquidacionMes.get(0);
            }*/

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaLiquidacionMes;
    }
    
    public List<SiiLiquidacionMes> buscarUltimaLiquidacion() throws ExcepcionDAO {
        List<SiiLiquidacionMes> listaLiquidacionMes = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT lme FROM SiiLiquidacionMes lme");
            sql.append(" WHERE lme.liqFecha = (select MAX(l.liqFecha) from SiiLiquidacionMes l) ");
            //sql.append(" ORDER BY lme.lmeCodigo DESC");                

            Query query = manager.createQuery(sql.toString());
                        
            listaLiquidacionMes = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaLiquidacionMes;
    }
    
    public SiiLiquidacionMes buscarUltimaLiquidacionMesPorContrato(Long codigoContrato) throws ExcepcionDAO {
        SiiLiquidacionMes siiLiquidacionMes = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT lme FROM SiiLiquidacionMes lme");
            sql.append(" INNER JOIN lme.siiContrato con");           
            sql.append(" WHERE lme.siiContrato.conCodigo = :codigoContrato");
            sql.append(" ORDER BY lme.liqFecha DESC");              

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoContrato", codigoContrato);
            
            List<SiiLiquidacionMes> listaLiquidacionMes = query.getResultList();
            if (listaLiquidacionMes != null && !listaLiquidacionMes.isEmpty()) {
                siiLiquidacionMes = listaLiquidacionMes.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiLiquidacionMes;
    }
    
}
