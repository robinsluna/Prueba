package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_LOG_CAMPO_MODIFICACION")
public class SiiLogCampoModificacion implements Serializable {
    private static final long serialVersionUID = 5313845652870441708L;
    private String lmcCampo;
    private Long lmcCodigo;
    private String lmcTipoCampo;
    private String lmcValorAnterior;
    private String lmcValorPosterior;
    private String lmoEsLlavePri;
    private SiiLogModificacion siiLogModificacion;

    public SiiLogCampoModificacion() {
    }

    public SiiLogCampoModificacion(String lmcCampo, Long lmcCodigo, String lmcTipoCampo, String lmcValorAnterior, String lmcValorPosterior, SiiLogModificacion siiLogModificacion,
                                   String lmoEsLlavePri) {
        this.lmcCampo = lmcCampo;
        this.lmcCodigo = lmcCodigo;
        this.lmcTipoCampo = lmcTipoCampo;
        this.lmcValorAnterior = lmcValorAnterior;
        this.lmcValorPosterior = lmcValorPosterior;
        this.siiLogModificacion = siiLogModificacion;
        this.lmoEsLlavePri = lmoEsLlavePri;
    }

    @Column(name = "LMC_CAMPO", nullable = false, length = 50)
    public String getLmcCampo() {
        return lmcCampo;
    }

    public void setLmcCampo(String lmcCampo) {
        this.lmcCampo = lmcCampo;
    }

    @Id
    @Column(name = "LMC_CODIGO", nullable = false)
    public Long getLmcCodigo() {
        return lmcCodigo;
    }

    public void setLmcCodigo(Long lmcCodigo) {
        this.lmcCodigo = lmcCodigo;
    }

    @Column(name = "LMC_TIPO_CAMPO", nullable = false, length = 1)
    public String getLmcTipoCampo() {
        return lmcTipoCampo;
    }

    public void setLmcTipoCampo(String lmcTipoCampo) {
        this.lmcTipoCampo = lmcTipoCampo;
    }

    @Column(name = "LMC_VALOR_ANTERIOR", length = 4000)
    public String getLmcValorAnterior() {
        return lmcValorAnterior;
    }

    public void setLmcValorAnterior(String lmcValorAnterior) {
        this.lmcValorAnterior = lmcValorAnterior;
    }

    @Column(name = "LMC_VALOR_POSTERIOR", length = 4000)
    public String getLmcValorPosterior() {
        return lmcValorPosterior;
    }

    public void setLmcValorPosterior(String lmcValorPosterior) {
        this.lmcValorPosterior = lmcValorPosterior;
    }


    @Column(name = "LMO_ES_LLAVE_PRI", nullable = false, length = 1)
    public String getLmoEsLlavePri() {
        return lmoEsLlavePri;
    }

    public void setLmoEsLlavePri(String lmoEsLlavePri) {
        this.lmoEsLlavePri = lmoEsLlavePri;
    }

    @ManyToOne
    @JoinColumn(name = "LMO_CODIGO")
    public SiiLogModificacion getSiiLogModificacion() {
        return siiLogModificacion;
    }

    public void setSiiLogModificacion(SiiLogModificacion siiLogModificacion) {
        this.siiLogModificacion = siiLogModificacion;
    }
}
