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
@Table(name = "PR_NIVEL8")
@IdClass(PrNivel8PK.class)
public class PrNivel8 implements Serializable {
    private static final long serialVersionUID = 5577581291254200240L;
    private String codigo;
    private String descripcion;
    private Long interno;
    private Long internoNivel7;
    private String tipoPlan;
    private Integer vigencia;

    public PrNivel8() {
    }

    public PrNivel8(String codigo, String descripcion, Long interno, Long internoNivel7, String tipoPlan,
                    Integer vigencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.interno = interno;
        this.internoNivel7 = internoNivel7;
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

    @Column(length = 250)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PR_NIVEL8_INTERNO")
    @SequenceGenerator(name = "SEQ_PR_NIVEL7_INTERNO", sequenceName = "SEQ_PR_NIVEL7_INTERNO",allocationSize=1) 
    public Long getInterno() {
        return interno;
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    @Column(name = "INTERNO_NIVEL7", nullable = false)
    public Long getInternoNivel7() {
        return internoNivel7;
    }

    public void setInternoNivel7(Long internoNivel7) {
        this.internoNivel7 = internoNivel7;
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
