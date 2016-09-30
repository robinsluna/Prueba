/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 26-02-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoImputacionContable;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.BalancePruebaVO;

import co.gov.coljuegos.siicol.ejb.vo.FiltrosBalancePruebaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;



@Stateless
@LocalBean
public class BalancePruebaDAO 
{
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    @EJB
    private CuentasContablesDAO cuentasContablesDao;
    
    private final String FECHA_INICIAL_KEY = "fechaInicial";
    private final String FECHA_FINAL_KEY = "fechaFinal";
    
    
    ///////////
    // MAPAS //
    ///////////
    private Map<String, SiiCuentasContables> mapaCuentasContables;
    
    
    /**
     * Constructor.
     */
    public BalancePruebaDAO() {
        recursos = new Recursos();
        
        this.mapaCuentasContables = new HashMap<String, SiiCuentasContables>();
    }
    
    
    
    /**
     * Obtiene un mapa que contiene la Fecha Inicial y Final para calcular los registros durante el periodo de Saldo Inicial.
     * @param filtros - Filtros aplicados al Balance de Prueba.
     * @return instance of Map<String, Date>
     */
    private Map<String, Date> obtenerFechasSaldoInicial (FiltrosBalancePruebaVO filtros) 
    {
        Map<String, Date> mapaFechas = null;
        
        if (filtros!=null && filtros.getFechaInicial()!=null) {
            mapaFechas = new HashMap<String, Date>();
            // TODO obtener la fecha inicial como el siguiente dia a partir de la fecha de cierre de mes
            Calendar calFechaIni = Calendar.getInstance();
            calFechaIni.set(Calendar.MONTH, 0);
            calFechaIni.set(Calendar.DAY_OF_MONTH, 1);
            calFechaIni.set(Calendar.YEAR, 2013);
            Date fechaInicial = Utilidades.truncDate(calFechaIni.getTime());
            mapaFechas.put(FECHA_INICIAL_KEY, fechaInicial);
            
            Calendar calFechaFin = Calendar.getInstance();
            calFechaFin.setTime(filtros.getFechaInicial());
            // establecer el dia anterior como fecha de fin
            calFechaFin.add(Calendar.DAY_OF_MONTH, -1);
            Date fechaFinal = Utilidades.truncDate(calFechaFin.getTime());
            mapaFechas.put(FECHA_FINAL_KEY, fechaFinal);
        }
        
        return (mapaFechas);
    }
    
    
    
    
    /**
     * Realiza la b&uacute;squeda de los C&oacute;digos de Cuentas Contables que pertenecen al rango de fechas del saldo inicial, 
     * pero que no se encuentran dentro del rango de fechas elegido en el filtro del reporte.
     * @param filtros - Filtros aplicados al Balance de Prueba.
     * @return Listado de C&oacute;digos de Cuenta Contable.
     * @throws PersistenceException
     */
    private List<Long> buscarIdCuentasContablesSaldoInicial (FiltrosBalancePruebaVO filtros) throws PersistenceException 
    {
        List<Long> ccoCodigoList = null;
        
        if (filtros!=null && filtros.getFechaInicial()!=null && filtros.getFechaFinal()!=null && filtros.getCodigosCuentaContable()!=null) {
            
            Date fechaIniSaldoInicial = null;
            Date fechaFinSaldoInicial = null;
            
            Map<String, Date> mapaFechasSaldoInicial = this.obtenerFechasSaldoInicial(filtros);
            if (mapaFechasSaldoInicial!=null) {
                fechaIniSaldoInicial = mapaFechasSaldoInicial.get(FECHA_INICIAL_KEY);
                fechaFinSaldoInicial = mapaFechasSaldoInicial.get(FECHA_FINAL_KEY);
            }
            
            
            if (fechaIniSaldoInicial!=null && fechaFinSaldoInicial!=null) {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT CCO_CODIGO ");
                sql.append("FROM ( "); 
                sql.append("      SELECT ");
                sql.append("        cco.CCO_CODIGO ");
                sql.append("      FROM SII_DOCUMENTO_CONTABLE dco ");
                sql.append("      INNER JOIN SII_IMPUTACION_CONTABLE imc ON imc.DCO_CODIGO = dco.DCO_CODIGO ");
                sql.append("      INNER JOIN SII_CUENTAS_CONTABLES cco ON cco.cco_codigo = imc.cco_codigo ");
                sql.append("      INNER JOIN SII_PERSONA p ON p.PER_CODIGO = imc.PER_CODIGO ");
                sql.append("      WHERE TRUNC(dco.DCO_FECHA_OPER) BETWEEN #fechaIniSaldoInicial  AND  #fechaFinSaldoInicial ");
                sql.append("      AND dco.edo_codigo = #edoCodigo ");
                sql.append("      AND imc.IMC_ESTADO = #imcEstado ");
                
                if (filtros.getCodigosCuentaContable()!=null) {
                    int size = filtros.getCodigosCuentaContable().size();
                    if (size>0) {
                        sql.append("        AND cco.CCO_CODIGO IN (");
                        for (int i=0; i<size; i++) {
                            Long ccoCodigo = filtros.getCodigosCuentaContable().get(i);
                            if (ccoCodigo!=null) {
                                sql.append(ccoCodigo.toString());
                                if (i<size-1)
                                    sql.append(", ");
                            }
                        }
                        sql.append(") ");
                    }
                }
                 
                sql.append("      ) "); 
                sql.append("MINUS ( ");
                sql.append("        SELECT  ");
                sql.append("            cco.CCO_CODIGO ");
                sql.append("        FROM SII_DOCUMENTO_CONTABLE dco "); 
                sql.append("        INNER JOIN SII_IMPUTACION_CONTABLE imc ON imc.DCO_CODIGO = dco.DCO_CODIGO "); 
                sql.append("        INNER JOIN SII_CUENTAS_CONTABLES cco ON cco.cco_codigo = imc.cco_codigo "); 
                sql.append("        INNER JOIN SII_PERSONA p ON p.PER_CODIGO = imc.PER_CODIGO "); 
                sql.append("        WHERE TRUNC(dco.DCO_FECHA_OPER) BETWEEN #fechaIni  AND  #fechaFin ");
                sql.append("        AND dco.edo_codigo = #edoCodigo ");
                sql.append("        AND imc.IMC_ESTADO = #imcEstado ");
                
                if (filtros.getCodigosCuentaContable()!=null) {
                    int size = filtros.getCodigosCuentaContable().size();
                    if (size>0) {
                        sql.append("        AND cco.CCO_CODIGO IN (");
                        for (int i=0; i<size; i++) {
                            Long ccoCodigo = filtros.getCodigosCuentaContable().get(i);
                            if (ccoCodigo!=null) {
                                sql.append(ccoCodigo.toString());
                                if (i<size-1)
                                    sql.append(", ");
                            }
                        }
                        sql.append(") ");
                    }
                }
                
                sql.append("    ) ");
                
                
                
                Query query = manager.createNativeQuery(sql.toString());
                
                //DOCUMENTO CONTABLE APROBADO 
                query.setParameter("edoCodigo", EnumEstadoDocContab.APROBADO.getId());
                //IMPUTACION CONTABLE ACTIVA
                query.setParameter("imcEstado", EnumEstadoImputacionContable.ACTIVO.getId());
                
                query.setParameter("fechaIniSaldoInicial", fechaIniSaldoInicial);
                query.setParameter("fechaFinSaldoInicial", fechaFinSaldoInicial);
                
                query.setParameter("fechaIni", Utilidades.truncDate(filtros.getFechaInicial()));
                query.setParameter("fechaFin", Utilidades.truncDate(filtros.getFechaFinal()));
                
                
                List<BigDecimal> rows = query.getResultList();
                
                if (rows!=null && !rows.isEmpty()) {
                    
                    ccoCodigoList =  new ArrayList<Long>();
                    
                    for (BigDecimal row: rows) {
                        if (row!=null)
                            ccoCodigoList.add( row.longValueExact() );
                    }
                    
                }
            }
            
        }
        
        return (ccoCodigoList);
    }
    
    
    
    
    /**
     * Obtiene la sentencia SQL que consulta los registros del Balance de Prueba, de acuerdo a si estos pertenecen al Saldo Inicial o a los Movimientos del periodo.
     * @param filtros - Filtros aplicados al Balance de Prueba.
     * @param isRegistrosSaldoInicial - Flag que determina si los movimientos deben corresponder al periodo de Saldo Inicial o no.
     * @param soloMovimientosCierreVigenciaFechaFin - Flag que determina si s&oacute;lo se deben incluir los movimientos pertenecientes al Cierre de la vigencia de la Fecha Final asociada a los Filtros.
     * @return Cadena que representa una sentencia SQL.
     */
    private String obtenerQuery (FiltrosBalancePruebaVO filtros, boolean isRegistrosSaldoInicial, boolean soloMovimientosCierreVigenciaFechaFin)  
    {
        String alias = null;
        if (isRegistrosSaldoInicial)
            alias = "SI";
        else
            alias = "MP";
        
        
        StringBuffer sql = new StringBuffer();
        
        sql.append("    SELECT  "+alias+".CUENTA_CONTABLE, ");
        sql.append("            "+alias+".CCO_CODIGO, ");
        sql.append("            "+alias+".NOMBRE_CUENTA_CONTABLE, ");
        sql.append("            "+alias+".ID_ESTADO_DOC_CONTAB, "); 
        sql.append("            "+alias+".ESTADO_DOC_CONTAB, "); 
        sql.append("            "+alias+".CCO_NIVEL1, "); 
        sql.append("            "+alias+".CCO_NIVEL2, ");
        sql.append("            "+alias+".CCO_NIVEL3, ");
        sql.append("            "+alias+".CCO_NIVEL4, ");
        sql.append("            "+alias+".CCO_NIVEL5, ");
        
        if (isRegistrosSaldoInicial) {
            sql.append("            0 AS MOVIMIENTO_CREDITO, ");
            sql.append("            0 MOVIMIENTO_DEBITO, ");
            sql.append("            NVL(SUM("+alias+".MOVIM_DEBITO), 0) - NVL(SUM("+alias+".MOVIM_CREDITO), 0) AS SALDO_INICIAL ");
        }
        else {
            sql.append("            SUM("+alias+".MOVIM_CREDITO) AS MOVIMIENTO_CREDITO, ");
            sql.append("            SUM("+alias+".MOVIM_DEBITO) AS MOVIMIENTO_DEBITO, ");
            sql.append("            0 AS SALDO_INICIAL ");
        }
            
        
        if (filtros!=null) {
            if (filtros.isFiltrarPorFuenteFinanciacion()) {
                sql.append(",           "+alias+".FFC_CODIGO, "); 
                sql.append("            "+alias+".NOMBRE_FUENTE_FIN_CONTAB ");
            }
            
            if (filtros.isFiltrarPorCentroCostos()) {
                sql.append(",           "+alias+".ID_CENTRO_COSTOS, ");
                sql.append("            "+alias+".NOMBRE_CENTRO_COSTOS ");
            }
            
            if (filtros.isFiltrarPorTercero()) {
                sql.append(",           "+alias+".PER_CODIGO, "); 
                sql.append("            "+alias+".TIPO_IDENTIFICACION, "); 
                sql.append("            "+alias+".PER_NUM_IDENTIFICACION, "); 
                sql.append("            "+alias+".PER_DIGITO_VERIF, "); 
                sql.append("            "+alias+".RAZON_SOCIAL "); 
            }
        }
        
        sql.append("    FROM ( "); 
        sql.append("        SELECT  TO_CHAR(cc.CCO_NIVEL1) || ");
        sql.append("                    (case when cc.CCO_NIVEL2 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL2) end) || ");
        sql.append("                    (case when cc.CCO_NIVEL3 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL3) end) || ");
        sql.append("                    (case when cc.CCO_NIVEL4 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL4) end) || "); 
        sql.append("                    (case when cc.CCO_NIVEL5 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL5) end) AS CUENTA_CONTABLE,  ");
        sql.append("                cc.cco_codigo, ");
        sql.append("                cc.cco_descripcion AS NOMBRE_CUENTA_CONTABLE, "); 
        
        
        if (filtros!=null && filtros.isFiltrarPorTercero()) {
            sql.append("                per.per_codigo, ");
            sql.append("                (SELECT tid_nombre_corto FROM SII_TIPO_IDENTIFICACION WHERE tid_codigo = per.tid_codigo) AS TIPO_IDENTIFICACION, ");
            sql.append("                per.per_num_identificacion, ");
            sql.append("                per.PER_DIGITO_VERIF, "); 
            sql.append("                (CASE WHEN per.PER_JUR_NOMBRE_LARGO IS NOT NULL THEN per.PER_JUR_NOMBRE_LARGO  ELSE  (per.PER_PRIMER_NOMBRE || ");
            sql.append("                    (case when per.PER_SEGUNDO_NOMBRE is null then '' else ' ' || per.PER_SEGUNDO_NOMBRE end) || ");
            sql.append("                    (case when per.PER_PRIMER_APELLIDO is null then '' else ' ' || per.PER_PRIMER_APELLIDO end) || "); 
            sql.append("                    (case when per.PER_SEGUNDO_APELLIDO is null then '' else ' ' || per.PER_SEGUNDO_APELLIDO end)) ");
            sql.append("                  END) AS RAZON_SOCIAL, ");
        }
        
        
        sql.append("                dc.dco_codigo, ");
        sql.append("                dc.dco_numero_compr, ");
        sql.append("                dc.tdc_codigo, "); 
        sql.append("                (SELECT tdc_nombre FROM SII_TIPO_DOC_CONTABLE WHERE tdc_codigo = dc.tdc_codigo) AS NOMBRE_TIPO_DOC_CONTABLE, "); 
        sql.append("                dc.dco_fecha_oper, ");
        sql.append("                dc.dco_valor, "); 
        
        if (filtros!=null && filtros.isFiltrarPorFuenteFinanciacion()) {
            sql.append("                ic.ffc_codigo, "); 
            sql.append("                (SELECT fcc_nombre FROM SII_FUENTE_FINANC_CONTAB WHERE ffc_codigo = ic.ffc_codigo) AS NOMBRE_FUENTE_FIN_CONTAB, ");
        }
        
        if (filtros!=null && filtros.isFiltrarPorCentroCostos()) {
            sql.append("                ic.aco_codigo AS ID_CENTRO_COSTOS, "); 
            sql.append("                (SELECT ac.aco_nombre FROM SII_AREA_COLJUEGOS ac WHERE ac.aco_codigo = ic.aco_codigo) AS NOMBRE_CENTRO_COSTOS,  ");
        }
        
        sql.append("                dc.edo_codigo AS ID_ESTADO_DOC_CONTAB, "); 
        sql.append("                (SELECT edo_nombre FROM SII_ESTADO_DOC_CONTAB WHERE edo_codigo = dc.edo_codigo) AS ESTADO_DOC_CONTAB,  "); 
        sql.append("                cc.CCO_NIVEL1,  ");
        sql.append("                cc.CCO_NIVEL2,  "); 
        sql.append("                cc.CCO_NIVEL3,  ");
        sql.append("                cc.CCO_NIVEL4,  "); 
        sql.append("                cc.CCO_NIVEL5,  ");
        sql.append("                ic.IMC_TIPO_MOVIM, "); 
        sql.append("                decode(ic.IMC_TIPO_MOVIM, 'C','CRÉDITO', 'D','DÉBITO') AS NOMBRE_TIPO_MOVIM,  ");
        sql.append("                decode(ic.IMC_TIPO_MOVIM, 'C', ic.IMC_VALOR, 0) AS MOVIM_CREDITO,  ");
        sql.append("                decode(ic.IMC_TIPO_MOVIM, 'D', ic.IMC_VALOR, 0) AS MOVIM_DEBITO "); 
        sql.append("        FROM SII_DOCUMENTO_CONTABLE dc ");
        sql.append("        INNER JOIN SII_IMPUTACION_CONTABLE ic  ON  ic.dco_codigo = dc.dco_codigo  ");
        sql.append("        INNER JOIN SII_CUENTAS_CONTABLES cc  ON  cc.cco_codigo = ic.cco_codigo ");
        
        if (filtros!=null && filtros.isFiltrarPorTercero()) {
            sql.append("        LEFT JOIN SII_PERSONA per  ON  per.per_codigo = ic.per_codigo ");
            
            // FILTRAR POR TERCERO
            if (filtros.getCodigosTercero()!=null) {
                int size=filtros.getCodigosTercero().size();
                if (size>0) {
                    sql.append("        AND per.PER_CODIGO IN (");
                    for (int i=0; i<size; i++) {
                        Long perCodigo = filtros.getCodigosTercero().get(i);
                        if (perCodigo!=null) {
                            sql.append(perCodigo.toString());
                            if (i<size-1)
                                sql.append(", ");
                        }
                    }
                    sql.append(") ");
                }
            }
        }
        
        
        sql.append("        WHERE dc.edo_codigo = #edoCodigo ");
        sql.append("        AND ic.IMC_ESTADO = #imcEstado ");
        
        
        if (filtros!=null) {
            
            // FILTRAR POR FECHA
            if (isRegistrosSaldoInicial) {
                // DE FECHA INICIAL A FECHA FINAL DEL SALDO INICIAL
                sql.append("        AND TRUNC(dc.DCO_FECHA_OPER) BETWEEN  #fechaIniSaldoInicial  AND  #fechaFinSaldoInicial ");
            
            }
            else {
                if (filtros.getFechaInicial()!=null && filtros.getFechaFinal()!=null) {
                    // DE FECHA INICIAL A FECHA FINAL
                    sql.append("        AND TRUNC(dc.DCO_FECHA_OPER) BETWEEN  #fechaIni  AND  #fechaFin ");
                
                }
                else if (filtros.getFechaInicial()!=null) {
                    // DE FECHA INICIAL PARA ADELANTE
                    sql.append("        AND TRUNC(dc.DCO_FECHA_OPER) >=  #fechaIni ");
                }
                else if (filtros.getFechaFinal()!=null) {
                    // DE FECHA FINAL PARA ATRAS
                    sql.append("        AND TRUNC(dc.DCO_FECHA_OPER) <=  #fechaFin ");
                }
            }
        
        
            // FILTRAR POR FUENTE DE FINANCIACION CONTABLE
            if (filtros.getFfcCodigo()!=null) {
                sql.append("        AND ic.FFC_CODIGO = #ffcCodigo ");
            }
            
            
            // FILTRAR POR RANGO DE CUENTAS CONTABLES
            if (filtros.getNumCuentaContableInicial()!=null && filtros.getNumCuentaContableFinal()!=null) {
                sql.append("        AND cc.CCO_CODIGO IN (");
                sql.append("SELECT Y.CCO_CODIGO ");
                sql.append("FROM (  SELECT  cco.CCO_CODIGO,  "); 
                sql.append("                TO_CHAR(cco.CCO_NIVEL1) ||   "); 
                sql.append("                    (case when cco.CCO_NIVEL2 is null then '' else '.' || TO_CHAR(cco.CCO_NIVEL2) end) ||   "); 
                sql.append("                    (case when cco.CCO_NIVEL3 is null then '' else '.' || TO_CHAR(cco.CCO_NIVEL3) end) ||   "); 
                sql.append("                    (case when cco.CCO_NIVEL4 is null then '' else '.' || TO_CHAR(cco.CCO_NIVEL4) end) ||   "); 
                sql.append("                    (case when cco.CCO_NIVEL5 is null then '' else '.' || TO_CHAR(cco.CCO_NIVEL5) end) AS CUENTA_CONTABLE, "); 
                sql.append("                cco.CCO_DESCRIPCION "); 
                sql.append("        FROM SII_CUENTAS_CONTABLES cco "); 
                sql.append("        ORDER BY cco.CCO_CODIGO) Y "); 
                sql.append("WHERE Y.CUENTA_CONTABLE BETWEEN #cuentaInicial AND #cuentaFinal ");
                sql.append(") ");
            }
            
            /*
            if (filtros.getCodigosCuentaContable()!=null) {
                int size = filtros.getCodigosCuentaContable().size();
                if (size>0) {
                    sql.append("        AND cc.CCO_CODIGO IN (");
                    for (int i=0; i<size; i++) {
                        Long ccoCodigo = filtros.getCodigosCuentaContable().get(i);
                        if (ccoCodigo!=null) {
                            sql.append(ccoCodigo.toString());
                            if (i<size-1)
                                sql.append(", ");
                        }
                    }
                    sql.append(") ");
                }
            }
            */
            
            
            // FILTRAR POR CENTRO DE COSTOS
            if (filtros.getCodigosCentroCostos()!=null) {
                int size=filtros.getCodigosCentroCostos().size();
                if (size>0) {
                    sql.append("        AND ic.ACO_CODIGO IN (");
                    for (int i=0; i<size; i++) {
                        Long acoCodigo = filtros.getCodigosCentroCostos().get(i);
                        if (acoCodigo!=null) {
                            sql.append(acoCodigo.toString());
                            if (i<size-1)
                                sql.append(", ");
                        }
                    }
                    sql.append(") ");
                }
            }
            
            // FILTRAR POR REFERENCIA 1
            if (filtros.getReferencia1()!=null && !filtros.getReferencia1().isEmpty()) {
                sql.append("        AND ic.IMC_REFERENCIA1 = #imcReferencia1 ");
            }
            
            
            // NO INCLUIR LOS MOVIMIENTOS DEL PERIODO DE CIERRE ANUAL
            if (soloMovimientosCierreVigenciaFechaFin) {
                sql.append("        AND dc.CAC_CODIGO IS NOT NULL ");
            }
            
            sql.append(") "+alias+" ");
            
            sql.append("GROUP BY    "+alias+".CUENTA_CONTABLE,  "+alias+".CCO_CODIGO, "+alias+".NOMBRE_CUENTA_CONTABLE, ");
            
            if (filtros!=null && filtros.isFiltrarPorTercero()) {
                sql.append("                "+alias+".PER_CODIGO, "+alias+".TIPO_IDENTIFICACION, "+alias+".PER_NUM_IDENTIFICACION, "+alias+".PER_DIGITO_VERIF, "+alias+".RAZON_SOCIAL, ");
            }
            
            if (filtros!=null && filtros.isFiltrarPorFuenteFinanciacion()) {
                sql.append("                "+alias+".FFC_CODIGO, "+alias+".NOMBRE_FUENTE_FIN_CONTAB, ");
            }
            
            if (filtros!=null && filtros.isFiltrarPorCentroCostos()) {
                sql.append("                "+alias+".ID_CENTRO_COSTOS, "+alias+".NOMBRE_CENTRO_COSTOS, ");
            }
            
            sql.append("                "+alias+".ID_ESTADO_DOC_CONTAB, "+alias+".ESTADO_DOC_CONTAB, ");
            sql.append("                "+alias+".CCO_NIVEL1, "+alias+".CCO_NIVEL2, "+alias+".CCO_NIVEL3, "+alias+".CCO_NIVEL4, "+alias+".CCO_NIVEL5 ");
        }
        
        return (sql.toString());
    }
    
    
    
