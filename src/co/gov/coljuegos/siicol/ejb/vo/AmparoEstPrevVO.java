package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoEstPrev;

public class AmparoEstPrevVO {
    private Long aepCodigo;
    private String aepJustificacion;
    private Integer aepPorcentaje;
    private String aepVigencia;
    private EstudioPrevioVO estudioPrevioVo;
    private TipoAmparoVO tipoAmparoVo;
    private TipoGarantiaVO tipoGarantiaVO;


    public AmparoEstPrevVO() {

    }

    public AmparoEstPrevVO(SiiAmparoEstPrev siiAmparoEstPrev) {
        this.aepCodigo = siiAmparoEstPrev.getAepCodigo();
        this.aepJustificacion = siiAmparoEstPrev.getAepJustificacion();
        this.aepPorcentaje = siiAmparoEstPrev.getAepPorcentaje();
        this.aepVigencia = siiAmparoEstPrev.getAepVigencia();

        //Estudio Previo
        if (siiAmparoEstPrev.getSiiEstudioPrevio() != null &&
            siiAmparoEstPrev.getSiiEstudioPrevio().getEpeCodigo() != null &&
            siiAmparoEstPrev.getSiiEstudioPrevio().getEpeCodigo() > 0) {
            this.estudioPrevioVo = new EstudioPrevioVO(siiAmparoEstPrev.getSiiEstudioPrevio());
        }
        
        //Tipo Garantia
        if(siiAmparoEstPrev.getSiiTipoGarantia() != null &&
            siiAmparoEstPrev.getSiiTipoGarantia().getTgaCodigo() != null &&
            siiAmparoEstPrev.getSiiTipoGarantia().getTgaCodigo() > 0){
            this.tipoGarantiaVO = new TipoGarantiaVO(siiAmparoEstPrev.getSiiTipoGarantia());
        }
        this.estudioPrevioVo = new EstudioPrevioVO(siiAmparoEstPrev.getSiiEstudioPrevio());
        this.tipoAmparoVo = new TipoAmparoVO(siiAmparoEstPrev.getSiiTipoAmparo());
    }

    public void setAepCodigo(Long aepCodigo) {
        this.aepCodigo = aepCodigo;
    }

    public Long getAepCodigo() {
        return aepCodigo;
    }

    public void setAepJustificacion(String aepJustificacion) {
        this.aepJustificacion = aepJustificacion;
    }

    public String getAepJustificacion() {
        return aepJustificacion;
    }

    public void setAepPorcentaje(Integer aepPorcentaje) {
        this.aepPorcentaje = aepPorcentaje;
    }

    public Integer getAepPorcentaje() {
        return aepPorcentaje;
    }

    public void setAepVigencia(String aepVigencia) {
        this.aepVigencia = aepVigencia;
    }

    public String getAepVigencia() {
        return aepVigencia;
    }

    public void setEstudioPrevioVo(EstudioPrevioVO estudioPrevioVo) {
        this.estudioPrevioVo = estudioPrevioVo;
    }

    public EstudioPrevioVO getEstudioPrevioVo() {
        return estudioPrevioVo;
    }

    public void setTipoAmparoVo(TipoAmparoVO tipoAmparoVo) {
        this.tipoAmparoVo = tipoAmparoVo;
    }

    public TipoAmparoVO getTipoAmparoVo() {
        return tipoAmparoVo;
    }

    public TipoGarantiaVO getTipoGarantiaVO() {
        return tipoGarantiaVO;
    }

    public void setTipoGarantiaVO(TipoGarantiaVO tipoGarantiaVO) {
        this.tipoGarantiaVO = tipoGarantiaVO;
    }
}
