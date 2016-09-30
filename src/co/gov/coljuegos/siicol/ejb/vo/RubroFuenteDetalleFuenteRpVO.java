package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionPago;

import java.math.BigDecimal;

import java.util.List;

public class RubroFuenteDetalleFuenteRpVO {
   
     
    private String rfdNumeroDocSop;
    private BigDecimal rfdValorRp;
    private Long rfdCodigoFuente;
    private String rfdNombreFuente;
    private Long rfdCodigoDetalleF;
    private String rfdDescripcionDF;
    private String rdfNumeroDocSoporte;
    private Long rdfCodigoDetalleRubroCdp;
    private Long tipoDocumento;
    private Integer vigencia; 
    private BigDecimal rfdValoraPagar;
    private Long rfdCodigoDetalleObligacion;
    private String rdfCadena;
    private Long rfdidDetalleRubro; 
    private Long rfdidObligacion;
    private Long rdfMesPago;
    private BigDecimal saldoXejecutar;
    private Long CodigoRp;
    private BigDecimal decrementoRp;
    private BigDecimal valorTotalObligaciones; 
    private Long rfdCodigoRpDetRubroCdp;
    private String aplicaGMF;
    private BigDecimal valorReintegro;
    private BigDecimal incrementoRp;
    private BigDecimal valorReintegroIndSi;
    private BigDecimal valorReintegroIndNo;
    private BigDecimal cuatroXMil;
    
    
    public RubroFuenteDetalleFuenteRpVO() {
       
    }


    public void setRfdCodigoRpDetRubroCdp(Long rfdCodigoRpDetRubroCdp) {
        this.rfdCodigoRpDetRubroCdp = rfdCodigoRpDetRubroCdp;
    }

    public Long getRfdCodigoRpDetRubroCdp() {
        return rfdCodigoRpDetRubroCdp;
    }

    public void setDecrementoRp(BigDecimal decrementoRp) {
        this.decrementoRp = decrementoRp;
    }

    public BigDecimal getDecrementoRp() {
        return decrementoRp;
    }

    public void setValorTotalObligaciones(BigDecimal valorTotalObligaciones) {
        this.valorTotalObligaciones = valorTotalObligaciones;
    }

    public BigDecimal getValorTotalObligaciones() {
        return valorTotalObligaciones;
    }

    public void setCodigoRp(Long CodigoRp) {
        this.CodigoRp = CodigoRp;
    }

    public Long getCodigoRp() {
        return CodigoRp;
    }

    public void setSaldoXejecutar(BigDecimal saldoXejecutar) {
        this.saldoXejecutar = saldoXejecutar;
    }

    public BigDecimal getSaldoXejecutar() {
        return saldoXejecutar;
    }

    public void setRfdidDetalleRubro(Long rfdidDetalleRubro) {
        this.rfdidDetalleRubro = rfdidDetalleRubro;
    }

    public Long getRfdidDetalleRubro() {
        return rfdidDetalleRubro;
    }

    public void setRfdidObligacion(Long rfdidObligacion) {
        this.rfdidObligacion = rfdidObligacion;
    }

    public Long getRfdidObligacion() {
        return rfdidObligacion;
    }

    public void setRdfCadena(String rdfCadena) {
        this.rdfCadena = rdfCadena;
    }

    public String getRdfCadena() {
        return rdfCadena;
    }


    public void setRfdCodigoDetalleObligacion(Long rfdCodigoDetalleObligacion) {
        this.rfdCodigoDetalleObligacion = rfdCodigoDetalleObligacion;
    }

    public Long getRfdCodigoDetalleObligacion() {
        return rfdCodigoDetalleObligacion;
    }

   
    public void setRfdNumeroDocSop(String rfdNumeroDocSop) {
        this.rfdNumeroDocSop = rfdNumeroDocSop;
    }

    public String getRfdNumeroDocSop() {
        return rfdNumeroDocSop;
    }

    public void setRfdValorRp(BigDecimal rfdValorRp) {
        this.rfdValorRp = rfdValorRp;
    }

    public BigDecimal getRfdValorRp() {
        return rfdValorRp;
    }

    public void setRfdCodigoFuente(Long rfdCodigoFuente) {
        this.rfdCodigoFuente = rfdCodigoFuente;
    }

    public Long getRfdCodigoFuente() {
        return rfdCodigoFuente;
    }

    public void setRfdValoraPagar(BigDecimal rfdValoraPagar) {
        this.rfdValoraPagar = rfdValoraPagar;
    }

    public BigDecimal getRfdValoraPagar() {
        return rfdValoraPagar;
    }

    public void setRfdNombreFuente(String rfdNombreFuente) {
        this.rfdNombreFuente = rfdNombreFuente;
    }


    public void setRdfMesPago(Long rdfMesPago) {
        this.rdfMesPago = rdfMesPago;
    }

    public Long getRdfMesPago() {
        return rdfMesPago;
    }

    public String getRfdNombreFuente() {
        return rfdNombreFuente;
    }

    public void setTipoDocumento(Long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getTipoDocumento() {
        return tipoDocumento;
    }


    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setRfdCodigoDetalleF(Long rfdCodigoDetalleF) {
        this.rfdCodigoDetalleF = rfdCodigoDetalleF;
    }

    public Long getRfdCodigoDetalleF() {
        return rfdCodigoDetalleF;
    }

    public void setRfdDescripcionDF(String rfdDescripcionDF) {
        this.rfdDescripcionDF = rfdDescripcionDF;
    }

    public String getRfdDescripcionDF() {
        return rfdDescripcionDF;
    }

    public void setRdfNumeroDocSoporte(String rdfNumeroDocSoporte) {
        this.rdfNumeroDocSoporte = rdfNumeroDocSoporte;
    }

    public String getRdfNumeroDocSoporte() {
        return rdfNumeroDocSoporte;
    }

    public void setRdfCodigoDetalleRubroCdp(Long rdfCodigoDetalleRubroCdp) {
        this.rdfCodigoDetalleRubroCdp = rdfCodigoDetalleRubroCdp;
    }

    public Long getRdfCodigoDetalleRubroCdp() {
        return rdfCodigoDetalleRubroCdp;
    }

    public void setAplicaGMF(String aplicaGMF) {
        this.aplicaGMF = aplicaGMF;
    }

    public String getAplicaGMF() {
        return aplicaGMF;
    }

    public void setValorReintegro(BigDecimal valorReintegro){
        this.valorReintegro = valorReintegro;
    }

    public BigDecimal getValorReintegro(){
        return valorReintegro;
    }


    public void setIncrementoRp(BigDecimal incrementoRp){
        this.incrementoRp = incrementoRp;
    }

    public BigDecimal getIncrementoRp(){
        return incrementoRp;
    }

    public void setValorReintegroIndSi(BigDecimal valorReintegroIndSi){
        this.valorReintegroIndSi = valorReintegroIndSi;
    }

    public BigDecimal getValorReintegroIndSi(){
        return valorReintegroIndSi;
    }

    public void setValorReintegroIndNo(BigDecimal valorReintegroIndNo){
        this.valorReintegroIndNo = valorReintegroIndNo;
    }

    public BigDecimal getValorReintegroIndNo(){
        return valorReintegroIndNo;
    }

    public void setCuatroXMil(BigDecimal cuatroXMil) {
        this.cuatroXMil = cuatroXMil;
    }

    public BigDecimal getCuatroXMil() {
        return cuatroXMil;
    }

}
