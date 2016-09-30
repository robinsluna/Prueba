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
@Table(name = "SII_AMPLIACION_TEMPORAL")
public class SiiAmpliacionTemporal implements Serializable {
    private Long ateCodigo;
    private Date ateFechaFin;
    private Date ateFechaInicio;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private SiiAjuste siiAjuste;

    public SiiAmpliacionTemporal() {
    }

    public SiiAmpliacionTemporal(SiiAjuste siiAjuste, Long ateCodigo, Date ateFechaFin, Date ateFechaInicio) {
        this.siiAjuste = siiAjuste;
        this.ateCodigo = ateCodigo;
        this.ateFechaFin = ateFechaFin;
        this.ateFechaInicio = ateFechaInicio;
    }


    @Id
    @Column(name = "ATE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AMPLIAC_TEMPORAL_COD")
    @SequenceGenerator(name = "SEQ_AMPLIAC_TEMPORAL_COD", sequenceName = "SEQ_AMPLIAC_TEMPORAL_COD",allocationSize=1)
    public Long getAteCodigo() {
        return ateCodigo;
    }

    public void setAteCodigo(Long ateCodigo) {
        this.ateCodigo = ateCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ATE_FECHA_FIN")
    public Date getAteFechaFin() {
        return ateFechaFin;
    }

    public void setAteFechaFin(Date ateFechaFin) {
        this.ateFechaFin = ateFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ATE_FECHA_INICIO")
    public Date getAteFechaInicio() {
        return ateFechaInicio;
    }

    public void setAteFechaInicio(Date ateFechaInicio) {
        this.ateFechaInicio = ateFechaInicio;
    }

    @OneToMany(mappedBy = "siiAmpliacionTemporal")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiAmpliacionTemporal(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiAmpliacionTemporal(null);
        return siiCuotaOperador;
    }

    @ManyToOne
    @JoinColumn(name = "AJU_CODIGO")
    public SiiAjuste getSiiAjuste() {
        return siiAjuste;
    }

    public void setSiiAjuste(SiiAjuste siiAjuste) {
        this.siiAjuste = siiAjuste;
    }
}
