package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RequisitosPolizaPolDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResultadoResDecDesDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcesoSanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoResDecDes;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcesoSancVO;
import co.gov.coljuegos.siicol.ejb.vo.ResultadoResDecDesVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminResultadoResDecDesBean implements AdminResultadoResDecDes {
    
    @EJB
    private ResultadoResDecDesDAO resultadoResDecDesDAO;
    
    /**
     * Constructor.
     */
    public AdminResultadoResDecDesBean() {
        super();
    }
    
    @Override
    public List<ResultadoResDecDesVO> buscarTodos() throws ExcepcionDAO{
        
        List<ResultadoResDecDesVO> resultado = null;
        List<SiiResultadoResDecDes> lista = resultadoResDecDesDAO.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<ResultadoResDecDesVO>();
            for (SiiResultadoResDecDes sii: lista) {
                if (sii!=null)
                    resultado.add(new ResultadoResDecDesVO(sii));
            }
        }
        
        return (resultado);
    }
    
    

    
}
