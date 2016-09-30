package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionProcesalIncDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionProcesalInc;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DireccionProcesalIncVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Direcciones Procesales de Procesos de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Stateless
public class AdminDireccionProcesalIncBean implements AdminDireccionProcesalInc 
{
    @EJB
    private DireccionProcesalIncDAO direccionProcesalIncDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminDireccionProcesalIncBean() {
        super();
    }
    
    
    
    @Override
    public DireccionProcesalIncVO buscarDireccionProcesalIncPorCodigo(Long dpiCodigo) throws ExcepcionDAO 
    {
        DireccionProcesalIncVO resultado = null;
        SiiDireccionProcesalInc siiDireccionProcesalInc = direccionProcesalIncDao.buscarPorCodigo(dpiCodigo);
        if (siiDireccionProcesalInc!=null)
            resultado = new DireccionProcesalIncVO(siiDireccionProcesalInc);
        
        return (resultado);
    }
    
    
    @Override
    public DireccionProcesalIncVO insertarDireccionProcesalInc(DireccionProcesalIncVO direccionProcesalIncVo) throws ExcepcionDAO {
        DireccionProcesalIncVO resultado = null;
        SiiDireccionProcesalInc siiDireccionProcesalInc = direccionProcesalIncDao.insertar(conversionVoEntidad.convertir(direccionProcesalIncVo));
        if (siiDireccionProcesalInc!=null)
            resultado = new DireccionProcesalIncVO(siiDireccionProcesalInc);
        
        return (resultado);
    }
    
    
    @Override
    public DireccionProcesalIncVO actualizarDireccionProcesalInc(DireccionProcesalIncVO direccionProcesalIncVo) throws ExcepcionDAO {
        DireccionProcesalIncVO resultado = null;
        SiiDireccionProcesalInc siiDireccionProcesalInc = direccionProcesalIncDao.actualizar(conversionVoEntidad.convertir(direccionProcesalIncVo));
        if (siiDireccionProcesalInc!=null)
            resultado = new DireccionProcesalIncVO(siiDireccionProcesalInc);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarDireccionProcesalInc(Long dpiCodigo) throws ExcepcionDAO {
        direccionProcesalIncDao.eliminar(dpiCodigo);
    }
    
    
    @Override
    public List<DireccionProcesalIncVO> buscarTodaDireccionProcesalInc() throws ExcepcionDAO {
        List<DireccionProcesalIncVO> resultado = null;
        List<SiiDireccionProcesalInc> lista = direccionProcesalIncDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<DireccionProcesalIncVO>();
            for (SiiDireccionProcesalInc siiDireccionProcesalInc: lista) {
                if (siiDireccionProcesalInc!=null)
                    resultado.add(new DireccionProcesalIncVO(siiDireccionProcesalInc));
            }
        }
        
        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionProcesalIncDAO#buscarDireccionProcesalIncPorCodigo(java.lang.Long)
     */
    @Override
    public List<DireccionProcesalIncVO> buscarDireccionProcesalIncPorIdIncumplimiento(Long icnCodigo) throws ExcepcionDAO {
        List<DireccionProcesalIncVO> resultado = null;
        
        if (icnCodigo!=null) {
            List<SiiDireccionProcesalInc> lista = direccionProcesalIncDao.buscarDireccionProcesalIncPorIdIncumplimiento(icnCodigo);
            if (lista!=null) {
                resultado = new ArrayList<DireccionProcesalIncVO>();
                for (SiiDireccionProcesalInc siiDireccionProcesalInc: lista) {
                    if (siiDireccionProcesalInc!=null)
                        resultado.add(new DireccionProcesalIncVO(siiDireccionProcesalInc));
                }
            }
        }
        
        return (resultado);
    }
}
