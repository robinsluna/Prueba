/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Contratacion
 * AUTOR	: Orlando Rodriguez Bayona
 * FECHA	: 25-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.FuncionVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;

import java.util.List;

import javax.ejb.Local;

@Local

public interface AdminFuncion {
    public FuncionVO buscarFuncionPorId(Long idFuncion) throws ExcepcionDAO;
    public List<FuncionVO> buscarTodoFuncion() throws ExcepcionDAO;
    public List<PersonaVO> buscarFuncionarioPorFuncion(String funcion) throws ExcepcionDAO;
}

    