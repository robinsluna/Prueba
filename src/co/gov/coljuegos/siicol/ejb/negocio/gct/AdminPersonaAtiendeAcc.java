package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaAtiendeAccVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminPersonaAtiendeAcc {
    public List<PersonaAtiendeAccVO> buscarPersonaAtiendePorAccionControl(Long accCodigo) throws ExcepcionDAO;

    public PersonaAtiendeAccVO buscarPersonaPorCodigo(Long peaCodigo) throws ExcepcionDAO;
}
