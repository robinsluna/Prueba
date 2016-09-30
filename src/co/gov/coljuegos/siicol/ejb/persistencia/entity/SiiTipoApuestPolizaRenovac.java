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
@Table(name = "SII_TIPO_APUEST_POLIZA_RENOVAC")
public class SiiTipoApuestPolizaRenovac implements Serializable {
    private static final long serialVersionUID = -5709339849581962101L;
    private Long talCodigo;
    private Integer talDuracion;
    private BigDecimal talValorDe;
    private BigDecimal talValorGa;
    private SiiUsuario siiUsuarioConec;
    private SiiPolizaContrat siiPolizaContrat;
    private SiiTipoApuesta siiTipoApuesta;
    private Long talNumeroElem;
    private BigDecimal talValorUnitario;

    public SiiTipoApuestPolizaRenovac() {
    }

    public SiiTipoApuestPolizaRenovac(SiiPolizaContrat siiPolizaContrat, Long talCodigo, Integer talDuracion, BigDecimal talValorDe, BigDecimal talValorGa, SiiTipoApuesta siiTipoApuesta,
                                      SiiUsuario siiUsuarioConec) {
        this.siiPolizaContrat = siiPolizaContrat;
        this.talCodigo = talCodigo;
        this.talDuracion = talDuracion;
        this.talValorDe = talValorDe;
        this.talValorGa = talValorGa;
        this.siiTipoApuesta = siiTipoApuesta;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "TAL_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TIPO_APUE_POLIZ_REN_COD")
    @SequenceGenerator(name = "SEQ_TIPO_APUE_POLIZ_REN_COD", sequenceName = "SEQ_TIPO_APUE_POLIZ_REN_COD",allocationSize=1)
    public Long getTalCodigo() {
        return talCodigo;
    }

    public void setTalCodigo(Long talCodigo) {
        this.talCodigo = talCodigo;
    }

    @Column(name = "TAL_DURACION", nullable = false)
    public Integer getTalDuracion() {
        return talDuracion;
    }

    public void setTalDuracion(Integer talDuracion) {
        this.talDuracion = talDuracion;
    }

    @Column(name = "TAL_VALOR_DE", nullable = false)
    public BigDecimal getTalValorDe() {
        return talValorDe;
    }

    public void setTalValorDe(BigDecimal talValorDe) {
        this.talValorDe = talValorDe;
    }

    @Column(name = "TAL_VALOR_GA", nullable = false)
    public BigDecimal getTalValorGa() {
        return talValorGa;
    }

    public void setTalValorGa(BigDecimal talValorGa) {
        this.talValorGa = talValorGa;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @ManyToOne
    @JoinColumn(name = "PCC_CODIGO")
    public SiiPolizaContrat getSiiPolizaContrat() {
        return siiPolizaContrat;
    }

    public void setSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        this.siiPolizaContrat = siiPolizaContrat;
    }

    @ManyToOne
    @JoinColumn(name = "TAP_CODIGO")
    public SiiTipoApuesta getSiiTipoApuesta() {
        return siiTipoApuesta;
    }

    public void setSiiTipoApuesta(SiiTipoApuesta siiTipoApuesta) {
        this.siiTipoApuesta = siiTipoApuesta;
    }

    @Column(name = "TAL_NUMERO_ELEM", nullable = false)
    public Long getTalNumeroElem() {
        return talNumeroElem;
    }
    
    public void setTalNumeroElem(Long talNumeroElem) {
        this.talNumeroElem = talNumeroElem;
    }

    @Column(name = "TAL_VALOR_UNITARIO", nullable = false)
    public BigDecimal getTalValorUnitario() {
        return talValorUnitario;
    }
    
    public void setTalValorUnitario(BigDecimal talValorUnitario) {
        this.talValorUnitario = talValorUnitario;
    }
}
