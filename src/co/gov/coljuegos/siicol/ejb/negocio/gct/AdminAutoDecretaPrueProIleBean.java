package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoDecretaPrueProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoDecretaPrueProIle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AutoDecretaPrueProIleVO;

import co.gov.coljuegos.siicol.ejb.vo.PerInvesProIleAutoPruVO;

import co.gov.coljuegos.siicol.ejb.vo.PruebaAutoDecrPruVO;

import co.gov.coljuegos.siicol.ejb.vo.TramiteAutoPrueTrasVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Autos que Decretan Pruebas para el Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminAutoDecretaPrueProIleBean implements AdminAutoDecretaPrueProIle 
{
    @EJB
    private AutoDecretaPrueProIleDAO autoDecretaPrueProIleDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminPerInvesProIleAutoPru adminPerInvesProIleAutoPru;
    @EJB
    private AdminPruebaAutoDecrPru adminPruebaAutoDecrPru;
    @EJB
    private AdminTramiteAutoPrueTras adminTramiteAutoPrueTras;
    
    
    
    /**
     * Constructor.
     */
    public AdminAutoDecretaPrueProIleBean() {
        super();
    }
    
    
    
    /**
     * Establece las listas hijas al value object resultante del almacenamiento de la entidad.
     * @param resultado - Value Object resultante.
     * @param autoDecretaPrueProIleVo -  Value Object base.
     */
    private void asignarHijos (AutoDecretaPrueProIleVO resultado, AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) 
    {
        resultado.setPerInvesProIleAutoPruList(autoDecretaPrueProIleVo.getPerInvesProIleAutoPruList());
        resultado.setPruebaAutoDecrPruListVo(autoDecretaPrueProIleVo.getPruebaAutoDecrPruListVo());
        resultado.setTramiteAutoPrueTrasListVo(autoDecretaPrueProIleVo.getTramiteAutoPrueTrasListVo());
    }
    
    
    /**
     * Persiste las entidades hijas del Auto que Decreta Pruebas.
     * @param autoDecretaPrueProIleVo - Auto que Decreta Pruebas del Proceso Sancionatorio de Ilegalidad.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirHijos (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        this.persistirPerInvesProIleAutoPru(autoDecretaPrueProIleVo);
        this.persistirPruebaAutoDecrPru(autoDecretaPrueProIleVo);
        this.persistirTramiteAutoPrueTras(autoDecretaPrueProIleVo);
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de las Personas Investigadas del Auto que Decreta Pruebas.
     * @param autoDecretaPrueProIleVo - Auto que Decreta Pruebas.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirPerInvesProIleAutoPru (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if(autoDecretaPrueProIleVo != null) {
            List<PerInvesProIleAutoPruVO> listaPerInvesProIleAutoPru = autoDecretaPrueProIleVo.getPerInvesProIleAutoPruList();
            if(listaPerInvesProIleAutoPru != null && !listaPerInvesProIleAutoPru.isEmpty()) {
                for(PerInvesProIleAutoPruVO pauVo : listaPerInvesProIleAutoPru) {
                    if(pauVo != null) {
                        pauVo.setAutoDecretaPrueProIleVo(autoDecretaPrueProIleVo);

                        if(pauVo.getPauCodigo() == null) {
                            // OPERACION INSERTAR
                            adminPerInvesProIleAutoPru.insertarPerInvesProIleAutoPru(pauVo);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminPerInvesProIleAutoPru.actualizarPerInvesProIleAutoPru(pauVo);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de las Pruebas del Auto que Decreta Pruebas.
     * @param autoDecretaPrueProIleVo - Auto que Decreta Pruebas.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirPruebaAutoDecrPru (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if(autoDecretaPrueProIleVo != null) {
            List<PruebaAutoDecrPruVO> listaPruebaAutoDecrPru = autoDecretaPrueProIleVo.getPruebaAutoDecrPruListVo();
            if(listaPruebaAutoDecrPru != null && !listaPruebaAutoDecrPru.isEmpty()) {
                for(PruebaAutoDecrPruVO papVo : listaPruebaAutoDecrPru) {
                    if(papVo != null) {
                        papVo.setAutoDecretaPrueProIleVo(autoDecretaPrueProIleVo);

                        if(papVo.getPapCodigo() == null) {
                            // OPERACION INSERTAR
                            adminPruebaAutoDecrPru.insertarPruebaAutoDecrPru(papVo);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminPruebaAutoDecrPru.actualizarPruebaAutoDecrPru(papVo);
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de los Tr&aacute;mites del Auto que Decreta Pruebas.
     * @param autoDecretaPrueProIleVo - Auto que Decreta Pruebas.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirTramiteAutoPrueTras (AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if(autoDecretaPrueProIleVo != null) {
            List<TramiteAutoPrueTrasVO> listaTramiteAutoPrueTras = autoDecretaPrueProIleVo.getTramiteAutoPrueTrasListVo();
            if(listaTramiteAutoPrueTras != null && !listaTramiteAutoPrueTras.isEmpty()) {
                for(TramiteAutoPrueTrasVO traVo : listaTramiteAutoPrueTras) {
                    if(traVo != null) {
                        traVo.setAutoDecretaPrueProIleVo(autoDecretaPrueProIleVo);

                        if(traVo.getTraCodigo() == null) {
                            // OPERACION INSERTAR
                            adminTramiteAutoPrueTras.insertarTramiteAutoPrueTras(traVo);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminTramiteAutoPrueTras.actualizarTramiteAutoPrueTras(traVo);
                        }
                    }
                }
            }
        }
    }
    
    
    
    @Override
    public AutoDecretaPrueProIleVO buscarAutoDecretaPrueProIlePorId(Long atpCodigo) throws ExcepcionDAO 
    {
        AutoDecretaPrueProIleVO resultado = null;
        SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle = autoDecretaPrueProIleDao.buscarPorCodigo(atpCodigo);
        if (siiAutoDecretaPrueProIle!=null)
            resultado = new AutoDecretaPrueProIleVO(siiAutoDecretaPrueProIle);
        
        return (resultado);
    }
    
    
    @Override
    public AutoDecretaPrueProIleVO insertarAutoDecretaPrueProIle(AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        return ( this.insertarAutoDecretaPrueProIle(autoDecretaPrueProIleVo, false) );
    }
    
    
    @Override
    public AutoDecretaPrueProIleVO insertarAutoDecretaPrueProIle(AutoDecretaPrueProIleVO autoDecretaPrueProIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        AutoDecretaPrueProIleVO resultado = null;
        SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle = autoDecretaPrueProIleDao.insertar(conversionVoEntidad.convertir(autoDecretaPrueProIleVo));
        if (siiAutoDecretaPrueProIle!=null) {
            resultado = new AutoDecretaPrueProIleVO(siiAutoDecretaPrueProIle);
            
            if (cascadeUpdate) {
                this.asignarHijos(resultado, autoDecretaPrueProIleVo);
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public AutoDecretaPrueProIleVO actualizarAutoDecretaPrueProIle(AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        return ( this.actualizarAutoDecretaPrueProIle(autoDecretaPrueProIleVo, false) );
    }
    
    
    @Override
    public AutoDecretaPrueProIleVO actualizarAutoDecretaPrueProIle(AutoDecretaPrueProIleVO autoDecretaPrueProIleVo, boolean cascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        AutoDecretaPrueProIleVO resultado = null;
        SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle = autoDecretaPrueProIleDao.actualizar(conversionVoEntidad.convertir(autoDecretaPrueProIleVo));
        if (siiAutoDecretaPrueProIle!=null) {
            resultado = new AutoDecretaPrueProIleVO(siiAutoDecretaPrueProIle);
            
            if (cascadeUpdate) {
                this.asignarHijos(resultado, autoDecretaPrueProIleVo);
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarAutoDecretaPrueProIle(Long atpCodigo) throws ExcepcionDAO {
        autoDecretaPrueProIleDao.eliminar(atpCodigo);
    }
    
    
    @Override
    public List<AutoDecretaPrueProIleVO> buscarTodoAutoDecretaPrueProIle() throws ExcepcionDAO 
    {
        List<AutoDecretaPrueProIleVO> resultado = null;
        List<SiiAutoDecretaPrueProIle> lista = autoDecretaPrueProIleDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<AutoDecretaPrueProIleVO>();
            
            for (SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle: lista) {
                if (siiAutoDecretaPrueProIle!=null) 
                    resultado.add(new AutoDecretaPrueProIleVO(siiAutoDecretaPrueProIle));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<AutoDecretaPrueProIleVO> buscarAutoDecretaPrueProIlePorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO 
    {
        List<AutoDecretaPrueProIleVO> resultado = null;
        List<SiiAutoDecretaPrueProIle> lista = autoDecretaPrueProIleDao.buscarAutoDecretaPrueProIlePorIdProcesoSancIlegalidad(prsCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<AutoDecretaPrueProIleVO>();
            
            for (SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle: lista) {
                if (siiAutoDecretaPrueProIle!=null) 
                    resultado.add(new AutoDecretaPrueProIleVO(siiAutoDecretaPrueProIle));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<AutoDecretaPrueProIleVO> buscarAutoDecretaPrueProIlePorProcesoYTipoAuto(Long prsCodigo, String atpTipoAuto) throws ExcepcionDAO 
    {
        List<AutoDecretaPrueProIleVO> resultado = null;
        List<SiiAutoDecretaPrueProIle> lista = autoDecretaPrueProIleDao.buscarAutoDecretaPrueProIlePorProcesoYTipoAuto(prsCodigo, atpTipoAuto);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<AutoDecretaPrueProIleVO>();
            
            for (SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle: lista) {
                if (siiAutoDecretaPrueProIle!=null) 
                    resultado.add(new AutoDecretaPrueProIleVO(siiAutoDecretaPrueProIle));
            }
        }
        
        return (resultado);
    }
}
