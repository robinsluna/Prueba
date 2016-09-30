package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogModificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;

import co.gov.coljuegos.siicol.ejb.vo.LogModificacionVO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class LogModificacionDAO extends AbstractDAO<Long, SiiLogModificacion>
{
    public LogModificacionDAO() 
    {
        super(SiiLogModificacion.class);
    }
    
    
    public List<SiiLogModificacion> buscarTablasLogModificacion () throws ExcepcionDAO {
        List<SiiLogModificacion> listaTabla = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT modif FROM SiiLogModificacion modif");
            Query query = em.createQuery(sql.toString());
            listaTabla = query.getResultList();
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"LogModificacionesDAO");
        }
        return listaTabla;
    }
}
