package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.FestivoDAO;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de D&iacute;as Festivos.
 * @author Camilo Miranda
 */
@Stateless
public class AdminFestivoBean implements AdminFestivo 
{
    @EJB
    private FestivoDAO festivoDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminFestivoBean() { }
    
    
    @Override
    public Date buscarFestivo(Date pFecha) throws ExcepcionDAO {
        return ( festivoDao.buscarSiiFestivo(pFecha) );
    }
    
    
    @Override
    public int diasFestivosEntre(Date fechaInicial, Date fechaFinal) throws ExcepcionDAO {
        return ( festivoDao.diasFestivosEntre(fechaInicial, fechaFinal) );
    }
}
