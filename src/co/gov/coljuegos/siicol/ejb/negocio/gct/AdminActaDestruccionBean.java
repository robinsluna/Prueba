/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActaDestruccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoRetiradoAccDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionDecomDestDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaDestruccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDecomDest;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ActaDestruccionVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoRetiradoAccVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionDecomDestVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona las actas de destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminActaDestruccionBean implements AdminActaDestruccion {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ActaDestruccionDAO actaDestruccionDao;
    @EJB    
    private AdminResolucionDecomDest adminResolucionDecomDest;
    @EJB   
    private ResolucionDecomDestDAO resolucionDecomDestDao;
    @EJB   
    private ElementoRetiradoAccDAO elementoRetiradoAccDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;

    /**
     * Constructor.
     */

    public AdminActaDestruccionBean() {
        super();
    }

    /**
     * Guardar la Resolución de decomiso y destrucción del acta de destrucción.
     * @param actaDestruccionVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    private void persistirResolucionDecomDest(ActaDestruccionVO actaDestruccionVo) throws ExcepcionDAO,
                                                                                          ExcepcionAplicacion {
        if (actaDestruccionVo != null && actaDestruccionVo.getResolucionDecomDestListVo() != null) {
            for (ResolucionDecomDestVO resolucionDecomDestVo : actaDestruccionVo.getResolucionDecomDestListVo()) {
                if (resolucionDecomDestVo != null) {
                    resolucionDecomDestVo.setActaDestruccionVo(actaDestruccionVo);

                    if (actaDestruccionVo.getAdeCodigo() == null) {
                        // OPERACION INSERTAR
                        adminResolucionDecomDest.insertarResolucionDecomDest(resolucionDecomDestVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminResolucionDecomDest.actualizarResolucionDecomDest(resolucionDecomDestVo);
                    }
                }
            }
        }
    }

    /**
     * Persistir las listas del acta de destrucción.
     * @param actaDestruccionVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirHijos(ActaDestruccionVO actaDestruccionVo) throws ExcepcionDAO, ExcepcionAplicacion {
        this.persistirResolucionDecomDest(actaDestruccionVo);
    }

    /**
     * Insertar
     * @param actaDestruccionVo
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    public ActaDestruccionVO insertarActaDestruccion(ActaDestruccionVO actaDestruccionVo) throws ExcepcionDAO,
                                                                                                 ExcepcionAplicacion {
        ActaDestruccionVO resultado = null;

        try {
            
            SiiActaDestruccion siiActaDestruccion =
                actaDestruccionDao.insertar(conversionVoEntidad.convertir(actaDestruccionVo));
            if (siiActaDestruccion != null) {
                resultado = new ActaDestruccionVO(siiActaDestruccion);

                // persistir las entidades hijas provenientes del Acta de Destrucción
                resultado.setResolucionDecomDestListVo(actaDestruccionVo.getResolucionDecomDestListVo());
                
                
                
                //actualiza elementos de resolucion
                for (ResolucionDecomDestVO resolucionDecomDestVo:actaDestruccionVo.getResolucionDecomDestListVo()){
                    //actualiza resolucion asociada al acta
                    SiiResolucionDecomDest siiResolucionDecomDest = conversionVoEntidad.convertir(resolucionDecomDestVo);
                    siiResolucionDecomDest.setSiiActaDestruccion(siiActaDestruccion);    
                    resolucionDecomDestDao.actualizar(siiResolucionDecomDest);
                    
                    if(resolucionDecomDestVo.getElementoRetiradoAccVoList()!= null){
                        for (ElementoRetiradoAccVO elementoRetiradoAccVo :resolucionDecomDestVo.getElementoRetiradoAccVoList()){
                            if(elementoRetiradoAccVo.getElrDestruido().equals("NO"))
                                elementoRetiradoAccVo.setElrDestruido("N");
                            else 
                                elementoRetiradoAccVo.setElrDestruido("S");
                            elementoRetiradoAccDao.actualizar(conversionVoEntidad.convertir(elementoRetiradoAccVo)); 
                        }  
                    }
                }

                this.persistirHijos(resultado);
            }
        } catch (ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar el Acta de Destrucción: " + e.getMessage());
        }

        return (resultado);
    }

    /**
     * Actualizar la información del Acta de Destrucción.
     * @param actaDestruccionVo
     * @return resultado - Acta de destrucción.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public ActaDestruccionVO actualizarActaDestruccion(ActaDestruccionVO actaDestruccionVo) throws ExcepcionDAO,
                                                                                                   ExcepcionAplicacion {
        ActaDestruccionVO resultado = null;

        try {
           
            SiiActaDestruccion siiActaDestruccion =
                actaDestruccionDao.actualizar(conversionVoEntidad.convertir(actaDestruccionVo));
            
            // deja en null lallave entre  las resoluciones y las actas, registros eliminados de las actas
            if (actaDestruccionVo.getEliminarResolucionSeleccionadaVo() != null){
                for (ResolucionDecomDestVO resolucionDecomDestVo:actaDestruccionVo.getEliminarResolucionSeleccionadaVo()){
                    SiiResolucionDecomDest siiResolucionDecomDest = conversionVoEntidad.convertir(resolucionDecomDestVo);
                    siiResolucionDecomDest.setSiiActaDestruccion(null);    
                    resolucionDecomDestDao.actualizar(siiResolucionDecomDest);
                }
            }
            if (actaDestruccionVo.getResolucionDecomDestListVo()!= null){
                for (ResolucionDecomDestVO resolucionDecomDestVo:actaDestruccionVo.getResolucionDecomDestListVo()){
                    //actualiza resolucion asociada al acta
                    SiiResolucionDecomDest siiResolucionDecomDest = conversionVoEntidad.convertir(resolucionDecomDestVo);
                    siiResolucionDecomDest.setSiiActaDestruccion(siiActaDestruccion);    
                    resolucionDecomDestDao.actualizar(siiResolucionDecomDest);
                    
                    if(resolucionDecomDestVo.getElementoRetiradoAccVoList()!= null){
                        for (ElementoRetiradoAccVO elementoRetiradoAccVo :resolucionDecomDestVo.getElementoRetiradoAccVoList()){
                            if(elementoRetiradoAccVo.getElrDestruido().equals("NO"))
                                elementoRetiradoAccVo.setElrDestruido("N");
                            else 
                                elementoRetiradoAccVo.setElrDestruido("S");
                            elementoRetiradoAccDao.actualizar(conversionVoEntidad.convertir(elementoRetiradoAccVo)); 
                        }    
                    }
                }
            }
            if (siiActaDestruccion != null) {
                resultado = new ActaDestruccionVO(siiActaDestruccion);
                // persistir las entidades hijas provenientes de la nota de credito
                resultado.setResolucionDecomDestListVo(actaDestruccionVo.getResolucionDecomDestListVo());
            }
            //log de estados
            if (resultado.getAdeEstado().equals("B")){
                 adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.ACTA_DESTRUCCION.getId(),
                                                            "B",actaDestruccionVo.getUsuarioConectVo(), siiActaDestruccion.getAdeCodigo());
            }
            if (resultado.getAdeEstado().equals("A")){
                 adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.ACTA_DESTRUCCION.getId(),
                                                            "A",actaDestruccionVo.getUsuarioConectVo(), siiActaDestruccion.getAdeCodigo());
            }
        } catch ( ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar el Acta de Destrucción: " + e.getMessage());
        }

        return (resultado);
    }

    /**
     * Buscar todas las actas de destrucción.
     * @return resultado - lista de todas las actas de destrucción.
     * @throws ExcepcionDAO
     */

    public List<ActaDestruccionVO> buscarTodaActaDestruccion() throws ExcepcionDAO {
        List<ActaDestruccionVO> resultado = null;
        List<SiiActaDestruccion> lista = actaDestruccionDao.buscarTodo();
        if (lista != null) {
            resultado = new ArrayList<ActaDestruccionVO>();
            for (SiiActaDestruccion siiActaDestruccion : lista) {
                if (siiActaDestruccion != null){
                    ActaDestruccionVO actaDestruccionVo =  new ActaDestruccionVO(siiActaDestruccion);
                    if(actaDestruccionVo.getAdeEstado().equals("B")) 
                        actaDestruccionVo.setAdeEstado("BORRADOR");
                    
                    if(actaDestruccionVo.getAdeEstado().equals("A"))
                        actaDestruccionVo.setAdeEstado("APROBADO");
                    
                    resultado.add(actaDestruccionVo);
                }
           }
        }
        return (resultado);
    }
}
