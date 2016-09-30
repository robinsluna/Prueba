package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuncionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuncion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.FuncionVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminFuncionBean implements AdminFuncion{


    @EJB    
    FuncionDAO funcionDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminFuncionBean(){}

    public FuncionVO buscarFuncionPorId(Long idFuncion) throws ExcepcionDAO {
        SiiFuncion siiFuncion = funcionDao.buscarFuncionPorId(idFuncion);
        return new FuncionVO(siiFuncion);
    }

    public List<FuncionVO> buscarTodoFuncion() throws ExcepcionDAO{
        List<SiiFuncion> listaFuncion = funcionDao.buscarTodoFuncion();
        List<FuncionVO> listaFuncionVo = new ArrayList<FuncionVO>();
        for(SiiFuncion unaEntidadFuncion : listaFuncion){
            listaFuncionVo.add(new FuncionVO(unaEntidadFuncion));
        }
        return listaFuncionVo;
    }
    
    public List<PersonaVO> buscarFuncionarioPorFuncion(String funcion) throws ExcepcionDAO {
        List<PersonaVO> personasVo = new ArrayList<PersonaVO>();
        for (SiiPersona per :funcionDao.buscarFuncionarioPorFuncion(funcion)){
            personasVo.add(new PersonaVO(per));
        }
        return personasVo;
    }

}
