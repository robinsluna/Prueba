package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTipoApuesta {
    
    public TipoApuestaVO  buscarPorcentajePromocionales() throws ExcepcionDAO ;
    public TipoApuestaVO buscarSiiTipoCodigoApuesta(String  codTipoCodigoApuesta) throws ExcepcionDAO ;
    public List<TipoApuestaVO> buscarTodoTipoApuesta() throws ExcepcionDAO;
}
