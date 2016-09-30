package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.InteresCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.ValidacionInteresVO;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

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
public class InteresCuotaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public InteresCuotaDAO() {
        recursos = new Recursos();
    }
    
    public SiiInteresCuota buscarInteresCuotaPorId(Long icuCodigo) throws ExcepcionDAO {
        SiiInteresCuota siiInteresCuota = null;
        try {
            siiInteresCuota = manager.find(SiiInteresCuota.class, icuCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiInteresCuota;
    }

    public SiiInteresCuota insertarSiiInteresCuota(SiiInteresCuota interes) throws ExcepcionDAO {
        try {
            manager.persist(interes);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return interes;
    }

    public SiiInteresCuota actualizarSiiInteresCuota(SiiInteresCuota siiInteresCuota) throws ExcepcionDAO {
        try {
            siiInteresCuota = manager.merge(siiInteresCuota);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiInteresCuota;
    }

    public List<SiiInteresCuota> buscarInteresesXRefPago(Long idRefPago) throws ExcepcionDAO {
        List<SiiInteresCuota> listaSiiInteresCuota = new ArrayList<SiiInteresCuota>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select ic.icu_codigo,ic.icu_valor,ic.icu_fecha,ic.icu_base_calc,ic.icu_tasa_aplic,ic.icu_cancelado,ic.icu_valor_pagado,ic.cop_codigo ");
            sql.append(" from sii_contrato c ");
            sql.append(" inner join sii_liquidacion_mes lm on (c.con_codigo = lm.con_codigo) ");
            sql.append(" inner join sii_cuota_operador co on (lm.lme_codigo = co.lme_codigo)   ");
            sql.append(" inner join sii_interes_cuota ic on (co.cop_codigo = ic.cop_codigo) ");
            sql.append(" inner join sii_detalle_declaracion dd on (co.cop_codigo = dd.cop_codigo) ");
            sql.append(" inner join sii_referencia_pago_decl refe on  refe.rpd_codigo = dd.rpd_codigo ");
            sql.append(" where refe.rpd_numero = #idRefPago and ic.icu_cancelado='N'");
            // sql.append(" group by co.cop_valor");
            sql.append(" order by 3 asc ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRefPago", idRefPago);

            List<Object[]> results = query.getResultList();

            for (Object[] object : results) {
                SiiInteresCuota unSiiInteresCuota = new SiiInteresCuota();
                unSiiInteresCuota.setIcuCodigo(((BigDecimal) object[0]).longValue());
                unSiiInteresCuota.setIcuValor((BigDecimal) object[1]);
                unSiiInteresCuota.setIcuFecha((Date) object[2]);
                unSiiInteresCuota.setIcuBaseCalc((BigDecimal) object[3]);
                unSiiInteresCuota.setIcuTasaAplic((BigDecimal) object[4]);
                unSiiInteresCuota.setIcuCancelado((String) object[5]);
                unSiiInteresCuota.setIcuValorPagado((BigDecimal) object[6]);
                SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
                siiCuotaOperador.setCopCodigo(((BigDecimal) object[7]).longValue());
                unSiiInteresCuota.setSiiCuotaOperador(siiCuotaOperador);

                listaSiiInteresCuota.add(unSiiInteresCuota);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiInteresCuota;
    }

    public InteresCuotaVO buscarSumaInteresesXRefPago(Long idRefPago) throws ExcepcionDAO {
        InteresCuotaVO unSiiInteresCuota = new InteresCuotaVO();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select nvl(sum(ic.icu_valor-ic.icu_valor_pagado), 0) ");
            sql.append(" from sii_contrato c ");
            sql.append(" inner join sii_liquidacion_mes lm on (c.con_codigo = lm.con_codigo) ");
            sql.append(" inner join sii_cuota_operador co on (lm.lme_codigo = co.lme_codigo)   ");
            sql.append(" inner join sii_interes_cuota ic on (co.cop_codigo = ic.cop_codigo) ");
            sql.append(" inner join sii_detalle_declaracion dd on (co.cop_codigo = dd.cop_codigo) ");
            sql.append(" inner join sii_referencia_pago_decl refe on  refe.rpd_codigo = dd.rpd_codigo ");
            sql.append(" where refe.rpd_numero = #idRefPago and ic.icu_cancelado='N'");
            //sql.append(" group by cop.cop_valor");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRefPago", idRefPago);
            Object results = query.getSingleResult();
            if (results != null)
                unSiiInteresCuota.setValorTotalInteresXRefPago((BigDecimal) results);
            else
                unSiiInteresCuota.setValorTotalInteresXRefPago(BigDecimal.ZERO);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unSiiInteresCuota;
    }
    
    
    public List<ValidacionInteresVO>  buscarInteresTotal(String fechaCorte,String fechaFin   ) throws ExcepcionDAO{ 
        List<ValidacionInteresVO>  listaValidacionInteresVo = new ArrayList<ValidacionInteresVO>();
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select codigo_cuota,con_numero,cop_num_cuota,ccu_nombre,mes_codigo,cop_vigencia,cop_fecha_lim_pag,ValorCuota, ");
            sql.append(" case when  sum(RECAUDO)=0 then  valorcuota  else  sum(saldo) end as saldo ,sum(SALDO_INTERES_ANTERIOR)  AS SALDO_INTERES_ANTERIOR, ");
            sql.append(" SUM (interesGenerado)AS interesGenerado,SUM( pagoInteres)AS pagoInteres,SUM( SALDOINTERESACTUAL)AS SALDOINTERESACTUAL ");
            sql.append(" from( ");
            sql.append(" select distinct e.cop_codigo as codigo_cuota ,g.con_numero,e.cop_num_cuota,con.ccu_nombre,l.mes_codigo,e.cop_vigencia,e.cop_fecha_lim_pag , ");
            sql.append(" e.cop_valor as ValorCuota, 0 as RECAUDO, 0 as  saldo,0 as SALDO_INTERES_ANTERIOR, 0 AS interesGenerado, 0 AS pagoInteres, 0 AS SALDOINTERESACTUAL ");
            sql.append(" from sii_contrato g  ");
            sql.append(" inner join sii_liquidacion_mes l on (g.con_codigo = l.con_codigo) "); 
            sql.append(" inner join sii_cuota_operador e on (l.lme_codigo = e.lme_codigo) "); 
            sql.append(" inner join sii_concepto_cuota con on E.ccu_codigo=con.ccu_codigo"); 
            sql.append(" where ((g.CON_FECHA_INI >= '30/04/2007'  AND g.CON_FECHA_FIN     >= '30/04/2012') or g.con_numero IN ('C0712'))   ");
            sql.append(" AND g.con_numero NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732','C0800')");
            sql.append(" union ");
            sql.append(" select  e.cop_codigo as codigo_cuota ,g.con_numero,e.cop_num_cuota,con.ccu_nombre,l.mes_codigo,e.cop_vigencia,e.cop_fecha_lim_pag , ");
            sql.append(" e.cop_valor as ValorCuota,nvl(sum(dt.dde_valor_pagado),0) as  RECAUDO,e.cop_valor-sum(dt.dde_valor_pagado) as saldo, ");
            sql.append("  0 as SALDO_INTERES_ANTERIOR, 0 AS interesGenerado, 0 AS pagoInteres, 0 AS SALDOINTERESACTUAL ");
            sql.append(" from sii_contrato g ");
            sql.append(" inner join sii_liquidacion_mes l on (g.con_codigo = l.con_codigo) ");
            sql.append(" inner join sii_cuota_operador e on (l.lme_codigo = e.lme_codigo) ");
            sql.append(" left join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo  ");
            sql.append(" left join sii_detalle_recaudo de on  dt.dre_codigo = de.dre_codigo ");
            sql.append(" left join sii_recaudo_banco db on  de.rba_codigo = db.rba_codigo   ");
            sql.append(" left join sii_recaudo_pse pse on pse.rps_codigo = de.rps_codigo");
            sql.append(" inner join sii_concepto_cuota con on E.ccu_codigo=con.ccu_codigo");
            sql.append(" where ((g.CON_FECHA_INI >= '30/04/2007'  AND g.CON_FECHA_FIN     >= '30/04/2012') or g.con_numero IN ('C0712'))");
            sql.append(" AND g.con_numero NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732','C0800') and ");
            sql.append(" ( db.rba_fecha_rec < #fechaCorte or  pse.rps_fecha_estado < #fechaCorte )");
            sql.append(" group by e.cop_codigo,g.con_numero,e.cop_num_cuota,con.ccu_nombre,l.mes_codigo,e.cop_vigencia,e.cop_fecha_lim_pag ,e.cop_valor ");
            sql.append(" union ");
            sql.append(" select  e.cop_codigo as codigo_cuota ,g.con_numero,e.cop_num_cuota,con.ccu_nombre,l.mes_codigo,e.cop_vigencia,e.cop_fecha_lim_pag ,");
            sql.append(" e.cop_valor as ValorCuota,0 as  RECAUDO,0 as saldo,sum(i.icu_valor)-nvl(SUM(i.icu_valor_pagado), 0) as SALDO_INTERES_ANTERIOR, ");
            sql.append("  0 AS interesGenerado, 0 AS pagoInteres, 0 AS SALDOINTERESACTUAL");
            sql.append(" from sii_contrato g ");
            sql.append(" left join sii_liquidacion_mes l on (g.con_codigo = l.con_codigo) ");
            sql.append(" inner join sii_cuota_operador e on (l.lme_codigo = e.lme_codigo)");
            sql.append(" inner join sii_concepto_cuota con on E.ccu_codigo=con.ccu_codigo");
            sql.append(" left join sii_interes_cuota i on i.cop_codigo=e.cop_codigo ");
            sql.append(" where ((g.CON_FECHA_INI >= '30/04/2007'  AND g.CON_FECHA_FIN     >= '30/04/2012') or g.con_numero IN ('C0712'))");
            sql.append(" AND g.con_numero NOT IN ('C0443','C0449','C0456','C0494','C0517','C0621','C0709','C0489','C0732','C0800')");
            sql.append(" and ( i.icu_fecha < #fechaCorte ) ");
            sql.append(" group by e.cop_codigo,g.con_numero,e.cop_num_cuota,con.ccu_nombre,l.mes_codigo,e.cop_vigencia,e.cop_fecha_lim_pag ,e.cop_valor  ");
            sql.append(" UNION");
            sql.append(" select  e.cop_codigo as codigo_cuota ,g.con_numero,e.cop_num_cuota,con.ccu_nombre,l.mes_codigo,e.cop_vigencia,e.cop_fecha_lim_pag , ");
            sql.append(" e.cop_valor as ValorCuota,0 as  RECAUDO,0 as saldo,0 as SALDO_INTERES_ANTERIOR,    ");
            sql.append(" nvl(sum (i.icu_valor),0)as interesGenerado, nvl(sum(i.icu_valor_pagado),0)as pagoInteres, ");
            sql.append(" nvl(case  when sum(i.icu_valor_pagado) is null then  sum (i.icu_valor) else sum(i.icu_valor)-sum(i.icu_valor_pagado)end ,0)   as SALDOINTERESACTUAL  ");
            sql.append(" from sii_contrato g  ");
            sql.append(" left join sii_liquidacion_mes l on g.con_codigo = l.con_codigo  ");
            sql.append(" inner join sii_cuota_operador e on l.lme_codigo = e.lme_codigo ");
            sql.append(" LEFT join sii_concepto_cuota con on E.ccu_codigo=con.ccu_codigo ");
            sql.append(" inner join sii_interes_cuota i on i.cop_codigo = e.cop_codigo ");
            sql.append(" where icu_fecha between #fechaCorte and #fechaFin ");
            sql.append("  group by e.cop_codigo,g.con_numero,e.cop_num_cuota,con.ccu_nombre,l.mes_codigo,e.cop_vigencia,e.cop_fecha_lim_pag , e.cop_valor )");
            sql.append(" group by codigo_cuota,con_numero,cop_num_cuota,ccu_nombre,mes_codigo,cop_vigencia,cop_fecha_lim_pag,ValorCuota");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("fechaCorte",fechaCorte );
            
            List<Object[]> results = query.getResultList();        
           
            for (Object[] object : results) {
                ValidacionInteresVO unValidacionInteresVo= new ValidacionInteresVO();   
                unValidacionInteresVo.setCodigoCuota(((BigDecimal) object[0]).longValue());   
                unValidacionInteresVo.setNumeroContrato((String) object[1]);   
                unValidacionInteresVo.setNumeroCuota(((BigDecimal) object[2]).longValue());   
                unValidacionInteresVo.setDescripcionconcepto((String) object[3]);
                unValidacionInteresVo.setMesCuota(((BigDecimal) object[4]).longValue());    
                unValidacionInteresVo.setAñoCuota(((BigDecimal) object[5]).longValue());  
                unValidacionInteresVo.setFechaLimitePago((Date) object[6]);  
                unValidacionInteresVo.setValorCuota((BigDecimal) object[7]);
                unValidacionInteresVo.setSaldo((BigDecimal) object[8]);   
                unValidacionInteresVo.setSaldoInteres((BigDecimal) object[9]);   
                unValidacionInteresVo.setInteresGenerado((BigDecimal) object[10]);
                unValidacionInteresVo.setInteresPago((BigDecimal) object[11]);
                unValidacionInteresVo.setSaldoInteres((BigDecimal) object[12]);
                listaValidacionInteresVo.add(unValidacionInteresVo);    
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaValidacionInteresVo;
    }  
    
    
    public ValidacionInteresVO  buscarPagoXdiaCodigoCuota(Long codigoCuota,String  fecha  ) throws ExcepcionDAO{ 
        ValidacionInteresVO unValidacionInteresVo= new ValidacionInteresVO();
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append("select  nvl(sum(dt.dde_valor_pagado),0) ");
            sql.append(" from sii_cuota_operador e");
            sql.append(" inner  join sii_detalle_declaracion dt on e.cop_codigo = dt.cop_codigo ");
            sql.append(" inner  join sii_detalle_recaudo de on  dt.dre_codigo = de.dre_codigo      ");
            sql.append(" left join sii_recaudo_banco db on  de.rba_codigo = db.rba_codigo   ");
            sql.append(" left join sii_recaudo_pse pse on pse.rps_codigo = de.rps_codigo ");
            sql.append(" where e.cop_codigo=#codigoCuota   and db.rba_fecha_rec= #fecha "); 
            
            
            //sql.append(" group by cop.cop_valor");                        
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codigoCuota",codigoCuota );
            query.setParameter("fecha",fecha );
            
            Object results = query.getSingleResult();
            unValidacionInteresVo.setDia((BigDecimal) results); 
          
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unValidacionInteresVo;
    }  
    
    
    public ValidacionInteresVO  buscarSaldoPagoInteresesXcodigoCuota(Long idCodigoCuota ) throws ExcepcionDAO{ 
        ValidacionInteresVO unValidacionInteresVo= new ValidacionInteresVO();
        try{        
            StringBuilder sql = new StringBuilder();
            sql.append(" select sum(calculado) - sum(pago)   as saldo from( ");
            sql.append(" select sum(dde_valor_pag_int) as pago,0 as calculado from sii_detalle_declaracion");
            sql.append(" where cop_codigo=#idCodigoCuota   ");
            sql.append(" union  ");
            sql.append(" select 0 as pago ,sum(icu_valor) as calculado  from sii_interes_cuota   ");
            sql.append(" where cop_codigo=#idCodigoCuota )  ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoCuota",idCodigoCuota );
          
            Object results = query.getSingleResult();        
           
            unValidacionInteresVo.setInteresGenerado((BigDecimal) results);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return unValidacionInteresVo;
    }  
    
    

    public List<SiiInteresCuota> buscarInteresPorIdCuota(long idCuota) throws ExcepcionDAO {
        List<SiiInteresCuota> listaSiiInteresCuota = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT icu FROM SiiInteresCuota icu");
            sql.append(" WHERE icu.siiCuotaOperador.copCodigo = :idCuota");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idCuota", idCuota);

            listaSiiInteresCuota = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiInteresCuota;
    }
    
    public Long buscarNumeroInteresesPorDia(Date fechaCorte) throws ExcepcionDAO {
        Long icu_codigo = 0L;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strFechaCorte = formatter.format(fechaCorte);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT count(icu_codigo) FROM sii_interes_cuota");
            sql.append(" WHERE TO_CHAR(icu_Fecha,'YYYY/MM/DD') = '" + strFechaCorte + "'");

            Query query = manager.createNativeQuery(sql.toString());
           
            Object results = query.getSingleResult();
            icu_codigo = ( ((BigDecimal) results).longValue()); 
           

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return icu_codigo;
    }
}
