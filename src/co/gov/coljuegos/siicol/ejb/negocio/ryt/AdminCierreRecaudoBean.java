package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CierreRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreRecaudo;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CierreRecaudoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminCierreRecaudoBean implements AdminCierreRecaudo {
    @Resource
    private SessionContext sessionContext;
    @EJB
    private CierreRecaudoDAO cierreRecaudoDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    public AdminCierreRecaudoBean() {
    }

    public CierreRecaudoVO insertarCierreRecaudo(CierreRecaudoVO cierreRecaudoVo) throws ExcepcionDAO {
        SiiCierreRecaudo siiCierreRecaudo =
            cierreRecaudoDao.insertarSiiCierreRecaudo(conversionVoEntidad.convertir(cierreRecaudoVo));
        return new CierreRecaudoVO(siiCierreRecaudo);
    }

    public Long buscarConsecutivoCierre() throws ExcepcionDAO {
        return cierreRecaudoDao.buscarConsecutivoCierre();
    }

    public List<CierreRecaudoVO> buscarTodoCierres() throws ExcepcionDAO {
        List<SiiCierreRecaudo> listaSiiCierres = new ArrayList<SiiCierreRecaudo>();
        listaSiiCierres = cierreRecaudoDao.buscarTodoSiiCierreRecaudo();
        List<CierreRecaudoVO> listaCierresVo = new ArrayList<CierreRecaudoVO>();
        if (listaSiiCierres.size() > 0) {
            for (SiiCierreRecaudo siiCierre : listaSiiCierres) {
                CierreRecaudoVO cierreVo = new CierreRecaudoVO(siiCierre);
                listaCierresVo.add(cierreVo);
            }
        }
        return listaCierresVo;
    }

    public CierreRecaudoVO buscarCierrePorCodio(Long idCierre) throws ExcepcionDAO {
        SiiCierreRecaudo siiCierre = cierreRecaudoDao.buscarPorCodigoCierreRecaudo(idCierre);
        return new CierreRecaudoVO(siiCierre);
    }

    /**
     * @author Modifica Giovanni
     * @param cierreRecaudoVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public CierreRecaudoVO actualizarCierreRecaudo(CierreRecaudoVO cierreRecaudoVo,
                                                   UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {
        
        /*
         * Manejo de error de concurrencia
         */
       /* SiiCierreRecaudo siiCierreRecaudoTemp = new SiiCierreRecaudo();
        siiCierreRecaudoTemp = cierreRecaudoDao.buscarPorCodigoCierreRecaudo(cierreRecaudoVo.getCirCodigo());
        if (siiCierreRecaudoTemp.getSiiEstadoCierrreRec().getEcrCodigo() != cierreRecaudoVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del cierre recaudo previo fue cambiado durante la modificación. Seleccione nuevamente el cierre recuado");
        }*/
        
        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (cierreRecaudoVo.getEstadoCierrreRecVo().getEcrCodigo() != cierreRecaudoVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CIERRE_RECAUDO.getId(),
                                                         cierreRecaudoVo.getEstadoCierrreRecVo().getEcrCodigo(),
                                                         usuarioLogueado, cierreRecaudoVo.getCirCodigo());
        }
        
        SiiCierreRecaudo siiCierreRecaudo =
            cierreRecaudoDao.actualizarSiiCierreRecaudo(conversionVoEntidad.convertir(cierreRecaudoVo));
        return new CierreRecaudoVO(siiCierreRecaudo);
    }

    public CierreRecaudoVO consultarCierreRecaudoPorMesVigencia(int pMes, int pVigencia) throws ExcepcionDAO {
        SiiCierreRecaudo siiCierre = cierreRecaudoDao.consultarCierreRecaudoPorMesVigencia(pMes, pVigencia);
        return new CierreRecaudoVO(siiCierre);
    }

}
