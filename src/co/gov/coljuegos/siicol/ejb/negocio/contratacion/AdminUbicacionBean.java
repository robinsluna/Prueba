package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminUbicacionBean implements AdminUbicacion {
    @Resource
    SessionContext sessionContext;

    @EJB
    UbicacionDAO ubicacionDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminUbicacionBean() {
    }

    public UbicacionVO buscarUbicacionPorId(UbicacionVO ubicacionVo) throws ExcepcionDAO {
        UbicacionVO unaUbicacionVo;
        SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(ubicacionVo.getUbiCodigo());
        if (siiUbicacion != null)
            unaUbicacionVo = new UbicacionVO(siiUbicacion);
        else
            unaUbicacionVo = new UbicacionVO();

        return unaUbicacionVo;
    }
    
    public List<UbicacionVO> buscarUbicacionTipoUbicacion(Long idTipoUbicacion) throws ExcepcionDAO {
        List<SiiUbicacion> listaUbicacion = ubicacionDao.buscarUbicacionTipoUbicacion(idTipoUbicacion);
        List<UbicacionVO> listaUbicacionVo = new ArrayList();
        for (SiiUbicacion unaUbicacion : listaUbicacion) {
            listaUbicacionVo.add(new UbicacionVO(unaUbicacion));
        }
        return listaUbicacionVo;
    }

    public List<UbicacionVO> buscarUbicacionPorPadre(String idPadre) throws ExcepcionDAO {
        List<SiiUbicacion> listaUbicacion = ubicacionDao.buscarUbicacionPorPadre(idPadre);
        List<UbicacionVO> listaUbicacionVo = new ArrayList();
        for (SiiUbicacion unaUbicacion : listaUbicacion) {
            listaUbicacionVo.add(new UbicacionVO(unaUbicacion));
        }
        return listaUbicacionVo;
    }

    @Override
    public UbicacionVO buscarUbicacionPorId(String idUbicacion) throws ExcepcionDAO {
        UbicacionVO unaUbicacionVo;
        SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(idUbicacion);
        if (siiUbicacion != null)
            unaUbicacionVo = new UbicacionVO(siiUbicacion);
        else
            unaUbicacionVo = new UbicacionVO();

        return unaUbicacionVo;
    }

    /**
     * Metodo que se encarga de consultat todos los paises
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<UbicacionVO> buscarUbicacionPaises() throws ExcepcionDAO {
        List<UbicacionVO> ubicacionPaiseVOs = new ArrayList<UbicacionVO>();
        List<SiiUbicacion> ubicacionPaises = new ArrayList<SiiUbicacion>();
        ubicacionPaises = ubicacionDao.buscarUbicacionPaises();
        for (SiiUbicacion siiUbicacion : ubicacionPaises) {
            UbicacionVO ubicacionVO = new UbicacionVO(siiUbicacion);
            ubicacionPaiseVOs.add(ubicacionVO);
        }
        return ubicacionPaiseVOs;
    }
    
    /**
     * Metodo que se encarga de consultar todos los departamentos 
     * @author Giovanni 
     * @return
     * @throws ExcepcionDAO
     */
    public List<UbicacionVO> buscarUbicacionDepartamento() throws ExcepcionDAO {
        List<UbicacionVO> ubicacionDepartamentoVOs = new ArrayList<UbicacionVO>();
        List<SiiUbicacion> ubicacionDepartamentos = new ArrayList<SiiUbicacion>();
        ubicacionDepartamentos = ubicacionDao.buscarUbicacionDepartamento();
        for (SiiUbicacion siiUbicacion : ubicacionDepartamentos) {
            UbicacionVO ubicacionVO = new UbicacionVO(siiUbicacion);
            ubicacionDepartamentoVOs.add(ubicacionVO);
        }
        return ubicacionDepartamentoVOs;
    }        
        
    /**
     * Metodo que se encarga de consultar todas ciudades del departamento 
     * @author Giovanni 
     * @return
     * @throws ExcepcionDAO
     */
    public List<UbicacionVO> buscarUbicacionCiudadesXDepartamento(String codigoDepartamenteo) throws ExcepcionDAO {
        List<UbicacionVO> ubicacionCiudadVOs = new ArrayList<UbicacionVO>();
        List<SiiUbicacion> ubicacionCiudades = new ArrayList<SiiUbicacion>();
        ubicacionCiudades = ubicacionDao.buscarUbicacionCiudadesXDepartamento(codigoDepartamenteo);
        for (SiiUbicacion siiUbicacion : ubicacionCiudades) {
            UbicacionVO ubicacionVO = new UbicacionVO(siiUbicacion);
            ubicacionCiudadVOs.add(ubicacionVO);
        }
        return ubicacionCiudadVOs;
    }
    
    public List<UbicacionVO> buscarTodaUbicacion( ) throws ExcepcionDAO {
        List<SiiUbicacion> listaUbicacion = ubicacionDao.buscarTodaUbicacion();
        List<UbicacionVO> listaUbicacionVo = new ArrayList();
        for (SiiUbicacion unaUbicacion : listaUbicacion) {
            listaUbicacionVo.add(new UbicacionVO(unaUbicacion));
        }
        return listaUbicacionVo;
    
    }
    
}

