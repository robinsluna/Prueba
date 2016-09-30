package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPromocionalesVO;

import java.math.BigDecimal;

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

public class RifaPromocionalDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
   
    public RifaPromocionalDAO() {
        recursos = new Recursos();
    }
    
    
    public List<SiiRifaPromocional> buscarTodoSiiRifaPromocional(Long tipoApuesta) throws ExcepcionDAO {
        List<SiiRifaPromocional> listaRifaPromocional = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiRifaPromocional o  ");
            sql.append(" inner join o.siiTipoApuesta t   where t.tapCodigoApuesta= :tipoApuesta order by o.rfpCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoApuesta",tipoApuesta.toString());
            listaRifaPromocional = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRifaPromocional;
    }
    
    public List<SiiRifaPromocional> buscarTodoSiiRifaPromoPorRol(String rol,String tipoApuesta,Long usuCodigo) throws ExcepcionDAO {
        List<SiiRifaPromocional> listaRifaPromocional = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiRifaPromocional o  ");
            sql.append(" inner join o.siiSolicitudAutoriza s ");
            sql.append(" inner join s.siiUsuario u  ");
            sql.append(" inner join u.siiUsuarioRolList ur   ");
            sql.append(" inner join ur.siiRol1 ro ");
            sql.append(" inner join  o.siiTipoApuesta t   ");
            sql.append(" where ro.rolNombre = :rol and  t.tapCodigoApuesta = :tipoApuesta  and u.usuCodigo = :usuCodigo ");
            sql.append(" order by o.rfpCodigo desc    ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rol",rol);
            query.setParameter("tipoApuesta",tipoApuesta );
            query.setParameter("usuCodigo",usuCodigo );
            listaRifaPromocional = query.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaRifaPromocional;
    }
    
    
    public SiiRifaPromocional buscarPorCodigoRifaPromocional(Long idRifaPromocional) throws ExcepcionDAO {
        SiiRifaPromocional retornoOperador = null;
        try {
            retornoOperador = (SiiRifaPromocional) manager.find(SiiRifaPromocional.class, idRifaPromocional);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retornoOperador;

    }
    
    public SiiRifaPromocional insertarSiiRifaPromocional(SiiRifaPromocional siiRifaPromocional) throws ExcepcionDAO {
        try {
            manager.persist(siiRifaPromocional);
            manager.flush();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRifaPromocional;
    }
    
    public SiiRifaPromocional actualizarRifaPromocional(SiiRifaPromocional siiRifaPromocional) throws ExcepcionDAO {
        try {
            manager.merge(siiRifaPromocional);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRifaPromocional;
    }
    
    public SiiRifaPromocional aprobarRifaPromocional(SiiRifaPromocional siiRifaPromocional) throws ExcepcionDAO{
        try{
            manager.merge(siiRifaPromocional);
            manager.flush();
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRifaPromocional;
    }
    
    public String   siguienteNumeroRifaPromocional() throws ExcepcionDAO {
        Integer i;
        Calendar cal=Calendar.getInstance();
        Integer tempAño=cal.get(Calendar.YEAR);
        String  consecutivo=null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT max(o.rfpConsecutivo) FROM SiiRifaPromocional o");
            Query query = manager.createQuery(sql.toString());
            i = (Integer) query.getSingleResult();
            if (i == null) {
                return "00";
            }
            else 
                return consecutivo= Integer.toString(i + 1) ;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoDAO");
        }
       
    }
    
    
    public List<SolicitudPromocionalesVO> buscarTodoRifaPromocionalTransferenciaBan() throws ExcepcionDAO{
        List<SolicitudPromocionalesVO> listaSolicitudPromocionalesVo = new ArrayList();

        try{

            StringBuilder sql = new StringBuilder();

            sql.append(" select distinct r.rfp_codigo,r.rfp_consecutivo,dt.dde_codigo,s.per_codigo_rif ");
            sql.append(" ,r.rfp_resolucion,r.rfp_fecha_resol,co.ccu_abreviatura , nvl(dt.dde_valor_pagado,0) AS VALOR ");
            sql.append(" FROM sii_rifa_promocional r   ");
            sql.append(" INNER JOIN sii_solicitud_autoriza s ON s.sau_codigo = r.sau_codigo ");
            sql.append(" INNER JOIN sii_estado_solic_autoriz e ON s.esa_codigo = e.esa_codigo ");
            sql.append(" LEFT JOIN  sii_detalle_trasl_banc d on r.rfp_codigo=d.rfp_codigo ");
            sql.append(" LEFT JOIN  sii_traslado_bancario tb  on  tb.tba_codigo = d.tba_codigo ");
            sql.append(" INNER JOIN sii_cuota_operador cu on r.rfp_codigo = cu.rfp_codigo ");
            sql.append(" INNER JOIN sii_detalle_declaracion dt on dt.cop_codigo = cu.cop_codigo ");
            sql.append(" INNER JOIN sii_concepto_cuota co on cu.ccu_codigo = co.ccu_codigo ");
            sql.append(" where e.esa_nombre = 'APROBADO' and  dt.dde_valor_pagado is not null and  (co.ccu_abreviatura != d.dtb_concepto or d.dtb_concepto is null)");
            sql.append(" and r.rfp_codigo not in ( ");
            sql.append(" select rfp_codigo from ( ");
            sql.append(" select count(d.rfp_codigo)as cont,d.rfp_codigo from sii_rifa_promocional tb ");
            sql.append(" inner join sii_detalle_trasl_banc d on tb.rfp_codigo = d.rfp_codigo ");
            sql.append(" inner join sii_traslado_bancario t on  t.tba_codigo = d.tba_codigo ");
            sql.append(" inner join sii_estado_trasl_bancario e on t.etb_codigo = e.etb_codigo ");
            sql.append(" INNER JOIN sii_solicitud_autoriza s ON s.sau_codigo = tb.sau_codigo ");
            sql.append(" INNER JOIN sii_estado_solic_autoriz es ON s.esa_codigo = es.esa_codigo ");
            sql.append(" where es.esa_nombre ='APROBADO' ");
            sql.append(" group by d.rfp_codigo) ");
            sql.append(" where cont>=2) ");

            Query query = manager.createNativeQuery(sql.toString());
            List<Object[]> rows = query.getResultList();
            for(Object[] row : rows){
                SolicitudPromocionalesVO solicitudPromocionalesVo = new SolicitudPromocionalesVO();
                solicitudPromocionalesVo.setIdSolicitud(((BigDecimal) row[0]).longValue());
                solicitudPromocionalesVo.setConsecutivo(((BigDecimal) row[1]).intValue());
                solicitudPromocionalesVo.setIdDeclaracion(((BigDecimal) row[2]).longValue());
                PersonaVO personaVo = new PersonaVO();
                personaVo.setPerCodigo(((BigDecimal) row[3]).longValue());
                solicitudPromocionalesVo.setPersonaVo(personaVo);
                solicitudPromocionalesVo.setNumeroResolucion((String) row[4]);
                solicitudPromocionalesVo.setFechaResolucion((Date) row[5]);
                solicitudPromocionalesVo.setConcepto((String) row[6]);
                solicitudPromocionalesVo.setValorConcepto((BigDecimal) row[7]);
                listaSolicitudPromocionalesVo.add(solicitudPromocionalesVo);

            }

        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolicitudPromocionalesVo;
    }
    
    public List<SolicitudPromocionalesVO> buscarRifaPromocionalTransFerenciaBan(Long idTrasBanco) throws ExcepcionDAO{
        List<SolicitudPromocionalesVO> listaSolicitudPromocionalesVo = new ArrayList();

        try{

            StringBuilder sql = new StringBuilder();

            sql.append(" SELECT distinct r.rfp_codigo, r.rfp_consecutivo,dt.dde_codigo,s.per_codigo_rif,r.rfp_resolucion,r.rfp_fecha_resol,co.ccu_abreviatura,sum( nvl(dt.dde_valor_pagado,0))  ");
            sql.append(" FROM sii_rifa_promocional r   ");
            sql.append(" INNER JOIN sii_solicitud_autoriza s ON s.sau_codigo = r.sau_codigo");
            sql.append(" INNER JOIN sii_estado_solic_autoriz e ON s.esa_codigo = e.esa_codigo ");
            sql.append(" INNER JOIN sii_cuota_operador cu on r.rfp_codigo = cu.rfp_codigo ");
            sql.append(" INNER JOIN sii_detalle_declaracion dt on dt.cop_codigo = cu.cop_codigo ");
            sql.append(" INNER JOIN sii_concepto_cuota co on cu.ccu_codigo = co.ccu_codigo ");
            sql.append(" INNER JOIN sii_detalle_trasl_banc tr on  tr.dtb_concepto=co.ccu_abreviatura and tr.rfp_codigo = r.rfp_codigo ");
            sql.append(" WHERE e.esa_nombre = 'APROBADO' and  dt.dde_valor_pagado is not null   AND tr.tba_codigo = #idTrasBanco ");
            sql.append(" group by co.ccu_abreviatura, r.rfp_resolucion,dt.dde_codigo, r.rfp_consecutivo, s.sau_codigo, r.rfp_fecha_resol, ");
            sql.append(" r.rfp_codigo, s.per_codigo_rif   order by 1 desc   ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idTrasBanco", idTrasBanco);
            List<Object[]> rows = query.getResultList();
            for(Object[] row : rows){
                SolicitudPromocionalesVO solicitudPromocionalesVo = new SolicitudPromocionalesVO();
                solicitudPromocionalesVo.setIdSolicitud(((BigDecimal) row[0]).longValue());
                solicitudPromocionalesVo.setConsecutivo(((BigDecimal) row[1]).intValue());
                solicitudPromocionalesVo.setIdDeclaracion(((BigDecimal) row[2]).longValue());
                PersonaVO personaVo = new PersonaVO();
                personaVo.setPerCodigo(((BigDecimal) row[3]).longValue());
                solicitudPromocionalesVo.setPersonaVo(personaVo);
                solicitudPromocionalesVo.setNumeroResolucion((String) row[4]);
                solicitudPromocionalesVo.setFechaResolucion((Date) row[5]);
                solicitudPromocionalesVo.setConcepto((String) row[6]);
                solicitudPromocionalesVo.setValorConcepto((BigDecimal) row[7]);
                listaSolicitudPromocionalesVo.add(solicitudPromocionalesVo);

            }

        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSolicitudPromocionalesVo;
    }

    
}
