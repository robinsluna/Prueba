package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class ReporteDistribucionVO {
    
    private String codigoDane;
    private String depto;
    private String municipio;
    private BigDecimal valorRecaudado;
    private Long poblacion;
    private BigDecimal valorPropio;
    private BigDecimal valorTodos;
    private BigDecimal valorDeTodos;
    private BigDecimal valorRecaudoInteresMora;
    private BigDecimal valorRecaudoInteresFinanc;
    private BigDecimal totalTransferencia;
    private BigDecimal localMenor100;
    private BigDecimal localMayor100;
    private String concepto;
    private String distribucion;
    private BigDecimal valorDeTodosInteresMora;
    private BigDecimal valorDeTodosInteresFinanc;
    private BigDecimal valorDeTodosPromocionales;
    private BigDecimal valorDeTodosRifas;
    private BigDecimal valorDeTodosHipicosGall;
    private BigDecimal valorDeTodosActuacionesAdm;
    private BigDecimal valorDeTodosLegalizacionAnticipos;
    private BigDecimal valorTotalControl;
    private BigDecimal valorColciencias;
    private BigDecimal subtotalTransferir;
    private BigDecimal porcentajeParticipacion;
    private BigDecimal rendimientoFinancieros;
    private BigDecimal distribucionFosyga;
    private BigDecimal distribucionMunicipios;
    private BigDecimal localizadosHbtXDnp;
    private BigDecimal derechosExpl;
    private BigDecimal deColciencias;
    private BigDecimal deFosyga;
    private BigDecimal deMunicipio;
    private BigDecimal ifColciencias;
    private BigDecimal ifFosyga;
    private BigDecimal ifMunicipio;
    private BigDecimal imColciencias;
    private BigDecimal imFosyga;
    private BigDecimal imMunicipio;
    private BigDecimal aAColciencias;
    private BigDecimal aAFosyga;
    private BigDecimal aAMunicipio;
    private BigDecimal rfColciencias;
    private BigDecimal rfFosyga;
    private BigDecimal rfMunicipio;
    private BigDecimal distrColciencias; 
    
        
    
    
    public ReporteDistribucionVO() {
        
    }   

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getDepto() {
        return depto;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setValorRecaudado(BigDecimal valorRecaudado) {
        this.valorRecaudado = valorRecaudado;
    }

    public BigDecimal getValorRecaudado() {
        return valorRecaudado;
    }

    public void setValorPropio(BigDecimal valorPropio) {
        this.valorPropio = valorPropio;
    }

    public BigDecimal getValorPropio() {
        return valorPropio;
    }

    public void setValorTodos(BigDecimal valorTodos) {
        this.valorTodos = valorTodos;
    }

    public BigDecimal getValorTodos() {
        return valorTodos;
    }

    public void setValorDeTodos(BigDecimal valorDeTodos) {
        this.valorDeTodos = valorDeTodos;
    }

    public BigDecimal getValorDeTodos() {
        return valorDeTodos;
    }

    public void setCodigoDane(String codigoDane) {
        this.codigoDane = codigoDane;
    }

    public String getCodigoDane() {
        return codigoDane;
    }


    public void setPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    public Long getPoblacion() {
        return poblacion;
    }

    public void setValorRecaudoInteresMora(BigDecimal valorRecaudoInteresMora) {
        this.valorRecaudoInteresMora = valorRecaudoInteresMora;
    }

    public BigDecimal getValorRecaudoInteresMora() {
        return valorRecaudoInteresMora;
    }

    public void setValorRecaudoInteresFinanc(BigDecimal valorRecaudoInteresFinanc) {
        this.valorRecaudoInteresFinanc = valorRecaudoInteresFinanc;
    }

    public BigDecimal getValorRecaudoInteresFinanc() {
        return valorRecaudoInteresFinanc;
    }


    public void setTotalTransferencia(BigDecimal totalTransferencia) {
        this.totalTransferencia = totalTransferencia;
    }

    public BigDecimal getTotalTransferencia() {
        return totalTransferencia;
    }

    public void setLocalMenor100(BigDecimal localMenor100) {
        this.localMenor100 = localMenor100;
    }

    public BigDecimal getLocalMenor100() {
        return localMenor100;
    }

    public void setLocalMayor100(BigDecimal localMayor100) {
        this.localMayor100 = localMayor100;
    }

    public BigDecimal getLocalMayor100() {
        return localMayor100;
    }


    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
    }

    public String getDistribucion() {
        return distribucion;
    }

    public void setValorDeTodosInteresMora(BigDecimal valorDeTodosInteresMora) {
        this.valorDeTodosInteresMora = valorDeTodosInteresMora;
    }

    public BigDecimal getValorDeTodosInteresMora() {
        return valorDeTodosInteresMora;
    }

    public void setValorDeTodosInteresFinanc(BigDecimal valorDeTodosInteresFinanc) {
        this.valorDeTodosInteresFinanc = valorDeTodosInteresFinanc;
    }

    public BigDecimal getValorDeTodosInteresFinanc() {
        return valorDeTodosInteresFinanc;
    }

    public void setValorDeTodosPromocionales(BigDecimal valorDeTodosPromocionales) {
        this.valorDeTodosPromocionales = valorDeTodosPromocionales;
    }

    public BigDecimal getValorDeTodosPromocionales() {
        return valorDeTodosPromocionales;
    }

    public void setValorDeTodosRifas(BigDecimal valorDeTodosRifas) {
        this.valorDeTodosRifas = valorDeTodosRifas;
    }

    public BigDecimal getValorDeTodosRifas() {
        return valorDeTodosRifas;
    }

    public void setValorDeTodosHipicosGall(BigDecimal valorDeTodosHipicosGall) {
        this.valorDeTodosHipicosGall = valorDeTodosHipicosGall;
    }

    public BigDecimal getValorDeTodosHipicosGall() {
        return valorDeTodosHipicosGall;
    }

    public void setValorDeTodosActuacionesAdm(BigDecimal valorDeTodosActuacionesAdm) {
        this.valorDeTodosActuacionesAdm = valorDeTodosActuacionesAdm;
    }

    public BigDecimal getValorDeTodosActuacionesAdm() {
        return valorDeTodosActuacionesAdm;
    }

    public void setValorDeTodosLegalizacionAnticipos(BigDecimal valorDeTodosLegalizacionAnticipos) {
        this.valorDeTodosLegalizacionAnticipos = valorDeTodosLegalizacionAnticipos;
    }

    public BigDecimal getValorDeTodosLegalizacionAnticipos() {
        return valorDeTodosLegalizacionAnticipos;
    }

    public void setValorTotalControl(BigDecimal valorTotalControl) {
        this.valorTotalControl = valorTotalControl;
    }

    public BigDecimal getValorTotalControl() {
        return valorTotalControl;
    }

    public void setValorColciencias(BigDecimal valorColciencias) {
        this.valorColciencias = valorColciencias;
    }

    public BigDecimal getValorColciencias() {
        return valorColciencias;
    }

    public void setSubtotalTransferir(BigDecimal subtotalTransferir) {
        this.subtotalTransferir = subtotalTransferir;
    }

    public BigDecimal getSubtotalTransferir() {
        return subtotalTransferir;
    }

     public void setPorcentajeParticipacion(BigDecimal porcentajeParticipacion) {
        this.porcentajeParticipacion = porcentajeParticipacion;
    }

    public BigDecimal getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    public void setRendimientoFinancieros(BigDecimal rendimientoFinancieros) {
        this.rendimientoFinancieros = rendimientoFinancieros;
    }

    public BigDecimal getRendimientoFinancieros() {
        return rendimientoFinancieros;
    }

    public void setDistribucionFosyga(BigDecimal distribucionFosyga) {
        this.distribucionFosyga = distribucionFosyga;
    }

    public BigDecimal getDistribucionFosyga() {
        return distribucionFosyga;
    }

    public void setDistribucionMunicipios(BigDecimal distribucionMunicipios) {
        this.distribucionMunicipios = distribucionMunicipios;
    }

    public BigDecimal getDistribucionMunicipios() {
        return distribucionMunicipios;
    }
	public void setLocalizadosHbtXDnp(BigDecimal localizadosHbtXDnp) {
        this.localizadosHbtXDnp = localizadosHbtXDnp;
    }

    public BigDecimal getLocalizadosHbtXDnp() {
        return localizadosHbtXDnp;
    }

    public void setDerechosExpl(BigDecimal derechosExpl) {
        this.derechosExpl = derechosExpl;
    }

    public BigDecimal getDerechosExpl() {
        return derechosExpl;
    }

    public void setDeColciencias(BigDecimal deColciencias) {
        this.deColciencias = deColciencias;
    }

    public BigDecimal getDeColciencias() {
        return deColciencias;
    }

    public void setDeFosyga(BigDecimal deFosyga) {
        this.deFosyga = deFosyga;
    }

    public BigDecimal getDeFosyga() {
        return deFosyga;
    }

    public void setDeMunicipio(BigDecimal deMunicipio) {
        this.deMunicipio = deMunicipio;
    }

    public BigDecimal getDeMunicipio() {
        return deMunicipio;
    }

    public void setIfColciencias(BigDecimal ifColciencias) {
        this.ifColciencias = ifColciencias;
    }

    public BigDecimal getIfColciencias() {
        return ifColciencias;
    }

    public void setIfFosyga(BigDecimal ifFosyga) {
        this.ifFosyga = ifFosyga;
    }

    public BigDecimal getIfFosyga() {
        return ifFosyga;
    }

    public void setIfMunicipio(BigDecimal ifMunicipio) {
        this.ifMunicipio = ifMunicipio;
    }

    public BigDecimal getIfMunicipio() {
        return ifMunicipio;
    }

    public void setImColciencias(BigDecimal imColciencias) {
        this.imColciencias = imColciencias;
    }

    public BigDecimal getImColciencias() {
        return imColciencias;
    }

    public void setImFosyga(BigDecimal imFosyga) {
        this.imFosyga = imFosyga;
    }

    public BigDecimal getImFosyga() {
        return imFosyga;
    }

    public void setImMunicipio(BigDecimal imMunicipio) {
        this.imMunicipio = imMunicipio;
    }

    public BigDecimal getImMunicipio() {
        return imMunicipio;
    }

    public void setAAColciencias(BigDecimal aAColciencias) {
        this.aAColciencias = aAColciencias;
    }

    public BigDecimal getAAColciencias() {
        return aAColciencias;
    }

    public void setAAFosyga(BigDecimal aAFosyga) {
        this.aAFosyga = aAFosyga;
    }

    public BigDecimal getAAFosyga() {
        return aAFosyga;
    }

    public void setAAMunicipio(BigDecimal aAMunicipio) {
        this.aAMunicipio = aAMunicipio;
    }

    public BigDecimal getAAMunicipio() {
        return aAMunicipio;
    }

    public void setRfColciencias(BigDecimal rfColciencias) {
        this.rfColciencias = rfColciencias;
    }

    public BigDecimal getRfColciencias() {
        return rfColciencias;
    }

    public void setRfFosyga(BigDecimal rfFosyga) {
        this.rfFosyga = rfFosyga;
    }

    public BigDecimal getRfFosyga() {
        return rfFosyga;
    }

    public void setRfMunicipio(BigDecimal rfMunicipio) {
        this.rfMunicipio = rfMunicipio;
    }

    public BigDecimal getRfMunicipio() {
        return rfMunicipio;
    }

    public void setDistrColciencias(BigDecimal distrColciencias) {
        this.distrColciencias = distrColciencias;
    }

    public BigDecimal getDistrColciencias() {
        return distrColciencias;
    }

}
