package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancionatorio;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para el Proceso Sancionatorio.
 * @author Camilo Miranda
 */
public class ProcesoSancionatorioVO 
{
    private String psaAuprDecretaPr;
    private Integer psaAuprNumDias;
    private BigDecimal psaBorTotales;
    private Long psaCodigo;
    private Date psaComFechaRad;
    private String psaComRadicado;
    private Date psaFechaAutoArch;
    private Date psaFechaGenAuTrAl;
    private String psaMotivoInexac;
    private String psaMotivoOmision;
    private Date psaNumFechaRad;
    private String psaNumRadicado;
    private String psaPruDescripcion;
    private Date psaPruFechaRad;
    private String psaPruRadicado;
    private Date psaResulFecha;
    private String psaResulIndResp;
    private String psaResulNumGuia;
    private Date psaSnataFechaRad;
    private String psaSnataRadicado;
    private Date psaSnaupFechaRad;
    private String psaSnaupRadicado;
    private Date psaSnumaarFechaRad;
    private String psaSnumaarRadicado;
    private Integer psaConsecutivo;
    private String psaInterpRecurso;
    private String psaInterpApelacion;
    
    private ResolucionProcSancVO resolucionProcSancSanc;
    private ResolucionProcSancVO resolucionProcSancSin;
    private ResolucionProcSancVO resolucionProcSancRepos;
    private ResolucionProcSancVO resolucionProcSancApela;
    private EstadoProcesoSancVO estadoProcesoSancVo;
    private ContratoVO contratoVo;
    private ArchivoFisicoVO archivoFisicoAuto;
    private InformeSupervisionVO informeSupervisionVo;
    private UsuarioVO usuarioRegistraVo;
    
