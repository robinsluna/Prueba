package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SII_AJUSTE_CONT_CAR_ACT")
public class SiiAjusteContCarAct implements Serializable {
    private static final long serialVersionUID = 6701489160947924502L;
    private String ajcActivo;
    private Long ajcCodigo;
    private String ajcDescripcion;
    private Date ajcFecha;
    private BigDecimal ajcValor;
    private SiiUsuario siiUsuarioConectado;
    private SiiCargaActuacionesAdm siiCargaActuacionesAdm;
    private SiiConcepCuotCarActAdm siiConcepCuotCarActAdm;

    public SiiAjusteContCarAct() {
    }

    public SiiAjusteContCarAct(String ajcActivo, Long ajcCodigo, BigDecimal ajcValor, SiiCargaActuacionesAdm siiCargaActuacionesAdm, SiiUsuario siiUsuarioConectado) {
        this.ajcActivo = ajcActivo;
        this.ajcCodigo = ajcCodigo;
        this.ajcValor = ajcValor;
        this.siiCargaActuacionesAdm = siiCargaActuacionesAdm;
        this.siiUsuarioConectado = siiUsuarioConectado;
    }

    @Column(name = "AJC_ACTIVO", nullable = false, length = 1)
    public String getAjcActivo() {
        return ajcActivo;
    }

    public void setAjcActivo(String ajcActivo) {
        this.ajcActivo = ajcActivo;
    }

    @Id
    @Column(name = "AJC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_AJU_CONT_CAR_ACT_COD")
    @SequenceGenerator(name = "SEQ_AJU_CONT_CAR_ACT_COD", sequenceName = "SEQ_AJU_CONT_CAR_ACT_COD",allocationSize=1)
    public Long getAjcCodigo() {
        return ajcCodigo;
    }

    public void setAjcCodigo(Long ajcCodigo) {
        this.ajcCodigo = ajcCodigo;
    }

    @Column(name = "AJC_DESCRIPCION", nullable = false, length = 150)
    public String getAjcDescripcion() {
        return ajcDescripcion;
    }

    public void setAjcDescripcion(String ajcDescripcion) {
        this.ajcDescripcion = ajcDescripcion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AJC_FECHA", nullable = false)
    public Date getAjcFecha() {
        return ajcFecha;
    }

    public void setAjcFecha(Date ajcFecha) {
        this.ajcFecha = ajcFecha;
    }

    @Column(name = "AJC_VALOR", nullable = false)
    public BigDecimal getAjcValor() {
        return ajcValor;
    }

    public void setAjcValor(BigDecimal ajcValor) {
        this.ajcValor = ajcValor;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConectado() {
        return siiUsuarioConectado;
    }

    public void setSiiUsuarioConectado(SiiUsuario siiUsuarioConectado) {
        this.siiUsuarioConectado = siiUsuarioConectado;
    }

    @ManyToOne
    @JoinColumn(name = "CAA_CODIGO")
    public SiiCargaActuacionesAdm getSiiCargaActuacionesAdm() {
        return siiCargaActuacionesAdm;
    }

    public void setSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        this.siiCargaActuacionesAdm = siiCargaActuacionesAdm;
    }

    @ManyToOne
    @JoinColumn(name = "CAM_CODIGO")
    public SiiConcepCuotCarActAdm getSiiConcepCuotCarActAdm() {
        return siiConcepCuotCarActAdm;
    }

    public void setSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        this.siiConcepCuotCarActAdm = siiConcepCuotCarActAdm;
    }
}
