/*
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-04-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaCtaBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaCtaBanco;
import co.gov.coljuegos.siicol.ejb.vo.PersonaCtaBancoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminPersonaCtaBancoBean implements AdminPersonaCtaBanco {

    @EJB
    private PersonaCtaBancoDAO personaCtaBancoDAO;


    public AdminPersonaCtaBancoBean() {
        super();
    }

    @Override
    public PersonaCtaBancoVO buscarPorCodigo(Long pcbCodigo) throws ExcepcionDAO {
        PersonaCtaBancoVO resultado = null;
        SiiPersonaCtaBanco siiPersonaCtaBanco = personaCtaBancoDAO.buscarPorCodigo(pcbCodigo);
        if (siiPersonaCtaBanco != null)
            resultado = new PersonaCtaBancoVO(siiPersonaCtaBanco);
        return (resultado);
    }

    /**
     * @author Modifica Giovanni 
     * @param perCodigo
     * @return
     * @throws ExcepcionDAO
     */
    @Override
    public List<PersonaCtaBancoVO> buscarPersonaCtaBancoPorCodigoPersona(Long perCodigo) throws ExcepcionDAO {
        List<PersonaCtaBancoVO> resultado = null;
        List<SiiPersonaCtaBanco> lista = personaCtaBancoDAO.buscarPorCodigoPersona(perCodigo);
        if (lista != null) {
            resultado = new ArrayList<PersonaCtaBancoVO>();
            for (SiiPersonaCtaBanco siiPersonaCtaBanco : lista) {
                resultado.add(new PersonaCtaBancoVO(siiPersonaCtaBanco));
            }
        }
        return (resultado);
    }
}
