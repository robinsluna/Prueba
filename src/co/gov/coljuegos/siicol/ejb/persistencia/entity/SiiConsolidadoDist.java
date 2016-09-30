package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CONSOLIDADO_DIST")
public class SiiConsolidadoDist implements Serializable {
    private static final Long serialVersionUID = 8267900680835471823L;
    private BigDecimal codActuacAdmin;
    private Long codCodigo;
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
    private List<SiiObligacion> siiObligacionList;
    private SiiDistribucionMes siiDistribucionMes;
    private SiiUbicacion siiUbicacion;
    private SiiPersona siiPersona;
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

    public SiiConsolidadoDist() {
    }

    public SiiConsolidadoDist(BigDecimal codActuacAdmin, Long codCodigo, BigDecimal codColciencias, BigDecimal codDistribFosyga,
                              BigDecimal codDistribMunicip, BigDecimal codHipicosGallist, BigDecimal codInteresFinanc,
                              BigDecimal codInteresMora, BigDecimal codLegalizacAnticip, BigDecimal codLocMayCienDnp,
                              BigDecimal codLocalizMayCien, BigDecimal codLocalizMenCien, BigDecimal codPorcentajePart,
                              BigDecimal codPromocionales, BigDecimal codRendimientosFin, BigDecimal codRifas, BigDecimal codSubtotalTrans,
                              BigDecimal codTotalControl, BigDecimal codTotalTransf, BigDecimal codValorRecaudo,
                              SiiDistribucionMes siiDistribucionMes, SiiUbicacion siiUbicacion) {
        this.codActuacAdmin = codActuacAdmin;
        this.codCodigo = codCodigo;
        this.codColciencias = codColciencias;
        this.codDistribFosyga = codDistribFosyga;
        this.codDistribMunicip = codDistribMunicip;
        this.codHipicosGallist = codHipicosGallist;
        this.codInteresFinanc = codInteresFinanc;
        this.codInteresMora = codInteresMora;
        this.codLegalizacAnticip = codLegalizacAnticip;
        this.codLocMayCienDnp = codLocMayCienDnp;
        this.codLocalizMayCien = codLocalizMayCien;
        this.codLocalizMenCien = codLocalizMenCien;
        this.codPorcentajePart = codPorcentajePart;
        this.codPromocionales = codPromocionales;
        this.codRendimientosFin = codRendimientosFin;
        this.codRifas = codRifas;
        this.codSubtotalTrans = codSubtotalTrans;
        this.codTotalControl = codTotalControl;
        this.codTotalTransf = codTotalTransf;
        this.codValorRecaudo = codValorRecaudo;
        this.siiDistribucionMes = siiDistribucionMes;
        this.siiUbicacion = siiUbicacion;
    }

    @Column(name = "COD_ACTUAC_ADMIN", nullable = false)
    public BigDecimal getCodActuacAdmin() {
        return codActuacAdmin;
    }

    public void setCodActuacAdmin(BigDecimal codActuacAdmin) {
        this.codActuacAdmin = codActuacAdmin;
    }

    @Id
    @Column(name = "COD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONSOLIDADO_DIST_COD")
    @SequenceGenerator(name = "SEQ_CONSOLIDADO_DIST_COD", sequenceName = "SEQ_CONSOLIDADO_DIST_COD",allocationSize=1)
    public Long getCodCodigo() {
        return codCodigo;
    }

    public void setCodCodigo(Long codCodigo) {
        this.codCodigo = codCodigo;
    }

    @Column(name = "COD_COLCIENCIAS", nullable = false)
    public BigDecimal getCodColciencias() {
        return codColciencias;
    }

    public void setCodColciencias(BigDecimal codColciencias) {
        this.codColciencias = codColciencias;
    }

    @Column(name = "COD_DISTRIB_FOSYGA", nullable = false)
    public BigDecimal getCodDistribFosyga() {
        return codDistribFosyga;
    }

    public void setCodDistribFosyga(BigDecimal codDistribFosyga) {
        this.codDistribFosyga = codDistribFosyga;
    }

    @Column(name = "COD_DISTRIB_MUNICIP", nullable = false)
    public BigDecimal getCodDistribMunicip() {
        return codDistribMunicip;
    }

    public void setCodDistribMunicip(BigDecimal codDistribMunicip) {
        this.codDistribMunicip = codDistribMunicip;
    }

    @Column(name = "COD_HIPICOS_GALLIST", nullable = false)
    public BigDecimal getCodHipicosGallist() {
        return codHipicosGallist;
    }

    public void setCodHipicosGallist(BigDecimal codHipicosGallist) {
        this.codHipicosGallist = codHipicosGallist;
    }

    @Column(name = "COD_INTERES_FINANC", nullable = false)
    public BigDecimal getCodInteresFinanc() {
        return codInteresFinanc;
    }

