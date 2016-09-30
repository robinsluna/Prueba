package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolEstMercadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;

import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;


@Stateless
public class AdminEstadoSolEstMercadoBean implements AdminEstadoSolEstMercado {
    
    @Resource
    SessionContext sessionContext;
    
    @EJB
    EstadoSolEstMercadoDAO estSolEstMercadoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminEstadoSolEstMercadoBean() {
        //super();
    }
    
    public EstadoSolEstMercadoVO buscarEstadoSolEstMercadoPorId(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO{
        SiiEstadoSolEstMercado  unEstadoSolEstMercado = estSolEstMercadoDao.buscarEstadoSolEstMercadoPorId(estadoSolEstMercadoVo.getEseCodigo());
        return new EstadoSolEstMercadoVO(unEstadoSolEstMercado);
    }
    

    public List<EstadoSolEstMercadoVO> buscarEstadoSolEstMercadoPorEstado(EstadoSolEstMercadoVO estSolEstMercadoVo) throws ExcepcionDAO{
        SiiEstadoSolEstMercado estadoSolEstMercado;
        estadoSolEstMercado = conversionVoEntidad.convertir(estSolEstMercadoVo);
        List<SiiEstadoSolEstMercado> listaEstadoSolEstMercado;
        listaEstadoSolEstMercado = estSolEstMercadoDao.buscarEstadoSolEstMercadoPorEstado(estadoSolEstMercado);
        List<EstadoSolEstMercadoVO> listaEstadoSolEstMercadoVo;
        listaEstadoSolEstMercadoVo = new ArrayList();
        for(SiiEstadoSolEstMercado unEstadoSolEstMercado : listaEstadoSolEstMercado){
            listaEstadoSolEstMercadoVo.add(new EstadoSolEstMercadoVO(unEstadoSolEstMercado));
        }
        return listaEstadoSolEstMercadoVo;
    }
    
    public EstadoSolEstMercadoVO actualizarEstadoSolEstMercado(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO{
        SiiEstadoSolEstMercado estadoSolEstMercado = conversionVoEntidad.convertir(estadoSolEstMercadoVo);
        SiiEstadoSolEstMercado unEstadoSolEstMercado = estSolEstMercadoDao.actualizarEstadoSolEstMercado(estadoSolEstMercado);
        return new EstadoSolEstMercadoVO(unEstadoSolEstMercado);
    }
    
    public EstadoSolEstMercadoVO insertarEstadoSolEstMercado(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO{
        SiiEstadoSolEstMercado estadoSolEstMercado = conversionVoEntidad.convertir(estadoSolEstMercadoVo);
        SiiEstadoSolEstMercado unEstadoSolEstMercado = estSolEstMercadoDao.insertarEstadoSolEstMercado(estadoSolEstMercado);
        return new EstadoSolEstMercadoVO(unEstadoSolEstMercado);
    }

   /* public EstadoSolEstMercadoVO buscarEstadoSolEstMercadoPorNombre(EstadoSolEstMercadoVO estSolEstMercadoVo) throws ExcepcionDAO{
        SiiEstadoSolEstMercado estadoSolEstMercado;
        estadoSolEstMercado = conversionVoEntidad.convertir(estSolEstMercadoVo);
        List<SiiEstadoSolEstMercado> listaEstadoSolEstMercado;
        listaEstadoSolEstMercado = estSolEstMercadoDao.buscarEstadoSolEstMercadoPorNombre(estadoSolEstMercado);
        List<EstadoSolEstMercadoVO> listaEstadoSolEstMercadoVo;
        listaEstadoSolEstMercadoVo = new ArrayList();
        for(SiiEstadoSolEstMercado unEstadoSolEstMercado : listaEstadoSolEstMercado){
            listaEstadoSolEstMercadoVo.add(new EstadoSolEstMercadoVO(unEstadoSolEstMercado));
        }
        return new EstadoSolEstMercadoVO(listaEstadoSolEstMercado);
    }*/
    
    public EstadoSolEstMercadoVO buscarEstadoSolEstMercadoPorNombre(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO{
        SiiEstadoSolEstMercado siiEstadoSEM = conversionVoEntidad.convertir(estadoSolEstMercadoVo);
        SiiEstadoSolEstMercado resultadoEstadoSolEstMercado = estSolEstMercadoDao.buscarEstadoSolEstMercadoPorNombre(siiEstadoSEM);
        return new EstadoSolEstMercadoVO(resultadoEstadoSolEstMercado);
    }
    
    public List<EstadoSolEstMercadoVO> buscarTodoEstadoSolEstMercado(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO{
        SiiEstadoSolEstMercado estadoSolEstMercado;
        estadoSolEstMercado = conversionVoEntidad.convertir(estadoSolEstMercadoVo);
        List<SiiEstadoSolEstMercado> listaEstadoSolEstMercado;
        listaEstadoSolEstMercado = estSolEstMercadoDao.buscarTodoEstadoSolEstMercado();
        List<EstadoSolEstMercadoVO> listaEstadoSolEstMercadoVo;
        listaEstadoSolEstMercadoVo = new ArrayList();
        for(SiiEstadoSolEstMercado unEstadoSolEstMercado : listaEstadoSolEstMercado){
            listaEstadoSolEstMercadoVo.add(new EstadoSolEstMercadoVO(unEstadoSolEstMercado));
        }
        return listaEstadoSolEstMercadoVo;
    }
}
