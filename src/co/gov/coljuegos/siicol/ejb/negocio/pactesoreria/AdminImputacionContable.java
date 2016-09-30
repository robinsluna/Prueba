/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;

import co.gov.coljuegos.siicol.ejb.vo.ImputacionObligaNoPresupuestalVO;

import co.gov.coljuegos.siicol.ejb.vo.InfoSaldoImpCuentaContabVO;
import co.gov.coljuegos.siicol.ejb.vo.OrdenPagoVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminImputacionContable 
{
    public ImputacionContableVO buscarPorCodigoImputacionContable(Long imcCodigo) throws ExcepcionDAO;
    public ImputacionContableVO insertarImputacionContable (ImputacionContableVO imputacionContableVO) throws ExcepcionDAO;
    public ImputacionContableVO actualizarImputacionContable (ImputacionContableVO imputacionContableVO) throws ExcepcionDAO;
    public void borrarImputacionContable (Long imcCodigo) throws ExcepcionDAO;
    public List<ImputacionContableVO> buscarTodaImputacionContable () throws ExcepcionDAO;
    public List<ImputacionContableVO> buscarPorCodigoDocumentoContable (Long dcoCodigo) throws ExcepcionDAO;
    public List<ImputacionContableVO> buscarPorCodigoDocumentoContableYEstado (Long dcoCodigo, String imcEstado) throws ExcepcionDAO;
    public List<ImputacionObligaNoPresupuestalVO> buscarImputacionObligacionesNoPresupuestales(String tipoIdentificacion, String numeroIdentificacion, String idFueFinan) throws ExcepcionDAO;
    public List<ImputacionObligaNoPresupuestalVO> buscarImputacionObligacionesNoPresupuestalesPorCodigoOblNoPres(Long idObligNoPres ) throws ExcepcionDAO;
    public boolean insertarImputacionContableOrdenesPagoNoPres(DocumentoContableVO doc, OrdenPagoVO orden, String estadoImpBorrador, BigDecimal totalObligacion,List<ImputacionContableVO> listaImputacionEd ) throws ExcepcionDAO;
    public boolean insertarImputacionContableOrdenesPagoNoPresTPE(DocumentoContableVO doc, OrdenPagoVO orden, String estadoImpBorrador, BigDecimal totalObligacion) throws ExcepcionDAO;
    public boolean insertarImputacionConfPago(DocumentoContableVO doc, List<ImputacionContableVO> listaImpNueva,OrdenPagoVO orden) throws ExcepcionDAO;
    public List<InfoSaldoImpCuentaContabVO> obtenerInfoSaldoImputacionCuentasContab (Integer vigencia, boolean incluirSaldoInicial, Long ccoCodigo, boolean groupByPerCodigo, boolean groupByAcoCodigo) throws ExcepcionDAO;
    public List<InfoSaldoImpCuentaContabVO> obtenerInfoSaldoImputacionCuentasContab (Integer vigencia, boolean incluirSaldoInicial, String ccoTipoCuenta, String ccoCtaResult, String ccoCtaImpuestos, boolean groupByPerCodigo, boolean groupByAcoCodigo, Long ccoCodigo) throws ExcepcionDAO;
}
