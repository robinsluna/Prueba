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
@Table(name = "SII_ELEMENTO_PROCESO_ILE")
public class SiiElementoProcesoIle implements Serializable {
    private static final long serialVersionUID = 965219761425421685L;
    private String eprActivo;
    private Long eprCodigo;
    private Integer eprNumElementos;
    private BigDecimal eprValorSancion;
    private SiiUsuario siiUsuarioConec;
    private SiiTipoInstrumento siiTipoInstrumento;
    private SiiClaseJuego siiClaseJuego;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;

    public SiiElementoProcesoIle() {
    }

    public SiiElementoProcesoIle(SiiClaseJuego siiClaseJuego, String eprActivo, Long eprCodigo, Integer eprNumElementos, BigDecimal eprValorSancion, SiiProcesoSancIlegalidad siiProcesoSancIlegalidad,
                                 SiiTipoInstrumento siiTipoInstrumento, SiiUsuario siiUsuarioConec) {
        this.siiClaseJuego = siiClaseJuego;
        this.eprActivo = eprActivo;
        this.eprCodigo = eprCodigo;
        this.eprNumElementos = eprNumElementos;
        this.eprValorSancion = eprValorSancion;
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
        this.siiTipoInstrumento = siiTipoInstrumento;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Column(name = "EPR_ACTIVO", nullable = false, length = 1)
    public String getEprActivo() {
        return eprActivo;
    }

    public void setEprActivo(String eprActivo) {
        this.eprActivo = eprActivo;
    }

    @Id
    @Column(name = "EPR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ELEM_PRO_SAN_ILE_COD")
    @SequenceGenerator(name = "SEQ_ELEM_PRO_SAN_ILE_COD", sequenceName = "SEQ_ELEM_PRO_SAN_ILE_COD",allocationSize=1)
    public Long getEprCodigo() {
        return eprCodigo;
    }

    public void setEprCodigo(Long eprCodigo) {
        this.eprCodigo = eprCodigo;
    }

    @Column(name = "EPR_NUM_ELEMENTOS", nullable = false)
    public Integer getEprNumElementos() {
        return eprNumElementos;
    }

    public void setEprNumElementos(Integer eprNumElementos) {
        this.eprNumElementos = eprNumElementos;
    }

    @Column(name = "EPR_VALOR_SANCION", nullable = false)
    public BigDecimal getEprValorSancion() {
        return eprValorSancion;
    }

    public void setEprValorSancion(BigDecimal eprValorSancion) {
        this.eprValorSancion = eprValorSancion;
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
    @JoinColumn(name = "TIN_CODIGO")
    public SiiTipoInstrumento getSiiTipoInstrumento() {
        return siiTipoInstrumento;
    }

    public void setSiiTipoInstrumento(SiiTipoInstrumento siiTipoInstrumento) {
        this.siiTipoInstrumento = siiTipoInstrumento;
    }

    @ManyToOne
    @JoinColumn(name = "CJU_CODIGO")
    public SiiClaseJuego getSiiClaseJuego() {
        return siiClaseJuego;
    }

    public void setSiiClaseJuego(SiiClaseJuego siiClaseJuego) {
        this.siiClaseJuego = siiClaseJuego;
    }

    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }
}
