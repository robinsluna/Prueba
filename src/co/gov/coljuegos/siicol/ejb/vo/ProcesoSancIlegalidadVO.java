package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancIlegalidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para el manejo del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
public class ProcesoSancIlegalidadVO 
{
    private Date prsAuArcFechaGen;
    private Date prsAuArcSolNFecR;
    private String prsAuArcSolNRadi;
    private Long prsCodigo;
    private Integer prsConsecutivo;
    private String prsInterpRecApel;
    private String prsInterpRecRepo;   
    private Date prsFechaConHech;
    private String prsNumeroAuto;
    private Date prsFechaAuto;

    private ResolucionProcIlegVO resolucionProcIlegApelaVo;
    private ResolucionProcIlegVO resolucionProcIlegResolVo;
    private ResolucionProcIlegVO resolucionProcIlegSinSancionVo;
    private DenunciaVO denunciaVo;
    private SustanciadorAuditorVO sustanciadorAuditorVo;
    private ResolucionProcIlegVO resolucionProcIlegReposicionVo;
    private UsuarioVO usuarioConecVo;
    private EstadoProcSanIlegVO estadoProcSanIlegVo;
    
    /**No pertenece al VO*/
    private AccionControlVO accionControlVo;

    private List<AutoDecretaPrueProIleVO> autoDecretaPrueProIleListVo;
    private List<ComunicacSujSancIleVO> comunicacSujSancIleListVo;
    private List<PersonaInvestProIleVO> personaInvestProIleListVo;
    private List<AutoFormCargProIleVO> autoFormCargProIleListVo;
    private List<DescargoProcIlegVO> descargoProcIlegListVo;
    private List<InhabilidadPersonaVO> inhabilidadPersonaList;
    private List<ElementoProcesoIleVO> elementoProcesoIleListVo;
    private List<CuotaOperadorVO> cuotaOperadorListVo;
    private List<DocumentoContableVO> documentoContableListVo;
    
   
    // Datos adicionales a la entidad
    private Integer numeroDiasVencimiento;
    // Manejo de cambios de estado
    /** Estado anterior del Proceso estadoProcSanIlegVo.epiCodigo */
    private Long idEstadoAnterior;


    /**
     * Constructor.
     */
    public ProcesoSancIlegalidadVO() { }
    
    
    /**
     * Constructor.
     * @param siiProcesoSancIlegalidad - Entidad.
     */
    public ProcesoSancIlegalidadVO(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        if(siiProcesoSancIlegalidad != null) {
            this.prsAuArcFechaGen = siiProcesoSancIlegalidad.getPrsAuArcFechaGen();
            this.prsAuArcSolNFecR = siiProcesoSancIlegalidad.getPrsAuArcSolNFecR();
            this.prsAuArcSolNRadi = siiProcesoSancIlegalidad.getPrsAuArcSolNRadi();
            this.prsCodigo = siiProcesoSancIlegalidad.getPrsCodigo();
            this.prsConsecutivo = siiProcesoSancIlegalidad.getPrsConsecutivo();
            this.prsInterpRecApel = siiProcesoSancIlegalidad.getPrsInterpRecApel();
            this.prsInterpRecRepo = siiProcesoSancIlegalidad.getPrsInterpRecRepo();
            this.prsFechaConHech = siiProcesoSancIlegalidad.getPrsFechaConHech();
            this.prsNumeroAuto = siiProcesoSancIlegalidad.getPrsNumeroAuto();
            this.prsFechaAuto = siiProcesoSancIlegalidad.getPrsFechaAuto();

            //Padres
            if(siiProcesoSancIlegalidad.getSiiResolucionProcIlegApela() != null) {
                this.resolucionProcIlegApelaVo = new ResolucionProcIlegVO(siiProcesoSancIlegalidad.getSiiResolucionProcIlegApela());
            }
            if(siiProcesoSancIlegalidad.getSiiResolucionProcIlegResol() != null) {
                this.resolucionProcIlegResolVo = new ResolucionProcIlegVO(siiProcesoSancIlegalidad.getSiiResolucionProcIlegResol());
            }
            if(siiProcesoSancIlegalidad.getSiiResolucionProcIlegSinSancion() != null) {
                this.resolucionProcIlegSinSancionVo = new ResolucionProcIlegVO(siiProcesoSancIlegalidad.getSiiResolucionProcIlegSinSancion());
            }
            if(siiProcesoSancIlegalidad.getSiiDenuncia() != null)
                this.denunciaVo = new DenunciaVO(siiProcesoSancIlegalidad.getSiiDenuncia());

            if(siiProcesoSancIlegalidad.getSiiResolucionProcIlegReposicion() != null) {
                this.resolucionProcIlegReposicionVo = new ResolucionProcIlegVO(siiProcesoSancIlegalidad.getSiiResolucionProcIlegReposicion());
            }
            if(siiProcesoSancIlegalidad.getSiiUsuarioConec() != null)
                this.usuarioConecVo = new UsuarioVO(siiProcesoSancIlegalidad.getSiiUsuarioConec());
            if(siiProcesoSancIlegalidad.getSiiEstadoProcSanIleg() != null) {
                this.estadoProcSanIlegVo = new EstadoProcSanIlegVO(siiProcesoSancIlegalidad.getSiiEstadoProcSanIleg());
            }
        }
    }

    
    
