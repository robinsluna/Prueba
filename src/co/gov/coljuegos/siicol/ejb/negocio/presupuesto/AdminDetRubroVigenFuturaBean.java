/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetRubroVigenFuturaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetRubroVigenFutura;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetRubroVigenFuturaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminDetRubroVigenFuturaBean implements AdminDetRubroVigenFutura 
{
    @EJB
    private DetRubroVigenFuturaDAO detRubroVigenFuturaDao;
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    
    /**
     * Constructor.
     */
    public AdminDetRubroVigenFuturaBean() { }
    
    
    
    @Override
    public DetRubroVigenFuturaVO buscarDetRubroVigenFuturaPorId(Long drvCodigo) throws ExcepcionDAO {
        DetRubroVigenFuturaVO resultado = null;
        SiiDetRubroVigenFutura siiDetRubroVigenFutura = detRubroVigenFuturaDao.buscarPorCodigo(drvCodigo);
        if (siiDetRubroVigenFutura!=null)
            resultado = new DetRubroVigenFuturaVO(siiDetRubroVigenFutura);
        
        return (resultado);
    }


    @Override
    public DetRubroVigenFuturaVO insertarDetRubroVigenFutura(DetRubroVigenFuturaVO detRubroVigenFuturaVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        DetRubroVigenFuturaVO resultado = null;
        SiiDetRubroVigenFutura siiDetRubroVigenFutura = detRubroVigenFuturaDao.insertar(conversionVoEntidad.convertir(detRubroVigenFuturaVo));
        if (siiDetRubroVigenFutura!=null)
            resultado = new DetRubroVigenFuturaVO(siiDetRubroVigenFutura);
        
        return (resultado);
    }


    @Override
    public DetRubroVigenFuturaVO actualizarDetRubroVigenFutura(DetRubroVigenFuturaVO detRubroVigenFuturaVo) throws ExcepcionDAO 
    {
        DetRubroVigenFuturaVO resultado = null;
        SiiDetRubroVigenFutura siiDetRubroVigenFutura = detRubroVigenFuturaDao.actualizar(conversionVoEntidad.convertir(detRubroVigenFuturaVo));
        if (siiDetRubroVigenFutura!=null)
            resultado = new DetRubroVigenFuturaVO(siiDetRubroVigenFutura);
        
        return (resultado);
    }


    @Override
    public void borrarDetRubroVigenFutura(Long drvCodigo) throws ExcepcionDAO 
    {
        detRubroVigenFuturaDao.eliminar(drvCodigo);
    }


    @Override
    public List<DetRubroVigenFuturaVO> buscarTodoDetRubroVigenFutura() throws ExcepcionDAO 
    {
        List<DetRubroVigenFuturaVO> resultado = null;
        List<SiiDetRubroVigenFutura> lista = detRubroVigenFuturaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<DetRubroVigenFuturaVO>();
            for (SiiDetRubroVigenFutura siiDetRubroVigenFutura: lista) {
                if (siiDetRubroVigenFutura!=null)
                    resultado.add(new DetRubroVigenFuturaVO(siiDetRubroVigenFutura));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DetRubroVigenFuturaVO> buscarPorVigencia(Integer drvVigencia) throws ExcepcionDAO {
        List<DetRubroVigenFuturaVO> resultado = null;
        List<SiiDetRubroVigenFutura> lista = detRubroVigenFuturaDao.buscarPorVigencia(drvVigencia);
        if (lista!=null) {
            resultado = new ArrayList<DetRubroVigenFuturaVO>();
            for (SiiDetRubroVigenFutura siiDetRubroVigenFutura: lista) {
                if (siiDetRubroVigenFutura!=null)
                    resultado.add(new DetRubroVigenFuturaVO(siiDetRubroVigenFutura));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DetRubroVigenFuturaVO> buscarPorVigencia(Integer drvVigencia, Long vfuCodigo) throws ExcepcionDAO {
        List<DetRubroVigenFuturaVO> resultado = null;
        List<SiiDetRubroVigenFutura> lista = detRubroVigenFuturaDao.buscarPorVigencia(drvVigencia, vfuCodigo);
        if (lista!=null) {
            resultado = new ArrayList<DetRubroVigenFuturaVO>();
            for (SiiDetRubroVigenFutura siiDetRubroVigenFutura: lista) {
                if (siiDetRubroVigenFutura!=null)
                    resultado.add(new DetRubroVigenFuturaVO(siiDetRubroVigenFutura));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DetRubroVigenFuturaVO> buscarPorCodigoVigenciaFutura(Long vfuCodigo) throws ExcepcionDAO {
        List<DetRubroVigenFuturaVO> resultado = null;
        List<SiiDetRubroVigenFutura> lista = detRubroVigenFuturaDao.buscarPorCodigoVigenciaFutura(vfuCodigo);
        if (lista!=null) {
            resultado = new ArrayList<DetRubroVigenFuturaVO>();
            for (SiiDetRubroVigenFutura siiDetRubroVigenFutura: lista) {
                if (siiDetRubroVigenFutura!=null)
                    resultado.add(new DetRubroVigenFuturaVO(siiDetRubroVigenFutura));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DetRubroVigenFuturaVO> buscarPorVigenciaFuturaEstado (Long vfuCodigo, String drvEstado) throws ExcepcionDAO {
        List<DetRubroVigenFuturaVO> resultado = null;
        List<SiiDetRubroVigenFutura> lista = detRubroVigenFuturaDao.buscarPorVigenciaFuturaEstado(vfuCodigo, drvEstado);
        if (lista!=null) {
            resultado = new ArrayList<DetRubroVigenFuturaVO>();
            for (SiiDetRubroVigenFutura siiDetRubroVigenFutura: lista) {
                if (siiDetRubroVigenFutura!=null)
                    resultado.add(new DetRubroVigenFuturaVO(siiDetRubroVigenFutura));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DetRubroVigenFuturaVO> buscarPorVigenciaFuturaDetalleRubro (Long vfuCodigo, Long druCodigo) throws ExcepcionDAO {
        List<DetRubroVigenFuturaVO> resultado = null;
        List<SiiDetRubroVigenFutura> lista = detRubroVigenFuturaDao.buscarPorVigenciaFuturaDetalleRubro(vfuCodigo, druCodigo);
        if (lista!=null) {
            resultado = new ArrayList<DetRubroVigenFuturaVO>();
            for (SiiDetRubroVigenFutura siiDetRubroVigenFutura: lista) {
                if (siiDetRubroVigenFutura!=null)
                    resultado.add(new DetRubroVigenFuturaVO(siiDetRubroVigenFutura));
            }
        }
        return (resultado);
    }
}
