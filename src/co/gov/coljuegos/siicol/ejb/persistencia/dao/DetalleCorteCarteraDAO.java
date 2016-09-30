package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCuentaVO;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DetalleCorteCarteraDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DetalleCorteCarteraDAO() {
        recursos = new Recursos();
    }
    
    public List<EstadoCuentaVO> estadoCuentaCorte(String contrato, Integer concepto, Date fechaCorte, boolean isOrderTipo) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVO = new ArrayList();

        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        
        fechaCorte = cal.getTime();
        int vigencia = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DCC_CONTRATO,DCC_NUMERO_CUOTA,DCC_VIGENCIA,DCC.MES_CODIGO,DCC_FECHA_LIMITE_PAGO,DCC_FECHA_PAGO,DCC_VALOR_CUOTA,DCC_VALOR_PAGADO,DCC_SALDO_CUOTA,DCC_TOTAL_INTERES,DCC_DIAS_MORA, DCC_TIPO,DCC_INTERES_PAGADO,DCC_SALDO_INTERES,CCU_CODIGO,DCC_FECHA_INI_CONTRATO, DCC_FECHA_FIN_CONTRATO,DCC_NIT,DCC_RAZON_SOCIAL, DCC_TOTAL_INTERES_1 "); 
            sql.append("FROM SII_CORTE_CARTERA CCA ");
            sql.append("INNER JOIN SII_DET_CORTE_CARTERA DCC on DCC.CCA_CODIGO = CCA.CCA_CODIGO ");
            sql.append("WHERE CCA.CCA_VIGENCIA = #vigencia AND CCA.MES_CODIGO = #mes ");
            

            if (!contrato.equals("")) {
                sql.append(" AND DCC_CONTRATO =#contrato ");
            } 

            if (concepto > 0) {
                sql.append(" AND CCU_CODIGO =#concepto ");
            }

            sql.append("ORDER BY DCC_CONTRATO, ");
            if(isOrderTipo){
                sql.append("DCC_TIPO, ");
            }
            sql.append("DCC_VIGENCIA, DCC_NIT, DCC_NUMERO_CUOTA ");
            if(!isOrderTipo){
                sql.append(",DCC_TIPO ");
            }


            Query query = manager.createNativeQuery(sql.toString());
            if (!contrato.equals("")) {
                query.setParameter("contrato", contrato);
            }

            if (concepto > 0) {
                query.setParameter("concepto", concepto);
            }

            query.setParameter("vigencia", vigencia);
            query.setParameter("mes", mes);

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                EstadoCuentaVO elemento = new EstadoCuentaVO();

                elemento.setContrato((String) object[0]);
                elemento.setCuota((BigDecimal) object[1]);
                elemento.setAnio((BigDecimal) object[2]);
                elemento.setMes((BigDecimal) object[3]);
                elemento.setFecha_vencimiento((Date) object[4]);
                elemento.setFecha_pago((Date) object[5]);
                elemento.setMonto_obligacion((BigDecimal) object[6]);
                elemento.setMonto_pago((BigDecimal) object[7]);
                elemento.setSaldo((BigDecimal) object[8]);
                elemento.setTotal_interes((BigDecimal) object[9]);
                elemento.setDias_mora((BigDecimal) object[10]);
                elemento.setDescripcionConcepto((String) object[11]);
                elemento.setPagado_interes((BigDecimal) object[12]);
                elemento.setSaldo_interes((BigDecimal) object[13]);
                elemento.setCodigoConcepto((BigDecimal) object[14]);

                elemento.setFecha_inicioContraro((Date) object[15]);
                elemento.setFecha_finContrato((Date) object[16]);
                elemento.setNit((String) object[17]);
                elemento.setRazonSocial((String) object[18]);
                elemento.setTotalTodosInteres((BigDecimal) object[19]);
                //elemento.setValorClasificado((BigDecimal) object[20]);
                
                estadoCuentaVO.add(elemento);
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return estadoCuentaVO;
    }
    
    public void crearDetallesCorte(Long idCorteCartera, Date fechaCorte) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVO = new ArrayList();

        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        fechaCorte = cal.getTime();
        //int vigencia = cal.get(Calendar.YEAR);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaSql  = "TO_DATE('" + formatter.format(fechaCorte) + "','YYYY/MM/DD HH24:MI:SS') ";

                
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into SII_DET_CORTE_CARTERA (CCA_CODIGO,DCC_CONTRATO,DCC_NUMERO_CUOTA,DCC_VIGENCIA,MES_CODIGO,DCC_FECHA_LIMITE_PAGO,DCC_FECHA_PAGO,DCC_VALOR_CUOTA,DCC_VALOR_PAGADO,");
            sql.append("DCC_SALDO_CUOTA,DCC_TOTAL_INTERES,DCC_DIAS_MORA, ");
            sql.append("DCC_TIPO,DCC_INTERES_PAGADO,DCC_SALDO_INTERES,CCU_CODIGO,DCC_FECHA_INI_CONTRATO, ");
            sql.append("DCC_FECHA_FIN_CONTRATO,DCC_NIT,DCC_RAZON_SOCIAL, DCC_TOTAL_INTERES_1) ");
            sql.append("SELECT distinct #idCorteCartera, CONTRATO,NUMERO_CUOTA,VIGENCIA,MES,FECHA_LIMITE_PAGO,FECHA_PAGO,VALOR_CUOTA,VALOR_PAGADO,");
            sql.append("(VALOR_CUOTA-VALOR_PAGADO) AS SALDO_CUOTA,TOTAL_INTERES,CASE WHEN(((CASE WHEN (FECHA_PAGO IS NOT NULL) THEN ");
            sql.append("ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0) ELSE 0 END) <0) OR ((CASE WHEN(FECHA_PAGO IS NOT NULL) THEN ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0) ");
            sql.append("ELSE 0 END) >200000))THEN 0 ELSE ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)END AS DIAS_MORA, ");
            sql.append("TIPO,INTERES_PAGADO,(NVL(TOTAL_INTERES,0)-INTERES_PAGADO) AS SALDO_INTERES,CCUCODIGO,FECHA_INICIO_CONTRATO, ");
            sql.append("FECHA_FIN_CONTRATO,NIT,RAZON_SOCIAL  , TOTAL_INTERES /*, NVL(VALOR_CLASIFICADO,0), NVL(VALOR_AJU_REC,0)*/ ");
            sql.append("FROM ");
            sql.append("( ");
            sql.append("SELECT CUO.TOTAL_INTERES, CON.CON_NUMERO AS CONTRATO ,CON.CON_FECHA_INI AS FECHA_INICIO_CONTRATO , ");
            sql.append("CON.CON_FECHA_FIN    AS FECHA_FIN_CONTRATO , CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO ,");
            sql.append("(select ccuo.ccu_nombre from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS TIPO , ");
            sql.append("CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES,(NVL(DDE.TOTAL_PAGADO_INTERES_DDE,0) + NVL(CUO.TOTAL_PAGADO_INTERES,0) - NVL(CUO.TOTAL_AJUSTE_INTERES,0))  AS INTERES_PAGADO , ");
            sql.append("CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO , CUO.CCU_CODIGO  AS CCUCODIGO, ");
            sql.append("PERSO.PER_NUM_IDENTIFICACION AS NIT,PERSO.PER_JUR_NOMBRE_LARGO   AS RAZON_SOCIAL , VDREC.DRE_CODIGO/*, VALOR_CLASIFICADO*/");
            sql.append(",CUO.TOTAL_PAGADO_INTERES ,  DDE.TOTAL_PAGADO_INTERES_DDE  ");
            sql.append("FROM (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG,  ");
            sql.append("  COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU ");
            sql.append("                        INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO");
            sql.append("                        WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > " + fechaSql + "),0) AS COP_VALOR,COP0.COP_CANCELADA,COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.ATE_CODIGO,");
            sql.append("  (SELECT SUM(ICU0.ICU_VALOR) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " + fechaSql + ") as TOTAL_INTERES,");
            sql.append("  (SELECT SUM(ICU0.ICU_VALOR_PAGADO) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " + fechaSql + ") as TOTAL_PAGADO_INTERES, ");
            sql.append("  (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0 ");
            sql.append("        INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO ");
            sql.append("        INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO ");
            sql.append("        INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " + fechaSql + " ");
            sql.append("        WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES ");
            sql.append("  FROM SII_CUOTA_OPERADOR COP0  ");
            sql.append("  ) CUO ");
            sql.append("LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DDE_VALOR_PAGADO,DDE0.DDE_BASE_CALC_INT,DDE0.DDE_DIAS_INTERES,DDE0.DOP_CODIGO,DDE0.DDE_VALOR_DECLARADO,DDE0.RPD_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAG_INT ,");
            sql.append("                (SELECT SUM(DDE_VALOR_PAG_INT) FROM SII_DETALLE_DECLARACION DDE00 ");
            sql.append("                INNER JOIN VW_DET_REC_RBA_RPS_AJU VDREC ON VDREC.DRE_CODIGO = DDE00.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " + fechaSql + " ");
            sql.append("                WHERE DDE00.COP_CODIGO = DDE0.COP_CODIGO");
            sql.append("                ) AS TOTAL_PAGADO_INTERES_DDE");
            sql.append("            FROM SII_DETALLE_DECLARACION DDE0");
            sql.append("            INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO");
            sql.append("            WHERE DOP.DOP_FECHA <= " + fechaSql + ") DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO ");
            sql.append("LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO,");
            sql.append("             (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR "); 
            sql.append("              INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " + fechaSql + " ");
            sql.append("              WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC");
            sql.append("            FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " + fechaSql + "");
            sql.append("INNER JOIN SII_LIQUIDACION_MES LME ON LME.LME_CODIGO = CUO.LME_CODIGO ");
            sql.append("INNER JOIN SII_CONTRATO CON ON LME.CON_CODIGO = CON.CON_CODIGO ");
            sql.append("INNER JOIN SII_OPERADOR OPE ON OPE.OPE_CODIGO = CON.OPE_CODIGO ");
            sql.append("INNER JOIN SII_PERSONA PERSO ON PERSO.PER_CODIGO   = OPE.PER_CODIGO ");
            sql.append("WHERE to_date('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql + "");
            sql.append(") TODO ");


            
                sql.append(" WHERE CONTRATO IN ");
                sql.append("  ( SELECT CONT.CON_NUMERO ");
                sql.append("    FROM SII_CONTRATO CONT ");
                sql.append("    WHERE ( ( CONT.CON_FECHA_INI >= to_date('30/04/2007','DD/MM/YYYY') ");
                sql.append("              AND CONT.CON_FECHA_FIN     >= to_date('30/04/2012','DD/MM/YYYY')" +
                           "             ) ");
                sql.append("           OR CONT.CON_NUMERO    in ('C0712','C0489')" +
                           "          ) ");
                sql.append("    AND CONT.CON_NUMERO NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732','C0800' ) ");
                sql.append("  ) ");
            


            sql.append(" ORDER BY CONTRATO , ");
            sql.append("  VIGENCIA, NIT, ");
            sql.append("   NUMERO_CUOTA, TIPO ");


            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("idCorteCartera", idCorteCartera);
            //query.setParameter("fechaCorte", fechaCorte);

            query.executeUpdate();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
}
