package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Local
public interface AdminEstadoSolEstMercado {

    public EstadoSolEstMercadoVO buscarEstadoSolEstMercadoPorId(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO;
    public List<EstadoSolEstMercadoVO> buscarEstadoSolEstMercadoPorEstado(EstadoSolEstMercadoVO estSolEstMercadoVo) throws ExcepcionDAO;
    public EstadoSolEstMercadoVO actualizarEstadoSolEstMercado(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO;
    public EstadoSolEstMercadoVO insertarEstadoSolEstMercado(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO;
    public EstadoSolEstMercadoVO buscarEstadoSolEstMercadoPorNombre(EstadoSolEstMercadoVO estSolEstMercadoVo) throws ExcepcionDAO;
    public List<EstadoSolEstMercadoVO> buscarTodoEstadoSolEstMercado(EstadoSolEstMercadoVO estadoSolEstMercadoVo) throws ExcepcionDAO;
    
}
