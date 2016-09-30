package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioResolDesisDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioResolDesis;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.InventarioResolDesisVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminInventarioResolDesisBean implements AdminInventarioResolDesis {
    @EJB
    InventarioResolDesisDAO inventarioResolDesisDao;
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
     
    @Override
    public InventarioResolDesisVO buscarInventarioResolDesisPorId(Long irdCodigo) throws ExcepcionDAO {
        InventarioResolDesisVO resultado = null;
        SiiInventarioResolDesis siiInventarioResolDesis = inventarioResolDesisDao.buscarPorCodigo(irdCodigo);
        if (siiInventarioResolDesis!=null){
        resultado = (new InventarioResolDesisVO(siiInventarioResolDesis));
        }
        return resultado;
    }
    
    @Override
    public InventarioResolDesisVO insertarInventarioResolDesis(InventarioResolDesisVO inventarioResolDesisVo) throws ExcepcionDAO {
        
        InventarioResolDesisVO resultado = null;     
        
        SiiInventarioResolDesis siiInventarioResolDesis = new SiiInventarioResolDesis();
        
        SiiInventarioResolDesis inventarioResolDesis = inventarioResolDesisDao.insertar(conversionVoEntidad.convertir(inventarioResolDesisVo));        
            
        if (siiInventarioResolDesis!=null)        
            
                resultado = new InventarioResolDesisVO(siiInventarioResolDesis);
        
            return resultado;
    }

    @Override
    public InventarioResolDesisVO actualizarInventarioResolDesis(InventarioResolDesisVO inventarioResolDesisVo) throws ExcepcionDAO {
       
        InventarioResolDesisVO resultado = null;     
        
        SiiInventarioResolDesis siiInventarioResolDesis = new SiiInventarioResolDesis();
        
        SiiInventarioResolDesis inventarioResolDesis = inventarioResolDesisDao.actualizar(conversionVoEntidad.convertir(inventarioResolDesisVo));        
            
        if (siiInventarioResolDesis!=null)        
            
                resultado = new InventarioResolDesisVO(siiInventarioResolDesis);
        
            return resultado;
    }

    @Override
    public void eliminarInventarioResolDesis(Long irdCodigo) throws ExcepcionDAO {
        // TODO Implement this method
    }

    @Override
    public List<InventarioResolDesisVO> buscarTodoInventarioResolDesis() throws ExcepcionDAO {
        List<InventarioResolDesisVO> resultado = null;
        List<SiiInventarioResolDesis> lista = inventarioResolDesisDao.buscarTodo();
        
        if (lista!=null) {
            resultado = new ArrayList<InventarioResolDesisVO>();
            for (SiiInventarioResolDesis siiInventarioResolDesis: lista) {
                if (siiInventarioResolDesis!=null)
                    resultado.add(new InventarioResolDesisVO(siiInventarioResolDesis));
            }
        }
        
        return resultado;
    }
    
    @Override
    public List<InventarioResolDesisVO> buscarInventarioResolDesisPorIdResolucionDesisSolAut (Long rdsCodigo) throws ExcepcionDAO {
        List<InventarioResolDesisVO> resultado = null;
        List<SiiInventarioResolDesis> lista = inventarioResolDesisDao.buscarInventarioResolDesisPorIdResolucionDesisSolAut(rdsCodigo);
        
        if (lista!=null) {
            resultado = new ArrayList<InventarioResolDesisVO>();
            for (SiiInventarioResolDesis siiInventarioResolDesis: lista) {
                if (siiInventarioResolDesis!=null)
                    resultado.add(new InventarioResolDesisVO(siiInventarioResolDesis));
            }
        }
        
        return resultado;
    }
}
