/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 10-02-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSaldoCtaBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

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
public class SaldoCtaBancoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public SaldoCtaBancoDAO() {
        recursos = new Recursos();   
    }
    
    
    public List<SiiSaldoCtaBanco> buscarTodoSaldoCtaBanco()
            throws ExcepcionDAO{
        try{
            List<SiiSaldoCtaBanco> listaSiiSaldoCtaBanco = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sal FROM SiiSaldoCtaBanco sal");
            sql.append(" order by sal.scbCodigo desc");
            Query query = manager.createQuery(sql.toString());
            listaSiiSaldoCtaBanco= query.getResultList();
            return listaSiiSaldoCtaBanco;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");
        }
    }
    
    public SiiSaldoCtaBanco buscarSaldoCtaBancoPorId(Long idSaldoCta) throws ExcepcionDAO{
        SiiSaldoCtaBanco estadoSiiSaldoCtaBanco= null;
        try{
            estadoSiiSaldoCtaBanco = (SiiSaldoCtaBanco) manager.find(SiiSaldoCtaBanco.class, idSaldoCta);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoSolEstMercadoDAO");
        }        
        return estadoSiiSaldoCtaBanco;
    }
    
    public SiiSaldoCtaBanco insertarSaldoCtaBanco(SiiSaldoCtaBanco siiSaldoCtaBanco) throws ExcepcionDAO{
        try{
            manager.persist(siiSaldoCtaBanco);                                                                                
            manager.flush();                                                                                                    
            return siiSaldoCtaBanco; 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SiiSaldoCtaBancoDAO");
        }
    }
    
    public SiiSaldoCtaBanco actualizarSaldoCtaBanco(SiiSaldoCtaBanco siiSaldoCtaBanco) throws ExcepcionDAO{
        try{            
            manager.merge(siiSaldoCtaBanco);
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SaldoCtaBancoDAO");            
        }
        return siiSaldoCtaBanco;
    }
    
   
    
    public SiiSaldoCtaBanco buscarCtaBancoXIdCuentaBanActivo(Long idCuentaBan) throws ExcepcionDAO {
        SiiSaldoCtaBanco siiSaldoCtaBanco = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT sal FROM SiiSaldoCtaBanco sal WHERE sal.siiCuentaBancaria.cbaCodigo = :idCuentaBan");
           // sql.append(" and sal.scbEstado = :estado ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idCuentaBan", idCuentaBan);
            //query.setParameter("estado", "A");
            List<SiiSaldoCtaBanco> listasiiSaldoCtaBanco = query.getResultList();
            if (listasiiSaldoCtaBanco != null && !listasiiSaldoCtaBanco.isEmpty()) 
                 siiSaldoCtaBanco=listasiiSaldoCtaBanco.get(0);
            
        }
        catch (javax.persistence.NoResultException ne) {
            siiSaldoCtaBanco = null;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        return siiSaldoCtaBanco;
    }
    
    
    
    
}
