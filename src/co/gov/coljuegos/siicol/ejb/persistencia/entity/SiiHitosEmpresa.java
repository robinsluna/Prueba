package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_HITOS_EMPRESA")
public class SiiHitosEmpresa implements Serializable {
    private static final long serialVersionUID = -6648778174015876217L;
    private Long hemCodigo;
    private String hemConsideraciones;
    private SiiPersona siiPersona;
    private Date hemFecha;

    public SiiHitosEmpresa() {
    }

    public SiiHitosEmpresa(Long hemCodigo, String hemConsideraciones, SiiPersona siiPersona) {
        this.hemCodigo = hemCodigo;
        this.hemConsideraciones = hemConsideraciones;
        this.siiPersona = siiPersona;
    }

    @Id
    @Column(name = "HEM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HITOS_EMPRESA_COD")
    @SequenceGenerator(name = "SEQ_HITOS_EMPRESA_COD", sequenceName = "SEQ_HITOS_EMPRESA_COD",allocationSize=1)
    public Long getHemCodigo() {
        return hemCodigo;
    }

    public void setHemCodigo(Long hemCodigo) {
        this.hemCodigo = hemCodigo;
    }

    @Column(name = "HEM_CONSIDERACIONES", nullable = false, length = 1200)
    public String getHemConsideraciones() {
        return hemConsideraciones;
    }

    public void setHemConsideraciones(String hemConsideraciones) {
        this.hemConsideraciones = hemConsideraciones;
    }


    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HEM_FECHA", nullable = false)
    public Date getHemFecha() {
        return hemFecha;
    }

    public void setHemFecha(Date hemFecha) {
        this.hemFecha = hemFecha;
    }
}
