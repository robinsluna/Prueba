package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoFormCargProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaInvProIleAutoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteAutoForCarIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoFormCargProIle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AutoFormCargProIleVO;

import co.gov.coljuegos.siicol.ejb.vo.PersonaInvProIleAutoVO;

import co.gov.coljuegos.siicol.ejb.vo.TramiteAutoForCarIleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo del Auto de Formulaci&oacute;n de Cargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminAutoFormCargProIleBean implements AdminAutoFormCargProIle 
{
    @EJB
    private AutoFormCargProIleDAO autoFormCargProIleDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private PersonaInvProIleAutoDAO personaInvProIleAutoDao;
    @EJB
    private TramiteAutoForCarIleDAO tramiteAutoForCarIleDao;
        
    
    /**
     * Constructor.
     */       
    public AdminAutoFormCargProIleBean() { }
    
    
    
    /**
     * Asigna los hijos del Auto de Formulaci&oacute;n de Cargos.
     * @param resultado - Auto Destino.
     * @param autoFormCargProIleVo - Auto Origen.
     */
    private void asignarHijos (AutoFormCargProIleVO resultado, AutoFormCargProIleVO autoFormCargProIleVo) 
    {
        if (resultado!=null && autoFormCargProIleVo!=null) {
            
            resultado.setPersonaInvProIleAutoListVo(autoFormCargProIleVo.getPersonaInvProIleAutoListVo());
            resultado.setTramiteAutoForCarIleListVo(autoFormCargProIleVo.getTramiteAutoForCarIleListVo());
            
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de los hijos del Auto de Formulaci&oacute;n de Cargos.
     * @param autoFormCargProIleVo - Auto de Formulaci&oacute;n de Cargos.
     * @throws ExcepcionDAO
     */
    private void persistirHijos (AutoFormCargProIleVO autoFormCargProIleVo) throws ExcepcionDAO 
    {
        this.persistirPersonaInvProIleAuto(autoFormCargProIleVo);
        this.persistirTramiteAutoForCarIle(autoFormCargProIleVo);
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de las Personas Investigadas del Auto de Formulaci&oacute;n de Cargos.
     * @param autoFormCargProIleVo - Auto de Formulaci&oacute;n de Cargos.
     * @throws ExcepcionDAO
     */
    private void persistirPersonaInvProIleAuto (AutoFormCargProIleVO autoFormCargProIleVo) throws ExcepcionDAO 
    {
        if(autoFormCargProIleVo != null) {
            List<PersonaInvProIleAutoVO> listaPersonaInvProIleAuto = autoFormCargProIleVo.getPersonaInvProIleAutoListVo();
            if(listaPersonaInvProIleAuto != null && !listaPersonaInvProIleAuto.isEmpty()) {
                for(PersonaInvProIleAutoVO piaVo : listaPersonaInvProIleAuto) {
                    if(piaVo != null) {
                        piaVo.setAutoFormCargProIleVo(autoFormCargProIleVo);

                        if(piaVo.getPiaCodigo() == null) {
                            // OPERACION INSERTAR
                            personaInvProIleAutoDao.insertar(conversionVoEntidad.convertir(piaVo));
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            personaInvProIleAutoDao.actualizar(conversionVoEntidad.convertir(piaVo));
                        }
                    }
                }
            }
        }
    }
    
    
    /**
     * Almacena la informaci&oacute;n de los Tr&aacute;mites del Auto de Formulaci&oacute;n de Cargos.
     * @param autoFormCargProIleVo - Auto de Formulaci&oacute;n de Cargos.
     * @throws ExcepcionDAO
     */
    private void persistirTramiteAutoForCarIle (AutoFormCargProIleVO autoFormCargProIleVo) throws ExcepcionDAO 
    {
        if(autoFormCargProIleVo != null) {
            List<TramiteAutoForCarIleVO> listaTramiteAutoForCarIle = autoFormCargProIleVo.getTramiteAutoForCarIleListVo();
            if(listaTramiteAutoForCarIle != null && !listaTramiteAutoForCarIle.isEmpty()) {
                for(TramiteAutoForCarIleVO tafVo : listaTramiteAutoForCarIle) {
                    if(tafVo != null) {
                        tafVo.setAutoFormCargProIleVo(autoFormCargProIleVo);

                        if(tafVo.getTafCodigo() == null) {
                            // OPERACION INSERTAR
                            tramiteAutoForCarIleDao.insertar(conversionVoEntidad.convertir(tafVo));
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            tramiteAutoForCarIleDao.actualizar(conversionVoEntidad.convertir(tafVo));
                        }
                    }
                }
            }
        }
    }
    
    
    
    @Override
    public AutoFormCargProIleVO buscarAutoFormCargProIlePorId(Long afcCodigo) throws ExcepcionDAO {
        AutoFormCargProIleVO resultado = null;
        SiiAutoFormCargProIle siiAutoFormCargProIle = autoFormCargProIleDao.buscarPorCodigo(afcCodigo);
        if (siiAutoFormCargProIle!=null)
            resultado = new AutoFormCargProIleVO(siiAutoFormCargProIle);
        
        return (resultado);
    }
    
    
    @Override
    public AutoFormCargProIleVO insertarAutoFormCargProIle(AutoFormCargProIleVO autoFormCargProIleVo) throws ExcepcionDAO {
        return ( this.insertarAutoFormCargProIle(autoFormCargProIleVo, false) );
    }
    
    
    @Override
    public AutoFormCargProIleVO insertarAutoFormCargProIle(AutoFormCargProIleVO autoFormCargProIleVo, boolean cascadeUpdate) throws ExcepcionDAO 
    {
        AutoFormCargProIleVO resultado = null;
        SiiAutoFormCargProIle siiAutoFormCargProIle = autoFormCargProIleDao.insertar(conversionVoEntidad.convertir(autoFormCargProIleVo));
        if (siiAutoFormCargProIle!=null) {
            resultado = new AutoFormCargProIleVO(siiAutoFormCargProIle);
            
            if (cascadeUpdate) {
                this.asignarHijos(resultado, autoFormCargProIleVo);
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public AutoFormCargProIleVO actualizarAutoFormCargProIle(AutoFormCargProIleVO autoFormCargProIleVo) throws ExcepcionDAO {
        return ( this.actualizarAutoFormCargProIle(autoFormCargProIleVo, false) );
    }
    
    
    @Override
    public AutoFormCargProIleVO actualizarAutoFormCargProIle(AutoFormCargProIleVO autoFormCargProIleVo, boolean cascadeUpdate) throws ExcepcionDAO 
    {
        AutoFormCargProIleVO resultado = null;
        SiiAutoFormCargProIle siiAutoFormCargProIle = autoFormCargProIleDao.actualizar(conversionVoEntidad.convertir(autoFormCargProIleVo));
        if (siiAutoFormCargProIle!=null) {
            resultado = new AutoFormCargProIleVO(siiAutoFormCargProIle);
            
            if (cascadeUpdate) {
                this.asignarHijos(resultado, autoFormCargProIleVo);
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarAutoFormCargProIle(Long afcCodigo) throws ExcepcionDAO {
        autoFormCargProIleDao.eliminar(afcCodigo);
    }
    
    
    @Override
    public List<AutoFormCargProIleVO> buscarTodoAutoFormCargProIle() throws ExcepcionDAO {
        List<AutoFormCargProIleVO> resultado = null;
        List<SiiAutoFormCargProIle> lista = autoFormCargProIleDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<AutoFormCargProIleVO>();
            for (SiiAutoFormCargProIle siiAutoFormCargProIle: lista) {
                if (siiAutoFormCargProIle!=null)
                    resultado.add(new AutoFormCargProIleVO(siiAutoFormCargProIle));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<AutoFormCargProIleVO> buscarAutoFormCargProIlePorIdProcesoSancIlegalidad(Long prsCodigo) throws ExcepcionDAO {
        List<AutoFormCargProIleVO> resultado = null;
        List<SiiAutoFormCargProIle> lista = autoFormCargProIleDao.buscarAutoFormCargProIlePorIdProcesoSancIlegalidad(prsCodigo);
        if (lista!=null) {
            resultado = new ArrayList<AutoFormCargProIleVO>();
            for (SiiAutoFormCargProIle siiAutoFormCargProIle: lista) {
                if (siiAutoFormCargProIle!=null)
                    resultado.add(new AutoFormCargProIleVO(siiAutoFormCargProIle));
            }
        }
        
        return (resultado);
    }
}
