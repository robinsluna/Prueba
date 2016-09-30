/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 03-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSolicAutoriza;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;

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
public class TipoApuestaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public TipoApuestaDAO() {
        recursos = new Recursos();
    }
    
    /**
     * Buscar todos los tipos de apuesta existentes.
     * @return listaTipoApuesta - Lista de tipos de apuesta.
     * @throws ExcepcionDAO
     */

    public List<SiiTipoApuesta> buscarTodoTipoApuesta() throws ExcepcionDAO {
        List<SiiTipoApuesta> listaTipoApuesta = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tap FROM SiiTipoApuesta tap");
            sql.append(" order by tap.tapCodigo desc");
            Query query = manager.createQuery(sql.toString());
            listaTipoApuesta = query.getResultList();
        } catch (Exception e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), "TipoApuestaDAO");
        }
        return listaTipoApuesta;

    }
    
    public SiiTipoApuesta buscarTipoApuestaPorCodigo(Long idCodigoTipoApuesta) throws ExcepcionDAO {
        SiiTipoApuesta retorno = null;
        try {
            retorno = (SiiTipoApuesta) manager.find(SiiTipoApuesta.class, idCodigoTipoApuesta);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoApuestaDAO");
        }
        return retorno;

    }
    
    public SiiTipoApuesta insertarSiiTipoApuesta(SiiTipoApuesta tipoApuesta) throws ExcepcionDAO {
        try {
            manager.persist(tipoApuesta); 
            manager.flush(); 
            return tipoApuesta; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoApuestaDAO");
        }
    }

    /**
     * @autor Giovanni
     * @param codTipoJuego
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiTipoApuesta> buscarSiiTipoApuestaXTipoJuego(Long codTipoJuego) throws ExcepcionDAO {
        List<SiiTipoApuesta> siiTipoApuestas = null;  
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tju FROM SiiTipoApuesta tju");
            sql.append(" WHERE tju.siiTipoJuego.tjuCodigo = :codTipoJuego");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codTipoJuego", codTipoJuego);

            siiTipoApuestas = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoApuestaDAO");
        }
        return siiTipoApuestas;
    }
    public TipoApuestaVO buscarPorcentajePromocionales() throws ExcepcionDAO {
        TipoApuestaVO retorno =new  TipoApuestaVO();
        List<TipoApuestaVO> listaTipoApuestaVo = new ArrayList<TipoApuestaVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select substr(tap_der_expl_formula,0,subDE-(1)) as DE,substr(tap_gast_adm_formula,0,subGA-1) as GA from(  ");
            sql.append(" select  INSTR( ap.tap_der_expl_formula,'*') subDE ,INSTR( ap.tap_gast_adm_formula,'*') subGA ,  ap.tap_der_expl_formula, ap.tap_gast_adm_formula from sii_tipo_juego tj  ");
            sql.append(" inner join sii_tipo_apuesta ap on tj.tju_codigo = ap.tju_codigo  ");
           sql.append(" where tj.tju_codigo=7 and ap.tap_codigo_apuesta='21')");
           // sql.append(" inner join sii_tipo_apuesta ap on tj.tju_codigo = ap.tju_codigo");
            //sql.append(" where tj.tju_codigo=7 and ap.tap_codigo_apuesta='21') group by tap_gast_adm_formula, tap_der_expl_formula,subDE,subGA)   ");

            Query query = manager.createNativeQuery(sql.toString());
            List<Object[]> results= query.getResultList();
            
            for (Object[] object : results) {
                retorno.setTapDerExplFormula((String) object[0]);  
                retorno.setTapGastAdmFormula((String) object[1]); 
                listaTipoApuestaVo.add(retorno);
            }
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoApuestaDAO");
        }
        return listaTipoApuestaVo.get(0);

    }
    
    public TipoApuestaVO buscarSiiTipoCodigoApuesta(String  codTipoCodigoApuesta) throws ExcepcionDAO {
        
        List<SiiTipoApuesta> siiTipoApuestas = null;  
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tju FROM SiiTipoApuesta tju");
            sql.append(" WHERE tju.tapCodigoApuesta = :codTipoCodigoApuesta");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codTipoCodigoApuesta", codTipoCodigoApuesta);

            siiTipoApuestas = query.getResultList();           

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoApuestaDAO");
        }
        return (new  TipoApuestaVO(siiTipoApuestas.get(0)));
    }
    
    public SiiTipoApuesta buscarSiiTipoApuestaByCodigoTipoApuesta(String  codTipoCodigoApuesta) throws ExcepcionDAO {
        
        List<SiiTipoApuesta> siiTipoApuestas = null;  
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tju FROM SiiTipoApuesta tju");
            sql.append(" WHERE tju.tapCodigoApuesta = :codTipoCodigoApuesta");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codTipoCodigoApuesta", codTipoCodigoApuesta);

            siiTipoApuestas = query.getResultList();           
            if(!siiTipoApuestas.isEmpty()){
                return siiTipoApuestas.get(0);
            }else{
                return null;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoApuestaDAO");            
        }        
    }

public List<SiiTipoApuesta> buscarSiiTipoApuestaPorCodigoTipoApuesta(String  codTipoCodigoApuesta) throws ExcepcionDAO {
        
        List<SiiTipoApuesta> siiTipoApuestas = null;  
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tju FROM SiiTipoApuesta tju");
            sql.append(" WHERE tju.tapCodigoApuesta = :codTipoCodigoApuesta");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codTipoCodigoApuesta", codTipoCodigoApuesta);

            siiTipoApuestas = query.getResultList();           

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoApuestaDAO");
        }
        return siiTipoApuestas;
    }

    /**
     * @author Giovanni
     * @param codigoTipoApuesta
     * @return
     * @throws ExcepcionDAO
     */
    public BigDecimal buscarDerechoExplotacionXCodigoTipoApuesta(Long codigoTipoApuesta) throws ExcepcionDAO {
        BigDecimal total = new BigDecimal(0);
        
        String codTipoApuest = codigoTipoApuesta.toString();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT PR.fn_calcula_de(tap.tap_der_expl_formula)");
            sql.append(" FROM sii_tipo_apuesta tap");
            sql.append(" WHERE tap.tap_codigo_apuesta = #codigoTipoApuesta");
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codigoTipoApuesta", codTipoApuest);
            
            total = (BigDecimal) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoApuestaDAO");
        }
        return total;
    }

    public static List<SiiTipoSolicAutoriza> buscarTodaTipoSolicAutoriza() {
        return null;
    }

    public static List<SiiTipoSolicAutoriza> buscarTodoTipoSolicAutoriza() {
        return null;
    }
}
