package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_LIQUIDACION_ESTABL")
public class SiiLiquidacionEstabl implements Serializable {
    private static final long serialVersionUID = -5995031959227102302L;
    private Long lesCodigo;
    private BigDecimal lesPonderado;
    private BigDecimal lesValor;
    private SiiLiquidacionMes siiLiquidacionMes;
    private SiiEstablecimiento siiEstablecimiento;
    private List<SiiRecaudoEstablec> siiRecaudoEstablecList;
    private SiiAsignacionRecaudo siiAsignacionRecaudo;
    private SiiUbicacion siiUbicacionMunEstab;
    private String lesNumEstablec;
    private SiiCargaActuacionesAdm siiCargaActuacionesAdm;

    public SiiLiquidacionEstabl() {
    }

    public SiiLiquidacionEstabl(SiiEstablecimiento siiEstablecimiento, Long lesCodigo, BigDecimal lesPonderado,
                                BigDecimal lesValor, SiiLiquidacionMes siiLiquidacionMes) {
        this.siiEstablecimiento = siiEstablecimiento;
        this.lesCodigo = lesCodigo;
        this.lesPonderado = lesPonderado;
        this.lesValor = lesValor;
        this.siiLiquidacionMes = siiLiquidacionMes;
    }


    @Id
    @Column(name = "LES_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_LIQUIDACION_ESTABL_COD")
    @SequenceGenerator(name = "SEQ_LIQUIDACION_ESTABL_COD", sequenceName = "SEQ_LIQUIDACION_ESTABL_COD",allocationSize=1)
    public Long getLesCodigo() {
        return lesCodigo;
    }

    public void setLesCodigo(Long lesCodigo) {
        this.lesCodigo = lesCodigo;
    }

    @Column(name = "LES_PONDERADO", nullable = false)
    public BigDecimal getLesPonderado() {
        return lesPonderado;
    }

    public void setLesPonderado(BigDecimal lesPonderado) {
        this.lesPonderado = lesPonderado;
    }

    @Column(name = "LES_VALOR", nullable = false)
    public BigDecimal getLesValor() {
        return lesValor;
    }

    public void setLesValor(BigDecimal lesValor) {
        this.lesValor = lesValor;
    }


    @ManyToOne
    @JoinColumn(name = "LME_CODIGO")
    public SiiLiquidacionMes getSiiLiquidacionMes() {
        return siiLiquidacionMes;
    }

    public void setSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) {
        this.siiLiquidacionMes = siiLiquidacionMes;
    }

    @ManyToOne
    @JoinColumn(name = "EST_CODIGO")
    public SiiEstablecimiento getSiiEstablecimiento() {
        return siiEstablecimiento;
    }

    public void setSiiEstablecimiento(SiiEstablecimiento siiEstablecimiento) {
        this.siiEstablecimiento = siiEstablecimiento;
    }

    @OneToMany(mappedBy = "siiLiquidacionEstabl")
    public List<SiiRecaudoEstablec> getSiiRecaudoEstablecList() {
        return siiRecaudoEstablecList;
    }

    public void setSiiRecaudoEstablecList(List<SiiRecaudoEstablec> siiRecaudoEstablecList) {
        this.siiRecaudoEstablecList = siiRecaudoEstablecList;
    }

    public SiiRecaudoEstablec addSiiRecaudoEstablec(SiiRecaudoEstablec siiRecaudoEstablec) {
        getSiiRecaudoEstablecList().add(siiRecaudoEstablec);
        siiRecaudoEstablec.setSiiLiquidacionEstabl(this);
        return siiRecaudoEstablec;
    }

    public SiiRecaudoEstablec removeSiiRecaudoEstablec(SiiRecaudoEstablec siiRecaudoEstablec) {
        getSiiRecaudoEstablecList().remove(siiRecaudoEstablec);
        siiRecaudoEstablec.setSiiLiquidacionEstabl(null);
        return siiRecaudoEstablec;
    }

    @ManyToOne
    @JoinColumn(name = "ARE_CODIGO")
    public SiiAsignacionRecaudo getSiiAsignacionRecaudo() {
        return siiAsignacionRecaudo;
    }

    public void setSiiAsignacionRecaudo(SiiAsignacionRecaudo siiAsignacionRecaudo) {
        this.siiAsignacionRecaudo = siiAsignacionRecaudo;
    }
    
    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_MUN_EST")
    public SiiUbicacion getSiiUbicacionMunEstab() {
        return siiUbicacionMunEstab;
    }

    public void setSiiUbicacionMunEstab(SiiUbicacion siiUbicacionMunEstab) {
        this.siiUbicacionMunEstab = siiUbicacionMunEstab;
    }

    @Column(name = "LES_NUM_ESTABLEC", length = 3)
    public String getLesNumEstablec() {
        return lesNumEstablec;
    }

    public void setLesNumEstablec(String lesNumEstablec) {
        this.lesNumEstablec = lesNumEstablec;
    }

    @ManyToOne
    @JoinColumn(name = "CAA_CODIGO")
    public SiiCargaActuacionesAdm getSiiCargaActuacionesAdm() {
        return siiCargaActuacionesAdm;
    }

    public void setSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        this.siiCargaActuacionesAdm = siiCargaActuacionesAdm;
    }
}
