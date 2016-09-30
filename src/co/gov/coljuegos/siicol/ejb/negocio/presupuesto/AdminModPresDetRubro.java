/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ModPresDetRubroVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de la relaci&oacute;n del Detalle Rubro con la Modificaci&oacute;n Presupuestal.
 * @author Camilo Miranda
 */
@Local
public interface AdminModPresDetRubro {
    public ModPresDetRubroVO buscarModPresDetRubroPorId (Long idMpdCodigo) throws ExcepcionDAO;
    public ModPresDetRubroVO insertarModPresDetRubro (ModPresDetRubroVO modPresDetRubroVo) throws ExcepcionDAO;
    public ModPresDetRubroVO actualizarModPresDetRubro(ModPresDetRubroVO modPresDetRubroVo) throws ExcepcionDAO;
    public void borrarModPresDetRubro (Long mpdCodigo) throws ExcepcionDAO;
    public List<ModPresDetRubroVO> buscarPorCodigoModificPresup (Long mprCodigo) throws ExcepcionDAO;
    public Long consultarValorCreditos (Long druCodigo) throws ExcepcionDAO;
    public Long consultarValorContracreditos (Long druCodigo) throws ExcepcionDAO;
    public Long consultarValorAdiciones (Long druCodigo) throws ExcepcionDAO;
    public Long consultarValorReducciones (Long druCodigo) throws ExcepcionDAO;
}
