package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResultadoVerifDenunDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoVerifDenun;
import co.gov.coljuegos.siicol.ejb.vo.ResultadoVerifDenunVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminResultadoVerifDenunBean implements AdminResultadoVerifDenun {
    
    
    public AdminResultadoVerifDenunBean() {
        super();
    }
    
    @EJB
    private ResultadoVerifDenunDAO resultadoVerifDenunDao;
        

    @Override
    public List<ResultadoVerifDenunVO> buscartodos() throws Exception{
        
        List<ResultadoVerifDenunVO> list = new ArrayList<ResultadoVerifDenunVO>();
        List<SiiResultadoVerifDenun> listSii = resultadoVerifDenunDao.buscarTodo();
        
        for(SiiResultadoVerifDenun unSiiresult : listSii){
            
            ResultadoVerifDenunVO resultadoVO = new ResultadoVerifDenunVO(unSiiresult);
            list.add(resultadoVO);
        }
        return list;
    }

    
}
