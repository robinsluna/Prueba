package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PruebaAutoDecrPruDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPruebaAutoDecrPru;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PruebaAutoDecrPruVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Pruebas del Auto que Decreta Pruebas del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminPruebaAutoDecrPruBean implements AdminPruebaAutoDecrPru 
{
    @EJB
    private PruebaAutoDecrPruDAO pruebaAutoDecrPruDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminPruebaAutoDecrPruBean() {
        super();
    }
    
    
    @Override
    public PruebaAutoDecrPruVO buscarPruebaAutoDecrPruPorId(Long papCodigo) throws ExcepcionDAO 
    {
        PruebaAutoDecrPruVO resultado = null;
        SiiPruebaAutoDecrPru siiPruebaAutoDecrPru = pruebaAutoDecrPruDao.buscarPorCodigo(papCodigo);
        if (siiPruebaAutoDecrPru!=null)
            resultado = new PruebaAutoDecrPruVO(siiPruebaAutoDecrPru);
        
        return (resultado);
    }
    
    
    @Override
    public PruebaAutoDecrPruVO insertarPruebaAutoDecrPru(PruebaAutoDecrPruVO pruebaAutoDecrPruVo) throws ExcepcionDAO 
    {
        PruebaAutoDecrPruVO resultado = null;
        SiiPruebaAutoDecrPru siiPruebaAutoDecrPru = pruebaAutoDecrPruDao.insertar(conversionVoEntidad.convertir(pruebaAutoDecrPruVo));
        if (siiPruebaAutoDecrPru!=null)
            resultado = new PruebaAutoDecrPruVO(siiPruebaAutoDecrPru);
        
        return (resultado);
    }
    
    
    @Override
    public PruebaAutoDecrPruVO actualizarPruebaAutoDecrPru(PruebaAutoDecrPruVO pruebaAutoDecrPruVo) throws ExcepcionDAO 
    {
        PruebaAutoDecrPruVO resultado = null;
        SiiPruebaAutoDecrPru siiPruebaAutoDecrPru = pruebaAutoDecrPruDao.actualizar(conversionVoEntidad.convertir(pruebaAutoDecrPruVo));
        if (siiPruebaAutoDecrPru!=null)
            resultado = new PruebaAutoDecrPruVO(siiPruebaAutoDecrPru);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarPruebaAutoDecrPru(Long papCodigo) throws ExcepcionDAO 
    {
        pruebaAutoDecrPruDao.eliminar(papCodigo);
    }
    
    
    @Override
    public List<PruebaAutoDecrPruVO> buscarTodaPruebaAutoDecrPru() throws ExcepcionDAO 
    {
        List<PruebaAutoDecrPruVO> resultado = null;
        List<SiiPruebaAutoDecrPru> lista = pruebaAutoDecrPruDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<PruebaAutoDecrPruVO>();
            
            for (SiiPruebaAutoDecrPru siiPruebaAutoDecrPru: lista) {
                if (siiPruebaAutoDecrPru!=null)
                    resultado.add(new PruebaAutoDecrPruVO(siiPruebaAutoDecrPru));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<PruebaAutoDecrPruVO> buscarPruebaAutoDecrPruPorIdAutoDecretaPrueProIle(Long atpCodigo) throws ExcepcionDAO 
    {
        List<PruebaAutoDecrPruVO> resultado = null;
        List<SiiPruebaAutoDecrPru> lista = pruebaAutoDecrPruDao.buscarPruebaAutoDecrPruPorIdAutoDecretaPrueProIle(atpCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<PruebaAutoDecrPruVO>();
            
            for (SiiPruebaAutoDecrPru siiPruebaAutoDecrPru: lista) {
                if (siiPruebaAutoDecrPru!=null)
                    resultado.add(new PruebaAutoDecrPruVO(siiPruebaAutoDecrPru));
            }
        }
        
        return (resultado);
    }
}
