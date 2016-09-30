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
@Table(name = "SII_ESTADO_SOL_EST_MERCADO")
public class SiiEstadoSolEstMercado implements Serializable {
    private static final long serialVersionUID = -3296735777643055404L;
    private Long eseCodigo;
    private String eseDescripcion;
    private String eseNombre;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList1;

    public SiiEstadoSolEstMercado() {
    }

    public SiiEstadoSolEstMercado(Long eseCodigo, String eseDescripcion, String eseNombre) {
        this.eseCodigo = eseCodigo;
        this.eseDescripcion = eseDescripcion;
        this.eseNombre = eseNombre;
    }

    @Id
    @Column(name = "ESE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTADO_SOL_EST_MERC_COD")
    @SequenceGenerator(name = "SEQ_ESTADO_SOL_EST_MERC_COD", sequenceName = "SEQ_ESTADO_SOL_EST_MERC_COD",allocationSize=1)
    public Long getEseCodigo() {
        return eseCodigo;
    }

    public void setEseCodigo(Long eseCodigo) {
        this.eseCodigo = eseCodigo;
    }

    @Column(name = "ESE_DESCRIPCION", nullable = false, length = 50, insertable=false, updatable = false)
    public String getEseDescripcion() {
        return eseDescripcion;
    }

    public void setEseDescripcion(String eseDescripcion) {
        this.eseDescripcion = eseDescripcion;
    }

    @Column(name = "ESE_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEseNombre() {
        return eseNombre;
    }

    public void setEseNombre(String eseNombre) {
        this.eseNombre = eseNombre;
    }

    @OneToMany(mappedBy = "siiEstadoSolEstMercado")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList1() {
        return siiSolicitudEstMercadoList1;
    }

    public void setSiiSolicitudEstMercadoList1(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList1) {
        this.siiSolicitudEstMercadoList1 = siiSolicitudEstMercadoList1;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList1().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiEstadoSolEstMercado(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList1().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiEstadoSolEstMercado(null);
        return siiSolicitudEstMercado;
    }
}
