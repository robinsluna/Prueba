package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionAlegatoProSanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionAlegatoProSan;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.RecepcionAlegatoProSanVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Recepci&oacute;n de Alegatos del Proceso Sancionatorio de Fiscalizaci&oacute;n.
 * @author Camilo Miranda
 */
@Stateless
public class AdminRecepcionAlegatoProSanBean implements AdminRecepcionAlegatoProSan {
    @EJB
    private RecepcionAlegatoProSanDAO recepcionAlegatoProSanDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminRecepcionAlegatoProSanBean() { }
    
    
    @Override
    public RecepcionAlegatoProSanVO buscarRecepcionAlegatoProSanPorId(Long ralCodigo) throws ExcepcionDAO 
    {
        RecepcionAlegatoProSanVO resultado = null;
        SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan = recepcionAlegatoProSanDao.buscarPorCodigo(ralCodigo);
        if (siiRecepcionAlegatoProSan!=null)
            resultado = new RecepcionAlegatoProSanVO(siiRecepcionAlegatoProSan);
        
        return (resultado);
    }
    
    
    @Override
    public RecepcionAlegatoProSanVO insertarRecepcionAlegatoProSan(RecepcionAlegatoProSanVO recepcionAlegatoProSanVo) throws ExcepcionDAO 
    {
        RecepcionAlegatoProSanVO resultado = null;
        SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan = recepcionAlegatoProSanDao.insertar(conversionVoEntidad.convertir(recepcionAlegatoProSanVo));
        if (siiRecepcionAlegatoProSan!=null)
            resultado = new RecepcionAlegatoProSanVO(siiRecepcionAlegatoProSan);
        
        return (resultado);
    }
    
    
    @Override
    public RecepcionAlegatoProSanVO actualizarRecepcionAlegatoProSan(RecepcionAlegatoProSanVO recepcionAlegatoProSanVo) throws ExcepcionDAO 
    {
        RecepcionAlegatoProSanVO resultado = null;
        SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan = recepcionAlegatoProSanDao.actualizar(conversionVoEntidad.convertir(recepcionAlegatoProSanVo));
        if (siiRecepcionAlegatoProSan!=null)
            resultado = new RecepcionAlegatoProSanVO(siiRecepcionAlegatoProSan);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarRecepcionAlegatoProSan(Long ralCodigo) throws ExcepcionDAO {
        recepcionAlegatoProSanDao.eliminar(ralCodigo);
    }
    
    
    @Override
    public List<RecepcionAlegatoProSanVO> buscarRecepcionAlegatoProSanPorIdProcesoSancionatorio(Long psaCodigo) throws ExcepcionDAO 
    {
        List<RecepcionAlegatoProSanVO> resultado = null;
        List<SiiRecepcionAlegatoProSan> lista = recepcionAlegatoProSanDao.buscarRecepcionAlegatoProSanPorIdProcesoSancionatorio(psaCodigo);
        if (lista!=null) {
            resultado = new ArrayList<RecepcionAlegatoProSanVO>();
            
            for (SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan: lista) {
                if (siiRecepcionAlegatoProSan!=null)
                    resultado.add(new RecepcionAlegatoProSanVO(siiRecepcionAlegatoProSan));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<RecepcionAlegatoProSanVO> buscarTodaRecepcionAlegatoProSan() throws ExcepcionDAO 
    {
        List<RecepcionAlegatoProSanVO> resultado = null;
        List<SiiRecepcionAlegatoProSan> lista = recepcionAlegatoProSanDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<RecepcionAlegatoProSanVO>();
            
            for (SiiRecepcionAlegatoProSan siiRecepcionAlegatoProSan: lista) {
                if (siiRecepcionAlegatoProSan!=null)
                    resultado.add(new RecepcionAlegatoProSanVO(siiRecepcionAlegatoProSan));
            }
        }
        
        return (resultado);
    }
}
