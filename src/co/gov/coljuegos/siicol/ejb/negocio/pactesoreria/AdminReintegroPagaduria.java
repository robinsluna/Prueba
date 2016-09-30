/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Walter Becerra
 * FECHA	: 23-06-2015
 */


package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;
import co.gov.coljuegos.siicol.ejb.vo.ReintegroPagaduriaVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminReintegroPagaduria {
    
    public ReintegroPagaduriaVO buscarPorCodigoReintegroIngresoPag (Long ripCodigo) throws ExcepcionDAO ;
    public ReintegroPagaduriaVO insertarSiiReintegroPagaduria(ReintegroPagaduriaVO reintegroPagaduriaVo,UsuarioVO usuarioLogueadoVo) throws ExcepcionDAO ;
    public ReintegroPagaduriaVO actualizarReintegroIngresoPag(ReintegroPagaduriaVO reintegroPagaduriaVo,UsuarioVO usuarioLogueadoVo) throws ExcepcionDAO ;
    public List<ReintegroPagaduriaVO> buscarTodoReintegroIngresoPag() throws ExcepcionDAO ;
    public List<NotaCreditoVO> buscarTodoNotaCreditoAprobado(String estado) throws ExcepcionDAO ;
    public String siguienteNumeroReintegroIngresoPag() throws ExcepcionDAO ;
    public NotaCreditoVO buscarNotaCreditoXId(Long  ncrCodigo, Long ripCodigo) throws ExcepcionDAO ;
    public List<ReintegroPagaduriaVO> buscarReintregroXNotaCredito(long nrcCodigo) throws ExcepcionDAO;
}
