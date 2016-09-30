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
@Table(name = "PR_NIVEL6")
@IdClass(PrNivel6PK.class)
public class PrNivel6 implements Serializable {
    private static final long serialVersionUID = 8922230034723634927L;
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel5;
    private String tipoPlan;
    private Integer vigencia;

    public PrNivel6() {
    }

    public PrNivel6(String codigo, String descripcion, Long interno, Long internoNivel5, String tipoPlan,
                    Integer vigencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.interno = interno;
        this.internoNivel5 = internoNivel5;
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

    @Column(length = 220)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PR_NIVEL6_INTERNO")
    @SequenceGenerator(name = "SEQ_PR_NIVEL6_INTERNO", sequenceName = "SEQ_PR_NIVEL6_INTERNO",allocationSize=1) 
    public Long getInterno() {
        return interno;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    @Column(name = "INTERNO_NIVEL5", nullable = false)
    public Long getInternoNivel5() {
        return internoNivel5;
    }

    public void setInternoNivel5(Long internoNivel5) {
        this.internoNivel5 = internoNivel5;
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
