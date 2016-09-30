package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoProcesoIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoProcesoIle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ElementoProcesoIleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Elementos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminElementoProcesoIleBean implements AdminElementoProcesoIle 
{
    @EJB
    private ElementoProcesoIleDAO elementoProcesoIleDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    
    /**
     * Constructor.
     */
    public AdminElementoProcesoIleBean() 
    {
        super();
    }
    
    
    @Override
    public ElementoProcesoIleVO buscarElementoProcesoIlePorId(Long eprCodigo) throws ExcepcionDAO 
    {
        ElementoProcesoIleVO resultado = null;
        SiiElementoProcesoIle siiElementoProcesoIle = elementoProcesoIleDao.buscarPorCodigo(eprCodigo);
        if (siiElementoProcesoIle!=null)
            resultado = new ElementoProcesoIleVO(siiElementoProcesoIle);
        
        return (resultado);
    }
    

    @Override
    public ElementoProcesoIleVO insertarElementoProcesoIle(ElementoProcesoIleVO elementoProcesoIleVo) throws ExcepcionDAO {
        ElementoProcesoIleVO resultado = null;
        SiiElementoProcesoIle siiElementoProcesoIle = elementoProcesoIleDao.insertar(conversionVoEntidad.convertir(elementoProcesoIleVo));
        if (siiElementoProcesoIle!=null)
            resultado = new ElementoProcesoIleVO(siiElementoProcesoIle);
        
        return (resultado);
    }
    
    
    @Override
    public ElementoProcesoIleVO actualizarElementoProcesoIle(ElementoProcesoIleVO elementoProcesoIleVo) throws ExcepcionDAO {
        ElementoProcesoIleVO resultado = null;
        SiiElementoProcesoIle siiElementoProcesoIle = elementoProcesoIleDao.actualizar(conversionVoEntidad.convertir(elementoProcesoIleVo));
        if (siiElementoProcesoIle!=null)
            resultado = new ElementoProcesoIleVO(siiElementoProcesoIle);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarElementoProcesoIle(Long eprCodigo) throws ExcepcionDAO {
        elementoProcesoIleDao.eliminar(eprCodigo);
    }
    
    
    @Override
    public List<ElementoProcesoIleVO> buscarTodoElementoProcesoIle() throws ExcepcionDAO {
        List<ElementoProcesoIleVO> resultado = null;
        List<SiiElementoProcesoIle> lista = elementoProcesoIleDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<ElementoProcesoIleVO>();
            
            for (SiiElementoProcesoIle siiElementoProcesoIle: lista) {
                if (siiElementoProcesoIle!=null)
                    resultado.add(new ElementoProcesoIleVO(siiElementoProcesoIle));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<ElementoProcesoIleVO> buscarElementoProcesoIlePorIdProceso(Long prsCodigo) throws ExcepcionDAO {
        List<ElementoProcesoIleVO> resultado = null;
        List<SiiElementoProcesoIle> lista = elementoProcesoIleDao.buscarElementoProcesoIlePorIdProceso(prsCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<ElementoProcesoIleVO>();
            
            for (SiiElementoProcesoIle siiElementoProcesoIle: lista) {
                if (siiElementoProcesoIle!=null)
                    resultado.add(new ElementoProcesoIleVO(siiElementoProcesoIle));
            }
        }
        
        return (resultado);
    }
}
