/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Diego Alvarado
 * FECHA	: 12-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ApropiacionInicialVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.NivelRubroDetFuenteValorVO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel1VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel2VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel3VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel4VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel5VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel6VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel7VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel8VO;
import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteEjecucionPreGastosVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminRubro {

    public void insertarApropiacionTotal(ApropiacionInicialVO insertApropiacionInicialVo, List<PrRubroVO> listaRubrosVo) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<ApropiacionInicialVO> buscarTodaApropiacionInicial() throws ExcepcionDAO;

    public List<NivelRubroDetFuenteValorVO> buscarTodaApropiacionIniPorVigencia(Integer vigencia) throws ExcepcionDAO;

    public List<ApropiacionInicialVO> buscarApropiacionIniPorVigencia(ApropiacionInicialVO apropiacionInicialVo) throws ExcepcionDAO;

    public PrRubroVO insertarPrRubro(PrRubroVO prRubroVo) throws ExcepcionDAO;

    public PrRubroVO buscarPorInternoRubroVig(PrRubroVO prRubroVo) throws ExcepcionDAO;

    public PrRubroVO actualizarPrRubro(PrRubroVO prRubroVo) throws ExcepcionDAO;
    
    public ApropiacionInicialVO actualizarApropiacionInicial(ApropiacionInicialVO apropiacionInicialVo) throws ExcepcionDAO;

    public List<PrRubroVO> buscarTodoPrRubro() throws ExcepcionDAO;

    public List<PrRubroVO> buscarTodoPrRubroVigencia(PrRubroVO prRubroVo) throws ExcepcionDAO;

    public List<NivelRubroDetFuenteValorVO> buscarTodaApropiacionIniPorVigenciaFuenteFin(Integer vigencia, String fuenteFin) throws ExcepcionDAO;

    public DetalleRubroVO buscarPorCodigoDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO;

    public DetalleRubroVO insertarSiiDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO;

    public List<DetalleRubroVO> actualizarSiiDetalleRubro(List<DetalleRubroVO> listaDetalleRubroVo) throws ExcepcionDAO;

    public void borrarPorCodigoDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO;

    public List<DetalleRubroVO> buscarTodoSiiDetalleRubro() throws ExcepcionDAO;

    public PrNivel1VO insertarNivel1(PrNivel1VO prNivel1Vo) throws ExcepcionDAO;

    public PrNivel2VO insertarNivel2(PrNivel2VO prNivel2Vo) throws ExcepcionDAO;

    public PrNivel3VO insertarNivel3(PrNivel3VO prNivel3Vo) throws ExcepcionDAO;

    public PrNivel4VO insertarNivel4(PrNivel4VO prNivel4Vo) throws ExcepcionDAO;

    public PrNivel5VO insertarNivel5(PrNivel5VO prNivel5Vo) throws ExcepcionDAO;

    public PrNivel6VO insertarNivel6(PrNivel6VO prNivel6Vo) throws ExcepcionDAO;

    public PrNivel7VO insertarNivel7(PrNivel7VO prNivel7Vo) throws ExcepcionDAO;

    public PrNivel8VO insertarNivel8(PrNivel8VO prNivel8Vo) throws ExcepcionDAO;

    public ApropiacionInicialVO buscarApropiacionInicialPorId(ApropiacionInicialVO apropiacionInicialVo) throws ExcepcionDAO;

    public String buscarCodigoPresupuestal(Long interno, Long vigencia) throws ExcepcionDAO;

    public String buscarCodigoPresupuestal(Long mrdCodigo) throws ExcepcionDAO;

    public String buscarNombreRubro(Long interno, Long vigencia) throws ExcepcionDAO;

    public String buscarNombreRubro(Long mrdCodigo) throws ExcepcionDAO;

    public ReporteEjecucionPreGastosVO calculoEjecucionPreGastos(String idRubro, String fechaIni, String fechaFin) throws ExcepcionDAO;

    public Long buscarRubroPorVigenciaCodigoNiveles(Integer vigencia, String unidad, String tipo, String cuenta, String subcuenta, String objeto, String ordinal, String subordinal) throws ExcepcionDAO;
    
    

}
