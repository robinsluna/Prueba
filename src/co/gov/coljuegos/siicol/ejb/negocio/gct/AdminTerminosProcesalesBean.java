package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminosProcesalesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosProcesales;
import co.gov.coljuegos.siicol.ejb.vo.TerminosProcesalesVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de T&eacute;rminos Procesales.
 * @author Camilo Miranda
 */
@Stateless
public class AdminTerminosProcesalesBean implements AdminTerminosProcesales 
{
    @EJB
    private TerminosProcesalesDAO terminosProcesalesDao;
    
    
    /**
     * Constructor.
     */
    public AdminTerminosProcesalesBean() 
    {
        super();
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminosProcesalesDAO#buscarPorCodigo(java.lang.Long)
     */
    @Override
    public TerminosProcesalesVO buscarTerminoProcesalPorId (Long tprCodigo) throws ExcepcionDAO 
    {
        TerminosProcesalesVO resultado = null;
        SiiTerminosProcesales siiTerminosProcesales = terminosProcesalesDao.buscarPorCodigo(tprCodigo);
        if (siiTerminosProcesales!=null)
            resultado = new TerminosProcesalesVO(siiTerminosProcesales);
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminosProcesalesDAO#buscarTerminoProcesalFiscalizacionPorEstadoProceso(java.lang.Long)
     */
    @Override
    public TerminosProcesalesVO buscarTerminoProcesalFiscalizacionPorEstadoProceso(Long epsCodigo) throws ExcepcionDAO 
    {
        TerminosProcesalesVO resultado = null;
        SiiTerminosProcesales siiTerminosProcesales = terminosProcesalesDao.buscarTerminoProcesalFiscalizacionPorEstadoProceso(epsCodigo);
        if (siiTerminosProcesales!=null)
            resultado = new TerminosProcesalesVO(siiTerminosProcesales);
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminosProcesalesDAO#buscarTerminoProcesalIlegalidadPorEstadoProceso(java.lang.Long)
     */
    @Override
    public TerminosProcesalesVO buscarTerminoProcesalIlegalidadPorEstadoProceso(Long epiCodigo) throws ExcepcionDAO 
    {
        TerminosProcesalesVO resultado = null;
        SiiTerminosProcesales siiTerminosProcesales = terminosProcesalesDao.buscarTerminoProcesalIlegalidadPorEstadoProceso(epiCodigo);
        if (siiTerminosProcesales!=null)
            resultado = new TerminosProcesalesVO(siiTerminosProcesales);
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminosProcesalesDAO#buscarTodo()
     */
    @Override
    public List<TerminosProcesalesVO> buscarTodoTerminosProcesales() throws ExcepcionDAO 
    {
        List<TerminosProcesalesVO> resultado = null;
        List<SiiTerminosProcesales> lista = terminosProcesalesDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TerminosProcesalesVO>();
            
            for (SiiTerminosProcesales siiTerminosProcesales: lista) {
                if (siiTerminosProcesales!=null)
                    resultado.add(new TerminosProcesalesVO(siiTerminosProcesales));
            }
        }
        
        return (resultado);
    }
}
