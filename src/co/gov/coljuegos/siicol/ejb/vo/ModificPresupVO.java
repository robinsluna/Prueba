package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPresup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para la Modificaci&oacute;n Presupuestal.
 */
public class ModificPresupVO {
    private Long mprCodigo;
    private Date mprFecha;
    private String mprTipo;
    private Integer mprVigencia;
    private Date mprFechaAcuerdoJunta;
    private Date mprFechaDecreto;
    private Date mprFechaOficioDesagregacion;
    private String mprNumeroAcuerdoJunta;
    private String mprNumeroDecreto;
    private String mprNumOficioDesagregacion;
    private Long mprConsecutivo;
    private Long idEstadoAnterior;
    private EstadoModifPresupVO estadoModifPresupVo;
    private List<ModPresDetRubroVO> modPresDetRubroListVo;
    
    
    /**
     * Constructor.
     */
    public ModificPresupVO() { }
    
    
    /**
     * Constructor.
     * @param siiModificPresup
     */
    public ModificPresupVO(SiiModificPresup siiModificPresup){
        if (siiModificPresup!=null) {
            this.mprCodigo = siiModificPresup.getMprCodigo();
            this.mprFecha = siiModificPresup.getMprFecha();
            this.mprTipo = siiModificPresup.getMprTipo();
            this.mprVigencia = siiModificPresup.getMprVigencia();
            this.mprFechaAcuerdoJunta = siiModificPresup.getMprFechaAcuerdoJunta();
            this.mprFechaDecreto = siiModificPresup.getMprFechaDecreto();
            this.mprFechaOficioDesagregacion = siiModificPresup.getMprFechaOficioDesagregacion();
            this.mprNumeroAcuerdoJunta = siiModificPresup.getMprNumeroAcuerdoJunta();
            this.mprNumeroDecreto = siiModificPresup.getMprNumeroDecreto();
            this.mprNumOficioDesagregacion = siiModificPresup.getMprNumOficioDesagregacion();
            this.mprConsecutivo = siiModificPresup.getMprConsecutivo();
            
            //Estado
            if (siiModificPresup.getSiiEstadoModifPresup()!=null) {
                this.estadoModifPresupVo = new EstadoModifPresupVO(siiModificPresup.getSiiEstadoModifPresup());
                this.idEstadoAnterior = siiModificPresup.getSiiEstadoModifPresup().getEmpCodigo();
            }
        }
    }
    
    
    public void setMprCodigo(Long mprCodigo) {
        this.mprCodigo = mprCodigo;
    }

    public Long getMprCodigo() {
        return mprCodigo;
    }

    public void setMprFecha(Date mprFecha) {
        this.mprFecha = mprFecha;
    }

    public Date getMprFecha() {
        return mprFecha;
    }

    public void setMprTipo(String mprTipo) {
        this.mprTipo = mprTipo;
    }

    public String getMprTipo() {
        return mprTipo;
    }

    public void setMprVigencia(Integer mprVigencia) {
        this.mprVigencia = mprVigencia;
    }

    public Integer getMprVigencia() {
        return mprVigencia;
    }

    public void setEstadoModifPresupVo(EstadoModifPresupVO estadoModifPresupVo) {
        this.estadoModifPresupVo = estadoModifPresupVo;
    }

    public EstadoModifPresupVO getEstadoModifPresupVo() {
        return estadoModifPresupVo;
    }

    public void setModPresDetRubroListVo(List<ModPresDetRubroVO> modPresDetRubroListVo) {
        this.modPresDetRubroListVo = modPresDetRubroListVo;
    }

    public List<ModPresDetRubroVO> getModPresDetRubroListVo() {
        return modPresDetRubroListVo;
    }

    public void setMprFechaAcuerdoJunta(Date mprFechaAcuerdoJunta) {
        this.mprFechaAcuerdoJunta = mprFechaAcuerdoJunta;
    }

    public Date getMprFechaAcuerdoJunta() {
        return mprFechaAcuerdoJunta;
    }

    public void setMprFechaDecreto(Date mprFechaDecreto) {
        this.mprFechaDecreto = mprFechaDecreto;
    }

    public Date getMprFechaDecreto() {
        return mprFechaDecreto;
    }

    public void setMprFechaOficioDesagregacion(Date mprFechaOficioDesagregacion) {
        this.mprFechaOficioDesagregacion = mprFechaOficioDesagregacion;
    }

    public Date getMprFechaOficioDesagregacion() {
        return mprFechaOficioDesagregacion;
    }

    public void setMprNumeroAcuerdoJunta(String mprNumeroAcuerdoJunta) {
        this.mprNumeroAcuerdoJunta = mprNumeroAcuerdoJunta;
    }

    public String getMprNumeroAcuerdoJunta() {
        return mprNumeroAcuerdoJunta;
    }

    public void setMprNumeroDecreto(String mprNumeroDecreto) {
        this.mprNumeroDecreto = mprNumeroDecreto;
    }

    public String getMprNumeroDecreto() {
        return mprNumeroDecreto;
    }