    private List<DescargoProcSanVO> descargoProcSanList;
    private List<CuotaInexacProcSancVO> cuotaInexacProcSancList;
    private List<InventarioProcSanVO> inventarioProcSanList;
    private List<CuotaOmisProcSancVO> cuotaOmisProcSancList;
    private List<RepartoFiscalizadorVO> repartoFiscalizadorList;
    private List<InhabilidadPersonaVO> inhabilidadPersonaList;
    private List<RecepcionAlegatoProSanVO> recepcionAlegatoProSanList;
    private List<DocumentoContableVO> documentoContableList;
    private List<CuotaOperadorVO> cuotaOperadorList;
    
    
    // Manejo de cambios de estado
    /** Estado anterior del Proceso Sancionatorio de Fiscalizacion (estadoProcesoSancVo.epsCodigo). */
    private Long idEstadoAnterior;
    
    
    
    
    /**
     * Constructor.
     */
    public ProcesoSancionatorioVO() {
    }
    
    
    /**
     * Constructor.
     * @param siiProcesoSancionatorio - Entity.
     */
    public ProcesoSancionatorioVO(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        if (siiProcesoSancionatorio!=null) {
            this.psaAuprDecretaPr = siiProcesoSancionatorio.getPsaAuprDecretaPr();
            this.psaAuprNumDias = siiProcesoSancionatorio.getPsaAuprNumDias();
            this.psaBorTotales = siiProcesoSancionatorio.getPsaBorTotales();
            this.psaCodigo = siiProcesoSancionatorio.getPsaCodigo();
            this.psaComFechaRad = siiProcesoSancionatorio.getPsaComFechaRad();
            this.psaComRadicado = siiProcesoSancionatorio.getPsaComRadicado();
            this.psaFechaAutoArch = siiProcesoSancionatorio.getPsaFechaAutoArch();
            this.psaFechaGenAuTrAl = siiProcesoSancionatorio.getPsaFechaGenAuTrAl();
            this.psaMotivoInexac = siiProcesoSancionatorio.getPsaMotivoInexac();
            this.psaMotivoOmision = siiProcesoSancionatorio.getPsaMotivoOmision();
            this.psaNumFechaRad = siiProcesoSancionatorio.getPsaNumFechaRad();
            this.psaNumRadicado = siiProcesoSancionatorio.getPsaNumRadicado();
            this.psaPruDescripcion = siiProcesoSancionatorio.getPsaPruDescripcion();
            this.psaPruFechaRad = siiProcesoSancionatorio.getPsaPruFechaRad();
            this.psaPruRadicado = siiProcesoSancionatorio.getPsaPruRadicado();
            this.psaResulFecha = siiProcesoSancionatorio.getPsaResulFecha();
            this.psaResulIndResp = siiProcesoSancionatorio.getPsaResulIndResp();
            this.psaResulNumGuia = siiProcesoSancionatorio.getPsaResulNumGuia();
            this.psaSnataFechaRad = siiProcesoSancionatorio.getPsaSnataFechaRad();
            this.psaSnataRadicado = siiProcesoSancionatorio.getPsaSnataRadicado();
            this.psaSnaupFechaRad = siiProcesoSancionatorio.getPsaSnaupFechaRad();
            this.psaSnaupRadicado = siiProcesoSancionatorio.getPsaSnaupRadicado();
            this.psaSnumaarFechaRad = siiProcesoSancionatorio.getPsaSnumaarFechaRad();
            this.psaSnumaarRadicado = siiProcesoSancionatorio.getPsaSnumaarRadicado_();
            this.psaConsecutivo = siiProcesoSancionatorio.getPsaConsecutivo();
            this.psaInterpRecurso = siiProcesoSancionatorio.getPsaInterpRecurso();
            this.psaInterpApelacion = siiProcesoSancionatorio.getPsaInterpApelacion();
            
            
            if (siiProcesoSancionatorio.getSiiResolucionProcSancSanc()!=null)
                this.resolucionProcSancSanc = new ResolucionProcSancVO(siiProcesoSancionatorio.getSiiResolucionProcSancSanc());
            
            if (siiProcesoSancionatorio.getSiiResolucionProcSancSin()!=null)
                this.resolucionProcSancSin = new ResolucionProcSancVO(siiProcesoSancionatorio.getSiiResolucionProcSancSin());
            
            if (siiProcesoSancionatorio.getSiiResolucionProcSancRepos()!=null)
                this.resolucionProcSancRepos = new ResolucionProcSancVO(siiProcesoSancionatorio.getSiiResolucionProcSancRepos());
            
            if (siiProcesoSancionatorio.getSiiResolucionProcSancApela()!=null)
                this.resolucionProcSancApela = new ResolucionProcSancVO(siiProcesoSancionatorio.getSiiResolucionProcSancApela());
            
            if (siiProcesoSancionatorio.getSiiEstadoProcesoSanc()!=null)
                this.estadoProcesoSancVo = new EstadoProcesoSancVO(siiProcesoSancionatorio.getSiiEstadoProcesoSanc());
            
            if (siiProcesoSancionatorio.getSiiContrato()!=null)
                this.contratoVo = new ContratoVO(siiProcesoSancionatorio.getSiiContrato());
            
            if (siiProcesoSancionatorio.getSiiArchivoFisicoAuto()!=null)
                this.archivoFisicoAuto = new ArchivoFisicoVO(siiProcesoSancionatorio.getSiiArchivoFisicoAuto());
            
            if (siiProcesoSancionatorio.getSiiInformeSupervision() != null) {
                this.informeSupervisionVo = new InformeSupervisionVO(siiProcesoSancionatorio.getSiiInformeSupervision());
            }
            
            if (siiProcesoSancionatorio.getSiiUsuarioRegistra()!=null) {
                this.usuarioRegistraVo = new UsuarioVO(siiProcesoSancionatorio.getSiiUsuarioRegistra());
            }
        }
    }


    public void setPsaAuprDecretaPr(String psaAuprDecretaPr) {
        this.psaAuprDecretaPr = psaAuprDecretaPr;
    }

    public String getPsaAuprDecretaPr() {
        return psaAuprDecretaPr;
    }

