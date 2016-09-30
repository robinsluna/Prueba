package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RequisitosPolizaPolDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaRequisitosPol;
import co.gov.coljuegos.siicol.ejb.vo.PolizaRequisitosPolVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRequisitosPolizaPolBean implements AdminRequisitosPolizaPol {
    @EJB
    private RequisitosPolizaPolDAO requisitosPolizaPolDao;

    public List<PolizaRequisitosPolVO> buscarRequisitosPorPolizaContrat(Long pccCodigo) throws ExcepcionDAO {
        List<SiiPolizaRequisitosPol> requisitos = new ArrayList<SiiPolizaRequisitosPol>();
        List<PolizaRequisitosPolVO> requisitosVo = new ArrayList<PolizaRequisitosPolVO>();
        requisitos = requisitosPolizaPolDao.buscarRequisitosPorPolizaContrat(pccCodigo);
        for (SiiPolizaRequisitosPol requisito : requisitos) {
            requisitosVo.add(new PolizaRequisitosPolVO(requisito));
        }
        return requisitosVo;
    }
}
