package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PruebaDescargoProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPruebaDescargoProIle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PruebaDescargoProIleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Pruebas de Descargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminPruebaDescargoProIleBean implements AdminPruebaDescargoProIle 
{
    @EJB
    private PruebaDescargoProIleDAO pruebaDescargoProIleDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    
    /**
     * Constructor.
     */
    public AdminPruebaDescargoProIleBean() {
        super();
    }
    
    
    
    @Override
    public PruebaDescargoProIleVO buscarPruebaDescargoProIlePorId(Long pdpCodigo) throws ExcepcionDAO 
    {
        PruebaDescargoProIleVO resultado = null;
        SiiPruebaDescargoProIle siiPruebaDescargoProIle = pruebaDescargoProIleDao.buscarPorCodigo(pdpCodigo);
        if (siiPruebaDescargoProIle!=null)
            resultado = new PruebaDescargoProIleVO(siiPruebaDescargoProIle);
        
        return ( resultado );
    }
    
    
    @Override
    public PruebaDescargoProIleVO insertarPruebaDescargoProIle(PruebaDescargoProIleVO pruebaDescargoProIleVo) throws ExcepcionDAO 
    {
        PruebaDescargoProIleVO resultado = null;
        SiiPruebaDescargoProIle siiPruebaDescargoProIle = pruebaDescargoProIleDao.insertar(conversionVoEntidad.convertir(pruebaDescargoProIleVo));
        if (siiPruebaDescargoProIle!=null)
            resultado = new PruebaDescargoProIleVO(siiPruebaDescargoProIle);
        
        return ( resultado );
    }
    
    
    @Override
    public PruebaDescargoProIleVO actualizarPruebaDescargoProIle(PruebaDescargoProIleVO pruebaDescargoProIleVo) throws ExcepcionDAO 
    {
        PruebaDescargoProIleVO resultado = null;
        SiiPruebaDescargoProIle siiPruebaDescargoProIle = pruebaDescargoProIleDao.actualizar(conversionVoEntidad.convertir(pruebaDescargoProIleVo));
        if (siiPruebaDescargoProIle!=null)
            resultado = new PruebaDescargoProIleVO(siiPruebaDescargoProIle);
        
        return ( resultado );
    }
    
    
    @Override
    public void eliminarPruebaDescargoProIle(Long pdpCodigo) throws ExcepcionDAO {
        pruebaDescargoProIleDao.eliminar(pdpCodigo);
    }
    
    
    @Override
    public List<PruebaDescargoProIleVO> buscarTodaPruebaDescargoProIle() throws ExcepcionDAO {
        List<PruebaDescargoProIleVO> resultado = null;
        List<SiiPruebaDescargoProIle> lista = pruebaDescargoProIleDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<PruebaDescargoProIleVO>();
            
            for (SiiPruebaDescargoProIle siiPruebaDescargoProIle: lista) {
                if (siiPruebaDescargoProIle!=null)
                    resultado.add(new PruebaDescargoProIleVO(siiPruebaDescargoProIle));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<PruebaDescargoProIleVO> buscarPruebaDescargoProIlePorIdDescargo(Long dprCodigo) throws ExcepcionDAO 
    {
        List<PruebaDescargoProIleVO> resultado = null;
        List<SiiPruebaDescargoProIle> lista = pruebaDescargoProIleDao.buscarPruebaDescargoProIlePorIdDescargo(dprCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<PruebaDescargoProIleVO>();
            
            for (SiiPruebaDescargoProIle siiPruebaDescargoProIle: lista) {
                if (siiPruebaDescargoProIle!=null)
                    resultado.add(new PruebaDescargoProIleVO(siiPruebaDescargoProIle));
            }
        }
        
        return (resultado);
    }
}
