package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.AutoDecretaPrueProIleVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Autos que Decretan Pruebas del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminAutoDecretaPrueProIle 
{
    public AutoDecretaPrueProIleVO buscarAutoDecretaPrueProIlePorId (Long atpCodigo) throws ExcepcionDAO;
    public AutoDecretaPrueProIleVO insertarAutoDecretaPrueProIle (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public AutoDecretaPrueProIleVO insertarAutoDecretaPrueProIle (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    public AutoDecretaPrueProIleVO actualizarAutoDecretaPrueProIle (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public AutoDecretaPrueProIleVO actualizarAutoDecretaPrueProIle (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    public void eliminarAutoDecretaPrueProIle (Long atpCodigo) throws ExcepcionDAO;
    public List<AutoDecretaPrueProIleVO> buscarTodoAutoDecretaPrueProIle () throws ExcepcionDAO;
    public List<AutoDecretaPrueProIleVO> buscarAutoDecretaPrueProIlePorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO;
    public List<AutoDecretaPrueProIleVO> buscarAutoDecretaPrueProIlePorProcesoYTipoAuto (Long prsCodigo, String atpTipoAuto) throws ExcepcionDAO;
}
