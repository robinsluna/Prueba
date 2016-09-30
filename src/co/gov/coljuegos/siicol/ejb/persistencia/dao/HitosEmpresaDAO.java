package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHitosEmpresa;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * DAO para proveedor de tecnologia
 * @author Giovanni
 */
@Stateless
@LocalBean
public class HitosEmpresaDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager entityManager;
    private Recursos recursos;

    /**
     * Registro
     *
     * @param siiHitosEmpresa
     * @throws ExcepcionDAO
     */
    public void insertarHitosEmpresa(SiiHitosEmpresa siiHitosEmpresa) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.persist(siiHitosEmpresa);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "HitosEmpresaDAO");
        }
    }
    
    /**
     * Eliminar
     *
     * @param siiHitosEmpresa
     * @throws ExcepcionDAO
     */
    public void eliminarHitosEmpresa(SiiHitosEmpresa siiHitosEmpresa) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.remove(siiHitosEmpresa);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "HitosEmpresaDAO");
        }
    }

    /**
     * actualizar
     *
     * @param siiHitosEmpresa
     * @throws ExcepcionDAO
     */
    public void actualizarHitosEmpresa(SiiHitosEmpresa siiHitosEmpresa) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.merge(siiHitosEmpresa);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "HitosEmpresaDAO");
        }
    }

    /**
     * Metodo para traer todos los hitos para para la persona
     * @author Giovanni
     * @param idPersona
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiHitosEmpresa> buscarHitosEmpresaXCodigoPersonal(long idPersona) throws ExcepcionDAO {
        List<SiiHitosEmpresa> siiHitosEmpresas = new ArrayList<SiiHitosEmpresa>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT he FROM SiiHitosEmpresa he");
            sql.append(" WHERE he.siiPersona.perCodigo = :idPersona");

            Query query = entityManager.createQuery(sql.toString());
            query.setParameter("idPersona", idPersona);
            siiHitosEmpresas = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "HitosEmpresaDAO");
        }
        return siiHitosEmpresas;
    }
    
    public SiiHitosEmpresa buscarHitoEmpresaPorId(Long idHitoEmpresa) throws ExcepcionDAO{
            SiiHitosEmpresa siiHitosEmpresa = null;
            try{
                siiHitosEmpresa = entityManager.find(SiiHitosEmpresa.class, idHitoEmpresa);
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"HitosEmpresaDAO");
            }
            return siiHitosEmpresa;
        }
}
