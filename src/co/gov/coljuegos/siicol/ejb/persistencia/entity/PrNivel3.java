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
@Table(name = "PR_NIVEL3")
@IdClass(PrNivel3PK.class)
public class PrNivel3 implements Serializable {
    private static final long serialVersionUID = -3787998395346354742L;
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel2;
    private String tipoPlan;
    private Integer vigencia;

    public PrNivel3() {
    }

    public PrNivel3(String codigo, String descripcion, Long interno, Long internoNivel2, String tipoPlan,
                    Integer vigencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.interno = interno;
        this.internoNivel2 = internoNivel2;
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PR_NIVEL3_INTERNO")
    @SequenceGenerator(name = "SEQ_PR_NIVEL3_INTERNO", sequenceName = "SEQ_PR_NIVEL3_INTERNO",allocationSize=1) 
    public Long getInterno() {
        return interno;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    @Column(name = "INTERNO_NIVEL2")
    public Long getInternoNivel2() {
        return internoNivel2;
    }

    public void setInternoNivel2(Long internoNivel2) {
        this.internoNivel2 = internoNivel2;
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
