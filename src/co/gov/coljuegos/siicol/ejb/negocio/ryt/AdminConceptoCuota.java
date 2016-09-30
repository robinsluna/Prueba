/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-08-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ConceptoCuotaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface Local para el manejo de Conceptos Cuota.
 * @author Camilo Miranda
 */
@Local
public interface AdminConceptoCuota 
{
    public ConceptoCuotaVO buscarConceptoCuotaXId(Long idConceptoCuota) throws ExcepcionDAO;
    public List<ConceptoCuotaVO> buscarTodoConceptoCuota() throws ExcepcionDAO;
    public List<ConceptoCuotaVO> buscarConceptoCuotaPorModalidades(String modalidad1, String modalidad2, String modalidad3) throws ExcepcionDAO;
    public List<ConceptoCuotaVO> buscarTodoSiiConceptoCuotaXCategoria(String  cadNombre) throws ExcepcionDAO ;
    public List<ConceptoCuotaVO> buscarTodoSiiConceptoCuotaXNombre(String  ccuNombre) throws ExcepcionDAO ;
    public List<ConceptoCuotaVO> buscarTodoSiiConceptoCuotaXAbreviatura(String  ccuAbreviatura) throws ExcepcionDAO;
}