    public void setPsaAuprNumDias(Integer psaAuprNumDias) {
        this.psaAuprNumDias = psaAuprNumDias;
    }

    public Integer getPsaAuprNumDias() {
        return psaAuprNumDias;
    }

    public void setPsaBorTotales(BigDecimal psaBorTotales) {
        this.psaBorTotales = psaBorTotales;
    }

    public BigDecimal getPsaBorTotales() {
        return psaBorTotales;
    }

    public void setPsaCodigo(Long psaCodigo) {
        this.psaCodigo = psaCodigo;
    }

    public Long getPsaCodigo() {
        return psaCodigo;
    }

    public void setPsaComFechaRad(Date psaComFechaRad) {
        this.psaComFechaRad = psaComFechaRad;
    }

    public Date getPsaComFechaRad() {
        return psaComFechaRad;
    }

    public void setPsaComRadicado(String psaComRadicado) {
        this.psaComRadicado = psaComRadicado;
    }

    public String getPsaComRadicado() {
        return psaComRadicado;
    }

    public void setPsaFechaAutoArch(Date psaFechaAutoArch) {
        this.psaFechaAutoArch = psaFechaAutoArch;
    }

    public Date getPsaFechaAutoArch() {
        return psaFechaAutoArch;
    }

    public void setPsaFechaGenAuTrAl(Date psaFechaGenAuTrAl) {
        this.psaFechaGenAuTrAl = psaFechaGenAuTrAl;
    }

    public Date getPsaFechaGenAuTrAl() {
        return psaFechaGenAuTrAl;
    }

    public void setPsaMotivoInexac(String psaMotivoInexac) {
        this.psaMotivoInexac = psaMotivoInexac;
    }

    public String getPsaMotivoInexac() {
        return psaMotivoInexac;
    }

    public void setPsaMotivoOmision(String psaMotivoOmision) {
        this.psaMotivoOmision = psaMotivoOmision;
    }

    public String getPsaMotivoOmision() {
        return psaMotivoOmision;
    }

    public void setPsaNumFechaRad(Date psaNumFechaRad) {
        this.psaNumFechaRad = psaNumFechaRad;
    }

    public Date getPsaNumFechaRad() {
        return psaNumFechaRad;
    }

    public void setPsaNumRadicado(String psaNumRadicado) {
        this.psaNumRadicado = psaNumRadicado;
    }

    public String getPsaNumRadicado() {
        return psaNumRadicado;
    }

    public void setPsaPruDescripcion(String psaPruDescripcion) {
        this.psaPruDescripcion = psaPruDescripcion;
    }

    public String getPsaPruDescripcion() {
        return psaPruDescripcion;
    }

    public void setPsaPruFechaRad(Date psaPruFechaRad) {
        this.psaPruFechaRad = psaPruFechaRad;
    }

    public Date getPsaPruFechaRad() {
        return psaPruFechaRad;
    }

    public void setPsaPruRadicado(String psaPruRadicado) {
        this.psaPruRadicado = psaPruRadicado;
    }

    public String getPsaPruRadicado() {
        return psaPruRadicado;
    }
    
    public void setPsaResulFecha(Date psaResulFecha) {
        this.psaResulFecha = psaResulFecha;
    }

    public Date getPsaResulFecha() {
        return psaResulFecha;
    }

    public void setPsaResulIndResp(String psaResulIndResp) {
        this.psaResulIndResp = psaResulIndResp;
    }

    public String getPsaResulIndResp() {
        return psaResulIndResp;
    }

    public void setPsaResulNumGuia(String psaResulNumGuia) {
        this.psaResulNumGuia = psaResulNumGuia;
    }

    public String getPsaResulNumGuia() {
        return psaResulNumGuia;
    }

    public void setPsaSnataFechaRad(Date psaSnataFechaRad) {
        this.psaSnataFechaRad = psaSnataFechaRad;
    }

    public Date getPsaSnataFechaRad() {
        return psaSnataFechaRad;
    }

