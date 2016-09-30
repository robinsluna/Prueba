/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResponDianPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponDianPersona;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ResponDianPersonaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminResponDianPersonaBean implements AdminResponDianPersona {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ResponDianPersonaDAO responDianPersonaDao;
    
    
    /**
     * Constructor.
     */
    public AdminResponDianPersonaBean() {
        super();
    }

    @Override
    public ResponDianPersonaVO buscarPorCodigoResponDianPersona(Long rdpCodigo) throws ExcepcionDAO {
        SiiResponDianPersona siiResponDianPersona = responDianPersonaDao.buscarPorCodigo(rdpCodigo);
        if (siiResponDianPersona!=null)
            return ( new ResponDianPersonaVO(siiResponDianPersona) );
        return null;
    }

    @Override
    public ResponDianPersonaVO insertarResponDianPersona(ResponDianPersonaVO responDianPersonaVo) throws ExcepcionDAO {
        SiiResponDianPersona siiResponDianPersona = responDianPersonaDao.insertar(conversionVoEntidad.convertir(responDianPersonaVo));
        if (siiResponDianPersona!=null)
            return ( new ResponDianPersonaVO(siiResponDianPersona) );
        return null;
    }

    @Override
    public ResponDianPersonaVO actualizarResponDianPersona(ResponDianPersonaVO responDianPersonaVo) throws ExcepcionDAO {
        SiiResponDianPersona siiResponDianPersona = responDianPersonaDao.actualizar(conversionVoEntidad.convertir(responDianPersonaVo));
        if (siiResponDianPersona!=null)
            return ( new ResponDianPersonaVO(siiResponDianPersona) );
        return null;
    }

    @Override
    public void eliminarResponDianPersona(Long rdpCodigo) throws ExcepcionDAO {
        this.eliminarResponDianPersona(rdpCodigo);
    }

    @Override
    public List<ResponDianPersonaVO> buscarTodaResponDianPersona() throws ExcepcionDAO {
        List<ResponDianPersonaVO> resultado = null;
        List<SiiResponDianPersona> lista = responDianPersonaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ResponDianPersonaVO>();
            for (SiiResponDianPersona siiResponDianPersona: lista) {
                resultado.add(new ResponDianPersonaVO(siiResponDianPersona));
            }
        }
        return (resultado);
    }

    @Override
    public List<ResponDianPersonaVO> buscarPorCodigoPersona(Long perCodigo) throws ExcepcionDAO {
        List<ResponDianPersonaVO> resultado = null;
        List<SiiResponDianPersona> lista = responDianPersonaDao.buscarPorCodigoPersona(perCodigo);
        if (lista!=null) {
            resultado = new ArrayList<ResponDianPersonaVO>();
            for (SiiResponDianPersona siiResponDianPersona: lista) {
                resultado.add(new ResponDianPersonaVO(siiResponDianPersona));
            }
        }
        return (resultado);
    }
}
