package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AlcanceInvitacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoAlcanceInvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAlcanceInvitacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAlcanceInv;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AlcanceInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoAlcanceInvVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminEstadoAlcanceInvBean implements AdminEstadoAlcanceInv{
    @Resource
    SessionContext sessionContext;
    @EJB
    EstadoAlcanceInvDAO estadoAlcanceInvDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    AlcanceInvitacionDAO alcanceInvitacionDao;

    public AdminEstadoAlcanceInvBean() {
    }

    public EstadoAlcanceInvVO buscarEstadoAlcanceInvPorId(Long eaiCodigo) throws ExcepcionDAO {
        SiiEstadoAlcanceInv estadoAlcanceInv;
        estadoAlcanceInv = estadoAlcanceInvDao.buscarEstadoAlcanceInvPorId(eaiCodigo);
        return new EstadoAlcanceInvVO(estadoAlcanceInv);
    }

    public EstadoAlcanceInvVO insertarEstadoAlcanceInv(EstadoAlcanceInvVO estadoAlcanceInvVO) throws ExcepcionDAO {
        SiiEstadoAlcanceInv estadoAlcanceInv =
            conversionVoEntidad.convertir(estadoAlcanceInvVO);
        estadoAlcanceInv = estadoAlcanceInvDao.insertarEstadoAlcanceInv(estadoAlcanceInv);
        
        List<AlcanceInvitacionVO> listaAlcanceInvitacionVO = estadoAlcanceInvVO.getAlcanceInvitacionListVo();
        for (AlcanceInvitacionVO unAlcanceInvitacionVO : listaAlcanceInvitacionVO) {
            SiiAlcanceInvitacion nuevoAlcanceInvitacion = conversionVoEntidad.convertir(unAlcanceInvitacionVO);
            nuevoAlcanceInvitacion.setSiiEstadoAlcanceInv(estadoAlcanceInv);
            alcanceInvitacionDao.insertarAlcanceInvitacion(nuevoAlcanceInvitacion);
        }
        return new EstadoAlcanceInvVO(estadoAlcanceInv);
    }

    public EstadoAlcanceInvVO actualizarEstadoAlcanceInv(EstadoAlcanceInvVO estadoAlcanceInvVO) throws ExcepcionDAO {
        SiiEstadoAlcanceInv estadoAlcanceInv = conversionVoEntidad.convertir(estadoAlcanceInvVO);
        return new EstadoAlcanceInvVO(estadoAlcanceInvDao.actualizarEstadoAlcanceInv(estadoAlcanceInv));
    }

    public void eliminarEstadoAlcanceInv(long eaiCodigo) throws ExcepcionDAO {
        estadoAlcanceInvDao.eliminarEstadoAlcanceInv(eaiCodigo);

    }

    public List<EstadoAlcanceInvVO> buscarTodoEstadoAlcanceInv() throws ExcepcionDAO {
        List<SiiEstadoAlcanceInv> listaEstadoAlcanceInv = estadoAlcanceInvDao.buscarTodoEstadoAlcanceInv();
        List<EstadoAlcanceInvVO> listaEstadoAlcanceInvVO = new ArrayList();
        for (SiiEstadoAlcanceInv unEstadoAlcanceInv : listaEstadoAlcanceInv) {
            listaEstadoAlcanceInvVO.add(new EstadoAlcanceInvVO(unEstadoAlcanceInv));
        }
        return listaEstadoAlcanceInvVO;
    }

    public List<EstadoAlcanceInvVO> buscarEstadoAlcanceInv(String estado) throws ExcepcionDAO {
        List<SiiEstadoAlcanceInv> listaEstadoAlcanceInv = estadoAlcanceInvDao.buscarEstadoAlcanceInv(estado);
        List<EstadoAlcanceInvVO> listaEstadoAlcanceInvVO = new ArrayList();
        for (SiiEstadoAlcanceInv unEstadoAlcanceInv : listaEstadoAlcanceInv) {
            listaEstadoAlcanceInvVO.add(new EstadoAlcanceInvVO(unEstadoAlcanceInv));
        }
        return listaEstadoAlcanceInvVO;
    }
}
