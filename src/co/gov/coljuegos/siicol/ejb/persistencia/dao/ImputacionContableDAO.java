/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoImputacionContable;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoMovimiento;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionObligaNoPresupuestalVO;
import co.gov.coljuegos.siicol.ejb.vo.InfoSaldoImpCuentaContabVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ImputacionContableDAO extends GenericDAO<SiiImputacionContable>
{  

    /**
     * Constructor.
     */
    public ImputacionContableDAO() {
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiImputacionContable.class);
    }
    
    
    /**
     * Realiza la consulta de los registros <i>ACTIVOS</i> de Imputaci&oacute;n Contable asociados al Documentos Contable especificado.
     * @param dcoCodigo - C&oacute;digo del Documento Contable.
     * @return listado de SiiImputacionContable.
     * @throws ExcepcionDAO
     */
    public List<SiiImputacionContable> buscarPorCodigoDocumentoContable (Long dcoCodigo) throws ExcepcionDAO {
        return ( this.buscarPorCodigoDocumentoContableYEstado(dcoCodigo, EnumEstadoImputacionContable.ACTIVO.getId()) );
    }
    
    
    
    /**
     * Realiza la consulta de los registros de Imputaci&oacute;n Contable asociados al Documentos Contable especificado.
     * @param dcoCodigo - C&oacute;digo del Documento Contable.
     * @param imcEstado - Estado de la Imputaci&oacute;n Contable.
     * @return listado de SiiImputacionContable.
     * @throws ExcepcionDAO
     */
    public List<SiiImputacionContable> buscarPorCodigoDocumentoContableYEstado (Long dcoCodigo, String imcEstado) throws ExcepcionDAO {
        List<SiiImputacionContable> listaIC = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ic FROM SiiImputacionContable ic, ");
            sql.append("               SiiDocumentoContable dc ");
            sql.append("WHERE dc.dcoCodigo = ic.siiDocumentoContable.dcoCodigo ");
            sql.append("AND dc.dcoCodigo = :dcoCodigo ");
            
            if (imcEstado!=null)
                sql.append("AND ic.imcEstado = :imcEstado");
            
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("dcoCodigo", dcoCodigo);
            
            if (imcEstado!=null)
                query.setParameter("imcEstado", imcEstado);
            
            listaIC = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaIC;
    }
    
    
    public SiiImputacionContable insertarInputacionContable(SiiImputacionContable siiImputacionContable) throws ExcepcionDAO {
        return ( this.insertar(siiImputacionContable) );
    }
    
    public SiiImputacionContable insertarImputacionContable (SiiImputacionContable siiImputacionContable) throws ExcepcionDAO {
        return ( this.insertar(siiImputacionContable) );
    }
    
    
    public List<ImputacionObligaNoPresupuestalVO> buscarImputacionObligacionesNoPresupuestales(String tipoIdentificacion, String numeroIdentificacion, String idFueFinan ) throws ExcepcionDAO{
        List<ImputacionObligaNoPresupuestalVO> lista = new ArrayList<ImputacionObligaNoPresupuestalVO>();
        
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT Per.Per_Jur_Nombre_Largo,Per.Per_Primer_Nombre,Per.Per_Segundo_Nombre,Per.Per_Primer_Apellido,");
            sql.append(" Per.Per_Segundo_Apellido,Ti.Tid_Nombre,Per.Per_Num_Identificacion,Imp.Imc_Codigo,Cc.Cco_Codigo,");
            sql.append(" Tdc.Tdc_Nombre,Dc.Dco_Numero_Compr,Imp.Imc_Descr_Operacion,Imp.Imc_Tipo_Movim,Imp.Imc_Valor, Imp.ffc_codigo,");
            sql.append(" TO_CHAR(Cc.Cco_Nivel1) || ");
            sql.append(" (case when Cc.Cco_Nivel2 is null then '' else '.' || TO_CHAR(Cc.Cco_Nivel2) end) ||");
            sql.append(" (case when Cc.Cco_Nivel3 is null then '' else '.' || TO_CHAR(Cc.Cco_Nivel3) end) ||");
            sql.append(" (case when Cc.Cco_Nivel4 is null then '' else '.' || TO_CHAR(Cc.Cco_Nivel4) end) ||");
            sql.append(" (case when Cc.Cco_Nivel5 is null then '' else '.' || TO_CHAR(Cc.Cco_Nivel5) end) as cadena ");            
            sql.append(" FROM sii_imputacion_contable imp");
            sql.append(" INNER JOIN sii_cuentas_contables cc ON (cc.cco_codigo = imp.cco_Codigo");
            sql.append(" and cc.cco_permite_obl='S')");
            sql.append(" INNER JOIN sii_persona per ON (imp.per_codigo = per.per_codigo and Per.Per_Num_Identificacion=#numeroIdentificacion");
            sql.append(" and Per.Tid_Codigo =#tipoIdentificacion )");
            sql.append(" INNER JOIN sii_tipo_identificacion ti ON Per.Tid_Codigo = Ti.Tid_Codigo");
            sql.append(" INNER JOIN sii_documento_contable dc ON Imp.Dco_Codigo = Dc.Dco_Codigo");
            sql.append(" INNER JOIN  sii_tipo_doc_contable tdc ON Dc.Tdc_Codigo = tdc.Tdc_Codigo"); 
            sql.append(" where Imp.Imc_Codigo not in (select imc_codigo from Sii_Imp_Contab_Obl_No_Pres where ion_estado='A')");
            sql.append(" and imp.ffc_codigo = #idFueFinan");
            sql.append(" AND imp.imc_estado='A' and dc.edo_codigo=2");
            
            Query query = em.createNativeQuery(sql.toString()); 
            query.setParameter("numeroIdentificacion",numeroIdentificacion);
            query.setParameter("tipoIdentificacion",tipoIdentificacion);
            query.setParameter("idFueFinan",idFueFinan);
            List<Object[]> results = query.getResultList();
                if(results != null && !results.isEmpty()){                    
                    for (Object[] object : results){
                        ImputacionObligaNoPresupuestalVO vo = new ImputacionObligaNoPresupuestalVO();
                        vo.setRazonSocial((String)object[0]);
                        vo.setPrimerNombre((String)object[1]);
                        vo.setSegundoNombre((String)object[2]);
                        vo.setPrimerApellido((String)object[3]);
                        vo.setSegundoApellido((String)object[4]);
                        vo.setTipoIdentificacion((String)object[5]);
                        vo.setNumeroIdentificacion((String)object[6]);
                        vo.setIdImputacion(((BigDecimal)object[7]).longValue());
                        vo.setCodigoCuentaContable(((BigDecimal)object[8]).longValue());
                        vo.setTipoComprobante((String)object[9]);
                        vo.setNumeroComprobante(((BigDecimal)object[10]).intValue());
                        vo.setDescripcionOperacion((String)object[11]);
                        vo.setTipoMovimiento((String)object[12]);
                        vo.setValor((BigDecimal)object[13]);
                        vo.setCodigoFuenteFinanciacion((String)object[14]);
                        vo.setCadena((String)object[15]);
                        lista.add(vo);
                    }
                }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }          
        return lista;
    }
    
    public List<ImputacionObligaNoPresupuestalVO> buscarImputacionObligacionesNoPresupuestalesPorCodigoOblNoPres(Long idObligNoPres ) throws ExcepcionDAO{
        List<ImputacionObligaNoPresupuestalVO> lista = new ArrayList<ImputacionObligaNoPresupuestalVO>();
        
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT Imp.Imc_Codigo,cc.Cco_Codigo,Tdc.Tdc_Nombre,Dc.Dco_Numero_Compr,Imp.Imc_Descr_Operacion,");
            sql.append(" Imp.Imc_Tipo_Movim,Imp.Imc_Valor,imp.ffc_codigo, TO_CHAR(Cc.Cco_Nivel1) ||");
            sql.append(" (case when Cc.Cco_Nivel2 is null then '' else '.' || TO_CHAR(Cc.Cco_Nivel2) end) ||");
            sql.append(" (case when Cc.Cco_Nivel3 is null then '' else '.' || TO_CHAR(Cc.Cco_Nivel3) end) ||");
            sql.append(" (case when Cc.Cco_Nivel4 is null then '' else '.' || TO_CHAR(Cc.Cco_Nivel4) end) ||");
            sql.append(" (case when Cc.Cco_Nivel5 is null then '' else '.' || TO_CHAR(Cc.Cco_Nivel5) end) as cadena,");            
            sql.append(" Imp.Aco_Codigo, inp.onp_codigo,inp.ion_codigo FROM sii_imputacion_contable imp");
            sql.append(" INNER JOIN sii_imp_contab_obl_no_pres inp on (inp.imc_codigo = imp.imc_codigo and  inp.onp_codigo=#idObligNoPres)");
            sql.append(" INNER JOIN sii_cuentas_contables cc ON (cc.cco_codigo = imp.cco_Codigo )");
            sql.append(" INNER JOIN sii_documento_contable dc ON Imp.Dco_Codigo = Dc.Dco_Codigo");
            sql.append(" INNER JOIN  sii_tipo_doc_contable tdc ON Dc.Tdc_Codigo = tdc.Tdc_Codigo");
            sql.append(" WHERE inp.ion_estado='A'");
            
                        
            Query query = em.createNativeQuery(sql.toString()); 
            query.setParameter("idObligNoPres",idObligNoPres);
            
            List<Object[]> results = query.getResultList();
                if(results != null && !results.isEmpty()){                    
                    for (Object[] object : results){
                        ImputacionObligaNoPresupuestalVO vo = new ImputacionObligaNoPresupuestalVO();
                      
                        vo.setIdImputacion(((BigDecimal)object[0]).longValue());
                        vo.setCodigoCuentaContable(((BigDecimal)object[1]).longValue());
                        vo.setTipoComprobante((String)object[2]);
                        vo.setNumeroComprobante(((BigDecimal)object[3]).intValue());
                        vo.setDescripcionOperacion((String)object[4]);
                        vo.setTipoMovimiento((String)object[5]);
                        vo.setValor((BigDecimal)object[6]); 
                        vo.setCodigoFuenteFinanciacion((String)object[7]);
                        vo.setCadena((String)object[8]);
                        if(object[9]!= null){
                            vo.setCodAreaColjuegos(((BigDecimal)object[9]).longValue());
                        }
                        vo.setOnpCodigo(((BigDecimal)object[10]).longValue());
                        vo.setIonCodigo(((BigDecimal)object[11]).longValue());
                        lista.add(vo);
                    }
                }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }          
        return lista;
    }
    
    
    
    
    /**
     * Obtiene el listado que contiene la informaci&oacute;n de Saldos asociados a registros de Imputaci&oacute;n Contable relacionadas con Cuentas Contables.
     * @param vigencia - Vigencia
     * @param incluirSaldoInicial - Flag que determina si es necesario incluir los movimientos correspondientes al Saldo Inicial.
     * @param ccoCodigo - C&oacute;digo de la Cuenta Contable.
     * @param groupByPerCodigo - Flag que determina si se realizar&aacute; agrupamiento por Tercero.
     * @param groupByAcoCodigo - Flag que determina si se realizar&aacute; agrupamiento por Centro de Costos.
     * @return List of InfoSaldoImpCuentaContabVO.
     * @throws ExcepcionDAO
     */
    public List<InfoSaldoImpCuentaContabVO> obtenerInfoSaldoImputacionCuentasContab (Integer vigencia, boolean incluirSaldoInicial, Long ccoCodigo, boolean groupByPerCodigo, boolean groupByAcoCodigo) throws ExcepcionDAO 
    {
        return ( this.obtenerInfoSaldoImputacionCuentasContab(vigencia, incluirSaldoInicial, null, null, null, groupByPerCodigo, groupByAcoCodigo, ccoCodigo) );
    }
    
    
    
    
    /**
     * Obtiene el listado que contiene la informaci&oacute;n de Saldos asociados a registros de Imputaci&oacute;n Contable relacionadas con Cuentas Contables.
     * @param vigencia - Vigencia.
     * @param incluirSaldoInicial - Flag que determina si es necesario incluir los movimientos correspondientes al Saldo Inicial.
     * @param ccoTipoCuenta - Tipo de Cuenta Contable.
     * @param ccoCtaResult - Flag que determina si es una Cuenta de Resultados.
     * @param ccoCtaImpuestos - Flag que determina si es una Cuenta de Impuestos.
     * @param groupByPerCodigo - Flag que determina si se realizar&aacute; agrupamiento por Tercero.
     * @param groupByAcoCodigo - Flag que determina si se realizar&aacute; agrupamiento por Centro de Costos.
     * @param ccoCodigo - C&oacute;digo de la Cuenta Contable.
     * @return List of InfoSaldoImpCuentaContabVO.
     * @throws ExcepcionDAO
     */
    public List<InfoSaldoImpCuentaContabVO> obtenerInfoSaldoImputacionCuentasContab (Integer vigencia, boolean incluirSaldoInicial, String ccoTipoCuenta, String ccoCtaResult, String ccoCtaImpuestos, boolean groupByPerCodigo, boolean groupByAcoCodigo, Long ccoCodigo) throws ExcepcionDAO
    {
        List<InfoSaldoImpCuentaContabVO> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  CCO_CODIGO, ");
            
            if (groupByAcoCodigo)
                sql.append("        ACO_CODIGO, ");
            
            sql.append("        FFC_CODIGO, ");
            
            if (groupByPerCodigo)
                sql.append("        PER_CODIGO, ");
            
            sql.append("        VALOR_DEBITOS, "); 
            sql.append("        VALOR_CREDITOS, "); 
            sql.append("        (VALOR_DEBITOS - VALOR_CREDITOS) AS SALDO "); 
            sql.append("FROM ");
            sql.append("( "); 
            sql.append("    SELECT  Y.CCO_CODIGO, ");
            
            if (groupByAcoCodigo)
                sql.append("            Y.ACO_CODIGO, ");
            
            sql.append("            Y.FFC_CODIGO, ");
            
            if (groupByPerCodigo)
                sql.append("            Y.PER_CODIGO, ");
            
            sql.append("            SUM(Y.VALOR_DEBITOS) AS VALOR_DEBITOS, "); 
            sql.append("            SUM(Y.VALOR_CREDITOS) AS VALOR_CREDITOS ");
            sql.append("    FROM ( ");
            sql.append("        (select imc.CCO_CODIGO, ");
            
            if (groupByAcoCodigo)
                sql.append("                imc.ACO_CODIGO, ");
            
            sql.append("                imc.FFC_CODIGO, ");
            
            if (groupByPerCodigo)
                sql.append("                imc.PER_CODIGO, ");
            
            sql.append("                SUM(imc.IMC_VALOR) as VALOR_DEBITOS, ");
            sql.append("                0 AS VALOR_CREDITOS ");
            sql.append("        from SII_IMPUTACION_CONTABLE imc ");
            sql.append("        INNER JOIN SII_CUENTAS_CONTABLES cco  ON  cco.CCO_CODIGO = imc.CCO_CODIGO ");
            
            if (vigencia!=null)
                sql.append("        INNER JOIN SII_DOCUMENTO_CONTABLE dco  ON  dco.DCO_CODIGO = imc.DCO_CODIGO ");
            
            sql.append("        WHERE imc.IMC_CODIGO = imc.IMC_CODIGO ");
            
            if (ccoTipoCuenta!=null)
                sql.append("        AND cco.CCO_TIPO_CUENTA = #ccoTipoCuenta ");
            
            if (ccoCtaResult!=null)
                sql.append("        AND cco.CCO_CTA_RESULT = #ccoCtaResult ");
            
            if (ccoCtaImpuestos!=null)
                sql.append("        AND cco.CCO_CTA_IMPUESTOS = #ccoCtaImpuestos ");
            
            if (ccoCodigo!=null)
                sql.append("        AND imc.CCO_CODIGO = #ccoCodigo ");
            
                if (vigencia!=null) {
                    sql.append("        AND EXTRACT(YEAR FROM dco.DCO_FECHA_OPER) IN ( ");
                    if (incluirSaldoInicial) {
                        Integer vigSaldoInicial = vigencia - 1;
                        sql.append(vigSaldoInicial+", "+vigencia);
                    }
                    else {
                        sql.append(vigencia.toString());
                    }
                    sql.append(") ");
                }
            
            sql.append("        AND dco.EDO_CODIGO = #edoCodigo ");
            sql.append("        AND imc.IMC_ESTADO = #imcEstado "); 
            sql.append("        AND imc.IMC_TIPO_MOVIM = #imcTipoMovimD "); 
            sql.append("        GROUP BY imc.CCO_CODIGO ");
            
            if (groupByAcoCodigo)
                sql.append("                ,imc.ACO_CODIGO ");
            
            sql.append("                ,imc.FFC_CODIGO ");
            
            if (groupByPerCodigo)
                sql.append("                 ,imc.PER_CODIGO ");
            
            sql.append("        ) ");
            
            sql.append("        UNION ALL ");
            
            sql.append("        (select imc.CCO_CODIGO, ");
            
            if (groupByAcoCodigo)
                sql.append("                imc.ACO_CODIGO, ");
            
            sql.append("                imc.FFC_CODIGO, ");
            
            if (groupByPerCodigo)
                sql.append("                imc.PER_CODIGO, ");
            
            sql.append("                0 AS VALOR_DEBITOS, "); 
            sql.append("                SUM(imc.IMC_VALOR) as VALOR_CREDITOS ");
            sql.append("        from SII_IMPUTACION_CONTABLE imc "); 
            sql.append("        INNER JOIN SII_CUENTAS_CONTABLES cco  ON  cco.CCO_CODIGO = imc.CCO_CODIGO ");
            
            if (vigencia!=null)
                sql.append("        INNER JOIN SII_DOCUMENTO_CONTABLE dco  ON  dco.DCO_CODIGO = imc.DCO_CODIGO ");
            
            sql.append("        WHERE imc.IMC_CODIGO = imc.IMC_CODIGO ");
            
            if (ccoTipoCuenta!=null)
                sql.append("        AND cco.CCO_TIPO_CUENTA = #ccoTipoCuenta ");
            
            if (ccoCtaResult!=null)
                sql.append("        AND cco.CCO_CTA_RESULT = #ccoCtaResult ");
            
            if (ccoCtaImpuestos!=null)
                sql.append("        AND cco.CCO_CTA_IMPUESTOS = #ccoCtaImpuestos ");
            
            if (ccoCodigo!=null)
                sql.append("        AND imc.CCO_CODIGO = #ccoCodigo ");
            
            if (vigencia!=null) {
                sql.append("        AND EXTRACT(YEAR FROM dco.DCO_FECHA_OPER) IN ( ");
                if (incluirSaldoInicial) {
                    Integer vigSaldoInicial = vigencia - 1;
                    sql.append(vigSaldoInicial+", "+vigencia);
                }
                else {
                    sql.append(vigencia.toString());
                }
                sql.append(") ");
            }
            
            sql.append("        AND dco.EDO_CODIGO = #edoCodigo ");
            sql.append("        AND imc.IMC_ESTADO = #imcEstado ");
            sql.append("        AND imc.IMC_TIPO_MOVIM = #imcTipoMovimC "); 
            sql.append("        GROUP BY imc.CCO_CODIGO ");
            
            if (groupByAcoCodigo)
                sql.append("                ,imc.ACO_CODIGO ");
            
            sql.append("                ,imc.FFC_CODIGO ");
            
            if (groupByPerCodigo)
                sql.append("                ,imc.PER_CODIGO ");
            
            sql.append("        ) ");
            
            sql.append("    ) Y "); 
            sql.append("    GROUP BY Y.CCO_CODIGO ");
            
            if (groupByAcoCodigo)
                sql.append("            ,Y.ACO_CODIGO ");
            
            sql.append("            ,Y.FFC_CODIGO ");
            
            if (groupByPerCodigo)
                sql.append("            ,Y.PER_CODIGO ");
            
            sql.append(") ");
            
            
            Query query = em.createNativeQuery(sql.toString());
            
            
            if (ccoTipoCuenta!=null)
                query.setParameter("ccoTipoCuenta", ccoTipoCuenta);
            
            if (ccoCtaResult!=null)
                query.setParameter("ccoCtaResult", ccoCtaResult);
            
            if (ccoCtaImpuestos!=null)
                query.setParameter("ccoCtaImpuestos", ccoCtaImpuestos);
            
            if (ccoCodigo!=null)
                query.setParameter("ccoCodigo", ccoCodigo);
            
            query.setParameter("edoCodigo", EnumEstadoDocContab.APROBADO.getId());
            query.setParameter("imcEstado", EnumEstadoImputacionContable.ACTIVO.getId());
            query.setParameter("imcTipoMovimD", EnumTipoMovimiento.DEBITO.getId());
            query.setParameter("imcTipoMovimC", EnumTipoMovimiento.CREDITO.getId());
            
            List<Object[]> lista = query.getResultList();
            
            if (lista!=null && !lista.isEmpty()) {
                resultado = new ArrayList<InfoSaldoImpCuentaContabVO>();
                
                for (Object[] row: lista) {
                    int colNum = 0;
                    InfoSaldoImpCuentaContabVO isiccVo = new InfoSaldoImpCuentaContabVO();
                    isiccVo.setCcoCodigo(((BigDecimal)row[colNum++]).longValue());
                    
                    if (groupByAcoCodigo) {
                        if (row[colNum]!=null)
                            isiccVo.setAcoCodigo(((BigDecimal)row[colNum]).longValue());
                        
                        colNum++;
                    }
                    
                    isiccVo.setFfcCodigo((String)row[colNum++]);
                    
                    if (groupByPerCodigo) {
                        if (row[colNum]!=null)
                            isiccVo.setPerCodigo(((BigDecimal)row[colNum]).longValue());
                        
                        colNum++;
                    }
                    
                    isiccVo.setValorDebitos((BigDecimal)row[colNum++]);
                    isiccVo.setValorCreditos((BigDecimal)row[colNum++]);
                    isiccVo.setSaldo((BigDecimal)row[colNum++]);
                    
                    
                    resultado.add(isiccVo);
                }
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    public List<SiiImputacionContable> buscarPorRef1Ref2ImputacionCont (String  ref1, String ref2) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT ic FROM SiiImputacionContable ic ");
            sql.append(" inner join  ic.siiDocumentoContable d ");
            sql.append(" WHERE ic.imcReferencia1 =:ref1 ");
            sql.append(" AND ic.imcReferencia2 =:ref2 and d.siiTipoDocContable.tdcCodigo ='ACC'");           
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("ref1", ref1);
            query.setParameter("ref2", ref2);
            
            List<SiiImputacionContable> listaIC = query.getResultList();
            return listaIC;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
}
