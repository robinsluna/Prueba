package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoColjuegos;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoColjuegosVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminProcesoColjuegos {
    public ProcesoColjuegosVO insertarProcesoColjuegos(ProcesoColjuegosVO procesoColjuegosVo) throws ExcepcionDAO;
    public ProcesoColjuegosVO buscarProcesoColjuegosPorId(ProcesoColjuegosVO procesoColjuegosVo) throws ExcepcionDAO;
    public ProcesoColjuegosVO actualizarProcesoColjuegos(ProcesoColjuegosVO procesoColjuegosVo) throws ExcepcionDAO;
    public List<ProcesoColjuegosVO> buscarProcesoColjuegosPorNombre(ProcesoColjuegosVO unProcesoColjuegosVo) throws ExcepcionDAO;
    public List<ProcesoColjuegosVO> buscarTodoProcesoColjuegos() throws ExcepcionDAO;
}
