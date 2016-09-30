/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioAdjudica;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.OficioAdjudicaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminOficioAdjudicaBean implements AdminOficioAdjudica {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private OficioAdjudicaDAO oficioAdjudicaDAO;
    @EJB
    private ProcesoContratacionDAO procesoContratacionDao;


    /**
     * Constructor.
     */
    public AdminOficioAdjudicaBean() {
    }


    /**
     * Almacena los padres asociados al Oficio de Adjudicaci&oacute;n.
     * @param oficioAdjudicaVO
     * @throws ExcepcionDAO
     */
    private void almacenarPadres(OficioAdjudicaVO oficioAdjudicaVO) throws ExcepcionDAO {
        if (oficioAdjudicaVO != null) {
            if (oficioAdjudicaVO.getProcesoContratacion() != null) {
                this.almacenarProcesoContratacion(oficioAdjudicaVO.getProcesoContratacion());
            }
        }
    }


    /**
     * Persiste el Proceso de Contrataci&oacute;n.
     * @param procesoContratacionVO
     * @throws ExcepcionDAO
     */
    private void almacenarProcesoContratacion(ProcesoContratacionVO procesoContratacionVO) throws ExcepcionDAO {
        if (procesoContratacionVO != null) {

            if (procesoContratacionVO.getPrcCodigo() ==
                null) {
                // OPERACION INSERTAR
                SiiProcesoContratacion siiProcesoContratacion =
                                      procesoContratacionDao.insertarProcesoContratacion(conversionVoEntidad.convertir(procesoContratacionVO));
                procesoContratacionVO.setPrcCodigo(siiProcesoContratacion.getPrcCodigo());
            } else {
                // OPERACION ACTUALIZAR
                procesoContratacionDao.actualizarProcesoContratacion(conversionVoEntidad.convertir(procesoContratacionVO));
            }
        }
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO#buscarPorCodigo(java.lang.Long)
     */
    public OficioAdjudicaVO buscarPorCodigoOficioAdjudica(Long idOficioAdjudica) throws ExcepcionDAO {
        SiiOficioAdjudica siiOficioAdjudica = oficioAdjudicaDAO.buscarPorCodigo(idOficioAdjudica);
        return (new OficioAdjudicaVO(siiOficioAdjudica));
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO#insertar(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioAdjudica)
     */
    public OficioAdjudicaVO insertarSiiOficioAdjudica(OficioAdjudicaVO oficioAdjudicaVO) throws ExcepcionDAO {
        // persiste las entidades Padre
        this.almacenarPadres(oficioAdjudicaVO);

        SiiOficioAdjudica siiOficioAdjudica =
            oficioAdjudicaDAO.insertar(conversionVoEntidad.convertir(oficioAdjudicaVO));
        oficioAdjudicaVO.setOadCodigo(siiOficioAdjudica.getOadCodigo());
        return (new OficioAdjudicaVO(siiOficioAdjudica));
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO#actualizar(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioAdjudica)
     */
    public OficioAdjudicaVO actualizarSiiOficioAdjudica(OficioAdjudicaVO oficioAdjudicaVO) throws ExcepcionDAO {
        // persiste las entidades Padre
        this.almacenarPadres(oficioAdjudicaVO);

        SiiOficioAdjudica siiOficioAdjudica =
            oficioAdjudicaDAO.actualizar(conversionVoEntidad.convertir(oficioAdjudicaVO));
        return (new OficioAdjudicaVO(siiOficioAdjudica));
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO#buscarPorCodigo(java.lang.Long)
     */
    public void borrarSiiOficioAdjudica(Long idOficioAdjudica) throws ExcepcionDAO {
        oficioAdjudicaDAO.eliminar(idOficioAdjudica);
    }


    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO#buscarTodo()
     */
    public List<OficioAdjudicaVO> buscarTodoOficioAdjudica() throws ExcepcionDAO {
        List<OficioAdjudicaVO> listaOficioAdjudica = null;

        List<SiiOficioAdjudica> lista = oficioAdjudicaDAO.buscarTodo();
        if (lista != null) {
            listaOficioAdjudica = new ArrayList<OficioAdjudicaVO>();
            for (SiiOficioAdjudica siiOficioAdjudica : lista) {
                listaOficioAdjudica.add(new OficioAdjudicaVO(siiOficioAdjudica));
            }
        }

        return (listaOficioAdjudica);
    }

    /**
     * @author Giovanni
     * @param prcCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public OficioAdjudicaVO buscarOficioAdjudicaXCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        SiiOficioAdjudica siiOficioAdjudica = new SiiOficioAdjudica();
        siiOficioAdjudica = oficioAdjudicaDAO.buscarOficioAdjudicaXCodigoProcesoContratacion(prcCodigo);
        OficioAdjudicaVO oficioAdjudicaVO = new OficioAdjudicaVO(siiOficioAdjudica);
        return oficioAdjudicaVO;
    }


    /*
        * (non-Javadoc)
        * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO#buscarPorCodigo(java.lang.Long)
        */
    public List<OficioAdjudicaVO> buscarPorCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        List<OficioAdjudicaVO> listaOficioAdjudica = null;

        List<SiiOficioAdjudica> lista = oficioAdjudicaDAO.buscarPorCodigoProcesoContratacion(prcCodigo);
        if (lista != null) {
            listaOficioAdjudica = new ArrayList<OficioAdjudicaVO>();
            for (SiiOficioAdjudica siiOficioAdjudica : lista) {
                listaOficioAdjudica.add(new OficioAdjudicaVO(siiOficioAdjudica));
            }
        }

        return (listaOficioAdjudica);
    }


    public Long consultarConsecutivoMinuta() throws ExcepcionDAO {
        return oficioAdjudicaDAO.consultarConsecutivoMinuta();
    }
    
    /**
     * @author Giovanni
     * @param oadConsecContr
     * @return 
     * @throws ExcepcionDAO
     */
    public boolean consultarConsecContr(Integer oadConsecContr, Integer oadVigencia) throws ExcepcionDAO {
        boolean estaConsecContr = false;
        estaConsecContr = oficioAdjudicaDAO.consultarConsecContr(oadConsecContr, oadVigencia);
        return estaConsecContr;
    }
}
