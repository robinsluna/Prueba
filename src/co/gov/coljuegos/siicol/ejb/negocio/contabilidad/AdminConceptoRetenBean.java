package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoRetenDAO;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoReten;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoRetenVO;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminConceptoRetenBean implements AdminConceptoReten{
    @EJB
    private ConceptoRetenDAO conceptoRetenDao;
    public AdminConceptoRetenBean() {
        //super();
    }
    
    public List<ConceptoRetenVO> buscarTodoConceptoReten() throws ExcepcionDAO{
            List<ConceptoRetenVO> listaConceptoRetenVo = new ArrayList<ConceptoRetenVO>();
            List<SiiConceptoReten> listaSiiConceptoReten = new ArrayList <SiiConceptoReten>();
            
            listaSiiConceptoReten = conceptoRetenDao.buscarTodo();
            if (listaSiiConceptoReten != null){
                for (SiiConceptoReten siiConceptoReten :listaSiiConceptoReten){
                    if (siiConceptoReten != null){
                        listaConceptoRetenVo.add(new ConceptoRetenVO(siiConceptoReten));
                    }
                }
            }
            return listaConceptoRetenVo;
        }
    
    public ConceptoRetenVO buscarConceptoRetenPorCodigo(Long idConceptoReten) throws ExcepcionDAO{
        SiiConceptoReten siiConceptoReten = new SiiConceptoReten();                
        siiConceptoReten = conceptoRetenDao.buscarPorCodigo(idConceptoReten);
        
        return new ConceptoRetenVO (siiConceptoReten);
    }
}


/*
 *     
    
   
 */