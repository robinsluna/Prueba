package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsolidadoDist;

import java.math.BigDecimal;

import java.util.List;


public class ConsolidadoDistVO {
    private Long codCodigo;
    private BigDecimal codActuacAdmin;    
    private BigDecimal codColciencias;
    private BigDecimal codDistribFosyga;
    private BigDecimal codDistribMunicip;
    private BigDecimal codHipicosGallist;
    private BigDecimal codInteresFinanc;
    private BigDecimal codInteresMora;
    private BigDecimal codLegalizacAnticip;
    private BigDecimal codLocMayCienDnp;
    private BigDecimal codLocalizMayCien;
    private BigDecimal codLocalizMenCien;
    private BigDecimal codPorcentajePart;
    private BigDecimal codPromocionales;
    private BigDecimal codRendimientosFin;
    private BigDecimal codRifas;
    private BigDecimal codSubtotalTrans;
    private BigDecimal codTotalControl;
    private BigDecimal codTotalTransf;
    private BigDecimal codValorRecaudo;
    private List<ObligacionVO> obligacionListVo;
    private DistribucionMesVO distribucionMesVo;
    private UbicacionVO ubicacionVo;
    private PersonaVO personaVo;
    private BigDecimal codDerechosExpl;
    private BigDecimal codDeColciencias;
    private BigDecimal codDeFosyga;
    private BigDecimal codDeMunicipio;
    private BigDecimal codIfColciencias;
    private BigDecimal codIfFosyga;
    private BigDecimal codIfMunicipio;
    private BigDecimal codImColciencias;
    private BigDecimal codImFosyga;
    private BigDecimal codImMunicipio;
    private BigDecimal codAaColciencias;
    private BigDecimal codAaFosyga;
    private BigDecimal codAaMunicipio;
    private BigDecimal codRfColciencias;
    private BigDecimal codRfFosyga;
    private BigDecimal codRfMunicipio;
    private BigDecimal codDistrColciencias;
    
    
    /**
     * Constructor.
     */
    public ConsolidadoDistVO () {}
    
    
    
    /**
     * Constructor.
     * @param siiConsolidadoDist
     */
    public ConsolidadoDistVO(SiiConsolidadoDist siiConsolidadoDist) {
        this.codActuacAdmin     = siiConsolidadoDist.getCodActuacAdmin();
        this.codCodigo          = siiConsolidadoDist.getCodCodigo();
        this.codColciencias     = siiConsolidadoDist.getCodColciencias();
        this.codDistribFosyga   = siiConsolidadoDist.getCodDistribFosyga();
        this.codDistribMunicip  = siiConsolidadoDist.getCodDistribMunicip();
        this.codHipicosGallist  = siiConsolidadoDist.getCodHipicosGallist();
        this.codInteresFinanc   = siiConsolidadoDist.getCodInteresFinanc();
        this.codInteresMora     = siiConsolidadoDist.getCodInteresMora();
        this.codLegalizacAnticip= siiConsolidadoDist.getCodLegalizacAnticip();
        this.codLocMayCienDnp   = siiConsolidadoDist.getCodLocMayCienDnp();
        this.codLocalizMayCien  = siiConsolidadoDist.getCodLocalizMayCien();
        this.codLocalizMenCien  = siiConsolidadoDist.getCodLocalizMenCien();
        this.codPorcentajePart  = siiConsolidadoDist.getCodPorcentajePart();
        this.codPromocionales   = siiConsolidadoDist.getCodPromocionales();
        this.codRendimientosFin = siiConsolidadoDist.getCodRendimientosFin();
        this.codRifas           = siiConsolidadoDist.getCodRifas();
        this.codSubtotalTrans   = siiConsolidadoDist.getCodSubtotalTrans();
        this.codTotalControl    = siiConsolidadoDist.getCodTotalControl();
        this.codTotalTransf     = siiConsolidadoDist.getCodTotalTransf();
        this.codValorRecaudo    = siiConsolidadoDist.getCodValorRecaudo();
        this.codDerechosExpl    = siiConsolidadoDist.getCodDerechosExpl();
        this.codDeColciencias   = siiConsolidadoDist.getCodDeColciencias();
        this.codDeFosyga        = siiConsolidadoDist.getCodDeFosyga();
        this.codDeMunicipio     = siiConsolidadoDist.getCodDeMunicipio();
        this.codIfColciencias   = siiConsolidadoDist.getCodIfColciencias();
        this.codIfFosyga        = siiConsolidadoDist.getCodIfFosyga();
        this.codIfMunicipio     = siiConsolidadoDist.getCodIfMunicipio();
        this.codImColciencias   = siiConsolidadoDist.getCodImColciencias();
        this.codImFosyga        = siiConsolidadoDist.getCodImFosyga();
        this.codImMunicipio     = siiConsolidadoDist.getCodImMunicipio();
        this.codAaColciencias   = siiConsolidadoDist.getCodAaColciencias();
        this.codAaFosyga        = siiConsolidadoDist.getCodAaFosyga();
        this.codAaMunicipio     = siiConsolidadoDist.getCodAaMunicipio();
        this.codRfColciencias   = siiConsolidadoDist.getCodRfColciencias();
        this.codRfFosyga        = siiConsolidadoDist.getCodRfFosyga();
        this.codRfMunicipio     = siiConsolidadoDist.getCodRfMunicipio();
        this.codDistrColciencias= siiConsolidadoDist.getCodDistrColciencias();
        
        if(siiConsolidadoDist.getSiiDistribucionMes()!= null){
            this.distribucionMesVo = new DistribucionMesVO(siiConsolidadoDist.getSiiDistribucionMes());
        }
        
        if(siiConsolidadoDist.getSiiUbicacion()!= null){
            this.ubicacionVo = new UbicacionVO(siiConsolidadoDist.getSiiUbicacion());
        }
        
        if(siiConsolidadoDist.getSiiPersona() != null){
            this.personaVo = new PersonaVO(siiConsolidadoDist.getSiiPersona());
        }
    }

   
    public void setCodCodigo(Long codCodigo) {
        this.codCodigo = codCodigo;
    }

