/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 21-10-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CdpRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoAnulacionRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdpRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.CargaRpVO;
import co.gov.coljuegos.siicol.ejb.vo.CdpRpVO;
import co.gov.coljuegos.siicol.ejb.vo.CdpRubroDetalleFuenteVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoRpVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminRpBean implements AdminRp {
    @Resource
    SessionContext sessionContext;

    @EJB
    RpDAO rpDao;
    @EJB
    RpDetRubroCdpDAO rpDetRubroCdpDao;
    @EJB
    EstadoRpDAO estadoRpDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ProveedorDAO proveedorDAO;
    @EJB
    CdpRpDAO cdpRpDao;
    @EJB
    CargaRpDAO cargaRpDao;
    @EJB
    CdpDAO cdpDao;
    @EJB
    MotivoAnulacionRpDAO motivoAnulacionRpDao;

    public AdminRpBean() {
    }

    public RpVO insertarRpConDetalle(RpVO rpVo) throws ExcepcionDAO {

        List<RpDetRubroCdpVO> listaDetalles = rpVo.getRpDetRubroCdpVoList();
        // se inserta el proveedor
        SiiProveedor resultadoSiiProveedor = crearProveedor(rpVo);
        rpVo.setProveedorVo(new ProveedorVO(resultadoSiiProveedor));
        SiiRp siiRp = conversionVoEntidad.convertir(rpVo);
        siiRp.setSiiProveedor(resultadoSiiProveedor);

        SiiRp resultadoRp = rpDao.insertarRp(siiRp);

        if (listaDetalles != null) {
            for (RpDetRubroCdpVO unDetRubroCdpVo : listaDetalles) {
                BigDecimal valorRpTmp = new BigDecimal(0);
                valorRpTmp = unDetRubroCdpVo.getRdrValor();
                valorRpTmp = Utilidades.redondear(valorRpTmp, 0);
                unDetRubroCdpVo.setRdrValor(valorRpTmp);
                SiiRpDetRubroCdp nuevaEntidadDetalle = conversionVoEntidad.convertir(unDetRubroCdpVo);
                nuevaEntidadDetalle.setSiiRp(resultadoRp);
				rpDetRubroCdpDao.insertarRpDetRubroCdp(nuevaEntidadDetalle);
            }
        }
        
        rpVo.setRpCodigo(resultadoRp.getRpCodigo());
        // Se insertan los CdpRp
        for (CdpRpVO unCdpRpVo : rpVo.getCdpRpListVo()) {
            SiiCdpRp siiCdpRp = conversionVoEntidad.convertir(unCdpRpVo);
            siiCdpRp.setSiiRp(resultadoRp);
            cdpRpDao.insertarSiiCdpRp(siiCdpRp);
        }
        return new RpVO(resultadoRp);
    }

    private SiiProveedor crearProveedor(RpVO rpVo) throws ExcepcionDAO {
        SiiProveedor resultadoSiiProveedor = null;
        if (rpVo.getProveedorVo().getProCodigo()== null) {
            SiiProveedor siiProveedor = conversionVoEntidad.convertir(rpVo.getProveedorVo());
            resultadoSiiProveedor = proveedorDAO.insertarProveedor(siiProveedor);

        } else {
            resultadoSiiProveedor = proveedorDAO.buscarProveedorPorId(rpVo.getProveedorVo().getProCodigo());
        }
        return resultadoSiiProveedor;
    }

    public RpVO buscarPorCodigoRp(RpVO rpVo) throws ExcepcionDAO {
        RpVO miRpVO = null;
        SiiRp resultadoSiiRp = rpDao.buscarPorCodigoRp(rpVo.getRpCodigo());
        if (resultadoSiiRp != null) {
            miRpVO = new RpVO(resultadoSiiRp);
            List<SiiRpDetRubroCdp> miListaSiiRpDetRubroCdp = new ArrayList<SiiRpDetRubroCdp>();
            List<RpDetRubroCdpVO> miListaRpDetRubroCdpVO = new ArrayList<RpDetRubroCdpVO>();

            miListaSiiRpDetRubroCdp = resultadoSiiRp.getSiiRpDetRubroCdpList1();
            if (miListaSiiRpDetRubroCdp != null && !miListaSiiRpDetRubroCdp.isEmpty()) {
                for (SiiRpDetRubroCdp unSiiRpDetRubroCdp : miListaSiiRpDetRubroCdp) {
                    RpDetRubroCdpVO miRpDetRubroCdpVO = new RpDetRubroCdpVO(unSiiRpDetRubroCdp);
                    miListaRpDetRubroCdpVO.add(miRpDetRubroCdpVO);
                }

            }

            miRpVO.setRpDetRubroCdpVoList(miListaRpDetRubroCdpVO);
        }
        return miRpVO;
    }

    public RpVO insertarRp(RpVO rpVo) throws ExcepcionDAO {
        SiiRp siiRp = conversionVoEntidad.convertir(rpVo);
        SiiRp resultadoSiiRp = rpDao.insertarRp(siiRp);

        List<RpDetRubroCdpVO> listaRpDetRubroCdpVo = rpVo.getRpDetRubroCdpVoList();
        for (RpDetRubroCdpVO unRpDetRubroCdp : listaRpDetRubroCdpVo) {
            SiiRpDetRubroCdp nuevoRpDetRubroCdp = conversionVoEntidad.convertir(unRpDetRubroCdp);
            nuevoRpDetRubroCdp.setSiiRp(resultadoSiiRp);
            rpDetRubroCdpDao.insertarRpDetRubroCdp(nuevoRpDetRubroCdp);
        }

        return new RpVO(resultadoSiiRp);
    }

    public RpVO actualizarRp(RpVO rpVo) throws ExcepcionDAO {
        // se actualiza el padre
        //SiiRp siiRp = conversionVoEntidad.convertir(rpVo);
        SiiRp resultadoRp = rpDao.buscarPorCodigoRp(rpVo.getRpCodigo());
        if (rpVo.getEstadoRpVo() != null) {
            SiiEstadoRp miresultadoRp = estadoRpDao.buscarEstadoRpPorId(rpVo.getEstadoRpVo().getErpCodigo());
            resultadoRp.setSiiEstadoRp(miresultadoRp);
        }
        if (rpVo.getRpConsecutivo() != null) {
            resultadoRp.setRpConsecutivo(rpVo.getRpConsecutivo());
        }

        if (rpVo.getMotivoAnulRpVo() != null) {
            SiiMotivoAnulRp miMotivoAnul = motivoAnulacionRpDao.buscarPorCodigoMotivoAnulacion(rpVo.getMotivoAnulRpVo().getManCodigo());
            resultadoRp.setSiiMotivoAnulRp(miMotivoAnul);
        }
        if (rpVo.getRpFechaRp() != null) {
            resultadoRp.setRpFechaRp(rpVo.getRpFechaRp());
        }

        SiiRp retornoSiiRp = rpDao.actualizarRp(resultadoRp);

        //Se actualizan los hijos
        if (rpVo.getRpDetRubroCdpVoList() != null) {
            for (RpDetRubroCdpVO unRpDetRubroCdpVO : rpVo.getRpDetRubroCdpVoList()) {
                SiiRpDetRubroCdp miSiiRpDetRubroCdp = conversionVoEntidad.convertir(unRpDetRubroCdpVO);
                miSiiRpDetRubroCdp.setSiiRp(retornoSiiRp);
                rpDetRubroCdpDao.actualizarRpDetRubroCdp(miSiiRpDetRubroCdp);
            }
        }


        return new RpVO(retornoSiiRp);
    }

    public List<RpVO> buscarTodoRp() throws ExcepcionDAO {
        return convertirSiiRpsEnVo(rpDao.buscarTodoRp());
    }

    public List<RpVO> buscarRpPorEstado(String estado) throws ExcepcionDAO {
        return convertirSiiRpsEnVo(rpDao.buscarRpPorEstado(estado));
    }

    public List<RpVO> buscarRpAprobadosSinIncrementosEnTramite() throws ExcepcionDAO {
        return convertirSiiRpsEnVo(rpDao.buscarRpAprobadosSinIncrementosEnTramite());
    }
    
    public List<RpVO> buscarRpAprobadosSinDecrementosEnTramite() throws ExcepcionDAO {
        return convertirSiiRpsEnVo(rpDao.buscarRpAprobadosSinDecrementosEnTramite());
    }


    private List<RpVO> convertirSiiRpsEnVo(List<SiiRp> listaRp) {
        List<RpVO> listaRpVo = new ArrayList();
        for (SiiRp unRp : listaRp) {
            listaRpVo.add(new RpVO(unRp));
        }
        return listaRpVo;
    }

    public RpDetRubroCdpVO buscarCodigoRpDetRubroCdp(RpDetRubroCdpVO rpDetRubroCdpVo) throws ExcepcionDAO {
        SiiRpDetRubroCdp retornoRpDetRubroCdp =
            rpDetRubroCdpDao.buscarCodigoRpDetRubroCdp(rpDetRubroCdpVo.getRdrCodigo());
        return new RpDetRubroCdpVO(retornoRpDetRubroCdp);
    }

    public RpDetRubroCdpVO insertarRpDetRubroCdp(RpDetRubroCdpVO rpDetRubroCdpVo) throws ExcepcionDAO {
        SiiRpDetRubroCdp siiRpDetRubroCdp = conversionVoEntidad.convertir(rpDetRubroCdpVo);
        SiiRpDetRubroCdp RetornoRpDetRubroCdp = rpDetRubroCdpDao.insertarRpDetRubroCdp(siiRpDetRubroCdp);
        return new RpDetRubroCdpVO(RetornoRpDetRubroCdp);
    }

    public RpDetRubroCdpVO actualizarRpDetRubroCdp(RpDetRubroCdpVO rpDetRubroCdpVo) throws ExcepcionDAO {
        SiiRpDetRubroCdp siiRpDetRubroCdp = conversionVoEntidad.convertir(rpDetRubroCdpVo);
        SiiRpDetRubroCdp RetornoRpDetRubroCdp = rpDetRubroCdpDao.actualizarRpDetRubroCdp(siiRpDetRubroCdp);
        return new RpDetRubroCdpVO(RetornoRpDetRubroCdp);
    }

    public List<RpDetRubroCdpVO> buscarTodoRpDetRubroCdp() throws ExcepcionDAO {
        List<SiiRpDetRubroCdp> listaRpDetRubroCdp = rpDetRubroCdpDao.buscarTodoRpDetRubroCdp();

        List<RpDetRubroCdpVO> listaRpDetRubroCdpVo = new ArrayList();
        for (SiiRpDetRubroCdp unRpDetRubroCdp : listaRpDetRubroCdp) {
            RpDetRubroCdpVO nuevoRpDetRubroCdp = new RpDetRubroCdpVO(unRpDetRubroCdp);
            listaRpDetRubroCdpVo.add(nuevoRpDetRubroCdp);
        }
        return listaRpDetRubroCdpVo;
    }

    public EstadoRpVO buscarEstadoRpPorId(EstadoRpVO estadoRpVo) throws ExcepcionDAO {
        SiiEstadoRp retornoEstadoRp = estadoRpDao.buscarEstadoRpPorId(estadoRpVo.getErpCodigo());
        return new EstadoRpVO(retornoEstadoRp);
    }

    public List<EstadoRpVO> buscarEstadoRpPorCodigo(EstadoRpVO estadoRpVo) throws ExcepcionDAO {
        SiiEstadoRp siiEstadoRp = conversionVoEntidad.convertir(estadoRpVo);

        List<SiiEstadoRp> listaEstadoRp = estadoRpDao.buscarEstadoRpPorCodigo(siiEstadoRp);

        List<EstadoRpVO> listaEstadoRpVo = new ArrayList();
        for (SiiEstadoRp unEstadoRp : listaEstadoRp) {
            listaEstadoRpVo.add(new EstadoRpVO(unEstadoRp));
        }
        return listaEstadoRpVo;
    }

    public List<EstadoRpVO> buscarCodEstadoPorNombre(String estadoRp) throws ExcepcionDAO {

        List<SiiEstadoRp> listaEstadoRp = estadoRpDao.buscarCodEstadoPorNombre(estadoRp);

        List<EstadoRpVO> listaEstadoRpVo = new ArrayList();
        for (SiiEstadoRp unEstadoRp : listaEstadoRp) {
            listaEstadoRpVo.add(new EstadoRpVO(unEstadoRp));
        }
        return listaEstadoRpVo;
    }

    public List<EstadoRpVO> buscarTodoEstadoRp() throws ExcepcionDAO {
        List<SiiEstadoRp> listaEstadoRp = estadoRpDao.buscarTodoEstadoRp();

        List<EstadoRpVO> listaEstadoRpVo = new ArrayList();
        for (SiiEstadoRp unEstadoRp : listaEstadoRp) {
            EstadoRpVO nuevoEstadoRp = new EstadoRpVO(unEstadoRp);
            listaEstadoRpVo.add(nuevoEstadoRp);
        }
        return listaEstadoRpVo;
    }

    public List<CdpRubroDetalleFuenteVO> bucarCdpConSaldo(Integer vigencia) throws ExcepcionDAO {
        return rpDao.bucarCdpConSaldo(vigencia);
    }

    public List<CdpRubroDetalleFuenteVO> bucarRubroFteDetPorCdp(Long IdCdp) throws ExcepcionDAO {

        List<CdpRubroDetalleFuenteVO> listaResultado = new ArrayList<CdpRubroDetalleFuenteVO>();
        listaResultado = rpDao.bucarRubroFteDetPorCdp(IdCdp);


        // Se buscan los rubros del CDP

        /* List<CdpRubroDetalleFuenteVO> listRubrosPorCdp = rpDao.buscarRubrosPorCdp(IdCdp);

        // Se buscan los incrementos del RUBRO
        for( CdpRubroDetalleFuenteVO unRubro : listRubrosPorCdp){
            BigDecimal TotalIncrementos = new BigDecimal(0);
            BigDecimal TotalDecrementos = new BigDecimal(0);
            BigDecimal TotalValorRubro = new BigDecimal(0);
            BigDecimal saldoRubro  = new BigDecimal(0);
            BigDecimal totalRp = new BigDecimal(0);
            BigDecimal total = new BigDecimal(0);
            saldoRubro = unRubro.getSaldo();
            TotalValorRubro= TotalValorRubro.add(saldoRubro);
            List<CdpRubroDetalleFuenteVO> listIncPorRubro = rpDao.buscarIncrementosPorRubro(unRubro.getIdDetRubCdp());
            // Se adicionan los incrementos
            TotalIncrementos = listIncPorRubro.get(0).getSaldo();
            TotalValorRubro= TotalValorRubro.add(TotalIncrementos);
            // se buscan los decrementos y rps
            List<CdpRubroDetalleFuenteVO> listDecPorRubro = rpDao.buscarDecrementosPorRubro(unRubro.getIdDetRubCdp());
            TotalDecrementos = (listDecPorRubro.get(0).getSaldo()).multiply(new BigDecimal(-1));
            TotalValorRubro= TotalValorRubro.add(TotalDecrementos);
            // Se buscan los rps
            List<CdpRubroDetalleFuenteVO> listValorRpPorRubro = rpDao.buscarRPPorRubro(unRubro.getIdDetRubCdp());
            totalRp = (listValorRpPorRubro.get(0).getSaldo()).multiply(new BigDecimal(-1));
            TotalValorRubro= TotalValorRubro.add(totalRp);
            //se arma la lista a retornar
            unRubro.setSaldo(TotalValorRubro);
            listaResultado.add(unRubro);

        }*/


        return listaResultado;
    }

    public Long buscarConsecutivoRp() throws ExcepcionDAO {
        return rpDao.buscarConsecutivoRp();
    }

    public List<CdpRubroDetalleFuenteVO> buscarRubroFteDetPorRp(RpVO unRpVo) throws ExcepcionDAO {
        List<CdpRubroDetalleFuenteVO> miListaRubroFteDetPorRp = new ArrayList();
        List<CdpRubroDetalleFuenteVO> miListaRpAprobados = new ArrayList();
        miListaRubroFteDetPorRp = rpDao.buscarRubroFteDetPorRp(unRpVo.getRpCodigo(),unRpVo.getCdpVo().getCdpCodigo());
        BigDecimal saldo = new BigDecimal(0);
        List<SiiRpDetRubroCdp> listaSiiRpDetRubroCdp = new ArrayList();

        miListaRpAprobados = rpDao.buscarRubroPorRpAprobados(unRpVo.getCdpVo().getCdpCodigo());
       // se busca el detalle del r
       listaSiiRpDetRubroCdp = rpDetRubroCdpDao.buscarRpDetRubroCdpPorRp(unRpVo.getRpCodigo());
        
        
        
        if (miListaRubroFteDetPorRp.size() > 0 && miListaRpAprobados.size() > 0) {
            for (CdpRubroDetalleFuenteVO miRubroCdp : miListaRubroFteDetPorRp) {
                saldo = miRubroCdp.getSaldo();
                for (CdpRubroDetalleFuenteVO miRpApr : miListaRpAprobados) {
                    if (miRubroCdp.getIdDetRubCdp().equals(miRpApr.getIdDetRubCdp())) {
                        if (saldo != null) {
                            saldo = saldo.subtract(miRpApr.getSaldo());
                            miRubroCdp.setSaldo(saldo);
                        } else {
                            miRubroCdp.setSaldo(new BigDecimal(0));
                        }
                    }
                }
                if(listaSiiRpDetRubroCdp.size()> 0){
                    for(SiiRpDetRubroCdp unDet : listaSiiRpDetRubroCdp){
                        if(miRubroCdp.getIdDetRubCdp().equals(unDet.getSiiDetalleRubroCdp().getDrcCodigo())){
                            miRubroCdp.setValorRp(unDet.getRdrValor());
                        }
                    }
                }
            }
        }

        return miListaRubroFteDetPorRp;
    }

    public CdpRubroDetalleFuenteVO buscarSaldoPorCdp(Long IdCdp, Long IdRubro) throws ExcepcionDAO {
        return rpDao.buscarSaldoPorCdp(IdCdp, IdRubro);
    }

    @Override
    public List<String> buscarObjetosPorCodigosRp(List<Long> rps) throws ExcepcionDAO {
        return rpDao.buscarObjetosPorCodigosRp(rps);
    }


    public List<RpVO> buscarRPPorIdProveedor(Long idProveedor) throws ExcepcionDAO {
        List<SiiRp> listaRp = rpDao.buscarRPPorIdProveedor(idProveedor);

        List<RpVO> listaRpVo = new ArrayList<RpVO>();
        for (SiiRp siiRP : listaRp) {
            RpVO nuevoRpVo = new RpVO(siiRP);
            listaRpVo.add(nuevoRpVo);
        }
        return listaRpVo;
    }


    public BigDecimal consultarValorRP(Long rpCodigo) throws ExcepcionDAO {
        return (rpDao.consultarValorRP(rpCodigo));
    }

    public BigDecimal consultarValorRPSinGMF(Long rpCodigo) throws ExcepcionDAO {
        return (rpDao.consultarValorRPSinGMF(rpCodigo));
    }

    public BigDecimal consultarValorRP(Long rpCodigo, boolean incluirGMF) throws ExcepcionDAO {
        return (rpDao.consultarValorRP(rpCodigo, incluirGMF));
    }


    public BigDecimal consultarDecrementosRP(Long rpCodigo, Long idEstadoModificRP) throws ExcepcionDAO {
        return (rpDao.consultarDecrementosRP(rpCodigo, idEstadoModificRP));
    }


    public BigDecimal consultarDecrementosRP(Long rpCodigo) throws ExcepcionDAO {
        return (rpDao.consultarDecrementosRP(rpCodigo));
    }

    public BigDecimal buscarTotalRpAprobadosPorCdp(Long idCdp) throws ExcepcionDAO {
        return rpDao.buscarTotalRpAprobadosPorCdp(idCdp);
    }

    public List<CdpRubroDetalleFuenteVO> reporteDetallePorRp(Long IdRp) throws ExcepcionDAO {
        return rpDao.reporteDetallePorRp(IdRp);
    }

    public List<RpVO> buscarRpPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO {
        List<SiiRp> listaRp = rpDao.buscarRpPorIdProcesoContratacion(idProcesoContratacion);
        List<RpVO> listaRpVo = new ArrayList<RpVO>();
        for (SiiRp siiRP : listaRp) {
            RpVO rpVo = new RpVO(siiRP);
            listaRpVo.add(rpVo);
        }
        return listaRpVo;
    }

    public BigDecimal getGastosPersonal(Long IdRp) throws ExcepcionDAO {
        return rpDao.getGastosPersonal(IdRp);
    }


    public BigDecimal getGastosGenerales(Long IdRp) throws ExcepcionDAO {
        return rpDao.getGastosGenerales(IdRp);
    }

    public BigDecimal getRecursosPropios(Long IdRp) throws ExcepcionDAO {
        return rpDao.getRecursosPropios(IdRp);
    }

    public List<CdpRubroDetalleFuenteVO> bucarRubroFteDetPorCdps(String IdCdp) throws ExcepcionDAO {

        List<CdpRubroDetalleFuenteVO> listaResultado = new ArrayList<CdpRubroDetalleFuenteVO>();
        listaResultado = rpDao.bucarRubroFteDetPorCdps(IdCdp);
        return listaResultado;
    }


    public List<RpVO> buscarRpAprobadosPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO {
        List<SiiRp> listaRp = rpDao.buscarRpAprobadosPorIdProcesoContratacion(idProcesoContratacion);
        List<RpVO> listaRpVo = new ArrayList<RpVO>();
        for (SiiRp siiRP : listaRp) {
            RpVO rpVo = new RpVO(siiRP);
            listaRpVo.add(rpVo);
        }
        return listaRpVo;
    }

    public List<CdpRubroDetalleFuenteVO> buscarDetalleRpPorRp(Long idRp) throws ExcepcionDAO {

        List<CdpRubroDetalleFuenteVO> listaResultado = new ArrayList<CdpRubroDetalleFuenteVO>();
        listaResultado = rpDao.buscarDetalleRpPorRp(idRp);
        return listaResultado;
    }

    public BigDecimal getTotalGastosPersonalPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        return rpDao.getTotalGastosPersonalPorObligacionConcepto(concepto);
    }

    public BigDecimal getGastosPersonalPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        return rpDao.getGastosPersonalPorObligacionConcepto(concepto);
    }

    public BigDecimal getTotalGastosGeneralesPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        return rpDao.getTotalGastosGeneralesPorObligacionConcepto(concepto);
    }

    public BigDecimal getGastosGeneralesPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        return rpDao.getGastosGeneralesPorObligacionConcepto(concepto);
    }

    public BigDecimal getTotalRecursosPropiosPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        return rpDao.getTotalRecursosPropiosPorObligacionConcepto(concepto);
    }

    public BigDecimal getRecursosPropiosPorObligacionConcepto(Integer concepto) throws ExcepcionDAO {
        return rpDao.getRecursosPropiosPorObligacionConcepto(concepto);
    }
    
    public BigDecimal getGastosTransferenciaPorObligacion (Integer oblNumero) throws ExcepcionDAO {
        return ( rpDao.getGastosTransferenciaPorObligacion(oblNumero) );
    }
    
    public BigDecimal getRecursosControlIlegalidadPorObligacion (Integer oblNumero) throws ExcepcionDAO {
        return ( rpDao.getRecursosControlIlegalidadPorObligacion(oblNumero) );
    }

    public BigDecimal consultarValorRP(Long rpCodigo, String ffcCodigo) throws ExcepcionDAO {
        return (rpDao.consultarValorRP(rpCodigo, ffcCodigo));
    }
    
    public BigDecimal consultarValorRP (Long rpCodigo, String ffcCodigo, boolean incluirGMF) throws ExcepcionDAO {
        return (rpDao.consultarValorRP(rpCodigo, ffcCodigo, incluirGMF));
    }

    public BigDecimal consultarDecrementosRP(Long rpCodigo, String ffcCodigo) throws ExcepcionDAO {
        return (rpDao.consultarDecrementosRP(rpCodigo, ffcCodigo));
    }

    public BigDecimal consultarDecrementosRP(Long rpCodigo, Long emrCodigo, String ffcCodigo) throws ExcepcionDAO {
        return (rpDao.consultarDecrementosRP(rpCodigo, emrCodigo, ffcCodigo));
    }
    
    
    public BigDecimal consultarIncrementosRP(Long rpCodigo) throws ExcepcionDAO {
        return ( rpDao.consultarIncrementosRP(rpCodigo) );
    }

    public BigDecimal consultarIncrementosRP(Long rpCodigo, Long idEstadoModificRP) throws ExcepcionDAO {
        return ( rpDao.consultarIncrementosRP(rpCodigo, idEstadoModificRP) );
    }

    public BigDecimal consultarIncrementosRP(Long rpCodigo, String ffcCodigo) throws ExcepcionDAO {
        return ( rpDao.consultarIncrementosRP(rpCodigo, ffcCodigo) );
    }

    public BigDecimal consultarIncrementosRP(Long rpCodigo, Long emrCodigo, String ffcCodigo) throws ExcepcionDAO {
        return ( rpDao.consultarIncrementosRP(rpCodigo, emrCodigo, ffcCodigo) );
    }
    

    public BigDecimal consultarValorRP(Long rpCodigo, Long druCodigo, Long dffCodigo) throws ExcepcionDAO {
        return (rpDao.consultarValorRP(rpCodigo, druCodigo, dffCodigo));
    }

    public RpVO buscarPorCodigoRp(Long idCodigoRp) throws ExcepcionDAO {
        RpVO rpVo = new RpVO();
        rpVo.setRpCodigo(idCodigoRp);
        return (this.buscarPorCodigoRp(rpVo));
    }

    public RpVO buscarPorConsecutivoRp(Long rpConsecutivo) throws ExcepcionDAO {
        RpVO rpVo = null;
        SiiRp siiRp = rpDao.buscarPorConsecutivoRp(rpConsecutivo);
        if (siiRp != null)
            rpVo = new RpVO(siiRp);

        return (rpVo);
    }

    public CargaRpVO guardarListaRp(CargaRpVO cargaRpVo) throws ExcepcionDAO, ExcepcionAplicacion {
        for (RpVO rpVo : cargaRpVo.getRpListVo()) {
            rpVo.setRpConsecutivo(rpDao.siguienteConsecutivoRp(cdpDao.buscarCdpPorId(rpVo.getCdpRpListVo().get(0).getCdpVo().getCdpCodigo()).getCdpVigencia()));
            rpVo = insertarRpConDetalle(rpVo);
        }
        cargaRpVo = new CargaRpVO(cargaRpDao.insertarCargaRp(conversionVoEntidad.convertir(cargaRpVo)));
        cargaRpVo.setRpListVo(cargaRpVo.getRpListVo());
        return cargaRpVo;

    }

    public List<RpVO> listaRpsAsociadosConLosCdpAsociadosConElRp(RpVO rpVO) throws ExcepcionDAO {
        List<SiiRp> listaRp = rpDao.listaRpsAsociadosConLosCdpAsociadosConElRp(rpVO);
        List<RpVO> listaRpVo = new ArrayList<RpVO>();
        for (SiiRp siiRP : listaRp) {
            RpVO rpVo = new RpVO(siiRP);
            listaRpVo.add(rpVo);
        }
        return listaRpVo;


    }
}

