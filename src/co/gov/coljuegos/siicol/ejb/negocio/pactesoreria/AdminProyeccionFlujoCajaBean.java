/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Diana Caro
 * FECHA	: 23-09-2013
 */
package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.RubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DistribucionPfcDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoPfcDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProyeccionFlujoCajaDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionFlujoCaja;

import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CdpVO;
import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionPfcVO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoPfcVO;

import co.gov.coljuegos.siicol.ejb.vo.ProyeccionFlujoCajaVO;

import co.gov.coljuegos.siicol.ejb.vo.RubroDetalleFuenteVO;

import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminProyeccionFlujoCajaBean implements AdminProyeccionFlujoCaja {
    @Resource
    SessionContext sessionContext;
    
    @EJB
    ProyeccionFlujoCajaDAO proyeccionFlujoCajaDao;
    @EJB
    DistribucionPfcDAO distribucionPfcDao;
    @EJB
    EstadoPfcDAO estadoPfcDao;
    @EJB
    RubroDAO rubroDao;
    @EJB
    DetalleRubroDAO detalleRubroDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminProyeccionFlujoCajaBean() {
        
    }
    
    public List<RubroDetalleFuenteVO> buscarTodoRubroDetallePorFteNacion(Integer vigencia) throws ExcepcionDAO{
        return rubroDao.buscarTodoRubroDetallePorFteNacion(vigencia);
    }
    
    public List<RubroDetalleFuenteVO> buscarTodoRubroFuenteDetalle(Integer vigencia) throws ExcepcionDAO {
       return rubroDao.buscarTodoRubroFuenteDetalle(vigencia); 
    }

    public DistribucionPfcVO buscarPorCodigoPDF(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO {
        SiiDistribucionPfc resultadosiiDistribucionPfc = distribucionPfcDao.buscarDistribucionPfcPorId(distribucionPfcVo.getDpfCodigo());
        return new DistribucionPfcVO(resultadosiiDistribucionPfc);
    }

    public DistribucionPfcVO insertarSiiDistribucionPfc(DistribucionPfcVO distribucionPfcVo ) throws ExcepcionDAO {
        SiiDistribucionPfc siiDistribucionPfc = conversionVoEntidad.convertir(distribucionPfcVo);
        SiiDistribucionPfc resultadosiiDistribucionPfc = distribucionPfcDao.insertarSiiDistribucionPfc(siiDistribucionPfc);         
        return new DistribucionPfcVO(resultadosiiDistribucionPfc);
     }

    public DistribucionPfcVO actualizarSiiDistribucionPfc(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO {
        SiiDistribucionPfc siiDistribucionPfc = conversionVoEntidad.convertir(distribucionPfcVo);
        return new DistribucionPfcVO(distribucionPfcDao.actualizarSiiDistribucionPfc(siiDistribucionPfc));
    }

    public void borrarPorCodigoSiiDistribucionPfc(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO {
        SiiDistribucionPfc siiDistribucionPfc = conversionVoEntidad.convertir(distribucionPfcVo);
        distribucionPfcDao.borrarPorCodigoSiiDistribucionPfc(siiDistribucionPfc);
    }

    public List<DistribucionPfcVO> buscarTodoSiiDistribucionPfc() throws ExcepcionDAO {
        List<SiiDistribucionPfc> listaSiiDistribucionPfc = distribucionPfcDao.buscarTodoSiiDistribucionPfc();
        List<DistribucionPfcVO> listaDistribucionPfcVo = new ArrayList(); 
        
        for(SiiDistribucionPfc unaEntidadDistribucion : listaSiiDistribucionPfc){
            listaDistribucionPfcVo.add(new DistribucionPfcVO(unaEntidadDistribucion));
        }
        return listaDistribucionPfcVo;    
         
     }    
    
    public EstadoPfcVO buscarPorEpfCodigo(EstadoPfcVO estadoPfcVo) throws ExcepcionDAO {
        SiiEstadoPfc resultadosiiEstadoPfc = estadoPfcDao.buscarPorEpfCodigo(estadoPfcVo.getEpfCodigo());
        return new EstadoPfcVO(resultadosiiEstadoPfc);
    }

    public EstadoPfcVO insertarSiiEstadoPfc(EstadoPfcVO estadoPfcVo) throws ExcepcionDAO {
        SiiEstadoPfc siiEstadoPfc = conversionVoEntidad.convertir(estadoPfcVo);
        SiiEstadoPfc resultadosiiEstadoPfc = estadoPfcDao.insertarSiiEstadoPfc(siiEstadoPfc);  
        return new EstadoPfcVO(resultadosiiEstadoPfc) ;        
    }

    public EstadoPfcVO actualizarSiiEstadoPfc(EstadoPfcVO estadoPfcVo) throws ExcepcionDAO {
        SiiEstadoPfc siiEstadoPfc = conversionVoEntidad.convertir(estadoPfcVo);
        return new EstadoPfcVO(estadoPfcDao.actualizarSiiEstadoPfc(siiEstadoPfc));
    }
    

    public List<EstadoPfcVO> buscarTodoSiiEstadoPfcVO() throws ExcepcionDAO {
        List<SiiEstadoPfc> listaSiiEstadoPfc = estadoPfcDao. buscarTodoSiiEstadoPfcVO();
        List<EstadoPfcVO> listaEstadoPfcVo = new ArrayList(); 
        
        for(SiiEstadoPfc unaEntidadEstadoPfc : listaSiiEstadoPfc){
             listaEstadoPfcVo.add(new EstadoPfcVO(unaEntidadEstadoPfc));
        }
        return listaEstadoPfcVo;    
        
    }

    public ProyeccionFlujoCajaVO buscarPorCodigoPFC(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO {
        SiiProyeccionFlujoCaja resultadosiiProyeccionFC = proyeccionFlujoCajaDao.buscarPorCodigoPFC(proyeccionFlujoCajaVo.getPfcCodigo());
        return new ProyeccionFlujoCajaVO(resultadosiiProyeccionFC);
    }

    public ProyeccionFlujoCajaVO insertarProyeccionFC(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo,List<DistribucionPfcVO> listaDistribucion) throws ExcepcionDAO {
        SiiProyeccionFlujoCaja siiProyeccionFlujoCaja = conversionVoEntidad.convertir(proyeccionFlujoCajaVo);
        SiiProyeccionFlujoCaja resultadosiiProyeccionFC = proyeccionFlujoCajaDao.insertarSiiProyeccionFC(siiProyeccionFlujoCaja);
       
        for(DistribucionPfcVO unaDistibucionPFCVo:listaDistribucion){
         ProyeccionFlujoCajaVO unProyeccionFC = new ProyeccionFlujoCajaVO();
         unProyeccionFC.setPfcCodigo(resultadosiiProyeccionFC.getPfcCodigo());   
         unaDistibucionPFCVo.setProyeccionFlujoCajaVo(unProyeccionFC);
         SiiDistribucionPfc siiDistribucionPFC= conversionVoEntidad.convertir(unaDistibucionPFCVo);
         distribucionPfcDao.insertarSiiDistribucionPfc(siiDistribucionPFC);
        }
        return new ProyeccionFlujoCajaVO(resultadosiiProyeccionFC);
    }

    public ProyeccionFlujoCajaVO actualizarSiiProyeccionFlujoCaja(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO {
        SiiProyeccionFlujoCaja siiProyeccionFlujoCaja = conversionVoEntidad.convertir(proyeccionFlujoCajaVo);
        SiiProyeccionFlujoCaja   ProyeccionFlujoCajaVO=proyeccionFlujoCajaDao.actualizarSiiProyeccionFlujoCaja(siiProyeccionFlujoCaja);  
        
        if(proyeccionFlujoCajaVo.getSiiDistribucionPfcVOList()!=null){
            for(DistribucionPfcVO unaDistribucionVo:proyeccionFlujoCajaVo.getSiiDistribucionPfcVOList()) {
              SiiDistribucionPfc siiDistribucionPfc= conversionVoEntidad.convertir(unaDistribucionVo);
               siiDistribucionPfc.setSiiProyeccionFlujoCaja(siiProyeccionFlujoCaja);
              SiiDistribucionPfc unDistribucionPfc= distribucionPfcDao.actualizarSiiDistribucionPfc(siiDistribucionPfc);
            }
        }
        return new ProyeccionFlujoCajaVO(ProyeccionFlujoCajaVO);      
    }  
    
    public void borrarPorCodigoSiiProyeccionFlujoCaja(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO {
        proyeccionFlujoCajaDao.borrarPorCodigoSiiProyeccionFlujoCaja(proyeccionFlujoCajaVo.getPfcCodigo());
    }

  
    public List<ProyeccionFlujoCajaVO> buscarTodoSiiProyeccionFlujoCaja() throws ExcepcionDAO {
       
        List<SiiProyeccionFlujoCaja> listaSiiProyeccionFlujoCaja = proyeccionFlujoCajaDao.buscarTodoSiiProyeccionFlujoCaja();
        List<ProyeccionFlujoCajaVO> listaProyeccionFlujoCajaVo = new ArrayList(); 
        
         for(SiiProyeccionFlujoCaja unaEntidadProyeccion : listaSiiProyeccionFlujoCaja){
                 listaProyeccionFlujoCajaVo.add(new ProyeccionFlujoCajaVO(unaEntidadProyeccion));
         }
         return listaProyeccionFlujoCajaVo;     
     }
    public List<ProyeccionFlujoCajaVO> buscarTodoPFCNacion() throws ExcepcionDAO {
       
        List<SiiProyeccionFlujoCaja> listaSiiProyeccionFlujoCaja = proyeccionFlujoCajaDao.buscarTodoPFCNacion();
        List<ProyeccionFlujoCajaVO> listaProyeccionFlujoCajaVo = new ArrayList(); 
        
         for(SiiProyeccionFlujoCaja unaEntidadProyeccion : listaSiiProyeccionFlujoCaja){
                 listaProyeccionFlujoCajaVo.add(new ProyeccionFlujoCajaVO(unaEntidadProyeccion));
         }
         return listaProyeccionFlujoCajaVo;     
     }
    
    
    
    public List<ProyeccionFlujoCajaVO> buscarPFCPorVigencia(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO{
        SiiProyeccionFlujoCaja proyeccionFlujoCaja = conversionVoEntidad.convertir(proyeccionFlujoCajaVo);
        List<SiiProyeccionFlujoCaja> listaSiiProyeccionFlujoCaja = proyeccionFlujoCajaDao.buscarPFCPorVigencia(proyeccionFlujoCaja);
        List<ProyeccionFlujoCajaVO> listaProyeccionFlujoCajaVo = new ArrayList();
        
        for(SiiProyeccionFlujoCaja unaEntidadSiiProyeccionFlujoCaja : listaSiiProyeccionFlujoCaja){
                listaProyeccionFlujoCajaVo.add(new ProyeccionFlujoCajaVO(unaEntidadSiiProyeccionFlujoCaja));
        }
        return listaProyeccionFlujoCajaVo;
       
    }
    
    public List<ProyeccionFlujoCajaVO> buscarPFCPorVigenciayEstado(ProyeccionFlujoCajaVO proyeccionFlujoCajaVo) throws ExcepcionDAO{
        SiiProyeccionFlujoCaja proyeccionFlujoCaja = conversionVoEntidad.convertir(proyeccionFlujoCajaVo);
        List<SiiProyeccionFlujoCaja> listaSiiProyeccionFlujoCaja = proyeccionFlujoCajaDao.buscarPFCPorVigenciayEstado(proyeccionFlujoCaja);
        List<ProyeccionFlujoCajaVO> listaProyeccionFlujoCajaVo = new ArrayList();
        
        for(SiiProyeccionFlujoCaja unaEntidadSiiProyeccionFlujoCaja : listaSiiProyeccionFlujoCaja){
                listaProyeccionFlujoCajaVo.add(new ProyeccionFlujoCajaVO(unaEntidadSiiProyeccionFlujoCaja));
        }
        return listaProyeccionFlujoCajaVo;
       
    }
    
    
    public List<ProyeccionFlujoCajaVO> buscarPFCPorEstado(String estado) throws ExcepcionDAO {
        List<SiiProyeccionFlujoCaja> listaPfc = proyeccionFlujoCajaDao.buscarPFCPorEstado(estado);
        List<ProyeccionFlujoCajaVO> listaPfcVo = new ArrayList();
        for (SiiProyeccionFlujoCaja unaPfc : listaPfc) {
            listaPfcVo.add(new ProyeccionFlujoCajaVO(unaPfc));
        }
        return listaPfcVo;
    }
    
    public List<DistribucionPfcVO> buscarTodoSiiDistribucionPfcXIdDetalleRubro(DetalleRubroVO siiDetalleRubroVo) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubro = conversionVoEntidad.convertir(siiDetalleRubroVo);           
        List<SiiDistribucionPfc> listaDistribucion = distribucionPfcDao.buscarTodoSiiDistribucionPfcXIdDetalleRubro(siiDetalleRubro);
        List<DistribucionPfcVO> listaDistribucionVo = new ArrayList();   
        //SiiDetalleRubro listaDetalleRubro = detalleRubroDao.buscarPorCodigoDetalleRubro(siiDetalleRubro);
                 
        for(SiiDistribucionPfc unaEntidadDetalleRubro : listaDistribucion){
            listaDistribucionVo.add(new DistribucionPfcVO(unaEntidadDetalleRubro));
        }
        return listaDistribucionVo;          
    }
    public List<DistribucionPfcVO> buscarTodoSiiDistribucionPfcXVigencia(DetalleRubroVO siiDetalleRubroVo) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubro = conversionVoEntidad.convertir(siiDetalleRubroVo);           
        List<SiiDistribucionPfc> listaDistribucion = distribucionPfcDao.buscarTodoSiiDistribucionPfcXVigencia(siiDetalleRubro);
        List<DistribucionPfcVO> listaDistribucionVo = new ArrayList();   
       
        for(SiiDistribucionPfc unaDistribucionPfc : listaDistribucion){
            listaDistribucionVo.add(new DistribucionPfcVO(unaDistribucionPfc));
        }
        return listaDistribucionVo;          
    }
    
    public DistribucionPfcVO buscarDistribucionPfcXVigenciaDetalleR(DistribucionPfcVO distribucionPfcVo) throws ExcepcionDAO {
        SiiDistribucionPfc siiDistribucionPfc = conversionVoEntidad.convertir(distribucionPfcVo);           
        SiiDistribucionPfc distribPfcVo = distribucionPfcDao.buscarDistribucionPfcXVigenciaDetalleR(distribucionPfcVo.getMesVo().getMesCodigo(),
                                         distribucionPfcVo.getDetalleRubroVo().getDruCodigo(),distribucionPfcVo.getVigencia());
        return new DistribucionPfcVO(distribPfcVo);          
    }
    
    
    public EstadoPfcVO buscarEstadoPfcPorNombre(EstadoPfcVO estadoPfcVo) throws ExcepcionDAO{
        SiiEstadoPfc siiEstadoPfc = conversionVoEntidad.convertir(estadoPfcVo);
        SiiEstadoPfc resultadoEstdo = estadoPfcDao.buscarEstadoPfcPorNombre(siiEstadoPfc);
        return new EstadoPfcVO(resultadoEstdo);
    }
    
}
