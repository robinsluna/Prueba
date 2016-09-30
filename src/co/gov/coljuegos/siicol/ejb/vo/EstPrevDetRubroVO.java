package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstPrevDetRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioPrevio;

public class EstPrevDetRubroVO {
    private Long epdCodigo;
    private Long epdValor;
    private DetalleRubroVO detalleRubroVo;
    private EstudioPrevioVO estudioPrevioVo;
    
    public EstPrevDetRubroVO(SiiEstPrevDetRubro siiEstPrevDetRubro) {
        this.epdCodigo = siiEstPrevDetRubro.getEpdCodigo();
        this.epdValor = siiEstPrevDetRubro.getEpdValor();
        this.detalleRubroVo = new DetalleRubroVO(siiEstPrevDetRubro.getSiiDetalleRubro());
        this.estudioPrevioVo = new EstudioPrevioVO(siiEstPrevDetRubro.getSiiEstudioPrevio2());
    }

    public EstPrevDetRubroVO(){
        
    }
    
    public void setEpdCodigo(Long epdCodigo) {
        this.epdCodigo = epdCodigo;
    }

    public Long getEpdCodigo() {
        return epdCodigo;
    }

    public void setEpdValor(Long epdValor) {
        this.epdValor = epdValor;
    }

    public Long getEpdValor() {
        return epdValor;
    }

    public void setDetalleRubroVo(DetalleRubroVO detalleRubroVo) {
        this.detalleRubroVo = detalleRubroVo;
    }

    public DetalleRubroVO getDetalleRubroVo() {
        return detalleRubroVo;
    }

    public void setEstudioPrevioVo(EstudioPrevioVO estudioPrevioVo) {
        this.estudioPrevioVo = estudioPrevioVo;
    }

    public EstudioPrevioVO getEstudioPrevioVo() {
        return estudioPrevioVo;
    }
}