    public void setPsaSnataRadicado(String psaSnataRadicado) {
        this.psaSnataRadicado = psaSnataRadicado;
    }

    public String getPsaSnataRadicado() {
        return psaSnataRadicado;
    }

    public void setPsaSnaupFechaRad(Date psaSnaupFechaRad) {
        this.psaSnaupFechaRad = psaSnaupFechaRad;
    }

    public Date getPsaSnaupFechaRad() {
        return psaSnaupFechaRad;
    }

    public void setPsaSnaupRadicado(String psaSnaupRadicado) {
        this.psaSnaupRadicado = psaSnaupRadicado;
    }

    public String getPsaSnaupRadicado() {
        return psaSnaupRadicado;
    }

    public void setPsaSnumaarFechaRad(Date psaSnumaarFechaRad) {
        this.psaSnumaarFechaRad = psaSnumaarFechaRad;
    }

    public Date getPsaSnumaarFechaRad() {
        return psaSnumaarFechaRad;
    }

    public void setPsaSnumaarRadicado(String psaSnumaarRadicado) {
        this.psaSnumaarRadicado = psaSnumaarRadicado;
    }

    public String getPsaSnumaarRadicado() {
        return psaSnumaarRadicado;
    }

    public void setResolucionProcSancSanc(ResolucionProcSancVO resolucionProcSancSanc) {
        this.resolucionProcSancSanc = resolucionProcSancSanc;
    }

    public ResolucionProcSancVO getResolucionProcSancSanc() {
        return resolucionProcSancSanc;
    }

    public void setResolucionProcSancSin(ResolucionProcSancVO resolucionProcSancSin) {
        this.resolucionProcSancSin = resolucionProcSancSin;
    }

    public ResolucionProcSancVO getResolucionProcSancSin() {
        return resolucionProcSancSin;
    }

    public void setResolucionProcSancRepos(ResolucionProcSancVO resolucionProcSancRepos) {
        this.resolucionProcSancRepos = resolucionProcSancRepos;
    }

    public ResolucionProcSancVO getResolucionProcSancRepos() {
        return resolucionProcSancRepos;
    }

    public void setResolucionProcSancApela(ResolucionProcSancVO resolucionProcSancApela) {
        this.resolucionProcSancApela = resolucionProcSancApela;
    }

    public ResolucionProcSancVO getResolucionProcSancApela() {
        return resolucionProcSancApela;
    }

    public void setEstadoProcesoSancVo(EstadoProcesoSancVO estadoProcesoSancVo) {
        this.estadoProcesoSancVo = estadoProcesoSancVo;
    }

    public EstadoProcesoSancVO getEstadoProcesoSancVo() {
        return estadoProcesoSancVo;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }

    public void setArchivoFisicoAuto(ArchivoFisicoVO archivoFisicoAuto) {
        this.archivoFisicoAuto = archivoFisicoAuto;
    }

    public ArchivoFisicoVO getArchivoFisicoAuto() {
        return archivoFisicoAuto;
    }

    public void setDescargoProcSanList(List<DescargoProcSanVO> descargoProcSanList) {
        this.descargoProcSanList = descargoProcSanList;
    }

    public List<DescargoProcSanVO> getDescargoProcSanList() {
        return descargoProcSanList;
    }

    public void setCuotaInexacProcSancList(List<CuotaInexacProcSancVO> cuotaInexacProcSancList) {
        this.cuotaInexacProcSancList = cuotaInexacProcSancList;
    }

    public List<CuotaInexacProcSancVO> getCuotaInexacProcSancList() {
        return cuotaInexacProcSancList;
    }

    public void setInventarioProcSanList(List<InventarioProcSanVO> inventarioProcSanList) {
        this.inventarioProcSanList = inventarioProcSanList;
    }

    public List<InventarioProcSanVO> getInventarioProcSanList() {
        return inventarioProcSanList;
    }

