package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_REPORTE_VENTAS")
public class SiiReporteVentas implements Serializable {
    private static final long serialVersionUID = -6273520315049796387L;
    private Long rveCodigo;
    private Date rveFecha;
    private BigDecimal rveInteresDe;
    private BigDecimal rveInteresGa;
    private Long rveMovimiento;
    private Integer rveNumRegistros;
    private String rveTipoReporte;
    private BigDecimal rveValorDe;
    private BigDecimal rveValorGa;
    private BigDecimal rveValorTotVentas;
    private Integer rveVigencia;
    private List<SiiVentasMet> siiVentasMetList;
    private List<SiiModificaVentasMet> siiModificaVentasMetList;
    private SiiMes siiMes;
    private SiiContrato siiContrato;
    private List<SiiLiquidacionMes> siiLiquidacionMesList;

    public SiiReporteVentas() {
    }

    public SiiReporteVentas(SiiContrato siiContrato, SiiMes siiMes, Long rveCodigo, Date rveFecha, BigDecimal rveInteresDe, BigDecimal rveInteresGa, Long rveMovimiento, Integer rveNumRegistros,
                            String rveTipoReporte, BigDecimal rveValorDe, BigDecimal rveValorGa, BigDecimal rveValorTotVentas, Integer rveVigencia) {
        this.siiContrato = siiContrato;
        this.siiMes = siiMes;
        this.rveCodigo = rveCodigo;
        this.rveFecha = rveFecha;
        this.rveInteresDe = rveInteresDe;
        this.rveInteresGa = rveInteresGa;
        this.rveMovimiento = rveMovimiento;
        this.rveNumRegistros = rveNumRegistros;
        this.rveTipoReporte = rveTipoReporte;
        this.rveValorDe = rveValorDe;
        this.rveValorGa = rveValorGa;
        this.rveValorTotVentas = rveValorTotVentas;
        this.rveVigencia = rveVigencia;
    }


    @Id
    @Column(name = "RVE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REPORTE_VENTAS_COD")
    @SequenceGenerator(name = "SEQ_REPORTE_VENTAS_COD", sequenceName = "SEQ_REPORTE_VENTAS_COD",allocationSize=1)
    public Long getRveCodigo() {
        return rveCodigo;
    }

    public void setRveCodigo(Long rveCodigo) {
        this.rveCodigo = rveCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RVE_FECHA", nullable = false)
    public Date getRveFecha() {
        return rveFecha;
    }

    public void setRveFecha(Date rveFecha) {
        this.rveFecha = rveFecha;
    }

    @Column(name = "RVE_INTERES_DE")
    public BigDecimal getRveInteresDe() {
        return rveInteresDe;
    }

    public void setRveInteresDe(BigDecimal rveInteresDe) {
        this.rveInteresDe = rveInteresDe;
    }

    @Column(name = "RVE_INTERES_GA")
    public BigDecimal getRveInteresGa() {
        return rveInteresGa;
    }

    public void setRveInteresGa(BigDecimal rveInteresGa) {
        this.rveInteresGa = rveInteresGa;
    }

    @Column(name = "RVE_MOVIMIENTO", nullable = false)
    public Long getRveMovimiento() {
        return rveMovimiento;
    }

    public void setRveMovimiento(Long rveMovimiento) {
        this.rveMovimiento = rveMovimiento;
    }

    @Column(name = "RVE_NUM_REGISTROS", nullable = false)
    public Integer getRveNumRegistros() {
        return rveNumRegistros;
    }

    public void setRveNumRegistros(Integer rveNumRegistros) {
        this.rveNumRegistros = rveNumRegistros;
    }

    @Column(name = "RVE_TIPO_REPORTE", nullable = false, length = 5)
    public String getRveTipoReporte() {
        return rveTipoReporte;
    }

    public void setRveTipoReporte(String rveTipoReporte) {
        this.rveTipoReporte = rveTipoReporte;
    }

    @Column(name = "RVE_VALOR_DE")
    public BigDecimal getRveValorDe() {
        return rveValorDe;
    }

    public void setRveValorDe(BigDecimal rveValorDe) {
        this.rveValorDe = rveValorDe;
    }

    @Column(name = "RVE_VALOR_GA")
    public BigDecimal getRveValorGa() {
        return rveValorGa;
    }

    public void setRveValorGa(BigDecimal rveValorGa) {
        this.rveValorGa = rveValorGa;
    }

    @Column(name = "RVE_VALOR_TOT_VENTAS", nullable = false)
    public BigDecimal getRveValorTotVentas() {
        return rveValorTotVentas;
    }

    public void setRveValorTotVentas(BigDecimal rveValorTotVentas) {
        this.rveValorTotVentas = rveValorTotVentas;
    }

    @Column(name = "RVE_VIGENCIA", nullable = false)
    public Integer getRveVigencia() {
        return rveVigencia;
    }

    public void setRveVigencia(Integer rveVigencia) {
        this.rveVigencia = rveVigencia;
    }

    @OneToMany(mappedBy = "siiReporteVentas")
    public List<SiiVentasMet> getSiiVentasMetList() {
        return siiVentasMetList;
    }

    public void setSiiVentasMetList(List<SiiVentasMet> siiVentasMetList) {
        this.siiVentasMetList = siiVentasMetList;
    }

    public SiiVentasMet addSiiVentasMet(SiiVentasMet siiVentasMet) {
        getSiiVentasMetList().add(siiVentasMet);
        siiVentasMet.setSiiReporteVentas(this);
        return siiVentasMet;
    }

    public SiiVentasMet removeSiiVentasMet(SiiVentasMet siiVentasMet) {
        getSiiVentasMetList().remove(siiVentasMet);
        siiVentasMet.setSiiReporteVentas(null);
        return siiVentasMet;
    }

    @OneToMany(mappedBy = "siiReporteVentas")
    public List<SiiModificaVentasMet> getSiiModificaVentasMetList() {
        return siiModificaVentasMetList;
    }

    public void setSiiModificaVentasMetList(List<SiiModificaVentasMet> siiModificaVentasMetList) {
        this.siiModificaVentasMetList = siiModificaVentasMetList;
    }

    public SiiModificaVentasMet addSiiModificaVentasMet(SiiModificaVentasMet siiModificaVentasMet) {
        getSiiModificaVentasMetList().add(siiModificaVentasMet);
        siiModificaVentasMet.setSiiReporteVentas(this);
        return siiModificaVentasMet;
    }

    public SiiModificaVentasMet removeSiiModificaVentasMet(SiiModificaVentasMet siiModificaVentasMet) {
        getSiiModificaVentasMetList().remove(siiModificaVentasMet);
        siiModificaVentasMet.setSiiReporteVentas(null);
        return siiModificaVentasMet;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }


    @OneToMany(mappedBy = "siiReporteVentas")
    public List<SiiLiquidacionMes> getSiiLiquidacionMesList(){
        return siiLiquidacionMesList;
    }

    public void setSiiLiquidacionMesList(List<SiiLiquidacionMes> siiLiquidacionMesList){
        this.siiLiquidacionMesList = siiLiquidacionMesList;
    }

    public SiiLiquidacionMes addSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes){
        getSiiLiquidacionMesList().add(siiLiquidacionMes);
        siiLiquidacionMes.setSiiReporteVentas(this);
        return siiLiquidacionMes;
    }

    public SiiLiquidacionMes removeSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes){
        getSiiLiquidacionMesList().remove(siiLiquidacionMes);
        siiLiquidacionMes.setSiiReporteVentas(null);
        return siiLiquidacionMes;
    }
}
