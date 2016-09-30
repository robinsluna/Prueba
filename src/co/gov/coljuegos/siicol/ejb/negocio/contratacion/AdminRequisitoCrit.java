package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RequisitoCritVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminRequisitoCrit {
    public RequisitoCritVO buscarRequisitoCritPorId(Long  idRequisito) throws ExcepcionDAO;        
    public RequisitoCritVO insertarRequisitoCrit(RequisitoCritVO requisitoCritVo) throws ExcepcionDAO;
    public RequisitoCritVO actualizarRequisitoCrit(RequisitoCritVO requisitoCritVo) throws ExcepcionDAO;
    public List<RequisitoCritVO> buscarTodosRequisitoCrit() throws ExcepcionDAO;
    public List<RequisitoCritVO> buscarRequisitoCritPorTipo(String tipoRequisito) throws ExcepcionDAO;
    public List<RequisitoCritVO> buscarRequisitoCriPorIdEstudioPrevio (Integer idEstudioPrevio) throws ExcepcionDAO;
}
