package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaPoblacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EnteTerritorialDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PoblacionEnteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaPoblacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEnteTerritorial;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPoblacionEnte;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CargaPoblacionVO;
import co.gov.coljuegos.siicol.ejb.vo.EnteTerritorialVO;
import co.gov.coljuegos.siicol.ejb.vo.PoblacionEnteVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminCargaPoblacionBean implements AdminCargaPoblacion {
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private CargaPoblacionDAO cargaPoblacionDao;
    @EJB
    private PoblacionEnteDAO poblacionEnteDao;
    @EJB
    private EnteTerritorialDAO enteTerritorialDao;
       
    /**
     * Constructor.
     **/
    
    public AdminCargaPoblacionBean() { }

    @Override
    public CargaPoblacionVO buscarCargaPoblacionPorId(Long cpoCodigo) throws ExcepcionDAO {
        CargaPoblacionVO cargaPoblacionVo = null;
        SiiCargaPoblacion siiCargaPoblacion = cargaPoblacionDao.buscarPorCodigo(cpoCodigo);
        if(siiCargaPoblacion!=null)
        cargaPoblacionVo = new CargaPoblacionVO(siiCargaPoblacion);
       
         return (cargaPoblacionVo);
    }

    @Override
    public CargaPoblacionVO insertarCargaPoblacion(CargaPoblacionVO cargaPoblacionVo,
                                                       UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(cargaPoblacionVo.getCpoFechaRegistro());
        cal.set(Calendar.HOUR, -1);
        //Long Temp = cargaPoblacionDao.BuscarCargaPoblacionOrdenado();
        List<SiiPoblacionEnte> ListaSiiPoblacionEnteC = poblacionEnteDao.buscarPoblacionPorCargaPoblacion(cargaPoblacionVo.getListaPoblacionEnteVo().get(0).getPenFechaFin());
        for(SiiPoblacionEnte siiPoblacionEnteC : ListaSiiPoblacionEnteC){
            siiPoblacionEnteC.setPenFechaFin(cal.getTime());
            poblacionEnteDao.actualizar(siiPoblacionEnteC);
            
        }
        
        SiiUsuario siiUsuario = conversionVoEntidad.convertir(usuarioLogueado);
        SiiCargaPoblacion siiCargaPoblacion = conversionVoEntidad.convertir(cargaPoblacionVo);
        siiCargaPoblacion.setSiiUsuarioConec(siiUsuario);
        siiCargaPoblacion = cargaPoblacionDao.insertar(siiCargaPoblacion);
        
         for (PoblacionEnteVO unPoblacionEnteVo : cargaPoblacionVo.getListaPoblacionEnteVo() ){
             
             SiiEnteTerritorial enteTerritorial = enteTerritorialDao.buscarPorCodigo(unPoblacionEnteVo.getEnteTerritorialVo().getEtiCodigo());
             SiiPoblacionEnte siiPoblacionEnte = conversionVoEntidad.convertir(unPoblacionEnteVo);
             siiPoblacionEnte.setSiiEnteTerritorial(enteTerritorial);
             siiPoblacionEnte.setSiiCargaPoblacion(siiCargaPoblacion);
             siiPoblacionEnte = poblacionEnteDao.insertar(siiPoblacionEnte);
             
             enteTerritorial.setEtiPoblacion(unPoblacionEnteVo.getPenPoblacTotal().intValue());
             enteTerritorialDao.actualizar(enteTerritorial); 
             
             
         }
         
         
         
        CargaPoblacionVO unCargaPoblacionVo= new CargaPoblacionVO(siiCargaPoblacion);
        return unCargaPoblacionVo;
    }


    @Override
    public CargaPoblacionVO actualizarCargaPoblacion(CargaPoblacionVO cargaPoblacionVo ) throws ExcepcionDAO {
        CargaPoblacionVO resultado = null;
        SiiCargaPoblacion siiCargaPoblacion = cargaPoblacionDao.actualizar(conversionVoEntidad.convertir(cargaPoblacionVo));
        if(siiCargaPoblacion!=null)
            cargaPoblacionVo = new CargaPoblacionVO(siiCargaPoblacion);
        
        return (resultado);
    }

    @Override
    public void borrarCargaPoblacion(Long cpoCodigo) throws ExcepcionDAO {
        cargaPoblacionDao.eliminar(cpoCodigo);
    }

    @Override
    public List<CargaPoblacionVO> buscarTodoCargaPoblacion() throws ExcepcionDAO {
        
        List<CargaPoblacionVO> resultado = null;
        List<SiiCargaPoblacion> lista = cargaPoblacionDao.buscarTodo();
        if(lista!=null){
            resultado = new ArrayList<CargaPoblacionVO>();
            
            for(SiiCargaPoblacion siiCargaPoblacion: lista){
            if(siiCargaPoblacion!=null)
                resultado.add(new CargaPoblacionVO(siiCargaPoblacion));
            }
        }      
        return (resultado); 
    }
    
    public EnteTerritorialVO buscarEnteTerritorialXIdUbicacion(String idUbicacion) throws ExcepcionDAO {
        EnteTerritorialVO unEnteTerritorialVo;
        SiiEnteTerritorial siiEnteterritorial = enteTerritorialDao.buscarEnteTerritorialXIdUbicacion(idUbicacion);
        if (siiEnteterritorial != null){
            unEnteTerritorialVo = new EnteTerritorialVO(siiEnteterritorial);
        }else{
            unEnteTerritorialVo = null;
        }
        return unEnteTerritorialVo;
    }
    
    /**
     *Metodo encargado de consultar el consecutivo de carga poblacion   
     * @return consecutivo
     * @throws ExcepcionDAO
     */
    public Long consultarConsecutivoCargaPoblacion() throws ExcepcionDAO {
        return cargaPoblacionDao.consultarConsecutivoCargaPoblacion();
    }
    public Long BuscarCargaPoblacionOrdenado() throws ExcepcionDAO {
        return cargaPoblacionDao.BuscarCargaPoblacionOrdenado();
    }
    
}
