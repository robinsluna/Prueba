/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 20-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminDetFuenteFinanciacion {

    public DetFuenteFinanciacionVO insertarDtlleFuenteFinanciacion(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO;

    public DetFuenteFinanciacionVO buscarDtlleFuenteFinanciacionPorId(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO;

    public DetFuenteFinanciacionVO buscarDtlleFuenteFinanciacionPorId(Long dffCodigo) throws ExcepcionDAO;

    public DetFuenteFinanciacionVO buscarCodDetFuenteFinanciacionPorNombre(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO;

    public DetFuenteFinanciacionVO actualizarDtlleFuenteFinanciacion(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO;

    public void eliminarDtlleFuenteFinanciacion(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO;

    public List<DetFuenteFinanciacionVO> buscarTodoDetalleFuentePorFuenteFin(FuenteFinanciacionVO fuenteFinanciacionVo) throws ExcepcionDAO;

    public DetFuenteFinanciacionVO buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre(String nombreFuente,
                                                                                          String nombreDetFuente) throws ExcepcionDAO;

    public DetFuenteFinanciacionVO buscarCodDetFuenteFinanciacionPorCodigoFuenteCodigoRecurso(Integer codigoFuente,
                                                                                              Integer codigoRecurso) throws ExcepcionDAO;

}