    public Long getCodCodigo() {
        return codCodigo;
    }

    public void setCodActuacAdmin(BigDecimal codActuacAdmin) {
        this.codActuacAdmin = codActuacAdmin;
    }

    public BigDecimal getCodActuacAdmin() {
        return codActuacAdmin;
    }

    public void setCodColciencias(BigDecimal codColciencias) {
        this.codColciencias = codColciencias;
    }

    public BigDecimal getCodColciencias() {
        return codColciencias;
    }

    public void setCodDistribFosyga(BigDecimal codDistribFosyga) {
        this.codDistribFosyga = codDistribFosyga;
    }

    public BigDecimal getCodDistribFosyga() {
        return codDistribFosyga;
    }

    public void setCodDistribMunicip(BigDecimal codDistribMunicip) {
        this.codDistribMunicip = codDistribMunicip;
    }

    public BigDecimal getCodDistribMunicip() {
        return codDistribMunicip;
    }

    public void setCodHipicosGallist(BigDecimal codHipicosGallist) {
        this.codHipicosGallist = codHipicosGallist;
    }

    public BigDecimal getCodHipicosGallist() {
        return codHipicosGallist;
    }

    public void setCodInteresFinanc(BigDecimal codInteresFinanc) {
        this.codInteresFinanc = codInteresFinanc;
    }

    public BigDecimal getCodInteresFinanc() {
        return codInteresFinanc;
    }

    public void setCodInteresMora(BigDecimal codInteresMora) {
        this.codInteresMora = codInteresMora;
    }

    public BigDecimal getCodInteresMora() {
        return codInteresMora;
    }

    public void setCodLegalizacAnticip(BigDecimal codLegalizacAnticip) {
        this.codLegalizacAnticip = codLegalizacAnticip;
    }

    public BigDecimal getCodLegalizacAnticip() {
        return codLegalizacAnticip;
    }

    public void setCodLocMayCienDnp(BigDecimal codLocMayCienDnp) {
        this.codLocMayCienDnp = codLocMayCienDnp;
    }

    public BigDecimal getCodLocMayCienDnp() {
        return codLocMayCienDnp;
    }

    public void setCodLocalizMayCien(BigDecimal codLocalizMayCien) {
        this.codLocalizMayCien = codLocalizMayCien;
    }

    public BigDecimal getCodLocalizMayCien() {
        return codLocalizMayCien;
    }

    public void setCodLocalizMenCien(BigDecimal codLocalizMenCien) {
        this.codLocalizMenCien = codLocalizMenCien;
    }

    public BigDecimal getCodLocalizMenCien() {
        return codLocalizMenCien;
    }

    public void setCodPorcentajePart(BigDecimal codPorcentajePart) {
        this.codPorcentajePart = codPorcentajePart;
    }

    public BigDecimal getCodPorcentajePart() {
        return codPorcentajePart;
    }

    public void setCodPromocionales(BigDecimal codPromocionales) {
        this.codPromocionales = codPromocionales;
    }

    public BigDecimal getCodPromocionales() {
        return codPromocionales;
    }

    public void setCodRendimientosFin(BigDecimal codRendimientosFin) {
        this.codRendimientosFin = codRendimientosFin;
    }

    public BigDecimal getCodRendimientosFin() {
        return codRendimientosFin;
    }

    public void setCodRifas(BigDecimal codRifas) {
        this.codRifas = codRifas;
    }

    public BigDecimal getCodRifas() {
        return codRifas;
    }

    public void setCodSubtotalTrans(BigDecimal codSubtotalTrans) {
        this.codSubtotalTrans = codSubtotalTrans;
    }

    public BigDecimal getCodSubtotalTrans() {
        return codSubtotalTrans;
    }

