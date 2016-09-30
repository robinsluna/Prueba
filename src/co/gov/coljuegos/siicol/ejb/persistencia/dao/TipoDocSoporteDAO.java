package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSoporte;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class TipoDocSoporteDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TipoDocSoporteDAO() {
        recursos = new Recursos();
    }

    public SiiTipoDocSoporte buscarTipoDocumentoSoportePorId(Long idTipoDocSoporte) throws ExcepcionDAO {
        SiiTipoDocSoporte siiTipoDocumentoSoporte = null;
        try {
            siiTipoDocumentoSoporte = (SiiTipoDocSoporte) manager.find(SiiTipoDocSoporte.class, idTipoDocSoporte);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiTipoDocumentoSoporte;
    }

    public List<SiiTipoDocSoporte> buscarTodoTipoDocumentoSoporte() throws ExcepcionDAO {
        List<SiiTipoDocSoporte> listaTipoDocSoporte = null;
        try {    
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tds FROM SiiTipoDocSoporte tds");
            Query query = manager.createQuery(sql.toString());
            listaTipoDocSoporte = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaTipoDocSoporte;
    }
}

