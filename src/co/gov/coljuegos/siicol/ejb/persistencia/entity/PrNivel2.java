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
@Table(name = "PR_NIVEL2")
@IdClass(PrNivel2PK.class)
public class PrNivel2 implements Serializable {
    private static final long serialVersionUID = 1064123236382920852L;
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel1;
    private String tipoPlan;
    private Integer vigencia;

    public PrNivel2() {
    }

    public PrNivel2(String codigo, String descripcion, Long interno, Long internoNivel1, String tipoPlan,
                    Integer vigencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.interno = interno;
        this.internoNivel1 = internoNivel1;
        this.tipoPlan = tipoPlan;
        this.vigencia = vigencia;
    }

    @Column(nullable = false, length = 10)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(length = 120)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PR_NIVEL2_INTERNO")
    @SequenceGenerator(name = "SEQ_PR_NIVEL2_INTERNO", sequenceName = "SEQ_PR_NIVEL2_INTERNO",allocationSize=1)
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
