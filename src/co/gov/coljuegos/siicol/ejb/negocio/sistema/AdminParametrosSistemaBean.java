package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ParametrosSistemaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiParametrosSistema;
import co.gov.coljuegos.siicol.ejb.vo.ParametrosSistemaVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminParametrosSistemaBean implements AdminParametrosSistema{
    
    @EJB
    private ParametrosSistemaDAO parametrosSistemaDAO;
    
    public AdminParametrosSistemaBean() {
    }
    
    public ParametrosSistemaVO buscarParametroPorId(String Id) throws ExcepcionDAO{
        ParametrosSistemaVO resultado = null;
        SiiParametrosSistema siiParametrosSistema = parametrosSistemaDAO.buscarParametroPorId(Id);
        if (siiParametrosSistema!=null)
            resultado = new ParametrosSistemaVO(siiParametrosSistema);
        
        return (resultado);
    }
    
    public String buscarCadenaParametroPorId(String Id){
        String result = "";
        try{
            SiiParametrosSistema siiParametrosSistema = parametrosSistemaDAO.buscarParametroPorId(Id);
            if(siiParametrosSistema != null && siiParametrosSistema.getPsiValor() != null){
                result = siiParametrosSistema.getPsiValor();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
