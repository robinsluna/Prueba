package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaInvProIleAutoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvProIleAuto;
import co.gov.coljuegos.siicol.ejb.vo.PersonaInvProIleAutoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Personas Investigadas del Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminPersonaInvProIleAutoBean implements AdminPersonaInvProIleAuto 
{
    @EJB
    private PersonaInvProIleAutoDAO personaInvProIleAutoDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminPersonaInvProIleAutoBean() { }
    
    

    @Override
    public PersonaInvProIleAutoVO buscarElementoAutoFormCarIlePorId(Long piaCodigo) throws ExcepcionDAO 
    {
        PersonaInvProIleAutoVO resultado = null;
        SiiPersonaInvProIleAuto siiPersonaInvProIleAuto = personaInvProIleAutoDao.buscarPorCodigo(piaCodigo);
        if (siiPersonaInvProIleAuto!=null)
            resultado = new PersonaInvProIleAutoVO(siiPersonaInvProIleAuto);
        
        return (resultado);
    }
    
    
    @Override
    public List<PersonaInvProIleAutoVO> buscarElementoAutoFormCarIlePorIdAutoFormCargProIle(Long afcCodigo) throws ExcepcionDAO 
    {
        List<PersonaInvProIleAutoVO> resultado = null;
        List<SiiPersonaInvProIleAuto> lista = personaInvProIleAutoDao.buscarElementoAutoFormCarIlePorIdAutoFormCargProIle(afcCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<PersonaInvProIleAutoVO>();
            
            for (SiiPersonaInvProIleAuto siiPersonaInvProIleAuto: lista) {
                if (siiPersonaInvProIleAuto!=null)
                    resultado.add(new PersonaInvProIleAutoVO(siiPersonaInvProIleAuto));
            }
        }
        
        return (resultado);
    }
}
