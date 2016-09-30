package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProveedorInvitacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedorInvitacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.InvitacionProcesoVO;
import co.gov.coljuegos.siicol.ejb.vo.ProveedorInvitacionVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminProveedorInvitacionBean implements AdminProveedorInvitacion {
    @EJB
    ProveedorInvitacionDAO proveedorInvitacionDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    public AdminProveedorInvitacionBean() {
        
    }

    public ProveedorInvitacionVO buscarProveedorInvitacionPorId(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO {
        
        return new ProveedorInvitacionVO(proveedorInvitacionDao.buscarProveedorInvitacionPorId(proveedorInvitacionVO.getPinCodigo()));
    }
    

    public ProveedorInvitacionVO insertarProveedorInvitacion(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO {

        return new ProveedorInvitacionVO(proveedorInvitacionDao.insertarProveedorInvitacion(conversionVoEntidad.convertir(proveedorInvitacionVO)));
        
    }

    public ProveedorInvitacionVO actualizarProveedorInvitacion(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO {
        return new ProveedorInvitacionVO(proveedorInvitacionDao.actualizarProveedorInvitacion(conversionVoEntidad.convertir(proveedorInvitacionVO)));
    }

    public void eliminarProveedorInvitacion(ProveedorInvitacionVO proveedorInvitacionVO) throws ExcepcionDAO {
        proveedorInvitacionDao.eliminarProveedorInvitacion(proveedorInvitacionVO.getPinCodigo());

    }

    public List<ProveedorInvitacionVO> buscarTodoProveedorInvitacionPorInvitacion(Integer invitacion) throws ExcepcionDAO {
        List<SiiProveedorInvitacion> listaProveedorInvitacion = proveedorInvitacionDao.buscarTodoProveedorInvitacionPorInvitacion(invitacion);
        List<ProveedorInvitacionVO> listaProveedorInvitacionVO = new ArrayList();
        for (SiiProveedorInvitacion unProveedorInvitacion : listaProveedorInvitacion) {
            listaProveedorInvitacionVO.add(new ProveedorInvitacionVO(unProveedorInvitacion));
        }
        return listaProveedorInvitacionVO;
    }
    public List<ProveedorInvitacionVO> buscarProveedorInvitacionPorCodProveedoreInvitacion(long idProveedor,long idInvitacionProceso) throws ExcepcionDAO {
        List<SiiProveedorInvitacion> lista = proveedorInvitacionDao.buscarProveedorInvitacionPorCodProveedoreInvitacion(idProveedor, idInvitacionProceso);        
        List<ProveedorInvitacionVO> listaProveedorInvitacionVO = new ArrayList();
        for (SiiProveedorInvitacion unProveedorInvitacion : lista) {
            listaProveedorInvitacionVO.add(new ProveedorInvitacionVO(unProveedorInvitacion));
        }
       
       
       
        return listaProveedorInvitacionVO;
    }

    public List<ProveedorInvitacionVO> buscarProveedorInvitacionPorProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        List<SiiProveedorInvitacion> lista = proveedorInvitacionDao.buscarProveedorInvitacionPorProcesoContratacion(prcCodigo);        
        List<ProveedorInvitacionVO> listaProveedorInvitacionVO = new ArrayList();
        if (lista!=null) {
            for (SiiProveedorInvitacion unProveedorInvitacion : lista) {
                listaProveedorInvitacionVO.add(new ProveedorInvitacionVO(unProveedorInvitacion));
            }
        }
        
        return listaProveedorInvitacionVO;
    }
}
