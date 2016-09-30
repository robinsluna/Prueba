package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SII_PER_INVES_PRO_ILE_AUTO_PRU")
public class SiiPerInvesProIleAutoPru implements Serializable {
    private static final long serialVersionUID = 2120501998465276445L;
    private Long pauCodigo;
    private Date pauFechaFinPubl;
    private Date pauFechaIniPubl;
    private Date pauFechaRadic;
    private String pauRadicado;
    private SiiUsuario siiUsuarioConec;
    private SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle;
    private SiiPersonaInvestProIle siiPersonaInvestProIle;

    public SiiPerInvesProIleAutoPru() {
    }

    public SiiPerInvesProIleAutoPru(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle, Long pauCodigo, Date pauFechaFinPubl, Date pauFechaIniPubl, Date pauFechaRadic, String pauRadicado,
                                    SiiPersonaInvestProIle siiPersonaInvestProIle, SiiUsuario siiUsuarioConec) {
        this.siiAutoDecretaPrueProIle = siiAutoDecretaPrueProIle;
        this.pauCodigo = pauCodigo;
        this.pauFechaFinPubl = pauFechaFinPubl;
        this.pauFechaIniPubl = pauFechaIniPubl;
        this.pauFechaRadic = pauFechaRadic;
        this.pauRadicado = pauRadicado;
        this.siiPersonaInvestProIle = siiPersonaInvestProIle;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "PAU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PER_INV_PRO_IL_AUTO_COD")
    @SequenceGenerator(name = "SEQ_PER_INV_PRO_IL_AUTO_COD", sequenceName = "SEQ_PER_INV_PRO_IL_AUTO_COD",allocationSize=1)
    public Long getPauCodigo() {
        return pauCodigo;
    }

    public void setPauCodigo(Long pauCodigo) {
        this.pauCodigo = pauCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PAU_FECHA_FIN_PUBL")
    public Date getPauFechaFinPubl() {
        return pauFechaFinPubl;
    }

    public void setPauFechaFinPubl(Date pauFechaFinPubl) {
        this.pauFechaFinPubl = pauFechaFinPubl;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PAU_FECHA_INI_PUBL")
    public Date getPauFechaIniPubl() {
        return pauFechaIniPubl;
    }

    public void setPauFechaIniPubl(Date pauFechaIniPubl) {
        this.pauFechaIniPubl = pauFechaIniPubl;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PAU_FECHA_RADIC")
    public Date getPauFechaRadic() {
        return pauFechaRadic;
    }

    public void setPauFechaRadic(Date pauFechaRadic) {
        this.pauFechaRadic = pauFechaRadic;
    }

    @Column(name = "PAU_RADICADO", length = 30)
    public String getPauRadicado() {
        return pauRadicado;
    }

    public void setPauRadicado(String pauRadicado) {
        this.pauRadicado = pauRadicado;
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
    @JoinColumn(name = "ATP_CODIGO")
    public SiiAutoDecretaPrueProIle getSiiAutoDecretaPrueProIle() {
        return siiAutoDecretaPrueProIle;
    }

    public void setSiiAutoDecretaPrueProIle(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle) {
        this.siiAutoDecretaPrueProIle = siiAutoDecretaPrueProIle;
    }

    @ManyToOne
    @JoinColumn(name = "PIP_CODIGO")
    public SiiPersonaInvestProIle getSiiPersonaInvestProIle() {
        return siiPersonaInvestProIle;
    }

    public void setSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        this.siiPersonaInvestProIle = siiPersonaInvestProIle;
    }
}
