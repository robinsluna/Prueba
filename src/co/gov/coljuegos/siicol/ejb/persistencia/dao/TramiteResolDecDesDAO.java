/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 30-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolDecDes;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data access object que gestiona los tr�mites de resoluciones de decomiso y destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
 */

@Stateless
@LocalBean
public class TramiteResolDecDesDAO extends AbstractDAO<Long, SiiTramiteResolDecDes> {

    /**
     * Constructor
     */

    public TramiteResolDecDesDAO() {
        super(SiiTramiteResolDecDes.class);
    }

    /**
     * Buscar los tr�mites de resoluci�n de decomiso y destrucci�n seg�n id resoluci�n y id estado
     * @param rddCodigo
     * @param etdCodigo
     * @return resultado - lista de los tr�mites de resoluci�n
     * @throws ExcepcionDAO
     */
    
    public List<SiiTramiteResolDecDes> buscarTramiteResolDecDesXIdResolucionXIdEstado(Long rddCodigo,
                                                                                      Long etdCodigo) throws ExcepcionDAO {
        List<SiiTramiteResolDecDes> resultado = null;

        if (rddCodigo != null ) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT trd FROM SiiTramiteResolDecDes trd ");
                sql.append(" WHERE trd.siiResolucionDecomDest.rddCodigo = :rddCodigo" );
                if(etdCodigo != null)
                    sql.append(" and trd.siiEstadoTramResDecDes.etdCodigo = :etdCodigo order by trd.trdFecha ");

                Query query = em.createQuery(sql.toString());
                query.setParameter("rddCodigo", rddCodigo);
                if(etdCodigo != null)
                    query.setParameter("etdCodigo", etdCodigo);

                resultado = query.getResultList();
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, this.getClass().getSimpleName());
            }
        }

        return (resultado);
    }
    
    
}
