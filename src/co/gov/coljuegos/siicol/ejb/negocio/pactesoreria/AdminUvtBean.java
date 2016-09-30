/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 13-05-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UvtDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUvt;
import co.gov.coljuegos.siicol.ejb.vo.UvtVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminUvtBean implements AdminUvt {
    
    @EJB
    private UvtDAO uvtDao;
    
    
    /**
     * Constructor.
     */
    public AdminUvtBean() {
        super();
    }
    
    
    /* 
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.UvtDAO#obtenerUvtPorVigencia(java.lang.Integer)
     */
    @Override
    public UvtVO obtenerUvtPorVigencia(Integer uvtVigencia) throws ExcepcionDAO {
        UvtVO uvtVo = null;
        
        SiiUvt siiUvt = uvtDao.obtenerUvtPorVigencia(uvtVigencia);
        if (siiUvt!=null)
            uvtVo = new UvtVO(siiUvt);
        
        return (uvtVo);
    }
}
