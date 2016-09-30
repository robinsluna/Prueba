/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EvaluacionJurTecFinDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaEvaluacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEvaluacionJurTecFin;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaEvaluacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EvaluacionJurTecFinVO;
import co.gov.coljuegos.siicol.ejb.vo.PropuestaEvaluacionVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminEvaluacionJurTecFinBean implements AdminEvaluacionJurTecFin {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private EvaluacionJurTecFinDAO evaluacionJurTecFinDAO;
    @EJB
    private PropuestaEvaluacionDAO propuestaEvaluacionDAO;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    /**
     * Constructor.
     */
    public AdminEvaluacionJurTecFinBean() {
        super();
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EvaluacionJurTecFinDAO#buscarPorCodigo(java.lang.Long)
     */
    public EvaluacionJurTecFinVO buscarPorCodigoEvaluacionJurTecFin(Long idEvaluacionJurTecFin) throws ExcepcionDAO {
        SiiEvaluacionJurTecFin ejtf = evaluacionJurTecFinDAO.buscarPorCodigo(idEvaluacionJurTecFin);
        return (new EvaluacionJurTecFinVO(ejtf));
    }


    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de las Propuestas de Evaluaci&oacute;n asociadas a la Evaluaci&oacute;n.
     * @param ejtf - Entidad Evaluaci&oacute;n.
     * @param propuestaEvaluacionList - Listado de propuestas de Evaluaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirPropuestasEvaluacion(SiiEvaluacionJurTecFin ejtf,
                                               List<PropuestaEvaluacionVO> propuestaEvaluacionList) throws ExcepcionDAO {
        if (propuestaEvaluacionList != null) {
            for (PropuestaEvaluacionVO peVO : propuestaEvaluacionList) {
                peVO.setEvaluacionJurTecFin(new EvaluacionJurTecFinVO(ejtf));
                SiiPropuestaEvaluacion siiPEv = conversionVoEntidad.convertir(peVO);
                if (siiPEv != null) {
                    siiPEv.setSiiEvaluacionJurTecFin(ejtf);
                    if (siiPEv.getPevCodigo() == null) {
                        // OPERACION INSERTAR
                        propuestaEvaluacionDAO.insertarSiiPropuestaEvaluacion(siiPEv);
                    } else {
                        // OPERACION ACTUALIZAR
                        propuestaEvaluacionDAO.actualizarSiiPropuestaEvaluacion(siiPEv);
                    }
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EvaluacionJurTecFinDAO#insertar(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEvaluacionJurTecFin)
     */
    public EvaluacionJurTecFinVO insertarSiiEvaluacionJurTecFin(EvaluacionJurTecFinVO evaluacionJurTecFinVO) throws ExcepcionDAO {
        SiiEvaluacionJurTecFin ejtf =
            evaluacionJurTecFinDAO.insertar(conversionVoEntidad.convertir(evaluacionJurTecFinVO));

        //////////////////////////////
        // PROPUESTAS DE EVALUACION //
        //////////////////////////////
        List<PropuestaEvaluacionVO> propuestaEvaluacionList = evaluacionJurTecFinVO.getPropuestaEvaluacionList();
        this.persistirPropuestasEvaluacion(ejtf, propuestaEvaluacionList);


        return (new EvaluacionJurTecFinVO(ejtf));
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EvaluacionJurTecFinDAO#actualizar(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEvaluacionJurTecFin)
     */
    /**
     * @author Modifica Giovanni
     * @param evaluacionJurTecFinVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public EvaluacionJurTecFinVO actualizarSiiEvaluacionJurTecFin(EvaluacionJurTecFinVO evaluacionJurTecFinVO,
                                                                  UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                    ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiEvaluacionJurTecFin siiEvaluacionJurTecFin = new SiiEvaluacionJurTecFin();
        siiEvaluacionJurTecFin = evaluacionJurTecFinDAO.buscarPorCodigo(evaluacionJurTecFinVO.getEjtCodigo());
        if (siiEvaluacionJurTecFin.getSiiEstadoEvaluacionJtf().getEejCodigo() !=
            evaluacionJurTecFinVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la evaluacion fue cambiado durante la modificación. Seleccione nuevamente la evaluacion");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (evaluacionJurTecFinVO.getEstadoEvaluacionJtf().getEejCodigo() !=
            evaluacionJurTecFinVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.EVALUACION_JTF.getId(),
                                                         evaluacionJurTecFinVO.getEstadoEvaluacionJtf().getEejCodigo(),
                                                         usuarioLogueado, evaluacionJurTecFinVO.getEjtCodigo());
        }

        SiiEvaluacionJurTecFin ejtf =
            evaluacionJurTecFinDAO.actualizar(conversionVoEntidad.convertir(evaluacionJurTecFinVO));

        //////////////////////////////
        // PROPUESTAS DE EVALUACION //
        //////////////////////////////
        List<PropuestaEvaluacionVO> propuestaEvaluacionList = evaluacionJurTecFinVO.getPropuestaEvaluacionList();
        this.persistirPropuestasEvaluacion(ejtf, propuestaEvaluacionList);

        return (new EvaluacionJurTecFinVO(ejtf));
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EvaluacionJurTecFinDAO#buscarPorCodigo(java.lang.Long)
     */
    public void borrarSiiEvaluacionJurTecFin(Long idEvaluacionJurTecFin) throws ExcepcionDAO {
        evaluacionJurTecFinDAO.eliminar(idEvaluacionJurTecFin);
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EvaluacionJurTecFinDAO#buscarTodo()
     */
    public List<EvaluacionJurTecFinVO> buscarTodaEvaluacionJurTecFin() throws ExcepcionDAO {
        List<EvaluacionJurTecFinVO> listaEvaluacionJurTecFinVO = null;

        List<SiiEvaluacionJurTecFin> lista = evaluacionJurTecFinDAO.buscarTodo();
        if (lista != null) {
            listaEvaluacionJurTecFinVO = new ArrayList<EvaluacionJurTecFinVO>();
            for (SiiEvaluacionJurTecFin siiEvaluacionJurTecFin : lista) {
                listaEvaluacionJurTecFinVO.add(new EvaluacionJurTecFinVO(siiEvaluacionJurTecFin));
            }
        }
        return listaEvaluacionJurTecFinVO;
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.EvaluacionJurTecFinDAO#buscarPorCodigoProcesoContratacion(java.lang.Long)
     */
    public List<EvaluacionJurTecFinVO> buscarPorCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        List<EvaluacionJurTecFinVO> listaEvaluacionJurTecFinVO = null;

        List<SiiEvaluacionJurTecFin> lista = evaluacionJurTecFinDAO.buscarPorCodigoProcesoContratacion(prcCodigo);
        if (lista != null) {
            listaEvaluacionJurTecFinVO = new ArrayList<EvaluacionJurTecFinVO>();
            for (SiiEvaluacionJurTecFin siiEvaluacionJurTecFin : lista) {
                listaEvaluacionJurTecFinVO.add(new EvaluacionJurTecFinVO(siiEvaluacionJurTecFin));
            }
        }
        return listaEvaluacionJurTecFinVO;
    }

}
