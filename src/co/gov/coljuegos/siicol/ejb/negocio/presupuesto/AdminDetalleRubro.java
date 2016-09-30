/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 11-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.InfoDetalladaRubroVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminDetalleRubro {
    public DetalleRubroVO buscarPorCodigoDetalleRubro(Long idDetalleRubro) throws ExcepcionDAO;

    public DetalleRubroVO insertarSiiDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO;

    public DetalleRubroVO actualizarSiiDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO;

    public void borrarPorCodigoDetalleRubro(Long idDetalleRubro) throws ExcepcionDAO;

    public List<DetalleRubroVO> buscarTodoSiiDetalleRubro() throws ExcepcionDAO;

    public String buscarCodigoPresupuestal(Long interno, Long vigencia) throws ExcepcionDAO;

    public String buscarNombreRubro(Long interno, Long vigencia) throws ExcepcionDAO;

    public DetalleRubroVO buscarDetalleRubroPorDetFuentePorRubro(Long idDetFuente, Long interno,
                                                                 Integer vigencia) throws ExcepcionDAO;

    public List<DetalleRubroVO> buscarDetalleRubroPorVigencia(Integer vigencia) throws ExcepcionDAO;

    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorVigencia(Integer vigencia) throws ExcepcionDAO;

    public List<InfoDetalladaRubroVO> buscarTodaInformacionDetalladaRubro() throws ExcepcionDAO;

    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorCodigoYVigencia(Long druCodigo,
                                                                                        Integer vigencia) throws ExcepcionDAO;

    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorCodigoVigenciaRP(Long druCodigo,
                                                                                         Integer vigencia,
                                                                                         Long rpCodigo) throws ExcepcionDAO;

    public BigDecimal valorPosibleIncrementarPorRubro(Long druCodigo) throws ExcepcionDAO;

    public BigDecimal valorActualComprometidoPorRubroDelCdp(Long druCodigo, Long cdpCodigo) throws ExcepcionDAO;
    
    public  DetalleRubroVO buscarDetalleRubroPorDetFuenteYrubroInterno(Long dffCodigo, Long rubroInterno, Integer vigencia) throws ExcepcionDAO;
    
    public List<DetalleRubroVO> buscarDetalleRubroPorDetalleRubroCdp(Long numeroCdp, Long rubroInterno, Integer vigencia, Integer fuenteFinanciacion) throws ExcepcionDAO;
}
