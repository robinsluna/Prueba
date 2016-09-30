package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoRadicado;
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
public class DocumentoRadicadoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DocumentoRadicadoDAO() {
        recursos = new Recursos();
    }

    /**
     *
     * @param siiDocumentoRadicado
     * @return
     * @throws ExcepcionDAO
     */
    public SiiDocumentoRadicado insertarSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) throws ExcepcionDAO {
        try {
            manager.persist(siiDocumentoRadicado);
            manager.flush();
            return siiDocumentoRadicado;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ErrorDAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DocumentoRadicadoDAO");
        }
    }

    /**
     *
     * @param idDocumentoRadicado
     * @return
     * @throws ExcepcionDAO
     */
    public SiiDocumentoRadicado buscarDocumentoRadicadoPorId(String idDocumentoRadicado) throws ExcepcionDAO {
        SiiDocumentoRadicado siiDocumentoRadicado = null;
        try {
            siiDocumentoRadicado = (SiiDocumentoRadicado) manager.find(SiiDocumentoRadicado.class, idDocumentoRadicado);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ErrorDAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DocumentoRadicadoDAO");
        }
        return siiDocumentoRadicado;
    }

    /**
     *
     * @param estudioPrevio
     * @return
     * @throws ExcepcionDAO
     */
    public SiiDocumentoRadicado actualizarDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) throws ExcepcionDAO {
        try {
            manager.merge(siiDocumentoRadicado);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ErrorDAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DocumentoRadicadoDAO");
        }
        return siiDocumentoRadicado;
    }

    /**
     *Metodo encargado de hacer la busqueda del ultimo registro radicado para una persona
     * @author David Tafur
     * @author Modifica Giovanni
     * @param numeroIdentificacion
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiDocumentoRadicado> buscarUltimosDocumentoRadicadosPorNumIdentificacion(String numeroIdentificacion) throws ExcepcionDAO {
        List<SiiDocumentoRadicado> listaSiiDocumentoRadicado = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dra FROM SiiDocumentoRadicado dra");
            sql.append(" INNER JOIN dra.siiPersona per");
            sql.append(" WHERE dra.siiTipoPersonal IS NULL");
            sql.append(" AND per.perNumIdentificacion = :numIdentificacion");
            sql.append(" ORDER BY dra.draFecha DESC");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("numIdentificacion", numeroIdentificacion);

            listaSiiDocumentoRadicado = consulta.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ErrorDAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DocumentoRadicadoDAO");
        }
        return listaSiiDocumentoRadicado;
    }
    
    public List<SiiDocumentoRadicado> buscarUltimosDocumentoRadicadosPorNumIdentificacionPorIdTipoPersonal(String numeroIdentificacion, Long idTipoPersonal) throws ExcepcionDAO {
        List<SiiDocumentoRadicado> listaSiiDocumentoRadicado = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dra FROM SiiDocumentoRadicado dra");
            sql.append(" INNER JOIN dra.siiPersona per");
            sql.append(" WHERE dra.siiTipoPersonal.tpeCodigo = :idTipoPersonal");
            sql.append(" AND per.perNumIdentificacion = :numIdentificacion");
            sql.append(" ORDER BY dra.draFecha DESC");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("idTipoPersonal", idTipoPersonal);
            consulta.setParameter("numIdentificacion", numeroIdentificacion);

            listaSiiDocumentoRadicado = consulta.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ErrorDAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DocumentoRadicadoDAO");
        }
        return listaSiiDocumentoRadicado;
    }

}
