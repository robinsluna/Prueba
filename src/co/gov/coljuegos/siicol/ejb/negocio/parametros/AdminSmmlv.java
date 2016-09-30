package co.gov.coljuegos.siicol.ejb.negocio.parametros;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.SmmlvVO;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo del Salario M&iacute;nimo Mensual Legal Vigente.
 * @author Camilo Miranda
 */
@Local
public interface AdminSmmlv 
{
    public Long buscarSmmlvPorVigencia (Integer vigencia) throws ExcepcionDAO;
    public SmmlvVO buscarSmmlvPorId(Integer vigencia) throws ExcepcionDAO;
}
