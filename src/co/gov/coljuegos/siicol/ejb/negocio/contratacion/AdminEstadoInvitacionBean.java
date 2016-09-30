package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoInvitacionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.InvitacionProcesoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoInvitacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoInvitacionVO;

import co.gov.coljuegos.siicol.ejb.vo.InvitacionProcesoVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;


@Stateless

public class AdminEstadoInvitacionBean implements AdminEstadoInvitacion {
    @Resource
    SessionContext sessionContext;
    @EJB
    EstadoInvitacionDAO estadoInvitacionDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    InvitacionProcesoDAO invitacionProcesoDao;

    public AdminEstadoInvitacionBean() {
    }

    public EstadoInvitacionVO buscarEstadoInvitacionPorId(Long einCodigo) throws ExcepcionDAO {
        SiiEstadoInvitacion estadoInvitacion;
        estadoInvitacion = estadoInvitacionDao.buscarEstadoInvitacionPorId(einCodigo);
        return new EstadoInvitacionVO(estadoInvitacion);
    }

    public EstadoInvitacionVO insertarEstadoInvitacion(EstadoInvitacionVO estadoInvitacionVO) throws ExcepcionDAO {
        SiiEstadoInvitacion estadoInvitacion =
            conversionVoEntidad.convertir(estadoInvitacionVO);
        estadoInvitacion = estadoInvitacionDao.insertarEstadoInvitacion(estadoInvitacion);
        
        List<InvitacionProcesoVO> listaInvitacionProcesoVO = estadoInvitacionVO.getInvitacionProcesoListVO();
        for (InvitacionProcesoVO unaInvitacionProcesoVO : listaInvitacionProcesoVO) {
            SiiInvitacionProceso nuevaInvitacionProceso = conversionVoEntidad.convertir(unaInvitacionProcesoVO);
            nuevaInvitacionProceso.setSiiEstadoInvitacion(estadoInvitacion);
            invitacionProcesoDao.insertarInvitacionProceso(nuevaInvitacionProceso);
        }
        return new EstadoInvitacionVO(estadoInvitacion);
    }

    public EstadoInvitacionVO actualizarEstadoInvitacion(EstadoInvitacionVO estadoInvitacionVO) throws ExcepcionDAO {
        SiiEstadoInvitacion estadoInvitacion = conversionVoEntidad.convertir(estadoInvitacionVO);
        return new EstadoInvitacionVO(estadoInvitacionDao.actualizarEstadoInvitacion(estadoInvitacion));
    }

    public void eliminarEstadoInvitacion(long einCodigo) throws ExcepcionDAO {
        estadoInvitacionDao.eliminarEstadoInvitacion(einCodigo);

    }

    public List<EstadoInvitacionVO> buscarTodoEstadoInvitacion() throws ExcepcionDAO {
        List<SiiEstadoInvitacion> listaEstadoInvitacion = estadoInvitacionDao.buscarTodoEstadoInvitacion();
        List<EstadoInvitacionVO> listaEstadoInvitacionVO = new ArrayList();
        for (SiiEstadoInvitacion unEstadoInvitacion : listaEstadoInvitacion) {
            listaEstadoInvitacionVO.add(new EstadoInvitacionVO(unEstadoInvitacion));
        }
        return listaEstadoInvitacionVO;
    }

    public List<EstadoInvitacionVO> buscarEstadoInvitacion(String estado) throws ExcepcionDAO {
        List<SiiEstadoInvitacion> listaEstadoInvitacion = estadoInvitacionDao.buscarEstadoInvitacion(estado);
        List<EstadoInvitacionVO> listaEstadoInvitacionVO = new ArrayList();
        for (SiiEstadoInvitacion unEstadoInvitacion : listaEstadoInvitacion) {
            listaEstadoInvitacionVO.add(new EstadoInvitacionVO(unEstadoInvitacion));
        }
        return listaEstadoInvitacionVO;
    }
}
