package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaAtiendeAccDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaAtiendeAcc;
import co.gov.coljuegos.siicol.ejb.vo.PersonaAtiendeAccVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminPersonaAtiendeAccBean implements AdminPersonaAtiendeAcc {
    @EJB
    private PersonaAtiendeAccDAO personaAtiendeAccDao;

    public AdminPersonaAtiendeAccBean() {

    }


    public List<PersonaAtiendeAccVO> buscarPersonaAtiendePorAccionControl(Long accCodigo) throws ExcepcionDAO {
        List<PersonaAtiendeAccVO> personasVo = new ArrayList<PersonaAtiendeAccVO>();
        for (SiiPersonaAtiendeAcc persona :personaAtiendeAccDao.buscarPersonaAtiendePorAccionControl(accCodigo)) {
            personasVo.add(new PersonaAtiendeAccVO(persona));
        }
        return personasVo;
    }


    public PersonaAtiendeAccVO buscarPersonaPorCodigo(Long peaCodigo) throws ExcepcionDAO {
        
        return new PersonaAtiendeAccVO(personaAtiendeAccDao.buscarPorCodigo(peaCodigo));
    }
}