    public void setCodInteresFinanc(BigDecimal codInteresFinanc) {
        this.codInteresFinanc = codInteresFinanc;
    }

    @Column(name = "COD_INTERES_MORA", nullable = false)
    public BigDecimal getCodInteresMora() {
        return codInteresMora;
    }

    public void setCodInteresMora(BigDecimal codInteresMora) {
        this.codInteresMora = codInteresMora;
    }

    @Column(name = "COD_LEGALIZAC_ANTICIP")
    public BigDecimal getCodLegalizacAnticip() {
        return codLegalizacAnticip;
    }

    public void setCodLegalizacAnticip(BigDecimal codLegalizacAnticip) {
        this.codLegalizacAnticip = codLegalizacAnticip;
    }

    @Column(name = "COD_LOC_MAY_CIEN_DNP")
    public BigDecimal getCodLocMayCienDnp() {
        return codLocMayCienDnp;
    }

    public void setCodLocMayCienDnp(BigDecimal codLocMayCienDnp) {
        this.codLocMayCienDnp = codLocMayCienDnp;
    }

    @Column(name = "COD_LOCALIZ_MAY_CIEN")
    public BigDecimal getCodLocalizMayCien() {
        return codLocalizMayCien;
    }

    public void setCodLocalizMayCien(BigDecimal codLocalizMayCien) {
        this.codLocalizMayCien = codLocalizMayCien;
    }

    @Column(name = "COD_LOCALIZ_MEN_CIEN")
    public BigDecimal getCodLocalizMenCien() {
        return codLocalizMenCien;
    }

    public void setCodLocalizMenCien(BigDecimal codLocalizMenCien) {
        this.codLocalizMenCien = codLocalizMenCien;
    }

    @Column(name = "COD_PORCENTAJE_PART", nullable = false)
    public BigDecimal getCodPorcentajePart() {
        return codPorcentajePart;
    }

    public void setCodPorcentajePart(BigDecimal codPorcentajePart) {
        this.codPorcentajePart = codPorcentajePart;
    }

    @Column(name = "COD_PROMOCIONALES", nullable = false)
    public BigDecimal getCodPromocionales() {
        return codPromocionales;
    }

    public void setCodPromocionales(BigDecimal codPromocionales) {
        this.codPromocionales = codPromocionales;
    }

    @Column(name = "COD_RENDIMIENTOS_FIN", nullable = false)
    public BigDecimal getCodRendimientosFin() {
        return codRendimientosFin;
    }

    public void setCodRendimientosFin(BigDecimal codRendimientosFin) {
        this.codRendimientosFin = codRendimientosFin;
    }

    @Column(name = "COD_RIFAS", nullable = false)
    public BigDecimal getCodRifas() {
        return codRifas;
    }

    public void setCodRifas(BigDecimal codRifas) {
        this.codRifas = codRifas;
    }

    @Column(name = "COD_SUBTOTAL_TRANS", nullable = false)
    public BigDecimal getCodSubtotalTrans() {
        return codSubtotalTrans;
    }

    public void setCodSubtotalTrans(BigDecimal codSubtotalTrans) {
        this.codSubtotalTrans = codSubtotalTrans;
    }

    @Column(name = "COD_TOTAL_CONTROL", nullable = false)
    public BigDecimal getCodTotalControl() {
        return codTotalControl;
    }

    public void setCodTotalControl(BigDecimal codTotalControl) {
        this.codTotalControl = codTotalControl;
    }

    @Column(name = "COD_TOTAL_TRANSF", nullable = false)
    public BigDecimal getCodTotalTransf() {
        return codTotalTransf;
    }

    public void setCodTotalTransf(BigDecimal codTotalTransf) {
        this.codTotalTransf = codTotalTransf;
    }

    @Column(name = "COD_VALOR_RECAUDO", nullable = false)
    public BigDecimal getCodValorRecaudo() {
        return codValorRecaudo;
    }

    public void setCodValorRecaudo(BigDecimal codValorRecaudo) {
        this.codValorRecaudo = codValorRecaudo;
    }


    @OneToMany(mappedBy = "siiConsolidadoDist")
    public List<SiiObligacion> getSiiObligacionList() {
        return siiObligacionList;
    }

