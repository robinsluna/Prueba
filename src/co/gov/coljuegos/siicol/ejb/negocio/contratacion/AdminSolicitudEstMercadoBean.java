package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AreaColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolEstMercadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoColjuegosDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudEstMercadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoIdentificacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemSolicitudDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoDevolucionSEMDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemSolicitud;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoColjuegos;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;
import co.gov.coljuegos.siicol.ejb.vo.AreaColjuegosVO;
import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemSolicitudVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoDevolucionVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;


@Stateless
public class AdminSolicitudEstMercadoBean implements AdminSolicitudEstMercado {
    
    @Resource
    SessionContext sessionContext;
    
    @EJB
    SolicitudEstMercadoDAO solicitudEstMercadoDao;
    @EJB
    EstadoSolEstMercadoDAO estadoSolEstMercadoDao;
    @EJB
    ProcesoColjuegosDAO procesoColjuegosDao;
    @EJB
    TipoIdentificacionDAO tipoIdentificacionDao;
    @EJB
    ArchivoFisicoDAO archivoFisicoDao;    
    @EJB
    AreaColjuegosDAO areaColjuegosDao;
    @EJB
    UsuarioDAO usuarioDao;
    @EJB
    ProcesoContratacionDAO procesoContratacionDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ItemSolicitudDAO itemSolicitudDao;
    @EJB
    MotivoDevolucionSEMDAO motivoDevolucionSEMDao;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
 
    

    public AdminSolicitudEstMercadoBean() {      
    }
    public SolicitudEstMercadoVO insertarSolicitudEstMercado(SolicitudEstMercadoVO solicitudEstMercadoVo) throws ExcepcionDAO{
        SiiSolicitudEstMercado solicitudEstMercado = conversionVoEntidad.convertir(solicitudEstMercadoVo);
        SiiSolicitudEstMercado unaSolicitudEstMercado = solicitudEstMercadoDao.insertarSolicitudEstMercado(solicitudEstMercado);
        return new SolicitudEstMercadoVO(unaSolicitudEstMercado);
    }
    
