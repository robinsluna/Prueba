package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionPersonaAtienDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionPersonaAtien;
import co.gov.coljuegos.siicol.ejb.vo.DireccionPersonaAtienVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminDireccionPersonaAtienBean implements AdminDireccionPersonaAtien {
    @EJB 
    DireccionPersonaAtienDAO direccionPersonaAtienDao;
    public AdminDireccionPersonaAtienBean() {
    }

    public List<DireccionPersonaAtienVO> buscarDireccionesPorPersona(Long peaCodigo) throws ExcepcionDAO {
        List<DireccionPersonaAtienVO> direccionesPersonaAtienVo = new ArrayList<DireccionPersonaAtienVO>();
        for (SiiDireccionPersonaAtien persona :direccionPersonaAtienDao.buscarDireccionesPorPersona(peaCodigo)) {
            direccionesPersonaAtienVo.add(new DireccionPersonaAtienVO(persona));
        }
        return direccionesPersonaAtienVo;
    }

    public DireccionPersonaAtienVO buscarDireccionPorCodigo(Long dpaCodigo) throws ExcepcionDAO {
        return new DireccionPersonaAtienVO(direccionPersonaAtienDao.buscarPorCodigo(dpaCodigo));
    }
}
