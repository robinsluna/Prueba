package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_PROPUESTA_RECIB")
public class SiiPropuestaRecib implements Serializable {
    private static final long serialVersionUID = -7810434906831643278L;
    private Long preCodigo;
    private SiiProveedor siiProveedor;
    private SiiRecepcionPropuestas siiRecepcionPropuestas;
    private List<SiiPropuestaEvaluacion> siiPropuestaEvaluacionList1;

    public SiiPropuestaRecib() {
    }

    public SiiPropuestaRecib(Long preCodigo, SiiProveedor siiProveedor, SiiRecepcionPropuestas siiRecepcionPropuestas) {
        this.preCodigo = preCodigo;
        this.siiProveedor = siiProveedor;
        this.siiRecepcionPropuestas = siiRecepcionPropuestas;
    }

    @Id
    @Column(name = "PRE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROPUESTA_RECIB_COD")
    @SequenceGenerator(name = "SEQ_PROPUESTA_RECIB_COD", sequenceName = "SEQ_PROPUESTA_RECIB_COD",allocationSize=1)
    public Long getPreCodigo() {
        return preCodigo;
    }

    public void setPreCodigo(Long preCodigo) {
        this.preCodigo = preCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "PRO_CODIGO")
    public SiiProveedor getSiiProveedor() {
        return siiProveedor;
    }

    public void setSiiProveedor(SiiProveedor siiProveedor) {
        this.siiProveedor = siiProveedor;
    }

    @ManyToOne
    @JoinColumn(name = "RPR_CODIGO")
    public SiiRecepcionPropuestas getSiiRecepcionPropuestas() {
        return siiRecepcionPropuestas;
    }

    public void setSiiRecepcionPropuestas(SiiRecepcionPropuestas siiRecepcionPropuestas) {
        this.siiRecepcionPropuestas = siiRecepcionPropuestas;
    }

    @OneToMany(mappedBy = "siiPropuestaRecib")
    public List<SiiPropuestaEvaluacion> getSiiPropuestaEvaluacionList1() {
        return siiPropuestaEvaluacionList1;
    }

    public void setSiiPropuestaEvaluacionList1(List<SiiPropuestaEvaluacion> siiPropuestaEvaluacionList1) {
        this.siiPropuestaEvaluacionList1 = siiPropuestaEvaluacionList1;
    }

    public SiiPropuestaEvaluacion addSiiPropuestaEvaluacion(SiiPropuestaEvaluacion siiPropuestaEvaluacion) {
        getSiiPropuestaEvaluacionList1().add(siiPropuestaEvaluacion);
        siiPropuestaEvaluacion.setSiiPropuestaRecib(this);
        return siiPropuestaEvaluacion;
    }

    public SiiPropuestaEvaluacion removeSiiPropuestaEvaluacion(SiiPropuestaEvaluacion siiPropuestaEvaluacion) {
        getSiiPropuestaEvaluacionList1().remove(siiPropuestaEvaluacion);
        siiPropuestaEvaluacion.setSiiPropuestaRecib(null);
        return siiPropuestaEvaluacion;
    }
}
