/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Camilo Miranda
 * FECHA	: 18-02-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;


/**
 * Value Object que contiene la informaci&oacute;n detallada de las Modificaciones Presupuestales por Rubros para reportes.
 * @author Camilo Miranda
 */
public class ModPresDetRubroResultVO {
    
    ///////////////////////////////////////////
    // Datos de la Modificacion Presupuestal //
    ///////////////////////////////////////////
    private Long mpdCodigo;
    private Long creditos;
    private Long contracreditos;
    private ModPresDetRubroVO modPresDetRubroVo;
    
    
    ///////////////////////////
    // INFORMACION DEL RUBRO //
    ///////////////////////////
    private String rubro;
    private String descRubro;
    private Long druCodigo;
    private String ffcCodigo;
    private String ffcNombre;
    private Integer ffiCodigoFuente;
    private String ffiDescripcion;
    private Integer dffCodigoRecurso;
    private String dffDescripcion;
    
    private InfoDetalladaRubroVO infoDetalladaRubro;
    
    
    
    
    /**
     * Constructor.
     */
    public ModPresDetRubroResultVO() 
    { 
        this.creditos = 0L;
        this.contracreditos = 0L;
    }
    
    
    /**
     * Constructor.
     * @param modPresDetRubroVo - Modificaci&oacute;n Presupuestal Detalle Rubro correspondiente.
     * @param origen - Informaci&oacute;n detallada del Rubro Origen.
     * @param destino - Informaci&oacute;n detallada del Rubro Destino.
     */
    public ModPresDetRubroResultVO (ModPresDetRubroVO modPresDetRubroVo, InfoDetalladaRubroVO origen, InfoDetalladaRubroVO destino) 
    {
        this.creditos = 0L;
        this.contracreditos = 0L;
        
        
        this.modPresDetRubroVo = modPresDetRubroVo;
        
        if (modPresDetRubroVo!=null) {
            this.mpdCodigo = modPresDetRubroVo.getMpdCodigo();
        }
        
        if (origen!=null) {
            this.rubro = origen.getRubro();
            this.descRubro = origen.getDescRubro();
            this.druCodigo = origen.getDruCodigo();
            this.ffcCodigo = origen.getFfcCodigo();
            this.ffcNombre = origen.getFccNombre();
            this.ffiCodigoFuente = origen.getFfiCodigoFuente();
            this.ffiDescripcion = origen.getFfiDescripcion();
            this.dffCodigoRecurso = origen.getDffCodigoRecurso();
            this.dffDescripcion = origen.getDffDescripcion();
            
            this.contracreditos = modPresDetRubroVo.getMpdValor();
            this.infoDetalladaRubro = origen;
        }
        
        else if (destino!=null) {
            this.rubro = destino.getRubro();
            this.descRubro = destino.getDescRubro();
            this.druCodigo = destino.getDruCodigo();
            this.ffcCodigo = destino.getFfcCodigo();
            this.ffcNombre = destino.getFccNombre();
            this.ffiCodigoFuente = destino.getFfiCodigoFuente();
            this.ffiDescripcion = destino.getFfiDescripcion();
            this.dffCodigoRecurso = destino.getDffCodigoRecurso();
            this.dffDescripcion = destino.getDffDescripcion();
            
            this.creditos = modPresDetRubroVo.getMpdValor();
            this.infoDetalladaRubro = destino;
        }
    }

    
    
    public void setMpdCodigo(Long mpdCodigo) {
        this.mpdCodigo = mpdCodigo;
    }

    public Long getMpdCodigo() {
        return mpdCodigo;
    }

    public void setCreditos(Long creditos) {
        this.creditos = creditos;
    }

    public Long getCreditos() {
        return creditos;
    }

    public void setContracreditos(Long contracreditos) {
        this.contracreditos = contracreditos;
    }

    public Long getContracreditos() {
        return contracreditos;
    }

    public void setModPresDetRubroVo(ModPresDetRubroVO modPresDetRubroVo) {
        this.modPresDetRubroVo = modPresDetRubroVo;
    }

    public ModPresDetRubroVO getModPresDetRubroVo() {
        return modPresDetRubroVo;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setDescRubro(String descRubro) {
        this.descRubro = descRubro;
    }

    public String getDescRubro() {
        return descRubro;
    }

    public void setDruCodigo(Long druCodigo) {
        this.druCodigo = druCodigo;
    }

    public Long getDruCodigo() {
        return druCodigo;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setFfcNombre(String ffcNombre) {
        this.ffcNombre = ffcNombre;
    }

    public String getFfcNombre() {
        return ffcNombre;
    }

    public void setFfiCodigoFuente(Integer ffiCodigoFuente) {
        this.ffiCodigoFuente = ffiCodigoFuente;
    }

    public Integer getFfiCodigoFuente() {
        return ffiCodigoFuente;
    }

    public void setFfiDescripcion(String ffiDescripcion) {
        this.ffiDescripcion = ffiDescripcion;
    }

    public String getFfiDescripcion() {
        return ffiDescripcion;
    }

    public void setDffCodigoRecurso(Integer dffCodigoRecurso) {
        this.dffCodigoRecurso = dffCodigoRecurso;
    }

    public Integer getDffCodigoRecurso() {
        return dffCodigoRecurso;
    }

    public void setDffDescripcion(String dffDescripcion) {
        this.dffDescripcion = dffDescripcion;
    }

    public String getDffDescripcion() {
        return dffDescripcion;
    }

    public void setInfoDetalladaRubro(InfoDetalladaRubroVO infoDetalladaRubro) {
        this.infoDetalladaRubro = infoDetalladaRubro;
    }

    public InfoDetalladaRubroVO getInfoDetalladaRubro() {
        return infoDetalladaRubro;
    }
}