    public void setPrsAuArcFechaGen(Date prsAuArcFechaGen) {
        this.prsAuArcFechaGen = prsAuArcFechaGen;
    }

    public Date getPrsAuArcFechaGen() {
        return prsAuArcFechaGen;
    }

    public void setPrsAuArcSolNFecR(Date prsAuArcSolNFecR) {
        this.prsAuArcSolNFecR = prsAuArcSolNFecR;
    }

    public Date getPrsAuArcSolNFecR() {
        return prsAuArcSolNFecR;
    }

    public void setPrsAuArcSolNRadi(String prsAuArcSolNRadi) {
        this.prsAuArcSolNRadi = prsAuArcSolNRadi;
    }

    public String getPrsAuArcSolNRadi() {
        return prsAuArcSolNRadi;
    }

    public void setPrsCodigo(Long prsCodigo) {
        this.prsCodigo = prsCodigo;
    }

    public Long getPrsCodigo() {
        return prsCodigo;
    }

    public void setPrsConsecutivo(Integer prsConsecutivo) {
        this.prsConsecutivo = prsConsecutivo;
    }

    public Integer getPrsConsecutivo() {
        return prsConsecutivo;
    }

    public void setPrsInterpRecApel(String prsInterpRecApel) {
        this.prsInterpRecApel = prsInterpRecApel;
    }

    public String getPrsInterpRecApel() {
        return prsInterpRecApel;
    }

    public void setPrsInterpRecRepo(String prsInterpRecRepo) {
        this.prsInterpRecRepo = prsInterpRecRepo;
    }

    public String getPrsInterpRecRepo() {
        return prsInterpRecRepo;
    }

    public void setDenunciaVo(DenunciaVO denunciaVo) {
        this.denunciaVo = denunciaVo;
    }

    public DenunciaVO getDenunciaVo() {
        return denunciaVo;
    }

    public void setSustanciadorAuditorVo(SustanciadorAuditorVO sustanciadorAuditorVo) {
        this.sustanciadorAuditorVo = sustanciadorAuditorVo;
    }

