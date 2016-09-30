package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoDecretaPrueProIle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * Value Object para el manejo de Autos que Decretan Pruebas en un Proceso Sancionatorio de Ilegalidad.
 * @author Orlando Rodr&iacute;guez
 */
public class AutoDecretaPrueProIleVO implements Comparable<AutoDecretaPrueProIleVO>
{
    private Long atpCodigo;
    private String atpDecretaPru;
    private Integer atpDias;
    private String atpTipoAuto;
    private String atpRadicado;
    private Date atpFechaRad;
    private String atpNumero;
    private Date atpFecha;

    private ProcesoSancIlegalidadVO procesoSancIlegalidadVo;
    private UsuarioVO usuarioConecVo;

    private List<TramiteAutoPrueTrasVO> tramiteAutoPrueTrasListVo;
    private List<PruebaAutoDecrPruVO> pruebaAutoDecrPruListVo;
    private List<PerInvesProIleAutoPruVO> perInvesProIleAutoPruList;
    
    
    
    /**
     * Constructor.
     */
    public AutoDecretaPrueProIleVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiAutoDecretaPrueProIle - Entity.
     */
    public AutoDecretaPrueProIleVO (SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle) 
    {
        if (siiAutoDecretaPrueProIle!=null) {
            this.atpCodigo = siiAutoDecretaPrueProIle.getAtpCodigo();
            this.atpDecretaPru = siiAutoDecretaPrueProIle.getAtpDecretaPru();
            this.atpDias = siiAutoDecretaPrueProIle.getAtpDias();
            this.atpTipoAuto = siiAutoDecretaPrueProIle.getAtpTipoAuto();
            this.atpRadicado = siiAutoDecretaPrueProIle.getAtpRadicado();
            this.atpFechaRad = siiAutoDecretaPrueProIle.getAtpFechaRad();
            this.atpNumero = siiAutoDecretaPrueProIle.getAtpNumero();
            this.atpFecha = siiAutoDecretaPrueProIle.getAtpFecha();
            
            //Padres
            if (siiAutoDecretaPrueProIle.getSiiProcesoSancIlegalidad() != null) {
                this.procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(siiAutoDecretaPrueProIle.getSiiProcesoSancIlegalidad());
            }
            if (siiAutoDecretaPrueProIle.getSiiUsuarioConec() != null) {
                this.usuarioConecVo = new UsuarioVO(siiAutoDecretaPrueProIle.getSiiUsuarioConec());
            }
        }
    }
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(AutoDecretaPrueProIleVO autoDecretaPrueProIleVo) 
    {
        int resultado = -1;
        
        if (this.atpCodigo!=null && autoDecretaPrueProIleVo!=null && autoDecretaPrueProIleVo.atpCodigo!=null)
            resultado = this.atpCodigo.compareTo(autoDecretaPrueProIleVo.atpCodigo);
        
        return (resultado);
    }
    
    
    
    public void setAtpCodigo(Long atpCodigo) {
        this.atpCodigo = atpCodigo;
    }

    public Long getAtpCodigo() {
        return atpCodigo;
    }

    public void setAtpDecretaPru(String atpDecretaPru) {
        this.atpDecretaPru = atpDecretaPru;
    }

    public String getAtpDecretaPru() {
        return atpDecretaPru;
    }

    public void setAtpDias(Integer atpDias) {
        this.atpDias = atpDias;
    }

