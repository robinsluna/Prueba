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
@Table(name = "SII_RECEPCION_PROPUESTAS")
public class SiiRecepcionPropuestas implements Serializable {
    private static final long serialVersionUID = -7635676310013572615L;
    private Long rprCodigo;
    private String rprEstadoActa;
    private Date rprFechaActa;
    private Long rprNumActa;
    private SiiArchivoFisico siiArchivoFisico;
    private List<SiiPropuestaRecib> siiPropuestaRecibList1;
    private SiiProcesoContratacion siiProcesoContratacion;

    public SiiRecepcionPropuestas() {
    }

    public SiiRecepcionPropuestas(SiiArchivoFisico siiArchivoFisico, Long rprCodigo, String rprEstadoActa,
                                  Date rprFechaActa, Long rprNumActa, SiiProcesoContratacion siiProcesoContratacion) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.rprCodigo = rprCodigo;
        this.rprEstadoActa = rprEstadoActa;
        this.rprFechaActa = rprFechaActa;
        this.rprNumActa = rprNumActa;
        this.siiProcesoContratacion = siiProcesoContratacion;
    }


    @Id
    @Column(name = "RPR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RECEPCION_PROP_COD")
    @SequenceGenerator(name = "SEQ_RECEPCION_PROP_COD", sequenceName = "SEQ_RECEPCION_PROP_COD",allocationSize=1)
    public Long getRprCodigo() {
        return rprCodigo;
    }

    public void setRprCodigo(Long rprCodigo) {
        this.rprCodigo = rprCodigo;
    }

    @Column(name = "RPR_ESTADO_ACTA", nullable = false, length = 1)
    public String getRprEstadoActa() {
        return rprEstadoActa;
    }

    public void setRprEstadoActa(String rprEstadoActa) {
        this.rprEstadoActa = rprEstadoActa;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RPR_FECHA_ACTA", nullable = false)
    public Date getRprFechaActa() {
        return rprFechaActa;
    }

    public void setRprFechaActa(Date rprFechaActa) {
        this.rprFechaActa = rprFechaActa;
    }

    @Column(name = "RPR_NUM_ACTA", nullable = false)
    public Long getRprNumActa() {
        return rprNumActa;
    }

    public void setRprNumActa(Long rprNumActa) {
        this.rprNumActa = rprNumActa;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @OneToMany(mappedBy = "siiRecepcionPropuestas")
    public List<SiiPropuestaRecib> getSiiPropuestaRecibList1() {
        return siiPropuestaRecibList1;
    }

    public void setSiiPropuestaRecibList1(List<SiiPropuestaRecib> siiPropuestaRecibList1) {
        this.siiPropuestaRecibList1 = siiPropuestaRecibList1;
    }

    public SiiPropuestaRecib addSiiPropuestaRecib(SiiPropuestaRecib siiPropuestaRecib) {
        getSiiPropuestaRecibList1().add(siiPropuestaRecib);
        siiPropuestaRecib.setSiiRecepcionPropuestas(this);
        return siiPropuestaRecib;
    }

    public SiiPropuestaRecib removeSiiPropuestaRecib(SiiPropuestaRecib siiPropuestaRecib) {
        getSiiPropuestaRecibList1().remove(siiPropuestaRecib);
        siiPropuestaRecib.setSiiRecepcionPropuestas(null);
        return siiPropuestaRecib;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }
}
