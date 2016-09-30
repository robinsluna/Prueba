/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 18-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoModificRP;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoModificacionRP;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.CdpRubroDetalleFuenteVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Iterator;
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
public class RpDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public RpDAO() {
        recursos = new Recursos();
    }
    
    public SiiRp buscarPorCodigoRp(Long idCodigoRp) throws ExcepcionDAO {
        SiiRp siiRp = null;
        
        try{
            siiRp = (SiiRp) manager.find(SiiRp.class, idCodigoRp);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
        return siiRp;
    }
    
    public SiiRp insertarRp(SiiRp siiRp) throws ExcepcionDAO {
        try{
            manager.persist(siiRp);
            manager.flush();
            return siiRp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO"); 
        }
    }
    
    public SiiRp actualizarRp(SiiRp siiRp) throws ExcepcionDAO {
        try{
            manager.merge(siiRp);
            manager.flush();
            return siiRp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
    }
    
    public List<SiiRp> buscarTodoRp() throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rp FROM SiiRp rp order by rp.rpCodigo desc");
            Query query = manager.createQuery(sql.toString());
            List<SiiRp> listaEntidadRp = query.getResultList();
            
            return listaEntidadRp;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO"); 
        }
    }
   
    public List<SiiRp> buscarRpPorEstado(String estado) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rp FROM SiiRp rp INNER JOIN rp.siiEstadoRp estado WHERE estado.erpNombre = :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            List<SiiRp> listaRp = query.getResultList();
            return listaRp;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
    }
    
    public List<SiiRp> buscarRpAprobadosSinIncrementosEnTramite() throws ExcepcionDAO {
        return rpsAprobadosSinMovimientosEnTramite("I");
    }

    public List<SiiRp> buscarRpAprobadosSinDecrementosEnTramite() throws ExcepcionDAO {
        return rpsAprobadosSinMovimientosEnTramite("D");
    }

    private List<SiiRp> rpsAprobadosSinMovimientosEnTramite(String mrpTipoModif) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rp FROM SiiRp rp INNER JOIN rp.siiEstadoRp estado " +
                "WHERE estado.erpNombre = 'RP APROBADO' "+
                       "AND NOT EXISTS " +
                "(SELECT mrp FROM SiiModificacionRp mrp" +
                " WHERE mrp.siiEstadoModificRp.emrNombre NOT IN ('APROBADO','RECHAZADO','ANULADO') " +
                " AND mrp.mrpTipoModif = :mrpTipoModif" +
                " AND mrp.siiRp1.rpCodigo = rp.rpCodigo)" +
            " ORDER BY rp.rpConsecutivo DESC");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mrpTipoModif", mrpTipoModif);
            List<SiiRp> listaRp = query.getResultList();
            return listaRp;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
    }

    public List<CdpRubroDetalleFuenteVO> bucarCdpConSaldo(Integer vigencia) throws ExcepcionDAO {      
            List<CdpRubroDetalleFuenteVO> listaCdpRubroDetalleFuenteVo = new ArrayList<CdpRubroDetalleFuenteVO>();
            try {
                StringBuilder sql = new StringBuilder();   
                /*sql.append("select sum(det.dru_valor) val,cdpPadre.cdp_codigo, cdpPadre.cdp_consecutivo ");
                sql.append("from SII_DETALLE_RUBRO_CDP det, sii_cdp cdpPadre ");
                sql.append("where det.cdp_codigo = cdpPadre.cdp_codigo ");
                sql.append("and cdpPadre.cdp_vigencia = #vigencia ");
                sql.append("and cdpPadre.ecd_codigo = 8");
                sql.append("group by cdpPadre.cdp_codigo, cdpPadre.cdp_consecutivo ");*/
                /*sql.append("select sum(s.val),s.cdp from (");  
                sql.append("select sum(det.dru_valor) val, cdpPadre.cdp_consecutivo cdp ");
                sql.append("from SII_DETALLE_RUBRO_CDP det, sii_cdp cdpPadre ");
                sql.append("where det.cdp_codigo = cdpPadre.cdp_codigo ");
                sql.append("and cdpPadre.cdp_vigencia = #vigencia ");
                sql.append("group by cdpPadre.cdp_consecutivo ");
                sql.append("union all ");
                sql.append("select sum(m.mcr_valor), c.cdp_codigo ");
                sql.append("from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc ");
                sql.append("where c.drc_codigo = m.drc_codigo ");
                sql.append("and mcd.mcd_codigo = m.mcd_codigo ");
                sql.append("and mcd.mcd_tipo_mod = 'I' ");
                sql.append("and emc.emc_codigo = mcd.emc_codigo ");
                sql.append("and emc.emc_nombre = 'APROBADO' ");
                sql.append("group by  c.cdp_codigo ");
                sql.append("union all ");
                sql.append("select -sum(m.mcr_valor), c.cdp_codigo ");
                sql.append("from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc ");
                sql.append("where c.drc_codigo = m.drc_codigo ");
                sql.append("and mcd.mcd_codigo = m.mcd_codigo ");
                sql.append("and mcd.mcd_tipo_mod = 'D' ");
                sql.append("and emc.emc_codigo = mcd.emc_codigo ");
                sql.append("and emc.emc_nombre = 'APROBADO' ");
                sql.append("group by  c.cdp_codigo ");
                sql.append("union all ");
                sql.append("select -sum(rd.rdr_valor),c.cdp_codigo ");
                sql.append("from sii_rp_det_rubro_cdp rd, sii_rp r,sii_cdp c ");
                sql.append("where rd.rp_codigo=r.rp_codigo ");
                sql.append("and r.cdp_codigo = c.cdp_codigo ");
                sql.append("group by c.cdp_codigo ");
                sql.append(") s ");   
                sql.append("group by s.cdp");*/
                
                sql.append(" SELECT SUMA,CDP, CONSECUTIVO, PROCESO FROM (");
                sql.append(" select sum(s.val) as suma,s.cdp, s.consecutivo ,s.proceso from (");
                sql.append(" select sum(det.dru_valor) val,cdpPadre.cdp_codigo cdp,");
                sql.append(" cdpPadre.cdp_consecutivo consecutivo,cdpPadre.prc_codigo proceso");
                sql.append(" from SII_DETALLE_RUBRO_CDP det, sii_cdp cdpPadre,sii_estado_cdp ecd");
                sql.append(" where det.cdp_codigo = cdpPadre.cdp_codigo");
                sql.append(" and cdpPadre.cdp_vigencia =#vigencia");
                sql.append(" and Cdppadre.Ecd_Codigo = ecd.ecd_codigo");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by cdpPadre.cdp_codigo ,cdpPadre.cdp_consecutivo,cdpPadre.prc_codigo ");
                sql.append(" union all");
                sql.append(" select sum(m.mcr_valor), c.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd,");
                sql.append(" sii_estado_modif_cdp emc, sii_cdp cdp ,sii_estado_cdp ecd");
                sql.append(" where c.drc_codigo = m.drc_codigo");
                sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
                sql.append(" and mcd.mcd_tipo_mod = 'I'");
                sql.append(" and emc.emc_codigo = mcd.emc_codigo");
                sql.append(" and emc.emc_nombre = 'APROBADO'");
                sql.append(" and c.cdp_codigo = cdp.cdp_codigo");
                sql.append(" and cdp.cdp_vigencia = #vigencia");
                sql.append(" and cdp.Ecd_Codigo = ecd.ecd_codigo");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by  c.cdp_codigo ,cdp.cdp_consecutivo,cdp.prc_codigo ");
                sql.append(" union all ");
                sql.append(" select -sum(m.mcr_valor), c.cdp_codigo ,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd,");
                sql.append(" sii_estado_modif_cdp emc, sii_cdp cdp ,sii_estado_cdp ecd");
                sql.append(" where c.drc_codigo = m.drc_codigo");
                sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
                sql.append(" and mcd.mcd_tipo_mod = 'D'");
                sql.append(" and emc.emc_codigo = mcd.emc_codigo");
                sql.append(" and emc.emc_nombre = 'APROBADO'");
                sql.append(" and c.cdp_codigo = cdp.cdp_codigo");
                sql.append(" and cdp.cdp_vigencia =#vigencia");
                sql.append(" and cdp.Ecd_Codigo = ecd.ecd_codigo");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by  c.cdp_codigo ,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" union all");
                sql.append(" select -sum(rd.rdr_valor),c.cdp_codigo,c.cdp_consecutivo,c.prc_codigo");
                sql.append(" from sii_rp_det_rubro_cdp rd, sii_rp r,sii_cdp c, Sii_Estado_Rp esrp ,sii_estado_cdp ecd,sii_cdp_rp cdprp");
                sql.append(" where rd.rp_codigo=r.rp_codigo");
                sql.append(" and r.rp_codigo = cdprp.rp_codigo");
                sql.append(" and cdprp.cdp_codigo = c.cdp_codigo");                
                sql.append(" and c.cdp_vigencia =#vigencia");
                sql.append(" and r.erp_codigo = Esrp.Erp_Codigo");
                sql.append(" and Esrp.Erp_Nombre = 'RP APROBADO'");
                sql.append(" and c.Ecd_Codigo = ecd.ecd_codigo");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by c.cdp_codigo,c.cdp_consecutivo,c.prc_codigo");
                sql.append(" union all");
                sql.append(" select -sum (mrd.mrd_valor),cdp.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" from sii_modif_rp_det_rub_cdp mrd");
                sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
                sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)                  ");
                sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
                sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
                sql.append(" Inner Join sii_cdp cdp on (crp.cdp_codigo = cdp.cdp_codigo)");
                sql.append(" Inner Join Sii_Estado_Modific_Rp emr on (mr.emr_codigo = emr.emr_codigo)");
                sql.append(" Inner Join sii_estado_cdp ecd on (cdp.ecd_codigo = ecd.ecd_codigo)");
                sql.append(" where cdp.cdp_vigencia =#vigencia");
                sql.append(" and mr.mrp_tipo_modif ='I'");
                sql.append(" and emr.emr_nombre = 'APROBADO'");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by cdp.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" union all");
                sql.append(" select sum (mrd.mrd_valor),cdp.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" from sii_modif_rp_det_rub_cdp mrd");
                sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
                sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
                sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
                sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
                sql.append(" Inner Join sii_cdp cdp on (crp.cdp_codigo = cdp.cdp_codigo)");
                sql.append(" Inner Join Sii_Estado_Modific_Rp emr on (mr.emr_codigo = emr.emr_codigo)");
                sql.append(" Inner Join sii_estado_cdp ecd on (cdp.ecd_codigo = ecd.ecd_codigo)");
                sql.append(" where cdp.cdp_vigencia =#vigencia");
                sql.append(" and mr.mrp_tipo_modif ='D'");
                sql.append(" and emr.emr_nombre = 'APROBADO'");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO' ");
                sql.append(" group by cdp.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo ) s");                                
                sql.append(" having sum(s.val) >0 AND  s.proceso is null");
                sql.append(" group by s.cdp,s.consecutivo,s.proceso");
                sql.append(" UNION ");
                sql.append(" select sum(s.val),s.cdp, s.consecutivo ,s.proceso from (");
                sql.append(" select sum(det.dru_valor) val,cdpPadre.cdp_codigo cdp,");
                sql.append(" cdpPadre.cdp_consecutivo consecutivo,cdpPadre.prc_codigo proceso");
                sql.append(" from SII_DETALLE_RUBRO_CDP det, sii_cdp cdpPadre,sii_estado_cdp ecd");
                sql.append(" where det.cdp_codigo = cdpPadre.cdp_codigo");
                sql.append(" and cdpPadre.cdp_vigencia =#vigencia");
                sql.append(" and Cdppadre.Ecd_Codigo = ecd.ecd_codigo");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by cdpPadre.cdp_codigo ,cdpPadre.cdp_consecutivo,cdpPadre.prc_codigo ");
                sql.append(" union all");
                sql.append(" select sum(m.mcr_valor), c.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd,");
                sql.append(" sii_estado_modif_cdp emc, sii_cdp cdp ,sii_estado_cdp ecd");
                sql.append(" where c.drc_codigo = m.drc_codigo");
                sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
                sql.append(" and mcd.mcd_tipo_mod = 'I'");
                sql.append(" and emc.emc_codigo = mcd.emc_codigo");
                sql.append(" and emc.emc_nombre = 'APROBADO'");
                sql.append(" and c.cdp_codigo = cdp.cdp_codigo");
                sql.append(" and cdp.cdp_vigencia = #vigencia");
                sql.append(" and cdp.Ecd_Codigo = ecd.ecd_codigo");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by  c.cdp_codigo ,cdp.cdp_consecutivo,cdp.prc_codigo ");
                sql.append(" union all ");
                sql.append(" select -sum(m.mcr_valor), c.cdp_codigo ,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd,");
                sql.append(" sii_estado_modif_cdp emc, sii_cdp cdp ,sii_estado_cdp ecd");
                sql.append(" where c.drc_codigo = m.drc_codigo");
                sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
                sql.append(" and mcd.mcd_tipo_mod = 'D'");
                sql.append(" and emc.emc_codigo = mcd.emc_codigo");
                sql.append(" and emc.emc_nombre = 'APROBADO'");
                sql.append(" and c.cdp_codigo = cdp.cdp_codigo");
                sql.append(" and cdp.cdp_vigencia =#vigencia");
                sql.append(" and cdp.Ecd_Codigo = ecd.ecd_codigo");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by  c.cdp_codigo ,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" union all");
                sql.append(" select -sum(rd.rdr_valor),c.cdp_codigo,c.cdp_consecutivo,c.prc_codigo");
                sql.append(" from sii_rp_det_rubro_cdp rd, sii_rp r,sii_cdp c, Sii_Estado_Rp esrp ,sii_estado_cdp ecd,sii_cdp_rp cdprp");
                sql.append(" where rd.rp_codigo=r.rp_codigo");
                sql.append(" and r.rp_codigo = cdprp.rp_codigo");
                sql.append(" and cdprp.cdp_codigo = c.cdp_codigo");
                sql.append(" and c.cdp_vigencia =#vigencia");
                sql.append(" and r.erp_codigo = Esrp.Erp_Codigo");
                sql.append(" and Esrp.Erp_Nombre = 'RP APROBADO'");
                sql.append(" and c.Ecd_Codigo = ecd.ecd_codigo");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by c.cdp_codigo,c.cdp_consecutivo,c.prc_codigo" );
                sql.append(" union all");
                sql.append(" select -sum (mrd.mrd_valor),cdp.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" from sii_modif_rp_det_rub_cdp mrd");
                sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
                sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
                sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
                sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
                sql.append(" Inner Join sii_cdp cdp on (crp.cdp_codigo = cdp.cdp_codigo)");
                sql.append(" Inner Join Sii_Estado_Modific_Rp emr on (mr.emr_codigo = emr.emr_codigo)");
                sql.append(" Inner Join sii_estado_cdp ecd on (cdp.ecd_codigo = ecd.ecd_codigo)");
                sql.append(" where cdp.cdp_vigencia =#vigencia");
                sql.append(" and mr.mrp_tipo_modif ='I'");
                sql.append(" and emr.emr_nombre = 'APROBADO'");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by cdp.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" union all");
                sql.append(" select sum (mrd.mrd_valor),cdp.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo");
                sql.append(" from sii_modif_rp_det_rub_cdp mrd");
                sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
                sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
                sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
                sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
                sql.append(" Inner Join sii_cdp cdp on (crp.cdp_codigo = cdp.cdp_codigo)");
                sql.append(" Inner Join Sii_Estado_Modific_Rp emr on (mr.emr_codigo = emr.emr_codigo)");
                sql.append(" Inner Join sii_estado_cdp ecd on (cdp.ecd_codigo = ecd.ecd_codigo)");
                sql.append(" where cdp.cdp_vigencia =#vigencia");
                sql.append(" and mr.mrp_tipo_modif ='D'");
                sql.append(" and emr.emr_nombre = 'APROBADO'");
                sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
                sql.append(" group by cdp.cdp_codigo,cdp.cdp_consecutivo,cdp.prc_codigo ) s");                         
                sql.append(" Inner Join sii_proceso_contratacion pro on (s.proceso = pro.prc_codigo and pro.epc_codigo=88)");
                sql.append(" having sum(s.val) >0 ");
                sql.append(" group by s.cdp,s.consecutivo,s.proceso )");
                sql.append(" ORDER BY CONSECUTIVO");
    
                Query query = manager.createNativeQuery(sql.toString());
                
                query.setParameter("vigencia",vigencia);
             
                List<Object[]> results = query.getResultList();
                for (Object[] object : results) {
                        CdpRubroDetalleFuenteVO crfdVo = new CdpRubroDetalleFuenteVO();
                        crfdVo.setSaldo((BigDecimal) object[0]);                            //Saldo    
                       crfdVo.setIdCdp(((BigDecimal) object[1]).longValue());              //Id CDP
                       crfdVo.setConsecutivo(((BigDecimal) object[2]).longValue());
                       
                                           
                        listaCdpRubroDetalleFuenteVo.add(crfdVo);
                }

            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
            } catch(Exception ex){
                ex.printStackTrace();
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"RpDAO");
            }
            return listaCdpRubroDetalleFuenteVo;
        }
    
    public List<CdpRubroDetalleFuenteVO> bucarRubroFteDetPorCdp(Long IdCdp) throws ExcepcionDAO {
        List<CdpRubroDetalleFuenteVO> listaRubroFteDetPorCdpVo = new ArrayList<CdpRubroDetalleFuenteVO>();
        try{
            StringBuilder sql = new StringBuilder();  
            sql.append(" select sum(s.val),s.idDetRubCdp , s.rubdescr, s.dffdescr, s.ffdescr from (");
            sql.append(" select sum(det.dru_valor) val, det.drc_codigo idDetRubCdp, ru.descripcion rubdescr");
            sql.append(" , dff.dff_descripcion dffdescr, ff.ffi_descripcion  ffdescr");
            sql.append(" from SII_DETALLE_RUBRO_CDP det,pr_rubro ru,Sii_Detalle_Rubro detru");
            sql.append(" ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff");
            sql.append(" where ru.vigencia = detru.vigencia");
            sql.append(" and ru.interno = detru.interno");
            sql.append(" and detru.dru_codigo = det.dru_codigo");
            sql.append(" and det.cdp_codigo = #IdCdp");
            sql.append(" and detru.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" group by det.drc_codigo ,ru.descripcion , dff.dff_descripcion, ff.ffi_descripcion");
            sql.append(" union all");
            sql.append(" select sum(m.mcr_valor), c.drc_codigo,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion");
            sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc,");
            sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff");
            sql.append(" where c.drc_codigo = m.drc_codigo");
            sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
            sql.append(" and mcd.mcd_tipo_mod = 'I'");
            sql.append(" and emc.emc_codigo = mcd.emc_codigo");
            sql.append(" and emc.emc_nombre = 'APROBADO'");
            sql.append(" and c.cdp_codigo =#IdCdp");
            sql.append(" and c.dru_codigo = detru.dru_codigo");
            sql.append(" and detru.vigencia = ru.vigencia");
            sql.append(" and detru.interno = ru.interno");
            sql.append(" and detru.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" group by  c.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion");
            sql.append(" union all");
            sql.append(" select -sum(m.mcr_valor), c.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion");
            sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc,");
            sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff");
            sql.append(" where c.drc_codigo = m.drc_codigo");
            sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
            sql.append(" and mcd.mcd_tipo_mod = 'D'");
            sql.append(" and emc.emc_codigo = mcd.emc_codigo");
            sql.append(" and emc.emc_nombre = 'APROBADO'");
            sql.append(" and c.cdp_codigo =#IdCdp");
            sql.append(" and c.dru_codigo = detru.dru_codigo");
            sql.append(" and detru.vigencia = ru.vigencia"); 
            sql.append(" and detru.interno = ru.interno");
            sql.append(" and detru.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" group by  c.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion");
            sql.append(" union all");
            sql.append(" select -sum(rd.rdr_valor),rd.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion");
            sql.append(" from sii_rp_det_rubro_cdp rd, sii_rp r,sii_detalle_rubro_cdp c,");
            sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff");
            sql.append(" where rd.rp_codigo=r.rp_codigo");
            sql.append(" and r.cdp_codigo = c.cdp_codigo");
            sql.append(" and r.erp_codigo = 8");
            sql.append(" and c.cdp_codigo = #IdCdp");
            sql.append(" and c.dru_codigo = detru.dru_codigo");
            sql.append(" and detru.vigencia = ru.vigencia");
            sql.append(" and detru.interno = ru.interno");
            sql.append(" and detru.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo ");
            sql.append(" and c.DRC_CODIGO = rd.DRC_CODIGO");
            sql.append(" group by rd.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion ) s");
            sql.append(" group by s.idDetRubCdp , s.rubdescr, s.dffdescr, s.ffdescr");
           
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("IdCdp",IdCdp);
            
            List<Object[]> results = query.getResultList();
            for(Object[] object : results){
                CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();
                rfdcVo.setIdCdp(IdCdp);              //Id CDP
                rfdcVo.setDesRubro((String) object[2]);                             //Descripción Rubro
                rfdcVo.setIdDetRubCdp(((BigDecimal) object[1]).longValue());        //Id Detalle Rubro CDP
                rfdcVo.setDesFuente((String) object[4]);                            //Descripción Fuente
                rfdcVo.setDtlleFuente((String) object[3]);                          //Descripción Detalle Fuente
                rfdcVo.setSaldo((BigDecimal) object[0]);                            //Valor
                
                listaRubroFteDetPorCdpVo.add(rfdcVo);
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
        return listaRubroFteDetPorCdpVo;
    }
    
    public Long buscarConsecutivoRp() throws ExcepcionDAO {
        Long consecutivo = null;
        BigDecimal resultado;
        try{
            StringBuilder sql = new StringBuilder(); 
            sql.append("SELECT NVL(MAX(RP_CONSECUTIVO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yyyy')||'000001')) ");
            sql.append("FROM SII_RP rp ");
            sql.append("WHERE rp_consecutivo LIKE ''||TO_CHAR(CURRENT_DATE,'yyyy')||'%'");
            
            Query query = manager.createNativeQuery(sql.toString());
            
           /* if (query.getSingleResult() == null) {
                consecutivo = 0L;
            } else {
                consecutivo = ((BigDecimal) query.getSingleResult()).longValue();
            }*/
            
           if (query.getSingleResult() != null) {
               consecutivo = new Long(((BigDecimal) query.getSingleResult()).longValue());
           }           
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
        return consecutivo;
    }
    
   public List<CdpRubroDetalleFuenteVO> buscarRubroFteDetPorRp(Long IdRp, Long idCdp) throws ExcepcionDAO {
        List<CdpRubroDetalleFuenteVO> listaRubroFteDetPorCdpVo = new ArrayList<CdpRubroDetalleFuenteVO>();
        try{
            StringBuilder sql = new StringBuilder();  
            
            sql.append(" select sum(s.val), s.dffdescr,s.ffdesc, s.rudesc, sum(s.rpvalor),s.rpsaldoanterior ,s.codrubro from (");
            sql.append(" select sum (drc.dru_valor) val, dff.dff_descripcion dffdescr,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000','') ffdesc, ");
            sql.append(" ru.descripcion rudesc,sum(rpdet.rdr_valor) rpvalor,NVL(rpdet.Rdr_Saldo_Anterior,0) rpsaldoanterior,drc.drc_codigo codrubro");
            sql.append(" from sii_detalle_rubro_cdp drc,sii_detalle_rubro dr, sii_dtlle_fuente_financiacion dff, sii_fuente_financiacion ff,");
            sql.append(" pr_rubro ru, sii_rp_det_rubro_cdp rpdet,sii_rp rp");
            sql.append(" where drc.dru_codigo = dr.dru_codigo");
            sql.append(" and dr.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" and dff.dff_codigo = dr.dff_codigo");
            sql.append(" and dr.vigencia = ru.vigencia");
            sql.append(" and dr.interno = ru.interno");
            sql.append(" and drc.drc_codigo = rpdet.drc_Codigo");
            sql.append(" and rpdet.rp_codigo = rp.rp_codigo");
            sql.append(" and rp.rp_codigo = #IdRp");
            sql.append(" group by dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,");
            sql.append(" Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo");
            
            sql.append(" UNION ALL");
            
            // INCREMENTOS CDP
            sql.append(" select sum(md.mcr_valor),dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,");
            //sql.append(" sum(rpdet.rdr_valor),NVL(Rpdet.Rdr_Saldo_Anterior,0),drc.drc_codigo");
            sql.append(" 0 as RDR_VALOR,NVL(Rpdet.Rdr_Saldo_Anterior,0),drc.drc_codigo");
            sql.append(" from sii_modif_cdp_det_rub_cdp md,sii_modificacion_cdp mc, sii_estado_modif_cdp es,");
            sql.append(" sii_detalle_rubro_cdp drc ,sii_detalle_rubro dr,");
            sql.append(" sii_dtlle_fuente_financiacion dff, sii_fuente_financiacion ff,pr_rubro ru, sii_rp_det_rubro_cdp rpdet,sii_rp rp");
            sql.append(" where drc.drc_codigo = md.drc_codigo");
            sql.append(" and md.mcd_codigo = mc.mcd_codigo");
            sql.append(" and mc.mcd_tipo_mod='I'");
            sql.append(" and mc.emc_codigo = es.emc_codigo");
            sql.append(" and es.emc_nombre='APROBADO'");
            sql.append(" and drc.dru_codigo = dr.dru_codigo");
            sql.append(" and dr.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" and dff.dff_codigo = dr.dff_codigo");
            sql.append(" and dr.vigencia = ru.vigencia");
            sql.append(" and dr.interno = ru.interno");
            sql.append(" and drc.drc_codigo = rpdet.drc_Codigo");
            sql.append(" and rpdet.rp_codigo = rp.rp_codigo");
            sql.append(" and rp.rp_codigo = #IdRp");
            sql.append(" group by dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,");
            sql.append(" Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo");
            
            sql.append(" UNION ALL");
            
            // DECREMENTOS CDP
            sql.append(" select -sum(md.mcr_valor),dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ");
            //sql.append(" ru.descripcion, sum(rpdet.rdr_valor),NVL(Rpdet.Rdr_Saldo_Anterior,0),drc.drc_codigo");
            sql.append(" ru.descripcion, 0 as RDR_VALOR,NVL(Rpdet.Rdr_Saldo_Anterior,0),drc.drc_codigo");
            sql.append(" from sii_modif_cdp_det_rub_cdp md,sii_modificacion_cdp mc, sii_estado_modif_cdp es,");
            sql.append(" sii_detalle_rubro_cdp drc ,sii_detalle_rubro dr,");
            sql.append(" sii_dtlle_fuente_financiacion dff, sii_fuente_financiacion ff,pr_rubro ru , sii_rp_det_rubro_cdp rpdet,sii_rp rp");
            sql.append(" where drc.drc_codigo = md.drc_codigo");
            sql.append(" and md.mcd_codigo = mc.mcd_codigo");
            sql.append(" and mc.mcd_tipo_mod='D'");
            sql.append(" and mc.emc_codigo = es.emc_codigo");
            sql.append(" and es.emc_nombre='APROBADO'");
            sql.append(" and drc.dru_codigo = dr.dru_codigo");
            sql.append(" and dr.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" and dff.dff_codigo = dr.dff_codigo");
            sql.append(" and dr.vigencia = ru.vigencia");
            sql.append(" and dr.interno = ru.interno");
            sql.append(" and drc.drc_codigo = rpdet.drc_Codigo");
            sql.append(" and rpdet.rp_codigo = rp.rp_codigo");
            sql.append(" and rp.rp_codigo = #IdRp");
            sql.append(" group by dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,");
            sql.append(" Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo");
            
            /*
            sql.append(" UNION ALL");
            
            // INCREMENTOS RP
            sql.append(" select -sum(mrd.mrd_valor),dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,");
            sql.append(" sum(rpdet.rdr_valor),NVL(Rpdet.Rdr_Saldo_Anterior,0),drc.drc_codigo ");
            sql.append(" from sii_modif_rp_det_rub_cdp mrd");
            sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
            sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
            sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
            sql.append(" Inner Join sii_detalle_rubro_cdp drc on (rpdet.drc_codigo = drc.drc_codigo)");
            sql.append(" Inner Join sii_detalle_rubro dr on (drc.dru_codigo = dr.dru_codigo)");
            sql.append(" Inner Join sii_dtlle_fuente_financiacion dff on ( dr.dff_codigo = dff.dff_codigo)");
            sql.append(" Inner Join sii_fuente_financiacion ff on (dff.ffi_codigo = ff.ffi_codigo)");
            sql.append(" Inner Join pr_rubro ru on (dr.vigencia = ru.vigencia and dr.interno = ru.interno)");
            sql.append(" Inner Join sii_estado_modific_rp  emr on (mr.emr_codigo = emr.emr_codigo)");
            sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
            sql.append(" where mr.mrp_tipo_modif ='I'");
            sql.append(" and emr.emr_nombre='APROBADO'");
            sql.append(" and crp.cdp_codigo = #idCdp");
            sql.append(" and rp.RP_CODIGO = #IdRp ");
            sql.append(" group by dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,");
            sql.append(" Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo ");
            
            sql.append(" UNION ALL");
            
            // DECREMENTOS RP
            sql.append(" select sum(mrd.mrd_valor), dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,");
            sql.append(" sum(rpdet.rdr_valor),NVL(Rpdet.Rdr_Saldo_Anterior,0),drc.drc_codigo ");
            sql.append(" from sii_modif_rp_det_rub_cdp mrd");
            sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
            sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
            sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
            sql.append(" Inner Join sii_detalle_rubro_cdp drc on (rpdet.drc_codigo = drc.drc_codigo)");
            sql.append(" Inner Join sii_detalle_rubro dr on (drc.dru_codigo = dr.dru_codigo)");
            sql.append(" Inner Join sii_dtlle_fuente_financiacion dff on ( dr.dff_codigo = dff.dff_codigo)");
            sql.append(" Inner Join sii_fuente_financiacion ff on (dff.ffi_codigo = ff.ffi_codigo)");
            sql.append(" Inner Join pr_rubro ru on (dr.vigencia = ru.vigencia and dr.interno = ru.interno)");
            sql.append(" Inner Join sii_estado_modific_rp  emr on (mr.emr_codigo = emr.emr_codigo)");
            sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
            sql.append(" where mr.mrp_tipo_modif ='D'");
            sql.append(" and emr.emr_nombre='APROBADO'");
            sql.append(" and crp.cdp_codigo = #idCdp");
            sql.append(" and rp.RP_CODIGO = #IdRp ");
            sql.append(" group by  dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,");
            sql.append(" Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo ");*/
            sql.append("   ) s");// Se reemplaza esta linea por el fragmento de codigo comentareado anteriormente, para no contemplar incrementos y decrementos RP en la consulta del valor puro del RP.
            sql.append(" group by s.dffdescr,s.ffdesc, s.rudesc, s.rpsaldoanterior,s.codrubro");           
                       
            /*sql.append(" select sum(s.val), s.idrp,s.dffdescr,s.ffdesc, s.rudesc, s.rpvalor,s.rpsaldoanterior ,s.codrubro from ( select sum (drc.dru_valor) val,rpdet.rdr_codigo idrp,dff.dff_descripcion dffdescr,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000','') ffdesc, ru.descripcion rudesc,rpdet.rdr_valor rpvalor,rpdet.Rdr_Saldo_Anterior rpsaldoanterior,drc.drc_codigo codrubro");
            sql.append(" from sii_detalle_rubro_cdp drc,sii_detalle_rubro dr,");
            sql.append(" sii_dtlle_fuente_financiacion dff, sii_fuente_financiacion ff,pr_rubro ru, sii_rp_det_rubro_cdp rpdet,sii_rp rp");
            sql.append(" where drc.dru_codigo = dr.dru_codigo");
            sql.append(" and dr.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" and dff.dff_codigo = dr.dff_codigo");
            sql.append(" and dr.vigencia = ru.vigencia");
            sql.append(" and dr.interno = ru.interno");
            sql.append(" and drc.drc_codigo = rpdet.drc_Codigo");
            sql.append(" and rpdet.rp_codigo = rp.rp_codigo");
            sql.append(" and rp.rp_codigo = #IdRp");
            sql.append(" group by rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo");
            sql.append(" UNION ALL");
            sql.append(" select sum(md.mcr_valor),rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo");
            sql.append(" from sii_modif_cdp_det_rub_cdp md,sii_modificacion_cdp mc, sii_estado_modif_cdp es,");
            sql.append(" sii_detalle_rubro_cdp drc ,sii_detalle_rubro dr,");
            sql.append(" sii_dtlle_fuente_financiacion dff, sii_fuente_financiacion ff,pr_rubro ru, sii_rp_det_rubro_cdp rpdet,sii_rp rp");
            sql.append(" where drc.drc_codigo = md.drc_codigo");
            sql.append(" and md.mcd_codigo = mc.mcd_codigo");
            sql.append(" and mc.mcd_tipo_mod='I'");
            sql.append(" and mc.emc_codigo = es.emc_codigo");
            sql.append(" and es.emc_nombre='APROBADO'");
            sql.append(" and drc.dru_codigo = dr.dru_codigo");
            sql.append(" and dr.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" and dff.dff_codigo = dr.dff_codigo");
            sql.append(" and dr.vigencia = ru.vigencia");
            sql.append(" and dr.interno = ru.interno");
            sql.append(" and drc.drc_codigo = rpdet.drc_Codigo");
            sql.append(" and rpdet.rp_codigo = rp.rp_codigo");
            sql.append(" and rp.rp_codigo = #IdRp");
            sql.append(" group by rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo");
            sql.append(" UNION ALL");
            sql.append(" select -sum(md.mcr_valor),rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo");
            sql.append(" from sii_modif_cdp_det_rub_cdp md,sii_modificacion_cdp mc, sii_estado_modif_cdp es,");
            sql.append(" sii_detalle_rubro_cdp drc ,sii_detalle_rubro dr,");
            sql.append(" sii_dtlle_fuente_financiacion dff, sii_fuente_financiacion ff,pr_rubro ru , sii_rp_det_rubro_cdp rpdet,sii_rp rp");
            sql.append(" where drc.drc_codigo = md.drc_codigo");
            sql.append(" and md.mcd_codigo = mc.mcd_codigo");
            sql.append(" and mc.mcd_tipo_mod='D'");
            sql.append(" and mc.emc_codigo = es.emc_codigo");
            sql.append(" and es.emc_nombre='APROBADO'");
            sql.append(" and drc.dru_codigo = dr.dru_codigo");
            sql.append(" and dr.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
            sql.append(" and dff.dff_codigo = dr.dff_codigo");
            sql.append(" and dr.vigencia = ru.vigencia");
            sql.append(" and dr.interno = ru.interno");
            sql.append(" and drc.drc_codigo = rpdet.drc_Codigo");
            sql.append(" and rpdet.rp_codigo = rp.rp_codigo");
            sql.append(" and rp.rp_codigo = #IdRp");
            sql.append(" group by rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo" );
            sql.append(" UNION ALL");
            sql.append(" select -sum(mrd.mrd_valor),rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo ");
            sql.append(" from sii_modif_rp_det_rub_cdp mrd");
            sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
            sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
            sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
            sql.append(" Inner Join sii_detalle_rubro_cdp drc on (rpdet.drc_codigo = drc.drc_codigo)");
            sql.append(" Inner Join sii_detalle_rubro dr on (drc.dru_codigo = dr.dru_codigo)");
            sql.append(" Inner Join sii_dtlle_fuente_financiacion dff on ( dr.dff_codigo = dff.dff_codigo)");
            sql.append(" Inner Join sii_fuente_financiacion ff on (dff.ffi_codigo = ff.ffi_codigo)");
            sql.append(" Inner Join pr_rubro ru on (dr.vigencia = ru.vigencia and dr.interno = ru.interno)");
            sql.append(" Inner Join sii_estado_modific_rp  emr on (mr.emr_codigo = emr.emr_codigo)");
            sql.append(" where mr.mrp_tipo_modif ='I'");
            sql.append(" and emr.emr_nombre='APROBADO'");
            sql.append(" and rp.rp_codigo = #IdRp");
            sql.append(" group by rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo ");
            sql.append(" UNION ALL");
            sql.append(" select sum(mrd.mrd_valor),rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo ");
            sql.append(" from sii_modif_rp_det_rub_cdp mrd");
            sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
            sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
            sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
            sql.append(" Inner Join sii_detalle_rubro_cdp drc on (rpdet.drc_codigo = drc.drc_codigo)");
            sql.append(" Inner Join sii_detalle_rubro dr on (drc.dru_codigo = dr.dru_codigo)");
            sql.append(" Inner Join sii_dtlle_fuente_financiacion dff on ( dr.dff_codigo = dff.dff_codigo)");
            sql.append(" Inner Join sii_fuente_financiacion ff on (dff.ffi_codigo = ff.ffi_codigo)");
            sql.append(" Inner Join pr_rubro ru on (dr.vigencia = ru.vigencia and dr.interno = ru.interno)");
            sql.append(" Inner Join sii_estado_modific_rp  emr on (mr.emr_codigo = emr.emr_codigo)");
            sql.append(" where mr.mrp_tipo_modif ='D'");
            sql.append(" and emr.emr_nombre='APROBADO'");
            sql.append(" and rp.rp_codigo = #IdRp");
            sql.append(" group by rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion||decode(drc.DRC_APLICA_GMF,'S','-4x1000',''), ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior,drc.drc_codigo  ) s ");           
            sql.append(" group by s.idrp,s.dffdescr,s.ffdesc, s.rudesc, s.rpvalor,s.rpsaldoanterior,s.codrubro");*/
            

            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("IdRp",IdRp);
            query.setParameter("idCdp",idCdp);
            
            List<Object[]> results = query.getResultList();
            for(Object[] object : results){
                CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();                
                rfdcVo.setDesRubro((String) object[3]); 
                rfdcVo.setDtlleFuente((String) object[1]);                           //Descripción Rubro                
                rfdcVo.setDesFuente((String) object[2]);                            //Descripción Fuente
                rfdcVo.setSaldo((BigDecimal) object[0]);                            //Valor
                rfdcVo.setValorRp((BigDecimal) object[4]);
                //rfdcVo.setIdRpDetRubroCdp(((BigDecimal) object[1]).longValue());
                rfdcVo.setSaldoAnterior((BigDecimal) object[5]);
                rfdcVo.setIdDetRubCdp(((BigDecimal) object[6]).longValue());
                
                listaRubroFteDetPorCdpVo.add(rfdcVo);
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
        return listaRubroFteDetPorCdpVo;
    }
   
   //*******************
   public CdpRubroDetalleFuenteVO buscarSaldoPorCdp(Long IdCdp, Long IdRubro) throws ExcepcionDAO {
        CdpRubroDetalleFuenteVO rfdcVo = null; 
        try{
            StringBuilder sql = new StringBuilder();                     
            /*sql.append(" select sum(s.val),s.cdp from (");
            sql.append(" select sum(det.dru_valor) val, cdpPadre.cdp_codigo cdp");
            sql.append(" from SII_DETALLE_RUBRO_CDP det, sii_cdp cdpPadre");
            sql.append(" where det.cdp_codigo = cdpPadre.cdp_codigo");
            sql.append(" and cdpPadre.cdp_codigo = #IdCdp");
            sql.append(" group by cdpPadre.cdp_codigo");
            sql.append(" union all");
            sql.append(" select sum(m.mcr_valor), c.cdp_codigo");
            sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc");
            sql.append(" where c.drc_codigo = m.drc_codigo");
            sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
            sql.append(" and mcd.mcd_tipo_mod = 'I'");
            sql.append(" and emc.emc_codigo = mcd.emc_codigo");
            sql.append(" and emc.emc_nombre = 'APROBADO'");
            sql.append(" and c.cdp_codigo = #IdCdp");
            sql.append(" group by  c.cdp_codigo");
            sql.append(" union all");
            sql.append(" select -sum(m.mcr_valor), c.cdp_codigo");
            sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc");
            sql.append(" where c.drc_codigo = m.drc_codigo");
            sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
            sql.append(" and mcd.mcd_tipo_mod = 'D'");
            sql.append(" and emc.emc_codigo = mcd.emc_codigo");
            sql.append(" and emc.emc_nombre = 'APROBADO'");
            sql.append(" and c.cdp_codigo = #IdCdp");
            sql.append(" group by  c.cdp_codigo");
            sql.append(" union all");
            sql.append(" select -sum(rd.rdr_valor),c.cdp_codigo");
            sql.append(" from sii_rp_det_rubro_cdp rd, sii_rp r,sii_cdp c, Sii_Estado_Rp esrp");
            sql.append(" where rd.rp_codigo=r.rp_codigo");
            sql.append(" and r.cdp_codigo = c.cdp_codigo");
            sql.append(" and c.cdp_codigo = #IdCdp");
            sql.append(" and r.erp_codigo = Esrp.Erp_Codigo");
            sql.append(" and Esrp.Erp_Nombre = 'RP APROBADO'");
            sql.append(" group by c.cdp_codigo ) s");
            sql.append(" group by s.cdp");*/
            
            sql.append(" select sum(s.val),s.cdp from (");
            sql.append(" select det.dru_valor val, cdpPadre.cdp_codigo cdp");
            sql.append(" from SII_DETALLE_RUBRO_CDP det, sii_cdp cdpPadre");
            sql.append(" where det.cdp_codigo = cdpPadre.cdp_codigo");
            sql.append(" and cdpPadre.cdp_codigo = #IdCdp");
            sql.append(" and det.drc_codigo = #IdRubro");
            sql.append(" union all");
            sql.append(" select m.mcr_valor, c.cdp_codigo");
            sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc");
            sql.append(" where c.drc_codigo = m.drc_codigo");
            sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
            sql.append(" and mcd.mcd_tipo_mod = 'I'");
            sql.append(" and emc.emc_codigo = mcd.emc_codigo");
            sql.append(" and emc.emc_nombre = 'APROBADO'");
            sql.append(" and c.cdp_codigo = #IdCdp");
            sql.append(" and c.drc_codigo = #IdRubro");
            sql.append(" union all");
            sql.append(" select -m.mcr_valor, c.cdp_codigo");
            sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc");
            sql.append(" where c.drc_codigo = m.drc_codigo");
            sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
            sql.append(" and mcd.mcd_tipo_mod = 'D'");
            sql.append(" and emc.emc_codigo = mcd.emc_codigo");
            sql.append(" and emc.emc_nombre = 'APROBADO'");
            sql.append(" and c.cdp_codigo = #IdCdp");
            sql.append(" and c.drc_codigo = #IdRubro");
            sql.append(" union all");
            sql.append(" select - rd.rdr_valor,c.cdp_codigo");
            sql.append(" from sii_rp_det_rubro_cdp rd, sii_rp r,sii_cdp c, Sii_Estado_Rp esrp, sii_cdp_rp m");
            sql.append(" where rd.rp_codigo=r.rp_codigo");
            sql.append(" and rd.drc_codigo = #IdRubro");
            sql.append(" and r.rp_codigo = m.rp_codigo");
            sql.append(" and m.cdp_codigo = c.cdp_codigo ");
            sql.append(" and c.cdp_codigo = #IdCdp");
            sql.append(" and r.erp_codigo = Esrp.Erp_Codigo");
            sql.append(" and Esrp.Erp_Nombre = 'RP APROBADO' ");
            sql.append(" union all ");
            sql.append(" select -mrd.mrd_valor, cdp.cdp_codigo");
            sql.append(" from sii_modif_rp_det_rub_cdp mrd");
            sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
            sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
            sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
            sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
            sql.append(" Inner Join sii_cdp cdp on (crp.cdp_codigo = cdp.cdp_codigo)");
            sql.append(" Inner Join Sii_Estado_Modific_Rp emr on (mr.emr_codigo = emr.emr_codigo)");
            sql.append(" where cdp.cdp_codigo = #IdCdp");
            sql.append(" and rpdet.drc_codigo = #IdRubro");
            sql.append(" and mr.mrp_tipo_modif ='I'");
            sql.append(" and emr.emr_nombre = 'APROBADO'");
            sql.append(" union all");
            sql.append(" select mrd.mrd_valor, cdp.cdp_codigo");
            sql.append(" from sii_modif_rp_det_rub_cdp mrd");
            sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
            sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
            sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
            sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
            sql.append(" Inner Join sii_cdp cdp on (crp.cdp_codigo = cdp.cdp_codigo)");
            sql.append(" Inner Join Sii_Estado_Modific_Rp emr on (mr.emr_codigo = emr.emr_codigo)");
            sql.append(" where cdp.cdp_codigo = #IdCdp");
            sql.append(" and rpdet.drc_codigo = #IdRubro");
            sql.append(" and mr.mrp_tipo_modif ='D'");
            sql.append(" and emr.emr_nombre = 'APROBADO'");
            sql.append(" ) s");
            sql.append(" group by s.cdp");
            
            
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("IdCdp",IdCdp);
            query.setParameter("IdRubro",IdRubro);
            
            List<Object[]> results = query.getResultList();
            for(Object[] object : results){
                rfdcVo = new CdpRubroDetalleFuenteVO();                
                rfdcVo.setIdCdp(IdCdp); 
                rfdcVo.setSaldo((BigDecimal) object[0]); 
                
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
        return rfdcVo;
    }
   
   //*****************
   public List<CdpRubroDetalleFuenteVO> buscarRubrosPorCdp(Long IdCdp) throws ExcepcionDAO {
        List<CdpRubroDetalleFuenteVO> listaCdpRubroDetalleFuenteVO = new ArrayList<CdpRubroDetalleFuenteVO>(); 
        try{
            StringBuilder sql = new StringBuilder();                     
            sql.append(" select det.dru_valor val, det.drc_codigo idDetRubCdp, ru.descripcion rubdescr" );
            sql.append(" , dff.dff_descripcion dffdescr, ff.ffi_descripcion  ffdescr");
            sql.append(" from SII_DETALLE_RUBRO_CDP det,pr_rubro ru,Sii_Detalle_Rubro detru");
            sql.append(" ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff");
            sql.append(" where ru.vigencia = detru.vigencia");
            sql.append(" and ru.interno = detru.interno");
            sql.append(" and detru.dru_codigo = det.dru_codigo");
            sql.append(" and det.cdp_codigo = #IdCdp");
            sql.append(" and detru.dff_codigo = dff.dff_codigo");
            sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
                       
            
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("IdCdp",IdCdp);
            
            List<Object[]> results = query.getResultList();
            for(Object[] object : results){
                CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();                
                rfdcVo.setIdCdp(IdCdp); 
                rfdcVo.setSaldo((BigDecimal) object[0]); 
                rfdcVo.setDesRubro((String) object[2]);
                rfdcVo.setDesFuente((String) object[4]);
                rfdcVo.setDtlleFuente((String) object[3]);
                rfdcVo.setIdDetRubCdp(((BigDecimal) object[1]).longValue());
                listaCdpRubroDetalleFuenteVO.add(rfdcVo);
                
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
        return listaCdpRubroDetalleFuenteVO;
    }
   
    public List<CdpRubroDetalleFuenteVO> buscarIncrementosPorRubro(Long Idrubro) throws ExcepcionDAO {
         List<CdpRubroDetalleFuenteVO> listaCdpRubroDetalleFuenteVO = new ArrayList<CdpRubroDetalleFuenteVO>(); 
         try{
             StringBuilder sql = new StringBuilder();                     
             sql.append(" select sum(m.mcr_valor), c.drc_codigo,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion" );
             sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc,");
             sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff");
             sql.append(" where c.drc_codigo = m.drc_codigo");
             sql.append(" and mcd.mcd_codigo = m.mcd_codigo ");
             sql.append(" and mcd.mcd_tipo_mod = 'I'");
             sql.append(" and emc.emc_codigo = mcd.emc_codigo");
             sql.append(" and emc.emc_nombre = 'APROBADO'");
             sql.append(" and c.drc_codigo = #Idrubro");
             sql.append(" and c.dru_codigo = detru.dru_codigo");
             sql.append(" and detru.vigencia = ru.vigencia");
             sql.append(" and detru.interno = ru.interno");
             sql.append(" and detru.dff_codigo = dff.dff_codigo");
             sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
             sql.append(" group by  c.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion");
                        
             
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("Idrubro",Idrubro);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();                
                 rfdcVo.setIdDetRubCdp(Idrubro); 
                 rfdcVo.setSaldo((BigDecimal) object[0]); 
                 rfdcVo.setDesRubro((String) object[2]);
                 rfdcVo.setDesFuente((String) object[4]);
                 rfdcVo.setDtlleFuente((String) object[3]);
                 listaCdpRubroDetalleFuenteVO.add(rfdcVo);
                 
             }
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return listaCdpRubroDetalleFuenteVO;
     }
    
    public List<CdpRubroDetalleFuenteVO> buscarDecrementosPorRubro(Long Idrubro) throws ExcepcionDAO {
         List<CdpRubroDetalleFuenteVO> listaCdpRubroDetalleFuenteVO = new ArrayList<CdpRubroDetalleFuenteVO>();  
         try{
             StringBuilder sql = new StringBuilder();                     
             sql.append(" select sum(m.mcr_valor), c.drc_codigo,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion" );
             sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc,");
             sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff");
             sql.append(" where c.drc_codigo = m.drc_codigo");
             sql.append(" and mcd.mcd_codigo = m.mcd_codigo ");
             sql.append(" and mcd.mcd_tipo_mod = 'D'");
             sql.append(" and emc.emc_codigo = mcd.emc_codigo");
             sql.append(" and emc.emc_nombre = 'APROBADO'");
             sql.append(" and c.drc_codigo = #Idrubro");
             sql.append(" and c.dru_codigo = detru.dru_codigo");
             sql.append(" and detru.vigencia = ru.vigencia");
             sql.append(" and detru.interno = ru.interno");
             sql.append(" and detru.dff_codigo = dff.dff_codigo");
             sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
             sql.append(" group by  c.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion");
                        
             
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("Idrubro",Idrubro);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();                
                 rfdcVo.setIdDetRubCdp(Idrubro); 
                 rfdcVo.setSaldo((BigDecimal) object[0]); 
                 rfdcVo.setDesRubro((String) object[2]);
                 rfdcVo.setDesFuente((String) object[4]);
                 rfdcVo.setDtlleFuente((String) object[3]);
                 listaCdpRubroDetalleFuenteVO.add(rfdcVo);
                 
             }
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return listaCdpRubroDetalleFuenteVO;
     }
    
    public List<CdpRubroDetalleFuenteVO> buscarRPPorRubro(Long Idrubro) throws ExcepcionDAO {
         List<CdpRubroDetalleFuenteVO> listaCdpRubroDetalleFuenteVO =new ArrayList<CdpRubroDetalleFuenteVO>();  
         try{
             StringBuilder sql = new StringBuilder();                     
             sql.append(" select sum(rd.rdr_valor),rd.drc_codigo" );
             sql.append(" from sii_rp_det_rubro_cdp rd, sii_rp r,sii_detalle_rubro_cdp c");
             sql.append(" where rd.rp_codigo=r.rp_codigo");
             sql.append(" and rd.drc_codigo = c.drc_codigo");
             sql.append(" and rd.drc_codigo = #Idrubro");
             sql.append(" group by rd.drc_codigo");
                                   
             
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("Idrubro",Idrubro);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();                
                 rfdcVo.setIdDetRubCdp(Idrubro); 
                 rfdcVo.setSaldo((BigDecimal) object[0]);                 
                 listaCdpRubroDetalleFuenteVO.add(rfdcVo);
                 
             }
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return listaCdpRubroDetalleFuenteVO;
     }


    public List<String> buscarObjetosPorCodigosRp(List<Long> rps) throws ExcepcionDAO {
        List<String> salida = new ArrayList();
        try{
            StringBuilder sql = new StringBuilder();
                
            if (rps!=null && !rps.isEmpty()) {
                
                sql.append("SELECT NVL(prc.PRC_OBJETO_C, NVL(cdp.CDP_OBJETO, cdp.CDP_OBJETO_CONT)) AS OBJETO "); 
                sql.append("FROM SII_CDP cdp ");
                sql.append("INNER JOIN SII_CDP_RP cdprp  ON  cdprp.CDP_CODIGO = cdp.CDP_CODIGO ");
                sql.append("LEFT JOIN SII_PROCESO_CONTRATACION prc  ON  prc.PRC_CODIGO = cdp.PRC_CODIGO ");
                sql.append("WHERE cdprp.RP_CODIGO IN (");
                
                Iterator<Long> it = rps.iterator();
                while (it.hasNext()) {
                    Long rp = it.next();
                    if (rp!=null) {
                        sql.append(rp);
                        
                        if (it.hasNext())
                            sql.append(", ");
                    }
                }
                
                sql.append(") ");
                
                Query query = manager.createNativeQuery(sql.toString());
                
                List<Object> results = query.getResultList();
                
                if (results!=null && !results.isEmpty()) {
                    for(Object object : results){
                        if (object!=null)
                            salida.add((String) object);
                    }
                }
            }
            
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
        }
        
        return salida;
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de un RP por medio del ID del Proveedor asociado.
     * @param idProveedor
     * @return List of SiiRp
     */
    public List<SiiRp> buscarRPPorIdProveedor (Long idProveedor) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rp FROM SiiRp rp ");
            sql.append("WHERE rp.siiProveedor.proCodigo = :proCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("proCodigo", idProveedor);
            List<SiiRp> listaRP = query.getResultList();
            return listaRP;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    public BigDecimal buscarTotalRpAprobadosPorCdp(Long idCdp) throws ExcepcionDAO {
         BigDecimal totalRp = new BigDecimal(0);
         try{
             StringBuilder sql = new StringBuilder();
             
            
             sql.append(" select sum(rd.rdr_valor) from sii_rp_det_rubro_cdp rd, sii_rp r,sii_detalle_rubro_cdp c,");
             sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff");
             sql.append(" where rd.rp_codigo=r.rp_codigo and r.cdp_codigo = c.cdp_codigo");
             sql.append(" and r.erp_codigo = 8");
             sql.append(" and c.cdp_codigo =#idCdp");
             sql.append(" and c.dru_codigo = detru.dru_codigo");
             sql.append(" and detru.vigencia = ru.vigencia");
             sql.append(" and detru.interno = ru.interno");
             sql.append(" and detru.dff_codigo = dff.dff_codigo");
             sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
             sql.append(" and c.drc_codigo = rd.drc_codigo"); 
             //sql.append(" group by rd.rdr_codigo");

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("idCdp",idCdp);
             
             //List<Object[]> results = query.getResultList();
             totalRp = (BigDecimal) query.getSingleResult();
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return totalRp;
     }
    
    
    
     /**
      * Realiza la consulta del Valor del RP (<i>incluye el valor de los rubros marcados con el Gravamen del Movimiento Financiero (4x1000)</i>).
      * @param rpCodigo - C&oacute;digo del RP.
      * @return Sumatoria de los valores de los detalles de rubro CDP.
      * @throws ExcepcionDAO
      */
     public BigDecimal consultarValorRP (Long rpCodigo) throws ExcepcionDAO 
     {
         return ( this.consultarValorRP(rpCodigo, true) );
     }
     
     
     
    /**
     * Realiza la consulta del Valor del RP <b>Sin incluir el valor de los rubros marcados con el Gravamen del Movimiento Financiero (4x1000)</b>.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return Sumatoria de los valores de los detalles de rubro CDP.
     * @throws ExcepcionDAO
     */
    public BigDecimal consultarValorRPSinGMF (Long rpCodigo) throws ExcepcionDAO 
    {
        return ( this.consultarValorRP(rpCodigo, false) );
    }
     
     
     
     
    /**
     * Realiza la consulta del Valor del RP.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param incluirGMF - Flag que determina si se incluye el valor de los rubros marcados con el Gravamen del Movimiento Financiero (4x1000).
     * @return Sumatoria de los valores de los detalles de rubro CDP.
     * @throws ExcepcionDAO
     */
    public BigDecimal consultarValorRP (Long rpCodigo, boolean incluirGMF) throws ExcepcionDAO 
    {
        BigDecimal valor = new BigDecimal(0);
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(rpdrc.rdrValor) FROM SiiRpDetRubroCdp rpdrc ");
            sql.append("WHERE rpdrc.siiRp.rpCodigo = :rpCodigo ");
            
            if (!incluirGMF) {
                sql.append("AND rpdrc.siiDetalleRubroCdp.drcAplicaGmf = :aplicaGmf ");
            }
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            
            if (!incluirGMF)
                query.setParameter("aplicaGmf", EnumDecision.NO.getId());
            
            
            valor = (BigDecimal) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException ne) {
            valor = new BigDecimal(0);
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return valor;
    }
     
    
    /**
     * Realiza la consulta del Valor del RP cuyos Rubros se encuentran asociados a la Fuente de Financiaci&oacute;n Contable suministrada.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return Sumatoria de los valores de los detalles de rubro CDP.
     * @throws ExcepcionDAO
     */
    public BigDecimal consultarValorRP (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        return ( this.consultarValorRP(rpCodigo, ffcCodigo, true) );
    }
    
    
     
     /**
      * Realiza la consulta del Valor del RP cuyos Rubros se encuentran asociados a la Fuente de Financiaci&oacute;n Contable suministrada.
      * @param rpCodigo - C&oacute;digo del RP.
      * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
      * @param incluirGMF - Flag que determina si se incluye el valor de los rubros marcados con el Gravamen del Movimiento Financiero (4x1000).
      * @return Sumatoria de los valores de los detalles de rubro CDP.
      * @throws ExcepcionDAO
      */
     public BigDecimal consultarValorRP (Long rpCodigo, String ffcCodigo, boolean incluirGMF) throws ExcepcionDAO 
     {
         BigDecimal valor = null;
         
         try {
             StringBuilder sql = new StringBuilder();
             sql.append("SELECT SUM(rdrc.rdrValor) FROM SiiRpDetRubroCdp rdrc ");
             sql.append("INNER JOIN SiiDetalleRubroCdp drc  ON  drc.drcCodigo = rdrc.siiDetalleRubroCdp.drcCodigo ");
             sql.append("INNER JOIN SiiDetalleRubro dr  ON  dr.druCodigo = drc.siiDetalleRubro.druCodigo ");
             sql.append("WHERE rdrc.siiRp.rpCodigo = :rpCodigo ");
             sql.append("AND dr.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
             
             if (!incluirGMF)
                sql.append("AND drc.drcAplicaGmf = :aplicaGmf ");
             
             Query query = manager.createQuery(sql.toString());
             query.setParameter("rpCodigo", rpCodigo);
             query.setParameter("ffcCodigo", ffcCodigo);
             
             if (!incluirGMF)
                 query.setParameter("aplicaGmf", EnumDecision.NO.getId());
             
             
             valor = (BigDecimal) query.getSingleResult();
         }
         catch (javax.persistence.NoResultException ne) {
             valor = new BigDecimal(0);
         }
         catch (PersistenceException pe) {
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         
         return valor;
     }
     
     
     
    /**
     * Realiza la consulta del Valor del RP cuyos Rubros se encuentran asociados a la Fuente de Financiaci&oacute;n suministrada.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param druCodigo - C&oacute;digo del Detalle Rubro.
     * @param dffCodigo - C&oacute;digo del Detalle de la Fuente de Financiaci&oacute;n.
     * @return Sumatoria de los valores de los detalles de rubro CDP.
     * @throws ExcepcionDAO
     */
    public BigDecimal consultarValorRP (Long rpCodigo, Long druCodigo, Long dffCodigo) throws ExcepcionDAO 
    {
        BigDecimal valor = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(rdrc.rdrValor) FROM SiiRpDetRubroCdp rdrc ");
            sql.append("INNER JOIN SiiDetalleRubroCdp drc  ON  drc.drcCodigo = rdrc.siiDetalleRubroCdp.drcCodigo ");
            sql.append("INNER JOIN SiiDetalleRubro dr  ON  dr.druCodigo = drc.siiDetalleRubro.druCodigo ");
            sql.append("INNER JOIN SiiDtlleFuenteFinanciacion dff  ON  dff.dffCodigo = dr.siiDtlleFuenteFinanciacion.dffCodigo "); 
            sql.append("INNER JOIN SiiFuenteFinanciacion ff  ON  ff.ffiCodigo = dff.siiFuenteFinanciacion.ffiCodigo ");
            sql.append("WHERE rdrc.siiRp.rpCodigo = :rpCodigo ");
            sql.append("AND dr.druCodigo = :druCodigo ");
            sql.append("AND dff.dffCodigo = :dffCodigo ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("dffCodigo", dffCodigo);
            
            valor = (BigDecimal) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException ne) {
            valor = new BigDecimal(0);
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return valor;
    }
     
     
     
     /**
      * Realiza la consulta de los Decrementos del RP cuyo Estado de la Modificaci&oacute;n se encuentre <i>APROBADO</i>.
      * @param rpCodigo - C&oacute;digo del RP.
      * @return Sumatoria de los valores de los detalles de rubro CDP.
      * @throws ExcepcionDAO
      */
     public BigDecimal consultarDecrementosRP (Long rpCodigo) throws ExcepcionDAO 
     {
         // consultar decrementos para modificaciones RP en estado APROBADO
         return (this.consultarDecrementosRP(rpCodigo, EnumEstadoModificRP.APROBADO.getId()));
     }
     
     
     
     /**
      * Realiza la consulta de los Decrementos del RP donde el Estado de la Modificaci&oacute;n se encuentre <i>APROBADO</i> y cuyos Rubros se encuentran asociados a la Fuente de Financiaci&oacute;n suministrada.
      * @param rpCodigo - C&oacute;digo del RP.
      * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
      * @return Sumatoria de los valores de los detalles de rubro CDP.
      * @throws ExcepcionDAO
      */
     public BigDecimal consultarDecrementosRP (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
     {
         // consultar decrementos para modificaciones RP en estado APROBADO
         return (this.consultarDecrementosRP(rpCodigo, EnumEstadoModificRP.APROBADO.getId(), ffcCodigo));
     }
     
     
     /**
      * Realiza la consulta de los Decrementos del RP.
      * @param rpCodigo - C&oacute;digo del RP.
      * @param emrCodigo - C&oacute;digo del Estado de Modificaci&oacute;n del RP.
      * @return Sumatoria de los valores de los detalles de rubro CDP.
      * @throws ExcepcionDAO
      */
     public BigDecimal consultarDecrementosRP (Long rpCodigo, Long emrCodigo) throws ExcepcionDAO 
     {
         BigDecimal decrementos = null;
         
         try {
             StringBuilder sql = new StringBuilder();
             sql.append("SELECT SUM(mrpdrc.mrdValor) FROM SiiModifRpDetRubCdp mrpdrc, ");
             sql.append("                                 SiiModificacionRp mrp, ");
             sql.append("                                 SiiEstadoModificRp emrp ");
             sql.append("WHERE mrpdrc.siiModificacionRp.mrpCodigo = mrp.mrpCodigo ");
             sql.append("AND mrp.siiEstadoModificRp.emrCodigo = emrp.emrCodigo ");
             sql.append("AND emrp.emrCodigo = :emrCodigo ");
             sql.append("AND mrp.siiRp1.rpCodigo = :rpCodigo ");
             sql.append("AND mrp.mrpTipoModif = :mrpTipoModif ");
             
             Query query = manager.createQuery(sql.toString());
             query.setParameter("rpCodigo", rpCodigo);
             query.setParameter("emrCodigo", emrCodigo);
             query.setParameter("mrpTipoModif", EnumTipoModificacionRP.DECREMENTO.getId());
             
             decrementos = (BigDecimal) query.getSingleResult();
         }
         catch (javax.persistence.NoResultException ne) {
             decrementos = new BigDecimal(0);
         }
         catch (PersistenceException pe) {
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         
         return decrementos;
     }
     
     
     
     /**
      * Realiza la consulta de los Decrementos del RP cuyos Rubros se encuentran asociados a la Fuente de Financiaci&oacute;n suministrada.
      * @param rpCodigo - C&oacute;digo del RP.
      * @param emrCodigo - C&oacute;digo del Estado de Modificaci&oacute;n del RP.
      * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
      * @return Sumatoria de los valores de los detalles de rubro CDP.
      * @throws ExcepcionDAO
      */
     public BigDecimal consultarDecrementosRP (Long rpCodigo, Long emrCodigo, String ffcCodigo) throws ExcepcionDAO 
     {
         BigDecimal decrementos = null;
         
         try {
             StringBuilder sql = new StringBuilder();
             sql.append("SELECT SUM(mrpdrc.mrdValor) FROM SiiModifRpDetRubCdp mrpdrc ");
             sql.append("INNER JOIN SiiModificacionRp mrp  ON  mrp.mrpCodigo = mrpdrc.siiModificacionRp.mrpCodigo ");
             sql.append("INNER JOIN SiiEstadoModificRp emrp  ON  emrp.emrCodigo = mrp.siiEstadoModificRp.emrCodigo ");
             sql.append("INNER JOIN SiiRpDetRubroCdp rdrc  ON   rdrc.rdrCodigo = mrpdrc.siiRpDetRubroCdp.rdrCodigo "); 
             sql.append("INNER JOIN SiiDetalleRubroCdp drc  ON  drc.drcCodigo = rdrc.siiDetalleRubroCdp.drcCodigo ");
             sql.append("INNER JOIN SiiDetalleRubro dr  ON  dr.druCodigo = drc.siiDetalleRubro.druCodigo ");
             sql.append("WHERE emrp.emrCodigo = :emrCodigo ");
             sql.append("AND mrp.siiRp1.rpCodigo = :rpCodigo ");
             sql.append("AND mrp.mrpTipoModif = :mrpTipoModif ");
             sql.append("AND dr.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
             sql.append("AND drc.drcAplicaGmf = :drcAplicaGmf ");
             
             Query query = manager.createQuery(sql.toString());
             query.setParameter("rpCodigo", rpCodigo);
             query.setParameter("emrCodigo", emrCodigo);
             query.setParameter("mrpTipoModif", EnumTipoModificacionRP.DECREMENTO.getId());
             query.setParameter("drcAplicaGmf", EnumDecision.NO.getId());
             query.setParameter("ffcCodigo", ffcCodigo);
             
             decrementos = (BigDecimal) query.getSingleResult();
         }
         catch (javax.persistence.NoResultException ne) {
             decrementos = new BigDecimal(0);
         }
         catch (PersistenceException pe) {
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         
         return decrementos;
    }
     

    
    /**
     * Realiza la consulta de los Incrementos del RP cuyo Estado de la Modificaci&oacute;n se encuentre <i>APROBADO</i>.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return Sumatoria de los valores de los detalles de rubro CDP.
     * @throws ExcepcionDAO
     */
    public BigDecimal consultarIncrementosRP (Long rpCodigo) throws ExcepcionDAO 
    {
        // consultar incrementos para modificaciones RP en estado APROBADO
        return (this.consultarIncrementosRP(rpCodigo, EnumEstadoModificRP.APROBADO.getId()));
    }
    
    
    
    /**
     * Realiza la consulta de los Incrementos del RP donde el Estado de la Modificaci&oacute;n se encuentre <i>APROBADO</i> y cuyos Rubros se encuentran asociados a la Fuente de Financiaci&oacute;n suministrada.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return Sumatoria de los valores de los detalles de rubro CDP.
     * @throws ExcepcionDAO
     */
    public BigDecimal consultarIncrementosRP (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        // consultar incrementos para modificaciones RP en estado APROBADO
        return (this.consultarIncrementosRP(rpCodigo, EnumEstadoModificRP.APROBADO.getId(), ffcCodigo));
    }
    
    
    /**
     * Realiza la consulta de los Incrementos del RP.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param emrCodigo - C&oacute;digo del Estado de Modificaci&oacute;n del RP.
     * @return Sumatoria de los valores de los detalles de rubro CDP.
     * @throws ExcepcionDAO
     */
    public BigDecimal consultarIncrementosRP (Long rpCodigo, Long emrCodigo) throws ExcepcionDAO 
    {
        return ( this.consultarIncrementosRP(rpCodigo, emrCodigo, null) );
    }
    
    
    
    /**
     * Realiza la consulta de los Incrementos del RP cuyos Rubros se encuentran asociados a la Fuente de Financiaci&oacute;n suministrada.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param emrCodigo - C&oacute;digo del Estado de Modificaci&oacute;n del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return Sumatoria de los valores de los detalles de rubro CDP.
     * @throws ExcepcionDAO
     */
    public BigDecimal consultarIncrementosRP (Long rpCodigo, Long emrCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        BigDecimal incrementos = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(mrpdrc.mrdValor) FROM SiiModifRpDetRubCdp mrpdrc ");
            sql.append("INNER JOIN SiiModificacionRp mrp  ON  mrp.mrpCodigo = mrpdrc.siiModificacionRp.mrpCodigo ");
            sql.append("INNER JOIN SiiEstadoModificRp emrp  ON  emrp.emrCodigo = mrp.siiEstadoModificRp.emrCodigo ");
            
            if (ffcCodigo!=null) {
                sql.append("INNER JOIN SiiRpDetRubroCdp rdrc  ON   rdrc.rdrCodigo = mrpdrc.siiRpDetRubroCdp.rdrCodigo "); 
                sql.append("INNER JOIN SiiDetalleRubroCdp drc  ON  drc.drcCodigo = rdrc.siiDetalleRubroCdp.drcCodigo ");
                sql.append("INNER JOIN SiiDetalleRubro dr  ON  dr.druCodigo = drc.siiDetalleRubro.druCodigo ");
            }
            
            sql.append("WHERE emrp.emrCodigo = :emrCodigo ");
            sql.append("AND mrp.siiRp1.rpCodigo = :rpCodigo ");
            sql.append("AND mrp.mrpTipoModif = :mrpTipoModif ");
            
            if (ffcCodigo!=null) {
                sql.append("AND dr.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
            }
            
            sql.append("AND drc.drcAplicaGmf = :drcAplicaGmf ");
            
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            query.setParameter("emrCodigo", emrCodigo);
            query.setParameter("mrpTipoModif", EnumTipoModificacionRP.INCREMENTO.getId());
            query.setParameter("drcAplicaGmf", EnumDecision.NO.getId());
            
            if (ffcCodigo!=null) {
                query.setParameter("ffcCodigo", ffcCodigo);
            }
            
            incrementos = (BigDecimal) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException ne) {
            incrementos = new BigDecimal(0);
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return incrementos;
    }
    
    
    
    public List<CdpRubroDetalleFuenteVO> reporteDetallePorRp(Long IdRp) throws ExcepcionDAO {
         List<CdpRubroDetalleFuenteVO> listaRubroFteDetPorCdpVo = new ArrayList<CdpRubroDetalleFuenteVO>();
         try{
             StringBuilder sql = new StringBuilder();            
                        
             sql.append(" SELECT PR.SII_RP_DET_RUBRO_CDP.RDR_VALOR,");
             sql.append(" PR.SII_FUENTE_FINANCIACION.FFI_CODIGO_FUENTE,");
             sql.append(" PR.SII_FUENTE_FINANCIACION.FFI_DESCRIPCION||decode(SII_DETALLE_RUBRO_CDP.DRC_APLICA_GMF,'S','-4x1000',''),");
             sql.append(" PR.PR_RUBRO.DESCRIPCION,PR.SII_DETALLE_RUBRO.DRU_CODIGO,");
             sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
             sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
             sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
             sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
             sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
             sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
             sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
             sql.append(" PR.SII_DETALLE_RUBRO.VIGENCIA,");
             sql.append(" PR.SII_RP.RP_CODIGO");
             sql.append(" FROM PR.SII_RP");
             sql.append(" INNER JOIN PR.SII_RP_DET_RUBRO_CDP");
             sql.append(" ON (PR.SII_RP.RP_CODIGO = PR.SII_RP_DET_RUBRO_CDP.RP_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DETALLE_RUBRO_CDP");
             sql.append(" ON (PR.SII_DETALLE_RUBRO_CDP.DRC_CODIGO = PR.SII_RP_DET_RUBRO_CDP.DRC_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DETALLE_RUBRO");
             sql.append(" ON (PR.SII_DETALLE_RUBRO.DRU_CODIGO = PR.SII_DETALLE_RUBRO_CDP.DRU_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DTLLE_FUENTE_FINANCIACION");
             sql.append(" ON (PR.SII_DTLLE_FUENTE_FINANCIACION.DFF_CODIGO = PR.SII_DETALLE_RUBRO.DFF_CODIGO)");
             sql.append(" INNER JOIN PR.SII_FUENTE_FINANCIACION");
             sql.append(" ON (PR.SII_FUENTE_FINANCIACION.FFI_CODIGO = PR.SII_DTLLE_FUENTE_FINANCIACION.FFI_CODIGO)");
             sql.append(" INNER JOIN PR.PR_RUBRO");
             sql.append(" ON PR.PR_RUBRO.VIGENCIA   = PR.SII_DETALLE_RUBRO.VIGENCIA");
             sql.append(" AND PR.PR_RUBRO.INTERNO   = PR.SII_DETALLE_RUBRO.INTERNO");
             sql.append(" Inner Join Pr_Nivel1 Nivel1 On PR.PR_RUBRO.Vigencia = Nivel1.Vigencia And PR.PR_RUBRO.Interno_Nivel1 = Nivel1.Interno");
             sql.append(" Left  Join Pr_Nivel2 Nivel2 On PR.PR_RUBRO.Vigencia = Nivel2.Vigencia And PR.PR_RUBRO.Interno_Nivel2 = Nivel2.Interno");
             sql.append(" Left  Join Pr_Nivel3 Nivel3 On PR.PR_RUBRO.Vigencia = Nivel3.Vigencia And PR.PR_RUBRO.Interno_Nivel3 = Nivel3.Interno");
             sql.append(" Left  Join Pr_Nivel4 Nivel4 On PR.PR_RUBRO.Vigencia = Nivel4.Vigencia And PR.PR_RUBRO.Interno_Nivel4 = Nivel4.Interno");
             sql.append(" Left  Join Pr_Nivel5 Nivel5 On PR.PR_RUBRO.Vigencia = Nivel5.Vigencia And PR.PR_RUBRO.Interno_Nivel5 = Nivel5.Interno");
             sql.append(" Left  Join Pr_Nivel6 Nivel6 On PR.PR_RUBRO.Vigencia = Nivel6.Vigencia And PR.PR_RUBRO.Interno_Nivel6 = Nivel6.Interno");
             sql.append(" Left  Join Pr_Nivel7 Nivel7 On PR.PR_RUBRO.Vigencia = Nivel7.Vigencia And PR.PR_RUBRO.Interno_Nivel7 = Nivel7.Interno");             
             sql.append(" WHERE PR.SII_RP.RP_CODIGO =#IdRp and PR.SII_RP_DET_RUBRO_CDP.RDR_VALOR<>0");             

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("IdRp",IdRp);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();                   
                 rfdcVo.setValorRp((BigDecimal) object[0]);
                 rfdcVo.setIdFuente(((BigDecimal) object[1]).longValue());
                 rfdcVo.setDesFuente((String) object[2]);
                 rfdcVo.setDesRubro((String) object[3]);
                 rfdcVo.setIdRubro(((BigDecimal) object[4]).longValue());  
                 rfdcVo.setCadena((String) object[5]);
                 BigDecimal vigencia = (BigDecimal) object[6];
                 if (vigencia!=null)
                    rfdcVo.setVigencia(new Integer(vigencia.intValue()));
                 BigDecimal rpCod = (BigDecimal) object[7];
                 if (rpCod!=null)
                    rfdcVo.setIdRp(new Long(rpCod.longValue()));
                 
                 listaRubroFteDetPorCdpVo.add(rfdcVo);
             }
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return listaRubroFteDetPorCdpVo;
     }
    
    
    
    public List<SiiRp>  buscarRpPorIdProcesoContratacion (Long idProcesoContratacion) throws ExcepcionDAO {
        List<SiiRp> listaRp = new ArrayList<SiiRp>();
        try{
            StringBuilder sql = new StringBuilder();            
            
            sql.append("SELECT rp FROM SiiRp rp " +
                "INNER JOIN rp.siiCdp cdp WHERE cdp.siiProcesoContratacion.prcCodigo = :idPc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPc", idProcesoContratacion);
            listaRp = query.getResultList();
            return listaRp;
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }        
    }
    
    public BigDecimal getGastosPersonal(Long IdRp) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();            
                        
             sql.append(" SELECT PR.SII_RP_DET_RUBRO_CDP.RDR_VALOR,");
             sql.append(" PR.SII_FUENTE_FINANCIACION.FFI_CODIGO_FUENTE,");
             sql.append(" PR.SII_FUENTE_FINANCIACION.FFI_DESCRIPCION,");
             sql.append(" PR.PR_RUBRO.DESCRIPCION,PR.SII_DETALLE_RUBRO.DRU_CODIGO,");
             sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
             sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
             sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
             sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
             sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
             sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
             sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
             sql.append(" PR.SII_DETALLE_RUBRO.VIGENCIA,");
             sql.append(" PR.SII_RP.RP_CODIGO");
             sql.append(" FROM PR.SII_RP");
             sql.append(" INNER JOIN PR.SII_RP_DET_RUBRO_CDP");
             sql.append(" ON (PR.SII_RP.RP_CODIGO = PR.SII_RP_DET_RUBRO_CDP.RP_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DETALLE_RUBRO_CDP");
             sql.append(" ON (PR.SII_DETALLE_RUBRO_CDP.DRC_CODIGO = PR.SII_RP_DET_RUBRO_CDP.DRC_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DETALLE_RUBRO");
             sql.append(" ON (PR.SII_DETALLE_RUBRO.DRU_CODIGO = PR.SII_DETALLE_RUBRO_CDP.DRU_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DTLLE_FUENTE_FINANCIACION");
             sql.append(" ON (PR.SII_DTLLE_FUENTE_FINANCIACION.DFF_CODIGO = PR.SII_DETALLE_RUBRO.DFF_CODIGO)");
             sql.append(" INNER JOIN PR.SII_FUENTE_FINANCIACION");
             sql.append(" ON (PR.SII_FUENTE_FINANCIACION.FFI_CODIGO = PR.SII_DTLLE_FUENTE_FINANCIACION.FFI_CODIGO)");
             sql.append(" INNER JOIN PR.PR_RUBRO");
             sql.append(" ON PR.PR_RUBRO.VIGENCIA   = PR.SII_DETALLE_RUBRO.VIGENCIA");
             sql.append(" AND PR.PR_RUBRO.INTERNO   = PR.SII_DETALLE_RUBRO.INTERNO");
             sql.append(" Inner Join Pr_Nivel1 Nivel1 On PR.PR_RUBRO.Vigencia = Nivel1.Vigencia And PR.PR_RUBRO.Interno_Nivel1 = Nivel1.Interno");
             sql.append(" Left  Join Pr_Nivel2 Nivel2 On PR.PR_RUBRO.Vigencia = Nivel2.Vigencia And PR.PR_RUBRO.Interno_Nivel2 = Nivel2.Interno");
             sql.append(" Left  Join Pr_Nivel3 Nivel3 On PR.PR_RUBRO.Vigencia = Nivel3.Vigencia And PR.PR_RUBRO.Interno_Nivel3 = Nivel3.Interno");
             sql.append(" Left  Join Pr_Nivel4 Nivel4 On PR.PR_RUBRO.Vigencia = Nivel4.Vigencia And PR.PR_RUBRO.Interno_Nivel4 = Nivel4.Interno");
             sql.append(" Left  Join Pr_Nivel5 Nivel5 On PR.PR_RUBRO.Vigencia = Nivel5.Vigencia And PR.PR_RUBRO.Interno_Nivel5 = Nivel5.Interno");
             sql.append(" Left  Join Pr_Nivel6 Nivel6 On PR.PR_RUBRO.Vigencia = Nivel6.Vigencia And PR.PR_RUBRO.Interno_Nivel6 = Nivel6.Interno");
             sql.append(" Left  Join Pr_Nivel7 Nivel7 On PR.PR_RUBRO.Vigencia = Nivel7.Vigencia And PR.PR_RUBRO.Interno_Nivel7 = Nivel7.Interno");             
             sql.append(" WHERE PR.SII_RP.RP_CODIGO =#IdRp");             
             sql.append(" AND PR.SII_FUENTE_FINANCIACION.FFI_CODIGO_FUENTE = 10");
             sql.append(" AND Nivel1.CODIGO = 2");
             sql.append(" AND Nivel2.CODIGO = 1");
             sql.append(" AND Nivel3.CODIGO = 1");
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("IdRp",IdRp);
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
             return total;
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }
    
    public BigDecimal getGastosGenerales(Long IdRp) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();            
                        
             sql.append(" SELECT PR.SII_RP_DET_RUBRO_CDP.RDR_VALOR,");
             sql.append(" PR.SII_FUENTE_FINANCIACION.FFI_CODIGO_FUENTE,");
             sql.append(" PR.SII_FUENTE_FINANCIACION.FFI_DESCRIPCION,");
             sql.append(" PR.PR_RUBRO.DESCRIPCION,PR.SII_DETALLE_RUBRO.DRU_CODIGO,");
             sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
             sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
             sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
             sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
             sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
             sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
             sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
             sql.append(" PR.SII_DETALLE_RUBRO.VIGENCIA,");
             sql.append(" PR.SII_RP.RP_CODIGO");
             sql.append(" FROM PR.SII_RP");
             sql.append(" INNER JOIN PR.SII_RP_DET_RUBRO_CDP");
             sql.append(" ON (PR.SII_RP.RP_CODIGO = PR.SII_RP_DET_RUBRO_CDP.RP_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DETALLE_RUBRO_CDP");
             sql.append(" ON (PR.SII_DETALLE_RUBRO_CDP.DRC_CODIGO = PR.SII_RP_DET_RUBRO_CDP.DRC_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DETALLE_RUBRO");
             sql.append(" ON (PR.SII_DETALLE_RUBRO.DRU_CODIGO = PR.SII_DETALLE_RUBRO_CDP.DRU_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DTLLE_FUENTE_FINANCIACION");
             sql.append(" ON (PR.SII_DTLLE_FUENTE_FINANCIACION.DFF_CODIGO = PR.SII_DETALLE_RUBRO.DFF_CODIGO)");
             sql.append(" INNER JOIN PR.SII_FUENTE_FINANCIACION");
             sql.append(" ON (PR.SII_FUENTE_FINANCIACION.FFI_CODIGO = PR.SII_DTLLE_FUENTE_FINANCIACION.FFI_CODIGO)");
             sql.append(" INNER JOIN PR.PR_RUBRO");
             sql.append(" ON PR.PR_RUBRO.VIGENCIA   = PR.SII_DETALLE_RUBRO.VIGENCIA");
             sql.append(" AND PR.PR_RUBRO.INTERNO   = PR.SII_DETALLE_RUBRO.INTERNO");
             sql.append(" Inner Join Pr_Nivel1 Nivel1 On PR.PR_RUBRO.Vigencia = Nivel1.Vigencia And PR.PR_RUBRO.Interno_Nivel1 = Nivel1.Interno");
             sql.append(" Left  Join Pr_Nivel2 Nivel2 On PR.PR_RUBRO.Vigencia = Nivel2.Vigencia And PR.PR_RUBRO.Interno_Nivel2 = Nivel2.Interno");
             sql.append(" Left  Join Pr_Nivel3 Nivel3 On PR.PR_RUBRO.Vigencia = Nivel3.Vigencia And PR.PR_RUBRO.Interno_Nivel3 = Nivel3.Interno");
             sql.append(" Left  Join Pr_Nivel4 Nivel4 On PR.PR_RUBRO.Vigencia = Nivel4.Vigencia And PR.PR_RUBRO.Interno_Nivel4 = Nivel4.Interno");
             sql.append(" Left  Join Pr_Nivel5 Nivel5 On PR.PR_RUBRO.Vigencia = Nivel5.Vigencia And PR.PR_RUBRO.Interno_Nivel5 = Nivel5.Interno");
             sql.append(" Left  Join Pr_Nivel6 Nivel6 On PR.PR_RUBRO.Vigencia = Nivel6.Vigencia And PR.PR_RUBRO.Interno_Nivel6 = Nivel6.Interno");
             sql.append(" Left  Join Pr_Nivel7 Nivel7 On PR.PR_RUBRO.Vigencia = Nivel7.Vigencia And PR.PR_RUBRO.Interno_Nivel7 = Nivel7.Interno");             
             sql.append(" WHERE PR.SII_RP.RP_CODIGO =#IdRp");             
             sql.append(" AND PR.SII_FUENTE_FINANCIACION.FFI_CODIGO_FUENTE = 10");
             sql.append(" AND Nivel1.CODIGO = 2");
             sql.append(" AND Nivel2.CODIGO = 1");
             sql.append(" AND Nivel3.CODIGO = 2");
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("IdRp",IdRp);
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
             return total;
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }
    
    public BigDecimal getRecursosPropios(Long IdRp) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();            
                        
             sql.append(" SELECT PR.SII_RP_DET_RUBRO_CDP.RDR_VALOR,");
             sql.append(" PR.SII_FUENTE_FINANCIACION.FFI_CODIGO_FUENTE,");
             sql.append(" PR.SII_FUENTE_FINANCIACION.FFI_DESCRIPCION,");
             sql.append(" PR.PR_RUBRO.DESCRIPCION,PR.SII_DETALLE_RUBRO.DRU_CODIGO,");
             sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
             sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
             sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
             sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
             sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
             sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
             sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
             sql.append(" PR.SII_DETALLE_RUBRO.VIGENCIA,");
             sql.append(" PR.SII_RP.RP_CODIGO");
             sql.append(" FROM PR.SII_RP");
             sql.append(" INNER JOIN PR.SII_RP_DET_RUBRO_CDP");
             sql.append(" ON (PR.SII_RP.RP_CODIGO = PR.SII_RP_DET_RUBRO_CDP.RP_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DETALLE_RUBRO_CDP");
             sql.append(" ON (PR.SII_DETALLE_RUBRO_CDP.DRC_CODIGO = PR.SII_RP_DET_RUBRO_CDP.DRC_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DETALLE_RUBRO");
             sql.append(" ON (PR.SII_DETALLE_RUBRO.DRU_CODIGO = PR.SII_DETALLE_RUBRO_CDP.DRU_CODIGO)");
             sql.append(" INNER JOIN PR.SII_DTLLE_FUENTE_FINANCIACION");
             sql.append(" ON (PR.SII_DTLLE_FUENTE_FINANCIACION.DFF_CODIGO = PR.SII_DETALLE_RUBRO.DFF_CODIGO)");
             sql.append(" INNER JOIN PR.SII_FUENTE_FINANCIACION");
             sql.append(" ON (PR.SII_FUENTE_FINANCIACION.FFI_CODIGO = PR.SII_DTLLE_FUENTE_FINANCIACION.FFI_CODIGO)");
             sql.append(" INNER JOIN PR.PR_RUBRO");
             sql.append(" ON PR.PR_RUBRO.VIGENCIA   = PR.SII_DETALLE_RUBRO.VIGENCIA");
             sql.append(" AND PR.PR_RUBRO.INTERNO   = PR.SII_DETALLE_RUBRO.INTERNO");
             sql.append(" Inner Join Pr_Nivel1 Nivel1 On PR.PR_RUBRO.Vigencia = Nivel1.Vigencia And PR.PR_RUBRO.Interno_Nivel1 = Nivel1.Interno");
             sql.append(" Left  Join Pr_Nivel2 Nivel2 On PR.PR_RUBRO.Vigencia = Nivel2.Vigencia And PR.PR_RUBRO.Interno_Nivel2 = Nivel2.Interno");
             sql.append(" Left  Join Pr_Nivel3 Nivel3 On PR.PR_RUBRO.Vigencia = Nivel3.Vigencia And PR.PR_RUBRO.Interno_Nivel3 = Nivel3.Interno");
             sql.append(" Left  Join Pr_Nivel4 Nivel4 On PR.PR_RUBRO.Vigencia = Nivel4.Vigencia And PR.PR_RUBRO.Interno_Nivel4 = Nivel4.Interno");
             sql.append(" Left  Join Pr_Nivel5 Nivel5 On PR.PR_RUBRO.Vigencia = Nivel5.Vigencia And PR.PR_RUBRO.Interno_Nivel5 = Nivel5.Interno");
             sql.append(" Left  Join Pr_Nivel6 Nivel6 On PR.PR_RUBRO.Vigencia = Nivel6.Vigencia And PR.PR_RUBRO.Interno_Nivel6 = Nivel6.Interno");
             sql.append(" Left  Join Pr_Nivel7 Nivel7 On PR.PR_RUBRO.Vigencia = Nivel7.Vigencia And PR.PR_RUBRO.Interno_Nivel7 = Nivel7.Interno");             
             sql.append(" WHERE PR.SII_RP.RP_CODIGO =#IdRp");             
             sql.append(" AND PR.SII_FUENTE_FINANCIACION.FFI_CODIGO_FUENTE = 40");
 
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("IdRp",IdRp);
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
             return total;
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }

    public List<CdpRubroDetalleFuenteVO> bucarRubroFteDetPorCdps(String IdCdp) throws ExcepcionDAO {
      List<CdpRubroDetalleFuenteVO> listaRubroFteDetPorCdpVo = new ArrayList<CdpRubroDetalleFuenteVO>();
      try{
          StringBuilder sql = new StringBuilder();  
          sql.append(" select sum(s.val),s.idDetRubCdp , s.rubdescr, s.dffdescr, s.ffdescr, s.cdp, s.consecutivo  from (");
          sql.append(" select sum(det.dru_valor) val, det.drc_codigo idDetRubCdp, ru.descripcion rubdescr");
          sql.append(" , dff.dff_descripcion dffdescr, ff.ffi_descripcion  ffdescr, det.cdp_codigo cdp,cdp2.cdp_consecutivo consecutivo");
          sql.append(" from SII_DETALLE_RUBRO_CDP det,pr_rubro ru,Sii_Detalle_Rubro detru");
          sql.append(" ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff,sii_cdp cdp2");
          sql.append(" where ru.vigencia = detru.vigencia");
          sql.append(" and ru.interno = detru.interno");
          sql.append(" and detru.dru_codigo = det.dru_codigo");
          sql.append(" and det.cdp_codigo = cdp2.cdp_codigo");
          sql.append(" and det.cdp_codigo in( ");
          sql.append(IdCdp);
          sql.append(" ) and detru.dff_codigo = dff.dff_codigo");
          sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
          sql.append(" group by det.drc_codigo ,ru.descripcion , dff.dff_descripcion, ff.ffi_descripcion, det.cdp_codigo,cdp2.cdp_consecutivo ");
          sql.append(" union all");
          sql.append(" select sum(m.mcr_valor), c.drc_codigo,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo,cdp3.cdp_consecutivo");
          sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc,");
          sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff,sii_cdp cdp3");
          sql.append(" where c.drc_codigo = m.drc_codigo");
          sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
          sql.append(" and mcd.mcd_tipo_mod = 'I'");
          sql.append(" and emc.emc_codigo = mcd.emc_codigo");
          sql.append(" and emc.emc_nombre = 'APROBADO'");
          sql.append(" and c.cdp_codigo = cdp3.cdp_codigo");
          sql.append(" and c.cdp_codigo in (");
          sql.append(IdCdp);
          sql.append(" ) and c.dru_codigo = detru.dru_codigo");
          sql.append(" and detru.vigencia = ru.vigencia");
          sql.append(" and detru.interno = ru.interno");
          sql.append(" and detru.dff_codigo = dff.dff_codigo");
          sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
          sql.append(" group by  c.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo,cdp3.cdp_consecutivo");
          sql.append(" union all");
          sql.append(" select -sum(m.mcr_valor), c.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo,cdp4.cdp_consecutivo");
          sql.append(" from sii_modif_cdp_det_rub_cdp m, sii_detalle_rubro_cdp c, sii_modificacion_cdp mcd, sii_estado_modif_cdp emc,");
          sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff,sii_cdp cdp4 ");
          sql.append(" where c.drc_codigo = m.drc_codigo");
          sql.append(" and mcd.mcd_codigo = m.mcd_codigo");
          sql.append(" and mcd.mcd_tipo_mod = 'D'");
          sql.append(" and emc.emc_codigo = mcd.emc_codigo");
          sql.append(" and emc.emc_nombre = 'APROBADO'");
          sql.append(" and c.cdp_codigo = cdp4.cdp_codigo");
          sql.append(" and c.cdp_codigo in (");
          sql.append(IdCdp);
          sql.append(" ) and c.dru_codigo = detru.dru_codigo");
          sql.append(" and detru.vigencia = ru.vigencia"); 
          sql.append(" and detru.interno = ru.interno");
          sql.append(" and detru.dff_codigo = dff.dff_codigo");
          sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
          sql.append(" group by  c.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo,cdp4.cdp_consecutivo");
          sql.append(" union all");
          sql.append(" select -sum(rd.rdr_valor),rd.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo,cdp5.cdp_consecutivo");
          sql.append(" from sii_rp_det_rubro_cdp rd, sii_rp r,sii_detalle_rubro_cdp c,");
          sql.append(" pr_rubro ru,Sii_Detalle_Rubro detru ,sii_dtlle_fuente_financiacion dff, Sii_Fuente_Financiacion  ff,sii_cdp cdp5,sii_cdp_rp cdprp");
          sql.append(" where rd.rp_codigo=r.rp_codigo");
          sql.append(" and r.rp_codigo = cdprp.rp_codigo");
          sql.append(" and cdprp.cdp_codigo = c.cdp_codigo");
          sql.append(" and r.erp_codigo = 8");
          sql.append(" and c.cdp_codigo = cdp5.cdp_codigo");
          sql.append(" and c.cdp_codigo in (");
          sql.append(IdCdp);
          sql.append(" ) and c.dru_codigo = detru.dru_codigo");
          sql.append(" and detru.vigencia = ru.vigencia");
          sql.append(" and detru.interno = ru.interno");
          sql.append(" and detru.dff_codigo = dff.dff_codigo");
          sql.append(" and dff.ffi_codigo = ff.ffi_codigo ");
          sql.append(" and c.DRC_CODIGO = rd.DRC_CODIGO");
          sql.append(" group by rd.drc_codigo ,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo,cdp5.cdp_consecutivo ");
          sql.append(" union all");  
          sql.append(" select -sum(mrd.mrd_valor),c.drc_codigo,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo, cdp.cdp_consecutivo");
          sql.append(" from sii_modif_rp_det_rub_cdp mrd");
          sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
          sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
          sql.append(" Inner Join Sii_Cdp_Rp cdpr on (rp.rp_codigo = cdpr.rp_codigo)");
          sql.append(" Inner Join Sii_Rp_Det_Rubro_Cdp rpdet on (rpdet.rp_codigo =rp.rp_codigo and rpdet.rdr_codigo =mrd.rdr_codigo)");
          sql.append(" Inner Join Sii_Detalle_Rubro_Cdp c on (Rpdet.Drc_Codigo = c.drc_codigo and c.cdp_codigo =cdpr.cdp_codigo)");
          sql.append(" Inner Join sii_cdp cdp on (c.cdp_codigo = cdp.cdp_codigo)");
          sql.append(" Inner Join Sii_Estado_Modific_Rp emr on (mr.emr_codigo = emr.emr_codigo)");
          sql.append(" Inner Join sii_estado_cdp ecd on (cdp.ecd_codigo = ecd.ecd_codigo)");
          sql.append(" Inner Join Sii_Detalle_Rubro detru on (  c.dru_codigo = detru.dru_codigo)");
          sql.append(" Inner Join pr_rubro ru on ( detru.vigencia = ru.vigencia and detru.interno = ru.interno )");
          sql.append(" Inner Join sii_dtlle_fuente_financiacion dff on ( detru.dff_codigo = dff.dff_codigo )");
          sql.append(" Inner Join Sii_Fuente_Financiacion  ff on ( dff.ffi_codigo = ff.ffi_codigo )");
          sql.append(" where  mr.mrp_tipo_modif ='I'");
          sql.append(" and emr.emr_nombre = 'APROBADO'");
          sql.append(" and ecd.ecd_nombre='CDP APROBADO'");
          sql.append(" and cdp.cdp_codigo in(");
          sql.append(IdCdp);
          sql.append(" ) group by c.drc_codigo,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo, cdp.cdp_consecutivo");
          sql.append(" union all");
          sql.append(" select sum(mrd.mrd_valor),c.drc_codigo,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo, cdp.cdp_consecutivo");
          sql.append(" from sii_modif_rp_det_rub_cdp mrd");
          sql.append(" Inner Join sii_modificacion_rp mr on (mrd.mrp_codigo = mr.mrp_codigo)");
          sql.append(" Inner Join sii_rp rp on (mr.rp_codigo = rp.rp_codigo)");
          sql.append(" Inner Join sii_rp_det_rubro_cdp rpdet on (mrd.rdr_codigo =rpdet.rdr_codigo)");
          sql.append(" Inner Join sii_cdp_rp crp on (rp.rp_codigo = crp.rp_codigo)");
          sql.append(" Inner Join sii_cdp cdp on (crp.cdp_codigo = cdp.cdp_codigo)");
          sql.append(" Inner Join Sii_Estado_Modific_Rp emr on (mr.emr_codigo = emr.emr_codigo)");
          sql.append(" Inner Join sii_estado_cdp ecd on (cdp.ecd_codigo = ecd.ecd_codigo)");
          sql.append(" Inner Join Sii_Detalle_Rubro_Cdp c on (Rpdet.Drc_Codigo = c.drc_codigo)");
          sql.append(" Inner Join Sii_Detalle_Rubro detru on (detru.dru_codigo = c.dru_codigo)");
          sql.append(" Inner Join pr_rubro ru on ( detru.vigencia = ru.vigencia and detru.interno = ru.interno )");
          sql.append(" Inner Join sii_dtlle_fuente_financiacion dff on ( detru.dff_codigo = dff.dff_codigo )");
          sql.append(" Inner Join Sii_Fuente_Financiacion  ff on ( dff.ffi_codigo = ff.ffi_codigo )");
          sql.append(" where  mr.mrp_tipo_modif ='D'");
          sql.append(" and emr.emr_nombre = 'APROBADO'");
          sql.append(" and ecd.ecd_nombre='CDP APROBADO' ");
          sql.append(" and cdp.cdp_codigo in(");
          sql.append(IdCdp);
          sql.append(" ) group by c.drc_codigo,ru.descripcion , dff.dff_descripcion , ff.ffi_descripcion,c.cdp_codigo, cdp.cdp_consecutivo) s ");          
          sql.append(" group by s.idDetRubCdp , s.rubdescr, s.dffdescr, s.ffdescr, s.cdp, s.consecutivo");
         
          Query query = manager.createNativeQuery(sql.toString());
          
          //query.setParameter("IdCdp"+cont,IdCdp);
          
          
          List<Object[]> results = query.getResultList();
          for(Object[] object : results){
              CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();
              rfdcVo.setIdCdp(((BigDecimal) object[5]).longValue());              //Id CDP
              rfdcVo.setDesRubro((String) object[2]);                             //Descripción Rubro
              rfdcVo.setIdDetRubCdp(((BigDecimal) object[1]).longValue());        //Id Detalle Rubro CDP
              rfdcVo.setDesFuente((String) object[4]);                            //Descripción Fuente
              rfdcVo.setDtlleFuente((String) object[3]);                          //Descripción Detalle Fuente
              rfdcVo.setSaldo((BigDecimal) object[0]);                            //Valor
              rfdcVo.setConsecutivo(((BigDecimal) object[6]).longValue());
              
              listaRubroFteDetPorCdpVo.add(rfdcVo);
          }
          
      }catch(PersistenceException pe){
          String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
          throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
      }
      return listaRubroFteDetPorCdpVo;
    }

    
    public List<SiiRp>  buscarRpAprobadosPorIdProcesoContratacion (Long idProcesoContratacion) throws ExcepcionDAO {
        List<SiiRp> listaRp = new ArrayList<SiiRp>();
        try{
            StringBuilder sql = new StringBuilder();            
            
            sql.append("SELECT rp FROM SiiRp rp" +
                " INNER JOIN rp.siiCdp cdp" +      
                " INNER JOIN cdp.siiCdpRpList crp WHERE cdp.siiProcesoContratacion.prcCodigo = :idPc" +
                " AND rp.siiEstadoRp.erpCodigo = 8");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPc", idProcesoContratacion);
            listaRp = query.getResultList();
            return listaRp;
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }        
    }
    
    public List<CdpRubroDetalleFuenteVO> buscarDetalleRpPorRp(Long idRp) throws ExcepcionDAO {
      List<CdpRubroDetalleFuenteVO> listaRubroFteDetPorCdpVo = new ArrayList<CdpRubroDetalleFuenteVO>();
      try{
          StringBuilder sql = new StringBuilder();  
          sql.append(" select distinct Detrp.Drc_Codigo, Detrp.Rdr_Valor,cdprp.cdp_codigo ");
          sql.append(" from sii_rp_det_rubro_cdp detrp, sii_cdp_rp cdprp");
          sql.append(" where detrp.rp_codigo = cdprp.rp_codigo");
          sql.append(" and detrp.rp_codigo =#idRp");
          sql.append(" order by cdprp.cdp_codigo ,Detrp.Drc_Codigo");
         
         
          Query query = manager.createNativeQuery(sql.toString());
          
          query.setParameter("idRp",idRp);
          
          
          List<Object[]> results = query.getResultList();
          for(Object[] object : results){
              CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();
              rfdcVo.setIdCdp(((BigDecimal) object[2]).longValue());              //Id CDP                                       
              rfdcVo.setIdDetRubCdp(((BigDecimal) object[0]).longValue());        //Id Detalle Rubro CDP                                      
              rfdcVo.setValorRp((BigDecimal) object[1]);                            //Valor              
              listaRubroFteDetPorCdpVo.add(rfdcVo);
          }
          
      }catch(PersistenceException pe){
          String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
          throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
      }
      return listaRubroFteDetPorCdpVo;
    }
    
    
    public BigDecimal getGastosPersonalPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();                                   
             sql.append(" select NVL(SUM(P.OCO_SUBTOTAL + P.OCO_IVA - P.OCO_VALOR_RENTA - P.OCO_VALOR_IVA - P.OCO_VALOR_ICA - NVL(P.OCO_VALOR_RET_ESTAMP,0) - NVL(P.OCO_VALOR_VOL_AFP,0) - NVL(P.OCO_VALOR_VOL_AFC,0)), 0) AS GASTOS_PERSONAL from SII_OBLIGACION O ");
             sql.append(" inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
             sql.append(" left join sii_orden_pago orp on orp.obl_codigo = o.obl_codigo ");
             sql.append(" WHERE P.FFC_CODIGO = 'RNP' AND O.OBL_NUMERO = #concepto");
             sql.append(" AND O.EOB_CODIGO = #estadoObligacion ");

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("concepto",concepto);

             query.setParameter("estadoObligacion", EnumEstadoObligacion.APROBADO.getId());

             BigDecimal total = (BigDecimal) query.getSingleResult();
           
                 return total;
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }
    
    public BigDecimal getGastosGeneralesPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        
         try{

             StringBuilder sql = new StringBuilder();                                      
             sql.append(" select NVL(SUM(P.OCO_SUBTOTAL + P.OCO_IVA - P.OCO_VALOR_RENTA - P.OCO_VALOR_IVA - P.OCO_VALOR_ICA - NVL(P.OCO_VALOR_RET_ESTAMP,0) - NVL(P.OCO_VALOR_VOL_AFP,0) - NVL(P.OCO_VALOR_VOL_AFC,0)), 0) AS GASTOS_GENERALES from SII_OBLIGACION O ");
             sql.append(" inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
             sql.append(" left join sii_orden_pago orp on orp.obl_codigo = o.obl_codigo ");
             sql.append(" WHERE P.FFC_CODIGO = 'RNG' AND O.OBL_NUMERO = #concepto");
             sql.append(" AND O.EOB_CODIGO = #estadoObligacion ");

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("concepto",concepto);
             query.setParameter("estadoObligacion", EnumEstadoObligacion.APROBADO.getId());
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
           
                 return total;
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }
    
    public BigDecimal getRecursosPropiosPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();            
             sql.append(" select NVL(SUM(P.OCO_SUBTOTAL + P.OCO_IVA - P.OCO_VALOR_RENTA - P.OCO_VALOR_IVA - P.OCO_VALOR_ICA - NVL(P.OCO_VALOR_RET_ESTAMP,0) - NVL(P.OCO_VALOR_VOL_AFP,0) - NVL(P.OCO_VALOR_VOL_AFC,0)), 0) AS GASTOS_PERSONAL from SII_OBLIGACION O ");
             sql.append(" inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
             sql.append(" left join sii_orden_pago orp on orp.obl_codigo = o.obl_codigo ");
             sql.append(" WHERE P.FFC_CODIGO = 'RPE' AND O.OBL_NUMERO = #concepto");
             sql.append(" AND O.EOB_CODIGO = #estadoObligacion ");

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("concepto",concepto);
             query.setParameter("estadoObligacion", EnumEstadoObligacion.APROBADO.getId());
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
            
                 return total;
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }
    
    
    /**
     * Obtiene el valor correspondiente a los Gastos asociados a los Recursos Naci&oacute;n Transferencia (<b>RNT</b>) para la Obligaci&oacute;n especificada.
     * @param oblNumero - N&uacute;mero de Obligaci&oacute;n.
     * @return Valor de Gasto RNT.
     * @throws ExcepcionDAO
     */
    public BigDecimal getGastosTransferenciaPorObligacion (Integer oblNumero) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();                                      
             sql.append(" select NVL(SUM(P.OCO_SUBTOTAL + P.OCO_IVA - P.OCO_VALOR_RENTA - P.OCO_VALOR_IVA - P.OCO_VALOR_ICA - NVL(P.OCO_VALOR_RET_ESTAMP,0) - NVL(P.OCO_VALOR_VOL_AFP,0) - NVL(P.OCO_VALOR_VOL_AFC,0)), 0) AS GASTOS_TRANSFERENCIA from SII_OBLIGACION O ");
             sql.append(" inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
             sql.append(" left join sii_orden_pago orp on orp.obl_codigo = o.obl_codigo ");
             sql.append(" WHERE P.FFC_CODIGO = 'RNT' AND O.OBL_NUMERO = #oblNumero ");
             sql.append(" AND O.EOB_CODIGO = #estadoObligacion ");
            
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("oblNumero", oblNumero);
             query.setParameter("estadoObligacion", EnumEstadoObligacion.APROBADO.getId());
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
            
            return total;
             
         }
         catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
    }
    
    
    
    /**
     * Obtiene el valor correspondiente a los Gastos asociados a los Recursos Control Ilegalidad (<b>RCI</b>) para la Obligaci&oacute;n especificada.
     * @param oblNumero - N&uacute;mero de Obligaci&oacute;n.
     * @return Valor de Gasto RCI.
     * @throws ExcepcionDAO
     */
    public BigDecimal getRecursosControlIlegalidadPorObligacion (Integer oblNumero) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();                                      
             sql.append(" select NVL(SUM(P.OCO_SUBTOTAL + P.OCO_IVA - P.OCO_VALOR_RENTA - P.OCO_VALOR_IVA - P.OCO_VALOR_ICA - NVL(P.OCO_VALOR_RET_ESTAMP,0) - NVL(P.OCO_VALOR_VOL_AFP,0) - NVL(P.OCO_VALOR_VOL_AFC,0)), 0) AS RECURSOS_ILEGALIDAD from SII_OBLIGACION O ");
             sql.append(" inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
             sql.append(" left join sii_orden_pago orp on orp.obl_codigo = o.obl_codigo ");
             sql.append(" WHERE P.FFC_CODIGO = 'RCI' AND O.OBL_NUMERO = #oblNumero ");
             sql.append(" AND O.EOB_CODIGO = #estadoObligacion ");
            
             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("oblNumero", oblNumero);
             query.setParameter("estadoObligacion", EnumEstadoObligacion.APROBADO.getId());
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
            
            return total;
             
         }
         catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
    }
    
    
    
    public List<CdpRubroDetalleFuenteVO> buscarRubroPorRpAprobados(Long IdCdp) throws ExcepcionDAO {
         List<CdpRubroDetalleFuenteVO> listaRubroFteDetPorCdpVo = new ArrayList<CdpRubroDetalleFuenteVO>();
         try{
             StringBuilder sql = new StringBuilder();                        
            
             sql.append(" select sum(rpdet.rdr_valor), rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion, ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior, rpdet.drc_codigo");
             sql.append(" from  sii_detalle_rubro_cdp drc ,sii_detalle_rubro dr, sii_dtlle_fuente_financiacion dff, sii_fuente_financiacion ff,");
             sql.append(" pr_rubro ru , sii_rp_det_rubro_cdp rpdet,sii_rp rp ,Sii_Estado_Rp esrp");
             sql.append(" where drc.dru_codigo = dr.dru_codigo");
             sql.append(" and dr.dff_codigo = dff.dff_codigo");
             sql.append(" and dff.ffi_codigo = ff.ffi_codigo");
             sql.append(" and dff.dff_codigo = dr.dff_codigo");
             sql.append(" and dr.vigencia = ru.vigencia");
             sql.append(" and dr.interno = ru.interno");
             sql.append(" and drc.drc_codigo = rpdet.drc_Codigo");
             sql.append(" and  rpdet.rp_codigo=rp.rp_codigo");
             //sql.append(" and rp.rp_codigo = #IdRp");
             sql.append(" and drc.cdp_codigo = #IdCdp");
             sql.append(" and rp.erp_codigo = Esrp.Erp_Codigo");
             sql.append(" and Esrp.Erp_Nombre = 'RP APROBADO'");
             sql.append(" group by  rpdet.rdr_codigo,dff.dff_descripcion,ff.ffi_descripcion, ru.descripcion,rpdet.rdr_valor,Rpdet.Rdr_Saldo_Anterior , rpdet.drc_codigo");          
             
             

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("IdCdp",IdCdp);
             
             List<Object[]> results = query.getResultList();
             for(Object[] object : results){
                 CdpRubroDetalleFuenteVO rfdcVo = new CdpRubroDetalleFuenteVO();                
                 rfdcVo.setDesRubro((String) object[4]); 
                 rfdcVo.setDtlleFuente((String) object[2]);                           //Descripción Rubro                
                 rfdcVo.setDesFuente((String) object[3]);                            //Descripción Fuente
                 rfdcVo.setSaldo((BigDecimal) object[0]);                            //Valor
                 rfdcVo.setValorRp((BigDecimal) object[5]);
                 rfdcVo.setIdRpDetRubroCdp(((BigDecimal) object[1]).longValue());
                 rfdcVo.setSaldoAnterior((BigDecimal) object[6]);
                 rfdcVo.setIdDetRubCdp(((BigDecimal) object[7]).longValue());                 
                 listaRubroFteDetPorCdpVo.add(rfdcVo);
             }
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
         return listaRubroFteDetPorCdpVo;
     }
   
    public BigDecimal getTotalGastosGeneralesPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        
         try{

             StringBuilder sql = new StringBuilder();                                      
             sql.append(" select NVL(SUM(P.OCO_SUBTOTAL)-sum(orp.orp_valor_gasto), 0) AS GASTOS_GENERALES from SII_OBLIGACION O ");
             sql.append(" inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
             sql.append(" left join sii_orden_pago orp on orp.obl_codigo = o.obl_codigo ");
             sql.append(" WHERE P.FFC_CODIGO = 'RNG' AND O.OBL_NUMERO = #concepto");
             sql.append(" AND O.EOB_CODIGO = #estadoObligacion ");

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("concepto",concepto);
             query.setParameter("estadoObligacion", EnumEstadoObligacion.APROBADO.getId());
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
           
                 return total;
             
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }
   
    public BigDecimal getTotalRecursosPropiosPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();            
             sql.append(" select NVL(SUM(P.OCO_SUBTOTAL)-sum(orp.orp_valor_gasto), 0) AS GASTOS_PERSONAL from SII_OBLIGACION O ");
             sql.append(" inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
             sql.append(" left join sii_orden_pago orp on orp.obl_codigo = o.obl_codigo ");
             sql.append(" WHERE P.FFC_CODIGO = 'RPE' AND O.OBL_NUMERO = #concepto");
             sql.append(" AND O.EOB_CODIGO = #estadoObligacion ");

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("concepto",concepto);
             query.setParameter("estadoObligacion", EnumEstadoObligacion.APROBADO.getId());
             
             BigDecimal total = (BigDecimal) query.getSingleResult();
            
                 return total;
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }
    
    public BigDecimal getTotalGastosPersonalPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        
         try{
             StringBuilder sql = new StringBuilder();                                   
             sql.append(" select NVL(SUM(P.OCO_SUBTOTAL)-sum(orp.orp_valor_gasto), 0) AS GASTOS_PERSONAL from SII_OBLIGACION O ");
             sql.append(" inner join SII_OBLIGACION_CONCEPTO P ON P.OBL_CODIGO = O.OBL_CODIGO ");
             sql.append(" left join sii_orden_pago orp on orp.obl_codigo = o.obl_codigo ");
             sql.append(" WHERE P.FFC_CODIGO = 'RNP' AND O.OBL_NUMERO = #concepto");
             sql.append(" AND O.EOB_CODIGO = #estadoObligacion ");

             Query query = manager.createNativeQuery(sql.toString());
             
             query.setParameter("concepto",concepto);

             query.setParameter("estadoObligacion", EnumEstadoObligacion.APROBADO.getId());

             BigDecimal total = (BigDecimal) query.getSingleResult();
           
                 return total;
             
         }catch(PersistenceException pe){
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"RpDAO");
         }
     }
    
    
    
    /**
     * Realiza la b&uacute;squeda de un RP por medio de su Consecutivo.
     * @param rpConsecutivo - Consecutivo del RP.
     * @return instance of SiiRp
     * @throws ExcepcionDAO
     */
    public SiiRp buscarPorConsecutivoRp (Long rpConsecutivo) throws ExcepcionDAO {
        SiiRp siiRp = null;
        
        if (rpConsecutivo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT rp FROM SiiRp rp ");
                sql.append("WHERE rp.rpConsecutivo = :rpConsecutivo ");
                
                Query query = manager.createQuery(sql.toString());
                query.setParameter("rpConsecutivo", rpConsecutivo);
                
                siiRp = (SiiRp) query.getSingleResult();
                
            }
            catch (NoResultException e) {
                siiRp = null;
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (siiRp);
    }
    
    public Long siguienteConsecutivoRp(Integer vigencia) throws ExcepcionDAO {
        Long i;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MAX(o.RP_CONSECUTIVO)\n" + 
            "FROM  sii_Rp o\n" + 
            "WHERE  to_number(SUBSTR(o.rp_consecutivo,1,4)) = #vigencia");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            i = ((BigDecimal) query.getSingleResult()).longValue();
            if (i == null)
                i = 1L;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RpDAO");
        }
        if (i == null || i / 1000000L != vigencia) {
            i = vigencia * 1000000L;
        }
        return i + 1;
    }


    public List<SiiRp> listaRpsAsociadosConLosCdpAsociadosConElRp(RpVO rpVO) throws ExcepcionDAO {
        try{
            StringBuilder sql = new StringBuilder();                        
            sql.append("SELECT distinct losRP\n" + 
            "FROM SiiCdpRp crp\n" + 
            "INNER JOIN crp.siiRp unRp\n" + 
            "INNER JOIN unRp.siiCdpRpList losCdpRp\n" + 
            "INNER JOIN losCdpRp.siiRp losRP\n" +
            "INNER JOIN losRP.siiEstadoRp erp\n" + 
            "WHERE unRp.rpConsecutivo = :unRp AND erp.erpNombre='RP APROBADO'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("unRp", rpVO.getRpCodigo());
            return query.getResultList();
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }        

    }


}