    public void setSiiObligacionList(List<SiiObligacion> siiObligacionList) {
        this.siiObligacionList = siiObligacionList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().add(siiObligacion);
        siiObligacion.setSiiConsolidadoDist(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().remove(siiObligacion);
        siiObligacion.setSiiConsolidadoDist(null);
        return siiObligacion;
    }

    @ManyToOne
    @JoinColumn(name = "DME_CODIGO")
    public SiiDistribucionMes getSiiDistribucionMes() {
        return siiDistribucionMes;
    }

    public void setSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        this.siiDistribucionMes = siiDistribucionMes;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO")
    public SiiUbicacion getSiiUbicacion() {
        return siiUbicacion;
    }

    public void setSiiUbicacion(SiiUbicacion siiUbicacion) {
        this.siiUbicacion = siiUbicacion;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }
    
    @Column(name = "COD_AA_COLCIENCIAS")
    public BigDecimal getCodAaColciencias() {
        return codAaColciencias;
    }

    public void setCodAaColciencias(BigDecimal codAaColciencias) {
        this.codAaColciencias = codAaColciencias;
    }

    @Column(name = "COD_AA_FOSYGA")
    public BigDecimal getCodAaFosyga() {
        return codAaFosyga;
    }

    public void setCodAaFosyga(BigDecimal codAaFosyga) {
        this.codAaFosyga = codAaFosyga;
    }

    @Column(name = "COD_AA_MUNICIPIO")
    public BigDecimal getCodAaMunicipio() {
        return codAaMunicipio;
    }

    public void setCodAaMunicipio(BigDecimal codAaMunicipio) {
        this.codAaMunicipio = codAaMunicipio;
    }

    @Column(name = "COD_IF_COLCIENCIAS")
    public BigDecimal getCodIfColciencias() {
        return codIfColciencias;
    }

    public void setCodIfColciencias(BigDecimal codIfColciencias) {
        this.codIfColciencias = codIfColciencias;
    }

    @Column(name = "COD_IF_FOSYGA")
    public BigDecimal getCodIfFosyga() {
        return codIfFosyga;
    }

    public void setCodIfFosyga(BigDecimal codIfFosyga) {
        this.codIfFosyga = codIfFosyga;
    }

    @Column(name = "COD_IF_MUNICIPIO")
    public BigDecimal getCodIfMunicipio() {
        return codIfMunicipio;
    }

    public void setCodIfMunicipio(BigDecimal codIfMunicipio) {
        this.codIfMunicipio = codIfMunicipio;
    }

    @Column(name = "COD_IM_COLCIENCIAS")
    public BigDecimal getCodImColciencias() {
        return codImColciencias;
    }

    public void setCodImColciencias(BigDecimal codImColciencias) {
        this.codImColciencias = codImColciencias;
    }

    @Column(name = "COD_IM_FOSYGA")
    public BigDecimal getCodImFosyga() {
        return codImFosyga;
    }

    public void setCodImFosyga(BigDecimal codImFosyga) {
        this.codImFosyga = codImFosyga;
    }

    @Column(name = "COD_IM_MUNICIPIO")
    public BigDecimal getCodImMunicipio() {
        return codImMunicipio;
    }

    public void setCodImMunicipio(BigDecimal codImMunicipio) {
        this.codImMunicipio = codImMunicipio;
    }
    
    @Column(name = "COD_RF_COLCIENCIAS")
    public BigDecimal getCodRfColciencias() {
        return codRfColciencias;
    }

    public void setCodRfColciencias(BigDecimal codRfColciencias) {
        this.codRfColciencias = codRfColciencias;
    }

    @Column(name = "COD_RF_FOSYGA")
    public BigDecimal getCodRfFosyga() {
        return codRfFosyga;
    }

    public void setCodRfFosyga(BigDecimal codRfFosyga) {
        this.codRfFosyga = codRfFosyga;
    }

    @Column(name = "COD_RF_MUNICIPIO")
    public BigDecimal getCodRfMunicipio() {
        return codRfMunicipio;
    }

    public void setCodRfMunicipio(BigDecimal codRfMunicipio) {
        this.codRfMunicipio = codRfMunicipio;
    }
    
    @Column(name = "COD_DE_COLCIENCIAS")
    public BigDecimal getCodDeColciencias() {
        return codDeColciencias;
    }

    public void setCodDeColciencias(BigDecimal codDeColciencias) {
        this.codDeColciencias = codDeColciencias;
    }

    @Column(name = "COD_DE_FOSYGA")
    public BigDecimal getCodDeFosyga() {
        return codDeFosyga;
    }

    public void setCodDeFosyga(BigDecimal codDeFosyga) {
        this.codDeFosyga = codDeFosyga;
    }

    @Column(name = "COD_DE_MUNICIPIO")
    public BigDecimal getCodDeMunicipio() {
        return codDeMunicipio;
    }

    public void setCodDeMunicipio(BigDecimal codDeMunicipio) {
        this.codDeMunicipio = codDeMunicipio;
    }
    @Column(name = "COD_DISTR_COLCIENCIAS")
    public BigDecimal getCodDistrColciencias() {
        return codDistrColciencias;
    }

    public void setCodDistrColciencias(BigDecimal codDistrColciencias) {
        this.codDistrColciencias = codDistrColciencias;
    }

    @Column(name = "COD_DERECHOS_EXPL")
    public BigDecimal getCodDerechosExpl() {
        return codDerechosExpl;
    }

    public void setCodDerechosExpl(BigDecimal codDerechosExpl) {
        this.codDerechosExpl = codDerechosExpl;
    }

}
