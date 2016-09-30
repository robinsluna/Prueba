/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 20-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFuenteFinanciacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminDetFuenteFinanciacionBean implements AdminDetFuenteFinanciacion {
    @Resource
    SessionContext sessionContext;

    @EJB
    DetalleFuenteFinanciacionDAO detFuenteFinanciacionDao;

    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminDetFuenteFinanciacionBean() {
    }

    public DetFuenteFinanciacionVO insertarDtlleFuenteFinanciacion(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO {
        SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion =
            conversionVoEntidad.convertir(siiDtlleFuenteFinanciacionVo);
        SiiDtlleFuenteFinanciacion resultadoDetFuenteFin =
            detFuenteFinanciacionDao.insertarDtlleFuenteFinanciacion(siiDtlleFuenteFinanciacion);
        return new DetFuenteFinanciacionVO(resultadoDetFuenteFin);
    }

    public DetFuenteFinanciacionVO buscarDtlleFuenteFinanciacionPorId(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO {
        SiiDtlleFuenteFinanciacion resultadoDetFuenteFin =
            detFuenteFinanciacionDao.buscarDtlleFuenteFinanciacionPorId(siiDtlleFuenteFinanciacionVo.getDffCodigo());
        return new DetFuenteFinanciacionVO(resultadoDetFuenteFin);
    }

    public DetFuenteFinanciacionVO buscarDtlleFuenteFinanciacionPorId(Long dffCodigo) throws ExcepcionDAO {
        SiiDtlleFuenteFinanciacion resultadoDetFuenteFin =
            detFuenteFinanciacionDao.buscarDtlleFuenteFinanciacionPorId(dffCodigo);
        return new DetFuenteFinanciacionVO(resultadoDetFuenteFin);
    }

    public DetFuenteFinanciacionVO buscarCodDetFuenteFinanciacionPorNombre(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO {
        //SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion = conversionVoEntidad.convertir(siiDtlleFuenteFinanciacionVo);
        SiiDtlleFuenteFinanciacion resultadoDetFuenteFin =
            detFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombre(siiDtlleFuenteFinanciacionVo.getDffCodigoRecurso());
        return new DetFuenteFinanciacionVO(resultadoDetFuenteFin);
    }

    public DetFuenteFinanciacionVO actualizarDtlleFuenteFinanciacion(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO {
        SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion =
            conversionVoEntidad.convertir(siiDtlleFuenteFinanciacionVo);
        return new DetFuenteFinanciacionVO(detFuenteFinanciacionDao.actualizarDtlleFuenteFinanciacion(siiDtlleFuenteFinanciacion));
    }

    public void eliminarDtlleFuenteFinanciacion(DetFuenteFinanciacionVO siiDtlleFuenteFinanciacionVo) throws ExcepcionDAO {
        detFuenteFinanciacionDao.eliminarDtlleFuenteFinanciacion(siiDtlleFuenteFinanciacionVo.getDffCodigo());
    }

    public List<DetFuenteFinanciacionVO> buscarTodoDetalleFuentePorFuenteFin(FuenteFinanciacionVO fuenteFinanciacionVo) throws ExcepcionDAO {
        SiiFuenteFinanciacion fuenteFinanciacion = conversionVoEntidad.convertir(fuenteFinanciacionVo);

        List<SiiDtlleFuenteFinanciacion> listaDetallesFuente =
            detFuenteFinanciacionDao.buscarTodoDetalleFuentePorFuenteFin(fuenteFinanciacion);

        List<DetFuenteFinanciacionVO> listaDetalleFuentesFinanciacionVo = new ArrayList();

        for (SiiDtlleFuenteFinanciacion unaEntidadDtlleFuenteFinan : listaDetallesFuente) {
            listaDetalleFuentesFinanciacionVo.add(new DetFuenteFinanciacionVO(unaEntidadDtlleFuenteFinan));
        }
        return listaDetalleFuentesFinanciacionVo;
    }

    public DetFuenteFinanciacionVO buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre(String nombreFuente,
                                                                                          String nombreDetFuente) throws ExcepcionDAO {
        return new DetFuenteFinanciacionVO(detFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre(nombreFuente,
                                                                                                                           nombreDetFuente));
    }

    public DetFuenteFinanciacionVO buscarCodDetFuenteFinanciacionPorCodigoFuenteCodigoRecurso(Integer codigoFuente, Integer codigoRecurso) throws ExcepcionDAO {
        return new DetFuenteFinanciacionVO(detFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorCodigoFuenteCodigoRecurso(codigoFuente, codigoRecurso));
    }

}
