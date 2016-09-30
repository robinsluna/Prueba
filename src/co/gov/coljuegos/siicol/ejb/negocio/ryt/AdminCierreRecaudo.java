/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Mónica Pabón
 * FECHA	: 20-03-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CierreRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminCierreRecaudo {
    public CierreRecaudoVO insertarCierreRecaudo(CierreRecaudoVO cierreRecaudoVo) throws ExcepcionDAO;

    public Long buscarConsecutivoCierre() throws ExcepcionDAO;

    public List<CierreRecaudoVO> buscarTodoCierres() throws ExcepcionDAO;

    public CierreRecaudoVO buscarCierrePorCodio(Long idCierre) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param cierreRecaudoVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public CierreRecaudoVO actualizarCierreRecaudo(CierreRecaudoVO cierreRecaudoVo,
                                                   UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion;

    public CierreRecaudoVO consultarCierreRecaudoPorMesVigencia(int pMes, int pVigencia) throws ExcepcionDAO;
}
