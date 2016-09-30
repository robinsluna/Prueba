
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 14-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;
import co.gov.coljuegos.siicol.ejb.wsvo.VentasMetCuotaWSVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CuotaOperadorDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    @EJB
    private ContratoDAO contratoDAO;

    public CuotaOperadorDAO() {
        recursos = new Recursos();
    }

    public SiiCuotaOperador buscarCuotaOperadorPorId(Long idCuotaoperador) throws ExcepcionDAO {
        SiiCuotaOperador localCuotaOperador = null;
        try {
            localCuotaOperador = manager.find(SiiCuotaOperador.class, idCuotaoperador);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return localCuotaOperador;

    }

    public SiiCuotaOperador actualizarCuotaOperador(SiiCuotaOperador siiCuotaOperador) throws ExcepcionDAO {
        try {
            siiCuotaOperador = manager.merge(siiCuotaOperador);
            manager.flush();
            return siiCuotaOperador;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public CuotaOperadorVO BuscarTotalDetalleDeclaracionXIdCuota(Long idCuotaOp) throws ExcepcionDAO {
        CuotaOperadorVO unaCuotaOperadorVo = new CuotaOperadorVO();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select cop.cop_valor,sum(NVL(0,dre.dre_valor)) as total from sii_cuota_operador cop");
            sql.append(" inner join sii_detalle_declaracion dde on cop.cop_codigo=dde.cop_codigo");
            sql.append(" left join sii_detalle_recaudo dre on dde.dre_codigo=dre.dre_codigo");
            sql.append(" where cop.cop_codigo = #idCuotaOp");
            sql.append(" group by cop.cop_valor");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCuotaOp", idCuotaOp);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                unaCuotaOperadorVo.setCopValor((BigDecimal) object[0]);
                unaCuotaOperadorVo.setValoTotalDetalleCuota((BigDecimal) object[1]);

                if (unaCuotaOperadorVo.getValoTotalDetalleCuota().compareTo(BigDecimal.ZERO) <= 0)
                    unaCuotaOperadorVo.setCopValor((BigDecimal) object[0]);

            }
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unaCuotaOperadorVo;
    }

    public SiiCuotaOperador buscarCuotaOperadorPorCuotaVigencia(Integer numCuota,
                                                                Long codLiquidacion) throws ExcepcionDAO {
        SiiCuotaOperador cuotaOperador = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT cop_codigo FROM SII_CUOTA_OPERADOR where COP_NUM_CUOTA = #numCuota and LME_CODIGO = #codLiquidacion");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("numCuota", numCuota);
            query.setParameter("codLiquidacion", codLiquidacion);
            BigDecimal copCodigo = (BigDecimal) query.getSingleResult();
            cuotaOperador = buscarCuotaOperadorPorId(copCodigo.longValue());


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return cuotaOperador;

    }

    public boolean contratoEnMora(String nitOperador) throws ExcepcionDAO {
        List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
        try {/*
            StringBuilder sql = new StringBuilder();
            //sql.append("SELECT o FROM SiiCuotaOperador o WHERE o.siiOperador.opeCodigo = :opeCodigo AND o.copTipoCartera <> 'C' AND o.copFechaLimPag < CURRENT_DATE ");
            sql.append("select per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA-DCC_VALOR_PAGADO as saldo ,TASA,TASA2 from ( " +
"                                            select per.per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA,sum(DCC_VALOR_PAGADO) as DCC_VALOR_PAGADO, " +
"                                                    case when CCU_TIPO_TASA='SB' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_date('16/10/15','dd/mm/yy') BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   " +
"                                                          ELSE 0  END  AS TASA , " +
"                                                    case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE to_date('16/10/15','dd/mm/yy') BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )    " +
"                                                          ELSE 0  END  AS TASA2  " +
"                                                               " +
"                                            from ( " +
"                                                       " +
"                                                       " +
"                                                        SELECT distinct CONTRATO as DCC_CONTRATO,NUMERO_CUOTA as DCC_NUMERO_CUOTA,VIGENCIA as DCC_VIGENCIA,MES as MES_CODIGO,FECHA_LIMITE_PAGO as DCC_FECHA_LIMITE_PAGO,FECHA_PAGO as DCC_FECHA_PAGO,  " +
"                                                                      VALOR_CUOTA as DCC_VALOR_CUOTA,VALOR_PAGADO AS DCC_VALOR_PAGADO, " +
"                                                                     (VALOR_CUOTA-VALOR_PAGADO) AS DCC_SALDO_CUOTA,CASE WHEN(((CASE WHEN (FECHA_PAGO IS NOT NULL) THEN   " +
"                                                                     ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0) ELSE 0 END) <0) OR ((CASE WHEN(FECHA_PAGO IS NOT NULL) THEN ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)   " +
"                                                                     ELSE 0 END) >200000))THEN 0 ELSE ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)END AS DCC_DIAS_MORA,   " +
"                                                                     TIPO AS DCC_TIPO, CCUCODIGO AS CCU_CODIGO,FECHA_INICIO_CONTRATO as DCC_FECHA_INI_CONTRATO,   " +
"                                                                     FECHA_FIN_CONTRATO as DCC_FECHA_FIN_CONTRATO, COD_CUOTA,OPE_CODIGO  " +
"                                                                     FROM   " +
"                                                                    " +
"                                                                     (   " +
"                                                                             SELECT CUO.COP_CODIGO AS COD_CUOTA, CON.CON_NUMERO AS CONTRATO ,CON.CON_FECHA_INI AS FECHA_INICIO_CONTRATO ,   " +
"                                                                                   CON.CON_FECHA_FIN    AS FECHA_FIN_CONTRATO , CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO ,  " +
"                                                                                  (select ccuo.ccu_nombre from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS TIPO ,   " +
"                                                                                   CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES  , " +
"                                                                                   CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO , CUO.CCU_CODIGO  AS CCUCODIGO,   " +
"                                                                                  VDREC.DRE_CODIGO,OPE_CODIGO  " +
"                                                                            FROM " +
"                                                                                  (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG,    " +
"                                                                                           COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU  INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO  " +
"                                                                                            WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > to_date('16/10/15','dd/mm/yy')),0) AS COP_VALOR," +
"                                                                                            COP0.COP_CANCELADA,COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.MUL_CODIGO,COP0.SAN_CODIGO,COP0.ATE_CODIGO,COP0.LAF_CODIGO, " +
"                                                                                           (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0  " +
"                                                                                             INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO  " +
"                                                                                             INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO  " +
"                                                                                             INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > to_date('16/10/15','dd/mm/yy')" +
"                                                                                             WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES  " +
"                                                                                     FROM SII_CUOTA_OPERADOR COP0    " +
"                                                                                   where COP0.cop_fecha_lim_pag < to_date('16/10/15','dd/mm/yy')                   " +
"                                                                                     ) CUO   " +
"                                                                             LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAGADO                                     " +
"                                                                                         FROM SII_DETALLE_DECLARACION DDE0  " +
"                                                                                         INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO  " +
"                                                                                         WHERE DOP.DOP_FECHA < to_date('16/10/15','dd/mm/yy')) DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO   " +
"                                                                                 " +
"                                                                             LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO, " +
"                                                                                          (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR    " +
"                                                                                           INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > to_date('16/10/15','dd/mm/yy')" +
"                                                                                           WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC  " +
"                                                                                        " +
"                                                                                         FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= to_date('16/10/15','dd/mm/yy')" +
"                                                                             INNER JOIN SII_LIQUIDACION_MES LME ON LME.LME_CODIGO = CUO.LME_CODIGO   " +
"                                                                             INNER JOIN SII_CONTRATO CON ON LME.CON_CODIGO = CON.CON_CODIGO   " +
"                                                                             INNER JOIN SII_OPERADOR OPE ON OPE.OPE_CODIGO = CON.OPE_CODIGO   " +
"                                                                             INNER JOIN SII_PERSONA PERSO ON PERSO.PER_CODIGO   = OPE.PER_CODIGO   " +
"                                                                             WHERE to_date('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= to_date('16/10/15','dd/mm/yy')" +
"                                                                             and  ((CON.CON_FECHA_INI >= '30/04/2007'  AND CON.CON_FECHA_FIN     >= '30/04/2012')  or CON.con_numero IN ('C0712') ) " +
"                                                                            and CON.con_numero NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732','C0800') " +
"                                                                            " +
"                                                                                " +
"                                                                  ) TODO   " +
"                                                                 " +
"                                                         ORDER BY CONTRATO,VIGENCIA,  NUMERO_CUOTA , TIPO   " +
"                                                         " +
"                                                         " +
"                                           )sub1  " +
"                                           left join sii_concepto_cuota con on sub1.ccu_codigo=con.ccu_codigo  " +
"                                           left join sii_operador op on sub1.ope_codigo=op.ope_codigo   " +
"                                           left join sii_persona per on per.per_codigo = op.per_codigo   " +
"                                           where CCU_TIPO_TASA != 'N/A' " +
"                                           group by per.per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA,CCU_TIPO_TASA" +
"                        )      " +
"                        where DCC_CONTRATO = #contrato AND (DCC_VALOR_CUOTA-DCC_VALOR_PAGADO) > 0 " );    
                 
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("contrato", contrato);            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {                
                for (Object[] object : results) {
                    SiiCuotaOperador siiCuotaOperador= new SiiCuotaOperador();
                    siiCuotaOperador.setCopCodigo(Long.parseLong(((BigDecimal) (object[1])).toString()));
                    listaCuotaOperador.add(siiCuotaOperador);
                }
            }*/

            /*List<ContratoVO> contratosVigentesOperador = null;//this.busbuscarContratosVigentesPorNit(nitOperador);
            Date fecha = Utilidades.truncDate(new Date()) ;

            boolean operadorEnMora = false;

            for(ContratoVO contrato : contratosVigentesOperador) {

                List<EstadoCuentaVO> estados = EstadoCuentaMB.estadoDeCuentaPorContrato(contrato.getConNumero(), fecha);
                for(EstadoCuentaVO estado : estados) {
                    if (!estado.getFecha_vencimiento().after(fecha)) {
                        BigDecimal saldo = estado.getSaldo().setScale(0,BigDecimal.ROUND_DOWN);
                        BigDecimal intereses = estado.getSaldo_interes().setScale(0,BigDecimal.ROUND_DOWN);
                        if ( saldo.add(intereses).compareTo(BigDecimal.ZERO) > 0) {
                            System.out.println("Fecha Vencimiento: "+estado.getFecha_vencimiento()+" saldo:  "+saldo+" intereses: "+intereses);
                        }
                        operadorEnMora = operadorEnMora || saldo.add(intereses).compareTo(BigDecimal.ZERO) > 0;                    
                    }

                }
            }*/


            
        
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return true;
    }
    
    

    
    public boolean operadorEnMora(Long opeCodigo) throws ExcepcionDAO {
        List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
        try {
            StringBuilder sql = new StringBuilder();
            //sql.append("SELECT o FROM SiiCuotaOperador o WHERE o.siiOperador.opeCodigo = :opeCodigo AND o.copTipoCartera <> 'C' AND o.copFechaLimPag < CURRENT_DATE ");
            sql.append("select interes, base, tasa, cop_codigo, dcc_tipo,  per_codigo, dcc_numero_cuota, dcc_contrato, numresolucion from (  " + 
            "            select case when tasa>0 then (saldo*tasa/100/(365)) else (case when tasa2>0 then (saldo*tasa2/100/(365))end )end as interes,saldo  as base, " + 
            "                        case when tasa>0 then tasa else(CASE WHEN  tasa2>0 THEN TASA2 END)END AS TASA, " + 
            "                            COD_CUOTA as  COP_CODIGO, DCC_TIPO,per_codigo,DCC_NUMERO_CUOTA,DCC_CONTRATO,\'\' as numresolucion   " + 
            "                           from(   " + 
            "                              select per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA-DCC_VALOR_PAGADO as saldo ,TASA,TASA2 from ( " + 
            "                                            select per.per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA,sum(DCC_VALOR_PAGADO) as DCC_VALOR_PAGADO, " + 
            "                                                    case when CCU_TIPO_TASA=\'SB\' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE CURRENT_DATE BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )   " + 
            "                                                          ELSE 0  END  AS TASA , " + 
            "                                                    case when CCU_TIPO_TASA=\'ILC\' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE CURRENT_DATE BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )    " + 
            "                                                          ELSE 0  END  AS TASA2  " + 
            "                                                               " + 
            "                                            from ( " + 
            "                                                        SELECT distinct CONTRATO as DCC_CONTRATO,NUMERO_CUOTA as DCC_NUMERO_CUOTA,VIGENCIA as DCC_VIGENCIA,MES as MES_CODIGO,FECHA_LIMITE_PAGO as DCC_FECHA_LIMITE_PAGO,FECHA_PAGO as DCC_FECHA_PAGO,  " + 
            "                                                                      VALOR_CUOTA as DCC_VALOR_CUOTA,VALOR_PAGADO AS DCC_VALOR_PAGADO, " + 
            "                                                                     (VALOR_CUOTA-VALOR_PAGADO) AS DCC_SALDO_CUOTA,CASE WHEN(((CASE WHEN (FECHA_PAGO IS NOT NULL) THEN   " + 
            "                                                                     ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0) ELSE 0 END) <0) OR ((CASE WHEN(FECHA_PAGO IS NOT NULL) THEN ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)   " + 
            "                                                                     ELSE 0 END) >200000))THEN 0 ELSE ROUND((FECHA_PAGO-FECHA_LIMITE_PAGO),0)END AS DCC_DIAS_MORA,  " + 
            "                                                                     TIPO AS DCC_TIPO, CCUCODIGO AS CCU_CODIGO,FECHA_INICIO_CONTRATO as DCC_FECHA_INI_CONTRATO,  " + 
            "                                                                     FECHA_FIN_CONTRATO as DCC_FECHA_FIN_CONTRATO, COD_CUOTA,OPE_CODIGO  " + 
            "                                                                     FROM   " + 
            "                                                                    " + 
            "                                                                     (   " + 
            "                                                                             SELECT CUO.COP_CODIGO AS COD_CUOTA, CON.CON_NUMERO AS CONTRATO ,CON.CON_FECHA_INI AS FECHA_INICIO_CONTRATO ,   " + 
            "                                                                                   CON.CON_FECHA_FIN    AS FECHA_FIN_CONTRATO , CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO ,  " + 
            "                                                                                  (select ccuo.ccu_nombre from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS TIPO ,   " + 
            "                                                                                   CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES  , " + 
            "                                                                                   CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO , CUO.CCU_CODIGO  AS CCUCODIGO,   " + 
            "                                                                                  VDREC.DRE_CODIGO,OPE_CODIGO  " + 
            "                                                                            FROM " + 
            "                                                                                  (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG,  " + 
            "                                                                                           COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU  INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO  " + 
            "                                                                                            WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > to_date(\'22/05/2015\',\'DD/MM/YYYY\')),0) AS COP_VALOR, " + 
            //"                                                                                            COP0.COP_CANCELADA,COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.MUL_CODIGO,COP0.SAN_CODIGO,COP0.ATE_CODIGO,COP0.LAF_CODIGO, " + 
            "                                                                                            COP0.COP_CANCELADA,COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.ATE_CODIGO, " + 
            "                                                                                           (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0  " + 
            "                                                                                             INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO  " + 
            "                                                                                             INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO  " + 
            "                                                                                             INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > CURRENT_DATE " + 
            "                                                                                             WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES  " + 
            "                                                                                     FROM SII_CUOTA_OPERADOR COP0 " + 
            "                                                                                   where COP0.cop_fecha_lim_pag < CURRENT_DATE  " + 
            "                                                                                     ) CUO  " + 
            "                                                                             LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAGADO " + 
            "                                                                                         FROM SII_DETALLE_DECLARACION DDE0 " + 
            "                                                                                         INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO  " + 
            "                                                                                         WHERE DOP.DOP_FECHA < CURRENT_DATE) DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO  " + 
            "                                                                                 " + 
            "                                                                             LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO, " + 
            "                                                                                          (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR   " + 
            "                                                                                           INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > CURRENT_DATE " + 
            "                                                                                           WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC  " + 
            "                                                                                        " + 
            "                                                                                         FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= CURRENT_DATE " + 
            "                                                                             INNER JOIN SII_LIQUIDACION_MES LME ON LME.LME_CODIGO = CUO.LME_CODIGO   " + 
            "                                                                             INNER JOIN SII_CONTRATO CON ON LME.CON_CODIGO = CON.CON_CODIGO   " + 
            "                                                                             INNER JOIN SII_OPERADOR OPE ON OPE.OPE_CODIGO = CON.OPE_CODIGO   " + 
            "                                                                             INNER JOIN SII_PERSONA PERSO ON PERSO.PER_CODIGO   = OPE.PER_CODIGO   " + 
            "                                                                             WHERE to_date(\'01/\' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= CURRENT_DATE " + 
            "                                                                             and  ((CON.CON_FECHA_INI >= TO_DATE(\'30/04/2007\',\'DD/MM/YYYY\')  AND CON.CON_FECHA_FIN     >= TO_DATE(\'30/04/2012\',\'DD/MM/YYYY\'))  or CON.con_numero IN (\'C0712\') ) " + 
            "                                                                            and CON.con_numero NOT IN (\'C0443\',\'C0449\',\'C0456\',\'C0494\',\'C0517\',\'C0621\',\'C0709\',\'C0489\',\'C0732\',\'C0800\') " + 
            "                                                                            and ope.ope_codigo = #opeCodigo " + 
            "                                                                                " + 
            "                                                                  ) TODO   " + 
            "                                                                 " + 
            "                                                         ORDER BY CONTRATO,VIGENCIA,  NUMERO_CUOTA , TIPO   " + 
            "                                           )sub1  " + 
            "                                           left join sii_concepto_cuota con on sub1.ccu_codigo=con.ccu_codigo  " + 
            "                                           left join sii_operador op on sub1.ope_codigo=op.ope_codigo   " + 
            "                                           left join sii_persona per on per.per_codigo = op.per_codigo  " + 
            "                                           where CCU_TIPO_TASA != \'N/A\' " + 
            "                                           group by per.per_codigo,COD_CUOTA,DCC_FECHA_LIMITE_PAGO,DCC_CONTRATO, DCC_NUMERO_CUOTA,DCC_TIPO,DCC_VALOR_CUOTA,CCU_TIPO_TASA  " + 
            "                        )    " + 
            " " +             
            "  " + 
            "        union  " + 
            "          select per_codigo, COP_CODIGO,cop_fecha_lim_pag,connumero,cop_num_cuota ,ccu_nombre, " +
            "           saldo, tasa, tasa2 " +                       
            "           from(  " + 
            "          select  per_codigo, COP_CODIGO,cop_fecha_lim_pag,connumero,cop_num_cuota ,ccu_nombre, " + 
            "          case when RECAUDO is null then  valorcuota  else  saldo end as saldo,  " + 
            "          case when CCU_TIPO_TASA=\'SB\' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE  CURRENT_DATE BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  " + 
            "          else 0  end  AS TASA ,  " + 
            "          case when CCU_TIPO_TASA='ILC' then (SELECT TIS_TASA FROM SII_TASA_INT_SUPERBAN WHERE  CURRENT_DATE BETWEEN TIS_VIGEN_DESDE AND TIS_VIGEN_HASTA )  " + 
            "          else 0  end  AS TASA2   from(  " + 
            "          select    acu.apa_codigo ,per.per_codigo, e.cop_codigo ,e.cop_fecha_lim_pag,con.CCU_TIPO_TASA,(case when  g.con_numero is null then acu.apa_num_resol else g.con_numero end )as connumero,e.cop_num_cuota,con.ccu_nombre,  " + 
            "          e.cop_valor as valorcuota,sum( dt.dde_valor_pagado) as recaudo,(e.cop_valor-sum(dt.dde_valor_pagado)) as saldo   " + 
            "          FROM SII_CUOTA_OPERADOR E  " + 
            "          left join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo  " + 
            "          left JOIN SII_LIQUIDACION_MES L ON L.LME_CODIGO = E.LME_CODIGO AND L.MES_CODIGO = E.MES_CODIGO   " + 
            "          left JOIN SII_CONTRATO G ON L.CON_CODIGO = G.CON_CODIGO  " + 
            "          inner join sii_concepto_cuota con on e.ccu_codigo=con.ccu_codigo  " + 
            "          inner join sii_acuerdo_pago acu on  e.apa_codigo=acu.apa_codigo  " + 
            "          inner join sii_operador op on e.ope_codigo=op.ope_codigo  " + 
            "          inner join sii_persona per on per.per_codigo = op.per_codigo   " + 
            "          where  acu.apa_codigo is not null   and con.ccu_tipo_tasa != \'N/A\'   and cop_fecha_lim_pag <  CURRENT_DATE  " + 
            "          group by  acu.apa_codigo,e.cop_codigo, per.per_codigo, con.CCU_TIPO_TASA, e.cop_fecha_lim_pag, g.con_numero,acu.apa_num_resol,e.cop_num_cuota,con.ccu_nombre, e.cop_valor  " + 
            "           ) )where saldo>0  " + 
            "              )          ) where interes > 0.49 ");             
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("opeCodigo", opeCodigo);            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {                
                for (Object[] object : results) {
                    SiiCuotaOperador siiCuotaOperador= new SiiCuotaOperador();
                    siiCuotaOperador.setCopCodigo(Long.parseLong(((BigDecimal) (object[3])).toString()));
                    listaCuotaOperador.add(siiCuotaOperador);
                }
            }
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        if (listaCuotaOperador != null && listaCuotaOperador.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *Metodo encargado de hacer la consulta de cuotas de operador que esten en cobro coactivo y vencidas
     * @author David Tafur
     * @param opeCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public boolean operadorCobroCoactivo(Long opeCodigo) throws ExcepcionDAO {
        List<SiiCuotaOperador> listaCuotaOperador = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiCuotaOperador o WHERE o.siiOperador.opeCodigo = :opeCodigo");
            sql.append(" INNER JOIN o.siiConceptoCuota  ccu");
            sql.append(" AND o.copTipoCartera <> 'C' AND o.copFechaLimPag < CURRENT_DATE ");
            sql.append(" AND ccu.ccuAbreviatura ='CBC'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("opeCodigo", opeCodigo);
            listaCuotaOperador = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        if (listaCuotaOperador != null && listaCuotaOperador.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public SiiCuotaOperador insertarSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) throws ExcepcionDAO {
        try {
            manager.persist(siiCuotaOperador);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }

    public SiiCuotaOperador buscarCuotaOperadorPorId(CuotaOperadorVO cuotaVo) throws ExcepcionDAO {
        SiiCuotaOperador resultado = null;
        try {
            resultado = (SiiCuotaOperador) manager.find(SiiCuotaOperador.class, cuotaVo.getCopCodigo());
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return resultado;
    }

    /**
     *Metodo encargado de buscar una cuota de un operador para un determinado mes y un concepto, ejemplo: DE o GA
     * @author David Tafur
     * @param codigoContrato
     * @param codigoOperador
     * @param codigoMes
     * @param conceptoLiq
     * @return
     * @throws ExcepcionDAO
     */
    public SiiCuotaOperador buscarCuotaOperadorXContratoXOperadorXMesXConcepto(long codigoContrato, long codigoOperador,
                                                                               long codigoMes, String conceptoLiq,
                                                                               int anoVigencia) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiLiquidacionMes liq");
            sql.append(" INNER JOIN liq.siiContrato cont");
            sql.append(" INNER JOIN cont.siiOperador ope");
            sql.append(" WHERE cuot.mesCodigo =:codigoMes");
            sql.append(" AND ope.opeCodigo =:codigoOperador");
            sql.append(" AND cont.conCodigo =:codigoContrato");
            sql.append(" AND liq.liqConcepto =:conceptoLiq");
            sql.append(" AND cuot.copVigencia =:anoVigencia");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoMes", codigoMes);
            consulta.setParameter("codigoOperador", codigoOperador);
            consulta.setParameter("codigoContrato", codigoContrato);
            consulta.setParameter("conceptoLiq", conceptoLiq);
            consulta.setParameter("anoVigencia", anoVigencia);


            List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
            listaCuotaOperador = consulta.getResultList();

            if (listaCuotaOperador.size() > 0) {
                siiCuotaOperador = listaCuotaOperador.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }
    
    public SiiCuotaOperador buscarCuotaOperadorModificadaCorregidaXContratoXOperadorXMesXConcepto(long codigoContrato, long codigoOperador,
                                                                               long codigoMes, Long conceptoCuota,
                                                                               int anoVigencia) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiReporteVentas rve");
            sql.append(" INNER JOIN rve.siiContrato cont");
            sql.append(" INNER JOIN cont.siiOperador ope");
            sql.append(" WHERE cuot.mesCodigo =:codigoMes");
            sql.append(" AND ope.opeCodigo =:codigoOperador");
            sql.append(" AND cont.conCodigo =:codigoContrato");
            sql.append(" AND cuot.copVigencia =:anoVigencia");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoMes", codigoMes);
            consulta.setParameter("codigoOperador", codigoOperador);
            consulta.setParameter("codigoContrato", codigoContrato);
            consulta.setParameter("conceptoCuota", conceptoCuota);
            consulta.setParameter("anoVigencia", anoVigencia);


            List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
            listaCuotaOperador = consulta.getResultList();

            if (listaCuotaOperador.size() > 0) {
                siiCuotaOperador = listaCuotaOperador.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }

    /**
     *Metodo encargado de buscar las cuotas para un operador cuyo concepto sea diferente de GA y de DE para liquidacion de otros conceptos
     * @author David Tafur
     * @param codigoContrato
     * @param codigoOperador
     * @param codigoMes
     * @param conceptoLiq
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiCuotaOperador> buscarCuotaOperadorXNitNoGaNoDE(String numIdentificacion) throws ExcepcionDAO {
        List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiConceptoCuota conc");
            sql.append(" INNER JOIN cuot.siiOperador ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" WHERE per.perNumIdentificacion =:numIdentificacion");
            sql.append(" AND conc.ccuAbreviatura != 'DE' AND conc.ccuAbreviatura != 'GA'");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("numIdentificacion", numIdentificacion);
            listaCuotaOperador = consulta.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCuotaOperador;
    }


    /**
     *Metodo encargado de buscar una cuota de un operador para un concepto y nit
     * @param nitOperador
     * @param conceptoCuota
     * @param numeroCuota
     * @return
     * @throws ExcepcionDAO
     */
    public SiiCuotaOperador buscarCuotaOperadorXOperadorXConceptoXNumeroCuota(String nitOperador, String conceptoCuota,
                                                                              int numeroCuota) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiConceptoCuota ccu");
            sql.append(" INNER JOIN cuot.siiOperador ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" WHERE cuot.copNumCuota = :numeroCuota");
            sql.append(" AND per.perNumIdentificacion = :numeroIdentificacion");
            sql.append(" AND ccu.ccuAbreviatura = :conceptoCuota");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("numeroCuota", numeroCuota);
            consulta.setParameter("numeroIdentificacion", nitOperador);
            consulta.setParameter("conceptoCuota", conceptoCuota);

            List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
            listaCuotaOperador = consulta.getResultList();

            if (listaCuotaOperador.size() > 0) {
                siiCuotaOperador = listaCuotaOperador.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }
    
    
    public List<SiiCuotaOperador> buscarCuotaOperadorPorRifaPromocional(Long  idRifaPromocional ) throws ExcepcionDAO {
        List<SiiCuotaOperador> listCuotaOperador = new ArrayList();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT cuot FROM SiiCuotaOperador cuot where cuot.siiRifaPromocional.rfpCodigo  = :idRifaPromocional ");
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("idRifaPromocional", idRifaPromocional);
            listCuotaOperador = consulta.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listCuotaOperador;

    }   
    
    
    /**
     *Metodo encargado de buscar una cuota de un operador por contrato
     * @author Giovanni
     * @param codigoContrato
     * @return
     * @throws ExcepcionDAO
     */
    public BigDecimal buscarTotalLiquidacioCuotaOperadorXContrato(long codigoContrato) throws ExcepcionDAO {
         BigDecimal totalLiquidacion = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(cop.copValor) FROM SiiCuotaOperador cop");
            sql.append(" INNER JOIN cop.siiLiquidacionMes lme");
            sql.append(" INNER JOIN lme.siiContrato con");
            sql.append(" WHERE con.conCodigo = :codigoContrato");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoContrato", codigoContrato);

            totalLiquidacion = (BigDecimal) consulta.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return totalLiquidacion;
    }
    
    /**
     *Metodo encargado de buscar numero de cuotas por concepto
     * @author      
     * @return
     * @throws ExcepcionDAO
     */
    public List<DuplaVO> buscarNumeroCuotasPorAcuerdoPago(long idAcuerdoPago) throws ExcepcionDAO {
         List<DuplaVO> listaConcuo = new ArrayList<>();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select count(*),ccu_codigo from sii_cuota_operador co");
            sql.append(" Inner Join sii_acuerdo_pago ap on co.apa_codigo = ap.apa_codigo");           
            sql.append(" where ap.apa_codigo = #idAcuerdoPago");
            sql.append(" group by ccu_codigo ");

            Query query = manager.createNativeQuery(sql.toString());            
            query.setParameter("idAcuerdoPago",idAcuerdoPago);  

            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {                
                    for (Object[] object : results) {
                        DuplaVO duplaVo = new DuplaVO();
                        duplaVo.setValor((BigDecimal)object[0]);
                        duplaVo.setConcepto((String)object[1]);
                        listaConcuo.add(duplaVo);
                    }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaConcuo;
    }

    /**
     *Metodo encargado de buscar una cuota de un operador para un determinado contrato, concepto y número de cuota
     * @author David Tafur
     * @param codigoContrato
     * @param codigoOperador
     * @param codigoMes
     * @param conceptoLiq
     * @return
     * @throws ExcepcionDAO
     */
    public SiiCuotaOperador buscarCuotaOperadorXContratoXConceptoXNumCuota(String contrato, BigDecimal numeroCuota,
                                                                               BigDecimal conceptoLiq) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
        String concepto="";
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiLiquidacionMes liq");           
            sql.append(" INNER JOIN liq.siiContrato cont");
            sql.append(" WHERE cont.conNumero =:contrato");             
            sql.append(" AND liq.liqConcepto =:conceptoLiq");
            sql.append(" AND cuot.copNumCuota =:numeroCuota");
            
            if (conceptoLiq.equals(new BigDecimal(1))) {
                concepto = "DE";
            } else if (conceptoLiq.equals(new BigDecimal(2))){
                concepto = "GA";
            }else if (conceptoLiq.equals(new BigDecimal(3))){
                concepto = "MU";
            }else if (conceptoLiq.equals(new BigDecimal(5))){
                concepto = "SF";
            }
               
            Query consulta = manager.createQuery(sql.toString());          
            consulta.setParameter("contrato", contrato);
            consulta.setParameter("conceptoLiq", concepto);
            consulta.setParameter("numeroCuota", numeroCuota);


            List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
            listaCuotaOperador = consulta.getResultList();

            if (listaCuotaOperador.size() > 0) {
                siiCuotaOperador = listaCuotaOperador.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }
    
    public List<SiiCuotaOperador> buscarCuotaOperadorXIdLiquidacion(Long idLiquidacion) throws ExcepcionDAO {
        List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cop FROM SiiCuotaOperador cop");
            sql.append(" WHERE cop.siiLiquidacionMes.lmeCodigo = :idLiquidacion");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("idLiquidacion", idLiquidacion);
            listaCuotaOperador = consulta.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCuotaOperador;
    }
    
    /**
     *Metodo encargado de buscar cuotas anteriores modificadas por tipo de reporte de ventas
     * @author Mónica     
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiCuotaOperador> buscarCuotasAsociadasAReporteVentas(Long idReporteVentas) throws ExcepcionDAO {
         List<SiiCuotaOperador> listaCuotas = new ArrayList();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append(" select o from SiiCuotaOperador o");
            sql.append(" where o.siiLiquidacionMes.siiReporteVentas.rveCodigo=:idReporteVentas and o.copCancelada='T'");
                       
            

            Query query = manager.createQuery(sql.toString());            
            query.setParameter("idReporteVentas",idReporteVentas);
            

            listaCuotas = query.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCuotas;
    }
    
    public List<VentasMetCuotaWSVO> buscarVentasMetPorCuotaOperador(Long conCodigo, Integer vigencia, Integer mes, String fechaInicio, String fechaFin, String tipoReporte) throws ExcepcionDAO {
        List<VentasMetCuotaWSVO> listaVentasMetCuotaOperador = new ArrayList();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select  met.met_serial, met.mar_codigo, mar.mar_nombre, met.met_uid, ins.tap_codigo, tap.tap_nombre, est.est_codigo, est.est_nombre, est.ubi_codigo, ubi.ubi_nombre, ubi2.ubi_codigo, ubi2.ubi_nombre,  " + 
            " case rev.rve_tipo_reporte " + 
            " when 'P' then vm.vme_valor_inicial " + 
            " when 'Mn' then vm.vme_valor_modif " + 
            " when 'Cn' then vm.vme_valor_correc " + 
            " end as Valor_Ventas_Netas, " + 
            " vm.VME_LIQ_TARIFA_VAR, vm.VME_LIQ_TARIFA_FIJA, vm.VME_LIQ_EFECTIVA, met.met_codigo, rev.rve_tipo_reporte, vm.vme_codigo, rev.rve_codigo  " + 
            " from sii_inventario inv  " + 
            " left join sii_instrumento ins on inv.ins_codigo = ins.ins_codigo " + 
            " left join sii_met met on ins.met_codigo = met.met_codigo  " + 
            " left join sii_marca mar on met.mar_codigo = mar.mar_codigo  " + 
            " left join sii_establecimiento est on inv.est_codigo = est.est_codigo  " + 
            " left JOIN sii_ubicacion ubi ON est.UBI_CODIGO = ubi.UBI_CODIGO " + 
            " left JOIN sii_ubicacion ubi2 ON ubi.UBI_CODIGO_PADRE = ubi2.UBI_CODIGO " + 
            " left join sii_novedad n on inv.nov_codigo = n.nov_codigo  " + 
            " left join sii_contrato con on con.con_codigo = n.con_codigo  " + 
            " left join sii_tipo_apuesta tap on inv.tap_codigo = tap.tap_codigo  " + 
            " left join sii_tipo_instrumento ti on ins.tin_codigo = ti.tin_codigo  " + 
            " left join sii_tipo_novedad tn on n.tno_codigo = tn.tno_codigo " + 
            " left join sii_operador ope on ope.ope_codigo = con.ope_codigo " + 
            " left join sii_persona p on p.per_codigo = ope.per_codigo " + 
            " left JOIN sii_reporte_ventas rev ON con.CON_CODIGO = rev.CON_CODIGO " + 
            " left JOIN sii_ventas_met vm on (rev.rve_codigo = vm.rve_codigo and met.met_codigo = vm.met_codigo and con.con_codigo = vm.con_codigo and vm.vme_vigencia=#vigencia and vm.mes_codigo = #mes) " + 
            " where " + 
            " con.con_codigo= #conCodigo " + 
            " and inv.inv_estado IN('A')" + 
            " and con.con_vigente ='S'" + 
            " and trunc(inv.inv_fecha_INI_liq)<=to_Date('"+fechaFin+"','dd/mm/yyyy') and trunc(inv.inv_fecha_fin_liq)>=to_date('"+fechaInicio+"','dd/mm/yyyy')" + 
            " and met.met_online='S'" + 
            " and est.est_estado='A'" +
            " and rev.rve_tipo_reporte = #tipoReporte" + 
            " and rev.rve_vigencia = #vigencia " + 
            " and rev.mes_codigo = #mes"+                       
            " and rev.rve_codigo in (select max(rve_codigo) from sii_reporte_ventas where rve_tipo_reporte=#tipoReporte and rve_vigencia=#vigencia and mes_codigo=#mes and con_codigo= #conCodigo)" +
            " UNION " +
            " select  met.met_serial, met.mar_codigo, mar.mar_nombre, met.met_uid, ins.tap_codigo, tap.tap_nombre, est.est_codigo, est.est_nombre, est.ubi_codigo, ubi.ubi_nombre, ubi2.ubi_codigo, ubi2.ubi_nombre,  " + 
            " case rev.rve_tipo_reporte " + 
            " when 'P' then vm.vme_valor_inicial " + 
            " when 'Mn' then vm.vme_valor_modif " + 
            " when 'Cn' then vm.vme_valor_correc " + 
            " end as Valor_Ventas_Netas, " + 
            " vm.VME_LIQ_TARIFA_VAR, vm.VME_LIQ_TARIFA_FIJA, vm.VME_LIQ_EFECTIVA, met.met_codigo, rev.rve_tipo_reporte, vm.vme_codigo, rev.rve_codigo  " + 
            " from sii_inventario inv  " + 
            " left join sii_instrumento ins on inv.ins_codigo = ins.ins_codigo " + 
            " left join sii_met met on ins.met_codigo = met.met_codigo  " + 
            " left join sii_marca mar on met.mar_codigo = mar.mar_codigo  " + 
            " left join sii_establecimiento est on inv.est_codigo = est.est_codigo  " + 
            " left JOIN sii_ubicacion ubi ON est.UBI_CODIGO = ubi.UBI_CODIGO " + 
            " left JOIN sii_ubicacion ubi2 ON ubi.UBI_CODIGO_PADRE = ubi2.UBI_CODIGO " + 
            " left join sii_novedad n on inv.nov_codigo = n.nov_codigo  " + 
            " left join sii_contrato con on con.con_codigo = n.con_codigo  " + 
            " left join sii_tipo_apuesta tap on inv.tap_codigo = tap.tap_codigo  " + 
            " left join sii_tipo_instrumento ti on ins.tin_codigo = ti.tin_codigo  " + 
            " left join sii_tipo_novedad tn on n.tno_codigo = tn.tno_codigo " + 
            " left join sii_operador ope on ope.ope_codigo = con.ope_codigo " + 
            " left join sii_persona p on p.per_codigo = ope.per_codigo " + 
            " left JOIN sii_reporte_ventas rev ON con.CON_CODIGO = rev.CON_CODIGO " + 
            " left JOIN sii_ventas_met vm on (rev.rve_codigo = vm.rve_codigo and met.met_codigo = vm.met_codigo and con.con_codigo = vm.con_codigo and vm.vme_vigencia=#vigencia and vm.mes_codigo = #mes) " + 
            " where " + 
            " con.con_codigo= #conCodigo " + 
            " and inv.inv_estado IN('R')" + 
            " and con.con_vigente ='S'" + 
            " and trunc(inv.inv_fecha_INI_liq)<=to_Date('"+fechaFin+"','dd/mm/yyyy') and trunc(inv.inv_fecha_fin_liq)>=to_date('"+fechaInicio+"','dd/mm/yyyy')" + 
            " and met.met_online='S'" + 
            " and est.est_estado='A'" +
            " and rev.rve_tipo_reporte = #tipoReporte" + 
            " and rev.rve_vigencia = #vigencia " + 
            " and rev.mes_codigo = #mes"+                       
            " and rev.rve_codigo in (select max(rve_codigo) from sii_reporte_ventas where rve_tipo_reporte=#tipoReporte and rve_vigencia=#vigencia and mes_codigo=#mes and con_codigo= #conCodigo)" +
            " and tn.tno_codigo   in (20,30,60,40) ");
            Query query = manager.createNativeQuery(sql.toString());       
            query.setParameter("conCodigo",conCodigo);
            query.setParameter("vigencia",vigencia);
            query.setParameter("mes",mes);
            query.setParameter("fechaInicio",fechaInicio);
            query.setParameter("fechaFin",fechaFin);
            query.setParameter("tipoReporte",tipoReporte);
            List<Object[]> results = query.getResultList();
            
            if (results != null && !results.isEmpty()) {                
                    for (Object[] object : results) {
                        VentasMetCuotaWSVO ventasMetCuotaWSVo = new VentasMetCuotaWSVO();
                        ventasMetCuotaWSVo.setMetSerial((String)object[0]);
                        ventasMetCuotaWSVo.setMarCodigo(((BigDecimal) object[1]).longValue());
                        ventasMetCuotaWSVo.setMarNombre((String)object[2]);
                        ventasMetCuotaWSVo.setMetNuid((String)object[3]);
                        ventasMetCuotaWSVo.setTapCodigo(((BigDecimal) object[4]).longValue());
                        ventasMetCuotaWSVo.setTapNombre((String)object[5]);                        
                        ventasMetCuotaWSVo.setEstCodigo(((BigDecimal) object[6]).longValue());                        
                        ventasMetCuotaWSVo.setEstNombre((String)object[7]);                        
                        ventasMetCuotaWSVo.setUbiCodigo(Long.parseLong((String) object[8]));
                        ventasMetCuotaWSVo.setUbiNombre((String)object[9]);
                        ventasMetCuotaWSVo.setUbi_codigoPadre(Long.parseLong((String) object[10]));
                        ventasMetCuotaWSVo.setUbiNombrePadre((String)object[11]);                        
                        ventasMetCuotaWSVo.setValorVentasNetas((BigDecimal)object[12]);
                        ventasMetCuotaWSVo.setVmeLiqEfectiva((BigDecimal)object[15]);
                        ventasMetCuotaWSVo.setVmeLiqTarifaFija((BigDecimal)object[14]);                        
                        ventasMetCuotaWSVo.setVmeLiqTarifaVar((BigDecimal)object[13]);                           
                        if (object[18] != null){
                            ventasMetCuotaWSVo.setVmeCodigo(((BigDecimal) object[18]).longValue());
                        }
                        ventasMetCuotaWSVo.setRveCodigo(((BigDecimal) object[19]).longValue());
                        listaVentasMetCuotaOperador.add(ventasMetCuotaWSVo);
                    }
            }
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaVentasMetCuotaOperador;   
    }
    
    public List<SiiCuotaOperador> buscarCuotaOperadorXFecha(Long idContrato,Date fechaLiq) throws ExcepcionDAO {
        List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT cop FROM SiiContrato  con");
            sql.append(" inner join  con.siiLiquidacionMesList liq");
            sql.append(" inner join  liq.siiCuotaOperadorList cop");
            sql.append(" WHERE liq.liqFecha >= :fechaLiq  and con.conCodigo =:idContrato ");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("fechaLiq", fechaLiq);
            consulta.setParameter("idContrato", idContrato);
            listaCuotaOperador = consulta.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCuotaOperador;
    }
    
    public SiiCuotaOperador buscarCuotaOperadorXContratoXOperadorXMesXConceptoXReporteVenta(long codigoContrato, 
                                                                               long codigoOperador,
                                                                               long codigoMes, String conceptoLiq,
                                                                               int anoVigencia) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiLiquidacionMes liq");
            sql.append(" INNER JOIN liq.siiContrato cont");
            sql.append(" INNER JOIN cont.siiOperador ope");            
            sql.append(" INNER JOIN liq.siiReporteVenta rve");            
            sql.append(" WHERE cuot.mesCodigo =:codigoMes");
            sql.append(" AND ope.opeCodigo =:codigoOperador");
            sql.append(" AND cont.conCodigo =:codigoContrato");
            sql.append(" AND liq.liqConcepto =:conceptoLiq");
            sql.append(" AND cuot.copVigencia =:anoVigencia");
            sql.append(" AND cuot.copCancelada ='T'");
            
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoMes", codigoMes);
            consulta.setParameter("codigoOperador", codigoOperador);
            consulta.setParameter("codigoContrato", codigoContrato);
            consulta.setParameter("conceptoLiq", conceptoLiq);
            consulta.setParameter("anoVigencia", anoVigencia);
            

            List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
            listaCuotaOperador = consulta.getResultList();

            if (listaCuotaOperador.size() > 0) {
                siiCuotaOperador = listaCuotaOperador.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }

    public SiiCuotaOperador buscarCuotaOperadorXContratoXOperadorXMesXConceptoXEstado(long codigoContrato, long codigoOperador,
                                                                               long codigoMes, String conceptoLiq,
                                                                               int anoVigencia, String estado) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiLiquidacionMes liq");
            sql.append(" INNER JOIN liq.siiContrato cont");
            sql.append(" INNER JOIN cont.siiOperador ope");
            sql.append(" WHERE cuot.mesCodigo =:codigoMes");
            sql.append(" AND ope.opeCodigo =:codigoOperador");
            sql.append(" AND cont.conCodigo =:codigoContrato");
            sql.append(" AND liq.liqConcepto =:conceptoLiq");
            sql.append(" AND cuot.copVigencia =:anoVigencia");
            
            if (estado!=null)
                sql.append(" AND cuot.copCancelada =:estadoCuota");
            

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoMes", codigoMes);
            consulta.setParameter("codigoOperador", codigoOperador);
            consulta.setParameter("codigoContrato", codigoContrato);
            consulta.setParameter("conceptoLiq", conceptoLiq);
            consulta.setParameter("anoVigencia", anoVigencia);
            
            if (estado!=null)
                consulta.setParameter("estadoCuota", estado);
            

            List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
            listaCuotaOperador = consulta.getResultList();

            if (listaCuotaOperador.size() > 0) {
                siiCuotaOperador = listaCuotaOperador.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }
    
    
    
    /**
     * Obtiene el listado de registros de Cuota Operador, asociados al Contrato, que se encuentran en el rango de fechas especificado.
     * @param conCodigo - C&oacute;digo del Contrato.
     * @param fechaIni - Fecha Inicial <i>(OPCIONAL)</i>.
     * @param fechaFin - Fecha Final <i>(OPCIONAL)</i>.
     * @param listaLiqConceptos - Listado de Conceptos <i>(OPCIONAL)</i>.
     * @return Listado de SiiCuotaOperador.
     * @throws ExcepcionDAO
     */
    public List<SiiCuotaOperador> buscarCuotaOperadorXContratoXFechaXConcepto (Long conCodigo, Date fechaIni, Date fechaFin, List<String> listaLiqConceptos) throws ExcepcionDAO 
    {
        List<SiiCuotaOperador> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT cop FROM SiiContrato con ");
            sql.append(" inner join  con.siiLiquidacionMesList liq ");
            sql.append(" inner join  liq.siiCuotaOperadorList cop ");
            sql.append(" WHERE con.conCodigo = :conCodigo ");
            
            if (fechaIni!=null && fechaFin!=null)
                sql.append(" AND liq.liqFecha BETWEEN :fechaIni  AND  :fechaFin ");
            else if (fechaIni!=null)
                sql.append(" AND liq.liqFecha >= :fechaIni ");
            
            if (listaLiqConceptos!=null && !listaLiqConceptos.isEmpty()) {
                sql.append(" AND liq.liqConcepto IN (");
                
                Iterator<String> it = listaLiqConceptos.iterator();
                while (it.hasNext()) {
                    String concepto = it.next();
                    if (concepto!=null) {
                        sql.append("'"+concepto+"'");
                        
                        if (it.hasNext())
                            sql.append(", ");
                    }
                }
                sql.append(") ");
            }

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("conCodigo", conCodigo);
            
            if (fechaIni!=null)
                consulta.setParameter("fechaIni", fechaIni);
            
            if (fechaFin!=null)
                consulta.setParameter("fechaFin", fechaFin);
            
            resultado = consulta.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        
        return (resultado);
    }
    public List<SiiCuotaOperador> buscarCuotaOperadorXOperadorXContratoXVigenciaXMes(long codigoOperador, long codigoContrato, 
                                                                               int anoVigencia, long codigoMes) 
                                                                                throws ExcepcionDAO {
        List<SiiCuotaOperador> listaCuotaOperador = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiLiquidacionMes liq");
            sql.append(" INNER JOIN liq.siiContrato cont");
            sql.append(" INNER JOIN cont.siiOperador ope");
            sql.append(" WHERE ");
            sql.append(" ope.opeCodigo =:codigoOperador");
            sql.append(" AND cont.conCodigo =:codigoContrato");
            sql.append(" AND cuot.copVigencia =:anoVigencia");
            sql.append(" AND cuot.mesCodigo =:codigoMes");
            Query consulta = manager.createQuery(sql.toString());            
            consulta.setParameter("codigoOperador", codigoOperador);
            consulta.setParameter("codigoContrato", codigoContrato);            
            consulta.setParameter("anoVigencia", anoVigencia);
            consulta.setParameter("codigoMes", codigoMes);
            
            listaCuotaOperador = consulta.getResultList();

            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCuotaOperador;
    }  
    
    /**
     *Metodo encargado de buscar una cuota de un operador para un determinado contrato, concepto,número de cuota y vigencia
     * @author Mónica Pabón
     * @param codigoContrato
     * @param numeroCuota
     * @param concepto
     * @param vigencia
     * @return
     * @throws ExcepcionDAO
     */
    public SiiCuotaOperador buscarCuotaOperadorXContratoXConceptoXNumCuotaXVigencia(String contrato, BigDecimal numeroCuota,
                                                                               BigDecimal conceptoLiq, Integer vigencia) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
        String concepto="";
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiOperador op");           
            sql.append(" INNER JOIN op.siiContratoList cont");
            sql.append (" INNER JOIN cuot.siiConceptoCuota cc");
            sql.append(" WHERE cont.conNumero =:contrato");             
            sql.append(" AND cuot.copVigencia =:vigencia");
            sql.append(" AND cuot.copNumCuota =:numeroCuota");
            sql.append(" AND cc.ccuCodigo = :conceptoLiq");            
                         
            Query consulta = manager.createQuery(sql.toString());          
            consulta.setParameter("contrato", contrato);
            consulta.setParameter("conceptoLiq", conceptoLiq);
            consulta.setParameter("numeroCuota", numeroCuota);
            consulta.setParameter("vigencia", vigencia);


            List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
            listaCuotaOperador = consulta.getResultList();

            if (listaCuotaOperador.size() > 0) {
                siiCuotaOperador = listaCuotaOperador.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }
    
    /**
     *Metodo encargado de buscar numero de cuotas TEMPORALES por acuerdo de pago
     * @author      
     * @return
     * @throws ExcepcionDAO
     */
    public Long buscarNumeroCuotasTemporalesPorAcuerdoPago(long idAcuerdoPago) throws ExcepcionDAO {
        Long consecutivo = null;
         String bandera ="numCuota";
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select max(hca_num_cuota) from sii_hlp_cuota_Acuerdo where apa_codigo=#idAcuerdoPago");
           
            Query query = manager.createNativeQuery(sql.toString());            
            query.setParameter("idAcuerdoPago",idAcuerdoPago);  

            if (query.getSingleResult() != null) {
                consecutivo = new Long(((BigDecimal) query.getSingleResult()).longValue());
            }else {
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
    
    /**
     *Metodo encargado de buscar la última cuota activa de un operador para un determinado contrato, concepto
     * @author Mónica Pabón
     * @param codigoContrato     
     * @param concepto   
     * @return
     * @throws ExcepcionDAO
     */
    public SiiCuotaOperador buscarCuotaOperadorXContratoXConceptoXMesXVigencia(Long contrato, BigDecimal conceptoLiq,
                                                                               Integer vigencia, Integer mes) throws ExcepcionDAO {
        SiiCuotaOperador siiCuotaOperador = null;
        String concepto="";
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiLiquidacionMes lm");           
            sql.append(" INNER JOIN lm.siiContrato cont");
            sql.append (" INNER JOIN cuot.siiConceptoCuota cc");
            sql.append(" WHERE cont.conCodigo =:contrato");                      
            sql.append(" AND cc.ccuCodigo = :conceptoLiq"); 
            sql.append(" AND cuot.copVigencia = :vigencia and cuot.mesCodigo = :mes");
            sql.append(" order by cuot.copCodigo desc");
                         
            Query consulta = manager.createQuery(sql.toString());          
            consulta.setParameter("contrato", contrato);
            consulta.setParameter("conceptoLiq", conceptoLiq);
            consulta.setParameter("vigencia", vigencia);
            consulta.setParameter("mes", mes);

            List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
            listaCuotaOperador = consulta.getResultList();

            if (listaCuotaOperador.size() > 0) {
                siiCuotaOperador = listaCuotaOperador.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiCuotaOperador;
    }


    /**
     * Busca las cuotas operador que tengan el concepto enviado en el parámetro
     * @modified El Gatopardo
     * @param ccuCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiCuotaOperador> buscarCuotaOperadorXCategoriaCuota(String nombreCategoriaCuota) throws ExcepcionDAO {
            List<SiiCuotaOperador> listaCuotaOperador = null;
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT cop FROM SiiCuotaOperador cop");
                sql.append (" INNER JOIN cop.siiConceptoCuota ccu"); 
                sql.append (" INNER join ccu.siiCategoriaDistrib cad");
                sql.append (" where cad.cadNombre = :nombreCategoriaCuota");  
                   
                Query consulta = manager.createQuery(sql.toString());          
                consulta.setParameter("nombreCategoriaCuota", nombreCategoriaCuota);
                listaCuotaOperador = consulta.getResultList();
                
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
           return listaCuotaOperador;
        }
        
        
        
        /**
         * Obtiene el listado de Cuota Operador asociados al Proceso Sancionatorio de Fiscalizaci&oacute;n especificado.
         * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio de Fiscalizaci&oacute;n.
         * @return List of SiiCuotaOperador.
         * @throws ExcepcionDAO
         */
        public List<SiiCuotaOperador> buscarPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO 
        {
            List<SiiCuotaOperador> resultado = null;
            
            if (psaCodigo!=null) {
                try {
                    StringBuilder sql = new StringBuilder();
                    sql.append("SELECT cop FROM SiiCuotaOperador cop ");
                    sql.append("WHERE cop.siiProcesoSancionatorio.psaCodigo = :psaCodigo ");
                    
                    Query query = manager.createQuery(sql.toString());
                    query.setParameter("psaCodigo", psaCodigo) ;   
                    
                    resultado = query.getResultList();
                }
                catch (PersistenceException pe) {
                    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                    throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
                }
            }
            
            return (resultado);
        }
        

    public List<SiiCuotaOperador> buscarCuotasAsociadasAReporteVentasXTipo(String  tipo, Long copCodigo) throws ExcepcionDAO {
         List<SiiCuotaOperador> listaCuotas = new ArrayList();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append(" select o from SiiCuotaOperador o");
            sql.append(" where o.siiLiquidacionMes.siiReporteVentas.rveTipoReporte =:tipo  and  o.copCodigo =:copCodigo ");

            Query query = manager.createQuery(sql.toString());            
            query.setParameter("tipo",tipo);
            query.setParameter("copCodigo",copCodigo);

            listaCuotas = query.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCuotas;
    }
    
    public CuotaOperadorVO BuscarTotalSugeridaMenosModifica(Long idConCodigo, Integer cuota, Long idConceptoCuota ) throws ExcepcionDAO {
        CuotaOperadorVO unaCuotaOperadorVo = new CuotaOperadorVO();
        try {
            StringBuilder sql = new StringBuilder();
            
               sql.append("SELECT nvl(valorSugerida-valorModificada,0) as dif_Cuota,nvl(valorIntCausados-valorIntDecla,0) as dif_int  from (");

               sql.append(" SELECT sum(valorSugerida) as valorSugerida,sum(valorIntCausados) as valorIntCausados,");
               sql.append(" sum(valorModificada) as valorModificada,sum(valorIntDecla)as valorIntDecla FROM (");

               sql.append(" SELECT distinct  e.COP_VALOR as valorSugerida ,SUM(i.icu_valor) AS valorIntCausados , 0 as valorModificada,0 as valorIntDecla from sii_contrato g  ");
               sql.append(" INNER join sii_liquidacion_mes l on g.con_codigo = l.con_codigo   ");
               sql.append(" INNER join sii_cuota_operador e on l.lme_codigo = e.lme_codigo    ");
               sql.append(" LEFT join PR.sii_reporte_ventas r on r.con_codigo = g.con_codigo");
               sql.append(" LEFT JOIN sii_interes_cuota I ON i.cop_codigo = e.cop_codigo");
               sql.append(" where g.con_codigo = #idConCodigo and e.cop_num_cuota =#cuota  and e.ccu_codigo=#idConceptoCuota  and r.rve_tipo_reporte='P'");
               sql.append(" group by e.COP_VALOR");

               sql.append(" UNION ");

               sql.append(" SELECT distinct  0 valorSugerida,0 valorIntCausados,e.COP_VALOR ,dt.dde_valor_inter AS icu_valor from sii_contrato g  ");
               sql.append(" INNER join sii_liquidacion_mes l on g.con_codigo = l.con_codigo   ");
               sql.append(" INNER join sii_cuota_operador e on l.lme_codigo = e.lme_codigo    ");
               sql.append(" left join PR.sii_reporte_ventas r on r.con_codigo = g.con_codigo");
               sql.append(" INNER join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo  ");
               sql.append(" where g.con_codigo = #idConCodigo and e.cop_num_cuota =#cuota  and e.ccu_codigo=#idConceptoCuota  and r.rve_tipo_reporte='M' ");
               sql.append(" ));");
            

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idConCodigo", idConCodigo);
            query.setParameter("cuota", cuota);
            query.setParameter("idConceptoCuota", idConceptoCuota);
            List<Object[]> results = query.getResultList();
            for (Object[] object : results) {
                unaCuotaOperadorVo.setCopValor((BigDecimal) object[0]);
                unaCuotaOperadorVo.setSaldoInteres((BigDecimal) object[1]);
            }
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unaCuotaOperadorVo;
    }
    public List<SiiCuotaOperador> buscarCuotaOperadorXContratoXNumCuota(String contrato, Integer numeroCuota,String liqConcepto ) throws ExcepcionDAO {
        List<SiiCuotaOperador> listaCuotaOperador = new ArrayList<SiiCuotaOperador>();
        String concepto="";
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cuot FROM SiiCuotaOperador cuot");
            sql.append(" INNER JOIN cuot.siiLiquidacionMes liq");           
            sql.append(" INNER JOIN liq.siiContrato cont");
            sql.append(" WHERE cont.conNumero =:contrato");             
            sql.append(" AND cuot.copNumCuota =:numeroCuota");
            sql.append(" AND liq.liqConcepto =:liqConcepto");
    
            Query consulta = manager.createQuery(sql.toString());          
            consulta.setParameter("contrato", contrato);
            consulta.setParameter("numeroCuota", numeroCuota);
            consulta.setParameter("liqConcepto", liqConcepto);
            
            listaCuotaOperador = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaCuotaOperador;
    }


}
