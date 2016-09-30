package co.gov.coljuegos.siicol.ejb.wsvo;

import java.math.BigDecimal;


/**
 *Objeto usado para transportar la informacion por el web services de las ventas de las mets relacionadas en
 * cuota operador
 * @author Carlos Arciniegas
 */

public class VentasMetCuotaWSVO {
        private String metSerial; 
        private Long marCodigo; 
        private String marNombre;
        private String metNuid;
        private Long tapCodigo;
        private String tapNombre;
        private Long estCodigo;
        private String estNombre; 
        private Long ubiCodigo;
        private String ubiNombre; 
        private Long ubi_codigoPadre; 
        private String ubiNombrePadre;
        private BigDecimal valorVentasNetas;
        private BigDecimal vmeLiqTarifaVar; 
        private BigDecimal vmeLiqTarifaFija; 
        private BigDecimal vmeLiqEfectiva;
        private Long vmeCodigo;
        private Long rveCodigo;
    
        public VentasMetCuotaWSVO() {
    }

    public void setMetSerial(String metSerial) {
        this.metSerial = metSerial;
    }

    public String getMetSerial() {
        return metSerial;
    }

    public void setMarCodigo(Long marCodigo) {
        this.marCodigo = marCodigo;
    }

    public Long getMarCodigo() {
        return marCodigo;
    }

    public void setMarNombre(String marNombre) {
        this.marNombre = marNombre;
    }

    public String getMarNombre() {
        return marNombre;
    }

    public void setMetNuid(String metNuid) {
        this.metNuid = metNuid;
    }

    public String getMetNuid() {
        return metNuid;
    }

    public void setTapCodigo(Long tapCodigo) {
        this.tapCodigo = tapCodigo;
    }

    public Long getTapCodigo() {
        return tapCodigo;
    }

    public void setTapNombre(String tapNombre) {
        this.tapNombre = tapNombre;
    }

    public String getTapNombre() {
        return tapNombre;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setUbiCodigo(Long ubiCodigo) {
        this.ubiCodigo = ubiCodigo;
    }

    public Long getUbiCodigo() {
        return ubiCodigo;
    }

    public void setUbiNombre(String ubiNombre) {
        this.ubiNombre = ubiNombre;
    }

    public String getUbiNombre() {
        return ubiNombre;
    }

    public void setUbi_codigoPadre(Long ubi_codigoPadre) {
        this.ubi_codigoPadre = ubi_codigoPadre;
    }

    public Long getUbi_codigoPadre() {
        return ubi_codigoPadre;
    }

    public void setUbiNombrePadre(String ubiNombrePadre) {
        this.ubiNombrePadre = ubiNombrePadre;
    }

    public String getUbiNombrePadre() {
        return ubiNombrePadre;
    }

    public void setValorVentasNetas(BigDecimal valorVentasNetas) {
        this.valorVentasNetas = valorVentasNetas;
    }

    public BigDecimal getValorVentasNetas() {
        return valorVentasNetas;
    }

    public void setVmeLiqTarifaVar(BigDecimal vmeLiqTarifaVar) {
        this.vmeLiqTarifaVar = vmeLiqTarifaVar;
    }

    public BigDecimal getVmeLiqTarifaVar() {
        return vmeLiqTarifaVar;
    }

    public void setVmeLiqTarifaFija(BigDecimal vmeLiqTarifaFija) {
        this.vmeLiqTarifaFija = vmeLiqTarifaFija;
    }

    public BigDecimal getVmeLiqTarifaFija() {
        return vmeLiqTarifaFija;
    }

    public void setVmeLiqEfectiva(BigDecimal vmeLiqEfectiva) {
        this.vmeLiqEfectiva = vmeLiqEfectiva;
    }

    public BigDecimal getVmeLiqEfectiva() {
        return vmeLiqEfectiva;
    }

    public void setVmeCodigo(Long vmeCodigo) {
        this.vmeCodigo = vmeCodigo;
    }

    public Long getVmeCodigo() {
        return vmeCodigo;
    }

    public void setRveCodigo(Long rveCodigo) {
        this.rveCodigo = rveCodigo;
    }

    public Long getRveCodigo() {
        return rveCodigo;
    }
}
