package co.gov.coljuegos.siicol.ejb.negocio.parametros;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SmmlvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSmmlv;
import co.gov.coljuegos.siicol.ejb.vo.SmmlvVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo del Salario M&iacute;nimo Mensual Legal Vigente.
 * @author Camilo Miranda
 */
@Stateless
public class AdminSmmlvBean implements AdminSmmlv 
{
    @EJB
    private SmmlvDAO smmlvDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminSmmlvBean() {
        super();
    }
    
    
    @Override
    public Long buscarSmmlvPorVigencia(Integer vigencia) throws ExcepcionDAO {
        return ( smmlvDao.buscarSmmlvPorVigencia(vigencia) );
    }
    
    
    @Override
    public SmmlvVO buscarSmmlvPorId(Integer vigencia) throws ExcepcionDAO 
    {
        SmmlvVO resultado = null;
        SiiSmmlv siiSmmlv = smmlvDao.buscarSmmlvPorId(vigencia);
        if (siiSmmlv!=null)
            resultado = new SmmlvVO(siiSmmlv);
            
        return (resultado);
    }
}
