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
@Table(name = "SII_DETALLE_DECLARACION")
public class SiiDetalleDeclaracion implements Serializable {
    private static final long serialVersionUID = -6083876710815270178L;
    private Long ddeBaseCalcInt;
    private Long ddeCodigo;
    private Integer ddeDiasInteres;
    private BigDecimal ddeValorDeclarado;
    private BigDecimal ddeValorInter;
    private BigDecimal ddeValorPagado;
    private BigDecimal ddeValorPagInt;
    private SiiCuotaOperador siiCuotaOperador;
    private SiiDeclaracionOperador siiDeclaracionOperador;
    private SiiReferenciaPagoDecl siiReferenciaPagoDecl;
    private SiiDetalleRecaudo siiDetalleRecaudo;
    private List<SiiRecaudoEstablec> siiRecaudoEstablecList;
    private SiiDistribucionMes siiDistribucionMes;
    private String ddeEstado;
    private List<SiiAsignacionRecaudo> siiAsignacionRecaudoList;

    public SiiDetalleDeclaracion() {
    }

    public SiiDetalleDeclaracion(SiiCuotaOperador siiCuotaOperador, Long ddeBaseCalcInt, Long ddeCodigo,
                                 Integer ddeDiasInteres, BigDecimal ddeValorInter, BigDecimal ddeValorPagInt, BigDecimal ddeValorPagado,
                                 SiiDeclaracionOperador siiDeclaracionOperador, BigDecimal ddeValorDeclarado,
						SiiReferenciaPagoDecl siiReferenciaPagoDecl, SiiDetalleRecaudo siiDetalleRecaudo) {
        this.siiCuotaOperador = siiCuotaOperador;
        this.ddeBaseCalcInt = ddeBaseCalcInt;
        this.ddeCodigo = ddeCodigo;
        this.ddeDiasInteres = ddeDiasInteres;
        this.ddeValorDeclarado = ddeValorDeclarado;
        this.ddeValorInter = ddeValorInter;
        this.ddeValorPagInt = ddeValorPagInt;
        this.ddeValorPagado = ddeValorPagado;
        this.siiDeclaracionOperador = siiDeclaracionOperador;
        this.siiReferenciaPagoDecl = siiReferenciaPagoDecl;
        this.siiDetalleRecaudo = siiDetalleRecaudo;

    }


    @Column(name = "DDE_BASE_CALC_INT", nullable = false)
    public Long getDdeBaseCalcInt() {
        return ddeBaseCalcInt;
    }

    public void setDdeBaseCalcInt(Long ddeBaseCalcInt) {
        this.ddeBaseCalcInt = ddeBaseCalcInt;
    }

    @Id
    @Column(name = "DDE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DETALLE_DECLARAC_COD")
    @SequenceGenerator(name = "SEQ_DETALLE_DECLARAC_COD", sequenceName = "SEQ_DETALLE_DECLARAC_COD",allocationSize=1)
    public Long getDdeCodigo() {
        return ddeCodigo;
    }

    public void setDdeCodigo(Long ddeCodigo) {
        this.ddeCodigo = ddeCodigo;
    }

    @Column(name = "DDE_DIAS_INTERES", nullable = false)
    public Integer getDdeDiasInteres() {
        return ddeDiasInteres;
    }

    public void setDdeDiasInteres(Integer ddeDiasInteres) {
        this.ddeDiasInteres = ddeDiasInteres;
    }

    @Column(name = "DDE_VALOR_INTER", nullable = false)
    public BigDecimal getDdeValorInter() {
        return ddeValorInter;
    }

    public void setDdeValorInter(BigDecimal ddeValorInter) {
        this.ddeValorInter = ddeValorInter;
    }

    @Column(name = "DDE_VALOR_PAGADO", nullable = false)
    public BigDecimal getDdeValorPagado() {
        return ddeValorPagado;
    }

    public void setDdeValorPagado(BigDecimal ddeValorPagado) {
        this.ddeValorPagado = ddeValorPagado;
    }

    @Column(name = "DDE_VALOR_PAG_INT", nullable = false)
    public BigDecimal getDdeValorPagInt() {
        return ddeValorPagInt;
    }

    public void setDdeValorPagInt(BigDecimal ddeValorPagInt) {
        this.ddeValorPagInt = ddeValorPagInt;
    }


