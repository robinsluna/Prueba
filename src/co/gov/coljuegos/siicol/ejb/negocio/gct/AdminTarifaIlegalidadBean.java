package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TarifaIlegalidadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTarifaIlegalidad;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TarifaIlegalidadVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Tarifas de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminTarifaIlegalidadBean implements AdminTarifaIlegalidad 
{
    @EJB
    private TarifaIlegalidadDAO tarifaIlegalidadDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    
    /**
     * Constructor.
     */
    public AdminTarifaIlegalidadBean() { }
    
    
    
    @Override
    public TarifaIlegalidadVO buscarTarifaIlegalidadPorId(Long tleCodigo) throws ExcepcionDAO 
    {
        TarifaIlegalidadVO resultado = null;
        SiiTarifaIlegalidad siiTarifaIlegalidad = tarifaIlegalidadDao.buscarPorCodigo(tleCodigo);
        if (siiTarifaIlegalidad!=null)
            resultado = new TarifaIlegalidadVO(siiTarifaIlegalidad);
        
        return (resultado);
    }
    
    
    @Override
    public TarifaIlegalidadVO insertarTarifaIlegalidad(TarifaIlegalidadVO tarifaIlegalidadVo) throws ExcepcionDAO 
    {
        TarifaIlegalidadVO resultado = null;
        SiiTarifaIlegalidad siiTarifaIlegalidad = tarifaIlegalidadDao.insertar(conversionVoEntidad.convertir(tarifaIlegalidadVo));
        if (siiTarifaIlegalidad!=null)
            resultado = new TarifaIlegalidadVO(siiTarifaIlegalidad);
        
        return (resultado);
    }
    
    
    @Override
    public TarifaIlegalidadVO actualizarTarifaIlegalidad(TarifaIlegalidadVO tarifaIlegalidadVo) throws ExcepcionDAO 
    {
        TarifaIlegalidadVO resultado = null;
        SiiTarifaIlegalidad siiTarifaIlegalidad = tarifaIlegalidadDao.actualizar(conversionVoEntidad.convertir(tarifaIlegalidadVo));
        if (siiTarifaIlegalidad!=null)
            resultado = new TarifaIlegalidadVO(siiTarifaIlegalidad);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarTarifaIlegalidad(Long tleCodigo) throws ExcepcionDAO 
    {
        tarifaIlegalidadDao.eliminar(tleCodigo);
    }
    
    
    @Override
    public List<TarifaIlegalidadVO> buscarTarifaIlegalidadPorClaseJuegoTipoInstrumento(Long cjuCodigo, Long tinCodigo) throws ExcepcionDAO 
    {
        List<TarifaIlegalidadVO> resultado = null;
        List<SiiTarifaIlegalidad> lista = tarifaIlegalidadDao.buscarTarifaIlegalidadPorClaseJuegoTipoInstrumento(cjuCodigo, tinCodigo);
            if (lista!=null && !lista.isEmpty()) {
                resultado = new ArrayList<TarifaIlegalidadVO>();
                
                for (SiiTarifaIlegalidad siiTarifaIlegalidad: lista) {
                    if (siiTarifaIlegalidad!=null)
                        resultado.add(new TarifaIlegalidadVO(siiTarifaIlegalidad));
                }
            }
        
        return (resultado);
    }
    
    
    @Override
    public List<TarifaIlegalidadVO> buscarTodaTarifaIlegalidad() throws ExcepcionDAO {
        List<TarifaIlegalidadVO> resultado = null;
        List<SiiTarifaIlegalidad> lista = tarifaIlegalidadDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TarifaIlegalidadVO>();
            
            for (SiiTarifaIlegalidad siiTarifaIlegalidad: lista) {
                if (siiTarifaIlegalidad!=null)
                    resultado.add(new TarifaIlegalidadVO(siiTarifaIlegalidad));
            }
        }
        
        return (resultado);
    }
}
