package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReintegroIngresoPag;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRifaPromocional;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import co.gov.coljuegos.siicol.ejb.vo.ReintegroPagaduriaVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ReintegroPagaduriaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    public ReintegroPagaduriaDAO() {
        recursos = new Recursos();
    }
    
    public SiiReintegroIngresoPag insertarSiiReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) throws ExcepcionDAO {
        try {
            manager.persist(siiReintegroIngresoPag);
            manager.flush();
            return siiReintegroIngresoPag;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
    }
    
    public SiiReintegroIngresoPag actualizarReintegroIngresoPag(SiiReintegroIngresoPag siiReintegroIngresoPag) throws ExcepcionDAO {
        try {
            siiReintegroIngresoPag = manager.merge(siiReintegroIngresoPag);
            manager.flush();
            return siiReintegroIngresoPag;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    public List<SiiReintegroIngresoPag> buscarTodoReintegroIngresoPag( ) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT r FROM SiiReintegroIngresoPag r  ");
            sql.append(" order by r.ripNumero desc ");
            Query query = manager.createQuery(sql.toString());
           
            List<SiiReintegroIngresoPag> listaReintegroIngresoPag = query.getResultList();
            return listaReintegroIngresoPag;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
    }
    
    public SiiReintegroIngresoPag buscarPorCodigoReintegroIngresoPag(Long idReintegroIngPag) throws ExcepcionDAO {
        SiiReintegroIngresoPag retornoOperador = null;
        try {
            retornoOperador = (SiiReintegroIngresoPag) manager.find(SiiReintegroIngresoPag.class, idReintegroIngPag);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
        return retornoOperador;

    }
    
    public String   siguienteNumeroReintegroIngresoPag() throws ExcepcionDAO {
        Integer i;
        Calendar cal=Calendar.getInstance();
        Integer tempAño=cal.get(Calendar.YEAR);
        String  consecutivo=null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT max(o.ripNumero) FROM SiiReintegroIngresoPag o");
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
    
    public List<ReintegroPagaduriaVO>   buscarReintregroXNotaCredito(long nrcCodigo  ) throws ExcepcionDAO {
        List<ReintegroPagaduriaVO> listReintegroPagaduriaVo = new  ArrayList();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT n FROM SiiReintegroIngresoPag n where n.siiNotaCredito.ncrCodigo = :nrcCodigo and n.siiNotaCredito.ncrEstado ='A' ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nrcCodigo", nrcCodigo);
            List<SiiReintegroIngresoPag>  listSiiReintegroIngresoPag = query.getResultList();
           
            for (SiiReintegroIngresoPag siiReintegroIngresoPag :  listSiiReintegroIngresoPag){
                listReintegroPagaduriaVo.add(new ReintegroPagaduriaVO(siiReintegroIngresoPag));
            }
           
            return listReintegroPagaduriaVo;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoDAO");
        }
       
    }
    
    public List<ReintegroPagaduriaVO>   buscarReintregroXNotaCreditoId(long nrcCodigo,Long ripCodigo  ) throws ExcepcionDAO {
        List<ReintegroPagaduriaVO> listReintegroPagaduriaVo = new  ArrayList();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT n FROM SiiReintegroIngresoPag n where n.siiNotaCredito.ncrCodigo = :nrcCodigo and n.ripCodigo = :ripCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nrcCodigo", nrcCodigo);
            query.setParameter("ripCodigo", ripCodigo);
            List<SiiReintegroIngresoPag>  listSiiReintegroIngresoPag = query.getResultList();
           
            for (SiiReintegroIngresoPag siiReintegroIngresoPag :  listSiiReintegroIngresoPag){
                listReintegroPagaduriaVo.add(new ReintegroPagaduriaVO(siiReintegroIngresoPag));
            }
           
            return listReintegroPagaduriaVo;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoDAO");
        }
       
    }
    
    
    
    
}
