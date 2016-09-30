package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoPruebaIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPruebaIleg;
import co.gov.coljuegos.siicol.ejb.vo.TipoPruebaIlegVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Tipos de Prueba para el Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminTipoPruebaIlegBean implements AdminTipoPruebaIleg 
{
    @EJB
    private TipoPruebaIlegDAO tipoPruebaIlegDao;
    
    
    /**
     * Constructor.
     */
    public AdminTipoPruebaIlegBean() {
        super();
    }
    
    
    @Override
    public TipoPruebaIlegVO buscarTipoPruebaIlegPorId (Long tpiCodigo) throws ExcepcionDAO 
    {
        TipoPruebaIlegVO resultado = null;
        SiiTipoPruebaIleg siiTipoPruebaIleg = tipoPruebaIlegDao.buscarPorCodigo(tpiCodigo);
        if (siiTipoPruebaIleg!=null)
            resultado = new TipoPruebaIlegVO(siiTipoPruebaIleg);
        
        return (resultado);
    }
    
    
    @Override
    public List<TipoPruebaIlegVO> buscarTodoTipoPruebaIleg() throws ExcepcionDAO 
    {
        List<TipoPruebaIlegVO> resultado = null;
        List<SiiTipoPruebaIleg> lista = tipoPruebaIlegDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<TipoPruebaIlegVO>();
            
            for (SiiTipoPruebaIleg siiTipoPruebaIleg: lista) {
                if (siiTipoPruebaIleg!=null)
                    resultado.add(new TipoPruebaIlegVO(siiTipoPruebaIleg));
            }
        }
        
        return (resultado);
    }
}
