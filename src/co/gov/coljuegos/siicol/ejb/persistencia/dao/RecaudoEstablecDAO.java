/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 09-09-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoLineaBan;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class RecaudoEstablecDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    public RecaudoEstablecDAO() {
        recursos = new Recursos();
    }

    public SiiRecaudoEstablec insertarRecaudoEstablec(SiiRecaudoEstablec siiRecaudoEstablec) throws ExcepcionDAO {
        try {
            manager.persist(siiRecaudoEstablec); 
            manager.flush(); 
            return siiRecaudoEstablec; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecaudoEstablecDAO");
        }
        catch (Exception ex){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"RecaudoEstablecDAO");            
        }
    }
    
    public SiiRecaudoEstablec actualizarSiiRecaudoEstablec(SiiRecaudoEstablec siiRecaudoEstablec) throws ExcepcionDAO {
        try {
            manager.merge(siiRecaudoEstablec);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RecaudoLineaBanDAO");
        }
        return siiRecaudoEstablec;
    }
    
    public List<SiiRecaudoEstablec> buscarRecEstPorIdDetalleDec(long idDdeCodigo) throws ExcepcionDAO {
        List<SiiRecaudoEstablec> listaSiiInteresCuota = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT icu FROM SiiRecaudoEstablec icu");
            sql.append(" WHERE icu.siiDetalleDeclaracion.ddeCodigo = :idDdeCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idDdeCodigo", idDdeCodigo);
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
    
    
    public SiiRecaudoEstablec buscarRecaudoEstablecPorId(Integer idRecaudoEst) throws ExcepcionDAO {
        SiiRecaudoEstablec siiRecaudoEstablec = null;
        try {
            siiRecaudoEstablec = manager.find(SiiRecaudoEstablec.class, idRecaudoEst); 
          } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(), "MesDAO");
        }
        return siiRecaudoEstablec;
    }


}
