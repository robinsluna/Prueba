package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoInstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoInstrumento;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TipoInstrumentoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminTipoInstrumentoBean implements AdminTipoInstrumento 
{
    @EJB
    private TipoInstrumentoDAO tipoInstrumentoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminTipoInstrumentoBean() { }
    

    @Override
    public TipoInstrumentoVO buscarTipoInstrumentoPorCodigo (Long tinCodigo) throws ExcepcionDAO 
    {
        TipoInstrumentoVO resultado = null;
        SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarPorCodigo(tinCodigo);
        if (siiTipoInstrumento!=null)
            resultado = new TipoInstrumentoVO(siiTipoInstrumento);
        
        return (resultado);
    }
    
    
    @Override
    public TipoInstrumentoVO insertarTipoInstrumento(TipoInstrumentoVO tipoInstrumentoVo) throws ExcepcionDAO 
    {
        TipoInstrumentoVO resultado = null;
        SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.insertar(conversionVoEntidad.convertir(tipoInstrumentoVo));
        if (siiTipoInstrumento!=null)
            resultado = new TipoInstrumentoVO(siiTipoInstrumento);
        
        return (resultado);
    }
    
    
    @Override
    public TipoInstrumentoVO actualizarTipoInstrumento(TipoInstrumentoVO tipoInstrumentoVo) throws ExcepcionDAO 
    {
        TipoInstrumentoVO resultado = null;
        SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.actualizar(conversionVoEntidad.convertir(tipoInstrumentoVo));
        if (siiTipoInstrumento!=null)
            resultado = new TipoInstrumentoVO(siiTipoInstrumento);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarTipoInstrumento(Long tinCodigo) throws ExcepcionDAO 
    {
        tipoInstrumentoDao.eliminar(tinCodigo);
    }
    
    
    @Override
    public List<TipoInstrumentoVO> buscarTodoTipoInstrumento() throws ExcepcionDAO 
    {
        List<TipoInstrumentoVO> resultado = null;
        List<SiiTipoInstrumento> lista = tipoInstrumentoDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TipoInstrumentoVO>();
            
            for (SiiTipoInstrumento siiTipoInstrumento: lista) {
                if (siiTipoInstrumento!=null)
                    resultado.add(new TipoInstrumentoVO(siiTipoInstrumento));
            }
        }
        
        return (resultado);
    }
}
