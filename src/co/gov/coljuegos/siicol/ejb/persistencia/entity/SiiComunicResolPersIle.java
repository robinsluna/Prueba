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
@Table(name = "SII_COMUNIC_RESOL_PERS_ILE")
public class SiiComunicResolPersIle implements Serializable {
    private static final long serialVersionUID = 4663033527161679459L;
    private Long corCodigo;
    private Date corFechaFinPub;
    private Date corFechaIniPub;
    private Date corFechaRad;
    private String corRadicado;
    private SiiResolucionProcIleg siiResolucionProcIleg;
    private SiiPersonaInvestProIle siiPersonaInvestProIle;
    private SiiUsuario siiUsuarioConec;

    public SiiComunicResolPersIle() {
    }

    public SiiComunicResolPersIle(Long corCodigo, Date corFechaFinPub, Date corFechaIniPub, Date corFechaRad, String corRadicado, SiiPersonaInvestProIle siiPersonaInvestProIle,
                                  SiiResolucionProcIleg siiResolucionProcIleg, SiiUsuario siiUsuarioConec) {
        this.corCodigo = corCodigo;
        this.corFechaFinPub = corFechaFinPub;
        this.corFechaIniPub = corFechaIniPub;
        this.corFechaRad = corFechaRad;
        this.corRadicado = corRadicado;
        this.siiPersonaInvestProIle = siiPersonaInvestProIle;
        this.siiResolucionProcIleg = siiResolucionProcIleg;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Id
    @Column(name = "COR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_COMUNIC_RESOL_PER_ILE_COD")
    @SequenceGenerator(name = "SEQ_COMUNIC_RESOL_PER_ILE_COD", sequenceName = "SEQ_COMUNIC_RESOL_PER_ILE_COD",allocationSize=1)
    public Long getCorCodigo() {
        return corCodigo;
    }

    public void setCorCodigo(Long corCodigo) {
        this.corCodigo = corCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COR_FECHA_FIN_PUB", nullable = false)
    public Date getCorFechaFinPub() {
        return corFechaFinPub;
    }

    public void setCorFechaFinPub(Date corFechaFinPub) {
        this.corFechaFinPub = corFechaFinPub;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COR_FECHA_INI_PUB", nullable = false)
    public Date getCorFechaIniPub() {
        return corFechaIniPub;
    }

    public void setCorFechaIniPub(Date corFechaIniPub) {
        this.corFechaIniPub = corFechaIniPub;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COR_FECHA_RAD", nullable = false)
    public Date getCorFechaRad() {
        return corFechaRad;
    }

    public void setCorFechaRad(Date corFechaRad) {
        this.corFechaRad = corFechaRad;
    }

    @Column(name = "COR_RADICADO", nullable = false, length = 30)
    public String getCorRadicado() {
        return corRadicado;
    }

    public void setCorRadicado(String corRadicado) {
        this.corRadicado = corRadicado;
    }


    @ManyToOne
    @JoinColumn(name = "RPI_CODIGO")
    public SiiResolucionProcIleg getSiiResolucionProcIleg() {
        return siiResolucionProcIleg;
    }

    public void setSiiResolucionProcIleg(SiiResolucionProcIleg siiResolucionProcIleg) {
        this.siiResolucionProcIleg = siiResolucionProcIleg;
    }

    @ManyToOne
    @JoinColumn(name = "PIP_CODIGO")
    public SiiPersonaInvestProIle getSiiPersonaInvestProIle() {
        return siiPersonaInvestProIle;
    }

    public void setSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        this.siiPersonaInvestProIle = siiPersonaInvestProIle;
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
