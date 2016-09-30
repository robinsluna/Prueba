package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PR_RUBRO")
@IdClass(PrRubroPK.class)
public class PrRubro implements Serializable {
    private static final long serialVersionUID = -8550249035492638551L;
    private String administracion;
    private Long ainCodigo;
    private Integer costos;
    private String descripcion;
    private String fuenteContable;
    private Long interno;
    private Long internoNivel1;
    private Long internoNivel2;
    private Long internoNivel3;
    private Long internoNivel4;
    private Long internoNivel5;
    private Long internoNivel6;
    private Long internoNivel7;
    private Long internoNivel8;
    private String inversion;
    private Integer programacion;
    private String tipoPlan;
    private Integer vigencia;

    public PrRubro() {
    }

    public PrRubro(String administracion, Long ainCodigo, Integer costos, String descripcion, Long interno,
                   Long internoNivel1, Long internoNivel2, Long internoNivel3, Long internoNivel4, Long internoNivel5,
                   Long internoNivel6, Long internoNivel7, Long internoNivel8, String inversion, Integer programacion,
                   String tipoPlan, Integer vigencia, String fuenteContable) {
        this.administracion = administracion;
        this.ainCodigo = ainCodigo;
        this.costos = costos;
        this.descripcion = descripcion;
        this.fuenteContable = fuenteContable;
        this.interno = interno;
        this.internoNivel1 = internoNivel1;
        this.internoNivel2 = internoNivel2;
        this.internoNivel3 = internoNivel3;
        this.internoNivel4 = internoNivel4;
        this.internoNivel5 = internoNivel5;
        this.internoNivel6 = internoNivel6;
        this.internoNivel7 = internoNivel7;
        this.internoNivel8 = internoNivel8;
        this.inversion = inversion;
        this.programacion = programacion;
        this.tipoPlan = tipoPlan;
        this.vigencia = vigencia;
    }

    @Column(length = 30)
    public String getAdministracion() {
        return administracion;
    }

    public void setAdministracion(String administracion) {
        this.administracion = administracion;
    }

    @Column(name = "AIN_CODIGO", nullable = false)
    public Long getAinCodigo() {
        return ainCodigo;
    }

    public void setAinCodigo(Long ainCodigo) {
        this.ainCodigo = ainCodigo;
    }

    public Integer getCostos() {
        return costos;
    }

    public void setCostos(Integer costos) {
        this.costos = costos;
    }

    @Column(length = 250)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "FUENTE_CONTABLE", length = 3)
    public String getFuenteContable() {
        return fuenteContable;
    }

    public void setFuenteContable(String fuenteContable) {
        this.fuenteContable = fuenteContable;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PR_RUBRO_CODIGO")
    @SequenceGenerator(name = "SEQ_PR_RUBRO_CODIGO", sequenceName = "SEQ_PR_RUBRO_CODIGO",allocationSize=1) 
    public Long getInterno() {
        return interno;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    @Column(name = "INTERNO_NIVEL1", nullable = false)
    public Long getInternoNivel1() {
        return internoNivel1;
    }

    public void setInternoNivel1(Long internoNivel1) {
        this.internoNivel1 = internoNivel1;
    }

    @Column(name = "INTERNO_NIVEL2", nullable = false)
    public Long getInternoNivel2() {
        return internoNivel2;
    }

    public void setInternoNivel2(Long internoNivel2) {
        this.internoNivel2 = internoNivel2;
    }

    @Column(name = "INTERNO_NIVEL3", nullable = false)
    public Long getInternoNivel3() {
        return internoNivel3;
    }

    public void setInternoNivel3(Long internoNivel3) {
        this.internoNivel3 = internoNivel3;
    }

    @Column(name = "INTERNO_NIVEL4", nullable = false)
    public Long getInternoNivel4() {
        return internoNivel4;
    }

    public void setInternoNivel4(Long internoNivel4) {
        this.internoNivel4 = internoNivel4;
    }

    @Column(name = "INTERNO_NIVEL5", nullable = false)
    public Long getInternoNivel5() {
        return internoNivel5;
    }

    public void setInternoNivel5(Long internoNivel5) {
        this.internoNivel5 = internoNivel5;
    }

    @Column(name = "INTERNO_NIVEL6", nullable = false)
    public Long getInternoNivel6() {
        return internoNivel6;
    }

    public void setInternoNivel6(Long internoNivel6) {
        this.internoNivel6 = internoNivel6;
    }

    @Column(name = "INTERNO_NIVEL7", nullable = false)
    public Long getInternoNivel7() {
        return internoNivel7;
    }

    public void setInternoNivel7(Long internoNivel7) {
        this.internoNivel7 = internoNivel7;
    }

    @Column(name = "INTERNO_NIVEL8", nullable = false)
    public Long getInternoNivel8() {
        return internoNivel8;
    }

    public void setInternoNivel8(Long internoNivel8) {
        this.internoNivel8 = internoNivel8;
    }

    @Column(length = 1)
    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public Integer getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Integer programacion) {
        this.programacion = programacion;
    }

    @Column(name = "TIPO_PLAN", length = 30)
    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    @Id
    @Column(nullable = false)
    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }
}
