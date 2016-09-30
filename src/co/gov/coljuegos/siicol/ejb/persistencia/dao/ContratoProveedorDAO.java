package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContratoProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioAdjudica;
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

public class ContratoProveedorDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ContratoProveedorDAO() {        
        recursos = new Recursos();
    }
    
    public SiiContratoProveedor insertarContratoProveedor (SiiContratoProveedor siiContratoProveedor) throws ExcepcionDAO{
        try {
                manager.persist(siiContratoProveedor);
                manager.flush();
                return siiContratoProveedor;
            }catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO (mensajeError + " : " + pe.getMessage(), "ContratoProveedorDAO");
            }
    }
    
    public SiiContratoProveedor buscarContratoProveedorPorId (Long idContratoProveedor) throws ExcepcionDAO{
        SiiContratoProveedor siiContratoProveedor = null;
        try{
            siiContratoProveedor = (SiiContratoProveedor) manager.find(SiiContratoProveedor.class, idContratoProveedor);
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ContratoProveedorDAO");
        }
        return siiContratoProveedor;
    }
    
    public SiiContratoProveedor actualizarContratoProveedor (SiiContratoProveedor siiContratoProveedor) throws ExcepcionDAO{
        try{
            manager.merge(siiContratoProveedor);
            manager.flush();
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO (mensajeError, "ContratoProveedor");
        }
        return siiContratoProveedor;
    }
    
    public List<SiiContratoProveedor> buscarContratoProveedorPorIdOficioAdjudicacion (Long idOficioAdjudicacion) throws ExcepcionDAO{
        List<SiiContratoProveedor> listaSiiContratoProveedor = new ArrayList();
        try{
            StringBuilder sql = new StringBuilder(); 
            sql.append("SELECT cp FROM SiiContratoProveedor cp WHERE cp.siiOficioAdjudica.oadCodigo = :idOficioAdjudicacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idOficioAdjudicacion",idOficioAdjudicacion); 
            listaSiiContratoProveedor = query.getResultList();
            return listaSiiContratoProveedor;
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoProveedorDAO");
        }
    }
}

