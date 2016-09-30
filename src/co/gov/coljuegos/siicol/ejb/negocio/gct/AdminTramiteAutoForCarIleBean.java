package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteAutoForCarIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteAutoForCarIle;
import co.gov.coljuegos.siicol.ejb.vo.TramiteAutoForCarIleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Tr&aacute;mites del Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminTramiteAutoForCarIleBean implements AdminTramiteAutoForCarIle 
{
    @EJB
    private TramiteAutoForCarIleDAO tramiteAutoForCarIleDao;
    
    
    /**
     * Constructor.
     */
    public AdminTramiteAutoForCarIleBean() { }
    
    
    
    @Override
    public TramiteAutoForCarIleVO buscarElementoAutoFormCarIlePorId(Long tafCodigo) throws ExcepcionDAO 
    {
        TramiteAutoForCarIleVO resultado = null;
        SiiTramiteAutoForCarIle siiTramiteAutoForCarIle = tramiteAutoForCarIleDao.buscarPorCodigo(tafCodigo);
        if (siiTramiteAutoForCarIle!=null)
            resultado = new TramiteAutoForCarIleVO(siiTramiteAutoForCarIle);
        
        return (resultado);
    }
    
    
    @Override
    public List<TramiteAutoForCarIleVO> buscarElementoAutoFormCarIlePorIdAutoFormCargProIle(Long afcCodigo) throws ExcepcionDAO 
    {
        List<TramiteAutoForCarIleVO> resultado = null;
        List<SiiTramiteAutoForCarIle> lista = tramiteAutoForCarIleDao.buscarElementoAutoFormCarIlePorIdAutoFormCargProIle(afcCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TramiteAutoForCarIleVO>();
            
            for (SiiTramiteAutoForCarIle siiTramiteAutoForCarIle: lista) {
                if (siiTramiteAutoForCarIle!=null)
                    resultado.add(new TramiteAutoForCarIleVO(siiTramiteAutoForCarIle));
            }
        }
        
        return (resultado);
    }
}
