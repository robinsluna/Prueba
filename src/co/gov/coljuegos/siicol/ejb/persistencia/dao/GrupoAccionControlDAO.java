package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoAccionControl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeVerificCampo;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoAccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoFiscalizacionVO;

import co.gov.coljuegos.siicol.ejb.vo.SustanciadorAuditorVO;

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
public class GrupoAccionControlDAO{
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public GrupoAccionControlDAO(){
        recursos = new Recursos();
    }
    
    
    public SiiGrupoAccionControl insertarGrupoAccionControl(SiiGrupoAccionControl siiGrupoAccionControl) throws ExcepcionDAO {
        try {
            manager.persist(siiGrupoAccionControl);
            manager.flush();
            return siiGrupoAccionControl;
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "GrupoAccionControlDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }
    
    public SiiGrupoAccionControl buscarGrupoAccionControlPorId(Long gacCodigo) throws ExcepcionDAO {
        SiiGrupoAccionControl siiGrupoAccionControl = null;
        try {
            siiGrupoAccionControl = manager.find(SiiGrupoAccionControl.class, gacCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "GrupoAccionControlDAO");
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiGrupoAccionControl;
    }
    
    public SiiGrupoAccionControl actualizarDocumentoConpes(SiiGrupoAccionControl siiGrupoAccionControl) throws ExcepcionDAO {
        try {
            manager.merge(siiGrupoAccionControl);                                                                           
            manager.flush();                                                                                             
            return siiGrupoAccionControl;                                                                                 

            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "GrupoAccionControlDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
    }  
    
    public List<GrupoAccionControlVO> buscarGrupoAccionControlXFecha(Date gacFecha) throws ExcepcionDAO {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
        String fecha  = "TO_DATE('" + formatter.format(gacFecha) + "','DD/MM/YYYY') ";
        List<GrupoAccionControlVO> listaGrupoFis = new ArrayList();
        GrupoAccionControlVO grupoAccionControlVo = new  GrupoAccionControlVO();
        SustanciadorAuditorVO sustanciadorAuditorVoPrin;
        SustanciadorAuditorVO sustanciadorAuditorVoAcom;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM sii_grupo_accion_control g  where g.gac_fecha  >= "+fecha+"  order by g.gac_codigo asc  "  ); // AND  g.gfiFechaFin = :gfiFechaFin  " );
            
            Query query = manager.createNativeQuery(sql.toString());
            //query.setParameter("gacFecha", gacFecha);
                List<Object[]> results = query.getResultList();
                if (results != null && !results.isEmpty()) {                
                    for (Object[] object : results) {
                        grupoAccionControlVo = new GrupoAccionControlVO();
                        sustanciadorAuditorVoPrin = new SustanciadorAuditorVO();
                        sustanciadorAuditorVoAcom = new SustanciadorAuditorVO();
                        grupoAccionControlVo.setGacCodigo(((BigDecimal) object[0]).longValue());
                        sustanciadorAuditorVoPrin.setSuaCodigo(((BigDecimal) object[1]).longValue());
                        grupoAccionControlVo.setSustanciadorAuditorPpalVo(sustanciadorAuditorVoPrin);
                        sustanciadorAuditorVoAcom.setSuaCodigo(((BigDecimal) object[2]).longValue());
                        grupoAccionControlVo.setSustanciadorAuditorAcompVo(sustanciadorAuditorVoAcom);
                        grupoAccionControlVo.setGacNumero( ((BigDecimal) object[3]).intValue()) ;
                        grupoAccionControlVo.setGacFecha((Date) object[4]);                     
                        listaGrupoFis.add(grupoAccionControlVo);
                    }
                }
            
            return listaGrupoFis;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "GrupoFiscalizadorDAO");
        }
    }
    
    public GrupoAccionControlVO ultimoGrupoAccionControl() throws ExcepcionDAO{
        GrupoAccionControlVO grupoAccionControlVo = null;
        SustanciadorAuditorVO sustanciadorAuditorVoAcom;
        SustanciadorAuditorVO sustanciadorAuditorVoPrin;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" select * from (");
            sql.append(" select * from sii_grupo_accion_control  order by 1 desc )  ");
            sql.append(" where  ROWNUM=1 ");
           
            Query query = manager.createNativeQuery(sql.toString());
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {            
                grupoAccionControlVo = new GrupoAccionControlVO();
                sustanciadorAuditorVoAcom = new SustanciadorAuditorVO();
                sustanciadorAuditorVoPrin = new SustanciadorAuditorVO();
                grupoAccionControlVo.setGacCodigo(((BigDecimal) object[0]).longValue());   
                sustanciadorAuditorVoPrin.setSuaCodigo(((BigDecimal) object[1]).longValue());
                grupoAccionControlVo.setSustanciadorAuditorPpalVo(sustanciadorAuditorVoPrin);
                sustanciadorAuditorVoAcom.setSuaCodigo(((BigDecimal) object[2]).longValue());
                grupoAccionControlVo.setSustanciadorAuditorAcompVo(sustanciadorAuditorVoAcom);
                grupoAccionControlVo.setGacNumero( ((BigDecimal) object[3]).intValue()) ;
                grupoAccionControlVo.setGacFecha((Date) object[4]);                  
                }
                
            }
            return grupoAccionControlVo;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicPfcmDetalleDAO");
        }
    }
    
    
}
