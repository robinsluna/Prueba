package co.gov.coljuegos.siicol.ejb.vo;


import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


public class CadenaPresupuestalRubroVO {

    private String UNI;
    private String TIP;
    private String CTA;
    private String SCTA;
    private String OBJ;
    private String ORD;
    private String SORD;
    private BigDecimal FUENTE;
    private BigDecimal DETFUENTE;
    private BigDecimal CDP_CONSECUTIVO;
    private Date CDP_FECHA_EXPEDICION;
    private String DESRUBRO;
    private BigDecimal VALOR_RUBRO;
    private BigDecimal VALOR_TOTAL_CDP;
    private BigDecimal VALOR_TOTAL_INCREM_RUBRO_CDP;
    private BigDecimal VALOR_TOTAL_INCREMENTO_CDP;
    private BigDecimal VALOR_TOTAL_DECREM_RUBRO_CDP;
    private BigDecimal VALOR_TOTAL_DECREMENTO_CDP;
    private BigDecimal VALOR_TOTAL_MODIFICADO_RUBRO;    
    private String OBJETOGASTO;
    private BigDecimal CDP_CODIGO;
    private List<CadenaPresupuestalRpVO> CADENA_PRESUPUESTAL_RP_VOS;

    public String getUNI() {
        return UNI;
    }

    public void setUNI(String UNI) {
        this.UNI = UNI;
    }

    public String getTIP() {
        return TIP;
    }

    public void setTIP(String TIP) {
        this.TIP = TIP;
    }

    public String getCTA() {
        return CTA;
    }

    public void setCTA(String CTA) {
        this.CTA = CTA;
    }

    public String getSCTA() {
        return SCTA;
    }

    public void setSCTA(String SCTA) {
        this.SCTA = SCTA;
    }

    public String getOBJ() {
        return OBJ;
    }

    public void setOBJ(String OBJ) {
        this.OBJ = OBJ;
    }

    public String getORD() {
        return ORD;
    }

    public void setORD(String ORD) {
        this.ORD = ORD;
    }

    public String getSORD() {
        return SORD;
    }

    public void setSORD(String SORD) {
        this.SORD = SORD;
    }

    public BigDecimal getFUENTE() {
        return FUENTE;
    }

    public void setFUENTE(BigDecimal FUENTE) {
        this.FUENTE = FUENTE;
    }

    public BigDecimal getDETFUENTE() {
        return DETFUENTE;
    }

    public void setDETFUENTE(BigDecimal DETFUENTE) {
        this.DETFUENTE = DETFUENTE;
    }

    public BigDecimal getCDP_CONSECUTIVO() {
        return CDP_CONSECUTIVO;
    }

    public void setCDP_CONSECUTIVO(BigDecimal CDP_CONSECUTIVO) {
        this.CDP_CONSECUTIVO = CDP_CONSECUTIVO;
    }

    public Date getCDP_FECHA_EXPEDICION() {
        return CDP_FECHA_EXPEDICION;
    }

    public void setCDP_FECHA_EXPEDICION(Date CDP_FECHA_EXPEDICION) {
        this.CDP_FECHA_EXPEDICION = CDP_FECHA_EXPEDICION;
    }

    public String getDESRUBRO() {
        return DESRUBRO;
    }

    public void setDESRUBRO(String DESRUBRO) {
        this.DESRUBRO = DESRUBRO;
    }

    public BigDecimal getVALOR_RUBRO() {
        return VALOR_RUBRO;
    }

    public void setVALOR_RUBRO(BigDecimal VALOR_RUBRO) {
        this.VALOR_RUBRO = VALOR_RUBRO;
    }

    public BigDecimal getVALOR_TOTAL_CDP() {
        return VALOR_TOTAL_CDP;
    }

    public void setVALOR_TOTAL_CDP(BigDecimal VALOR_TOTAL_CDP) {
        this.VALOR_TOTAL_CDP = VALOR_TOTAL_CDP;
    }

    public BigDecimal getVALOR_TOTAL_INCREM_RUBRO_CDP() {
        return VALOR_TOTAL_INCREM_RUBRO_CDP;
    }

    public void setVALOR_TOTAL_INCREM_RUBRO_CDP(BigDecimal VALOR_TOTAL_INCREM_RUBRO_CDP) {
        this.VALOR_TOTAL_INCREM_RUBRO_CDP = VALOR_TOTAL_INCREM_RUBRO_CDP;
    }

    public BigDecimal getVALOR_TOTAL_INCREMENTO_CDP() {
        return VALOR_TOTAL_INCREMENTO_CDP;
    }

    public void setVALOR_TOTAL_INCREMENTO_CDP(BigDecimal VALOR_TOTAL_INCREMENTO_CDP) {
        this.VALOR_TOTAL_INCREMENTO_CDP = VALOR_TOTAL_INCREMENTO_CDP;
    }

    public BigDecimal getVALOR_TOTAL_DECREM_RUBRO_CDP() {
        return VALOR_TOTAL_DECREM_RUBRO_CDP;
    }

    public void setVALOR_TOTAL_DECREM_RUBRO_CDP(BigDecimal VALOR_TOTAL_DECREM_RUBRO_CDP) {
        this.VALOR_TOTAL_DECREM_RUBRO_CDP = VALOR_TOTAL_DECREM_RUBRO_CDP;
    }

    public BigDecimal getVALOR_TOTAL_DECREMENTO_CDP() {
        return VALOR_TOTAL_DECREMENTO_CDP;
    }

    public void setVALOR_TOTAL_DECREMENTO_CDP(BigDecimal VALOR_TOTAL_DECREMENTO_CDP) {
        this.VALOR_TOTAL_DECREMENTO_CDP = VALOR_TOTAL_DECREMENTO_CDP;
    }

    public BigDecimal getVALOR_TOTAL_MODIFICADO_RUBRO() {
        return VALOR_TOTAL_MODIFICADO_RUBRO;
    }

    public void setVALOR_TOTAL_MODIFICADO_RUBRO(BigDecimal VALOR_TOTAL_MODIFICADO_RUBRO) {
        this.VALOR_TOTAL_MODIFICADO_RUBRO = VALOR_TOTAL_MODIFICADO_RUBRO;
    }

    public String getOBJETOGASTO() {
        return OBJETOGASTO;
    }

    public void setOBJETOGASTO(String OBJETOGASTO) {
        this.OBJETOGASTO = OBJETOGASTO;
    }

    public BigDecimal getCDP_CODIGO() {
        return CDP_CODIGO;
    }

    public void setCDP_CODIGO(BigDecimal CDP_CODIGO) {
        this.CDP_CODIGO = CDP_CODIGO;
    }

    public List<CadenaPresupuestalRpVO> getCADENA_PRESUPUESTAL_RP_VOS() {
        return CADENA_PRESUPUESTAL_RP_VOS;
    }

    public void setCADENA_PRESUPUESTAL_RP_VOS(List<CadenaPresupuestalRpVO> CADENA_PRESUPUESTAL_RP_VOS) {
        this.CADENA_PRESUPUESTAL_RP_VOS = CADENA_PRESUPUESTAL_RP_VOS;
    }
}
