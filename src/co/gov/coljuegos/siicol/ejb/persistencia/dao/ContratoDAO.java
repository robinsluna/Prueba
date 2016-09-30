/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 29-11-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoContrato;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCuentaVO;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class ContratoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ContratoDAO() {
        recursos = new Recursos();
    }

    public SiiContrato insertarSiiContrato(SiiContrato contrato) throws ExcepcionDAO {
        try {
            manager.persist(contrato);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return contrato;
    }

    public List<SiiContrato> buscarContratosPorEstadoEjecucion(String pEstado) throws ExcepcionDAO {
        List<SiiContrato> listaContratos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o INNER JOIN o.siiEstadoContrato pc WHERE o.siiEstadoContrato.ecoEstEjecucion = :pEstado" );
            sql.append(" AND o.conVigente = 'S'" );
            sql.append(" and (o.conFechaFinDefin >= CURRENT_DATE OR o.conFechaFin >= CURRENT_DATE) "  );
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pEstado", pEstado);
            listaContratos = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaContratos;
    }

    public List<SiiContrato> buscarContratosVigentes(String pVigente) throws ExcepcionDAO {
        List<SiiContrato> listaContratos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con FROM SiiContrato con WHERE con.conVigente = :pVigente");
            if("S".equals(pVigente)){
                sql.append(" OR con.conVigente IS NULL");
            }
            sql.append(" order by con.conNumero");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pVigente", pVigente);
            listaContratos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaContratos;
    }
    
    
    public List<SiiContrato> buscarContratosVigentesOrdenDesc() throws ExcepcionDAO {
        List<SiiContrato> listaContratos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con FROM SiiContrato con WHERE con.conVigente = 'S' OR con.conVigente IS NULL");
            sql.append(" order by con.conNumero DESC");
            Query query = manager.createQuery(sql.toString());
            listaContratos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaContratos;
    }


    public List<SiiContrato> buscarContratosEstadoCuenta() throws ExcepcionDAO {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2007);
        cal.set(Calendar.MONTH, 3); //Basado en 0
        cal.set(Calendar.DAY_OF_MONTH, 30);
        Date fechaIni = cal.getTime();
        cal.set(Calendar.YEAR, 2012);
        cal.set(Calendar.MONTH, 3); //Basado en 0
        cal.set(Calendar.DAY_OF_MONTH, 30);
        Date fechaFin = cal.getTime();
        List<SiiContrato> listaContratos = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o where ((o.conFechaIni >= :fechaIni AND o.conFechaFin  >= :fechaFin) OR o.conNumero in ('C0712','C0489'))");
            sql.append("AND o.conNumero NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732') ");
            sql.append("ORDER BY o.conNumero");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("fechaIni", fechaIni);
            query.setParameter("fechaFin", fechaFin);
            listaContratos = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaContratos;
    }


    public SiiContrato buscarContratoPorNumero(String pNumeroContrato) throws ExcepcionDAO {

        SiiContrato miContratoSii = null;
        List<SiiContrato> listaContratos = new ArrayList<SiiContrato>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o WHERE o.conNumero = :pNumeroContrato");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pNumeroContrato", pNumeroContrato);
            listaContratos = query.getResultList();

            if (listaContratos.size() > 0) {
                miContratoSii = listaContratos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miContratoSii;
    }


    public SiiContrato buscarContratoPorId(Long conCodigo) throws ExcepcionDAO {
        SiiContrato siiContrato = null;
        try {
            siiContrato = (SiiContrato) manager.find(SiiContrato.class, conCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiContrato;

    }

    public SiiContrato actualizarSiiContrato(SiiContrato contrato) throws ExcepcionDAO {
        try {
            manager.merge(contrato);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return contrato;
    }

    public SiiContrato buscarContratoPorNumeroContrato(String pNumeroContrato) throws ExcepcionDAO {
        SiiContrato contrato = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiContrato o WHERE o.conNumero = :pNumeroContrato");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pNumeroContrato", pNumeroContrato);
            contrato = (SiiContrato) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return contrato;
    }

    public List<SiiContrato> buscarContratosOuterJoinEstadoSolicitud(String pEstado) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c FROM SiiNovedad n LEFT JOIN n.siiContrato c LEFT JOIN n.siiSolicitudAutoriza s" +
                       " WHERE n.siiSolicitudAutoriza.siiEstadoSolicAutoriz.esaNombre = :pEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pEstado", pEstado);
            List<SiiContrato> listaContratos = query.getResultList();
            return listaContratos;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiContrato> contratosPerfeccionadosSinPolizasPendientes() throws ExcepcionDAO {
        List<SiiContrato> siiContratos = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con FROM SiiContrato con");
            sql.append(" WHERE NOT EXISTS(");
            sql.append(" SELECT pcc FROM SiiPolizaContrat pcc");
            sql.append(" WHERE pcc.siiContrato.conCodigo = con.conCodigo)");
            sql.append(" AND con.siiEstadoContrato.ecoCodigo = :estadoPerfeccionado");
            sql.append(" ORDER BY con.conNumero DESC");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("estadoPerfeccionado", EnumEstadoContrato.PERFECCIONADO.getId());
            
            siiContratos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiContratos;
    }

    public Integer siguienteNumeroContrato() throws ExcepcionDAO {
        Integer i;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select max(to_number(substr(lpad(con_numero,5,'x'),2,5))) from sii_contrato");
            Query query = manager.createNativeQuery(sql.toString());
            BigDecimal x = (BigDecimal) query.getSingleResult();
            i = x.intValue();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return i + 1;
    }

    public List<EstadoCuentaVO> estadoCuenta(String contrato, Integer concepto, Date fechaCorte, boolean isOrderDesc,
                                             String nit) throws ExcepcionDAO {
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

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaSql = "TO_DATE('" + formatter.format(fechaCorte) + "','YYYY/MM/DD HH24:MI:SS') ";

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT distinct CONTRATO,NUMERO_CUOTA,VIGENCIA,MES,FECHA_LIMITE_PAGO,FECHA_PAGO,VALOR_CUOTA,VALOR_PAGADO,");
            sql.append("(VALOR_CUOTA-VALOR_PAGADO) AS SALDO_CUOTA,TOTAL_INTERES,0 AS DIAS_MORA, ");
            sql.append("TIPO,INTERES_PAGADO,(NVL(TOTAL_INTERES,0)-INTERES_PAGADO) AS SALDO_INTERES,CCUCODIGO,FECHA_INICIO_CONTRATO, ");
            sql.append("FECHA_FIN_CONTRATO,NIT,RAZON_SOCIAL  , TOTAL_INTERES, DESTINO_CUOTA, COP_CANCELADA, COP_CODIGO ");
            sql.append("FROM ");
            sql.append("( ");
            sql.append("SELECT CUO.TOTAL_INTERES, CON.CON_NUMERO AS CONTRATO ,CON.CON_FECHA_INI AS FECHA_INICIO_CONTRATO , ");
            sql.append("CON.CON_FECHA_FIN    AS FECHA_FIN_CONTRATO , CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO ,");
            sql.append("(select ccuo.ccu_nombre from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS TIPO , ");
            sql.append("(select ccuo.ccu_destino from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS DESTINO_CUOTA , ");
            sql.append("CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES ,(NVL(DDE.TOTAL_PAGADO_INTERES_DDE,0) + NVL(CUO.TOTAL_PAGADO_INTERES,0) - NVL(CUO.TOTAL_AJUSTE_INTERES,0))  AS INTERES_PAGADO , ");
            sql.append("CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO , CUO.CCU_CODIGO  AS CCUCODIGO, ");
            sql.append("PERSO.PER_NUM_IDENTIFICACION AS NIT,PERSO.PER_JUR_NOMBRE_LARGO   AS RAZON_SOCIAL , VDREC.DRE_CODIGO/*, VALOR_CLASIFICADO*/");
            sql.append(",CUO.TOTAL_PAGADO_INTERES ,  DDE.TOTAL_PAGADO_INTERES_DDE, CUO.COP_CANCELADA, CUO.COP_CODIGO  ");
            sql.append("FROM (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG,  ");
            sql.append("  COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU ");
            sql.append("                        INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO");
            sql.append("                        WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > " +
                       fechaSql +
                       "),0) AS COP_VALOR,COP0.COP_CANCELADA,COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.ATE_CODIGO,");
            sql.append("  (SELECT SUM(ICU0.ICU_VALOR) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " +
                       fechaSql + ") as TOTAL_INTERES,");
            sql.append("  (SELECT SUM(ICU0.ICU_VALOR_PAGADO) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " +
                       fechaSql + ") as TOTAL_PAGADO_INTERES, ");
            sql.append("  (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0 ");
            sql.append("        INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO ");
            sql.append("        INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO ");
            sql.append("        INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " +
                       fechaSql + " ");
            sql.append("        WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES ");
            sql.append("  FROM SII_CUOTA_OPERADOR COP0  ");
            sql.append("  ) CUO ");
            sql.append("LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DDE_VALOR_PAGADO,DDE0.DDE_BASE_CALC_INT,DDE0.DDE_DIAS_INTERES,DDE0.DOP_CODIGO,DDE0.DDE_VALOR_DECLARADO,DDE0.RPD_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAG_INT ,");
            sql.append("                (SELECT SUM(DDE_VALOR_PAG_INT) FROM SII_DETALLE_DECLARACION DDE00 ");
            sql.append("                INNER JOIN VW_DET_REC_RBA_RPS_AJU VDREC ON VDREC.DRE_CODIGO = DDE00.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " +
                       fechaSql + " ");
            sql.append("                WHERE DDE00.COP_CODIGO = DDE0.COP_CODIGO");
            sql.append("                ) AS TOTAL_PAGADO_INTERES_DDE");
            sql.append("            FROM SII_DETALLE_DECLARACION DDE0");
            sql.append("            INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO");
            sql.append("            WHERE DOP.DOP_FECHA <= " + fechaSql + " AND (DDE_ESTADO IS NULL OR DDE_ESTADO <> 'I') ) DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO ");
            sql.append("LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO,");
            sql.append("             (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR ");
            sql.append("              INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " +
                       fechaSql + " ");
            sql.append("              WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC");
            sql.append("            FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " +
                       fechaSql + "");
            sql.append("INNER JOIN SII_LIQUIDACION_MES LME ON LME.LME_CODIGO = CUO.LME_CODIGO ");
            sql.append("INNER JOIN SII_CONTRATO CON ON LME.CON_CODIGO = CON.CON_CODIGO ");
            sql.append("INNER JOIN SII_OPERADOR OPE ON OPE.OPE_CODIGO = CON.OPE_CODIGO ");
            sql.append("INNER JOIN SII_PERSONA PERSO ON PERSO.PER_CODIGO   = OPE.PER_CODIGO ");
            sql.append("WHERE to_date('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql +
                       "");
            sql.append(") TODO ");


            if (!contrato.equals("")) {
                sql.append(" WHERE CONTRATO =#contrato ");
            } else {
                sql.append(" WHERE CONTRATO IN ");
                sql.append("  ( SELECT CONT.CON_NUMERO ");
                sql.append("    FROM SII_CONTRATO CONT ");
                sql.append("    WHERE ( ( CONT.CON_FECHA_INI >= to_date('30/04/2007','DD/MM/YYYY') ");
                sql.append("              AND CONT.CON_FECHA_FIN     >= to_date('30/04/2012','DD/MM/YYYY')" +
                           "             ) ");
                sql.append("           OR CONT.CON_NUMERO    in ('C0712','C0489')" + "          ) ");
                sql.append("    AND CONT.CON_NUMERO NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732' ) ");
                sql.append("  ) ");
            }

            if (concepto > 0) {
                sql.append(" AND CCUCODIGO = #concepto ");
            }

            if (nit != null) {
                sql.append(" AND NIT = #nit ");
            }
            sql.append(" AND (COP_CANCELADA IS NULL OR COP_CANCELADA <> 'I') ");
            sql.append(" ORDER BY CONTRATO , ");
            sql.append(" VIGENCIA " + (isOrderDesc ? "DESC" : "") + " , ");
            sql.append(" NUMERO_CUOTA " + (isOrderDesc ? "DESC" : ""));
            sql.append(" ,NIT " + (isOrderDesc ? "DESC" : "") + ",TIPO ");


            Query query = manager.createNativeQuery(sql.toString());
            if (!contrato.equals("")) {
                query.setParameter("contrato", contrato);
            }

            if (concepto > 0) {
                query.setParameter("concepto", concepto);
            }

            if (nit != null) {
                query.setParameter("nit", nit);
            }

            //query.setParameter("vigencia", vigencia);
            //query.setParameter("fechaCorte", fechaCorte);

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
                elemento.setDestinoCuota((String) object[20]);
                elemento.setCancelada((String) object[21]);
                
                if (object[22]!=null) { 
                    BigDecimal valCopCodigo = (BigDecimal) object[22];
                    elemento.setCopCodigo(valCopCodigo.longValueExact());
                }

                estadoCuentaVO.add(elemento);
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return estadoCuentaVO;
    }


    public List<EstadoCuentaVO> interesesXCuota(String contrato, Integer concepto, Integer cuota) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVO = new ArrayList();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT   ");
            sql.append("   CASE  WHEN ((RB.RBA_FECHA_REC-E.COP_FECHA_LIM_PAG)>0) THEN I.ICU_VALOR ELSE 0 END AS INTERES, "); //0
            sql.append("   CASE  WHEN ((RB.RBA_FECHA_REC-E.COP_FECHA_LIM_PAG)>0) THEN I.ICU_VALOR_PAGADO ELSE 0 END AS INTERES_PAGADO, "); //1
            sql.append("   (RB.RBA_FECHA_REC-E.COP_FECHA_LIM_PAG) as base,   "); //2
            sql.append("   ((CASE  WHEN ((RB.RBA_FECHA_REC-E.COP_FECHA_LIM_PAG)>0) THEN I.ICU_VALOR ELSE 0 END)-(CASE  WHEN ((RB.RBA_FECHA_REC-E.COP_FECHA_LIM_PAG)>0) THEN I.ICU_VALOR_PAGADO ELSE 0 END))  AS SALDO"); //3
            sql.append(" FROM SII_CUOTA_OPERADOR E  ");
            sql.append(" LEFT JOIN SII_INTERES_CUOTA I ON I.COP_CODIGO = E.COP_CODIGO  ");
            sql.append(" LEFT JOIN SII_DETALLE_DECLARACION W ON W.COP_CODIGO = E.COP_CODIGO  ");
            sql.append(" LEFT JOIN SII_DETALLE_RECAUDO H ON W.DRE_CODIGO = H.DRE_CODIGO  ");
            sql.append(" LEFT JOIN SII_RECAUDO_BANCO RB ON RB.RBA_CODIGO = H.RBA_CODIGO  ");
            sql.append(" LEFT JOIN SII_DET_RECAUDO_INTER Q ON Q.DRE_CODIGO  = H.DRE_CODIGO AND I.ICU_CODIGO = Q.ICU_CODIGO   ");
            sql.append(" INNER JOIN SII_LIQUIDACION_MES L ON L.LME_CODIGO  = E.LME_CODIGO AND L.MES_CODIGO = E.MES_CODIGO  ");
            sql.append(" INNER JOIN SII_CONTRATO G ON L.CON_CODIGO = G.CON_CODIGO");
            sql.append(" INNER JOIN SII_OPERADOR O ON O.OPE_CODIGO = E.OPE_CODIGO AND O.OPE_CODIGO   = G.OPE_CODIGO  ");
            sql.append(" WHERE G.CON_NUMERO = #contrato");
            if (concepto != null) {
                sql.append(" AND E.CCU_CODIGO   = #concepto  ");
            }
            sql.append(" AND E.COP_NUM_CUOTA = #cuota  ");
            sql.append(" AND (G.CON_FECHA_INI >= '30/04/2007' AND G.CON_FECHA_FIN  >= '30/04/2012')  ");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("contrato", contrato);
            query.setParameter("concepto", concepto);
            query.setParameter("cuota", cuota);


            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                EstadoCuentaVO elemento = new EstadoCuentaVO();

                elemento.setTotal_interes((BigDecimal) object[0]);
                elemento.setDias_mora((BigDecimal) object[2]);
                elemento.setPagado_interes((BigDecimal) object[1]);
                elemento.setSaldo_interes((BigDecimal) object[3]);

                estadoCuentaVO.add(elemento);
            }
        } catch (NoResultException e) {
            estadoCuentaVO = new ArrayList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return estadoCuentaVO;
    }

    public List<EstadoCuentaVO> estadoAcuerdoPago(String nit, Date fechaCorte) throws ExcepcionDAO {
        List<EstadoCuentaVO> listaEstadoCuentaVo = new ArrayList();

        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        fechaCorte = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaSql = "TO_DATE('" + formatter.format(fechaCorte) + "','YYYY/MM/DD HH24:MI:SS') ";

        try {
            StringBuilder sql = new StringBuilder();


            sql.append("SELECT APA_NUMERO,APA_DOC_ORIGEN,APA_NUM_RESOL,APA_RESOLUC_MODIF, ");
            sql.append("NIT,RAZON_SOCIAL,CCU_ABREVIATURA, ");
            sql.append("NUMERO_CUOTA,VIGENCIA,MES, ");
            sql.append("FECHA_LIMITE_PAGO,FECHA_PAGO, ");
            sql.append("VALOR_CUOTA,VALOR_PAGADO,  ");
            sql.append("TOTAL_INTERES,INTERES_PAGADO, ");
            sql.append("CCU_CODIGO,  ");
            sql.append("APA_NUM_COMITE_APR, ");
            sql.append("APA_FECHA_APR_COMITE, ");
            sql.append("APA_FECHA_INICIO, ");
            sql.append("APA_FECHA_FIN, ");
            sql.append("APA_FECHA_FIRMA_RES, ");
            sql.append("CCU_NOMBRE, ");
            sql.append("APA_FECHA_RESOL, ");
            sql.append("DESTINO_CUOTA ");
            sql.append(" FROM  ");
            sql.append("(  ");
            sql.append("SELECT APA.APA_NUMERO,APA.APA_DOC_ORIGEN,APA.APA_NUM_RESOL,APA.APA_RESOLUC_MODIF, ");
            sql.append("PER.PER_NUM_IDENTIFICACION AS NIT, PER.PER_JUR_NOMBRE_LARGO AS RAZON_SOCIAL,CCU.CCU_ABREVIATURA, ");
            sql.append("CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES, ");
            sql.append("CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO, ");
            sql.append("CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO, ");
            sql.append("CUO.TOTAL_INTERES,(NVL(DDE.TOTAL_PAGADO_INTERES_DDE,0) + NVL(CUO.TOTAL_PAGADO_INTERES,0) - NVL(CUO.TOTAL_AJUSTE_INTERES,0))  AS INTERES_PAGADO, ");
            sql.append("CUO.CCU_CODIGO, ");
            sql.append("APA.APA_NUM_COMITE_APR, ");
            sql.append("APA.APA_FECHA_APR_COMITE, ");
            sql.append("APA.APA_FECHA_INICIO, ");
            sql.append("APA.APA_FECHA_FIN, ");
            sql.append("APA.APA_FECHA_FIRMA_RES, ");
            sql.append("CCU.CCU_NOMBRE, ");
            sql.append("APA.APA_FECHA_RESOL, ");
            sql.append("(select ccuo.ccu_destino from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS DESTINO_CUOTA   ");
            sql.append(" FROM (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG,   ");
            sql.append("    COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU  ");
            sql.append("            INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO ");
            sql.append("            WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > " + fechaSql +
                       "),0) AS COP_VALOR,COP0.COP_CANCELADA,COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.ATE_CODIGO, ");
            sql.append("    (SELECT SUM(ICU0.ICU_VALOR) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " +
                       fechaSql + ") as TOTAL_INTERES, ");
            sql.append("    (SELECT SUM(ICU0.ICU_VALOR_PAGADO) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " +
                       fechaSql + ") as TOTAL_PAGADO_INTERES,  ");
            sql.append("    (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0  ");
            sql.append("        INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO  ");
            sql.append("        INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO  ");
            sql.append("        INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " +
                       fechaSql + "  ");
            sql.append("        WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES  ");
            sql.append("    FROM SII_CUOTA_OPERADOR COP0   ");
            sql.append("    ) CUO  ");
            sql.append("LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DDE_VALOR_PAGADO,DDE0.DDE_BASE_CALC_INT,DDE0.DDE_DIAS_INTERES,DDE0.DOP_CODIGO,DDE0.DDE_VALOR_DECLARADO,DDE0.RPD_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAG_INT , ");
            sql.append("               (SELECT SUM(DDE_VALOR_PAG_INT) FROM SII_DETALLE_DECLARACION DDE00  ");
            sql.append("                INNER JOIN VW_DET_REC_RBA_RPS_AJU VDREC ON VDREC.DRE_CODIGO = DDE00.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " +
                       fechaSql + "  ");
            sql.append("                WHERE DDE00.COP_CODIGO = DDE0.COP_CODIGO ");
            sql.append("                ) AS TOTAL_PAGADO_INTERES_DDE ");
            sql.append("            FROM SII_DETALLE_DECLARACION DDE0 ");
            sql.append("            INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO ");
            sql.append("            WHERE DOP.DOP_FECHA <= " + fechaSql + " AND (DDE_ESTADO IS NULL OR DDE_ESTADO <> 'I') ) DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO  ");
            sql.append("LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO, ");
            sql.append("             (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR   ");
            sql.append("                INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " +
                       fechaSql + "  ");
            sql.append("                WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC ");
            sql.append("            FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " +
                       fechaSql + " ");
            sql.append("INNER JOIN SII_ACUERDO_PAGO APA ON APA.APA_CODIGO = CUO.APA_CODIGO ");
            sql.append("INNER JOIN SII_CONCEPTO_CUOTA CCU ON CCU.CCU_CODIGO = CUO.CCU_CODIGO ");
            sql.append("LEFT JOIN SII_PERSONA PER ON PER.PER_CODIGO   = APA.PER_CODIGO  ");
            sql.append("WHERE to_date('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql +
                       " ");
            sql.append(") TODO  ");

            if (!nit.equals("")) {
                sql.append(" where NIT = #nit ");
            }
            sql.append("ORDER BY APA_NUMERO,VIGENCIA DESC,NUMERO_CUOTA DESC,CCU_ABREVIATURA ");

            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("fechaCorte", fechaCorte);
            if (!nit.equals("")) {
                query.setParameter("nit", nit);
            }

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                EstadoCuentaVO estadoCuentaVo = new EstadoCuentaVO();

                estadoCuentaVo.setNumeroAcuerdoPago(((BigDecimal) object[0]).intValue());
                estadoCuentaVo.setContrato((String) object[1]); //Documento Origen
                estadoCuentaVo.setResolucion((String) object[2]);
                estadoCuentaVo.setResolucionModificatoria((String) object[3]);
                estadoCuentaVo.setNit((String) object[4]);
                estadoCuentaVo.setRazonSocial((String) object[5]);
                estadoCuentaVo.setAbreviaturaConcepto((String) object[6]);
                estadoCuentaVo.setCuota((BigDecimal) object[7]);
                estadoCuentaVo.setAnio((BigDecimal) object[8]);
                estadoCuentaVo.setMes((BigDecimal) object[9]);
                estadoCuentaVo.setFecha_vencimiento((Date) object[10]);
                estadoCuentaVo.setFecha_pago((Date) object[11]);
                estadoCuentaVo.setMonto_obligacion((BigDecimal) object[12]);
                estadoCuentaVo.setMonto_pago((BigDecimal) object[13]);
                estadoCuentaVo.setTotalTodosInteres((BigDecimal) object[14]);
                estadoCuentaVo.setPagado_interes((BigDecimal) object[15]);
                estadoCuentaVo.setCodigoConcepto((BigDecimal) object[16]);
                estadoCuentaVo.setNumComiteApr((String) object[17]);
                estadoCuentaVo.setFechaAprComite((Date) object[18]);
                estadoCuentaVo.setFechaInicio((Date) object[19]);
                estadoCuentaVo.setFechaFin((Date) object[20]);
                estadoCuentaVo.setFechaFirmaRes((Date) object[21]);
                estadoCuentaVo.setDescripcionConcepto((String) object[22]);
                estadoCuentaVo.setFechaResolucion((Date) object[23]);
                estadoCuentaVo.setDestinoCuota((String) object[24]);

                listaEstadoCuentaVo.add(estadoCuentaVo);
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return listaEstadoCuentaVo;
    }

    public List<SiiContrato> buscarContratosPorNit(String nit) throws ExcepcionDAO {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.MONTH, 4);
        cal.set(Calendar.YEAR, 2007);
        Date fechaIni = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.MONTH, 4);
        cal.set(Calendar.YEAR, 2012);
        Date fechaFin = cal.getTime();

        List<SiiContrato> listaContratos = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con FROM SiiContrato con INNER JOIN con.siiOperador ope INNER JOIN ope.siiPersona per INNER JOIN per.siiTipoIdentificacion1 tid" +
                       " WHERE tid.tidCodigo = 31 AND per.perNumIdentificacion = :nit");

            sql.append(" AND con.conNumero IN ");
            sql.append("  ( SELECT CONT.conNumero ");
            sql.append("    FROM SiiContrato CONT ");
            sql.append("    WHERE ( ( CONT.conFechaIni >= :fechaIni ");
            sql.append("              AND CONT.conFechaFin >= :fechaFin" + "             ) ");
            sql.append("           OR CONT.conNumero    in ('C0712','C0489')" + "          ) ");
            sql.append("    AND CONT.conNumero NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732' ) ");
            sql.append("  ) ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("nit", nit);
            query.setParameter("fechaIni", fechaIni);
            query.setParameter("fechaFin", fechaFin);
            listaContratos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaContratos;

    }

    /**
     *Metodo encargado de hacer la consulta del estado de cuenta para los conceptos diferentes a GA y DE
     * Adaptacion por : David Tafur
     * @param contrato
     * @param concepto
     * @param fechaCorte
     * @param isOrderTipo
     * @return
     * @throws ExcepcionDAO
     */
    public List<EstadoCuentaVO> estadoCuentaLiquidacionOtrosConceptos(String nit, Date fechaCorte) throws ExcepcionDAO {
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

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        String fechaSql = "TO_DATE('" + formatter.format(fechaCorte) + "','dd/MM/yy HH24:MI:SS') ";


        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT NUM_DOC_ORIGEN," + 
            "  NUMERO_CUOTA," + 
            "  VIGENCIA," + 
            "  MES," + 
            "  FECHA_LIMITE_PAGO," + 
            "  FECHA_PAGO," + 
            "  VALOR_CUOTA," + 
            "  VALOR_PAGADO," + 
            "  (VALOR_CUOTA-VALOR_PAGADO) AS SALDO_CUOTA," + 
            "  TOTAL_INTERES," + 
            "  TIPO," + 
            "  INTERES_PAGADO," + 
            "  (NVL(TOTAL_INTERES,0)-INTERES_PAGADO) AS SALDO_INTERES," + 
            "  CCUCODIGO,NIT,RAZON_SOCIAL,TOTAL_INTERES,CODIGO_CUOTA," + 
            "  DESTINO_CUOTA," + 
            "   RESOLUCION" +
            "  FROM" + 
            "  (SELECT CUO.TOTAL_INTERES," + 
            "    CUO.COP_VALOR                                              AS VALOR_CUOTA ," + 
            "    (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO ," + 
            "    (SELECT ccuo.ccu_nombre" + 
            "    FROM sii_concepto_cuota ccuo" + 
            "    WHERE ccuo.ccu_codigo = CUO.CCU_CODIGO" + 
            "    )                                                                                                         AS TIPO ," + 
            "    CUO.COP_NUM_CUOTA                                                                                         AS NUMERO_CUOTA," + 
            "    CUO.COP_VIGENCIA                                                                                          AS VIGENCIA," + 
            "    CUO.MES_CODIGO                                                                                            AS MES ," + 
            "    (NVL(DDE.TOTAL_PAGADO_INTERES_DDE,0) + NVL(CUO.TOTAL_PAGADO_INTERES,0) - NVL(CUO.TOTAL_AJUSTE_INTERES,0)) AS INTERES_PAGADO ," + 
            "    CUO.COP_FECHA_LIM_PAG                                                                                     AS FECHA_LIMITE_PAGO ," + 
            "    VDREC.FECHA_PAGO                                                                                          AS FECHA_PAGO ," + 
            "    CUO.CCU_CODIGO                                                                                            AS CCUCODIGO," + 
            "    PERSO.PER_NUM_IDENTIFICACION AS NIT,PERSO.PER_JUR_NOMBRE_LARGO   AS RAZON_SOCIAL ," + 
            "    VDREC.DRE_CODIGO ," + 
            "    CUO.TOTAL_PAGADO_INTERES ," + 
            "    DDE.TOTAL_PAGADO_INTERES_DDE," + 
            "    " + 
            "    CASE" + 
            "      WHEN APA.APA_CODIGO IS NOT NULL" + 
            "      THEN APA.APA_DOC_ORIGEN        " + 
            "      ELSE NULL" + 
            "    END AS NUM_DOC_ORIGEN," + 
            "	 CUO.COP_CODIGO AS CODIGO_CUOTA," + 
            "    (" + 
            "    SELECT ccuo.ccu_destino" + 
            "    FROM sii_concepto_cuota ccuo" + 
            "    WHERE ccuo.ccu_codigo = CUO.CCU_CODIGO" + 
            "    ) AS DESTINO_CUOTA, " + 
            "    APA.APA_NUM_RESOL AS RESOLUCION  " +
            "  FROM" + 
            "    (SELECT COP0.COP_CODIGO," + 
            "      COP0.CCU_CODIGO," + 
            "      COP0.COP_NUM_CUOTA," + 
            "      COP0.COP_TIPO_DOC_SOPOR," + 
            "      COP0.COP_VIGENCIA," + 
            "      COP0.MES_CODIGO," + 
            "      COP0.COP_FECHA_LIM_PAG," + 
            "      COP0.COP_VALOR - NVL(" + 
            "      (SELECT SUM(ACU.AJU_VALOR)" + 
            "      FROM SII_AJUSTE_CUOTA ACU" + 
            "      INNER JOIN SII_AJUSTE AJU" + 
            "      ON AJU.AJU_CODIGO    = ACU.AJU_CODIGO" + 
            "      WHERE ACU.COP_CODIGO = COP0.COP_CODIGO" + 
            "      AND AJU.AJU_FECHA    > " + fechaSql + " " + 
            "      ),0) AS COP_VALOR," + 
            "      COP0.COP_CANCELADA," + 
            "      COP0.OPE_CODIGO," + 
            "      COP0.COP_TIPO_CARTERA," + 
            "      COP0.APA_CODIGO," + 
            "      (SELECT SUM(ICU0.ICU_VALOR)" + 
            "      FROM SII_INTERES_CUOTA ICU0" + 
            "      WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO" + 
            "      AND ICU0.ICU_FECHA   <= " + fechaSql + " " + 
            "      ) AS TOTAL_INTERES," + 
            "      (SELECT SUM(ICU0.ICU_VALOR_PAGADO)" + 
            "      FROM SII_INTERES_CUOTA ICU0" + 
            "      WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO" + 
            "      AND ICU0.ICU_FECHA   <= " + fechaSql + "" + 
            "      ) AS TOTAL_PAGADO_INTERES," + 
            "      (SELECT SUM(ADR_VALOR_INTERES)" + 
            "      FROM SII_DETALLE_DECLARACION DDE0" + 
            "      INNER JOIN SII_DETALLE_RECAUDO DRE0" + 
            "      ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO" + 
            "      INNER JOIN SII_AJUSTE_DET_RECAUDO ADR" + 
            "      ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO" + 
            "      INNER JOIN SII_AJUSTE AJU" + 
            "      ON AJU.AJU_CODIGO     = ADR.AJU_CODIGO" + 
            "      AND AJU.AJU_FECHA     > " + fechaSql + "" + 
            "      WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO" + 
            "      ) AS TOTAL_AJUSTE_INTERES" + 
            "    FROM SII_CUOTA_OPERADOR COP0" + 
            "    ) CUO" + 
            "  LEFT JOIN" + 
            "    (SELECT DDE0.DDE_CODIGO," + 
            "      DDE0.COP_CODIGO," + 
            "      DDE0.DDE_VALOR_PAGADO," + 
            "      DDE0.DDE_BASE_CALC_INT," + 
            "      DDE0.DDE_DIAS_INTERES," + 
            "      DDE0.DOP_CODIGO," + 
            "      DDE0.DDE_VALOR_DECLARADO," + 
            "      DDE0.RPD_CODIGO," + 
            "      DDE0.DRE_CODIGO," + 
            "      DDE0.DDE_VALOR_PAG_INT ," + 
            "      (SELECT SUM(DDE_VALOR_PAG_INT)" + 
            "      FROM SII_DETALLE_DECLARACION DDE00" + 
            "      INNER JOIN VW_DET_REC_RBA_RPS_AJU VDREC" + 
            "      ON VDREC.DRE_CODIGO      = DDE00.DRE_CODIGO" + 
            "      AND VDREC.FECHA_RECAUDO <= " + fechaSql + "" + 
            "      WHERE DDE00.COP_CODIGO   = DDE0.COP_CODIGO" + 
            "      ) AS TOTAL_PAGADO_INTERES_DDE" + 
            "    FROM SII_DETALLE_DECLARACION DDE0" + 
            "    INNER JOIN SII_DECLARACION_OPERADOR DOP" + 
            "    ON DDE0.DOP_CODIGO      = DOP.DOP_CODIGO" + 
            "    WHERE DOP.DOP_FECHA    <= " + fechaSql + "" + 
            "    ) DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO" + 
            "  INNER JOIN" + 
            "    (SELECT FECHA_PAGO," + 
            "      DRE_CODIGO," + 
            "      FECHA_RECAUDO," + 
            "      (SELECT SUM(ADR_VALOR)" + 
            "      FROM SII_AJUSTE_DET_RECAUDO ADR" + 
            "      INNER JOIN SII_AJUSTE AJU" + 
            "      ON AJU.AJU_CODIGO    = ADR.AJU_CODIGO" + 
            "      AND AJU.AJU_FECHA    > " + fechaSql + "" + 
            "      WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO" + 
            "      ) AS VALOR_AJU_REC" + 
            "    FROM VW_DET_REC_RBA_RPS_AJU VDREC0" + 
            "    ) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO" + 
            "  AND VDREC.FECHA_RECAUDO      <= " + fechaSql + "" + 
            "  inner join sii_operador ope " + 
            "  on cuo.ope_codigo = ope.ope_codigo" + 
            "  inner join sii_persona perso" + 
            "  on perso.per_codigo  = ope.per_codigo" + 
            "  LEFT JOIN SII_ACUERDO_PAGO APA ON APA.APA_CODIGO = CUO.APA_CODIGO WHERE to_date('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql + "" + 
            "  ) PAYASO WHERE CCUCODIGO NOT IN(1,2,18,19)");
            
            if (!nit.equals("")) {
                sql.append("AND NIT =#nit ");
            }
            
            sql.append("ORDER BY  NUM_DOC_ORIGEN,VIGENCIA, NIT, NUMERO_CUOTA,TIPO");


            Query query = manager.createNativeQuery(sql.toString());
            if (!nit.equals("")) {
                query.setParameter("nit", nit);
            }

            //query.setParameter("vigencia", vigencia);
            //query.setParameter("fechaCorte", fechaCorte);

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
                        //   elemento.setDias_mora((BigDecimal) object[10]);
                        elemento.setDescripcionConcepto((String) object[10]);
                        elemento.setPagado_interes((BigDecimal) object[11]);
                        elemento.setSaldo_interes((BigDecimal) object[12]);
                        elemento.setCodigoConcepto((BigDecimal) object[13]);
                        elemento.setTotalTodosSaldoInteres((BigDecimal) object[16]);
                        
                        // elemento.setFecha_inicioContraro((Date) object[15]);
                        //elemento.setFecha_finContrato((Date) object[16]);
                        elemento.setNit((String) object[14]);
                        elemento.setRazonSocial((String) object[15]);
                        elemento.setTotalTodosInteres((BigDecimal) object[16]);
                        elemento.setResolucion((String) object[19]);
                        BigDecimal codigoCuota = new BigDecimal(0);
                        codigoCuota = (BigDecimal) object[17];
                        elemento.setCopCodigo(codigoCuota.longValue());
                        elemento.setDestinoCuota((String) object[18]);
        
                        estadoCuentaVO.add(elemento);
                    }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return estadoCuentaVO;
    }

    /**
     *
     * @param pNumeroContrato
     * @param codigoOperador
     * @return
     * @throws ExcepcionDAO
     */
    public SiiContrato buscarContratoPorNumeroYCodigoOperador(String pNumeroContrato,
                                                              long codigoOperador) throws ExcepcionDAO {

        SiiContrato miContratoSii = null;
        List<SiiContrato> listaContratos = new ArrayList<SiiContrato>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o WHERE o.conNumero = :pNumeroContrato");
            sql.append(" AND o.siiOperador.opeCodigo = :codigoOperador");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pNumeroContrato", pNumeroContrato);
            query.setParameter("codigoOperador", codigoOperador);
            listaContratos = query.getResultList();

            if (listaContratos.size() > 0) {
                miContratoSii = listaContratos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miContratoSii;
    }
    
    /**
     * @author Modifica Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiContrato> buscarTodoSiiContrato() throws ExcepcionDAO {
        List<SiiContrato> siiContratos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con FROM SiiContrato con");
            sql.append(" ORDER BY con.conNumero DESC");            
            
            Query query = manager.createQuery(sql.toString());
            siiContratos = query.getResultList();            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiContratos;
    }
    /**
     * 
     * @return Lista de contratos de concesión en estado ejecución diferente de TRAMITE o que tengan estado ejecución igual a TRAMITE y estado = PERFECCIONADO.
     * @throws ExcepcionDAO
     */
    public List<SiiContrato> buscarContratosDesdePerfeccionados() throws ExcepcionDAO {
        List<SiiContrato> siiContratos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o WHERE o.siiEstadoContrato.ecoEstEjecucion <> 'TRÁMITE' or (o.siiEstadoContrato.ecoEstEjecucion = 'TRÁMITE' and o.siiEstadoContrato.ecoNombre = 'PERFECCIONADO')");
            sql.append(" ORDER BY o.conNumero DESC");            
            
            Query query = manager.createQuery(sql.toString());
            siiContratos = query.getResultList();            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiContratos;
    }

    /**
     *
     * @param pNumeroContrato
     * @param codigoOperador
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiContrato> buscarContratosVigentesPorNit(String nit) throws ExcepcionDAO {

        List<SiiContrato> listaContratos = new ArrayList<SiiContrato>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con FROM SiiContrato con");
            sql.append(" INNER JOIN con.siiOperador ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" WHERE per.perNumIdentificacion = :nit");
            sql.append(" AND (con.conVigente = 'S' or con.conVigente IS NULL)");
            //sql.append(" AND con.conFechaFin >= TO_DATE(CURRENT_DATE, 'dd/mm/yyyy')");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("nit", nit);

            listaContratos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaContratos;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiContrato> contratosVigentesSinPolizasPendientes() throws ExcepcionDAO {
        List<SiiContrato> siiContratos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con FROM SiiContrato con");
            sql.append(" WHERE not exists (SELECT ep FROM SiiEstadoPolizaCont ep INNER JOIN SiiPolizaContrat pc WHERE ep.epoNombre LIKE 'BORRADOR%' and con = pc.siiContrato)");
            sql.append(" AND con.siiEstadoContrato.ecoCodigo = " + EnumEstadoContrato.PROYECTADO.getId());
            
            Query query = manager.createQuery(sql.toString());
            
            siiContratos = query.getResultList();            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiContratos;
    }
    
    public List<SiiContrato> buscarContratosXEstadoEjecucionYFechaTermi(String pEstado) throws ExcepcionDAO {
        try {
            Date fecha = new Date();
            Calendar calendar = Calendar.getInstance();
            DateFormat format=new SimpleDateFormat("yyyy/mm/dd");
            calendar=format.getCalendar();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o " );
            sql.append(" WHERE  o.conFechaFinDefin >:fecha order by o.conNumero desc "   );
            Query query = manager.createQuery(sql.toString());
            query.setParameter("fecha", fecha);                     
            
            List<SiiContrato> listaContratos = query.getResultList();
            return listaContratos;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoDAO");
        }
    }
    public List<SiiContrato> buscarContratosXFechaTermi() throws ExcepcionDAO {
        try {
            Date fecha = new Date();
            Calendar calendar = Calendar.getInstance();
            DateFormat format=new SimpleDateFormat("yyyy/mm/dd");
            calendar=format.getCalendar();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o " );
            sql.append(" WHERE  o.conFechaFinDefin <:fecha order by o.conNumero desc "   );
            Query query = manager.createQuery(sql.toString());
            query.setParameter("fecha", fecha);                     
            
            List<SiiContrato> listaContratos = query.getResultList();
            return listaContratos;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoDAO");
        }
    }
    
    
    public List<EstadoCuentaVO> saldoLiqContrato(String contrato) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVO = new ArrayList();

        Date fechaCorte = new Date() ;
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        fechaCorte = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaSql = "TO_DATE('" + formatter.format(fechaCorte) + "','YYYY/MM/DD HH24:MI:SS') ";

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("  select sum(VALOR_CUOTA),sum(VALOR_PAGADO), sum(SALDO_CUOTA) ,nvl(sum(TOTAL_INTERES),0),nvl(sum(INTERES_PAGADO),0),nvl(sum(SALDO_INTERES),0), TIPO  from ( ");
            sql.append("          SELECT distinct CONTRATO,NUMERO_CUOTA,VIGENCIA,MES,FECHA_LIMITE_PAGO,FECHA_PAGO,VALOR_CUOTA,VALOR_PAGADO,");
            sql.append("          (VALOR_CUOTA-VALOR_PAGADO) AS SALDO_CUOTA,TOTAL_INTERES,");
            sql.append("          TIPO,INTERES_PAGADO,(NVL(TOTAL_INTERES,0)-INTERES_PAGADO) AS SALDO_INTERES,CCUCODIGO");
            sql.append("          FROM ");
            sql.append("          ( ");
            sql.append("           SELECT CUO.TOTAL_INTERES, CON.CON_NUMERO AS CONTRATO , ");
            sql.append("           CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO ,");
            sql.append("          (select ccuo.ccu_abreviatura from sii_concepto_cuota ccuo where ccuo.ccu_codigo = CUO.CCU_CODIGO) AS TIPO , ");
            sql.append("          CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES ,(NVL(DDE.TOTAL_PAGADO_INTERES_DDE,0) + NVL(CUO.TOTAL_PAGADO_INTERES,0) - NVL(CUO.TOTAL_AJUSTE_INTERES,0))  AS INTERES_PAGADO , ");
            sql.append("          CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO , CUO.CCU_CODIGO  AS CCUCODIGO, ");
            sql.append("          VDREC.DRE_CODIGO");
            sql.append("         ,CUO.TOTAL_PAGADO_INTERES ,  DDE.TOTAL_PAGADO_INTERES_DDE  ");
            sql.append("        FROM (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG,  ");
            sql.append("          COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU ");
            sql.append("                                 INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO");
            sql.append("                                 WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > "+ fechaSql +"),0) AS COP_VALOR,COP0.COP_CANCELADA,COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.ATE_CODIGO,");
            sql.append("           (SELECT SUM(ICU0.ICU_VALOR) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= "+ fechaSql + ") as TOTAL_INTERES,");
            sql.append("           (SELECT SUM(ICU0.ICU_VALOR_PAGADO) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " + fechaSql +") as TOTAL_PAGADO_INTERES, ");
            sql.append("          (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0 ");
            sql.append("                INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO ");
            sql.append("                INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO ");
            sql.append("                INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA >" + fechaSql+" ");
            sql.append("               WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES ");
            sql.append("         FROM SII_CUOTA_OPERADOR COP0  ");
            sql.append("         ) CUO ");
            sql.append("      LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DDE_VALOR_PAGADO,DDE0.DDE_BASE_CALC_INT,DDE0.DDE_DIAS_INTERES,DDE0.DOP_CODIGO,DDE0.DDE_VALOR_DECLARADO,DDE0.RPD_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAG_INT ,");
            sql.append("                       (SELECT SUM(DDE_VALOR_PAG_INT) FROM SII_DETALLE_DECLARACION DDE00 ");
            sql.append("                       INNER JOIN VW_DET_REC_RBA_RPS_AJU VDREC ON VDREC.DRE_CODIGO = DDE00.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= "+ fechaSql +" " );
            sql.append("                       WHERE DDE00.COP_CODIGO = DDE0.COP_CODIGO");
            sql.append("                       ) AS TOTAL_PAGADO_INTERES_DDE");
            sql.append("                   FROM SII_DETALLE_DECLARACION DDE0");
            sql.append("                   INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO");
            sql.append("                   WHERE DOP.DOP_FECHA <= " + fechaSql + ") DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO ");
            sql.append("      LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO,");
            sql.append("                   (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR ");
            sql.append("                    INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " + fechaSql + " ");
            sql.append("                    WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC");
            sql.append("                  FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " + fechaSql + " " );
            sql.append("      INNER JOIN SII_LIQUIDACION_MES LME ON LME.LME_CODIGO = CUO.LME_CODIGO ");
            sql.append("      INNER JOIN SII_CONTRATO CON ON LME.CON_CODIGO = CON.CON_CODIGO ");
            sql.append("      INNER JOIN SII_OPERADOR OPE ON OPE.OPE_CODIGO = CON.OPE_CODIGO ");
            sql.append("      INNER JOIN SII_PERSONA PERSO ON PERSO.PER_CODIGO   = OPE.PER_CODIGO ");
            sql.append("      WHERE to_date('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= "+ fechaSql );
            sql.append("      ) TODO ");
            sql.append("  WHERE CONTRATO =#contrato ");
            sql.append("  ) group by TIPO   ");
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("contrato", contrato);

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                EstadoCuentaVO elemento = new EstadoCuentaVO();
                elemento.setMonto_obligacion((BigDecimal) object[0]);
                elemento.setTotal_pagado((BigDecimal) object[1]);
                elemento.setSaldo((BigDecimal) object[2]);
                elemento.setTotal_interes((BigDecimal) object[3]);
                elemento.setTotalPagadoInteres((BigDecimal) object[4]);
                elemento.setSaldo_interes((BigDecimal) object[5]);
                elemento.setDescripcionConcepto((String)  object[6]);
                estadoCuentaVO.add(elemento);
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return estadoCuentaVO;
    }
    
    public SiiContrato contratoXRefPagoDeclaracion(Long refPago) throws ExcepcionDAO {
        List<SiiContrato> siiContratos = null;
        SiiContrato contrato = new SiiContrato();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT co FROM SiiContrato co");
            sql.append(" INNER JOIN  co.siiLiquidacionMesList lq ");
            sql.append(" INNER JOIN  lq.siiCuotaOperadorList cu ");
            sql.append(" INNER JOIN  cu.siiDetalleDeclaracionList dt ");
            sql.append(" INNER JOIN  dt.siiReferenciaPagoDecl rf ");
            sql.append(" WHERE rf.rpdNumero = :refPago ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("refPago", refPago);
            siiContratos = query.getResultList();  
            
            if (siiContratos.size() > 0) {
                contrato = siiContratos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return contrato;
    }
    
    public SiiContrato buscarContratoPorNumeroPorNit(String nit, String numeroContrato) throws ExcepcionDAO {

        SiiContrato siiContrato = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT con FROM SiiContrato con");
            sql.append(" INNER JOIN con.siiOperador ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" WHERE per.perNumIdentificacion = :nit");
            sql.append(" AND (con.conVigente = 'S' OR con.conVigente IS NULL)");
            sql.append(" AND con.conNumero = :numeroContrato");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("nit", nit);
            query.setParameter("numeroContrato", numeroContrato);

            List<SiiContrato> listaContratos = query.getResultList();
            if(listaContratos != null && listaContratos.size() > 0){
                siiContrato = listaContratos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiContrato;
    }


    public List<SiiContrato> buscarContratosEnEjecucion() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o WHERE o.siiEstadoContrato.ecoEstEjecucion = 'EJECUCIÓN' ORDER BY o.conNumero DESC");
            Query query = manager.createQuery(sql.toString());
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public List<SiiContrato> buscarContratosEnEjecucionSinTramiteSuspension() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o" + 
            " FROM SiiContrato o" + 
            " JOIN o.siiEstadoContrato eco" + 
            " LEFT JOIN o.siiSuspensionContrList sco" + 
            " LEFT JOIN sco.siiEstadoSuspensionCont esc" + 
            " WHERE (esc.escNombre is null OR esc.escNombre NOT IN ('SOLICITADO','REQUERIDO'))" + 
            " AND eco.ecoEstEjecucion = 'EJECUCIÓN'  ORDER BY o.conNumero DESC");
            Query query = manager.createQuery(sql.toString());
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public void reanudarContratosSuspendidos() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE sii_contrato" + 
            " SET eco_codigo =" + 
            "  ( SELECT eco_codigo FROM sii_estado_contrato WHERE eco_nombre ='REANUDADO'" + 
            "  )" + 
            " WHERE con_codigo IN " + 
            "  (SELECT con.con_codigo" + 
            "  FROM sii_estado_contrato eco" + 
            "  INNER JOIN sii_contrato con" + 
            "  ON con.ECO_CODIGO = eco.ECO_CODIGO" + 
            "  INNER JOIN sii_suspension_contr sco" + 
            "  ON con.CON_CODIGO = sco.CON_CODIGO" + 
            "  INNER JOIN sii_estado_suspension_cont esc" + 
            "  ON sco.ESC_CODIGO    = esc.ESC_CODIGO" + 
            "  WHERE eco.ECO_NOMBRE = 'SUSPENDIDO'" + 
            "  AND esc.esc_nombre   = 'APROBADO'" + 
            "  GROUP BY con.con_codigo" + 
            "  HAVING MAX(sco.sco_fecha_fin_sus_act)<sysdate" +
            "  )");
            Query query = manager.createNativeQuery(sql.toString());
            query.executeUpdate();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    public SiiContrato buscarContratoPorNumeroYConVigente(String pNumeroContrato) throws ExcepcionDAO {

        SiiContrato miContratoSii = null;
        List<SiiContrato> listaContratos = new ArrayList<SiiContrato>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o WHERE o.conNumero = :pNumeroContrato and o.conVigente='S'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pNumeroContrato", pNumeroContrato);
            listaContratos = query.getResultList();

            if (listaContratos.size() > 0) {
                miContratoSii = listaContratos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miContratoSii;
    }
    
    public List<EstadoCuentaVO> estadoMultasSanciones(String nit, Date fechaCorte, Long idCuota) throws ExcepcionDAO {
        List<EstadoCuentaVO> listaEstadoCuentaVo = new ArrayList();

        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        fechaCorte = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaSql = "TO_DATE('" + formatter.format(fechaCorte) + "','YYYY/MM/DD HH24:MI:SS') ";

        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT DISTINCT RESOLUCION,FECHA_RESOLUCION,NIT,RAZON_SOCIAL,COP_CODIGO,CCU_ABREVIATURA,NUMERO_CUOTA,VIGENCIA,MES,");
            sql.append(" FECHA_LIMITE_PAGO,FECHA_PAGO,VALOR_CUOTA,VALOR_PAGADO,");
            sql.append(" TOTAL_INTERES,INTERES_PAGADO,CCUCODIGO,TIPO, DESTINO_CUOTA,");
            sql.append(" (VALOR_CUOTA-VALOR_PAGADO) AS SALDO_CUOTA, COP_CANCELADA, (NVL(TOTAL_INTERES,0)-INTERES_PAGADO) AS SALDO_INTERES");
            sql.append(" FROM ");
            sql.append(" ( ");
            sql.append(" SELECT CUO.TOTAL_INTERES, CUO.COP_VALOR  AS VALOR_CUOTA , (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO ,");
            sql.append(" CCUO.CCU_NOMBRE AS TIPO ,  CCUO.CCU_DESTINO AS DESTINO_CUOTA , CCUO.CCU_ABREVIATURA,");
            sql.append(" CUO.COP_NUM_CUOTA  AS NUMERO_CUOTA,CUO.COP_VIGENCIA  AS VIGENCIA,CUO.MES_CODIGO  AS MES ,(NVL(DDE.TOTAL_PAGADO_INTERES_DDE,0) + NVL(CUO.TOTAL_PAGADO_INTERES,0) - NVL(CUO.TOTAL_AJUSTE_INTERES,0))  AS INTERES_PAGADO , ");
            sql.append(" CUO.COP_FECHA_LIM_PAG  AS FECHA_LIMITE_PAGO ,VDREC.FECHA_PAGO  AS FECHA_PAGO , CUO.CCU_CODIGO  AS CCUCODIGO, ");
            sql.append(" NIT, RAZON_SOCIAL , VDREC.DRE_CODIGO, VCMS.FECHA_RESOLUCION, VCMS.RESOLUCION");
            sql.append(" ,CUO.TOTAL_PAGADO_INTERES ,  DDE.TOTAL_PAGADO_INTERES_DDE, CUO.COP_CANCELADA, CUO.COP_CODIGO  ");
            sql.append(" FROM (SELECT COP0.COP_CODIGO,COP0.LME_CODIGO,COP0.CCU_CODIGO,COP0.COP_NUM_CUOTA,COP0.COP_TIPO_DOC_SOPOR,COP0.COP_VIGENCIA,COP0.MES_CODIGO,COP0.COP_FECHA_LIM_PAG,  ");
            sql.append("   COP0.COP_VALOR - NVL((SELECT SUM(ACU.AJU_VALOR) FROM SII_AJUSTE_CUOTA ACU ");
            sql.append("                         INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ACU.AJU_CODIGO");
            sql.append("                         WHERE ACU.COP_CODIGO = COP0.COP_CODIGO AND AJU.AJU_FECHA > " + fechaSql + "),0) AS COP_VALOR,COP0.COP_CANCELADA,COP0.OPE_CODIGO,COP0.COP_TIPO_CARTERA,COP0.APA_CODIGO,COP0.ATE_CODIGO,");
            sql.append("   (SELECT SUM(ICU0.ICU_VALOR) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " + fechaSql + ") AS TOTAL_INTERES,");
            sql.append("   (SELECT SUM(ICU0.ICU_VALOR_PAGADO) FROM SII_INTERES_CUOTA ICU0 WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO AND ICU0.ICU_FECHA <= " + fechaSql + ") AS TOTAL_PAGADO_INTERES, ");
            sql.append("   (SELECT SUM(ADR_VALOR_INTERES) FROM SII_DETALLE_DECLARACION DDE0 ");
            sql.append("         INNER JOIN SII_DETALLE_RECAUDO DRE0 ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO ");
            sql.append("         INNER JOIN SII_AJUSTE_DET_RECAUDO ADR ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO ");
            sql.append("         INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " + fechaSql + " ");
            sql.append("         WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO) AS TOTAL_AJUSTE_INTERES ");
            sql.append("   FROM SII_CUOTA_OPERADOR COP0  ");
            sql.append("   ) CUO ");
            sql.append(" LEFT JOIN (SELECT DDE0.DDE_CODIGO,DDE0.COP_CODIGO,DDE0.DDE_VALOR_PAGADO,DDE0.DDE_BASE_CALC_INT,DDE0.DDE_DIAS_INTERES,DDE0.DOP_CODIGO,DDE0.DDE_VALOR_DECLARADO,DDE0.RPD_CODIGO,DDE0.DRE_CODIGO,DDE0.DDE_VALOR_PAG_INT ,");
            sql.append("                 (SELECT SUM(DDE_VALOR_PAG_INT) FROM SII_DETALLE_DECLARACION DDE00 ");
            sql.append("                 INNER JOIN VW_DET_REC_RBA_RPS_AJU VDREC ON VDREC.DRE_CODIGO = DDE00.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " + fechaSql + " ");
            sql.append("                 WHERE DDE00.COP_CODIGO = DDE0.COP_CODIGO");
            sql.append("                 ) AS TOTAL_PAGADO_INTERES_DDE");
            sql.append("             FROM SII_DETALLE_DECLARACION DDE0");
            sql.append("             INNER JOIN SII_DECLARACION_OPERADOR DOP ON DDE0.DOP_CODIGO = DOP.DOP_CODIGO");
            sql.append("             WHERE DOP.DOP_FECHA <= " + fechaSql + " AND (DDE_ESTADO IS NULL OR DDE_ESTADO <> 'I') ) DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO ");
            sql.append(" LEFT JOIN (SELECT FECHA_PAGO,DRE_CODIGO,FECHA_RECAUDO,");
            sql.append("              (SELECT SUM(ADR_VALOR) FROM SII_AJUSTE_DET_RECAUDO ADR ");
            sql.append("               INNER JOIN SII_AJUSTE AJU ON AJU.AJU_CODIGO = ADR.AJU_CODIGO AND AJU.AJU_FECHA > " + fechaSql + " ");
            sql.append("               WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO) AS VALOR_AJU_REC");
            sql.append("             FROM VW_DET_REC_RBA_RPS_AJU VDREC0) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO AND VDREC.FECHA_RECAUDO <= " + fechaSql + "");
            sql.append(" INNER JOIN SII_CONCEPTO_CUOTA CCUO ON CCUO.CCU_CODIGO = CUO.CCU_CODIGO");
            sql.append(" INNER JOIN VW_CUO_MUL_SANC VCMS ON VCMS.COP_CODIGO = CUO.COP_CODIGO");
            sql.append(" WHERE TO_DATE('01/' || CUO.MES_CODIGO || '/' || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql + "");
            sql.append(" ) TODO ");
            sql.append(" ");
            sql.append("  WHERE (COP_CANCELADA IS NULL OR COP_CANCELADA <> 'I') ");
            
            if (nit != null && !nit.equals("")) {
                sql.append(" AND NIT = #nit ");
            }
            if (idCuota != null) {
                sql.append(" AND COP_CODIGO = #idCuota ");
            }
            
            sql.append(" ORDER BY COP_CODIGO, FECHA_PAGO ");

            Query query = manager.createNativeQuery(sql.toString());

            if (nit != null && !nit.equals("")) {
                query.setParameter("nit", nit);
            }
            
            if (idCuota != null) {
                query.setParameter("idCuota", idCuota);
            }

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                EstadoCuentaVO estadoCuentaVo = new EstadoCuentaVO();
                estadoCuentaVo.setResolucion((String) object[0]);
                estadoCuentaVo.setFechaResolucion((Date) object[1]); 
                if ( object[2] != null){
                    estadoCuentaVo.setNit((String) object[2]);
                }
                if ( object[3] != null){
                    estadoCuentaVo.setRazonSocial((String) object[3]);
                }
                else{
                    estadoCuentaVo.setRazonSocial("");
                }
                estadoCuentaVo.setCopCodigo (((BigDecimal) object[4]).longValue());
                estadoCuentaVo.setAbreviaturaConcepto((String) object[5]);
                estadoCuentaVo.setCuota((BigDecimal) object[6]);
                estadoCuentaVo.setAnio((BigDecimal) object[7]);
                estadoCuentaVo.setMes((BigDecimal) object[8]);
                estadoCuentaVo.setFecha_vencimiento((Date) object[9]);
                if ( object[10] != null){
                    estadoCuentaVo.setFecha_pago((Date) object[10]);
                }
                estadoCuentaVo.setMonto_obligacion((BigDecimal) object[11]);
                if ( object[12] != null){
                    estadoCuentaVo.setMonto_pago((BigDecimal) object[12]);
                }
                if ( object[13] != null){
                    estadoCuentaVo.setTotalTodosInteres((BigDecimal) object[13]);
                }
                if ( object[14] != null){
                    estadoCuentaVo.setPagado_interes((BigDecimal) object[14]);
                }
                estadoCuentaVo.setCodigoConcepto((BigDecimal) object[15]);
                estadoCuentaVo.setDescripcionConcepto((String) object[16]);                
                estadoCuentaVo.setDestinoCuota((String) object[17]);
                estadoCuentaVo.setSaldo((BigDecimal) object[18]);
                estadoCuentaVo.setCancelada((String) object[19]);
                estadoCuentaVo.setSaldo_interes((BigDecimal) object[20]);
                estadoCuentaVo.setContrato("");

                listaEstadoCuentaVo.add(estadoCuentaVo);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return listaEstadoCuentaVo;
    }
    
    public List<SiiContrato> buscarContratosXEstadoEjecucion(String pEstado) throws ExcepcionDAO {
        
        List<SiiContrato> listaContratos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiContrato o INNER JOIN o.siiEstadoContrato pc WHERE o.siiEstadoContrato.ecoEstEjecucion = :pEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pEstado", pEstado);
            listaContratos = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaContratos;
    }
    
    public List<EstadoCuentaVO> estadoCuentaIlegalidad(String nit, Date fechaCorte, Long idCuota) throws ExcepcionDAO {
        List<EstadoCuentaVO> listaEstadoCuentaVo = new ArrayList();

        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        fechaCorte = cal.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String fechaSql = "TO_DATE('" + formatter.format(fechaCorte) + "','YYYY/MM/DD HH24:MI:SS') ";

        try {
            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT " + 
            "			RPI_NUMERO_RESOL as resolucion," + 
            "			RPI_FECHA_RESOL as fecha_resolucion," + 
            "			NIT," + 
            "			RAZON_SOCIAL," + 
            "			CCU_ABREVIATURA," + 
            "			NUMERO_CUOTA," + 
            "			VIGENCIA," + 
            "			MES," + 
            "			FECHA_LIMITE_PAGO," + 
            "			FECHA_PAGO," + 
            "			VALOR_CUOTA," + 
            "			VALOR_PAGADO," + 
            "			TOTAL_INTERES," + 
            "			INTERES_PAGADO," + 
            "			CCU_CODIGO," + 
            "			CCU_NOMBRE," + 
            "			DESTINO_CUOTA" + 
            "			FROM" + 
            "			(SELECT" + 
            "			  rpi.RPI_NUMERO_RESOL                                       , " + 
            "			  rpi.RPI_FECHA_RESOL                                        ,  " + 
            "			  PER.PER_NUM_IDENTIFICACION AS NIT," + 
            "			  case per.per_tipo_persona " + 
            "			  WHEN 'J' THEN PER_JUR_NOMBRE_LARGO " + 
            "			  WHEN 'N' then PER_PRIMER_NOMBRE || ' ' || PER_SEGUNDO_NOMBRE || ' ' || PER_PRIMER_APELLIDO || ' ' || PER_SEGUNDO_APELLIDO" + 
            "			  END  AS RAZON_SOCIAL," + 
            "			  CCU.CCU_ABREVIATURA," + 
            "			  CUO.COP_NUM_CUOTA                                          AS NUMERO_CUOTA," + 
            "			  CUO.COP_VIGENCIA                                           AS VIGENCIA," + 
            "			  CUO.MES_CODIGO                                             AS MES," + 
            "			  CUO.COP_FECHA_LIM_PAG                                      AS FECHA_LIMITE_PAGO ," + 
            "			  VDREC.FECHA_PAGO                                           AS FECHA_PAGO," + 
            "			  CUO.COP_VALOR                                              AS VALOR_CUOTA ," + 
            "			  (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO," + 
            "			  CUO.TOTAL_INTERES," + 
            "			  (NVL(DDE.TOTAL_PAGADO_INTERES_DDE,0) + NVL(CUO.TOTAL_PAGADO_INTERES,0) - NVL(CUO.TOTAL_AJUSTE_INTERES,0)) AS INTERES_PAGADO," + 
            "			  CUO.CCU_CODIGO," + 
            "			  CCU.CCU_NOMBRE," + 
            "			  (SELECT ccuo.ccu_destino" + 
            "			  FROM sii_concepto_cuota ccuo" + 
            "			  WHERE ccuo.ccu_codigo = CUO.CCU_CODIGO" + 
            "			  ) AS DESTINO_CUOTA" + 
            "			FROM" + 
            "			  (SELECT COP0.COP_CODIGO," + 
            "				COP0.LME_CODIGO," + 
            "				COP0.CCU_CODIGO," + 
            "				COP0.COP_NUM_CUOTA," + 
            "				COP0.COP_TIPO_DOC_SOPOR," + 
            "				COP0.COP_VIGENCIA," + 
            "				COP0.MES_CODIGO," + 
            "				COP0.COP_FECHA_LIM_PAG," + 
            "				COP0.COP_VALOR - NVL(" + 
            "				(SELECT SUM(ACU.AJU_VALOR)" + 
            "				FROM SII_AJUSTE_CUOTA ACU" + 
            "				INNER JOIN SII_AJUSTE AJU" + 
            "				ON AJU.AJU_CODIGO    = ACU.AJU_CODIGO" + 
            "				WHERE ACU.COP_CODIGO = COP0.COP_CODIGO" + 
            "				AND AJU.AJU_FECHA    >  " + fechaSql + 
            "				),0) AS COP_VALOR," + 
            "				COP0.COP_CANCELADA," + 
            "				COP0.OPE_CODIGO," + 
            "				COP0.COP_TIPO_CARTERA," + 
            "				COP0.APA_CODIGO," + 
            "				COP0.ATE_CODIGO," + 
            "				COP0.ICN_CODIGO," + 
            "				COP0.CAA_CODIGO," + 
            "				COP0.PRS_CODIGO," + 
            "				(SELECT SUM(ICU0.ICU_VALOR)" + 
            "				FROM SII_INTERES_CUOTA ICU0" + 
            "				WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO" + 
            "				AND ICU0.ICU_FECHA   <= " + fechaSql + 
            "				) AS TOTAL_INTERES," + 
            "				(SELECT SUM(ICU0.ICU_VALOR_PAGADO)" + 
            "				FROM SII_INTERES_CUOTA ICU0" + 
            "				WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO" + 
            "				AND ICU0.ICU_FECHA   <= " + fechaSql + 
            "				) AS TOTAL_PAGADO_INTERES," + 
            "				(SELECT SUM(ADR_VALOR_INTERES)" + 
            "				FROM SII_DETALLE_DECLARACION DDE0" + 
            "				INNER JOIN SII_DETALLE_RECAUDO DRE0" + 
            "				ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO" + 
            "				INNER JOIN SII_AJUSTE_DET_RECAUDO ADR" + 
            "				ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO" + 
            "				INNER JOIN SII_AJUSTE AJU" + 
            "				ON AJU.AJU_CODIGO     = ADR.AJU_CODIGO" + 
            "				AND AJU.AJU_FECHA     > sysdate  " + 
            "				WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO" + 
            "				) AS TOTAL_AJUSTE_INTERES" + 
            "			  FROM SII_CUOTA_OPERADOR COP0" + 
            "			  ) CUO" + 
            "			LEFT JOIN" + 
            "			  (SELECT DDE0.DDE_CODIGO," + 
            "				DDE0.COP_CODIGO," + 
            "				DDE0.DDE_VALOR_PAGADO," + 
            "				DDE0.DDE_BASE_CALC_INT," + 
            "				DDE0.DDE_DIAS_INTERES," + 
            "				DDE0.DOP_CODIGO," + 
            "				DDE0.DDE_VALOR_DECLARADO," + 
            "				DDE0.RPD_CODIGO," + 
            "				DDE0.DRE_CODIGO," + 
            "				DDE0.DDE_VALOR_PAG_INT ," + 
            "				(SELECT SUM(DDE_VALOR_PAG_INT)" + 
            "				FROM SII_DETALLE_DECLARACION DDE00" + 
            "				INNER JOIN VW_DET_REC_RBA_RPS_AJU VDREC" + 
            "				ON VDREC.DRE_CODIGO      = DDE00.DRE_CODIGO" + 
            "				AND VDREC.FECHA_RECAUDO <= " + fechaSql + 
            "				WHERE DDE00.COP_CODIGO   = DDE0.COP_CODIGO" + 
            "				) AS TOTAL_PAGADO_INTERES_DDE" + 
            "			  FROM SII_DETALLE_DECLARACION DDE0" + 
            "			  INNER JOIN SII_DECLARACION_OPERADOR DOP" + 
            "			  ON DDE0.DOP_CODIGO      = DOP.DOP_CODIGO" + 
            "			  WHERE DOP.DOP_FECHA    <= " + fechaSql +  
            "			  AND (DDE_ESTADO        IS NULL" + 
            "			  OR DDE_ESTADO          <> 'I')" + 
            "			  ) DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO" + 
            "			LEFT JOIN" + 
            "			  (SELECT FECHA_PAGO," + 
            "				DRE_CODIGO," + 
            "				FECHA_RECAUDO," + 
            "				(SELECT SUM(ADR_VALOR)" + 
            "				FROM SII_AJUSTE_DET_RECAUDO ADR" + 
            "				INNER JOIN SII_AJUSTE AJU" + 
            "				ON AJU.AJU_CODIGO    = ADR.AJU_CODIGO" + 
            "				AND AJU.AJU_FECHA    > " + fechaSql + 
            "				WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO" + 
            "				) AS VALOR_AJU_REC" + 
            "			  FROM VW_DET_REC_RBA_RPS_AJU VDREC0" + 
            "			  ) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO" + 
            "			AND VDREC.FECHA_RECAUDO      <= " + fechaSql + 
            "			inner join sii_proceso_sanc_ilegalidad psi on  (psi.prs_codigo = CUO.prs_codigo)" + 
            "			inner join sii_persona_invest_pro_ile pipi on (pipi.prs_codigo = psi.prs_codigo )" + 
            "			inner join sii_persona per on (pipi.per_codigo = per.per_codigo)" + 
            "			inner join sii_resolucion_proc_ileg rpi on (rpi.rpi_codigo = psi.rpi_codigo)" + 
            "			INNER JOIN SII_CONCEPTO_CUOTA CCU ON CCU.CCU_CODIGO = CUO.CCU_CODIGO" + 
            "			WHERE to_date('01/'   || CUO.MES_CODIGO  || '/'  || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql + 
            "			) TODO WHERE 1=1"        );        
            
            if (nit != null && !nit.equals("")) {
                sql.append(" AND NIT = #nit ");
            }
            if (idCuota != null) {
                sql.append(" AND COP_CODIGO = #id_cuota ");
            }
            //sql.append("ORDER BY resolucion,VIGENCIA DESC,NUMERO_CUOTA DESC,CCU_ABREVIATURA ");
            //sql.append("ORDER BY resolucion,VIGENCIA DESC,NUMERO_CUOTA DESC,CCU_ABREVIATURA, FECHA_PAGO ");
            
            sql.append(" UNION " +
            " SELECT " +
            " resolucion as resolucion, " +
            " fecha_resolucion as fecha_resolucion, " +
            " NIT, " +
            " RAZON_SOCIAL, " +
            " CCU_ABREVIATURA, " +
            " NUMERO_CUOTA, " +
            " VIGENCIA, " +
            " MES, " +
            " FECHA_LIMITE_PAGO, " +
            " FECHA_PAGO, " +
            " VALOR_CUOTA, " +
            " VALOR_PAGADO, " +
            " TOTAL_INTERES, " +
            " INTERES_PAGADO, " +
            " CCU_CODIGO, " +
            " CCU_NOMBRE, " +
            " DESTINO_CUOTA " +
            " FROM " +
            " (SELECT " +
            " to_char(caa.CAA_NUM_RESOLUCION) as resolucion," + 
            " caa.CAA_FECHA_RESOLUC as fecha_resolucion ," +            
            "  PER.PER_NUM_IDENTIFICACION AS NIT, " +
            "  case per.per_tipo_persona  " +
            "  WHEN 'J' THEN PER_JUR_NOMBRE_LARGO  " +
            "  WHEN 'N' then PER_PRIMER_NOMBRE || ' ' || PER_SEGUNDO_NOMBRE || ' ' || PER_PRIMER_APELLIDO || ' ' || PER_SEGUNDO_APELLIDO " +
            "  END  AS RAZON_SOCIAL, " +
            "  CCU.CCU_ABREVIATURA,  " +
            " CUO.COP_NUM_CUOTA                                          AS NUMERO_CUOTA, " +
            " CUO.COP_VIGENCIA                                           AS VIGENCIA,         " +
            "  CUO.MES_CODIGO                                             AS MES, " +
            " CUO.COP_FECHA_LIM_PAG                                      AS FECHA_LIMITE_PAGO , " +
            " VDREC.FECHA_PAGO                                           AS FECHA_PAGO, " +
            " CUO.COP_VALOR                                              AS VALOR_CUOTA , " +
            " (NVL(DDE.DDE_VALOR_PAGADO,0) - NVL(VDREC.VALOR_AJU_REC,0)) AS VALOR_PAGADO, " +
            " CUO.TOTAL_INTERES, " +
            " (NVL(DDE.TOTAL_PAGADO_INTERES_DDE,0) + NVL(CUO.TOTAL_PAGADO_INTERES,0) - NVL(CUO.TOTAL_AJUSTE_INTERES,0)) AS INTERES_PAGADO, " +
            " CUO.CCU_CODIGO, " +
            " CCU.CCU_NOMBRE, " +
            " (SELECT ccuo.ccu_destino " +
            " FROM sii_concepto_cuota ccuo " +
            " WHERE ccuo.ccu_codigo = CUO.CCU_CODIGO " +
            " ) AS DESTINO_CUOTA " +
            " FROM " +
            " (SELECT COP0.COP_CODIGO, " +
            "       COP0.LME_CODIGO, " +
            "       COP0.CCU_CODIGO, " +
            "       COP0.COP_NUM_CUOTA, " +
            "       COP0.COP_TIPO_DOC_SOPOR, " +
            "       COP0.COP_VIGENCIA, " +
            "       COP0.MES_CODIGO, " +
            "       COP0.COP_FECHA_LIM_PAG, " +
            "       COP0.COP_VALOR - NVL( " +
            "       (SELECT SUM(ACU.AJU_VALOR) " +
            "       FROM SII_AJUSTE_CUOTA ACU " +
            "       INNER JOIN SII_AJUSTE AJU " +
            "       ON AJU.AJU_CODIGO    = ACU.AJU_CODIGO " +
            "       WHERE ACU.COP_CODIGO = COP0.COP_CODIGO " +
            "       AND AJU.AJU_FECHA    >  " + fechaSql + 
            "       ),0) AS COP_VALOR, " +
            "       COP0.COP_CANCELADA, " +
            "       COP0.OPE_CODIGO, " +
            "       COP0.COP_TIPO_CARTERA, " +
            "       COP0.APA_CODIGO, " +
            "       COP0.ATE_CODIGO, " +
            "       COP0.ICN_CODIGO, " +
            "       COP0.CAA_CODIGO, " +
            "       COP0.PRS_CODIGO, " +
            "       (SELECT SUM(ICU0.ICU_VALOR) " +
            "       FROM SII_INTERES_CUOTA ICU0 " +
            "       WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO " +
            "       AND ICU0.ICU_FECHA   <= " + fechaSql + 
            "       ) AS TOTAL_INTERES, " +
            "       (SELECT SUM(ICU0.ICU_VALOR_PAGADO) " +
            "       FROM SII_INTERES_CUOTA ICU0 " +
            "       WHERE ICU0.COP_CODIGO = COP0.COP_CODIGO " +
            "       AND ICU0.ICU_FECHA   <= " + fechaSql + 
            "       ) AS TOTAL_PAGADO_INTERES, " +
            "       (SELECT SUM(ADR_VALOR_INTERES) " +
            "       FROM SII_DETALLE_DECLARACION DDE0 " +
            "       INNER JOIN SII_DETALLE_RECAUDO DRE0 " +
            "       ON DRE0.DRE_CODIGO = DDE0.DRE_CODIGO " +
            "       INNER JOIN SII_AJUSTE_DET_RECAUDO ADR " +
            "       ON ADR.DRE_CODIGO = DRE0.DRE_CODIGO " +
            "       INNER JOIN SII_AJUSTE AJU " +
            "       ON AJU.AJU_CODIGO     = ADR.AJU_CODIGO " +
            "       AND AJU.AJU_FECHA     > " + fechaSql +  
            "       WHERE DDE0.COP_CODIGO = COP0.COP_CODIGO " +
            "       ) AS TOTAL_AJUSTE_INTERES " +
            "  FROM SII_CUOTA_OPERADOR COP0 " +
            "  ) CUO " + 
            " LEFT JOIN " +
            "  (SELECT DDE0.DDE_CODIGO, " +
            "       DDE0.COP_CODIGO, " +
            "       DDE0.DDE_VALOR_PAGADO, " +
            "       DDE0.DDE_BASE_CALC_INT, " +
            "       DDE0.DDE_DIAS_INTERES, " +
            "       DDE0.DOP_CODIGO, " +
            "       DDE0.DDE_VALOR_DECLARADO, " +
            "       DDE0.RPD_CODIGO, " +
            "       DDE0.DRE_CODIGO, " +
            "       DDE0.DDE_VALOR_PAG_INT , " +
            "       (SELECT SUM(DDE_VALOR_PAG_INT) " +
            "       FROM SII_DETALLE_DECLARACION DDE00 " +
            "       INNER JOIN VW_DET_REC_RBA_RPS_AJU VDREC " + 
            "       ON VDREC.DRE_CODIGO      = DDE00.DRE_CODIGO " +
            "       AND VDREC.FECHA_RECAUDO <= " + fechaSql + 
            "       WHERE DDE00.COP_CODIGO   = DDE0.COP_CODIGO " +
            "       ) AS TOTAL_PAGADO_INTERES_DDE " +
            "  FROM SII_DETALLE_DECLARACION DDE0 " +
            "  INNER JOIN SII_DECLARACION_OPERADOR DOP " +
            "  ON DDE0.DOP_CODIGO      = DOP.DOP_CODIGO " +
            "  WHERE DOP.DOP_FECHA    <= " + fechaSql +  
            "  AND (DDE_ESTADO        IS NULL " +
            "  OR DDE_ESTADO          <> 'I') " +
            "  ) DDE ON CUO.COP_CODIGO = DDE.COP_CODIGO " +
            " LEFT JOIN " +
            "  (SELECT FECHA_PAGO, " +
            "       DRE_CODIGO, " +
            "       FECHA_RECAUDO, " +
            "       (SELECT SUM(ADR_VALOR) " +
            "       FROM SII_AJUSTE_DET_RECAUDO ADR " +
            "       INNER JOIN SII_AJUSTE AJU " +
            "       ON AJU.AJU_CODIGO    = ADR.AJU_CODIGO  " +
            "       AND AJU.AJU_FECHA    > " + fechaSql + 
            "       WHERE ADR.DRE_CODIGO = VDREC0.DRE_CODIGO " +
            "       ) AS VALOR_AJU_REC " +
            "  FROM VW_DET_REC_RBA_RPS_AJU VDREC0 " +
            "  ) VDREC ON VDREC.DRE_CODIGO = DDE.DRE_CODIGO " +
            " AND VDREC.FECHA_RECAUDO      <= " + fechaSql + 
            " INNER JOIN sii_carga_actuaciones_adm caa on caa.caa_codigo = cuo.caa_codigo " +
            " INNER JOIN sii_persona per on (caa.per_codigo = per.per_codigo) " +
            " INNER JOIN SII_CONCEPTO_CUOTA CCU ON CCU.CCU_CODIGO = CUO.CCU_CODIGO " +
            " WHERE to_date('01/'   || CUO.MES_CODIGO  || '/'  || CUO.COP_VIGENCIA,'DD/MM/YYYY') <= " + fechaSql + 
            " ) TODO WHERE 1=1  " );       
            

            if (nit != null && !nit.equals("")) {
                sql.append(" AND NIT = #nit ");
            }
            if (idCuota != null) {
                sql.append(" AND COP_CODIGO = #id_cuota ");
            }
            //sql.append("ORDER BY resolucion,VIGENCIA DESC,NUMERO_CUOTA DESC,CCU_ABREVIATURA ");
            //sql.append("ORDER BY resolucion,VIGENCIA DESC,NUMERO_CUOTA DESC,CCU_ABREVIATURA, FECHA_PAGO ");

            Query query = manager.createNativeQuery(sql.toString());

            query.setParameter("fechaCorte", fechaCorte);
            if (nit != null && !nit.equals("")) {
                query.setParameter("nit", nit);
            }

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                EstadoCuentaVO estadoCuentaVo = new EstadoCuentaVO();
                estadoCuentaVo.setResolucion((String) object[0]);
                estadoCuentaVo.setFechaResolucion((Date) object[1]); 
                estadoCuentaVo.setNit((String) object[2]);
                estadoCuentaVo.setRazonSocial((String) object[3]);
                //estadoCuentaVo.setCopCodigo (((BigDecimal) object[4]).longValue());
                estadoCuentaVo.setAbreviaturaConcepto((String) object[4]);
                estadoCuentaVo.setCuota((BigDecimal) object[5]);
                estadoCuentaVo.setAnio((BigDecimal) object[6]);
                estadoCuentaVo.setMes((BigDecimal) object[7]);
                estadoCuentaVo.setFecha_vencimiento((Date) object[8]);
                if ( object[9] != null){
                    estadoCuentaVo.setFecha_pago((Date) object[9]);
                }
                estadoCuentaVo.setMonto_obligacion((BigDecimal) object[10]);
                if ( object[11] != null){
                    estadoCuentaVo.setMonto_pago((BigDecimal) object[11]);
                }
                if ( object[12] != null){
                    estadoCuentaVo.setTotalTodosInteres((BigDecimal) object[12]);
                }
                if ( object[13] != null){
                    estadoCuentaVo.setPagado_interes((BigDecimal) object[13]);
                }
                estadoCuentaVo.setCodigoConcepto((BigDecimal) object[14]);
                estadoCuentaVo.setDescripcionConcepto((String) object[15]);                
                estadoCuentaVo.setDestinoCuota((String) object[16]);
                //estadoCuentaVo.setCopCodigo(((BigDecimal) object[14]).longValue());

                listaEstadoCuentaVo.add(estadoCuentaVo);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return listaEstadoCuentaVo;
    }
    public SiiContrato buscarContratoPorCedente(Long conCodigo) throws ExcepcionDAO {
        SiiContrato contrato = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiContrato o WHERE o.siiContratoCedente.conCodigo = :conCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            contrato = (SiiContrato) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return contrato;
    }

}
