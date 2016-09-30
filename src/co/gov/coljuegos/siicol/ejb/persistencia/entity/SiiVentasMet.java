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
@Table(name = "SII_VENTAS_MET")
public class SiiVentasMet implements Serializable {
    private static final long serialVersionUID = -3672258354521122747L;
    private Long vmeCodigo;
    private Integer vmeDiasRepor;
    private BigDecimal vmeValorCorrec;
    private BigDecimal vmeValorInicial;
    private BigDecimal vmeValorModif;
    private BigDecimal vmeLiqTarifaFija;
    private BigDecimal vmeLiqTarifaVar;
    private BigDecimal vmeLiqEfectiva;
    private Integer vmeVigencia;
    private SiiReporteVentas siiReporteVentas;
    private SiiInventario siiInventario;
    private SiiMet siiMet;
    private SiiMes siiMes;
    private List<SiiModificaVentasMet> siiModificaVentasMetList;
    private BigDecimal vmeValorConsulta;
    private SiiContrato siiContrato;
    public SiiVentasMet() {
    }

    public SiiVentasMet(SiiMes siiMes, SiiReporteVentas siiReporteVentas, Long vmeCodigo, Integer vmeDiasRepor, BigDecimal vmeValorCorrec,
                        BigDecimal vmeValorInicial, BigDecimal vmeValorModif, Integer vmeVigencia) {
        this.siiMes = siiMes;
        this.siiReporteVentas = siiReporteVentas;
        this.vmeCodigo = vmeCodigo;
        this.vmeDiasRepor = vmeDiasRepor;
        this.vmeValorCorrec = vmeValorCorrec;
        this.vmeValorInicial = vmeValorInicial;
        this.vmeValorModif = vmeValorModif;
        this.vmeVigencia = vmeVigencia;
    }

    @Id
    @Column(name = "VME_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_VENTAS_MET_COD")
    @SequenceGenerator(name = "SEQ_VENTAS_MET_COD", sequenceName = "SEQ_VENTAS_MET_COD",allocationSize=1)
    public Long getVmeCodigo() {
        return vmeCodigo;
    }

    public void setVmeCodigo(Long vmeCodigo) {
        this.vmeCodigo = vmeCodigo;
    }

    @Column(name = "VME_DIAS_REPOR", nullable = false)
    public Integer getVmeDiasRepor() {
        return vmeDiasRepor;
    }

    public void setVmeDiasRepor(Integer vmeDiasRepor) {
        this.vmeDiasRepor = vmeDiasRepor;
    }

    @Column(name = "VME_VALOR_CORREC")
    public BigDecimal getVmeValorCorrec() {
        return vmeValorCorrec;
    }

    public void setVmeValorCorrec(BigDecimal vmeValorCorrec) {
        this.vmeValorCorrec = vmeValorCorrec;
    }

    @Column(name = "VME_VALOR_INICIAL", nullable = false)
    public BigDecimal getVmeValorInicial() {
        return vmeValorInicial;
    }

    public void setVmeValorInicial(BigDecimal vmeValorInicial) {
        this.vmeValorInicial = vmeValorInicial;
    }

    @Column(name = "VME_VALOR_MODIF")
    public BigDecimal getVmeValorModif() {
        return vmeValorModif;
    }

    public void setVmeValorModif(BigDecimal vmeValorModif) {
        this.vmeValorModif = vmeValorModif;
    }

    @Column(name = "VME_VIGENCIA", nullable = false)
    public Integer getVmeVigencia() {
        return vmeVigencia;
    }

    public void setVmeVigencia(Integer vmeVigencia) {
        this.vmeVigencia = vmeVigencia;
    }

    @ManyToOne
    @JoinColumn(name = "RVE_CODIGO")
    public SiiReporteVentas getSiiReporteVentas() {
        return siiReporteVentas;
    }

    public void setSiiReporteVentas(SiiReporteVentas siiReporteVentas) {
        this.siiReporteVentas = siiReporteVentas;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @OneToMany(mappedBy = "siiVentasMet")
    public List<SiiModificaVentasMet> getSiiModificaVentasMetList() {
        return siiModificaVentasMetList;
    }

    public void setSiiModificaVentasMetList(List<SiiModificaVentasMet> siiModificaVentasMetList) {
        this.siiModificaVentasMetList = siiModificaVentasMetList;
    }

    public SiiModificaVentasMet addSiiModificaVentasMet(SiiModificaVentasMet siiModificaVentasMet) {
        getSiiModificaVentasMetList().add(siiModificaVentasMet);
        siiModificaVentasMet.setSiiVentasMet(this);
        return siiModificaVentasMet;
    }

    public SiiModificaVentasMet removeSiiModificaVentasMet(SiiModificaVentasMet siiModificaVentasMet) {
        getSiiModificaVentasMetList().remove(siiModificaVentasMet);
        siiModificaVentasMet.setSiiVentasMet(null);
        return siiModificaVentasMet;
    }
    
    @ManyToOne
    @JoinColumn(name = "INV_CODIGO")
    public SiiInventario getSiiInventario() {
        return siiInventario;
    }

    public void setSiiInventario(SiiInventario siiInventario) {
        this.siiInventario = siiInventario;
    }

    @ManyToOne
    @JoinColumn(name = "MET_CODIGO")
    public SiiMet getSiiMet() {
        return siiMet;
    }

    public void setSiiMet(SiiMet siiMet) {
        this.siiMet = siiMet;
    }

    @Column(name = "VME_LIQ_TARIFA_FIJA")
    public BigDecimal getVmeLiqTarifaFija() {
        return vmeLiqTarifaFija;
    }
    
    public void setVmeLiqTarifaFija(BigDecimal vmeLiqTarifaFija) {
        this.vmeLiqTarifaFija = vmeLiqTarifaFija;
    }

    @Column(name = "VME_LIQ_TARIFA_VAR")
    public BigDecimal getVmeLiqTarifaVar() {
        return vmeLiqTarifaVar;
    }
    
    public void setVmeLiqTarifaVar(BigDecimal vmeLiqTarifaVar) {
        this.vmeLiqTarifaVar = vmeLiqTarifaVar;
    }

    @Column(name = "VME_LIQ_EFECTIVA")
    public BigDecimal getVmeLiqEfectiva() {
        return vmeLiqEfectiva;
    }
    
    public void setVmeLiqEfectiva(BigDecimal vmeLiqEfectiva) {
        this.vmeLiqEfectiva = vmeLiqEfectiva;
    }

    @Column(name = "VME_VALOR_CONSULTA")
    public BigDecimal getVmeValorConsulta() {
        return vmeValorConsulta;
    }
    
    public void setVmeValorConsulta(BigDecimal vmeValorConsulta) {
        this.vmeValorConsulta = vmeValorConsulta;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato(){
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato){
        this.siiContrato = siiContrato;
    }


    
}
