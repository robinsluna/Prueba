package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_REGLA_IMPUESTOS")
public class SiiReglaImpuestos implements Serializable {
    private static final long serialVersionUID = -3594500401575153260L;
    private Long rimCodigo;
    private String rimTipoContrib;
    private String rimTipoProveed;
    private SiiTipoRetencion siiTipoRetencion;
    private SiiGrupoRetenc siiGrupoRetenc;
    private String rimGrupoRespon;

    public SiiReglaImpuestos() {
    }

    public SiiReglaImpuestos(SiiGrupoRetenc siiGrupoRetenc, Long rimCodigo, String rimTipoContrib,
                             String rimTipoProveed, SiiTipoRetencion siiTipoRetencion) {
        this.siiGrupoRetenc = siiGrupoRetenc;
        this.rimCodigo = rimCodigo;
        this.rimTipoContrib = rimTipoContrib;
        this.rimTipoProveed = rimTipoProveed;
        this.siiTipoRetencion = siiTipoRetencion;
    }


    @Id
    @Column(name = "RIM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REGLA_IMPUESTOS_COD")
    @SequenceGenerator(name = "SEQ_REGLA_IMPUESTOS_COD", sequenceName = "SEQ_REGLA_IMPUESTOS_COD",allocationSize=1)
    public Long getRimCodigo() {
        return rimCodigo;
    }

    public void setRimCodigo(Long rimCodigo) {
        this.rimCodigo = rimCodigo;
    }

    @Column(name = "RIM_TIPO_CONTRIB", nullable = false, length = 1)
    public String getRimTipoContrib() {
        return rimTipoContrib;
    }

    public void setRimTipoContrib(String rimTipoContrib) {
        this.rimTipoContrib = rimTipoContrib;
    }

    @Column(name = "RIM_TIPO_PROVEED", nullable = false, length = 1)
    public String getRimTipoProveed() {
        return rimTipoProveed;
    }

    public void setRimTipoProveed(String rimTipoProveed) {
        this.rimTipoProveed = rimTipoProveed;
    }


    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO")
    public SiiTipoRetencion getSiiTipoRetencion() {
        return siiTipoRetencion;
    }

    public void setSiiTipoRetencion(SiiTipoRetencion siiTipoRetencion) {
        this.siiTipoRetencion = siiTipoRetencion;
    }


    @ManyToOne
    @JoinColumn(name = "GRE_CODIGO")
    public SiiGrupoRetenc getSiiGrupoRetenc() {
        return siiGrupoRetenc;
    }

    public void setSiiGrupoRetenc(SiiGrupoRetenc siiGrupoRetenc) {
        this.siiGrupoRetenc = siiGrupoRetenc;
    }

    @Column(name = "RIM_GRUPO_RESPON", nullable = false, length = 20)
    public String getRimGrupoRespon() {
        return rimGrupoRespon;
    }

    public void setRimGrupoRespon(String rimGrupoRespon) {
        this.rimGrupoRespon = rimGrupoRespon;
    }
}
