package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeActaIni;
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
public class InformeActaIniDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public InformeActaIniDAO() {
        recursos = new Recursos();
    }

    public SiiInformeActaIni buscarInformeActaIniPorId(Long id) throws ExcepcionDAO {
        SiiInformeActaIni informeActaIni = null;
        try {
            informeActaIni = (SiiInformeActaIni) manager.find(SiiInformeActaIni.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "InformeActaIniDAO");
        }
        return informeActaIni;
    }

    public SiiInformeActaIni insertarInformeActaIni(SiiInformeActaIni informeActaIni) throws ExcepcionDAO {
        try {
            manager.persist(informeActaIni);
            manager.flush();
            return informeActaIni;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "InformeActaIniDAO");
        }
    }

    public SiiInformeActaIni actualizarInformeActaIni(SiiInformeActaIni informeActaIni) throws ExcepcionDAO {
        try {
            manager.merge(informeActaIni);
            manager.flush();
            return informeActaIni;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "informeActaIniDAO");
        }
    }

    public List<SiiInformeActaIni> buscarInformeActaIniPorActaInicio(Long acnCodigo) throws ExcepcionDAO {
        List<SiiInformeActaIni> listaInformeActaIni = new ArrayList<SiiInformeActaIni>();
        SiiInformeActaIni informeActaIni = new SiiInformeActaIni();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiInformeActaIni o WHERE o.siiActaIniContrato.acnCodigo = :acnCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("acnCodigo", acnCodigo);
            return listaInformeActaIni = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "informeActaIniDAO");
        }

    }

    public void eliminaInformeActaIni(Long iaiCodigo) throws ExcepcionDAO {
        SiiInformeActaIni informeActaIni = null;
        try {
            informeActaIni = (SiiInformeActaIni) manager.find(SiiInformeActaIni.class, iaiCodigo);
            manager.remove(informeActaIni);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "informeActaIniDAO");
        }
    }
    
     

}
