package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoProveedorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContratoProveedor;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ContratoProveedorVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminContratoProveedorBean implements AdminContratoProveedor {
    @Resource
    SessionContext sessionContext;

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ContratoProveedorDAO contratoProveedorDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    public AdminContratoProveedorBean() {
    }

    public ContratoProveedorVO insertarContratoProveedor(ContratoProveedorVO contratoProveedorVo) throws ExcepcionDAO {
        SiiContratoProveedor siiContratoProveedor = conversionVoEntidad.convertir(contratoProveedorVo);
        siiContratoProveedor = contratoProveedorDao.insertarContratoProveedor(siiContratoProveedor);
        return new ContratoProveedorVO(siiContratoProveedor);
    }

    /**
     * @author Modifica Giovanni
     * @param contratoProveedorVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ContratoProveedorVO actualizarContratoProveedor(ContratoProveedorVO contratoProveedorVo,
                                                           UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                             ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiContratoProveedor siiContratoProveedorTemp = new SiiContratoProveedor();
        siiContratoProveedorTemp =
            contratoProveedorDao.buscarContratoProveedorPorId(contratoProveedorVo.getCprCodigo());
        if (siiContratoProveedorTemp.getSiiEstadoContrProv().getEcpCodigo() !=
            contratoProveedorVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del contrato proveedro fue cambiado durante la modificación. Seleccione nuevamente el contrato proveedor");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (contratoProveedorVo.getEstadoContrProvVo().getEcpCodigo() != contratoProveedorVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.ESTUDIOS_PREVIOS.getId(),
                                                         contratoProveedorVo.getEstadoContrProvVo().getEcpCodigo(),
                                                         usuarioLogueado, contratoProveedorVo.getCprCodigo());
        }

        SiiContratoProveedor siiContratoProveedor =
            contratoProveedorDao.actualizarContratoProveedor(conversionVoEntidad.convertir(contratoProveedorVo));
        //siiContratoProveedor = contratoProveedorDao.actualizarContratoProveedor(siiContratoProveedor);
        return new ContratoProveedorVO(siiContratoProveedor);
    }

    public ContratoProveedorVO buscarContratoProveedorPorId(ContratoProveedorVO contratoProveedorVo) throws ExcepcionDAO {
        SiiContratoProveedor siiContratoProveedor =
            contratoProveedorDao.buscarContratoProveedorPorId(contratoProveedorVo.getCprCodigo());
        return new ContratoProveedorVO(siiContratoProveedor);
    }

    public List<ContratoProveedorVO> buscarContratoProveedorPorIdOficioAdjudicacion(Long idOficioAdjudicacion) throws ExcepcionDAO {
        List<SiiContratoProveedor> listaContratoProveedor =
            contratoProveedorDao.buscarContratoProveedorPorIdOficioAdjudicacion(idOficioAdjudicacion);
        List<ContratoProveedorVO> listaContratoProveedorVo = new ArrayList();
        for (SiiContratoProveedor unContratoProveedor : listaContratoProveedor) {
            listaContratoProveedorVo.add(new ContratoProveedorVO(unContratoProveedor));
        }
        return listaContratoProveedorVo;
    }
}

