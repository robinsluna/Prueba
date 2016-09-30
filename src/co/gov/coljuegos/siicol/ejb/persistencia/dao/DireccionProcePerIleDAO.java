package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionProcePerIle;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DireccionProcePerIleDAO extends AbstractDAO<Long, SiiDireccionProcePerIle> {
    public DireccionProcePerIleDAO() {
        super(SiiDireccionProcePerIle.class);
    }

    /**
     * Buscar la dirección procesal por id persona investigada
     * @param pipCodigo
     * @return resultado - Lista de SiiDireccionProcePerIle
     * @throws ExcepcionDAO
     */

    public List<SiiDireccionProcePerIle> buscarDireccionProcePerIleXIdPerInvest(Long pipCodigo) throws ExcepcionDAO {
        List<SiiDireccionProcePerIle> resultado = null;

        if(pipCodigo != null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dppi FROM SiiDireccionProcePerIle dppi ");
                sql.append("WHERE dppi.siiPersonaInvestProIle.pipCodigo = :pipCodigo ");

                Query query = em.createQuery(sql.toString());
                query.setParameter("pipCodigo", pipCodigo);

                resultado = query.getResultList();

            } catch(PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }
        return (resultado);
    }
}
