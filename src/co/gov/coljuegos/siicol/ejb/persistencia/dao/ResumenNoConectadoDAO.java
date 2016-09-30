/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 11-09-2015
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResumenNoConectado;
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
public class ResumenNoConectadoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ResumenNoConectadoDAO() {
        recursos = new Recursos();
    }
    
    public SiiResumenNoConectado buscarPorCodigoResumen(Long idCodigoResumen) throws ExcepcionDAO {
        SiiResumenNoConectado siiResumenNoConectadoRetorno = null;
        try {
            siiResumenNoConectadoRetorno = (SiiResumenNoConectado) manager.find(SiiResumenNoConectado.class, idCodigoResumen);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ResumenNoConectadoDAO");
        }
        return siiResumenNoConectadoRetorno;

    }
    
    public SiiResumenNoConectado insertarSiiResumenNoConectado(SiiResumenNoConectado resumenNoConectado) throws ExcepcionDAO {
        try {
            manager.persist(resumenNoConectado); 
            manager.flush(); 
            return resumenNoConectado; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ResumenNoConectadoDAO");
        }
    }
    
    public List<SiiResumenNoConectado> buscarResumenPorCodigoCuota (Long codigoCuota) throws ExcepcionDAO{
            List<SiiResumenNoConectado> listaResumenNoConectado= new ArrayList<SiiResumenNoConectado>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rnc FROM SiiResumenNoConectado rnc WHERE rnc.siiCuotaOperador.copCodigo = :codigoCuota");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoCuota", codigoCuota);
            listaResumenNoConectado = query.getResultList();
            
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ResumenNoConectadoDAO");
        }
            return listaResumenNoConectado;
        }
}