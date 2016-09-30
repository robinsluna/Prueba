package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ABONO_INI_ACUERDO_PAGO")
public class SiiAbonoIniAcuerdoPago implements Serializable {
    private static final long serialVersionUID = 7441582848382560801L;
    private BigDecimal aiaAbonoIni;
    private BigDecimal aiaAbonoIniInt;
    private String aiaActivo;
    private BigDecimal aiaCodigo;
    private Integer aiaPorcPropCuo;
    private Integer aiaPorcPropInt;
    private SiiAcuerdoPago siiAcuerdoPago;
    private SiiConceptoCuota siiConceptoCuota;
    private SiiUsuario siiUsuarioConec;

    public SiiAbonoIniAcuerdoPago() {
    }

    public SiiAbonoIniAcuerdoPago(BigDecimal aiaAbonoIni, BigDecimal aiaAbonoIniInt, String aiaActivo, BigDecimal aiaCodigo, Integer aiaPorcPropCuo, Integer aiaPorcPropInt,
                                  SiiAcuerdoPago siiAcuerdoPago, SiiConceptoCuota siiConceptoCuota, SiiUsuario siiUsuarioConec) {
        this.aiaAbonoIni = aiaAbonoIni;
        this.aiaAbonoIniInt = aiaAbonoIniInt;
        this.aiaActivo = aiaActivo;
        this.aiaCodigo = aiaCodigo;
        this.aiaPorcPropCuo = aiaPorcPropCuo;
        this.aiaPorcPropInt = aiaPorcPropInt;
        this.siiAcuerdoPago = siiAcuerdoPago;
        this.siiConceptoCuota = siiConceptoCuota;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Column(name = "AIA_ABONO_INI")
    public BigDecimal getAiaAbonoIni() {
        return aiaAbonoIni;
    }

    public void setAiaAbonoIni(BigDecimal aiaAbonoIni) {
        this.aiaAbonoIni = aiaAbonoIni;
    }

    @Column(name = "AIA_ABONO_INI_INT")
    public BigDecimal getAiaAbonoIniInt() {
        return aiaAbonoIniInt;
    }

    public void setAiaAbonoIniInt(BigDecimal aiaAbonoIniInt) {
        this.aiaAbonoIniInt = aiaAbonoIniInt;
    }

    @Column(name = "AIA_ACTIVO", nullable = false, length = 1)
    public String getAiaActivo() {
        return aiaActivo;
    }

    public void setAiaActivo(String aiaActivo) {
        this.aiaActivo = aiaActivo;
    }

    @Id
    @Column(name = "AIA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ABONO_INI_ACUER_PAG_COD")
    @SequenceGenerator(name = "SEQ_ABONO_INI_ACUER_PAG_COD", sequenceName = "SEQ_ABONO_INI_ACUER_PAG_COD",allocationSize=1)
    public BigDecimal getAiaCodigo() {
        return aiaCodigo;
    }

    public void setAiaCodigo(BigDecimal aiaCodigo) {
        this.aiaCodigo = aiaCodigo;
    }

    @Column(name = "AIA_PORC_PROP_CUO")
    public Integer getAiaPorcPropCuo() {
        return aiaPorcPropCuo;
    }

    public void setAiaPorcPropCuo(Integer aiaPorcPropCuo) {
        this.aiaPorcPropCuo = aiaPorcPropCuo;
    }

    @Column(name = "AIA_PORC_PROP_INT")
    public Integer getAiaPorcPropInt() {
        return aiaPorcPropInt;
    }

    public void setAiaPorcPropInt(Integer aiaPorcPropInt) {
        this.aiaPorcPropInt = aiaPorcPropInt;
    }


    @ManyToOne
    @JoinColumn(name = "APA_CODIGO")
    public SiiAcuerdoPago getSiiAcuerdoPago() {
        return siiAcuerdoPago;
    }

    public void setSiiAcuerdoPago(SiiAcuerdoPago siiAcuerdoPago) {
        this.siiAcuerdoPago = siiAcuerdoPago;
    }

    @ManyToOne
    @JoinColumn(name = "CCU_CODIGO")
    public SiiConceptoCuota getSiiConceptoCuota() {
        return siiConceptoCuota;
    }

    public void setSiiConceptoCuota(SiiConceptoCuota siiConceptoCuota) {
        this.siiConceptoCuota = siiConceptoCuota;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }
}
