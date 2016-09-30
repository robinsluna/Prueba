package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoFiscalizacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribucionVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;
import co.gov.coljuegos.siicol.ejb.vo.GrupoFiscalizacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificPfcAnualVO;

import java.math.BigDecimal;

import java.text.DateFormat;
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
public class GrupoFiscalizadorDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public GrupoFiscalizadorDAO() {
         recursos = new Recursos();
    }
    
    public List<SiiGrupoFiscalizacion> buscarTodoGrupoFiscalizacion() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT g FROM SiiGrupoFiscalizacion g");
            Query query = manager.createQuery(sql.toString());
            List<SiiGrupoFiscalizacion> listaGrupoFis = query.getResultList();
            
            return listaGrupoFis;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "GrupoFiscalizadorDAO");
        }
    }
    
    public SiiGrupoFiscalizacion buscarPorCodigoSiiGrupoFiscalizacion(Long gfiCodigo) throws ExcepcionDAO {
        SiiGrupoFiscalizacion siiGrupoFiscalizacion = null;
        try {
            siiGrupoFiscalizacion =(SiiGrupoFiscalizacion) manager.find(SiiGrupoFiscalizacion.class, gfiCodigo);
         
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ModificPfcAnualDAO");
        }
        return siiGrupoFiscalizacion;
    }
    
    
    public SiiGrupoFiscalizacion insertarSiiGrupoFiscalizacion(SiiGrupoFiscalizacion siiGrupoFiscalizacion) throws ExcepcionDAO {
        try {
            manager.persist(siiGrupoFiscalizacion);                                                            //La guarda en el almacen
            manager.flush();                                                                                //Pasa a la Bd
            return siiGrupoFiscalizacion;                                                                      //Retorna la entidad

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"GrupoFiscalizadorDAO");
        }
        catch (Exception ex) {
                    ex.printStackTrace();
                    throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    public List<GrupoFiscalizacionVO> buscarGrupoFiscalizacionXSemana(Date gfiFechaIni, Date gfiFechaFin  ) throws ExcepcionDAO {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String fechaIni  = "TO_DATE('" + formatter.format(gfiFechaIni) + "','YYYY/MM/DD') ";
        //String fechaFin  = "TO_DATE('" + formatter.format(gfiFechaFin) + "','YYYY/MM/DD') ";
        List<GrupoFiscalizacionVO> listaGrupoFis = new ArrayList();
        GrupoFiscalizacionVO grupoFiscalizacionVo = new  GrupoFiscalizacionVO();
        FiscalizadorSustancVO fiscalizadorSustancVoPrin;
        FiscalizadorSustancVO fiscalizadorSustancVoAcom;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM sii_grupo_fiscalizacion g  where g.gfi_fecha_ini  = "+fechaIni+"  order by g.gfi_codigo asc  "  ); // AND  g.gfiFechaFin = :gfiFechaFin  " );
            
            Query query = manager.createNativeQuery(sql.toString());
                List<Object[]> results = query.getResultList();
                if (results != null && !results.isEmpty()) {                
                    for (Object[] object : results) {
                        grupoFiscalizacionVo = new GrupoFiscalizacionVO();
                        fiscalizadorSustancVoPrin = new FiscalizadorSustancVO();
                        fiscalizadorSustancVoAcom = new FiscalizadorSustancVO();
                        grupoFiscalizacionVo.setGfiCodigo(((BigDecimal) object[0]).longValue());
                        grupoFiscalizacionVo.setGfiNumero((String) object[1]);
                        grupoFiscalizacionVo.setGfiFechaIni((Date) object[2]);
                        grupoFiscalizacionVo.setGfiFechaFin((Date) object[3]);
                        fiscalizadorSustancVoPrin.setFsuCodigo(((BigDecimal) object[4]).longValue());
                        grupoFiscalizacionVo.setFiscalizadorSustancVoPrincipal(fiscalizadorSustancVoPrin);
                        fiscalizadorSustancVoAcom.setFsuCodigo(((BigDecimal) object[5]).longValue());
                        grupoFiscalizacionVo.setFiscalizadorSustancVoAcompañante(fiscalizadorSustancVoAcom);
                        listaGrupoFis.add(grupoFiscalizacionVo);
                    }
                }
            
            return listaGrupoFis;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "GrupoFiscalizadorDAO");
        }
    }
    
    public GrupoFiscalizacionVO ultimoGrupoFiscalizador() throws ExcepcionDAO{
        GrupoFiscalizacionVO unGrupoFiscalizacionVo = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" select * from (");
            sql.append(" select * from sii_grupo_fiscalizacion  order by 1 desc )  ");
            sql.append(" where  ROWNUM=1 ");
           
            Query query = manager.createNativeQuery(sql.toString());
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                for (Object[] object : results) {            
                unGrupoFiscalizacionVo = new GrupoFiscalizacionVO();
                unGrupoFiscalizacionVo.setGfiCodigo(((BigDecimal) object[0]).longValue());   
                unGrupoFiscalizacionVo.setGfiNumero((String) object[1]);
                unGrupoFiscalizacionVo.setGfiFechaIni((Date) object[2]);
                unGrupoFiscalizacionVo.setGfiFechaFin((Date) object[3]);
                FiscalizadorSustancVO fiscalizadorSustancVoPrincipal =new FiscalizadorSustancVO();
                fiscalizadorSustancVoPrincipal.setFsuCodigo(((BigDecimal) object[4]).longValue());
                unGrupoFiscalizacionVo.setFiscalizadorSustancVoPrincipal(fiscalizadorSustancVoPrincipal);
                FiscalizadorSustancVO fiscalizadorSustancVoAcompañante =new FiscalizadorSustancVO();
                fiscalizadorSustancVoAcompañante.setFsuCodigo(((BigDecimal) object[5]).longValue());
                unGrupoFiscalizacionVo.setFiscalizadorSustancVoAcompañante(fiscalizadorSustancVoAcompañante);
                }
                
            }
            return unGrupoFiscalizacionVo;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicPfcmDetalleDAO");
        }
    }
    
    
}
