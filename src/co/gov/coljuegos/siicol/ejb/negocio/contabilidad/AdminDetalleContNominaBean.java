/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-06-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleContNominaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleContNomina;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetalleContNominaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminDetalleContNominaBean implements AdminDetalleContNomina {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private DetalleContNominaDAO detalleContNominaDao;
    
    
    /**
     * Constructor.
     */
    public AdminDetalleContNominaBean() { }
    
    
    
    
    @Override
    public DetalleContNominaVO buscarDetalleContNominaPorId(Long dcmCodigo) throws ExcepcionDAO {
        DetalleContNominaVO detalleContNominaVo = null;
        SiiDetalleContNomina siiDetalleContNomina = detalleContNominaDao.buscarPorCodigo(dcmCodigo);
        if (siiDetalleContNomina!=null)
            detalleContNominaVo = new DetalleContNominaVO(siiDetalleContNomina);
        
        return (detalleContNominaVo);
    }
    
    
    @Override
    public DetalleContNominaVO insertarDetalleContNomina(DetalleContNominaVO detalleContNominaVo) throws ExcepcionDAO {
        DetalleContNominaVO resultado = null;
        SiiDetalleContNomina siiDetalleContNomina = detalleContNominaDao.insertar(conversionVoEntidad.convertir(detalleContNominaVo));
        if (siiDetalleContNomina!=null)
            resultado = new DetalleContNominaVO(siiDetalleContNomina);
        
        return (resultado);
    }

    @Override
    public DetalleContNominaVO actualizarDetalleContNomina(DetalleContNominaVO detalleContNominaVo) throws ExcepcionDAO {
        DetalleContNominaVO resultado = null;
        SiiDetalleContNomina siiDetalleContNomina = detalleContNominaDao.actualizar(conversionVoEntidad.convertir(detalleContNominaVo));
        if (siiDetalleContNomina!=null)
            resultado = new DetalleContNominaVO(siiDetalleContNomina);
        
        return (resultado);
    }

    @Override
    public void borrarDetalleContNomina(Long dcmCodigo) throws ExcepcionDAO {
        detalleContNominaDao.eliminar(dcmCodigo);
    }
    
    
    @Override
    public List<DetalleContNominaVO> buscarTodoDetalleContNomina() throws ExcepcionDAO {
        List<DetalleContNominaVO> resultado = null;
        List<SiiDetalleContNomina> lista = detalleContNominaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<DetalleContNominaVO>();
            
            for (SiiDetalleContNomina siiDetalleContNomina: lista) {
                if (siiDetalleContNomina!=null)
                    resultado.add(new DetalleContNominaVO(siiDetalleContNomina));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DetalleContNominaVO> buscarPorCodigoObligacion(Long oblCodigo) throws ExcepcionDAO {
        List<DetalleContNominaVO> resultado = null;
        List<SiiDetalleContNomina> lista = detalleContNominaDao.buscarPorCodigoObligacion(oblCodigo);
        if (lista!=null) {
            resultado = new ArrayList<DetalleContNominaVO>();
            
            for (SiiDetalleContNomina siiDetalleContNomina: lista) {
                if (siiDetalleContNomina!=null)
                    resultado.add(new DetalleContNominaVO(siiDetalleContNomina));
            }
        }
        return (resultado);
    }
}
