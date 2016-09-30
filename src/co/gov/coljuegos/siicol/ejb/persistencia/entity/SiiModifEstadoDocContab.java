package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_MODIF_ESTADO_DOC_CONTAB")
public class SiiModifEstadoDocContab implements Serializable {
    private static final long serialVersionUID = 8946029081581616912L;
    private Long mecCodigo;
    private Date mecFecha;
    private SiiUsuario siiUsuarioConec;
    private List<SiiDocumentoContable> siiDocumentoContableList;

    public SiiModifEstadoDocContab() {
    }

    public SiiModifEstadoDocContab(Long mecCodigo, Date mecFecha, SiiUsuario siiUsuarioConec) {
        this.mecCodigo = mecCodigo;
        this.mecFecha = mecFecha;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Id
    @Column(name = "MEC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODIF_EST_DOC_CON_COD")
    @SequenceGenerator(name = "SEQ_MODIF_EST_DOC_CON_COD", sequenceName = "SEQ_MODIF_EST_DOC_CON_COD",allocationSize=1)
    public Long getMecCodigo() {
        return mecCodigo;
    }

    public void setMecCodigo(Long mecCodigo) {
        this.mecCodigo = mecCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MEC_FECHA", nullable = false)
    public Date getMecFecha() {
        return mecFecha;
    }

    public void setMecFecha(Date mecFecha) {
        this.mecFecha = mecFecha;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiModifEstadoDocContab")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiModifEstadoDocContab(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiModifEstadoDocContab(null);
        return siiDocumentoContable;
    }
}
