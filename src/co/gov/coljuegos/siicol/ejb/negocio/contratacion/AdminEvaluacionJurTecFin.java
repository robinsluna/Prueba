/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EvaluacionJurTecFinVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de Evaluaci&oacute;n Jur&iacute;dica, T&eacute;cnica y Financiera.
 * @author Camilo Miranda
 */
@Local
public interface AdminEvaluacionJurTecFin {
    public EvaluacionJurTecFinVO buscarPorCodigoEvaluacionJurTecFin(Long idEvaluacionJurTecFin) throws ExcepcionDAO;

    public EvaluacionJurTecFinVO insertarSiiEvaluacionJurTecFin(EvaluacionJurTecFinVO evaluacionJurTecFinVO) throws ExcepcionDAO;

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
                                                                                                    ExcepcionAplicacion;

    public void borrarSiiEvaluacionJurTecFin(Long idEvaluacionJurTecFin) throws ExcepcionDAO;

    public List<EvaluacionJurTecFinVO> buscarTodaEvaluacionJurTecFin() throws ExcepcionDAO;

    public List<EvaluacionJurTecFinVO> buscarPorCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO;
}
