package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoFechaVO;
import co.gov.coljuegos.siicol.ejb.vo.LogCambioEstadoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminLogCambioEstado {
    public void insertarLogCambioEstado( Long tipoDocColjuegos, Long idEstadoNuevo, UsuarioVO usuarioVo, Long idDocumento);
    public void insertarLogCambioEstadoConNombreEstado( Long tipoDocColjuegos, String lceNombEstNuevo, UsuarioVO usuarioVo, Long idDocumento);
    public void insertarLogCambioEstadoConNombreEstadoIDString( Long tipoDocColjuegos, String lceNombEstNuevo, UsuarioVO usuarioVo, String idDocumento);
    public Date buscarFechaLogCambioEstadoPorDocumentoEstado(Long tdoCodigo, Long lceEstadoNuevo, Long lceCodigoDoc) throws ExcepcionDAO;
    public String buscarNombreUsuario(Long tdoCodigo, Long lceEstado, Long lceCodigoDoc) throws ExcepcionDAO;
    public String buscarInicialesNombreUsuario(Long tdoCodigo, Long lceEstado, Long lceCodigoDoc) throws ExcepcionDAO;
    public UsuarioVO buscarUsuarioLogCambioEstado(Long tdoCodigo, Long lceEstado, Long lceCodigoDoc) throws ExcepcionDAO;
    public List<EstadoFechaVO> listaFechasCambioEstadoPorDocumento(Long tdoCodigo, Long lceCodigoDoc) throws ExcepcionDAO ;
    public LogCambioEstadoVO fechaUltimoCambioEstadoPorDocumentoPorEstado(Long tdoCodigo, Long lceCodigoDoc, Long idEstado) throws ExcepcionDAO;
    public String buscarNombreUsu(Long tdoCodigo, String nombreEstado, Long lceCodigoDoc) throws ExcepcionDAO;
}
