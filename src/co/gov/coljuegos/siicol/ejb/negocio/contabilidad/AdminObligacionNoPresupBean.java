/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoObligacionNoPresupuestal;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImpContabOblNoPresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionNoPresupDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImpContabOblNoPres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionNoPresup;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ImpContabOblNoPresVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionNoPresupVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminObligacionNoPresupBean implements AdminObligacionNoPresup {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ObligacionNoPresupDAO obligacionNoPresupDAO;
    @EJB
    private ImpContabOblNoPresDAO impContabOblNoPresDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    

    public AdminObligacionNoPresupBean() {
    }

    public ObligacionNoPresupVO insertarSiiObligacionNoPresup(ObligacionNoPresupVO obligacionNoPresupVO) throws ExcepcionDAO {
        SiiObligacionNoPresup obligNo =
            obligacionNoPresupDAO.insertarSiiObligacionNoPresup(conversionVoEntidad.convertir(obligacionNoPresupVO));

        // Se insertan las imputaciones contables
        if (obligacionNoPresupVO.getImpContabOblNoPresListVo().size() > 0) {
            for (ImpContabOblNoPresVO unVo : obligacionNoPresupVO.getImpContabOblNoPresListVo()) {
                SiiImpContabOblNoPres siiImpContabOblNoPres = conversionVoEntidad.convertir(unVo);
                siiImpContabOblNoPres.setSiiObligacionNoPresup(obligNo);
                impContabOblNoPresDao.insertarSiiImpContabOblNoPres(siiImpContabOblNoPres);
            }

        }

        return new ObligacionNoPresupVO(obligNo);
    }

    public List<ObligacionNoPresupVO> buscarTodoSiiObligacionNoPresup() throws ExcepcionDAO {
        List<SiiObligacionNoPresup> listaObligNoPres = obligacionNoPresupDAO.buscarTodoSiiObligacionNoPresup();
        List<ObligacionNoPresupVO> listaObligacionNoPresupVO = new ArrayList<ObligacionNoPresupVO>();
        for (SiiObligacionNoPresup unaObli : listaObligNoPres) {
            listaObligacionNoPresupVO.add(new ObligacionNoPresupVO(unaObli));
        }
        return listaObligacionNoPresupVO;
    }

    public ObligacionNoPresupVO buscarPorCodigoObligacionNoPres(Long idCodigoObligNoPres) throws ExcepcionDAO {
        SiiObligacionNoPresup siiObligacionNoPresup =
            obligacionNoPresupDAO.buscarPorCodigoObligacionNoPres(idCodigoObligNoPres);
        return new ObligacionNoPresupVO(siiObligacionNoPresup);

    }

    public Long buscarConsecutivoObligaNoPres() throws ExcepcionDAO {
        return obligacionNoPresupDAO.buscarConsecutivoObligaNoPres();
    }

    /**
     * @author Modifica Giovannni
     * @param obligacionNoPresupVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ObligacionNoPresupVO actualizarSiiObligacionNoPresup(ObligacionNoPresupVO obligacionNoPresupVO,
                                                                UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                  ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiObligacionNoPresup siiObligacionNoPresup = new SiiObligacionNoPresup();
        siiObligacionNoPresup =
            obligacionNoPresupDAO.buscarPorCodigoObligacionNoPres(obligacionNoPresupVO.getOnpCodigo());
        if (siiObligacionNoPresup.getSiiEstadoObligNoPres().getEonCodigo() !=
            obligacionNoPresupVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de obligacion no presup fue cambiado durante la modificación. Seleccione nuevamente el estado obligacion no presup");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (obligacionNoPresupVO.getEstadoObligNoPresVo().getEonCodigo() !=
            obligacionNoPresupVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.OBLIGACION.getId(),
                                                         obligacionNoPresupVO.getEstadoObligNoPresVo().getEonCodigo(),
                                                         usuarioLogueado, obligacionNoPresupVO.getOnpCodigo());
        }

        SiiObligacionNoPresup oblNoPres =
            obligacionNoPresupDAO.actualizarSiiObligacionNoPresup(conversionVoEntidad.convertir(obligacionNoPresupVO));
        
        // si el estado a actualizar es anulado se borra la imputación asociada a la obligación que se anula
       /* if(obligacionNoPresupVO.getEstadoObligNoPresVo().getEonCodigo().equals(EnumEstadoObligacionNoPresupuestal.ANULADO.getId())){
            impContabOblNoPresDao.borrarImpContabOblNoPresPorCodigoObligacion(obligacionNoPresupVO.getOnpCodigo());
        }*/
        return new ObligacionNoPresupVO(oblNoPres);
    }

    public List<ObligacionNoPresupVO> buscarObligacionesNoPresSinOrdenPago() throws ExcepcionDAO {
        List<ObligacionNoPresupVO> listaObligaciones = obligacionNoPresupDAO.buscarObligacionesNoPresSinOrdenPago();
        return listaObligaciones;
    }
    
}
