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
@Table(name = "SII_HIST_ESTADO_FISCALIZ")
public class SiiHistEstadoFiscaliz implements Serializable {
    private static final long serialVersionUID = 8970538009730411854L;
    private Long hefCodigo;
    private String hefEstado;
    private Date hefFechaAct;
    private Date hefFechaInact;
    private String hefGrupoAsignVisit;
    private SiiUsuario siiUsuarioConect;
    private SiiFiscalizadorSustanc siiFiscalizadorSustanc;

    public SiiHistEstadoFiscaliz() {
    }

    public SiiHistEstadoFiscaliz(SiiFiscalizadorSustanc siiFiscalizadorSustanc, Long hefCodigo, String hefEstado,
                                 Date hefFechaAct, Date hefFechaInact) {
        this.siiFiscalizadorSustanc = siiFiscalizadorSustanc;
        this.hefCodigo = hefCodigo;
        this.hefEstado = hefEstado;
        this.hefFechaAct = hefFechaAct;
        this.hefFechaInact = hefFechaInact;
    }


    @Id
    @Column(name = "HEF_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HIST_ESTADO_FISCALIZ_COD")
    @SequenceGenerator(name = "SEQ_HIST_ESTADO_FISCALIZ_COD", sequenceName = "SEQ_HIST_ESTADO_FISCALIZ_COD",allocationSize=1)
    public Long getHefCodigo() {
        return hefCodigo;
    }

    public void setHefCodigo(Long hefCodigo) {
        this.hefCodigo = hefCodigo;
    }

    @Column(name = "HEF_ESTADO", nullable = false, length = 1)
    public String getHefEstado() {
        return hefEstado;
    }

    public void setHefEstado(String hefEstado) {
        this.hefEstado = hefEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HEF_FECHA_ACT", nullable = false)
    public Date getHefFechaAct() {
        return hefFechaAct;
    }

    public void setHefFechaAct(Date hefFechaAct) {
        this.hefFechaAct = hefFechaAct;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HEF_FECHA_INACT", nullable = false)
    public Date getHefFechaInact() {
        return hefFechaInact;
    }

    public void setHefFechaInact(Date hefFechaInact) {
        this.hefFechaInact = hefFechaInact;
    }

    @Column(name = "HEF_GRUPO_ASIGN_VISIT", length = 1)
    public String getHefGrupoAsignVisit() {
        return hefGrupoAsignVisit;
    }

    public void setHefGrupoAsignVisit(String hefGrupoAsignVisit) {
        this.hefGrupoAsignVisit = hefGrupoAsignVisit;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONECT")
    public SiiUsuario getSiiUsuarioConect() {
        return siiUsuarioConect;
    }

    public void setSiiUsuarioConect(SiiUsuario siiUsuarioConect) {
        this.siiUsuarioConect = siiUsuarioConect;
    }

    @ManyToOne
    @JoinColumn(name = "FSU_CODIGO")
    public SiiFiscalizadorSustanc getSiiFiscalizadorSustanc() {
        return siiFiscalizadorSustanc;
    }

    public void setSiiFiscalizadorSustanc(SiiFiscalizadorSustanc siiFiscalizadorSustanc) {
        this.siiFiscalizadorSustanc = siiFiscalizadorSustanc;
    }
}
