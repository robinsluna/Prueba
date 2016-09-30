package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.PersonaInvProIleAutoVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Personas Investigadas del Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminPersonaInvProIleAuto 
{
    public PersonaInvProIleAutoVO buscarElementoAutoFormCarIlePorId (Long piaCodigo) throws ExcepcionDAO;
    public List<PersonaInvProIleAutoVO> buscarElementoAutoFormCarIlePorIdAutoFormCargProIle (Long afcCodigo) throws ExcepcionDAO;
}
