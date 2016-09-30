package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComunicacSujSancIle;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ComunicacSujSancIleDAO  extends AbstractDAO<Long,SiiComunicacSujSancIle>{
    public ComunicacSujSancIleDAO() {
        super(SiiComunicacSujSancIle.class);
    }

    /**
     * Buscar comunicaciones para determinar sujeto sancionable.
     * @param prsCodigo
     * @return listaSiiComunicacSujSancIle - Lista de SiiComunicacSujSancIle
     * @throws ExcepcionDAO
     */
    
    public List<SiiComunicacSujSancIle> buscarComunicacSujSancIleXIdProceso(Long prsCodigo) throws ExcepcionDAO {
        List<SiiComunicacSujSancIle> listaSiiComunicacSujSancIle = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT csci from SiiComunicacSujSancIle csci  ");
            sql.append(" WHERE  csci.siiProcesoSancIlegalidad.prsCodigo=:prsCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("prsCodigo", prsCodigo);
            listaSiiComunicacSujSancIle = query.getResultList();
            return listaSiiComunicacSujSancIle;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ComunicacSujSancIleDAO");
        }

    }
}
