package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiIncumplimientoContr;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class IncumplimientoContrVO {
    private Long icnCodigo;
    private Integer icnConsecutivo;
    private Date icnFechaAutoArchivo;
    private Date icnFechaCancelacion;
    private Date icnFechaCitaAud;
    private Date icnFechaComAse;
    private Date icnFechaComOpe;
    private Date icnFechaConstEjecut;
    private Date icnFechaRadCitAse;
    private Date icnFechaRadCitOpe;
    private Date icnFechaReanudAud;
    private Date icnFechaSuperaInc;
    private Date icnFechaSuspension;
    private String icnFormaComunicaAse;
    private String icnFormaComunicaOpe;
    private String icnMotivoCancelac;
    private String icnMotivoSuspen;
    private String icnNumAutoArchivo;
    private String icnNumGuiaAse;
    private String icnNumGuiaOpe;
    private String icnObservacionesSus;
    private String icnObservacCancela;
    private String icnRadicaCitaAse;
    private String icnRadicaCitaOpe;
    private Integer icnDiasIncumplim;
    private BigDecimal icnValorClausulaP;
    private BigDecimal icnValorMulta;
    private Integer icnCantidadElem;
    private String icnSuperoInc;
    private String icnRepLegPrimApeCitAud;
    private String icnRepLegPrimNomCitAud;
    private String icnRepLegSegApeCitAud;
    private String icnRepLegSegNomCitAud;
    
    private EstadoIncumplContractVO estadoIncumplContractVo;
    private ArchivoFisicoVO archivoFisicoOperVo;
    private InformeSupervisionVO informeSupervisionVo;
    private ResolucionIncumContrVO resolucionIncumContrResolVo;
    private ArchivoFisicoVO archivoFisicoAutoVo;
    private ResolucionIncumContrVO resolucionIncumContrRecursoVo;
    private ArchivoFisicoVO archivoFisicoAsegVo;
    private UsuarioVO usuarioRegistraVo;
    
    private List<RepartoFiscalizadorVO> repartoFiscalizadorListVo;
    private List<DireccionProcesalIncVO> direccionProcesalIncListVo;
    private List<CuotaOperadorVO> cuotaOperadorListVo;
    private List<DocumentoContableVO> documentoContableListVo;
    private List<ActaSuspenAudIncumConVO> actaSuspenAudIncumConListVo;
    private List<InhabilidadPersonaVO> inhabilidadPersonaListVo;
    
    
    // Manejo de cambios de estado
    /** Estado anterior del Proceso de Incumplimiento Contractual (estadoIncumplContractVo.eicCodigo). */
    private Long idEstadoAnterior;
    
    
    
    /**
     * Constructor.
     */
    public IncumplimientoContrVO(){ }
    
    
    
    public IncumplimientoContrVO(SiiIncumplimientoContr siiIncumplimientoContr){
        if (siiIncumplimientoContr!=null) {
            this.icnCodigo=siiIncumplimientoContr.getIcnCodigo();
            this.icnConsecutivo=siiIncumplimientoContr.getIcnConsecutivo();
            this.icnFechaAutoArchivo=siiIncumplimientoContr.getIcnFechaAutoArchivo();
            this.icnFechaCancelacion=siiIncumplimientoContr.getIcnFechaCancelacion();
            this.icnFechaCitaAud=siiIncumplimientoContr.getIcnFechaCitaAud();
            this.icnFechaComAse=siiIncumplimientoContr.getIcnFechaComAse();
            this.icnFechaComOpe=siiIncumplimientoContr.getIcnFechaComOpe();
            this.icnFechaConstEjecut=siiIncumplimientoContr.getIcnFechaConstEjecut();
            this.icnFechaRadCitAse=siiIncumplimientoContr.getIcnFechaRadCitAse();
            this.icnFechaRadCitOpe=siiIncumplimientoContr.getIcnFechaRadCitOpe();
            this.icnFechaReanudAud=siiIncumplimientoContr.getIcnFechaReanudAud();
            this.icnFechaSuperaInc=siiIncumplimientoContr.getIcnFechaSuperaInc();
            this.icnFechaSuspension=siiIncumplimientoContr.getIcnFechaSuspension();
            this.icnFormaComunicaAse=siiIncumplimientoContr.getIcnFormaComunicaAse();
            this.icnFormaComunicaOpe=siiIncumplimientoContr.getIcnFormaComunicaOpe();
            this.icnMotivoCancelac=siiIncumplimientoContr.getIcnMotivoCancelac();
            this.icnMotivoSuspen=siiIncumplimientoContr.getIcnMotivoSuspen();
            this.icnNumAutoArchivo=siiIncumplimientoContr.getIcnNumAutoArchivo();
            this.icnNumGuiaAse=siiIncumplimientoContr.getIcnNumGuiaAse();
            this.icnNumGuiaOpe=siiIncumplimientoContr.getIcnNumGuiaOpe();
            this.icnObservacCancela=siiIncumplimientoContr.getIcnObservacCancela();
            this.icnObservacionesSus=siiIncumplimientoContr.getIcnObservacionesSus();
            this.icnRadicaCitaAse=siiIncumplimientoContr.getIcnRadicaCitaAse();
            this.icnRadicaCitaOpe=siiIncumplimientoContr.getIcnRadicaCitaOpe();
            this.icnDiasIncumplim = siiIncumplimientoContr.getIcnDiasIncumplim();
            this.icnValorClausulaP = siiIncumplimientoContr.getIcnValorClausulaP();
            this.icnValorMulta = siiIncumplimientoContr.getIcnValorMulta();
            this.icnCantidadElem = siiIncumplimientoContr.getIcnCantidadElem();
            this.icnSuperoInc = siiIncumplimientoContr.getIcnSuperoInc();
            this.icnRepLegPrimApeCitAud = siiIncumplimientoContr.getIcnRepLegPrimApeCitAud();
            this.icnRepLegPrimNomCitAud = siiIncumplimientoContr.getIcnRepLegPrimNomCitAud();
            this.icnRepLegSegApeCitAud = siiIncumplimientoContr.getIcnRepLegSegApeCitAud();
            this.icnRepLegSegNomCitAud = siiIncumplimientoContr.getIcnRepLegSegNomCitAud();
            
            
            //Padres
            if (siiIncumplimientoContr.getSiiArchivoFisicoAseg() != null) {
                this.archivoFisicoAsegVo = new ArchivoFisicoVO(siiIncumplimientoContr.getSiiArchivoFisicoAseg());
            }
            if (siiIncumplimientoContr.getSiiArchivoFisicoAuto() != null) {
                this.archivoFisicoAutoVo = new ArchivoFisicoVO(siiIncumplimientoContr.getSiiArchivoFisicoAuto());
            }
            if (siiIncumplimientoContr.getSiiArchivoFisicoOper() != null) {
                this.archivoFisicoOperVo = new ArchivoFisicoVO(siiIncumplimientoContr.getSiiArchivoFisicoOper());
            }
            if (siiIncumplimientoContr.getSiiInformeSupervision()!= null) {
                this.informeSupervisionVo = new InformeSupervisionVO(siiIncumplimientoContr.getSiiInformeSupervision());
            }
            if (siiIncumplimientoContr.getSiiEstadoIncumplContract() != null) {
                this.estadoIncumplContractVo = new EstadoIncumplContractVO(siiIncumplimientoContr.getSiiEstadoIncumplContract());
            }
            if (siiIncumplimientoContr.getSiiResolucionIncumContrRecurso()!=null) {
                this.resolucionIncumContrRecursoVo = new ResolucionIncumContrVO(siiIncumplimientoContr.getSiiResolucionIncumContrRecurso());
            }
            if (siiIncumplimientoContr.getSiiResolucionIncumContrResol()!=null) {
                this.resolucionIncumContrResolVo = new ResolucionIncumContrVO(siiIncumplimientoContr.getSiiResolucionIncumContrResol());
            }
            if (siiIncumplimientoContr.getSiiUsuarioRegistra()!=null) {
                this.usuarioRegistraVo = new UsuarioVO(siiIncumplimientoContr.getSiiUsuarioRegistra());
            }
        }
    }
    

    public void setIcnCodigo(Long icnCodigo) {
        this.icnCodigo = icnCodigo;
    }

    public Long getIcnCodigo() {
        return icnCodigo;
    }

    public void setIcnConsecutivo(Integer icnConsecutivo) {
        this.icnConsecutivo = icnConsecutivo;
    }

    public Integer getIcnConsecutivo() {
        return icnConsecutivo;
    }

    public void setIcnFechaAutoArchivo(Date icnFechaAutoArchivo) {
        this.icnFechaAutoArchivo = icnFechaAutoArchivo;
    }

    public Date getIcnFechaAutoArchivo() {
        return icnFechaAutoArchivo;
    }

    public void setIcnFechaCancelacion(Date icnFechaCancelacion) {
        this.icnFechaCancelacion = icnFechaCancelacion;
    }

    public Date getIcnFechaCancelacion() {
        return icnFechaCancelacion;
    }

    public void setIcnFechaCitaAud(Date icnFechaCitaAud) {
        this.icnFechaCitaAud = icnFechaCitaAud;
    }

    public Date getIcnFechaCitaAud() {
        return icnFechaCitaAud;
    }

    public void setIcnFechaComAse(Date icnFechaComAse) {
        this.icnFechaComAse = icnFechaComAse;
    }

    public Date getIcnFechaComAse() {
        return icnFechaComAse;
    }

    public void setIcnFechaComOpe(Date icnFechaComOpe) {
        this.icnFechaComOpe = icnFechaComOpe;
    }

    public Date getIcnFechaComOpe() {
        return icnFechaComOpe;
    }

    public void setIcnFechaConstEjecut(Date icnFechaConstEjecut) {
        this.icnFechaConstEjecut = icnFechaConstEjecut;
    }

    public Date getIcnFechaConstEjecut() {
        return icnFechaConstEjecut;
    }

    public void setIcnFechaRadCitAse(Date icnFechaRadCitAse) {
        this.icnFechaRadCitAse = icnFechaRadCitAse;
    }

    public Date getIcnFechaRadCitAse() {
        return icnFechaRadCitAse;
    }

    public void setIcnFechaRadCitOpe(Date icnFechaRadCitOpe) {
        this.icnFechaRadCitOpe = icnFechaRadCitOpe;
    }

    public Date getIcnFechaRadCitOpe() {
        return icnFechaRadCitOpe;
    }

    public void setIcnFechaReanudAud(Date icnFechaReanudAud) {
        this.icnFechaReanudAud = icnFechaReanudAud;
    }

    public Date getIcnFechaReanudAud() {
        return icnFechaReanudAud;
    }

    public void setIcnFechaSuperaInc(Date icnFechaSuperaInc) {
        this.icnFechaSuperaInc = icnFechaSuperaInc;
    }

    public Date getIcnFechaSuperaInc() {
        return icnFechaSuperaInc;
    }

    public void setIcnFechaSuspension(Date icnFechaSuspension) {
        this.icnFechaSuspension = icnFechaSuspension;
    }

    public Date getIcnFechaSuspension() {
        return icnFechaSuspension;
    }

    public void setIcnFormaComunicaAse(String icnFormaComunicaAse) {
        this.icnFormaComunicaAse = icnFormaComunicaAse;
    }

    public String getIcnFormaComunicaAse() {
        return icnFormaComunicaAse;
    }

    public void setIcnFormaComunicaOpe(String icnFormaComunicaOpe) {
        this.icnFormaComunicaOpe = icnFormaComunicaOpe;
    }

    public String getIcnFormaComunicaOpe() {
        return icnFormaComunicaOpe;
    }

    public void setIcnMotivoCancelac(String icnMotivoCancelac) {
        this.icnMotivoCancelac = icnMotivoCancelac;
    }

    public String getIcnMotivoCancelac() {
        return icnMotivoCancelac;
    }

    public void setIcnMotivoSuspen(String icnMotivoSuspen) {
        this.icnMotivoSuspen = icnMotivoSuspen;
    }

    public String getIcnMotivoSuspen() {
        return icnMotivoSuspen;
    }

    public void setIcnNumAutoArchivo(String icnNumAutoArchivo) {
        this.icnNumAutoArchivo = icnNumAutoArchivo;
    }

    public String getIcnNumAutoArchivo() {
        return icnNumAutoArchivo;
    }

    public void setIcnNumGuiaAse(String icnNumGuiaAse) {
        this.icnNumGuiaAse = icnNumGuiaAse;
    }

    public String getIcnNumGuiaAse() {
        return icnNumGuiaAse;
    }

    public void setIcnNumGuiaOpe(String icnNumGuiaOpe) {
        this.icnNumGuiaOpe = icnNumGuiaOpe;
    }

    public String getIcnNumGuiaOpe() {
        return icnNumGuiaOpe;
    }

    public void setIcnObservacionesSus(String icnObservacionesSus) {
        this.icnObservacionesSus = icnObservacionesSus;
    }

    public String getIcnObservacionesSus() {
        return icnObservacionesSus;
    }

    public void setIcnObservacCancela(String icnObservacCancela) {
        this.icnObservacCancela = icnObservacCancela;
    }

    public String getIcnObservacCancela() {
        return icnObservacCancela;
    }

    public void setIcnRadicaCitaAse(String icnRadicaCitaAse) {
        this.icnRadicaCitaAse = icnRadicaCitaAse;
    }

    public String getIcnRadicaCitaAse() {
        return icnRadicaCitaAse;
    }

    public void setIcnRadicaCitaOpe(String icnRadicaCitaOpe) {
        this.icnRadicaCitaOpe = icnRadicaCitaOpe;
    }

    public String getIcnRadicaCitaOpe() {
        return icnRadicaCitaOpe;
    }

    public void setEstadoIncumplContractVo(EstadoIncumplContractVO estadoIncumplContractVo) {
        this.estadoIncumplContractVo = estadoIncumplContractVo;
    }

    public EstadoIncumplContractVO getEstadoIncumplContractVo() {
        return estadoIncumplContractVo;
    }

    public void setArchivoFisicoOperVo(ArchivoFisicoVO archivoFisicoOperVo) {
        this.archivoFisicoOperVo = archivoFisicoOperVo;
    }

    public ArchivoFisicoVO getArchivoFisicoOperVo() {
        return archivoFisicoOperVo;
    }

    public void setInformeSupervisionVo(InformeSupervisionVO informeSupervisionVo) {
        this.informeSupervisionVo = informeSupervisionVo;
    }

    public InformeSupervisionVO getInformeSupervisionVo() {
        return informeSupervisionVo;
    }

    public void setResolucionIncumContrResolVo(ResolucionIncumContrVO resolucionIncumContrResolVo) {
        this.resolucionIncumContrResolVo = resolucionIncumContrResolVo;
    }

    public ResolucionIncumContrVO getResolucionIncumContrResolVo() {
        return resolucionIncumContrResolVo;
    }

    public void setArchivoFisicoAutoVo(ArchivoFisicoVO archivoFisicoAutoVo) {
        this.archivoFisicoAutoVo = archivoFisicoAutoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoAutoVo() {
        return archivoFisicoAutoVo;
    }

    public void setResolucionIncumContrRecursoVo(ResolucionIncumContrVO resolucionIncumContrRecursoVo) {
        this.resolucionIncumContrRecursoVo = resolucionIncumContrRecursoVo;
    }

    public ResolucionIncumContrVO getResolucionIncumContrRecursoVo() {
        return resolucionIncumContrRecursoVo;
    }

    public void setArchivoFisicoAsegVo(ArchivoFisicoVO archivoFisicoAsegVo) {
        this.archivoFisicoAsegVo = archivoFisicoAsegVo;
    }

    public ArchivoFisicoVO getArchivoFisicoAsegVo() {
        return archivoFisicoAsegVo;
    }

    public void setRepartoFiscalizadorListVo(List<RepartoFiscalizadorVO> repartoFiscalizadorListVo) {
        this.repartoFiscalizadorListVo = repartoFiscalizadorListVo;
    }

    public List<RepartoFiscalizadorVO> getRepartoFiscalizadorListVo() {
        return repartoFiscalizadorListVo;
    }

    public void setDireccionProcesalIncListVo(List<DireccionProcesalIncVO> direccionProcesalIncListVo) {
        this.direccionProcesalIncListVo = direccionProcesalIncListVo;
    }

    public List<DireccionProcesalIncVO> getDireccionProcesalIncListVo() {
        return direccionProcesalIncListVo;
    }

    public void setIcnDiasIncumplim(Integer icnDiasIncumplim) {
        this.icnDiasIncumplim = icnDiasIncumplim;
    }

    public Integer getIcnDiasIncumplim() {
        return icnDiasIncumplim;
    }

    public void setIcnValorClausulaP(BigDecimal icnValorClausulaP) {
        this.icnValorClausulaP = icnValorClausulaP;
    }

    public BigDecimal getIcnValorClausulaP() {
        return icnValorClausulaP;
    }

    public void setIcnValorMulta(BigDecimal icnValorMulta) {
        this.icnValorMulta = icnValorMulta;
    }

    public BigDecimal getIcnValorMulta() {
        return icnValorMulta;
    }

    public void setIcnCantidadElem(Integer icnCantidadElem) {
        this.icnCantidadElem = icnCantidadElem;
    }

    public Integer getIcnCantidadElem() {
        return icnCantidadElem;
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

    public void setIcnSuperoInc(String icnSuperoInc) {
        this.icnSuperoInc = icnSuperoInc;
    }

    public String getIcnSuperoInc() {
        return icnSuperoInc;
    }

    public void setUsuarioRegistraVo(UsuarioVO usuarioRegistraVo) {
        this.usuarioRegistraVo = usuarioRegistraVo;
    }

    public UsuarioVO getUsuarioRegistraVo() {
        return usuarioRegistraVo;
    }

    public void setActaSuspenAudIncumConListVo(List<ActaSuspenAudIncumConVO> actaSuspenAudIncumConListVo) {
        this.actaSuspenAudIncumConListVo = actaSuspenAudIncumConListVo;
    }

    public List<ActaSuspenAudIncumConVO> getActaSuspenAudIncumConListVo() {
        return actaSuspenAudIncumConListVo;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setInhabilidadPersonaListVo(List<InhabilidadPersonaVO> inhabilidadPersonaListVo) {
        this.inhabilidadPersonaListVo = inhabilidadPersonaListVo;
    }

    public List<InhabilidadPersonaVO> getInhabilidadPersonaListVo() {
        return inhabilidadPersonaListVo;
    }

    public void setIcnRepLegPrimApeCitAud(String icnRepLegPrimApeCitAud) {
        this.icnRepLegPrimApeCitAud = icnRepLegPrimApeCitAud;
    }

    public String getIcnRepLegPrimApeCitAud() {
        return icnRepLegPrimApeCitAud;
    }

    public void setIcnRepLegPrimNomCitAud(String icnRepLegPrimNomCitAud) {
        this.icnRepLegPrimNomCitAud = icnRepLegPrimNomCitAud;
    }

    public String getIcnRepLegPrimNomCitAud() {
        return icnRepLegPrimNomCitAud;
    }

    public void setIcnRepLegSegApeCitAud(String icnRepLegSegApeCitAud) {
        this.icnRepLegSegApeCitAud = icnRepLegSegApeCitAud;
    }

    public String getIcnRepLegSegApeCitAud() {
        return icnRepLegSegApeCitAud;
    }

    public void setIcnRepLegSegNomCitAud(String icnRepLegSegNomCitAud) {
        this.icnRepLegSegNomCitAud = icnRepLegSegNomCitAud;
    }

    public String getIcnRepLegSegNomCitAud() {
        return icnRepLegSegNomCitAud;
    }
    
    


    /**
     * Adiciona un registro al listado de DocumentoContableVO.
     * @param documentoContableVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addDocumentoContable (DocumentoContableVO documentoContableVo) 
    {
        boolean exitoso = false;
        
        if (documentoContableListVo==null)
            documentoContableListVo = new ArrayList<DocumentoContableVO>();
        
        exitoso = documentoContableListVo.add(documentoContableVo);
        
        if (exitoso)
            documentoContableVo.setIncumplimientoContrVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado DocumentoContableVO.
     * @param documentoContableVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeDocumentoContable (DocumentoContableVO documentoContableVo) {
        boolean exitoso = false;
        
        if (documentoContableListVo!=null) {
            exitoso = documentoContableListVo.remove(documentoContableVo);
            
            if (exitoso)
                documentoContableVo.setIncumplimientoContrVo(null);
        }
        
        return (exitoso);
    }
    
    
    


    /**
     * Adiciona un registro al listado de DireccionProcesalIncVO.
     * @param direccionProcesalIncVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addDireccionProcesalInc (DireccionProcesalIncVO direccionProcesalIncVo) 
    {
        boolean exitoso = false;
        
        if (direccionProcesalIncListVo==null)
            direccionProcesalIncListVo = new ArrayList<DireccionProcesalIncVO>();
        
        exitoso = direccionProcesalIncListVo.add(direccionProcesalIncVo);
        
        if (exitoso)
            direccionProcesalIncVo.setIncumplimientoContrVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado DireccionProcesalIncVO.
     * @param direccionProcesalIncVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeDireccionProcesalInc (DireccionProcesalIncVO direccionProcesalIncVo) {
        boolean exitoso = false;
        
        if (direccionProcesalIncListVo!=null) {
            exitoso = direccionProcesalIncListVo.remove(direccionProcesalIncVo);
            
            if (exitoso)
                direccionProcesalIncVo.setIncumplimientoContrVo(null);
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
        
        if (cuotaOperadorListVo==null)
            cuotaOperadorListVo = new ArrayList<CuotaOperadorVO>();
        
        exitoso = cuotaOperadorListVo.add(cuotaOperadorVo);
        
        if (exitoso)
            cuotaOperadorVo.setIncumplimientoContrVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado de CuotaOperadorVO.
     * @param cuotaOperadorVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeCuotaOperador (CuotaOperadorVO cuotaOperadorVo) {
        boolean exitoso = false;
        
        if (cuotaOperadorListVo!=null) {
            exitoso = cuotaOperadorListVo.remove(cuotaOperadorVo);
            
            if (exitoso)
                cuotaOperadorVo.setIncumplimientoContrVo(null);
        }
        
        return (exitoso);
    }
    
    
    
    /**
     * Adiciona un registro al listado de Acta de Suspensi&oacute;n de la Audiencia.
     * @param actaSuspenAudIncumConVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addActaSuspenAudIncumCon (ActaSuspenAudIncumConVO actaSuspenAudIncumConVo) 
    {
        boolean exitoso = false;
        
        if (actaSuspenAudIncumConListVo==null)
            actaSuspenAudIncumConListVo = new ArrayList<ActaSuspenAudIncumConVO>();
        
        exitoso = actaSuspenAudIncumConListVo.add(actaSuspenAudIncumConVo);
        
        if (exitoso)
            actaSuspenAudIncumConVo.setIncumplimientoContrVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado de Acta de Suspensi&oacute;n de la Audiencia.
     * @param actaSuspenAudIncumConVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeActaSuspenAudIncumCon (ActaSuspenAudIncumConVO actaSuspenAudIncumConVo) {
        boolean exitoso = false;
        
        if (actaSuspenAudIncumConListVo!=null) {
            exitoso = actaSuspenAudIncumConListVo.remove(actaSuspenAudIncumConVo);
            
            if (exitoso)
                actaSuspenAudIncumConVo.setIncumplimientoContrVo(null);
        }
        
        return (exitoso);
    }
    
    
    /**
     * Adiciona un registro al listado de InhabilidadPersonaVO.
     * @param inhabilidadPersonaVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addInhabilidadPersona (InhabilidadPersonaVO inhabilidadPersonaVo) 
    {
        boolean exitoso = false;
        
        if (inhabilidadPersonaListVo==null)
            inhabilidadPersonaListVo = new ArrayList<InhabilidadPersonaVO>();
        
        exitoso = inhabilidadPersonaListVo.add(inhabilidadPersonaVo);
        
        if (exitoso)
            inhabilidadPersonaVo.setIncumplimientoContrVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado InhabilidadPersonaVO.
     * @param inhabilidadPersonaVo - Objeto a eliminar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeInhabilidadPersona (InhabilidadPersonaVO inhabilidadPersonaVo) {
        boolean exitoso = false;
        
        if (inhabilidadPersonaListVo!=null) {
            exitoso = inhabilidadPersonaListVo.remove(inhabilidadPersonaVo);
            
            if (exitoso)
                inhabilidadPersonaVo.setIncumplimientoContrVo(null);
        }
        
        return (exitoso);
    }
    
    
    

    /**
     * Obtiene el nombre del Estado del Proceso de Incumplimiento Contractual.
     * @return estadoIncumplContractVo.eicNombre
     */
    public String getEstado () {
        return ( this.estadoIncumplContractVo!=null ? this.estadoIncumplContractVo.getEicNombre() : null );
    }
    
    
    /**
     * Obtiene el Contrato asociado al Informe de Supervisi&oacute;n.
     * @return informeSupervisionVo->contratoVo
     */
    public ContratoVO getContratoVo () 
    {
        return ( this.informeSupervisionVo!=null ? this.informeSupervisionVo.getContratoVo() : null );
    }
    
    
    /**
     * Obtiene el Operador asociado al Contrato del Informe de Supervisi&oacute;n.
     * @return informeSupervisionVo->contratoVo->operadorVo
     */
    public OperadorVO getOperadorVo () {
        return ( this.getContratoVo()!=null ? this.getContratoVo().getOperadorVo() : null );
    }
}
