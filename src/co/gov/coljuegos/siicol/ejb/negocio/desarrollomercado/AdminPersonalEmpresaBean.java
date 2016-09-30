package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonalEmpresaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonalEmpresa;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.PersonalEmpresaVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminPersonalEmpresaBean implements AdminPersonalEmpresa {

    @Resource
    SessionContext sessionContext;

    @EJB
    PersonalEmpresaDAO personalEmpresaDAO;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminPersonalEmpresaBean() {
    }

    public PersonalEmpresaVO insertarSiiPersonalEmpresa(PersonalEmpresaVO personalEmpresaVO) throws ExcepcionDAO {
        SiiPersonalEmpresa siiPersonalEmpresa = conversionVoEntidad.convertir(personalEmpresaVO);
        SiiPersonalEmpresa unPersonalEmpresa = personalEmpresaDAO.insertarSiiPersonalEmpresa(siiPersonalEmpresa);
        return new PersonalEmpresaVO(unPersonalEmpresa);
    }

    public PersonalEmpresaVO buscarPersonalEmpresaPorCodigo(Long idCodigoPersonalEmpresa) throws ExcepcionDAO {
        SiiPersonalEmpresa unPersonalEmpresa =
            personalEmpresaDAO.buscarPersonalEmpresaPorCodigo(idCodigoPersonalEmpresa);
        return new PersonalEmpresaVO(unPersonalEmpresa);
    }

    public PersonalEmpresaVO actualizarSiiPersonalEmpresa(PersonalEmpresaVO personalEmpresaVO) throws ExcepcionDAO {
        SiiPersonalEmpresa siiPersonalEmpresa = conversionVoEntidad.convertir(personalEmpresaVO);
        SiiPersonalEmpresa unPersonalEmpresa = personalEmpresaDAO.actualizarSiiPersonalEmpresa(siiPersonalEmpresa);
        return new PersonalEmpresaVO(unPersonalEmpresa);

    }

    public void borrarPersonalEmpresa(Long idCodigoPersonalEmpresa) throws ExcepcionDAO {

        personalEmpresaDAO.borrarPersonalEmpresa(idCodigoPersonalEmpresa);
    }

    public List<PersonalEmpresaVO> buscarTodoSiiPersonalEmpresa() throws ExcepcionDAO {
        List<SiiPersonalEmpresa> listaPersonalEmpresa = personalEmpresaDAO.buscarTodoSiiPersonalEmpresa();
        List<PersonalEmpresaVO> listaPersonalEmpresaVo = new ArrayList();
        for (SiiPersonalEmpresa unPersonalEmpresa : listaPersonalEmpresa) {
            listaPersonalEmpresaVo.add(new PersonalEmpresaVO(unPersonalEmpresa));
        }
        return listaPersonalEmpresaVo;
    }

    /**
     * Metodo que se encarga de coanultar los contactos  de un personal
     * @author Giovanni
     * @param codigoPersonal
     * @return
     */
    public List<PersonalEmpresaVO> buscarPersonalEmpresaXCodigoPersonal(long codigoPersonal) throws ExcepcionDAO {
        List<PersonalEmpresaVO> personalEmpresaVOs = new ArrayList<PersonalEmpresaVO>();
        List<SiiPersonalEmpresa> siiPersonalEmpresas = new ArrayList<SiiPersonalEmpresa>();
        siiPersonalEmpresas = personalEmpresaDAO.buscarPersonalEmpresaPorIdPersona(codigoPersonal);
        for (SiiPersonalEmpresa siiPersonalEmpresa : siiPersonalEmpresas) {
            PersonalEmpresaVO personalEmpresaVO = new PersonalEmpresaVO(siiPersonalEmpresa);
            personalEmpresaVOs.add(personalEmpresaVO);
        }
        return personalEmpresaVOs;
    }

    /**
     * Metodo para consultar un contacto para un operador ya sea autorizado, potencia o proveedor de tecnologia
     * @author Giovanni
     * @param idOperador
     * @param idPersonaContacto
     * @return
     * @throws ExcepcionDAO
     */
    public PersonalEmpresaVO buscarPersonalEmpresaXOperadorXPerosna(long idOperador,
                                                                    long idPersonaContacto) throws ExcepcionDAO {
        SiiPersonalEmpresa siiPersonalEmpresa = new SiiPersonalEmpresa();
        siiPersonalEmpresa = personalEmpresaDAO.buscarPersonalEmpresaXOperadorXPerosna(idOperador, idPersonaContacto);
        PersonalEmpresaVO personalEmpresaVO = new PersonalEmpresaVO(siiPersonalEmpresa);
        return personalEmpresaVO;
    }
    
    public PersonalEmpresaVO buscarPersonalEmpresaPorEmpresaPorRol(Long perCodigoEmpresa, String rol) throws ExcepcionDAO {
        return new PersonalEmpresaVO(personalEmpresaDAO.buscarPersonalEmpresaPorEmpresaPorRol(perCodigoEmpresa, rol));
    }

}
