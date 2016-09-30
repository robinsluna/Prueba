package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteAutoPrueTrasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteAutoPrueTras;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TramiteAutoPrueTrasVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Tr&aacute;mites del Auto que Decreta Pruebas del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminTramiteAutoPrueTrasBean implements AdminTramiteAutoPrueTras 
{
    @EJB
    private TramiteAutoPrueTrasDAO tramiteAutoPrueTrasDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminTramiteAutoPrueTrasBean() {
        super();
    }
    
    
    @Override
    public TramiteAutoPrueTrasVO buscarTramiteAutoPrueTrasPorId (Long traCodigo) throws ExcepcionDAO 
    {
        TramiteAutoPrueTrasVO resultado = null;
        SiiTramiteAutoPrueTras siiTramiteAutoPrueTras = tramiteAutoPrueTrasDao.buscarPorCodigo(traCodigo);
        if (siiTramiteAutoPrueTras!=null)
            resultado = new TramiteAutoPrueTrasVO(siiTramiteAutoPrueTras);
        
        return (resultado);
    }
    

    @Override
    public TramiteAutoPrueTrasVO insertarTramiteAutoPrueTras(TramiteAutoPrueTrasVO tramiteAutoPrueTrasVo) throws ExcepcionDAO 
    {
        TramiteAutoPrueTrasVO resultado = null;
        SiiTramiteAutoPrueTras siiTramiteAutoPrueTras = tramiteAutoPrueTrasDao.insertar(conversionVoEntidad.convertir(tramiteAutoPrueTrasVo));
        if (siiTramiteAutoPrueTras!=null)
            resultado = new TramiteAutoPrueTrasVO(siiTramiteAutoPrueTras);
        
        return (resultado);
    }
    
    
    @Override
    public TramiteAutoPrueTrasVO actualizarTramiteAutoPrueTras(TramiteAutoPrueTrasVO tramiteAutoPrueTrasVo) throws ExcepcionDAO {
        TramiteAutoPrueTrasVO resultado = null;
        SiiTramiteAutoPrueTras siiTramiteAutoPrueTras = tramiteAutoPrueTrasDao.actualizar(conversionVoEntidad.convertir(tramiteAutoPrueTrasVo));
        if (siiTramiteAutoPrueTras!=null)
            resultado = new TramiteAutoPrueTrasVO(siiTramiteAutoPrueTras);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarTramiteAutoPrueTras(Long traCodigo) throws ExcepcionDAO {
        tramiteAutoPrueTrasDao.eliminar(traCodigo);
    }

    @Override
    public List<TramiteAutoPrueTrasVO> buscarTodoDetalleAutoPruPerInv() throws ExcepcionDAO 
    {
        List<TramiteAutoPrueTrasVO> resultado = null;
        List<SiiTramiteAutoPrueTras> lista = tramiteAutoPrueTrasDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TramiteAutoPrueTrasVO>();
            
            for (SiiTramiteAutoPrueTras siiTramiteAutoPrueTras: lista) {
                if (siiTramiteAutoPrueTras!=null)
                    resultado.add(new TramiteAutoPrueTrasVO(siiTramiteAutoPrueTras));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<TramiteAutoPrueTrasVO> buscarDetalleAutoPruPerInvPorIdAutoDecretaPrueProIle(Long atpCodigo) throws ExcepcionDAO 
    {
        List<TramiteAutoPrueTrasVO> resultado = null;
        List<SiiTramiteAutoPrueTras> lista = tramiteAutoPrueTrasDao.buscarDetalleAutoPruPerInvPorIdAutoDecretaPrueProIle(atpCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TramiteAutoPrueTrasVO>();
            
            for (SiiTramiteAutoPrueTras siiTramiteAutoPrueTras: lista) {
                if (siiTramiteAutoPrueTras!=null)
                    resultado.add(new TramiteAutoPrueTrasVO(siiTramiteAutoPrueTras));
            }
        }
        
        return (resultado);
    }
}
