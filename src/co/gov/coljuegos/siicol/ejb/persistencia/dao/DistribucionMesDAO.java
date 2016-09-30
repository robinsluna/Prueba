/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 14-03-2014
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.DistribucionMesVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteDistribucionVO;
import co.gov.coljuegos.siicol.ejb.vo.RecaudoEnteVO;

import co.gov.coljuegos.siicol.ejb.vo.ReporteOperadorVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

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
public class DistribucionMesDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public DistribucionMesDAO() {
        recursos = new Recursos();
    }
    
    public SiiDistribucionMes buscarPorCodigoDistribucionMes(Long idCodigoDistMes) throws ExcepcionDAO {
        SiiDistribucionMes retorno = null;
        try {
            retorno = manager.find(SiiDistribucionMes.class, idCodigoDistMes);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DistribucionMesDAO");
        }
        return retorno;

    }
    
    public SiiDistribucionMes insertarSiiDistribucionMes(SiiDistribucionMes distribucionMes) throws ExcepcionDAO {
        try {
            manager.persist(distribucionMes); 
            manager.flush(); 
            return distribucionMes; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DistribucionMesDAO");
        }
    }
    
    public List<RecaudoEnteVO> buscarValorRecaudoTodosMunicipiosPorMes(int mes, Long idCategoria, Integer vigencia, String fechaLiq) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
         try{             
             StringBuilder sql = new StringBuilder(); 
             sql.append("  select sum(t.valor), t.ubicacion ,t.poblacion, t.dde_codigo FROM");
             sql.append(" (select distinct sum(s.valor) valor,s.ubicacion ubicacion,s.poblacion poblacion,s.cuota, s.dde_codigo dde_codigo FROM ( ");
             sql.append(" select sum(p.valor) valor ,p.ubicacion ubicacion,p.poblacion poblacion,p.codconcepto,p.cuota cuota,p.dde_codigo dde_codigo  from  (");
             //sql.append(" select sum(re.ree_valor_pagado)valor, ub.ubi_codigo ubicacion,pen.pen_poblac_total poblacion,");
             sql.append(" select sum(re.ree_valor_pagado)valor, ub.ubi_codigo ubicacion, Et.ETI_POBLACION poblacion,");
             sql.append(" cc.ccu_codigo codconcepto,Dd.Dde_Codigo dde_codigo,Co.Cop_Codigo cuota");
             sql.append(" from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
             sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
             sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
             sql.append(" Inner Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
             //sql.append(" Inner Join sii_poblacion_ente pen on (et.eti_codigo = pen.eti_codigo)");
             sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
             sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo is null");
             //sql.append(" and ( Pen.Pen_Fecha_Ini <= to_Date('" + fechaLiq + "','dd/mm/yyyy') and pen.pen_fecha_fin >= to_Date('" +fechaLiq +"','dd/mm/yyyy') )");
             sql.append(" group by dd.dde_valor_pagado, re.dde_codigo, Dd.Dde_Codigo");
             //sql.append(" ,ub.ubi_codigo,pen.pen_poblac_total,cc.ccu_codigo,Co.Cop_Codigo");
             sql.append(" ,ub.ubi_codigo,Et.ETI_POBLACION,cc.ccu_codigo,Co.Cop_Codigo");
             sql.append(" having sum(re.ree_valor_pagado) > 0	) p");
             sql.append(" group by p.ubicacion,p.poblacion,p.codconcepto ,p.cuota ,p.dde_codigo");
             sql.append(" UNION");
             sql.append(" select distinct sum(q.valor),q.ubica,q.poblacion,q.codconcepto,q.cuota, q.dde_codigo  from (");
             //sql.append(" select distinct sum(re.ree_valor_pagado) valor ,ub.ubi_codigo ubica,pen.pen_poblac_total poblacion,");
             sql.append(" select distinct sum(re.ree_valor_pagado) valor ,ub.ubi_codigo ubica,Et.ETI_POBLACION poblacion,");
             sql.append(" cc.ccu_codigo codconcepto,Co.Cop_Codigo cuota, dd.dde_codigo dde_codigo");
             sql.append(" from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
             sql.append(" inner join sii_acuerdo_pago ac on co.apa_codigo = ac.apa_codigo");
             sql.append(" inner join sii_liquidacion_establ lq on re.les_codigo = lq.les_codigo");
             sql.append(" inner join sii_ubicacion ub on  lq.ubi_codigo_mun_est = ub.ubi_codigo");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo) ");
             //sql.append(" Inner Join sii_poblacion_ente pen on (et.eti_codigo = pen.eti_codigo)");
             sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
             sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo is null");
             //sql.append(" and ( Pen.Pen_Fecha_Ini <= to_Date('" + fechaLiq + "','dd/mm/yyyy') and pen.pen_fecha_fin >= to_Date('" +fechaLiq +"','dd/mm/yyyy') )");
             //sql.append(" group by ub.ubi_codigo,pen.pen_poblac_total , cc.ccu_codigo ,Co.Cop_Codigo,dd.dde_codigo)q  ");
             sql.append(" group by ub.ubi_codigo, Et.ETI_POBLACION , cc.ccu_codigo ,Co.Cop_Codigo,dd.dde_codigo)q  ");
             sql.append(" group by q.ubica,q.poblacion,q.codconcepto ,q.cuota,q.dde_codigo");
             sql.append(" UNION");
             sql.append(" select  sum(r.valor), r.ubicacion,r.poblacion,r.codconcepto, r.cuota , r.dde_codigo from ");
             //sql.append(" (select distinct sum(re.ree_valor_pagado)valor, ub.ubi_codigo ubicacion,pen.pen_poblac_total poblacion,");
             sql.append(" (select distinct sum(re.ree_valor_pagado)valor, ub.ubi_codigo ubicacion,Et.ETI_POBLACION poblacion,");
             sql.append(" cc.ccu_codigo codconcepto, co.cop_codigo cuota, dd.dde_codigo dde_codigo");
             sql.append(" from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
             sql.append(" left Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (le.ubi_codigo_mun_est= ub.ubi_codigo) ");
             sql.append(" left Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
             //sql.append(" left Join sii_poblacion_ente pen on (et.eti_codigo = pen.eti_codigo)");
             sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
             sql.append(" and Cc.Cad_Codigo=1");
             sql.append(" and dd.dme_codigo is null");
             //sql.append(" and ( Pen.Pen_Fecha_Ini <= to_Date('" + fechaLiq + "','dd/mm/yyyy') and pen.pen_fecha_fin >= to_Date('" +fechaLiq +"','dd/mm/yyyy') )");
             sql.append(" group by dd.dde_valor_pagado, re.dde_codigo, Dd.Dde_Codigo");
             //sql.append(" ,ub.ubi_codigo,pen.pen_poblac_total,cc.ccu_codigo, co.cop_codigo,dd.dde_codigo");
             sql.append(" ,ub.ubi_codigo,Et.ETI_POBLACION,cc.ccu_codigo, co.cop_codigo,dd.dde_codigo");
             sql.append(" having sum(re.ree_valor_pagado) > 0)r");
             sql.append(" group by r.ubicacion,r.poblacion,r.codconcepto,r.cuota,r.dde_codigo   )s");
             sql.append(" GROUP BY s.ubicacion,s.poblacion, s.codconcepto,s.cuota,s.dde_codigo)t");
             sql.append(" GROUP BY t.ubicacion ,t.poblacion ,t.dde_codigo");			 

                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             query.setParameter("idCategoria",idCategoria);
             //query.setParameter("fechaLiq",fechaLiq);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 RecaudoEnteVO vo = new RecaudoEnteVO(); 
                 vo.setTotalRecaudo((BigDecimal) object[0]);
                 vo.setUbicacion((String) object[1]);
                 vo.setPoblacion((BigDecimal) object[2]); 
                 //vo.setConceptoCuota(((BigDecimal) object[3]).longValue());                 
                 vo.setDdeCodigo(((BigDecimal) object[3]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    public List<RecaudoEnteVO> buscarValorRecaudoInteresTodosMunicipiosPorMes(int mes, String pTipoCuota, Integer vigencia) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
         try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select sum(re.ree_valor_pagado),ub.ubi_codigo,et.ETI_POBLAC_P_2014");
             sql.append(" ,cc.ccu_codigo, cc.ccu_tipo,cc.ccu_distribucion,dd.dde_codigo");
             sql.append(" from sii_interes_cuota ic");
             sql.append(" Inner Join sii_cuota_operador co on (ic.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (co.cop_codigo = dd.cop_codigo)");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
             sql.append(" Inner Join sii_liquidacion_establ le on (re.les_codigo = le.les_codigo)");
             sql.append(" Inner Join sii_establecimiento es on (le.est_codigo = es.est_codigo)");             
             sql.append(" Inner Join sii_ubicacion ub on (es.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo) ");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') =#mes and to_char(pp.fecha_recaudo,'YYYY')=#vigencia");             
             sql.append(" and cc.ccu_modalidad='L' and Cc.Ccu_Tipo=#pTipoCuota and dd.dme_codigo is null");
             sql.append(" group by ub.ubi_codigo,et.ETI_POBLAC_P_2014 ,cc.ccu_codigo, cc.ccu_tipo,cc.ccu_distribucion,dd.dde_codigo");
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             query.setParameter("pTipoCuota",pTipoCuota);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 RecaudoEnteVO vo = new RecaudoEnteVO(); 
                 vo.setTotalRecaudo((BigDecimal) object[0]);
                 vo.setUbicacion((String) object[1]);
                 vo.setPoblacion((BigDecimal) object[2]); 
                 vo.setConceptoCuota(((BigDecimal) object[3]).longValue());
                 vo.setTipoConceptoCuota((String) object[4]);
                 vo.setDistribucion((String) object[5]);
                 vo.setDdeCodigo(((BigDecimal) object[6]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    
    public int buscarConsecutivoDistribucion() throws ExcepcionDAO {
        int consecutivo = 0;    
        try{
            StringBuilder sql = new StringBuilder();            
            sql.append("SELECT NVL(MAX(SII_DISTRIBUCION_MES.DCN_NUMERO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) FROM SII_DISTRIBUCION_MES");
            Query query = manager.createNativeQuery(sql.toString());
            
            if (query.getSingleResult() != null) {              
                consecutivo = ((BigDecimal) query.getSingleResult()).intValueExact();
            }                 
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    
    
    /**
     * Obtiene el listado de Distribuciones del Mes, que se encuentren en el Estado especificado.
     * @param edeCodigo - C&oacute;digo del Estado.
     * @return List of SiiDistribucionMes
     * @throws ExcepcionDAO
     */
    public List<SiiDistribucionMes> buscarDistribucionMesPorEstado (Long edeCodigo) throws ExcepcionDAO {
        List<SiiDistribucionMes> resultado = null;
        
        if (edeCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT o FROM SiiDistribucionMes o ");
                sql.append("WHERE o.siiEstadoDistribEnte.edeCodigo = :edeCodigo ");
                
                Query query = manager.createQuery(sql.toString());
                query.setParameter("edeCodigo", edeCodigo);
                
                resultado = query.getResultList();
                
            }
            catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene el listado de Distribuciones del Mes, que se encuentren en el Estado especificado y que no est&eacute;n asociadas a una Obligaci&oacute;n.
     * @param edeCodigo - C&oacute;digo del Estado.
     * @return List of SiiDistribucionMes
     * @throws ExcepcionDAO
     */
    public List<SiiDistribucionMes> buscarDistribucionMesSinObligacionPorEstado (Long edeCodigo) throws ExcepcionDAO {
        List<SiiDistribucionMes> resultado = null;
        
        if (edeCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT d FROM SiiDistribucionMes d ");
                sql.append("WHERE d.siiEstadoDistribEnte.edeCodigo = :edeCodigo ");
                sql.append("AND NOT EXISTS (SELECT o FROM SiiObligacion o  WHERE o.siiDistribucionMes.dmeCodigo = d.dmeCodigo) ");
                
                Query query = manager.createQuery(sql.toString());
                query.setParameter("edeCodigo", edeCodigo);
                
                resultado = query.getResultList();
                
            }
            catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene la Distribuciones dado un mes y una vigencia.
     * @param pMes - mes de distribución.
     * @param pVigencia - vigencia de distribución.
     * @return List of SiiDistribucionMes
     * @throws ExcepcionDAO
     */
    public List<SiiDistribucionMes> buscarDistribucionPorMesYVigencia (int pMes, int pVigencia ) throws ExcepcionDAO {
        List<SiiDistribucionMes> resultado = null;        
        
        try {
            // falta por crear los dos campos mes y vigencia en la tabla sii_distribucion_mes :(
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDistribucionMes o INNER JOIN o.siiMes mes");
            sql.append(" INNER JOIN o.siiEstadoDistribEnte est WHERE mes.mesCodigo=:pMes and o.dmeVigencia=:pVigencia");
            sql.append(" and est.edeCodigo = 4");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pMes", pMes);
            query.setParameter("pVigencia", pVigencia);
            
            resultado = query.getResultList();
            
        }
        catch(PersistenceException pe){            
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
       
        
        return (resultado);
    }
    public SiiDistribucionMes actualizarSiiDistribucionMes(SiiDistribucionMes distribucion) throws ExcepcionDAO {
        try {
            manager.merge(distribucion); 
            manager.flush(); 
            return distribucion; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    
    public List<SiiDistribucionMes> buscarDistribucionMesConOrdenPagoPendientes () throws ExcepcionDAO {
        return ( this.buscarDistribucionMesConOrdenPagoPendientes(null) );
    }
    
    
    public List<SiiDistribucionMes> buscarDistribucionMesConOrdenPagoPendientes (String tdcCodigo) throws ExcepcionDAO {
        List<SiiDistribucionMes> resultado = null;
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  dme.DME_CODIGO, ");
            sql.append("        dme.DME_DESCRIPCION ");
            sql.append("FROM SII_DISTRIBUCION_MES dme ");
            sql.append("INNER JOIN SII_ESTADO_DISTRIB_ENTE ede  ON  ede.EDE_CODIGO = dme.EDE_CODIGO ");
            sql.append("WHERE EXISTS (SELECT obl.obl_codigo FROM SII_OBLIGACION obl ");
            sql.append("              INNER JOIN SII_ESTADO_OBLIGACION eob  ON  eob.eob_codigo = obl.eob_codigo ");
            sql.append("              WHERE obl.DME_CODIGO = dme.DME_CODIGO ");
            sql.append("              AND obl.eob_codigo = #eobCodigo ");
            
            if (tdcCodigo!=null) {
                sql.append("              AND obl.tdc_codigo = #tdcCodigo ");
            }
            
            sql.append("              AND obl.obl_codigo NOT IN (SELECT orp.obl_codigo FROM SII_ORDEN_PAGO orp WHERE orp.obl_codigo IS NOT NULL)) ");
            
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("eobCodigo", EnumEstadoObligacion.APROBADO.getId());
            
            if (tdcCodigo!=null)
                query.setParameter("tdcCodigo", tdcCodigo);
            
            
            List<Object[]> lista = query.getResultList();
            
            if (lista!=null) {
                resultado = new ArrayList<SiiDistribucionMes>();
                
                for (Object[] row: lista) {
                    if (row!=null && row[0]!=null) {
                        Long dmeCodigo = ((BigDecimal) row[0]).longValue();
                        SiiDistribucionMes siiDistribucionMes = this.buscarPorCodigoDistribucionMes(dmeCodigo);
                        if (siiDistribucionMes!=null)
                            resultado.add(siiDistribucionMes);
                    }
                }
            }
            
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    public List<SiiDistribucionMes> buscarTodoSiiDistribucion() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDistribucionMes o");
            Query query = manager.createQuery(sql.toString());
            List<SiiDistribucionMes> listaDistri = query.getResultList();
            return listaDistri;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

    }
    




public List<ReporteOperadorVO> buscarDistribucionOperadorPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
		 Long codDistribucion = new Long(0);
         try{
			List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
                  codDistribucion = distribucion.get(0).getDmeCodigo();
                 
              }              
             StringBuilder sql = new StringBuilder();
			 sql.append(" select distinct s.concepto,s.nit,s.razonSocial,sum(s.valor),s.codconcepto FROM");
			 sql.append(" (select cc.ccu_abreviatura concepto, per.per_num_identificacion nit,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
			 sql.append(" sum(re.ree_valor_pagado)valor, cc.ccu_codigo codconcepto ,co.cop_num_cuota	");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
			 sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo)");
			 sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo =#codDistribucion");
			 sql.append(" group by cc.ccu_abreviatura , per.per_num_identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido),");
			 sql.append(" cc.ccu_codigo,co.cop_num_cuota");
			 sql.append(" having sum(re.ree_valor_pagado) > 0");
			 sql.append(" UNION");
			 sql.append(" select distinct p.conc,p.ident,p.razon,sum(p.valor2),p.codconce ,p.cop_num_cuota from (");
			 sql.append(" select distinct cc.ccu_abreviatura conc, per.per_num_identificacion ident,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razon,");
			 sql.append(" re.ree_valor_pagado valor2, cc.ccu_codigo codconce ,co.cop_num_cuota");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" inner join sii_acuerdo_pago ac on co.apa_codigo = ac.apa_codigo");
			 sql.append(" inner join sii_liquidacion_establ lq on re.les_codigo = lq.les_codigo");
			 sql.append(" inner join sii_ubicacion ub on  lq.ubi_codigo_mun_est = ub.ubi_codigo");
			 sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo) ");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo=#codDistribucion)p");
			 sql.append(" group by p.conc,p.ident,p.razon,p.codconce,p.cop_num_cuota");
			 sql.append(" UNION");
			 sql.append(" select distinct cc.ccu_abreviatura , per.per_num_identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
			 sql.append(" sum(re.ree_valor_pagado) , cc.ccu_codigo ,co.cop_num_cuota ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" left Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (le.ubi_codigo_mun_est= ub.ubi_codigo) ");
			 sql.append(" left Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo = #codDistribucion");
			 sql.append(" group by cc.ccu_abreviatura , per.per_num_identificacion ,");
			 sql.append("  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
			 sql.append(" cc.ccu_codigo,co.cop_num_cuota ");
			 sql.append(" having sum(re.ree_valor_pagado) > 0	 )s");
			 sql.append(" GROUP BY s.concepto,s.nit,s.razonSocial,s.codconcepto");
			 
			 /*sql.append(" select cc.ccu_abreviatura concepto,Per.Per_Num_Identificacion NIT,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
			 sql.append(" sum(re.ree_valor_pagado)valor,cc.ccu_codigo codconcepto");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
			 sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" left Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (per.ubi_codigo = ub.ubi_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo =#codDistribucion");
			 sql.append(" group by cc.ccu_codigo ,cc.ccu_abreviatura ,Per.Per_Num_Identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido)");
			 sql.append(" having sum(re.ree_valor_pagado) >0");
			 sql.append(" order by razonSocial");*/
			                                                     
             
			Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("mes", mes); 
			query.setParameter("vigenciaReporte", vigenciaReporte);
			query.setParameter("codDistribucion", codDistribucion);			
             
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setConcepto((String) object[0]);
                 vo.setNumeroIdentificacion((String) object[1]);
                 vo.setRazonSocial((String) object[2]);
                 vo.setValor((BigDecimal) object[3]);                 
                 vo.setCodConcepto(((BigDecimal) object[4]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    public List<ReporteOperadorVO> buscarDistribucionOperadorPorMesYDepto(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
         try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" SELECT  Ub2.Ubi_Nombre ,SUM(re.ree_valor_pagado)");
             sql.append("  FROM sii_detalle_declaracion dde");
             sql.append(" Inner Join Sii_Distribucion_Mes dm on (dde.dme_codigo = dm.dme_codigo)");
             sql.append(" Inner Join Sii_Cuota_Operador co on (co.cop_codigo = dde.cop_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo) ");
             sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
             sql.append(" Inner Join sii_recaudo_establec re on (dde.dde_codigo = re.dde_codigo)");
             sql.append(" Inner Join sii_liquidacion_establ les on (re.les_codigo = les.les_codigo)");
             sql.append(" Inner Join sii_establecimiento est on (les.est_codigo = est.est_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo )");
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo   )");
             sql.append(" where Dm.Mes_Codigo = #mes and dm.dme_vigencia=#vigenciaReporte ");
             sql.append(" group by Ub2.Ubi_Nombre ");
             sql.append(" order by Ub2.Ubi_Nombre");
             
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigenciaReporte",vigenciaReporte);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setDepartamento((String) object[0]);                 
                 vo.setValor((BigDecimal) object[1]);                
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    
public List<RecaudoEnteVO> buscarValorRecaudoTodosMunicipiosPorMesSinDdeCodigo(int mes, Long idCategoria, Integer vigencia, String fechaLiq) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
         try{             
             StringBuilder sql = new StringBuilder(); 
             
             sql.append(" select sum(t.valor), t.ubicacion ,t.poblacion FROM");
             sql.append(" (select distinct sum(s.valor) valor,s.ubicacion ubicacion,s.poblacion poblacion,s.cuota FROM ( ");
             sql.append(" select sum(p.valor) valor ,p.ubicacion ubicacion,p.poblacion poblacion,p.codconcepto,p.cuota cuota from  (");
             //sql.append(" select sum(re.ree_valor_pagado)valor, ub.ubi_codigo ubicacion, pen.pen_poblac_total poblacion,");
             sql.append(" select sum(re.ree_valor_pagado)valor, ub.ubi_codigo ubicacion, Et.ETI_POBLACION poblacion,");
             sql.append(" cc.ccu_codigo codconcepto,Dd.Dde_Codigo dde_codigo,Co.Cop_Codigo cuota");
             sql.append(" from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
             sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
             sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
             sql.append(" Inner Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
             //sql.append(" Inner Join sii_poblacion_ente pen on (et.eti_codigo = pen.eti_codigo)");
             sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
             sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo is null");
             //sql.append(" and ( Pen.Pen_Fecha_Ini <= to_Date('" + fechaLiq + "','dd/mm/yyyy') and pen.pen_fecha_fin >= to_Date('" +fechaLiq +"','dd/mm/yyyy') )");
             sql.append(" group by dd.dde_valor_pagado, re.dde_codigo, Dd.Dde_Codigo");
             //sql.append(" ,ub.ubi_codigo,pen.pen_poblac_total,cc.ccu_codigo,Co.Cop_Codigo");
             sql.append(" ,ub.ubi_codigo,Et.ETI_POBLACION,cc.ccu_codigo,Co.Cop_Codigo");
             sql.append(" having sum(re.ree_valor_pagado) > 0	) p");
             sql.append(" group by p.ubicacion,p.poblacion,p.codconcepto ,p.cuota ");
             sql.append(" UNION");
             sql.append(" select distinct sum(q.valor),q.ubica,q.poblacion,q.codconcepto,q.cuota  from (");
             //sql.append(" select distinct sum(re.ree_valor_pagado) valor ,ub.ubi_codigo ubica,pen.pen_poblac_total poblacion,");
             sql.append(" select distinct sum(re.ree_valor_pagado) valor ,ub.ubi_codigo ubica,Et.ETI_POBLACION poblacion,");
             sql.append(" cc.ccu_codigo codconcepto,Co.Cop_Codigo cuota");
             sql.append(" from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
             sql.append(" inner join sii_acuerdo_pago ac on co.apa_codigo = ac.apa_codigo");
             sql.append(" inner join sii_liquidacion_establ lq on re.les_codigo = lq.les_codigo");
             sql.append(" inner join sii_ubicacion ub on  lq.ubi_codigo_mun_est = ub.ubi_codigo");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo) ");
             //sql.append(" Inner Join sii_poblacion_ente pen on (et.eti_codigo = pen.eti_codigo)");
             sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
             sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo is null");
             //sql.append(" and ( Pen.Pen_Fecha_Ini <= to_Date('" + fechaLiq + "','dd/mm/yyyy') and pen.pen_fecha_fin >= to_Date('" +fechaLiq +"','dd/mm/yyyy') )");
             //sql.append(" group by ub.ubi_codigo,pen.pen_poblac_total , cc.ccu_codigo ,Co.Cop_Codigo)q  ");
             sql.append(" group by ub.ubi_codigo,Et.ETI_POBLACION , cc.ccu_codigo ,Co.Cop_Codigo)q  ");
             sql.append(" group by q.ubica,q.poblacion,q.codconcepto ,q.cuota");
             sql.append(" UNION");
             sql.append(" select  sum(r.valor), r.ubicacion,r.poblacion,r.codconcepto, r.cuota  from ");
             //sql.append(" (select distinct sum(re.ree_valor_pagado)valor, ub.ubi_codigo ubicacion,pen.pen_poblac_total poblacion,");
             sql.append(" (select distinct sum(re.ree_valor_pagado)valor, ub.ubi_codigo ubicacion,Et.ETI_POBLACION poblacion,");
             sql.append(" cc.ccu_codigo codconcepto, co.cop_codigo cuota");
             sql.append(" from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
             sql.append(" left Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (le.ubi_codigo_mun_est= ub.ubi_codigo) ");
             sql.append(" left Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
             //sql.append(" left Join sii_poblacion_ente pen on (et.eti_codigo = pen.eti_codigo)");
             sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
             sql.append(" and Cc.Cad_Codigo=1");
             sql.append(" and dd.dme_codigo is null");
             //sql.append(" and ( Pen.Pen_Fecha_Ini <= to_Date('" + fechaLiq + "','dd/mm/yyyy') and pen.pen_fecha_fin >= to_Date('" +fechaLiq +"','dd/mm/yyyy') )");
             sql.append(" group by dd.dde_valor_pagado, re.dde_codigo, Dd.Dde_Codigo");
             //sql.append(" ,ub.ubi_codigo,pen.pen_poblac_total,cc.ccu_codigo, co.cop_codigo");
             sql.append(" ,ub.ubi_codigo,Et.ETI_POBLACION,cc.ccu_codigo, co.cop_codigo");
             sql.append(" having sum(re.ree_valor_pagado) > 0)r");
             sql.append(" group by r.ubicacion,r.poblacion,r.codconcepto,r.cuota   )s");
             sql.append(" GROUP BY s.ubicacion,s.poblacion, s.codconcepto,s.cuota)t");
             sql.append("  GROUP BY t.ubicacion ,t.poblacion ");             
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             query.setParameter("idCategoria",idCategoria);
             //query.setParameter("fechaLiq",fechaLiq);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 RecaudoEnteVO vo = new RecaudoEnteVO(); 
                 vo.setTotalRecaudo((BigDecimal) object[0]);
                 vo.setUbicacion((String) object[1]);
                 vo.setPoblacion((BigDecimal) object[2]); 
                 //vo.setConceptoCuota(((BigDecimal) object[3]).longValue());                 
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    public List<RecaudoEnteVO> buscarValorRecaudoInteresTodosMunicipiosPorMesSinDdeCodigo(int mes, String pTipoCuota, Integer vigencia) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
         try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select sum(dde.dde_valor_pag_int) ,ub.ubi_codigo,et.ETI_POBLAC_P_2014");
             sql.append("  ,ccu.ccu_codigo, ccu.ccu_tipo,ccu.ccu_distribucion,dde.dde_codigo");
             sql.append(" from sii_detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo)");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
             sql.append(" Inner Join sii_liquidacion_establ le on (lm.lme_codigo = le.lme_codigo)");
             sql.append(" Inner Join sii_establecimiento es on (le.est_codigo = es.est_codigo)");             
             sql.append(" Inner Join sii_ubicacion ub on (es.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo) ");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigencia and dde.dme_codigo is null");             
             sql.append(" and ccu.ccu_modalidad='L' and Ccu.Ccu_Tipo=#pTipoCuota and dde.dme_codigo is null and dde.dde_valor_pag_int > 0");
             sql.append(" group by ub.ubi_codigo,et.ETI_POBLAC_P_2014 ,ccu.ccu_codigo, ccu.ccu_tipo,ccu.ccu_distribucion,dde.dde_codigo");
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             query.setParameter("pTipoCuota",pTipoCuota);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 RecaudoEnteVO vo = new RecaudoEnteVO(); 
                 vo.setTotalRecaudo((BigDecimal) object[0]);
                 vo.setUbicacion((String) object[1]);
                 vo.setPoblacion((BigDecimal) object[2]); 
                 vo.setConceptoCuota(((BigDecimal) object[3]).longValue());
                 vo.setTipoConceptoCuota((String) object[4]);
                 vo.setDistribucion((String) object[5]);
                 //vo.setDdeCodigo(((BigDecimal) object[6]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    public List<ReporteOperadorVO> buscarDistribucionMunicGeneradorPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
		 Long codDistribucion = new Long(0);
         try{               
			 List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
                   codDistribucion = distribucion.get(0).getDmeCodigo();
                  
             } 
			 StringBuilder sql = new StringBuilder();
			 sql.append(" select distinct s.depto,s.muni,s.dane, s.nit,s.razonSocial,sum(s.valor),s.coddepto FROM");
			 sql.append(" (select ub2.ubi_nombre depto,ub.ubi_nombre muni,ub.ubi_codigo dane,Per.Per_Num_Identificacion nit,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
			 sql.append(" sum(re.ree_valor_pagado)valor,ub2.ubi_codigo coddepto ,co.cop_num_cuota ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
			 sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo =#codDistribucion");
			 sql.append(" group by ub2.ubi_nombre ,ub.ubi_nombre ,ub.ubi_codigo ,Per.Per_Num_Identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,ub2.ubi_codigo,co.cop_num_cuota ");
			 sql.append(" having sum(re.ree_valor_pagado) > 0	");
			 sql.append(" UNION");
			 sql.append(" select distinct p.dep,p.mun,p.dan,p.iden,p.razon,sum(p.valor2),p.coddep,p.cop_num_cuota  from (");
			 sql.append(" select distinct ub2.ubi_nombre dep,ub.ubi_nombre mun,ub.ubi_codigo dan,Per.Per_Num_Identificacion iden,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razon,");
			 sql.append(" re.ree_valor_pagado valor2,ub2.ubi_codigo coddep,co.cop_num_cuota  ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" inner join sii_acuerdo_pago ac on co.apa_codigo = ac.apa_codigo");
			 sql.append(" inner join sii_liquidacion_establ lq on re.les_codigo = lq.les_codigo");
			 sql.append(" inner join sii_ubicacion ub on  lq.ubi_codigo_mun_est = ub.ubi_codigo");
			 sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo=#codDistribucion)p");
			 sql.append(" group by p.dep,p.mun,p.dan,p.iden,p.razon,p.coddep ,p.cop_num_cuota");
			 sql.append(" UNION");
			 sql.append(" select distinct ub2.ubi_nombre ,ub.ubi_nombre ,ub.ubi_codigo ,Per.Per_Num_Identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
			 sql.append(" sum(re.ree_valor_pagado) ,ub2.ubi_codigo ,co.cop_num_cuota");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)	");
			 sql.append(" left Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (le.ubi_codigo_mun_est= ub.ubi_codigo) ");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo=#codDistribucion");
			 sql.append(" group by ub2.ubi_nombre ,ub.ubi_nombre ,ub.ubi_codigo ,Per.Per_Num_Identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,ub2.ubi_codigo,co.cop_num_cuota");
			 sql.append(" having sum(re.ree_valor_pagado) > 0	 )s	");
			 sql.append(" GROUP BY s.depto,s.muni,s.dane, s.nit,s.razonSocial,s.coddepto");
			 			 
			 
			 /*sql.append(" select s.depto,s.muni, s.dane,s.nit,s.razonSocial, sum(s.valor),s.coddepto from");
			 sql.append(" (select ub2.ubi_nombre depto,ub.ubi_nombre muni,ub.ubi_codigo dane,Per.Per_Num_Identificacion nit,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
			 sql.append(" sum(re.ree_valor_pagado)valor,ub2.ubi_codigo coddepto");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
			 sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo=#codDistribucion");
			 sql.append(" group by ub2.ubi_nombre ,ub.ubi_nombre ,ub.ubi_codigo , Per.Per_Num_Identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) , ub2.ubi_codigo )s");
			 sql.append(" GROUP BY s.depto,s.muni, s.dane,s.nit,s.razonSocial, s.coddepto");
			 sql.append(" having sum(s.valor) >0");
			 sql.append(" order by 1,2,5");*/
			 			                
             
			 /*sql.append(" select Ub2.Ubi_Nombre depto,Ub.Ubi_Nombre muni,ub.ubi_codigo dane, Per.Per_Num_Identificacion nit, ");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonsocial");
             sql.append(" ,sum(re.ree_valor_pagado) recaudo,ub2.ubi_codigo codDepto");
             sql.append(" from sii_recaudo_establec re");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (re.dde_codigo =dd.dde_codigo )");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
             sql.append(" Inner Join sii_liquidacion_establ le on (re.les_codigo = le.les_codigo) ");
             sql.append(" Inner Join sii_establecimiento es on (le.est_codigo = es.est_codigo)");
             sql.append("Inner Join sii_ubicacion ub on (es.ubi_codigo = ub.ubi_codigo)");             
             sql.append(" Inner Join Sii_Distribucion_Mes dm on (dd.dme_codigo = dm.dme_codigo)");             
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo )");
             sql.append(" where Dm.Mes_Codigo = #mes and dm.dme_vigencia=#vigenciaReporte  and cc.cad_codigo = 1");
             sql.append(" group by Per.Per_Num_Identificacion , NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido)");
             sql.append(" ,ub2.ubi_codigo,Ub2.Ubi_Nombre ,Ub.Ubi_Nombre ,ub.ubi_codigo , Per.Per_Num_Identificacion ");             
             sql.append(" having sum (re.ree_valor_pagado) > 0");  
             sql.append(" order by 1,2");  */                                  
             
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes", mes);
			 query.setParameter("vigenciaReporte", vigenciaReporte);
			 query.setParameter("codDistribucion", codDistribucion);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setDepartamento((String) object[0]);
                 vo.setMunicipio((String) object[1]);
                 vo.setCodDane((String) object[2]);
                 vo.setNumeroIdentificacion((String) object[3]);
                 vo.setRazonSocial((String) object[4]);
                 vo.setValor((BigDecimal) object[5]);  
                 vo.setCodDepto((String) object[6]);
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    /*public List<ReporteDistribucionVO> buscarTransferenciaMunicipiosPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteDistribucionVO> lista = new ArrayList<ReporteDistribucionVO>();
         try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select Et.Eti_Codigo,ub2.ubi_nombre,ub.ubi_nombre,dd.ddi_valor_Rec ,dd.ddi_valor_prop ,dd.ddi_valor_todos ,dd.ddi_valor_detod");
             sql.append(" from sii_detalle_distrib dd");
             sql.append(" Inner Join sii_ente_Territorial et on (dd.eti_codigo = et.eti_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (et.ubi_codigo = ub.ubi_codigo )");
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo   )");
             sql.append(" Inner Join sii_distribucion_mes dm on (dd.dme_codigo= dm.dme_codigo)");
             sql.append(" where dm.dme_vigencia=#vigenciaReporte and dm.mes_codigo =#mes");
             sql.append(" order by Et.Eti_Codigo ");
                    
                                                    
             Query query = manager.createNativeQuery(sql.toString());             
                         
             query.setParameter("vigenciaReporte",vigenciaReporte);
             query.setParameter("mes",mes); 
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteDistribucionVO vo = new ReporteDistribucionVO(); 
                 vo.setCodEnteTerritorial(((BigDecimal) object[0]).longValue());
                 vo.setDepto((String) object[1]);
                 vo.setMunicipio((String) object[2]);                
                 vo.setValorRecaudado((BigDecimal) object[3]); 
                 vo.setValorPropio((BigDecimal) object[4]);
                 vo.setValorTodos((BigDecimal) object[5]);
                 vo.setValorDeTodos((BigDecimal) object[6]);
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }*/
    public List<RecaudoEnteVO> buscarValorRecaudoInteresMoraTodosMunicipiosPorMes(int mes, Integer vigencia) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
         try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select sum (s.valor),s.ubicacion,s.ente,s.codcuenta, s.tipocuenta, s.distri");
             sql.append(" from (select sum(dde.dde_valor_pag_int) valor ,ub.ubi_codigo ubicacion,et.ETI_POBLAC_P_2014 ente");
             sql.append(" ,ccu.ccu_codigo codcuenta, ccu.ccu_tipo tipocuenta,ccu.ccu_distribucion distri");
             sql.append(" from sii_detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo)");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
             sql.append(" Inner Join sii_liquidacion_establ le on (lm.lme_codigo = le.lme_codigo)");             
             sql.append(" Inner Join sii_establecimiento es on (le.est_codigo = es.est_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (es.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");             
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigencia and dde.dme_codigo is null");
             sql.append(" and ccu.ccu_modalidad='L' and Ccu.Ccu_Tipo='CU' and dde.dme_codigo is null and dde.dde_valor_pag_int > 0");
             sql.append(" group by ub.ubi_codigo,et.ETI_POBLAC_P_2014 ,ccu.ccu_codigo, ccu.ccu_tipo,ccu.ccu_distribucion,dde.dde_codigo");
             sql.append(" UNION ALL  ");
             sql.append(" select sum(dde.dde_valor_pag_int) ,ub.ubi_codigo,et.ETI_POBLAC_P_2014");
             sql.append(" ,ccu.ccu_codigo, ccu.ccu_tipo,ccu.ccu_distribucion");
             sql.append(" from sii_detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo)");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");             
             sql.append(" Inner Join sii_liquidacion_establ le on (lm.lme_codigo = le.lme_codigo)");
             sql.append(" Inner Join sii_establecimiento es on (le.est_codigo = es.est_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (es.ubi_codigo = ub.ubi_codigo)");             
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigencia and dde.dme_codigo is null");
             sql.append(" and ccu.ccu_modalidad='L' and Ccu.Ccu_Tipo='IM' and dde.dme_codigo is null and dde.dde_valor_pag_int > 0 ");
             sql.append(" group by ub.ubi_codigo,et.ETI_POBLAC_P_2014 ,ccu.ccu_codigo, ccu.ccu_tipo,ccu.ccu_distribucion,dde.dde_codigo) S");
             sql.append(" GROUP BY s.ubicacion,s.ente,s.codcuenta, s.tipocuenta, s.distri");
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);             
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 RecaudoEnteVO vo = new RecaudoEnteVO(); 
                 vo.setTotalRecaudo((BigDecimal) object[0]);
                 vo.setUbicacion((String) object[1]);
                 vo.setPoblacion((BigDecimal) object[2]); 
                 vo.setConceptoCuota(((BigDecimal) object[3]).longValue());
                 vo.setTipoConceptoCuota((String) object[4]);
                 vo.setDistribucion((String) object[5]);
                 //vo.setDdeCodigo(((BigDecimal) object[6]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    public List<ReporteDistribucionVO> generarReporteTransferenciaPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteDistribucionVO> lista = new ArrayList<ReporteDistribucionVO>();
         Long codDistribucion = new Long(0);
         try{ 
             List<SiiDistribucionMes> distribucion = this.buscarDistribucionAprobadaPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
                  codDistribucion = distribucion.get(0).getDmeCodigo();
                 
              }             
             
             StringBuilder sql = new StringBuilder(); 
             sql.append(" select  ub2.ubi_nombre depto,ub.ubi_nombre  muni,ub.ubi_codigo ubi_codigo,et.ETI_POBLAC_P_2014 poblacion ,");
             sql.append(" ddis.Ddi_Valor_Rec recaudo,ddis.Ddi_Valor_Prop propio,ddis.Ddi_Valor_Todos todos,ddis.Ddi_Valor_Detod detodos");
             sql.append(" from sii_detalle_distrib ddis ");
             sql.append(" Inner Join sii_distribucion_mes dm on (ddis.dme_codigo = dm.dme_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ddis.eti_codigo = et.eti_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (et.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.ubi_codigo_padre = ub2.ubi_codigo)");
             sql.append(" where Dm.Dme_Vigencia = #vigenciaReporte and Dm.Mes_Codigo=#mes and ddis.cad_codigo=1 and dm.dme_codigo =#codDistribucion");
             sql.append(" order by 3");
             
             /*sql.append(" select s.depto, s.muni, s.ubicodigo,sum(s.recaudo),s.poblacion, sum(s.detodos),s.interes,s.concepto,s.distribucion,s.propio from ");
             sql.append(" (select  distinct dm.dme_codigo dmecodigo,ub.ubi_codigo ubicodigo, ub2.ubi_nombre depto,ub.ubi_nombre  muni, ");
             sql.append(" et.eti_poblacion poblacion ,Dd.Ddi_Valor_Rec recaudo,Dd.Ddi_Valor_Prop propio,");
             sql.append(" Dd.Ddi_Valor_Todos todos,Dd.Ddi_Valor_Detod detodos,sum(Dde.Dde_Valor_Pag_Int) interes,ccu.ccu_abreviatura concepto, ccu.ccu_distribucion distribucion ");
             sql.append(" from sii_detalle_declaracion dde ");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
             sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
             sql.append(" Inner Join sii_liquidacion_establ le on (lm.lme_codigo = le.lme_codigo)");
             sql.append(" Inner Join sii_establecimiento es on (le.est_codigo = es.est_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (es.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
             sql.append(" Inner Join sii_detalle_distrib dd on (et.eti_codigo = dd.eti_codigo)");
             sql.append(" Inner Join sii_distribucion_mes dm on (dde.dme_codigo = dm.dme_Codigo)");
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.ubi_codigo_padre = ub2.ubi_codigo)");
             sql.append(" where Dm.Dme_Vigencia = #vigenciaReporte and Dm.Mes_Codigo=#mes ");
             sql.append(" group by ub.ubi_codigo , ub2.ubi_nombre ,ub.ubi_nombre  , et.eti_poblacion  ,Dd.Ddi_Valor_Rec ,Dd.Ddi_Valor_Prop ,");
             sql.append(" Dd.Ddi_Valor_Todos ,Dd.Ddi_Valor_Detod ,dm.dme_codigo,ccu.ccu_abreviatura , ccu.ccu_distribucion");
             sql.append(" UNION ALL");
             sql.append(" select  distinct dm.dme_codigo, ub.ubi_codigo ubicodigo, ub2.ubi_nombre depto,ub.ubi_nombre  muni, et.eti_poblacion poblacion ,Dd.Ddi_Valor_Rec recaudo,Dd.Ddi_Valor_Prop propio,");
             sql.append(" Dd.Ddi_Valor_Todos todos,Dd.Ddi_Valor_Detod detodos,0,'Ninguno','Ninguno'");
             sql.append(" from sii_detalle_distrib dd");
             sql.append(" Inner Join sii_ente_territorial et on (DD.eti_codigo = et.eti_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (et.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.ubi_codigo_padre = ub2.ubi_codigo)");
             sql.append(" Inner Join sii_distribucion_mes dm on (dd.dme_codigo = dm.dme_Codigo)");
             sql.append(" where Dm.Dme_Vigencia = #vigenciaReporte and Dm.Mes_Codigo=#mes and dd.ddi_codigo not in (");
             sql.append(" select  distinct dd.ddi_codigo");
             sql.append(" from sii_detalle_declaracion dde ");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
             sql.append(" Inner Join sii_liquidacion_establ le on (lm.lme_codigo = le.lme_codigo)");
             sql.append(" Inner Join sii_establecimiento es on (le.est_codigo = es.est_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (es.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
             sql.append(" Inner Join sii_detalle_distrib dd on (et.eti_codigo = dd.eti_codigo)");
             sql.append(" Inner Join sii_distribucion_mes dm on (dde.dme_codigo = dm.dme_Codigo)");
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.ubi_codigo_padre = ub2.ubi_codigo)");
             sql.append(" where Dm.Dme_Vigencia = #vigenciaReporte and Dm.Mes_Codigo=#mes");
             sql.append(" ) ) s"); 
             sql.append(" group by s.depto, s.muni, s.ubicodigo,s.poblacion,s.interes,s.concepto,s.distribucion,s.propio"); 
             sql.append(" order by s.depto, s.muni"); */
                                                    
             Query query = manager.createNativeQuery(sql.toString());             
                         
             query.setParameter("vigenciaReporte",vigenciaReporte);
             query.setParameter("mes",mes); 
             query.setParameter("codDistribucion",codDistribucion); 
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteDistribucionVO vo = new ReporteDistribucionVO();                 
                 vo.setDepto((String) object[0]);
                 vo.setMunicipio((String) object[1]);  
                 vo.setCodigoDane((String) object[2]);
                 vo.setPoblacion(((BigDecimal) object[3]).longValue());
                 vo.setValorRecaudado((BigDecimal) object[4]); 
                 vo.setValorPropio((BigDecimal) object[5]);
                 vo.setValorTodos((BigDecimal) object[6]);
                 vo.setValorDeTodos((BigDecimal) object[7]);
                 //vo.setValorRecaudoInteres((BigDecimal) object[6]);
                 //vo.setConcepto((String) object[7]);
                 //vo.setDistribucion((String) object[8]);
                 
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    public List<ReporteOperadorVO> buscarDistribucionConsolidadoOperadorPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
		 Long codDistribucion = new Long(0);
         try{ 
			List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
                  codDistribucion = distribucion.get(0).getDmeCodigo();
                 
              }  
          
             StringBuilder sql = new StringBuilder();
			 sql.append(" select distinct s.concepto,sum(s.valor),s.codconcepto FROM");
			 sql.append(" (select cc.ccu_abreviatura concepto, per.per_num_identificacion nit,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
			 sql.append(" sum(re.ree_valor_pagado)valor, cc.ccu_codigo codconcepto ,co.cop_num_cuota	");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
			 sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo)");
			 sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo =#codDistribucion");
			 sql.append(" group by cc.ccu_abreviatura , per.per_num_identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido),");
			 sql.append(" cc.ccu_codigo,co.cop_num_cuota");
			 sql.append(" having sum(re.ree_valor_pagado) > 0");
			 sql.append(" UNION");
			 sql.append(" select distinct p.conc,p.ident,p.razon,sum(p.valor2),p.codconce ,p.cop_num_cuota from (");
			 sql.append(" select distinct cc.ccu_abreviatura conc, per.per_num_identificacion ident,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razon,");
			 sql.append(" re.ree_valor_pagado valor2, cc.ccu_codigo codconce,co.cop_num_cuota ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" inner join sii_acuerdo_pago ac on co.apa_codigo = ac.apa_codigo");
			 sql.append(" inner join sii_liquidacion_establ lq on re.les_codigo = lq.les_codigo");
			 sql.append(" inner join sii_ubicacion ub on  lq.ubi_codigo_mun_est = ub.ubi_codigo");
			 sql.append(" Inner Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo) ");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo=#codDistribucion)p");
			 sql.append(" group by p.conc,p.ident,p.razon,p.codconce,p.cop_num_cuota");
			 sql.append(" UNION");
			 sql.append(" select distinct cc.ccu_abreviatura , per.per_num_identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
			 sql.append(" sum(re.ree_valor_pagado) , cc.ccu_codigo ,co.cop_num_cuota ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" left Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (le.ubi_codigo_mun_est= ub.ubi_codigo) ");
			 sql.append(" left Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo = #codDistribucion");
			 sql.append(" group by cc.ccu_abreviatura , per.per_num_identificacion ,");
			 sql.append("  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
			 sql.append(" cc.ccu_codigo,co.cop_num_cuota ");
			 sql.append(" having sum(re.ree_valor_pagado) > 0	 )s");
			 sql.append(" GROUP BY s.concepto,s.codconcepto");			 
			 
			 
			 			 /*sql.append(" select cc.ccu_abreviatura concepto,sum(re.ree_valor_pagado)valor,cc.ccu_codigo codconcepto");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
			 sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" left Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (per.ubi_codigo = ub.ubi_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo=#codDistribucion");
			 sql.append(" group by cc.ccu_abreviatura ,cc.ccu_codigo");*/
			 
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes", mes);
			 query.setParameter("vigenciaReporte", vigenciaReporte);
			 query.setParameter("codDistribucion", codDistribucion);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setConcepto((String) object[0]);                 
                 vo.setValor((BigDecimal) object[1]);                 
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }


public List<ReporteOperadorVO> buscarDistribucionMunicPorMesConsolidado(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
		 Long codDistribucion = new Long(0);
         try{
			 List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
               codDistribucion = distribucion.get(0).getDmeCodigo();
              
             }               
             StringBuilder sql = new StringBuilder();
			 sql.append(" select distinct s.depto,sum(s.valor),s.coddepto FROM");
			 sql.append(" (select ub2.ubi_nombre depto,ub.ubi_nombre muni,ub.ubi_codigo dane,Per.Per_Num_Identificacion nit,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
			 sql.append(" sum(re.ree_valor_pagado)valor,ub2.ubi_codigo coddepto ,co.cop_num_cuota  ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
			 sql.append(" Inner Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo =#codDistribucion");
			 sql.append(" group by ub2.ubi_nombre ,ub.ubi_nombre ,ub.ubi_codigo ,Per.Per_Num_Identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,ub2.ubi_codigo,co.cop_num_cuota ");
			 sql.append(" having sum(re.ree_valor_pagado) > 0	");
			 sql.append(" UNION");
			 sql.append(" select distinct p.dep,p.mun,p.dan,p.iden,p.razon,sum(p.valor2),p.coddep,p.cop_num_cuota from (");
			 sql.append(" select distinct ub2.ubi_nombre dep,ub.ubi_nombre mun,ub.ubi_codigo dan,Per.Per_Num_Identificacion iden,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razon,");
			 sql.append(" re.ree_valor_pagado valor2,ub2.ubi_codigo coddep ,co.cop_num_cuota  ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
			 sql.append(" inner join sii_acuerdo_pago ac on co.apa_codigo = ac.apa_codigo");
			 sql.append(" inner join sii_liquidacion_establ lq on re.les_codigo = lq.les_codigo");
			 sql.append(" inner join sii_ubicacion ub on  lq.ubi_codigo_mun_est = ub.ubi_codigo");
			 sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo=#codDistribucion)p");
			 sql.append(" group by p.dep,p.mun,p.dan,p.iden,p.razon,p.coddep ,p.cop_num_cuota");
			 sql.append(" UNION");
			 sql.append(" select distinct ub2.ubi_nombre ,ub.ubi_nombre ,ub.ubi_codigo ,Per.Per_Num_Identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
			 sql.append(" sum(re.ree_valor_pagado) ,ub2.ubi_codigo ,co.cop_num_cuota  ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)	");
			 sql.append(" left Join Sii_Liquidacion_Establ le on (re.les_codigo = le.les_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub on (le.ubi_codigo_mun_est= ub.ubi_codigo) ");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
			 sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo=#codDistribucion");
			 sql.append(" group by ub2.ubi_nombre ,ub.ubi_nombre ,ub.ubi_codigo ,Per.Per_Num_Identificacion ,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '");
			 sql.append(" ||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,ub2.ubi_codigo,co.cop_num_cuota ");
			 sql.append(" having sum(re.ree_valor_pagado) > 0	 )s	");
			 sql.append(" GROUP BY s.depto,s.coddepto");
			 			 
			 
			 /*sql.append (" select s.depto,sum(recaudo),s.codDepto from");
             sql.append(" (select distinct Ub2.Ubi_Nombre depto,(sum(Re.Ree_Valor_Pagado)-dd.dde_valor_pag_int)  recaudo");             
             sql.append(" ,ub2.ubi_codigo codDepto");
             sql.append(" from  sii_Detalle_declaracion dd");
             sql.append(" Inner Join sii_recaudo_establec re on (dd.dde_codigo = re.dde_codigo)");
             sql.append(" Inner join sii_distribucion_mes dm on (dd.dme_codigo = dd.dme_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_persona per on (op.per_codigo = per.per_codigo)");
             sql.append(" Inner Join sii_liquidacion_establ le on (re.les_codigo = le.les_codigo) ");
             sql.append(" Inner Join sii_establecimiento es on (le.est_codigo = es.est_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (es.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.Ubi_Codigo_Padre = ub2.ubi_codigo  ) ");
             sql.append(" where Cc.Cad_Codigo=1 and dd.dme_codigo =#codDistribucion ");
             sql.append(" group by Ub2.Ubi_Nombre,ub2.ubi_codigo,dd.dde_valor_pag_int)s");      
             sql.append(" GROUP BY s.depto,s.codDepto"); 
		     sql.append(" order by 1");  */         
             
			 
			
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes", mes); 
			 query.setParameter("vigenciaReporte", vigenciaReporte); 
			 query.setParameter("codDistribucion", codDistribucion);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setDepartamento((String) object[0]);                 
                 vo.setValor((BigDecimal) object[1]);  
                 vo.setCodDepto((String) object[2]);
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    public int anularDistribucionMes(Long idDistribucion) throws ExcepcionDAO, ExcepcionAplicacion {
        int resultado = 0;
        try{             
            StringBuilder sql = new StringBuilder();             
            sql.append(" update sii_detalle_declaracion set dme_codigo = null where dme_codigo = #idDistribucion");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idDistribucion",idDistribucion); 
            resultado = query.executeUpdate();
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
            return resultado;
    }
    public List<ReporteDistribucionVO> buscarRecaudoInteresPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteDistribucionVO> lista = new ArrayList<ReporteDistribucionVO>();
         Long codDistribucion = new Long(0);
         try{ 
             
             StringBuilder sql = new StringBuilder(); 
             sql.append(" select distinct sum(dde.DDE_VALOR_PAG_INT), per.ubi_codigo");
             sql.append(" from sii_Detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo)");
             sql.append(" Inner Join sii_Contrato c on (lm.con_codigo = c.con_codigo)");
             sql.append(" Inner Join sii_operador op on (c.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo)");
             sql.append(" Inner Join sii_distribucion_mes dm on (dde.dme_codigo = dm.dme_codigo)");
             sql.append(" where dm.dme_vigencia= #vigenciaReporte and dm.mes_codigo =#mes and dde.dde_valor_pag_int> 0");
             sql.append(" group by per.ubi_codigo");
             
                                                    
             Query query = manager.createNativeQuery(sql.toString());             
                         
             query.setParameter("vigenciaReporte",vigenciaReporte);
             query.setParameter("mes",mes); 
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteDistribucionVO vo = new ReporteDistribucionVO(); 
                 vo.setValorRecaudoInteresMora((BigDecimal) object[0]);                 
                 vo.setCodigoDane((String) object[1]);                 
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    public List<ReporteDistribucionVO> buscarTransferenciaInteresPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteDistribucionVO> lista = new ArrayList<ReporteDistribucionVO>();
         Long codDistribucion = new Long(0);
         try{ 
             List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
                  codDistribucion = distribucion.get(0).getDmeCodigo();
                 
              }  
             
             StringBuilder sql = new StringBuilder(); 
             sql.append(" select s.ubi_codigo,sum(s.detodos) from ");
             sql.append(" (select distinct ub.ubi_codigo ubi_codigo,ddis.Ddi_Valor_Detod detodos");
             sql.append(" from sii_detalle_distrib ddis");
             sql.append(" Inner Join sii_distribucion_mes dm on (ddis.dme_codigo = dm.dme_codigo)");
             sql.append(" Inner Join sii_detalle_declaracion dde on (dm.dme_codigo = dde.dme_codigo)");
             sql.append(" Inner Join Sii_Ente_Territorial et on (ddis.eti_codigo = et.eti_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (et.ubi_codigo = ub.ubi_codigo)");
             sql.append(" Inner Join sii_ubicacion ub2 on (ub.ubi_codigo_padre = ub2.ubi_codigo)");
             sql.append(" where Dm.Dme_Vigencia = #vigenciaReporte and Dm.Mes_Codigo=#mes");
             sql.append(" and dde.dde_codigo  in (");
             sql.append(" select dde_codigo from sii_Detalle_declaracion d");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = d.dre_codigo)");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (d.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigenciaReporte");
             sql.append(" and ccu.ccu_modalidad='L' and Ccu.Ccu_Tipo='CU'");
             sql.append(" and d.dde_valor_pag_int> 0 and dme_codigo = #codDistribucion ))s");
             sql.append(" group by s.ubi_codigo");
             sql.append(" order by ubi_codigo");             
                                                    
             Query query = manager.createNativeQuery(sql.toString());             
                         
             query.setParameter("vigenciaReporte",vigenciaReporte);
             query.setParameter("mes",mes);
             query.setParameter("codDistribucion",codDistribucion); 
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteDistribucionVO vo = new ReporteDistribucionVO();
                 vo.setCodigoDane((String) object[0]); 
                 vo.setValorRecaudoInteresMora((BigDecimal) object[1]);                 
                                 
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    public List<RecaudoEnteVO> buscarValorRecaudoInteresPorMesVigenciaTipoCuota(int mes, Integer vigencia, String pBandera, String pReporte) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
		 BigDecimal totalRecaudo = new BigDecimal(0);
         try{             
             StringBuilder sql = new StringBuilder(); 
             sql.append(" select sum(s.valor)");
             if(pBandera.equals("conDDE")){
                sql.append(", s.ddecodigo ");
             }
             sql.append(" FROM (select cc.ccu_codigo codconcepto,cc.ccu_abreviatura concepto,");
             sql.append(" Per.Per_Num_Identificacion NIT,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
             sql.append(" sum(dd.dde_valor_pag_int)valor , ubi.ubi_codigo ubicacion");
             if(pBandera.equals("conDDE")){
                sql.append(", dd.dde_codigo ddecodigo");
             }
             sql.append(" from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo) ");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo) ");
             sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo) ");
             sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo) ");
             sql.append(" left Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
             sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
             sql.append(" and Cc.Cad_Codigo=1");
             if(pReporte.equals("NO")){
                     sql.append(" and dd.dme_codigo is null ");
             }             
             sql.append(" group by cc.ccu_codigo ,cc.ccu_abreviatura ,");
             sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido)");
             sql.append(" ,ubi.ubi_codigo,cc.ccu_codigo, ubi.ubi_codigo");
             if(pBandera.equals("conDDE")){
                     sql.append(" ,  dde_codigo ");
             }
             sql.append(" UNION ALL");
             sql.append(" select cc.ccu_codigo ,cc.ccu_abreviatura ,");
             sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
             sql.append(" SUM(dde.dde_valor_pagado)  , ubi.ubi_codigo");
             if(pBandera.equals("conDDE")){
                     sql.append(" ,  dde.dde_codigo ");
             }
             sql.append(" from sii_detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo) ");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo)");
             sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo)");
             sql.append(" left Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigencia");
             sql.append(" and cc.cad_codigo = 6");
             if(pReporte.equals("NO")){
                     sql.append(" and dde.dme_codigo is null  ");
             }
             sql.append(" group by cc.ccu_codigo ,cc.ccu_abreviatura ,");
             sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) , ubi.ubi_codigo" );
             if(pBandera.equals("conDDE")){
                     sql.append(" ,  dde_codigo ");
             }
             sql.append(")s");
             if(pBandera.equals("conDDE")){
                     sql.append("  group by s.ddecodigo  "); 
             }
             

			/*sql.append(" select sum(s.valor)    ");
			if(pBandera.equals("conDDE")){
                sql.append(", s.ddecodigo ");
             }
			sql.append(" from (select sum(dde_valor_pag_int) as valor  ");
			if(pBandera.equals("conDDE")){
			sql.append(" , dde_codigo ddecodigo");
			}
			sql.append(" FROM (select distinct dd.dde_codigo, dd.dde_valor_pag_int	");
			sql.append(" from vw_det_rec_rba_rps_aju  pp");
			sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			sql.append(" inner Join sii_liquidacion_mes lm on (co.lme_codigo = lm.lme_codigo) ");
			sql.append(" inner Join Sii_Liquidacion_Establ le on (lm.lme_codigo = le.lme_codigo)");
			sql.append(" inner  Join sii_establecimiento est on (le.est_codigo = est.est_codigo)");
			sql.append(" left Join sii_ubicacion ub on (est.ubi_codigo = ub.ubi_codigo) ");
			sql.append(" left Join sii_ente_territorial et on (ub.ubi_codigo = et.ubi_codigo)");
			sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')= #vigencia");
			sql.append(" and Cc.Cad_Codigo=1  		");
			if(pReporte.equals("NO")){
				sql.append(" and dd.dme_codigo is null )");
			}else{
				sql.append(")");
			}
			if(pBandera.equals("conDDE")){
				sql.append(" group by  dde_codigo ");
			}
			sql.append(" UNION ALL");
			sql.append(" select SUM(dde.dde_valor_pagado)");
			if(pBandera.equals("conDDE")){
				sql.append(" ,Dde.Dde_Codigo");
			}
			sql.append(" from sii_detalle_declaracion dde ");
			sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
			sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
			sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo)");
			sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo) ");
			sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigencia ");
			sql.append(" and ccu.cad_codigo = 6  ");
			if(pReporte.equals("NO")){
				sql.append(" and dde.dme_codigo is null  ");
			}
			if(pBandera.equals("conDDE")){
				sql.append(" group by Dde.Dde_Codigo");
			
			}
			sql.append(" having sum (dde.dde_valor_pagado) > 0)s 	");
			if(pBandera.equals("conDDE")){
				sql.append("  group by s.ddecodigo  ");	
			}
			sql.append(" having sum (s.valor) > 0");*/
               
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             if(pBandera.equals("conDDE")){
                 List<Object[]> results = query.getResultList();
                 for(Object[] object : results){
                     RecaudoEnteVO vo = new RecaudoEnteVO();
                     vo.setTotalRecaudo((BigDecimal) object[0]);                     
                     vo.setDdeCodigo(((BigDecimal) object[1]).longValue());                    
                     lista.add(vo);
                 }
             }else {
                 totalRecaudo = (BigDecimal)query.getSingleResult();
                 RecaudoEnteVO vo = new RecaudoEnteVO();
                 vo.setTotalRecaudo(totalRecaudo);
                 lista.add(vo);
             
             }              
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    public List<RecaudoEnteVO> buscarValorRecaudoIFPorMesVigenciaTipoCuota(int mes, Integer vigencia, String pBandera, String pReporte) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
		 BigDecimal totalRecaudo = new BigDecimal(0);
         try{             
             StringBuilder sql = new StringBuilder();               
             sql.append(" select SUM(dde.dde_valor_pagado ) valor");
             if(pBandera.equals("conDDE")){
                sql.append(" ,dde.dde_codigo");
             }             
             sql.append(" from sii_detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo)");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigencia");            
             if(pReporte.equals("NO")){
                sql.append(" and dde.dme_codigo is null");
             }
             sql.append(" and ccu.cad_codigo = 7");             
             if(pBandera.equals("conDDE")){
                sql.append(" group by dde.dde_codigo ");
             }                              
             Query query = manager.createNativeQuery(sql.toString());             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             
            if(pBandera.equals("conDDE")){
                 List<Object[]> results = query.getResultList();
                 for(Object[] object : results){
                     RecaudoEnteVO vo = new RecaudoEnteVO();
                     vo.setTotalRecaudo((BigDecimal) object[0]);                     
                     vo.setDdeCodigo(((BigDecimal) object[1]).longValue());                    
                     lista.add(vo);
                 }
             }else {
                 totalRecaudo = (BigDecimal)query.getSingleResult();
				 if(totalRecaudo!= null){
	                 RecaudoEnteVO vo = new RecaudoEnteVO();
	                 vo.setTotalRecaudo(totalRecaudo);
	                 lista.add(vo);
				 }
             
             }       
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    /**
     * Obtiene la transferencia de intereses de mora dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of ReporteDistribucionVO
     * @throws ExcepcionDAO
     */
    public List<ReporteDistribucionVO> buscarTransferenciaInteresMoraPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteDistribucionVO> lista = new ArrayList<ReporteDistribucionVO>();
         Long codDistribucion = new Long(0);
         try{              
             StringBuilder sql = new StringBuilder(); 
             sql.append(" select ub.ubi_codigo,ddis.Ddi_Valor_Detod detodos");
             sql.append(" from sii_detalle_distrib ddis");
             sql.append(" Inner Join sii_distribucion_mes dm on (ddis.dme_codigo = dm.dme_Codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ddis.eti_codigo = et.eti_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (et.ubi_codigo = ub.ubi_codigo)");
             sql.append(" where Dm.Dme_Vigencia = #vigenciaReporte and Dm.Mes_Codigo=#mes and ddis.cad_codigo = 6");
             sql.append(" order by 1");
                                                    
             Query query = manager.createNativeQuery(sql.toString());             
                         
             query.setParameter("vigenciaReporte",vigenciaReporte);
             query.setParameter("mes",mes);
             
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteDistribucionVO vo = new ReporteDistribucionVO();
                 vo.setCodigoDane((String) object[0]); 
                 vo.setValorDeTodos((BigDecimal) object[1]);                 
                                 
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    
    /**
     * Obtiene la transferencia de intereses de financiación dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of ReporteDistribucionVO
     * @throws ExcepcionDAO
     */
    public List<ReporteDistribucionVO> buscarTransferenciaInteresFinanciacionPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteDistribucionVO> lista = new ArrayList<ReporteDistribucionVO>();
         Long codDistribucion = new Long(0);
         try{              
             StringBuilder sql = new StringBuilder(); 
             sql.append(" select ub.ubi_codigo,ddis.Ddi_Valor_Detod detodos");
             sql.append(" from sii_detalle_distrib ddis");
             sql.append(" Inner Join sii_distribucion_mes dm on (ddis.dme_codigo = dm.dme_Codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ddis.eti_codigo = et.eti_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (et.ubi_codigo = ub.ubi_codigo)");
             sql.append(" where Dm.Dme_Vigencia = #vigenciaReporte and Dm.Mes_Codigo=#mes and ddis.cad_codigo = 7");
             
                                                    
             Query query = manager.createNativeQuery(sql.toString());             
                         
             query.setParameter("vigenciaReporte",vigenciaReporte);
             query.setParameter("mes",mes);
             
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteDistribucionVO vo = new ReporteDistribucionVO();
                 vo.setCodigoDane((String) object[0]); 
                 vo.setValorDeTodos((BigDecimal) object[1]);                 
                                 
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    /**
     * Obtiene el recaudo de intereses de mora para el reporte de distribucion por operador dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of ReporteOperadorVO
     * @throws ExcepcionDAO
     */
    public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
		 Long codDistribucion = new Long(0);
         try{             
			List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
               codDistribucion = distribucion.get(0).getDmeCodigo();
              
             }  
			 StringBuilder sql = new StringBuilder();
			 sql.append(" select s.concepto,s.NIT,S.Razonsocial,sum(s.valor) , s.ubicacion");
			 sql.append(" FROM (select cc.ccu_codigo codconcepto,cc.ccu_abreviatura concepto,");
			 sql.append(" Per.Per_Num_Identificacion NIT,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
			 sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
			 sql.append(" sum(dd.dde_valor_pag_int)valor , ubi.ubi_codigo ubicacion			 ");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo) ");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo) ");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo) ");
			 sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo)   ");
			 sql.append(" left Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
			 sql.append(" and Cc.Cad_Codigo=1 ");
			 sql.append(" group by cc.ccu_codigo ,cc.ccu_abreviatura ,");
			 sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
			 sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) 			");
			 sql.append(" ,ubi.ubi_codigo,Et.ETI_POBLAC_P_2014,cc.ccu_codigo, ubi.ubi_codigo ");
			 sql.append(" UNION ALL");
			 sql.append(" select cc.ccu_codigo ,cc.ccu_abreviatura ,");
			 sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
			 sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
			 sql.append(" SUM(dde.dde_valor_pagado)  , ubi.ubi_codigo ");
			 sql.append(" from sii_detalle_declaracion dde ");
			 sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo) ");
			 sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo)");
			 sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo)  ");
			 sql.append(" left Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
			 sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigenciaReporte");
			 sql.append(" and cc.cad_codigo = 6 ");
			 sql.append("  group by cc.ccu_codigo ,cc.ccu_abreviatura ,");
			 sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
			 sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) , ubi.ubi_codigo  )s 	");
			 sql.append(" GROUP BY s.concepto,s.NIT,S.Razonsocial, s.ubicacion ");
			 sql.append(" having sum (s.valor) > 0 ");
			 
			
			 /*sql.append(" select s.concepto,s.NIT,S.Razonsocial, sum (s.valor), s.ubicacion");
             sql.append(" from (select ccu.ccu_codigo codconcepto,ccu.ccu_abreviatura concepto,");
             sql.append(" Per.Per_Num_Identificacion NIT,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
             sql.append(" SUM(dde.dde_valor_pag_int) valor, ubi.ubi_codigo ubicacion ");
             sql.append(" from sii_detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)  ");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)  ");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo)  ");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo) ");
             sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo) ");
             sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo)  ");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigenciaReporte");
             sql.append(" and ccu.ccu_codigo = 1 and dde.dme_codigo=#codDistribucion ");
             sql.append(" group by ccu.ccu_codigo ,ccu.ccu_abreviatura ,Per.Per_Num_Identificacion ,");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,ubi.ubi_codigo");
             sql.append(" UNION ALL");
             sql.append(" select ccu.ccu_codigo ,ccu.ccu_abreviatura , Per.Per_Num_Identificacion ,  ");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||  per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||");
             sql.append(" per.per_segundo_apellido) , SUM(dde.dde_valor_pagado) , ubi.ubi_codigo");
             sql.append(" from sii_detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo)");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo)");
             sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo)");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigenciaReporte");
             sql.append(" and ccu.cad_codigo = 6 and dde.dme_codigo=#codDistribucion");
             sql.append(" group by ccu.ccu_codigo ,ccu.ccu_abreviatura ,Per.Per_Num_Identificacion ,");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,ubi.ubi_codigo )s");                         
             sql.append(" having sum (s.valor) > 0");
             sql.append(" GROUP BY s.concepto,s.NIT,S.Razonsocial, s.ubicacion");*/
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigenciaReporte",vigenciaReporte);
			 query.setParameter("codDistribucion",codDistribucion);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setConcepto((String) object[0]);
                 vo.setNumeroIdentificacion((String) object[1]);
                 vo.setRazonSocial((String) object[2]);
                 vo.setValor((BigDecimal) object[3]);
                 vo.setCodDane((String) object[4]);                 
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    
    /**
     * Obtiene el recaudo consolidado de intereses de mora para el reporte de distribucion por operador dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of ReporteOperadorVO
     * @throws ExcepcionDAO
     */
    public List<ReporteOperadorVO> buscarConsolidadoReporteRecaudoInteresMoraOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
		 Long codDistribucion = new Long(0);
         try{             
			List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
                codDistribucion = distribucion.get(0).getDmeCodigo();
               
              } 
             StringBuilder sql = new StringBuilder(); 
			 sql.append(" select s.concepto,sum(s.valor) , s.codconcepto");
			 sql.append(" FROM (select cc.ccu_codigo codconcepto,cc.ccu_abreviatura concepto,");
			 sql.append(" Per.Per_Num_Identificacion NIT,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
			 sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
			 sql.append(" sum(dd.dde_valor_pag_int)valor , ubi.ubi_codigo ubicacion	");
			 sql.append(" from vw_det_rec_rba_rps_aju  pp");
			 sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
			 sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo) ");
			 sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo)");
			 sql.append(" left Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
			 sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte ");
			 sql.append(" and Cc.Cad_Codigo=1");
			 sql.append(" group by cc.ccu_codigo ,cc.ccu_abreviatura ,");
			 sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
			 sql.append("  per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido)");
			 sql.append(" ,ubi.ubi_codigo,Et.ETI_POBLAC_P_2014,cc.ccu_codigo, ubi.ubi_codigo ");
			 sql.append(" UNION ALL");
			 sql.append(" select cc.ccu_codigo ,cc.ccu_abreviatura ,");
			 sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
			 sql.append("  per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
			 sql.append(" SUM(dde.dde_valor_pagado)  , ubi.ubi_codigo ");
			 sql.append(" from sii_detalle_declaracion dde  ");
			 sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
			 sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
			 sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo) ");
			 sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
			 sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
			 sql.append("  Inner Join sii_persona per on (op.per_codigo= per.per_codigo) ");
			 sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo)");
			 sql.append(" left Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
			 sql.append(" where to_char(pp.fecha_recaudo,'MM') =#mes and to_char(pp.fecha_recaudo,'YYYY') = #vigenciaReporte");
			 sql.append(" and cc.cad_codigo = 6");
			 sql.append(" group by cc.ccu_codigo ,cc.ccu_abreviatura ,");
			 sql.append(" Per.Per_Num_Identificacion ,  NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
			 sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) , ubi.ubi_codigo  )s");
			 sql.append(" GROUP BY s.concepto, s.codconcepto ");
			 sql.append(" having sum (s.valor) > 0  ");
			 
			 
			 
			 
/*sql.append(" select s.concepto, sum (s.valor), S.Codconcepto");
             sql.append(" from (select ccu.ccu_codigo codconcepto,ccu.ccu_abreviatura concepto, Per.Per_Num_Identificacion NIT, ");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial,");
             sql.append(" SUM(dde.dde_valor_pag_int) valor, ubi.ubi_codigo ubicacion ");
             sql.append(" from sii_detalle_declaracion dde ");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo)");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo)");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo)");
             sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo)");
             sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo) ");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigenciaReporte and dde.dme_codigo=#codDistribucion");
             sql.append(" and ccu.ccu_codigo = 1 and dde.dme_codigo=#codDistribucion");
             sql.append(" group by ubi.ubi_codigo,ccu.ccu_abreviatura,ccu.ccu_codigo,Per.Per_Num_Identificacion ,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ");
             sql.append(" UNION ALL");
             sql.append(" select ccu.ccu_codigo ,ccu.ccu_abreviatura , Per.Per_Num_Identificacion , ");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) ,");
             sql.append(" SUM(dde.dde_valor_pagado) , ubi.ubi_codigo");
             sql.append(" from sii_detalle_declaracion dde");
             sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota ccu on (co.ccu_codigo = ccu.ccu_codigo) ");
             sql.append(" Inner join sii_detalle_recaudo dr on (dr.dre_codigo = dde.dre_codigo) ");
             sql.append(" Inner Join vw_det_rec_rba_rps_aju  pp on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_operador op on (co.ope_codigo = op.ope_codigo) ");
             sql.append(" Inner Join sii_persona per on (op.per_codigo= per.per_codigo)");
             sql.append(" Inner Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo) ");
             sql.append(" where to_char(pp.fecha_recaudo,'MM') = #mes and to_char(pp.fecha_recaudo,'YYYY') = #vigenciaReporte");
             sql.append(" and ccu.cad_codigo = 6  and dde.dme_codigo=#codDistribucion");
             sql.append(" group by ubi.ubi_codigo,ccu.ccu_abreviatura,ccu.ccu_codigo,Per.Per_Num_Identificacion ,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '|| ");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) )s ");             
             sql.append(" having sum (s.valor) > 0");
             sql.append(" GROUP BY s.concepto, S.Codconcepto");  */
            
			 
			 
                          
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigenciaReporte",vigenciaReporte);
			 query.setParameter("codDistribucion",codDistribucion);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setConcepto((String) object[0]);                 
                 vo.setValor((BigDecimal) object[1]); 
                 vo.setCodConcepto(((BigDecimal) object[2]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    /**
     * Obtiene el recaudo de Rifas dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of RecaudoEnteVO
     * @throws ExcepcionDAO
     */
    public List<RecaudoEnteVO> buscarValorRecaudoRifasPorMes(int mes, Integer vigencia, String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList();
		 RecaudoEnteVO vari = new RecaudoEnteVO();
         BigDecimal total = new BigDecimal(0);
         try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select abs(sum(valor)) from ");
             sql.append(" (select sum(NVL(ic.imc_valor,0)) valor");
             sql.append(" from sii_imputacion_contable ic");
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2");
             sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4");
             sql.append(" and cc.cco_nivel5=#nivel5");
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia"); 
             sql.append(" and Ic.Imc_Tipo_Movim='D' and dc.edo_codigo =2");             
             sql.append(" UNION ALL");
             sql.append(" select -sum(NVL(ic.imc_valor,0))");
             sql.append(" from sii_imputacion_contable ic");             
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2");             
             sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4");
             sql.append(" and cc.cco_nivel5=#nivel5");             
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia "); 
             sql.append(" and Ic.Imc_Tipo_Movim='C' and dc.edo_codigo =2)");
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             query.setParameter("nivel1",nivel1);
             query.setParameter("nivel2",nivel2);
             query.setParameter("nivel3",nivel3);
             query.setParameter("nivel4",nivel4);
             query.setParameter("nivel5",nivel5);
            
             
             total = (BigDecimal)query.getSingleResult();
             if(total!= null ){
                vari.setTotalRecaudo(total);
                lista.add(vari); 
            }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    
    /**
     * Obtiene la transferencia de promocionales-  rifas - hipicos y gallisticos - actuaciones administrativas,  dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @param categoría - categoría de distribución.
     * @return List of ReporteDistribucionVO
     * @throws ExcepcionDAO
     */
    public List<ReporteDistribucionVO> buscarTransferenciaPorMesVigenciaYCategoria(int mes,Integer vigenciaReporte,Long idCategoria) throws ExcepcionDAO {         
         List<ReporteDistribucionVO> lista = new ArrayList<ReporteDistribucionVO>();
         Long codDistribucion = new Long(0);
         try{              
             StringBuilder sql = new StringBuilder(); 
             sql.append(" select ub.ubi_codigo,ddis.Ddi_Valor_Detod detodos,ddi_valor_prop");
             sql.append(" from sii_detalle_distrib ddis");
             sql.append(" Inner Join sii_distribucion_mes dm on (ddis.dme_codigo = dm.dme_Codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ddis.eti_codigo = et.eti_codigo)");
             sql.append(" Inner Join sii_ubicacion ub on (et.ubi_codigo = ub.ubi_codigo)");
             sql.append(" where Dm.Dme_Vigencia = #vigenciaReporte and Dm.Mes_Codigo=#mes and ddis.cad_codigo = #idCategoria");
             sql.append(" order by 1");
                                                    
             Query query = manager.createNativeQuery(sql.toString());             
                         
             query.setParameter("vigenciaReporte",vigenciaReporte);
             query.setParameter("mes",mes);
             query.setParameter("idCategoria",idCategoria);
             
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteDistribucionVO vo = new ReporteDistribucionVO();
                 vo.setCodigoDane((String) object[0]); 
                 vo.setValorDeTodos((BigDecimal) object[1]); 
				 vo.setValorPropio((BigDecimal) object[2]);
                                 
                 lista.add(vo);               
             }             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
	     public List<RecaudoEnteVO> buscarValorRecaudoPromocionales(int mes, Integer vigencia, String bandera) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>(); 
		 BigDecimal totalRecaudo = new BigDecimal(0);
         try{             
             StringBuilder sql = new StringBuilder();             
             
             sql.append(" select sum(pp.dre_Valor) valor");
             if(bandera.equals("conDDE"))
                 sql.append(" , dd.dde_codigo");
             sql.append(" from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join Sii_Rifa_Promocional rp on (co.rfp_codigo =rp.rfp_codigo)");
             sql.append(" Inner Join Sii_Solicitud_Autoriza sa on (rp.sau_codigo = sa.sau_codigo)");
             sql.append(" Inner Join Sii_Estado_Solic_Autoriz esa on (sa.esa_codigo = esa.esa_codigo)");
             sql.append(" Inner Join sii_detalle_trasl_banc dt on (rp.rfp_codigo = dt.rfp_codigo)");
             sql.append(" Inner Join sii_traslado_bancario tb on (dt.tba_codigo = tb.tba_codigo) where ");			 
             //sql.append("   to_char(pp.fecha_recaudo,'MM') <= #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
             sql.append(" Cc.Cad_Codigo=2 and dd.dme_codigo is null and esa.esa_codigo = 8"); 
             //sql.append(" and to_char(rp.rfp_fecha_resol,'MM') <= #mes and to_char(rp.rfp_fecha_resol,'YYYY')= #vigencia");
             sql.append(" and to_char(tb.tba_fecha,'MM') <= #mes and to_char(tb.tba_fecha,'YYYY') =#vigencia and dt.dtb_concepto='DEP'");
             sql.append(" ");
             if(bandera.equals("conDDE"))
                 sql.append(" group by  dd.dde_codigo");
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);             
             
             if(bandera.equals("conDDE")){
                List<Object[]> results = query.getResultList();
                for(Object[] object : results){
                     RecaudoEnteVO vo = new RecaudoEnteVO(); 
                     vo.setTotalRecaudo((BigDecimal) object[0]);
                     if(bandera.equals("conDDE")){
                            vo.setDdeCodigo(((BigDecimal) object[1]).longValue());
                     }
                     lista.add(vo); 
                 }
             }else {  
                    totalRecaudo = (BigDecimal)query.getSingleResult();
					if(totalRecaudo!= null){
						RecaudoEnteVO vo = new RecaudoEnteVO(); 
						vo.setTotalRecaudo(totalRecaudo);                    
						lista.add(vo);
					}						
                     
                }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }

public List<ReporteOperadorVO> buscarValorRecaudoPromocionalesReporte(int mes, Integer vigencia) throws ExcepcionDAO {         
    List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
    BigDecimal totalRecaudo = new BigDecimal(0);
    Long codDistribucion = new Long(0);
    try{
    StringBuilder sql = new StringBuilder(); 
        
    List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigencia);
    if(distribucion!= null && distribucion.size()> 0){
         codDistribucion = distribucion.get(0).getDmeCodigo();
        
     }   
    
    sql.append(" select cc.ccu_abreviatura,per.per_num_identificacion, ");    
    sql.append(" NVL(per.per_jur_nombre_largo,per.per_primer_nombre||' '||per.per_primer_apellido),");
    sql.append(" sum(pp.dre_Valor) valor  , ubi.ubi_codigo");
    sql.append(" from vw_det_rec_rba_rps_aju  pp");
    sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
    sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");    
    sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
    sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)"); 
    sql.append(" Inner Join Sii_Rifa_Promocional rp on (co.rfp_codigo =rp.rfp_codigo)");
    sql.append(" Inner Join Sii_Solicitud_Autoriza sa on (rp.sau_codigo = sa.sau_codigo)");    
    sql.append(" Inner Join Sii_Estado_Solic_Autoriz esa on (sa.esa_codigo = esa.esa_codigo)");	
    sql.append(" left outer Join sii_persona per on (sa.per_codigo_rif = per.per_codigo)"); 
    sql.append(" left outer Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo) where ");    
    sql.append(" Cc.Cad_Codigo=2 and dd.dme_codigo= #codDistribucion and esa.esa_codigo = 8 ");
    sql.append(" group by cc.ccu_abreviatura,per.per_num_identificacion,");
	sql.append(" NVL(per.per_jur_nombre_largo,per.per_primer_nombre||' '||per.per_primer_apellido),ubi.ubi_codigo");
    	
                              
    Query query = manager.createNativeQuery(sql.toString());
    
    query.setParameter("mes",mes);
    query.setParameter("vigencia",vigencia); 
    query.setParameter("codDistribucion",codDistribucion);    
    
    List<Object[]> results = query.getResultList();
    for(Object[] object : results){
        ReporteOperadorVO vo = new ReporteOperadorVO(); 
        vo.setConcepto((String) object[0]);
        vo.setNumeroIdentificacion((String) object[1]);
        vo.setRazonSocial((String) object[2]);
        vo.setValor((BigDecimal) object[3]);
        vo.setCodDane((String) object[4]);                 
        lista.add(vo);               
    }
       
    
    }catch(PersistenceException pe){
    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
    throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
    }
    return lista;
 }
    /**
     * Obtiene el recaudo consolidado de promocionales por operador dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of ReporteOperadorVO
     * @throws ExcepcionDAO
     */
    public List<ReporteOperadorVO> buscarConsolidadoReportePromocionalesOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
         Long codDistribucion = new Long(0);
         try{             
             List<SiiDistribucionMes> distribucion = this.buscarDistribucionPorMesYVigencia(mes, vigenciaReporte);
             if(distribucion!= null && distribucion.size()> 0){
                codDistribucion = distribucion.get(0).getDmeCodigo();
               
              } 
             StringBuilder sql = new StringBuilder();             
             sql.append(" select cc.ccu_abreviatura, sum(pp.dre_Valor) valor  , cc.ccu_codigo");
             sql.append("  from vw_det_rec_rba_rps_aju  pp");
             sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
             sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
             sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
             sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
             sql.append(" Inner Join Sii_Rifa_Promocional rp on (co.rfp_codigo =rp.rfp_codigo)");
             sql.append(" Inner Join Sii_Solicitud_Autoriza sa on (rp.sau_codigo = sa.sau_codigo)");
             sql.append(" Inner Join Sii_Estado_Solic_Autoriz esa on (sa.esa_codigo = esa.esa_codigo)");
            //sql.append(" and to_char(rp.rfp_fecha_resol,'MM') <= #mes and to_char(rp.rfp_fecha_resol,'YYYY')= #vigenciaReporte");
             sql.append(" left outer Join sii_persona per on (sa.per_codigo_rif = per.per_codigo)");
             sql.append(" left outer Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo) where ");
             //sql.append(" where  to_char(pp.fecha_recaudo,'MM') <= #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigenciaReporte");
             sql.append(" Cc.Cad_Codigo=2 and dd.dme_codigo= #codDistribucion and esa.esa_codigo = 8");
             sql.append(" group by cc.ccu_abreviatura,cc.ccu_codigo ");
                        
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigenciaReporte",vigenciaReporte);
             query.setParameter("codDistribucion",codDistribucion);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setConcepto((String) object[0]);                 
                 vo.setValor((BigDecimal) object[1]); 
                 vo.setCodConcepto(((BigDecimal) object[2]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
	    /**
     * Obtiene el recaudo de intereses de mora de actuaciones administrativas para el reporte de distribucion por operador dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of ReporteOperadorVO
     * @throws ExcepcionDAO
     */
    public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraConsolidadoActAdmOperadorPorMesYVigencia(int mes,Integer vigenciaReporte, String nivel1,
                                                                                                String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
                
         try{             
                        
             StringBuilder sql = new StringBuilder();
			 
			 sql.append(" select s.concepto,abs(sum(valor)),s.codConcepto  from");
             sql.append(" (select 130 codConcepto,'IMACT' concepto,Per.Per_Num_Identificacion nit,");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonsocial,ic.imc_valor valor, per.ubi_codigo ubicacion");
             sql.append(" from sii_imputacion_contable ic");
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
			 sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" left Join sii_persona per on (ic.per_codigo = per.per_codigo)");
             sql.append(" left Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo) ");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2");
             sql.append(" and cc.cco_nivel3=#nivel3");
			 sql.append(" and cc.cco_nivel4=#nivel4");
             sql.append(" and cc.cco_nivel5=#nivel5");
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigenciaReporte");
             sql.append(" and Ic.Imc_Tipo_Movim='D' and dc.edo_codigo =2");
             sql.append(" UNION ALL");
             sql.append(" select 130 codConcepto,'IMACT' concepto, Per.Per_Num_Identificacion nit,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonsocial,");
             sql.append(" -ic.imc_valor, per.ubi_codigo ubicacion");
             sql.append(" from sii_imputacion_contable ic ");
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
			 sql.append(" left Join sii_persona per on (ic.per_codigo = per.per_codigo)");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2 ");
             sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4");
			 sql.append(" and cc.cco_nivel5=#nivel5");
			 sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigenciaReporte");
             sql.append(" and Ic.Imc_Tipo_Movim='C' and dc.edo_codigo =2)s");
             sql.append("  GROUP BY  s.concepto,s.codConcepto");
			 
			
                         
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigenciaReporte",vigenciaReporte);             
             query.setParameter("nivel1",nivel1);
             query.setParameter("nivel2",nivel2);
             query.setParameter("nivel3",nivel3);
             query.setParameter("nivel4",nivel4);
             query.setParameter("nivel5",nivel5);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO();                 
                 vo.setConcepto((String) object[0]);                 
                 vo.setValor((BigDecimal) object[1]); 
                 vo.setCodConcepto(((BigDecimal) object[2]).longValue());                                
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
	 /**
     * Obtiene el recaudo de intereses de mora de actuaciones administrativas para el reporte de distribucion por operador dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of ReporteOperadorVO
     * @throws ExcepcionDAO
     */
    public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraActAdmOperadorPorMesYVigencia(int mes,Integer vigenciaReporte, String nivel1,
                                                                                                String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
                
         try{             
                        
             StringBuilder sql = new StringBuilder();
             sql.append(" select s.concepto, s.nit,s.razonsocial,abs(sum(valor)),s.ubicacion  from");
             sql.append(" (select 130 codConcepto,'IMACT' concepto,Per.Per_Num_Identificacion nit,");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonsocial,ic.imc_valor valor, per.ubi_codigo ubicacion");
             sql.append(" from sii_imputacion_contable ic");
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
			 sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" left Join sii_persona per on (ic.per_codigo = per.per_codigo)");
             sql.append(" left Join sii_ubicacion ubi on (per.ubi_codigo = ubi.ubi_codigo) ");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2");
             sql.append(" and cc.cco_nivel3=#nivel3");
			 sql.append(" and cc.cco_nivel4=#nivel4");
             sql.append(" and cc.cco_nivel5=#nivel5");
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigenciaReporte");
             sql.append(" and Ic.Imc_Tipo_Movim='D' and dc.edo_codigo =2");
             sql.append(" UNION ALL");
             sql.append(" select 130 codConcepto,'IMACT' concepto, Per.Per_Num_Identificacion nit,");
			 sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||");
             sql.append(" per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonsocial,");
             sql.append(" -ic.imc_valor, per.ubi_codigo ubicacion");
             sql.append(" from sii_imputacion_contable ic ");
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
			 sql.append(" left Join sii_persona per on (ic.per_codigo = per.per_codigo)");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2 ");
             sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4");
			  sql.append(" and cc.cco_nivel5=#nivel5");
			 sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigenciaReporte");
             sql.append(" and Ic.Imc_Tipo_Movim='C' and dc.edo_codigo =2)s");
             sql.append("  GROUP BY  s.nit,s.razonsocial,s.concepto,s.ubicacion");
                                      
                                                    
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigenciaReporte",vigenciaReporte);             
             query.setParameter("nivel1",nivel1);
             query.setParameter("nivel2",nivel2);
             query.setParameter("nivel3",nivel3);
             query.setParameter("nivel4",nivel4);
             query.setParameter("nivel5",nivel5);
                          
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setConcepto((String) object[0]);
                 vo.setNumeroIdentificacion((String) object[1]);
                 vo.setRazonSocial((String) object[2]);
                 vo.setValor((BigDecimal) object[3]);
                 vo.setCodDane((String) object[4]);                 
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
	 /**
     * Obtiene el recaudo de Rifas dado un mes y una vigencia para mostrar en el reporte.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of RecaudoEnteVO
     * @throws ExcepcionDAO
     */
    public List<ReporteOperadorVO> buscarValorRecaudoRifasPorMesReporte(int mes, Integer vigencia, String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5,String concepto) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
		 try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select 'Rifas',s.nit,s.razonSocial,abs(sum(s.valor)) from ");
             sql.append(" (select sum(ic.imc_valor) valor,per.per_num_identificacion nit,");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial");
             sql.append(" from sii_imputacion_contable ic");
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" Inner Join sii_persona per on (ic.per_codigo=per.per_codigo)");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2");
             sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4"); 
             sql.append(" and cc.cco_nivel5=#nivel5");             
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia");
             sql.append(" and Ic.Imc_Tipo_Movim='D'");
             sql.append(" group by per.per_num_identificacion,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido)");             
             sql.append(" UNION ALL");
             sql.append(" select -sum(ic.imc_valor),per.per_num_identificacion nit,");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial");
             sql.append(" from sii_imputacion_contable ic");             
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" Inner Join sii_persona per on (ic.per_codigo=per.per_codigo)");             
             sql.append(" where cc.cco_nivel1=#nivel1"); 
             sql.append(" and cc.cco_nivel2=#nivel2");
			 sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4");
             sql.append(" and cc.cco_nivel5=#nivel5");             
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia");
             sql.append(" and Ic.Imc_Tipo_Movim='C'");
             sql.append(" group by per.per_num_identificacion,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||");             
             sql.append(" per.per_primer_apellido||' ' ||per.per_segundo_apellido))s"); 
             sql.append(" GROUP BY s.nit,s.razonSocial,'Rifas'");
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             query.setParameter("nivel1",nivel1);
             query.setParameter("nivel2",nivel2);
             query.setParameter("nivel3",nivel3);
             query.setParameter("nivel4",nivel4);
             query.setParameter("nivel5",nivel5);
            
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setConcepto(concepto);
                 vo.setNumeroIdentificacion((String) object[1]);
                 vo.setRazonSocial((String) object[2]);
                 vo.setValor((BigDecimal) object[3]);                 
                 //vo.setCodConcepto(((BigDecimal) object[4]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
	  /**
     * Obtiene el recaudo Consolidado de Rifas dado un mes y una vigencia para mostrar en el reporte.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of RecaudoEnteVO
     * @throws ExcepcionDAO
     */
    public List<ReporteOperadorVO> buscarValorRecaudoRifasConsolidadoPorMesReporte(int mes, Integer vigencia, String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5, String concepto) throws ExcepcionDAO {         
         List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
		 try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select 'Rifas',abs(sum(s.valor)) from ");
             sql.append(" (select sum(ic.imc_valor) valor,per.per_num_identificacion nit,");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial");
             sql.append(" from sii_imputacion_contable ic");
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" Inner Join sii_persona per on (ic.per_codigo=per.per_codigo)");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2");
             sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4"); 
             sql.append(" and cc.cco_nivel5=#nivel5");             
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia");
             sql.append(" and Ic.Imc_Tipo_Movim='D'");
             sql.append(" group by per.per_num_identificacion,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido)");             
             sql.append(" UNION ALL");
             sql.append(" select -sum(ic.imc_valor),per.per_num_identificacion nit,");
             sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial");
             sql.append(" from sii_imputacion_contable ic");             
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" Inner Join sii_persona per on (ic.per_codigo=per.per_codigo)");             
             sql.append(" where cc.cco_nivel1=#nivel1"); 
             sql.append(" and cc.cco_nivel2=#nivel2");
			 sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4");
             sql.append(" and cc.cco_nivel5=#nivel5");             
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia");
             sql.append(" and Ic.Imc_Tipo_Movim='C'");
             sql.append(" group by per.per_num_identificacion,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||");             
             sql.append(" per.per_primer_apellido||' ' ||per.per_segundo_apellido))s"); 
             sql.append(" GROUP BY 'Rifas'");
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             query.setParameter("nivel1",nivel1);
             query.setParameter("nivel2",nivel2);
             query.setParameter("nivel3",nivel3);
             query.setParameter("nivel4",nivel4);
             query.setParameter("nivel5",nivel5);
            
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 ReporteOperadorVO vo = new ReporteOperadorVO(); 
                 vo.setConcepto(concepto);                 
                 vo.setValor((BigDecimal) object[1]);                 
                 //vo.setCodConcepto(((BigDecimal) object[4]).longValue());
                 lista.add(vo);               
             }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
      
    /**
     * Obtiene la Distribucion aprobada dado un mes y una vigencia.
     * @param pMes - mes de distribución.
     * @param pVigencia - vigencia de distribución.
     * @return List of SiiDistribucionMes
     * @throws ExcepcionDAO
     */
    public List<SiiDistribucionMes> buscarDistribucionAprobadaPorMesYVigencia (int pMes, int pVigencia ) throws ExcepcionDAO {
        List<SiiDistribucionMes> resultado = null;        
        
        try {
            // falta por crear los dos campos mes y vigencia en la tabla sii_distribucion_mes :(
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDistribucionMes o INNER JOIN o.siiMes mes");
            sql.append(" INNER JOIN o.siiEstadoDistribEnte est WHERE mes.mesCodigo=:pMes and o.dmeVigencia=:pVigencia");
            sql.append(" and est.edeCodigo = 2");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pMes", pMes);
            query.setParameter("pVigencia", pVigencia);
            
            resultado = query.getResultList();
            
        }
        catch(PersistenceException pe){            
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
       
        
        return (resultado);
    }
	 
 //********************

 public List<RecaudoEnteVO> buscarPagosSinRecaudoEstablecimientoPorMesYVigencia(int mes, Integer vigencia) throws ExcepcionDAO {         
      List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
      try{             
          StringBuilder sql = new StringBuilder();             
          sql.append(" select dd.dde_codigo, Dd.Dde_Valor_Pagado");
          sql.append(" from vw_det_rec_rba_rps_aju  pp");
          sql.append(" Inner join sii_detalle_recaudo dr on (pp.dre_codigo = dr.dre_codigo)");
          sql.append(" Inner Join sii_Detalle_declaracion dd on (dr.dre_codigo = dd.dre_codigo)");
          sql.append(" Inner Join sii_cuota_operador co on (dd.cop_codigo = co.cop_codigo)");
          sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
          sql.append(" where  to_char(pp.fecha_recaudo,'MM') = #mes and  to_char(pp.fecha_recaudo,'YYYY')=#vigencia");
          sql.append(" and Cc.Cad_Codigo=1 and dd.dme_codigo is null");
          sql.append(" and dd.dde_codigo not in (select dde_codigo from sii_recaudo_establec)");          
          sql.append (" and Dd.Dde_Valor_Pagado > 0");                          
          Query query = manager.createNativeQuery(sql.toString());
          
          query.setParameter("mes",mes);
          query.setParameter("vigencia",vigencia);         
          
          List<Object[]> results = query.getResultList();
          for(Object[] object : results){
              RecaudoEnteVO vo = new RecaudoEnteVO();
              vo.setDdeCodigo(((BigDecimal) object[0]).longValue());
              vo.setTotalRecaudo((BigDecimal) object[1]);              
              lista.add(vo);               
          }
          
          
          
      }catch(PersistenceException pe){
          String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
          throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DistribucionMesDAO");
      }
      return lista;
  }
 
 //***************
 public List<RecaudoEnteVO> buscarValorRecaudoActAdmTodosMunicipiosPorMesSinARaCodigo(int mes, Integer vigencia, String fechaLiq) throws ExcepcionDAO {         
          List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
          try{             
              StringBuilder sql = new StringBuilder();  
              sql.append(" SELECT sum(s.valor),s.ubicacion,s.poblacion FROM");
              sql.append(" ( select sum(asr.asr_valor) valor, asr.ubi_codigo ubicacion,Et.ETI_POBLACION poblacion");
              sql.append(" from sii_asig_recaudo_aa_establ asr");
              sql.append(" Inner Join sii_asignacion_recaudo_aa ara on (asr.ara_codigo = ara.ara_codigo)");
              sql.append(" Inner Join sii_ubicacion ubi on (asr.ubi_codigo = ubi.ubi_codigo)");
              sql.append(" Inner Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
              //sql.append(" Inner Join sii_poblacion_ente pen on (et.eti_codigo = pen.eti_codigo)");
              sql.append(" where  to_char(ara.ara_fecha_pago,'MM') = #mes and  to_char(ara.ara_fecha_pago,'YYYY')=#vigencia");
              sql.append(" and ara.dme_codigo is null");
              //sql.append(" and ( Pen.Pen_Fecha_Ini <= to_Date('" + fechaLiq + "','dd/mm/yyyy') and pen.pen_fecha_fin >= to_Date('" +fechaLiq +"','dd/mm/yyyy') )");
              //sql.append(" group by asr.ubi_codigo ,pen.pen_poblac_total ) s");
              sql.append(" group by asr.ubi_codigo ,Et.ETI_POBLACION ) s");
              sql.append(" GROUP BY s.ubicacion,s.poblacion");               
                                        
              Query query = manager.createNativeQuery(sql.toString());
              
              query.setParameter("mes",mes);
              query.setParameter("vigencia",vigencia);
              //query.setParameter("fechaLiq",fechaLiq);
              
              List<Object[]> results = query.getResultList();
              for(Object[] object : results){
                  RecaudoEnteVO vo = new RecaudoEnteVO(); 
                  vo.setTotalRecaudo((BigDecimal) object[0]);
                  vo.setUbicacion((String) object[1]);
                  vo.setPoblacion((BigDecimal) object[2]); 
                  //vo.setConceptoCuota(((BigDecimal) object[3]).longValue());                 
                  lista.add(vo);               
              }
              
          }catch(PersistenceException pe){
              String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
              throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DistribucionMesDAO");
          }
          return lista;
      }
 
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmTodosMunicipiosPorMesConARaCodigo(int mes, Integer vigencia, String fechaLiq) throws ExcepcionDAO {         
             List<RecaudoEnteVO> lista = new ArrayList<RecaudoEnteVO>();
             try{             
                 StringBuilder sql = new StringBuilder();             
                 sql.append(" SELECT sum(s.valor),s.ubicacion,s.poblacion, s.araCodigo FROM");
                 //sql.append(" ( select sum(asr.asr_valor) valor, asr.ubi_codigo ubicacion,pen.pen_poblac_total poblacion,ara.ara_codigo araCodigo");
                 sql.append(" ( select sum(asr.asr_valor) valor, asr.ubi_codigo ubicacion,Et.ETI_POBLACION poblacion,ara.ara_codigo araCodigo");
                 sql.append(" from sii_asig_recaudo_aa_establ asr");
                 sql.append(" Inner Join sii_asignacion_recaudo_aa ara on (asr.ara_codigo = ara.ara_codigo)");
                 sql.append(" Inner Join sii_ubicacion ubi on (asr.ubi_codigo = ubi.ubi_codigo)");
                 sql.append(" Inner Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
                 //sql.append(" Inner Join sii_poblacion_ente pen on (et.eti_codigo = pen.eti_codigo)");
                 sql.append(" where  to_char(ara.ara_fecha_pago,'MM') = #mes and  to_char(ara.ara_fecha_pago,'YYYY')=#vigencia");
                 sql.append(" and ara.dme_codigo is null");
                 //sql.append(" and ( Pen.Pen_Fecha_Ini <= to_Date('" + fechaLiq + "','dd/mm/yyyy') and pen.pen_fecha_fin >= to_Date('" +fechaLiq +"','dd/mm/yyyy') )");
                 //sql.append(" group by asr.ubi_codigo ,pen.pen_poblac_total ,ara.ara_codigo ) s");
                 sql.append(" group by asr.ubi_codigo ,Et.ETI_POBLACION ,ara.ara_codigo ) s");
                 sql.append(" GROUP BY s.ubicacion,s.poblacion, s.araCodigo");                                    
                 
                                           
                 Query query = manager.createNativeQuery(sql.toString());
                 
                 query.setParameter("mes",mes);
                 query.setParameter("vigencia",vigencia);
                 //query.setParameter("fechaLiq",fechaLiq);
                 
                 List<Object[]> results = query.getResultList();
                 for(Object[] object : results){
                     RecaudoEnteVO vo = new RecaudoEnteVO(); 
                     vo.setTotalRecaudo((BigDecimal) object[0]);
                     vo.setUbicacion((String) object[1]);
                     vo.setPoblacion((BigDecimal) object[2]); 
                     vo.setDdeCodigo(((BigDecimal) object[3]).longValue());                 
                     lista.add(vo);               
                 }
                 
             }catch(PersistenceException pe){
                 String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                 throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DistribucionMesDAO");
             }
             return lista;
         }
    //****************************** ojo
    /**
    * Obtiene el recaudo de Actuaciones administrativas dado un mes y una vigencia para mostrar en el reporte.
    * @param mes - mes de distribución.
    * @param vigenciaReporte - vigencia de distribución.
    * @return List of RecaudoEnteVO
    * @throws ExcepcionDAO
    */
    public List<ReporteOperadorVO> buscarValorRecaudoActAdmPorMesVigenciaReporte(int mes, Integer vigencia, String concepto, String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {         
    List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
            try{             
        StringBuilder sql = new StringBuilder();             
        sql.append(" select 'Actuaciones Administrativas',s.nit,s.razonSocial,abs(sum(s.valor)) from ");
        sql.append(" (select sum(ic.imc_valor) valor,per.per_num_identificacion nit,");
        sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial");
        sql.append(" from sii_imputacion_contable ic");
        sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
        sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
        sql.append(" Inner Join sii_persona per on (ic.per_codigo=per.per_codigo)");
        sql.append(" where cc.cco_nivel1=#nivel1");
        sql.append(" and cc.cco_nivel2=#nivel2");
        sql.append(" and cc.cco_nivel3=#nivel3");
        sql.append(" and cc.cco_nivel4=#nivel4"); 
        sql.append(" and cc.cco_nivel5=#nivel5");             
        sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia");
        sql.append(" and Ic.Imc_Tipo_Movim='D' and dc.edo_codigo =2");
        sql.append(" group by per.per_num_identificacion,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido)");             
        sql.append(" UNION ALL");
        sql.append(" select -sum(ic.imc_valor),per.per_num_identificacion nit,");
        sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial");
        sql.append(" from sii_imputacion_contable ic");             
        sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
        sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
        sql.append(" Inner Join sii_persona per on (ic.per_codigo=per.per_codigo)");             
        sql.append(" where cc.cco_nivel1=#nivel1"); 
        sql.append(" and cc.cco_nivel2=#nivel2");
                    sql.append(" and cc.cco_nivel3=#nivel3");
        sql.append(" and cc.cco_nivel4=#nivel4");
        sql.append(" and cc.cco_nivel5=#nivel5");             
        sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia");
        sql.append(" and Ic.Imc_Tipo_Movim='C' and dc.edo_codigo =2");
        sql.append(" group by per.per_num_identificacion,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||");             
        sql.append(" per.per_primer_apellido||' ' ||per.per_segundo_apellido))s"); 
        sql.append(" GROUP BY s.nit,s.razonSocial,'Rifas'");
                                  
        Query query = manager.createNativeQuery(sql.toString());
        
        query.setParameter("mes",mes);
        query.setParameter("vigencia",vigencia); 
        query.setParameter("nivel1",nivel1);
        query.setParameter("nivel2",nivel2);
        query.setParameter("nivel3",nivel3);
        query.setParameter("nivel4",nivel4);
        query.setParameter("nivel5",nivel5);
        
       
        List<Object[]> results = query.getResultList();
        for(Object[] object : results){
            ReporteOperadorVO vo = new ReporteOperadorVO(); 
            vo.setConcepto(concepto);
            vo.setNumeroIdentificacion((String) object[1]);
            vo.setRazonSocial((String) object[2]);
            vo.setValor((BigDecimal) object[3]);                 
            //vo.setCodConcepto(((BigDecimal) object[4]).longValue());
            lista.add(vo);               
        }
        
        
        
    }catch(PersistenceException pe){
        String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
        throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
    }
    return lista;
    }
    
    
    
    /**
    * Obtiene el recaudo Consolidado de Rifas dado un mes y una vigencia para mostrar en el reporte.
    * @param mes - mes de distribución.
    * @param vigenciaReporte - vigencia de distribución.
    * @return List of RecaudoEnteVO
    * @throws ExcepcionDAO
    */
    public List<ReporteOperadorVO> buscarValorRecaudoActAdmConsolidadoPorMesReporte(int mes, Integer vigencia, String concepto,String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {         
    List<ReporteOperadorVO> lista = new ArrayList<ReporteOperadorVO>();
           try{             
       StringBuilder sql = new StringBuilder();             
       sql.append(" select 'Rifas',abs(sum(s.valor)) from ");
       sql.append(" (select sum(ic.imc_valor) valor,per.per_num_identificacion nit,");
       sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial");
       sql.append(" from sii_imputacion_contable ic");
       sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
       sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
       sql.append(" Inner Join sii_persona per on (ic.per_codigo=per.per_codigo)");
       sql.append(" where cc.cco_nivel1=#nivel1");
       sql.append(" and cc.cco_nivel2=#nivel2");
       sql.append(" and cc.cco_nivel3=#nivel3");
       sql.append(" and cc.cco_nivel4=#nivel4"); 
       sql.append(" and cc.cco_nivel5=#nivel5");             
       sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia");
       sql.append(" and Ic.Imc_Tipo_Movim='D' and dc.edo_codigo =2");
       sql.append(" group by per.per_num_identificacion,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido)");             
       sql.append(" UNION ALL");
       sql.append(" select -sum(ic.imc_valor),per.per_num_identificacion nit,");
       sql.append(" NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||per.per_primer_apellido||' ' ||per.per_segundo_apellido) razonSocial");
       sql.append(" from sii_imputacion_contable ic");             
       sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
       sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
       sql.append(" Inner Join sii_persona per on (ic.per_codigo=per.per_codigo)");             
       sql.append(" where cc.cco_nivel1=#nivel1"); 
       sql.append(" and cc.cco_nivel2=#nivel2");
                   sql.append(" and cc.cco_nivel3=#nivel3");
       sql.append(" and cc.cco_nivel4=#nivel4");
       sql.append(" and cc.cco_nivel5=#nivel5");             
       sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia");
       sql.append(" and Ic.Imc_Tipo_Movim='C' and dc.edo_codigo =2");
       sql.append(" group by per.per_num_identificacion,NVL(Per.Per_Jur_Nombre_Largo,per.per_primer_nombre||' '||per.per_segundo_nombre||' '||");             
       sql.append(" per.per_primer_apellido||' ' ||per.per_segundo_apellido))s"); 
       sql.append(" GROUP BY 'Rifas'");
                                 
       Query query = manager.createNativeQuery(sql.toString());
       
       query.setParameter("mes",mes);
       query.setParameter("vigencia",vigencia);
        query.setParameter("nivel1",nivel1);
        query.setParameter("nivel2",nivel2);
        query.setParameter("nivel3",nivel3);
        query.setParameter("nivel4",nivel4);
        query.setParameter("nivel5",nivel5);
      
      
       List<Object[]> results = query.getResultList();
       for(Object[] object : results){
           ReporteOperadorVO vo = new ReporteOperadorVO(); 
           vo.setConcepto(concepto);                 
           vo.setValor((BigDecimal) object[1]);                 
           //vo.setCodConcepto(((BigDecimal) object[4]).longValue());
           lista.add(vo);               
       }
       
       
       
    }catch(PersistenceException pe){
       String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
       throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
    }
    return lista;
    }
	
	public List<RecaudoEnteVO> buscarValorRecaudoActAdmPorMesValidacion(int mes, Integer vigencia) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList();
                 RecaudoEnteVO vari = new RecaudoEnteVO();
         BigDecimal total = new BigDecimal(0);
         try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select sum(asr.asr_valor) valor");
             sql.append(" from sii_asig_recaudo_aa_establ asr");
             sql.append(" Inner Join sii_asignacion_recaudo_aa ara on (asr.ara_codigo = ara.ara_codigo)");
             sql.append(" Inner Join sii_ubicacion ubi on (asr.ubi_codigo = ubi.ubi_codigo)");
             sql.append(" Inner Join sii_ente_territorial et on (ubi.ubi_codigo = et.ubi_codigo)");
             sql.append(" where  to_char(ara.ara_fecha_pago,'MM') = #mes and  to_char(ara.ara_fecha_pago,'YYYY')=#vigencia");
             sql.append(" and ara.dme_codigo is null");
             
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             
            
             
             total = (BigDecimal)query.getSingleResult();
             if(total!= null ){
                vari.setTotalRecaudo(total);
                lista.add(vari); 
            }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
    /**
     * Obtiene el recaudo de Rifas dado un mes y una vigencia.
     * @param mes - mes de distribución.
     * @param vigenciaReporte - vigencia de distribución.
     * @return List of RecaudoEnteVO
     * @throws ExcepcionDAO
     */
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmPorMesYVigencia(int mes, Integer vigencia, String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {         
         List<RecaudoEnteVO> lista = new ArrayList();
                 RecaudoEnteVO vari = new RecaudoEnteVO();
         BigDecimal total = new BigDecimal(0);
         try{             
             StringBuilder sql = new StringBuilder();             
             sql.append(" select abs(sum(valor)) from ");
             sql.append(" (select sum(NVL(ic.imc_valor,0)) valor");
             sql.append(" from sii_imputacion_contable ic");
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2");
             sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4");
             sql.append(" and cc.cco_nivel5=#nivel5");
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia"); 
             sql.append(" and Ic.Imc_Tipo_Movim='D' and dc.edo_codigo =2");             
             sql.append(" UNION ALL");
             sql.append(" select -sum(NVL(ic.imc_valor,0))");
             sql.append(" from sii_imputacion_contable ic");             
             sql.append(" Inner Join sii_cuentas_contables cc on (ic.cco_codigo = cc.cco_codigo)");
             sql.append(" Inner Join sii_documento_contable dc on (ic.dco_codigo = dc.dco_codigo)");
             sql.append(" where cc.cco_nivel1=#nivel1");
             sql.append(" and cc.cco_nivel2=#nivel2");             
             sql.append(" and cc.cco_nivel3=#nivel3");
             sql.append(" and cc.cco_nivel4=#nivel4");
             sql.append(" and cc.cco_nivel5=#nivel5");             
             sql.append(" and to_char(dc.dco_fecha_oper,'MM') = #mes and to_char(dc.dco_fecha_oper,'YYYY') = #vigencia "); 
             sql.append(" and Ic.Imc_Tipo_Movim='C' and dc.edo_codigo =2)");
                                       
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("mes",mes);
             query.setParameter("vigencia",vigencia);
             query.setParameter("nivel1",nivel1);
             query.setParameter("nivel2",nivel2);
             query.setParameter("nivel3",nivel3);
             query.setParameter("nivel4",nivel4);
             query.setParameter("nivel5",nivel5);
            
             
             total = (BigDecimal)query.getSingleResult();
             if(total!= null ){
                vari.setTotalRecaudo(total);
                lista.add(vari); 
            }
             
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return lista;
     }
}
