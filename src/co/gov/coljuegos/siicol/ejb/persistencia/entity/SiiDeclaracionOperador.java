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
@Table(name = "SII_DECLARACION_OPERADOR")
public class SiiDeclaracionOperador implements Serializable {
    private static final long serialVersionUID = 4677097722050492466L;
    private Long dopCodigo;
    private Date dopFecha;
    private List<SiiDetalleDeclaracion> siiDetalleDeclaracionList;
    private String dopTipo;
    private SiiDeclaracionSugerida siiDeclaracionSugerida;

    public SiiDeclaracionOperador() {
    }

    public SiiDeclaracionOperador(Long dopCodigo, Date dopFecha, String dopTipo) {
        this.dopCodigo = dopCodigo;
        this.dopFecha = dopFecha;
        this.dopTipo = dopTipo;
    }

    @Id
    @Column(name = "DOP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DECLARAC_OPERADOR_COD")
    @SequenceGenerator(name = "SEQ_DECLARAC_OPERADOR_COD", sequenceName = "SEQ_DECLARAC_OPERADOR_COD",allocationSize=1)
    public Long getDopCodigo() {
        return dopCodigo;
    }

    public void setDopCodigo(Long dopCodigo) {
        this.dopCodigo = dopCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DOP_FECHA", nullable = false)
    public Date getDopFecha() {
        return dopFecha;
    }

    public void setDopFecha(Date dopFecha) {
        this.dopFecha = dopFecha;
    }

    @OneToMany(mappedBy = "siiDeclaracionOperador")
    public List<SiiDetalleDeclaracion> getSiiDetalleDeclaracionList() {
        return siiDetalleDeclaracionList;
    }

    public void setSiiDetalleDeclaracionList(List<SiiDetalleDeclaracion> siiDetalleDeclaracionList) {
        this.siiDetalleDeclaracionList = siiDetalleDeclaracionList;
    }

    public SiiDetalleDeclaracion addSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        getSiiDetalleDeclaracionList().add(siiDetalleDeclaracion);
        siiDetalleDeclaracion.setSiiDeclaracionOperador(this);
        return siiDetalleDeclaracion;
    }

    public SiiDetalleDeclaracion removeSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        getSiiDetalleDeclaracionList().remove(siiDetalleDeclaracion);
        siiDetalleDeclaracion.setSiiDeclaracionOperador(null);
        return siiDetalleDeclaracion;
    }

    @Column(name = "DOP_TIPO", nullable = false, length = 1)
    public String getDopTipo() {
        return dopTipo;
    }

    public void setDopTipo(String dopTipo) {
        this.dopTipo = dopTipo;
    }
    @ManyToOne
    @JoinColumn(name = "DSU_CODIGO")
    public SiiDeclaracionSugerida getSiiDeclaracionSugerida() {
        return siiDeclaracionSugerida;
    }

    public void setSiiDeclaracionSugerida(SiiDeclaracionSugerida siiDeclaracionSugerida) {
        this.siiDeclaracionSugerida = siiDeclaracionSugerida;
    }
}
