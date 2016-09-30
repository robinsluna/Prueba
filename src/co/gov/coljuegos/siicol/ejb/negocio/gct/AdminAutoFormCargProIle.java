package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.AutoFormCargProIleVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Auto Formulaci&oacute;n Cargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminAutoFormCargProIle 
{
    public AutoFormCargProIleVO buscarAutoFormCargProIlePorId (Long afcCodigo) throws ExcepcionDAO;
    public AutoFormCargProIleVO insertarAutoFormCargProIle (AutoFormCargProIleVO autoFormCargProIleVo) throws ExcepcionDAO;
    public AutoFormCargProIleVO insertarAutoFormCargProIle (AutoFormCargProIleVO autoFormCargProIleVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public AutoFormCargProIleVO actualizarAutoFormCargProIle (AutoFormCargProIleVO autoFormCargProIleVo) throws ExcepcionDAO;
    public AutoFormCargProIleVO actualizarAutoFormCargProIle (AutoFormCargProIleVO autoFormCargProIleVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public void eliminarAutoFormCargProIle (Long afcCodigo) throws ExcepcionDAO;
    public List<AutoFormCargProIleVO> buscarTodoAutoFormCargProIle () throws ExcepcionDAO;
    public List<AutoFormCargProIleVO> buscarAutoFormCargProIlePorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO;
}