    public SolicitudEstMercadoVO actualizarSolicitudEstMercado(SolicitudEstMercadoVO solicitudEstMercadoVo,ProcesoContratacionVO procesoContratacionVo, List<ItemSolicitudVO> listaAgregarItemPlanContratacVo,
            List<ItemSolicitudVO> listaEliminarItemPlanContratacVo, UsuarioVO usuarioLogueado)
            throws ExcepcionDAO, ExcepcionAplicacion{
        SiiSolicitudEstMercado solicitudEstActual = solicitudEstMercadoDao.buscarSolicitudEstMercadoPorId(solicitudEstMercadoVo.getSemCodigo());
        if(solicitudEstActual.getSiiEstadoSolEstMercado().getEseCodigo() != solicitudEstMercadoVo.getIdEstadoAnterior()){
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la solicitud fue cambiado durante la modificación. Seleccione nuevamente la solicitud");
        }
        SiiSolicitudEstMercado solicitudEstMercado = conversionVoEntidad.convertir(solicitudEstMercadoVo);
        SiiSolicitudEstMercado unaSolicitudEstMercado = solicitudEstMercadoDao.actualizarSolicitudEstMercado(solicitudEstMercado);
        if(solicitudEstMercadoVo.getEstadoSolEstMercadoVo().getEseCodigo() != solicitudEstMercadoVo.getIdEstadoAnterior()){
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOL_EST_MERCADO.getId(), solicitudEstMercadoVo.getEstadoSolEstMercadoVo().getEseCodigo(), usuarioLogueado, solicitudEstMercado.getSemCodigo());
        }
        
        
        //actualizar Proceso de contratación
        if(procesoContratacionVo.getPrcCodigo() != null){
            SiiProcesoContratacion siiProcesoContratacion = new SiiProcesoContratacion();
            siiProcesoContratacion = procesoContratacionDao.buscarProcesoContratacionPorId(procesoContratacionVo.getPrcCodigo());
            if(procesoContratacionVo.getPrcObjeto() != null)
                siiProcesoContratacion.setPrcObjeto(procesoContratacionVo.getPrcObjeto());
            if(procesoContratacionVo.getEstadoProcContrat() != null ){
                SiiEstadoProcContrat siiEstadoProcContrat = conversionVoEntidad.convertir(procesoContratacionVo.getEstadoProcContrat());
                siiProcesoContratacion.setSiiEstadoProcContrat(siiEstadoProcContrat);
            }
            procesoContratacionDao.actualizarProcesoContratacion(siiProcesoContratacion);
            if(procesoContratacionVo.getEstadoProcContrat() != null && procesoContratacionVo.getEstadoProcContrat().getEpcCodigo() != procesoContratacionVo.getIdEstadoAnterior()){
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.PROC_CONTRAT.getId(), procesoContratacionVo.getEstadoProcContrat().getEpcCodigo(), usuarioLogueado, procesoContratacionVo.getPrcCodigo());
            }
        }
        
        if (listaEliminarItemPlanContratacVo != null){
            for (ItemSolicitudVO eliminarItemSolicitudVo :listaEliminarItemPlanContratacVo){
                SiiItemSolicitud  eliminarItem = conversionVoEntidad.convertir(eliminarItemSolicitudVo);
                itemSolicitudDao.eliminarItemSolicitud(eliminarItem.getIsoCodigo()); 
            }
        }
        if (listaAgregarItemPlanContratacVo != null){
            for(ItemSolicitudVO agregarItemSolicitudVo : listaAgregarItemPlanContratacVo){
                SiiItemSolicitud nuevaItemSolicitud = conversionVoEntidad.convertir(agregarItemSolicitudVo);
                nuevaItemSolicitud.setSiiSolicitudEstMercado(unaSolicitudEstMercado);            
                itemSolicitudDao.insertarItemSolicitud(nuevaItemSolicitud);
            }
        }

        return new SolicitudEstMercadoVO(unaSolicitudEstMercado);
    }
    
    public SolicitudEstMercadoVO buscarSolicitudEstMercadoPorId(SolicitudEstMercadoVO solicitudEstMercadoVo) throws ExcepcionDAO{
        SiiSolicitudEstMercado solicitudEstMercado = conversionVoEntidad.convertir(solicitudEstMercadoVo);
        SiiSolicitudEstMercado unaSolicitudEstMercado = solicitudEstMercadoDao.buscarSolicitudEstMercadoPorId(solicitudEstMercado.getSemCodigo());
        return new SolicitudEstMercadoVO(unaSolicitudEstMercado);
        
    }

    public List<SolicitudEstMercadoVO> buscarSolicitudesEstMercadoPorArea(AreaColjuegosVO unAreaColjuegosVo) throws ExcepcionDAO{
        SiiAreaColjuegos areaColjuegos = conversionVoEntidad.convertir(unAreaColjuegosVo);
        List<SiiSolicitudEstMercado> listaSolicitudEtMercado;
        listaSolicitudEtMercado = solicitudEstMercadoDao.buscarSolicitudesEstMercadoPorArea(areaColjuegos);
        List<SolicitudEstMercadoVO> listaSolicitudEstMercadoVo = new ArrayList();
        for(SiiSolicitudEstMercado unaSolicitudEstMercado : listaSolicitudEtMercado){
            listaSolicitudEstMercadoVo.add(new SolicitudEstMercadoVO(unaSolicitudEstMercado));
        }        
        return listaSolicitudEstMercadoVo;
    }
    
    public List<SolicitudEstMercadoVO> buscarSolicitudEMPorIdProcesoContratacion(ProcesoContratacionVO unProcesoContratacionVo) throws ExcepcionDAO{
        SiiProcesoContratacion procesoContratacion = conversionVoEntidad.convertir(unProcesoContratacionVo);
        List<SiiSolicitudEstMercado> listaSolicitudEtMercado;
        listaSolicitudEtMercado = solicitudEstMercadoDao.buscarSolicitudEMPorIdProcesoContratacion(procesoContratacion);
        List<SolicitudEstMercadoVO> listaSolicitudEstMercadoVo = new ArrayList();
        for(SiiSolicitudEstMercado unaSolicitudEstMercado : listaSolicitudEtMercado){
            listaSolicitudEstMercadoVo.add(new SolicitudEstMercadoVO(unaSolicitudEstMercado));
        }        
        return listaSolicitudEstMercadoVo;
    }
    
    public List<SolicitudEstMercadoVO> buscarSolicitudesEstMercadoPorEstado(EstadoSolEstMercadoVO unEstadoSolicitudVo) throws ExcepcionDAO{        
        SiiEstadoSolEstMercado estadoSolEstMercado = conversionVoEntidad.convertir(unEstadoSolicitudVo);
        List<SiiSolicitudEstMercado> listaSolicitudEstMercado;
        listaSolicitudEstMercado = solicitudEstMercadoDao.buscarSolicitudesEstMercadoPorEstado(estadoSolEstMercado);
        List<SolicitudEstMercadoVO> listaSolicitudEstMercadoVo = new ArrayList();
        for(SiiSolicitudEstMercado unaSolicitudEstMercado : listaSolicitudEstMercado){
            listaSolicitudEstMercadoVo.add(new SolicitudEstMercadoVO(unaSolicitudEstMercado));
        }
        return listaSolicitudEstMercadoVo;
    }
    
    public List<SolicitudEstMercadoVO> buscarTodoSolicitudEstMercado() throws ExcepcionDAO{
        List<SiiSolicitudEstMercado> listaSolicitudEstMercado;
        listaSolicitudEstMercado = solicitudEstMercadoDao.buscarTodoSolicitudEstMercado();
        List<SolicitudEstMercadoVO> listaSolicitudEstMercadoVo = new ArrayList();
        for(SiiSolicitudEstMercado unaSolicitudEstMercado : listaSolicitudEstMercado){
            listaSolicitudEstMercadoVo.add(new SolicitudEstMercadoVO(unaSolicitudEstMercado));
        }
        return listaSolicitudEstMercadoVo;        
    }
    
    public SolicitudEstMercadoVO insertarSolicitudEstMercadoConItemSolicitud (SolicitudEstMercadoVO solicitudEstMercadoVo,ProcesoContratacionVO unProContratacionVo,
                                                                              UsuarioVO usuarioLogueado) throws ExcepcionDAO{
           /*
            SiiSolicitudEstMercado siiSolicitudEstMercado=new SiiSolicitudEstMercado();
            SiiArchivoFisico siiArchivofisico=new SiiArchivoFisico();
            SiiAreaColjuegos siiAreaColjuegos=new SiiAreaColjuegos();
            SiiEstadoSolEstMercado siiEstadoSEM= new SiiEstadoSolEstMercado(); 
            SiiItemPlanContratac siiItemPlanContrac= new SiiItemPlanContratac();
            SiiItemSolicitud siiItemSolicitud= new SiiItemSolicitud();
            SiiProcesoColjuegos siiProcesoColjuegos= new SiiProcesoColjuegos();
            SiiTipoIdentificacion siiTipoIdentificacion= new SiiTipoIdentificacion();
            SiiUbicacion siiUbicacion= new SiiUbicacion();
            SiiUsuario siiUsuario=new SiiUsuario();
           */
            SiiProcesoContratacion procesoContratacion= conversionVoEntidad.convertir(unProContratacionVo);
            SiiProcesoContratacion unProcesoContratacion=procesoContratacionDao.insertarProcesoContratacion(procesoContratacion);
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.PROC_CONTRAT.getId(), unProContratacionVo.getEstadoProcContrat().getEpcCodigo(), usuarioLogueado, unProcesoContratacion.getPrcCodigo());
            ProcesoContratacionVO unProcesoContratacionVo= new ProcesoContratacionVO();
            unProcesoContratacionVo.setPrcCodigo(unProcesoContratacion.getPrcCodigo());
            solicitudEstMercadoVo.setProcesoContratacionVo(unProcesoContratacionVo);
       
            SiiSolicitudEstMercado solicitudEstMercado = conversionVoEntidad.convertir(solicitudEstMercadoVo);
            SiiSolicitudEstMercado solicitudEstMercadoResultado = solicitudEstMercadoDao.insertarSolicitudEstMercado(solicitudEstMercado);
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOL_EST_MERCADO.getId(), solicitudEstMercadoVo.getEstadoSolEstMercadoVo().getEseCodigo(), usuarioLogueado, solicitudEstMercado.getSemCodigo());
            List <ItemSolicitudVO> listaItemSolicitudVo = solicitudEstMercadoVo.getItemSolicitudListVo(); 
            for (ItemSolicitudVO unaItemSolicitudVo : listaItemSolicitudVo){
                SiiItemSolicitud nuevaItemSolicitud = conversionVoEntidad.convertir(unaItemSolicitudVo);
                nuevaItemSolicitud.setSiiSolicitudEstMercado(solicitudEstMercadoResultado);            
                itemSolicitudDao.insertarItemSolicitud(nuevaItemSolicitud);
            }
            return new SolicitudEstMercadoVO(solicitudEstMercadoResultado);
        }
    
    public List<SolicitudEstMercadoVO> buscarSolicitudesEstMercadoPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO{        
            
            List<SiiSolicitudEstMercado> listaSolicitudEstMercado;
            listaSolicitudEstMercado = solicitudEstMercadoDao.buscarSolicitudesEstMercadoPorIdProcesoContratacion(idProcesoContratacion);
            List<SolicitudEstMercadoVO> listaSolicitudEstMercadoVo = new ArrayList();
            for(SiiSolicitudEstMercado unaSolicitudEstMercado : listaSolicitudEstMercado){
                listaSolicitudEstMercadoVo.add(new SolicitudEstMercadoVO(unaSolicitudEstMercado));
            }
            return listaSolicitudEstMercadoVo;
        }
    
    
    public List<MotivoDevolucionVO> buscarTodoMotivoDevolucionSEM() throws ExcepcionDAO{        
            
            List<SiiMotivoDevolucion> listaMotivoDevolucionSEM;
            listaMotivoDevolucionSEM = motivoDevolucionSEMDao.buscarTodoMotivoDevolucionSEM();
            List<MotivoDevolucionVO> listaMotivoDevolucionSEMVo = new ArrayList();
            for(SiiMotivoDevolucion unMotivoDevolucion : listaMotivoDevolucionSEM){
                listaMotivoDevolucionSEMVo.add(new MotivoDevolucionVO(unMotivoDevolucion));
            }
            return listaMotivoDevolucionSEMVo;
        }
    
    public MotivoDevolucionVO buscarMotivoDevolucionSEMPorId(Long idmotivoDevolucionVo) throws ExcepcionDAO{
        SiiMotivoDevolucion siiMotivoDevolucion;
        siiMotivoDevolucion= motivoDevolucionSEMDao.buscarMotivoDevolucionSEMPorId(idmotivoDevolucionVo);
        return new MotivoDevolucionVO(siiMotivoDevolucion);
    }
    
    public MotivoDevolucionVO buscarEstadoMotivoDevPorNombre(MotivoDevolucionVO motivoDevolucionVo) throws ExcepcionDAO{
        SiiMotivoDevolucion siiMotivoDevolucion = conversionVoEntidad.convertir(motivoDevolucionVo);
        SiiMotivoDevolucion resultadoMotivoDevolucion = motivoDevolucionSEMDao.buscarEstadoMotivoDevPorNombre(siiMotivoDevolucion);
        return new MotivoDevolucionVO(resultadoMotivoDevolucion);
    }
}

