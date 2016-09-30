/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 17-03-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoImputacionContable;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.FiltrosLibroAuxiliarVO;
import co.gov.coljuegos.siicol.ejb.vo.LibroAuxiliarVO;

import java.math.BigDecimal;

import java.util.ArrayList;
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
public class LibroAuxiliarDAO 
{
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    /**
     * Constructor.
     */
    public LibroAuxiliarDAO() {
        this.recursos = new Recursos();
    }
    
    
    
    /**
     * Genera el listado de Value Objects que conformar el <b>LIBRO AUXILIAR</b>.
     * @param idDocumentoContable - C&oacute;digo del Comprobante (Documento Contable).
     * @return List of LibroAuxiliarVO.
     */
    public List<LibroAuxiliarVO> generarLibroAuxiliarPorComprobante (Long idDocumentoContable) 
        throws ExcepcionDAO
    {
        FiltrosLibroAuxiliarVO filtros = new FiltrosLibroAuxiliarVO();
        filtros.setDcoCodigo(idDocumentoContable);
        return ( this.generarLibroAuxiliarPorFiltros(filtros, false) );
    }
    
    
    
    /**
     * Genera el listado de Value Objects que conformar el <b>LIBRO AUXILIAR</b>.
     * @param filtros - Filtros que ser&aacute;n aplicados para generar el Libro Auxuliar.
     * @return List of LibroAuxiliarVO.
     */
    public List<LibroAuxiliarVO> generarLibroAuxiliarPorFiltros (FiltrosLibroAuxiliarVO filtros) 
        throws ExcepcionDAO
    {
        return ( this.generarLibroAuxiliarPorFiltros(filtros, true) );
    }
    
    
    /**
     * Genera el listado de Value Objects que conformar el <b>LIBRO AUXILIAR</b>.
     * @param filtros - Filtros que ser&aacute;n aplicados para generar el Libro Auxuliar.
     * @param ocultarCampos - Flag que determina si algunos campos se encontrar&aacute;n ocultos de acuerdo a los filtros no aplicados.
     * @return List of LibroAuxiliarVO.
     */
    public List<LibroAuxiliarVO> generarLibroAuxiliarPorFiltros (FiltrosLibroAuxiliarVO filtros, boolean ocultarCampos) 
        throws ExcepcionDAO
    {
        List<LibroAuxiliarVO> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  TO_CHAR(cc.CCO_NIVEL1) || "); 
            sql.append("            (case when cc.CCO_NIVEL2 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL2) end) || "); 
            sql.append("            (case when cc.CCO_NIVEL3 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL3) end) || "); 
            sql.append("            (case when cc.CCO_NIVEL4 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL4) end) || "); 
            sql.append("            (case when cc.CCO_NIVEL5 is null then '' else '.' || TO_CHAR(cc.CCO_NIVEL5) end) AS CUENTA_CONTABLE,  "); 
            sql.append("        cc.cco_codigo, "); 
            sql.append("        cc.cco_descripcion AS NOMBRE_CUENTA_CONTABLE,  "); 
            sql.append("        per.per_codigo, "); 
            sql.append("        (SELECT tid_nombre_corto FROM SII_TIPO_IDENTIFICACION WHERE tid_codigo = per.tid_codigo) AS TIPO_IDENTIFICACION, "); 
            sql.append("        per.per_num_identificacion,  "); 
            sql.append("        per.PER_DIGITO_VERIF,  "); 
            sql.append("        (CASE WHEN per.PER_JUR_NOMBRE_LARGO IS NOT NULL THEN per.PER_JUR_NOMBRE_LARGO  ELSE  (per.PER_PRIMER_NOMBRE || "); 
            sql.append("            (case when per.PER_SEGUNDO_NOMBRE is null then '' else ' ' || per.PER_SEGUNDO_NOMBRE end) || "); 
            sql.append("            (case when per.PER_PRIMER_APELLIDO is null then '' else ' ' || per.PER_PRIMER_APELLIDO end) || "); 
            sql.append("            (case when per.PER_SEGUNDO_APELLIDO is null then '' else ' ' || per.PER_SEGUNDO_APELLIDO end))  "); 
            sql.append("          END) AS RAZON_SOCIAL,  "); 
            sql.append("        dc.dco_codigo,  "); 
            sql.append("        dc.dco_numero_compr,  "); 
            sql.append("        dc.tdc_codigo, "); 
            sql.append("        (SELECT tdc_nombre FROM SII_TIPO_DOC_CONTABLE WHERE tdc_codigo = dc.tdc_codigo) AS NOMBRE_TIPO_DOC_CONTABLE, "); 
            sql.append("        dc.dco_fecha_oper, "); 
            sql.append("        ic.ffc_codigo, "); 
            sql.append("        (SELECT fcc_nombre FROM SII_FUENTE_FINANC_CONTAB WHERE ffc_codigo = ic.ffc_codigo) AS NOMBRE_FUENTE_FIN_CONTAB, "); 
            sql.append("        (SELECT ac.aco_codigo FROM SII_AREA_COLJUEGOS ac WHERE ac.aco_codigo = ic.aco_codigo) AS ID_CENTRO_COSTOS,  "); 
            sql.append("        (SELECT ac.aco_nombre FROM SII_AREA_COLJUEGOS ac WHERE ac.aco_codigo = ic.aco_codigo) AS NOMBRE_CENTRO_COSTOS,   "); 
            sql.append("        dc.edo_codigo AS ID_ESTADO_DOC_CONTAB, "); 
            sql.append("        (SELECT edo_nombre FROM SII_ESTADO_DOC_CONTAB WHERE edo_codigo = dc.edo_codigo) AS ESTADO_DOC_CONTAB,  "); 
            sql.append("        cc.CCO_NIVEL1,  "); 
            sql.append("        cc.CCO_NIVEL2,  "); 
            sql.append("        cc.CCO_NIVEL3,  "); 
            sql.append("        cc.CCO_NIVEL4,  "); 
            sql.append("        cc.CCO_NIVEL5,  "); 
            sql.append("        ic.IMC_TIPO_MOVIM, "); 
            sql.append("        decode(ic.IMC_TIPO_MOVIM, 'C','CRÉDITO', 'D','DÉBITO') AS NOMBRE_TIPO_MOVIM,  "); 
            sql.append("        decode(ic.IMC_TIPO_MOVIM, 'C', ic.IMC_VALOR, 0) AS MOVIM_CREDITO,  "); 
            sql.append("        decode(ic.IMC_TIPO_MOVIM, 'D', ic.IMC_VALOR, 0) AS MOVIM_DEBITO, ");
            sql.append("        ic.imc_referencia1 AS REFERENCIA1,  "); 
            sql.append("        ic.imc_referencia2 AS REFERENCIA2,  ");
            sql.append("        ic.imc_descr_operacion AS DESCRIPCION_OPERACION  ");
            sql.append("FROM SII_DOCUMENTO_CONTABLE dc "); 
            sql.append("INNER JOIN SII_IMPUTACION_CONTABLE ic  ON  ic.dco_codigo = dc.dco_codigo  "); 
            sql.append("INNER JOIN SII_CUENTAS_CONTABLES cc  ON  cc.cco_codigo = ic.cco_codigo "); 
            sql.append("LEFT JOIN SII_PERSONA per  ON  per.per_codigo = ic.per_codigo  "); 
            sql.append("WHERE ic.IMC_VALOR > 0 ");
            sql.append("AND dc.edo_codigo = #edoCodigo "); 
            sql.append("AND ic.IMC_ESTADO = #imcEstado "); 
            
            
            
            if (filtros!=null) {
                // FILTRAR POR COMPROBANTE CONTABLE
                if (filtros.getDcoCodigo()!=null) {
                    sql.append("AND dc.DCO_CODIGO = #dcoCodigo ");
                }
                
                // FILTRAR POR FECHA
                if (filtros.getFechaInicial()!=null && filtros.getFechaFinal()!=null) {
                    sql.append(" AND TRUNC(dc.DCO_FECHA_OPER) BETWEEN #fechaIni  AND #fechaFin ");
                }
                // FILTRAR POR FUENTE DE FINANCIACION CONTABLE
                if (filtros.getFfcCodigo()!=null) {
                    sql.append(" AND ic.FFC_CODIGO = #ffcCodigo ");
                }
                // FILTRAR POR TERCERO
                if (filtros.getCodigosTercero()!=null) {
                    int size=filtros.getCodigosTercero().size();
                    if (size>0) {
                        sql.append(" AND per.PER_CODIGO IN (");
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
                
                
                // FILTRAR POR RANGO DE CUENTAS CONTABLES
                if (filtros.getNumCuentaContableInicial()!=null && filtros.getNumCuentaContableFinal()!=null) {
                    sql.append(" AND cc.CCO_CODIGO IN (");
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
                // FILTRAR POR RANGO DE CUENTAS CONTABLES
                if (filtros.getCodigosCuentaContable()!=null) {
                    int size = filtros.getCodigosCuentaContable().size();
                    if (size>0) {
                        sql.append(" AND cc.CCO_CODIGO IN (");
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
                        sql.append(" AND ic.ACO_CODIGO IN (");
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
                if (filtros.getReferencia1()!=null) {
                    sql.append("AND ic.IMC_REFERENCIA1 = #imcReferencia1 ");
                }
                // FILTRAR POR REFERENCIA 2
                if (filtros.getReferencia2()!=null) {
                    sql.append("AND ic.IMC_REFERENCIA2 = #imcReferencia2 ");
                }
                
                // NO INCLUIR LOS MOVIMIENTOS DEL PERIODO DE CIERRE ANUAL
                if (!filtros.isIncluyeMovPeriodoCierre()) {
                    sql.append("    AND dc.CAC_CODIGO IS NULL ");
                }
            }
            
            sql.append("ORDER BY cc.CCO_NIVEL1,cc.CCO_NIVEL2,cc.CCO_NIVEL3,cc.CCO_NIVEL4,cc.CCO_NIVEL5 ");
            
            
            
            Query query = manager.createNativeQuery(sql.toString());
            
            //DOCUMENTO CONTABLE APROBADO 
            query.setParameter("edoCodigo", EnumEstadoDocContab.APROBADO.getId());
            //IMPUTACION CONTABLE ACTIVA
            query.setParameter("imcEstado", EnumEstadoImputacionContable.ACTIVO.getId());
            
            if (filtros!=null) {
                if (filtros.getDcoCodigo()!=null) {
                    // CODIGO DEL DOCUMENTO CONTABLE
                    query.setParameter("dcoCodigo", filtros.getDcoCodigo());
                }
                // RANGO DE CUENTAS CONTABLES
                if (filtros.getNumCuentaContableInicial()!=null && filtros.getNumCuentaContableFinal()!=null) {
                    query.setParameter("cuentaInicial", filtros.getNumCuentaContableInicial());
                    query.setParameter("cuentaFinal", filtros.getNumCuentaContableFinal());
                }
                if (filtros.getFechaInicial()!=null && filtros.getFechaFinal()!=null) {
                    // RANGO DE FECHAS
                    query.setParameter("fechaIni", Utilidades.truncDate(filtros.getFechaInicial()));
                    query.setParameter("fechaFin", Utilidades.truncDate(filtros.getFechaFinal()));
                }
                if (filtros.getFfcCodigo()!=null) {
                    // FUENTE DE FINANCIACION
                    query.setParameter("ffcCodigo", filtros.getFfcCodigo());
                }
                if (filtros.getReferencia1()!=null) {
                    // REFERENCIA 1
                    query.setParameter("imcReferencia1", filtros.getReferencia1());
                }
                if (filtros.getReferencia2()!=null) {
                    // REFERENCIA 2
                    query.setParameter("imcReferencia2", filtros.getReferencia2());
                }
            }
            
            
            List<Object[]> rows = query.getResultList();
            
            
            if (rows!=null) {
                
                resultado =  new ArrayList<LibroAuxiliarVO>();
                
                for (Object[] row: rows) {
                    LibroAuxiliarVO libroAuxiliarVo = new LibroAuxiliarVO();
                    
                    if (row[0]!=null)
                        libroAuxiliarVo.setCuentaContable((String) row[0]);
                    
                    if (row[1]!=null)
                        libroAuxiliarVo.setCcoCodigo(((BigDecimal) row[1]).longValue());
                    if (row[2]!=null)
                        libroAuxiliarVo.setNombreCuentaContable((String) row[2]);
                    
                    
                    // Solamente se visualizaran al momento de Filtrar por TERCERO.
                    if (!ocultarCampos || filtros.isFiltrarPorTercero()) {
                        if (row[3]!=null)
                            libroAuxiliarVo.setPerCodigo(((BigDecimal) row[3]).longValue());
                        if (row[4]!=null)
                            libroAuxiliarVo.setTipoIdentificacion((String) row[4]);
                        if (row[5]!=null)
                            libroAuxiliarVo.setPerNumIdentificacion((String) row[5]);
                        if (row[6]!=null)
                            libroAuxiliarVo.setPerDigitoVerif(((BigDecimal) row[6]).intValue());
                        if (row[7]!=null)
                            libroAuxiliarVo.setRazonSocial((String) row[7]);
                    }
                    
                    
                    if (row[8]!=null)
                        libroAuxiliarVo.setDcoCodigo(((BigDecimal) row[8]).longValue());
                    if (row[9]!=null)
                        libroAuxiliarVo.setDcoNumeroCompr(((BigDecimal) row[9]).intValue());
                    if (row[10]!=null)
                        libroAuxiliarVo.setTdcCodigo((String) row[10]);
                    if (row[11]!=null)
                        libroAuxiliarVo.setNombreTipoDocContable((String) row[11]);
                    if (row[12]!=null)
                        libroAuxiliarVo.setDcoFechaOper((Date) row[12]);
                    
                    
                    // Solamente se visualizaran al momento de Filtrar por FUENTE DE FINANCIACION.
                    if (!ocultarCampos || filtros.isFiltrarPorFuenteFinanciacion()) {
                        if (row[13]!=null)
                            libroAuxiliarVo.setFfcCodigo((String) row[13]);
                        if (row[14]!=null)
                            libroAuxiliarVo.setNombreFuenteFinContab((String) row[14]);
                    }
                    
                    
                    // Solamente se visualizaran al momento de Filtrar por CENTRO DE COSTOS.
                    if (!ocultarCampos || filtros.isFiltrarPorCentroCostos()) {
                        if (row[15]!=null)
                            libroAuxiliarVo.setIdCentroCostos(((BigDecimal) row[15]).longValue());
                        if (row[16]!=null)
                            libroAuxiliarVo.setNombreCentroCostos((String) row[16]);
                    }
                    
                    
                    if (row[17]!=null)
                        libroAuxiliarVo.setIdEstadoDocContab(((BigDecimal) row[17]).longValue());
                    if (row[18]!=null)
                        libroAuxiliarVo.setEstadoDocContab((String) row[18]);
                    if (row[19]!=null)
                        libroAuxiliarVo.setCcoNivel1((String) row[19]);
                    if (row[20]!=null)
                        libroAuxiliarVo.setCcoNivel2((String) row[20]);
                    if (row[21]!=null)
                        libroAuxiliarVo.setCcoNivel3((String) row[21]);
                    if (row[22]!=null)
                        libroAuxiliarVo.setCcoNivel4((String) row[22]);
                    if (row[23]!=null)
                        libroAuxiliarVo.setCcoNivel5((String) row[23]);
                    if (row[24]!=null)
                        libroAuxiliarVo.setImcTipoMovim((String) row[24]);
                    if (row[25]!=null)
                        libroAuxiliarVo.setNombreTipoMovim((String) row[25]);
                    if (row[26]!=null)
                        libroAuxiliarVo.setMovimientoCredito((BigDecimal) row[26]);
                    if (row[27]!=null)
                        libroAuxiliarVo.setMovimientoDebito((BigDecimal) row[27]);
                    
                    if (row[28]!=null)
                        libroAuxiliarVo.setReferencia1((String) row[28]);
                    if (row[29]!=null)
                        libroAuxiliarVo.setReferencia2((String) row[29]);
                    if (row[30]!=null)
                        libroAuxiliarVo.setDescrOperacion((String) row[30]);
                    
                    
                    resultado.add(libroAuxiliarVo);
                }
                
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
}