    public Integer getAtpDias() {
        return atpDias;
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

    public void setTramiteAutoPrueTrasListVo(List<TramiteAutoPrueTrasVO> tramiteAutoPrueTrasListVo) {
        this.tramiteAutoPrueTrasListVo = tramiteAutoPrueTrasListVo;
    }

    public List<TramiteAutoPrueTrasVO> getTramiteAutoPrueTrasListVo() {
        return tramiteAutoPrueTrasListVo;
    }

    public void setPruebaAutoDecrPruListVo(List<PruebaAutoDecrPruVO> pruebaAutoDecrPruListVo) {
        this.pruebaAutoDecrPruListVo = pruebaAutoDecrPruListVo;
    }

    public List<PruebaAutoDecrPruVO> getPruebaAutoDecrPruListVo() {
        return pruebaAutoDecrPruListVo;
    }

    public void setAtpTipoAuto(String atpTipoAuto) {
        this.atpTipoAuto = atpTipoAuto;
    }

    public String getAtpTipoAuto() {
        return atpTipoAuto;
    }

    public void setPerInvesProIleAutoPruList(List<PerInvesProIleAutoPruVO> perInvesProIleAutoPruList) {
        this.perInvesProIleAutoPruList = perInvesProIleAutoPruList;
    }

    public List<PerInvesProIleAutoPruVO> getPerInvesProIleAutoPruList() {
        return perInvesProIleAutoPruList;
    }

    public void setAtpRadicado(String atpRadicado) {
        this.atpRadicado = atpRadicado;
    }

    public String getAtpRadicado() {
        return atpRadicado;
    }

    public void setAtpFechaRad(Date atpFechaRad) {
        this.atpFechaRad = atpFechaRad;
    }

    public Date getAtpFechaRad() {
        return atpFechaRad;
    }

    public void setAtpNumero(String atpNumero) {
        this.atpNumero = atpNumero;
    }

    public String getAtpNumero() {
        return atpNumero;
    }

    public void setAtpFecha(Date atpFecha) {
        this.atpFecha = atpFecha;
    }

    public Date getAtpFecha() {
        return atpFecha;
    }
    
    
    

    /**
     * Obtiene la Cantidad de Personas Investigadas relacionadas en el Auto de Formulaci&oacute;n de Cargos.
     * @return perInvesProIleAutoPruList.size
     */
    public int getCantidadPersonasInvestigadas () 
    {
        return ( perInvesProIleAutoPruList!=null ? perInvesProIleAutoPruList.size() : 0 );
    }
    
    
    /**
     * Adiciona un registro de PerInvesProIleAutoPruVO a la lista.
     * @param perInvesProIleAutoPruVo - Registro que se desea adicionar.
     */
    public boolean addPerInvesProIleAutoPru (PerInvesProIleAutoPruVO perInvesProIleAutoPruVo) 
    {
        boolean exitoso = false;
        
        if (perInvesProIleAutoPruVo!=null) {
            if (perInvesProIleAutoPruList==null)
                perInvesProIleAutoPruList = new ArrayList<PerInvesProIleAutoPruVO>();
            
            
            exitoso = perInvesProIleAutoPruList.add(perInvesProIleAutoPruVo);
            
            if (exitoso)
                perInvesProIleAutoPruVo.setAutoDecretaPrueProIleVo(this);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro de PerInvesProIleAutoPruVO de la lista.
     * @param perInvesProIleAutoPruVo - Registro que se desea eliminar.
     */
    public boolean removePerInvesProIleAutoPru (PerInvesProIleAutoPruVO perInvesProIleAutoPruVo) 
    {
        boolean exitoso = false;
        
        if (perInvesProIleAutoPruVo!=null) {
            if (perInvesProIleAutoPruList!=null) {
                exitoso = perInvesProIleAutoPruList.remove(perInvesProIleAutoPruVo);
                
                if (exitoso)
                    perInvesProIleAutoPruVo.setAutoDecretaPrueProIleVo(null);
            }
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Adiciona un registro de TramiteAutoPrueTrasVO a la lista.
     * @param tramiteAutoForCarIleVo - Registro que se desea adicionar.
     */
    public boolean addTramiteAutoPrueTras (TramiteAutoPrueTrasVO tramiteAutoForCarIleVo) 
    {
        boolean exitoso = false;
        
        if (tramiteAutoForCarIleVo!=null) {
            if (tramiteAutoPrueTrasListVo==null)
                tramiteAutoPrueTrasListVo = new ArrayList<TramiteAutoPrueTrasVO>();
            
            
            exitoso = tramiteAutoPrueTrasListVo.add(tramiteAutoForCarIleVo);
            
            if (exitoso)
                tramiteAutoForCarIleVo.setAutoDecretaPrueProIleVo(this);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro de TramiteAutoPrueTrasVO de la lista.
     * @param tramiteAutoPrueTrasVo - Registro que se desea eliminar.
     */
    public boolean removeTramiteAutoPrueTras (TramiteAutoPrueTrasVO tramiteAutoPrueTrasVo) 
    {
        boolean exitoso = false;
        
        if (tramiteAutoPrueTrasVo!=null) {
            if (tramiteAutoPrueTrasListVo!=null) {
                exitoso = tramiteAutoPrueTrasListVo.remove(tramiteAutoPrueTrasVo);
                
                if (exitoso)
                    tramiteAutoPrueTrasVo.setAutoDecretaPrueProIleVo(null);
            }
        }
        
        return (exitoso);
    }
    
    
    /**
     * Adiciona un registro de PruebaAutoDecrPruVO a la lista.
     * @param pruebaAutoDecrPruVo - Registro que se desea adicionar.
     */
    public boolean addPruebaAutoDecrPru (PruebaAutoDecrPruVO pruebaAutoDecrPruVo) 
    {
        boolean exitoso = false;
        
        if (pruebaAutoDecrPruVo!=null) {
            if (pruebaAutoDecrPruListVo==null)
                pruebaAutoDecrPruListVo = new ArrayList<PruebaAutoDecrPruVO>();
            
            
            exitoso = pruebaAutoDecrPruListVo.add(pruebaAutoDecrPruVo);
            
            if (exitoso)
                pruebaAutoDecrPruVo.setAutoDecretaPrueProIleVo(this);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro de PruebaAutoDecrPruVO de la lista.
     * @param pruebaAutoDecrPruVo - Registro que se desea eliminar.
     */
    public boolean removePruebaAutoDecrPru (PruebaAutoDecrPruVO pruebaAutoDecrPruVo) 
    {
        boolean exitoso = false;
        
        if (pruebaAutoDecrPruVo!=null) {
            if (pruebaAutoDecrPruListVo!=null) {
                exitoso = pruebaAutoDecrPruListVo.remove(pruebaAutoDecrPruVo);
                
                if (exitoso)
                    pruebaAutoDecrPruVo.setAutoDecretaPrueProIleVo(null);
            }
        }
        
        return (exitoso);
    }
}
