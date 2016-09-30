package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SII_CORTE_CARTERA")
public class SiiCorteCartera implements Serializable {
    private static final long serialVersionUID = 6499418273538526549L;
    private Long ccaCodigo;
    private Date ccaFecha;
    private Integer ccaVigencia;
    private SiiMes siiMes;
    private List<SiiDetCorteCartera> siiDetCorteCarteraList;
    private SiiUsuario siiUsuario;

    public SiiCorteCartera() {
    }

    public SiiCorteCartera(Long ccaCodigo, Date ccaFecha, Integer ccaVigencia, SiiMes siiMes, SiiUsuario siiUsuario) {
        this.ccaCodigo = ccaCodigo;
        this.ccaFecha = ccaFecha;
        this.ccaVigencia = ccaVigencia;
        this.siiMes = siiMes;
        this.siiUsuario = siiUsuario;
    }

    @Id
    @Column(name = "CCA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CORTE_CARTERA_COD")
    @SequenceGenerator(name = "SEQ_CORTE_CARTERA_COD", sequenceName = "SEQ_CORTE_CARTERA_COD",allocationSize=1)
    public Long getCcaCodigo() {
        return ccaCodigo;
    }

    public void setCcaCodigo(Long ccaCodigo) {
        this.ccaCodigo = ccaCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CCA_FECHA", nullable = false)
    public Date getCcaFecha() {
        return ccaFecha;
    }

    public void setCcaFecha(Date ccaFecha) {
        this.ccaFecha = ccaFecha;
    }

    @Column(name = "CCA_VIGENCIA", nullable = false)
    public Integer getCcaVigencia() {
        return ccaVigencia;
    }

    public void setCcaVigencia(Integer ccaVigencia) {
        this.ccaVigencia = ccaVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }

    @OneToMany(mappedBy = "siiCorteCartera")
    public List<SiiDetCorteCartera> getSiiDetCorteCarteraList() {
        return siiDetCorteCarteraList;
    }

    public void setSiiDetCorteCarteraList(List<SiiDetCorteCartera> siiDetCorteCarteraList) {
        this.siiDetCorteCarteraList = siiDetCorteCarteraList;
    }

    public SiiDetCorteCartera addSiiDetCorteCartera(SiiDetCorteCartera siiDetCorteCartera) {
        getSiiDetCorteCarteraList().add(siiDetCorteCartera);
        siiDetCorteCartera.setSiiCorteCartera(this);
        return siiDetCorteCartera;
    }

    public SiiDetCorteCartera removeSiiDetCorteCartera(SiiDetCorteCartera siiDetCorteCartera) {
        getSiiDetCorteCarteraList().remove(siiDetCorteCartera);
        siiDetCorteCartera.setSiiCorteCartera(null);
        return siiDetCorteCartera;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }
}
