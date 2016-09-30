package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PerInvesProIleAutoPruDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPerInvesProIleAutoPru;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PerInvesProIleAutoPruVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Personas Investigadas en Autos que Decretan Pruebas del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminPerInvesProIleAutoPruBean implements AdminPerInvesProIleAutoPru 
{
    @EJB
    private PerInvesProIleAutoPruDAO perInvesProIleAutoPruDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    
    /**
     * Constructor.
     */
    public AdminPerInvesProIleAutoPruBean() 
    {
        super();
    }
    
    
    @Override
    public PerInvesProIleAutoPruVO buscarPerInvesProIleAutoPruPorId(Long pauCodigo) throws ExcepcionDAO 
    {
        PerInvesProIleAutoPruVO resultado = null;
        SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru = perInvesProIleAutoPruDao.buscarPorCodigo(pauCodigo);
        if (siiPerInvesProIleAutoPru!=null)
            resultado = new PerInvesProIleAutoPruVO(siiPerInvesProIleAutoPru);
        
        return (resultado);
    }
    
    
    @Override
    public PerInvesProIleAutoPruVO insertarPerInvesProIleAutoPru(PerInvesProIleAutoPruVO perInvesProIleAutoPruVo) throws ExcepcionDAO 
    {
        PerInvesProIleAutoPruVO resultado = null;
        SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru = perInvesProIleAutoPruDao.insertar(conversionVoEntidad.convertir(perInvesProIleAutoPruVo));
        if (siiPerInvesProIleAutoPru!=null)
            resultado = new PerInvesProIleAutoPruVO(siiPerInvesProIleAutoPru);
        
        return (resultado);
    }
    
    
    @Override
    public PerInvesProIleAutoPruVO actualizarPerInvesProIleAutoPru(PerInvesProIleAutoPruVO perInvesProIleAutoPruVo) throws ExcepcionDAO 
    {
        PerInvesProIleAutoPruVO resultado = null;
        SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru = perInvesProIleAutoPruDao.actualizar(conversionVoEntidad.convertir(perInvesProIleAutoPruVo));
        if (siiPerInvesProIleAutoPru!=null)
            resultado = new PerInvesProIleAutoPruVO(siiPerInvesProIleAutoPru);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarPerInvesProIleAutoPru(Long pauCodigo) throws ExcepcionDAO 
    {
        perInvesProIleAutoPruDao.eliminar(pauCodigo);
    }
    
    
    @Override
    public List<PerInvesProIleAutoPruVO> buscarTodaPerInvesProIleAutoPru() throws ExcepcionDAO 
    {
        List<PerInvesProIleAutoPruVO> resultado = null;
        List<SiiPerInvesProIleAutoPru> lista = perInvesProIleAutoPruDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<PerInvesProIleAutoPruVO>();
            
            for (SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru: lista) {
                if (siiPerInvesProIleAutoPru!=null)
                    resultado.add(new PerInvesProIleAutoPruVO(siiPerInvesProIleAutoPru));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<PerInvesProIleAutoPruVO> buscarPerInvesProIleAutoPruPorIdAutoDecretaPrueProIle(Long atpCodigo) throws ExcepcionDAO 
    {
        List<PerInvesProIleAutoPruVO> resultado = null;
        List<SiiPerInvesProIleAutoPru> lista = perInvesProIleAutoPruDao.buscarPerInvesProIleAutoPruPorIdAutoDecretaPrueProIle(atpCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<PerInvesProIleAutoPruVO>();
            
            for (SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru: lista) {
                if (siiPerInvesProIleAutoPru!=null)
                    resultado.add(new PerInvesProIleAutoPruVO(siiPerInvesProIleAutoPru));
            }
        }
        
        return (resultado);
    }
}
