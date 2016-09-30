package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminAreaColjuegos {
    public AreaColjuegosVO buscarAreaColjuegosPorId(Long idAreaColjuegos) throws ExcepcionDAO;
    public AreaColjuegosVO buscarAreaColjuegosPorId(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO;
    public AreaColjuegosVO insertarAreaColjuegos(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO;
    public AreaColjuegosVO actualizarAreaColjuegos(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO;
    //public AreaColjuegosVO eliminarAreaColjuegos(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO;
    public List<AreaColjuegosVO> buscarTodoAreaColjuegos() throws ExcepcionDAO;
    public List<AreaColjuegosVO> buscarAreaColjuegosPorNombre(AreaColjuegosVO areaColjuegosVo) throws ExcepcionDAO;
    public List<AreaColjuegosVO> buscarAreaColjuegosPorNombre(String acoNombre) throws ExcepcionDAO;
    public AreaColjuegosVO buscarAreaColjuegosPorAbreviatura (String acoAbreviatura) throws ExcepcionDAO;
}
