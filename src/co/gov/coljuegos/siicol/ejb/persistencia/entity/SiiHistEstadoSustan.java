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
@Table(name = "SII_HIST_ESTADO_SUSTAN")
public class SiiHistEstadoSustan implements Serializable {
    private static final long serialVersionUID = 5527034208698847564L;
    private Long hesCodigo;
    private String hesEstado;
    private Date hesFechaAct;
    private Date hesFechaInact;
    private String hesGrupoAsignVisit;
    private SiiSustanciadorAuditor siiSustanciadorAuditor;
    private SiiUsuario siiUsuarioConect;

    public SiiHistEstadoSustan() {
    }

    public SiiHistEstadoSustan(Long hesCodigo, String hesEstado, Date hesFechaAct, Date hesFechaInact, String hesGrupoAsignVisit, SiiSustanciadorAuditor siiSustanciadorAuditor,
                               SiiUsuario siiUsuarioConect) {
        this.hesCodigo = hesCodigo;
        this.hesEstado = hesEstado;
        this.hesFechaAct = hesFechaAct;
        this.hesFechaInact = hesFechaInact;
        this.hesGrupoAsignVisit = hesGrupoAsignVisit;
        this.siiSustanciadorAuditor = siiSustanciadorAuditor;
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @Id
    @Column(name = "HES_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HIST_ESTADO_SUST_COD")
    @SequenceGenerator(name = "SEQ_HIST_ESTADO_SUST_COD", sequenceName = "SEQ_HIST_ESTADO_SUST_COD",allocationSize=1)
    public Long getHesCodigo() {
        return hesCodigo;
    }

    public void setHesCodigo(Long hesCodigo) {
        this.hesCodigo = hesCodigo;
    }

    @Column(name = "HES_ESTADO", nullable = false, length = 1)
    public String getHesEstado() {
        return hesEstado;
    }

    public void setHesEstado(String hesEstado) {
        this.hesEstado = hesEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HES_FECHA_ACT", nullable = false)
    public Date getHesFechaAct() {
        return hesFechaAct;
    }

    public void setHesFechaAct(Date hesFechaAct) {
        this.hesFechaAct = hesFechaAct;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HES_FECHA_INACT", nullable = false)
    public Date getHesFechaInact() {
        return hesFechaInact;
    }

    public void setHesFechaInact(Date hesFechaInact) {
        this.hesFechaInact = hesFechaInact;
    }

    @Column(name = "HES_GRUPO_ASIGN_VISIT", length = 1)
    public String getHesGrupoAsignVisit() {
        return hesGrupoAsignVisit;
    }

    public void setHesGrupoAsignVisit(String hesGrupoAsignVisit) {
        this.hesGrupoAsignVisit = hesGrupoAsignVisit;
    }


    @ManyToOne
    @JoinColumn(name = "SUA_CODIGO")
    public SiiSustanciadorAuditor getSiiSustanciadorAuditor() {
        return siiSustanciadorAuditor;
    }

    public void setSiiSustanciadorAuditor(SiiSustanciadorAuditor siiSustanciadorAuditor) {
        this.siiSustanciadorAuditor = siiSustanciadorAuditor;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect() {
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect) {
        this.siiUsuarioConect = siiUsuarioConect;
    }
}
