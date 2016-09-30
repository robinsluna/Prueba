package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import java.util.Date;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de D&iacute;as Festivos.
 * @author Camilo Miranda
 */
@Local
public interface AdminFestivo 
{
    public Date buscarFestivo (Date pFecha) throws ExcepcionDAO;
    public int diasFestivosEntre(Date fechaInicial, Date fechaFinal) throws ExcepcionDAO;
}
