package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoGastoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoGasto;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoGastoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminConceptoGastoBean implements AdminConceptoGasto{
    
    @EJB
    ConceptoGastoDAO conceptoGastoDao;   
    
    public AdminConceptoGastoBean() {
        
    }

    public List<ConceptoGastoVO> buscarTodoConceptoGasto() throws ExcepcionDAO {
        List<SiiConceptoGasto> siConceptos = conceptoGastoDao.buscarTodoConceptoGasto();
        List<ConceptoGastoVO> conceptosVo = new ArrayList();
        for (SiiConceptoGasto concepto : siConceptos){
            conceptosVo.add(new ConceptoGastoVO(concepto));
        }
        return  conceptosVo; 
    }
}
