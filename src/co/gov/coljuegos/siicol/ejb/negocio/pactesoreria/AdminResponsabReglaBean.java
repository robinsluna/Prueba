/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResponsabReglaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponsabRegla;
import co.gov.coljuegos.siicol.ejb.vo.ResponsabReglaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;



@Stateless
public class AdminResponsabReglaBean implements AdminResponsabRegla {
    
    @EJB
    private ResponsabReglaDAO responsabReglaDao;
    
    
    /**
     * Constructor.
     */
    public AdminResponsabReglaBean() {
        super();
    }
    
    
    @Override
    public ResponsabReglaVO buscarResponsabReglaPorCodigo(Long rreCodigo) throws ExcepcionDAO {
        SiiResponsabRegla siiResponsabRegla = responsabReglaDao.buscarPorCodigo(rreCodigo);
        if (siiResponsabRegla!=null)
            return ( new ResponsabReglaVO(siiResponsabRegla) );
        return null;
    }
    
    
    @Override
    public List<ResponsabReglaVO> buscarTodaResponsabRegla() throws ExcepcionDAO {
        List<ResponsabReglaVO> resultado = null;
        List<SiiResponsabRegla> lista = responsabReglaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ResponsabReglaVO>();
            for (SiiResponsabRegla siiResponsabRegla: lista) {
                resultado.add(new ResponsabReglaVO(siiResponsabRegla));
            }
        }
        
        return (resultado);
    }

    @Override
    public List<ResponsabReglaVO> buscarPorCodigoResponsabilidadDian(Long rdiCodigo) throws ExcepcionDAO {
        List<ResponsabReglaVO> resultado = null;
        List<SiiResponsabRegla> lista = responsabReglaDao.buscarPorCodigoResponsabilidadDian(rdiCodigo);
        if (lista!=null) {
            resultado = new ArrayList<ResponsabReglaVO>();
            for (SiiResponsabRegla siiResponsabRegla: lista) {
                resultado.add(new ResponsabReglaVO(siiResponsabRegla));
            }
        }
        
        return (resultado);
    }
}
