/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 03-02-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.pagoOperadoresPSE.PagoOperadoresPseVO;

import java.util.Date;
import java.util.List;

public interface AdminPagoOperadoresPse {
   
    public PagoOperadoresPseVO  insertarPagoOperadoresPse (List<PagoOperadoresPseVO> lista  ) throws ExcepcionDAO, ExcepcionAplicacion ;
    public List<PagoOperadoresPseVO> buscarTodoDetalleRecaudoXRecaudo(Date fechaActual ) throws ExcepcionDAO;

    
}
