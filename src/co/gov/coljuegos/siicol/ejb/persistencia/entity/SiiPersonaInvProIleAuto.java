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
@Table(name = "SII_PERSONA_INV_PRO_ILE_AUTO")
public class SiiPersonaInvProIleAuto implements Serializable {
    private static final long serialVersionUID = -4485847480054112057L;
    private Long piaCodigo;
    private Date piaComFechaFinP;
    private Date piaComFechaIniP;
    private Date piaComFechaRad;
    private String piaComRadicado;
    private Date piaNumFechaRad;
    private String piaNumRadicado;
    private SiiAutoFormCargProIle siiAutoFormCargProIle;
    private SiiUsuario siiUsuarioConec;
    private SiiPersonaInvestProIle siiPersonaInvestProIle;

    public SiiPersonaInvProIleAuto() {
    }

    public SiiPersonaInvProIleAuto(SiiAutoFormCargProIle siiAutoFormCargProIle, Long piaCodigo, Date piaComFechaFinP, Date piaComFechaIniP, Date piaComFechaRad, String piaComRadicado,
                                   Date piaNumFechaRad, String piaNumRadicado, SiiPersonaInvestProIle siiPersonaInvestProIle, SiiUsuario siiUsuarioConec) {
        this.siiAutoFormCargProIle = siiAutoFormCargProIle;
        this.piaCodigo = piaCodigo;
        this.piaComFechaFinP = piaComFechaFinP;
        this.piaComFechaIniP = piaComFechaIniP;
        this.piaComFechaRad = piaComFechaRad;
        this.piaComRadicado = piaComRadicado;
        this.piaNumFechaRad = piaNumFechaRad;
        this.piaNumRadicado = piaNumRadicado;
        this.siiPersonaInvestProIle = siiPersonaInvestProIle;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "PIA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERS_INV_PRO_ILE_AUTO_COD")
    @SequenceGenerator(name = "SEQ_PERS_INV_PRO_ILE_AUTO_COD", sequenceName = "SEQ_PERS_INV_PRO_ILE_AUTO_COD",allocationSize=1)
    public Long getPiaCodigo() {
        return piaCodigo;
    }

    public void setPiaCodigo(Long piaCodigo) {
        this.piaCodigo = piaCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PIA_COM_FECHA_FIN_P")
    public Date getPiaComFechaFinP() {
        return piaComFechaFinP;
    }

    public void setPiaComFechaFinP(Date piaComFechaFinP) {
        this.piaComFechaFinP = piaComFechaFinP;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PIA_COM_FECHA_INI_P")
    public Date getPiaComFechaIniP() {
        return piaComFechaIniP;
    }

    public void setPiaComFechaIniP(Date piaComFechaIniP) {
        this.piaComFechaIniP = piaComFechaIniP;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PIA_COM_FECHA_RAD")
    public Date getPiaComFechaRad() {
        return piaComFechaRad;
    }

    public void setPiaComFechaRad(Date piaComFechaRad) {
        this.piaComFechaRad = piaComFechaRad;
    }

    @Column(name = "PIA_COM_RADICADO", length = 30)
    public String getPiaComRadicado() {
        return piaComRadicado;
    }

    public void setPiaComRadicado(String piaComRadicado) {
        this.piaComRadicado = piaComRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PIA_NUM_FECHA_RAD")
    public Date getPiaNumFechaRad() {
        return piaNumFechaRad;
    }

    public void setPiaNumFechaRad(Date piaNumFechaRad) {
        this.piaNumFechaRad = piaNumFechaRad;
    }

    @Column(name = "PIA_NUM_RADICADO", length = 30)
    public String getPiaNumRadicado() {
        return piaNumRadicado;
    }

    public void setPiaNumRadicado(String piaNumRadicado) {
        this.piaNumRadicado = piaNumRadicado;
    }


    @ManyToOne
    @JoinColumn(name = "AFC_CODIGO")
    public SiiAutoFormCargProIle getSiiAutoFormCargProIle() {
        return siiAutoFormCargProIle;
    }

    public void setSiiAutoFormCargProIle(SiiAutoFormCargProIle siiAutoFormCargProIle) {
        this.siiAutoFormCargProIle = siiAutoFormCargProIle;
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
    @JoinColumn(name = "PIP_CODIGO")
    public SiiPersonaInvestProIle getSiiPersonaInvestProIle() {
        return siiPersonaInvestProIle;
    }

    public void setSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        this.siiPersonaInvestProIle = siiPersonaInvestProIle;
    }
}
