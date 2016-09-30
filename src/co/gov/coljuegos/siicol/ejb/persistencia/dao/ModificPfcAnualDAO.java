/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-11-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPfcAnual;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicPfcmDetalle;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.MesVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicPfcmDetalleVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificPfcAnualVO;

import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleFuenteRpVO;

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
public class ModificPfcAnualDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ModificPfcAnualDAO() {
        recursos = new Recursos();
    }
    
    public SiiModificPfcAnual buscarPorCodigoModPfca(Long idModPfca) throws ExcepcionDAO {
        SiiModificPfcAnual siiModificPfcAnualRetorno = null;
        try {
            siiModificPfcAnualRetorno =(SiiModificPfcAnual) manager.find(SiiModificPfcAnual.class, idModPfca);
         
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ModificPfcAnualDAO");
        }
        return siiModificPfcAnualRetorno;
    }
    
    public SiiModificPfcAnual insertarModPfca(SiiModificPfcAnual siiModificPfcAnual) throws ExcepcionDAO {
        try {
            manager.persist(siiModificPfcAnual);                                                            //La guarda en el almacen
            manager.flush();                                                                                //Pasa a la Bd
            return siiModificPfcAnual;                                                                      //Retorna la entidad

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ModificPfcAnualDAO");
        }
    }
    
    public SiiModificPfcAnual actualizarModPfca(SiiModificPfcAnual siiModificPfcAnual) throws ExcepcionDAO {
        try {
            manager.merge(siiModificPfcAnual);                                                                           
            manager.flush();                                                                                             
           return siiModificPfcAnual;                                                                                 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificPfcAnualDAO");
        }
    }
    
    public List<SiiModificPfcAnual> buscarTodaModifPfca() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT modifPfca FROM SiiModificPfcAnual modifPfca");
            Query query = manager.createQuery(sql.toString());
            List<SiiModificPfcAnual> listaModifPfca = query.getResultList();
            
            return listaModifPfca;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificPfcAnualDAO");
        }
    }
    public List<SiiModificPfcAnual> buscarTodoModificacPfcAnualXSpd(ModificPfcAnualVO modificPfcAnualVo) throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT mpa FROM SiiModificPfcAnual mpa");
            sql.append(" WHERE mpa.siiSolicPfcmDetalle.spdCodigo = :codigoSpd");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoSpd", modificPfcAnualVo.getSolicPfcmDetalleVo().getSpdCodigo());
            List<SiiModificPfcAnual> listaSiiModificPfcAnual= query.getResultList();

            return listaSiiModificPfcAnual;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicPfcmDetalleDAO");
        }
    }
   
    public List<ModificPfcAnualVO> buscarTodoModificacPfcAnualXVigenciaMes(String vigencia, Integer mes) throws ExcepcionDAO{
        List<ModificPfcAnualVO> listaModificPfcAnualVo= new ArrayList<ModificPfcAnualVO>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" select * from (select distinct TO_CHAR(Nivel1.CODIGO) ||");
            sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
            sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
            sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
            sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
            sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
            sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
            sql.append(" dpf.dru_codigo, mpa.mpa_activo, mpa.mpa_codigo, mpa.mpa_justificacion, mpa.mpa_tipo_modif,mpa.mpa_valor");
            sql.append(" from sii_detalle_rubro dru");
            sql.append(" inner join sii_distribucion_pfc dpf on dru.dru_codigo=dpf.dru_codigo");
            sql.append(" inner join sii_modific_pfc_anual mpa on mpa.dpf_codigo= dpf.dpf_codigo");
            sql.append(" inner join pr_rubro Rubro on rubro.vigencia= dru.vigencia and rubro.interno=dru.interno");
            sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
            sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
            sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
            sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
            sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
            sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
            sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno");            
            sql.append(" Where dru.vigencia=#vigencia and dpf.mes_codigo=#mes)");
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("vigencia",Integer.parseInt(vigencia));
            query.setParameter("mes", mes);
            List<Object[]> results = query.getResultList();
            
            for(Object[] object : results){
                ModificPfcAnualVO modificPfcAnualVo = new ModificPfcAnualVO();   
                DistribucionPfcVO distribucionPfcVo = new DistribucionPfcVO();
                DetalleRubroVO detalleRubroVo = new DetalleRubroVO();
                modificPfcAnualVo.setCadena((String) object[0]);   
                detalleRubroVo.setDruCodigo((((BigDecimal) object[1]).longValue()));
                distribucionPfcVo.setDetalleRubroVo(detalleRubroVo);
                modificPfcAnualVo.setDistribucionPfcVo(distribucionPfcVo);
                modificPfcAnualVo.setMpaActivo((String) object[2]);
                modificPfcAnualVo.setMpaCodigo(((BigDecimal) object[3]).longValue());
                modificPfcAnualVo.setMpaJustificacion((String) object[4]);
                modificPfcAnualVo.setMpaTipoModif((String) object[5]);
                modificPfcAnualVo.setMpaValor((BigDecimal) object[6]);
                 
                listaModificPfcAnualVo.add(modificPfcAnualVo);
                }
            return listaModificPfcAnualVo;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicPfcmDetalleDAO");
        }
    }
    
    public List<ModificPfcAnualVO> buscarTodoModificacPfcAnualXSpf(long idSpf) throws ExcepcionDAO{
        List<ModificPfcAnualVO> listaModificPfcAnualVo= new ArrayList<ModificPfcAnualVO>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" select mpa.dpf_codigo,mpa.mpa_activo,mpa.mpa_codigo,mpa.mpa_justificacion,mpa.mpa_tipo_modif,mpa.mpa_valor" );
            sql.append(" ,mpa.spd_codigo,dpf.mes_codigo,dpf.dru_codigo, mes.mes_nombre");
            sql.append(" from sii_modific_pfc_anual mpa");
            sql.append(" inner join sii_distribucion_pfc dpf on mpa.dpf_codigo=dpf.dpf_codigo");
            sql.append(" inner join sii_solic_pfcm_detalle spd on mpa.spd_codigo=spd.spd_codigo");
            sql.append(" inner join sii_mes mes on dpf.mes_codigo=mes.mes_codigo");
            sql.append(" WHERE spd.spf_codigo=#codigoSpf");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codigoSpf", idSpf);
            List<Object[]> results = query.getResultList();
            for(Object[] object : results){
                ModificPfcAnualVO modificPfcAnualVo = new ModificPfcAnualVO();   
                DistribucionPfcVO distribucionPfcVo = new DistribucionPfcVO();
                SolicPfcmDetalleVO solicPfcmDetalleVo=new SolicPfcmDetalleVO();
                DetalleRubroVO detalleRubroVo= new DetalleRubroVO();
                MesVO unMesVo = new MesVO();
                distribucionPfcVo.setDpfCodigo((((BigDecimal) object[0]).longValue()));
                modificPfcAnualVo.setDistribucionPfcVo(distribucionPfcVo);
                modificPfcAnualVo.setMpaActivo((String) object[1]);
                modificPfcAnualVo.setMpaCodigo(((BigDecimal) object[2]).longValue());
                modificPfcAnualVo.setMpaJustificacion((String) object[3]);
                modificPfcAnualVo.setMpaTipoModif((String) object[4]);
                modificPfcAnualVo.setMpaValor((BigDecimal) object[5]);
                solicPfcmDetalleVo.setSpdCodigo(((BigDecimal) object[6]).longValue()); 
                modificPfcAnualVo.setSolicPfcmDetalleVo(solicPfcmDetalleVo);
                unMesVo.setMesCodigo(((BigDecimal) object[7]).intValue());
                detalleRubroVo.setDruCodigo((((BigDecimal) object[8]).longValue()));
                modificPfcAnualVo.getDistribucionPfcVo().setDetalleRubroVo(detalleRubroVo);
                unMesVo.setMesNombre((String) object[9]);
                modificPfcAnualVo.setMesVo(unMesVo);
                listaModificPfcAnualVo.add(modificPfcAnualVo);
            }

            return listaModificPfcAnualVo;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicPfcmDetalleDAO");
        }
    }
   
    
    
    
}
