/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 19-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFuenteFinanciacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuenteFinanciacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminFuenteFinanciacionBean implements AdminFuenteFinanciacion {
    @Resource
    SessionContext sessionContext;

    @EJB
    FuenteFinanciacionDAO fuenteFinanciacionDao;
    @EJB
    DetalleFuenteFinanciacionDAO detalleFuenteFinDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminFuenteFinanciacionBean() {
    }

    public FuenteFinanciacionVO insertarFuenteFinanciacion(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO {
        SiiFuenteFinanciacion siiFuenteFinanciacion = conversionVoEntidad.convertir(siiFuenteFinanciacionVo);
        SiiFuenteFinanciacion resultadoFuenteFinanciacion = fuenteFinanciacionDao.insertarFuenteFinanciacion(siiFuenteFinanciacion);
        return new FuenteFinanciacionVO(resultadoFuenteFinanciacion);
    }
    
    public FuenteFinanciacionVO insertarFuenteFinanciacionConDetalles(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO {
        SiiFuenteFinanciacion siiFuenteFinanciacion = conversionVoEntidad.convertir(siiFuenteFinanciacionVo);
        SiiFuenteFinanciacion resultadoFuenteFinanciacion = fuenteFinanciacionDao.insertarFuenteFinanciacion(siiFuenteFinanciacion);
        if(siiFuenteFinanciacionVo.getDetFuenteFinanciacionVoList()!=null){
            List<DetFuenteFinanciacionVO> listaDetalles = siiFuenteFinanciacionVo.getDetFuenteFinanciacionVoList();
            for(DetFuenteFinanciacionVO unDetalleFuenteVo : listaDetalles){
                SiiDtlleFuenteFinanciacion nuevaEntidadDetalle = conversionVoEntidad.convertir(unDetalleFuenteVo);
                nuevaEntidadDetalle.setSiiFuenteFinanciacion(resultadoFuenteFinanciacion);
                detalleFuenteFinDao.insertarDtlleFuenteFinanciacion(nuevaEntidadDetalle);
            }
        }
        return new FuenteFinanciacionVO(resultadoFuenteFinanciacion);
    }
    
    /**
     * Método que actualiza la información de una fuente y borra los detalles que llegan en la lista de borrado
     * y agrega los detalles de la lista de agregar
     */
    public void actualizarFuenteDetallesAgregarBorrar(FuenteFinanciacionVO fuenteFinanciacionVo, List<DetFuenteFinanciacionVO> listaDetallesAgregar,
                                    List<DetFuenteFinanciacionVO> listaDetallesBorrar) throws ExcepcionDAO {
        
        SiiFuenteFinanciacion siiFuenteFinanciacion = conversionVoEntidad.convertir(fuenteFinanciacionVo);
        fuenteFinanciacionDao.actualizarFuenteFinanciacion(siiFuenteFinanciacion);
        
        if (listaDetallesBorrar != null){
            for (DetFuenteFinanciacionVO detFuenteFinanVo  : listaDetallesBorrar){
                SiiDtlleFuenteFinanciacion unaEntidadDetFuente = conversionVoEntidad.convertir(detFuenteFinanVo);
                detalleFuenteFinDao.eliminarDtlleFuenteFinanciacion(unaEntidadDetFuente.getDffCodigo());
            }
        }
        if (listaDetallesAgregar != null){
            for(DetFuenteFinanciacionVO detFuenteFinanVo : listaDetallesAgregar){
                SiiDtlleFuenteFinanciacion unaEntidadDetFuente = conversionVoEntidad.convertir(detFuenteFinanVo);
                unaEntidadDetFuente.setSiiFuenteFinanciacion(siiFuenteFinanciacion);
                detalleFuenteFinDao.insertarDtlleFuenteFinanciacion(unaEntidadDetFuente);
            }
        }
    }

    public FuenteFinanciacionVO buscarFuenteFinanciacionPorId(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO {
        SiiFuenteFinanciacion siiFuenteFinanciacion = conversionVoEntidad.convertir(siiFuenteFinanciacionVo);
        SiiFuenteFinanciacion resultadoFuenteFinanciacion = fuenteFinanciacionDao.buscarFuenteFinanciacionPorId(siiFuenteFinanciacionVo.getFfiCodigo());
        return new FuenteFinanciacionVO(resultadoFuenteFinanciacion);
    }
    
    public FuenteFinanciacionVO buscarFuenteFinanciacionPorNombre(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO{
        SiiFuenteFinanciacion siiFuenteFinanciacion = conversionVoEntidad.convertir(siiFuenteFinanciacionVo);
        SiiFuenteFinanciacion resultadoFuenteFinanciacion = fuenteFinanciacionDao.buscarFuenteFinanciacionPorNombre(siiFuenteFinanciacion);
        return new FuenteFinanciacionVO(resultadoFuenteFinanciacion);
    }
    
    public FuenteFinanciacionVO buscarCodFuenteFinanciacionPorNombre(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO{
        SiiFuenteFinanciacion siiFuenteFinanciacion = conversionVoEntidad.convertir(siiFuenteFinanciacionVo);
        SiiFuenteFinanciacion resultadoFuenteFinanciacion = fuenteFinanciacionDao.buscarCodFuenteFinanciacionPorNombre(siiFuenteFinanciacion);
        return new FuenteFinanciacionVO(resultadoFuenteFinanciacion);
    }
    
    public void actualizarFuenteFinanciacion(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO {
        SiiFuenteFinanciacion siiFuenteFinanciacion = conversionVoEntidad.convertir(siiFuenteFinanciacionVo);
        SiiFuenteFinanciacion resultadoFuenteFinanciacion = fuenteFinanciacionDao.buscarFuenteFinanciacionPorId(siiFuenteFinanciacionVo.getFfiCodigo());
        
        resultadoFuenteFinanciacion.setFfiDescripcion(siiFuenteFinanciacionVo.getFfidescripcion());
        resultadoFuenteFinanciacion.setFfiNombre(siiFuenteFinanciacionVo.getFfiNombre());
        
        fuenteFinanciacionDao.actualizarFuenteFinanciacion(siiFuenteFinanciacion);
    }
   
    public void eliminarFuenteFinanciacion(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO{
        fuenteFinanciacionDao.eliminarFuenteFinanciacion(siiFuenteFinanciacionVo.getFfiCodigo()); 
    }

    public List<FuenteFinanciacionVO> buscarTodoFteFinanciacionConDtle() throws ExcepcionDAO {
        List<SiiFuenteFinanciacion> listaFuenteFinanciacion = fuenteFinanciacionDao.buscarTodoFteFinanciacionConDtle();
        
        List<FuenteFinanciacionVO> listaFuenteFinVo = new ArrayList();
        
        for(SiiFuenteFinanciacion unaEntidadFuenteFinan : listaFuenteFinanciacion){
            listaFuenteFinVo.add(new FuenteFinanciacionVO(unaEntidadFuenteFinan));
        }
        return listaFuenteFinVo;
    }

    
    /**
     * Obtiene el listado de Fuentes de Financiaci&oacute;n de acuerdo al RP asociado.
     * @param rpCodigo
     * @return List of FuenteFinanciacionVO
     * @throws ExcepcionDAO
     */
    public List<FuenteFinanciacionVO> buscarFuenteFinanciacionPorRp(Long rpCodigo) throws ExcepcionDAO {
        List<SiiFuenteFinanciacion> listaFuenteFinanciacion = fuenteFinanciacionDao.buscarFuenteFinanciacionPorRp(rpCodigo);
        List<FuenteFinanciacionVO> listaFuenteFinVo = new ArrayList<FuenteFinanciacionVO>();
        
        for(SiiFuenteFinanciacion siiFuenteFinanciacion : listaFuenteFinanciacion){
            listaFuenteFinVo.add(new FuenteFinanciacionVO(siiFuenteFinanciacion));
        }
        return (listaFuenteFinVo);
    }
}
