/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 26-03-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoNominaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Conceptos de N&oacute;mina.
 * @author Camilo Miranda
 */
@Local
public interface AdminConceptoNomina 
{
    /**
     * Realiza la b&uacute;squeda de un Concepto de N&oacute;mina por c&oacute;digo.
     * @param cnoCodigo - C&oacute;digo del Concepto de N&oacute;mina.
     * @return instance of ConceptoNominaVO.
     * @throws ExcepcionDAO
     */
    public ConceptoNominaVO buscarConceptoNominaPorCodigo (String cnoCodigo) throws ExcepcionDAO;
    
    
    /**
     * Realiza la inserci&oacute;n de un registro de Concepto de N&oacute;mina.
     * @param conceptoNominaVo - Concepto de N&oacute;mina.
     * @return instance of ConceptoNominaVO.
     * @throws ExcepcionDAO
     */
    public ConceptoNominaVO insertarConceptoNomina (ConceptoNominaVO conceptoNominaVo) throws ExcepcionDAO;
    
    
    /**
     * Realiza la actualizaci&oacute;n de un registro de Concepto de N&oacute;mina.
     * @param conceptoNominaVo - Concepto de N&oacute;mina.
     * @return instance of ConceptoNominaVO.
     * @throws ExcepcionDAO
     */
    public ConceptoNominaVO actualizarConceptoNomina (ConceptoNominaVO conceptoNominaVo) throws ExcepcionDAO;
    
    
    /**
     * Realiza la eliminaci&oacute;n de un registro de Concepto de N&oacute;mina.
     * @param cnoCodigo - C&oacute;digo del Concepto de N&oacute;mina.
     * @throws ExcepcionDAO
     */
    public void eliminarConceptoNomina (String cnoCodigo) throws ExcepcionDAO;
    
    
    /**
     * Realiza la b&uacute;squeda de todos los Conceptos de N&oacute;mina.
     * @return List of ConceptoNominaVO.
     * @throws ExcepcionDAO
     */
    public List<ConceptoNominaVO> buscarTodoConceptoNomina () throws ExcepcionDAO;
    
    
    /**
     * Realiza la b&uacute;squeda los Conceptos de N&oacute;mina que se encuentren <i>ACTIVOS</i> en el sistema.
     * @return List of ConceptoNominaVO.
     * @throws ExcepcionDAO
     */
    public List<ConceptoNominaVO> buscarConceptoNominaActivos () throws ExcepcionDAO;
    
    
    /**
     * Valida si el Concepto N&oacute;mina se encuentra asociado a un Comprobante Contable.
     * @param cnoCodigo - C&oacute;digo del Concepto N&oacute;mina.
     * @return Se encuentra asociado a un Comprobante Contable activo?
     * @throws ExcepcionDAO
     */
    public boolean isConceptoNominaAsociadoDocumentoContable(String cnoCodigo) throws ExcepcionDAO;
}