    public void setCuotaOmisProcSancList(List<CuotaOmisProcSancVO> cuotaOmisProcSancList) {
        this.cuotaOmisProcSancList = cuotaOmisProcSancList;
    }

    public List<CuotaOmisProcSancVO> getCuotaOmisProcSancList() {
        return cuotaOmisProcSancList;
    }

    public void setRepartoFiscalizadorList(List<RepartoFiscalizadorVO> repartoFiscalizadorList) {
        this.repartoFiscalizadorList = repartoFiscalizadorList;
    }

    public List<RepartoFiscalizadorVO> getRepartoFiscalizadorList() {
        return repartoFiscalizadorList;
    }

    public void setInformeSupervisionVo(InformeSupervisionVO informeSupervisionVo) {
        this.informeSupervisionVo = informeSupervisionVo;
    }

    public InformeSupervisionVO getInformeSupervisionVo() {
        return informeSupervisionVo;
    }

    public void setPsaConsecutivo(Integer psaConsecutivo) {
        this.psaConsecutivo = psaConsecutivo;
    }

    public Integer getPsaConsecutivo() {
        return psaConsecutivo;
    }

    public void setPsaInterpRecurso(String psaInterpRecurso) {
        this.psaInterpRecurso = psaInterpRecurso;
    }

    public String getPsaInterpRecurso() {
        return psaInterpRecurso;
    }

    public void setPsaInterpApelacion(String psaInterpApelacion) {
        this.psaInterpApelacion = psaInterpApelacion;
    }

    public String getPsaInterpApelacion() {
        return psaInterpApelacion;
    }

    public void setUsuarioRegistraVo(UsuarioVO usuarioRegistraVo) {
        this.usuarioRegistraVo = usuarioRegistraVo;
    }

    public UsuarioVO getUsuarioRegistraVo() {
        return usuarioRegistraVo;
    }

    public void setInhabilidadPersonaList(List<InhabilidadPersonaVO> inhabilidadPersonaList) {
        this.inhabilidadPersonaList = inhabilidadPersonaList;
    }

    public List<InhabilidadPersonaVO> getInhabilidadPersonaList() {
        return inhabilidadPersonaList;
    }

    public void setRecepcionAlegatoProSanList(List<RecepcionAlegatoProSanVO> recepcionAlegatoProSanList) {
        this.recepcionAlegatoProSanList = recepcionAlegatoProSanList;
    }

