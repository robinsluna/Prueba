package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActaSuspenAudIncumConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaSuspenAudIncumCon;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ActaSuspenAudIncumConVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Actas de Suspensi&oacute;n de la Audiencia en procesos de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Stateless
public class AdminActaSuspenAudIncumConBean implements AdminActaSuspenAudIncumCon 
{
    @EJB
    private ActaSuspenAudIncumConDAO actaSuspenAudIncumConDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    /**
     * Constructor.
     */
    public AdminActaSuspenAudIncumConBean() {
        super();
    }
    
    
    @Override
    public ActaSuspenAudIncumConVO buscarActaSuspenAudPorCodigo(Long asaCodigo) throws ExcepcionDAO 
    {
        ActaSuspenAudIncumConVO resultado = null;
        SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon = actaSuspenAudIncumConDao.buscarPorCodigo(asaCodigo);
        if (siiActaSuspenAudIncumCon!=null)
            resultado = new ActaSuspenAudIncumConVO(siiActaSuspenAudIncumCon);
        
        return (resultado);
    }
    
    
    @Override
    public ActaSuspenAudIncumConVO insertarActaSuspenAud(ActaSuspenAudIncumConVO actaSuspenAudIncumConVo) throws ExcepcionDAO {
        ActaSuspenAudIncumConVO resultado = null;
        SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon = actaSuspenAudIncumConDao.insertar(conversionVoEntidad.convertir(actaSuspenAudIncumConVo));
        if (siiActaSuspenAudIncumCon!=null)
            resultado = new ActaSuspenAudIncumConVO(siiActaSuspenAudIncumCon);
        
        return (resultado);
    }
    
    
    @Override
    public ActaSuspenAudIncumConVO actualizarActaSuspenAud(ActaSuspenAudIncumConVO actaSuspenAudIncumConVo) throws ExcepcionDAO {
        ActaSuspenAudIncumConVO resultado = null;
        SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon = actaSuspenAudIncumConDao.actualizar(conversionVoEntidad.convertir(actaSuspenAudIncumConVo));
        if (siiActaSuspenAudIncumCon!=null)
            resultado = new ActaSuspenAudIncumConVO(siiActaSuspenAudIncumCon);
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarActaSuspenAudIncumCon(Long asaCodigo) throws ExcepcionDAO {
        actaSuspenAudIncumConDao.eliminar(asaCodigo);
    }
    
    
    @Override
    public List<ActaSuspenAudIncumConVO> buscarTodaActaSuspenAud() throws ExcepcionDAO {
        List<ActaSuspenAudIncumConVO> resultado = null;
        List<SiiActaSuspenAudIncumCon> lista = actaSuspenAudIncumConDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ActaSuspenAudIncumConVO>();
            
            for (SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon: lista) {
                if (siiActaSuspenAudIncumCon!=null)
                    resultado.add(new ActaSuspenAudIncumConVO(siiActaSuspenAudIncumCon));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<ActaSuspenAudIncumConVO> buscarActaSuspenAudPorIdIncumplimientoContr(Long icnCodigo) throws ExcepcionDAO {
        List<ActaSuspenAudIncumConVO> resultado = null;
        List<SiiActaSuspenAudIncumCon> lista = actaSuspenAudIncumConDao.buscarActaSuspenAudPorIdIncumplimientoContr(icnCodigo);
        if (lista!=null) {
            resultado = new ArrayList<ActaSuspenAudIncumConVO>();
            
            for (SiiActaSuspenAudIncumCon siiActaSuspenAudIncumCon: lista) {
                if (siiActaSuspenAudIncumCon!=null)
                    resultado.add(new ActaSuspenAudIncumConVO(siiActaSuspenAudIncumCon));
            }
        }
        return (resultado);
    }
}
