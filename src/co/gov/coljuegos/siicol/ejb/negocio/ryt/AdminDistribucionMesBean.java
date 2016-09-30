/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 14-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminObligacion;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AsignacionRecaudoAaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BeneficiarioEnteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CategoriaDistribDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConsolidadoDistDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDistribDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DistribucionMesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudoAa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBeneficiarioEnte;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsolidadoDist;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDistrib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.AsignacionRecaudoAAVO;
import co.gov.coljuegos.siicol.ejb.vo.BeneficiarioEnteVO;
import co.gov.coljuegos.siicol.ejb.vo.CategoriaDistribVO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.ConsolidadoDistVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribVO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionMesVO;

import co.gov.coljuegos.siicol.ejb.vo.ObligacionVO;
import co.gov.coljuegos.siicol.ejb.vo.RecaudoEnteVO;

import co.gov.coljuegos.siicol.ejb.vo.ReporteDistribucionVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminDistribucionMesBean implements AdminDistribucionMes{
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB 
    DistribucionMesDAO distribucionMesDao;
    @EJB
    DetalleDistribDAO detalleDistribDao;
    @EJB
    ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    AdminObligacion adminObligacion;
    @EJB
    private BeneficiarioEnteDAO beneficiarioEnteDao;
    @EJB
    CategoriaDistribDAO categoriaDistribDao; 
    @EJB
    ConsolidadoDistDAO consolidadoDistDao;
    @EJB
    AsignacionRecaudoAaDAO asignacionRecaudoAaDao;
    
    
    //////////////////////////////////////////////////////////
    // Listas para actualizar hijos relacionados en cascada. //
    //////////////////////////////////////////////////////////
    private List<BeneficiarioEnteVO> listaBeneficiariosEnteActualizar;
    
    
    
    
    /**
     * Constructor.
     */
    public AdminDistribucionMesBean() {
       
    }
    
    public List<RecaudoEnteVO> buscarValorRecaudoTodosMunicipiosPorMes(int mes, Long idCategoria, Integer vigencia, String fechaLiq) throws ExcepcionDAO{       
        List<RecaudoEnteVO>listaRecaudo = new ArrayList();
        listaRecaudo = distribucionMesDao.buscarValorRecaudoTodosMunicipiosPorMes(mes,idCategoria, vigencia, fechaLiq);
        
        return listaRecaudo;
    }
    public int buscarConsecutivoDistribucion() throws ExcepcionDAO {
         return distribucionMesDao.buscarConsecutivoDistribucion();
     }
    
    public DistribucionMesVO actualizarSiiDistribucionMes(DistribucionMesVO distribucionMesVO, UsuarioVO usuLogin) throws ExcepcionDAO, ExcepcionAplicacion {
        // realiza la actualizacion del registro, sin actualizar sus hijos en cascada.
        
        SiiDistribucionMes distribucionEstActual = distribucionMesDao.buscarPorCodigoDistribucionMes(distribucionMesVO.getDmeCodigo());        
        if(distribucionMesVO.getEstadoDistribEnteVo().getEdeCodigo() != distribucionMesVO.getIdEstadoAnterior()){
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.DISTRIBUCION_MES.getId(),
                                                         distribucionMesVO.getEstadoDistribEnteVo().getEdeCodigo(),
                                                         usuLogin, distribucionMesVO.getDmeCodigo());
            
            //throw new ExcepcionAplicacion("Error de concurrencia: El estado de la distribucion fue cambiado durante la modificación. Seleccione nuevamente la distribución");
        }      
        return (this.actualizarDistribucionMes(distribucionMesVO, usuLogin, false) );
    }
    
    public DistribucionMesVO  insertarSiiDistribucionMes(DistribucionMesVO distribucionMesVo,List<DetalleDistribVO> listaDetalleDistrib,
                                                            DistribucionMesVO  distribucionMesVoAnular,List<DetalleDeclaracionVO> listaDeclaracion,List<AsignacionRecaudoAAVO> listaAsigRec ) throws ExcepcionDAO{
          // Se anula la distribución anterior
        if(distribucionMesVoAnular!= null && distribucionMesVoAnular.getEstadoDistribEnteVo().getEdeCodigo().equals(1L)){
                distribucionMesDao.actualizarSiiDistribucionMes(conversionVoEntidad.convertir(distribucionMesVoAnular));
            }
            
            SiiDistribucionMes resultadoSiiDistribucionMes = distribucionMesDao.insertarSiiDistribucionMes(conversionVoEntidad.convertir(distribucionMesVo));            
            // Se inserta el detalle distribución
            if(listaDetalleDistrib.size() > 0){
                for(DetalleDistribVO unVo : listaDetalleDistrib){
                    SiiDetalleDistrib siiDetDistr = conversionVoEntidad.convertir(unVo);
                    siiDetDistr.setSiiDistribucionMes(resultadoSiiDistribucionMes);
                    detalleDistribDao.insertarSiiDetalleDistrib(siiDetDistr);
                }
            }
            // Se marca detalle declaracion con la distribucion
            if(listaDeclaracion!= null && listaDeclaracion.size()> 0){
                for(DetalleDeclaracionVO unRecVo : listaDeclaracion){
                    SiiDetalleDeclaracion miDetalleDecSii = detalleDeclaracionDao.buscarPorCodigoDetalleDeclaracion(unRecVo.getDdeCodigo());
                    miDetalleDecSii.setSiiDistribucionMes(resultadoSiiDistribucionMes);
                    detalleDeclaracionDao.actualizarDetalleDeclaracion(miDetalleDecSii);
                    }
            }
            
            // Se marca el recaudo actuaciones administrativas
            if(listaAsigRec != null && listaAsigRec.size() > 0){
                for(AsignacionRecaudoAAVO unAA : listaAsigRec){
                    SiiAsignacionRecaudoAa siiAsignacionRecaudoAa = asignacionRecaudoAaDao.buscarPorCodigoAsignacionRecaudoAa(unAA.getAraCodigo());
                    siiAsignacionRecaudoAa.setSiiDistribucionMes(resultadoSiiDistribucionMes);
                    asignacionRecaudoAaDao.actualizarAsignacionRecaudoAa(siiAsignacionRecaudoAa);
                }
                
            }
            
            return new DistribucionMesVO(resultadoSiiDistribucionMes);
    }
    
    
    public List<DistribucionMesVO> buscarDistribucionMesPorEstado(Long edeCodigo) throws ExcepcionDAO {
        List<DistribucionMesVO> resultado = null;
        List<SiiDistribucionMes> lista = distribucionMesDao.buscarDistribucionMesPorEstado(edeCodigo);
        if (lista!=null) {
            resultado = new ArrayList<DistribucionMesVO>();
            for (SiiDistribucionMes siiDistribucionMes: lista) {
                if (siiDistribucionMes!=null)
                    resultado.add(new DistribucionMesVO(siiDistribucionMes));
            }
        }
        
        return (resultado);
    }
    public DistribucionMesVO buscarPorCodigoDistribucionMes(Long idCodigoDistMes) throws ExcepcionDAO {
            SiiDistribucionMes siiDistribucionMes =distribucionMesDao.buscarPorCodigoDistribucionMes(idCodigoDistMes);         
            return  new DistribucionMesVO(siiDistribucionMes);
    }
    
    public List<DetalleDistribVO> buscarDetalleDistribPorIdDistribucion(Long idDistriMes) throws ExcepcionDAO {
        List<DetalleDistribVO>  resultado = new ArrayList();
        List<SiiDetalleDistrib> lista = detalleDistribDao.buscarDetalleDistribPorIdDistribucion(idDistriMes);
        if(lista.size() > 0){
            for(SiiDetalleDistrib vo :lista ){
                resultado.add(new DetalleDistribVO (vo));
            }
        }
        return (resultado);
    }
    
    public List<DistribucionMesVO> buscarDistribucionPorMesYVigencia (int pMes, int pVigencia )throws ExcepcionDAO {
        List<DistribucionMesVO> lista =  new ArrayList<DistribucionMesVO>();
        List<SiiDistribucionMes> siiDistribucionMes =distribucionMesDao.buscarDistribucionPorMesYVigencia(pMes, pVigencia) ;
        for(SiiDistribucionMes vo : siiDistribucionMes){
                 lista.add( new DistribucionMesVO(vo));
        }
        return  lista;
    }
    
    public List<ConceptoCuotaVO> buscarSiiConceptoCuotaPorModalidades(String modalidad1, String modalidad2, String modalidad3) throws ExcepcionDAO {
        List<ConceptoCuotaVO>  resultado = null;
        List<SiiConceptoCuota> lista = conceptoCuotaDao.buscarSiiConceptoCuotaPorModalidades(modalidad1, modalidad2, modalidad3);
        if(lista!=null && lista.size() > 0){
            resultado = new ArrayList<ConceptoCuotaVO>();
            for(SiiConceptoCuota vo :lista ){
                resultado.add(new ConceptoCuotaVO (vo));
            }
        }
        return (resultado);    
    }

    
    public List<DistribucionMesVO> buscarDistribucionMesConOrdenPagoPendientes() throws ExcepcionDAO {
        List<DistribucionMesVO>  resultado = null;
        List<SiiDistribucionMes> lista = distribucionMesDao.buscarDistribucionMesConOrdenPagoPendientes();
        if(lista!=null){
            resultado = new ArrayList<DistribucionMesVO>();
            for(SiiDistribucionMes siiDistribucionMes :lista ){
                if (siiDistribucionMes!=null)
                    resultado.add(new DistribucionMesVO(siiDistribucionMes));
            }
        }
        return (resultado);    
    }

    public List<DistribucionMesVO> buscarDistribucionMesConOrdenPagoPendientes(String tdcCodigo) throws ExcepcionDAO {
        List<DistribucionMesVO>  resultado = null;
        List<SiiDistribucionMes> lista = distribucionMesDao.buscarDistribucionMesConOrdenPagoPendientes(tdcCodigo);
        if(lista!=null){
            resultado = new ArrayList<DistribucionMesVO>();
            for(SiiDistribucionMes siiDistribucionMes :lista ){
                if (siiDistribucionMes!=null)
                    resultado.add(new DistribucionMesVO(siiDistribucionMes));
            }
        }
        return (resultado);    
    }
    public List<DistribucionMesVO> buscarTodoDistribucion() throws ExcepcionDAO {
        List<SiiDistribucionMes> listaSiiDistribucion = new ArrayList<SiiDistribucionMes>();
        listaSiiDistribucion = distribucionMesDao.buscarTodoSiiDistribucion();
        List<DistribucionMesVO> listaDistribucionVo = new ArrayList<DistribucionMesVO>();
        if (listaSiiDistribucion.size() > 0) {
            for (SiiDistribucionMes siiDistri : listaSiiDistribucion) {
                DistribucionMesVO distriVo = new DistribucionMesVO(siiDistri);
                listaDistribucionVo.add(distriVo);
            }
        }
        return listaDistribucionVo;
    }
    public List<RecaudoEnteVO> buscarValorRecaudoInteresTodosMunicipiosPorMes(int mes, String pTipoCuota, Integer vigencia) throws ExcepcionDAO{       
        List<RecaudoEnteVO>listaRecaudo = new ArrayList();
        listaRecaudo = distribucionMesDao.buscarValorRecaudoInteresTodosMunicipiosPorMes(mes, pTipoCuota, vigencia);
        
        return listaRecaudo;
    }
    public List<ReporteOperadorVO> buscarDistribucionOperadorPorMes(int mes, Integer vigenciaReporte) throws ExcepcionDAO {
        List<ReporteOperadorVO>lista = new ArrayList();
        lista = distribucionMesDao.buscarDistribucionOperadorPorMes(mes,vigenciaReporte);
        return lista;
    }
    public List<RecaudoEnteVO> buscarValorRecaudoTodosMunicipiosPorMesSinDdeCodigo(int mes, Long idCategoria, Integer vigencia, String fechaLiq) throws ExcepcionDAO {         
        List<RecaudoEnteVO>listaRecaudo = new ArrayList();
        listaRecaudo = distribucionMesDao.buscarValorRecaudoTodosMunicipiosPorMesSinDdeCodigo(mes, idCategoria,vigencia,fechaLiq);
        
        return listaRecaudo;
    }
    public List<RecaudoEnteVO> buscarValorRecaudoInteresTodosMunicipiosPorMesSinDdeCodigo(int mes, String pDistribucion,Integer vigencia) throws ExcepcionDAO {
        List<RecaudoEnteVO>listaRecaudo = new ArrayList();
        listaRecaudo = distribucionMesDao.buscarValorRecaudoInteresTodosMunicipiosPorMesSinDdeCodigo(mes, pDistribucion,vigencia);
        
        return listaRecaudo;
    }
    public List<ReporteOperadorVO> buscarDistribucionMunicGeneradorPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
        List<ReporteOperadorVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarDistribucionMunicGeneradorPorMes(mes, vigenciaReporte);
        return lista;
    }
    /*public List<ReporteDistribucionVO> buscarTransferenciaMunicipiosPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO{
        List<ReporteDistribucionVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarTransferenciaMunicipiosPorMes(mes, vigenciaReporte);
        return lista;
    }*/
    public List<ReporteOperadorVO> buscarDistribucionOperadorPorMesYDepto(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
        List<ReporteOperadorVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarDistribucionOperadorPorMesYDepto(mes, vigenciaReporte);
        return lista;
    }
    public List<RecaudoEnteVO> buscarValorRecaudoInteresMoraTodosMunicipiosPorMes(int mes, Integer vigencia) throws ExcepcionDAO {
        List<RecaudoEnteVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarValorRecaudoInteresMoraTodosMunicipiosPorMes(mes, vigencia);
        return lista;
    }
    public List<ReporteDistribucionVO> generarReporteTransferenciaPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
        List<ReporteDistribucionVO>lista = new ArrayList();
        lista =  distribucionMesDao.generarReporteTransferenciaPorMes(mes, vigenciaReporte);
        return lista;
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de los hijos de la Distribuci&oacute;n Mes.
     * @param distribucionMesVo - Distribuci&oacute;n Mes.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirHijos(DistribucionMesVO distribucionMesVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        // Persistir listado de Obligaciones.
        this.persistirObligaciones(distribucionMesVo);
        
        
        if (this.listaBeneficiariosEnteActualizar!=null)
            this.actualizarBeneficiariosEnte();
    }
    
    
    
    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de las Obligaciones asociadas a la Distribuci&oacute;n Mes especificada.
     * @param distribucionMesVo - Distribuci&oacute;n Mes que contiene las Obligaciones a persistir.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirObligaciones (DistribucionMesVO distribucionMesVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (distribucionMesVo!=null && distribucionMesVo.getObligacionList()!=null && !distribucionMesVo.getObligacionList().isEmpty()) {
            for (ObligacionVO obligacionVo: distribucionMesVo.getObligacionList()) {
                if (obligacionVo!=null) {
                    obligacionVo.setDistribucionMesVo(distribucionMesVo);
                    
                    if (obligacionVo.getOblCodigo()==null) {
                        // Operacion INSERTAR
                        adminObligacion.insertarObligacion(obligacionVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        adminObligacion.actualizarObligacion(obligacionVo);
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Realiza la actualizaci&oaucte;n de un registro de Distribuci&oacute;n Mes, con la posibilidad de actualizar sus hijos en cascada.
     * @param distribucionMesVO - Distribuci&oacute;n Mes.
     * @param usuLogin - Usuario.
     * @param doCascadeUpdate - Flag que determina si es requerido realizar la actualizaci&oacute;n de los registros en Cascada.
     * @return instance of DistribucionMesVO.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public DistribucionMesVO actualizarDistribucionMes(DistribucionMesVO distribucionMesVO, UsuarioVO usuLogin, boolean doCascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion
    {
        DistribucionMesVO resultado = null;
        SiiDistribucionMes distri = distribucionMesDao.actualizarSiiDistribucionMes(conversionVoEntidad.convertir(distribucionMesVO));
        
        if (distri!=null) {
            resultado = new DistribucionMesVO(distri);
            
            // se actualiza el log
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.DISTRIBUCION_MES.getId(),
                                                         distribucionMesVO.getEstadoDistribEnteVo().getEdeCodigo(),
                                                         usuLogin, distribucionMesVO.getDmeCodigo());
            
            if (doCascadeUpdate) {
                // asociar los hijos al resultado
                resultado.setObligacionList(distribucionMesVO.getObligacionList());
                resultado.setDetalleDistribListVo(distribucionMesVO.getDetalleDistribListVo());
                resultado.setDetalleDeclaracionList(distribucionMesVO.getDetalleDeclaracionList());
                
                // persistir las entidades hijas
                this.persistirHijos(resultado);
            }
        }
        
        return ( resultado );
    }
    
    
    
    public List<DistribucionMesVO> buscarDistribucionMesSinObligacionPorEstado (Long edeCodigo) throws ExcepcionDAO {
        List<DistribucionMesVO> resultado = null;
        List<SiiDistribucionMes> lista = distribucionMesDao.buscarDistribucionMesSinObligacionPorEstado(edeCodigo);
        if (lista!=null) {
            resultado = new ArrayList<DistribucionMesVO>();
            for (SiiDistribucionMes siiDistribucionMes: lista) {
                if (siiDistribucionMes!=null)
                    resultado.add(new DistribucionMesVO(siiDistribucionMes));
            }
        }
        
        return (resultado);
    }
    
    public List<ReporteOperadorVO> buscarDistribucionConsolidadoOperadorPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO{
                List<ReporteOperadorVO>lista = new ArrayList();
                lista =  distribucionMesDao.buscarDistribucionConsolidadoOperadorPorMes(mes, vigenciaReporte);
                return lista;
    }
    public List<ReporteOperadorVO> buscarDistribucionMunicPorMesConsolidado(int mes,Integer vigenciaReporte) throws ExcepcionDAO {
        List<ReporteOperadorVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarDistribucionMunicPorMesConsolidado(mes, vigenciaReporte);
        return lista;
    }
    public DistribucionMesVO anularDistribucionMes(DistribucionMesVO distribucionMesVO, UsuarioVO usuLogin) throws ExcepcionDAO, ExcepcionAplicacion {
        // realiza la actualizacion del registro, sin actualizar sus hijos en cascada.
        
        SiiDistribucionMes distribucionEstActual = distribucionMesDao.buscarPorCodigoDistribucionMes(distribucionMesVO.getDmeCodigo());
        if(distribucionEstActual.getSiiEstadoDistribEnte().getEdeCodigo() != distribucionMesVO.getIdEstadoAnterior()){
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la distribucion fue cambiado durante la modificación. Seleccione nuevamente la distribución");
        }      
        DistribucionMesVO resultadoAct = this.actualizarDistribucionMes(distribucionMesVO, usuLogin, false);
        
        // Se desmarca detalle_declaracion con la distribución a anular
        distribucionMesDao.anularDistribucionMes(distribucionMesVO.getDmeCodigo());
        return resultadoAct;
        
    }

    
    
    
    
    ///////////////////////////////////////
    // Listas para Persistir en cascada. //
    ///////////////////////////////////////
    public void setListaBeneficiariosEnteActualizar(List<BeneficiarioEnteVO> listaBeneficiariosEnteActualizar) {
        this.listaBeneficiariosEnteActualizar = listaBeneficiariosEnteActualizar;
    }
    
    
    /**
     * Actualiza el listado de Beneficiarios-Ente previamente cargado.
     * @throws ExcepcionDAO
     */
    private void actualizarBeneficiariosEnte () throws ExcepcionDAO
    {
        if (this.listaBeneficiariosEnteActualizar!=null) {
            for (BeneficiarioEnteVO beVo: listaBeneficiariosEnteActualizar) {
                if (beVo!=null && beVo.getBenCodigo()!=null) {
                    SiiBeneficiarioEnte siiBeneficiarioEnte = conversionVoEntidad.convertir(beVo);
                    if (siiBeneficiarioEnte!=null)
                        beneficiarioEnteDao.actualizar(siiBeneficiarioEnte);
                }
            }
        }
    }
    public List<ReporteDistribucionVO> buscarRecaudoInteresPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
        List<ReporteDistribucionVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarRecaudoInteresPorMesYVigencia(mes, vigenciaReporte);
        return lista;
    }
    public List<ReporteDistribucionVO> buscarTransferenciaInteresPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
        List<ReporteDistribucionVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarTransferenciaInteresPorMesYVigencia(mes, vigenciaReporte);
        return lista;
    }
    public List<RecaudoEnteVO> buscarValorRecaudoInteresPorMesVigenciaTipoCuota(int mes, Integer vigencia, String pBandera, String pReporte) throws ExcepcionDAO {
        List<RecaudoEnteVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarValorRecaudoInteresPorMesVigenciaTipoCuota(mes, vigencia,pBandera,pReporte);
        return lista;
    }
    public List<RecaudoEnteVO> buscarValorRecaudoIFPorMesVigenciaTipoCuota(int mes, Integer vigencia, String pBandera, String pReporte) throws ExcepcionDAO {
        List<RecaudoEnteVO>lista = new ArrayList();
        lista =  distribucionMesDao.buscarValorRecaudoIFPorMesVigenciaTipoCuota(mes, vigencia, pBandera,pReporte);
        return lista;
    }
    
    public CategoriaDistribVO buscarPorCodigoCategoriaDistrib(Long idCodigoCategoria) throws ExcepcionDAO {        
        return( new CategoriaDistribVO(categoriaDistribDao.buscarPorCodigoCategoriaDistrib(idCodigoCategoria)));
        
    }
    
    public List<ReporteDistribucionVO> buscarTransferenciaInteresMoraPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {
        return(distribucionMesDao.buscarTransferenciaInteresMoraPorMesYVigencia(mes, vigenciaReporte));
    }
    
    public List<ReporteDistribucionVO> buscarTransferenciaInteresFinanciacionPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO { 
        return(distribucionMesDao.buscarTransferenciaInteresFinanciacionPorMesYVigencia(mes, vigenciaReporte));
    }
    public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {         
        return(distribucionMesDao.buscarReporteRecaudoInteresMoraOperadorPorMesYVigencia(mes, vigenciaReporte));
    }
    public List<ReporteOperadorVO> buscarConsolidadoReporteRecaudoInteresMoraOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {
        return(distribucionMesDao.buscarConsolidadoReporteRecaudoInteresMoraOperadorPorMesYVigencia(mes, vigenciaReporte));
    }
    public List<RecaudoEnteVO> buscarValorRecaudoRifasPorMes(int mes, Integer vigencia, String nivel1,String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {
        return(distribucionMesDao.buscarValorRecaudoRifasPorMes(mes, vigencia, nivel1,nivel2, nivel3, nivel4, nivel5));
    }
    public List<ReporteDistribucionVO> buscarTransferenciaPorMesVigenciaYCategoria(int mes,Integer vigenciaReporte,Long idCategoria) throws ExcepcionDAO {
        return(distribucionMesDao.buscarTransferenciaPorMesVigenciaYCategoria(mes, vigenciaReporte, idCategoria));
    }
    public List<RecaudoEnteVO> buscarValorRecaudoPromocionales(int mes, Integer vigencia, String bandera) throws ExcepcionDAO {         
            return(distribucionMesDao.buscarValorRecaudoPromocionales(mes, vigencia, bandera));
    }
    
    public void insertarConsolidadoDist(List<ConsolidadoDistVO> listaConsolidado,DistribucionMesVO unaDistriVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        try{ 
            if(listaConsolidado.size() > 0){
                for(ConsolidadoDistVO unVo : listaConsolidado){
                    consolidadoDistDao.insertarSiiConsolidadoDist(conversionVoEntidad.convertir(unVo));
                }            
            }
            // Se actualiza el estado de la distribucion
            this.actualizarSiiDistribucionMes(unaDistriVo,usuarioLogueado);
        } catch (Exception e) {                
                e.printStackTrace();
            }
    }
	public List<ReporteOperadorVO> buscarValorRecaudoPromocionalesReporte(int mes, Integer vigencia) throws ExcepcionDAO {         
        return(distribucionMesDao.buscarValorRecaudoPromocionalesReporte(mes, vigencia));
    }
    
    public List<ReporteOperadorVO> buscarConsolidadoReportePromocionalesOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO {  
        return(distribucionMesDao.buscarConsolidadoReportePromocionalesOperadorPorMesYVigencia(mes, vigenciaReporte));
    }
	public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraActAdmOperadorPorMesYVigencia(int mes,Integer vigenciaReporte, String nivel1,
                                                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {
            return(distribucionMesDao.buscarReporteRecaudoInteresMoraActAdmOperadorPorMesYVigencia(mes, vigenciaReporte, nivel1, nivel2, nivel3, nivel4, nivel5));
        
    }
    public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraConsolidadoActAdmOperadorPorMesYVigencia(int mes,Integer vigenciaReporte, String nivel1,
                                                                                                String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {         
        return(distribucionMesDao.buscarReporteRecaudoInteresMoraConsolidadoActAdmOperadorPorMesYVigencia(mes, vigenciaReporte, nivel1, nivel2, nivel3, nivel4, nivel5));
    }
    public List<ReporteOperadorVO> buscarValorRecaudoRifasPorMesReporte(int mes, Integer vigencia, String nivel1, 
                                                         String nivel2, String nivel3, String nivel4, String nivel5,String concepto) throws ExcepcionDAO {
                                                                                                                     
            return (distribucionMesDao.buscarValorRecaudoRifasPorMesReporte(mes, vigencia, nivel1,nivel2, nivel3, nivel4, nivel5,concepto));
    }
    public List<ReporteOperadorVO> buscarValorRecaudoRifasConsolidadoPorMesReporte(int mes, Integer vigencia, String nivel1, 
                                                         String nivel2, String nivel3, String nivel4, String nivel5, String concepto) throws ExcepcionDAO {
                                                                                                                     
                    return (distribucionMesDao.buscarValorRecaudoRifasConsolidadoPorMesReporte(mes, vigencia, nivel1, nivel2, nivel3, nivel4, nivel5,concepto));												 
    }
        
    public List<RecaudoEnteVO> buscarPagosSinRecaudoEstablecimientoPorMesYVigencia(int mes, Integer vigencia) throws ExcepcionDAO {
            return (distribucionMesDao.buscarPagosSinRecaudoEstablecimientoPorMesYVigencia(mes, vigencia));        
    }
    
    public BigDecimal buscarTotalPagosActuacionesAdmPorMesYVigencia(int mes,Integer vigencia) throws ExcepcionDAO {
        return asignacionRecaudoAaDao.buscarTotalPagosActuacionesAdmPorMesYVigencia(mes, vigencia);
    }
    
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmTodosMunicipiosPorMesConARaCodigo(int mes, Integer vigencia, String fechaLiq) throws ExcepcionDAO {
        return (distribucionMesDao.buscarValorRecaudoActAdmTodosMunicipiosPorMesConARaCodigo(mes, vigencia, fechaLiq));
    }
    
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmTodosMunicipiosPorMesSinARaCodigo(int mes, Integer vigencia, String fechaLiq) throws ExcepcionDAO {
        return (distribucionMesDao.buscarValorRecaudoActAdmTodosMunicipiosPorMesSinARaCodigo(mes, vigencia, fechaLiq));
    }
	
	public List<ConsolidadoDistVO> buscarConsolidadoDistribPorIdDistribucion(Long dmeCodigo) throws ExcepcionDAO {
        List<ConsolidadoDistVO> lista = new ArrayList();
        List<SiiConsolidadoDist> listaSii = consolidadoDistDao.buscarConsolidadoDistribPorIdDistribucion(dmeCodigo);
        if(listaSii!= null && listaSii.size()> 0 ){
            for(SiiConsolidadoDist unSii: listaSii){
                ConsolidadoDistVO unVo = new ConsolidadoDistVO(unSii);
                lista.add(unVo);
            }
        }
        return lista;
    }
    public List<ReporteOperadorVO> buscarValorRecaudoActAdmPorMesVigenciaReporte(int mes, Integer vigencia, String concepto,String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {
        
        return ( distribucionMesDao.buscarValorRecaudoActAdmPorMesVigenciaReporte(mes,vigencia,concepto,nivel1,nivel2,nivel3,nivel4,nivel5));
    }
    public List<ReporteOperadorVO> buscarValorRecaudoActAdmConsolidadoPorMesReporte(int mes, Integer vigencia, String concepto,String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {
        return( distribucionMesDao.buscarValorRecaudoActAdmConsolidadoPorMesReporte(mes,vigencia,concepto,nivel1,nivel2,nivel3,nivel4,nivel5));
        }
    
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmPorMesValidacion(int mes, Integer vigencia) throws ExcepcionDAO {
        
            return( distribucionMesDao.buscarValorRecaudoActAdmPorMesValidacion(mes, vigencia));
        }
    
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmPorMesYVigencia(int mes, Integer vigencia, String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO {
        return( distribucionMesDao.buscarValorRecaudoActAdmPorMesYVigencia(mes, vigencia, nivel1, nivel2, nivel3, nivel4, nivel5));
    }
}
