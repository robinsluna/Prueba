package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_COMUNICAC_SIITO")
public class SiiComunicacSiito implements Serializable {
    private static final long serialVersionUID = -729582444443589381L;
    private Long csiCodigo;
    private Date csiFecha;
    private String csiRadicado;
    private SiiResolucionAutoriz siiResolucionAutoriz;

    public SiiComunicacSiito() {
    }

    public SiiComunicacSiito(Long csiCodigo, Date csiFecha, String csiRadicado,
                             SiiResolucionAutoriz siiResolucionAutoriz) {
        this.csiCodigo = csiCodigo;
        this.csiFecha = csiFecha;
        this.csiRadicado = csiRadicado;
        this.siiResolucionAutoriz = siiResolucionAutoriz;
    }

    @Id
    @Column(name = "CSI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_COMUNICAC_SIITO_COD")
    @SequenceGenerator(name = "SEQ_COMUNICAC_SIITO_COD", sequenceName = "SEQ_COMUNICAC_SIITO_COD",allocationSize=1)
    public Long getCsiCodigo() {
        return csiCodigo;
    }

    public void setCsiCodigo(Long csiCodigo) {
        this.csiCodigo = csiCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CSI_FECHA", nullable = false)
    public Date getCsiFecha() {
        return csiFecha;
    }

    public void setCsiFecha(Date csiFecha) {
        this.csiFecha = csiFecha;
    }

    @Column(name = "CSI_RADICADO", nullable = false, length = 20)
    public String getCsiRadicado() {
        return csiRadicado;
    }

    public void setCsiRadicado(String csiRadicado) {
        this.csiRadicado = csiRadicado;
    }


    @ManyToOne
    @JoinColumn(name = "RAU_CODIGO")
    public SiiResolucionAutoriz getSiiResolucionAutoriz() {
        return siiResolucionAutoriz;
    }

    public void setSiiResolucionAutoriz(SiiResolucionAutoriz siiResolucionAutoriz) {
        this.siiResolucionAutoriz = siiResolucionAutoriz;
    }
}
