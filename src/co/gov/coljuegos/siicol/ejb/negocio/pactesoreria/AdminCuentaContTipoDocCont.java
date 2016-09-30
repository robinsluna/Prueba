/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-05-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.CuentaContTipoDocContVO;

import java.util.List;

import javax.ejb.Local;



/**
 * Interface local para el manejo de Cuentas Contables por Tipo de Documento Contable.
 * @author Camilo Miranda
 */
@Local
public interface AdminCuentaContTipoDocCont 
{
    public List<CuentaContTipoDocContVO> buscarSiiCuentaContTipoDocContPorTipoDoc(String tipoDocumento) throws ExcepcionDAO;
    public List<CuentaContTipoDocContVO> buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(String tdcCodigo, String cctConcepto, String perNumIdentificacion, String cctTipoRetNomina, String ffcCodigo) throws ExcepcionDAO;
    public List<CuentaContTipoDocContVO> buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(String tdcCodigo, String cctConcepto, String perNumIdentificacion, String cctTipoRetNomina, String ffcCodigo, boolean buscarCuentasSinConcepto) throws ExcepcionDAO;
    public List<CuentaContTipoDocContVO> buscarSiiCuentaContTipoDocContPorTipoDocYConcepto(String tipoDocumento, String concepto) throws ExcepcionDAO;
    
    public CuentaContTipoDocContVO buscarCuentaContTipoDocContPorCodigo (Long cctCodigo) throws ExcepcionDAO;
    public List<CuentaContTipoDocContVO> buscarTodaCuentaContTipoDocCont () throws ExcepcionDAO;
    public CuentaContTipoDocContVO insertarCuentaContTipoDocCont (CuentaContTipoDocContVO cuentaContTipoDocContVo) throws ExcepcionDAO;
    public CuentaContTipoDocContVO actualizarCuentaContTipoDocCont (CuentaContTipoDocContVO cuentaContTipoDocContVo) throws ExcepcionDAO;
    public void eliminarCuentaContTipoDocCont (Long cctCodigo) throws ExcepcionDAO;
}
