package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifRpDetRubCdp;

import java.math.BigDecimal;

public class ModifRpDetRubCdpVO {
    private Long mrdCodigo;
    private BigDecimal mrdValor;
    private ModificacionRpVO modificacionRpVo;
    private RpDetRubroCdpVO ppDetRubroCdpVo;
    private String codigoPresupuestal; // no corresponde a un campo de la tabla. corresponde al codigo presupuestal traido de las tablas de nivles de rubros. 
    private String nombreRubro; // no corresponde a un campo de la tabla. corresponde al nombre del rubro presupuestal traido de pr rubro.
    private BigDecimal maxValor; // no corresponde a un campo de la tabla. corresponde al valor maximo a decrementar para el rubro. se usa para validacion
    private String gmf;

    
    public ModifRpDetRubCdpVO() {
        
    }
    
    public ModifRpDetRubCdpVO(SiiModifRpDetRubCdp modifRpDetRubCdp) {
        this.mrdCodigo = modifRpDetRubCdp.getMrdCodigo();
        this.mrdValor = modifRpDetRubCdp.getMrdValor();
        //Padres:
        if (modifRpDetRubCdp.getSiiModificacionRp() != null) {
            this.modificacionRpVo = new ModificacionRpVO(modifRpDetRubCdp.getSiiModificacionRp());
        }
        
        if (modifRpDetRubCdp.getSiiRpDetRubroCdp() != null) {
            this.ppDetRubroCdpVo = new RpDetRubroCdpVO(modifRpDetRubCdp.getSiiRpDetRubroCdp());
        }
        
    }

    public void setMrdCodigo(Long mrdCodigo) {
        this.mrdCodigo = mrdCodigo;
    }

    public Long getMrdCodigo() {
        return mrdCodigo;
    }

    public void setMrdValor(BigDecimal mrdValor) {
        this.mrdValor = mrdValor;
    }

    public BigDecimal getMrdValor() {
        return mrdValor;
    }

    public void setModificacionRpVo(ModificacionRpVO modificacionRpVo) {
        this.modificacionRpVo = modificacionRpVo;
    }

    public ModificacionRpVO getModificacionRpVo() {
        return modificacionRpVo;
    }

    public void setPpDetRubroCdpVo(RpDetRubroCdpVO ppDetRubroCdpVo) {
        this.ppDetRubroCdpVo = ppDetRubroCdpVo;
    }

    public RpDetRubroCdpVO getPpDetRubroCdpVo() {
        return ppDetRubroCdpVo;
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

    public void setGmf(String gmf) {
        this.gmf = gmf;
    }

    public String getGmf() {
        if ("S".equals(this.ppDetRubroCdpVo.getDetalleRubroCdpVo().getDrcAplicaGmf())) {
            this.gmf = "4*1000";
        }
        return gmf;
    }
}
