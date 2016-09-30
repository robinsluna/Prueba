/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 26-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoTramResDecDes;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AccionControlDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoComisorioAccConDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoTramResDecDesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionDecomDestDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolDecDesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAccionControl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorioAccCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResDecDes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDecomDest;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolDecDes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AccionControlVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoTramResDecDesVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionDecomDestVO;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolDecDesVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 * Bean que gestiona la resoluciones con decomiso y destrucción.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminResolucionDecomDestBean implements AdminResolucionDecomDest {

    @EJB
    private ResolucionDecomDestDAO resolucionDecomDestDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AccionControlDAO accionControlDao;
    @EJB
    private TramiteResolDecDesDAO tramiteResolDecDesDao;
    @EJB
    private AutoComisorioAccConDAO autoComAccConDAO;
    @EJB
    private EstadoTramResDecDesDAO estadoTramResDecDesDao;
    @EJB
    private  AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private UsuarioDAO usuarioDao;

    /**
     * Constructor.
     */

    public AdminResolucionDecomDestBean() {
        super();
    }

    private void persistirHijos(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO {
        this.persistirListaAccionControlResuelve(resolucionDecomDestVo);
        this.persistirListaAccionControl(resolucionDecomDestVo);
        this.persistirListaTramiteResolDecDes(resolucionDecomDestVo);
    }

    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de las Imputaciones Contables asociadas al Documento Contable.
     * @param resolucionDecomDestVo - Value Object Accion Control.
     * @throws ExcepcionDAO
     */
    private void persistirListaTramiteResolDecDes(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO {
        if(resolucionDecomDestVo != null) {
            List<TramiteResolDecDesVO> accionControlList = resolucionDecomDestVo.getTramiteResolDecDesVoList();
            if(accionControlList != null) {
                for(TramiteResolDecDesVO acVO : accionControlList) {
                    if(acVO != null) {
                        acVO.setResolucionDecomDestVo(resolucionDecomDestVo);
                        SiiTramiteResolDecDes siiAC = conversionVoEntidad.convertir(acVO);
                        if(siiAC != null) {
                            if(siiAC.getTrdCodigo() == null) {
                                // OPERACION INSERTAR
                                tramiteResolDecDesDao.insertar(siiAC);
                            }
                            else {
                                // OPERACION ACTUALIZAR
                                tramiteResolDecDesDao.actualizar(siiAC);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de las Imputaciones Contables asociadas al Documento Contable.
     * @param resolucionDecomDestVo - Value Object Accion Control.
     * @throws ExcepcionDAO
     */
    private void persistirListaAccionControl(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO {
        if(resolucionDecomDestVo != null) {
            List<AccionControlVO> accionControlList = resolucionDecomDestVo.getAccionControlVoList();
            if(accionControlList != null) {
                for(AccionControlVO acVO : accionControlList) {
                    if(acVO != null) {
                        acVO.setResolucionDecomDestVo(resolucionDecomDestVo);
                        SiiAccionControl siiAC = conversionVoEntidad.convertir(acVO);
                        if(siiAC != null) {
                            if(siiAC.getAccCodigo() == null) {
                                // OPERACION INSERTAR
                                accionControlDao.insertar(siiAC);
                            }
                            else {
                                // OPERACION ACTUALIZAR
                                accionControlDao.actualizar(siiAC);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de las Imputaciones Contables asociadas al Documento Contable.
     * @param resolucionDecomDestVo - Value Object Accion Control.
     * @throws ExcepcionDAO
     */
    private void persistirListaAccionControlResuelve(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO {
        if(resolucionDecomDestVo != null) {
            List<AccionControlVO> accionControlList = resolucionDecomDestVo.getAccionControlResuelveVoList();
            if(accionControlList != null) {
                for(AccionControlVO acVO : accionControlList) {
                    if(acVO != null) {
                        acVO.setResolucionDecomDestVo(resolucionDecomDestVo);
                        SiiAccionControl siiAC = conversionVoEntidad.convertir(acVO);
                        if(siiAC != null) {
                            if(siiAC.getAccCodigo() == null) {
                                // OPERACION INSERTAR
                                accionControlDao.insertar(siiAC);
                            }
                            else {
                                // OPERACION ACTUALIZAR
                                accionControlDao.actualizar(siiAC);
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * Insertar la resolución de decomiso y destrucción
     * @param resolucionDecomDestVo
     * @return resultado - Resolución de decomiso y destrucción
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    @Override
    public ResolucionDecomDestVO insertarResolucionDecomDest(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO, ExcepcionAplicacion {
        ResolucionDecomDestVO resultado = null;

        try {
            SiiResolucionDecomDest siiResolucionDecomDest = resolucionDecomDestDao.insertar(conversionVoEntidad.convertir(resolucionDecomDestVo));
            if(siiResolucionDecomDest != null) {
                resultado = new ResolucionDecomDestVO(siiResolucionDecomDest);

                // persistir las entidades hijas provenientes de la resolucion
                resultado.setAccionControlResuelveVoList(resolucionDecomDestVo.getAccionControlResuelveVoList());
                resultado.setAccionControlVoList(resolucionDecomDestVo.getAccionControlVoList());
                resultado.setTramiteResolDecDesVoList(resolucionDecomDestVo.getTramiteResolDecDesVoList());

                persistirHijos(resultado);

            }
        } catch(ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Resolución de Decomiso y Destrucción: " + e.getMessage());
        }

        return (resultado);
    }

    /**
     * Buscar resolución de decomiso y destrucción por id
     * @param rddCodigo
     * @return resultado - ResolucionDecomDestVO
     * @throws ExcepcionDAO
     */

    public ResolucionDecomDestVO buscarResolucionDecomDestVOXId(Long rddCodigo) throws ExcepcionDAO {
        ResolucionDecomDestVO resultado = null;
        SiiResolucionDecomDest siiResolucionDecomDest = resolucionDecomDestDao.buscarPorCodigo(rddCodigo);
        if(siiResolucionDecomDest != null)
            resultado = new ResolucionDecomDestVO(siiResolucionDecomDest);

        return (resultado);
    }

    /**
     * Buscar el estado de la resolución según id de la denuncia
     * @param denCodigo
     * @return String
     * @throws ExcepcionDAO
     */

    public String buscarEstadoResolucionXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        return resolucionDecomDestDao.buscarEstadoResolucionXIdDenuncia(denCodigo);
    }

    /**
     * Buscar el estado de la resolución que resuelve el recurso según id de la denuncia
     * @param denCodigo
     * @return String
     * @throws ExcepcionDAO
     */

    public String buscarEstadoResolucionRecursoXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        return resolucionDecomDestDao.buscarEstadoResolucionRecursoXIdDenuncia(denCodigo);
    }

    /**
     * Buscar el estado de la resolución según id de denuncia
     * @param denCodigo
     * @return rrd_nombre - String
     * @throws ExcepcionDAO
     */

    public Long buscarEstadoTramiteResolucionXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        return resolucionDecomDestDao.buscarEstadoTramiteResolucionXIdDenuncia(denCodigo);
    }

    /**
     * Buscar el estado del trámite de la resolución que resuelve el recurso según id de denuncia
     * @param denCodigo
     * @return Long
     * @throws ExcepcionDAO
     */

    public Long buscarEstadoTramiteResolucionRecursoXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        return resolucionDecomDestDao.buscarEstadoTramiteResolucionRecursoXIdDenuncia(denCodigo);
    }

    /**
     * Buscar todas las resoluciones de decomiso y destrucción.
     * @return resultado - Lista de resoluciones de decomiso y destrucción.
     * @throws ExcepcionDAO
     */
    @Override
    public List<ResolucionDecomDestVO> buscarTodaResolucionDecomDest() throws ExcepcionDAO {
        List<ResolucionDecomDestVO> resultado = null;
        List<SiiResolucionDecomDest> lista = resolucionDecomDestDao.buscarTodo();
        if(lista != null) {
            resultado = new ArrayList<ResolucionDecomDestVO>();
            for(SiiResolucionDecomDest siiResolucionDecomDest : lista) {
                if(siiResolucionDecomDest != null)
                    resultado.add(new ResolucionDecomDestVO(siiResolucionDecomDest));
            }
        }

        return (resultado);
    }

    /**
     * Buscar todas las resoluciones de decomiso y destrucción que no tengan acta de destrucción asociada.
     * @return listaSiiResolucionDecomDest - Lista de resoluciones de decomiso y destrucción
     * @throws ExcepcionDAO
     */

    public List<ResolucionDecomDestVO> buscarTodoResolDecomDestSinActaDestruccion() throws ExcepcionDAO {
        List<ResolucionDecomDestVO> resultado = null;
        List<SiiAccionControl> lista = resolucionDecomDestDao.buscarResolDecomDestSinActaDestruccionDecoDestrDev();
        if(lista != null) {
            resultado = new ArrayList<ResolucionDecomDestVO>();
            for(SiiAccionControl siiAccionControl : lista) {
                List<SiiTramiteResolDecDes> listSiiTramiteResolDecDes = 
                    tramiteResolDecDesDao.buscarTramiteResolDecDesXIdResolucionXIdEstado(siiAccionControl.getSiiResolucionDecomDest().getRddCodigo(),EnumEstadoTramResDecDes.EN_FIRME.getId());
                    if(listSiiTramiteResolDecDes.size()>0){
                        ResolucionDecomDestVO resolucionDecomDestVo = new ResolucionDecomDestVO();
                        AccionControlVO accionControlVo = new AccionControlVO (siiAccionControl);
                        resolucionDecomDestVo = accionControlVo.getResolucionDecomDestVo();
                        resolucionDecomDestVo.setBodega(accionControlVo.getAccBodega());
                        resolucionDecomDestVo.setSucursal(accionControlVo.getAccSucursal());
                        resolucionDecomDestVo.setNumeroAutocomisorio(accionControlVo.getAutoComisorioAccConVo().getAcaNumero());
                        resolucionDecomDestVo.setFechaEjecutora(listSiiTramiteResolDecDes.get(0).getTrdFecha());
                        resolucionDecomDestVo.setRddFechaResolucion(listSiiTramiteResolDecDes.get(0).getSiiResolucionDecomDest().getRddFechaRadicac());
                        resolucionDecomDestVo.setNumActaHechosRetiroBienes(accionControlVo.getAccNumeroActa());
                        resultado.add(resolucionDecomDestVo);
                    }
            }
        }

        return (resultado);
    }

    /**
     * Buscar la resolución de decomiso y destrucción según Id de Acta de Destrucción
     * @param adeCodigo
     * @return resultado - Lista de ResolucionDecomDestVO
     * @throws ExcepcionDAO
     */

    public List<ResolucionDecomDestVO> buscarResolDecomDestXIdActaDestruccion(Long adeCodigo) throws ExcepcionDAO {
    List<ResolucionDecomDestVO> resultado = null;
    List<SiiAccionControl> lista = resolucionDecomDestDao.buscarResolDecomDestXIdActaDestruccion(adeCodigo);
    if(lista != null) {
        resultado = new ArrayList<ResolucionDecomDestVO>();
        for(SiiAccionControl siiAccionControl : lista) {
            List<SiiTramiteResolDecDes> listSiiTramiteResolDecDes = 
                tramiteResolDecDesDao.buscarTramiteResolDecDesXIdResolucionXIdEstado(siiAccionControl.getSiiResolucionDecomDest().getRddCodigo(),null);
                if(listSiiTramiteResolDecDes.size()>0){
                    ResolucionDecomDestVO resolucionDecomDestVo = new ResolucionDecomDestVO();
                    AccionControlVO accionControlVo = new AccionControlVO (siiAccionControl);
                    resolucionDecomDestVo = accionControlVo.getResolucionDecomDestVo();
                    resolucionDecomDestVo.setBodega(accionControlVo.getAccBodega());
                    resolucionDecomDestVo.setSucursal(accionControlVo.getAccSucursal());
                    resolucionDecomDestVo.setNumeroAutocomisorio(accionControlVo.getAutoComisorioAccConVo().getAcaNumero());
                    resolucionDecomDestVo.setFechaEjecutora(listSiiTramiteResolDecDes.get(0).getTrdFecha());
                    resolucionDecomDestVo.setRddFechaResolucion(listSiiTramiteResolDecDes.get(0).getSiiResolucionDecomDest().getRddFechaRadicac());
                    resolucionDecomDestVo.setNumActaHechosRetiroBienes(accionControlVo.getAccNumeroActa());
                    resultado.add(resolucionDecomDestVo);
                }
        }
    }

    return (resultado);
    }

    /**
     * Actualizar la resolución de decomiso y destrucción.
     * @param resolucionDecomDestVo
     * @return resultado - Resolución de decomiso y destrucción.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    @Override
    public ResolucionDecomDestVO actualizarResolucionDecomDest(ResolucionDecomDestVO resolucionDecomDestVo) throws ExcepcionDAO, ExcepcionAplicacion {
        ResolucionDecomDestVO resultado = null;

        try {
            // eliminar entidades hijas pendientes por remover
            //    this.eliminarHijos();


            SiiResolucionDecomDest siiResolucionDecomDest = resolucionDecomDestDao.actualizar(conversionVoEntidad.convertir(resolucionDecomDestVo));
            if(siiResolucionDecomDest != null) {
                resultado = new ResolucionDecomDestVO(siiResolucionDecomDest);

                // persistir las entidades hijas provenientes de la resolucion
                resultado.setAccionControlResuelveVoList(resolucionDecomDestVo.getAccionControlResuelveVoList());
                resultado.setAccionControlVoList(resolucionDecomDestVo.getAccionControlVoList());
                resultado.setTramiteResolDecDesVoList(resolucionDecomDestVo.getTramiteResolDecDesVoList());

                persistirHijos(resultado);
            }
        } catch(ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la Resolución de Decomiso y Destrucción: " + e.getMessage());
        }

        return (resultado);
    }


    @Override
    public Integer buscarConsecutivoResolucion() throws ExcepcionDAO {
        return resolucionDecomDestDao.buscarConsecutivoResolucion();
    }

    /**
     * Buscar el Id de la última resolución agregada según usuario logueado
     * @param usuarioVo
     * @return Long
     * @throws ExcepcionDAO
     */

    public Long buscarIdUltimaResolucion(UsuarioVO usuarioVo) throws ExcepcionDAO {
        return resolucionDecomDestDao.buscarIdUltimaResolucion(usuarioVo);
    }


    @Override
    public SiiAutoComisorioAccCon buscarUnAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO {
        return autoComAccConDAO.buscarUnAutoComisorioAccPorDenuncia(denCodigo);
    }
    @Schedule(minute = "05", hour = "01")
    public void establecerResolucionesDecomDestEnFirme()  {
        
        Date fechaActual = new Date();
            try {
        List<ResolucionDecomDestVO> listaResolucionDecomDestVo = resolucionDecomDestDao.buscarEstadoNumeracionTramiteResolucion();
        SiiEstadoTramResDecDes unSiiEstadoTramResDecDes;
        unSiiEstadoTramResDecDes = estadoTramResDecDesDao.buscarEstadoTramResDecDes("EN FIRME");
        SiiUsuario siiUsuario =  usuarioDao.buscarUsuarioPorLogin("ROOT_SIICOL");
    
        for(ResolucionDecomDestVO rddVo : listaResolucionDecomDestVo) {
                SiiResolucionDecomDest unaSiiResolucionDecomDest = new SiiResolucionDecomDest();
                unaSiiResolucionDecomDest.setRddCodigo(rddVo.getRddCodigo());
                SiiTramiteResolDecDes unaSiiTramiteResolDecDes = new SiiTramiteResolDecDes();
                
                unaSiiTramiteResolDecDes.setSiiResolucionDecomDest(unaSiiResolucionDecomDest);
                unaSiiTramiteResolDecDes.setSiiUsuarioConect(siiUsuario);
                unaSiiTramiteResolDecDes.setTrdFecha(fechaActual);
                unaSiiTramiteResolDecDes.setSiiEstadoTramResDecDes(unSiiEstadoTramResDecDes);   
                tramiteResolDecDesDao.insertar(unaSiiTramiteResolDecDes);
        }

        } catch(ExcepcionDAO e) {
                //    this.mostrarMensajeError("Error al NOTIFICAR la resolución de decomiso y destrucción", e);
                    e.printStackTrace();
         }

    }
        
}
