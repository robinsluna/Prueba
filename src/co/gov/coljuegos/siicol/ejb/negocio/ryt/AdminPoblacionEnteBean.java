package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PoblacionEnteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPoblacionEnte;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PoblacionEnteVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminPoblacionEnteBean implements AdminPoblacionEnte {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private PoblacionEnteDAO poblacionEnteDao;
    
    
    /**
     * Constructor.
     **/
    public AdminPoblacionEnteBean () { }

    @Override
    public PoblacionEnteVO buscarPoblacionEntePorId(Long penCodigo) throws ExcepcionDAO {
        PoblacionEnteVO poblacionEnteVo = null;
        SiiPoblacionEnte siiPoblacionEnte = poblacionEnteDao.buscarPorCodigo(penCodigo);
        if(siiPoblacionEnte!=null)
        poblacionEnteVo = new PoblacionEnteVO(siiPoblacionEnte);
       
         return (poblacionEnteVo);
    }

    @Override
    public PoblacionEnteVO insertarPoblacionEnte(PoblacionEnteVO poblacionEnteVo,
                                                       UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        PoblacionEnteVO resultado = null;
        
        poblacionEnteVo.setUsuarioConec(usuarioLogueado);
        SiiPoblacionEnte siiPoblacionEnte = poblacionEnteDao.insertar(conversionVoEntidad.convertir(poblacionEnteVo));
        if(siiPoblacionEnte!=null)
            resultado = new PoblacionEnteVO(siiPoblacionEnte);
     
        return (resultado);
    }

    @Override
    public PoblacionEnteVO actualizarPoblacionEnte(PoblacionEnteVO poblacionEnteVo) throws ExcepcionDAO {
        PoblacionEnteVO resultado = null;
        SiiPoblacionEnte siiPoblacionEnte = poblacionEnteDao.actualizar(conversionVoEntidad.convertir(poblacionEnteVo));
        if(siiPoblacionEnte!=null)
            poblacionEnteVo = new PoblacionEnteVO(siiPoblacionEnte);
        
        return (resultado);
    }

    @Override
    public void borrarPoblacionEnte(Long penCodigo) throws ExcepcionDAO {
        poblacionEnteDao.eliminar(penCodigo);
    }

    @Override
    public List<PoblacionEnteVO> buscarTodoPoblacionEnte() throws ExcepcionDAO {
        
        List<PoblacionEnteVO> resultado = null;
        List<SiiPoblacionEnte> lista = poblacionEnteDao.buscarTodo();
        if(lista!=null){
            resultado = new ArrayList<PoblacionEnteVO>();
            
            for(SiiPoblacionEnte siiPoblacionEnte: lista){
            if(siiPoblacionEnte!=null)
                resultado.add(new PoblacionEnteVO(siiPoblacionEnte));
            }
        }      
        return (resultado); 
    }
    
    
    @Override
    public List<PoblacionEnteVO> buscarPoblacionEntePorIdEnteTerritorial (Long etiCodigo) throws ExcepcionDAO {
        List<PoblacionEnteVO> resultado = null;
        List<SiiPoblacionEnte> lista = poblacionEnteDao.buscarPoblacionEntePorIdEnteTerritorial(etiCodigo);
        if(lista!=null){
            resultado = new ArrayList<PoblacionEnteVO>();
            
            for (SiiPoblacionEnte siiPoblacionEnte: lista) {
                if(siiPoblacionEnte!=null)
                    resultado.add(new PoblacionEnteVO(siiPoblacionEnte));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<PoblacionEnteVO> buscarPoblacionEntePorIdEnteTerritorial (Long etiCodigo, boolean soloVigentes) throws ExcepcionDAO {
        List<PoblacionEnteVO> resultado = null;
        List<SiiPoblacionEnte> lista = poblacionEnteDao.buscarPoblacionEntePorIdEnteTerritorial(etiCodigo, soloVigentes);
        if(lista!=null){
            resultado = new ArrayList<PoblacionEnteVO>();
            
            for (SiiPoblacionEnte siiPoblacionEnte: lista) {
                if(siiPoblacionEnte!=null)
                    resultado.add(new PoblacionEnteVO(siiPoblacionEnte));
            }
        }
        
        return (resultado);
    }
}
