package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InhabilidadPersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInhabilidadPersona;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.InhabilidadPersonaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminInhabilidadPersonaBean implements AdminInhabilidadPersona 
{
    @EJB
    private InhabilidadPersonaDAO inhabilidadPersonaDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    
    /**
     * Constructor.
     */
    public AdminInhabilidadPersonaBean() { }
    
    
    
    @Override
    public InhabilidadPersonaVO buscarInhabilidadPersonaPorId(Long ipeCodigo) throws ExcepcionDAO 
    {
        InhabilidadPersonaVO resultado = null;
        SiiInhabilidadPersona siiInhabilidadPersona = inhabilidadPersonaDao.buscarPorCodigo(ipeCodigo);
        if (siiInhabilidadPersona!=null)
            resultado = new InhabilidadPersonaVO(siiInhabilidadPersona);
        
        return (resultado);
    }
    
    
    @Override
    public List<InhabilidadPersonaVO> buscarInhabilidadPersonaPorIdPersona(Long perCodigo) throws ExcepcionDAO 
    {
        List<InhabilidadPersonaVO> resultado = null;
        List<SiiInhabilidadPersona> lista = inhabilidadPersonaDao.buscarInhabilidadPersonaPorIdPersona(perCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<InhabilidadPersonaVO>();
            
            for (SiiInhabilidadPersona siiInhabilidadPersona: lista) {
                if (siiInhabilidadPersona!=null)
                    resultado.add(new InhabilidadPersonaVO(siiInhabilidadPersona));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public InhabilidadPersonaVO buscarInhabilidadPersonaPorIdPersonaYTipoProceso(Long perCodigo, Long idProceso, Long tipoProceso) throws ExcepcionDAO 
    {
        InhabilidadPersonaVO resultado = null;
        SiiInhabilidadPersona siiInhabilidadPersona = inhabilidadPersonaDao.buscarInhabilidadPersonaPorIdPersonaYTipoProceso(perCodigo, idProceso, tipoProceso);
        if (siiInhabilidadPersona!=null)
            resultado = new InhabilidadPersonaVO(siiInhabilidadPersona);
        
        return (resultado);
    }
    
    
    @Override
    public InhabilidadPersonaVO insertarInhabilidadPersona(InhabilidadPersonaVO inhabilidadPersonaVo) throws ExcepcionDAO 
    {
        InhabilidadPersonaVO resultado = null;
        SiiInhabilidadPersona siiInhabilidadPersona = inhabilidadPersonaDao.insertar(conversionVoEntidad.convertir(inhabilidadPersonaVo));
        if (siiInhabilidadPersona!=null)
            resultado = new InhabilidadPersonaVO(siiInhabilidadPersona);
        
        return (resultado);
    }
    
    
    @Override
    public InhabilidadPersonaVO actualizarInhabilidadPersona(InhabilidadPersonaVO inhabilidadPersonaVo) throws ExcepcionDAO 
    {
        InhabilidadPersonaVO resultado = null;
        SiiInhabilidadPersona siiInhabilidadPersona = inhabilidadPersonaDao.actualizar(conversionVoEntidad.convertir(inhabilidadPersonaVo));
        if (siiInhabilidadPersona!=null)
            resultado = new InhabilidadPersonaVO(siiInhabilidadPersona);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarInhabilidadPersona(Long ipeCodigo) throws ExcepcionDAO 
    {
        inhabilidadPersonaDao.eliminar(ipeCodigo);
    }
    
    
    @Override
    public List<InhabilidadPersonaVO> buscarTodaInhabilidadPersona() throws ExcepcionDAO {
        List<InhabilidadPersonaVO> resultado = null;
        List<SiiInhabilidadPersona> lista = inhabilidadPersonaDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<InhabilidadPersonaVO>();
            
            for (SiiInhabilidadPersona siiInhabilidadPersona: lista) {
                if (siiInhabilidadPersona!=null)
                    resultado.add(new InhabilidadPersonaVO(siiInhabilidadPersona));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<InhabilidadPersonaVO> buscarInhabilidadPersonaPorIdIncumplimientoContr(Long icnCodigo) throws ExcepcionDAO {
        List<InhabilidadPersonaVO> resultado = null;
        List<SiiInhabilidadPersona> lista = inhabilidadPersonaDao.buscarInhabilidadPersonaPorIdIncumplimientoContr(icnCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<InhabilidadPersonaVO>();
            
            for (SiiInhabilidadPersona siiInhabilidadPersona: lista) {
                if (siiInhabilidadPersona!=null)
                    resultado.add(new InhabilidadPersonaVO(siiInhabilidadPersona));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<InhabilidadPersonaVO> buscarInhabilidadPersonaPorIdProcesoSancionatorio(Long psaCodigo) throws ExcepcionDAO {
        List<InhabilidadPersonaVO> resultado = null;
        List<SiiInhabilidadPersona> lista = inhabilidadPersonaDao.buscarInhabilidadPersonaPorIdProcesoSancionatorio(psaCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<InhabilidadPersonaVO>();
            
            for (SiiInhabilidadPersona siiInhabilidadPersona: lista) {
                if (siiInhabilidadPersona!=null)
                    resultado.add(new InhabilidadPersonaVO(siiInhabilidadPersona));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<InhabilidadPersonaVO> buscarInhabilidadPersonaPorIdProcesoSancIlegalidad(Long prsCodigo) throws ExcepcionDAO 
    {
        List<InhabilidadPersonaVO> resultado = null;
        List<SiiInhabilidadPersona> lista = inhabilidadPersonaDao.buscarInhabilidadPersonaPorIdProcesoSancIlegalidad(prsCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<InhabilidadPersonaVO>();
            
            for (SiiInhabilidadPersona siiInhabilidadPersona: lista) {
                if (siiInhabilidadPersona!=null)
                    resultado.add(new InhabilidadPersonaVO(siiInhabilidadPersona));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public InhabilidadPersonaVO buscarInhabilidadPersonaPorIdPersonaYTipoProceso(Long perCodigo, Long idProceso, Long tipoProceso, boolean soloActivos) throws ExcepcionDAO 
    {
        InhabilidadPersonaVO resultado = null;
        SiiInhabilidadPersona siiInhabilidadPersona = inhabilidadPersonaDao.buscarInhabilidadPersonaPorIdPersonaYTipoProceso(perCodigo, idProceso, tipoProceso, soloActivos);
        if (siiInhabilidadPersona!=null)
            resultado = new InhabilidadPersonaVO(siiInhabilidadPersona);
        
        return (resultado);
    }
}