    public List<RecepcionAlegatoProSanVO> getRecepcionAlegatoProSanList() {
        return recepcionAlegatoProSanList;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setDocumentoContableList(List<DocumentoContableVO> documentoContableList) {
        this.documentoContableList = documentoContableList;
    }

    public List<DocumentoContableVO> getDocumentoContableList() {
        return documentoContableList;
    }

    public void setCuotaOperadorList(List<CuotaOperadorVO> cuotaOperadorList) {
        this.cuotaOperadorList = cuotaOperadorList;
    }

    public List<CuotaOperadorVO> getCuotaOperadorList() {
        return cuotaOperadorList;
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
            inhabilidadPersonaVo.setProcesoSancionatorioVo(this);
        
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
                inhabilidadPersonaVo.setProcesoSancionatorioVo(null);
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Adiciona un registro al listado de DescargoProcSanVO.
     * @param descargoProcSanVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addDescargoProcSan (DescargoProcSanVO descargoProcSanVo) 
    {
        boolean exitoso = false;
        
        if (descargoProcSanList==null)
            descargoProcSanList = new ArrayList<DescargoProcSanVO>();
        
        exitoso = descargoProcSanList.add(descargoProcSanVo);
        
        if (exitoso)
            descargoProcSanVo.setProcesoSancionatorioVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado DescargoProcSanVO.
     * @param descargoProcSanVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeDescargoProcSan (DescargoProcSanVO descargoProcSanVo) {
        boolean exitoso = false;
        
        if (descargoProcSanList!=null) {
            exitoso = descargoProcSanList.remove(descargoProcSanVo);
            
            if (exitoso)
                descargoProcSanVo.setProcesoSancionatorioVo(null);
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Adiciona un registro al listado de InventarioProcSanVO.
     * @param inventarioProcSanVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addInventarioProcSan (InventarioProcSanVO inventarioProcSanVo) 
    {
        boolean exitoso = false;
        
        if (inventarioProcSanList==null)
            inventarioProcSanList = new ArrayList<InventarioProcSanVO>();
        
        exitoso = inventarioProcSanList.add(inventarioProcSanVo);
        
        if (exitoso)
            inventarioProcSanVo.setProcesoSancionatorioVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado InventarioProcSanVO.
     * @param inventarioProcSanVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeInventarioProcSan (InventarioProcSanVO inventarioProcSanVo) {
        boolean exitoso = false;
        
        if (inventarioProcSanList!=null) {
            exitoso = inventarioProcSanList.remove(inventarioProcSanVo);
            
            if (exitoso)
                inventarioProcSanVo.setProcesoSancionatorioVo(null);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Adiciona un registro al listado de RecepcionAlegatoProSanVO.
     * @param recepcionAlegatoProSanVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addRecepcionAlegatoProSan (RecepcionAlegatoProSanVO recepcionAlegatoProSanVo) 
    {
        boolean exitoso = false;
        
        if (recepcionAlegatoProSanList==null)
            recepcionAlegatoProSanList = new ArrayList<RecepcionAlegatoProSanVO>();
        
        exitoso = recepcionAlegatoProSanList.add(recepcionAlegatoProSanVo);
        
        if (exitoso)
            recepcionAlegatoProSanVo.setProcesoSancionatorioVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado RecepcionAlegatoProSanVO.
     * @param recepcionAlegatoProSanVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeRecepcionAlegatoProSan (RecepcionAlegatoProSanVO recepcionAlegatoProSanVo) {
        boolean exitoso = false;
        
        if (recepcionAlegatoProSanList!=null) {
            exitoso = recepcionAlegatoProSanList.remove(recepcionAlegatoProSanVo);
            
            if (exitoso)
                recepcionAlegatoProSanVo.setProcesoSancionatorioVo(null);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Adiciona un registro al listado de DocumentoContableVO.
     * @param documentoContableVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addDocumentoContable (DocumentoContableVO documentoContableVo) 
    {
        boolean exitoso = false;
        
        if (documentoContableList==null)
            documentoContableList = new ArrayList<DocumentoContableVO>();
        
        exitoso = documentoContableList.add(documentoContableVo);
        
        if (exitoso)
            documentoContableVo.setProcesoSancionatorioVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado DocumentoContableVO.
     * @param documentoContableVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeDocumentoContable (DocumentoContableVO documentoContableVo) {
        boolean exitoso = false;
        
        if (documentoContableList!=null) {
            exitoso = documentoContableList.remove(documentoContableVo);
            
            if (exitoso)
                documentoContableVo.setProcesoSancionatorioVo(null);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Adiciona un registro al listado de CuotaOperadorVO.
     * @param cuotaOperadorVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addCuotaOperador (CuotaOperadorVO cuotaOperadorVo) 
    {
        boolean exitoso = false;
        
        if (cuotaOperadorList==null)
            cuotaOperadorList = new ArrayList<CuotaOperadorVO>();
        
        exitoso = cuotaOperadorList.add(cuotaOperadorVo);
        
        if (exitoso)
            cuotaOperadorVo.setProcesoSancionatorioVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado CuotaOperadorVO.
     * @param cuotaOperadorVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeCuotaOperador (CuotaOperadorVO cuotaOperadorVo) {
        boolean exitoso = false;
        
        if (cuotaOperadorList!=null) {
            exitoso = cuotaOperadorList.remove(cuotaOperadorVo);
            
            if (exitoso)
                cuotaOperadorVo.setProcesoSancionatorioVo(null);
        }
        
        return (exitoso);
    }
}
