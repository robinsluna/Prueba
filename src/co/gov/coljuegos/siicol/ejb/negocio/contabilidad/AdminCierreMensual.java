/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 17-03-2014
 */


package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CierreMensualVO;

import java.util.Date;
import java.util.List;

public interface AdminCierreMensual {

    public CierreMensualVO insertarCierreContable(CierreMensualVO cierreMensualVo) throws ExcepcionDAO;

    public List<CierreMensualVO> buscarTodoCierreContable() throws ExcepcionDAO;

    public CierreMensualVO buscarUltimoCierreContable() throws ExcepcionDAO;

    public CierreMensualVO actualizarCierreContable(CierreMensualVO cierreMensualVo) throws ExcepcionDAO;

    public CierreMensualVO buscarCierreContablePorId(Long idCierre) throws ExcepcionDAO;

    public boolean isMesCerrado(Date fecha) throws ExcepcionDAO;

    public CierreMensualVO procesoCierreContable(CierreMensualVO cierreMensualVo) throws ExcepcionDAO;

    public String proveedoresNulosEnCierreMensual(Integer vigencia, Integer mes) throws ExcepcionDAO;

}
