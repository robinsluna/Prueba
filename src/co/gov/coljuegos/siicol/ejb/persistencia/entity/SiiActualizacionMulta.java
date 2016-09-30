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
@Table(name = "SII_ACTUALIZACION_MULTA")
public class SiiActualizacionMulta implements Serializable {
    private static final long serialVersionUID = 1663657322095780330L;
    private Long amuCodigo;
    private Date amuFecha;
    private Integer amuVigencia;
    private List<SiiActualizacCuotaOpe> siiActualizacCuotaOpeList;
    private SiiSmmlv siiSmmlv;

    public SiiActualizacionMulta() {
    }

    public SiiActualizacionMulta(Long amuCodigo, Date amuFecha, Integer amuVigencia) {
        this.amuCodigo = amuCodigo;
        this.amuFecha = amuFecha;
        this.amuVigencia = amuVigencia;
    }

    @Id
    @Column(name = "AMU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACTUALIZACION_MULTA_COD")
    @SequenceGenerator(name = "SEQ_ACTUALIZACION_MULTA_COD", sequenceName = "SEQ_ACTUALIZACION_MULTA_COD",allocationSize=1)
    public Long getAmuCodigo() {
        return amuCodigo;
    }

    public void setAmuCodigo(Long amuCodigo) {
        this.amuCodigo = amuCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AMU_FECHA", nullable = false)
    public Date getAmuFecha() {
        return amuFecha;
    }

    public void setAmuFecha(Date amuFecha) {
        this.amuFecha = amuFecha;
    }

    @Column(name = "AMU_VIGENCIA", nullable = false)
    public Integer getAmuVigencia() {
        return amuVigencia;
    }

    public void setAmuVigencia(Integer amuVigencia) {
        this.amuVigencia = amuVigencia;
    }

    @OneToMany(mappedBy = "siiActualizacionMulta")
    public List<SiiActualizacCuotaOpe> getSiiActualizacCuotaOpeList() {
        return siiActualizacCuotaOpeList;
    }

    public void setSiiActualizacCuotaOpeList(List<SiiActualizacCuotaOpe> siiActualizacCuotaOpeList) {
        this.siiActualizacCuotaOpeList = siiActualizacCuotaOpeList;
    }

    public SiiActualizacCuotaOpe addSiiActualizacCuotaOpe(SiiActualizacCuotaOpe siiActualizacCuotaOpe) {
        getSiiActualizacCuotaOpeList().add(siiActualizacCuotaOpe);
        siiActualizacCuotaOpe.setSiiActualizacionMulta(this);
        return siiActualizacCuotaOpe;
    }

    public SiiActualizacCuotaOpe removeSiiActualizacCuotaOpe(SiiActualizacCuotaOpe siiActualizacCuotaOpe) {
        getSiiActualizacCuotaOpeList().remove(siiActualizacCuotaOpe);
        siiActualizacCuotaOpe.setSiiActualizacionMulta(null);
        return siiActualizacCuotaOpe;
    }

    @ManyToOne
    @JoinColumn(name = "SMM_VIGENCIA")
    public SiiSmmlv getSiiSmmlv() {
        return siiSmmlv;
    }

    public void setSiiSmmlv(SiiSmmlv siiSmmlv) {
        this.siiSmmlv = siiSmmlv;
    }
}
