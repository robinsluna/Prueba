package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_PROCESO_COLJUEGOS")
public class SiiProcesoColjuegos implements Serializable {
    private static final long serialVersionUID = -4211935879174153748L;
    private Long pcoCodigo;
    private String pcoDescripcion;
    private String pcoNombre;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList4;

    public SiiProcesoColjuegos() {
    }

    public SiiProcesoColjuegos(Long pcoCodigo, String pcoDescripcion, String pcoNombre) {
        this.pcoCodigo = pcoCodigo;
        this.pcoDescripcion = pcoDescripcion;
        this.pcoNombre = pcoNombre;
    }

    @Id
    @Column(name = "PCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROCESO_COLJUEGOS_COD")
    @SequenceGenerator(name = "SEQ_PROCESO_COLJUEGOS_COD", sequenceName = "SEQ_PROCESO_COLJUEGOS_COD",allocationSize=1)
    public Long getPcoCodigo() {
        return pcoCodigo;
    }

    public void setPcoCodigo(Long pcoCodigo) {
        this.pcoCodigo = pcoCodigo;
    }

    @Column(name = "PCO_DESCRIPCION", nullable = false, length = 200)
    public String getPcoDescripcion() {
        return pcoDescripcion;
    }

    public void setPcoDescripcion(String pcoDescripcion) {
        this.pcoDescripcion = pcoDescripcion;
    }

    @Column(name = "PCO_NOMBRE", nullable = false, length = 50)
    public String getPcoNombre() {
        return pcoNombre;
    }

    public void setPcoNombre(String pcoNombre) {
        this.pcoNombre = pcoNombre;
    }

    @OneToMany(mappedBy = "siiProcesoColjuegos")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList4() {
        return siiSolicitudEstMercadoList4;
    }

    public void setSiiSolicitudEstMercadoList4(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList4) {
        this.siiSolicitudEstMercadoList4 = siiSolicitudEstMercadoList4;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList4().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiProcesoColjuegos(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList4().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiProcesoColjuegos(null);
        return siiSolicitudEstMercado;
    }
}
