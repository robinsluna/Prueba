package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LogCambioEstadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocumentoColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocumentoColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.vo.EstadoFechaVO;
import co.gov.coljuegos.siicol.ejb.vo.LogCambioEstadoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminLogCambioEstadoBean implements AdminLogCambioEstado{
    
    @EJB
    LogCambioEstadoDAO logCambioEstadoDao;
    @EJB
    UsuarioDAO usuarioDao;
    @EJB
    TipoDocumentoColjuegosDAO tipoDocumentoColjuegosDao;
    
    public AdminLogCambioEstadoBean() {
    }
    
    public void insertarLogCambioEstado( Long tipoDocColjuegos, Long idEstadoNuevo, UsuarioVO usuarioVo, Long idDocumento){
        try{
            if(usuarioVo == null || usuarioVo.getUsuCodigo() <= 0){
                System.out.println("Error al insertar log: el usuario es nulo");
                return;
            }
            if(tipoDocColjuegos == null || idDocumento == null){
                System.out.println("Error al insertar log: el tipo de documento o el id del documento es nulo");
                return;
            }
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(usuarioVo.getUsuCodigo());
            SiiTipoDocumentoColjuegos siiTipoDocColjuegos = tipoDocumentoColjuegosDao.buscarTipoDocumentoColjuegosPorId(tipoDocColjuegos);
            SiiLogCambioEstado siiLogCambioEstado = new SiiLogCambioEstado(null,idDocumento,idEstadoNuevo,new Date(System.currentTimeMillis()), siiTipoDocColjuegos, siiUsuario);
            logCambioEstadoDao.insertarLogCambioEstado(siiLogCambioEstado);
        } catch (Exception ex){
            System.out.println("Error al insertar log: ");
            ex.printStackTrace();
        }
        
    }
    
    public void insertarLogCambioEstadoConNombreEstado( Long tipoDocColjuegos, String lceNombEstNuevo, UsuarioVO usuarioVo, Long idDocumento){
        try{
            if(usuarioVo == null || usuarioVo.getUsuCodigo() <= 0){
                System.out.println("Error al insertar log: el usuario es nulo");
                return;
            }
            if(tipoDocColjuegos == null || idDocumento == null){
                System.out.println("Error al insertar log: el tipo de documento o el id del documento es nulo");
                return;
            }
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(usuarioVo.getUsuCodigo());
            SiiTipoDocumentoColjuegos siiTipoDocColjuegos = tipoDocumentoColjuegosDao.buscarTipoDocumentoColjuegosPorId(tipoDocColjuegos);
            SiiLogCambioEstado siiLogCambioEstado = new SiiLogCambioEstado(null,idDocumento,lceNombEstNuevo,new Date(), siiTipoDocColjuegos, siiUsuario);
            logCambioEstadoDao.insertarLogCambioEstado(siiLogCambioEstado);
        } catch (Exception ex){
            System.out.println("Error al insertar log: ");
            ex.printStackTrace();
        }
        
    }
    
    public void insertarLogCambioEstadoConNombreEstadoIDString( Long tipoDocColjuegos, String lceNombEstNuevo, UsuarioVO usuarioVo, String idDocumento){
        try{
            if(usuarioVo == null || usuarioVo.getUsuCodigo() <= 0){
                System.out.println("Error al insertar log: el usuario es nulo");
                return;
            }
            if(tipoDocColjuegos == null || idDocumento == null){
                System.out.println("Error al insertar log: el tipo de documento o el id del documento es nulo");
                return;
            }
            SiiUsuario siiUsuario = usuarioDao.buscarUsuarioPorId(usuarioVo.getUsuCodigo());
            SiiTipoDocumentoColjuegos siiTipoDocColjuegos = tipoDocumentoColjuegosDao.buscarTipoDocumentoColjuegosPorId(tipoDocColjuegos);
            SiiLogCambioEstado siiLogCambioEstado = new SiiLogCambioEstado(idDocumento,lceNombEstNuevo,new Date(), siiTipoDocColjuegos, siiUsuario);
            logCambioEstadoDao.insertarLogCambioEstado(siiLogCambioEstado);
        } catch (Exception ex){
            System.out.println("Error al insertar log: ");
            ex.printStackTrace();
        }
        
    }
    
    public Date buscarFechaLogCambioEstadoPorDocumentoEstado(Long tdoCodigo, Long lceEstadoNuevo, Long lceCodigoDoc)  throws ExcepcionDAO {
        return logCambioEstadoDao.buscarFechaLogCambioEstadoPorDocumentoEstado(tdoCodigo, lceEstadoNuevo, lceCodigoDoc);
    }
    
    public List<EstadoFechaVO> listaFechasCambioEstadoPorDocumento(Long tdoCodigo, Long lceCodigoDoc) throws ExcepcionDAO {
        return logCambioEstadoDao.listaFechasCambioEstadoPorDocumento(tdoCodigo, lceCodigoDoc);
    }
    
    public String buscarNombreUsuario(Long tdoCodigo, Long lceEstado, Long lceCodigoDoc) throws ExcepcionDAO {
        return logCambioEstadoDao.buscarNombreUsuario( tdoCodigo,  lceEstado,  lceCodigoDoc);
    }
    
    public String buscarInicialesNombreUsuario(Long tdoCodigo, Long lceEstado, Long lceCodigoDoc) throws ExcepcionDAO {
        return logCambioEstadoDao.buscarInicialesNombreUsuario(tdoCodigo, lceEstado, lceCodigoDoc);
    }
    
    public UsuarioVO buscarUsuarioLogCambioEstado(Long tdoCodigo, Long lceEstado, Long lceCodigoDoc) throws ExcepcionDAO {
        return new UsuarioVO(logCambioEstadoDao.buscarUsuarioLogCambioEstado(tdoCodigo, lceEstado, lceCodigoDoc));
    }
    
    public LogCambioEstadoVO fechaUltimoCambioEstadoPorDocumentoPorEstado(Long tdoCodigo, Long lceCodigoDoc, Long idEstado) throws ExcepcionDAO {
        LogCambioEstadoVO logCambioEstadoVO = null;
        SiiLogCambioEstado siiLogCambioEstado = logCambioEstadoDao.fechaUltimoCambioEstadoPorDocumentoPorEstado(tdoCodigo, lceCodigoDoc, idEstado);
        if(siiLogCambioEstado != null){
            logCambioEstadoVO = new LogCambioEstadoVO(siiLogCambioEstado);
        }
        return logCambioEstadoVO;
    }
    public String buscarNombreUsu(Long tdoCodigo, String nombreEstado, Long lceCodigoDoc) throws ExcepcionDAO{
        return logCambioEstadoDao.buscarNombreUsu(tdoCodigo, nombreEstado, lceCodigoDoc);
    }
    
}
