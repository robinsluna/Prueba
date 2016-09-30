/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 09-06-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConcDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Notas de Cr&eacute;dito.
 * @author Camilo Miranda
 */
@Local
public interface AdminNotaCredito 
{
    public NotaCreditoVO buscarNotaCreditoPorId (Long ncrCodigo) throws ExcepcionDAO;
    public NotaCreditoVO insertarNotaCredito (NotaCreditoVO notaCreditoVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public NotaCreditoVO actualizarNotaCredito (NotaCreditoVO notaCreditoVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public void borrarNotaCredito (Long ncrCodigo) throws ExcepcionDAO;
    public List<NotaCreditoVO> buscarTodaNotaCredito () throws ExcepcionDAO;
    public Date obtenerUltimaFechaRegistrada (String ncrTipoNota) throws ExcepcionDAO;
    public Integer obtenerConsecutivoNotaCredito (String ncrTipoNota) throws ExcepcionDAO;
    public List<NotaCreditoVO> buscarNotaCreditoPorTipo (String ncrTipoNota) throws ExcepcionDAO;
    public List<NotaCreditoVO> buscarNotaCreditoPorCodigoObligacion(Long oblCodigo) throws ExcepcionDAO;
    public List<NotaCreditoVO> buscarNotaCreditoPorObligacionFFCTipoNotaEstado(Long oblCodigo, String ffcCodigo, String ncrTipoNota, String ncrEstado) throws ExcepcionDAO;
    
    
    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    public void setListaNotaCredOblConceptoEliminar (List<NotaCredOblConceptoVO> listaNotaCredOblConceptoEliminar);
    public void setListaNotaCredOblConcDetRubEliminar (List<NotaCredOblConcDetRubVO> listaNotaCredOblConcDetRubEliminar);
}
