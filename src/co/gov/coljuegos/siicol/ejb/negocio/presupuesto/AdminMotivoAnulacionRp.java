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

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminMotivoAnulacionRp {

    public MotivoAnulRpVO insertarMotivoAnulacionRp(MotivoAnulRpVO motivoAnulRpVo) throws ExcepcionDAO;
    
    public MotivoAnulRpVO buscarPorCodigoMotivoAnulRp(MotivoAnulRpVO motivoAnulVo) throws ExcepcionDAO;    
    
    public MotivoAnulRpVO actualizarSiiMotivoAnulRp(MotivoAnulRpVO motivoVo) throws ExcepcionDAO;
    
    public List<MotivoAnulRpVO> buscarTodoMotivoAnulacion() throws ExcepcionDAO;
    
    public void borrarMotivoAnulacionRp(MotivoAnulRpVO motivoAnulVo) throws ExcepcionDAO;
}


