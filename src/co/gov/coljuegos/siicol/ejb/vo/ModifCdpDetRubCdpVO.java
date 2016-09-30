package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifCdpDetRubCdp;

import java.math.BigDecimal;

public class ModifCdpDetRubCdpVO {
    
    private Long mcrCodigo;
    private BigDecimal mcrValor;
    private ModificacionCdpVO modificacionCdpVo;
    private DetalleRubroCdpVO detalleRubroCdpVo;
    private String codigoPresupuestal; // no corresponde a un campo de la tabla. corresponde al codigo presupuestal traido de las tablas de nivles de rubros. 
    private String nombreRubro; // no corresponde a un campo de la tabla. corresponde al nombre del rubro presupuestal traido de por rubro.
    private BigDecimal maxValor; // no corresponde a un campo de la tabla. corresponde al valor maximo  para el rubro. se usa para validacion
    private Long cdrCodigo; //  Corresponde al codigo de cada rubro
    private String gmf; // "4*1000" si en detalleRubroCdpVo drcAplicaGmf == "S"

    public ModifCdpDetRubCdpVO() {
    }

    public ModifCdpDetRubCdpVO(SiiModifCdpDetRubCdp siiModifCdpDetRubCdp) {
        this.mcrCodigo = siiModifCdpDetRubCdp.getMcrCodigo();
        this.mcrValor = siiModifCdpDetRubCdp.getMcrValor();
        
        if(siiModifCdpDetRubCdp.getSiiModificacionCdp() != null){
            this.modificacionCdpVo = new ModificacionCdpVO(siiModifCdpDetRubCdp.getSiiModificacionCdp());
        }
        if(siiModifCdpDetRubCdp.getSiiDetalleRubroCdp() != null){
            this.detalleRubroCdpVo = new DetalleRubroCdpVO(siiModifCdpDetRubCdp.getSiiDetalleRubroCdp());
        }
    }

    public void setMcrCodigo(Long mcrCodigo) {
        this.mcrCodigo = mcrCodigo;
    }

    public Long getMcrCodigo() {
        return mcrCodigo;
    }

    public void setMcrValor(BigDecimal mcrValor) {
        this.mcrValor = mcrValor;
    }

    public BigDecimal getMcrValor() {
        return mcrValor;
    }

    public void setModificacionCdpVo(ModificacionCdpVO modificacionCdpVo) {
        this.modificacionCdpVo = modificacionCdpVo;
    }

    public ModificacionCdpVO getModificacionCdpVo() {
        return modificacionCdpVo;
    }

    public void setDetalleRubroCdpVo(DetalleRubroCdpVO detalleRubroCdpVo) {
        this.detalleRubroCdpVo = detalleRubroCdpVo;
    }

    public DetalleRubroCdpVO getDetalleRubroCdpVo() {
        return detalleRubroCdpVo;
    }

    public void setCodigoPresupuestal(String codigoPresupuestal) {
        this.codigoPresupuestal = codigoPresupuestal;
    }

    public String getCodigoPresupuestal() {
        return codigoPresupuestal;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setMaxValor(BigDecimal maxValor) {
        this.maxValor = maxValor;
    }

    public BigDecimal getMaxValor() {
        return maxValor;
    }

    public void setCdrCodigo(Long cdrCodigo) {
        this.cdrCodigo = cdrCodigo;
    }

    public Long getCdrCodigo() {
        return cdrCodigo;
    }

    public void setGmf(String gmf) {
        this.gmf = gmf;
    }

    public String getGmf() {
        if ("S".equals(this.detalleRubroCdpVo.getDrcAplicaGmf())) {
            this.gmf = "4*1000";
        }
        return gmf;
    }
}


