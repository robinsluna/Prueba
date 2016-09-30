/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 20-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.OficioAdjudicaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de Oficio de Adjudicaci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminOficioAdjudica {
    public OficioAdjudicaVO buscarPorCodigoOficioAdjudica(Long idOficioAdjudica) throws ExcepcionDAO;

    public OficioAdjudicaVO insertarSiiOficioAdjudica(OficioAdjudicaVO oficioAdjudicaVO) throws ExcepcionDAO;

    public OficioAdjudicaVO actualizarSiiOficioAdjudica(OficioAdjudicaVO oficioAdjudicaVO) throws ExcepcionDAO;

    public void borrarSiiOficioAdjudica(Long idOficioAdjudica) throws ExcepcionDAO;

    public List<OficioAdjudicaVO> buscarTodoOficioAdjudica() throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @param prcCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public OficioAdjudicaVO buscarOficioAdjudicaXCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO;

    /*
        * (non-Javadoc)
        * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioAdjudicaDAO#buscarPorCodigo(java.lang.Long)
        */
    public List<OficioAdjudicaVO> buscarPorCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO;

    public Long consultarConsecutivoMinuta() throws ExcepcionDAO;
    
    /**
     * @author Giovanni
     * @param oadConsecContr
     * @return 
     * @throws ExcepcionDAO
     */
    public boolean consultarConsecContr(Integer oadConsecContr, Integer oadVigencia) throws ExcepcionDAO;
}