    public SustanciadorAuditorVO getSustanciadorAuditorVo() {
        return sustanciadorAuditorVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setInhabilidadPersonaList(List<InhabilidadPersonaVO> inhabilidadPersonaList) {
        this.inhabilidadPersonaList = inhabilidadPersonaList;
    }

    public List<InhabilidadPersonaVO> getInhabilidadPersonaList() {
        return inhabilidadPersonaList;
    }
    
    
    
    /**
     * Adiciona un registro al listado de InhabilidadPersonaVO.
     * @param inhabilidadPersonaVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addInhabilidadPersona (InhabilidadPersonaVO inhabilidadPersonaVo) 
    {
        boolean exitoso = false;
        
        if (inhabilidadPersonaList==null)
            inhabilidadPersonaList = new ArrayList<InhabilidadPersonaVO>();
        
        exitoso = inhabilidadPersonaList.add(inhabilidadPersonaVo);
        
        if (exitoso)
            inhabilidadPersonaVo.setProcesoSancIlegalidadVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado InhabilidadPersonaVO.
     * @param inhabilidadPersonaVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeInhabilidadPersona (InhabilidadPersonaVO inhabilidadPersonaVo) {
        boolean exitoso = false;
        
        if (inhabilidadPersonaList!=null) {
            exitoso = inhabilidadPersonaList.remove(inhabilidadPersonaVo);
            
            if (exitoso)
                inhabilidadPersonaVo.setProcesoSancIlegalidadVo(null);
        }
        
        return (exitoso);
    }

    public void setResolucionProcIlegApelaVo(ResolucionProcIlegVO resolucionProcIlegApelaVo) {
        this.resolucionProcIlegApelaVo = resolucionProcIlegApelaVo;
    }

    public ResolucionProcIlegVO getResolucionProcIlegApelaVo() {
        return resolucionProcIlegApelaVo;
    }

    public void setResolucionProcIlegResolVo(ResolucionProcIlegVO resolucionProcIlegResolVo) {
        this.resolucionProcIlegResolVo = resolucionProcIlegResolVo;
    }

    public ResolucionProcIlegVO getResolucionProcIlegResolVo() {
        return resolucionProcIlegResolVo;
    }

    public void setResolucionProcIlegReposicionVo(ResolucionProcIlegVO resolucionProcIlegReposicionVo) {
        this.resolucionProcIlegReposicionVo = resolucionProcIlegReposicionVo;
    }

    public ResolucionProcIlegVO getResolucionProcIlegReposicionVo() {
        return resolucionProcIlegReposicionVo;
    }

    public void setEstadoProcSanIlegVo(EstadoProcSanIlegVO estadoProcSanIlegVo) {
        this.estadoProcSanIlegVo = estadoProcSanIlegVo;
    }

    public EstadoProcSanIlegVO getEstadoProcSanIlegVo() {
        return estadoProcSanIlegVo;
    }

    public void setAutoDecretaPrueProIleListVo(List<AutoDecretaPrueProIleVO> autoDecretaPrueProIleListVo) {
        this.autoDecretaPrueProIleListVo = autoDecretaPrueProIleListVo;
    }

    public List<AutoDecretaPrueProIleVO> getAutoDecretaPrueProIleListVo() {
        return autoDecretaPrueProIleListVo;
    }

    public void setComunicacSujSancIleListVo(List<ComunicacSujSancIleVO> comunicacSujSancIleListVo) {
        this.comunicacSujSancIleListVo = comunicacSujSancIleListVo;
    }

    public List<ComunicacSujSancIleVO> getComunicacSujSancIleListVo() {
        return comunicacSujSancIleListVo;
    }

    public void setPersonaInvestProIleListVo(List<PersonaInvestProIleVO> personaInvestProIleListVo) {
        this.personaInvestProIleListVo = personaInvestProIleListVo;
    }

    public List<PersonaInvestProIleVO> getPersonaInvestProIleListVo() {
        return personaInvestProIleListVo;
    }

    public void setAutoFormCargProIleListVo(List<AutoFormCargProIleVO> autoFormCargProIleListVo) {
        this.autoFormCargProIleListVo = autoFormCargProIleListVo;
    }

    public List<AutoFormCargProIleVO> getAutoFormCargProIleListVo() {
        return autoFormCargProIleListVo;
    }

    public void setDescargoProcIlegListVo(List<DescargoProcIlegVO> descargoProcIlegListVo) {
        this.descargoProcIlegListVo = descargoProcIlegListVo;
    }

    public List<DescargoProcIlegVO> getDescargoProcIlegListVo() {
        return descargoProcIlegListVo;
    }

    public void setResolucionProcIlegSinSancionVo(ResolucionProcIlegVO resolucionProcIlegSinSancionVo) {
        this.resolucionProcIlegSinSancionVo = resolucionProcIlegSinSancionVo;
    }

    public ResolucionProcIlegVO getResolucionProcIlegSinSancionVo() {
        return resolucionProcIlegSinSancionVo;
    }

    public void setPrsFechaConHech(Date prsFechaConHech) {
        this.prsFechaConHech = prsFechaConHech;
    }

    public Date getPrsFechaConHech() {
        return prsFechaConHech;
    }


    public void setAccionControlVo(AccionControlVO accionControlVo) {
        this.accionControlVo = accionControlVo;
    }

    public AccionControlVO getAccionControlVo() {
        return accionControlVo;
    }

    public void setElementoProcesoIleListVo(List<ElementoProcesoIleVO> elementoProcesoIleListVo) {
        this.elementoProcesoIleListVo = elementoProcesoIleListVo;
    }

    public List<ElementoProcesoIleVO> getElementoProcesoIleListVo() {
        return elementoProcesoIleListVo;
    }
    
    
    /**
     * Adiciona un registro al listado de ElementoProcesoIleVO.
     * @param elementoProcesoIleVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addElementoProcesoIle (ElementoProcesoIleVO elementoProcesoIleVo) 
    {
        boolean exitoso = false;
        
        if (elementoProcesoIleListVo==null)
            elementoProcesoIleListVo = new ArrayList<ElementoProcesoIleVO>();
        
        exitoso = elementoProcesoIleListVo.add(elementoProcesoIleVo);
        
        if (exitoso)
            elementoProcesoIleVo.setProcesoSancIlegalidadVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado ElementoProcesoIleVO.
     * @param elementoProcesoIleVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeElementoProcesoIle (ElementoProcesoIleVO elementoProcesoIleVo) {
        boolean exitoso = false;
        
        if (elementoProcesoIleListVo!=null) {
            exitoso = elementoProcesoIleListVo.remove(elementoProcesoIleVo);
            
            if (exitoso)
                elementoProcesoIleVo.setProcesoSancIlegalidadVo(null);
        }
        
        return (exitoso);
    }
    
    
    
    public void setCuotaOperadorListVo(List<CuotaOperadorVO> cuotaOperadorListVo) {
        this.cuotaOperadorListVo = cuotaOperadorListVo;
    }

    public List<CuotaOperadorVO> getCuotaOperadorListVo() {
        return cuotaOperadorListVo;
    }

    public void setDocumentoContableListVo(List<DocumentoContableVO> documentoContableListVo) {
        this.documentoContableListVo = documentoContableListVo;
    }

    public List<DocumentoContableVO> getDocumentoContableListVo() {
        return documentoContableListVo;
    }
    
    
    
    
    /**
     * @return Número de días para vencimiento:
     * - Si el estado en el que se encuentra el proceso existe en la tabla de parametrización de Términos procesales, el número de días para el vencimiento inicia en el número de días que tiene parametrizado el estado en la tabla.
     * - Si el estado en el que se encuentra el proceso es AUTO DECRETA PRUEBAS COMUNICADO, el número de días para el vencimiento inicia en el número de días registrado en el último auto que decreta pruebas del proceso.
     */
    public Integer getNumeroDiasVencimiento() {
        return numeroDiasVencimiento;
    }
    
    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }
    
    
    /**
     * Obtiene la Cantidad de Elementos relacionados en el Proceso Sancionatorio de Ilegalidad.
     * @return elementoProcesoIleListVo.size
     */
    public int getCantidadElementos () 
    {
        return ( elementoProcesoIleListVo!=null ? elementoProcesoIleListVo.size() : 0 );
    }

    public void setPrsNumeroAuto(String prsNumeroAuto) {
        this.prsNumeroAuto = prsNumeroAuto;
    }

    public String getPrsNumeroAuto() {
        return prsNumeroAuto;
    }

    public void setPrsFechaAuto(Date prsFechaAuto) {
        this.prsFechaAuto = prsFechaAuto;
    }

    public Date getPrsFechaAuto() {
        return prsFechaAuto;
    }
}
