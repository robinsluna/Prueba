package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

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
@Table(name = "SII_ASIGNACION_RECAUDO_AA")
public class SiiAsignacionRecaudoAa implements Serializable {
    private static final long serialVersionUID = 2640086343099639141L;
    private Long araCodigo;
    private Date araFecha;
    private Date araFechaPago;
    private String araResolucion;
    private BigDecimal araValor;
    private List<SiiAsigRecaudoAaEstabl> siiAsigRecaudoAaEstablList;
    private SiiDistribucionMes siiDistribucionMes;

    public SiiAsignacionRecaudoAa() {
    }

    public SiiAsignacionRecaudoAa(Long araCodigo, Date araFecha, Date araFechaPago, String araResolucion, BigDecimal araValor) {
        this.araCodigo = araCodigo;
        this.araFecha = araFecha;
        this.araFechaPago = araFechaPago;
        this.araResolucion = araResolucion;
        this.araValor = araValor;
    }

    @Id
    @Column(name = "ARA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ASIGNAC_RECAUDO_AA_COD")
    @SequenceGenerator(name = "SEQ_ASIGNAC_RECAUDO_AA_COD", sequenceName = "SEQ_ASIGNAC_RECAUDO_AA_COD",allocationSize=1)
    public Long getAraCodigo() {
        return araCodigo;
    }

    public void setAraCodigo(Long araCodigo) {
        this.araCodigo = araCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ARA_FECHA", nullable = false)
    public Date getAraFecha() {
        return araFecha;
    }

    public void setAraFecha(Date araFecha) {
        this.araFecha = araFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ARA_FECHA_PAGO", nullable = false)
    public Date getAraFechaPago() {
        return araFechaPago;
    }

    public void setAraFechaPago(Date araFechaPago) {
        this.araFechaPago = araFechaPago;
    }

    @Column(name = "ARA_RESOLUCION", nullable = false, length = 6)
    public String getAraResolucion() {
        return araResolucion;
    }

    public void setAraResolucion(String araResolucion) {
        this.araResolucion = araResolucion;
    }

    @Column(name = "ARA_VALOR", nullable = false)
    public BigDecimal getAraValor() {
        return araValor;
    }

    public void setAraValor(BigDecimal araValor) {
        this.araValor = araValor;
    }

    @OneToMany(mappedBy = "siiAsignacionRecaudoAa")
    public List<SiiAsigRecaudoAaEstabl> getSiiAsigRecaudoAaEstablList() {
        return siiAsigRecaudoAaEstablList;
    }

    public void setSiiAsigRecaudoAaEstablList(List<SiiAsigRecaudoAaEstabl> siiAsigRecaudoAaEstablList) {
        this.siiAsigRecaudoAaEstablList = siiAsigRecaudoAaEstablList;
    }

    public SiiAsigRecaudoAaEstabl addSiiAsigRecaudoAaEstabl(SiiAsigRecaudoAaEstabl siiAsigRecaudoAaEstabl) {
        getSiiAsigRecaudoAaEstablList().add(siiAsigRecaudoAaEstabl);
        siiAsigRecaudoAaEstabl.setSiiAsignacionRecaudoAa(this);
        return siiAsigRecaudoAaEstabl;
    }

    public SiiAsigRecaudoAaEstabl removeSiiAsigRecaudoAaEstabl(SiiAsigRecaudoAaEstabl siiAsigRecaudoAaEstabl) {
        getSiiAsigRecaudoAaEstablList().remove(siiAsigRecaudoAaEstabl);
        siiAsigRecaudoAaEstabl.setSiiAsignacionRecaudoAa(null);
        return siiAsigRecaudoAaEstabl;
    }

    @ManyToOne
    @JoinColumn(name = "DME_CODIGO")
    public SiiDistribucionMes getSiiDistribucionMes() {
        return siiDistribucionMes;
    }

    public void setSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        this.siiDistribucionMes = siiDistribucionMes;
    }
}
