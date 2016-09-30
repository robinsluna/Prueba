package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoMultaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoMulta;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoMultaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Tipos de Multa.
 * @author Camilo Miranda
 */
@Stateless
public class AdminTipoMultaBean implements AdminTipoMulta 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private TipoMultaDAO tipoMultaDao;
    
    
    /**
     * Constructor.
     */
    public AdminTipoMultaBean() {
        super();
    }
    
    
    @Override
    public TipoMultaVO buscarTipoMultaPorId(Long tmuCodigo) throws ExcepcionDAO 
    {
        TipoMultaVO resultado = null;
        SiiTipoMulta siiTipoMulta = tipoMultaDao.buscarPorCodigo(tmuCodigo);
        if (siiTipoMulta!=null)
            resultado = new TipoMultaVO(siiTipoMulta);
        
        return (resultado);
    }
    
    
    @Override
    public TipoMultaVO insertarTipoMulta(TipoMultaVO tipoMultaVo) throws ExcepcionDAO 
    {
        TipoMultaVO resultado = null;
        SiiTipoMulta siiTipoMulta = tipoMultaDao.insertar(conversionVoEntidad.convertir(tipoMultaVo));
        if (siiTipoMulta!=null)
            resultado = new TipoMultaVO(siiTipoMulta);
        
        return (resultado);
    }
    
    
    @Override
    public TipoMultaVO actualizarTipoMulta(TipoMultaVO tipoMultaVo) throws ExcepcionDAO {
        TipoMultaVO resultado = null;
        SiiTipoMulta siiTipoMulta = tipoMultaDao.actualizar(conversionVoEntidad.convertir(tipoMultaVo));
        if (siiTipoMulta!=null)
            resultado = new TipoMultaVO(siiTipoMulta);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarTipoMulta(Long tmuCodigo) throws ExcepcionDAO {
        tipoMultaDao.eliminar(tmuCodigo);
    }
    
    
    @Override
    public List<TipoMultaVO> buscarTodoTipoMulta() throws ExcepcionDAO {
        List<TipoMultaVO> resultado = null;
        List<SiiTipoMulta> lista = tipoMultaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<TipoMultaVO>();
            for (SiiTipoMulta siiTipoMulta: lista) {
                if (siiTipoMulta!=null)
                    resultado.add(new TipoMultaVO(siiTipoMulta));
            }
        }
        
        return (resultado);
    }
}
