/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 11-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.InfoDetalladaRubroVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminDetalleRubroBean implements AdminDetalleRubro {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private DetalleRubroDAO detalleRubroDao;


    /**
     * Constructor.
     */
    public AdminDetalleRubroBean() {
    }


    public DetalleRubroVO buscarPorCodigoDetalleRubro(Long idDetalleRubro) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubro = detalleRubroDao.buscarPorCodigoDetalleRubro(idDetalleRubro);
        return (new DetalleRubroVO(siiDetalleRubro));
    }


    public DetalleRubroVO insertarSiiDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubro =
            detalleRubroDao.insertarSiiDetalleRubro(conversionVoEntidad.convertir(detalleRubroVo));
        if (siiDetalleRubro != null)
            detalleRubroVo.setDruCodigo(siiDetalleRubro.getDruCodigo());

        return (new DetalleRubroVO(siiDetalleRubro));
    }


    public DetalleRubroVO actualizarSiiDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubro =
            detalleRubroDao.actualizarSiiDetalleRubro(conversionVoEntidad.convertir(detalleRubroVo));
        return (new DetalleRubroVO(siiDetalleRubro));
    }


    public void borrarPorCodigoDetalleRubro(Long idDetalleRubro) throws ExcepcionDAO {
        detalleRubroDao.borrarPorCodigoDetalleRubro(idDetalleRubro);
    }


    public List<DetalleRubroVO> buscarTodoSiiDetalleRubro() throws ExcepcionDAO {
        List<DetalleRubroVO> listaVo = new ArrayList<DetalleRubroVO>();
        List<SiiDetalleRubro> lista = detalleRubroDao.buscarTodoSiiDetalleRubro();
        if (lista != null) {
            for (SiiDetalleRubro siiDetalleRubro : lista) {
                listaVo.add(new DetalleRubroVO(siiDetalleRubro));
            }
        }
        return listaVo;
    }


    public String buscarCodigoPresupuestal(Long interno, Long vigencia) throws ExcepcionDAO {
        return (detalleRubroDao.buscarCodigoPresupuestal(interno, vigencia));
    }


    public String buscarNombreRubro(Long interno, Long vigencia) throws ExcepcionDAO {
        return (detalleRubroDao.buscarNombreRubro(interno, vigencia));
    }


    public DetalleRubroVO buscarDetalleRubroPorDetFuentePorRubro(Long idDetFuente, Long interno,
                                                                 Integer vigencia) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubro =
            detalleRubroDao.buscarDetalleRubroPorDetFuentePorRubro(idDetFuente, interno, vigencia);
        if (siiDetalleRubro != null) {
            return (new DetalleRubroVO(siiDetalleRubro));
        } else {
            return null;
        }


    }

    public List<DetalleRubroVO> buscarDetalleRubroPorVigencia(Integer vigencia) throws ExcepcionDAO {
        List<DetalleRubroVO> listaVo = new ArrayList<DetalleRubroVO>();
        List<SiiDetalleRubro> lista = detalleRubroDao.buscarDetalleRubroPorVigencia(vigencia);
        if (lista != null) {
            for (SiiDetalleRubro siiDetalleRubro : lista) {
                listaVo.add(new DetalleRubroVO(siiDetalleRubro));
            }
        }
        return listaVo;
    }

    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorVigencia(Integer vigencia) throws ExcepcionDAO {
        return (detalleRubroDao.buscarInformacionDetalladaRubroPorVigencia(vigencia));
    }

    public List<InfoDetalladaRubroVO> buscarTodaInformacionDetalladaRubro() throws ExcepcionDAO {
        return (detalleRubroDao.buscarTodaInformacionDetalladaRubro());
    }

    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorCodigoYVigencia(Long druCodigo,
                                                                                        Integer vigencia) throws ExcepcionDAO {
        return (detalleRubroDao.buscarInformacionDetalladaRubroPorCodigoYVigencia(druCodigo, vigencia));
    }

    public BigDecimal valorPosibleIncrementarPorRubro(Long druCodigo) throws ExcepcionDAO {
        return detalleRubroDao.valorActualApropiacionPorRubro(druCodigo).subtract(detalleRubroDao.valorActualComprometidoPorRubro(druCodigo));
    }

    public List<InfoDetalladaRubroVO> buscarInformacionDetalladaRubroPorCodigoVigenciaRP(Long druCodigo,
                                                                                         Integer vigencia,
                                                                                         Long rpCodigo) throws ExcepcionDAO {
        return (detalleRubroDao.buscarInformacionDetalladaRubroPorCodigoVigenciaRP(druCodigo, vigencia, rpCodigo));
    }

    public BigDecimal valorActualComprometidoPorRubroDelCdp(Long druCodigo, Long cdpCodigo) throws ExcepcionDAO {
        return detalleRubroDao.valorActualComprometidoPorRubroDelCdp(druCodigo, cdpCodigo);
    }

    public DetalleRubroVO buscarDetalleRubroPorDetFuenteYrubroInterno(Long dffCodigo, Long rubroInterno,
                                                                      Integer vigencia) throws ExcepcionDAO {

        SiiDetalleRubro siiDetalleRubro =
            detalleRubroDao.buscarDetalleRubroPorDetFuenteYrubroInterno(dffCodigo, rubroInterno, vigencia);
        if (siiDetalleRubro != null) {
            return (new DetalleRubroVO(siiDetalleRubro));
        } else {
            return null;
        }

    }
    
    public List<DetalleRubroVO> buscarDetalleRubroPorDetalleRubroCdp(Long numeroCdp, Long rubroInterno, Integer vigencia, Integer fuenteFinanciacion) throws ExcepcionDAO {
        List<DetalleRubroVO> detallesVo = new ArrayList<DetalleRubroVO>();
        for (SiiDetalleRubro detalle : detalleRubroDao.buscarDetalleRubroPorDetalleRubroCdp( numeroCdp,  rubroInterno, vigencia, fuenteFinanciacion) ) {
            detallesVo.add(new DetalleRubroVO (detalle));
        }
        return detallesVo;
        
    }
}