    public void setCodTotalControl(BigDecimal codTotalControl) {
        this.codTotalControl = codTotalControl;
    }

    public BigDecimal getCodTotalControl() {
        return codTotalControl;
    }

    public void setCodTotalTransf(BigDecimal codTotalTransf) {
        this.codTotalTransf = codTotalTransf;
    }

    public BigDecimal getCodTotalTransf() {
        return codTotalTransf;
    }

    public void setCodValorRecaudo(BigDecimal codValorRecaudo) {
        this.codValorRecaudo = codValorRecaudo;
    }

    public BigDecimal getCodValorRecaudo() {
        return codValorRecaudo;
    }

    public void setObligacionListVo(List<ObligacionVO> obligacionListVo) {
        this.obligacionListVo = obligacionListVo;
    }

    public List<ObligacionVO> getObligacionListVo() {
        return obligacionListVo;
    }

    public void setDistribucionMesVo(DistribucionMesVO distribucionMesVo) {
        this.distribucionMesVo = distribucionMesVo;
    }

    public DistribucionMesVO getDistribucionMesVo() {
        return distribucionMesVo;
    }

    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }


    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }
	
	    public void setCodDerechosExpl(BigDecimal codDerechosExpl) {
        this.codDerechosExpl = codDerechosExpl;
    }

    public BigDecimal getCodDerechosExpl() {
        return codDerechosExpl;
    }

    public void setCodDeColciencias(BigDecimal codDeColciencias) {
        this.codDeColciencias = codDeColciencias;
    }

    public BigDecimal getCodDeColciencias() {
        return codDeColciencias;
    }

    public void setCodDeFosyga(BigDecimal codDeFosyga) {
        this.codDeFosyga = codDeFosyga;
    }

    public BigDecimal getCodDeFosyga() {
        return codDeFosyga;
    }

    public void setCodDeMunicipio(BigDecimal codDeMunicipio) {
        this.codDeMunicipio = codDeMunicipio;
    }

    public BigDecimal getCodDeMunicipio() {
        return codDeMunicipio;
    }

    public void setCodIfColciencias(BigDecimal codIfColciencias) {
        this.codIfColciencias = codIfColciencias;
    }

    public BigDecimal getCodIfColciencias() {
        return codIfColciencias;
    }

    public void setCodIfFosyga(BigDecimal codIfFosyga) {
        this.codIfFosyga = codIfFosyga;
    }

    public BigDecimal getCodIfFosyga() {
        return codIfFosyga;
    }

    public void setCodIfMunicipio(BigDecimal codIfMunicipio) {
        this.codIfMunicipio = codIfMunicipio;
    }

    public BigDecimal getCodIfMunicipio() {
        return codIfMunicipio;
    }

    public void setCodImColciencias(BigDecimal codImColciencias) {
        this.codImColciencias = codImColciencias;
    }

    public BigDecimal getCodImColciencias() {
        return codImColciencias;
    }

    public void setCodImFosyga(BigDecimal codImFosyga) {
        this.codImFosyga = codImFosyga;
    }

    public BigDecimal getCodImFosyga() {
        return codImFosyga;
    }

    public void setCodImMunicipio(BigDecimal codImMunicipio) {
        this.codImMunicipio = codImMunicipio;
    }

    public BigDecimal getCodImMunicipio() {
        return codImMunicipio;
    }

    public void setCodAaColciencias(BigDecimal codAaColciencias) {
        this.codAaColciencias = codAaColciencias;
    }

    public BigDecimal getCodAaColciencias() {
        return codAaColciencias;
    }

    public void setCodAaFosyga(BigDecimal codAaFosyga) {
        this.codAaFosyga = codAaFosyga;
    }

    public BigDecimal getCodAaFosyga() {
        return codAaFosyga;
    }

    public void setCodAaMunicipio(BigDecimal codAaMunicipio) {
        this.codAaMunicipio = codAaMunicipio;
    }

    public BigDecimal getCodAaMunicipio() {
        return codAaMunicipio;
    }

    public void setCodRfColciencias(BigDecimal codRfColciencias) {
        this.codRfColciencias = codRfColciencias;
    }

    public BigDecimal getCodRfColciencias() {
        return codRfColciencias;
    }

    public void setCodRfFosyga(BigDecimal codRfFosyga) {
        this.codRfFosyga = codRfFosyga;
    }

    public BigDecimal getCodRfFosyga() {
        return codRfFosyga;
    }

    public void setCodRfMunicipio(BigDecimal codRfMunicipio) {
        this.codRfMunicipio = codRfMunicipio;
    }

    public BigDecimal getCodRfMunicipio() {
        return codRfMunicipio;
    }

    public void setCodDistrColciencias(BigDecimal codDistrColciencias) {
        this.codDistrColciencias = codDistrColciencias;
    }

    public BigDecimal getCodDistrColciencias() {
        return codDistrColciencias;
    }

}