    public void setMprNumOficioDesagregacion(String mprNumOficioDesagregacion) {
        this.mprNumOficioDesagregacion = mprNumOficioDesagregacion;
    }

    public String getMprNumOficioDesagregacion() {
        return mprNumOficioDesagregacion;
    }

    public void setMprConsecutivo(Long mprConsecutivo) {
        this.mprConsecutivo = mprConsecutivo;
    }

    public Long getMprConsecutivo() {
        return mprConsecutivo;
    }


    /**
     * Adiciona un registro de Detalle de Modificaci&oacute;n Presupuestal a la lista.
     * @param modPresDetRubroVO
     * @return
     */
    public boolean addModPresDetRubroVO (ModPresDetRubroVO modPresDetRubroVO) 
    {
        boolean exitoso = false;
        
        if (modPresDetRubroListVo==null)
            modPresDetRubroListVo = new ArrayList<ModPresDetRubroVO>();
        
        exitoso = modPresDetRubroListVo.add(modPresDetRubroVO);
        if (exitoso)
            modPresDetRubroVO.setModificPresupVo(this);
        return (exitoso);
    }
    
    /**
     * Elimina un registro de Detalle de Modificaci&oacute;n Presupuestal de la lista.
     * @param modPresDetRubroVO
     * @return
     */
    public boolean removeModPresDetRubroVO (ModPresDetRubroVO modPresDetRubroVO) 
    {
        boolean exitoso = false;
        exitoso = modPresDetRubroListVo.remove(modPresDetRubroVO);
        if (exitoso)
            modPresDetRubroVO.setModificPresupVo(null);
        return (exitoso);
    }
    
    
    
    /**
     * Obtiene el primer documento de soporte de la Modificaci&oacute;n Presupuestal.
     * @return mprNumeroDecreto || mprNumeroAcuerdoJunta || mprNumOficioDesagregacion
     */
    public DocSoportePresupuestalVO getPrimerDocSoportePresupuestal () {
        DocSoportePresupuestalVO resultado = null;
        if (mprNumeroDecreto!=null) {
            resultado = new DocSoportePresupuestalVO(DocSoportePresupuestalVO.DECRETO);
            resultado.setNumeroDocumento(mprNumeroDecreto);
            resultado.setFechaDocumento(mprFechaDecreto);
        }
        else if (mprNumeroAcuerdoJunta!=null) {
            resultado = new DocSoportePresupuestalVO(DocSoportePresupuestalVO.ACUERDO);
            resultado.setNumeroDocumento(mprNumeroAcuerdoJunta);
            resultado.setFechaDocumento(mprFechaAcuerdoJunta);
        }
        else if (mprNumOficioDesagregacion!=null) {
            resultado = new DocSoportePresupuestalVO(DocSoportePresupuestalVO.OFICIO);
            resultado.setNumeroDocumento(mprNumOficioDesagregacion);
            resultado.setFechaDocumento(mprFechaOficioDesagregacion);
        }
        
        return (resultado);
    }
    
    
    /**
     * Obtiene el documento de soporte de <b>DECRETO</b> asociado a la Modificaci&oacute;n Presupuestal.
     * @return mprNumeroDecreto
     */
    public DocSoportePresupuestalVO getDocSoporteDecreto () {
        DocSoportePresupuestalVO resultado = null;
        if (mprNumeroDecreto!=null) {
            resultado = new DocSoportePresupuestalVO(DocSoportePresupuestalVO.DECRETO);
            resultado.setNumeroDocumento(mprNumeroDecreto);
            resultado.setFechaDocumento(mprFechaDecreto);
        }
        return (resultado);
    }
    
    /**
     * Obtiene el documento de soporte de <b>ACUERDO JUNTA</b> asociado a la Modificaci&oacute;n Presupuestal.
     * @return mprNumeroAcuerdoJunta
     */
    public DocSoportePresupuestalVO getDocSoporteAcuerdoJunta () {
        DocSoportePresupuestalVO resultado = null;
        if (mprNumeroAcuerdoJunta!=null) {
            resultado = new DocSoportePresupuestalVO(DocSoportePresupuestalVO.ACUERDO);
            resultado.setNumeroDocumento(mprNumeroAcuerdoJunta);
            resultado.setFechaDocumento(mprFechaAcuerdoJunta);
        }
        return (resultado);
    }
    
    /**
     * Obtiene el documento de soporte de <b>OFICIO DESAGREGACI&Oacute;N</b> asociado a la Modificaci&oacute;n Presupuestal.
     * @return mprNumOficioDesagregacion
     */
    public DocSoportePresupuestalVO getDocSoporteOficioDesagregacion () {
        DocSoportePresupuestalVO resultado = null;
        if (mprNumOficioDesagregacion!=null) {
            resultado = new DocSoportePresupuestalVO(DocSoportePresupuestalVO.OFICIO);
            resultado.setNumeroDocumento(mprNumOficioDesagregacion);
            resultado.setFechaDocumento(mprFechaOficioDesagregacion);
        }
        return (resultado);
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}
