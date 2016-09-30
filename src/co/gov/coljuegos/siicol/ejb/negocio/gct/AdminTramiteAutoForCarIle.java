package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.TramiteAutoForCarIleVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Tr&aacute;mites del Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminTramiteAutoForCarIle 
{
    public TramiteAutoForCarIleVO buscarElementoAutoFormCarIlePorId (Long tafCodigo) throws ExcepcionDAO;
    public List<TramiteAutoForCarIleVO> buscarElementoAutoFormCarIlePorIdAutoFormCargProIle (Long afcCodigo) throws ExcepcionDAO;
}