    @ManyToOne
    @JoinColumn(name = "COP_CODIGO", updatable=false)
    public SiiCuotaOperador getSiiCuotaOperador() {
        return siiCuotaOperador;
    }

    public void setSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        this.siiCuotaOperador = siiCuotaOperador;
    }

    @ManyToOne
    @JoinColumn(name = "DOP_CODIGO", updatable=false)
    public SiiDeclaracionOperador getSiiDeclaracionOperador() {
        return siiDeclaracionOperador;
    }

    public void setSiiDeclaracionOperador(SiiDeclaracionOperador siiDeclaracionOperador) {
        this.siiDeclaracionOperador = siiDeclaracionOperador;
    }


    @Column(name = "DDE_VALOR_DECLARADO", nullable = false)
    public BigDecimal getDdeValorDeclarado() {
        return ddeValorDeclarado;
    }

    public void setDdeValorDeclarado(BigDecimal ddeValorDeclarado) {
        this.ddeValorDeclarado = ddeValorDeclarado;
    }

    @ManyToOne
    @JoinColumn(name = "RPD_CODIGO")
    public SiiReferenciaPagoDecl getSiiReferenciaPagoDecl() {
        return siiReferenciaPagoDecl;
    }

    public void setSiiReferenciaPagoDecl(SiiReferenciaPagoDecl siiReferenciaPagoDecl) {
        this.siiReferenciaPagoDecl = siiReferenciaPagoDecl;
    }

    @ManyToOne
    @JoinColumn(name = "DRE_CODIGO")
    public SiiDetalleRecaudo getSiiDetalleRecaudo() {
        return siiDetalleRecaudo;
    }

    public void setSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        this.siiDetalleRecaudo = siiDetalleRecaudo;
    }

    @OneToMany(mappedBy = "siiDetalleDeclaracion")
    public List<SiiRecaudoEstablec> getSiiRecaudoEstablecList() {
        return siiRecaudoEstablecList;
    }

    public void setSiiRecaudoEstablecList(List<SiiRecaudoEstablec> siiRecaudoEstablecList) {
        this.siiRecaudoEstablecList = siiRecaudoEstablecList;
    }

    public SiiRecaudoEstablec addSiiRecaudoEstablec(SiiRecaudoEstablec siiRecaudoEstablec) {
        getSiiRecaudoEstablecList().add(siiRecaudoEstablec);
        siiRecaudoEstablec.setSiiDetalleDeclaracion(this);
        return siiRecaudoEstablec;
    }

    public SiiRecaudoEstablec removeSiiRecaudoEstablec(SiiRecaudoEstablec siiRecaudoEstablec) {
        getSiiRecaudoEstablecList().remove(siiRecaudoEstablec);
        siiRecaudoEstablec.setSiiDetalleDeclaracion(null);
        return siiRecaudoEstablec;
    }

    @ManyToOne
    @JoinColumn(name = "DME_CODIGO")
    public SiiDistribucionMes getSiiDistribucionMes() {
        return siiDistribucionMes;
    }

    public void setSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        this.siiDistribucionMes = siiDistribucionMes;
    }
    
    @Column(name = "DDE_ESTADO", length = 1)
    public String getDdeEstado() {
        return ddeEstado;
    }
    
    public void setDdeEstado(String ddeEstado) {
        this.ddeEstado = ddeEstado;
    }
    
    @OneToMany(mappedBy = "siiDetalleDeclaracion")
    public List<SiiAsignacionRecaudo> getSiiAsignacionRecaudoList() {
        return siiAsignacionRecaudoList;
    }

    public void setSiiAsignacionRecaudoList(List<SiiAsignacionRecaudo> siiAsignacionRecaudoList) {
        this.siiAsignacionRecaudoList = siiAsignacionRecaudoList;
    }

    public SiiAsignacionRecaudo addSiiAsignacionRecaudo(SiiAsignacionRecaudo siiAsignacionRecaudo) {
        getSiiAsignacionRecaudoList().add(siiAsignacionRecaudo);
        siiAsignacionRecaudo.setSiiDetalleDeclaracion(this);
        return siiAsignacionRecaudo;
    }

    public SiiAsignacionRecaudo removeSiiAsignacionRecaudo(SiiAsignacionRecaudo siiAsignacionRecaudo) {
        getSiiAsignacionRecaudoList().remove(siiAsignacionRecaudo);
        siiAsignacionRecaudo.setSiiDetalleDeclaracion(null);
        return siiAsignacionRecaudo;
    }
}