    /**
     * Genera el listado de Documentos Contables que conforman el <b>BALANCE DE PRUEBA</b>, basado en los filtros suministrados.
     * @param filtros - Filtros que se aplican a la consulta SQL.
     * @param generarCuentasAdicionales - Flag que determina si ser&aacute;n adicionadas las cuentas padre y cuentas de saldo inicial al resultado del Balance de Prueba.
     * @return List of BalancePruebaVO
     * @throws ExcepcionDAO
     */
    private List<BalancePruebaVO> generarRegistrosDocumentoContableParaBalance (FiltrosBalancePruebaVO filtros, boolean generarCuentasAdicionales) throws ExcepcionDAO {
        List<BalancePruebaVO> resultado = null;
        
        // balance sin registros duplicados
        Set<BalancePruebaVO> balance = new HashSet<BalancePruebaVO>();
        
        if (mapaCuentasContables==null) this.mapaCuentasContables = new HashMap<String, SiiCuentasContables>();
        
        
        boolean valido = true;
        Date fechaIniSaldoInicial = null;
        Date fechaFinSaldoInicial = null;
        
        
        if (filtros!=null && filtros.getFechaInicial()!=null) {
            Map<String, Date> mapaFechasSaldoInicial = this.obtenerFechasSaldoInicial(filtros);
            if (mapaFechasSaldoInicial!=null) {
                fechaIniSaldoInicial = mapaFechasSaldoInicial.get(FECHA_INICIAL_KEY);
                fechaFinSaldoInicial = mapaFechasSaldoInicial.get(FECHA_FINAL_KEY);
            }
        }
        
        
        if (filtros!=null && fechaIniSaldoInicial!=null && fechaFinSaldoInicial!=null && filtros.getFechaInicial()!=null) {
            if (fechaFinSaldoInicial.before(fechaIniSaldoInicial) || filtros.getFechaInicial().before(fechaFinSaldoInicial)) {
                // no se obtendran los registros de saldo inicial, ya que las fechas no son consistentes
                valido = false;
            }
        }
        else {
            // no se obtendran los registros de saldo inicial, ya que no se han configurado filtros adecuadamente
            valido = false;
        }
        
        
        if (valido) {
            
            try {
                StringBuilder sql = new StringBuilder();
                
                sql.append("SELECT  NVL(Z.CUENTA_CONTABLE, ( TO_CHAR(Z.CCO_NIVEL1) ");
                sql.append("                              || ( ");
                sql.append("                              CASE "); 
                sql.append("                                WHEN Z.CCO_NIVEL2 IS NULL ");
                sql.append("                                THEN '' ");
                sql.append("                                ELSE '.' "); 
                sql.append("                                  || TO_CHAR(Z.CCO_NIVEL2) ");
                sql.append("                              END) ");
                sql.append("                              || ( "); 
                sql.append("                              CASE ");
                sql.append("                                WHEN Z.CCO_NIVEL3 IS NULL ");
                sql.append("                                THEN '' ");
                sql.append("                                ELSE '.' "); 
                sql.append("                                  || TO_CHAR(Z.CCO_NIVEL3) ");
                sql.append("                              END) ");
                sql.append("                              || ( ");
                sql.append("                              CASE ");
                sql.append("                                WHEN Z.CCO_NIVEL4 IS NULL "); 
                sql.append("                                THEN '' "); 
                sql.append("                                ELSE '.' "); 
                sql.append("                                  || TO_CHAR(Z.CCO_NIVEL4) "); 
                sql.append("                              END) ");
                sql.append("                              || ( ");
                sql.append("                              CASE ");
                sql.append("                                WHEN Z.CCO_NIVEL5 IS NULL ");
                sql.append("                                THEN '' ");
                sql.append("                                ELSE '.' "); 
                sql.append("                                  || TO_CHAR(Z.CCO_NIVEL5) ");
                sql.append("                              END) )) AS CUENTA_CONTABLE, "); 
                sql.append("        Z.CCO_CODIGO, ");
                sql.append("        Z.NOMBRE_CUENTA_CONTABLE, ");
                sql.append("        Z.ID_ESTADO_DOC_CONTAB, "); 
                sql.append("        Z.ESTADO_DOC_CONTAB, "); 
                sql.append("        Z.CCO_NIVEL1, "); 
                sql.append("        Z.CCO_NIVEL2, ");
                sql.append("        Z.CCO_NIVEL3, ");
                sql.append("        Z.CCO_NIVEL4, ");
                sql.append("        Z.CCO_NIVEL5, ");
                sql.append("        SUM(Z.MOVIMIENTO_CREDITO) AS MOVIMIENTO_CREDITO, ");
                sql.append("        SUM(Z.MOVIMIENTO_DEBITO) AS MOVIMIENTO_DEBITO, ");
                
                if (filtros!=null) {
                    if (filtros.isFiltrarPorFuenteFinanciacion()) {
                        sql.append("        Z.FFC_CODIGO, "); 
                        sql.append("        Z.NOMBRE_FUENTE_FIN_CONTAB, ");
                    }
                    
                    if (filtros.isFiltrarPorCentroCostos()) {
                        sql.append("        Z.ID_CENTRO_COSTOS, ");
                        sql.append("        Z.NOMBRE_CENTRO_COSTOS, ");
                    }
                    
                    if (filtros.isFiltrarPorTercero()) {
                        sql.append("        Z.PER_CODIGO, "); 
                        sql.append("        Z.TIPO_IDENTIFICACION, "); 
                        sql.append("        Z.PER_NUM_IDENTIFICACION, "); 
                        sql.append("        Z.PER_DIGITO_VERIF, "); 
                        sql.append("        Z.RAZON_SOCIAL, "); 
                    }
                }
                
                sql.append("        SUM(Z.SALDO_INICIAL) AS SALDO_INICIAL ");
                
                
                sql.append("FROM ( ");
                
                
                // Obtener los queries de acuerdo a las fechas del saldo inicial o a las fechas del movimiento del periodo, 
                // para realizar la union y la agrupacion, y obtener un resultado final.
                String querySaldoInicial = this.obtenerQuery(filtros, true, false);
                String queryMovimientosPeriodo = this.obtenerQuery(filtros, false, false);
                String queryExclusionMovPeriodoCierre = null;
                // EN CASO TAL QUE NO SE DESEE INCLUIR LOS MOVIMIENTOS DEL PERIODO DE CIERRE ANUAL
                if (!filtros.isIncluyeMovPeriodoCierre()) {
                    FiltrosBalancePruebaVO filtrosCierreAnual = filtros.clone();
                    
                    // Establecer la misma fecha final como fecha inicial
                    filtrosCierreAnual.setFechaInicial(filtrosCierreAnual.getFechaFinal());
                    queryExclusionMovPeriodoCierre = this.obtenerQuery(filtrosCierreAnual, false, true);
                }
                
                
                
                // QUERY DEL SALDO INICIAL
                sql.append("        ( ");
                sql.append(querySaldoInicial);
                sql.append("        ) ");
                // UNIDO CON 
                sql.append("        UNION ");
                // QUERY DE LOS MOVIMIENTOS DEL PERIODO
                sql.append("        ( ");
                sql.append(queryMovimientosPeriodo);
                sql.append("        ) ");
                
                if (!filtros.isIncluyeMovPeriodoCierre()) {
                    // EXCLUYENDO A 
                    sql.append("        MINUS ");
                    // QUERY DE LOS MOVIMIENTOS DEL PERIODO DE CIERRE ANUAL
                    sql.append("        ( ");
                    sql.append(queryExclusionMovPeriodoCierre);
                    sql.append("        ) ");
                }
                
                sql.append(") Z   ");
                
                
                sql.append("GROUP BY    ");
                
                if (generarCuentasAdicionales) {
                    sql.append("ROLLUP     (");
                }
                
                sql.append("            Z.CCO_NIVEL1, Z.CCO_NIVEL2, Z.CCO_NIVEL3, Z.CCO_NIVEL4, Z.CCO_NIVEL5, ");
                sql.append("            Z.CUENTA_CONTABLE,  Z.CCO_CODIGO, Z.NOMBRE_CUENTA_CONTABLE, ");
                
                if (filtros!=null && filtros.isFiltrarPorTercero()) {
                    sql.append("            Z.PER_CODIGO, Z.TIPO_IDENTIFICACION, Z.PER_NUM_IDENTIFICACION, Z.PER_DIGITO_VERIF, Z.RAZON_SOCIAL, ");
                }
                
                if (filtros!=null && filtros.isFiltrarPorFuenteFinanciacion()) {
                    sql.append("            Z.FFC_CODIGO, Z.NOMBRE_FUENTE_FIN_CONTAB, ");
                }
                
                if (filtros!=null && filtros.isFiltrarPorCentroCostos()) {
                    sql.append("            Z.ID_CENTRO_COSTOS, Z.NOMBRE_CENTRO_COSTOS, ");
                }
                
                sql.append("            Z.ID_ESTADO_DOC_CONTAB, Z.ESTADO_DOC_CONTAB ");
                
                if (generarCuentasAdicionales) {
                    sql.append(") ");
                    sql.append("HAVING  GROUPING_ID(Z.CCO_NIVEL1, Z.CCO_NIVEL2, Z.CCO_NIVEL3, Z.CCO_NIVEL4, Z.CCO_NIVEL5)<=(POWER(2,4)-1)  AND  ");
                    sql.append("       ( ( GROUPING(Z.CCO_NIVEL1) + GROUPING(Z.CCO_NIVEL2) + GROUPING(Z.CCO_NIVEL3) + GROUPING(Z.CCO_NIVEL4) + GROUPING(Z.CCO_NIVEL5) >0 )  OR  ");
                    sql.append("         ( GROUPING(Z.CUENTA_CONTABLE) + GROUPING(Z.CCO_CODIGO) + GROUPING(Z.NOMBRE_CUENTA_CONTABLE) ");
                    
                    if (filtros!=null) {
                        if (filtros.isFiltrarPorTercero())
                            sql.append("           + GROUPING(Z.PER_CODIGO) + GROUPING(Z.TIPO_IDENTIFICACION) + GROUPING(Z.PER_NUM_IDENTIFICACION) + GROUPING(Z.PER_DIGITO_VERIF) + GROUPING(Z.RAZON_SOCIAL) ");
                        if (filtros.isFiltrarPorFuenteFinanciacion())
                            sql.append("           + GROUPING(Z.FFC_CODIGO) + GROUPING(Z.NOMBRE_FUENTE_FIN_CONTAB) ");
                        if (filtros.isFiltrarPorCentroCostos())
                            sql.append("           + GROUPING(Z.ID_CENTRO_COSTOS) + GROUPING(Z.NOMBRE_CENTRO_COSTOS) ");
                    }
                    sql.append("           + GROUPING(Z.ID_ESTADO_DOC_CONTAB) + GROUPING(Z.ESTADO_DOC_CONTAB)  = 0 ) ) ");
                }
                
                
                sql.append("ORDER BY Z.CCO_NIVEL1, Z.CCO_NIVEL2, Z.CCO_NIVEL3, Z.CCO_NIVEL4, Z.CCO_NIVEL5 ");
                
                
                Query query = manager.createNativeQuery(sql.toString());
                //DOCUMENTO CONTABLE APROBADO 
                query.setParameter("edoCodigo", EnumEstadoDocContab.APROBADO.getId());
                //IMPUTACION CONTABLE ACTIVA
                query.setParameter("imcEstado", EnumEstadoImputacionContable.ACTIVO.getId());
                
                
                
                // PARAMETROS DE FILTROS
                if (filtros!=null) {
                    if (filtros.getFechaInicial()!=null || filtros.getFechaFinal()!=null) {
                        
                        // PARA CONSULTA DE SALDO INICIAL
                        query.setParameter("fechaIniSaldoInicial", fechaIniSaldoInicial);
                        query.setParameter("fechaFinSaldoInicial", fechaFinSaldoInicial);
                        
                        if (filtros.getFechaInicial()!=null)
                            query.setParameter("fechaIni", Utilidades.truncDate(filtros.getFechaInicial()));
                            
                        if (filtros.getFechaFinal()!=null)
                            query.setParameter("fechaFin", Utilidades.truncDate(filtros.getFechaFinal()));
                        
                    }
                    
                    if (filtros.getFfcCodigo()!=null) {
                        query.setParameter("ffcCodigo", filtros.getFfcCodigo());
                    }
                    
                    if (filtros.getReferencia1()!=null && !filtros.getReferencia1().isEmpty()) {
                        query.setParameter("imcReferencia1", filtros.getReferencia1());
                    }
                    
                    if (filtros.getNumCuentaContableInicial()!=null && filtros.getNumCuentaContableFinal()!=null) {
                        query.setParameter("cuentaInicial", filtros.getNumCuentaContableInicial());
                        query.setParameter("cuentaFinal", filtros.getNumCuentaContableFinal());
                    }
                }
                
                
                List<Object[]> rows = query.getResultList();
                
                if (rows!=null) {
                    
                    resultado =  new ArrayList<BalancePruebaVO>();
                    
                    for (Object[] row: rows) {
                        // construir el value object
                        BalancePruebaVO bpVO = new BalancePruebaVO();
                        if (row[0]!=null)
                            bpVO.setCuentaContable((String) row[0]);
                        if (row[1]!=null)
                            bpVO.setCcoCodigo(((BigDecimal) row[1]).longValue());
                        if (row[2]!=null)
                            bpVO.setNombreCuentaContable((String) row[2]);
                        if (row[3]!=null)
                            bpVO.setIdEstadoDocContab(((BigDecimal) row[3]).longValue());
                        if (row[4]!=null)
                            bpVO.setEstadoDocContab((String) row[4]);
                        if (row[5]!=null)
                            bpVO.setCcoNivel1((String) row[5]);
                        if (row[6]!=null)
                            bpVO.setCcoNivel2((String) row[6]);
                        if (row[7]!=null)
                            bpVO.setCcoNivel3((String) row[7]);
                        if (row[8]!=null)
                            bpVO.setCcoNivel4((String) row[8]);
                        if (row[9]!=null)
                            bpVO.setCcoNivel5((String) row[9]);
                        
                        if (row[10]!=null) {
                            bpVO.setMovimientoCredito((BigDecimal) row[10]);
                        }
                        
                        if (row[11]!=null) {
                            bpVO.setMovimientoDebito((BigDecimal) row[11]);
                        }
                        
                        
                        // incrementar la posicion de acuerdo a los filtros seleccionados
                        int posicion = 11;
                        
                        if (filtros!=null) {
                            
                            // Solamente se visualizaran al momento de Filtrar por FUENTE DE FINANCIACION.
                            if (filtros.isFiltrarPorFuenteFinanciacion()) {
                                if (row[++posicion]!=null)
                                    bpVO.setFfcCodigo((String) row[posicion]);
                                if (row[++posicion]!=null)
                                    bpVO.setNombreFuenteFinContab((String) row[posicion]);
                            }
                            
                            
                            // Solamente se visualizaran al momento de Filtrar por CENTRO DE COSTOS.
                            if (filtros.isFiltrarPorCentroCostos()) {
                                if (row[++posicion]!=null)
                                    bpVO.setIdCentroCostos(((BigDecimal) row[posicion]).longValue());
                                if (row[++posicion]!=null)
                                    bpVO.setNombreCentroCostos((String) row[posicion]);
                            }
                            
                            // Solamente se visualizaran al momento de Filtrar por TERCERO.
                            if (filtros.isFiltrarPorTercero()) {
                                if (row[++posicion]!=null)
                                    bpVO.setPerCodigo(((BigDecimal) row[posicion]).longValue());
                                if (row[++posicion]!=null)
                                    bpVO.setTipoIdentificacion((String) row[posicion]);
                                if (row[++posicion]!=null)
                                    bpVO.setPerNumIdentificacion((String) row[posicion]);
                                if (row[++posicion]!=null)
                                    bpVO.setPerDigitoVerif(((BigDecimal) row[posicion]).intValue());
                                if (row[++posicion]!=null)
                                    bpVO.setRazonSocial((String) row[posicion]);
                            }
                        }
                        
                        
                        
                        // establece el SALDO INICIAL del registro de Balance de Prueba
                        if (row[++posicion]!=null)
                            bpVO.setSaldoAnterior((BigDecimal) row[posicion]);
    
                        
                        
                        if (generarCuentasAdicionales) {
                            // VERIFICAR SI EL REGISTRO PERTENECE AL RESUMEN DE ACUMULADO DE SALDOS EN CUENTAS PADRES, PARA ESTABLECER LAS COLUMNAS POR DEFECTO
                            if (bpVO.getCuentaContable()!=null) {
                                if (bpVO.getCcoCodigo()==null) {
                                    
                                    SiiCuentasContables siiCuentaContable = this.mapaCuentasContables.get(bpVO.getCuentaContable());
                                    if (siiCuentaContable==null) {
                                        siiCuentaContable = cuentasContablesDao.buscarPorCadenaNiveles(bpVO.getCuentaContable());
                                        
                                        if (siiCuentaContable!=null) 
                                            this.mapaCuentasContables.put(bpVO.getCuentaContable(), siiCuentaContable);
                                    }
                                    
                                    if (siiCuentaContable!=null) {
                                        bpVO.setCcoCodigo(siiCuentaContable.getCcoCodigo());
                                        bpVO.setNombreCuentaContable(siiCuentaContable.getCcoDescripcion());
                                    }
                                        
                                    
                                    if (filtros.isFiltrarPorFuenteFinanciacion() && filtros.getFfcCodigo()!=null && bpVO.getFfcCodigo()==null) {
                                        bpVO.setFfcCodigo(filtros.getFfcCodigo());
                                    }
                                }
                            }
                        }
                        
                        
                        // adicionar balance de prueba hijo a la lista
                        balance.add(bpVO);
                    }
                    
                    // adicionar todos los registros sin duplicados
                    resultado.addAll(balance);
                    
                }
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
                
        }
        
        
        return (resultado);
    }
    
    
    
    /**
     * Genera el listado que conforma el <b>BALANCE DE PRUEBA</b>.
     * @param filtros - Filtros que se aplican en la generaci&oacute;n del Balance de Prueba.
     * @return List of BalancePruebaVO
     * @throws ExcepcionDAO
     */
    public List<BalancePruebaVO> generarBalancePrueba (FiltrosBalancePruebaVO filtros) throws ExcepcionDAO {
        return ( this.generarBalancePrueba(filtros, true) );
    }
    
    
    
    /**
     * Genera el listado que conforma el <b>BALANCE DE PRUEBA</b>.
     * @param filtros - Filtros que se aplican en la generaci&oacute;n del Balance de Prueba.
     * @param generarCuentasAdicionales - Flag que determina si ser&aacute;n adicionadas las cuentas padre y cuentas de saldo inicial al resultado del Balance de Prueba.
     * @return List of BalancePruebaVO
     * @throws ExcepcionDAO
     */
    public List<BalancePruebaVO> generarBalancePrueba (FiltrosBalancePruebaVO filtros, boolean generarCuentasAdicionales) throws ExcepcionDAO {
        List<BalancePruebaVO> resultado = null;
        
        // balance sin registros duplicados
        Set<BalancePruebaVO> balance = new HashSet<BalancePruebaVO>();
        
        // registros que conforman los movimientos contables basados en los filtros suministrados
        List<BalancePruebaVO> registrosMovimientoContable = this.generarRegistrosDocumentoContableParaBalance(filtros, generarCuentasAdicionales);
        
        if (registrosMovimientoContable!=null) {
            // ADICIONAR LOS REGISTROS OBTENIDOS DEL MOVIMIENTO CONTABLE ASOCIADO AL RANGO DE FECHAS EN EL FILTRO
            for (BalancePruebaVO bpVO: registrosMovimientoContable) {
                balance.add(bpVO);
            }
        }
        
        
        if (balance!=null && !balance.isEmpty()) {
            // adicionar todos los registros sin duplicados
            resultado = new ArrayList<BalancePruebaVO>();
            resultado.addAll(balance);
        }
        
        
        return (resultado);
    }
    
    
    
    /**
     * Establece el <b>SALDO INICIAL</b> del registro de Balance de Prueba, de acuerdo a los filtros establecidos.
     * @param balancePruebaVo
     * @param filtros
     * @throws ExcepcionDAO
     */
    public void establecerSaldoInicial (BalancePruebaVO balancePruebaVo, FiltrosBalancePruebaVO filtros) throws ExcepcionDAO {
        if (balancePruebaVo!=null) {
            BigDecimal saldoAnterior = new BigDecimal(0);
            
            if (filtros!=null && filtros.getFechaInicial()!=null) {
                
                Date fechaIni = null;
                Date fechaFin = null;
                
                Map<String, Date> mapaFechasSaldoInicial = this.obtenerFechasSaldoInicial(filtros);
                if (mapaFechasSaldoInicial!=null) {
                    fechaIni = mapaFechasSaldoInicial.get(FECHA_INICIAL_KEY);
                    fechaFin = mapaFechasSaldoInicial.get(FECHA_FINAL_KEY);
                }
                
                
                if (fechaFin.compareTo(fechaIni) >= 0 && filtros.getFechaInicial().after(fechaFin)) {
                
                    StringBuffer sql = new StringBuffer();
                    sql.append("SELECT ( NVL(SUM(Y.MOVIM_DEBITO), 0) - NVL(SUM(Y.MOVIM_CREDITO), 0) ) AS SALDO_ANTERIOR ");
                    sql.append("FROM ( ");
                    sql.append("    SELECT  dco.DCO_CODIGO, "); 
                    sql.append("            dco.DCO_NUMERO_COMPR, ");
                    sql.append("            dco.TDC_CODIGO, "); 
                    sql.append("            dco.DCO_FECHA_OPER, ");
                    sql.append("            cco.CCO_CODIGO, ");
                    sql.append("            imc.FFC_CODIGO, ");
                    sql.append("            imc.IMC_TIPO_MOVIM, "); 
                    sql.append("            decode(imc.IMC_TIPO_MOVIM, 'C','CRÉDITO', 'D','DÉBITO') AS NOMBRE_TIPO_MOVIM, ");
                    sql.append("            decode(imc.IMC_TIPO_MOVIM, 'C', imc.IMC_VALOR, 0) AS MOVIM_CREDITO, ");
                    sql.append("            decode(imc.IMC_TIPO_MOVIM, 'D', imc.IMC_VALOR, 0) AS MOVIM_DEBITO, ");
                    sql.append("            imc.IMC_DESCR_OPERACION, ");
                    sql.append("            imc.ACO_CODIGO, "); 
                    sql.append("            imc.PER_CODIGO ");
                    sql.append("    FROM SII_DOCUMENTO_CONTABLE dco ");
                    sql.append("    INNER JOIN SII_IMPUTACION_CONTABLE imc  ON  imc.DCO_CODIGO = dco.DCO_CODIGO ");
                    sql.append("    INNER JOIN SII_CUENTAS_CONTABLES cco  ON  cco.cco_codigo = imc.cco_codigo ");
                    sql.append("    WHERE 1=1 ");
                    
                    if (filtros.getFechaInicial()!=null) {
                        sql.append("    AND TRUNC(dco.DCO_FECHA_OPER)  BETWEEN  #fechaIni  AND  #fechaFin ");
                    }
                    
                    //sql.append("    AND dco.TDC_CODIGO = 'SFI' ");
                    
                    // NO INCLUIR LOS MOVIMIENTOS DEL PERIODO DE CIERRE ANUAL
                    if (!filtros.isIncluyeMovPeriodoCierre()) {
                        sql.append("    AND dco.CAC_CODIGO IS NULL ");
                    }
                    
                    
                    if (balancePruebaVo.getCcoCodigo()!=null) {
                        sql.append("    AND cco.CCO_CODIGO = #ccoCodigo ");
                    }
                    
                    if (balancePruebaVo.getPerCodigo()!=null) {
                        sql.append("    AND imc.PER_CODIGO = #perCodigo ");
                    }
                    
                    if (balancePruebaVo.getIdCentroCostos()!=null) {
                        sql.append("    AND imc.ACO_CODIGO = #acoCodigo ");
                    }
                    
                    if (balancePruebaVo.getFfcCodigo()!=null) {
                        sql.append("    AND imc.FFC_CODIGO = #ffcCodigo ");
                    }
                    
                    
                    sql.append("    AND dco.EDO_CODIGO = #edoCodigo ");
                    sql.append("    AND imc.IMC_ESTADO = #imcEstado ");
                    sql.append(") Y");
                    
                    
                    
                    Query query = manager.createNativeQuery(sql.toString());
                    
                    
                    // PARAMETROS
                    //DOCUMENTO CONTABLE APROBADO 
                    query.setParameter("edoCodigo", EnumEstadoDocContab.APROBADO.getId());
                    //IMPUTACION CONTABLE ACTIVA
                    query.setParameter("imcEstado", EnumEstadoImputacionContable.ACTIVO.getId());
                    
                    
                    if (filtros.getFechaInicial()!=null) {
                        // Establecer la fecha desde el inicio de anno (inclusive) hasta la fecha de la operacion (exclusive)
                        query.setParameter("fechaIni", fechaIni);
                        query.setParameter("fechaFin", fechaFin);
                    }
                    
                    
                    if (balancePruebaVo.getCcoCodigo()!=null) {
                        query.setParameter("ccoCodigo", balancePruebaVo.getCcoCodigo());
                    }
                    
                    if (balancePruebaVo.getPerCodigo()!=null) {
                        query.setParameter("perCodigo", balancePruebaVo.getPerCodigo());
                    }
                    
                    if (balancePruebaVo.getIdCentroCostos()!=null) {
                        query.setParameter("acoCodigo", balancePruebaVo.getIdCentroCostos());
                    }
                    
                    if (balancePruebaVo.getFfcCodigo()!=null) {
                        query.setParameter("ffcCodigo", balancePruebaVo.getFfcCodigo());
                    }
                    
                    
                    saldoAnterior = (BigDecimal) query.getSingleResult();
                    
                }
            }
            
            balancePruebaVo.setSaldoAnterior(saldoAnterior);
        }
    }
    
}
