/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 11-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoOrdenTrabajoVisita;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BarrioOrdenDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BarrioOrdenInfVerDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuadranteOrdTraInfVerDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuadranteOrdenTraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenuncOrdTraInfVerDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DenunciaOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DireccionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ElementoIlegInfVerDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDenunciaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InformeVerificCampoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MunicOrdTraInfVerifDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MunicipioOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OrdenTrabajoVisitaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResultadoVerifCampoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoElemenIlegalidadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrden;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrdenInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdTraInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdenTra;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncOrdTraInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenunciaOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegInfVer;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeVerificCampo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicOrdTraInfVerif;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenTrabajoVisita;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoVerifCampo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCalleDireccion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSectorDirec;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo1Calle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo2Calle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AuditorOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.BarrioOrdenInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.BarrioOrdenVO;
import co.gov.coljuegos.siicol.ejb.vo.CuadranteOrdTraInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.CuadranteOrdenTraVO;
import co.gov.coljuegos.siicol.ejb.vo.DenuncOrdTraInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.DenunciaOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoIlegInfVerVO;
import co.gov.coljuegos.siicol.ejb.vo.InformeVerificCampoVO;
import co.gov.coljuegos.siicol.ejb.vo.MunicOrdTraInfVerifVO;
import co.gov.coljuegos.siicol.ejb.vo.MunicipioOrdenTrabVO;
import co.gov.coljuegos.siicol.ejb.vo.OrdenTrabajoVisitaVO;
import co.gov.coljuegos.siicol.ejb.vo.ResultadoVerifCampoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean para gestionar las órdenes de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminOrdenTrabajoVisitaBean implements AdminOrdenTrabajoVisita {

    @EJB
    private OrdenTrabajoVisitaDAO ordenTrabajoVisitaDao;

    @EJB
    private DenunciaOrdenTrabDAO denunciaOrdenTrabDao;

    @EJB
    private ConversionVOEntidad conversionVoEntidad;

    @EJB
    private AdminAuditorOrdenTrab adminAuditorOrdenTrab;

    @EJB
    private AdminBarrioOrden adminBarrioOrden;

    @EJB
    private AdminCuadranteOrdenTra adminCuadranteOrdenTra;

    @EJB
    private AdminDenunciaOrdenTrab adminDenunciaOrdenTrab;

    @EJB
    private AdminMunicipioOrdenTrab adminMunicipioOrdenTrab;

    @EJB
    private MunicipioOrdenTrabDAO municipioOrdenTrabDao;

    @EJB
    private CuadranteOrdenTraDAO cuadranteOrdenTraDao;

    @EJB
    private BarrioOrdenDAO BarrioOrdenDao;
    @EJB
    private InformeVerificCampoDAO informeVerificCampoDao;
    @EJB
    private ElementoIlegInfVerDAO elementoIlegInfVerDao;

    @EJB
    private TipoElemenIlegalidadDAO tipoElemenIlegalidadDao;
    @EJB
    private DenuncOrdTraInfVerDAO denuncOrdTraInfVerDao;
    @EJB
    private BarrioOrdenInfVerDAO barrioOrdenInfVerDao;
    @EJB
    private CuadranteOrdTraInfVerDAO cuadranteOrdTraInfVerDao;
    @EJB
    private MunicOrdTraInfVerifDAO municOrdTraInfVerifDao;
    @EJB
    private ResultadoVerifCampoDAO resultadoVerifCampoDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private UbicacionDAO ubicacionDao;
    @EJB
    private DireccionDAO direccionDao;
    @EJB
    DenunciaDAO denunciaDao;
    @EJB
    PersonaDAO personaDao;
    @EJB    
    EstadoDenunciaDAO estadoDenunciaDao;
    

    public AdminOrdenTrabajoVisitaBean() {
        super();
    }

    /**
     * Actualiza la orden de trabajo de visita en la base de datos.
     * @param ordenTrabajoVisitaVo
     * @return
     * @throws ExcepcionDAO
     */
    public OrdenTrabajoVisitaVO actualizarOrdenTrabajoVisita(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        try {
            SiiOrdenTrabajoVisita SiiOrdenTrabajoVisita = conversionVoEntidad.convertir(ordenTrabajoVisitaVo);

            SiiOrdenTrabajoVisita = ordenTrabajoVisitaDao.actualizar(SiiOrdenTrabajoVisita);

            // Insertar Log de cambio de estado
            if (ordenTrabajoVisitaVo.getOtvEstado() != null && ordenTrabajoVisitaVo.getUsuarioLogueado() != null && ordenTrabajoVisitaVo.getUsuarioLogueado().getUsuCodigo() != null && SiiOrdenTrabajoVisita != null 
                && SiiOrdenTrabajoVisita.getOtvCodigo() != null) {
                adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.ORDEN_DE_TRABAJO.getId(), 
                                                                            ordenTrabajoVisitaVo.getOtvEstado(), ordenTrabajoVisitaVo.getUsuarioLogueado(), 
                                                                            SiiOrdenTrabajoVisita.getOtvCodigo());
            }
            
            this.persistirHijos(ordenTrabajoVisitaVo);
            
            return new OrdenTrabajoVisitaVO(SiiOrdenTrabajoVisita);
        } catch(ExcepcionAplicacion | ExcepcionDAO ex) {
            throw ex;
        } catch(Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la orden de trabajo de visita: " + e.getMessage());
        }


    }

    /**
     * Obtener la cadena de texto del estado de la orden de trabajo de visita para mostrar.
     * @param estado - Letra que indica el estado de la orden de trabajo.
     * @return estadoOrdenTrab - Cadena de texto del estado de la orden de trabajo.
     */

    public String obtenerEstadoOrdenTrabajoVisita(String estado) {
        String estadoOrdenTrab = "";

        if(estado.matches(EnumEstadoOrdenTrabajoVisita.APROBADO.getId())) {
            estadoOrdenTrab = EnumEstadoOrdenTrabajoVisita.APROBADO.toString();
        }
        else if(estado.matches(EnumEstadoOrdenTrabajoVisita.ANULADO.getId())) {
            estadoOrdenTrab = EnumEstadoOrdenTrabajoVisita.ANULADO.toString();
        }
        if(estado.matches(EnumEstadoOrdenTrabajoVisita.BORRADOR.getId())) {
            estadoOrdenTrab = EnumEstadoOrdenTrabajoVisita.BORRADOR.toString();
        }
        return estadoOrdenTrab;
    }

    /**
     * Buscar todas las órdenes de trabajo de visita
     * @return resultado - Lista de todas las órdenes de trabajo
     * @throws ExcepcionDAO
     */
    public List<OrdenTrabajoVisitaVO> buscarTodaOrdenTrabajoVisita() throws ExcepcionDAO {
        List<OrdenTrabajoVisitaVO> resultado = null;
        List<SiiOrdenTrabajoVisita> lista = ordenTrabajoVisitaDao.buscarTodo();
        if(lista != null) {
            resultado = new ArrayList<OrdenTrabajoVisitaVO>();
            for(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita : lista) {
                if(siiOrdenTrabajoVisita != null) {
                    OrdenTrabajoVisitaVO ordenTrabajoVisitaVo = new OrdenTrabajoVisitaVO(siiOrdenTrabajoVisita);
                    ordenTrabajoVisitaVo.setEstado(this.obtenerEstadoOrdenTrabajoVisita(siiOrdenTrabajoVisita.getOtvEstado()));
                    resultado.add(ordenTrabajoVisitaVo);
                }
            }
        }

        return (resultado);
    }

    public List<OrdenTrabajoVisitaVO> buscarOrdenTrabajoVisitaAprobadas() throws ExcepcionDAO {
        List<OrdenTrabajoVisitaVO> resultado = null;
        List<SiiOrdenTrabajoVisita> lista = ordenTrabajoVisitaDao.buscarOrdenesTrabajoAprobadas();
        if(lista != null) {
            resultado = new ArrayList<OrdenTrabajoVisitaVO>();
            for(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita : lista) {
                if(siiOrdenTrabajoVisita != null) {
                    OrdenTrabajoVisitaVO ordenTrabajoVisitaVo = new OrdenTrabajoVisitaVO(siiOrdenTrabajoVisita);
                    ordenTrabajoVisitaVo.setEstado(this.obtenerEstadoOrdenTrabajoVisita(siiOrdenTrabajoVisita.getOtvEstado()));
                    resultado.add(ordenTrabajoVisitaVo);
                }
            }
        }

        return (resultado);
    }


    /**
     * Obtener el siguiente número consecutivo para la orden de trabajo de visita
     * @return consecutivo
     * @throws ExcepcionDAO
     */
    public Integer obtenerConsecutivoOrdenTrabajoVisita() throws ExcepcionDAO {
        return ordenTrabajoVisitaDao.obtenerConsecutivoOrdenTrabajoVisita();
    }

    /**
     * Inserta la orden de trabajo de visita
     * @param ordenTrabajoVisitaVo
     * @return resultado - la orden de trabajo que se inserta a la bd
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public OrdenTrabajoVisitaVO insertarOrdenTrabajoVisita(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        OrdenTrabajoVisitaVO resultado = null;

        try {
            SiiOrdenTrabajoVisita siiOrdenTrabajoVisita = ordenTrabajoVisitaDao.insertar(conversionVoEntidad.convertir(ordenTrabajoVisitaVo));
            if (siiOrdenTrabajoVisita != null) {
                resultado = new OrdenTrabajoVisitaVO(siiOrdenTrabajoVisita);

                // Persistir las entidades hijas provenientes de la orden de trabajo
                resultado.setAuditorOrdenTrabList(ordenTrabajoVisitaVo.getAuditorOrdenTrabList());
                resultado.setBarrioOrdenList(ordenTrabajoVisitaVo.getBarrioOrdenList());
                resultado.setCuadranteOrdenTraList(ordenTrabajoVisitaVo.getCuadranteOrdenTraList());
                resultado.setDenunciaOrdenTrabList(ordenTrabajoVisitaVo.getDenunciaOrdenTrabList());
                resultado.setMunicipioOrdenTrabList(ordenTrabajoVisitaVo.getMunicipioOrdenTrabList()); 

                // Insertar Log de cambio de estado
                if (ordenTrabajoVisitaVo.getOtvEstado() != null && ordenTrabajoVisitaVo.getUsuarioLogueado() != null 
                    && ordenTrabajoVisitaVo.getUsuarioLogueado().getUsuCodigo() != null && resultado != null 
                    && resultado.getOtvCodigo() != null) {
                    adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.ORDEN_DE_TRABAJO.getId(), 
                                                                                ordenTrabajoVisitaVo.getOtvEstado(), ordenTrabajoVisitaVo.getUsuarioLogueado(), 
                                                                                resultado.getOtvCodigo());
                }
                
                this.persistirHijos(resultado);
            }
        } catch (ExcepcionAplicacion | ExcepcionDAO ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la orden de trabajo de visita: " + e.getMessage());
        }
        return (resultado);
    }

    /**
     * Persiste los hijos de la órden de trabajo
     * @param ordenTrabajoVisitaVo - Nota de Cr&eacute;dito padre.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirHijos(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        this.persistirAuditorOrdenTrab(ordenTrabajoVisitaVo);
        this.persistirBarrioOrden(ordenTrabajoVisitaVo);
        this.persistirCuadranteOrdenTra(ordenTrabajoVisitaVo);
        this.persistirDenunciaOrdenTrab(ordenTrabajoVisitaVo);
        this.persistirMunicipioOrdenTrab(ordenTrabajoVisitaVo);
    }

    /**
     * Persiste los Conceptos asociados a la órden de trabajo de visita especificada
     * @param ordenTrabajoVisitaVo - Órden de trabajo de visita
     * @throws ExcepcionDAO
     */
    private void persistirAuditorOrdenTrab(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO {
        if(ordenTrabajoVisitaVo != null && ordenTrabajoVisitaVo.getAuditorOrdenTrabList() != null) {
            for(AuditorOrdenTrabVO aotVo : ordenTrabajoVisitaVo.getAuditorOrdenTrabList()) {
                if(aotVo != null) {
                    aotVo.setOrdenTrabajoVisitaVO(ordenTrabajoVisitaVo);

                    if(ordenTrabajoVisitaVo.getOtvCodigo() == null) {
                        // OPERACION INSERTAR
                        adminAuditorOrdenTrab.insertarAuditorOrdenTrab(aotVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        adminAuditorOrdenTrab.actualizarAuditorOrdenTrab(aotVo);
                    }
                }
            }
        }
    }

    /**
     * Persiste los Conceptos asociados a la órden de trabajo de visita especificada
     * @param ordenTrabajoVisitaVo - Órden de trabajo de visita
     * @throws ExcepcionDAO
     */
    private void persistirBarrioOrden(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO {
        if(ordenTrabajoVisitaVo != null && ordenTrabajoVisitaVo.getBarrioOrdenList() != null) {
            for(BarrioOrdenVO boVo : ordenTrabajoVisitaVo.getBarrioOrdenList()) {
                if(boVo != null) {
                    boVo.setOrdenTrabajoVisitaVO(ordenTrabajoVisitaVo);

                    if(ordenTrabajoVisitaVo.getOtvCodigo() == null) {
                        // OPERACION INSERTAR
                        adminBarrioOrden.insertarBarrioOrden(boVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        adminBarrioOrden.actualizarBarrioOrden(boVo);
                    }
                }
            }
        }
    }

    /**
     * Persiste los Conceptos asociados a la órden de trabajo de visita especificada
     * @param ordenTrabajoVisitaVo - Órden de trabajo de visita
     * @throws ExcepcionDAO
     */
    private void persistirCuadranteOrdenTra(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO {
        if(ordenTrabajoVisitaVo != null && ordenTrabajoVisitaVo.getCuadranteOrdenTraList() != null) {
            for(CuadranteOrdenTraVO cuoVo : ordenTrabajoVisitaVo.getCuadranteOrdenTraList()) {
                if(cuoVo != null) {
                    cuoVo.setOrdenTrabajoVisitaVO(ordenTrabajoVisitaVo);

                    if(ordenTrabajoVisitaVo.getOtvCodigo() == null) {
                        // OPERACION INSERTAR
                        adminCuadranteOrdenTra.insertarCuadranteOrdenTra(cuoVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        adminCuadranteOrdenTra.actualizarCuadranteOrdenTra(cuoVo, cuoVo.getCotLimite1(), cuoVo.getCotLimite2(), cuoVo.getCotLimite3(), cuoVo.getCotLimite4());
                    }
                }
            }
        }
    }

    /**
     * Persiste los Conceptos asociados a la órden de trabajo de visita especificada
     * @param ordenTrabajoVisitaVo - Órden de trabajo de visita
     * @throws ExcepcionDAO
     */
    private void persistirDenunciaOrdenTrab(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO {
        if(ordenTrabajoVisitaVo != null && ordenTrabajoVisitaVo.getDenunciaOrdenTrabList() != null) {
            for(DenunciaOrdenTrabVO dotVo : ordenTrabajoVisitaVo.getDenunciaOrdenTrabList()) {
                if(dotVo != null) {
                    dotVo.setOrdenTrabajoVisitaVO(ordenTrabajoVisitaVo);

                    if(ordenTrabajoVisitaVo.getOtvCodigo() == null) {
                        // OPERACION INSERTAR
                        adminDenunciaOrdenTrab.insertarDenunciaOrdenTrab(dotVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        adminDenunciaOrdenTrab.actualizarDenunciaOrdenTrab(dotVo);
                    }
                }
            }
        }
    }

    /**
     * Persiste los Conceptos asociados a la órden de trabajo de visita especificada
     * @param ordenTrabajoVisitaVo - Órden de trabajo de visita
     * @throws ExcepcionDAO
     */
    private void persistirMunicipioOrdenTrab(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO {
        if(ordenTrabajoVisitaVo != null && ordenTrabajoVisitaVo.getMunicipioOrdenTrabList() != null) {
            for(MunicipioOrdenTrabVO motVo : ordenTrabajoVisitaVo.getMunicipioOrdenTrabList()) {
                if(motVo != null) {
                    motVo.setOrdenTrabajoVisitaVO(ordenTrabajoVisitaVo);

                    if(ordenTrabajoVisitaVo.getOtvCodigo() == null) {
                        // OPERACION INSERTAR
                        adminMunicipioOrdenTrab.insertarMunicipioOrdenTrab(motVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        adminMunicipioOrdenTrab.actualizarMunicipioOrdenTrab(motVo);
                    }
                }
            }
        }
    }

    public List<OrdenTrabajoVisitaVO> buscarOrdenTrabajoXEstadoAprobado(UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        List<OrdenTrabajoVisitaVO> listOrdenTrabajoVisitaVo = null;
        List<SiiPersona>  listPersona =   personaDao.buscarPersonaPorIdUsuario(usuarioLogueado.getUsuCodigo());
        List<SiiOrdenTrabajoVisita> listSiiOrdenTrabajoVisita = ordenTrabajoVisitaDao.buscarOrdenTrabajoXEstadoAprobado(listPersona.get(0).getPerCodigo());
        if(listSiiOrdenTrabajoVisita != null) {
            listOrdenTrabajoVisitaVo = new ArrayList();
            for(SiiOrdenTrabajoVisita siiOrdenTrabajoVisita : listSiiOrdenTrabajoVisita) {
                List<SiiDenunciaOrdenTrab> listSiiDenunciaOrdenTrab = denunciaOrdenTrabDao.buscarTodoDenunciaOrdenTrabXCodigoOrdenTrab(siiOrdenTrabajoVisita.getOtvCodigo());
                
                OrdenTrabajoVisitaVO ordenTrabajoVisitaVo =new OrdenTrabajoVisitaVO(siiOrdenTrabajoVisita);
                if(listSiiDenunciaOrdenTrab.size()>0 ){
                         ordenTrabajoVisitaVo.setDenunciaOrdenTraVo(new  DenunciaOrdenTrabVO ( listSiiDenunciaOrdenTrab.get(0)));
                }
                else
                    ordenTrabajoVisitaVo.setDenunciaOrdenTraVo(new  DenunciaOrdenTrabVO());
                
                listOrdenTrabajoVisitaVo.add(ordenTrabajoVisitaVo);
            }
        }
        return listOrdenTrabajoVisitaVo;
    }


    public OrdenTrabajoVisitaVO buscarOrdenTrabajoXId(Long idOrden) throws ExcepcionDAO {
        OrdenTrabajoVisitaVO ordenTrabajoVisitaVo = null;
        String direccion  = null;
        DenunciaOrdenTrabVO denunciaOrdenTrabVo;
        List<DenunciaOrdenTrabVO> listDenunciaOrdenTrabVo = new ArrayList();
        List<MunicipioOrdenTrabVO> listMunicipioOrdenTrabVo = new ArrayList();
        List<CuadranteOrdenTraVO> listCuadranteOrdenTraVO = new ArrayList();
        List<DenuncOrdTraInfVerVO>listDenuncOrdTraInfVerVo =new ArrayList();  
        List<ElementoIlegInfVerVO> listElementoIlegInfVerVo = new ArrayList();
        List<BarrioOrdenVO> listBarrioOrdenVo = new ArrayList();
        if(idOrden != null) {
            SiiOrdenTrabajoVisita siiOrdenTrabajoVisita = ordenTrabajoVisitaDao.buscarOrdenTrabajoXId(idOrden);

            if(siiOrdenTrabajoVisita != null) {
                List<SiiDenunciaOrdenTrab> listSiiDenunciaOrdenTrab = denunciaOrdenTrabDao.buscarTodoDenunciaOrdenTrabXCodigoOrdenTrab(idOrden);
                for(SiiDenunciaOrdenTrab siiDenunciaOrdenTrab : listSiiDenunciaOrdenTrab) {
                     denunciaOrdenTrabVo = new DenunciaOrdenTrabVO(siiDenunciaOrdenTrab);
                     direccion = direccionDao.buscarDireccionCompletaXIdDenuncia(siiDenunciaOrdenTrab.getSiiDenuncia().getDenCodigo());
                     denunciaOrdenTrabVo.getDenunciaVO().setDenDenunDireccion(direccion);
                    if(denunciaOrdenTrabVo.getDenunciaVO().getUbicacionLocalVO() != null ){
                                   denunciaOrdenTrabVo.getDenunciaVO().setMunicipio(denunciaOrdenTrabVo.getDenunciaVO().getUbicacionLocalVO().getUbiNombre());  
                                   SiiUbicacion unaSiiUbicacion = ubicacionDao.buscarUbicacionPorId(denunciaOrdenTrabVo.getDenunciaVO().getUbicacionLocalVO().getUbiCodigoPadre());
                                   denunciaOrdenTrabVo.getDenunciaVO().setDepartamento(unaSiiUbicacion.getUbiNombre());
                   }
                    List<SiiDenuncOrdTraInfVer> ListTempDenun = denuncOrdTraInfVerDao.buscarDenuncOrdTraInfVerPorDotCodigo(denunciaOrdenTrabVo.getDotCodigo());
                    for (SiiDenuncOrdTraInfVer  unaSiiDenuncOrdTraInfVer : ListTempDenun){
                       DenuncOrdTraInfVerVO denuncOrdTraInfVerVo = new DenuncOrdTraInfVerVO(unaSiiDenuncOrdTraInfVer);
                        listDenuncOrdTraInfVerVo.add(denuncOrdTraInfVerVo);
                        
                    }
                    
                    denunciaOrdenTrabVo.setListDenuncOrdTraInfVerVo(listDenuncOrdTraInfVerVo);
                    listDenunciaOrdenTrabVo.add(denunciaOrdenTrabVo);
                }
                ordenTrabajoVisitaVo = new OrdenTrabajoVisitaVO(siiOrdenTrabajoVisita);
                ordenTrabajoVisitaVo.setDenunciaOrdenTrabList(listDenunciaOrdenTrabVo);

                List<SiiMunicipioOrdenTrab> listSiiMunicipioOrdenTrab = municipioOrdenTrabDao.buscarTodoMunicipioOrdenTrabXCodigoOrdenTrab(idOrden);
                for(SiiMunicipioOrdenTrab SiiMunicipioOrdenTrab : listSiiMunicipioOrdenTrab) {
                    MunicipioOrdenTrabVO municipioOrdenTrabVo = new MunicipioOrdenTrabVO();
                    municipioOrdenTrabVo = new MunicipioOrdenTrabVO(SiiMunicipioOrdenTrab);
                    listMunicipioOrdenTrabVo.add(municipioOrdenTrabVo);
                }
                ordenTrabajoVisitaVo.setMunicipioOrdenTrabList(listMunicipioOrdenTrabVo);

                List<SiiCuadranteOrdenTra> lisSiiCuadranteOrdenTra = cuadranteOrdenTraDao.buscarTodoCuadranteXOrdenTrab(idOrden);
                for(SiiCuadranteOrdenTra unSiiCuadranteOrdenTra : lisSiiCuadranteOrdenTra) {
                    listCuadranteOrdenTraVO.add(new CuadranteOrdenTraVO(unSiiCuadranteOrdenTra));
                }
                ordenTrabajoVisitaVo.setCuadranteOrdenTraList(listCuadranteOrdenTraVO);

                List<SiiBarrioOrden> listSiiBarrioOrden = BarrioOrdenDao.buscarTodoBarrioOrdenXCodigoOrdenTrab(idOrden);
                for(SiiBarrioOrden unSiiBarrioOrden : listSiiBarrioOrden) {
                    List<SiiBarrioOrdenInfVer> siiBarrioOrdenInfVerList = barrioOrdenInfVerDao.buscarBarrioOrdenInfVerPorBorCodigo(unSiiBarrioOrden.getBorCodigo());
                    unSiiBarrioOrden.setSiiBarrioOrdenInfVerList(siiBarrioOrdenInfVerList);
                    listBarrioOrdenVo.add(new BarrioOrdenVO(unSiiBarrioOrden));
                }
                ordenTrabajoVisitaVo.setBarrioOrdenList(listBarrioOrdenVo);

            }
        }

        return ordenTrabajoVisitaVo;

    }

    public InformeVerificCampoVO insertarInformeVerificCampo(InformeVerificCampoVO InformeVerificCampoVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        InformeVerificCampoVO unInformeVerificCampoVo = new InformeVerificCampoVO();
        SiiInformeVerificCampo siiInformeVerificCampo = new SiiInformeVerificCampo();
        siiInformeVerificCampo.setIvcFecha(new Date());
        SiiTipoElemenIlegalidad siiTipoElemenIlegalidad = new SiiTipoElemenIlegalidad();
        siiInformeVerificCampo.setSiiOrdenTrabajoVisita(conversionVoEntidad.convertir(InformeVerificCampoVo.getOrdenTrabajoVisitaVo()));
        siiInformeVerificCampo.setSiiAuditorOrdenTrab(conversionVoEntidad.convertir(InformeVerificCampoVo.getAuditorOrdenTrabVo()));
        SiiInformeVerificCampo tempsiiInformeVerificCampo = informeVerificCampoDao.buscarSiiInformeVerificCampoPorOrdenId(InformeVerificCampoVo.getOrdenTrabajoVisitaVo().getOtvCodigo());
        List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = new ArrayList();

        try{


        if(tempsiiInformeVerificCampo == null) {
            siiInformeVerificCampo = informeVerificCampoDao.insertarInformeVerificCampo(siiInformeVerificCampo);
        }
        else
            siiInformeVerificCampo = tempsiiInformeVerificCampo;

        for(BarrioOrdenVO BarrioOrdenVo : InformeVerificCampoVo.getListBarrioOrdenVo()) {
            List<SiiBarrioOrdenInfVer> ListTempBar = barrioOrdenInfVerDao.buscarBarrioOrdenInfVerPorBorCodigo(BarrioOrdenVo.getBorCodigo());
            if(BarrioOrdenVo.getListBarrioOrdenInfVerVo() != null) {
                for(BarrioOrdenInfVerVO unBarrioOrdenInfVerVo : BarrioOrdenVo.getListBarrioOrdenInfVerVo()) {
                    SiiBarrioOrdenInfVer siiBarrioOrdenInfVer = conversionVoEntidad.convertir(unBarrioOrdenInfVerVo);
                    siiBarrioOrdenInfVer.setSiiInformeVerificCampo(siiInformeVerificCampo);
                    siiBarrioOrdenInfVer.setBivActivo("S");
                    siiBarrioOrdenInfVer = barrioOrdenInfVerDao.insertarSiiBarrioOrdenInfVer(siiBarrioOrdenInfVer);

                    for(ElementoIlegInfVerVO elementoIlegInfVerVo : unBarrioOrdenInfVerVo.getListElementoIlegInfVerVo()) {
                        siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(elementoIlegInfVerVo.getTipoElemento());
                        SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
                        elementoIlegInfVer.setSiiBarrioOrdenInfVer(siiBarrioOrdenInfVer);
                        elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                        elementoIlegInfVer.setEivActivo("S");
                        elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                    }
                    //actualiza elementos de la orden de trabajo
                    if(unBarrioOrdenInfVerVo.getListEliminarElementoIlegInfVerVo()!= null){
                        for ( ElementoIlegInfVerVO unElementoIlegInfVerVo : unBarrioOrdenInfVerVo.getListEliminarElementoIlegInfVerVo()){
                            if(unElementoIlegInfVerVo.getEivCodigo() != null) {
                                SiiElementoIlegInfVer unSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementoIlegInfVerPorId(unElementoIlegInfVerVo.getEivCodigo());
                                unSiiElementoIlegInfVer.setEivActivo("N");
                                elementoIlegInfVerDao.actualizarElementoIlegInfVer(unSiiElementoIlegInfVer);
                            }
                        }
                     }
                    
                }
            }
            // para el borrado de registros  BarrioOrdenInfVer
            for(int i = 0; i < ListTempBar.size(); i++) {
                boolean temp = false;
                //valida registros para borrar
                for(int j = 0; j < BarrioOrdenVo.getListBarrioOrdenInfVerVo().size(); j++) {
                    if(ListTempBar.get(i).getBivCodigo() == BarrioOrdenVo.getListBarrioOrdenInfVerVo().get(j).getBivCodigo()) {
                        temp = true;
                    }
                }
                //desactiva elementos asociados al BarrioOrdenInfVer
                if(temp == false) {
                    listSiiElementoIlegInfVer = new ArrayList();
                    listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(ListTempBar.get(i).getBivCodigo(), null, null, null);
                    for(SiiElementoIlegInfVer SiiElementoIlegInfVer : listSiiElementoIlegInfVer) {
                        SiiElementoIlegInfVer.setEivActivo("N");
                        elementoIlegInfVerDao.actualizarElementoIlegInfVer(SiiElementoIlegInfVer);
                    }
                    //descativar  BarrioOrdenInfVer
                    ListTempBar.get(i).setBivActivo("N");
                    barrioOrdenInfVerDao.actualizarBarrioOrdenInfVer(ListTempBar.get(i));
                }
            }
        }

        for(MunicipioOrdenTrabVO municipioOrdenTrabVo : InformeVerificCampoVo.getListMunicipioOrdenTrabVo()) {
            List<SiiMunicOrdTraInfVerif> ListTempMun = municOrdTraInfVerifDao.buscarMunicOrdTraInfVerifPorMotCodigo(municipioOrdenTrabVo.getMotCodigo());
            if(municipioOrdenTrabVo.getListMunicOrdTraInfVerifVo() != null) {
                for(MunicOrdTraInfVerifVO municOrdTraInfVerifVo : municipioOrdenTrabVo.getListMunicOrdTraInfVerifVo()) {
                    SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif = conversionVoEntidad.convertir(municOrdTraInfVerifVo);
                    siiMunicOrdTraInfVerif.setMivActivo("S");
                    siiMunicOrdTraInfVerif.setSiiInformeVerificCampo(siiInformeVerificCampo);
                    siiMunicOrdTraInfVerif = municOrdTraInfVerifDao.insertarMunicOrdTraInfVerif(siiMunicOrdTraInfVerif);

                    for(ElementoIlegInfVerVO elementoIlegInfVerVo : municOrdTraInfVerifVo.getElementoIlegInfVerVo()) {
                        siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(elementoIlegInfVerVo.getTipoElemento());
                        SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
                        elementoIlegInfVer.setSiiMunicOrdTraInfVerif(siiMunicOrdTraInfVerif);
                        elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                        elementoIlegInfVer.setEivActivo("S");
                        elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                    }
                    //actualiza elementos de la orden de trabajo
                    if(municOrdTraInfVerifVo.getLisEliminarElementoIlegInfVerVo()!= null){
                        for ( ElementoIlegInfVerVO unElementoIlegInfVerVo : municOrdTraInfVerifVo.getLisEliminarElementoIlegInfVerVo()){
                            if(unElementoIlegInfVerVo.getEivCodigo() != null) {
                                SiiElementoIlegInfVer unSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementoIlegInfVerPorId(unElementoIlegInfVerVo.getEivCodigo());
                                unSiiElementoIlegInfVer.setEivActivo("N");
                                elementoIlegInfVerDao.actualizarElementoIlegInfVer(unSiiElementoIlegInfVer);
                            }
                        }
                     }
                }
            }
            // para el borrado de registros  MunicOrdTraInfVerif
            for(int i = 0; i < ListTempMun.size(); i++) {
                boolean temp = false;
                //valida registros para borrar
                for(int j = 0; j < municipioOrdenTrabVo.getListMunicOrdTraInfVerifVo().size(); j++) {
                    if(ListTempMun.get(i).getMivCodigo() == municipioOrdenTrabVo.getListMunicOrdTraInfVerifVo().get(j).getMivCodigo()) {
                        temp = true;
                    }
                }
                //desactiva elementos asociados al MunicOrdTraInfVerif
                if(temp == false) {
                    listSiiElementoIlegInfVer = new ArrayList();
                    listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(ListTempMun.get(i).getMivCodigo(), null, null, null);
                    for(SiiElementoIlegInfVer SiiElementoIlegInfVer : listSiiElementoIlegInfVer) {
                        SiiElementoIlegInfVer.setEivActivo("N");
                        elementoIlegInfVerDao.actualizarElementoIlegInfVer(SiiElementoIlegInfVer);
                    }
                    //descativar  MunicOrdTraInfVerif
                    ListTempMun.get(i).setMivActivo("N");
                    municOrdTraInfVerifDao.actualizarBarrioOrdenInfVer(ListTempMun.get(i));
                }
            }
        }
        for(CuadranteOrdenTraVO cuadranteOrdenTraVo : InformeVerificCampoVo.getListCuadranteOrdenTraVo()) {
            List<SiiCuadranteOrdTraInfVer> ListTempCua = cuadranteOrdTraInfVerDao.buscarCuadranteOrdTraInfVerPorCotCodigo(cuadranteOrdenTraVo.getCotCodigo());
            if(cuadranteOrdenTraVo.getListCuadranteOrdTraInfVerVo() != null) {
                for(CuadranteOrdTraInfVerVO cuadranteOrdTraInfVerVo : cuadranteOrdenTraVo.getListCuadranteOrdTraInfVerVo()) {
                    SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer = conversionVoEntidad.convertir(cuadranteOrdTraInfVerVo);
                    siiCuadranteOrdTraInfVer.setSiiInformeVerificCampo1(siiInformeVerificCampo);
                    siiCuadranteOrdTraInfVer.setCivActivo("S");
                    siiCuadranteOrdTraInfVer = cuadranteOrdTraInfVerDao.insertarCuadranteOrdTraInfVer(siiCuadranteOrdTraInfVer);

                    if(cuadranteOrdTraInfVerVo.getListElementoIlegInfVer() != null) {
                        for(ElementoIlegInfVerVO elementoIlegInfVerVo : cuadranteOrdTraInfVerVo.getListElementoIlegInfVer()) {
                            siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(elementoIlegInfVerVo.getTipoElemento());
                            SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
                            elementoIlegInfVer.setSiiCuadranteOrdTraInfVer(siiCuadranteOrdTraInfVer);
                            elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                            elementoIlegInfVer.setEivActivo("S");
                            elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                        }
                    }
                    //actualiza elementos de la orden de trabajo
                    if(cuadranteOrdTraInfVerVo.getListEliminarElementoIlegInfVer()!= null){
                        for ( ElementoIlegInfVerVO unElementoIlegInfVerVo : cuadranteOrdTraInfVerVo.getListEliminarElementoIlegInfVer()){
                            if(unElementoIlegInfVerVo.getEivCodigo() != null) {
                                SiiElementoIlegInfVer unSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementoIlegInfVerPorId(unElementoIlegInfVerVo.getEivCodigo());
                                unSiiElementoIlegInfVer.setEivActivo("N");
                                elementoIlegInfVerDao.actualizarElementoIlegInfVer(unSiiElementoIlegInfVer);
                            }
                        }
                     }
                }
                
            }
            // para el borrado de registros  CuadranteOrdTraInfVer
            for(int i = 0; i < ListTempCua.size(); i++) {
                boolean temp = false;
                //valida registros para borrar
                for(int j = 0; j < cuadranteOrdenTraVo.getListCuadranteOrdTraInfVerVo().size(); j++) {
                    if(ListTempCua.get(i).getCivCodigo() == cuadranteOrdenTraVo.getListCuadranteOrdTraInfVerVo().get(j).getCivCodigo()) {
                        temp = true;
                    }
                }
                //desactiva elementos asociados al CuadranteOrdTraInfVer
                if(temp == false) {
                    listSiiElementoIlegInfVer = new ArrayList();
                    listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(ListTempCua.get(i).getCivCodigo(), null, null, null);
                    for(SiiElementoIlegInfVer SiiElementoIlegInfVer : listSiiElementoIlegInfVer) {
                        SiiElementoIlegInfVer.setEivActivo("N");
                        elementoIlegInfVerDao.actualizarElementoIlegInfVer(SiiElementoIlegInfVer);
                    }
                    //descativar  MunicOrdTraInfVerif
                    ListTempCua.get(i).setCivActivo("N");
                    cuadranteOrdTraInfVerDao.actualizarCuadranteOrdTraInfVer(ListTempCua.get(i));
                }
            }
        }

        for (DenunciaOrdenTrabVO denunciaOrdenTrabVo:  InformeVerificCampoVo.getDenunciaOrdenTrabList()) {
            List<SiiResultadoVerifCampo> listSiiResultadoVerifCampo =  resultadoVerifCampoDao.buscarTodo();
            
            //actualiza estado de la denuncia
           /* if ( denunciaOrdenTrabVo.getDenunciaVO().getEstadoDenunciaVO().getEdnCodigo()< 6){
                SiiDenuncia siiDenuncia = conversionVoEntidad.convertir(denunciaOrdenTrabVo.getDenunciaVO());
                SiiEstadoDenuncia siiEstadoDenuncia = estadoDenunciaDao.buscarEstadoPorNombre("VERIFICADO CAMPO");
                siiDenuncia.setSiiEstadoDenuncia(siiEstadoDenuncia);
                denunciaDao.actualizar(siiDenuncia);
                
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.INFORME_VERIFICACION_CAMPO.getId(),
                                                            siiEstadoDenuncia.getEdnCodigo(),
                                                            usuarioLogueado, siiDenuncia.getDenCodigo());
            }*/
            
            if(denunciaOrdenTrabVo.getListDenuncOrdTraInfVerVo() != null){
                List<SiiDenuncOrdTraInfVer> ListTempDenun = denuncOrdTraInfVerDao.buscarDenuncOrdTraInfVerPorDotCodigo(denunciaOrdenTrabVo.getDotCodigo());
                for(DenuncOrdTraInfVerVO denuncOrdTraInfVerVo : denunciaOrdenTrabVo.getListDenuncOrdTraInfVerVo()) {
                    
                    SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer = conversionVoEntidad.convertir(denuncOrdTraInfVerVo);
                    if(denuncOrdTraInfVerVo.getDivCodigo() == null) {
                        for(SiiResultadoVerifCampo siiResultadoVerifCampo :listSiiResultadoVerifCampo){
                            if(siiResultadoVerifCampo.getRvcNombre().equals(denuncOrdTraInfVerVo.getResultadoVerificacion()) ){
                                siiDenuncOrdTraInfVer.setSiiResultadoVerifCampo(siiResultadoVerifCampo);
                                break;
                            }
                        }
                        siiDenuncOrdTraInfVer.setSiiInformeVerificCampo(siiInformeVerificCampo);
                        siiDenuncOrdTraInfVer.setDivActivo("S");
                        siiDenuncOrdTraInfVer = denuncOrdTraInfVerDao.insertarDenuncOrdTraInfVer(siiDenuncOrdTraInfVer);
    
                        if(denuncOrdTraInfVerVo.getListElementoIlegInfVerVo() != null) {
                            for(ElementoIlegInfVerVO elementoIlegInfVerVo : denuncOrdTraInfVerVo.getListElementoIlegInfVerVo()) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(elementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiDenuncOrdTraInfVer(siiDenuncOrdTraInfVer);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                    else {
                        if (denuncOrdTraInfVerVo.getListElementoIlegInfVerVo() != null ){
                            for(ElementoIlegInfVerVO unElementoIlegInfVerVo : denuncOrdTraInfVerVo.getListElementoIlegInfVerVo()) {
                                if(unElementoIlegInfVerVo.getEivCodigo() == null) {
                                    siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(unElementoIlegInfVerVo.getTipoElemento());
                                    SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(unElementoIlegInfVerVo);
                                    elementoIlegInfVer.setSiiDenuncOrdTraInfVer(siiDenuncOrdTraInfVer);
                                    elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                    elementoIlegInfVer.setEivActivo("S");
                                    elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                                }
                            }
                        }
                    }
                    //actualiza elementos de la orden de trabajo
                    if(denuncOrdTraInfVerVo.getListEliminarElementoIlegInfVerVo()!= null){
                        for ( ElementoIlegInfVerVO unElementoIlegInfVerVo : denuncOrdTraInfVerVo.getListEliminarElementoIlegInfVerVo()){
                            if(unElementoIlegInfVerVo.getEivCodigo() != null) {
                                SiiElementoIlegInfVer unSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementoIlegInfVerPorId(unElementoIlegInfVerVo.getEivCodigo());
                                unSiiElementoIlegInfVer.setEivActivo("N");
                                elementoIlegInfVerDao.actualizarElementoIlegInfVer(unSiiElementoIlegInfVer);
                            }
                        }
                     }
                }
           
                // para el borrado de registros  CuadranteOrdTraInfVer
                for(int i = 0; i < ListTempDenun.size(); i++) {
                    listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(null, null, null, ListTempDenun.get(i).getDivCodigo());
                    boolean temp = false;
                    //valida registros para actualizar
                    for(int j = 0; j < denunciaOrdenTrabVo.getListDenuncOrdTraInfVerVo().size(); j++) {
                        if(ListTempDenun.get(i).getDivCodigo() == denunciaOrdenTrabVo.getListDenuncOrdTraInfVerVo().get(j).getDivCodigo()) {
                            temp = true;
                        }                        
                    }
                    //desactiva elementos asociados al CuadranteOrdTraInfVer
                    listSiiElementoIlegInfVer = new ArrayList();
                    if(temp == false) {
                        for(SiiElementoIlegInfVer SiiElementoIlegInfVer : listSiiElementoIlegInfVer) {
                           
                        }
                        //descativar  MunicOrdTraInfVerif
                        ListTempDenun.get(i).setDivActivo("N");
                        denuncOrdTraInfVerDao.actualizarDenuncOrdTraInfVer(ListTempDenun.get(i));
                    }                    
                }
                
                
            }
            
        }
        } catch (ExcepcionDAO ex){
            ex.printStackTrace();
            throw ex;
        } 


        return unInformeVerificCampoVo;
    }

    public List<BarrioOrdenInfVerVO> buscarBarrioOrdenInfVerPorBorCodigo(Long borCodigo) throws ExcepcionDAO {
        List<BarrioOrdenInfVerVO> listBarrioOrdenInfVerVo = new ArrayList();
        List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = new ArrayList();
        List<ElementoIlegInfVerVO> listElementoIlegInfVerVo = new ArrayList();
        List<SiiBarrioOrdenInfVer> siilistBarrioOrdenInfVer = barrioOrdenInfVerDao.buscarBarrioOrdenInfVerPorBorCodigo(borCodigo);
        for(SiiBarrioOrdenInfVer siiBarrioOrdenInfVer : siilistBarrioOrdenInfVer) {
            listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(siiBarrioOrdenInfVer.getBivCodigo(), null, null, null);
            listElementoIlegInfVerVo = new ArrayList();
            for(int i = 0; i < listSiiElementoIlegInfVer.size(); i++) {
                ElementoIlegInfVerVO unElementoIlegInfVerVo = new ElementoIlegInfVerVO(listSiiElementoIlegInfVer.get(i));
                listElementoIlegInfVerVo.add(unElementoIlegInfVerVo);
            }
            BarrioOrdenInfVerVO barrioOrdenInfVerVo = new BarrioOrdenInfVerVO(siiBarrioOrdenInfVer);
            barrioOrdenInfVerVo.setListElementoIlegInfVerVo(listElementoIlegInfVerVo);
            listBarrioOrdenInfVerVo.add(barrioOrdenInfVerVo);

        }

        return listBarrioOrdenInfVerVo;

    }

    public List<CuadranteOrdTraInfVerVO> buscarCuadranteOrdTraInfVerPorCotCodigo(Long cotCodigo) throws ExcepcionDAO {
        List<CuadranteOrdTraInfVerVO> listCuadranteOrdTraInfVerVo = new ArrayList();
        List<ElementoIlegInfVerVO> listElementoIlegInfVerVo = new ArrayList();
        List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = new ArrayList();
        List<SiiCuadranteOrdTraInfVer> listCuadranteOrdTraInfVer = cuadranteOrdTraInfVerDao.buscarCuadranteOrdTraInfVerPorCotCodigo(cotCodigo);
        for(SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer : listCuadranteOrdTraInfVer) {
            listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(null, null, siiCuadranteOrdTraInfVer.getCivCodigo(), null);
            listElementoIlegInfVerVo = new ArrayList();
            for(int i = 0; i < listSiiElementoIlegInfVer.size(); i++) {
                ElementoIlegInfVerVO unElementoIlegInfVerVo = new ElementoIlegInfVerVO(listSiiElementoIlegInfVer.get(i));
                listElementoIlegInfVerVo.add(unElementoIlegInfVerVo);
            }
            CuadranteOrdTraInfVerVO cuadranteOrdTraInfVerVo = new CuadranteOrdTraInfVerVO(siiCuadranteOrdTraInfVer);
            cuadranteOrdTraInfVerVo.setRvcNombre("Pendiente Operativo");
            cuadranteOrdTraInfVerVo.setListElementoIlegInfVer(listElementoIlegInfVerVo);
            listCuadranteOrdTraInfVerVo.add(cuadranteOrdTraInfVerVo);
        }

        return listCuadranteOrdTraInfVerVo;
    }


    public List<MunicOrdTraInfVerifVO> buscarMunicOrdTraInfVerifPorMotCodigo(Long motCodigo) throws ExcepcionDAO {
        List<SiiMunicOrdTraInfVerif> listSiiMunicOrdTraInfVerif = municOrdTraInfVerifDao.buscarMunicOrdTraInfVerifPorMotCodigo(motCodigo);
        List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = new ArrayList();
        List<ElementoIlegInfVerVO> listElementoIlegInfVerVo = new ArrayList();
        List<MunicOrdTraInfVerifVO> listMunicOrdTraInfVerifVo = new ArrayList();
        for(SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif : listSiiMunicOrdTraInfVerif) {
            listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(null, siiMunicOrdTraInfVerif.getMivCodigo(), null, null);
            listElementoIlegInfVerVo = new ArrayList();
            for(int i = 0; i < listSiiElementoIlegInfVer.size(); i++) {
                ElementoIlegInfVerVO unElementoIlegInfVerVo = new ElementoIlegInfVerVO(listSiiElementoIlegInfVer.get(i));
                listElementoIlegInfVerVo.add(unElementoIlegInfVerVo);
            }
            MunicOrdTraInfVerifVO municOrdTraInfVerifVo = new MunicOrdTraInfVerifVO(siiMunicOrdTraInfVerif);
            municOrdTraInfVerifVo.setElementoIlegInfVerVo(listElementoIlegInfVerVo);
            listMunicOrdTraInfVerifVo.add(municOrdTraInfVerifVo);

        }

        return listMunicOrdTraInfVerifVo;

    }


    public InformeVerificCampoVO actualizarInformeVerificacion(OrdenTrabajoVisitaVO ordenTrabajoVisitaVo) throws ExcepcionDAO {
        InformeVerificCampoVO unInformeVerificCampoVo = new InformeVerificCampoVO();
        SiiBarrioOrdenInfVer siiBarrioOrdenInfVer = new SiiBarrioOrdenInfVer();
        SiiTipoElemenIlegalidad siiTipoElemenIlegalidad = new SiiTipoElemenIlegalidad();
        SiiInformeVerificCampo siiInformeVerificCampo = informeVerificCampoDao.buscarSiiInformeVerificCampoPorOrdenId(ordenTrabajoVisitaVo.getOtvCodigo());


        for(BarrioOrdenVO BarrioOrdenVo : ordenTrabajoVisitaVo.getBarrioOrdenList()) {
            List<SiiBarrioOrdenInfVer> ListTempBar = barrioOrdenInfVerDao.buscarBarrioOrdenInfVerPorBorCodigo(BarrioOrdenVo.getBorCodigo());
            if(BarrioOrdenVo.getListBarrioOrdenInfVerVo() != null) {
                for(BarrioOrdenInfVerVO unBarrioOrdenInfVerVo : BarrioOrdenVo.getListBarrioOrdenInfVerVo()) {
                    siiBarrioOrdenInfVer = conversionVoEntidad.convertir(unBarrioOrdenInfVerVo);
                    if(unBarrioOrdenInfVerVo.getBivCodigo() == null) {
                        siiBarrioOrdenInfVer = conversionVoEntidad.convertir(unBarrioOrdenInfVerVo);
                        siiBarrioOrdenInfVer.setSiiInformeVerificCampo(siiInformeVerificCampo);
                        siiBarrioOrdenInfVer.setBivActivo("S");
                        siiBarrioOrdenInfVer = barrioOrdenInfVerDao.insertarSiiBarrioOrdenInfVer(siiBarrioOrdenInfVer);

                        if(unBarrioOrdenInfVerVo.getListElementoIlegInfVerVo() != null) {
                            for(ElementoIlegInfVerVO elementoIlegInfVerVo : unBarrioOrdenInfVerVo.getListElementoIlegInfVerVo()) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(elementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiBarrioOrdenInfVer(siiBarrioOrdenInfVer);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                    else {
                        for(ElementoIlegInfVerVO unElementoIlegInfVerVo : unBarrioOrdenInfVerVo.getListElementoIlegInfVerVo()) {
                            if(unElementoIlegInfVerVo.getEivCodigo() == null) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(unElementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(unElementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiBarrioOrdenInfVer(siiBarrioOrdenInfVer);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                }
            }

            // para el borrado de registros  BarrioOrdenInfVer
            for(int i = 0; i < ListTempBar.size(); i++) {
                boolean temp = false;
                //valida registros para borrar
                for(int j = 0; j < BarrioOrdenVo.getListBarrioOrdenInfVerVo().size(); j++) {
                    if(ListTempBar.get(i).getBivCodigo() == BarrioOrdenVo.getListBarrioOrdenInfVerVo().get(j).getBivCodigo()) {
                        temp = true;
                    }
                }
                //desactiva elementos asociados al BarrioOrdenInfVer
                if(temp == false) {
                    List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(ListTempBar.get(i).getBivCodigo(), null, null, null);
                    for(SiiElementoIlegInfVer SiiElementoIlegInfVer : listSiiElementoIlegInfVer) {
                        SiiElementoIlegInfVer.setEivActivo("N");
                        elementoIlegInfVerDao.actualizarElementoIlegInfVer(SiiElementoIlegInfVer);
                    }
                    //descativar  BarrioOrdenInfVer
                    ListTempBar.get(i).setBivActivo("N");
                    barrioOrdenInfVerDao.actualizarBarrioOrdenInfVer(ListTempBar.get(i));
                }
            }
        }


        for(MunicipioOrdenTrabVO municipioOrdenTrabVo : ordenTrabajoVisitaVo.getMunicipioOrdenTrabList()) {
            List<SiiMunicOrdTraInfVerif> ListTempMun = municOrdTraInfVerifDao.buscarMunicOrdTraInfVerifPorMotCodigo(municipioOrdenTrabVo.getMotCodigo());
            if(municipioOrdenTrabVo.getListMunicOrdTraInfVerifVo() != null) {
                for(MunicOrdTraInfVerifVO unMunicOrdTraInfVerifVo : municipioOrdenTrabVo.getListMunicOrdTraInfVerifVo()) {
                    SiiMunicOrdTraInfVerif siiMunicOrdTraInfVerif = conversionVoEntidad.convertir(unMunicOrdTraInfVerifVo);
                    if(unMunicOrdTraInfVerifVo.getMivCodigo() == null) {
                        siiMunicOrdTraInfVerif.setSiiInformeVerificCampo(siiInformeVerificCampo);
                        siiMunicOrdTraInfVerif.setMivActivo("S");
                        siiMunicOrdTraInfVerif = municOrdTraInfVerifDao.insertarMunicOrdTraInfVerif(siiMunicOrdTraInfVerif);

                        if(unMunicOrdTraInfVerifVo.getElementoIlegInfVerVo() != null) {
                            for(ElementoIlegInfVerVO elementoIlegInfVerVo : unMunicOrdTraInfVerifVo.getElementoIlegInfVerVo()) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(elementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiMunicOrdTraInfVerif(siiMunicOrdTraInfVerif);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                    else {
                        for(ElementoIlegInfVerVO unElementoIlegInfVerVo : unMunicOrdTraInfVerifVo.getElementoIlegInfVerVo()) {
                            if(unElementoIlegInfVerVo.getEivCodigo() == null) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(unElementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(unElementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiMunicOrdTraInfVerif(siiMunicOrdTraInfVerif);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                }
            }
            // para el borrado de registros  MunicOrdTraInfVerif
            for(int i = 0; i < ListTempMun.size(); i++) {
                boolean temp = false;
                //valida registros para borrar
                for(int j = 0; j < municipioOrdenTrabVo.getListMunicOrdTraInfVerifVo().size(); j++) {
                    if(ListTempMun.get(i).getMivCodigo() == municipioOrdenTrabVo.getListMunicOrdTraInfVerifVo().get(j).getMivCodigo()) {
                        temp = true;
                    }
                }
                //desactiva elementos asociados al MunicOrdTraInfVerif
                if(temp == false) {
                    List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(ListTempMun.get(i).getMivCodigo(), null, null, null);
                    for(SiiElementoIlegInfVer SiiElementoIlegInfVer : listSiiElementoIlegInfVer) {
                        SiiElementoIlegInfVer.setEivActivo("N");
                        elementoIlegInfVerDao.actualizarElementoIlegInfVer(SiiElementoIlegInfVer);
                    }
                    //descativar  MunicOrdTraInfVerif
                    ListTempMun.get(i).setMivActivo("N");
                    municOrdTraInfVerifDao.actualizarBarrioOrdenInfVer(ListTempMun.get(i));
                }
            }
        }

        for(CuadranteOrdenTraVO cuadranteOrdenTraVo : ordenTrabajoVisitaVo.getCuadranteOrdenTraList()) {
            List<SiiCuadranteOrdTraInfVer> ListTempCua = cuadranteOrdTraInfVerDao.buscarCuadranteOrdTraInfVerPorCotCodigo(cuadranteOrdenTraVo.getCotCodigo());
            if(cuadranteOrdenTraVo.getListCuadranteOrdTraInfVerVo() != null) {
                for(CuadranteOrdTraInfVerVO unCuadranteOrdTraInfVerVo : cuadranteOrdenTraVo.getListCuadranteOrdTraInfVerVo()) {
                    SiiCuadranteOrdTraInfVer siiCuadranteOrdTraInfVer = conversionVoEntidad.convertir(unCuadranteOrdTraInfVerVo);
                    if(unCuadranteOrdTraInfVerVo.getCivCodigo() == null) {
                        siiCuadranteOrdTraInfVer.setSiiInformeVerificCampo1(siiInformeVerificCampo);
                        siiCuadranteOrdTraInfVer.setCivActivo("S");
                        siiCuadranteOrdTraInfVer = cuadranteOrdTraInfVerDao.insertarCuadranteOrdTraInfVer(siiCuadranteOrdTraInfVer);

                        if(unCuadranteOrdTraInfVerVo.getListElementoIlegInfVer() != null) {
                            for(ElementoIlegInfVerVO elementoIlegInfVerVo : unCuadranteOrdTraInfVerVo.getListElementoIlegInfVer()) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(elementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiCuadranteOrdTraInfVer(siiCuadranteOrdTraInfVer);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                    else {
                        for(ElementoIlegInfVerVO unElementoIlegInfVerVo : unCuadranteOrdTraInfVerVo.getListElementoIlegInfVer()) {
                            if(unElementoIlegInfVerVo.getEivCodigo() == null) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(unElementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(unElementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiCuadranteOrdTraInfVer(siiCuadranteOrdTraInfVer);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                }
            }
            // para el borrado de registros  CuadranteOrdTraInfVer
            for(int i = 0; i < ListTempCua.size(); i++) {
                boolean temp = false;
                //valida registros para borrar
                for(int j = 0; j < cuadranteOrdenTraVo.getListCuadranteOrdTraInfVerVo().size(); j++) {
                    if(ListTempCua.get(i).getCivCodigo() == cuadranteOrdenTraVo.getListCuadranteOrdTraInfVerVo().get(j).getCivCodigo()) {
                        temp = true;
                    }
                }
                //desactiva elementos asociados al CuadranteOrdTraInfVer
                List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(ListTempCua.get(i).getCivCodigo(), null, null, null);
                if(temp == false) {
                    for(SiiElementoIlegInfVer SiiElementoIlegInfVer : listSiiElementoIlegInfVer) {
                        SiiElementoIlegInfVer.setEivActivo("N");
                        elementoIlegInfVerDao.actualizarElementoIlegInfVer(SiiElementoIlegInfVer);
                    }
                    //descativar  MunicOrdTraInfVerif
                    ListTempCua.get(i).setCivActivo("N");
                    cuadranteOrdTraInfVerDao.actualizarCuadranteOrdTraInfVer(ListTempCua.get(i));
                }
                
            }
        }

        for(DenunciaOrdenTrabVO denunciaOrdenTrabVo : ordenTrabajoVisitaVo.getDenunciaOrdenTrabList()) {
            List<SiiDenuncOrdTraInfVer> ListTempDenun = denuncOrdTraInfVerDao.buscarDenuncOrdTraInfVerPorDotCodigo(denunciaOrdenTrabVo.getDotCodigo());
            if(denunciaOrdenTrabVo.getListDenuncOrdTraInfVerVo() != null) {
                for(DenuncOrdTraInfVerVO denuncOrdTraInfVerVo : denunciaOrdenTrabVo.getListDenuncOrdTraInfVerVo()) {
                    SiiDenuncOrdTraInfVer siiDenuncOrdTraInfVer = conversionVoEntidad.convertir(denuncOrdTraInfVerVo);
                    if(denuncOrdTraInfVerVo.getDivCodigo() == null) {
                        siiDenuncOrdTraInfVer.setSiiInformeVerificCampo(siiInformeVerificCampo);
                        siiDenuncOrdTraInfVer.setDivActivo("S");
                        siiDenuncOrdTraInfVer = denuncOrdTraInfVerDao.insertarDenuncOrdTraInfVer(siiDenuncOrdTraInfVer);

                        if(denuncOrdTraInfVerVo.getListElementoIlegInfVerVo() != null) {
                            for(ElementoIlegInfVerVO elementoIlegInfVerVo : denuncOrdTraInfVerVo.getListElementoIlegInfVerVo()) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(elementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiDenuncOrdTraInfVer(siiDenuncOrdTraInfVer);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                    else {
                        for(ElementoIlegInfVerVO unElementoIlegInfVerVo : denuncOrdTraInfVerVo.getListElementoIlegInfVerVo()) {
                            if(unElementoIlegInfVerVo.getEivCodigo() == null) {
                                siiTipoElemenIlegalidad = tipoElemenIlegalidadDao.buscarTipoElemenIlegalidadXNombre(unElementoIlegInfVerVo.getTipoElemento());
                                SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(unElementoIlegInfVerVo);
                                elementoIlegInfVer.setSiiDenuncOrdTraInfVer(siiDenuncOrdTraInfVer);
                                elementoIlegInfVer.setSiiTipoElemenIlegalidad(siiTipoElemenIlegalidad);
                                elementoIlegInfVer.setEivActivo("S");
                                elementoIlegInfVerDao.insertarElementoIlegInfVer(elementoIlegInfVer);
                            }
                        }
                    }
                }
            }
            // para el borrado de registros  CuadranteOrdTraInfVer
            for(int i = 0; i < ListTempDenun.size(); i++) {
                boolean temp = false;
                //valida registros para borrar
                for(int j = 0; j < denunciaOrdenTrabVo.getListDenuncOrdTraInfVerVo().size(); j++) {
                    if(ListTempDenun.get(i).getDivCodigo() == denunciaOrdenTrabVo.getListDenuncOrdTraInfVerVo().get(j).getDivCodigo()) {
                        temp = true;
                    }
                }
                //desactiva elementos asociados al CuadranteOrdTraInfVer
                if(temp == false) {
                    List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(null, null, null, ListTempDenun.get(i).getDivCodigo());
                    for(SiiElementoIlegInfVer SiiElementoIlegInfVer : listSiiElementoIlegInfVer) {
                        SiiElementoIlegInfVer.setEivActivo("N");
                        elementoIlegInfVerDao.actualizarElementoIlegInfVer(SiiElementoIlegInfVer);
                    }
                    //descativar  MunicOrdTraInfVerif
                    ListTempDenun.get(i).setDivActivo("N");
                    denuncOrdTraInfVerDao.actualizarDenuncOrdTraInfVer(ListTempDenun.get(i));
                }
            }
        }
        
        for( ElementoIlegInfVerVO elementoIlegInfVerVo : ordenTrabajoVisitaVo.getListBorradoElementoIlegInfVerVo()){
            SiiElementoIlegInfVer elementoIlegInfVer = conversionVoEntidad.convertir(elementoIlegInfVerVo);
            elementoIlegInfVer.setEivActivo("N");
            elementoIlegInfVerDao.actualizarElementoIlegInfVer(elementoIlegInfVer);
            
        }

        return unInformeVerificCampoVo = (new InformeVerificCampoVO(siiInformeVerificCampo));
    }

    public List<ResultadoVerifCampoVO> buscarTodoResulVerCampo() throws ExcepcionDAO {
        List<ResultadoVerifCampoVO> listResultadoVerifCampoVO = new ArrayList();
        List<SiiResultadoVerifCampo> listSiiResultadoVerifCampo = resultadoVerifCampoDao.buscarTodo();
        for(SiiResultadoVerifCampo unSiiResultadoVerifCampo : listSiiResultadoVerifCampo) {
            listResultadoVerifCampoVO.add(new ResultadoVerifCampoVO(unSiiResultadoVerifCampo));
        }
        return listResultadoVerifCampoVO;
    }

    public List<DenuncOrdTraInfVerVO> buscarDenuncOrdTraInfVerPorDotCodigo(Long dotCodigo) throws ExcepcionDAO {
        List<DenuncOrdTraInfVerVO> listDenuncOrdTraInfVerVo = new ArrayList();
        List<SiiElementoIlegInfVer> listSiiElementoIlegInfVer = new ArrayList();
        List<ElementoIlegInfVerVO> listElementoIlegInfVerVo = new ArrayList();
        List<SiiDenuncOrdTraInfVer> listSiiDenuncOrdTraInfVer = denuncOrdTraInfVerDao.buscarDenuncOrdTraInfVerPorDotCodigo(dotCodigo);
        SiiTipoCalleDireccion siiTipoCalleDireccion = new SiiTipoCalleDireccion();
        SiiTipoSufijo1Calle siiTipoSufijo1Calle = new SiiTipoSufijo1Calle();
        SiiTipoSufijo2Calle siiTipoSufijo2Calle = new  SiiTipoSufijo2Calle ();
        SiiTipoSectorDirec siiTipoSectorDirec = new SiiTipoSectorDirec ();
        SiiTipoSufijo1Calle siiTipoSufijo1CalleLocal =  new SiiTipoSufijo1Calle ();
        SiiTipoSectorDirec siiTipoSectorDirec2 = new   SiiTipoSectorDirec ();
        
        for(SiiDenuncOrdTraInfVer unaSiiDenuncOrdTraInfVer : listSiiDenuncOrdTraInfVer) {
            listSiiElementoIlegInfVer = elementoIlegInfVerDao.buscarElementosPorIdPadre(null, null, null, unaSiiDenuncOrdTraInfVer.getDivCodigo());
            listElementoIlegInfVerVo = new ArrayList();
            for(int i = 0; i < listSiiElementoIlegInfVer.size(); i++) {
                ElementoIlegInfVerVO unElementoIlegInfVerVo = new ElementoIlegInfVerVO(listSiiElementoIlegInfVer.get(i));
                listElementoIlegInfVerVo.add(unElementoIlegInfVerVo);
            }
            DenuncOrdTraInfVerVO denuncOrdTraInfVerVo = new DenuncOrdTraInfVerVO(unaSiiDenuncOrdTraInfVer);
            denuncOrdTraInfVerVo.setListElementoIlegInfVerVo(listElementoIlegInfVerVo);
            denuncOrdTraInfVerVo.setResultadoVerificacion(denuncOrdTraInfVerVo.getResultadoVerifCampoVo().getRvcNombre());
            listDenuncOrdTraInfVerVo.add(denuncOrdTraInfVerVo);
        }
        
        
        return listDenuncOrdTraInfVerVo;

    }


    


}
