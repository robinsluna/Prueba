package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoFormCargProIle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para el Auto de Formulaci&oacute;n de Cargos.
 * @author Camilo Miranda
 */
public class AutoFormCargProIleVO 
{
    private Long afcCodigo;
    private Date afcNumFechaRad;
    private String afcNumRadicado;
    private String afcNumero;
    private Date afcFecha;
    private Date afcFechaNotifica;

    private ProcesoSancIlegalidadVO procesoSancIlegalidadVo;
    private UsuarioVO usuarioConecVo;
    
    private List<PersonaInvProIleAutoVO> personaInvProIleAutoListVo;
    private List<TramiteAutoForCarIleVO> tramiteAutoForCarIleListVo;
    
    
    /**
     * Constructor.
     */
    public AutoFormCargProIleVO() { }
    
    
    /**
     * Constructor.
     * @param siiAutoFormCargProIle - Entity.
     */
    public AutoFormCargProIleVO(SiiAutoFormCargProIle siiAutoFormCargProIle) 
    {
        if (siiAutoFormCargProIle!=null) {
            this.afcCodigo = siiAutoFormCargProIle.getAfcCodigo();
            this.afcNumFechaRad = siiAutoFormCargProIle.getAfcNumFechaRad();
            this.afcNumRadicado = siiAutoFormCargProIle.getAfcNumRadicado();
            this.afcNumero = siiAutoFormCargProIle.getAfcNumero();
            this.afcFecha = siiAutoFormCargProIle.getAfcFecha();
            this.afcFechaNotifica = siiAutoFormCargProIle.getAfcFechaNotifica();
            
            
            //Padres
            if (siiAutoFormCargProIle.getSiiProcesoSancIlegalidad()!= null) {
                this.procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(siiAutoFormCargProIle.getSiiProcesoSancIlegalidad());
            }
            if (siiAutoFormCargProIle.getSiiUsuarioConec()!=null) {
                this.usuarioConecVo = new UsuarioVO(siiAutoFormCargProIle.getSiiUsuarioConec());
            }
        }
    }

    public void setAfcCodigo(Long afcCodigo) {
        this.afcCodigo = afcCodigo;
    }

    public Long getAfcCodigo() {
        return afcCodigo;
    }

    public void setAfcNumFechaRad(Date afcNumFechaRad) {
        this.afcNumFechaRad = afcNumFechaRad;
    }

    public Date getAfcNumFechaRad() {
        return afcNumFechaRad;
    }

    public void setAfcNumRadicado(String afcNumRadicado) {
        this.afcNumRadicado = afcNumRadicado;
    }

    public String getAfcNumRadicado() {
        return afcNumRadicado;
    }

    public void setProcesoSancIlegalidadVo(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) {
        this.procesoSancIlegalidadVo = procesoSancIlegalidadVo;
    }

    public ProcesoSancIlegalidadVO getProcesoSancIlegalidadVo() {
        return procesoSancIlegalidadVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setPersonaInvProIleAutoListVo(List<PersonaInvProIleAutoVO> personaInvProIleAutoListVo) {
        this.personaInvProIleAutoListVo = personaInvProIleAutoListVo;
    }

    public List<PersonaInvProIleAutoVO> getPersonaInvProIleAutoListVo() {
        return personaInvProIleAutoListVo;
    }

    public void setTramiteAutoForCarIleListVo(List<TramiteAutoForCarIleVO> tramiteAutoForCarIleListVo) {
        this.tramiteAutoForCarIleListVo = tramiteAutoForCarIleListVo;
    }

    public List<TramiteAutoForCarIleVO> getTramiteAutoForCarIleListVo() {
        return tramiteAutoForCarIleListVo;
    }

    public void setAfcNumero(String afcNumero) {
        this.afcNumero = afcNumero;
    }

    public String getAfcNumero() {
        return afcNumero;
    }

    public void setAfcFecha(Date afcFecha) {
        this.afcFecha = afcFecha;
    }

    public Date getAfcFecha() {
        return afcFecha;
    }

    public void setAfcFechaNotifica(Date afcFechaNotifica) {
        this.afcFechaNotifica = afcFechaNotifica;
    }

    public Date getAfcFechaNotifica() {
        return afcFechaNotifica;
    }
    
    
    
    /**
     * Obtiene la Cantidad de Personas Investigadas relacionadas en el Auto de Formulaci&oacute;n de Cargos.
     * @return personaInvProIleAutoListVo.size
     */
    public int getCantidadPersonasInvestigadas () 
    {
        return ( personaInvProIleAutoListVo!=null ? personaInvProIleAutoListVo.size() : 0 );
    }
    
    
    


    /**
     * Adiciona un registro de PersonaInvProIleAutoVO a la lista.
     * @param personaInvProIleAutoVo - Registro que se desea adicionar.
     */
    public boolean addPersonaInvProIleAuto (PersonaInvProIleAutoVO personaInvProIleAutoVo) 
    {
        boolean exitoso = false;
        
        if (personaInvProIleAutoVo!=null) {
            if (personaInvProIleAutoListVo==null)
                personaInvProIleAutoListVo = new ArrayList<PersonaInvProIleAutoVO>();
            
            
            exitoso = personaInvProIleAutoListVo.add(personaInvProIleAutoVo);
            
            if (exitoso)
                personaInvProIleAutoVo.setAutoFormCargProIleVo(this);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro de PersonaInvProIleAutoVO de la lista.
     * @param personaInvProIleAutoVo - Registro que se desea eliminar.
     */
    public boolean removePersonaInvProIleAuto (PersonaInvProIleAutoVO personaInvProIleAutoVo) 
    {
        boolean exitoso = false;
        
        if (personaInvProIleAutoVo!=null) {
            if (personaInvProIleAutoListVo!=null) {
                exitoso = personaInvProIleAutoListVo.remove(personaInvProIleAutoVo);
                
                if (exitoso)
                    personaInvProIleAutoVo.setAutoFormCargProIleVo(null);
            }
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Adiciona un registro de TramiteAutoForCarIleVO a la lista.
     * @param tramiteAutoForCarIleVo - Registro que se desea adicionar.
     */
    public boolean addTramiteAutoForCarIle (TramiteAutoForCarIleVO tramiteAutoForCarIleVo) 
    {
        boolean exitoso = false;
        
        if (tramiteAutoForCarIleVo!=null) {
            if (tramiteAutoForCarIleListVo==null)
                tramiteAutoForCarIleListVo = new ArrayList<TramiteAutoForCarIleVO>();
            
            
            exitoso = tramiteAutoForCarIleListVo.add(tramiteAutoForCarIleVo);
            
            if (exitoso)
                tramiteAutoForCarIleVo.setAutoFormCargProIleVo(this);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro de TramiteAutoForCarIleVO de la lista.
     * @param tramiteAutoForCarIleVo - Registro que se desea eliminar.
     */
    public boolean removeTramiteAutoForCarIle (TramiteAutoForCarIleVO tramiteAutoForCarIleVo) 
    {
        boolean exitoso = false;
        
        if (tramiteAutoForCarIleVo!=null) {
            if (tramiteAutoForCarIleListVo!=null) {
                exitoso = tramiteAutoForCarIleListVo.remove(tramiteAutoForCarIleVo);
                
                if (exitoso)
                    tramiteAutoForCarIleVo.setAutoFormCargProIleVo(null);
            }
        }
        
        return (exitoso);
    }
}
