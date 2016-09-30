package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAseguradora;
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
public class AseguradoraDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    public AseguradoraDAO() {
        recursos = new Recursos();
    }

    /**
     * @author Modifica Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiAseguradora> buscarTodaAseguradora() throws ExcepcionDAO {
        List<SiiAseguradora> siiAseguradoras = null;
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ase FROM SiiAseguradora ase");
            sql.append(" ORDER BY ase.siiPersona.perJurNombreLargo ASC");
            
            Query query = manager.createQuery(sql.toString());
            siiAseguradoras = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AseguradoraDAO");
        }
        return siiAseguradoras;
    }

    public SiiAseguradora buscarAseguradoraPorCodigo(Long aseCodigo) throws ExcepcionDAO {
        SiiAseguradora aseguradora = null;
        try {
            aseguradora = (SiiAseguradora) manager.find(SiiAseguradora.class, aseCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AseguradoraDAO");
        }
        return aseguradora;
    }        

}
