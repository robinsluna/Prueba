/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 13-05-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUvt;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;


@Stateless
@LocalBean
public class UvtDAO extends GenericDAO<SiiUvt> {
    /**
     * Constructor.
     */
    public UvtDAO() {
        super(SiiUvt.class);
    }
    
    
    
    /**
     * Obtiene el UVT correspondiente a la vigencia dada.
     * @param uvtVigencia - Vigencia del UVT.
     * @return Instance of SiiUvt.
     * @throws ExcepcionDAO
     */
    public SiiUvt obtenerUvtPorVigencia (Integer uvtVigencia) throws ExcepcionDAO 
    {
        SiiUvt siiUvt = null;
        
        try {
            siiUvt = em.find(SiiUvt.class, uvtVigencia);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (siiUvt);
    }
}
