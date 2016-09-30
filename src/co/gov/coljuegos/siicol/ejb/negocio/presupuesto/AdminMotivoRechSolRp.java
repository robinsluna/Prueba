/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 19-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;

import co.gov.coljuegos.siicol.ejb.vo.MotivoAnulRpVO;

import co.gov.coljuegos.siicol.ejb.vo.MotivoRechSolRpVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminMotivoRechSolRp {

    public MotivoRechSolRpVO insertarSiiMotivoRechSolRp(MotivoRechSolRpVO MotivoRechSolRpVO) throws ExcepcionDAO;
    
    public MotivoRechSolRpVO buscarPorCodigoMotivoRechSolRp(Long idCodigoMotivo) throws ExcepcionDAO;    
    
    public MotivoRechSolRpVO actualizarSiiMotivoRechSolRp(MotivoRechSolRpVO MotivoRechSolRpVO) throws ExcepcionDAO;
    
    public List<MotivoRechSolRpVO> buscarTodoSiiMotivoRechSolRp() throws ExcepcionDAO;
    
    public void borrarSiiMotivoRechSolRp(MotivoRechSolRpVO MotivoRechSolRpVO) throws ExcepcionDAO;
}


